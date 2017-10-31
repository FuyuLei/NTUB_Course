package fuyu.ntub_course.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import fuyu.ntub_course.R;

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
    }

    @Override
    public void onClick(View v) {
        String std_no = stdNo.getText().toString();
    }
}
