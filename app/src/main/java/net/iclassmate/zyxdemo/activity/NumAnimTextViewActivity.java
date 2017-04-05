package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.view.NumAnimTextView;

/**
 * Created by xydbj on 2016.12.15.
 */
public class NumAnimTextViewActivity extends Activity {
    private NumAnimTextView tv1, tv2;
    private TextView tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numanimtextview);

        tv1 = (NumAnimTextView) findViewById(R.id.tv1);
        tv2 = (NumAnimTextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        tv1.setPrefixString("＄");//设置前缀
        tv1.setDuration(4000);//设置动画时长
        tv1.setNumberString("10000");//设置最终值
        tv1.setNumberString("0", "10000");//设置变化区间

        tv2.setPostfixString("%");//设置后缀
        tv2.setDuration(2000);//设置动画时长
        tv2.setNumberString("100.00");//设置最终值
        tv2.setNumberString("0", "100.00");//设置变化区间

        String name1 = "杭州10月份阶段性测试6校联考的总分为473分，其中语文101分，数学116分，英语105分，物理72分，生化79分，科学151分。";
        String name2 = "杭州10月份阶段性测试6校联考的总分为473分，其中语文101分，数学116分，英语105分，物理72分，生化79分，科学151分。";
        String diseaseName1 = "杭州10月份阶段性测试6校联考";
        String diseaseName2 = "语文";
        setHighLight1(diseaseName1, name1, tv3);
        setHighLight2(diseaseName2, name2, tv4);

    }

    /**
     * 设置搜索结果字体高亮
     *
     * @param keyword：需要高亮显示的字体
     * @param searchResult：搜索的结果
     * @param tv：展示的view
     */
    private void setHighLight1(String keyword, String searchResult, TextView tv) {
        SpannableString ss = new SpannableString(searchResult);
        int start = searchResult.toLowerCase().indexOf(keyword.toLowerCase());
        int end = start + keyword.length();
        if (start < 0) return;
        ss.setSpan(new ForegroundColorSpan(0xffffa500), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);
    }

    /**
     *
     * @param keyword：需要高亮显示的字体
     * @param searchResult：搜索的结果
     * @param tv：展示的view
     */
    public void setHighLight2(String keyword, String searchResult, TextView tv) {
        if (searchResult.contains(keyword)) {
            searchResult = searchResult.replace(keyword, "<font color='#68C270'>" + keyword + "</font>");
            tv.setText(Html.fromHtml(searchResult));
        }
    }
}
