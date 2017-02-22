package com.example.simplecaculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;

    private TextView tvadd;
    private TextView tvsubtract;
    private TextView tvmultiply;
    private TextView tvdivide;
    private TextView tvis;

    private TextView leftkuohao;
    private TextView rightkuohao;
    private TextView tvitem;
    private TextView number;
    private TextView answer;
    private TextView tvclean;
    private TextView tvback;

    private String shownumber = "";
    private boolean kuohaoFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (TextView) findViewById(R.id.number);
        answer = (TextView) findViewById(R.id.answer);

//        <!--add, subtract, multiply  divide;-->
        tv0 = (TextView) findViewById(R.id.tv_0);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);
        tv5 = (TextView) findViewById(R.id.tv_5);
        tv6 = (TextView) findViewById(R.id.tv_6);
        tv7 = (TextView) findViewById(R.id.tv_7);
        tv8 = (TextView) findViewById(R.id.tv_8);
        tv9 = (TextView) findViewById(R.id.tv_9);

        tvadd = (TextView) findViewById(R.id.tv_add);
        tvsubtract = (TextView) findViewById(R.id.tv_subtract);
        tvmultiply = (TextView) findViewById(R.id.tv_multiply);
        tvdivide = (TextView) findViewById(R.id.tv_divide);
        tvis = (TextView) findViewById(R.id.tv_is);


        leftkuohao = (TextView) findViewById(R.id.tv_left_kh);
        rightkuohao = (TextView) findViewById(R.id.tv_right_kh);
        tvitem = (TextView) findViewById(R.id.tv_item);
        tvclean = (TextView) findViewById(R.id.tv_clean);
        tvback = (TextView) findViewById(R.id.tv_back);


        tv0.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);

        tvadd.setOnClickListener(this);
        tvsubtract.setOnClickListener(this);
        tvmultiply.setOnClickListener(this);
        tvdivide.setOnClickListener(this);
        tvis.setOnClickListener(this);

        leftkuohao.setOnClickListener(this);
        rightkuohao.setOnClickListener(this);
        tvitem.setOnClickListener(this);
        tvclean.setOnClickListener(this);
        tvback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView t = (TextView) v;
        if (("(").equals(t.getText())) {//左边括号
            shownumber = shownumber + "(";
            number.setText(shownumber);
            return;
        }
        if ((")").equals(t.getText())) {//右边括号
            shownumber = shownumber + ")";
            number.setText(shownumber);
            return;
        }
        if (("删除").equals(t.getText())) {
            if (shownumber.length() > 0) {
//                if ((")").equals(shownumber.substring(shownumber.length() - 1, shownumber.length()))) {
//                    //判断是否删除右边空格
//                    kuohaoFlag = false;
//                } else if (("(").equals(shownumber.substring(shownumber.length() - 1, shownumber.length()))) {
//                    kuohaoFlag = true;
//                }
                shownumber = shownumber.substring(0, shownumber.length() - 1);
            }
            number.setText(shownumber);
            return;
        }
        if (("c").equals(t.getText())) {//删除所有信息
            shownumber = "";
            number.setText("");
            answer.setText(shownumber);
            return;
        }

        if (("=").equals(t.getText())) {//结果
            answer.setText(String.valueOf(JavaScriptManager.eval(shownumber)));
            shownumber += t.getText();
            number.setText(shownumber);
            shownumber = "";
            return;
        }
        shownumber += t.getText();
        number.setText(shownumber);
    }

}
