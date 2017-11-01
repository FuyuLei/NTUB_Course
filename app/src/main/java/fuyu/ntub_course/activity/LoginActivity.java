package fuyu.ntub_course.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    private void login(String std_no, String day) {
        Course course = new Course();
        course.setStdNo(std_no);
        course.setToday(day);

        CourseService service = CourseService.retrofit.create(CourseService.class);
        Call<String> call = service.Login(std_no, day);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data = response.body();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

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
