package com.android.settings.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class OptionCardView extends LinearLayout {
    private ImageView mCheckView;
    private ImageView mIconView;
    private TextView mTitleView;

    public OptionCardView(Context r2) {
        this(r2, null);
    }

    public OptionCardView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OptionCardView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(R.layout.color_theme_item_layout, this, true);
        this.mIconView = (ImageView) findViewById(R.id.theme_icon);
        this.mTitleView = (TextView) findViewById(R.id.theme_name);
        this.mCheckView = (ImageView) findViewById(R.id.selected_icon);
    }

    public void setTitle(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    public void setTitle(int r1) {
        this.mTitleView.setText(r1);
    }

    public void setIcon(int r1) {
        this.mIconView.setImageResource(r1);
    }

    public void setIcon(Drawable r1) {
        this.mIconView.setImageDrawable(r1);
    }

    public void setCheck(boolean r1) {
        ImageView r0 = this.mCheckView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        ImageView r0 = this.mIconView;
        float r1 = 1.0f;
        if (r5 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        TextView r4 = this.mTitleView;
        if (r5 == true) goto L10;
        r1 = 0.4f;
    L10:
        r4.setAlpha(r1);
        return;
    L5:
        r3 = 0.4f;
        goto L6
    }

    public boolean isChecked() {
        if (this.mCheckView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setSelected(isChecked());
    }
}
