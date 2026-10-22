package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.R;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceImageView extends ImageView {
    private int mMaxHeight;
    private int mMaxWidth;

    public PreferenceImageView(Context r2) {
        this(r2, null);
    }

    public PreferenceImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PreferenceImageView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.PreferenceImageView, r6, 0);
        setMaxWidth(r7.getDimensionPixelSize(R.styleable.PreferenceImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(r7.getDimensionPixelSize(R.styleable.PreferenceImageView_maxHeight, Integer.MAX_VALUE));
        r7.recycle();
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int r1) {
        this.mMaxWidth = r1;
        super.setMaxWidth(r1);
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int r1) {
        this.mMaxHeight = r1;
        super.setMaxHeight(r1);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getMode(r6);
        if (r0 == Integer.MIN_VALUE) goto L5;
        if (r0 == 0) goto L5;
    L10:
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L13;
        if (r1 == 0) goto L13;
    L18:
        super.onMeasure(r6, r7);
        return;
    L13:
        int r3 = View.MeasureSpec.getSize(r7);
        int r4 = getMaxHeight();
        if (r4 == Integer.MAX_VALUE) goto L18;
        if (r4 < r3) goto L17;
        if (r1 != 0) goto L18;
    L17:
        r7 = View.MeasureSpec.makeMeasureSpec(r4, Integer.MIN_VALUE);
    L5:
        int r5 = View.MeasureSpec.getSize(r6);
        int r8 = getMaxWidth();
        if (r8 == Integer.MAX_VALUE) goto L10;
        if (r8 < r5) goto L9;
        if (r0 != 0) goto L10;
    L9:
        r6 = View.MeasureSpec.makeMeasureSpec(r8, Integer.MIN_VALUE);
        goto L10
    }
}
