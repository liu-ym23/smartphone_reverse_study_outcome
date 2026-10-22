package obric.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class FontFitTextView extends TextView {
    private float mFitMinSize;
    private final Paint mFitPaint;

    public FontFitTextView(Context context) {
        this(context, null);
    }

    public FontFitTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontFitTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mFitPaint = new Paint();
        this.mFitMinSize = getContext().getResources().getDimension(R.dimen.font_fit_min_size);
    }

    public void setMinTextSize(float px) {
        this.mFitMinSize = px;
        if (px <= getTextSize()) goto L5;
        setTextSize(0, px);
    L5:
        refitText(getText().toString(), getWidth());
    }

    private void refitText(String text, int textWidth) {
        if (textWidth > 0) goto L4;
        return;
    L4:
        if (this.mFitPaint == null) goto L45;
        int r7 = (textWidth - getPaddingLeft()) - getPaddingRight();
        this.mFitPaint.set(getPaint());
        float r8 = r7;
        if (this.mFitPaint.measureText(text) <= r8) goto L43;
        float r0 = getTextSize();
        float r1 = this.mFitMinSize;
        if (r0 > r1) goto L11;
        return;
    L11:
        if ((r0 - r1) <= 0.5f) goto L17;
        float r2 = (r0 + r1) / 2.0f;
        this.mFitPaint.setTextSize(r2);
        if (this.mFitPaint.measureText(text) >= r8) goto L14;
        r1 = r2;
        goto L11
    L14:
        r0 = r2;
        goto L11
    L17:
        if (r1 <= (this.mFitMinSize + 0.5f)) goto L28;
        float r6 = getMeasuredHeight();
        if (getFontHeight() <= r6) goto L28;
        float r9 = this.mFitMinSize;
    L22:
        if ((r1 - r9) <= 0.5f) goto L27;
        float r3 = (r1 + r9) / 2.0f;
        this.mFitPaint.setTextSize(r3);
        if (getFontHeight() >= r6) goto L25;
        r9 = r3;
        goto L22
    L25:
        r1 = r3;
        goto L22
    L27:
        r1 = r9;
    L28:
        setTextSize(0, r1);
        return;
    L43:
        return;
    }

    private float getFontHeight() {
        Paint.FontMetrics r1 = this.mFitPaint.getFontMetrics();
        return r1.bottom - r1.top;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        refitText(getText().toString(), getMeasuredWidth());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(final CharSequence text, final int start, final int before, final int after) {
        refitText(text.toString(), getWidth());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w == oldw) goto L5;
        refitText(getText().toString(), w);
        return;
    }
}
