package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.obric.security.R;
import obric.widget.ListContentItem;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityBatteryItemText extends ListContentItem {
    public static final int SECURITY_BATTERY_BG_STYLE_BOTTOM = 11;
    public static final int SECURITY_BATTERY_BG_STYLE_MIDDLE = 10;
    private View mBottomSpliteView;
    private View mBtnContainer;
    private TextView mBtnText;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private SwitchEx mSwitch;

    @Override // obric.widget.ListContentItem
    protected int getDefaultLeftLayout() {
        return R.layout.security_progress_item_text_left_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return R.layout.security_battery_item_text_mid_layout;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return -1;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
    }

    @Override // obric.widget.ListContentItem
    public void setSummary(CharSequence s) {
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$000(SecurityBatteryItemText r0) {
        return r0.mOnCheckedChangeListener;
    }

    public SecurityBatteryItemText(Context context) {
        this(context, null);
    }

    public SecurityBatteryItemText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecurityBatteryItemText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray r3 = context.obtainStyledAttributes(attrs, R.styleable.SecurityItemText, defStyleAttr, 0);
        if (r3 == null) goto L5;
        boolean r5 = r3.getBoolean(3, false);
        int r4 = r3.getInt(2, 3);
        String r0 = r3.getString(0);
        r3.recycle();
        showSpliteLine(r5);
        setRightLayout(r4);
        setBtnText(r0);
    L5:
        SwitchEx r6 = this.mSwitch;
        if (r6 == null) goto L9;
        r6.setOnCheckedChangeListener(new AnonymousClass1(this));
        return;
    }

    @Override // obric.widget.ListContentItem
    public void setBackgroundStyle(int style) {
        if (style != 10) goto L6;
        setBackgroundResource(R.drawable.security_item_list_mid_gray);
        return;
    L6:
        if (style != 11) goto L12;
        setBackgroundResource(R.drawable.security_item_list_bottom_gray);
        View r1 = this.mBottomSpliteView;
        if (r1 == null) goto L13;
        r1.setVisibility(8);
        return;
    L13:
        return;
    }

    public void setBtnText(String message) {
        TextView r0 = this.mBtnText;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(message);
    }

    public void setBtnClickListener(View.OnClickListener listener) {
        View r0 = this.mBtnContainer;
        if (r0 == null) goto L6;
        r0.setOnClickListener(listener);
        return;
    }

    private void setRightLayout(int layoutMode) {
        this.mSwitch.setVisibility(8);
        this.mBtnContainer.setVisibility(8);
        if (layoutMode != 2) goto L6;
        this.mBtnContainer.setVisibility(0);
        return;
    L6:
        if (layoutMode != 3) goto L10;
        this.mSwitch.setVisibility(0);
        return;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public SwitchEx getSwitch() {
        return this.mSwitch;
    }

    public void setChecked(boolean isChecked) {
        SwitchEx r0 = this.mSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        CompoundButton.OnCheckedChangeListener r1 = this.mOnCheckedChangeListener;
        this.mOnCheckedChangeListener = null;
        r0.setChecked(isChecked);
        this.mOnCheckedChangeListener = r1;
    }

    public void showSpliteLine(boolean show) {
        View r0 = this.mBottomSpliteView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (show == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    @Override // obric.widget.ListContentItem
    protected void initMidWidget() {
        super.initMidWidget();
        this.mBottomSpliteView = findViewById(R.id.id_splite_view);
        this.mSwitch = (SwitchEx) findViewById(R.id.switchex);
        this.mBtnContainer = findViewById(R.id.right_btn_container);
        this.mBtnText = (TextView) findViewById(R.id.right_btn);
    }
}
