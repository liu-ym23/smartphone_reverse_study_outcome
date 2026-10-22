package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class PreviewOptionItemView extends LinearLayout {
    private int mActiveColor;
    private int mCurrentDisactiveColor;
    private int mDisactiveColor;
    private FrameLayout mIconAreaLayout;
    private boolean mIsActive;
    private ImageView mItemIcon;
    private ImageView mSelectedIcon;
    private TextView mTitle;

    public PreviewOptionItemView(Context r2) {
        this(r2, null);
    }

    public PreviewOptionItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PreviewOptionItemView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        setOrientation(1);
        setGravity(17);
        View r1 = LayoutInflater.from(r4).inflate(R.layout.preview_option_item_layout, this, true);
        this.mIconAreaLayout = (FrameLayout) r1.findViewById(R.id.icon_area_layout);
        this.mItemIcon = (ImageView) r1.findViewById(R.id.item_img);
        this.mSelectedIcon = (ImageView) r1.findViewById(R.id.selected_img);
        this.mTitle = (TextView) r1.findViewById(R.id.title);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.PreviewOptionItemView, r6, 0);
        String r8 = r7.getString(2);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        this.mTitle.setText(r8);
    L5:
        Drawable r9 = r7.getDrawable(0);
        if (r9 == null) goto L8;
        this.mItemIcon.setImageDrawable(r9);
    L8:
        Drawable r10 = r7.getDrawable(1);
        if (r10 == null) goto L11;
        this.mSelectedIcon.setImageDrawable(r10);
    L11:
        this.mActiveColor = getResources().getColor(R.color.preview_option_item_title_active);
        this.mDisactiveColor = getResources().getColor(R.color.preview_option_item_title_disactive);
        this.mCurrentDisactiveColor = getResources().getColor(R.color.preview_option_item_title_disactive_current);
        setActive(false);
        r7.recycle();
    }

    public void setTitle(CharSequence r1) {
        this.mTitle.setText(r1);
    }

    public void setTitle(int r1) {
        this.mTitle.setText(r1);
    }

    public void setItemImageRes(int r1) {
        this.mItemIcon.setImageResource(r1);
    }

    public void setItemImage(Drawable r1) {
        this.mItemIcon.setImageDrawable(r1);
    }

    public void setIconSize(int r2, int r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.mItemIcon.getLayoutParams();
        r0.width = r2;
        r0.height = r3;
        this.mItemIcon.setLayoutParams(r0);
    }

    public void setSelectedImageRes(int r1) {
        this.mSelectedIcon.setImageResource(r1);
    }

    public void setActive(boolean r3) {
        this.mIsActive = r3;
        ImageView r0 = this.mSelectedIcon;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        TextView r2 = this.mTitle;
        if (r3 == false) goto L9;
        int r4 = this.mActiveColor;
    L10:
        r2.setTextColor(r4);
        return;
    L9:
        r4 = this.mDisactiveColor;
        goto L10
    L5:
        r1 = 8;
        goto L6
    }

    public void setActive(boolean r3, boolean r4) {
        this.mIsActive = r3;
        ImageView r0 = this.mSelectedIcon;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        TextView r2 = this.mTitle;
        if (r3 == false) goto L9;
        int r5 = this.mActiveColor;
    L12:
        r2.setTextColor(r5);
        return;
    L9:
        if (r4 == false) goto L11;
        r5 = this.mCurrentDisactiveColor;
        goto L12
    L11:
        r5 = this.mDisactiveColor;
        goto L12
    L5:
        r1 = 8;
        goto L6
    }

    public void enableChildViews(boolean r3) {
        super.setEnabled(r3);
        this.mIconAreaLayout.setEnabled(r3);
        TextView r0 = this.mTitle;
        if (this.mIsActive == false) goto L7;
        if (r3 == false) goto L6;
        int r2 = this.mActiveColor;
    L8:
        r0.setTextColor(r2);
        return;
    L6:
        r2 = this.mCurrentDisactiveColor;
        goto L8
    L7:
        r2 = this.mDisactiveColor;
        goto L8
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        if (r2 == false) goto L4;
        float r0 = 1.0f;
    L5:
        setAlpha(r0);
        super.setEnabled(r2);
        return;
    L4:
        r0 = 0.4f;
        goto L5
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public FrameLayout getIconAreaFrameLayout() {
        return this.mIconAreaLayout;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }
}
