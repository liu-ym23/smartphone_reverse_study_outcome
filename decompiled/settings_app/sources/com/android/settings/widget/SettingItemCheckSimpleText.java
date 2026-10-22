package com.android.settings.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.obric.olog.OLog;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes.dex */
public class SettingItemCheckSimpleText extends ListContentItemCustom {
    private static final String TAG = "SettingItemCheckSimpleText";
    private Intent mData;
    private ImageView mIcArrow;
    private IcArrowClickListener mIcArrowListener;
    private ImageView mIcChecked;
    private TextView mItemTitle;
    private boolean mShowIconArrow;
    private TextView mSubTitle;

    public interface IcArrowClickListener extends View.OnClickListener {
        @Override // android.view.View.OnClickListener
        void onClick(View r1);
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return 0;
    }

    @Override // obric.widget.ListContentItemCustom, obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.setting_item_check_simple_text;
    }

    static /* synthetic */ IcArrowClickListener access$000(SettingItemCheckSimpleText r0) {
        return r0.mIcArrowListener;
    }

    public SettingItemCheckSimpleText(Context r2) {
        this(r2, null);
    }

    public SettingItemCheckSimpleText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingItemCheckSimpleText(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.SettingItemCheckSimpleText, r5, 0);
        CharSequence r7 = r6.getText(0);
        if (r7 == null) goto L5;
        this.mItemTitle.setText(r7);
    L5:
        boolean r8 = r6.getBoolean(1, false);
        this.mShowIconArrow = r8;
        if (r8 == false) goto L8;
        this.mIcArrow.setVisibility(0);
    L8:
        r6.recycle();
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        this.mIcChecked = (ImageView) findViewById(R.id.item_check);
        this.mItemTitle = (TextView) findViewById(R.id.item_title);
        this.mIcArrow = (ImageView) findViewById(R.id.item_arrow);
        this.mSubTitle = (TextView) findViewById(R.id.item_subtitle);
        this.mSummary = (TextView) findViewById(R.id.item_summary);
        this.mIcArrow.setOnClickListener(new AnonymousClass1(this));
    }

    public View getIcArrow() {
        return this.mIcArrow;
    }

    public void setSubTitle(CharSequence r2) {
        this.mSubTitle.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.mSubTitle.setVisibility(8);
        return;
    L5:
        this.mSubTitle.setVisibility(0);
    }

    public void setSubTitle(int r2) {
        setSubTitle(getContext().getString(r2));
    }

    public boolean isChecked() {
        if (this.mIcChecked.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setChecked(boolean r1) {
        ImageView r0 = this.mIcChecked;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setTitleText(CharSequence r1) {
        this.mItemTitle.setText(r1);
    }

    public void setTitleText(int r1) {
        this.mItemTitle.setText(r1);
    }

    public void showIconArrow(boolean r3) {
        ImageView r0 = this.mIcArrow;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3 == false) goto L10;
        setIconArrowListener(this.mIcArrowListener);
        return;
    L10:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setIconArrowListener(IcArrowClickListener r2) {
        this.mIcArrowListener = r2;
        OLog.d(TAG, "setIconArrowListener: l:" + r2);
    }

    public Intent getData() {
        return this.mData;
    }

    public void setData(Intent r1) {
        this.mData = r1;
        if (this.mIcArrow != null) goto L5;
        return;
    L5:
        if (isChecked() == false) goto L7;
        this.mIcArrow.setEnabled(true);
        return;
    L7:
        this.mIcArrow.setEnabled(false);
    }

    public void enableIcArrow(boolean r1) {
        this.mIcArrow.setEnabled(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.mIcChecked.setEnabled(r2);
        this.mItemTitle.setEnabled(r2);
        super.setEnabled(r2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        setSelected(isChecked());
    }
}
