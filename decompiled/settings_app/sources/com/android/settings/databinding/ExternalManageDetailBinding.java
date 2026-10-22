package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.deviceinfo.StorageProgressBar;
import com.android.settings.widget.DisableTipsButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ExternalManageDetailBinding implements ViewBinding {
    public final SettingItemText defaultStoragePath;
    public final DisableTipsButton eraseExternalStorage;
    public final LinearLayout externalStorageContent;
    public final TextView externalStorageFree;
    public final TextView externalStorageFreeSize;
    public final TextView externalStorageTotal;
    public final TextView externalStorageTotalSize;
    public final View gap;
    public final TextView phoneDesktopConnect;
    private final RelativeLayout rootView;
    public final SettingItemText sdFileStorageDetail;
    public final StorageProgressBar storageProgessBar;
    public final DisableTipsButton unmountExternalStorage;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ExternalManageDetailBinding(RelativeLayout r1, SettingItemText r2, DisableTipsButton r3, LinearLayout r4, TextView r5, TextView r6, TextView r7, TextView r8, View r9, TextView r10, SettingItemText r11, StorageProgressBar r12, DisableTipsButton r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.defaultStoragePath = r2;
        this.eraseExternalStorage = r3;
        this.externalStorageContent = r4;
        this.externalStorageFree = r5;
        this.externalStorageFreeSize = r6;
        this.externalStorageTotal = r7;
        this.externalStorageTotalSize = r8;
        this.gap = r9;
        this.phoneDesktopConnect = r10;
        this.sdFileStorageDetail = r11;
        this.storageProgessBar = r12;
        this.unmountExternalStorage = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExternalManageDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ExternalManageDetailBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.external_manage_detail, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ExternalManageDetailBinding bind(View r18) {
        int r1 = R.id.default_storage_path;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r18, R.id.default_storage_path);
        if (r5 == null) goto L31;
        r1 = R.id.erase_external_storage;
        DisableTipsButton r6 = (DisableTipsButton) ViewBindings.findChildViewById(r18, R.id.erase_external_storage);
        if (r6 == null) goto L31;
        r1 = R.id.external_storage_content;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.external_storage_content);
        if (r7 == null) goto L31;
        r1 = R.id.external_storage_free;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r18, R.id.external_storage_free);
        if (r8 == null) goto L31;
        r1 = R.id.external_storage_free_size;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r18, R.id.external_storage_free_size);
        if (r9 == null) goto L31;
        r1 = R.id.external_storage_total;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r18, R.id.external_storage_total);
        if (r10 == null) goto L31;
        r1 = R.id.external_storage_total_size;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r18, R.id.external_storage_total_size);
        if (r11 == null) goto L31;
        r1 = R.id.gap;
        View r12 = ViewBindings.findChildViewById(r18, R.id.gap);
        if (r12 == null) goto L31;
        r1 = R.id.phone_desktop_connect;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r18, R.id.phone_desktop_connect);
        if (r13 == null) goto L31;
        r1 = R.id.sd_file_storage_detail;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r18, R.id.sd_file_storage_detail);
        if (r14 == null) goto L31;
        r1 = R.id.storage_progess_bar;
        StorageProgressBar r15 = (StorageProgressBar) ViewBindings.findChildViewById(r18, R.id.storage_progess_bar);
        if (r15 == null) goto L31;
        r1 = R.id.unmount_external_storage;
        DisableTipsButton r16 = (DisableTipsButton) ViewBindings.findChildViewById(r18, R.id.unmount_external_storage);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new ExternalManageDetailBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
