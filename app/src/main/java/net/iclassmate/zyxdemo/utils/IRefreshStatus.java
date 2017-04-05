package net.iclassmate.zyxdemo.utils;

/**
 * Created by xydbj on 2016.12.14.
 */
public interface IRefreshStatus {
    /**
     * 当手势操作完成且刷新动画滑动到起始位置
     */
    void reset();
    /**
     * 正在刷新
     */
    void refreshing();
    /**
     * 刷新动画被下拉到刷新位置
     */
    void pullToRefresh();
    /**
     * 刷新动画被释放到刷新位置
     */
    void releaseToRefresh();
    /**
     * @param pullDistance 刷新动画被拖动的距离
     * @param pullProgress 刷新动画被拖动的进度，当大于触发刷新的距离会大于1.0f
     *                     pullProgress = pullDistance / refreshTargetOffset
     */
    void pullProgress(float pullDistance, float pullProgress);
}
