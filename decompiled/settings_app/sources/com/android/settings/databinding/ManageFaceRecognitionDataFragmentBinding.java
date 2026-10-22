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
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageFaceRecognitionDataFragmentBinding implements ViewBinding {
    public final OCardListItem faceDataManageSwitch2;
    public final OCardListItem faceDataManageSwitch3;
    public final TextView faceDataTitleView;
    public final LinearLayout pageContainer;
    public final LinearLayout pageScrollview;
    public final OButton removeFaceData;
    private final RelativeLayout rootView;
    public final OCheckBox useFcInLockScreenSetting;
    public final OCardListItem useFcInPrivacyPasswordSetting;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageFaceRecognitionDataFragmentBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, TextView r4, LinearLayout r5, LinearLayout r6, OButton r7, OCheckBox r8, OCardListItem r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.faceDataManageSwitch2 = r2;
        this.faceDataManageSwitch3 = r3;
        this.faceDataTitleView = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.removeFaceData = r7;
        this.useFcInLockScreenSetting = r8;
        this.useFcInPrivacyPasswordSetting = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageFaceRecognitionDataFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageFaceRecognitionDataFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_face_recognition_data_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageFaceRecognitionDataFragmentBinding bind(View r13) {
        int r0 = R.id.face_data_manage_switch_2;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.face_data_manage_switch_2);
        if (r4 == null) goto L23;
        r0 = R.id.face_data_manage_switch_3;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.face_data_manage_switch_3);
        if (r5 == null) goto L23;
        r0 = R.id.face_data_title_view;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, R.id.face_data_title_view);
        if (r6 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r7 == null) goto L23;
        r0 = R.id.page_scrollview;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r8 == null) goto L23;
        r0 = R.id.remove_face_data;
        OButton r9 = (OButton) ViewBindings.findChildViewById(r13, R.id.remove_face_data);
        if (r9 == null) goto L23;
        r0 = R.id.use_fc_in_lock_screen_setting;
        OCheckBox r10 = (OCheckBox) ViewBindings.findChildViewById(r13, R.id.use_fc_in_lock_screen_setting);
        if (r10 == null) goto L23;
        r0 = R.id.use_fc_in_privacy_password_setting;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.use_fc_in_privacy_password_setting);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new ManageFaceRecognitionDataFragmentBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
