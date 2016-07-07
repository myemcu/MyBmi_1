//必须使用下拉菜单完成各种类的输入，这样AS就会自动import相关类(切勿全部敲完)

package com.example.administrator.mybmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Ctrl+Alt+F(提升局部变量为类属性)(这样即使在onCreate()外也能使用)
    private EditText weight;
    private EditText height;
    private Button bAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 获取两个编辑框和最后一个按钮对象
        findViews();
    }

    // 通过Ctrl+Alt+M实现的方法抽取
    private void findViews() {
        weight = (EditText) findViewById(R.id.yourWeight);
        height = (EditText) findViewById(R.id.yourHeight);
        bAbout = (Button) findViewById(R.id.btn2);
    }

    // 对应于xml中onClick方法名btn_Click所实现的方法，该方法的功能是实现Bmi值的计算
    public void btn_Click(View v) {
        // 调用EditText的getText()方法取得编辑框对象,再调用toString()方法取得编辑框内的字符串
        // 即该过程为单纯获取字符串输入信息
        String w = weight.getText().toString(); // 获取体重(整数Kg)
        String h = height.getText().toString(); // 获取身高(小数X.xx)
        // 将字符串转为Float类型
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);

        float bmi = weight / (height*height);

        Log.d("BMI", String.valueOf(bmi));
    }
}
