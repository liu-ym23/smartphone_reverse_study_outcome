package com.bumptech.glide.manager;

import android.app.Fragment;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bumptech.glide.RequestManager;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    public void com_bumptech_glide_manager_RequestManagerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_bumptech_glide_manager_RequestManagerFragment__onPause$___twin___() {
        super.onPause();
    }

    public void com_bumptech_glide_manager_RequestManagerFragment__onResume$___twin___() {
        super.onResume();
    }

    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r1) {
        com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
    }

    @Deprecated
    public void setRequestManager(RequestManager r1) {
    }

    public RequestManagerFragment() {
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new AnonymousClass1(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(RequestManagerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_bumptech_glide_manager_RequestManagerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(RequestManagerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_bumptech_glide_manager_RequestManagerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_bumptech_glide_manager_RequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(RequestManagerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_bumptech_glide_manager_RequestManagerFragment__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
