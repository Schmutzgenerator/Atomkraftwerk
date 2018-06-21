package atom.kraftwerk;
// by Wojciech S.Y.R.O.P. Godula
// enjoy good techno while reading the code


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    int n=0;
    int layout=0;
    Canvas canvas;
    public double[][] data ={{530,320,200,5,0,7},
                            {500,340,200,5,1,0},
                            {530,320,200,5,2,0}};
/////////////////////////////rA[0],rB[1],rC[2],thcknss[3],clr[4],steps[5]



    private void printValues(View view) {
        ((TextView) findViewById(R.id.eTextA)).setText(Double.toString(data[n][0] / 10));
        ((TextView) findViewById(R.id.eTextB)).setText(Double.toString(data[n][1] / 10));
        ((TextView) findViewById(R.id.eTextC)).setText(Double.toString(data[n][2] / 10));
        ((TextView) findViewById(R.id.eTextD)).setText(Double.toString(data[n][3]));
        ((TextView) findViewById(R.id.eTextE)).setText(Double.toString(data[n][5]));


        if(data[n][4]==0) ((TextView) findViewById(R.id.textView3)).setTextColor(Color.parseColor("#ffff00"));
        if(data[n][4]==1) ((TextView) findViewById(R.id.textView3)).setTextColor(Color.parseColor("#0000ff"));
        if(data[n][4]==2) ((TextView) findViewById(R.id.textView3)).setTextColor(Color.parseColor("#ff0000"));
        if(data[n][4]==3) ((TextView) findViewById(R.id.textView3)).setTextColor(Color.parseColor("#00ff00"));

        ((TextView)findViewById(R.id.textView3)).setText(Integer.toString(n+1));
    }



//    View Control Section

    public void onClickSwitchViewRysuj(View view) {

        MyView mV = new MyView(this,data);
//        try {
//            Toast.makeText(this,"processing",Toast.LENGTH_LONG).show() ;
//            Thread.sleep(1000);
            if (layout == 0) {

//                Thread.sleep(1000);
                setContentView(mV);
//                mV.kkk(canvas);
//                Thread.sleep(1000);
                layout = 1;
            }
//        } catch(InterruptedException e){
//            e.printStackTrace();
//        }
    }

    public void onClickSwitchViewMain(View view) {
        setContentView(R.layout.activity_main);
        printValues(view);
        layout=0;
    }

    public void onClickSwitchViewZapisane(View view) {

        setContentView(R.layout.activity_zapisane);
        layout=0;
    }

    public void onClickSwitchViewKolory(View view){

        setContentView(R.layout.activity_kolory);
        layout=0;
    }


