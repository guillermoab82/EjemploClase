package memoscorp.unam.mx.clase1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import memoscorp.unam.mx.clase1.fragments.FragmentList;
import memoscorp.unam.mx.clase1.fragments.FragmentProfile;

/**
 * Created by Alumno on 10/06/2016.
 */
public class ActivityDetail extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_detail);
        //TextView txt=(TextView) findViewById(R.id.detail_username);
        String userName=getIntent().getExtras().getString("key_user");
        String hello = String.format(getString(R.string.hello),userName);
        //txt.setText(hello);
        //getFragmentManager().beginTransaction().replace(R.id.fragmentHolder,new FragmentProfile()).commit();
        findViewById(R.id.btnfragmentA).setOnClickListener(this);
        findViewById(R.id.btnfragmentB).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnfragmentA:
                changeFragmentA();
                break;
            case R.id.btnfragmentB:
                changeFragmentB();
                break;
        }
    }

    private void changeFragmentB() {
        //FragmentProfile f = FragmentProfile.newInstance("Adios nicanor :("); primer ejemplo
        //getFragmentManager().beginTransaction().replace(R.id.fragmentHolder,f).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragmentHolder,new FragmentList()).commit();
    }

    private void changeFragmentA() {
        FragmentProfile f = FragmentProfile.newInstance("Hola nicanor :)");
        getFragmentManager().beginTransaction().replace(R.id.fragmentHolder,f).commit();
    }

}
