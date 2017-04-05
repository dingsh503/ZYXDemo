package net.iclassmate.zyxdemo.bean;

import net.iclassmate.zyxdemo.utils.Parserable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by xydbj on 2016.11.15.
 */
public class Information implements Serializable,Parserable {
    private String id;
    private String spaceId;
    private UserInfo userInfo;

    @Override
    public void parserJson(JSONObject jsonObject) {
        if (jsonObject != null){
            try {
                id = jsonObject.getString("id");
                spaceId = jsonObject.getString("spaceId");
                userInfo = new UserInfo();
                JSONObject jsonObject1 = jsonObject.getJSONObject("userInfo");
                userInfo.parserJson(jsonObject1);
                setUserInfo(userInfo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
