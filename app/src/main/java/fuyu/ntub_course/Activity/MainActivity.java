package fuyu.ntub_course.Activity;

import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.List;

import fuyu.ntub_course.Adapter.SessionRVAdapter;
import fuyu.ntub_course.Adapter.WeekRVAdapter;
import fuyu.ntub_course.Model.Session;
import fuyu.ntub_course.R;

public class MainActivity extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener {

    private RecyclerView rv_week;
    private RecyclerView rv_session;
    private WeekView wkv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_week = (RecyclerView) findViewById(R.id.rv_main_week);
        rv_session = (RecyclerView) findViewById(R.id.rv_main_session);
        wkv = (WeekView) findViewById(R.id.wkv_main_weekView);

        wkv.setOnEventClickListener(this);
        wkv.setMonthChangeListener(this);
        wkv.setEventLongPressListener(this);

//        initWeek();
//        initSession();
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

    private void initSession() {
        ArrayList<Session> list_session = new ArrayList<>();
        list_session.add(new Session("第一節", "08:10", "09:00"));
        list_session.add(new Session("第二節", "09:10", "10:00"));
        list_session.add(new Session("第三節", "10:10", "11:00"));
        list_session.add(new Session("第四節", "11:10", "12:00"));
        list_session.add(new Session("第五節", "13:30", "14:20"));
        list_session.add(new Session("第六節", "14:25", "15:15"));
        list_session.add(new Session("第七節", "15:25", "16:15"));
        list_session.add(new Session("第八節", "16:20", "17:10"));
        list_session.add(new Session("第九節", "17:15", "18:05"));
        list_session.add(new Session("第十節", "", ""));
        list_session.add(new Session("第十一節", "18:30", "19:15"));
        list_session.add(new Session("第十二節", "19:20", "20:05"));
        list_session.add(new Session("第十三節", "20:15", "21:00"));
        list_session.add(new Session("第十四節", "21:05", "21:50"));
        rv_session.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_session.setAdapter(new SessionRVAdapter(this, list_session));
    }

    @Override
    public void onEventClick(WeekViewEvent weekViewEvent, RectF rectF) {

    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int i, int i1) {
        return null;
    }

    @Override
    public void onEventLongPress(WeekViewEvent weekViewEvent, RectF rectF) {

    }
}
