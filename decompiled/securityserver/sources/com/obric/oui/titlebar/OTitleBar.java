package com.obric.oui.titlebar;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OTitleBar extends FrameLayout {
    public TextView b;

    public TextView getTitleView() {
        return this.b;
    }

    public abstract void setDividerLineBackground(@ColorInt int r1);

    public void setTitle(CharSequence r1) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitleColor(@ColorInt int r1) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextColor(r1);
    }

    public void setTitleSize(float r1) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextSize(r1);
    }

    public void setTitleSizePixel(float r2) {
        TextView r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTextSize(0, r2);
    }

    public void setTitle(@StringRes int r1) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }
}
