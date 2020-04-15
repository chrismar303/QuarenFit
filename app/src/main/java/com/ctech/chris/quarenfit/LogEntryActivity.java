package com.ctech.chris.quarenfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LogEntryActivity extends AppCompatActivity {

    private String dateStr;
    // TODO update manifest

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_entry);
        Bundle extras = getIntent().getExtras();
        dateStr = extras.getString("date");
        setupActivityUI();
    }

    //TODO: if no date is selected, date at top will be blank in log_entry
    // TODO: load any data into fields from db
    private void setupActivityUI() {
        TextView titleTV = (TextView) findViewById(R.id.entryTV);
        titleTV.setText(dateStr);
    }


    // TODO: close activity
    public void onSubmitEntry(View view) {
        Toast.makeText(getApplicationContext(), "Submitting Entry", Toast.LENGTH_SHORT).show();
    }

    // ListView for weights and cardio
    // - popup menu and place into list

    // TODO: new cardio/strength training only to appear if radio button is marked yes

}