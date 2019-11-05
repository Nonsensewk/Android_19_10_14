package ies.syuct.edu.cn.ies;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import ies.syuct.edu.cn.utils.HttpUtilsHttpClient;

public class PasswordForgetActivity extends AppCompatActivity {
    EditText Sno,Email;
    Button Enter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forget);
        Enter = findViewById(R.id.enter);
        Email = findViewById(R.id.et_inputemail);
        Sno = findViewById(R.id.et_inputsno);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.INVISIBLE);
       /* Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = Email.getText().toString();
                boolean check = isEmail(getEmail);
                if (check == true){

                }else {
                    Toast.makeText(PasswordForgetActivity.this,"Illegal input",Toast.LENGTH_LONG).show();
                }

            }
        });*/
        Enter.setOnClickListener(new LoginButtonClick());



    }

    //登录按钮点击事件
    private class LoginButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            progressBar.setVisibility(View.VISIBLE);
            //发送登录请求http ------    测试连接
            //开启线程,4.0以后不支持主线程进行耗时操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String url = HttpUtilsHttpClient.BASE_URL + "resetPwdServlet?username=" +
                            Sno.getText().toString().trim() + "&email=" + Email.getText().toString().trim();

                    //请求，返回json
                    String result = HttpUtilsHttpClient.getRequest(url);
                    Message msg = new Message();
                    msg.what = 0x11;
                    Bundle data = new Bundle();
                    data.putString("result", result);
                    msg.setData(data);
                    //？？？？？
                    handler.sendMessage(msg);
                }
                Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        //测试是否能连接，不传输有效数据
                        if (msg.what == 0x11) {
                            Bundle data = msg.getData();
                            String key = data.getString("result");//得到json返回的json数据
                            try {
                                JSONObject json = new JSONObject(key);
                                String result = (String) json.get("result");
                                Toast.makeText(PasswordForgetActivity.this, "info: " + result, Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };

            }).start();
        }
    }
    //邮箱验证
    /*public static boolean isEmail(String strEmail) {
        String regex = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(regex)) {
            return false;
        } else {
            return strEmail.matches(regex);
        }
    }
*/
}
