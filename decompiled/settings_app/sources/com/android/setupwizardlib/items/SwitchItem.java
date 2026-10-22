package com.android.setupwizardlib.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class SwitchItem extends Item implements CompoundButton.OnCheckedChangeListener {
    private boolean checked;
    private OnCheckedChangeListener listener;

    public interface OnCheckedChangeListener {
        void onCheckedChange(SwitchItem r1, boolean r2);
    }

    public SwitchItem() {
        this.checked = false;
    }

    public SwitchItem(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.checked = false;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SuwSwitchItem);
        this.checked = r5.getBoolean(R.styleable.SuwSwitchItem_android_checked, false);
        r5.recycle();
    }

    public void setChecked(boolean r2) {
        if (this.checked == r2) goto L8;
        this.checked = r2;
        notifyItemChanged();
        OnCheckedChangeListener r0 = this.listener;
        if (r0 == null) goto L9;
        r0.onCheckedChange(this, r2);
        return;
    L9:
        return;
    }

    public boolean isChecked() {
        return this.checked;
    }

    @Override // com.android.setupwizardlib.items.Item
    protected int getDefaultLayoutResource() {
        return R.layout.suw_items_switch;
    }

    public void toggle(View r2) {
        this.checked = !this.checked;
        ((SwitchCompat) r2.findViewById(R.id.suw_items_switch)).setChecked(this.checked);
    }

    @Override // com.android.setupwizardlib.items.Item, com.android.setupwizardlib.items.IItem
    public void onBindView(View r2) {
        super.onBindView(r2);
        SwitchCompat r3 = (SwitchCompat) r2.findViewById(R.id.suw_items_switch);
        r3.setOnCheckedChangeListener(null);
        r3.setChecked(this.checked);
        r3.setOnCheckedChangeListener(this);
        r3.setEnabled(isEnabled());
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener r1) {
        this.listener = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.checked = r2;
        OnCheckedChangeListener r3 = this.listener;
        if (r3 == null) goto L6;
        r3.onCheckedChange(this, r2);
        return;
    }
}
