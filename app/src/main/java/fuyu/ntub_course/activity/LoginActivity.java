package fuyu.ntub_course.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Callable;

import fuyu.ntub_course.R;
import fuyu.ntub_course.helper.SPHelper;
import fuyu.ntub_course.model.Course;
import fuyu.ntub_course.retrofit.CourseService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView login;
    private EditText stdNo;
    private CheckBox cb_auto_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (TextView) findViewById(R.id.tv_login_do_login);
        stdNo = (EditText) findViewById(R.id.et_login_std_no);

        login.setOnClickListener(this);

        // init
        boolean auto = SPHelper.getStdNo(this);
        if (auto) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void login(final String std_no, final String day) {
        Course course = new Course();
        course.setStdNo(std_no);
        course.setToday(day);

        CourseService service = CourseService.retrofit.create(CourseService.class);
        Call<Course> call = service.Login(course);
        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    Course result = response.body();
                    if (result.isResult()) {
                        Course course = Course.getInstance();
                        course.setStdNo(std_no);
                            course.setToday(day);
                        if (cb_auto_login.isChecked())
                            SPHelper.setStdNo(LoginActivity.this, std_no);
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), "失敗", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("log", t.toString());
            }
        });

    }

    @Override
    public void onClick(View v) {
        String std_no = stdNo.getText().toString();
        if (std_no.isEmpty()) {
            Toast.makeText(this, "不能是空的", Toast.LENGTH_SHORT).show();
        }
        for (int i = 1; i < 8; i++) {
            login(std_no, String.valueOf(i));
        }

    }
}
