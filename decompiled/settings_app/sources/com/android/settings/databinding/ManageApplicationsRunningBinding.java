package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.applications.RunningProcessesView_;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsRunningBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RunningProcessesView_ runningProcesses;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsRunningBinding(LinearLayout r1, RunningProcessesView_ r2) {
        this.rootView = r1;
        this.runningProcesses = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsRunningBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsRunningBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_running_, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsRunningBinding bind(View r2) {
        RunningProcessesView_ r1 = (RunningProcessesView_) ViewBindings.findChildViewById(r2, R.id.running_processes);
        if (r1 == null) goto L7;
        return new ManageApplicationsRunningBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.running_processes)));
    }
}
