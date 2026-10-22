package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes.dex */
public class CustomNavbarStyleView extends LinearLayout {
    private ImageView mBackIcon;
    private OCheckBox mCheckBox;
    private ImageView mHomeIcon;
    private OnCustomStyleCheckedChangeListener mListener;
    private ImageView mMenuIcon;

    public interface OnCustomStyleCheckedChangeListener {
        void onCustomStyleSelected(CustomNavbarStyleView r1, boolean r2);
    }

    public CustomNavbarStyleView(Context r2) {
        this(r2, null);
    }

    public CustomNavbarStyleView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CustomNavbarStyleView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
    }

    private void init(Context r3) {
        LayoutInflater.from(r3).inflate(R.layout.navbar_custom_style_layout, this, true);
        this.mBackIcon = (ImageView) findViewById(R.id.custom_back_icon);
        this.mHomeIcon = (ImageView) findViewById(R.id.custom_home_icon);
        this.mMenuIcon = (ImageView) findViewById(R.id.custom_menu_icon);
        OCheckBox r4 = (OCheckBox) findViewById(R.id.custom_style_checkbox);
        this.mCheckBox = r4;
        r4.setClickable(false);
        setOnClickListener(new CustomNavbarStyleView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$init$0$com-android-settings-widget-CustomNavbarStyleView, reason: not valid java name */
    /* synthetic */ void m650lambda$init$0$comandroidsettingswidgetCustomNavbarStyleView(View r2) {
        toggleSelection();
        OnCustomStyleCheckedChangeListener r3 = this.mListener;
        if (r3 == null) goto L6;
        r3.onCustomStyleSelected(this, this.mCheckBox.isChecked());
        return;
    }

    @Override // android.view.View
    public void setSelected(boolean r1) {
        this.mCheckBox.setChecked(r1);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.mCheckBox.isChecked();
    }

    public void setOnCustomStyleCheckedChangeListener(OnCustomStyleCheckedChangeListener r1) {
        this.mListener = r1;
    }

    private void toggleSelection() {
        if (this.mCheckBox.isChecked() == true) goto L6;
        setSelected(true);
        return;
    }

    public void setBackIconResource(int r1) {
        this.mBackIcon.setImageResource(r1);
    }

    public void setHomeIconResource(int r1) {
        this.mHomeIcon.setImageResource(r1);
    }

    public void setMenuIconResource(int r1) {
        this.mMenuIcon.setImageResource(r1);
    }

    public void reverseBgResource() {
        this.mBackIcon.setImageResource(R.drawable.icon_nav_menu);
        this.mMenuIcon.setImageResource(R.drawable.icon_nav_back);
    }
}
