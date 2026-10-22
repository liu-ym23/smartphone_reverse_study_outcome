package com.android.settings;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PinnedHeaderListFragment extends ListFragment {
    public void com_android_settings_PinnedHeaderListFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_PinnedHeaderListFragment__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_PinnedHeaderListFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    public PinnedHeaderListFragment() {
    }

    public void setPinnedHeaderView(View r2) {
        ((ViewGroup) getListView().getParent()).addView(r2, 0);
    }

    public void clearPinnedHeaderView() {
        ((ViewGroup) getListView().getParent()).removeViewAt(0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(PinnedHeaderListFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PinnedHeaderListFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(PinnedHeaderListFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PinnedHeaderListFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_PinnedHeaderListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(PinnedHeaderListFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PinnedHeaderListFragment__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
