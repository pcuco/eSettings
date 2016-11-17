package com.app.esettings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Luís Ferreira on 14/11/2016.
 */

public class BatteryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        TextView temperature = (TextView) findViewById(R.id.temperature);
        TextView voltage = (TextView) findViewById(R.id.voltage);
        TextView plugged = (TextView) findViewById(R.id.plugged);
        TextView percentage = (TextView) findViewById(R.id.percentage);

        temperature.setText(Battery.batteryTemperature(this.getApplicationContext()));
        voltage.setText(Battery.batteryVoltage(this.getApplicationContext()));
        percentage.setText(Battery.batteryPercentage(this.getApplicationContext()));
        boolean plug = Battery.isConnected2(this);
        String str = Boolean.toString(plug);
        plugged.setText(str);
    }
}