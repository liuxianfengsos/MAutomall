package automall.com.mautomall;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.callumtaylor.asynchttp.AsyncHttpClient;
import net.callumtaylor.asynchttp.obj.NameValuePair;
import net.callumtaylor.asynchttp.response.JsonResponseHandler;

import java.util.ArrayList;
import java.util.List;
import okhttp3.Headers;

public class LoginActivity extends AppCompatActivity {
    EditText loginaccount;
    EditText loginpassword;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void registerClick(View view){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void postClick(View view) {
        loginaccount = findViewById(R.id.loginaccount);
        username = loginaccount.getText().toString().trim();
        loginpassword = findViewById(R.id.loginpassword);
        String password = loginpassword.getText().toString().trim();
        Log.v("username",username);
        Log.v("password",password);
        //开始准备访问服务器
        AsyncHttpClient client = new AsyncHttpClient("http://192.168.25.1:8080/mautomallserver/");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new NameValuePair("username", username));
        params.add(new NameValuePair("password", password));

        Headers headers = Headers.of("Header", "");

        client.post("login", params, headers, new JsonResponseHandler()
        {
            @Override public void onSuccess()
            {
                JsonElement result = getContent();
                JsonObject jsonObject = result.getAsJsonObject();
                String msg = jsonObject.get("msg").getAsString();
                Log.v("msg1",msg);
                // msg = msg.substring(1,msg.length()-1);
                if("loginsuccess".equals(msg)){
                    Intent i = new Intent(LoginActivity.this,LoginedActivity.class);
                    i.putExtra("msg",msg);
                    i.putExtra("uname",username);
                    startActivity(i);
                }else {
                    // midToast("用户名密码错误",2000);
                    Looper.prepare();
                    Toast.makeText(LoginActivity.this,"用户名密码错误",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        });

    }
}
