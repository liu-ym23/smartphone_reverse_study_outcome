package com.bytedanceos.datausage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Process;
import android.os.UserManager;
import android.text.TextUtils;
import com.bytedanceos.powerusage.PowerUsageHelper;
import com.bytedanceos.security.AppExitTrace;
import com.bytedanceos.security.invokeHistory.InvokeHistoryJob;
import com.bytedanceos.securitycenter.AccountSdkInitializer;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.securitycenter.dynamicResolution.DynamicResolutionHelper;
import com.bytedanceos.securitycenter.init.VirusDbAutoUpdateInitializer;
import com.bytedanceos.securitycenter.memory.StorageReportWorker;
import com.obric.baseservice.privacy.PrivacySdkManager;
import com.obric.olog.OLog;
import com.obric.pushservice.PushInitializer;
import com.obric.safecheck.dataSync.DailySyncWorkInitializer;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushMessageObserver;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudPushTokenObserver;
import com.obric.security.battertpower.powerHigh.HighPowerWhitelistTask;
import com.obric.security.util.ExternalStoragePermissionManager;
import com.obric.taskmanager.TaskManager;

/* JADX INFO: loaded from: classes2.dex */
public class BootCompletedReceiver extends BroadcastReceiver {
    ExternalStoragePermissionManager externalStoragePermissionManager;

    public BootCompletedReceiver() {
        this.externalStoragePermissionManager = new ExternalStoragePermissionManager();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String r5 = intent.getAction();
        if (r5 != null) goto L5;
        return;
    L5:
        Context r0 = context.getApplicationContext();
        if (r5.equals("android.intent.action.BOOT_COMPLETED") == false) goto L9;
        OLog.e("BootCompletedReceiver", "ACTION_BOOT_COMPLETED----1");
        AppExitTrace.getInstance().init();
        AppExitTrace.getInstance().addTask(AppExitTrace.TASK_DRH_CONFIGURE_RESOLUTION);
        InvokeHistoryJob.cancelRepeatingAlarm(r0);
        initWorkAfterUserUnlocked(r0);
        DynamicResolutionHelper.configureResolution(r0);
        TaskManager.Companion.getInstance().execute("allow_bg_power_high", new HighPowerWhitelistTask(r0));
        this.externalStoragePermissionManager.processWhiteList();
        OLog.e("BootCompletedReceiver", " ACTION_BOOT_COMPLETED----2");
    L11:
        resetCleanProcessTime(context);
        return;
    L9:
        if (r5.equals("android.intent.action.USER_UNLOCKED") == false) goto L11;
        initWorkAfterUserUnlocked(r0);
        goto L11
    }

    private void initWorkAfterUserUnlocked(Context context) {
        UserManager r0 = (UserManager) context.getSystemService(UserManager.class);
        if (r0 != null) goto L5;
    L8:
        OLog.i("BootCompletedReceiver", "initWorkAfterUserUnlocked");
        if (isMainProcess(context) == false) goto L11;
        MiitAntiFraudPushTokenObserver.register();
        MiitAntiFraudPushMessageObserver.register();
        PushInitializer.init(context);
    L11:
        AccountSdkInitializer.INSTANCE.init(SecurityCenterApplication.getApplication());
        PrivacySdkManager.INSTANCE.init(SecurityCenterApplication.getApplication());
        DailySyncWorkInitializer.INSTANCE.init(context);
        StorageReportWorker.init(context);
        VirusDbAutoUpdateInitializer.init(context);
        PowerUsageHelper.resetBgBatteryControllerStatus(context);
        return;
    L5:
        if (r0.isUserUnlocked() == true) goto L8;
        OLog.i("BootCompletedReceiver", "Skip WorkManager init before user unlock");
    }

    private boolean isMainProcess(Context context) {
        return TextUtils.equals(SecurityCenterApplication.getProcessName(context, Process.myPid()), context.getPackageName());
    }

    private void resetCleanProcessTime(final Context context) {
        AsyncTask.execute(new AnonymousClass1(this, context));
    }
}
