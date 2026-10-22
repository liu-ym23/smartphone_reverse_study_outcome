package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.common.widget.ClickEffectTouchListener;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {
    public final ImageView c;
    public final ImageView e;
    public OnTitleBarClickListener f;
    public final View i;
    public final TextView j;

    public ONormalTitleBar(Context r7, AttributeSet r8) {
        int r0 = 0;
        super(r7, r8, 0);
        if (getBackground() != null) goto L5;
        setBackgroundColor(ContextCompat.getColor(r7, R.color.BGPrimary));
    L5:
        View.inflate(r7, R.layout.o_view_normal_title_bar, this);
        this.c = (ImageView) findViewById(R.id.back_btn);
        this.b = (TextView) findViewById(R.id.title);
        this.e = (ImageView) findViewById(R.id.right_btn);
        this.i = findViewById(R.id.line);
        this.j = (TextView) findViewById(R.id.text_left);
        this.c.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.j.setOnClickListener(this);
        ClickEffectTouchListener r1 = new ClickEffectTouchListener();
        r1.b = 0.5f;
        r1.c = 1.0f;
        this.c.setOnTouchListener(r1);
        this.e.setOnTouchListener(r1);
        this.j.setOnTouchListener(r1);
        if (r8 == null) goto L19;
        TypedArray r9 = r7.obtainStyledAttributes(r8, com.obric.common.oui.R.styleable.m);
        String r2 = r9.getString(0);
        float r3 = r9.getDimension(2, OUnitExtensionKt.a(17));
        int r4 = r9.getColor(1, ContextCompat.getColor(r7, R.color.TextPrimary));
        this.b.setText(r2);
        this.b.setTextSize(0, r3);
        this.b.setTextColor(r4);
        Drawable r5 = r9.getDrawable(5);
        if (r9.hasValue(6) == false) goto L11;
        if (r5 == null) goto L11;
        int r6 = r9.getColor(6, 0);
        r5 = r5.mutate();
        DrawableCompat.setTint(r5, r6);
    L11:
        if (r5 == null) goto L13;
        this.e.setImageDrawable(r5);
    L13:
        boolean r10 = r9.getBoolean(4, true);
        View r11 = this.i;
        if (r10 == true) goto L17;
        r0 = 8;
    L17:
        r11.setVisibility(r0);
        this.i.setBackgroundColor(r9.getColor(3, ContextCompat.getColor(r7, R.color.LinePrimary)));
        r9.recycle();
        return;
    }

    public ImageView getEndBtn() {
        return this.e;
    }

    public ImageView getStartBtn() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        ViewExtensionsKt.b(getStartBtn(), OUnitExtensionKt.a(44), OUnitExtensionKt.a(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        ViewExtensionsKt.b(getEndBtn(), OUnitExtensionKt.a(44), OUnitExtensionKt.a(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.f != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L7;
    L12:
        this.f.b();
        return;
    L7:
        if (r3.getId() == R.id.text_left) goto L12;
        if (r3.getId() != R.id.right_btn) goto L15;
        this.f.a();
        return;
    }

    public void setCenterText(CharSequence r1) {
        this.b.setText(r1);
    }

    public void setDividerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.i.getLayoutParams();
        r0.height = r2;
        this.i.setLayoutParams(r0);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r1) {
        this.i.setBackgroundColor(r1);
    }

    public void setEndBtnIcon(@DrawableRes int r1) {
        this.e.setImageResource(r1);
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.f = r1;
    }

    public void setStartBtnIcon(@DrawableRes int r1) {
        this.c.setImageResource(r1);
    }

    public void setStartText(String r3) {
        this.c.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setText(r3);
    }

    public void setStartTextSize(float r2) {
        this.j.setTextSize(0, r2);
    }
}
