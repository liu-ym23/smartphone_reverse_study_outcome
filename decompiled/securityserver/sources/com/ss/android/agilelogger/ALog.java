package com.ss.android.agilelogger;

import a.a;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.Log;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.ss.android.agilelogger.utils.StackTraceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ALog {
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    public static ALogConfig sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile ILogCacheCallback sILogCacheCallback = null;
    private static volatile List<INativeFuncAddrCallback> sINativeFuncAddrCallbackList = null;
    private static volatile boolean sInitSuccess = false;
    private static ScheduledExecutorService sOuterExecutorService;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.ALog$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE = null;

        static {
            int[] r0 = new int[FormatUtils.TYPE.values().length];
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE = r0;
            r0[FormatUtils.TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
    }

    public ALog() {
    }

    public static /* synthetic */ void access$000(Queue r0) {
        writeCachedItems(r0);
    }

    public static /* synthetic */ ILogCacheCallback access$100() {
        return sILogCacheCallback;
    }

    public static /* synthetic */ void access$200(String r0, String r1) {
        removeLegacyFiles(r0, r1);
    }

    public static void addNativeFuncAddrCallback(INativeFuncAddrCallback r1) {
        sINativeFuncAddrCallbackList.add(r1);
    }

    public static void asyncFlush() {
        Log.asyncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
    }

    public static void bundle(int r1, String r2, Bundle r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static void changeLevel(int r1) {
        prio = r1;
        Log.setLevel(level2AlogCoreLevel(r1));
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.setLevel(level2AlogCoreLevel(r1));
        return;
    }

    private static boolean checkPrioAndTag(int r2, String r3) {
        if (r2 >= prio) goto L6;
        return false;
    L6:
        if (mBlockTagSet != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (mBlockTagSet.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void d(String r1, String r2) {
        if (checkPrioAndTag(3, r1) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
    L9:
        Log.d(r1, r2);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.d(r1, r2);
    }

    public static void destroy() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public static void e(String r1, String r2) {
        if (checkPrioAndTag(6, r1) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
    L9:
        Log.e(r1, r2);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.e(r1, r2);
    }

    @Deprecated
    public static void flush() {
        Log.asyncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    public static List<String> getALogFiles(long r9, long r11) {
        ArrayList r0 = new ArrayList();
        File[] r10 = Log.getLogs(null, null, r9 * 1000, r11 * 1000);     // Catch: Exception -> L8
        int r12 = r10.length;     // Catch: Exception -> L8
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L7;
        r0.add(r10[r13].getAbsolutePath());     // Catch: Exception -> L8
        r13 = r13 + 1;
    L7:
        return r0;
    }

    public static long getALogWriteFuncAddr() {
        return Log.getLegacyWriteFuncAddr();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return Log.getLegacyFlushFuncAddr();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return Log.getLegacyGetLogFileDirFuncAddr();
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static List<INativeFuncAddrCallback> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static String getStatus() {
        return Log.getStatus();
    L4:
        return "getStatus exception";
    }

    private static void handleItemMsg(LogItem r2) {
        switch(AnonymousClass6.$SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[r2.mFormatType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = "";
    L16:
        r2.mMsg = r0;
        return;
    L5:
        r0 = FormatUtils.format(r2.mFormatType, (StackTraceElement[]) r2.mObj);
        goto L16
    L6:
        r0 = FormatUtils.format(r2.mFormatType, (Thread) r2.mObj);
        goto L16
    L7:
        r0 = FormatUtils.format(r2.mFormatType, (Throwable) r2.mObj);
        goto L16
    L8:
        r0 = FormatUtils.format(r2.mFormatType, (Intent) r2.mObj);
        goto L16
    L9:
        r0 = FormatUtils.format(r2.mFormatType, (Bundle) r2.mObj);
        goto L16
    L10:
        r0 = FormatUtils.format(r2.mFormatType, (String) r2.mObj);
        goto L16
    L15:
        r0 = (String) r2.mObj;
        goto L16
    L12:
        if (r2.mObj2 != null) goto L14;
        r0 = StackTraceUtils.getStackTraceString((Throwable) r2.mObj);
        goto L16
    L14:
        r0 = r2.mObj2 + StackTraceUtils.getStackTraceString((Throwable) r2.mObj);
        goto L16
    }

    public static void header(int r1, String r2, String r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.BORDER, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static void i(String r1, String r2) {
        if (checkPrioAndTag(4, r1) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
    L9:
        Log.i(r1, r2);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.i(r1, r2);
    }

    public static boolean init(ALogConfig r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        sConfig = r5;
        Alog.init(new LibLoader());     // Catch: Throwable -> L59
        prio = r5.getLevel();
        Alog.Builder r0 = new Alog.Builder(r5.getContext()).setInstanceName("default").setLevel(level2AlogCoreLevel(r5.getLevel())).setSyslog(sDebug).setLogFileDir(r5.getLogDirPath()).setLogFileSizeEach(r5.getPerSize()).setLogFileSizeTotal(r5.getMaxDirSize()).setLogFileExpDays(r5.getLogFileExpDays()).setCacheFileDir(r5.getBufferDirPath()).setCacheFileSizeEach(65536).setCacheFileSizeTotal(196608);
        Alog.Mode r1 = Alog.Mode.SAFE;
        Alog.Builder r2 = r0.setMode(r1);
        Alog.TimeFormat r3 = Alog.TimeFormat.RAW;
        Alog.Builder r4 = r2.setTimeFormat(r3);
        Alog.PrefixFormat r6 = Alog.PrefixFormat.LEGACY;
        Alog.Builder r7 = r4.setPrefixFormat(r6);
        if (r5.isCompress() == false) goto L10;
        Alog.Compress r8 = Alog.Compress.ZSTD;
    L11:
        Alog.Builder r9 = r7.setCompress(r8);
        if (r5.isEncrypt() == false) goto L14;
        Alog.SymCrypt r10 = Alog.SymCrypt.TEA_16;
    L15:
        Alog.Builder r11 = r9.setSymCrypt(r10);
        if (r5.isEncrypt() == false) goto L18;
        Alog.AsymCrypt r12 = Alog.AsymCrypt.EC_SECP256K1;
    L19:
        Log.setInstance(r11.setAsymCrypt(r12).setServerPublicKey(r5.getPubKey()).build());
        if (r5.isMainThreadSpeedUp() == true) goto L22;
    L36:
        final String r13 = r5.getBufferDirPath();
        final String r14 = r5.getLogDirPath();
        final Queue<LogItem> r15 = null;
        if (sILogCacheCallback == null) goto L45;
        Queue<LogItem> r16 = sILogCacheCallback.getCachedLog();
        if (r16 != null) goto L41;
    L43:
        r15 = r16;
        goto L45
    L41:
        if (r16.size() != 0) goto L43;
    L45:
        if (r15 == null) goto L47;
    L53:
        Runnable r17 = new AnonymousClass1(r15, r13, r14);
        ScheduledExecutorService r18 = sOuterExecutorService;
        if (r18 != null) goto L56;
        new Thread(r17, "_ALOG_OPT_").start();
    L57:
        sInitSuccess = true;
        return true;
    L56:
        r18.execute(r17);
        goto L57
    L47:
        if (getNativeFuncAddrCallbackList().size() > 0) goto L53;
        ScheduledExecutorService r19 = sOuterExecutorService;
        if (r19 != null) goto L52;
        new Timer("_ALOG_OPT_").schedule(new AnonymousClass2(r13, r14), 15000);
        goto L57
    L52:
        r19.schedule(new AnonymousClass3(r13, r14), 15, TimeUnit.SECONDS);
        goto L57
    L22:
        if (Util.isMainProcess(r5.getContext()) == false) goto L36;
        Alog.Builder r20 = new Alog.Builder(r5.getContext()).setInstanceName("main").setLevel(level2AlogCoreLevel(r5.getLevel())).setSyslog(sDebug).setLogFileDir(r5.getLogDirPath()).setLogFileSizeEach(r5.getPerSize() / 2).setLogFileSizeTotal(r5.getMaxDirSize() / 2).setLogFileExpDays(r5.getLogFileExpDays()).setCacheFileDir(r5.getBufferDirPath()).setCacheFileSizeEach(32768).setCacheFileSizeTotal(98304).setMode(r1).setTimeFormat(r3).setPrefixFormat(r6);
        if (r5.isCompress() == false) goto L26;
        Alog.Compress r21 = Alog.Compress.ZSTD;
    L27:
        Alog.Builder r22 = r20.setCompress(r21);
        if (r5.isEncrypt() == false) goto L30;
        Alog.SymCrypt r23 = Alog.SymCrypt.TEA_16;
    L31:
        Alog.Builder r24 = r22.setSymCrypt(r23);
        if (r5.isEncrypt() == false) goto L34;
        Alog.AsymCrypt r25 = Alog.AsymCrypt.EC_SECP256K1;
    L35:
        mainThreadRef = r24.setAsymCrypt(r25).setServerPublicKey(r5.getPubKey()).build();
        goto L36
    L34:
        r25 = Alog.AsymCrypt.NONE;
        goto L35
    L30:
        r23 = Alog.SymCrypt.NONE;
        goto L31
    L26:
        r21 = Alog.Compress.NONE;
        goto L27
    L18:
        r12 = Alog.AsymCrypt.NONE;
        goto L19
    L14:
        r10 = Alog.SymCrypt.NONE;
        goto L15
    L10:
        r8 = Alog.Compress.NONE;
    L59:
        return false;
    }

    public static void intent(int r1, String r2, Intent r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.INTENT, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void json(int r1, String r2, String r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.JSON, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    private static int level2AlogCoreLevel(int r0) {
        return r0 - 2;
    }

    public static void println(int r1, String r2, Object r3, FormatUtils.TYPE r4) {
        if (checkPrioAndTag(r1, r2) == false) goto L23;
        int r5 = level2AlogCoreLevel(r1);
        switch(AnonymousClass6.$SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[r4.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L6:
        String r6 = "";
    L17:
        if (mainThreadRef != null) goto L19;
    L21:
        Log.write(r5, r2, r6);
        return;
    L19:
        if (Util.isMainThread() == false) goto L21;
        mainThreadRef.write(r5, r2, r6);
        return;
    L7:
        r6 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r3);
        goto L17
    L8:
        r6 = FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) r3);
        goto L17
    L9:
        r6 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) r3);
        goto L17
    L10:
        r6 = FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) r3);
        goto L17
    L11:
        r6 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) r3);
        goto L17
    L12:
        r6 = FormatUtils.format(FormatUtils.TYPE.JSON, (String) r3);
        goto L17
    L13:
        r6 = FormatUtils.format(FormatUtils.TYPE.BORDER, (String) r3);
        goto L17
    L14:
        r6 = StackTraceUtils.getStackTraceString((Throwable) r3);
        goto L17
    L15:
        r6 = (String) r3;
        goto L17
    }

    public static void release() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    private static void removeLegacyFiles(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new AnonymousClass4());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        File r7 = new File(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new AnonymousClass5());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void setBlockTagSet(Set<String> r0) {
        mBlockTagSet = Collections.unmodifiableSet(r0);
    }

    public static void setDebug(boolean r1) {
        sDebug = r1;
        Log.setSyslog(sDebug);
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L6;
        r2.setSyslog(sDebug);
        return;
    }

    public static void setILogCacheCallback(ILogCacheCallback r0) {
        sILogCacheCallback = r0;
    }

    public static void setOuterExecutorService(ScheduledExecutorService r0) {
        sOuterExecutorService = r0;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r0) {
    }

    @Deprecated
    public static void setsPackageClassName(String r0) {
    }

    public static void stacktrace(int r1, String r2, StackTraceElement[] r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static void statcktrace(int r0, String r1, StackTraceElement[] r2) {
        stacktrace(r0, r1, r2);
    }

    public static void syncFlush() {
        Log.syncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.syncFlush();
        return;
    }

    public static void thread(int r1, String r2, Thread r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.THREAD, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static void throwable(int r1, String r2, Throwable r3) {
        if (checkPrioAndTag(r1, r2) == false) goto L11;
        int r4 = level2AlogCoreLevel(r1);
        String r5 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.write(r4, r2, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.write(r4, r2, r5);
        return;
    }

    public static void timedSyncFlush(int r1) {
        Log.timedSyncFlush(r1);
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.timedSyncFlush(r1);
        return;
    }

    public static void v(String r1, String r2) {
        if (checkPrioAndTag(2, r1) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
    L9:
        Log.v(r1, r2);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.v(r1, r2);
    }

    public static void w(String r1, String r2) {
        if (checkPrioAndTag(5, r1) == true) goto L5;
        return;
    L5:
        if (mainThreadRef != null) goto L7;
    L9:
        Log.w(r1, r2);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.w(r1, r2);
    }

    private static void writeCachedItems(Queue<LogItem> r3) {
        Iterator<LogItem> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        LogItem r0 = r4.next();
        if (checkPrioAndTag(r0.mLevel, r0.mTag) == false) goto L4;
        handleItemMsg(r0);
        Log.write(level2AlogCoreLevel(r0.mLevel), r0.mTag, r0.mMsg);
        goto L4
    }

    public static void e(String r1, String r2, Throwable r3) {
        if (checkPrioAndTag(6, r1) == false) goto L11;
        StringBuilder r4 = a.t(r2, "\n");
        r4.append(StackTraceUtils.getStackTraceString(r3));
        String r5 = r4.toString();
        if (mainThreadRef != null) goto L7;
    L9:
        Log.e(r1, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.e(r1, r5);
        return;
    }

    public static List<String> getALogFiles(String r9, String r10, long r11, long r13) {
        ArrayList r0 = new ArrayList();
        File[] r12 = Log.getLogs(r9, r10, r11 * 1000, r13 * 1000);     // Catch: Exception -> L8
        int r14 = r12.length;     // Catch: Exception -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L7;
        r0.add(r12[r15].getAbsolutePath());     // Catch: Exception -> L8
        r15 = r15 + 1;
    L7:
        return r0;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (checkPrioAndTag(5, r1) == false) goto L11;
        StringBuilder r4 = a.t(r2, "\n");
        r4.append(StackTraceUtils.getStackTraceString(r3));
        String r5 = r4.toString();
        if (mainThreadRef != null) goto L7;
    L9:
        Log.w(r1, r5);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.w(r1, r5);
        return;
    }

    public static void e(String r1, Throwable r2) {
        if (checkPrioAndTag(6, r1) == false) goto L11;
        String r3 = StackTraceUtils.getStackTraceString(r2);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.e(r1, r3);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.e(r1, r3);
        return;
    }

    public static void w(String r1, Throwable r2) {
        if (checkPrioAndTag(5, r1) == false) goto L11;
        String r3 = StackTraceUtils.getStackTraceString(r2);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.w(r1, r3);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.w(r1, r3);
        return;
    }
}
