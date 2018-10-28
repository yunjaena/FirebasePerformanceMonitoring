package com.house.yunjaena.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.AddTrace;
import com.google.firebase.perf.metrics.Trace;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_actvity_trace_start_button)
    Button mTraceStartButton;
    Trace mMyTrace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyTrace = FirebasePerformance.getInstance().newTrace("test_trace");
        ButterKnife.bind(this);
    }


    @OnClick(R.id.main_actvity_trace_start_button)
    void onTraceStartButtonClick() {
        mMyTrace.start();
        Toast.makeText(this, "Trace가 시작되었습니다.", Toast.LENGTH_SHORT).show();
    }

    @AddTrace(name = "endButtonClick", enabled = true)
    @OnClick(R.id.main_actvity_trace_end_button)
    void onTraceEndtButtonClick() {
        mMyTrace.stop();
        Toast.makeText(this, "Trace가 종료되었습니다.", Toast.LENGTH_SHORT).show();
    }



}
