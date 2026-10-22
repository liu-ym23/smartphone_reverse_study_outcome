package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class InstallManageStorageBinding implements ViewBinding {
    public final Button installExternalStorage;
    public final LinearLayout installExternalStorageContext;
    public final TextView installExternalStorageTips;
    private final LinearLayout rootView;
    public final StorageItemLayoutBinding sdManage;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private InstallManageStorageBinding(LinearLayout r1, Button r2, LinearLayout r3, TextView r4, StorageItemLayoutBinding r5) {
        this.rootView = r1;
        this.installExternalStorage = r2;
        this.installExternalStorageContext = r3;
        this.installExternalStorageTips = r4;
        this.sdManage = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InstallManageStorageBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static InstallManageStorageBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.install_manage_storage, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static InstallManageStorageBinding bind(View r8) {
        int r0 = R.id.install_external_storage;
        Button r4 = (Button) ViewBindings.findChildViewById(r8, R.id.install_external_storage);
        if (r4 == null) goto L13;
        r0 = R.id.install_external_storage_context;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.install_external_storage_context);
        if (r5 == null) goto L13;
        r0 = R.id.install_external_storage_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.install_external_storage_tips);
        if (r6 == null) goto L13;
        r0 = R.id.sd_manage;
        View r1 = ViewBindings.findChildViewById(r8, R.id.sd_manage);
        if (r1 == null) goto L13;
        LinearLayout r3 = (LinearLayout) r8;
        return new InstallManageStorageBinding(r3, r4, r5, r6, StorageItemLayoutBinding.bind(r1));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
