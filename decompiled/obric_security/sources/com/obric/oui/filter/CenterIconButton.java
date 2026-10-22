package com.obric.oui.filter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class CenterIconButton extends AppCompatButton {
    private static final String DELIMITERS = "\n";
    private static final int DRAWABLES_LENGTH = 4;
    private static final int DRAWABLE_BOTTOM_POSITION = 3;
    private static final int DRAWABLE_LEFT_POSITION = 0;
    private static final int DRAWABLE_RIGHT_POSITION = 2;
    private static final int DRAWABLE_TOP_POSITION = 1;
    protected int mDrawableSize;
    protected int mLeftPadding;
    protected int mRightPadding;
    protected int mTintColor;
    private Rect textBoundsRect;

    public CenterIconButton(Context r2) {
        super(r2);
        this.mTintColor = 0;
        init(r2, null);
    }

    public CenterIconButton(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mTintColor = 0;
        init(r2, r3);
    }

    public CenterIconButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mTintColor = 0;
        init(r1, r2);
    }

    private void init(Context r2, AttributeSet r3) {
        if (r3 == null) goto L4;
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.OCenterIconButton);
        this.mTintColor = r4.getColor(R.styleable.OCenterIconButton_oui_drawableTint, 0);
        this.mDrawableSize = r4.getDimensionPixelSize(R.styleable.OCenterIconButton_oui_drawableSize, OUnitExtensionKt.dp2px(12));
        setCompoundDrawablePadding((int) r4.getDimension(R.styleable.OCenterIconButton_android_drawablePadding, OUnitExtensionKt.dp2px(4)));
        updateDrawables();
        r4.recycle();
    L4:
        this.mLeftPadding = getPaddingLeft();
        this.mRightPadding = getPaddingRight();
    }

    public void updateDrawables() {
        if (this.mTintColor == 0) goto L5;
    L6:
        Drawable[] r0 = getCompoundDrawables();
        if (r0.length == 4) goto L9;
        return;
    L9:
        Drawable[] r1 = new Drawable[4];
        int r4 = 0;
    L10:
        if (r4 >= 4) goto L22;
        Drawable r5 = r0[r4];
        if (r5 == null) goto L20;
        if (this.mTintColor == 0) goto L17;
        r5 = getTintedDrawable(r5);
    L17:
        if (this.mDrawableSize <= 0) goto L19;
        r5 = updateDrawableBounds(r5);
    L19:
        r1[r4] = r5;
    L20:
        r4 = r4 + 1;
        goto L10
    L22:
        if (this.mDrawableSize <= 0) goto L24;
        setCompoundDrawables(r1[0], r1[1], r1[2], r1[3]);
        return;
    L24:
        setCompoundDrawablesWithIntrinsicBounds(r1[0], r1[1], r1[2], r1[3]);
        return;
    L5:
        if (this.mDrawableSize != (-1)) goto L6;
    }

    private Drawable getTintedDrawable(Drawable r1) {
        Drawable r2 = DrawableCompat.wrap(r1).mutate();
        DrawableCompat.setTint(r2, this.mTintColor);
        return r2;
    }

    private Drawable updateDrawableBounds(Drawable r3) {
        Rect r0 = r3.getBounds();
        int r2 = this.mDrawableSize;
        r0.set(0, 0, r2, r2);
        return r3;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);
        updatePadding();
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updatePadding(r1);
    }

    private void updatePadding() {
        updatePadding(getMeasuredWidth());
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        this.mLeftPadding = r1;
        this.mRightPadding = r3;
        updatePadding();
    }

    private void updatePadding(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        Drawable[] r0 = getCompoundDrawables();
        if (r0.length == 4) goto L7;
        return;
    L7:
        Drawable r3 = r0[0];
        Drawable r1 = r0[2];
        if (r3 != null) goto L11;
        if (r1 != null) goto L11;
        return;
    L11:
        int r5 = getTextWidth();
        int r6 = Math.max(getCompoundDrawablePadding(), 1);
        if (r3 != null) goto L14;
        int r7 = 0;
    L15:
        if (r1 != null) goto L17;
        int r8 = 0;
    L18:
        if (r3 == null) goto L21;
        if (r1 == null) goto L21;
        int r11 = ((((r10 - r7) - r8) - r5) - (r6 * 4)) / 2;
    L24:
        Log.d("CenterIconButton", "paddingSize:" + r11);
        Log.d("CenterIconButton", "leftPadding:" + this.mLeftPadding);
        Log.d("CenterIconButton", "rightPadding:" + this.mRightPadding);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.mLeftPadding, r11));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r11, this.mRightPadding));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.mLeftPadding, r11), getPaddingTop(), Math.max(r11, this.mRightPadding), getPaddingBottom());
        return;
    L21:
        if (r3 == null) goto L23;
        r11 = (((r10 - r7) - r6) - r5) / 2;
        goto L24
    L23:
        r11 = (((r10 - r8) - r6) - r5) / 2;
        goto L24
    L17:
        r8 = r1.getBounds().width();
        goto L18
    L14:
        r7 = r3.getBounds().width();
        goto L15
    }

    private int getTextWidth() {
        if (this.textBoundsRect != null) goto L5;
        this.textBoundsRect = new Rect();
    L5:
        TextPaint r0 = getPaint();
        String r1 = divideText();
        Log.d("CenterIconButton", "text:" + r1);
        r0.getTextBounds(r1, 0, r1.length(), this.textBoundsRect);
        Log.d("CenterIconButton", "textHeight" + this.textBoundsRect.height());
        return this.textBoundsRect.width();
    }

    private String divideText() {
        String r0 = getText().toString();
        if (r0.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r1 = new ArrayList();
        int r4 = 0;
        StringTokenizer r2 = new StringTokenizer(r0, "\n", false);
    L8:
        if (r2.hasMoreTokens() == false) goto L11;
        r1.add(r2.nextToken());
        goto L8
    L11:
        if (r1.size() == 1) goto L13;
        String r3 = (String) r1.get(0);
    L19:
        if (r4 >= (r1.size() - 1)) goto L25;
        int r5 = r4 + 1;
        if (((String) r1.get(r5)).length() <= ((String) r1.get(r4)).length()) goto L23;
        r3 = (String) r1.get(r5);
    L23:
        r4 = r5;
        goto L19
    L25:
        if (isAllCaps() == true) goto L27;
        return r3;
    L27:
        return r3.toUpperCase();
    L13:
        if (isAllCaps() == false) goto L16;
        return ((String) r1.get(0)).toUpperCase();
    L16:
        return (String) r1.get(0);
    }

    @Override // android.widget.TextView
    public boolean isAllCaps() {
        TransformationMethod r1 = getTransformationMethod();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }
}
