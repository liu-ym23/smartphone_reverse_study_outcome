package com.bytedance.boost_multidex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import com.bytedance.mpaas.app.a;
import com.obric.matrix.r.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class DexInstallProcessor {
    private boolean mDoCheckSum;
    private SharedPreferences mPreferences;

    DexInstallProcessor() {
        if (new Random().nextInt(3) != 0) goto L5;
        boolean r0 = true;
    L6:
        this.mDoCheckSum = r0;
        Monitor.get().logInfo("Do checksum " + this.mDoCheckSum);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences INVOKEVIRTUAL_com_bytedance_boost_multidex_DexInstallProcessor_com_obric_matrix_SPLancet_getSharedPreferences2(Context r0, String r1, int r2) {
        return b.g(a.a()).getSharedPreferences(r1, r2);
    }

    private boolean checkFileValid(int r10, String r11, String r12, File r13, boolean r14) {
        if (r13.exists() == true) goto L8;
        Monitor r9 = Monitor.get();
        StringBuilder r15 = new StringBuilder();
        r15.append("File does not exist! ");
        r11 = r13.getPath();
    L5:
        r15.append(r11);
        String r16 = r15.toString();
    L6:
        r9.logWarning(r16);
        return false;
    L8:
        long r5 = this.mPreferences.getLong(r12 + r10, -1);
        long r7 = r13.lastModified();
        if (r5 == r7) goto L11;
        r9 = Monitor.get();
        r16 = "Invalid file:  (key \"" + r11 + r12 + r10 + "\"), expected modification time: " + r5 + ", modification time: " + r7;
        goto L6
    L11:
        long r6 = 0;
        if (Constants.KEY_DEX_CHECKSUM.equals(r11) == false) goto L22;
        if (r14 == false) goto L16;
        r6 = Utility.doZipCheckSum(r13);     // Catch: IOException -> L20
    L31:
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L29;
        long r18 = this.mPreferences.getLong(r11 + r10, -1);
        if (r18 == r6) goto L29;
        r9 = Monitor.get();
        r16 = "Invalid file:  (key \"" + r11 + r12 + r10 + "\"), expected checksum: " + r18 + ", file checksum: " + r6;
    L29:
        return true;
    L16:
        if (this.mDoCheckSum == false) goto L19;
        r6 = Utility.doFileCheckSum(r13);     // Catch: IOException -> L20
        goto L31
    L19:
        r17 = false;
    L20:
        return false;
    L22:
        if (Constants.KEY_ODEX_CHECKSUM.equals(r11) == false) goto L30;
        r6 = r13.length();
        goto L24
    L30:
        r9 = Monitor.get();
        r15 = new StringBuilder();
        r15.append("unsupported checksum key: ");
        goto L5
    }

    private File getValidDexFile(File r7, int r8) {
        if (checkFileValid(r8, Constants.KEY_DEX_CHECKSUM, Constants.KEY_DEX_TIME, r7, false) == true) goto L6;
        return null;
    L6:
        return r7;
    }

    private File getValidOptDexFile(File r9, int r10) {
        if (r9.exists() == true) goto L7;
        Monitor.get().logInfo("opt file does not exist: " + r9.getPath());
        return null;
    L7:
        if (checkFileValid(r10, Constants.KEY_ODEX_CHECKSUM, Constants.KEY_ODEX_TIME, r9, false) == true) goto L9;
        return null;
    L9:
        return r9;
    }

    private void installSecondaryDexes(ClassLoader r3, List<DexHolder> r4) {
        DexLoader.create(Build.VERSION.SDK_INT).install(r3, r4, this.mPreferences);
        BoostNative.recoverAction();     // Catch: UnsatisfiedLinkError -> L6
    L4:
        Monitor.get().logDebug("After install all, sp value is " + this.mPreferences.getAll());
    }

    private boolean isZipFileValid(File r7, int r8) {
        return checkFileValid(r8, Constants.KEY_DEX_CHECKSUM, Constants.KEY_DEX_TIME, r7, true);
    }

    private DexHolder obtainDexHolder(int r12, File r13, File r14, File r15, File r16) {
        int r4 = this.mPreferences.getInt(Constants.KEY_DEX_OBJ_TYPE + r12, 9);
        if (r4 != 9) goto L9;
        if (BoostNative.isSupportFastLoad() == false) goto L7;
        r4 = !Utility.isBetterUseApkBuf() ? 1 : 0;
        goto L9
    L7:
        r4 = 3;
    L9:
        if (r4 != 3) goto L16;
        File r5 = new File(r16, r12 + Constants.ZIP_SUFFIX);
        File r6 = new File(r16, r12 + Constants.ODEX_SUFFIX);
        if (isZipFileValid(r5, r12) == true) goto L13;
        ZipFile r7 = new ZipFile(r13);
        DexHolder.ZipOpt r0 = DexHolder.obtainValidZipDex(this.mPreferences, r12, r5, r6, r7, r7.getEntry(Constants.DEX_PREFIX + r12 + ".dex"));
        r7.close();
        return r0;
    L13:
        return new DexHolder.ZipOpt(r12, r5, r6);
    L16:
        File r3 = new File(r14, r12 + ".dex");
        File r8 = new File(r15, r12 + Constants.ODEX_SUFFIX);
        int r10 = 0;
        if (r4 != 2) goto L34;
        File r9 = getValidDexFile(r3, r12);
        if (r9 == null) goto L30;
        File r11 = getValidOptDexFile(r8, r12);
        if (r11 == null) goto L25;
        return new DexHolder.DexOpt(r12, r9, r11, false);
    L25:
        if (BoostNative.isSupportFastLoad() == false) goto L28;
        r4 = 1;
        goto L34
    L28:
        return new DexHolder.DexOpt(r12, r9, r8, true);
    L30:
        if (BoostNative.isSupportFastLoad() == false) goto L32;
        r4 = 0;
        goto L34
    L32:
        ZipFile r17 = new ZipFile(r13);
        return DexHolder.obtainValidForceDexOpt(this.mPreferences, r12, r3, r8, r17, r17.getEntry(Constants.DEX_PREFIX + r12 + ".dex"));
    L34:
        if (r4 != 1) goto L45;
        File r18 = getValidDexFile(r3, r12);
        if (BoostNative.isSupportFastLoad() == false) goto L40;
        if (r18 != null) goto L39;
    L46:
        if (r10 == 0) goto L48;
        return null;
    L48:
        if (BoostNative.isSupportFastLoad() == true) goto L50;
        Monitor.get().logError("Do not support apk buf!");
    L50:
        ZipFile r19 = new ZipFile(r13);
        DexHolder.ApkBuffer r2 = new DexHolder.ApkBuffer(r12, obtainEntryBytesInApk(r19, r19.getEntry(Constants.DEX_PREFIX + r12 + ".dex")), r3, r8);
        r19.close();
        return r2;
    L39:
        return new DexHolder.DexBuffer(r12, r18, r8);
    L40:
        if (r18 != null) goto L42;
        ZipFile r20 = new ZipFile(r13);
        return DexHolder.obtainValidForceDexOpt(this.mPreferences, r12, r3, r8, r20, r20.getEntry(Constants.DEX_PREFIX + r12 + ".dex"));
    L42:
        return new DexHolder.DexOpt(r12, r18, r8, true);
    L45:
        r10 = r4;
        goto L46
    }

    @SuppressLint({"ApplySharedPref"})
    private List<DexHolder> obtainDexObjectList(File r24, File r25, File r26, File r27, File r28, Result r29) {
        long r0 = Utility.doZipCheckSum(r24);
        long r2 = r24.lastModified();
        long r10 = this.mPreferences.getLong("timestamp", -1);
        String r12 = Constants.KEY_CRC;
        if (r10 == r2) goto L5;
    L8:
        boolean r8 = true;
    L9:
        r29.modified = r8;
        ArrayList r9 = new ArrayList();
        int r4 = 2;
        if (r8 == false) goto L27;
        Utility.clearDirFiles(r26);
        Utility.clearDirFiles(r27);
        Utility.clearDirFiles(r28);
        SharedPreferences.Editor r11 = this.mPreferences.edit();
        r11.clear();
        r11.commit();
        ZipFile r13 = new ZipFile(r24);
    L12:
        ZipEntry r14 = r13.getEntry(Constants.DEX_PREFIX + r4 + ".dex");
        if (r14 == null) goto L26;
        long r20 = r0;
        File r15 = new File(r26, r4 + ".dex");
        String r22 = r12;
        File r1 = new File(r27, r4 + Constants.ODEX_SUFFIX);
        if (BoostNative.isSupportFastLoad() == false) goto L21;
        if (Utility.isBetterUseApkBuf() == false) goto L19;
        r9.add(new DexHolder.ApkBuffer(r4, obtainEntryBytesInApk(r13, r14), r15, r1));
    L25:
        r4 = r4 + 1;
        r0 = r20;
        r12 = r22;
        goto L12
    L19:
        DexHolder r3 = DexHolder.obtainValidDexBuffer(this.mPreferences, r4, obtainEntryFileInApk(r13, r14, r15), r1);
    L24:
        r9.add(r3);
        goto L25
    L21:
        if (Environment.getDataDirectory().getFreeSpace() <= Constants.SPACE_THRESHOLD) goto L23;
        r3 = DexHolder.obtainValidForceDexOpt(this.mPreferences, r4, r15, r1, r13, r14);
        goto L24
    L23:
        r3 = DexHolder.obtainValidZipDex(this.mPreferences, r4, new File(r28, r4 + Constants.ZIP_SUFFIX), new File(r28, r4 + Constants.ODEX_SUFFIX), r13, r14);
        goto L24
    L26:
        r13.close();
        r11.putInt(Constants.KEY_DEX_NUMBER, r4 - 1);
        r11.putLong("timestamp", r2);
        r11.putLong(r12, r0);
        r11.commit();
    L30:
        return r9;
    L27:
        int r16 = this.mPreferences.getInt(Constants.KEY_DEX_NUMBER, 0);
        int r17 = 2;
    L28:
        if (r17 > r16) goto L30;
        r9.add(obtainDexHolder(r17, r24, r26, r27, r28));
        r17 = r17 + 1;
        goto L28
    L5:
        if (this.mPreferences.getLong(Constants.KEY_CRC, -1) != r0) goto L8;
        r8 = false;
        goto L9
    }

    private byte[] obtainEntryBytesInApk(ZipFile r1, ZipEntry r2) {
        return Utility.obtainEntryBytesInZip(r1, r2);
    }

    private File obtainEntryFileInApk(ZipFile r1, ZipEntry r2, File r3) {
        return Utility.obtainEntryFileInZip(r1, r2, r3);
    }

    void doInstallation(final Context r11, File r12, Result r13) {
        File r1 = r11.getFilesDir();
        if (r1.exists() == true) goto L5;
        Utility.mkdirChecked(r1);
    L5:
        Utility.clearDirFiles(new File(r1.getParent(), Constants.CODE_CACHE_SECONDARY_FOLDER_NAME));
        File r6 = Utility.ensureDirCreated(r1, Constants.BOOST_MULTIDEX_DIR_NAME);
        File r7 = Utility.ensureDirCreated(r6, Constants.DEX_DIR_NAME);
        File r8 = Utility.ensureDirCreated(r6, Constants.ODEX_DIR_NAME);
        File r9 = Utility.ensureDirCreated(r6, Constants.ZIP_DIR_NAME);
        r13.setDirs(r1, r6, r7, r8, r9);
        Locker r0 = new Locker(new File(r6, Constants.LOCK_PREPARE_FILENAME));
        r0.lock();
        Locker r2 = new Locker(new File(r6, Constants.LOCK_INSTALL_FILENAME));
        r2.lock();
        r0.close();
        this.mPreferences = INVOKEVIRTUAL_com_bytedance_boost_multidex_DexInstallProcessor_com_obric_matrix_SPLancet_getSharedPreferences2(r11, Constants.PREFS_FILE, 0);     // Catch: Throwable -> L19
        r13.freeSpaceBefore = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L19
        List<DexHolder> r14 = obtainDexObjectList(r12, r6, r7, r8, r9, r13);     // Catch: Throwable -> L19
        installSecondaryDexes(r11.getClassLoader(), r14);     // Catch: Throwable -> L19
        r2.close();
        long r3 = Environment.getDataDirectory().getFreeSpace();
        r13.freeSpaceAfter = r3;
        if (r3 >= Constants.SPACE_MIN_THRESHOLD) goto L10;
        Monitor.get().logWarning("Free space is too small: " + r3 + ", compare to " + Constants.SPACE_MIN_THRESHOLD);
        return;
    L10:
        Iterator<DexHolder> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L36;
        DexHolder r16 = r15.next();
        if ((r16 instanceof DexHolder.ZipOpt) == true) goto L12;
        if ((r16 instanceof DexHolder.DexOpt) == true) goto L12;
        Monitor.get().doAfterInstall(new AnonymousClass1(this, r11));
        return;
    L36:
        return;
    L19:
        th = move-exception;
        Monitor.get().logWarning("Failed to install extracted secondary dex files", th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r2.close();
        throw th;
    }

    void doInstallationInOptProcess(Context r6, File r7) {
        if (BoostNative.isSupportFastLoad() == true) goto L6;
        Monitor.get().logError("Fast load is not supported!");
        return;
    L6:
        int r0 = 2;
        ZipFile r1 = new ZipFile(r7);
        ArrayList r8 = new ArrayList();
    L7:
        ZipEntry r2 = r1.getEntry(Constants.DEX_PREFIX + r0 + ".dex");
        if (r2 == null) goto L10;
        r8.add(new DexHolder.ApkBuffer(r0, obtainEntryBytesInApk(r1, r2), null, null));
        r0 = r0 + 1;
        goto L7
    L10:
        DexLoader.create(Build.VERSION.SDK_INT).install(r6.getClassLoader(), r8);
        r1.close();
        BoostNative.recoverAction();     // Catch: UnsatisfiedLinkError -> L13
        return;
    }
}
