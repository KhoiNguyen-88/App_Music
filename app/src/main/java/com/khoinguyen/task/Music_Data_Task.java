package com.khoinguyen.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import android.util.Config;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.khoinguyen.helper.Music;
import com.khoinguyen.config.Configuration;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by ceani_000 on 02/10/2015.
 */
public class Music_Data_Task extends AsyncTask<Void,Void,ArrayList<Music>>
{

    Activity context;
    ArrayAdapter<Music> adapter;
    ProgressDialog dialog;

    public Music_Data_Task(Activity context, ArrayAdapter<Music> adapter)
    {
        this.context=context;
        this.adapter=adapter;
        dialog=new ProgressDialog(this.context);
        dialog.setTitle("notify");
        dialog.setMessage("Processing Please wait");
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Music> doInBackground(Void... params) {
        try{
            SoapObject request=new SoapObject(Configuration.NAME_SPACE,Configuration.METHOD_GET_LIST_DATA);
            SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet=true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE se=new HttpTransportSE(Configuration.URL);
            se.call(Configuration.SOAP_ACTION_GET_LIST_DATA,envelope);
            SoapObject soapObject=(SoapObject) envelope.getResponse();

            for(int i=0;i<soapObject.getPropertyCount();i++)
            {
                SoapObject object=(SoapObject) soapObject.getProperty(i);
                String name_song= (String) object.getProperty("name_song");
                String singer= (String) object.getProperty("singer");
                String url= (String) object.getProperty("url");
                Music music=new Music(name_song,singer,url);
                music.notifyAll();
            }
        }
        catch (Exception e)
        {
            Log.e("LOI_BACKGROUND",e.toString());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Music> musics) {
        super.onPostExecute(musics);
    }
}
