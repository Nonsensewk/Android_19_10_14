package ies.syuct.edu.cn.ies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

/**
 * 第二页，主页面
 * 签到功能，地图展示
 */
public class IndexActivity extends AppCompatActivity {


    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        //测试显示
        String info = (String)getIntent().getSerializableExtra("info");
        //test.setText(info);
    }
}
