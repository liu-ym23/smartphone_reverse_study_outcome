package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class RoundedRectLinearLayout extends LinearLayout {
    private Path mClip;
    private float mRadius;

    public RoundedRectLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RoundedRectLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs == null) goto L5;
        TypedArray r4 = getContext().obtainStyledAttributes(attrs, R.styleable.RoundedRectLinearLayout, 0, 0);
        this.mRadius = r4.getDimensionPixelSize(R.styleable.RoundedRectLinearLayout_cornerRadius, 0);
        r4.recycle();
        return;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.mRadius <= 0.0f) goto L6;
        this.mClip = new Path();
        RectF r3 = new RectF(0.0f, 0.0f, w, h);
        Path r1 = this.mClip;
        float r0 = this.mRadius;
        r1.addRoundRect(r3, r0, r0, Path.Direction.CW);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int r0 = canvas.save();
        if (this.mRadius <= 0.0f) goto L5;
        canvas.clipPath(this.mClip);
    L5:
        super.dispatchDraw(canvas);
        canvas.restoreToCount(r0);
    }
}
