package ies.syuct.edu.cn.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    private Paint paint = new Paint();
    private int X = 500;
    private int Y = 900;
    private Double latitude;
    private Double longitude;

    public CanvasView(Context context) {
        this(context,null);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }
   @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

       paint.setColor(Color.BLACK);
       paint.setStrokeWidth(10);
        canvas.drawPoint(450,900,paint);


        paint.setTextSize(50);
        canvas.drawText("国际教育学院410",X,Y,paint);

   }


}
