package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SelectOptionsView extends LinearLayout implements View.OnClickListener {
    private static final int INVALID_TEXT_SIZE = -1;
    private String[] mAnimNameArray;
    private boolean mCheckImmediately;
    private OptionsSelectedCallback mOptionsSelectedCallback;
    private int mOriginIndex;
    private int mTitleTextSize;

    public interface OptionsSelectedCallback {
        void onSelectIndex(int r1);
    }

    public SelectOptionsView(Context r2) {
        this(r2, null);
    }

    public SelectOptionsView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SelectOptionsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mOriginIndex = -1;
        this.mCheckImmediately = true;
        this.mTitleTextSize = -1;
    }

    public void initTitleSize(int r1) {
        this.mTitleTextSize = r1;
    }

    public void initView(int r4, int r5, int r6, int r7) {
        TypedArray r8 = getResources().obtainTypedArray(r4);
        Drawable[] r0 = new Drawable[r8.length()];
        int r1 = 0;
    L4:
        if (r1 >= r8.length()) goto L6;
        r0[r1] = r8.getDrawable(r1);
        r1 = r1 + 1;
        goto L4
    L6:
        String[] r9 = getResources().getStringArray(r5);
        this.mAnimNameArray = r9;
        initView(r0, r9, r6, r7);
        r8.recycle();
    }

    public void initView(ArrayList<Drawable> r2, ArrayList<String> r3, int r4, int r5) {
        Drawable[] r0 = new Drawable[r2.size()];
        r2.toArray(r0);
        String[] r6 = new String[r3.size()];
        r3.toArray(r6);
        initView(r0, r6, r4, r5);
    }

    public void initView(Drawable[] r7, String[] r8, int r9, int r10) {
        this.mAnimNameArray = r8;
        if (r7.length != r8.length) goto L16;
        int r0 = 0;
    L6:
        if (r0 >= r7.length) goto L14;
        PreviewOptionItemView r1 = new PreviewOptionItemView(getContext());
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.launcher_anim_preview_option_item_width), getResources().getDimensionPixelOffset(R.dimen.select_options_view_height));
        r4.gravity = 1;
        r4.bottomMargin = getResources().getDimensionPixelOffset(r10);
        if (r9 <= 0) goto L10;
        r4.leftMargin = getResources().getDimensionPixelOffset(r9);
        r4.rightMargin = getResources().getDimensionPixelOffset(r9);
    L10:
        r1.setLayoutParams(r4);
        int r2 = getResources().getDimensionPixelOffset(R.dimen.launcher_anim_preview_option_item_top_margin);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.topMargin = r2;
        r1.getIconAreaFrameLayout().setLayoutParams(r3);
        int r5 = getResources().getDimensionPixelOffset(R.dimen.launcher_anim_preview_option_item_title_top_margin);
        TextView r6 = r1.getTitleView();
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        r11.setMargins(0, r5, 0, 0);
        r6.setLayoutParams(r11);
        r1.setTitle(this.mAnimNameArray[r0]);
        if (this.mTitleTextSize == (-1)) goto L13;
        r1.getTitleView().setTextSize(0, this.mTitleTextSize);
    L13:
        r1.setItemImage(r7[r0]);
        r1.setSelectedImageRes(R.drawable.option_selected);
        r1.setOnClickListener(this);
        addView(r1);
        r0 = r0 + 1;
        goto L6
    L14:
        return;
    L16:
        throw new IllegalStateException("got different array size between images and names!");
    }

    public void updateIcons(int r4) {
        TypedArray r5 = getResources().obtainTypedArray(r4);
        if (r5.length() == getChildCount()) goto L6;
        r5.recycle();
        return;
    L6:
        int r0 = 0;
    L8:
        if (r0 >= getChildCount()) goto L13;
        PreviewOptionItemView r1 = (PreviewOptionItemView) getChildAt(r0);
        if (r1 == null) goto L12;
        r1.setItemImage(r5.getDrawable(r0));
    L12:
        r0 = r0 + 1;
        goto L8
    L13:
        r5.recycle();
    }

    public void setOriginIndex(int r1) {
        this.mOriginIndex = r1;
        updateViewTitle();
    }

    private void updateViewTitle() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        PreviewOptionItemView r1 = (PreviewOptionItemView) getChildAt(r0);
        if (r1 == null) goto L7;
        if (r0 != this.mOriginIndex) goto L11;
        r1.setTitle(R.string.current_use);
    L12:
        r0 = r0 + 1;
        goto L4
    L11:
        r1.setTitle(this.mAnimNameArray[r0]);
        goto L12
    L7:
        return;
    }

    public void setCallback(OptionsSelectedCallback r2) {
        setCallback(r2, true);
    }

    public void setCallback(OptionsSelectedCallback r1, boolean r2) {
        this.mOptionsSelectedCallback = r1;
        this.mCheckImmediately = r2;
    }

    public void setSelectedIndex(int r7) {
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L14;
        PreviewOptionItemView r2 = (PreviewOptionItemView) getChildAt(r1);
        boolean r3 = true;
        if (r7 != r1) goto L8;
        boolean r4 = true;
    L10:
        if (r1 == this.mOriginIndex) goto L13;
        r3 = false;
    L13:
        r2.setActive(r4, r3);
        r1 = r1 + 1;
        goto L4
    L8:
        r4 = false;
        goto L10
    }

    public int getSelectedIndex() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L9;
        if (((PreviewOptionItemView) getChildAt(r0)).isActive() == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        if ((r7 instanceof PreviewOptionItemView) == false) goto L28;
        boolean r0 = !((PreviewOptionItemView) r7).isActive();
        int r3 = 0;
    L6:
        if (r3 >= getChildCount()) goto L35;
        PreviewOptionItemView r4 = (PreviewOptionItemView) getChildAt(r3);
        if (r4 != r7) goto L21;
        if (this.mCheckImmediately == true) goto L12;
    L16:
        if (r0 == false) goto L27;
        OptionsSelectedCallback r5 = this.mOptionsSelectedCallback;
        if (r5 == null) goto L27;
        r5.onSelectIndex(r3);
    L27:
        r3 = r3 + 1;
        goto L6
    L12:
        if (r3 != this.mOriginIndex) goto L14;
        boolean r6 = true;
    L15:
        r4.setActive(true, r6);
        goto L16
    L14:
        r6 = false;
        goto L15
    L21:
        if (this.mCheckImmediately == false) goto L27;
        if (r3 != this.mOriginIndex) goto L25;
        boolean r8 = true;
    L26:
        r4.setActive(false, r8);
        goto L27
    L25:
        r8 = false;
        goto L26
    L35:
        return;
    }
}
