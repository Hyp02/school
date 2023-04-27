package com.hyp.service.PrintService;

import com.hyp.dao.FileDao.FIleDao;
import com.hyp.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
@Service
public class PrintServiceImpl implements PrintService{
    @Autowired
    FIleDao fileDao;
    @Override
    public int upLoadFile(Integer id, String fileName, String fileType, String filePath) {
        return fileDao.saveFile(id,fileName,fileType,filePath);
    }

    @Override
    public List<Files> downFiles() {
        return fileDao.getAllFiles();
    }

    @Override
    public int deleteByFileName(String fileName) {
        return fileDao.deleteByFileName(fileName);
    }
}
