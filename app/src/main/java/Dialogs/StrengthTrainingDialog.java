package Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.ctech.chris.quarenfit.R;

import Util.StrengthTraining;
import Util.Utility;
import Util.Workout;

public class StrengthTrainingDialog extends AppCompatDialogFragment {

    private WorkoutDialogListener workoutDialogListener;

    // TODO input validations
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.new_strength_training_dialog, null);
        builder.setView(view)
                .setTitle("New Strength Training Exercise")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Workout newWorkout = new StrengthTraining(
                                Utility.textToString(view, R.id.nameET),
                                Utility.textToString(view, R.id.intensityET),
                                Utility.textToString(view,R.id.notesET),
                                Utility.textToInt(view, R.id.weightET),
                                Utility.textToInt(view, R.id.setsET),
                                Utility.textToInt(view, R.id.repsET)
                        );
                        workoutDialogListener.addWorkout(newWorkout);
                    }
                });


        return builder.create();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            workoutDialogListener = (WorkoutDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " have not implement WorkoutDialogListener");
        }
    }
}
