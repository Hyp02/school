package com.hyp.contorller.PrintController;

import com.hyp.pojo.Files;
import com.hyp.service.PrintService.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
@Controller
@RequestMapping("print")
public class PrintController {
    @Autowired
    PrintService printService;

    @RequestMapping("/printIndex")
    public String printIndex(HttpServletRequest req) {
        if (req.getSession().getAttribute("login") != null) {
            return "/printService";
        }
        //没有登录先登录
        return "NotLogin";
    }

    @PostMapping("/upload")
    public String handleFileUpload(MultipartFile[] files, HttpServletRequest req) throws IOException {
        for (MultipartFile file : files) {
            //循环获取上传的每个文件的文件名
            String filename = file.getOriginalFilename();
            //取出文件的扩展名
            String fileType = filename.substring(filename.lastIndexOf("."));
            //获取文件存储的路径
            ServletContext servletContext = req.getServletContext();
            String printFile = servletContext.getRealPath("printFile");

            //创建这个文件的File对象，
            File file1 = new File(printFile);
            if (!file1.exists()) {
                //如果这个文件不存在，创建
                file1.mkdir();
            }
            String finalPath = printFile + File.separator + filename;
            file.transferTo(new File(finalPath));
            //将上传的文件的文件名和路径保存到数据库中，用于打印时下载
            printService.upLoadFile(null, filename, fileType, finalPath);
        }
        return "makeSuccess";
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        List<File> fileList = new ArrayList<>(); // 需要下载的文件列表
        List<Files> files = printService.downFiles();
        for (Files file : files) {
            //将文件路径存到集合中
            fileList.add(new File(file.getFilePath()));
            //根据这个文件的名字，将文件在数据库中删除
            printService.deleteByFileName(file.getFileName());
        }

        // 设置 HTTP 响应头信息
        response.setContentType("application/zip");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=printFiles.zip");

        // 创建 ZipOutputStream 对象，逐个读取文件并写入输出流
        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
            // 逐个添加文件到压缩包中
            for (File file : fileList) {
                FileInputStream fileIn = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOut.putNextEntry(zipEntry);

                // 写入文件数据到输出流
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fileIn.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, len);
                }
                fileIn.close();

                // 告知压缩包该文件的处理已经完成
                zipOut.closeEntry();
            }
            zipOut.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //下载完成以后，在数据库中将文件路径删除

    }
}

