package com.example.moment;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MapActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback {
    // T Map API
    String API_Key = "l7xx4e73edbc96c742a0a4a0f8379a11d274";

    // T Map View
    TMapView tMapView = null;

    // T Map GPS
    TMapGpsManager tMapGPS = null;

    //container
    private LinearLayout container;
    //Intent
    Intent sharingIntent;
    //Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        sharingIntent = new Intent(this, RecordlistActivity.class);
        //intent = new Intent(this, RecordlistActivity.class);

        // set button Stop GPS
        Button stopRec = findViewById(R.id.stopRec);
        stopRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapGPS.CloseGps();
                Toast.makeText(getApplicationContext(),"경로 기록을 종료합니다.", Toast.LENGTH_SHORT).show();
            }

        });

        // set button screenshot
        Button share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getCaptureScreen();

                                }
        });

        // T Map View
        tMapView = new TMapView(this);

        // API Key
        tMapView.setSKTMapApiKey(API_Key);

        // Initial Setting
        tMapView.setZoomLevel(17);
        tMapView.setIconVisibility(true);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);

        // T Map View Using Linear Layout
        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        linearLayoutTmap.addView(tMapView);

        // Request For GPS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // GPS using T Map
        tMapGPS = new TMapGpsManager(this);

        // Initial Setting
        tMapGPS.setMinTime(1000);
        tMapGPS.setMinDistance(6);
        tMapGPS.setProvider(TMapGpsManager.NETWORK_PROVIDER);
        // tMapGPS.setProvider(tMapGPS.GPS_PROVIDER);
        tMapGPS.OpenGps();


    }
    //screenshot
    private void getCaptureScreen() {
        container = (LinearLayout) findViewById(R.id.linearLayoutTmap);
        String now = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        container.buildDrawingCache();
        container.setDrawingCacheEnabled(true);
        Bitmap captureView = container.getDrawingCache();
        FileOutputStream fos;

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/" + now + "capture.jpeg"; //저장 경로 (String Type 변수)
        File file = new File(path);


        try {
            fos = new FileOutputStream(file);
            captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), "캡쳐되었습니다", Toast.LENGTH_LONG).show();
        container.setDrawingCacheEnabled(false);

        sharingIntent.setType("image/*");
        Uri uri = Uri.parse(path);
        sharingIntent.putExtra("Img", uri.toString()); //이미지를 uri로 전송

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(sharingIntent);
            }
        }, 1000L);

    }


    TMapPolyLine tMapPolyLine = new TMapPolyLine();
        //ArrayList<TMapPoint> alTMapPoint = new ArrayList<TMapPoint>();


    @Override
    public void onLocationChange(Location location) {
        tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
        tMapView.setCenterPoint(location.getLongitude(), location.getLatitude());
        //TMapPoint point = tMapGPS.getLocation();

        double Latitude = location.getLatitude();
        double Longitude = location.getLongitude();
        TMapPoint point = new TMapPoint(Latitude, Longitude);
        // Log.i("point", String.valueOf(point));

        //alTMapPoint.add( new TMapPoint(Latitude, Longitude) );
        tMapPolyLine.setLineColor(Color.BLUE);
        tMapPolyLine.setLineWidth(2);

        tMapPolyLine.addLinePoint(point);
        tMapView.addTMapPolyLine("Line", tMapPolyLine);

    }



}
