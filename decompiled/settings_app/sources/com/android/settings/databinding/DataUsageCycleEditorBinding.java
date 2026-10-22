package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageCycleEditorBinding implements ViewBinding {
    public final NumberPicker cycleDay;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageCycleEditorBinding(LinearLayout r1, NumberPicker r2) {
        this.rootView = r1;
        this.cycleDay = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageCycleEditorBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageCycleEditorBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_cycle_editor, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageCycleEditorBinding bind(View r2) {
        NumberPicker r1 = (NumberPicker) ViewBindings.findChildViewById(r2, R.id.cycle_day);
        if (r1 == null) goto L7;
        return new DataUsageCycleEditorBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.cycle_day)));
    }
}
