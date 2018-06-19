package atom.kraftwerk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.view.View;

import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class MyView extends View {


    public double[][] data;
      Paint paint;
// /= Bitmap.createBitmap( view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
Canvas canvas1 = new Canvas();
private Bitmap mBitmap = null;

    public MyView(Context context, double[][] data)
    {
        super(context);
        paint = new Paint();
        this.data=data;
    }

    public void kkk(Canvas canvas){
//        Canvas canvas1 = new Canvas(myBitmap);
        double y1=getHeight();
        double x1=getWidth();

        double radiusX;
        double radiusY;
        {
            x1 /= 2;
            y1 /= 2;
        }
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
            canvas.save();
        try {
            String filename = Environment.getExternalStorageDirectory().toString();

            File f = new File(filename ,"myImage.png");
            f.createNewFile();
            System.out.println("file created " + f.toString());
            FileOutputStream out = new FileOutputStream(f);
//            Bitmap bitmap = new Bitmap();

            mBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void kkk(){
//        Canvas canvas1 = new Canvas(myBitmap);
        double y1=getHeight();
        double x1=getWidth();

        double radiusX;
        double radiusY;
        {
            x1 /= 2;
            y1 /= 2;
        }
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

                canvas1.drawCircle(
                        ((int) (x1 + radiusX * Math.cos(i * 0.0002 * 2 * Math.PI) + radiusY * Math.cos(-i * 0.0002 * data[j][0] / data[j][1] * 2 * Math.PI - (0.0002 * i * data[j][0] / data[j][1])))),
                        ((int) (y1 + radiusX * Math.sin(i * 0.0002 * 2 * Math.PI) + radiusY * Math.sin(-i * 0.0002 * data[j][0] / data[j][1] * 2 * Math.PI - (0.0002 * i * data[j][0] / data[j][1])))),
                        (float) data[j][3], paint);

            }
            paint.setTextSize(40);
            if(data[j][5]>0)canvas1.drawText(data[j][0] + "//" + data[j][1] + "//" + data[j][2] + "//" + data[j][3] + "//" + data[j][5], 25, 40*(j+1), paint);
        }
        canvas1.save();
        try {
            String filename = Environment.getExternalStorageDirectory().toString();

            File f = new File(filename ,"myImage.png");
            f.createNewFile();
            System.out.println("file created " + f.toString());
            FileOutputStream out = new FileOutputStream(f);
//            Bitmap bitmap = new Bitmap();

            mBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#434343"));
            canvas.drawPaint(paint);
//            canvas.drawColor(Color.parseColor("#ffff00"));
            kkk(canvas);
kkk();



        }



    }

