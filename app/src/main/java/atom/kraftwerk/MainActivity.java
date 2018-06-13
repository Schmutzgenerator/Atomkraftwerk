package atom.kraftwerk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;




public class MainActivity extends AppCompatActivity {

    public double radiusA=530;
    public double radiusB=320;
    public double radiusC=200;
    public int thicknss = 5;
    public int color=0; // 0- yellow, 1 - blue, 2- red
    public double steps=7;

    private void printValues(View view){
        ((TextView)findViewById(R.id.eTextA)).setText(Double.toString(radiusA/10));
        ((TextView)findViewById(R.id.eTextB)).setText(Double.toString(radiusB/10));
        ((TextView)findViewById(R.id.eTextC)).setText(Double.toString(radiusC/10));
        ((TextView)findViewById(R.id.eTextD)).setText(Integer.toString(thicknss));
        ((TextView)findViewById(R.id.eTextE)).setText(Double.toString(steps));
    }



//    View Control Section

    public void onClickSwitchViewRysuj(View view) {
//        MyView mysz = new MyView(this, radiusA, radiusB, radiusC, thicknss, color, steps);
        setContentView(new MyView(this, radiusA, radiusB, radiusC, thicknss, color, steps));
//        mysz.zmienne();
    }

    public void onClickSwitchViewMain(View view) {
        setContentView(R.layout.activity_main);
        printValues(view);
    }

    public void onClickSwitchViewZapisane(View view) {

        setContentView(R.layout.activity_zapisane);
    }

    public void onClickSwitchViewKolory(View view){

        setContentView(R.layout.activity_kolory);
    }


// Radius Control Section

    public void onClickPlusCRadiusA(View view){
        radiusA+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusA(View view){
        radiusA++;
        printValues(view);
    }

    public void onClickMinusCRadiusA(View view){
        if(radiusA>10) radiusA-=10;
        if(radiusB>radiusA) radiusB=radiusA;
        if(radiusC>radiusA) radiusC=radiusA;
        printValues(view);
    }

    public void onClickMinusDRadiusA(View view){
        if(radiusA>1) radiusA--;
        if(radiusB>radiusA) radiusB=radiusA;
        if(radiusC>radiusA) radiusC=radiusA;
        printValues(view);
    }

//

    public void onClickPlusCRadiusB(View view){
        if(radiusB<radiusA-10) radiusB+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusB(View view){
        if(radiusB<radiusA)radiusB++;
        printValues(view);
    }

    public void onClickMinusCRadiusB(View view){
       if(radiusB>10) radiusB-=10;
        if(radiusC>radiusB) radiusC=radiusB;
        printValues(view);
    }

    public void onClickMinusDRadiusB(View view){
        if(radiusB>1) radiusB--;
        if(radiusC>radiusB) radiusC=radiusB;
        printValues(view);
    }

//

    public void onClickPlusCRadiusC(View view) {
        if(radiusC<radiusB-10) radiusC+=10;
        printValues(view);
    }

    public void onClickPlusDRadiusC(View view){
        if(radiusC<radiusB)radiusC++;
        printValues(view);
    }

    public void onClickMinusCRadiusC(View view){
        if(radiusC>10) radiusC-=10;
        printValues(view);
    }

    public void onClickMinusDRadiusC(View view){
        if(radiusC>1) radiusC--;
        printValues(view);
    }


    public void onClickPlusPen(View view){
        thicknss++;

        ((TextView)findViewById(R.id.eTextD)).setText(Integer.toString(thicknss));

    }

    public void onClickMinusPen(View view){
        if(thicknss>1) thicknss--;

        ((TextView)findViewById(R.id.eTextD)).setText(Integer.toString(thicknss));

    }
//

//    KOLORY
    public void onClickSwitchColorBlue(View view){
        color=1;
        onClickSwitchViewMain(view);
    }

    public void onClickSwitchColorYellow(View view){
        color=0;
        onClickSwitchViewMain(view);
    }

    public void onClickSwitchColorRed(View view){
        color=2;
        onClickSwitchViewMain(view);
    }

//

    public void onClickPlusStep(View view){
        steps+=0.5;
        ((TextView)findViewById(R.id.eTextE)).setText(Double.toString(steps));
    }

    public void onClickMinusStep(View view){
        if(steps>0.5) steps-=0.5;
        ((TextView)findViewById(R.id.eTextE)).setText(Double.toString(steps));
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
        radiusA=530;
        radiusB=320;
        radiusC=200;
        steps=7;
        color=0;
        thicknss = 5;
        printValues(view);
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
