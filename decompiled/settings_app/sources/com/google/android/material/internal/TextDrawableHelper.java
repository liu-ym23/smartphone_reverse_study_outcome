package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class TextDrawableHelper {
    private WeakReference<TextDrawableDelegate> delegate;
    private final TextAppearanceFontCallback fontCallback;
    private TextAppearance textAppearance;
    private final TextPaint textPaint;
    private float textWidth;
    private boolean textWidthDirty;

    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] r1);

        void onTextSizeChange();
    }

    static /* synthetic */ boolean access$002(TextDrawableHelper r0, boolean r1) {
        r0.textWidthDirty = r1;
        return r1;
    }

    static /* synthetic */ WeakReference access$100(TextDrawableHelper r0) {
        return r0.delegate;
    }

    public TextDrawableHelper(TextDrawableDelegate r3) {
        this.textPaint = new TextPaint(1);
        this.fontCallback = new AnonymousClass1(this);
        this.textWidthDirty = true;
        this.delegate = new WeakReference(null);
        setDelegate(r3);
    }

    public void setDelegate(TextDrawableDelegate r2) {
        this.delegate = new WeakReference(r2);
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public void setTextWidthDirty(boolean r1) {
        this.textWidthDirty = r1;
    }

    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    public float getTextWidth(String r2) {
        if (this.textWidthDirty == false) goto L5;
        float r3 = calculateTextWidth(r2);
        this.textWidth = r3;
        this.textWidthDirty = false;
        return r3;
    L5:
        return this.textWidth;
    }

    private float calculateTextWidth(CharSequence r3) {
        if (r3 != null) goto L6;
        return 0.0f;
    L6:
        return this.textPaint.measureText(r3, 0, r3.length());
    }

    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public void setTextAppearance(TextAppearance r3, Context r4) {
        if (this.textAppearance == r3) goto L14;
        this.textAppearance = r3;
        if (r3 == null) goto L10;
        r3.updateMeasureState(r4, this.textPaint, this.fontCallback);
        TextDrawableDelegate r0 = this.delegate.get();
        if (r0 == null) goto L9;
        TextPaint r1 = this.textPaint;
        r1.drawableState = r0.getState();
    L9:
        r3.updateDrawState(r4, this.textPaint, this.fontCallback);
        this.textWidthDirty = true;
    L10:
        TextDrawableDelegate r2 = this.delegate.get();
        if (r2 == null) goto L15;
        r2.onTextSizeChange();
        r2.onStateChange(r2.getState());
        return;
    L15:
        return;
    }

    public void updateTextPaintDrawState(Context r3) {
        this.textAppearance.updateDrawState(r3, this.textPaint, this.fontCallback);
    }
}
