package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceInfoLayoutBinding implements ViewBinding {
    public final TextView idImeiSummary;
    public final TextView idImeiTitle;
    public final TextView idModelSummary;
    public final TextView idModelTitle;
    public final TextView idStorageSummary;
    public final TextView idStorageTitle;
    private final LinearLayout rootView;
    public final FrameLayout transparentView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceInfoLayoutBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, TextView r5, TextView r6, TextView r7, FrameLayout r8) {
        this.rootView = r1;
        this.idImeiSummary = r2;
        this.idImeiTitle = r3;
        this.idModelSummary = r4;
        this.idModelTitle = r5;
        this.idStorageSummary = r6;
        this.idStorageTitle = r7;
        this.transparentView = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DeviceInfoLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceInfoLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_info_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceInfoLayoutBinding bind(View r11) {
        int r0 = R.id.id_imei_summary;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_imei_summary);
        if (r4 == null) goto L19;
        r0 = R.id.id_imei_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_imei_title);
        if (r5 == null) goto L19;
        r0 = R.id.id_model_summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_model_summary);
        if (r6 == null) goto L19;
        r0 = R.id.id_model_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_model_title);
        if (r7 == null) goto L19;
        r0 = R.id.id_storage_summary;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_storage_summary);
        if (r8 == null) goto L19;
        r0 = R.id.id_storage_title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_storage_title);
        if (r9 == null) goto L19;
        r0 = R.id.transparent_view;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.transparent_view);
        if (r10 == null) goto L19;
        return new DeviceInfoLayoutBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
