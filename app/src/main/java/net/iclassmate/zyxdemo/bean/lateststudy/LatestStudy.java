package net.iclassmate.zyxdemo.bean.lateststudy;

import java.util.List;

/**
 * Created by xydbj on 2016.12.29.
 */
public class LatestStudy {
    private List<Today> todays;
    private List<Yest> yests;
    private List<OneWeekBef> oneWeekBefs;
    private List<MoreEar> moreEars;

    @Override
    public String toString() {
        return "LatestStudy{" +
                "todays=" + todays +
                ", yests=" + yests +
                ", oneWeekBefs=" + oneWeekBefs +
                ", moreEars=" + moreEars +
                '}';
    }

    public List<Today> getTodays() {
        return todays;
    }

    public void setTodays(List<Today> todays) {
        this.todays = todays;
    }

    public List<Yest> getYests() {
        return yests;
    }

    public void setYests(List<Yest> yests) {
        this.yests = yests;
    }

    public List<OneWeekBef> getOneWeekBefs() {
        return oneWeekBefs;
    }

    public void setOneWeekBefs(List<OneWeekBef> oneWeekBefs) {
        this.oneWeekBefs = oneWeekBefs;
    }

    public List<MoreEar> getMoreEars() {
        return moreEars;
    }

    public void setMoreEars(List<MoreEar> moreEars) {
        this.moreEars = moreEars;
    }
}
