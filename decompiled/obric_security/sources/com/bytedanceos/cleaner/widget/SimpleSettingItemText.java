package com.bytedanceos.cleaner.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.api.TextViewSmt;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleSettingItemText extends RelativeLayout {
    private ImageView mArrow;
    private boolean mClickable;
    private TextView mTitle;
    private TextView subTitle;

    public SimpleSettingItemText(Context context) {
        super(context);
    }

    public SimpleSettingItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleSettingItemText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View r0 = LayoutInflater.from(context).inflate(R.layout.simple_item_text_layout, this, true);
        this.mTitle = (TextView) r0.findViewById(R.id.item_title);
        this.subTitle = (TextView) r0.findViewById(R.id.item_subtitle);
        this.mArrow = (ImageView) r0.findViewById(R.id.item_arrow);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.SimpleSettingItemText, defStyle, 0);
        this.mTitle.setText(r4.getText(4));
        this.subTitle.setText(r4.getText(1));
        this.subTitle.setTextSize(0, getResources().getDimension(R.dimen.settings_item_sub_title_size));
        ColorStateList r5 = r4.getColorStateList(3);
        if (r5 == null) goto L5;
        this.subTitle.setTextColor(r5);
    L5:
        Drawable r6 = r4.getDrawable(0);
        r4.recycle();
        if (r6 == null) goto L8;
        this.mArrow.setImageDrawable(r6);
    L8:
        this.mTitle.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.simple_setting_item_title_max_width));
    }

    public ImageView getArrow() {
        return this.mArrow;
    }

    public TextView getTitleView() {
        return this.mTitle;
    }

    public CharSequence getTitle() {
        return this.mTitle.getText();
    }

    public void setTitle(String aTitle) {
        this.mTitle.setText(aTitle);
    }

    public TextView getSubTitleView() {
        return this.subTitle;
    }

    public CharSequence getSubTitle() {
        return this.subTitle.getText();
    }

    public void setSubTitle(CharSequence aSubTitle) {
        this.mTitle.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.simple_setting_item_title_max_width_with_subtitle));
        this.subTitle.setVisibility(0);
        this.subTitle.setText(aSubTitle);
    }

    public void setArrowVisible(boolean isVisible) {
        ImageView r0 = this.mArrow;
        if (isVisible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.mClickable = isVisible;
        return;
    L5:
        r1 = 4;
        goto L6
    }

    public void setItemEnable(boolean enabled) {
        setEnabled(enabled);
        TextView r0 = this.subTitle;
        if (enabled == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public boolean clickable() {
        return this.mClickable;
    }

    public void setTitleMaxTextSize(float size) {
        TextViewSmt.getInstance().setMaxTextSize(this.mTitle, size);
    }
}
