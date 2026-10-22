package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SimpleImmersionFragment extends Fragment implements SimpleImmersionOwner {
    private SimpleImmersionProxy mSimpleImmersionProxy;

    public void com_gyf_barlibrary_SimpleImmersionFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_gyf_barlibrary_SimpleImmersionFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.gyf.barlibrary.SimpleImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SimpleImmersionFragment() {
        this.mSimpleImmersionProxy = new SimpleImmersionProxy(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        this.mSimpleImmersionProxy.setUserVisibleHint(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        this.mSimpleImmersionProxy.onActivityCreated(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        this.mSimpleImmersionProxy.onHiddenChanged(r1);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.mSimpleImmersionProxy.onConfigurationChanged(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SimpleImmersionFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_gyf_barlibrary_SimpleImmersionFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SimpleImmersionFragment r2) {
        String r0 = r2.getClass().getName();
        com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_gyf_barlibrary_SimpleImmersionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SimpleImmersionFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_gyf_barlibrary_SimpleImmersionFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
