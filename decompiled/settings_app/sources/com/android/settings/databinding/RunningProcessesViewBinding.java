package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class RunningProcessesViewBinding implements ViewBinding {
    public final BottomTipsLayoutBinding bottomView;
    public final TextView empty;
    public final OListView list;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RunningProcessesViewBinding(LinearLayout r1, BottomTipsLayoutBinding r2, TextView r3, OListView r4) {
        this.rootView = r1;
        this.bottomView = r2;
        this.empty = r3;
        this.list = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RunningProcessesViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RunningProcessesViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.running_processes_view_, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RunningProcessesViewBinding bind(View r4) {
        int r0 = R.id.bottom_view;
        View r1 = ViewBindings.findChildViewById(r4, R.id.bottom_view);
        if (r1 == null) goto L12;
        BottomTipsLayoutBinding r2 = BottomTipsLayoutBinding.bind(r1);
        int r3 = android.R.id.empty;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.empty);
        if (r5 == null) goto L10;
        r3 = android.R.id.list;
        OListView r6 = (OListView) ViewBindings.findChildViewById(r4, android.R.id.list);
        if (r6 == null) goto L10;
        return new RunningProcessesViewBinding((LinearLayout) r4, r2, r5, r6);
    L10:
        r0 = r3;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
