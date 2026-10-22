package com.bumptech.glide.manager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
public class SupportRequestManagerFragment extends Fragment {
    public void com_bumptech_glide_manager_SupportRequestManagerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_bumptech_glide_manager_SupportRequestManagerFragment__onResume$___twin___() {
        super.onResume();
    }

    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Deprecated
    public void setRequestManager(RequestManager r1) {
    }

    public SupportRequestManagerFragment() {
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new EmptyRequestManagerTreeNode();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SupportRequestManagerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_bumptech_glide_manager_SupportRequestManagerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SupportRequestManagerFragment r2) {
        String r0 = r2.getClass().getName();
        com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_bumptech_glide_manager_SupportRequestManagerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SupportRequestManagerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_bumptech_glide_manager_SupportRequestManagerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
