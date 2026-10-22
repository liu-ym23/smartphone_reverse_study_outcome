package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothSettingBottomLayoutBinding implements ViewBinding {
    public final RelativeLayout bluetoothBottomLayout;
    public final GroupListItemVerticalGapLayoutBinding bottomGap;
    public final OCardListItem btnDeviceName;
    public final OCardListItem btnShowReceivedFiles;
    public final LinearLayout groupContainer;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothSettingBottomLayoutBinding(RelativeLayout r1, RelativeLayout r2, GroupListItemVerticalGapLayoutBinding r3, OCardListItem r4, OCardListItem r5, LinearLayout r6) {
        this.rootView = r1;
        this.bluetoothBottomLayout = r2;
        this.bottomGap = r3;
        this.btnDeviceName = r4;
        this.btnShowReceivedFiles = r5;
        this.groupContainer = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothSettingBottomLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothSettingBottomLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_setting_bottom_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothSettingBottomLayoutBinding bind(View r7) {
        RelativeLayout r2 = (RelativeLayout) r7;
        int r0 = R.id.bottom_gap;
        View r1 = ViewBindings.findChildViewById(r7, R.id.bottom_gap);
        if (r1 == null) goto L13;
        GroupListItemVerticalGapLayoutBinding r3 = GroupListItemVerticalGapLayoutBinding.bind(r1);
        r0 = R.id.btn_device_name;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r7, R.id.btn_device_name);
        if (r4 == null) goto L13;
        r0 = R.id.btn_show_received_files;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r7, R.id.btn_show_received_files);
        if (r5 == null) goto L13;
        r0 = R.id.group_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r7, R.id.group_container);
        if (r6 == null) goto L13;
        return new BluetoothSettingBottomLayoutBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
