package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes.dex */
public class SettingItemImage extends ListContentItemCustom {
    private static final ImageView.ScaleType[] sScaleTypeArray = null;
    private ImageView mImageView;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return 0;
    }

    static {
        sScaleTypeArray = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public SettingItemImage(Context r2) {
        this(r2, null);
    }

    public SettingItemImage(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingItemImage(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        TypedArray r5 = r2.obtainStyledAttributes(r3, R.styleable.SettingItemImage);
        setImageDrawable(r5.getDrawable(0));
        int r6 = r5.getInt(1, 1);
        setScaleType(sScaleTypeArray[r6]);
        r5.recycle();
        setPressable(false);
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        this.mImageView = new ImageView(getContext());
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        this.mMidContainer.addView(this.mImageView, r0);
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public void setScaleType(ImageView.ScaleType r1) {
        ImageView r0 = this.mImageView;
        if (r0 == null) goto L6;
        r0.setScaleType(r1);
        return;
    }

    public void setImageResource(int r1) {
        ImageView r0 = this.mImageView;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    }

    public void setImageDrawable(Drawable r1) {
        ImageView r0 = this.mImageView;
        if (r0 == null) goto L6;
        r0.setImageDrawable(r1);
        return;
    }
}
