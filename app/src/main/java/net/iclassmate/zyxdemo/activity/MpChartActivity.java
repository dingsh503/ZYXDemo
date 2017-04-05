package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import net.iclassmate.zyxdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2017.3.6.
 */

public class MpChartActivity extends Activity {

    private LineChart lineChart;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpchart);
        //折线图
        lineChart = (LineChart) findViewById(R.id.linechart);
        LineData mLineData = getLineData(10, 100);
        showChart(lineChart, mLineData, Color.rgb(114, 188, 223));
        //柱形图
        barChart = (BarChart) findViewById(R.id.barchart);
        BarData barData = getBarData(5, 50);
        showBarChart(barChart, barData, Color.parseColor("#445566"));
    }

    /**
     * 生成折线图的数据
     * @param count:表示图表中有多少个坐标点
     * @param range:用来生成range以内的随机数
     * @return
     */
    public LineData getLineData(int count, float range) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add("" + i);
        }
        // y轴的数据
        List<Entry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float values = (float) ((Math.random() * range) + 3);
            yValues.add(new Entry(values, i));
        }
        LineDataSet lineDataSet = new LineDataSet(yValues, "测试折线图");
        lineDataSet.setLabel("测试折线图---");
        //用y轴的集合来设置参数
        // 线宽
        lineDataSet.setLineWidth(1.75f);
        // 显示的圆形大小
        lineDataSet.setCircleSize(3f);
        // 显示颜色
        lineDataSet.setColor(Color.WHITE);
        // 圆形的颜色
        lineDataSet.setCircleColor(Color.WHITE);
        // 高亮的线的颜色
        lineDataSet.setHighLightColor(Color.WHITE);

        List<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
        // add the datasets
        lineDataSets.add(lineDataSet);
        // create a data object with the datasets
        LineData lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }
    //设置折线图显示的样式
    public void showChart(LineChart lineChart, LineData lineData, int color) {
        //是否在折线图上添加边框
        lineChart.setDrawBorders(true);
        // 数据描述
        lineChart.setDescription("这里是数据描述");
        lineChart.setDescriptionPosition(1000, 100);
        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        lineChart.setNoDataTextDescription("You need to provide data for the chart");
        // 是否显示表格颜色
        lineChart.setDrawGridBackground(true);
        // 表格的的颜色，在这里是是给颜色设置一个透明度
        lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF);
        // 设置是否可以触摸
        lineChart.setTouchEnabled(true);
        // 是否可以拖拽
        lineChart.setDragEnabled(true);
        // 是否可以缩放
        lineChart.setScaleEnabled(true);
        //设置x轴和y轴能否同时缩放。默认是否
        lineChart.setPinchZoom(false);
        // 设置背景
        lineChart.setBackgroundColor(color);
        // add data 设置数据
        lineChart.setData(lineData);
        // 设置比例图标示，就是那个一组y的value的
        Legend mLegend = lineChart.getLegend();
        mLegend.setPosition(Legend.LegendPosition.ABOVE_CHART_LEFT);
        // 样式
        mLegend.setForm(Legend.LegendForm.CIRCLE);
        // 字体
        mLegend.setFormSize(6f);
        // 颜色
        mLegend.setTextColor(Color.WHITE);
        // 字体
        //        mLegend.setTypeface(mTf);
        // 立即执行的动画
        //        lineChart.animateY(2500);
        lineChart.animateX(2500);

        XAxis x = lineChart.getXAxis();
        //设置X轴的摆放位置
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置X轴数据间隔多少
        x.setLabelsToSkip(1);
        x.setDrawAxisLine(true);
        YAxis y = lineChart.getAxisRight();
        y.setEnabled(false);
        //        y.setStartAtZero(true);
        //一个界面显示多少个点，其他点可以通过滑动看到
        lineChart.setVisibleXRangeMaximum(6);
        //将左边的边放到指定的位置，参数是（float xindex）
        lineChart.moveViewToX(4);
        //Y轴是否允许缩放
        lineChart.setScaleYEnabled(false);
        //X轴是否允许缩放
        lineChart.setScaleXEnabled(true);
    }

    /**
     * 生成柱形图的数据
     * @param count：表示图表中有多少个坐标点
     * @param range：用来生成range以内的随机数
     * @return
     */
    public BarData getBarData(int count, float range) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            xValues.add("" + i);
        }
        List<BarEntry> yValues1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float values = (float) ((Math.random() * range) + 3);
            yValues1.add(new BarEntry(values, i));
        }

        List<BarEntry> yValues2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float values = (float) ((Math.random() * range) + 10);
            yValues2.add(new BarEntry(values, i));
        }

        BarDataSet barDataSet1 = new BarDataSet(yValues1, "小明");
        barDataSet1.setColor(Color.BLUE);

        BarDataSet barDataSet2 = new BarDataSet(yValues2, "李华");
        barDataSet2.setColor(Color.YELLOW);

        List<BarDataSet> barDataSetList = new ArrayList<>();
        barDataSetList.add(barDataSet1);
        barDataSetList.add(barDataSet2);

        BarData barData = new BarData(xValues, barDataSetList);
        return barData;
    }
    //设置柱形图显示的样式
    public void showBarChart(BarChart barChart, BarData barData, int color) {
        barChart.setDrawBorders(true);
        barChart.setDescription("这里是柱形图的数据描述");
        barChart.setDescriptionPosition(800, 800);
        barChart.setNoDataTextDescription("这个柱形图没有数据");
        barChart.setDrawGridBackground(true);
        barChart.setGridBackgroundColor(Color.parseColor("#7faa00aa"));
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setPinchZoom(true);
        barChart.setBackgroundColor(color);
        barChart.setData(barData);

    }
}
