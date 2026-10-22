package com.android.settings.wifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.WifiConfigurationSmtOnly;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.RegisterUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TrustedNetworkSettings extends Fragment implements View.OnClickListener {
    private static final String PREF_SHOW_TRUSTED_NETWORK_SETTINGS = "show_trusted_network_settings";
    private static final String TAG = "TrustedNetworkSettings";
    private TextView mAccessPointName;
    private WifiConfiguration mConfig;
    private TextView mDescription;
    private IntentFilter mIntentFilter;
    private View mNoNotify;
    private WifiManager.ActionListener mSaveListener;
    private OListItemSettings mSet;
    private OListItemSettings mUnset;
    private WifiManager wifiManager;
    private BroadcastReceiver wifiReceiver;

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TrustedNetworkSettings() {
        this.wifiReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(TrustedNetworkSettings r0, Intent r1) {
        r0.handleWifiEvent(r1);
    }

    public void com_android_settings_wifi_TrustedNetworkSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.wifiManager = (WifiManager) getActivity().getSystemService("wifi");
        if (com.android.settings.Utils.isWifiNetwork(getActivity()) == true) goto L6;
        OLog.d(TAG, "current is not wifi network, finish");
        getActivity().finish();
        return;
    L6:
        initFilter();
        this.mSaveListener = new AnonymousClass1(this);
    }

    private void initCurrentWifiConfig() {
        List<WifiConfiguration> r0 = this.wifiManager.getConfiguredNetworks();     // Catch: RuntimeException -> L4
    L6:
        android.net.wifi.WifiInfo r1 = this.wifiManager.getConnectionInfo();
        if (r1 == null) goto L21;
        if (r0 == null) goto L22;
        int r2 = r1.getNetworkId();
        Iterator<WifiConfiguration> r3 = r0.iterator();
    L11:
        if (r3.hasNext() == false) goto L23;
        WifiConfiguration r4 = r3.next();
        if (r4.networkId != r2) goto L11;
        this.mConfig = r4;
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L6
    }

    private void setTrusted(boolean r3) {
        if (this.mConfig.networkId != (-1)) goto L6;
        OLog.w(TAG, "invalid network , failed to set trusted");
        return;
    L6:
        WifiConfiguration r0 = this.mConfig;
        if (r0 == null) goto L9;
        WifiConfigurationSmtOnly.set_isTrustedAp(r0, r3);
    L9:
        this.wifiManager.save(this.mConfig, this.mSaveListener);
        getActivity().sendBroadcast(new Intent(AccessPointDetailFragment.TRUST_AP_CHANGED_ACTION));
    }

    private void initFilter() {
        IntentFilter r0 = new IntentFilter();
        this.mIntentFilter = r0;
        r0.addAction("android.net.wifi.STATE_CHANGE");
    }

    private void handleWifiEvent(Intent r3) {
        if ("android.net.wifi.STATE_CHANGE".equals(r3.getAction()) == false) goto L11;
        NetworkInfo r4 = (NetworkInfo) r3.getParcelableExtra("networkInfo");
        if (r4 != null) goto L7;
    L9:
        OLog.d(TAG, "wifi disconnected, finish");
        getActivity().finish();
        return;
    L7:
        if (r4.isConnected() == false) goto L9;
        initCurrentWifiConfig();
        setupUI();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.trusted_network_settings, r3, false);
        this.mAccessPointName = (TextView) r5.findViewById(R.id.access_point_name);
        this.mDescription = (TextView) r5.findViewById(R.id.description);
        OListItemSettings r6 = (OListItemSettings) r5.findViewById(R.id.btn_set);
        this.mSet = r6;
        r6.setOnClickListener(this);
        OListItemSettings r7 = (OListItemSettings) r5.findViewById(R.id.btn_unset);
        this.mUnset = r7;
        r7.setOnClickListener(this);
        View r8 = r5.findViewById(R.id.no_notify);
        this.mNoNotify = r8;
        r8.setOnClickListener(this);
        setupUI();
        return r5;
    }

    private void setupUI() {
        WifiConfiguration r0 = this.mConfig;
        if (r0 == null) goto L6;
        String r1 = AccessPoint.removeDoubleQuotes(r0.SSID);
        this.mAccessPointName.setText(r1);
        this.mDescription.setText(String.format(getString(R.string.trusted_network_description), new Object[]{r1, r1}));
        this.mSet.setTitleString(String.format(getString(R.string.trusted_network_set_btn), new Object[]{r1}));
        this.mUnset.setTitleString(String.format(getString(R.string.trusted_network_unset_btn), new Object[]{r1}));
        return;
    }

    public void com_android_settings_wifi_TrustedNetworkSettings__onResume$___twin___() {
        super.onResume();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.wifiReceiver, this.mIntentFilter, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        RegisterUtils.unRegisterBroadcastReceiverSafely(TAG, getActivity(), this.wifiReceiver);
    }

    public static void gotoSetTrustedNetworkIfNeeded(Activity r3) {
        boolean r0 = PreferenceMgr.getInstance(r3).getBoolean(PREF_SHOW_TRUSTED_NETWORK_SETTINGS, true);
        if (com.android.settings.Utils.isUseStrictLockScreen(r3) == true) goto L11;
        if (r0 == true) goto L6;
        return;
    L6:
        if (com.android.settings.Utils.isWifiNetwork(r3) == true) goto L8;
        return;
    L8:
        if (isCurrentApCanBeTrusted(r3) == false) goto L14;
        com.android.settings.Utils.startActivity(r3, new Intent(r3, TrustedNetworkSettingsActivity.class), 2);
        return;
    L14:
        return;
    }

    private static boolean isCurrentApCanBeTrusted(Context r4) {
        WifiManager r5 = (WifiManager) r4.getSystemService("wifi");
        WifiConfiguration r0 = null;
        List<WifiConfiguration> r1 = r5.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L7:
        android.net.wifi.WifiInfo r6 = r5.getConnectionInfo();
        if (r6 == null) goto L16;
        if (r1 == null) goto L16;
        int r7 = r6.getNetworkId();
        Iterator<WifiConfiguration> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        WifiConfiguration r3 = r2.next();
        if (r3.networkId != r7) goto L12;
        r0 = r3;
    L16:
        if (r0 != null) goto L18;
    L22:
        return false;
    L18:
        if (WifiConfigurationSmtOnly.get_isTrustedAp(r0) == true) goto L22;
        if (AccessPoint.getSecurity(r0) == 0) goto L22;
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mSet) goto L6;
        setTrusted(true);
    L11:
        getActivity().finish();
        return;
    L6:
        if (r3 != this.mUnset) goto L9;
        setTrusted(false);
        goto L11
    L9:
        if (r3 != this.mNoNotify) goto L11;
        PreferenceMgr.getInstance(getActivity()).putBoolean(PREF_SHOW_TRUSTED_NETWORK_SETTINGS, false);
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TrustedNetworkSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TrustedNetworkSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TrustedNetworkSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
