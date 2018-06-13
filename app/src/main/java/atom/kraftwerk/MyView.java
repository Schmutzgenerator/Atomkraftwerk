package atom.kraftwerk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    protected double radiusA;
    protected double radiusB;
    protected double radiusC;
    protected int thicknss;
    public int color; // 0- yellow, 1 - blue, 2- red
    public double steps;



      Paint paint;



        public MyView(Context context, double radiusA0, double radiusB0, double radiusC0, int thicknss0, int color0, double steps0)
        {
            super(context);
            paint = new Paint();
            this.radiusA=radiusA0;
            this.radiusB=radiusB0;
            this.radiusC=radiusC0;
            this.thicknss=thicknss0;
            this.color=color0;
            this.steps=steps0;
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int color1 = color;
            double y1=getHeight();
            double x1=getWidth();

            double radiusX;
            double radiusY;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#434343"));
            canvas.drawPaint(paint);
            paint.setColor(Color.parseColor("#ffff00"));

            canvas.drawColor(Color.parseColor("#343434"));
            if (color1 == 0) paint.setColor(Color.parseColor("#ffff00"));
            if (color1 == 1) paint.setColor(Color.parseColor("#0000ff"));
            if (color1 == 2) paint.setColor(Color.parseColor("#ff0000"));

        x1/=2;
        y1/=2;
        radiusX=radiusA-radiusB;
        radiusY=radiusC;

            for(int i=0;i<5000*steps;i++){

                canvas.drawCircle(
                        ((int)(x1+radiusX*Math.cos(i*0.0002*2*Math.PI)+radiusY*Math.cos(-i*0.0002*radiusA/radiusB*2*Math.PI-(0.0002*i*radiusA/radiusB)))),
                        ((int)(y1+radiusX*Math.sin(i*0.0002*2*Math.PI)+radiusY*Math.sin(-i*0.0002*radiusA/radiusB*2*Math.PI-(0.0002*i*radiusA/radiusB)))),
                        thicknss, paint);

            }
            paint.setTextSize(40);
        canvas.drawText(radiusA+"//"+radiusB+"//"+radiusC+"//"+steps, 25, 40, paint);

        }



    }

