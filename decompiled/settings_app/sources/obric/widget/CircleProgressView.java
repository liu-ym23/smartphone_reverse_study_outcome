package obric.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class CircleProgressView extends View {
    private static final String TAG = "CircleView";
    private Drawable mCircleDrawable;
    private int mHeight;
    private Bitmap mMastBitmap;
    private Paint mPaint;
    private Rect mRect;
    private float mSweepAngle;
    private int mWidth;
    private final Xfermode mXfermode;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        init();
    }

    private void init() {
        this.mCircleDrawable = getResources().getDrawable(R.drawable.circle);
        this.mMastBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.circle_mask)).getBitmap();
        int r0 = getResources().getDimensionPixelSize(R.dimen.circle_progress_view_size);
        this.mWidth = r0;
        this.mHeight = r0;
        this.mRect = new Rect(0, 0, this.mWidth, this.mHeight);
        Paint r1 = new Paint();
        this.mPaint = r1;
        r1.setColor(getResources().getColor(R.color.circle_progress_view_arc_color));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r0 = canvas.saveLayer(0.0f, 0.0f, this.mWidth, this.mHeight, null, 31);
        canvas.drawArc(0.0f, 0.0f, this.mWidth, this.mHeight, -90.0f, this.mSweepAngle, true, this.mPaint);
        this.mPaint.setXfermode(this.mXfermode);
        canvas.drawBitmap(this.mMastBitmap, null, this.mRect, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(r0);
        this.mCircleDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mCircleDrawable.draw(canvas);
    }

    public int getCircleWidth() {
        return this.mWidth;
    }

    public int getCircleHeight() {
        return this.mHeight;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.mSweepAngle = sweepAngle;
        invalidate();
    }

    public void reset() {
        setSweepAngle(0.0f);
    }
}
