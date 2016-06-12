package memoscorp.unam.mx.clase1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import memoscorp.unam.mx.clase1.R;
import memoscorp.unam.mx.clase1.model.ModelItem;

/**
 * Created by Alumno on 11/06/2016.
 */
public class AdapterItemList extends ArrayAdapter<ModelItem> {
    public AdapterItemList(Context context, List<ModelItem> objects){
       super(context,0,objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = (LayoutInflater.from(parent.getContext())).inflate(R.layout.row_list,parent,false);
        }
        TextView txtItemDescription = (TextView) convertView.findViewById(R.id.txtItemDescription);
        TextView txtItemTitle = (TextView) convertView.findViewById(R.id.txtItemTitle);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgList);

        ModelItem modelItem = getItem(position);
        txtItemTitle.setText(modelItem.item);
        txtItemDescription.setText(modelItem.id);
        img.setImageResource(modelItem.resourceid);
        return convertView;
    }
}
