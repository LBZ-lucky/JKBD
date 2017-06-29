package cn.ucai.jkbd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import cn.ucai.utils.OkHttpUtils;
import cn.ucai.bean.ExamInformations;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void test(View view)
    {

        OkHttpUtils<ExamInformations> utils = new OkHttpUtils<ExamInformations>(getApplicationContext());
              String uri = "http://101.251.196.90:8080/JztkServer/examInfo";
             utils.url(uri)
                               .targetClass(ExamInformations.class)
                     .execute(new OkHttpUtils.OnCompleteListener<ExamInformations>() {
                    @Override
                    public void onSuccess(ExamInformations result) {
                                  Log.e("main","result="+result);
                               }

                             @Override
                     public void onError(String error) {
                                  Log.e("main","error="+error);
                                }
                });
        startActivity(new Intent(MainActivity.this,Question_test.class));
    }
}
