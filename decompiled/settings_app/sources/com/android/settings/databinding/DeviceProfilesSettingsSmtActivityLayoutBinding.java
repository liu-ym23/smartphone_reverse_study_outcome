package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceProfilesSettingsSmtActivityLayoutBinding implements ViewBinding {
    public final LinearLayout advancedContainer;
    public final OCardListItem advancedSetting;
    public final LinearLayout autoDisconnectContainer;
    public final FrameLayout btnLayoutBottom;
    public final FrameLayout btnLayoutRecordVoicePrint;
    public final FrameLayout btnLayoutTop;
    public final OButton btnRecordVoicePrint;
    public final OCardListItem codecItem;
    public final OCardListItem connectionTimer;
    public final OCardListItem deviceRename;
    public final OButton disconnectBtn;
    public final ODownloadProgressView loadingView;
    public final ItemSubSettingsPaddingLayout2Binding profilesBottomView;
    public final LinearLayout profilesContainer;
    public final TextView profilesHeaderTitle;
    private final RelativeLayout rootView;
    public final OButton unpairBtn;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceProfilesSettingsSmtActivityLayoutBinding(RelativeLayout r3, LinearLayout r4, OCardListItem r5, LinearLayout r6, FrameLayout r7, FrameLayout r8, FrameLayout r9, OButton r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OButton r14, ODownloadProgressView r15, ItemSubSettingsPaddingLayout2Binding r16, LinearLayout r17, TextView r18, OButton r19, OFloatingTitleBar r20) {
        this.rootView = r3;
        this.advancedContainer = r4;
        this.advancedSetting = r5;
        this.autoDisconnectContainer = r6;
        this.btnLayoutBottom = r7;
        this.btnLayoutRecordVoicePrint = r8;
        this.btnLayoutTop = r9;
        this.btnRecordVoicePrint = r10;
        this.codecItem = r11;
        this.connectionTimer = r12;
        this.deviceRename = r13;
        this.disconnectBtn = r14;
        this.loadingView = r15;
        this.profilesBottomView = r16;
        this.profilesContainer = r17;
        this.profilesHeaderTitle = r18;
        this.unpairBtn = r19;
        this.viewTitle = r20;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceProfilesSettingsSmtActivityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceProfilesSettingsSmtActivityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_profiles_settings_smt_activity_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceProfilesSettingsSmtActivityLayoutBinding bind(View r22) {
        int r1 = R.id.advanced_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r22, R.id.advanced_container);
        if (r5 == null) goto L39;
        r1 = R.id.advanced_setting;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r22, R.id.advanced_setting);
        if (r6 == null) goto L39;
        r1 = R.id.auto_disconnect_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r22, R.id.auto_disconnect_container);
        if (r7 == null) goto L39;
        r1 = R.id.btnLayoutBottom;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r22, R.id.btnLayoutBottom);
        if (r8 == null) goto L39;
        r1 = R.id.btnLayoutRecordVoicePrint;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r22, R.id.btnLayoutRecordVoicePrint);
        if (r9 == null) goto L39;
        r1 = R.id.btnLayoutTop;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r22, R.id.btnLayoutTop);
        if (r10 == null) goto L39;
        r1 = R.id.btn_record_voice_print;
        OButton r11 = (OButton) ViewBindings.findChildViewById(r22, R.id.btn_record_voice_print);
        if (r11 == null) goto L39;
        r1 = R.id.codec_item;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r22, R.id.codec_item);
        if (r12 == null) goto L39;
        r1 = R.id.connection_timer;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r22, R.id.connection_timer);
        if (r13 == null) goto L39;
        r1 = R.id.device_rename;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r22, R.id.device_rename);
        if (r14 == null) goto L39;
        r1 = R.id.disconnect_btn;
        OButton r15 = (OButton) ViewBindings.findChildViewById(r22, R.id.disconnect_btn);
        if (r15 == null) goto L39;
        r1 = R.id.loading_view;
        ODownloadProgressView r16 = (ODownloadProgressView) ViewBindings.findChildViewById(r22, R.id.loading_view);
        if (r16 == null) goto L39;
        r1 = R.id.profiles_bottom_view;
        View r2 = ViewBindings.findChildViewById(r22, R.id.profiles_bottom_view);
        if (r2 == null) goto L39;
        ItemSubSettingsPaddingLayout2Binding r17 = ItemSubSettingsPaddingLayout2Binding.bind(r2);
        r1 = R.id.profiles_container;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r22, R.id.profiles_container);
        if (r18 == null) goto L39;
        r1 = R.id.profiles_header_title;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r22, R.id.profiles_header_title);
        if (r19 == null) goto L39;
        r1 = R.id.unpair_btn;
        OButton r20 = (OButton) ViewBindings.findChildViewById(r22, R.id.unpair_btn);
        if (r20 == null) goto L39;
        r1 = R.id.view_title;
        OFloatingTitleBar r21 = (OFloatingTitleBar) ViewBindings.findChildViewById(r22, R.id.view_title);
        if (r21 == null) goto L39;
        return new DeviceProfilesSettingsSmtActivityLayoutBinding((RelativeLayout) r22, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r1)));
    }
}
