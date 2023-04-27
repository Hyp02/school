package com.hyp.dao.FileDao;

import com.hyp.pojo.Files;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
public interface FIleDao {
    //保存文件名，文件路径等信息
    int saveFile(Integer id,String fileName,String fileType,String filePath);
    List<Files> getAllFiles();
    int deleteByFileName(String fileName);
}
