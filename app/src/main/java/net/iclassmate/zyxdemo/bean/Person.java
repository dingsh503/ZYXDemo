package net.iclassmate.zyxdemo.bean;

/**
 * Created by xydbj on 2016.10.29.
 */
public class Person {

    /**
     * id : 064ed5acaea946a9b49c3803900221ee
     * userInfo : {"name":"牛顿我我我我","fsRoot":"2d6c6e4003164ee4b83732364daafa7a","capacity":"100","searchMe":"1","Introduction":"1234567890","city":"三亚市","icon":"http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/064ed5acaea946a9b49c3803900221ee/701ebcf312e44da78ebcaa2ea3cd75e7.jpg@!75","area":"","ryToken":"Cz2D6Yo6+UmgcC5Ljfq6DthWgv91OOudH+W9ZZOIj9SNNqmPCXQN+3rFmCc4qSUiK/XkZqKzdqPdMrbxwOEeNNkSdNpQnEDhbE4nNZO49Ot/wn2z0qtlrsG9ui1jP+5AScGic3LHzj8=","province":"海南省","dateBirth":"2000-10-22","userType":"1","gender":"女","labels":null,"phone":"15801362521","userCode":"613441"}
     * spaceId : 5eebaf72898341b6a4ac5b850f2197a4
     */

    private String id;
    /**
     * name : 牛顿我我我我
     * fsRoot : 2d6c6e4003164ee4b83732364daafa7a
     * capacity : 100
     * searchMe : 1
     * Introduction : 1234567890
     * city : 三亚市
     * icon : http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/064ed5acaea946a9b49c3803900221ee/701ebcf312e44da78ebcaa2ea3cd75e7.jpg@!75
     * area :
     * ryToken : Cz2D6Yo6+UmgcC5Ljfq6DthWgv91OOudH+W9ZZOIj9SNNqmPCXQN+3rFmCc4qSUiK/XkZqKzdqPdMrbxwOEeNNkSdNpQnEDhbE4nNZO49Ot/wn2z0qtlrsG9ui1jP+5AScGic3LHzj8=
     * province : 海南省
     * dateBirth : 2000-10-22
     * userType : 1
     * gender : 女
     * labels : null
     * phone : 15801362521
     * userCode : 613441
     */

    private UserInfoBean userInfo;
    private String spaceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static class UserInfoBean {
        private String name;
        private String fsRoot;
        private String capacity;
        private String searchMe;
        private String Introduction;
        private String city;
        private String icon;
        private String area;
        private String ryToken;
        private String province;
        private String dateBirth;
        private String userType;
        private String gender;
        private Object labels;
        private String phone;
        private String userCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFsRoot() {
            return fsRoot;
        }

        public void setFsRoot(String fsRoot) {
            this.fsRoot = fsRoot;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getRyToken() {
            return ryToken;
        }

        public void setRyToken(String ryToken) {
            this.ryToken = ryToken;
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

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Object getLabels() {
            return labels;
        }

        public void setLabels(Object labels) {
            this.labels = labels;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }
    }
}
