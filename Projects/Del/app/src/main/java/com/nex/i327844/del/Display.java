package com.nex.i327844.del;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

/**
 * Created by I327844 on 12/18/2016.
 */

public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
    }
    public void call (View v){
        Intent i = null;
        switch (v.getId()){
            case R.id.internet:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.innosen.blogspot.com"));
                break;
            case R.id.facebook:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                break;
            case R.id.dia:
                i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8527801400"));
                break;
            case R.id.cal:
                i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:+918527801400"));
                break;
            case R.id.cam:
                i=new Intent("android.media.action.IMAGE_CAPTURE");
                break;
        }
        startActivity(i);
    }
    public void close(View v)
    {
        onCreateDialog(10);
    }

    protected Dialog onCreateDialog(int id)
    {
        switch(id)
        {
            case 10:
                Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Activity will close!!!");
                builder.setTitle("Warning...");
                builder.setIcon(R.drawable.images);
//button
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(), "Nothing happened", Toast.LENGTH_LONG).show();

                    }
                });
//button
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();

                    }
                });
//button
                builder.setNeutralButton("Thinking", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(), "i have to think", Toast.LENGTH_LONG).show();

                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();

        }
        return super.onCreateDialog(id);

    }
}
