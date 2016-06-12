package memoscorp.unam.mx.clase1.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import memoscorp.unam.mx.clase1.R;

/**
 * Created by Alumno on 11/06/2016.
 */
public class FragmentProfile extends Fragment{
    public static FragmentProfile newInstance(String name){
        FragmentProfile f = new FragmentProfile();
        Bundle b = new Bundle();
        b.putString("user_key",name);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        ImageView imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        TextView txt = (TextView) view.findViewById(R.id.txtUserFragment);
        Bundle bundle = getArguments();
        String user = bundle.getString("user_key");
        txt.setText(user);
        return view;
    }

}
