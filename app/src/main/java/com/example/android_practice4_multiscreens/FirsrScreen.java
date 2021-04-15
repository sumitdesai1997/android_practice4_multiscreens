package com.example.android_practice4_multiscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class FirsrScreen extends AppCompatActivity {

    Spinner spCountry, spPOI;
    ImageView img1,img2;

    public static String countryList[] = {"India", "Canada", "USA", "Finland"};
    public static ArrayList<POI> POIList = new ArrayList<>();
    public static ArrayList<String> tempPOIList = new ArrayList<>();
    public static POI object = new POI();
    public static String primaryImg = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firsr_screen);

        spCountry = findViewById(R.id.spCountry);
        spPOI = findViewById(R.id.spPOI);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        fillData();

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countryList);
        spCountry.setAdapter(aa1);
        spCountry.setOnItemSelectedListener(new SpinnerEvents());

        spPOI.setOnItemSelectedListener(new SpinnerEvents());

        img1.setOnClickListener(new ImageEvents());
        img2.setOnClickListener(new ImageEvents());
    }

    public static void fillData(){
        POIList.add(new POI("Ellora caves",countryList[0], "ie1", "ie2", "Ellora caves are the great!"));
        POIList.add(new POI("Mehrangarh fort",countryList[0], "im1", "im2", "Mehrangarh fort is the great!"));
        POIList.add(new POI("Ranki vaav",countryList[0], "ir1", "ir2", "Ranki vaav is the great!"));
        POIList.add(new POI("Banff national park",countryList[1], "cb1", "cb2", "Banff national park is superb!"));
        POIList.add(new POI("Maligne Canyon",countryList[1], "cma1", "cma2", "Maligne Canyon is awesome!"));
        POIList.add(new POI("Mount robson",countryList[1], "cmo1", "cmo2", "Mount robson is amazing!"));
        POIList.add(new POI("Statue of liberty",countryList[2], "us1", "us2", "Statue of liberty is the great!"));
        POIList.add(new POI("Hollywood rock",countryList[2], "uh1", "uh2", "Hollywood rocks are the great!"));
        POIList.add(new POI("Santa clause village",countryList[3], "fs1", "fs2", "Santa clause village is mesmerizing!"));
        POIList.add(new POI("Levi",countryList[3], "fl1", "fl2", "Levi is the great!"));
    }

    public class SpinnerEvents implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(parent.getId() == R.id.spCountry){
                tempPOIList.clear();
                fillTempPOIList(countryList[position]);

                ArrayAdapter aa2 = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, tempPOIList);
                spPOI.setAdapter(aa2);
            } else{
                object = getPOIobject(tempPOIList.get(position));

                int img1id = getResources().getIdentifier(object.getImg1(),"mipmap",getPackageName());
                img1.setImageResource(img1id);

                int img2id = getResources().getIdentifier(object.getImg2(),"mipmap",getPackageName());
                img2.setImageResource(img2id);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            if(parent.getId() == R.id.spCountry){
                fillTempPOIList(countryList[0]);

                ArrayAdapter aa2 = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, tempPOIList);
                spPOI.setAdapter(aa2);
            } else{
                object = getPOIobject(tempPOIList.get(0));

                int img1id = getResources().getIdentifier(object.getImg1(),"mipmap",getPackageName());
                img1.setImageResource(img1id);

                int img2id = getResources().getIdentifier(object.getImg2(),"mipmap",getPackageName());
                img2.setImageResource(img2id);
            }
        }
    }

    public static void fillTempPOIList(String countryName){
        for(POI poi:POIList){
            if(poi.getCountryName().equals(countryName)){
                tempPOIList.add(poi.getPOIName());
            }
        }
    }

    public static POI getPOIobject(String POIName){
        for(POI poi: POIList){
            if(poi.getPOIName().equals(POIName)){
                return poi;
            }
        }
        return  null;
    }

    public class ImageEvents implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.img1){
                primaryImg = "img1";
                Intent intent1 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent1);
            } else {
                primaryImg = "img2";
                Intent intent2 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent2);
            }
        }
    }
}