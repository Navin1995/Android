package com.nex.i327844.test1;

import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import static com.nex.i327844.test1.R.layout.wifipage;

/**
 * Created by I327844 on 12/21/2016.
 */

public class Wifipage extends Activity {
    private ToggleButton toggleBtn;
    private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(wifipage);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        toggleBtn = (ToggleButton)  findViewById(R.id.toggleBtn);

        //btnDisplay=(Button)findViewById(R.id.button2);
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                //result.append("You have clicked first ON Button-:) ").append(toggleBtn.getText());
                //Toast.makeText(Wifipage.this, result.toString(),Toast.LENGTH_SHORT).show();
                if(toggleBtn.getText() == "ON"){
                    result.append("You have clicked first ON Button-:) ").append(toggleBtn.getText());
                    Toast.makeText(Wifipage.this, result.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void wwf(View v)
    {
        Button b1=(Button)findViewById(R.id.button2);
        //get Wifi service
        WifiManager wm=(WifiManager)getSystemService(WIFI_SERVICE);
        //WifiInfo Wi =(WifiInfo)
        //Check Wifi is on or off
        if(wm.isWifiEnabled())
        {
            b1.setText("Wifi ON");
            //enable or disable Wifi
            //for enable pass true value
            //for disable pass false value
            wm.setWifiEnabled(false);
        }
        else
        {
            b1.setText("Wifi OFF");
            wm.setWifiEnabled(true);
        }
    }

}

