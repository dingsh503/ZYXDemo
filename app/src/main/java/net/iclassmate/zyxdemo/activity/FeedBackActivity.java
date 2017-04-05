package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2017.2.14.
 */
public class FeedBackActivity extends Activity implements OnClickListener {

    private RadioGroup radioGroup;
    private EditText editText;
    private Button button;
    private TextView textView;
    private String str_radio, str_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        initView();
        setListener();

    }

    public void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.feedback_rg);
        editText = (EditText) findViewById(R.id.feedback_et);
        button = (Button) findViewById(R.id.feedback_btn);
        textView = (TextView) findViewById(R.id.feedback_content);
    }

    public void setListener() {
        button.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        editText.addTextChangedListener(textWatcher);
    }

    public RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            str_radio = radioButton.getText().toString();
        }
    };

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            str_edit = s + "";
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.feedback_btn:
                textView.setText("单选框的选项：" + str_radio + "；输入框的内容：" + str_edit);
                break;
        }
    }
}
