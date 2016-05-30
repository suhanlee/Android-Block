package com.devsh.suhanlee.instagramshare;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    private String type = "video/*";
    private String filename = "/fingling.mp4";
    private String mediaPath = Environment.getExternalStorageDirectory() + filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createInstagramIntent(type, mediaPath, "#madeinfingling");
            }
        });
    }

    private void createInstagramIntent(String type, String mediaPath, String tag) {
        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);

        // Set the MIME type
        share.setType(type);

        // Create the URI from the media
        File media = new File(mediaPath);
        Uri uri = Uri.fromFile(media);

        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);

        // TODO: EXTRA_TEXT is not working
        share.putExtra(Intent.EXTRA_TEXT, tag);

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
    }

}
