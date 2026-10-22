package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.c;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.common.oui.k;
import com.obric.oui.common.util.j;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ONormalTitleBar extends b implements View.OnClickListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f11526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f11527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.obric.oui.titlebar.c.a f11528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f11529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f11530k;

    public ONormalTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ONormalTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
        if (r2 == null) goto L6;
        b(r1, r2);
        return;
    }

    private void a(Context r3) {
        FrameLayout.inflate(r3, g.x, this);
        this.f11526g = (ImageView) findViewById(f.v);
        this.f11546f = (TextView) findViewById(f.S0);
        this.f11527h = (ImageView) findViewById(f.J0);
        this.f11529j = findViewById(f.c0);
        this.f11530k = (TextView) findViewById(f.R0);
        this.f11526g.setOnClickListener(this);
        this.f11527h.setOnClickListener(this);
        this.f11530k.setOnClickListener(this);
        d.g.d.b.c.a r4 = new d.g.d.b.c.a(0.5f, 1.0f);
        this.f11526g.setOnTouchListener(r4);
        this.f11527h.setOnTouchListener(r4);
        this.f11530k.setOnTouchListener(r4);
    }

    private void b(Context r5, AttributeSet r6) {
        TypedArray r7 = r5.obtainStyledAttributes(r6, k.y0);
        String r0 = r7.getString(k.z0);
        float r1 = r7.getDimension(k.B0, com.obric.oui.common.util.f.a(17));
        int r2 = r7.getColor(k.A0, ContextCompat.getColor(r5, c.p));
        this.f11546f.setText(r0);
        int r3 = 0;
        this.f11546f.setTextSize(0, r1);
        this.f11546f.setTextColor(r2);
        Drawable r4 = r7.getDrawable(k.E0);
        int r8 = k.F0;
        if (r7.hasValue(r8) == false) goto L6;
        if (r4 == null) goto L6;
        int r9 = r7.getColor(r8, 0);
        r4 = r4.mutate();
        DrawableCompat.setTint(r4, r9);
    L6:
        if (r4 == null) goto L8;
        this.f11527h.setImageDrawable(r4);
    L8:
        boolean r10 = r7.getBoolean(k.D0, true);
        View r11 = this.f11529j;
        if (r10 == true) goto L12;
        r3 = 8;
    L12:
        r11.setVisibility(r3);
        this.f11529j.setBackgroundColor(r7.getColor(k.C0, ContextCompat.getColor(r5, c.f8213l)));
        r7.recycle();
    }

    public ImageView getEndBtn() {
        return this.f11527h;
    }

    public ImageView getStartBtn() {
        return this.f11526g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        j.b(getStartBtn(), com.obric.oui.common.util.f.a(44), com.obric.oui.common.util.f.a(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        j.b(getEndBtn(), com.obric.oui.common.util.f.a(44), com.obric.oui.common.util.f.a(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.f11528i != null) goto L5;
        return;
    L5:
        if (r3.getId() != f.v) goto L7;
    L12:
        this.f11528i.b(r3);
        return;
    L7:
        if (r3.getId() == f.R0) goto L12;
        if (r3.getId() != f.J0) goto L15;
        this.f11528i.a(r3);
        return;
    }

    public void setCenterText(CharSequence r1) {
        this.f11546f.setText(r1);
    }

    public void setDividerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.f11529j.getLayoutParams();
        r0.height = r2;
        this.f11529j.setLayoutParams(r0);
    }

    @Override // com.obric.oui.titlebar.b
    public void setDividerLineBackground(@ColorInt int r1) {
        this.f11529j.setBackgroundColor(r1);
    }

    public void setEndBtnIcon(@DrawableRes int r1) {
        this.f11527h.setImageResource(r1);
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.c.a r1) {
        this.f11528i = r1;
    }

    public void setStartBtnIcon(@DrawableRes int r1) {
        this.f11526g.setImageResource(r1);
    }

    public void setStartText(String r3) {
        this.f11526g.setVisibility(8);
        this.f11530k.setVisibility(0);
        this.f11530k.setText(r3);
    }

    public void setStartTextSize(float r2) {
        this.f11530k.setTextSize(0, r2);
    }
}
