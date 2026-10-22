package com.android.settings.deviceinfo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import bytedanceos.api.StorageManagerSmt;
import com.GlobalProxyLancet;
import com.android.settings.ExecutorManager;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.DisableTipsButton;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;

/* JADX INFO: loaded from: classes2.dex */
public class ExternalManageDetail extends BaseActivity implements View.OnClickListener {
    private static final int MSG_UPDATE_STORAGE_DETAILS = 1;
    private static final int RED_MB = 50;
    private static final String TAG = "SDManageDetail";
    private final BroadcastReceiver UsbReceiver;
    private TextView mAvailableSize;
    private Context mContext;
    private DisableTipsButton mEraseStorage;
    private View mGapView;
    private final Handler mHandler;
    private boolean mMtpPtpConnected;
    private int mOldSdManageAction;
    private View mPhoneDesktopConnectTips;
    private BytedanceProgressDialog mProgressDialog;
    private ContentObserver mRecorderStatusObserver;
    private DisableTipsButton mRemoveStorage;
    private AlertDialog mSDManageDialog;
    private Runnable mShowProgressDialogRunnable;
    private final StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private StorageProgressBar mStorageProgessBar;
    private int mTitleRes;
    private TextView mTotalSize;
    private VolumeInfo mVolume;

    class ClickListener implements DialogInterface.OnClickListener {
        int id;
        final /* synthetic */ ExternalManageDetail this$0;

        public ClickListener(ExternalManageDetail r1, int r2) {
            this.this$0 = r1;
            this.id = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r2, int r3) {
            if (r3 != (-1)) goto L12;
            int r4 = this.id;
            if (r4 != R.id.erase_external_storage) goto L7;
            new FormatTask(this.this$0, R.string.erasing_external_storage).execute(new Void[0]);
            return;
        L7:
            if (r4 != R.id.unmount_external_storage) goto L14;
            new UnmountTask(this.this$0, R.string.unmounting_external_storage).execute(new Void[0]);
            return;
        L14:
            return;
        }
    }

    public class FormatTask extends AsyncTask<Void, Integer, Boolean> {
        final /* synthetic */ ExternalManageDetail this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean r1) {
            onPostExecute2(r1);
        }

