package com.app.esettings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
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

        if (!Battery.isConnected2(this)) {
            // !Plugged
            String percentage2 = Battery.batteryPercentage(this.getApplicationContext());
            int per = Integer.parseInt(percentage2);
            if (per <= 25) {
                ImageView BatteryLow = (ImageView) findViewById(R.id.imageView2);
                BatteryLow.setVisibility(View.VISIBLE);
            } else if (per > 25 && per <= 50) {
                ImageView BatteryMediumLow = (ImageView) findViewById(R.id.imageView3);
                BatteryMediumLow.setVisibility(View.VISIBLE);
            } else if (per > 50 && per <= 75) {
                ImageView BatteryMediumHigh = (ImageView) findViewById(R.id.imageView4);
                BatteryMediumHigh.setVisibility(View.VISIBLE);
            } else {
                ImageView BatteryHigh = (ImageView) findViewById(R.id.imageView5);
                BatteryHigh.setVisibility(View.VISIBLE);
            }
            percentage.setText(Battery.batteryPercentage(this.getApplicationContext())+R.string.percentage);
            plugged.setText(R.string.falsePlug);

        } else {
            ImageView BatteryCharge = (ImageView) findViewById(R.id.imageView1);
            BatteryCharge.setVisibility(View.VISIBLE);
            percentage.setText(R.string.charging);
            plugged.setText(R.string.truePlug);

        }

        temperature.setText(Battery.batteryTemperature(this.getApplicationContext()));
        voltage.setText(Battery.batteryVoltage(this.getApplicationContext()));

    }
}
