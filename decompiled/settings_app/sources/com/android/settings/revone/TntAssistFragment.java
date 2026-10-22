package com.android.settings.revone;

import android.app.SmtPCUtils;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wfd.WifiDisplaySettings;
import com.android.settings.wfd.WifiDisplaySettingsFragment;
import com.android.settings.widget.SettingItemImage;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class TntAssistFragment extends BaseFragment implements View.OnClickListener {
    private SettingItemImage mConnectTntItemImage;
    private SettingItemImage mControlsTntItemImage;
    private ListContentItemText mDefaultMode;
    private final BroadcastReceiver mReceiver;
    private WifiManager mWifiManager;
    private ListContentItemText mWifiTnt;
    private View mWifiTntGap;
    private SettingItemImage mWifiTntItemImage;
    private TextView mWifiTntTips;

    public void com_android_settings_revone_TntAssistFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TntAssistFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ ListContentItemText access$000(TntAssistFragment r0) {
        return r0.mWifiTnt;
    }

    static /* synthetic */ View access$100(TntAssistFragment r0) {
        return r0.mWifiTntGap;
    }

    static /* synthetic */ TextView access$200(TntAssistFragment r0) {
        return r0.mWifiTntTips;
    }

    public TntAssistFragment() {
        super(R.layout.revone_fragment_bytedance_tnt_assist);
        this.mReceiver = new AnonymousClass1(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        OFloatingTitleBar r4 = this.mTitleView;
        if (this.mIsExtDisplaying == false) goto L6;
        if (r4 == null) goto L6;
        r4.setCenterTitle(R.string.connection_mode_pager_header_title);
    L6:
        ListContentItemText r5 = (ListContentItemText) findViewByIdNullable(R.id.tnt_default_mode);
        this.mDefaultMode = r5;
        r5.setOnClickListener(this);
        ListContentItemText r6 = (ListContentItemText) findViewByIdNullable(R.id.wifi_tnt);
        this.mWifiTnt = r6;
        r6.setOnClickListener(this);
        TextView r7 = (TextView) findViewByIdNullable(R.id.controls_hint_tips);
        getString(R.string.bytedance_keyboard);
        getString(R.string.bytedance_mouse);
        SpannableString r8 = SpannableString.valueOf(getString(R.string.controls_hint_tips));
        this.mWifiTntTips = (TextView) findViewByIdNullable(R.id.wifi_tnt_tips);
        this.mWifiTntGap = findViewByIdNullable(R.id.wifi_tnt_gap_layout);
        this.mControlsTntItemImage = (SettingItemImage) findViewByIdNullable(R.id.controls_tnt_item_image);
        this.mConnectTntItemImage = (SettingItemImage) findViewByIdNullable(R.id.connect_tnt_item_image);
        this.mWifiTntItemImage = (SettingItemImage) findViewByIdNullable(R.id.wifi_tnt_item_image);
        r7.setText(r8);
        r7.setMovementMethod(LinkMovementMethod.getInstance());
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        showModeTitle();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, r0, 2);
        ListContentItemText r1 = this.mWifiTnt;
        if (this.mWifiManager.getWifiState() != 3) goto L5;
        boolean r2 = true;
    L6:
        r1.setEnabled(r2);
        if (this.mWifiManager.getWifiState() != 3) goto L9;
        this.mWifiTntGap.setVisibility(0);
        this.mWifiTntTips.setVisibility(8);
    L11:
        if (this.mIsExtDisplaying == false) goto L14;
        this.mWifiTntItemImage.setImageResource(R.drawable.revone_phone_connect_tnt_land);
        this.mConnectTntItemImage.setImageResource(R.drawable.revone_connection_hint_land);
        this.mControlsTntItemImage.setImageResource(R.drawable.revone_operation_method_land);
        return;
    L14:
        return;
    L9:
        this.mWifiTntGap.setVisibility(8);
        this.mWifiTntTips.setVisibility(0);
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mReceiver);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mDefaultMode) goto L6;
        start(TntModeFragment.class);
        return;
    L6:
        if (r3 != this.mWifiTnt) goto L10;
        Bundle r4 = new Bundle();
        r4.putBoolean(WifiDisplaySettings.EXTRA_ENTRY_FLAG, false);
        start(WifiDisplaySettingsFragment.class, r4);
        return;
    }

    private int getTntDefaultMode() {
        return Settings.Secure.getInt(getContentResolver(), "pc_mode_enable", 1);
    }

    private void showModeTitle() {
        if (getTntDefaultMode() != 0) goto L6;
        String r0 = getString(R.string.tnt_default_display_mode_mirror);
    L9:
        this.mDefaultMode.setSubtitle(r0);
        return;
    L6:
        if (getShareMode() == false) goto L8;
        r0 = getString(R.string.tnt_default_display_mode_share);
        goto L9
    L8:
        r0 = getString(R.string.tnt_default_display_mode_tnt);
        goto L9
    }

    private boolean getShareMode() {
        if (SmtPCUtils.getDesktopMode(this.mContext) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TntAssistFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TntAssistFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TntAssistFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TntAssistFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TntAssistFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TntAssistFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
