package net.iclassmate.zyxdemo.bean;

import java.io.Serializable;

/**
 * Created by xydbj on 2017.2.16.
 */
public class ImageState implements Serializable {
    private String filePath;
    private String fileName;
    private boolean check;

    @Override
    public String toString() {
        return "ImageState{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", check=" + check +
                '}';
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
