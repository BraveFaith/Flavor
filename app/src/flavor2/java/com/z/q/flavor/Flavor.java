package com.z.q.flavor;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zengqian on 2017/4/26.
 */

public class Flavor extends AppCompatActivity {
    private TextView tv1,tv2;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        btn = (Button) findViewById(R.id.btn);

        final String pkName = getPackageName();
        PackageManager pm = getPackageManager();

        try {
            String version = pm.getPackageInfo(pkName,0).versionName;
            int code = pm.getPackageInfo(pkName,0).versionCode;
            tv1.setText(version);
            tv2.setText(code+"");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Flavor.this,pkName,Toast.LENGTH_LONG).show();
            }
        });
    }
}
