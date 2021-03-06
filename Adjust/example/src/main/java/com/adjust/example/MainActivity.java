package com.adjust.example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri data = intent.getData();
        Adjust.appWillOpenUrl(data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        Adjust.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Adjust.onPause();
    }

    public void onTrackSimpleEventClick(View v) {
        AdjustEvent event = new AdjustEvent("{eventToken}");

        Adjust.trackEvent(event);
    }

    public void onTrackRevenueEventClick(View v) {
        AdjustEvent event = new AdjustEvent("{eventToken}");

        // add revenue 1 cent of an euro
        event.setRevenue(0.01, "EUR");

        Adjust.trackEvent(event);
    }

    public void onTrackEventWithCallbackClick(View v) {
        AdjustEvent event = new AdjustEvent("{eventToken}");

        // add callback parameters to this parameter
        event.addCallbackParameter("key", "value");

        Adjust.trackEvent(event);
    }

    public void onTrackEventWithPartnerClick(View v) {
        AdjustEvent event = new AdjustEvent("{eventToken}");

        // add partner parameters to this parameter
        event.addPartnerParameter("foo", "bar");

        Adjust.trackEvent(event);
    }
}
