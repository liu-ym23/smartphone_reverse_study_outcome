package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SettingItemTextVertical extends SettingItemText {
    private FrameLayout framelayout;
    private ImageView mArrow;
    private ImageView mIcon;
    private ImageView mIconFrame;
    private TextView mTitle;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return 0;
    }

    @Override // obric.widget.SettingItemText, obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.lock_screen_mode_item_layout;
    }

    public SettingItemTextVertical(Context r2) {
        this(r2, null);
    }

    public SettingItemTextVertical(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingItemTextVertical(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        setGravity(16);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SettingItemTextVertical, r5, 0);
        Drawable r7 = r6.getDrawable(2);
        if (r7 != null) goto L5;
        this.mIcon.setVisibility(8);
        this.framelayout.setVisibility(8);
    L6:
        Drawable r8 = r6.getDrawable(3);
        if (r8 == null) goto L9;
        this.mIconFrame.setImageDrawable(r8);
    L9:
        this.mTitle.setText(r6.getText(7));
        setSummary(r6.getText(5));
        setSubtitle("");
        this.mSummary.setSingleLine(r6.getBoolean(4, true));
        this.mSummary.setTextSize(0, getResources().getDimension(R.dimen.settings_item_sub_title_size));
        r6.recycle();
        setMidContentPaddingLeft(0);
        return;
    L5:
        this.mIcon.setImageDrawable(r7);
        goto L6
    }

    @Override // obric.widget.SettingItemText, obric.widget.ListContentItem
    protected void initMidWidget() {
        this.framelayout = (FrameLayout) findViewById(R.id.frame_layout);
        this.mIcon = (ImageView) findViewById(R.id.item_icon);
        this.mIconFrame = (ImageView) findViewById(R.id.item_icon_frame);
        this.mTitle = (TextView) findViewById(R.id.item_title);
        this.mSummary = (TextView) findViewById(R.id.item_subtitle);
    }

    @Override // obric.widget.ListContentItemText, obric.widget.ListContentItem
    protected void initRightWidget() {
        super.initRightWidget();
        this.mArrow = (ImageView) findViewById(R.id.arrow);
    }

    @Override // obric.widget.ListContentItem
    public CharSequence getTitle() {
        TextView r0 = this.mTitle;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    @Override // obric.widget.ListContentItem
    public ImageView getIconView() {
        return this.mIcon;
    }

    public void setIconScale(int r4, int r5) {
        this.mIcon.setLayoutParams(new FrameLayout.LayoutParams(r4, r5, 17));
        this.mIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void setIcon(Bitmap r1) {
        ImageView r0 = this.mIcon;
        if (r0 == null) goto L6;
        r0.setImageBitmap(r1);
        return;
    }

    @Override // obric.widget.ListContentItem
    public void setIcon(Drawable r1) {
        ImageView r0 = this.mIcon;
        if (r0 == null) goto L6;
        r0.setImageDrawable(r1);
        return;
    }

    @Override // obric.widget.ListContentItem
    public TextView getSummaryView() {
        return this.mSummary;
    }

    @Override // obric.widget.ListContentItemText, obric.widget.ListContentItem
    public void setSummary(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.mSummary.setVisibility(8);
        return;
    L5:
        this.mSummary.setText(r2);
        this.mSummary.setVisibility(0);
    }

    @Override // obric.widget.ListContentItem
    public void setSummary(int r2) {
        setSummary(getResources().getString(r2));
    }

    @Override // obric.widget.ListContentItemText
    public void setArrowVisible(boolean r1) {
        ImageView r0 = this.mArrow;
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
    public void setSelected(boolean r1) {
        super.setSelected(r1);
        ImageView r0 = this.mArrow;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 0;
    L7:
        r0.setVisibility(r2);
        return;
    L6:
        r2 = 8;
        goto L7
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setSelected(isSelected());
    }
}