        public FormatTask(ExternalManageDetail r1, int r2) {
            this.this$0 = r1;
            if (ExternalManageDetail.access$700(r1) != null) goto L5;
            ExternalManageDetail.access$702(r1, ExternalManageDetail.access$1000(r1));
        L5:
            ExternalManageDetail.access$700(r1).setMessage(ExternalManageDetail.access$400(r1).getString(r2));
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ExternalManageDetail.access$1200(this.this$0).postDelayed(ExternalManageDetail.access$1100(this.this$0), 500);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... r5) {
            OLog.d(StorageUtils.TAG, "before format sdcard: " + ExternalManageDetail.access$300(this.this$0).getPath());
            boolean r2 = true;
            ExternalManageDetail.access$1300(this.this$0, true);     // Catch: RuntimeException -> L5
            ExternalManageDetail.access$600(this.this$0).format(ExternalManageDetail.access$300(this.this$0).getId());     // Catch: RuntimeException -> L5
        L7:
            if (r2 == true) goto L14;
        L12:
            ExternalManageDetail.access$1200(this.this$0).removeCallbacks(ExternalManageDetail.access$1100(this.this$0));
            ExternalManageDetail.access$1300(this.this$0, false);
            return Boolean.valueOf(r2);
        L14:
            ExternalManageDetail.access$600(this.this$0).mount(ExternalManageDetail.access$300(this.this$0).getId());     // Catch: RuntimeException -> L10
        L10:
            e = move-exception;
            e.printStackTrace();
            OLog.w(ExternalManageDetail.TAG, "mount formatted sdcard catch exception " + e.getMessage());
            r2 = false;
        L5:
            e = move-exception;
            e.printStackTrace();
            OLog.w(StorageUtils.TAG, " format sdcard catch exception: " + e.getMessage());
            r2 = false;
            goto L7
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean r4) {
            OLog.d(StorageUtils.TAG, "after format sdcard: " + ExternalManageDetail.access$300(this.this$0).getPath());
            String r0 = ExternalManageDetail.access$400(this.this$0).getString(R.string.external_sd_label);
            if (r4.booleanValue() == false) goto L5;
            String r5 = ExternalManageDetail.access$400(this.this$0).getString(R.string.storage_format_success, new Object[]{r0});
        L6:
            ToastUtils.show(ExternalManageDetail.access$400(this.this$0), r5);
            if (ExternalManageDetail.access$700(this.this$0) != null) goto L9;
            return;
        L9:
            if (ExternalManageDetail.access$700(this.this$0).isShowing() == false) goto L13;
            ExternalManageDetail.access$700(this.this$0).dismiss();
            return;
        L13:
            return;
        L5:
            r5 = ExternalManageDetail.access$400(this.this$0).getString(R.string.storage_format_failure, new Object[]{r0});
            goto L6
        }
    }

    private static class SDStorageInfo {
        long avaiSize;
        long totalSize;

        private SDStorageInfo() {
        }

        /* synthetic */ SDStorageInfo(AnonymousClass1 r1) {
            this();
        }
    }

    public class UnmountTask extends AsyncTask<Void, Void, Exception> {
        private final String mDescription;
        private final String mVolumeId;
        final /* synthetic */ ExternalManageDetail this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Exception doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Exception r1) {
            onPostExecute2(r1);
        }

        public UnmountTask(ExternalManageDetail r3, int r4) {
            this.this$0 = r3;
            this.mVolumeId = ExternalManageDetail.access$300(r3).getId();
            this.mDescription = ExternalManageDetail.access$600(r3).getBestVolumeDescription(ExternalManageDetail.access$300(r3));
            if (ExternalManageDetail.access$700(r3) != null) goto L5;
            ExternalManageDetail.access$702(r3, ExternalManageDetail.access$1000(r3));
        L5:
            ExternalManageDetail.access$700(r3).setMessage(r3.getString(r4));
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ExternalManageDetail.access$1200(this.this$0).postDelayed(ExternalManageDetail.access$1100(this.this$0), 500);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Exception doInBackground2(Void... r5) {
            Iterator r6 = ExternalManageDetail.access$600(this.this$0).getVolumes().iterator();     // Catch: Throwable -> L11 Exception -> L13
        L4:
            if (r6.hasNext() == false) goto L9;
            VolumeInfo r0 = (VolumeInfo) r6.next();     // Catch: Throwable -> L11 Exception -> L13
            if (StorageUtils.isValidSdVolume(r0) == false) goto L4;
            OLog.d(ExternalManageDetail.TAG, "unmount vol id " + r0.id);     // Catch: Throwable -> L11 Exception -> L13
            ExternalManageDetail.access$600(this.this$0).unmount(r0.id);     // Catch: Throwable -> L11 Exception -> L13
        L9:
            ExternalManageDetail.access$1200(this.this$0).removeCallbacks(ExternalManageDetail.access$1100(this.this$0));
            return null;
        L13:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L11
            ExternalManageDetail.access$1200(this.this$0).removeCallbacks(ExternalManageDetail.access$1100(this.this$0));
            return e;
        L11:
            th = move-exception;
            ExternalManageDetail.access$1200(this.this$0).removeCallbacks(ExternalManageDetail.access$1100(this.this$0));
            throw th;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Exception r7) {
            if (ExternalManageDetail.access$700(this.this$0) != null) goto L5;
        L7:
            String r0 = ExternalManageDetail.access$400(this.this$0).getString(R.string.external_sd_label);
            if (r7 == null) goto L10;
            OLog.e(ExternalManageDetail.TAG, "Failed to unmount " + r7.getMessage());
            String r8 = ExternalManageDetail.access$400(this.this$0).getString(R.string.storage_unmount_failure, new Object[]{r0});
        L11:
            ToastUtils.show(ExternalManageDetail.access$400(this.this$0), r8);
            return;
        L10:
            OLog.e(ExternalManageDetail.TAG, "success to unmount " + this.mVolumeId);
            r8 = ExternalManageDetail.access$400(this.this$0).getString(R.string.storage_unmount_success, new Object[]{r0});
            goto L11
        L5:
            if (ExternalManageDetail.access$700(this.this$0).isShowing() == false) goto L7;
            ExternalManageDetail.access$700(this.this$0).dismiss();
            goto L7
        }
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ExternalManageDetail() {
        this.mTitleRes = R.string.sd_manage;
        this.mOldSdManageAction = -1;
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mRecorderStatusObserver = new AnonymousClass2(this, r1);
        this.UsbReceiver = new AnonymousClass3(this);
        this.mStorageListener = new AnonymousClass4(this);
        this.mShowProgressDialogRunnable = new AnonymousClass5(this);
    }

    static /* synthetic */ void access$000(ExternalManageDetail r0, long r1, long r3) {
        r0.updateDetailViews(r1, r3);
    }

    static /* synthetic */ void access$100(ExternalManageDetail r0) {
        r0.updateSdButtonViews();
    }

    static /* synthetic */ BytedanceProgressDialog access$1000(ExternalManageDetail r0) {
        return r0.createProgressDialog();
    }

    static /* synthetic */ Runnable access$1100(ExternalManageDetail r0) {
        return r0.mShowProgressDialogRunnable;
    }

    static /* synthetic */ Handler access$1200(ExternalManageDetail r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$1300(ExternalManageDetail r0, boolean r1) {
        r0.sendFormatStateBroadcast(r1);
    }

    static /* synthetic */ boolean access$200(ExternalManageDetail r0) {
        return r0.mMtpPtpConnected;
    }

    static /* synthetic */ boolean access$202(ExternalManageDetail r0, boolean r1) {
        r0.mMtpPtpConnected = r1;
        return r1;
    }

    static /* synthetic */ VolumeInfo access$300(ExternalManageDetail r0) {
        return r0.mVolume;
    }

    static /* synthetic */ VolumeInfo access$302(ExternalManageDetail r0, VolumeInfo r1) {
        r0.mVolume = r1;
        return r1;
    }

    static /* synthetic */ Context access$400(ExternalManageDetail r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$500(ExternalManageDetail r0, VolumeInfo r1) {
        r0.onPublicVolumeStateChangedInternal(r1);
    }

    static /* synthetic */ StorageManager access$600(ExternalManageDetail r0) {
        return r0.mStorageManager;
    }

    static /* synthetic */ BytedanceProgressDialog access$700(ExternalManageDetail r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ BytedanceProgressDialog access$702(ExternalManageDetail r0, BytedanceProgressDialog r1) {
        r0.mProgressDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$800(ExternalManageDetail r0, VolumeInfo r1) {
        r0.calculateStorageDetail(r1);
    }

    private void updateSdButtonViews() {
        boolean r0 = isScreenRecordingToExternalSdcard();
        if (this.mMtpPtpConnected == true) goto L7;
        if (r0 == true) goto L7;
        this.mRemoveStorage.setEnabled(true);
        this.mEraseStorage.setEnabled(true);
        this.mPhoneDesktopConnectTips.setVisibility(8);
        this.mGapView.setVisibility(0);
        return;
    L7:
        this.mRemoveStorage.setEnabled(false);
        this.mEraseStorage.setEnabled(false);
        if (r0 == false) goto L10;
        this.mRemoveStorage.setDisableTips(getString(R.string.umount_when_recording_screen_tips));
        this.mEraseStorage.setDisableTips(getString(R.string.umount_when_recording_screen_tips));
        return;
    L10:
        this.mRemoveStorage.setDisableTips(null);
        this.mEraseStorage.setDisableTips(null);
        this.mPhoneDesktopConnectTips.setVisibility(0);
        this.mGapView.setVisibility(8);
    }

    private boolean isScreenRecordingToExternalSdcard() {
        if (Settings.Global.getInt(getContentResolver(), "screen_recorder_status", 0) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (Settings.Global.getInt(getContentResolver(), "storage_path_captivate", 0) != 1) goto L9;
        boolean r5 = true;
    L10:
        OLog.d(TAG, "isScreenRecording " + r0 + ", isSaveExternal " + r5);
        if (r0 == false) goto L15;
        if (r5 == true) goto L14;
        return false;
    L14:
        return true;
    L15:
        return false;
    L9:
        r5 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        if (SettingsFeature.isSdMounted() == true) goto L5;
        finish();
    L5:
        setContentView(R.layout.external_manage_detail);
        initView();
        this.mContext = this;
        setupBackBtnOnTitle(false);
        registerReceiver();
        StorageManager r4 = StorageManager.from(this);
        this.mStorageManager = r4;
        r4.registerListener(this.mStorageListener);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("screen_recorder_status"), true, this.mRecorderStatusObserver);
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__onResume$___twin___() {
        super.onResume();
        List r0 = this.mStorageManager.getVolumes();
        OLog.d(StorageUtils.TAG, "update current volume");
        Iterator r1 = r0.iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L9;
        VolumeInfo r3 = (VolumeInfo) r1.next();
        if (StorageUtils.isValidSdVolume(r3) == false) goto L4;
        if (r2 == true) goto L4;
        this.mVolume = r3;
        onPublicVolumeStateChangedInternal(r3);
        r2 = true;
        goto L4
    }

    public void initView() {
        this.mStorageProgessBar = (StorageProgressBar) findViewById(R.id.storage_progess_bar);
        this.mRemoveStorage = (DisableTipsButton) findViewById(R.id.unmount_external_storage);
        this.mEraseStorage = (DisableTipsButton) findViewById(R.id.erase_external_storage);
        this.mGapView = findViewById(R.id.gap);
        this.mPhoneDesktopConnectTips = findViewById(R.id.phone_desktop_connect);
        this.mTotalSize = (TextView) findViewById(R.id.external_storage_total_size);
        this.mAvailableSize = (TextView) findViewById(R.id.external_storage_free_size);
        this.mRemoveStorage.setOnClickListener(this);
        this.mEraseStorage.setOnClickListener(this);
        findViewById(R.id.sd_file_storage_detail).setOnClickListener(this);
        findViewById(R.id.default_storage_path).setOnClickListener(this);
    }

    public void com_android_settings_deviceinfo_ExternalManageDetail__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.UsbReceiver);
        getContentResolver().unregisterContentObserver(this.mRecorderStatusObserver);
        StorageManager r0 = this.mStorageManager;
        if (r0 == null) goto L7;
        StorageEventListener r1 = this.mStorageListener;
        if (r1 == null) goto L7;
        r0.unregisterListener(r1);
    L7:
        dismissProgressDialog();
        AlertDialog r2 = this.mSDManageDialog;
        if (r2 == null) goto L10;
        r2.dismiss();
    L10:
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void registerReceiver() {
        IntentFilter r0 = new IntentFilter("android.hardware.usb.action.USB_STATE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.UsbReceiver, r0);
    }

    public int getSdVolumeIndexById(String r4) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isSd() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, r4) == false) goto L4;
    L11:
        return r0;
    }

    public int getUsbVolumeIndexById(String r4) {
        Iterator r3 = this.mStorageManager.getVolumes().iterator();
        int r0 = -1;
    L4:
        if (r3.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r3.next();
        if (r1.getDisk() == null) goto L4;
        if (r1.getDisk().isUsb() == false) goto L4;
        r0 = r0 + 1;
        if (Objects.equals(r1.id, r4) == false) goto L4;
    L11:
        return r0;
    }

    private void onPublicVolumeStateChangedInternal(VolumeInfo r3) {
        OLog.d(StorageUtils.TAG, "onPublicVolumeStateChangedInternal " + r3);
        int r0 = r3.getState();
        if (r0 == 0) goto L14;
        if (r0 != 2) goto L7;
    L12:
        calculateStorageDetailsAsync(r3);
        return;
    L7:
        if (r0 == 3) goto L12;
        if (r0 != 4) goto L20;
        calculateStorageDetailsAsync(r3);
        return;
    L20:
        return;
    L14:
        if (StorageUtils.isFormatting == false) goto L16;
        sendFormatStateBroadcast(false);
    L16:
        finish();
    }

    public void calculateStorageDetailsAsync(final VolumeInfo r2) {
        ExecutorManager.execute(new AnonymousClass6(this, r2));
    }

    private void calculateStorageDetail(VolumeInfo r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.getPath() == null) goto L11;
        File r10 = r9.getPath();
        long r0 = System.currentTimeMillis();
        long r2 = Utils.getTotalSize(r10);
        long r4 = Utils.getAvailableSize(r10);
        OLog.d(TAG, "calculateStorageDetailsAsync use time: " + (System.currentTimeMillis() - r0));
        if (isFinishing() == false) goto L8;
        return;
    L8:
        Message r11 = new Message();
        r11.what = 1;
        SDStorageInfo r1 = new SDStorageInfo(null);
        r1.totalSize = r2;
        r1.avaiSize = r4;
        r11.obj = r1;
        this.mHandler.sendMessage(r11);
        return;
    }

    private void updateDetailViews(long r4, long r6) {
        this.mTotalSize.setText(Utils.formatSize(this, r4));
        this.mAvailableSize.setText(Utils.formatSize(this, r6));
        double r1 = (r4 * 1.0f) / 1048576.0f;
        updateProView(r1, r1 - ((double) ((r6 * 1.0f) / 1048576.0f)));
    }

    private void updateProView(double r5, double r7) {
        if ((r5 - r7) <= 50.0d) goto L5;
        this.mStorageProgessBar.setUsedPercentage(r7 / r5, false);
        return;
    L5:
        this.mStorageProgessBar.setUsedPercentage(r7 / r5, true);
    }

    private void warnSDManageDialog(int r5) {
        this.mHandler.removeCallbacks(this.mShowProgressDialogRunnable);
        if (this.mSDManageDialog != null) goto L5;
    L6:
        this.mOldSdManageAction = r5;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this);
        Resources r1 = getResources();
        if (r5 != R.id.unmount_external_storage) goto L9;
        int r3 = R.string.unmount_external_storage;
    L10:
        AlertDialog.Builder r2 = r0.setTitle(r1.getString(r3));
        Resources r4 = getResources();
        if (r5 != R.id.unmount_external_storage) goto L13;
        int r6 = R.string.unmount_external_storage_warning;
    L14:
        this.mSDManageDialog = r2.setMessage(r4.getString(r6)).setPositiveButton(R.string.continue_operation, new ClickListener(this, r5)).setNegativeButton(R.string.cancel, new ClickListener(this, r5)).create();
    L15:
        this.mSDManageDialog.dismiss();
        this.mSDManageDialog.show();
        return;
    L13:
        r6 = R.string.erase_external_storage_warning;
        goto L14
    L9:
        r3 = R.string.format_external_storage;
        goto L10
    L5:
        if (this.mOldSdManageAction == r5) goto L15;
        goto L6
    }

    private BytedanceProgressDialog createProgressDialog() {
        BytedanceProgressDialog r0 = new BytedanceProgressDialog(this);
        r0.setCanceledOnTouchOutside(false);
        r0.setCancelable(false);
        return r0;
    }

    public void dismissProgressDialog() {
        BytedanceProgressDialog r0 = this.mProgressDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private void sendFormatStateBroadcast(boolean r2) {
        if (r2 == false) goto L4;
        StorageUtils.isFormatting = true;
        Intent r3 = new Intent(StorageUtils.EXTERNAL_FORMAT_BEGIN);
    L5:
        sendBroadcast(r3, "android.permission.WRITE_MEDIA_STORAGE");
        return;
    L4:
        StorageUtils.isFormatting = false;
        r3 = new Intent(StorageUtils.EXTERNAL_FORMAT_END);
        goto L5
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        Intent r0 = new Intent();
        switch(r3.getId()) {
            case 2131428336: goto L8;
            case 2131428595: goto L7;
            case 2131430697: goto L6;
            case 2131431570: goto L5;
            default: goto L9;
        };
    L5:
        warnSDManageDialog(R.id.unmount_external_storage);
        SettingsTracker.onItemClick(android.R.string.global_action_bug_report);
        goto L9
    L6:
        r0 = createSdFileManagerIntent();
        r0.putExtra("back_text", getString(R.string.sd_manage));
        SettingsTracker.onItemClick(android.R.string.global_action_lockdown);
        goto L9
    L7:
        warnSDManageDialog(R.id.erase_external_storage);
        SettingsTracker.onItemClick(android.R.string.global_action_emergency);
        goto L9
    L8:
        r0.putExtra("back_text_id", this.mTitleRes);
        r0.setClass(this, StoragePathActivity.class);
        SettingsTracker.onItemClick(android.R.string.global_action_lock);
    L9:
        Utils.startActivity(this, r0);
    }

    public static Intent createSdFileManagerIntent() {
        Intent r0 = new Intent();
        r0.setPackage("com.obric.filemanager");
        r0.setAction(StorageUtils.ACTION_VIEW_FOLDER);
        r0.putExtra("storageType", 2);
        r0.putExtra("path", StorageManagerSmt.getExternalSdcardPath());
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ExternalManageDetail r1) {
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onCreate(ExternalManageDetail r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ExternalManageDetail r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_ExternalManageDetail__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_onResume(ExternalManageDetail r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ExternalManageDetail r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ExternalManageDetail r5 = r4;
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
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ExternalManageDetail r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_ExternalManageDetail__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_BatchedActivityLancet_onStop(ExternalManageDetail r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_ExternalManageDetail_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onResume(ExternalManageDetail r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ExternalManageDetail r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_ExternalManageDetail__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ExternalManageDetail r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onPause(ExternalManageDetail r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ExternalManageDetail r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_ExternalManageDetail__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ExternalManageDetail r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ExternalManageDetail r5 = r3;
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
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onStop(ExternalManageDetail r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ExternalManageDetail r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_ExternalManageDetail__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_deviceinfo_ExternalManageDetail_com_obric_hook_lancet_PrivacyHook_onDestroy(ExternalManageDetail r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ExternalManageDetail r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_deviceinfo_ExternalManageDetail__onDestroy$___twin___();
    }
}
