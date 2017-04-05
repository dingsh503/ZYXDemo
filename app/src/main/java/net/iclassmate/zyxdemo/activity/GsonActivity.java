package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.Person;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xydbj on 2016.10.29.
 */
public class GsonActivity extends Activity {

    @BindView(R.id.oldData)
    TextView oldData;
    @BindView(R.id.newData)
    TextView newData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        ButterKnife.bind(this);
//        oldData = (TextView) findViewById(R.id.oldData);
//        newData = (TextView) findViewById(R.id.newData);

        String result = getResources().getString(R.string.person_data);
        oldData.setText(result);

        Gson gson = new Gson();
//        OtherData otherData = gson.fromJson(result,OtherData.class);
        Person person = gson.fromJson(result, Person.class);
        newData.setText(person.toString());
    }

    @OnClick({R.id.oldData, R.id.newData})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oldData:
                break;
            case R.id.newData:
                break;
        }
    }
}
