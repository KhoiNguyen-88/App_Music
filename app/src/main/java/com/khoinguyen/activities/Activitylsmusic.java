package com.khoinguyen.activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.khoinguyen.app_music.R;
import com.khoinguyen.helper.Music;

import java.util.ArrayList;

public class Activitylsmusic extends ActionBarActivity {

    ListView lv_music;
    ArrayList <Music>dsMusic;
    ArrayAdapter<Music>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lsmusic);
        addControls();
        addEvent();
    }

    private void addControls()
    {
        lv_music= (ListView) findViewById(R.id.lv_music);
        dsMusic=new ArrayList<>();
        adapter=new ArrayAdapter<Music>
                (Activitylsmusic.this, R.layout.data_row, dsMusic);
        lv_music.setAdapter(adapter);
    }

    private void addEvent()
    {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activitylsmusic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
