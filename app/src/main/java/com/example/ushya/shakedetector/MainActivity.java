package com.example.ushya.shakedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Rakshit on 5/17/2017.
 * <p>
 * Activity to detect the shake of the mobile device
 */

public class MainActivity extends AppCompatActivity implements ShakeDetector.ShakeListener {

    private ShakeDetector shakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shakeDetector = new ShakeDetector();
        shakeDetector.setListener(this);
        shakeDetector.init(this);
    }

    @Override
    public void onShake() {
        Toast.makeText(this, "Device shaken", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        shakeDetector.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shakeDetector.deregister();
    }
}
