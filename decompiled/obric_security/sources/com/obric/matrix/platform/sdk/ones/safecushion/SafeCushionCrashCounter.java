package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.repair.BaseRepair;
import com.obric.matrix.platform.sdk.ones.safecushion.ui.CushionActivity;
import com.obric.matrix.platform.sdk.ones.safecushion.util.AppUtil;
import com.obric.matrix.platform.sdk.ones.safecushion.util.FlagHelper;
import com.obric.matrix.platform.sdk.ones.safecushion.util.SafeCushionFileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SafeCushionCrashCounter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u000e\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0004J\b\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010\u0015\u001a\u00020\u001cJ\"\u0010.\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u000101J\u0006\u00102\u001a\u00020\u001cJ\b\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u0006H\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0006H\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J?\u0010;\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042%\b\u0002\u0010+\u001a\u001f\u0012\u0013\u0012\u00110-¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0006\u0018\u00010=H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006A"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/SafeCushionCrashCounter;", "", "()V", "TAG", "", "alreadyStartedSafeMode", "", "currentCrashCount", "", "flagHelper", "Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "haveHandledSafeModeAction", "increaseCrashCountSuccess", "isMainProcess", "()Z", "isMainProcess$delegate", "Lkotlin/Lazy;", "isSafeProcess", "isSafeProcess$delegate", "lastCrashCount", "lastSupposeCrashCount", "normalStart", "safeModeCrashThreshold", "getSafeModeCrashThreshold", "()I", "canClearCrash", "fileNamePrefix", "checkCrash", "", "clearCrashInfo", "deleteTempCrashFile", "clearSupposeCrashCount", "deleteCrashFile", "deleteSupposeCrashFiles", "exitProcess", "getCrashCountFromFile", "crashFileNamePrefix", "handleCrash", "increaseCrashCount", "crashType", "increaseSupposeCrashCount", "initSafeMode", "isHeadlessMode", "needInterrupt", "file", "Ljava/io/File;", "onCrash", "crashMsg", "thread", "Ljava/lang/Thread;", "onNpthInitFinish", "performCheckCrash", "performExitProcess", "needExit", "performOpenAppStore", "isLaunchCheckCrash", "startActivityIfNeed", "startHeadlessRepair", "startSafeMode", "updateCrashCount", "crashFileName", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "crashFile", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeCushionCrashCounter {
    public static final SafeCushionCrashCounter INSTANCE = null;
    private static final String TAG = "SafeModeCounter";
    private static boolean alreadyStartedSafeMode;
    private static int currentCrashCount;
    private static final FlagHelper flagHelper = null;
    private static volatile boolean haveHandledSafeModeAction;
    private static boolean increaseCrashCountSuccess;
    private static final Lazy isMainProcess$delegate = null;
    private static final Lazy isSafeProcess$delegate = null;
    private static int lastCrashCount;
    private static int lastSupposeCrashCount;
    private static volatile boolean normalStart;

    private SafeCushionCrashCounter() {
    }

    public static final /* synthetic */ boolean access$needInterrupt(SafeCushionCrashCounter r0, File r1) {
        return r0.needInterrupt(r1);
    }

    static {
        SafeCushionCrashCounter r0 = new SafeCushionCrashCounter();
        INSTANCE = r0;
        lastSupposeCrashCount = -1;
        lastCrashCount = -1;
        currentCrashCount = -1;
        flagHelper = new FlagHelper();
        isMainProcess$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        isSafeProcess$delegate = LazyKt.lazy(C02322.INSTANCE);
        if (r0.isMainProcess() == false) goto L5;
        lastSupposeCrashCount = r0.getCrashCountFromFile(SafeCushionConstant.SUPPOSE_CRASH_FILE_NAME_PREFIX);
        int r1 = r0.getCrashCountFromFile(SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX);
        currentCrashCount = r1;
        lastCrashCount = r1;
        r0.performCheckCrash();
    L5:
        r0.initSafeMode();
    }

    private final boolean isMainProcess() {
        return ((Boolean) isMainProcess$delegate.getValue()).booleanValue();
    }

    private final boolean isSafeProcess() {
        return ((Boolean) isSafeProcess$delegate.getValue()).booleanValue();
    }

    public final int getCrashCountFromFile(String r8) {
        Intrinsics.checkNotNullParameter(r8, "crashFileNamePrefix");
        File r7 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(r8);
        if (r7 == null) goto L14;
        String r9 = r7.getName();     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r9, "it.name");     // Catch: Exception -> L8
        List r10 = StringsKt.split$default(r9, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L8
        if (r10.size() <= 1) goto L15;
        String r11 = (String) r10.get(1);     // Catch: Exception -> L8
        MLog.i$default(TAG, r8 + " getCrashCount: " + r11, null, 4, null);     // Catch: Exception -> L8
        return Integer.parseInt(r11);
    L15:
        return 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L14:
        return 0;
    }

    private final void performCheckCrash() {
        if (isMainProcess() == false) goto L6;
        checkCrash();
        return;
    }

    private final void checkCrash() {
        if (isMainProcess() == true) goto L5;
        return;
    L5:
        if (lastCrashCount >= getSafeModeCrashThreshold()) goto L9;
        if (lastSupposeCrashCount >= 4) goto L9;
        return;
    L9:
        if (isHeadlessMode() == false) goto L11;
        startSafeMode();
        return;
    L11:
        startActivityIfNeed(true);
    }

    public final void initSafeMode() {
        if (isSafeProcess() == false) goto L13;
        FlagHelper r2 = flagHelper;
        String r0 = r2.getSafeMode();
        if (r2.safeModeIsLegal(r0) == true) goto L7;
        return;
    L7:
        if (r0 != null) goto L10;
        r2.markStartSafeModeProcess("repair");
        return;
    L10:
        if (Intrinsics.areEqual(r0, "repair") == false) goto L16;
        r2.markStartSafeModeProcess(SafeCushionConstant.UPGRADE_MODE);
        return;
    L16:
        return;
    }

    private final int getSafeModeCrashThreshold() {
        int r0 = MatrixCushionManager.Companion.getInstance().getConfig().getCrashThreshold();
        if (r0 > 0) goto L7;
        return 3;
    L7:
        return r0;
    }

    private final boolean isHeadlessMode() {
        if (MatrixCushionManager.Companion.getInstance().getConfig().getUiProvider() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void increaseSupposeCrashCount() {
        if (isMainProcess() == false) goto L6;
        MLog.i$default(TAG, "increaseSupposeCrashCount lastSupposeCrashCount:" + lastSupposeCrashCount, null, 4, null);
        updateCrashCount$default(this, SafeCushionConstant.SUPPOSE_CRASH_FILE_NAME_PREFIX, "supposeCrash-" + (lastSupposeCrashCount + 1) + '-' + System.currentTimeMillis(), null, 4, null);
        return;
    }

    private final void clearSupposeCrashCount() {
        if (isMainProcess() == false) goto L6;
        lastSupposeCrashCount = 0;
        deleteSupposeCrashFiles();
        return;
    }

    private final void deleteSupposeCrashFiles() {
        File r5 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.SUPPOSE_CRASH_FILE_NAME_PREFIX);
        MLog.i$default(TAG, "deleteSupposeCrashFiles supposeCrashFile: " + r5, null, 4, null);
        if (r5 == null) goto L5;
        MLog.i$default(TAG, "deleteSupposeCrashFiles deleteSupposeCrashFileSuccess:" + SafeCushionFileUtils.INSTANCE.deleteDir(r5), null, 4, null);
    L5:
        File r6 = SafeCushionFileUtils.INSTANCE.getNormalFile(SafeCushionConstant.NPTH_NORMAL_INIT_FILE_NAME_PREFIX);
        if (r6 == null) goto L9;
        MLog.i$default(TAG, "deleteSupposeCrashFiles: deleteNpthNormalInitFileSuccess:" + SafeCushionFileUtils.INSTANCE.deleteDir(r6), null, 4, null);
        return;
    }

    private final void increaseCrashCount(String r10) {
        if (isMainProcess() == false) goto L8;
        MLog.i$default(TAG, "increaseCrashCount currentCrashCount:" + currentCrashCount, null, 4, null);
        if (updateCrashCount$default(this, SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX, "crashInfo-" + (currentCrashCount + 1) + '-' + System.currentTimeMillis() + '-' + r10, null, 4, null) == false) goto L9;
        increaseCrashCountSuccess = true;
        currentCrashCount++;
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean updateCrashCount$default(SafeCushionCrashCounter r0, String r1, String r2, AnonymousClass1 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = AnonymousClass1.INSTANCE;
    L6:
        return r0.updateCrashCount(r1, r2, r3);
    }

    private final boolean updateCrashCount(String r11, String r12, Function1<? super File, Boolean> r13) {
        File r2 = SafeCushionFileUtils.INSTANCE.getExistCrashInfoDir();     // Catch: Exception -> L38
        File r3 = new File(r2, r12);     // Catch: Exception -> L38
        File[] r4 = r2.listFiles();     // Catch: Exception -> L38
        StringBuilder r14 = new StringBuilder("updateCrashCount crashFileName:").append(r12).append(",containFile:");     // Catch: Exception -> L38
        if (r4 != null) goto L6;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        boolean r6 = true;
    L16:
        MLog.i$default(TAG, r14.append(r6).toString(), null, 4, null);     // Catch: Exception -> L38
        if (r4 == null) goto L36;
        int r15 = r4.length;     // Catch: Exception -> L38
        int r7 = 0;
    L19:
        if (r7 >= r15) goto L36;
        File r8 = r4[r7];     // Catch: Exception -> L38
        String r9 = r8.getName();     // Catch: Exception -> L38
        Intrinsics.checkNotNullExpressionValue(r9, "it.name");     // Catch: Exception -> L38
        if (StringsKt.startsWith$default(r9, r11, false, 2, null) == true) goto L23;
        r7 = r7 + 1;     // Catch: Exception -> L38
        goto L19
    L23:
        if (r13 == null) goto L27;
        Intrinsics.checkNotNullExpressionValue(r8, "it");     // Catch: Exception -> L38
        if (r13.invoke(r8).booleanValue() != true) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == false) goto L32;
        MLog.i$default(TAG, "updateCrashCount: interrupt", null, 4, null);     // Catch: Exception -> L38
        return false;
    L32:
        if (r8.renameTo(r3) == true) goto L34;
        SafeCushionFileUtils r10 = SafeCushionFileUtils.INSTANCE;     // Catch: Exception -> L38
        Intrinsics.checkNotNullExpressionValue(r8, "it");     // Catch: Exception -> L38
        r10.deleteDir(r8);     // Catch: Exception -> L38
        r3.createNewFile();     // Catch: Exception -> L38
    L34:
        return true;
    L27:
        r16 = false;
    L36:
        r3.createNewFile();     // Catch: Exception -> L38
        return true;
    L15:
        r6 = false;
        goto L16
    L6:
        if (r4.length != 0) goto L8;
        boolean r17 = true;
    L9:
        if (r17 == true) goto L12;
        r5 = false;
        goto L13
    L8:
        r17 = false;
    L38:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final boolean needInterrupt(File r8) {
        if (MatrixCushionManager.Companion.getInstance().getConfig().getCrashCountDebounceEnabled() == true) goto L5;
        return false;
    L5:
        String r7 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "file.name");
        List r9 = StringsKt.split$default(r7, new String[]{"-"}, false, 0, 6, null);
        if (r9.size() <= 2) goto L11;
        long r10 = Long.parseLong((String) r9.get(2));
        if ((System.currentTimeMillis() - r10) >= 1000) goto L11;
        return true;
    L11:
        return false;
    }

    public final void normalStart() {
        if (isMainProcess() == false) goto L8;
        normalStart = true;
        if (canClearCrash(SafeCushionConstant.MMY_NORMAL_START_FILE_NAME_PREFIX) == false) goto L9;
        clearCrashInfo$default(this, false, 1, null);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void clearCrashInfo$default(SafeCushionCrashCounter r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.clearCrashInfo(r1);
    }

    public final void clearCrashInfo(boolean r5) {
        MLog.i$default(TAG, "deleteCrashFile:" + normalStart + ",lastCrashCount:" + lastCrashCount + ",currentCrashCount:" + currentCrashCount, null, 4, null);
        lastCrashCount = 0;
        currentCrashCount = 0;
        deleteCrashFile(r5);
    }

    static /* synthetic */ void deleteCrashFile$default(SafeCushionCrashCounter r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.deleteCrashFile(r1);
    }

    private final void deleteCrashFile(boolean r3) {
        File r0 = SafeCushionFileUtils.INSTANCE.getExistCrashInfoDir();     // Catch: Exception -> L9
        SafeCushionFileUtils.INSTANCE.deleteDir(r0);     // Catch: Exception -> L9
        if (r3 == false) goto L18;
        File r4 = SafeCushionFileUtils.INSTANCE.getTempCrashInfoFile();     // Catch: Exception -> L9
        if (r4 == null) goto L18;
        SafeCushionFileUtils.INSTANCE.deleteDir(r4);     // Catch: Exception -> L9
    L18:
        File r5 = SafeCushionFileUtils.INSTANCE.getExistNormalInfoDir();     // Catch: Exception -> L13
        SafeCushionFileUtils.INSTANCE.deleteDir(r5);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        MLog.e(TAG, "deleteNormalFile: error", e);
        return;
    L9:
        e = move-exception;
        MLog.e(TAG, "deleteCrashFile: error", e);
        goto L18
    }

    public final void onNpthInitFinish() {
        if (canClearCrash(SafeCushionConstant.NPTH_NORMAL_INIT_FILE_NAME_PREFIX) == false) goto L6;
        clearSupposeCrashCount();
        return;
    }

    private final boolean canClearCrash(String r7) {
        MLog.i$default(TAG, "canClearCrash haveHandledSafeModeAction: " + haveHandledSafeModeAction + ",lastSupposeCrashCount:" + lastSupposeCrashCount + ",currentCrashCount:" + currentCrashCount, null, 4, null);     // Catch: Exception -> L15
        if (haveHandledSafeModeAction == false) goto L6;
    L11:
        int r8 = SafeCushionFileUtils.INSTANCE.getNormalFileCount(r7);     // Catch: Exception -> L15
        MLog.i$default(TAG, "canClearCrash normalFileCount: " + r8, null, 4, null);     // Catch: Exception -> L15
        if (r8 >= 1) goto L17;
        return false;
    L17:
        return true;
    L6:
        if (lastSupposeCrashCount >= 4) goto L10;
        if (currentCrashCount < 2) goto L17;
    L10:
        if (SafeCushionFileUtils.INSTANCE.isRepairNotFinish() == false) goto L17;
    L15:
        e = move-exception;
        MLog.e(TAG, "canClearCrash: error", e);
        goto L17
    }

    public final synchronized void onCrash(String r5, String r6, Thread r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "crashType");     // Catch: Throwable -> L29
        MLog.i$default(TAG, "onCrash:" + r5 + ",thread:" + r7 + ",crashMsg:" + r6, null, 4, null);     // Catch: Throwable -> L29
        if (isMainProcess() == true) goto L10;
        MLog.i$default(TAG, "onCrash isn't main process", null, 4, null);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L10:
        if (normalStart == false) goto L15;
        MLog.i$default(TAG, "onCrash already normalStart", null, 4, null);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L15:
        if (increaseCrashCountSuccess == true) goto L17;
        increaseCrashCount(r5);     // Catch: Throwable -> L29
    L17:
        SafeCushionFileUtils r0 = SafeCushionFileUtils.INSTANCE;     // Catch: Throwable -> L29
        if (r7 == null) goto L20;
        String r8 = r7.toString();     // Catch: Throwable -> L29
    L21:
        r0.saveCrashInfo(r5, r6, r8, currentCrashCount);     // Catch: Throwable -> L29
        if (haveHandledSafeModeAction == false) goto L26;
        MLog.i$default(TAG, "onCrash haveHandledSafeModeAction", null, 4, null);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L26:
        handleCrash();     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L20:
        r8 = null;
    L29:
        th = move-exception;
        throw th;
    }

    private final void handleCrash() {
        MatrixCushionManager r0 = MatrixCushionManager.Companion.getInstance();
        MatrixCushionConfig r1 = r0.getConfig();
        boolean r4 = true;
        if (r1.getForegroundCheckEnabled() == true) goto L5;
    L8:
        MLog.i$default(TAG, "performStartSafeMode currentCrashCount:" + currentCrashCount + ",isForeground:" + r4 + ",foregroundCheckEnabled:" + r1.getForegroundCheckEnabled(), null, 4, null);
        if (currentCrashCount < getSafeModeCrashThreshold()) goto L11;
    L12:
        if (r4 == true) goto L14;
        return;
    L14:
        if (isHeadlessMode() == false) goto L16;
        startSafeMode();
        return;
    L16:
        startActivityIfNeed(false);
        return;
    L11:
        if (lastSupposeCrashCount > getSafeModeCrashThreshold()) goto L12;
        return;
    L5:
        if (AppUtil.INSTANCE.isProcessInBackground(r0.getContext()) == false) goto L8;
        r4 = false;
        goto L8
    }

    private final void startActivityIfNeed(boolean r10) {
        MLog.i$default(TAG, "startActivityIfNeed isLaunchCheckCrash:" + r10, null, 4, null);
        FlagHelper r0 = flagHelper;
        Pair<Boolean, Long> r4 = r0.lastStartSafeModeInfo();
        if (r4.getFirst().booleanValue() == false) goto L22;
        MLog.i$default(TAG, "lastStartSafeModeInfo success", null, 4, null);
        if ((System.currentTimeMillis() - r4.getSecond().longValue()) > 2000) goto L8;
        MLog.i$default(TAG, "lastStartSafeModeInfo success,but time is near,return", null, 4, null);
        return;
    L8:
        Pair<String, Long> r5 = r0.lastStartSafeModeProcessInfo();
        Pair<String, Long> r6 = r0.lastSafeModeFlagInfo();
        MLog.i$default(TAG, "lastStartSafeModeProcess success,lastStartSafeModeProcess:" + r5.getFirst() + ",lastSafeModeFlag:" + r6.getFirst(), null, 4, null);
        if (r5.getFirst() != null) goto L11;
        Log.i("zhoupeng.725999", "lastStartSafeModeProcess fail");
        performOpenAppStore(r10);
        return;
    L11:
        if (r6.getFirst() != null) goto L17;
        long r1 = System.currentTimeMillis() - r5.getSecond().longValue();
        if (r1 > WsConstants.EXIT_DELAY_TIME) goto L15;
        Log.i("zhoupeng.725999", "wait for start Activity,duration:" + r1);
        return;
    L15:
        Log.i("zhoupeng.725999", "start Activity failed,duration:" + r1);
        performOpenAppStore(r10);
        return;
    L17:
        if (r0.upgradeFinish() == false) goto L19;
        Log.i("zhoupeng.725999", "upgradeFinish,openAppStore");
        performOpenAppStore(r10);
        return;
    L19:
        if (r10 == true) goto L27;
        Log.i("zhoupeng.725999", "!isLaunchCheckCrash,startSafeMode");
        startSafeMode();
        return;
    L27:
        return;
    L22:
        MLog.i$default(TAG, "not startSafeModeInfo,startSafeMode now", null, 4, null);
        alreadyStartedSafeMode = true;
        startSafeMode();
        performExitProcess(r10);
    }

    private final void performOpenAppStore(boolean r3) {
        if (alreadyStartedSafeMode == true) goto L6;
        haveHandledSafeModeAction = true;
        LaunchCrashCatcher.INSTANCE.openMarketDetails(MatrixCushionManager.Companion.getInstance().getContext());
        performExitProcess(r3);
        return;
    }

    private final void performExitProcess(boolean r1) {
        if (r1 == false) goto L5;
        exitProcess();
        return;
    }

    private final void exitProcess() {
        System.exit(1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "exitProcess: error", e);
    }

    private final boolean startSafeMode() {
        MLog.i$default(TAG, "startSafeMode", null, 4, null);
        haveHandledSafeModeAction = true;
        flagHelper.markStartSafeMode();
        if (isHeadlessMode() == true) goto L5;
        Context r4 = MatrixCushionManager.Companion.getInstance().getContext();     // Catch: Exception -> L8
        Intent r1 = new Intent(r4, CushionActivity.class);     // Catch: Exception -> L8
        r1.addFlags(268435456);     // Catch: Exception -> L8
        r4.startActivity(r1);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        MLog.e(TAG, "openSafeMode: error", e);
        return false;
    L5:
        return startHeadlessRepair();
    }

    private final boolean startHeadlessRepair() {
        List<BaseRepair> r1 = MatrixCushionManager.Companion.getInstance().getConfig().getRepairsForCrashCount(currentCrashCount);     // Catch: Exception -> L22
        String r2 = SafeCushionFileUtils.INSTANCE.getCrashMsg();     // Catch: Exception -> L22
        int r3 = SafeCushionFileUtils.INSTANCE.getCrashCount();     // Catch: Exception -> L22
        MLog.i$default(TAG, "startHeadlessRepair repairCount:" + r1.size() + ",crashCount:" + currentCrashCount, null, 4, null);     // Catch: Exception -> L22
        Iterator<T> r0 = r1.iterator();     // Catch: Exception -> L22
    L5:
        if (r0.hasNext() == false) goto L17;
        BaseRepair r4 = (BaseRepair) r0.next();     // Catch: Exception -> L22
        r4.bindExecutionContext$sdk_platform_ones_release(null, r2, r3);     // Catch: Exception -> L22
        r4.run();     // Catch: Throwable -> L10 Exception -> L12
    L8:
        r4.clearExecutionContext$sdk_platform_ones_release();     // Catch: Exception -> L22
    L12:
        e = move-exception;
        MLog.e(TAG, "startHeadlessRepair: repair error", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r4.clearExecutionContext$sdk_platform_ones_release();     // Catch: Exception -> L22
        throw th;     // Catch: Exception -> L22
    L17:
        FlagHelper r5 = flagHelper;     // Catch: Exception -> L22
        String r6 = r5.getSafeMode();     // Catch: Exception -> L22
        if (r6 != null) goto L20;
        r6 = "repair";
    L20:
        r5.updateSafeModeState(r6, SafeCushionConstant.FINISH_STATE);     // Catch: Exception -> L22
        return true;
    L22:
        e = move-exception;
        MLog.e(TAG, "startHeadlessRepair: error", e);
        return false;
    }
}
