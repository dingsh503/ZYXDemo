package net.iclassmate.zyxdemo.bean;

import java.util.List;

/**
 * Created by xydbj on 2017.2.28.
 */

public class UserInformation {

    /**
     * area :
     * phone : 15801362521
     * icon : http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/064ed5acaea946a9b49c3803900221ee/1e383052b33a42228bcfb4809779a1c6.jpg@!75
     * labels : {"list":["北京烤鸭"]}
     * fsRoot : 2d6c6e4003164ee4b83732364daafa7a
     * ryToken : Cz2D6Yo6+UmgcC5Ljfq6DthWgv91OOudH+W9ZZOIj9SNNqmPCXQN+3rFmCc4qSUiK/XkZqKzdqPdMrbxwOEeNNkSdNpQnEDhbE4nNZO49Ot/wn2z0qtlrsG9ui1jP+5AScGic3LHzj8=
     * userType : 1
     * userCode : 613441
     * name : 张寓宣
     * capacity : 100
     * city : 三亚市
     * province : 海南省
     * dateBirth : 1998-10-24
     * gender : 女
     * searchMe : 1
     * Introduction : | ू•ૅ㉨•́)ᵎᵎᵎ 被我发现了！
     */

    private UserInfoBean userInfo;
    /**
     * userInfo : {"area":"","phone":"15801362521","icon":"http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/064ed5acaea946a9b49c3803900221ee/1e383052b33a42228bcfb4809779a1c6.jpg@!75","labels":{"list":["北京烤鸭"]},"fsRoot":"2d6c6e4003164ee4b83732364daafa7a","ryToken":"Cz2D6Yo6+UmgcC5Ljfq6DthWgv91OOudH+W9ZZOIj9SNNqmPCXQN+3rFmCc4qSUiK/XkZqKzdqPdMrbxwOEeNNkSdNpQnEDhbE4nNZO49Ot/wn2z0qtlrsG9ui1jP+5AScGic3LHzj8=","userType":"1","userCode":"613441","name":"张寓宣","capacity":"100","city":"三亚市","province":"海南省","dateBirth":"1998-10-24","gender":"女","searchMe":"1","Introduction":"| ू\u2022ૅ㉨\u2022́)ᵎᵎᵎ 被我发现了！"}
     * spaceId : 5eebaf72898341b6a4ac5b850f2197a4
     * id : 064ed5acaea946a9b49c3803900221ee
     */

    private String spaceId;
    private String id;

    @Override
    public String toString() {
        return "UserInformation{" +
                "userInfo=" + userInfo +
                ", spaceId='" + spaceId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class UserInfoBean {
        private String area;
        private String phone;
        private String icon;
        private LabelsBean labels;
        private String fsRoot;
        private String ryToken;
        private String userType;
        private String userCode;
        private String name;
        private String capacity;
        private String city;
        private String province;
        private String dateBirth;
        private String gender;
        private String searchMe;
        private String Introduction;

        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "area='" + area + '\'' +
                    ", phone='" + phone + '\'' +
                    ", icon='" + icon + '\'' +
                    ", labels=" + labels +
                    ", fsRoot='" + fsRoot + '\'' +
                    ", ryToken='" + ryToken + '\'' +
                    ", userType='" + userType + '\'' +
                    ", userCode='" + userCode + '\'' +
                    ", name='" + name + '\'' +
                    ", capacity='" + capacity + '\'' +
                    ", city='" + city + '\'' +
                    ", province='" + province + '\'' +
                    ", dateBirth='" + dateBirth + '\'' +
                    ", gender='" + gender + '\'' +
                    ", searchMe='" + searchMe + '\'' +
                    ", Introduction='" + Introduction + '\'' +
                    '}';
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public LabelsBean getLabels() {
            return labels;
        }

        public void setLabels(LabelsBean labels) {
            this.labels = labels;
        }

        public String getFsRoot() {
            return fsRoot;
        }

        public void setFsRoot(String fsRoot) {
            this.fsRoot = fsRoot;
        }

        public String getRyToken() {
            return ryToken;
        }

        public void setRyToken(String ryToken) {
            this.ryToken = ryToken;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getDateBirth() {
            return dateBirth;
        }

        public void setDateBirth(String dateBirth) {
            this.dateBirth = dateBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getSearchMe() {
            return searchMe;
        }

        public void setSearchMe(String searchMe) {
            this.searchMe = searchMe;
        }

        public String getIntroduction() {
            return Introduction;
        }

        public void setIntroduction(String Introduction) {
            this.Introduction = Introduction;
        }

        public static class LabelsBean {
            private List<String> list;

            @Override
            public String toString() {
                return "LabelsBean{" +
                        "list=" + list +
                        '}';
            }

            public List<String> getList() {
                return list;
            }

            public void setList(List<String> list) {
                this.list = list;
            }
        }
    }
}
