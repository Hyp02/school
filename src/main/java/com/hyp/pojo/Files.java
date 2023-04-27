package com.hyp.pojo;

/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
public class Files {
    private Integer id;
    private String fileName;
    private String fileType;
    private String filePath;

    public Files(Integer id, String fileName, String fileType, String filePath) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }
    public Files(){ }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
