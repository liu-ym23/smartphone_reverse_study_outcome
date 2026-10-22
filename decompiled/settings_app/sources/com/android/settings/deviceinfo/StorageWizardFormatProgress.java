package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.IPackageMoveObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.viewmodel.PartitionTaskViewModel;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class StorageWizardFormatProgress extends BaseStorageWizard {
    private static final String TAG_SLOW_WARNING = "slow_warning";
    private boolean mFormatPrivate;
    private PartitionTask mTask;
    private PartitionTaskViewModel mViewModel;

    /* JADX INFO: renamed from: com.android.settings.deviceinfo.StorageWizardFormatProgress$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class PartitionTask extends AsyncTask<Void, Integer, Exception> {
        public StorageWizardFormatProgress mActivity;
        private volatile long mInternalBench;
        private volatile long mPrivateBench;
        private volatile int mProgress;

        public PartitionTask() {
            this.mProgress = 20;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Exception doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Exception r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] r1) {
            onProgressUpdate2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Exception doInBackground2(Void... r7) {
            StorageWizardFormatProgress r8 = this.mActivity;
            StorageManager r0 = r8.mStorage;
            AnonymousClass1 r2 = null;
            if (StorageWizardFormatProgress.access$000(r8) == false) goto L10;
            r0.partitionPrivate(r8.mDisk.getId());     // Catch: Exception -> L12
            publishProgress(new Integer[]{40});     // Catch: Exception -> L12
            this.mInternalBench = r0.benchmark(null);     // Catch: Exception -> L12
            publishProgress(new Integer[]{60});     // Catch: Exception -> L12
            VolumeInfo r1 = r8.findFirstVolume(1);     // Catch: Exception -> L12
            this.mPrivateBench = r0.benchmark(r1.getId());     // Catch: Exception -> L12
            if (r8.mDisk.isDefaultPrimary() == true) goto L8;
        L11:
            return null;
        L8:
            if (Objects.equals(r0.getPrimaryStorageUuid(), "primary_physical") == false) goto L11;
            OLog.d("StorageSettings", "Just formatted primary physical; silently moving storage to new emulated volume");     // Catch: Exception -> L12
            r0.setPrimaryStorageUuid(r1.getFsUuid(), new SilentObserver(r2));     // Catch: Exception -> L12
            goto L11
        L10:
            r0.partitionPublic(r8.mDisk.getId());     // Catch: Exception -> L12
        L12:
            e = move-exception;
            return e;
        }

        /* JADX INFO: renamed from: onProgressUpdate, reason: avoid collision after fix types in other method */
        protected void onProgressUpdate2(Integer... r2) {
            this.mProgress = r2[0].intValue();
            this.mActivity.setCurrentProgress(this.mProgress);
        }

        public void setActivity(StorageWizardFormatProgress r1) {
            this.mActivity = r1;
            r1.setCurrentProgress(this.mProgress);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Exception r5) {
            StorageWizardFormatProgress r0 = this.mActivity;
            if (r5 == null) goto L7;
            OLog.e("StorageSettings", "Failed to partition", r5);
            ToastUtils.show(r0, r5.getMessage());
            r0.finishAffinity();
            return;
        L7:
            if (StorageWizardFormatProgress.access$000(r0) == false) goto L15;
            float r6 = this.mInternalBench / this.mPrivateBench;
            OLog.d("StorageSettings", "New volume is " + r6 + "x the speed of internal");
            if (Float.isNaN(r6) == false) goto L11;
        L14:
            new SlowWarningFragment().show(r0.getSupportFragmentManager(), StorageWizardFormatProgress.TAG_SLOW_WARNING);
            return;
        L11:
            if (r6 < 0.25d) goto L14;
            StorageWizardFormatProgress.access$200(r0);
            return;
        L15:
            StorageWizardFormatProgress.access$200(r0);
        }
    }

    private static class SilentObserver extends IPackageMoveObserver.Stub {
        public void onCreated(int r1, Bundle r2) {
        }

        public void onStatusChanged(int r1, int r2, long r3) {
        }

        private SilentObserver() {
        }

        /* synthetic */ SilentObserver(AnonymousClass1 r1) {
            this();
        }
    }

    public static class SlowWarningFragment extends DialogFragment {
        public void com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public SlowWarningFragment() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r6) {
            AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity());
            StorageWizardFormatProgress r7 = (StorageWizardFormatProgress) getActivity();
            String r1 = StorageWizardFormatProgress.access$300(r7);
            String r8 = StorageWizardFormatProgress.access$400(r7);
            r0.setMessage(TextUtils.expandTemplate(getText(R.string.storage_wizard_slow_body), new CharSequence[]{r1, r8}));
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
            return r0.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SlowWarningFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SlowWarningFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SlowWarningFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_deviceinfo_StorageWizardFormatProgress$SlowWarningFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_deviceinfo_StorageWizardFormatProgress__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_StorageWizardFormatProgress__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_deviceinfo_StorageWizardFormatProgress__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_StorageWizardFormatProgress__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.deviceinfo.BaseStorageWizard, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public StorageWizardFormatProgress() {
    }

    static /* synthetic */ boolean access$000(StorageWizardFormatProgress r0) {
        return r0.mFormatPrivate;
    }

    static /* synthetic */ void access$200(StorageWizardFormatProgress r0) {
        r0.onFormatFinished();
    }

    static /* synthetic */ String access$300(StorageWizardFormatProgress r0) {
        return r0.getDiskDescription();
    }

    static /* synthetic */ String access$400(StorageWizardFormatProgress r0) {
        return r0.getGenericDiskDescription();
    }

    public void com_android_settings_deviceinfo_StorageWizardFormatProgress__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (this.mDisk != null) goto L6;
        finish();
        return;
    L6:
        setContentView(R.layout.storage_wizard_progress);
        setKeepScreenOn(true);
        boolean r0 = getIntent().getBooleanExtra(StorageWizardFormatConfirm.EXTRA_FORMAT_PRIVATE, false);
        this.mFormatPrivate = r0;
        if (r0 == false) goto L9;
        int r1 = 1;
    L10:
        setIllustrationType(r1);
        setHeaderText(R.string.storage_wizard_format_progress_title, new String[]{this.mDisk.getDescription()});
        setBodyText(R.string.storage_wizard_format_progress_body, new String[]{this.mDisk.getDescription()});
        getNextButton().setVisibility(8);
        PartitionTaskViewModel r5 = (PartitionTaskViewModel) new ViewModelProvider(this).get(PartitionTaskViewModel.class);
        this.mViewModel = r5;
        if (r5.task != null) goto L13;
        this.mViewModel.task = new PartitionTask();
        this.mViewModel.task.setActivity(this);
        this.mViewModel.task.execute(new Void[0]);
    L14:
        this.mTask = this.mViewModel.task;
        return;
    L13:
        this.mViewModel.task.setActivity(this);
        goto L14
    L9:
        r1 = 2;
        goto L10
    }

    private String getDiskDescription() {
        return this.mDisk.getDescription();
    }

    private String getGenericDiskDescription() {
        if (this.mDisk.isSd() == false) goto L7;
        return getString(17042195);
    L7:
        if (this.mDisk.isUsb() == true) goto L9;
        return null;
    L9:
        return getString(17042198);
    }

    private void onFormatFinished() {
        String r0 = getIntent().getStringExtra(StorageWizardFormatConfirm.EXTRA_FORGET_UUID);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.mStorage.forgetVolume(r0);
    L5:
        boolean r1 = false;
        if (this.mFormatPrivate == false) goto L13;
        VolumeInfo r2 = getPackageManager().getPrimaryStorageCurrentVolume();
        if (r2 == null) goto L13;
        if (HeaderConstants.PRIVATE.equals(r2.getId()) == false) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L15;
        Intent r3 = new Intent(this, StorageWizardMigrate.class);
        r3.putExtra("android.os.storage.extra.DISK_ID", this.mDisk.getId());
        startActivity(r3);
    L16:
        finishAffinity();
        return;
    L15:
        Intent r4 = new Intent(this, StorageWizardReady.class);
        r4.putExtra("android.os.storage.extra.DISK_ID", this.mDisk.getId());
        startActivity(r4);
        goto L16
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(StorageWizardFormatProgress r1) {
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(StorageWizardFormatProgress r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardFormatProgress r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_StorageWizardFormatProgress__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_onResume(StorageWizardFormatProgress r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(StorageWizardFormatProgress r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        StorageWizardFormatProgress r5 = r4;
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
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(StorageWizardFormatProgress r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_StorageWizardFormatProgress__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_BatchedActivityLancet_onStop(StorageWizardFormatProgress r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onResume(StorageWizardFormatProgress r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardFormatProgress r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardFormatProgress__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(StorageWizardFormatProgress r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onPause(StorageWizardFormatProgress r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardFormatProgress r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardFormatProgress__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(StorageWizardFormatProgress r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        StorageWizardFormatProgress r5 = r3;
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
    public static void com_android_settings_deviceinfo_StorageWizardFormatProgress_com_obric_hook_lancet_PrivacyHookActivity2_onStop(StorageWizardFormatProgress r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        StorageWizardFormatProgress r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StorageWizardFormatProgress__onStop$___twin___();
    }
}
