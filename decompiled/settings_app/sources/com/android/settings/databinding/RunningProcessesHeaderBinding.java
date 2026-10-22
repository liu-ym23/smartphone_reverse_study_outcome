package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.applications.LinearColorBar;

/* JADX INFO: loaded from: classes2.dex */
public final class RunningProcessesHeaderBinding implements ViewBinding {
    public final TextView appsSize;
    public final TextView appsSizePrefix;
    public final LinearColorBar colorBar;
    public final TextView freeSize;
    public final TextView freeSizePrefix;
    public final TextView listHeader;
    private final LinearLayout rootView;
    public final TextView systemSize;
    public final TextView systemSizePrefix;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningProcessesHeaderBinding(LinearLayout r1, TextView r2, TextView r3, LinearColorBar r4, TextView r5, TextView r6, TextView r7, TextView r8, TextView r9, TextView r10) {
        this.rootView = r1;
        this.appsSize = r2;
        this.appsSizePrefix = r3;
        this.colorBar = r4;
        this.freeSize = r5;
        this.freeSizePrefix = r6;
        this.listHeader = r7;
        this.systemSize = r8;
        this.systemSizePrefix = r9;
        this.title = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RunningProcessesHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningProcessesHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_processes_header_, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningProcessesHeaderBinding bind(View r13) {
        int r0 = R.id.appsSize;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, R.id.appsSize);
        if (r4 == null) goto L23;
        r0 = R.id.appsSizePrefix;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, R.id.appsSizePrefix);
        if (r5 == null) goto L23;
        r0 = R.id.color_bar;
        LinearColorBar r6 = (LinearColorBar) ViewBindings.findChildViewById(r13, R.id.color_bar);
        if (r6 == null) goto L23;
        r0 = R.id.freeSize;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, R.id.freeSize);
        if (r7 == null) goto L23;
        r0 = R.id.freeSizePrefix;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.freeSizePrefix);
        if (r8 == null) goto L23;
        r0 = R.id.listHeader;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, R.id.listHeader);
        if (r9 == null) goto L23;
        r0 = R.id.systemSize;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, R.id.systemSize);
        if (r10 == null) goto L23;
        r0 = R.id.systemSizePrefix;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r13, R.id.systemSizePrefix);
        if (r11 == null) goto L23;
        r0 = R.id.title;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r13, R.id.title);
        if (r12 == null) goto L23;
        return new RunningProcessesHeaderBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
