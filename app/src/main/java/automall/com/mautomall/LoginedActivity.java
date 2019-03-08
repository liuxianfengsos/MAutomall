package automall.com.mautomall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined);
        Intent i = getIntent();//获取Intent
        Bundle bundle = i.getExtras();//获取绑定信息
        String uname = bundle.get("uname").toString();

        TextView editText = findViewById(R.id.editText);
        editText.setText("欢迎您:"+uname);
    }

    public void weixiuClick(View view){
        Intent intent = new Intent(LoginedActivity.this,Weixiu.class);
        startActivity(intent);
    }

    public void serviceClick(View view){
        Intent intent = new Intent(LoginedActivity.this,Service1.class);
        startActivity(intent);
    }
}
