package com.ctech.chris.quarenfit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;


public class LogFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_log, container, false);
        initCalendar(layout);
        return layout;
    }

    private void initCalendar(View layout) {
        CalendarView calendarView = (CalendarView) layout.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = month + "/" + dayOfMonth + "/" + year;
                Toast.makeText(getActivity().getApplicationContext(), date, Toast.LENGTH_SHORT).show();
            }
        });
    }


}

