package com.example.fileshare.common;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文件信息实体类
 * 用于存储和传输文件的元数据信息
 */
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;                // 文件ID
    private String filename;           // 文件名
    private String filePath;           // 文件路径
    private Long fileSize;            // 文件大小（字节）
    private String fileType;          // 文件类型
    private Timestamp uploadTime;      // 上传时间
    private Integer downloadCount;     // 下载次数
    private String uploadedBy;         // 上传者
    private String md5;               // 文件MD5值
    
    // 默认构造函数
    public FileInfo() {}
    
    // 带参数的构造函数
    public FileInfo(Integer id, String filename, String filePath, Long fileSize, 
                   String fileType, Timestamp uploadTime, Integer downloadCount, 
                   String uploadedBy, String md5) {
        this.id = id;
        this.filename = filename;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.uploadTime = uploadTime;
        this.downloadCount = downloadCount;
        this.uploadedBy = uploadedBy;
        this.md5 = md5;
    }

    public FileInfo(int id, String filename, String filePath, Timestamp uploadTime, int downloadCount) {
        this.id = id;
        this.filename = filename;
        this.filePath = filePath;
        this.uploadTime = uploadTime;
        this.downloadCount = downloadCount;
    }

    // Getter和Setter方法
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public Long getFileSize() {
        return fileSize;
    }
    
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public Timestamp getUploadTime() {
        return uploadTime;
    }
    
    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }
    
    public Integer getDownloadCount() {
        return downloadCount;
    }
    
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
    
    public String getUploadedBy() {
        return uploadedBy;
    }
    
    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
    
    public String getMd5() {
        return md5;
    }
    
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    
    @Override
    public String toString() {
        return "FileInfo{" +
               "id=" + id +
               ", filename='" + filename + '\'' +
               ", filePath='" + filePath + '\'' +
               ", fileSize=" + fileSize +
               ", fileType='" + fileType + '\'' +
               ", uploadTime=" + uploadTime +
               ", downloadCount=" + downloadCount +
               ", uploadedBy='" + uploadedBy + '\'' +
               ", md5='" + md5 + '\'' +
               '}';
    }
    
    // 用于构建FileInfo对象的Builder类
    public static class Builder {
        private Integer id;
        private String filename;
        private String filePath;
        private Long fileSize;
        private String fileType;
        private Timestamp uploadTime;
        private Integer downloadCount;
        private String uploadedBy;
        private String md5;
        
        public Builder() {}
        
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }
        
        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }
        
        public Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }
        
        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
        
        public Builder uploadTime(Timestamp uploadTime) {
            this.uploadTime = uploadTime;
            return this;
        }
        
        public Builder downloadCount(Integer downloadCount) {
            this.downloadCount = downloadCount;
            return this;
        }
        
        public Builder uploadedBy(String uploadedBy) {
            this.uploadedBy = uploadedBy;
            return this;
        }
        
        public Builder md5(String md5) {
            this.md5 = md5;
            return this;
        }
        
        public FileInfo build() {
            return new FileInfo(id, filename, filePath, fileSize, fileType, 
                              uploadTime, downloadCount, uploadedBy, md5);
        }
    }
} 