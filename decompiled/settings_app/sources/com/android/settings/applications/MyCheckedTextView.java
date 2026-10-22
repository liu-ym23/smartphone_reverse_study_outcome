package com.android.settings.applications;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CheckedTextView;

/* JADX INFO: compiled from: RunningProcessesView.java */
/* JADX INFO: loaded from: classes2.dex */
class MyCheckedTextView extends CheckedTextView {
    public MyCheckedTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return CheckBox.class.getName();
    }
}
