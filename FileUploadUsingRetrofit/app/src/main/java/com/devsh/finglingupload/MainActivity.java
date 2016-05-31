package com.devsh.finglingupload;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.devsh.libfileupload.ServerStorage;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Uri fileUri = Uri.parse("/sdcard/46.gif");
        Button btnFileUpload = (Button) findViewById(R.id.btnFileUpload);
        btnFileUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File("/sdcard/46.gif");
                ServerStorage.uploadImageFile(file);
            }
        });
    }
}
