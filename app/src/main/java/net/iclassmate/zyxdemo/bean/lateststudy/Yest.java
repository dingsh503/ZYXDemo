package net.iclassmate.zyxdemo.bean.lateststudy;

/**
 * Created by xydbj on 2016.12.29.
 */
public class Yest {
    /**
     * catalogName : 全国一卷xxx
     * id : 12
     * resId : 666666
     * resName : 张雪峰化学第一讲
     * userId : 13051529625
     * watchTime : 2016-12-28
     * webUrl : http://xxx.xxx.x.xxx
     */

    private String catalogName;
    private int id;
    private String resId;
    private String resName;
    private String userId;
    private String watchTime;
    private String webUrl;

    @Override
    public String toString() {
        return "Yest{" +
                "catalogName='" + catalogName + '\'' +
                ", id=" + id +
                ", resId='" + resId + '\'' +
                ", resName='" + resName + '\'' +
                ", userId='" + userId + '\'' +
                ", watchTime='" + watchTime + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(String watchTime) {
        this.watchTime = watchTime;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
