package com.bytedance.boost_multidex;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import com.bytedance.mpaas.app.a;
import com.obric.matrix.r.b;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class OptimizeService extends IntentService {
    static volatile boolean sAlreadyOpt;
    File mDexDir;
    File mOptDexDir;
    File mRootDir;
    File mZipDir;

    public OptimizeService() {
        super("OptimizeService");
        if (Monitor.get() != null) goto L5;
        Monitor.init(null);
    L5:
        Monitor.get().logDebug("Starting OptimizeService");
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_com_bytedance_boost_multidex_OptimizeService_com_obric_matrix_SPLancet_getSharedPreferences(OptimizeService r0, String r1, int r2) {
        return b.g(a.a()).getSharedPreferences(r1, r2);
    }

    private void handleOptimize() {
        if (sAlreadyOpt == false) goto L6;
        Monitor.get().logInfo("opt had already done, skip");
        return;
    L6:
        int r5 = 1;
        sAlreadyOpt = true;
        Monitor.get().doBeforeHandleOpt();
        Locker r6 = new Locker(new File(this.mRootDir, Constants.LOCK_INSTALL_FILENAME));
        r6.lock();
        int r7 = 0;
        ApplicationInfo r8 = getApplicationInfo();     // Catch: Throwable -> L47
        if (r8 == null) goto L46;
        File r9 = new File(r8.sourceDir);     // Catch: Throwable -> L47
        SharedPreferences r10 = INVOKEVIRTUAL_com_bytedance_boost_multidex_OptimizeService_com_obric_matrix_SPLancet_getSharedPreferences(this, Constants.PREFS_FILE, 0);     // Catch: Throwable -> L47
        int r11 = r10.getInt(Constants.KEY_DEX_NUMBER, 0);     // Catch: Throwable -> L47
        int r12 = 2;
    L10:
        if (r12 > r11) goto L49;
        int r0 = r10.getInt(Constants.KEY_DEX_OBJ_TYPE + r12, r7);     // Catch: Throwable -> L47
        File r13 = new File(this.mDexDir, r12 + ".dex");     // Catch: Throwable -> L47
        File r14 = new File(this.mOptDexDir, r12 + Constants.ODEX_SUFFIX);     // Catch: Throwable -> L47
        if (r0 != 0) goto L14;
        ZipFile r15 = new ZipFile(r9);     // Catch: Throwable -> L47
        DexHolder r16 = new DexHolder.ApkBuffer(r12, Utility.obtainEntryBytesInZip(r15, r15.getEntry(Constants.DEX_PREFIX + r12 + ".dex")), r13, r14);     // Catch: Throwable -> L47
    L24:
        Monitor.get().logInfo("Process beginning holder " + r16.toString() + ", type: " + r0);     // Catch: Throwable -> L47
    L25:
        if (r16 == null) goto L44;
        long r17 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L47
        if (r17 < Constants.SPACE_MIN_THRESHOLD) goto L28;
        Monitor.get().logInfo("Free space is enough: " + r17 + ", continue...");     // Catch: Throwable -> L47
        Monitor.get().logDebug("Process holder, " + r16);     // Catch: Throwable -> L47
        long r18 = System.nanoTime();     // Catch: Throwable -> L36
        r16 = r16.toFasterHolder(r10);     // Catch: Throwable -> L36
        if (r16 == null) goto L38;
        long r19 = System.nanoTime() - r18;     // Catch: Throwable -> L36
        DexHolder.StoreInfo r1 = r16.getInfo();     // Catch: Throwable -> L36
        Monitor.get().logDebug("Put info, " + r1.index + " file is " + r1.file.getPath());     // Catch: Throwable -> L36
        Monitor.get().reportAfterInstall(r19, r17, Environment.getDataDirectory().getFreeSpace() - r17, r16.toString());     // Catch: Throwable -> L36
    L38:
        Locker r2 = new Locker(new File(this.mRootDir, Constants.LOCK_PREPARE_FILENAME));     // Catch: Throwable -> L47
        if (r2.test() == false) goto L41;
        r2.close();     // Catch: Throwable -> L47
        goto L25
    L41:
        Monitor.get().logInfo("Other process is waiting for installing");     // Catch: Throwable -> L47
        r6.close();
        Monitor.get().logInfo("Exit quietly");
        stopSelf();
        System.exit(0);
        return;
    L36:
        th = move-exception;
        Monitor.get().logErrorAfterInstall("Fail to be faster", th);     // Catch: Throwable -> L47
        Result.get().unFatalThrowable.add(th);     // Catch: Throwable -> L47
        goto L38
    L28:
        Monitor.get().logWarning("Free space is too small: " + r17 + ", compare to " + Constants.SPACE_THRESHOLD);     // Catch: Throwable -> L47
        r6.close();
        Monitor.get().logInfo("Exit quietly");
        stopSelf();
        System.exit(0);
        return;
    L44:
        r12 = r12 + 1;
        r5 = 1;
        r7 = 0;
        goto L10
    L14:
        if (r0 != r5) goto L18;
        r16 = new DexHolder.DexBuffer(r12, r13, r14);     // Catch: Throwable -> L47
        goto L24
    L18:
        if (r0 != 2) goto L21;
        r16 = new DexHolder.DexOpt(r12, r13, r14, false);     // Catch: Throwable -> L47
        goto L24
    L21:
        if (r0 != 3) goto L23;
        r16 = new DexHolder.ZipOpt(r12, new File(this.mZipDir, r12 + Constants.ZIP_SUFFIX), new File(this.mZipDir, r12 + Constants.ODEX_SUFFIX));     // Catch: Throwable -> L47
        goto L24
    L23:
        r16 = null;
    L49:
        r6.close();
        Monitor.get().logInfo("Exit quietly");
        stopSelf();
        System.exit(0);
        return;
    L46:
        throw new RuntimeException("No ApplicationInfo available, i.e. running on a test Context: BoostMultiDex support library is disabled.");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Monitor.get().logWarning("Failed to install extracted secondary dex files", th);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r6.close();
        Monitor.get().logInfo("Exit quietly");
        stopSelf();
        System.exit(0);
        throw th;
    }

    public static void startOptimizeService(Context r2) {
        r2.startService(new Intent(r2, OptimizeService.class));
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        File r0 = getFilesDir();     // Catch: IOException -> L8
        if (r0.exists() == true) goto L6;
        Utility.mkdirChecked(r0);     // Catch: IOException -> L8
    L6:
        File r1 = Utility.ensureDirCreated(r0, Constants.BOOST_MULTIDEX_DIR_NAME);     // Catch: IOException -> L8
        this.mRootDir = r1;     // Catch: IOException -> L8
        this.mDexDir = Utility.ensureDirCreated(r1, Constants.DEX_DIR_NAME);     // Catch: IOException -> L8
        this.mOptDexDir = Utility.ensureDirCreated(this.mRootDir, Constants.ODEX_DIR_NAME);     // Catch: IOException -> L8
        this.mZipDir = Utility.ensureDirCreated(this.mRootDir, Constants.ZIP_DIR_NAME);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Monitor.get().logError("fail to create files", e);
        sAlreadyOpt = true;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r2) {
        if (r2 == null) goto L10;
        handleOptimize();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Monitor.get().logError("fail to handle opt", e);
        return;
    }
}
