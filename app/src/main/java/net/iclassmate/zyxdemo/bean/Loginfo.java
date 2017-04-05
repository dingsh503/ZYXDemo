package net.iclassmate.zyxdemo.bean;

/**
 * Created by xydbj on 2017.1.20.
 */
public class Loginfo {

    @Override
    public String toString() {
        return "Loginfo{" +
                "authToken='" + authToken + '\'' +
                ", userId='" + userId + '\'' +
                ", ryToken='" + ryToken + '\'' +
                ", name='" + name + '\'' +
                ", remark=" + remark +
                ", userType='" + userType + '\'' +
                ", userCode='" + userCode + '\'' +
                ", icon='" + icon + '\'' +
                ", spaceId='" + spaceId + '\'' +
                ", hasFriends=" + hasFriends +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * authToken : 2e995b2bf9cc5452dfdcb45ba46f514e
     * userId : d2412f4178b9411f96e034af4b8d3ed6
     * ryToken : NaiRfhiljqs9DxMPqYauiE9EZXmjWKB1nH1NhsnQmSw53Br2XFJgXAd4u+qEDM0YVcz5TOLeJkRbL3ZKV0Em9A6CNEt6ORdkTfvq/hdY08Az2Pu6T5CP/dStNSlNBnSR6rC4NUQQM/Q=
     * name : 夏海
     * remark : null
     * userType : 1
     * userCode : 617176
     * icon : http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/d2412f4178b9411f96e034af4b8d3ed6/a1dddf2cb92c420192c332baba52cf3d.jpg@!75
     * spaceId : 931c7a78ae9e4010b7a7cb49ba23f50c
     * hasFriends : true
     * phone : 13817207640
     */

    private String authToken;
    private String userId;
    private String ryToken;
    private String name;
    private Object remark;
    private String userType;
    private String userCode;
    private String icon;
    private String spaceId;
    private boolean hasFriends;
    private String phone;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRyToken() {
        return ryToken;
    }

    public void setRyToken(String ryToken) {
        this.ryToken = ryToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public boolean isHasFriends() {
        return hasFriends;
    }

    public void setHasFriends(boolean hasFriends) {
        this.hasFriends = hasFriends;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
