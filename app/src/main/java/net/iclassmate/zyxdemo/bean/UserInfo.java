package net.iclassmate.zyxdemo.bean;

import net.iclassmate.zyxdemo.utils.Parserable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by xydbj on 2016.11.15.
 */
public class UserInfo implements Serializable,Parserable {


    /**
     * Introduction : 哈哈哈哈哈尔滨💎🔫💣🎁🎁😂😜😁😉😚😝😳
     * area :
     * capacity : 100
     * city : 三亚市
     * dateBirth : 1998-10-24
     * fsRoot : 2d6c6e4003164ee4b83732364daafa7a
     * gender : 女
     * icon : http://space-oss.iclassmate.cn/user/ctsi/filestore/icon/064ed5acaea946a9b49c3803900221ee/a564518ba99b49d1b9e7784455efcb37.jpg@!75
     * labels : {"list":["北京烤鸭"]}
     * name : 张寓宣
     * phone : 15801362521
     * province : 海南省
     * ryToken : Cz2D6Yo6+UmgcC5Ljfq6DthWgv91OOudH+W9ZZOIj9SNNqmPCXQN+3rFmCc4qSUiK/XkZqKzdqPdMrbxwOEeNNkSdNpQnEDhbE4nNZO49Ot/wn2z0qtlrsG9ui1jP+5AScGic3LHzj8=
     * searchMe : 1
     * userCode : 613441
     * userType : 1
     */

    private String introduction;
    private String area;
    private String capacity;
    private String city;
    private String dateBirth;
    private String fsRoot;
    private String gender;
    private String icon;
    private String name;
    private String phone;
    private String province;
    private String ryToken;
    private String searchMe;
    private String userCode;
    private String userType;
    private Lables lables;

    @Override
    public void parserJson(JSONObject jsonObject) {
        if (jsonObject != null){
            try {
                introduction = jsonObject.getString("Introduction");
                area = jsonObject.getString("area");
                capacity = jsonObject.getString("capacity");
                city = jsonObject.getString("city");
                dateBirth = jsonObject.getString("dateBirth");
                fsRoot = jsonObject.getString("fsRoot");
                gender = jsonObject.getString("gender");
                icon = jsonObject.getString("icon");
                name = jsonObject.getString("name");
                phone = jsonObject.getString("phone");
                province = jsonObject.getString("province");
                ryToken = jsonObject.getString("ryToken");
                searchMe = jsonObject.getString("searchMe");
                userCode = jsonObject.getString("userCode");
                userType = jsonObject.getString("userType");
                lables = new Lables();
                JSONObject jsonObject1 = jsonObject.getJSONObject("labels");
                lables.parserJson(jsonObject1);
                setLables(lables);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Lables getLables() {
        return lables;
    }

    public void setLables(Lables lables) {
        this.lables = lables;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFsRoot() {
        return fsRoot;
    }

    public void setFsRoot(String fsRoot) {
        this.fsRoot = fsRoot;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRyToken() {
        return ryToken;
    }

    public void setRyToken(String ryToken) {
        this.ryToken = ryToken;
    }

    public String getSearchMe() {
        return searchMe;
    }

    public void setSearchMe(String searchMe) {
        this.searchMe = searchMe;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
