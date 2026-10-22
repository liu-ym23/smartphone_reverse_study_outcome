package com.bytedanceos.security.widget.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes2.dex */
class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(final Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return ((Checkable) this.mItem).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(final boolean checked) {
        ((Checkable) this.mItem).setChecked(checked);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
