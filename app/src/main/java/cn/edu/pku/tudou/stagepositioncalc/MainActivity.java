package cn.edu.pku.tudou.stagepositioncalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bt,switchBtn;
    Button clearFromBtn,clearToBtn;
    EditText et_from,et_to,et_dx,et_dy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        switchBtn=(Button)findViewById(R.id.button2);
        clearFromBtn=(Button)findViewById(R.id.button3);
        clearToBtn=(Button)findViewById(R.id.button4);
        et_from=(EditText) findViewById(R.id.editText);
        et_to=(EditText) findViewById(R.id.editText2);
        et_dx=(EditText) findViewById(R.id.editText3);
        et_dy=(EditText) findViewById(R.id.editText4);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pFrom=Integer.parseInt(et_from.getText().toString());
                int pTo=Integer.parseInt(et_to.getText().toString());
                int[] deltaPosition=new int[2];
                deltaPosition=arraySub(convertPosition(pFrom),convertPosition(pTo));
                et_dx.setText(Integer.toString(deltaPosition[0]));
                et_dy.setText(Integer.toString(deltaPosition[1]));

                //et_dx.setText("lalllllll");
            }
        });
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=et_from.getText().toString();
                String b=et_to.getText().toString();
                et_from.setText(b);
                et_to.setText(a);
            }
        });
        clearFromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_from.setText("");
            }
        });
        clearToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_to.setText("");
            }
        });
    }

    public int[] convertPosition(int value){
        int[] tmpIndex=new int[4];
        int tmp=value;
        for(int i=0;i<4;i++){
            tmpIndex[i]=tmp%10;
            tmp=(tmp-tmpIndex[i])/10;
        }
         int[] position=new int[2];
        position[0]=tmpIndex[3]*2000+tmpIndex[1]*200;
        position[1]=tmpIndex[2]*2000+tmpIndex[0]*200;
        return position;
    }
    public int[] arraySub(int[] from,int[] to){
        int[] result=new int[2];
        for(int i=0;i<2;i++){
            result[i]=to[i]-from[i];
        }
        return result;
    }
}
