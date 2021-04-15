package com.example.android_practice4_multiscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvDetail;
    ImageView img11, img12;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvDetail = findViewById(R.id.tvDetail);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        btnBack = findViewById(R.id.btnBack);

        tvTitle.setText(FirsrScreen.object.getPOIName());
        tvDetail.setText(FirsrScreen.object.getDetail());

        int img11id = getResources().getIdentifier(FirsrScreen.object.getImg1(),"mipmap",getPackageName());
        int img12id = getResources().getIdentifier(FirsrScreen.object.getImg2(),"mipmap",getPackageName());

        if(FirsrScreen.primaryImg.equals("img1")){
            img12.setImageResource(img11id);
            img12.setTag(img11id);

            img11.setImageResource(img12id);
            img11.setTag(img12id);
        } else {
            img12.setImageResource(img12id);
            img12.setTag(img12id);

            img11.setImageResource(img11id);
            img11.setTag(img11id);
        }

        btnBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FirsrScreen.class);
                startActivity(intent);
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int img1 = (int) img11.getTag();
                int img2 = (int) img12.getTag();
                img11.setImageResource(img2);
                img11.setTag(img2);

                img12.setImageResource(img1);
                img12.setTag(img1);
            }
        });

    }
}