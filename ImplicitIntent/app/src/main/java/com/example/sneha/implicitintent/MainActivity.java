package com.example.sneha.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText f1;
    private EditText f2;

    Intent intent = null;
    Intent chooser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = (EditText) findViewById(R.id.editText);
        f2 = (EditText) findViewById(R.id.editText2);
    }

    public void launcButton(View v) {

        intent = new Intent(Intent.ACTION_VIEW);
        String url = f1.getText().toString();

        if( url.startsWith("http://") || url.startsWith("https://")){
            intent.setData(Uri.parse(url));
        }
        else {
            intent.setData(Uri.parse("http://" + url));
        }

        chooser = Intent.createChooser(intent, "Open Website Using ...");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void ringbutton(View V) {
        intent = new Intent(Intent.ACTION_DIAL);
        String phone = f2.getText().toString();
        chooser = Intent.createChooser(intent, "Make Phone Call Using ...");
        intent.setData(Uri.parse("tel:" + phone));
        startActivity(chooser);
    }

    public void closebutton(View V){
        MainActivity.this.finish();
    }
}
