package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OTitleBar extends FrameLayout {
    protected static final int DEFAULT_BUTTON_TEXT_SIZE = 15;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 17;
    protected TextView mTitleView;

    public abstract void setDividerLineBackground(int r1);

    public abstract void showDividerLine(boolean r1);

    public OTitleBar(Context r1) {
        super(r1);
    }

    public OTitleBar(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public OTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r1, R.color.BGPrimary));
        return;
    }

    public void setTitle(CharSequence r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitle(int r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitleColor(int r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextColor(r1);
    }

    public void setTitleSize(float r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextSize(r1);
    }

    public void setTitleSizePixel(float r2) {
        TextView r1 = this.mTitleView;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTextSize(0, r2);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }
}
