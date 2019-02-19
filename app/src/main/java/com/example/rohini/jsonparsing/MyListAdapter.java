package com.example.rohini.jsonparsing;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rupali on 30-10-2018.
 */
public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] ModuleNo;
    private final String[] ModuleName;
    private final Integer[] Images;

    public MyListAdapter(Activity contexta, String[] MNo, String[] MName, Integer[] img){
        super(contexta,R.layout.my_list,MNo);
        context = contexta;
        ModuleNo = MNo;
        ModuleName = MName;
        Images = img;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list, null, true);

        TextView MNo = (TextView)rowView.findViewById(R.id.moduleNo);
        TextView MName = (TextView)rowView.findViewById(R.id.moduleName);
        ImageView img = (ImageView)rowView.findViewById(R.id.imageView);

        MNo.setText(ModuleNo[position]);
        MName.setText(ModuleName[position]);
        img.setImageResource(Images[position]);

        return rowView;
    };
}
