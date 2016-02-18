package com.zzg.materialdesign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.zzg.materialdesign.widgets.flashview.FlashView;
import com.zzg.materialdesign.widgets.flashview.constants.EffectConstants;

import java.util.ArrayList;

public class PrivateInfoActivity extends AppCompatActivity {
    FloatingActionButton fab;
    private ArrayList<String> imageUrls;
    private FlashView flashView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrivateInfoActivity.this.finish();
            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, "删除？？？？", Snackbar.LENGTH_LONG);
                snackbar.setAction("DELETE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });

        flashView=(FlashView)findViewById(R.id.flash_view);
        imageUrls=new ArrayList<String>();
        imageUrls.add("drawable://"+R.drawable.card1);
        imageUrls.add("drawable://"+R.drawable.card2);
        imageUrls.add("drawable://"+R.drawable.card3);
        imageUrls.add("drawable://"+R.drawable.card4);
        flashView.setImageUris(imageUrls);
        flashView.setEffect(EffectConstants.DEFAULT_EFFECT);//更改图片切换的动画效果
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate t  he menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_private_info, menu);
        return true;
    }
}
