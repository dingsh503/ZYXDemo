package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ClassClass;
import net.iclassmate.zyxdemo.bean.GradeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.28.
 */
public class DataActivity extends Activity {
    private List<GradeClass> list;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tv = (TextView) findViewById(R.id.tv);
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            GradeClass gradeClass = new GradeClass();
            gradeClass.setType(i + 1);
            for (int j = 0; j < 3; j++) {
                ClassClass classClass = new ClassClass();
                classClass.setTitle("标题" + (i + 1));
                classClass.setContent("内容" + (i + 1));
                gradeClass.setClassClass(classClass);
            }
            list.add(gradeClass);
        }
        Log.i("info", "假数据的list=" + list.toString());
        tv.setText(list.toString());
    }
}
