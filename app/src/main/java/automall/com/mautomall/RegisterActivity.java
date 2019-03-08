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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

    }
    public void registClick1(View view){
        EditText registaccount = findViewById(R.id.registaccount);
        EditText registpwd = findViewById(R.id.registpwd);
        EditText registphone1 = findViewById(R.id.registphone1);
        EditText registcarno1 = findViewById(R.id.registcarno1);

        String username = registaccount.getText().toString().trim();
        String password = registpwd.getText().toString().trim();
        String phone = registphone1.getText().toString().trim();
        String carno = registcarno1.getText().toString().trim();

        AsyncHttpClient client = new AsyncHttpClient("http://192.168.25.1:8080/mautomallserver/");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new NameValuePair("username", username));
        params.add(new NameValuePair("password", password));
        params.add(new NameValuePair("phone", phone));
        params.add(new NameValuePair("carno", carno));

        Headers headers = Headers.of("Header", "");

        client.post("regist", params, headers, new JsonResponseHandler()
        {
            @Override public void onSuccess()
            {
                JsonElement result = getContent();
                JsonObject jsonObject = result.getAsJsonObject();
                String msg = jsonObject.get("msg").getAsString();
                Log.v("msg1",msg);
                // msg = msg.substring(1,msg.length()-1);
                if("success".equals(msg)){
                    Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,"注册成功请登录",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                   startActivity(i);
                }else {
                    // midToast("用户名密码错误",2000);
                    Looper.prepare();
                    Toast.makeText(RegisterActivity.this,"注册失败，请重新注册",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        });

    }
}
