package org.ogin.thread.walker;

/**
 * @author ogin
 */
public class FileDetails {
    private String fileName;
    private int fileSize;


    public FileDetails(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    @Override
    public String toString(){
        return fileName + " .... " + fileSize + " bytes";
    }
}
