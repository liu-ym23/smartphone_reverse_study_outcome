package com.android.setupwizardlib.items;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class Item extends AbstractItem {
    private boolean enabled;
    private Drawable icon;
    private int layoutRes;
    private CharSequence summary;
    private CharSequence title;
    private boolean visible;

    public Item() {
        this.enabled = true;
        this.visible = true;
        this.layoutRes = getDefaultLayoutResource();
    }

    public Item(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.enabled = true;
        this.visible = true;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SuwItem);
        this.enabled = r5.getBoolean(R.styleable.SuwItem_android_enabled, true);
        this.icon = r5.getDrawable(R.styleable.SuwItem_android_icon);
        this.title = r5.getText(R.styleable.SuwItem_android_title);
        this.summary = r5.getText(R.styleable.SuwItem_android_summary);
        this.layoutRes = r5.getResourceId(R.styleable.SuwItem_android_layout, getDefaultLayoutResource());
        this.visible = r5.getBoolean(R.styleable.SuwItem_android_visible, true);
        r5.recycle();
    }

    protected int getDefaultLayoutResource() {
        return R.layout.suw_items_default;
    }

    public void setEnabled(boolean r1) {
        this.enabled = r1;
        notifyItemChanged();
    }

    @Override // com.android.setupwizardlib.items.AbstractItem, com.android.setupwizardlib.items.ItemHierarchy
    public int getCount() {
        return isVisible() ? 1 : 0;
    }

    @Override // com.android.setupwizardlib.items.IItem
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setIcon(Drawable r1) {
        this.icon = r1;
        notifyItemChanged();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public void setLayoutResource(int r1) {
        this.layoutRes = r1;
        notifyItemChanged();
    }

    @Override // com.android.setupwizardlib.items.IItem
    public int getLayoutResource() {
        return this.layoutRes;
    }

    public void setSummary(CharSequence r1) {
        this.summary = r1;
        notifyItemChanged();
    }

    public CharSequence getSummary() {
        return this.summary;
    }

    public void setTitle(CharSequence r1) {
        this.title = r1;
        notifyItemChanged();
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public void setVisible(boolean r3) {
        if (this.visible != r3) goto L5;
        return;
    L5:
        this.visible = r3;
        if (r3 == true) goto L8;
        notifyItemRangeRemoved(0, 1);
        return;
    L8:
        notifyItemRangeInserted(0, 1);
    }

    public boolean isVisible() {
        return this.visible;
    }

    @Override // com.android.setupwizardlib.items.AbstractItemHierarchy
    public int getViewId() {
        return getId();
    }

    public void onBindView(View r6) {
        ((TextView) r6.findViewById(R.id.suw_items_title)).setText(getTitle());
        TextView r0 = (TextView) r6.findViewById(R.id.suw_items_summary);
        CharSequence r1 = getSummary();
        if (r1 != null) goto L5;
    L7:
        r0.setVisibility(8);
    L8:
        View r2 = r6.findViewById(R.id.suw_items_icon_container);
        Drawable r3 = getIcon();
        if (r3 == null) goto L11;
        ImageView r4 = (ImageView) r6.findViewById(R.id.suw_items_icon);
        r4.setImageDrawable(null);
        onMergeIconStateAndLevels(r4, r3);
        r4.setImageDrawable(r3);
        r2.setVisibility(0);
    L12:
        r6.setId(getViewId());
        return;
    L11:
        r2.setVisibility(8);
        goto L12
    L5:
        if (r1.length() <= 0) goto L7;
        r0.setText(r1);
        r0.setVisibility(0);
        goto L8
    }

    protected void onMergeIconStateAndLevels(ImageView r2, Drawable r3) {
        r2.setImageState(r3.getState(), false);
        r2.setImageLevel(r3.getLevel());
    }
}
