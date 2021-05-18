package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TemplateListAdapter extends ArrayAdapter<MyTemplates> {

    public TemplateListAdapter(Context context, MyTemplates[] arr) {
        super(context, R.layout.templates_adapter, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyTemplates title = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.templates_adapter, null);
        }

        ((TextView) convertView.findViewById(R.id.templateTitle)).setText(title.titleTemplate);

        int imageID = title.drawableID;
        ((ImageView) convertView.findViewById(R.id.templateIcon)).setImageResource(imageID);


        return convertView;
    }
}
