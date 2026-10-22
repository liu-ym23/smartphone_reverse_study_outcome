package com.android.settings.applications;

import android.widget.ImageView;
import obric.widget.support.IMenuItem;

/* JADX INFO: loaded from: classes2.dex */
public class ManageApplicationsMenuItem implements IMenuItem {
    private final int iconRes;
    private boolean selected;
    private final String title;
    private final int value;

    @Override // obric.widget.support.IMenuItem
    public boolean hasMenuIcon() {
        return false;
    }

    @Override // obric.widget.support.IMenuItem
    public void setMenuIcon(ImageView r1) {
    }

    public ManageApplicationsMenuItem(String r1, boolean r2, int r3, int r4) {
        this.title = r1;
        this.selected = r2;
        this.value = r3;
        this.iconRes = r4;
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

    public void setSelected(boolean r1) {
        this.selected = r1;
    }

    public int getIconRes() {
        return this.iconRes;
    }
}
