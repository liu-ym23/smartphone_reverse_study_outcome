package com.android.settings.deviceinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class StorageWizardMigrateConfirm extends BaseStorageWizard {
    private MigrateEstimateTask mEstimate;

    public void com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_StorageWizardMigrateConfirm__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.deviceinfo.BaseStorageWizard, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public StorageWizardMigrateConfirm() {
    }

    public void com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.storage_wizard_generic);
        if (this.mVolume != null) goto L5;
        this.mVolume = findFirstVolume(1);
    L5:
        VolumeInfo r7 = getPackageManager().getPrimaryStorageCurrentVolume();
        if (r7 != null) goto L8;
    L12:
        OLog.d("StorageSettings", "Missing either source or target volume");
        finish();
        return;
    L8:
        if (this.mVolume == null) goto L12;
        final String r8 = this.mStorage.getBestVolumeDescription(r7);
        String r1 = this.mStorage.getBestVolumeDescription(this.mVolume);
        setIllustrationType(1);
        setHeaderText(R.string.storage_wizard_migrate_confirm_title, new String[]{r1});
        setBodyText(R.string.memory_calculating_size, new String[0]);
        setSecondaryBodyText(R.string.storage_wizard_migrate_details, new String[]{r1});
        MigrateEstimateTask r0 = new AnonymousClass1(this, this, r8);
        this.mEstimate = r0;
        r0.copyFrom(getIntent());
        this.mEstimate.execute(new Void[0]);
        getNextButton().setText(R.string.storage_wizard_migrate_confirm_next);
    }

    @Override // com.android.settings.deviceinfo.BaseStorageWizard
    public void onNavigateNext() {
        int r0 = getPackageManager().movePrimaryStorage(this.mVolume);     // Catch: IllegalStateException -> L5 IllegalArgumentException -> L7
        Intent r1 = new Intent(this, StorageWizardMigrateProgress.class);
        r1.putExtra("android.os.storage.extra.VOLUME_ID", this.mVolume.getId());
        r1.putExtra("android.content.pm.extra.MOVE_ID", r0);
        startActivity(r1);
        finishAffinity();
        return;
    L7:
        e = move-exception;
        StorageManager r2 = (StorageManager) getSystemService("storage");
        if (Objects.equals(this.mVolume.getFsUuid(), r2.getPrimaryStorageVolume().getUuid()) == false) goto L12;
        Intent r3 = new Intent(this, StorageWizardReady.class);
        r3.putExtra("android.os.storage.extra.DISK_ID", getIntent().getStringExtra("android.os.storage.extra.DISK_ID"));
        startActivity(r3);
        finishAffinity();
        return;
    L12:
        throw e;
    L5:
        ToastUtils.show(this, getString(R.string.another_migration_already_in_progress));
        finishAffinity();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(StorageWizardMigrateConfirm r1) {
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(StorageWizardMigrateConfirm r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardMigrateConfirm r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_onResume(StorageWizardMigrateConfirm r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(StorageWizardMigrateConfirm r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        StorageWizardMigrateConfirm r5 = r4;
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
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(StorageWizardMigrateConfirm r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_StorageWizardMigrateConfirm__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_BatchedActivityLancet_onStop(StorageWizardMigrateConfirm r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onResume(StorageWizardMigrateConfirm r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardMigrateConfirm r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(StorageWizardMigrateConfirm r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onPause(StorageWizardMigrateConfirm r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardMigrateConfirm r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(StorageWizardMigrateConfirm r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        StorageWizardMigrateConfirm r5 = r3;
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
    public static void com_android_settings_deviceinfo_StorageWizardMigrateConfirm_com_obric_hook_lancet_PrivacyHookActivity2_onStop(StorageWizardMigrateConfirm r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardMigrateConfirm r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardMigrateConfirm__onStop$___twin___();
    }
}
