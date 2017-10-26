package fuyu.ntub_course.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import fuyu.ntub_course.Adapter.WeekRVAdapter;
import fuyu.ntub_course.Model.Session;
import fuyu.ntub_course.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_week;
    private RecyclerView rv_session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_week = (RecyclerView) findViewById(R.id.rv_main_week);
        rv_session = (RecyclerView) findViewById(R.id.rv_main_session);

        initWeek();
        initSession();
    }

    private void initSession() {
        ArrayList<Session> list_session = new ArrayList<>();
        list_session.add("第一節", "08:10", "09:00");
        list_session.add("第一節", "08:10", "09:00");
    }

    private void initWeek() {
        ArrayList<String> list_week = new ArrayList<>();
        list_week.add("");
        list_week.add("一");
        list_week.add("二");
        list_week.add("三");
        list_week.add("四");
        list_week.add("五");
        list_week.add("六");
        list_week.add("日");
        rv_week.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_week.setAdapter(new WeekRVAdapter(this, list_week));
    }


}
