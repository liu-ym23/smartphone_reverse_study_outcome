package com.qihoo360.mobilesafe.ui.common.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedanceos.utils.Constants;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonCheckBox1 extends LinearLayout implements ICustomCheckBox, View.OnClickListener {
    private Drawable[] mButtonDrawables;
    private boolean mChecked;
    private boolean mDefineEnabled;
    private int[] mHalfCheckDrawables;
    private boolean mHalfChecked;
    private ImageView mImgButton;
    private ICustomCheckBox.OnCheckChangedListener mListener;

    public CommonCheckBox1(Context r2) {
        this(r2, null);
    }

    public CommonCheckBox1(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.mDefineEnabled = true;
        setOrientation(0);
        setGravity(17);
        String r2 = CommonUtils.getValueFromAttrs(r6, r7, "checked");
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        String r3 = CommonUtils.getValueFromAttrs(r6, r7, "enabled");
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L12:
        String r8 = CommonUtils.getValueFromAttrs(r6, r7, "clickable");
        if (TextUtils.isEmpty(r8) == false) goto L15;
    L16:
        setOnClickListener(this);
    L17:
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
        ImageView r4 = new ImageView(r6);
        this.mImgButton = r4;
        r4.setLayoutParams(r9);
        addView(this.mImgButton);
        this.mButtonDrawables = new Drawable[]{getResources().getDrawable(R.drawable.checkbox_active), getResources().getDrawable(R.drawable.checkbox_unactive), getResources().getDrawable(R.drawable.common_icon_lock), getResources().getDrawable(R.drawable.common_icon_lock), getResources().getDrawable(R.drawable.checkbox_active), getResources().getDrawable(R.drawable.checkbox_unactive)};
        this.mHalfCheckDrawables = new int[]{R.drawable.common_checkbox1_halfchecked, R.drawable.common_checkbox1_halfchecked};
        setEnabled(this.mDefineEnabled);
        refreshView();
        setClickable(false);
        return;
    L15:
        if (r8.equals(Constants.IS_SET) == false) goto L17;
    L10:
        if (r3.equals(Constants.IS_SET) == false) goto L12;
        this.mDefineEnabled = true;
        goto L12
    L5:
        if (r2.equals(Constants.IS_SET) == false) goto L7;
        this.mChecked = true;
        goto L7
    }

    protected void setButtonDrawables(Drawable[] r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length != this.mButtonDrawables.length) goto L9;
        this.mButtonDrawables = r3;
        refreshView();
        return;
    }

    protected void setHalfCheckButtonDrawables(int[] r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length != this.mHalfCheckDrawables.length) goto L9;
        this.mHalfCheckDrawables = r3;
        refreshView();
        return;
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        if (r2 == false) goto L12;
        if (isEnabled() == false) goto L19;
        ImageView r3 = this.mImgButton;
        boolean r0 = this.mChecked;
        Drawable[] r1 = this.mButtonDrawables;
        if (r0 == false) goto L9;
        Drawable r4 = r1[4];
    L10:
        r3.setImageDrawable(r4);
        return;
    L9:
        r4 = r1[5];
        goto L10
    L19:
        return;
    L12:
        if (isEnabled() == false) goto L21;
        ImageView r5 = this.mImgButton;
        boolean r6 = this.mChecked;
        Drawable[] r7 = this.mButtonDrawables;
        if (r6 == false) goto L16;
        Drawable r8 = r7[0];
    L17:
        r5.setImageDrawable(r8);
        return;
    L16:
        r8 = r7[1];
        goto L17
    }

    @Override // com.qihoo360.mobilesafe.ui.common.checkbox.ICustomCheckBox
    public void setOnCheckedChangedListener(ICustomCheckBox.OnCheckChangedListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        refreshView();
    }

    protected void refreshView() {
        if (isEnabled() == false) goto L13;
        if (this.mHalfChecked == false) goto L7;
        this.mImgButton.setImageResource(this.mHalfCheckDrawables[0]);
    L20:
        setDescription(getContext(), this.mImgButton);
        return;
    L7:
        ImageView r0 = this.mImgButton;
        if (this.mChecked == false) goto L10;
        Drawable r1 = this.mButtonDrawables[0];
    L11:
        r0.setImageDrawable(r1);
        goto L20
    L10:
        r1 = this.mButtonDrawables[1];
        goto L11
    L13:
        if (this.mHalfChecked == false) goto L15;
        this.mImgButton.setImageResource(this.mHalfCheckDrawables[1]);
        goto L20
    L15:
        ImageView r2 = this.mImgButton;
        if (this.mChecked == false) goto L18;
        Drawable r3 = this.mButtonDrawables[2];
    L19:
        r2.setImageDrawable(r3);
        goto L20
    L18:
        r3 = this.mButtonDrawables[3];
        goto L19
    }

    public void setDescription(Context r1, ImageView r2) {
        if (this.mChecked == false) goto L5;
        int r0 = R.string.common_selected;
    L6:
        r2.setContentDescription(r1.getString(r0));
        return;
    L5:
        r0 = R.string.common_unselected;
        goto L6
    }

    public void setHalfChecked(boolean r1) {
        this.mHalfChecked = r1;
        refreshView();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        this.mHalfChecked = false;
        if (this.mChecked != r2) goto L5;
        return;
    L5:
        this.mChecked = r2;
        refreshView();
        ICustomCheckBox.OnCheckChangedListener r3 = this.mListener;
        if (r3 == null) goto L9;
        r3.onCheckChanged(this, this.mChecked);
        return;
    }

    public void setCheckedWithoutNotify(boolean r2) {
        this.mHalfChecked = false;
        if (this.mChecked != r2) goto L5;
        return;
    L5:
        this.mChecked = r2;
        refreshView();
    }

    public boolean isHalfChecked() {
        return this.mHalfChecked;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        if (r1 != this) goto L5;
        toggle();
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        refreshView();
    }

    public void setCheckBoxVisibility(int r2) {
        this.mImgButton.setVisibility(r2);
        if (r2 != 4) goto L5;
    L8:
        setClickable(false);
        return;
    L5:
        if (r2 == 8) goto L8;
        setClickable(true);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        setClickable(r0);
        super.setOnClickListener(r2);
        return;
    L4:
        r0 = false;
        goto L5
    }
}
