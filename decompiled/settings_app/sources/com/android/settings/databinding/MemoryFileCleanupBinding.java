package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryFileCleanupBinding implements ViewBinding {
    public final SettingItemText appManagement;
    public final SettingItemText bigFilesCleanup;
    public final SettingItemText junkFilesCleanup;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MemoryFileCleanupBinding(LinearLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4) {
        this.rootView = r1;
        this.appManagement = r2;
        this.bigFilesCleanup = r3;
        this.junkFilesCleanup = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MemoryFileCleanupBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryFileCleanupBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.memory_file_cleanup, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MemoryFileCleanupBinding bind(View r4) {
        int r0 = R.id.app_management;
        SettingItemText r1 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.app_management);
        if (r1 == null) goto L11;
        r0 = R.id.big_files_cleanup;
        SettingItemText r2 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.big_files_cleanup);
        if (r2 == null) goto L11;
        r0 = R.id.junk_files_cleanup;
        SettingItemText r3 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.junk_files_cleanup);
        if (r3 == null) goto L11;
        return new MemoryFileCleanupBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
