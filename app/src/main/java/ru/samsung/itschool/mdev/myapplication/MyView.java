package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED); // цвет маркера
        //paint.setColor(Color.rgb(255,1,22));
        //paint.setColor(Color.parseColor("#00ff00"));
        paint.setStyle(Paint.Style.STROKE); // заливка
        paint.setAntiAlias(true); // сглаживание
        paint.setTextSize(100); // размер текста
        paint.setStrokeWidth(10); // толщина маркера
        int y = getHeight()/2;
        int x = getWidth()/2;
        canvas.drawColor(Color.BLUE); // цвет фона
        canvas.drawCircle(x, y, 200,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(100,100,200,200, paint);
       // Rect rect = new Rect(100,100, 1000, 200);
       // canvas.drawRect(rect, paint);
        RectF rectF = new RectF(100,100, 1000, 200);
        canvas.drawOval(rectF, paint);
        canvas.drawText("Happy New Year",100,300,paint);


        // текст под углом
        float rotate_center_x = 200; //центр поворота холста по оси X
        float rotate_center_y = 200; // центр поворота холста по оси Y
        float rotate_angle = 45; //угол поворота

// поворачиваем холст
        canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);
        canvas.drawText("Samsung",100,700,paint);
        canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);

        Path path = new Path();
        path.moveTo(100,100);
        path.lineTo(500,500);
        path.lineTo(100,400);
        paint.setColor(Color.WHITE);
        canvas.drawPath(path, paint);

        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.football);
        canvas.drawBitmap(img,300,300,paint);

    }
}
