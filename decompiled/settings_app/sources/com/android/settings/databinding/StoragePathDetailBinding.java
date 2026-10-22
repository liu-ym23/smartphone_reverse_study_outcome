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
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class StoragePathDetailBinding implements ViewBinding {
    public final SettingItemCheck popupExternalStorage;
    public final SettingItemCheck popupInternalStorage;
    public final TextView preferredItemTip;
    private final RelativeLayout rootView;
    public final TextView sdPreferredItemTip;
    public final LinearLayout storageContainer;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StoragePathDetailBinding(RelativeLayout r1, SettingItemCheck r2, SettingItemCheck r3, TextView r4, TextView r5, LinearLayout r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.popupExternalStorage = r2;
        this.popupInternalStorage = r3;
        this.preferredItemTip = r4;
        this.sdPreferredItemTip = r5;
        this.storageContainer = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StoragePathDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StoragePathDetailBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_path_detail, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StoragePathDetailBinding bind(View r10) {
        int r0 = R.id.popup_external_storage;
        SettingItemCheck r4 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.popup_external_storage);
        if (r4 == null) goto L17;
        r0 = R.id.popup_internal_storage;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.popup_internal_storage);
        if (r5 == null) goto L17;
        r0 = R.id.preferred_item_tip;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.preferred_item_tip);
        if (r6 == null) goto L17;
        r0 = R.id.sd_preferred_item_tip;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.sd_preferred_item_tip);
        if (r7 == null) goto L17;
        r0 = R.id.storage_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.storage_container);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new StoragePathDetailBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
