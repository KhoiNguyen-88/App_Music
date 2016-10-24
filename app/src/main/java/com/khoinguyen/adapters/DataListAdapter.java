package com.khoinguyen.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.khoinguyen.app_music.R;
import com.khoinguyen.helper.Music;

import java.util.List;

/**
 * Created by ceani_000 on 03/10/2015.
 */
public class DataListAdapter extends ArrayAdapter<Music> {

    Activity context;
    int resource;
    List<Music> objects;
    public DataListAdapter(Activity context, int resource, List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        View datarow=layoutInflater.inflate(this.resource, null);
        TextView txt_song=(TextView) datarow.findViewById(R.id.txt_song);
        TextView txt_singer = (TextView) datarow.findViewById(R.id.txt_singer);
        TextView txt_url = (TextView) datarow.findViewById(R.id.txt_url);

        final Music mu=this.objects.get(position);
        txt_song.setText(mu.getName_song());
        txt_singer.setText(mu.getSinger());
        txt_url.setText(mu.getUrl());
        return datarow;
    }
}
