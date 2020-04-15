package com.ctech.chris.quarenfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        // set title as today's date
        TextView titleTV = (TextView) findViewById(R.id.entryTV);
        titleTV.setText(dateStr);

        // setup radio groups functionality
        initRadioGroups();
    }

    private void initRadioGroups() {
        initStrengthRGP(findViewById(R.id.strengthTrainingListContainer));
        initCardioRGP(findViewById(R.id.cardioListContainer));
    }

    // TODO database
    private void initStrengthRGP(final View strengthListContainer) {
        RadioGroup strengthRGP = (RadioGroup) findViewById(R.id.strengthTrainingRGP);
        strengthRGP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.yesStrengthTrainingRB:
                        strengthListContainer.setVisibility(View.VISIBLE);
                        break;
                    case R.id.noStrengthTrainingRB:
                        strengthListContainer.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }


    private void initCardioRGP(final View cardioListContainer) {

        RadioGroup cardioRGP = (RadioGroup) findViewById(R.id.cardioRGP);
        cardioRGP.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.yesCardioRB:
                        cardioListContainer.setVisibility(View.VISIBLE);
                        break;
                    case R.id.noCardioRB:
                        cardioListContainer.setVisibility(View.GONE);
                        break;
                }
            }
        });

    }






    // TODO: close activity
    public void onSubmitEntry(View view) {
        Toast.makeText(getApplicationContext(), "Submitting Entry", Toast.LENGTH_SHORT).show();
    }

    // ListView for weights and cardio
    // - popup menu and place into list

    // TODO: new cardio/strength training only to appear if radio button is marked yes

}