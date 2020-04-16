package Util;

import android.view.View;
import android.widget.EditText;

public class Utility {
    // return edit text to string
    public static String textToString(View view, int id) {
        return ((EditText) view.findViewById(id)).getText().toString();
    }

    // return edit text to int
    public static int textToInt(View view, int id) {
        return Integer.parseInt(((EditText) view.findViewById(id)).getText().toString());
    }
}
