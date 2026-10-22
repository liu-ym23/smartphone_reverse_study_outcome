package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WidgetProgressBarBinding implements ViewBinding {
    public final ProgressBar progress;
    private final ProgressBar rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WidgetProgressBarBinding(ProgressBar r1, ProgressBar r2) {
        this.rootView = r1;
        this.progress = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ProgressBar getRoot() {
        return this.rootView;
    }

    public static WidgetProgressBarBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WidgetProgressBarBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.widget_progress_bar, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WidgetProgressBarBinding bind(View r1) {
        if (r1 == null) goto L6;
        ProgressBar r2 = (ProgressBar) r1;
        return new WidgetProgressBarBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
