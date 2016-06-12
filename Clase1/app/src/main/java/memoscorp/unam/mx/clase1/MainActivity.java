package memoscorp.unam.mx.clase1;

import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mUser;
    private EditText mPass;
    private View loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = (EditText) findViewById(R.id.activity_main_user);
        mPass = (EditText) findViewById(R.id.activity_main_pwd);
        findViewById(R.id.activity_main_btningresar).setOnClickListener(this);
        loading = (View) findViewById(R.id.activity_main_progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_main_btningresar:
                processData();
                break;
        }
    }
    private void processData(){
        final String user = mUser.getText().toString();
        final String pass = mPass.getText().toString();
        loading.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setVisibility(View.GONE);
                if(user.equals("unam") && pass.equals("curso"))
                {
                    Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),ActivityDetail.class);
                    intent.putExtra("key_user",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                }
            }
        },1000*1);
    }
}
