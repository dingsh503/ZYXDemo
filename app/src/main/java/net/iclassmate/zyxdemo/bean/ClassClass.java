package net.iclassmate.zyxdemo.bean;

/**
 * Created by xydbj on 2016.11.28.
 */
public class ClassClass {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "ClassClass{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
