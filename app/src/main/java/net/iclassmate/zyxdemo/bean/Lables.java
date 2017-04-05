package net.iclassmate.zyxdemo.bean;

import net.iclassmate.zyxdemo.utils.Parserable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.15.
 */
public class Lables implements Serializable,Parserable{

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public void parserJson(JSONObject jsonObject) {
        if (jsonObject != null){
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("list");
                list = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.get(i).toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
