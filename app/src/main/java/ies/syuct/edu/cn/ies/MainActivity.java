package ies.syuct.edu.cn.ies;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.json.JSONException;
import org.json.JSONObject;

import ies.syuct.edu.cn.utils.HttpUtilsHttpClient;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private EditText userPassword;
    private TextView forgetPassword;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPassword = findViewById(R.id.et_user_pwd);
        //监听小眼睛的变化
        toggleButton = findViewById(R.id.togglebutton);
        toggleButton.setOnCheckedChangeListener(new ToggleButtonClick());
        //忘记密码下划线
        forgetPassword = findViewById(R.id.forget);
        forgetPassword.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //登录按钮
        login = findViewById(R.id.login);
        //验证登录


    }



    //密码可见性监听事件
    private class ToggleButtonClick implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton,boolean ischecked) {
            //判断事件的选中状态
            if(ischecked){//显示密码
                userPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }else{//隐藏密码
                userPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            //每次显示或关闭后  密码显示的编辑线不统一再最后，下面是为了同一
            userPassword.setSelection(userPassword.length());
        }

    }








}