// Radius Control Section

    public void onClickPlusCRadiusA(View view){
        data[n][0]+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusA(View view){
        data[n][0]++;
        printValues(view);
    }

    public void onClickMinusCRadiusA(View view){
        if(data[n][0]>10) data[n][0]-=10;
        if(data[n][1]>data[n][0]) data[n][1]=data[n][0];
        if(data[n][2]>data[n][0]) data[n][2]=data[n][0];
        printValues(view);
    }

    public void onClickMinusDRadiusA(View view){
        if(data[n][0]>1) data[n][0]--;
        if(data[n][1]>data[n][0]) data[n][1]=data[n][0];
        if(data[n][2]>data[n][0]) data[n][2]=data[n][0];
        printValues(view);
    }

//

    public void onClickPlusCRadiusB(View view){
        if(data[n][1]<data[n][0]-10) data[n][1]+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusB(View view){
        if(data[n][1]<data[n][0])data[n][1]++;
        printValues(view);
    }

    public void onClickMinusCRadiusB(View view){
       if(data[n][1]>10) data[n][1]-=10;
        if(data[n][2]>data[n][1]) data[n][2]=data[n][1];
        printValues(view);
    }

    public void onClickMinusDRadiusB(View view){
        if(data[n][1]>1) data[n][1]--;
        if(data[n][2]>data[n][1]) data[n][2]=data[n][1];
        printValues(view);
    }

//

    public void onClickPlusCRadiusC(View view) {
        if(data[n][2]<data[n][1]-10) data[n][2]+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusC(View view){
        if(data[n][2]<data[n][1])data[n][2]++;
        printValues(view);
    }

    public void onClickMinusCRadiusC(View view){
        if(data[n][2]>10) data[n][2]-=10;
        printValues(view);
    }

    public void onClickMinusDRadiusC(View view){
        if(data[n][2]>1) data[n][2]--;
        printValues(view);
    }


    public void onClickPlusPen(View view){
        data[n][3]++;

        ((TextView)findViewById(R.id.eTextD)).setText(Double.toString(data[n][3]));

    }

    public void onClickMinusPen(View view){
        if(data[n][3]>1) data[n][3]--;

        ((TextView)findViewById(R.id.eTextD)).setText(Double.toString(data[n][3]));

    }
//
    public void switchLayer1(View view){
        n=0;
        printValues(view);
    }


    public void switchLayer2(View view){
        n=1;
        printValues(view);
    }

    public void switchLayer3(View view){
        n=2;
        printValues(view);
    }



//    KOLORY
    public void onClickSwitchColorBlue(View view){
//        color=1;
        data[n][4]=1;
        onClickSwitchViewMain(view);
        printValues(view);
    }

    public void onClickSwitchColorYellow(View view){
//        color=0;
        data[n][4]=0;
        onClickSwitchViewMain(view);
        printValues(view);
    }

    public void onClickSwitchColorGreen(View view){
//        color=3;
        data[n][4]=3;
        onClickSwitchViewMain(view);
        printValues(view);
    }


    public void onClickSwitchColorRed(View view){
//        color=2;
        data[n][4]=2;
        onClickSwitchViewMain(view);
        printValues(view);
    }

//

    public void onClickPlusStep(View view){
        data[n][5]+=0.5;
        ((TextView)findViewById(R.id.eTextE)).setText(Double.toString(data[n][5]));
    }

    public void onClickMinusStep(View view){
        if(data[n][5]>0.5) data[n][5]-=0.5;
        ((TextView)findViewById(R.id.eTextE)).setText(Double.toString(data[n][5]));
    }

    //view-draw-etc

//    public class MyView extends View
//    {
//        Paint paint = null;
//
//        public MyView(Context context)
//        {
//            super(context);
//            paint = new Paint();
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            int x = getWidth();
//            int y = getHeight();
//            int color1 = color;
//            double y1=getHeight();
//            double x1=getWidth();
//            double radiusX;
//            double radiusY;
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(Color.parseColor("#434343"));
//            canvas.drawPaint(paint);
//            paint.setColor(Color.parseColor("#ffff00"));
//
//            canvas.drawColor(Color.parseColor("#343434"));
//            if (color1 == 0) paint.setColor(Color.parseColor("#ffff00"));
//            if (color1 == 1) paint.setColor(Color.parseColor("#0000ff"));
//            if (color1 == 2) paint.setColor(Color.parseColor("#ff0000"));
//
//        x1/=2;
//        y1/=2;
//        radiusX=radiusA-radiusB;
//        radiusY=radiusC;
//
//            for(int i=0;i<5000*steps;i++){
//
//                canvas.drawCircle(
//                        ((int)(x1+radiusX*Math.cos(i*0.0002*2*Math.PI)+radiusY*Math.cos(-i*0.0002*radiusA/radiusB*2*Math.PI-(0.0002*i*radiusA/radiusB)))),
//                        ((int)(y1+radiusX*Math.sin(i*0.0002*2*Math.PI)+radiusY*Math.sin(-i*0.0002*radiusA/radiusB*2*Math.PI-(0.0002*i*radiusA/radiusB)))),
//                        thicknss, paint);
//
//            }
//            paint.setTextSize(40);
//        canvas.drawText(radiusA+"//"+radiusB+"//"+radiusC+"//"+steps, 25, 40, paint);
//
//        }
//
//
//
//    }

    ///back to the reality

    public void onClickReset(View view){
//        radiusA=530;
//        radiusB=320;
//        radiusC=200;
//        steps=7;
//        color=0;
//        thicknss = 5;

        data[0][0]=530; //radiusA
        data[0][1]=320; //radiusB
        data[0][2]=200; //radiusC
        data[0][3]=5;   //thicknss
        data[0][4]=0;   //color
        data[0][5]=7;   //steps

        data[1][0]=500;
        data[1][1]=340;
        data[1][2]=200;
        data[1][3]=5;
        data[1][4]=1;
        data[1][5]=0;

        data[2][0]=530;
        data[2][1]=320;
        data[2][2]=200;
        data[2][3]=5;
        data[2][4]=2;
        data[2][5]=0;

        n=0;
        printValues(view);
        ((ImageView) findViewById(R.id.imageView2)).setVisibility((View.INVISIBLE));
        ((TextView)findViewById(R.id.textView3)).setText("1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();
        getWindow().addContentView(inflater.inflate(R.layout.activity_rysuj, null),
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

    }

}
