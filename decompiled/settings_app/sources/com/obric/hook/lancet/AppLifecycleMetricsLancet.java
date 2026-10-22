package com.obric.hook.lancet;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: AppLifecycleMetricsLancet.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/hook/lancet/AppLifecycleMetricsLancet;", "", "()V", "onCreate_Activity", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate_Fragment", "onCreate_FragmentX", "onCreate_Provider", "onPause_Activity", "onPause_Fragment", "onPause_FragmentX", "onResume_Activity", "onResume_Fragment", "onResume_FragmentX", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppLifecycleMetricsLancet {
    public static final AppLifecycleMetricsLancet INSTANCE = null;

    static {
        INSTANCE = new AppLifecycleMetricsLancet();
    }

    public AppLifecycleMetricsLancet() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public final void onResume_Activity() {
        String r4 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r4);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r4);
        r0.recordVisibleTime(r4);
        Object r1 = This.get();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        Activity r2 = (Activity) r1;
        String r3 = r2.getCallingPackage();
        if (r3 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r5 = r2.getReferrer();
        if (r5 == null) goto L9;
        r3 = r5.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r3);
        if (r3 != null) goto L12;
        r3 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r3, r4);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public final void onPause_Activity() {
        String r4 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r4);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r4);
        AppMetricsUtils.reportVisibleTime$default(r0, r4, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public final void onCreate_Provider() {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.reportColdStartProvider(r2);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public final void onCreate_Activity(Bundle r4) {
        String r3 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r3);
        Object r5 = This.get();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.Activity");
        Activity r6 = (Activity) r5;
        String r1 = r6.getCallingPackage();
        if (r1 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r6.getReferrer();
        if (r7 == null) goto L9;
        r1 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r1);
        if (r1 != null) goto L12;
        r1 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r3);
        r8.callingPackageEvent(r1, r3, false);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public final void onCreate_Fragment(Bundle r3) {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_Fragment " + r2);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r4.callingPackageEvent("self", r2, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public final void onCreate_FragmentX(Bundle r3) {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r2);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r4.callingPackageEvent("self", r2, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public final void onResume_Fragment() {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_Fragment " + r2);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.recordVisibleTime(r2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public final void onResume_FragmentX() {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r2);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.recordVisibleTime(r2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onPause")
    public final void onPause_Fragment() {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Fragment " + r2);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.reportVisibleTime(r2, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public final void onPause_FragmentX() {
        String r2 = This.get().getClass().getName();
        Origin.callVoid();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r2);
        AppMetricsUtils r0 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.reportVisibleTime(r2, true);
        return;
    }
}
