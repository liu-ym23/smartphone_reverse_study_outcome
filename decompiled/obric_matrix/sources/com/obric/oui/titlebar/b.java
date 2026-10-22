package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected TextView f11546f;

    public b(@NonNull Context r1, @Nullable AttributeSet r2) {
        super(r1, r2);
    }

    public b(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r1, c.f8208g));
        return;
    }

    public TextView getTitleView() {
        return this.f11546f;
    }

    public abstract void setDividerLineBackground(@ColorInt int r1);

    public void setTitle(@StringRes int r1) {
        TextView r0 = this.f11546f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitle(CharSequence r1) {
        TextView r0 = this.f11546f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitleColor(@ColorInt int r1) {
        TextView r0 = this.f11546f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextColor(r1);
    }

    public void setTitleSize(float r1) {
        TextView r0 = this.f11546f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextSize(r1);
    }

    public void setTitleSizePixel(float r2) {
        TextView r1 = this.f11546f;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTextSize(0, r2);
    }
}
