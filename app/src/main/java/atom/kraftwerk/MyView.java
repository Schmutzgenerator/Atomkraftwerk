package atom.kraftwerk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {


    public double[][] data;
      Paint paint;


//    protected double radiusA;
//    protected double radiusB;
//    protected double radiusC;
//    protected int thicknss;
//    public int color; // 0- yellow, 1 - blue, 2- red
//    public double steps;
//
//
//        public MyView(Context context, double radiusA0, double radiusB0, double radiusC0, int thicknss0, int color0, double steps0)
//        {
//            super(context);
//            paint = new Paint();
//            this.radiusA=radiusA0;
//            this.radiusB=radiusB0;
//            this.radiusC=radiusC0;
//            this.thicknss=thicknss0;
//            this.color=color0;
//            this.steps=steps0;
//        }

    public MyView(Context context, double[][] data)
    {
        super(context);
        paint = new Paint();
        this.data=data;
    }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            double y1=getHeight();
            double x1=getWidth();

            double radiusX;
            double radiusY;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#434343"));
            canvas.drawPaint(paint);
            paint.setColor(Color.parseColor("#ffff00"));
//            canvas.drawColor(Color.parseColor("#343434"));

            x1 /= 2;
            y1 /= 2;

///////////////////////////// data[][]::  rA[0],rB[1],rC[2],thcknss[3],clr[4],steps[5]


        /////////////////////////////////
            for(int j=0;j<3;j++) {
                if (data[j][4] == 0) paint.setColor(Color.parseColor("#ffff00"));
                if (data[j][4] == 1) paint.setColor(Color.parseColor("#0000ff"));
                if (data[j][4] == 2) paint.setColor(Color.parseColor("#ff0000"));
                if (data[j][4] == 3) paint.setColor(Color.parseColor("#00ff00"));

                radiusX = data[j][0] - data[j][1];
                radiusY = data[j][2];

                for (int i = 0; i < 5000 * data[j][5]; i++) {

                    canvas.drawCircle(
                            ((int) (x1 + radiusX * Math.cos(i * 0.0002 * 2 * Math.PI) + radiusY * Math.cos(-i * 0.0002 * data[j][0] / data[j][1] * 2 * Math.PI - (0.0002 * i * data[j][0] / data[j][1])))),
                            ((int) (y1 + radiusX * Math.sin(i * 0.0002 * 2 * Math.PI) + radiusY * Math.sin(-i * 0.0002 * data[j][0] / data[j][1] * 2 * Math.PI - (0.0002 * i * data[j][0] / data[j][1])))),
                            (float) data[j][3], paint);

                }
                paint.setTextSize(40);
                if(data[j][5]>0)canvas.drawText(data[j][0] + "//" + data[j][1] + "//" + data[j][2] + "//" + data[j][3] + "//" + data[j][5], 25, 40*(j+1), paint);
            }



        }



    }

