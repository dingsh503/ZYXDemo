package net.iclassmate.zyxdemo.utils;

import net.iclassmate.zyxdemo.bean.QuanKe;
import net.iclassmate.zyxdemo.bean.lateststudy.LatestStudy;
import net.iclassmate.zyxdemo.bean.lateststudy.MoreEar;
import net.iclassmate.zyxdemo.bean.lateststudy.OneWeekBef;
import net.iclassmate.zyxdemo.bean.lateststudy.Today;
import net.iclassmate.zyxdemo.bean.lateststudy.Yest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.12.29.
 */
public class JsonUtils {
    public static LatestStudy StartJson(String json) {
        LatestStudy latestStudy = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            latestStudy = new LatestStudy();

            JSONArray jsonArray_moreear = jsonObject.getJSONArray("moreEarList");
            List<MoreEar> moreEarLists = new ArrayList<>();
            for (int i = 0; i < jsonArray_moreear.length(); i++) {
                JSONObject jsonObject_moreear = jsonArray_moreear.getJSONObject(i);
                MoreEar moreEar = new MoreEar();
                moreEar.setCatalogName(jsonObject_moreear.getString("catalogName"));
                moreEar.setId(jsonObject_moreear.getInt("id"));
                moreEar.setResId(jsonObject_moreear.getString("resId"));
                moreEar.setResName(jsonObject_moreear.getString("resName"));
                moreEar.setUserId(jsonObject_moreear.getString("userId"));
                moreEar.setWatchTime(jsonObject_moreear.getString("watchTime"));
                moreEar.setWebUrl(jsonObject_moreear.getString("webUrl"));
                moreEarLists.add(moreEar);
            }
            latestStudy.setMoreEars(moreEarLists);

            JSONArray jsonArray_oneweek = jsonObject.getJSONArray("oneWeekBefList");
            List<OneWeekBef> oneWeekBefLists = new ArrayList<>();
            for (int i = 0; i < jsonArray_oneweek.length(); i++) {
                JSONObject jsonObject_oneweek = jsonArray_oneweek.getJSONObject(i);
                OneWeekBef oneWeekBef = new OneWeekBef();
                oneWeekBef.setCatalogName(jsonObject_oneweek.getString("catalogName"));
                oneWeekBef.setId(jsonObject_oneweek.getInt("id"));
                oneWeekBef.setResId(jsonObject_oneweek.getString("resId"));
                oneWeekBef.setResName(jsonObject_oneweek.getString("resName"));
                oneWeekBef.setUserId(jsonObject_oneweek.getString("userId"));
                oneWeekBef.setWatchTime(jsonObject_oneweek.getString("watchTime"));
                oneWeekBef.setWebUrl(jsonObject_oneweek.getString("webUrl"));
                oneWeekBefLists.add(oneWeekBef);
            }
            latestStudy.setOneWeekBefs(oneWeekBefLists);

            JSONArray jsonArray_today = jsonObject.getJSONArray("todayList");
            List<Today> todayLists = new ArrayList<>();
            for (int i = 0; i < jsonArray_today.length(); i++) {
                JSONObject jsonObject_today = jsonArray_today.getJSONObject(i);
                Today today = new Today();
                today.setCatalogName(jsonObject_today.getString("catalogName"));
                today.setId(jsonObject_today.getInt("id"));
                today.setResId(jsonObject_today.getString("resId"));
                today.setResName(jsonObject_today.getString("resName"));
                today.setUserId(jsonObject_today.getString("userId"));
                today.setWatchTime(jsonObject_today.getString("watchTime"));
                today.setWebUrl(jsonObject_today.getString("webUrl"));
                todayLists.add(today);
            }
            latestStudy.setTodays(todayLists);

            JSONArray jsonArray_yest = jsonObject.getJSONArray("yestList");
            List<Yest> yestLists = new ArrayList<>();
            for (int i = 0; i < jsonArray_yest.length(); i++) {
                JSONObject jsonObject_yest = jsonArray_yest.getJSONObject(i);
                Yest yest = new Yest();
                yest.setCatalogName(jsonObject_yest.getString("catalogName"));
                yest.setId(jsonObject_yest.getInt("id"));
                yest.setResId(jsonObject_yest.getString("resId"));
                yest.setResName(jsonObject_yest.getString("resName"));
                yest.setUserId(jsonObject_yest.getString("userId"));
                yest.setWatchTime(jsonObject_yest.getString("watchTime"));
                yest.setWebUrl(jsonObject_yest.getString("webUrl"));
                yestLists.add(yest);
            }
            latestStudy.setYests(yestLists);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return latestStudy;
    }
    public static QuanKe StartQuanKeJson(String result){
        QuanKe quanKe = new QuanKe();

        return quanKe;
    }
}
