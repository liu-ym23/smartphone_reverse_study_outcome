package com.bytedanceos.datausage;

import android.widget.ImageView;
import obric.widget.support.IMenuItem;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageMenuItem implements IMenuItem {
    private boolean selected;
    private final String title;
    private final int value;

    @Override // obric.widget.support.IMenuItem
    public boolean hasMenuIcon() {
        return false;
    }

    @Override // obric.widget.support.IMenuItem
    public void setMenuIcon(ImageView targetImageView) {
    }

    public DataUsageMenuItem(String title, boolean selected, int value) {
        this.title = title;
        this.selected = selected;
        this.value = value;
    }

    @Override // obric.widget.support.IMenuItem
    public String getTitle() {
        return this.title;
    }

    public int getValue() {
        return this.value;
    }

    @Override // obric.widget.support.IMenuItem
    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
