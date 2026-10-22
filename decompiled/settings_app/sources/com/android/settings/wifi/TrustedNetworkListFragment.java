package com.android.settings.wifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TrustedNetworkListFragment extends BaseFragment {
    private TrustedNetworkList mTrustedNetworkList;

    public void com_android_settings_wifi_TrustedNetworkListFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_TrustedNetworkListFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TrustedNetworkListFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (this.mIsLandScreen == false) goto L8;
        if (this.mIsExtDisplaying == false) goto L8;
        return r2.inflate(R.layout.trusted_network_list_land_activity, r3, false);
    L8:
        return r2.inflate(R.layout.trusted_network_list_activity, r3, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        this.mTrustedNetworkList = (TrustedNetworkList) getChildFragmentManager().findFragmentById(R.id.trusted_network_list_fragment);
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        TrustedNetworkList r0 = this.mTrustedNetworkList;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.onBackPressed() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TrustedNetworkListFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkListFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TrustedNetworkListFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_TrustedNetworkListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TrustedNetworkListFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_TrustedNetworkListFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
