package com.nex.i327844.del;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //toolbar.setOnClickListener();
        /*
        TextView tv=(TextView)findViewById(R.id.textView1);
        //set text color
        tv.setTextColor(Color.RED);
        //set text
        tv.setText("This is my first app");*/
        //initialize image view object
        ImageView im=(ImageView)findViewById(R.id.imageView1);
        //set image resource
        im.setImageResource(R.drawable.lion);
        TextView h=(TextView)findViewById(R.id.textView2);
        //set text color
        h.setTextColor(Color.RED);
        //print 1 to 100 numbers using for loop
        //use append method to print all numbers
        for(int a=0;a<=100;a++)
        {
            h.append(a+"\n");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //This function will perform action when we click on menu item
    public boolean onOptionsItemSelected(MenuItem item)
    {
        LinearLayout rl=(LinearLayout)findViewById(R.id.content_main);
        switch(item.getItemId())
        {
            //Simply changing color of layout
            case R.id.red: rl.setBackgroundColor(Color.RED); break;
            case R.id.blue: rl.setBackgroundColor(Color.BLUE); break;
            case R.id.gray: rl.setBackgroundColor(Color.GRAY); break;
            case R.id.yellow: rl.setBackgroundColor(Color.YELLOW); break;
            case R.id.pink: rl.setBackgroundColor(Color.MAGENTA); break;
            case R.id.white: rl.setBackgroundColor(Color.WHITE); break;
            case R.id.green: rl.setBackgroundColor(Color.GREEN); break;
            case R.id.close: finish(); break;
            default: rl.setBackgroundColor(Color.BLACK);
        }
        return true;
    }

    public void changeIt(View v){
        ImageView im =(ImageView)findViewById(R.id.imageView1);
        switch(v.getId()){
            case R.id.prev:
                im.setImageResource(R.drawable.lion);
                break;
            case R.id.nxt:
                im.setImageResource(R.drawable.t);
                break;
        }
    }
    public void AdIt(View v){
        TextView result = (TextView)findViewById(R.id.res);
        EditText a = (EditText)findViewById(R.id.vala);
        EditText b = (EditText)findViewById(R.id.valb);
        double num1 = Double.parseDouble(String.valueOf(a.getText()));
        double num2 = Double.parseDouble(String.valueOf(b.getText()));
        double sum = num1 + num2;
        result.setText("Result : "+ sum);
    }
    public void nextPage (View v){
        if (v.getId() == R.id.nxtbtn){
            Intent i = new Intent(MainActivity.this,Display.class);
            startActivity(i);
        }
    }
}
