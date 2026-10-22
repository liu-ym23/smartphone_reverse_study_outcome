package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    public MotionTelltales(Context context) {
        super(context);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attrs);
    }

    public MotionTelltales(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = -65281;
        this.mTailScale = 0.25f;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) goto L16;
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.MotionTelltales);
        int r5 = r4.getIndexCount();
        int r0 = 0;
    L4:
        if (r0 >= r5) goto L15;
        int r1 = r4.getIndex(r0);
        if (r1 != R.styleable.MotionTelltales_telltales_tailColor) goto L9;
        this.mTailColor = r4.getColor(r1, this.mTailColor);
    L14:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 != R.styleable.MotionTelltales_telltales_velocityMode) goto L12;
        this.mVelocityMode = r4.getInt(r1, this.mVelocityMode);
        goto L14
    L12:
        if (r1 != R.styleable.MotionTelltales_telltales_tailScale) goto L14;
        this.mTailScale = r4.getFloat(r1, this.mTailScale);
        goto L14
    L15:
        r4.recycle();
    L16:
        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setText(CharSequence text) {
        this.mText = text.toString();
        requestLayout();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        postInvalidate();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.mInvertMatrix);
        if (this.mMotionLayout != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof MotionLayout) == false) goto L17;
        this.mMotionLayout = (MotionLayout) r0;
        return;
    L17:
        return;
    L8:
        int r7 = getWidth();
        int r8 = getHeight();
        float[] r10 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int r12 = 0;
    L9:
        if (r12 >= 5) goto L14;
        float r13 = r10[r12];
        int r14 = 0;
    L11:
        if (r14 >= 5) goto L13;
        float r15 = r10[r14];
        this.mMotionLayout.getViewVelocity(this, r15, r13, this.velocity, this.mVelocityMode);
        this.mInvertMatrix.mapVectors(this.velocity);
        float r17 = r7 * r15;
        float r18 = r8 * r13;
        float[] r1 = this.velocity;
        float r2 = r1[0];
        float r3 = this.mTailScale;
        float r20 = r18 - (r1[1] * r3);
        this.mInvertMatrix.mapVectors(r1);
        canvas.drawLine(r17, r18, r17 - (r2 * r3), r20, this.mPaintTelltales);
        r14 = r14 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
        goto L9
    }
}
