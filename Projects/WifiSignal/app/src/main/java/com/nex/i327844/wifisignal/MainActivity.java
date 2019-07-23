package com.nex.i327844.wifisignal;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void wwf(View v)
    {
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        int numberOfLevels = 5;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
        TextView b1=(TextView) findViewById(R.id.level);
        b1.setText(level);
    }
}
