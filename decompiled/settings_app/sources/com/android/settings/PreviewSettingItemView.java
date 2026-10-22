package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewSettingItemView extends RelativeLayout {
    private ImageView mCheckedImage;
    private Drawable mFocusedDrawable;
    private Drawable mNormalDrawable;
    private ImageView mPreviewImage;
    private TextView mPreviewTitle;

    public PreviewSettingItemView(Context r1) {
        super(r1);
    }

    public PreviewSettingItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PreviewSettingItemView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        View r0 = LayoutInflater.from(r4).inflate(R.layout.preview_setting_item_view, this, true);
        this.mPreviewImage = (ImageView) r0.findViewById(R.id.preview_image);
        this.mCheckedImage = (ImageView) r0.findViewById(R.id.checked_image);
        this.mPreviewTitle = (TextView) r0.findViewById(R.id.preview_title);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.PreviewSettingItemView, r6, 0);
        this.mNormalDrawable = r7.getDrawable(1);
        this.mFocusedDrawable = r7.getDrawable(0);
        Drawable r8 = this.mNormalDrawable;
        if (r8 == null) goto L5;
        this.mPreviewImage.setImageDrawable(r8);
    L5:
        CharSequence r9 = r7.getText(2);
        if (r9 == null) goto L8;
        this.mPreviewTitle.setText(r9);
    L9:
        r7.recycle();
        return;
    L8:
        this.mPreviewTitle.setVisibility(8);
        goto L9
    }

    public void setChecked(boolean r4) {
        Drawable r0 = this.mFocusedDrawable;
        if (r0 == null) goto L11;
        Drawable r1 = this.mNormalDrawable;
        if (r1 == null) goto L11;
        ImageView r2 = this.mPreviewImage;
        if (r4 == true) goto L10;
        r0 = r1;
    L10:
        r2.setImageDrawable(r0);
    L11:
        ImageView r3 = this.mCheckedImage;
        if (r4 == false) goto L14;
        int r5 = 0;
    L15:
        r3.setVisibility(r5);
        return;
    L14:
        r5 = 8;
        goto L15
    }

    public void setTitle(int r2) {
        setTitle(getResources().getString(r2));
    }

    public void setTitle(CharSequence r2) {
        this.mPreviewTitle.setText(r2);
        this.mPreviewTitle.setVisibility(0);
    }

    public void setPreview(Drawable r1) {
        this.mPreviewImage.setImageDrawable(r1);
    }

    public void setPreview(int r1) {
        this.mPreviewImage.setImageResource(r1);
    }

    public void setCheckImgMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mCheckedImage.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mCheckedImage.setLayoutParams(r0);
    }

    public void setPreviewImgMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mPreviewImage.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mPreviewImage.setLayoutParams(r0);
    }

    public void setPreviewTitleMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mPreviewTitle.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mPreviewTitle.setLayoutParams(r0);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.mPreviewImage.setEnabled(r2);
        this.mPreviewTitle.setEnabled(r2);
    }

    public boolean isChecked() {
        if (this.mCheckedImage.getVisibility() != 0) goto L5;
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
