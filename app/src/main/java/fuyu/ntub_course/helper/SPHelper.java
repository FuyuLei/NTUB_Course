package fuyu.ntub_course.helper;

import android.content.Context;
import android.content.SharedPreferences;

import fuyu.ntub_course.model.Course;

public class SPHelper {

    private static final String STUDENT = "student";
    private static final String STD_NO = "std_no";

    public static void setStdNo(Context context, String stdno){
        SharedPreferences sp = context.getSharedPreferences(STUDENT, Context.MODE_APPEND);
        sp.edit().putString(STD_NO, stdno).apply();
    }

    public static boolean getStdNo(Context context){
        SharedPreferences sp = context.getSharedPreferences(STUDENT, Context.MODE_APPEND);
        return sp.getBoolean(STD_NO, false);
    }

    public static void clearStudent(Context context){
        SharedPreferences sp = context.getSharedPreferences(STUDENT, Context.MODE_APPEND);
        sp.edit().clear().apply();
    }

}
