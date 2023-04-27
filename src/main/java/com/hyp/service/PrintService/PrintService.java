package com.hyp.service.PrintService;

import com.hyp.pojo.Files;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
public interface PrintService {
    /**
     * 文件上传
     * @param files
     * @return
     */
    int upLoadFile(Integer id, String fileName, String fileType, String filePath);
    /**
     * 文件下载
     */
    List<Files> downFiles();
    /**
     * 文件删除
     */
    int deleteByFileName(String fileName);
}
