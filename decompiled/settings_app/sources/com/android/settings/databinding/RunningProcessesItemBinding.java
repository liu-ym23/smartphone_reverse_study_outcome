package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RunningProcessesItemBinding implements ViewBinding {
    public final TextView description;
    public final ImageView icon;
    public final TextView name;
    private final GridLayout rootView;
    public final TextView size;
    public final TextView uptime;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningProcessesItemBinding(GridLayout r1, TextView r2, ImageView r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.description = r2;
        this.icon = r3;
        this.name = r4;
        this.size = r5;
        this.uptime = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public GridLayout getRoot() {
        return this.rootView;
    }

    public static RunningProcessesItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningProcessesItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_processes_item_, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningProcessesItemBinding bind(View r9) {
        int r0 = R.id.description;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.description);
        if (r4 == null) goto L15;
        r0 = R.id.icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.icon);
        if (r5 == null) goto L15;
        r0 = R.id.name;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.name);
        if (r6 == null) goto L15;
        r0 = R.id.size;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.size);
        if (r7 == null) goto L15;
        r0 = R.id.uptime;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.uptime);
        if (r8 == null) goto L15;
        return new RunningProcessesItemBinding((GridLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
