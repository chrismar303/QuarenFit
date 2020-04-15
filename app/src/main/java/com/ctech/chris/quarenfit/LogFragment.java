package com.ctech.chris.quarenfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class LogFragment extends Fragment {

    private String selectedDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_log, container, false);
        initCalendar(layout);
        initEntryButton((Button) layout.findViewById(R.id.entryBtn));
        return layout;
    }


    // TODO: load entries from database
    private void initCalendar(View layout) {
        CalendarView calendarView = (CalendarView) layout.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = month + "/" + dayOfMonth + "/" + year;
                Toast.makeText(getActivity().getApplicationContext(), selectedDate, Toast.LENGTH_SHORT).show();
            }
        });

        // set today's date as default entry to pass to LogEntryActivity
        selectedDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
    }

    private void initEntryButton(Button entryBtn) {
        entryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), LogEntryActivity.class);
                intent.putExtra("date", selectedDate);
                startActivity(intent);
            }
        });
    }

}

