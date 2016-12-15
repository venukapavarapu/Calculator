package com.example.venu.calci;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, clear, equal,dot;
    TextView text;
    EditText edit;
    char op = '\0';
    String data="0.0";
    String details="";
    Double a = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.textView);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);
        dot=(Button)findViewById(R.id.dot);
        text.setTextColor(Color.rgb(000,123,546));
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        add.setOnClickListener(this);
        mul.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.one:
                case R.id.two:
                case R.id.three:
                case R.id.four:
                case R.id.five:
                case R.id.six:
                case R.id.seven:
                case R.id.eight:
                case R.id.nine:
                case R.id.zero:
                case R.id.dot:
                    String d = ((Button) view).getText().toString();
                    if (data.equals("0.0")) {
                        data = d;
                    } else {
                        data += d;

                    }
                    details += d;
                    edit.setText(data);
                    text.setText(details);
                    //text.setText(details);
                    if (op == '=') {
                        a = 0.0;
                        op = '\0';
                    }
                    break;
                case R.id.add:
                    details += "+";
                    text.setText(details);
                    compute();
                    op = '+';
                    break;

                case R.id.div:
                    details += "/";
                    text.setText(details);
                    compute();
                    op = '/';
                    // edit.setText(edit.getText()+"/");
                    break;

                case R.id.sub:
                    details += "-";
                    text.setText(details);
                    compute();
                    op = '-';
                    break;
                case R.id.mul:
                    details += "*";
                    edit.setText(details);
                    compute();
                    op = '*';
                    break;
                case R.id.equal:
                    compute();
                    op = '=';
                    details="";

                    break;
                case R.id.clear:
                    a = 0.0;
                    data = "0.0";
                    op = '\0';
                    edit.setText("0.0");
                    text.setText("0.0");
                    break;
            }
        }
        catch (Exception e){}
    }
    public void compute(){
        Double num=Double.parseDouble(data);
     //   details+=data;
       // text.setText(details);
        data="0.0";
        if(op=='\0'){
            a=num;
        }
        else if(op=='+'){
            //text.setText(details+"+");
            a+=num;
        }
        else if(op=='-'){
            a-=num;
        }
        else if(op=='*'){
            a*=num;
        }
        else if(op=='/'){
            a/=num;
        } else if (op == '=') {
            //text.setText(a);
        }
//text.setText(String.valueOf(a));
        edit.setText(String.valueOf(a));
    }
}