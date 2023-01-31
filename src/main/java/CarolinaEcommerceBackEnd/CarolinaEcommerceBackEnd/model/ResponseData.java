package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model;

import java.util.Objects;

public class ResponseData {

    private String fileName;
    private String downloadURL;
    private String fileType;
    private int fileSize;

    public ResponseData(String fileName, String downloadURL, String fileType, int fileSize) {
        this.fileName = fileName;
        this.downloadURL = downloadURL;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public ResponseData() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseData that = (ResponseData) o;
        return fileSize == that.fileSize && Objects.equals(fileName, that.fileName) && Objects.equals(downloadURL, that.downloadURL) && Objects.equals(fileType, that.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, downloadURL, fileType, fileSize);
    }


}
