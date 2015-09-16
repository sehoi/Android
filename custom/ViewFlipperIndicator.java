package com.stn.memorizetraining.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/**
 * Created by sehoi on 15. 8. 28..
 * reference: https://asishinwp.wordpress.com/2013/03/11/android-viewflipper-with-page-indicator/
 */
public class ViewFlipperIndicator extends ViewFlipper {
    private Paint paint;
    private float innerMargin = 4;
    private float bottomMargin = 30;
    private float radius = 10;

    public ViewFlipperIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);

        int width = getWidth();
        float cx = width / 2 - ((radius + innerMargin) * 2 * getChildCount() / 2);
        float cy = getHeight() - bottomMargin;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++) {

            if (i == getDisplayedChild()) {
                paint.setColor(Color.BLACK);
                canvas.drawCircle(cx, cy, radius, paint);

            } else {
                paint.setColor(Color.GRAY);
                canvas.drawCircle(cx, cy, radius, paint);
            }
            cx += 2 * (radius + innerMargin);
        }
        canvas.restore();
    }

    public float getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(float bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    public float getInnerMargin() {
        return innerMargin;
    }

    public void setInnerMargin(float innerMargin) {
        this.innerMargin = innerMargin;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
