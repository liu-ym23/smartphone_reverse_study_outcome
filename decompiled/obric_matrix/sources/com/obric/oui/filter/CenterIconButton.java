package com.obric.oui.filter;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class CenterIconButton extends AppCompatButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f10975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f10976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f10977h;

    private String a() {
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

    private void b() {
        c(getMeasuredWidth());
    }

    private void c(int r10) {
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
        int r11 = (((r10 - r7) - r8) - r5) - (r6 * 4);
    L25:
        int r12 = r11 / 2;
        Log.d("CenterIconButton", "paddingSize:" + r12);
        Log.d("CenterIconButton", "leftPadding:" + this.f10976g);
        Log.d("CenterIconButton", "rightPadding:" + this.f10977h);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.f10976g, r12));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r12, this.f10977h));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.f10976g, r12), getPaddingTop(), Math.max(r12, this.f10977h), getPaddingBottom());
        return;
    L21:
        if (r3 == null) goto L23;
        int r13 = r10 - r7;
    L24:
        r11 = (r13 - r6) - r5;
        goto L25
    L23:
        r13 = r10 - r8;
        goto L24
    L17:
        r8 = r1.getBounds().width();
        goto L18
    L14:
        r7 = r3.getBounds().width();
        goto L15
    }

    private int getTextWidth() {
        if (this.f10975f != null) goto L5;
        this.f10975f = new Rect();
    L5:
        TextPaint r0 = getPaint();
        String r1 = a();
        Log.d("CenterIconButton", "text:" + r1);
        r0.getTextBounds(r1, 0, r1.length(), this.f10975f);
        Log.d("CenterIconButton", "textHeight" + this.f10975f.height());
        return this.f10975f.width();
    }

    @Override // android.widget.TextView
    public boolean isAllCaps() {
        TransformationMethod r1 = getTransformationMethod();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        c(r1);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        b();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r1, @Nullable Drawable r2, @Nullable Drawable r3, @Nullable Drawable r4) {
        super.setCompoundDrawablesWithIntrinsicBounds(r1, r2, r3, r4);
        b();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        this.f10976g = r1;
        this.f10977h = r3;
        b();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r1, TextView.BufferType r2) {
        super.setText(r1, r2);
        b();
    }
}
