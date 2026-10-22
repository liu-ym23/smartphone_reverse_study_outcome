package com.obric.oui.header;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes4.dex */
public class HeaderInfoView extends LinearLayout {
    private static final int DEFAULT_BOTTOM_PADDING_DP = 24;
    private static final int DEFAULT_TOP_PADDING_DP = 96;
    private static final int[] PADDING_ATTRS = null;
    private FrameLayout customContentContainer;
    private OImageAppIcon iconView;
    private OTextView subtitleView;
    private OTextView titleView;

    static {
        PADDING_ATTRS = new int[]{R.attr.padding, R.attr.paddingTop, R.attr.paddingBottom};
    }

    public HeaderInfoView(Context r2) {
        this(r2, null);
    }

    public HeaderInfoView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public HeaderInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2);
    }

    private void init(Context r3, AttributeSet r4) {
        LayoutInflater.from(r3).inflate(com.obric.common.oui.R.layout.header_info_view_layout, this, true);
        setGravity(1);
        setOrientation(1);
        initViews();
        applyDefaultPadding(r4);
        initAttrs(r4);
    }

    private void initViews() {
        this.iconView = (OImageAppIcon) findViewById(com.obric.common.oui.R.id.header_info_icon);
        this.titleView = (OTextView) findViewById(com.obric.common.oui.R.id.header_info_title);
        this.subtitleView = (OTextView) findViewById(com.obric.common.oui.R.id.header_info_subtitle);
        this.customContentContainer = (FrameLayout) findViewById(com.obric.common.oui.R.id.header_info_custom_content_container);
    }

    private void applyDefaultPadding(AttributeSet r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r5, PADDING_ATTRS);
        boolean r0 = r6.hasValue(0);     // Catch: Throwable -> L19
        if (r0 == false) goto L6;
    L9:
        int r1 = getPaddingTop();     // Catch: Throwable -> L19
    L10:
        if (r0 == false) goto L12;
    L15:
        int r2 = getPaddingBottom();     // Catch: Throwable -> L19
    L16:
        setPadding(getPaddingLeft(), r1, getPaddingRight(), r2);     // Catch: Throwable -> L19
        r6.recycle();
        return;
    L12:
        if (r6.hasValue(2) == true) goto L15;
        r2 = dpToPx(24);     // Catch: Throwable -> L19
        goto L16
    L6:
        if (r6.hasValue(1) == true) goto L9;
        r1 = dpToPx(96);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    private int dpToPx(int r2) {
        return (int) TypedValue.applyDimension(1, r2, getResources().getDisplayMetrics());
    }

    private void initAttrs(AttributeSet r4) {
        TypedArray r5 = getContext().obtainStyledAttributes(r4, com.obric.common.oui.R.styleable.HeaderInfoView, 0, 0);
    L20:
        th = move-exception;
        r5.recycle();
        throw th;
    L4:
        if (r5.hasValue(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_icon) == false) goto L7;
        setIcon(r5.getDrawable(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_icon));     // Catch: Throwable -> L20
    L7:
        if (r5.hasValue(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_title) == false) goto L10;
        setTitle(r5.getString(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_title));     // Catch: Throwable -> L20
    L10:
        if (r5.hasValue(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_titleColor) == false) goto L13;
        setTitleColor(r5.getColor(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_titleColor, this.titleView.getCurrentTextColor()));     // Catch: Throwable -> L20
    L13:
        if (r5.hasValue(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_subtitle) == false) goto L16;
        setSubtitle(r5.getString(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_subtitle));     // Catch: Throwable -> L20
    L16:
        if (r5.hasValue(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor) == false) goto L18;
        setSubtitleColor(r5.getColor(com.obric.common.oui.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor, this.subtitleView.getCurrentTextColor()));     // Catch: Throwable -> L20
    L18:
        r5.recycle();
    }

    public OImageAppIcon getIconView() {
        return this.iconView;
    }

    public void setIcon(int r2) {
        this.iconView.setImageResource(r2);
        OImageAppIcon r1 = this.iconView;
        if (r2 != 0) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setIcon(Drawable r2) {
        this.iconView.setImageDrawable(r2);
        OImageAppIcon r1 = this.iconView;
        if (r2 != null) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setImagePackageName(String r2) {
        if (r2 != null) goto L4;
    L8:
        Drawable r0 = (Drawable) null;
        setIcon(null);
        return;
    L4:
        if (r2.trim().isEmpty() == true) goto L8;
        this.iconView.setImagePackageName(r2);
        this.iconView.setVisibility(0);
    }

    public OTextView getTitleView() {
        return this.titleView;
    }

    public void setTitle(CharSequence r2) {
        this.titleView.setText(r2);
        OTextView r1 = this.titleView;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setTitleColor(int r1) {
        this.titleView.setTextColor(r1);
    }

    public OTextView getSubtitleView() {
        return this.subtitleView;
    }

    public void setSubtitle(CharSequence r2) {
        this.subtitleView.setText(r2);
        OTextView r1 = this.subtitleView;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setSubtitleColor(int r1) {
        this.subtitleView.setTextColor(r1);
    }

    public FrameLayout getCustomContentContainer() {
        return this.customContentContainer;
    }

    public void addCustomContentView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.customContentContainer.addView(r2);
        updateCustomContentContainerVisibility();
    }

    private void updateCustomContentContainerVisibility() {
        FrameLayout r1 = this.customContentContainer;
        if (r1.getChildCount() <= 0) goto L5;
        int r0 = 0;
    L6:
        r1.setVisibility(r0);
        return;
    L5:
        r0 = 8;
        goto L6
    }
}
