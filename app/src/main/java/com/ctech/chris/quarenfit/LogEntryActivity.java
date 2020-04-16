package com.ctech.chris.quarenfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import Dialogs.CardioDialog;
import Dialogs.StrengthTrainingDialog;
import Util.Workout;

public class LogEntryActivity extends AppCompatActivity implements Dialogs.WorkoutDialogListener {

    // TODO update manifest to make this a child activity of MainActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_entry);
        setupActivityUI();
    }

    //TODO: if no date is selected, date at top will be blank in log_entry
    // TODO: load any data into fields from db
    private void setupActivityUI() {
        // set title text as today's date
        setTitle();
        // setup radio groups functionality
        initRadioGroups();
        // setup buttons
        initButtons();
    }

    private void setTitle() {
        String dateStr = getIntent().getExtras().getString("date");
        TextView titleTV = (TextView) findViewById(R.id.entryTV);
        titleTV.setText(dateStr);
    }

    private void initButtons() {
        initStrengthTrainingButton();
        initCardioButton();
    }

    private void initCardioButton() {
        Button newCardioBtn = (Button) findViewById(R.id.newCardioBtn);
        newCardioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewCardioDialog();
            }
        });
    }

    private void initStrengthTrainingButton() {
        Button newStrengthTrainingBtn = (Button) findViewById(R.id.newStrengthExerciseBtn);
        newStrengthTrainingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewStrengthTrainingDialog();
            }
        });
    }

    // TODO: implement
    private void openNewStrengthTrainingDialog() {
        StrengthTrainingDialog dialog = new StrengthTrainingDialog();
        dialog.show(getSupportFragmentManager(), "strength training dialog");
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


    private void openNewCardioDialog() {
        CardioDialog dialog = new CardioDialog();
        dialog.show(getSupportFragmentManager(), "cardio dialog");
    }

    // TODO: close activity
    public void onSubmitEntry(View view) {
        Toast.makeText(getApplicationContext(), "Submitting Entry", Toast.LENGTH_SHORT).show();
        finish();
    }

    // TODO: add to workouts own respective RecyclerView
    // interface between Dialog Fragments
    @Override
    public void addWorkout(Workout workout) {
        Toast.makeText(getApplicationContext(), workout.getName(), Toast.LENGTH_SHORT).show();
    }

    // ListView for weights and cardio
    // - popup menu and place into list

}