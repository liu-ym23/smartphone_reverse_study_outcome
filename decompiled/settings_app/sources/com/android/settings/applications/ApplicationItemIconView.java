package com.android.settings.applications;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationItemIconView extends RelativeLayout {
    private ImageView mIcon;
    private ImageView mIconBg;
    private ImageView mIconSelected;

    public ApplicationItemIconView(Context r2) {
        this(r2, null);
    }

    public ApplicationItemIconView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ApplicationItemIconView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(R.layout.app_icon, this, true);
        setGravity(16);
        this.mIcon = (ImageView) findViewById(R.id.icon);
        this.mIconBg = (ImageView) findViewById(R.id.icon_bg);
        this.mIconSelected = (ImageView) findViewById(R.id.icon_selected);
    }

    public void setVisible(boolean r1) {
        ImageView r0 = this.mIconSelected;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setIcon(int r1) {
        this.mIcon.setImageResource(r1);
    }

    public void setIcon(Drawable r1) {
        this.mIcon.setImageDrawable(r1);
    }

    public void setIconSelected(int r1) {
        this.mIconSelected.setImageResource(r1);
    }

    public void setIconSelected(Drawable r1) {
        this.mIconSelected.setImageDrawable(r1);
    }

    public void setBg(int r1) {
        this.mIconBg.setBackgroundResource(r1);
    }

    public void setBg(Drawable r1) {
        this.mIconBg.setBackground(r1);
    }

    public ImageView getIcon() {
        return this.mIcon;
    }

    public boolean isChecked() {
        if (this.mIconSelected.getVisibility() != 0) goto L5;
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
