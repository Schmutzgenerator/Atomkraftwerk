package atom.kraftwerk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class MyView extends View {


    public double[][] data;
      Paint paint;
      Bitmap mBitmap;
        Canvas canvas;

    public MyView(Context context, double[][] data)
    {
        super(context);
        paint = new Paint();
        this.data=data;
    }

    public void kkk(Canvas canvas){
//
        double y1=getHeight()/2;
        double x1=getWidth()/2;

        double radiusX;
        double radiusY;

///////////////////////////// data[][]::  rA[0],rB[1],rC[2],thcknss[3],clr[4],steps[5]

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
            canvas.save();

///////////////////////////////////////////////////////////////////
//        mBitmap.compress(Bitmap.CompressFormat.PNG,100,b);

    }

    public void kkk(Canvas canvas, double[][] data){
//
        double y1=getHeight()/2;
        double x1=getWidth()/2;

        double radiusX;
        double radiusY;

///////////////////////////// data[][]::  rA[0],rB[1],rC[2],thcknss[3],clr[4],steps[5]

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
        canvas.save();

///////////////////////////////////////////////////////////////////
//        mBitmap.compress(Bitmap.CompressFormat.PNG,100,b);

    }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#434343"));
            canvas.drawPaint(paint);
            kkk(canvas);

        }



    }

