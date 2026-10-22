package com.android.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RegulatoryInfoDisplayActivity extends LifeHookActivity2 implements DialogInterface.OnDismissListener {
    private final String REGULATORY_INFO_RESOURCE;

    public void com_android_settings_RegulatoryInfoDisplayActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_RegulatoryInfoDisplayActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_RegulatoryInfoDisplayActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_RegulatoryInfoDisplayActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RegulatoryInfoDisplayActivity() {
        this.REGULATORY_INFO_RESOURCE = "regulatory_info";
    }

    public void com_android_settings_RegulatoryInfoDisplayActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        Resources r8 = getResources();
        if (r8.getBoolean(R.bool.config_show_regulatory_info) == true) goto L5;
        finish();
    L5:
        AlertDialog.Builder r0 = new AlertDialog.Builder(this).setTitle(R.string.regulatory_information).setOnDismissListener(this);
        int r1 = getResourceId();
        boolean r2 = false;
        if (r1 != 0) goto L23;
    L14:
        CharSequence r9 = r8.getText(R.string.regulatory_info_text);
        if (r2 == false) goto L18;
        View r6 = getLayoutInflater().inflate(R.layout.regulatory_info, null);
        ((ImageView) r6.findViewById(R.id.regulatoryInfo)).setImageResource(r1);
        r0.setView(r6);
        r0.show();
        return;
    L18:
        if (r9.length() <= 0) goto L20;
        r0.setMessage(r9);
        ((TextView) r0.show().findViewById(android.R.id.message)).setGravity(17);
        return;
    L20:
        finish();
        return;
    L23:
        Drawable r3 = r8.getDrawable(r1);     // Catch: Throwable -> L22
        if (r3 == null) goto L14;
        if (r3.getIntrinsicWidth() <= 2) goto L14;
        if (r3.getIntrinsicHeight() <= 2) goto L14;
        r2 = true;
        goto L14
    }

    private int getResourceId() {
        int r0 = getResources().getIdentifier("regulatory_info", "drawable", getPackageName());
        String r1 = SystemProperties.get("ro.boot.hardware.sku", "");
        if (TextUtils.isEmpty(r1) == true) goto L8;
        int r5 = getResources().getIdentifier("regulatory_info_" + r1.toLowerCase(), "drawable", getPackageName());
        if (r5 != 0) goto L7;
        return r0;
    L7:
        return r5;
    L8:
        return r0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RegulatoryInfoDisplayActivity r1) {
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(RegulatoryInfoDisplayActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RegulatoryInfoDisplayActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_RegulatoryInfoDisplayActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(RegulatoryInfoDisplayActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RegulatoryInfoDisplayActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RegulatoryInfoDisplayActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RegulatoryInfoDisplayActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_RegulatoryInfoDisplayActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(RegulatoryInfoDisplayActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_RegulatoryInfoDisplayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(RegulatoryInfoDisplayActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RegulatoryInfoDisplayActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_RegulatoryInfoDisplayActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RegulatoryInfoDisplayActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(RegulatoryInfoDisplayActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RegulatoryInfoDisplayActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_RegulatoryInfoDisplayActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RegulatoryInfoDisplayActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RegulatoryInfoDisplayActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_RegulatoryInfoDisplayActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(RegulatoryInfoDisplayActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RegulatoryInfoDisplayActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_RegulatoryInfoDisplayActivity__onStop$___twin___();
    }
}
