package com.android.setupwizardlib.items;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.view.CheckableLinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ExpandableSwitchItem extends SwitchItem implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private CharSequence collapsedSummary;
    private CharSequence expandedSummary;
    private boolean isExpanded;

    public ExpandableSwitchItem() {
        this.isExpanded = false;
    }

    public ExpandableSwitchItem(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.isExpanded = false;
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.SuwExpandableSwitchItem);
        this.collapsedSummary = r4.getText(R.styleable.SuwExpandableSwitchItem_suwCollapsedSummary);
        this.expandedSummary = r4.getText(R.styleable.SuwExpandableSwitchItem_suwExpandedSummary);
        r4.recycle();
    }

    @Override // com.android.setupwizardlib.items.SwitchItem, com.android.setupwizardlib.items.Item
    protected int getDefaultLayoutResource() {
        return R.layout.suw_items_expandable_switch;
    }

    @Override // com.android.setupwizardlib.items.Item
    public CharSequence getSummary() {
        if (this.isExpanded == false) goto L6;
        return getExpandedSummary();
    L6:
        return getCollapsedSummary();
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean r2) {
        if (this.isExpanded != r2) goto L5;
        return;
    L5:
        this.isExpanded = r2;
        notifyItemChanged();
    }

    public CharSequence getCollapsedSummary() {
        return this.collapsedSummary;
    }

    public void setCollapsedSummary(CharSequence r1) {
        this.collapsedSummary = r1;
        if (isExpanded() == true) goto L6;
        notifyChanged();
        return;
    }

    public CharSequence getExpandedSummary() {
        return this.expandedSummary;
    }

    public void setExpandedSummary(CharSequence r1) {
        this.expandedSummary = r1;
        if (isExpanded() == false) goto L6;
        notifyChanged();
        return;
    }

    @Override // com.android.setupwizardlib.items.SwitchItem, com.android.setupwizardlib.items.Item, com.android.setupwizardlib.items.IItem
    public void onBindView(View r3) {
        super.onBindView(r3);
        View r0 = r3.findViewById(R.id.suw_items_expandable_switch_content);
        r0.setOnClickListener(this);
        if ((r0 instanceof CheckableLinearLayout) == false) goto L5;
        ((CheckableLinearLayout) r0).setChecked(isExpanded());
    L5:
        tintCompoundDrawables(r3);
        r3.setFocusable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        setExpanded(!isExpanded());
    }

    private void tintCompoundDrawables(View r8) {
        int r2 = 0;
        TypedArray r7 = r8.getContext().obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary});
        ColorStateList r0 = r7.getColorStateList(0);
        r7.recycle();
        if (r0 == null) goto L16;
        TextView r9 = (TextView) r8.findViewById(R.id.suw_items_title);
        Drawable[] r10 = r9.getCompoundDrawables();
        int r1 = r10.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        Drawable r4 = r10[r3];
        if (r4 == null) goto L9;
        r4.setColorFilter(r0.getDefaultColor(), PorterDuff.Mode.SRC_IN);
    L9:
        r3 = r3 + 1;
        goto L5
    L10:
        Drawable[] r11 = r9.getCompoundDrawablesRelative();
        int r12 = r11.length;
    L11:
        if (r2 >= r12) goto L23;
        Drawable r5 = r11[r2];
        if (r5 == null) goto L15;
        r5.setColorFilter(r0.getDefaultColor(), PorterDuff.Mode.SRC_IN);
    L15:
        r2 = r2 + 1;
        goto L11
    L23:
        return;
    }
}
