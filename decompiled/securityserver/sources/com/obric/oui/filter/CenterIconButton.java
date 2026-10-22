package com.obric.oui.filter;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class CenterIconButton extends AppCompatButton {
    public Rect b;
    public int c;
    public int e;

    private int getTextWidth() {
        if (this.b != null) goto L5;
        this.b = new Rect();
    L5:
        TextPaint r0 = getPaint();
        String r1 = getText().toString();
        if (r1.isEmpty() == false) goto L8;
        String r2 = "";
    L28:
        Log.d("CenterIconButton", "text:" + r2);
        r0.getTextBounds(r2, 0, r2.length(), this.b);
        Log.d("CenterIconButton", "textHeight" + this.b.height());
        return this.b.width();
    L8:
        ArrayList r3 = new ArrayList();
        StringTokenizer r4 = new StringTokenizer(r1, "\n", false);
    L10:
        if (r4.hasMoreTokens() == false) goto L13;
        r3.add(r4.nextToken());
        goto L10
    L13:
        if (r3.size() == 1) goto L15;
        r2 = (String) r3.get(0);
        int r5 = 0;
    L20:
        if (r5 >= (r3.size() - 1)) goto L26;
        int r6 = r5 + 1;
        if (((String) r3.get(r6)).length() <= ((String) r3.get(r5)).length()) goto L24;
        r2 = (String) r3.get(r6);
    L24:
        r5 = r6;
        goto L20
    L26:
        if (isAllCaps() == false) goto L28;
        r2 = r2.toUpperCase();
        goto L28
    L15:
        if (isAllCaps() == false) goto L17;
        r2 = ((String) r3.get(0)).toUpperCase();
        goto L28
    L17:
        r2 = (String) r3.get(0);
        goto L28
    }

    public final void a(int r10) {
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
        Log.d("CenterIconButton", "leftPadding:" + this.c);
        Log.d("CenterIconButton", "rightPadding:" + this.e);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.c, r11));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r11, this.e));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.c, r11), getPaddingTop(), Math.max(r11, this.e), getPaddingBottom());
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

    @Override // android.widget.TextView
    public final boolean isAllCaps() {
        TransformationMethod r1 = getTransformationMethod();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a(r1);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        a(getMeasuredWidth());
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        a(getMeasuredWidth());
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        this.c = r1;
        this.e = r3;
        a(getMeasuredWidth());
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);
        a(getMeasuredWidth());
    }
}
