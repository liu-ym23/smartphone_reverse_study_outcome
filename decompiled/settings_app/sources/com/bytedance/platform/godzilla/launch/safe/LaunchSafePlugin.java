package com.bytedance.platform.godzilla.launch.safe;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.ProcessHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LaunchSafePlugin extends UncaughtExceptionPlugin {
    private Application mApplication;
    private IFetchConfig mConfig;
    private Handler mHandler;

    public interface IFetchConfig {
        void fixSuccessful(Strategy r1, String r2, int r3);

        int getCrashLimit();

        List<Strategy> getStrategy();

        long getWatchDogTime();

        void occurSerialCrash(String r1, int r2);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "LaunchSafePlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    public LaunchSafePlugin(IFetchConfig r3) {
        this.mHandler = new Handler(Looper.getMainLooper());
        if (r3 == null) goto L7;
        this.mConfig = r3;
        return;
    L7:
        throw new NullPointerException("LaunchSafeConfig is null");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r2) {
        if (ProcessHelper.isMainProcess(r2) == false) goto L6;
        super.init(r2);
        this.mApplication = r2;
        return;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        if (ProcessHelper.isMainProcess(this.mApplication) == false) goto L6;
        super.start();
        this.mHandler.postDelayed(new AnonymousClass1(this), this.mConfig.getWatchDogTime());
        return;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        if (ProcessHelper.isMainProcess(this.mApplication) == false) goto L6;
        super.stop();
        CrashRecord.getInstance(this.mApplication).clearCrashCount();
        return;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r2, Throwable r3) {
        if (ProcessHelper.isMainProcess(this.mApplication) == true) goto L5;
        return false;
    L5:
        return callCrashHandler(r2, r3);
    }

    private boolean callCrashHandler(Thread r7, Throwable r8) {
        if (ProcessHelper.isMainProcess(this.mApplication) == false) goto L16;
        if (r7 == null) goto L16;
        if (r8 == null) goto L16;
        CrashRecord.getInstance(this.mApplication).crashCountIncrement(r7, r8);
        if (CrashRecord.getInstance(this.mApplication).getTotalCrashCount() >= this.mConfig.getCrashLimit()) goto L10;
        Logger.e("LaunchSafePlugin", "Current user crash less than " + this.mConfig.getCrashLimit());
        return false;
    L10:
        int r0 = CrashRecord.getInstance(this.mApplication).getCrashCount(r7, r8);
        this.mConfig.occurSerialCrash(CrashRecord.crashKeyGenerator(r7, r8), r0);
        Iterator<Strategy> r2 = this.mConfig.getStrategy().iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Strategy r3 = r2.next();
        if (r3.onExceptionOccur(r8, r7, r0) == false) goto L12;
        this.mConfig.fixSuccessful(r3, CrashRecord.crashKeyGenerator(r7, r8), r0);
    L16:
        return false;
    }
}
