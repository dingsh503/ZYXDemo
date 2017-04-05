package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jaiky.imagespickers.ImageSelectorActivity;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.utils.PicassoLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.25.
 */
public class ImagePickerActivity extends Activity implements View.OnClickListener {

    private Button btn1, btn2;
    private TextView tv;
    private LinearLayout llContainer;
    private ArrayList<String> pathList;
    private ImageConfig imageConfig;
    public static final int REQUEST_CODE = 1011;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepicker);
        initView();
    }

    public void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv1);
        llContainer = (LinearLayout) findViewById(R.id.llContainer);
        pathList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                imageConfig = new ImageConfig.Builder(new PicassoLoader())
                        // 修改状态栏颜色
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                                // 标题的背景颜色
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                                // 提交按钮字体的颜色
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                                // 标题颜色
                        .titleTextColor(getResources().getColor(R.color.white))
                                // 开启单选   （默认为多选）
                        .singleSelect()
                                // 裁剪 (只有单选可裁剪)
//                        .crop()
                                // 开启拍照功能 （默认关闭）
//                        .showCamera()
                                // 设置显示容器
//                        .setContainer(llContainer)
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(ImagePickerActivity.this, imageConfig);
                break;
            case R.id.btn2:
                imageConfig = new ImageConfig.Builder(
                        new PicassoLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                                // 开启多选   （默认为多选）
                        .mutiSelect()
                                // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                                // 设置图片显示容器，参数：（1、显示容器，2、每行显示数量（建议不要超过8个），是否可删除）
//                        .setContainer(llContainer, 4, true)
                                // 已选择的图片路径
                        .pathList(pathList)
                                // 拍照后存放的图片路径（默认 /temp/picture）
                        .filePath("/temp")
                                // 开启拍照功能 （默认关闭）
                        .showCamera()
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(ImagePickerActivity.this, imageConfig);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);

            tv.setText("");
            for (String path : pathList) {
                tv.append(path);
                tv.append("\n");
            }

            pathList.clear();
            pathList.addAll(pathList);
        }
    }
}
