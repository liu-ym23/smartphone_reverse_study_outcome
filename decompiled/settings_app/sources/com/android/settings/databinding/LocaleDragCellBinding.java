package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.localepicker.LocaleDragCell;

/* JADX INFO: loaded from: classes2.dex */
public final class LocaleDragCellBinding implements ViewBinding {
    public final CheckBox checkbox;
    public final ImageView dragHandle;
    public final TextView l10nWarn;
    public final TextView label;
    public final TextView miniLabel;
    private final LocaleDragCell rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LocaleDragCellBinding(LocaleDragCell r1, CheckBox r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.checkbox = r2;
        this.dragHandle = r3;
        this.l10nWarn = r4;
        this.label = r5;
        this.miniLabel = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LocaleDragCell getRoot() {
        return this.rootView;
    }

    public static LocaleDragCellBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LocaleDragCellBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.locale_drag_cell, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LocaleDragCellBinding bind(View r9) {
        int r0 = R.id.checkbox;
        CheckBox r4 = (CheckBox) ViewBindings.findChildViewById(r9, R.id.checkbox);
        if (r4 == null) goto L15;
        r0 = R.id.dragHandle;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.dragHandle);
        if (r5 == null) goto L15;
        r0 = R.id.l10nWarn;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.l10nWarn);
        if (r6 == null) goto L15;
        r0 = R.id.label;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.label);
        if (r7 == null) goto L15;
        r0 = R.id.miniLabel;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.miniLabel);
        if (r8 == null) goto L15;
        return new LocaleDragCellBinding((LocaleDragCell) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
