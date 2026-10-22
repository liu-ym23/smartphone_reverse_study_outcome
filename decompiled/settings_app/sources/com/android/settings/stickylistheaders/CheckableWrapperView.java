package com.android.settings.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes2.dex */
class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(Context r1) {
        super(r1);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return ((Checkable) this.mItem).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        ((Checkable) this.mItem).setChecked(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
