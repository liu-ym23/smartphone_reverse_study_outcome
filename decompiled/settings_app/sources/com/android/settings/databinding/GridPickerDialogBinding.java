package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class GridPickerDialogBinding implements ViewBinding {
    public final GridView list;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GridPickerDialogBinding(FrameLayout r1, GridView r2) {
        this.rootView = r1;
        this.list = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static GridPickerDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GridPickerDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.grid_picker_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GridPickerDialogBinding bind(View r2) {
        GridView r1 = (GridView) ViewBindings.findChildViewById(r2, android.R.id.list);
        if (r1 == null) goto L7;
        return new GridPickerDialogBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(android.R.id.list)));
    }
}
