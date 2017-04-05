package net.iclassmate.zyxdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xydbj on 2017.1.18.
 */
public class ItemPool {
    @Override
    public String toString() {
        return "ItemPool{" +
                "banner=" + banner +
                ", tenYearsExam=" + tenYearsExam +
                ", items=" + items +
                '}';
    }

    /**
     * courseName : 理数
     * url : http://space-oss.iclassmate.cn/wk-space/images/img_banner1_gaokao.png
     */

    private List<BannerBean> banner;
    private List<TenYearsExamBean> tenYearsExam;
    /**
     * item : 文数
     * type : 10000
     */

    private List<ItemsBean> items;

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<TenYearsExamBean> getTenYearsExam() {
        return tenYearsExam;
    }

    public void setTenYearsExam(List<TenYearsExamBean> tenYearsExam) {
        this.tenYearsExam = tenYearsExam;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class BannerBean {

        @Override
        public String toString() {
            return "BannerBean{" +
                    "courseName='" + courseName + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

        private String courseName;
        private String url;

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class TenYearsExamBean {

        @Override
        public String toString() {
            return "TenYearsExamBean{" +
                    "value2017=" + value2017 +
                    '}';
        }

        @SerializedName("2017")
        private List<?> value2017;

        public List<?> getValue2017() {
            return value2017;
        }

        public void setValue2017(List<?> value2017) {
            this.value2017 = value2017;
        }
    }

    public static class ItemsBean {

        @Override
        public String toString() {
            return "ItemsBean{" +
                    "item='" + item + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }

        private String item;
        private String type;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
