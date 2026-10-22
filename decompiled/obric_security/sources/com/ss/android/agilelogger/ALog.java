package com.ss.android.agilelogger;

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
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
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
    static /* synthetic */ class AnonymousClass6 {
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

    @Deprecated
    public static void forceLogSharding() {
    }

    private static int level2AlogCoreLevel(int r0) {
        return r0 - 2;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r0) {
    }

    @Deprecated
    public static void setsPackageClassName(String r0) {
    }

    public ALog() {
    }

    static /* synthetic */ void access$000(Queue r0) {
        writeCachedItems(r0);
    }

    static /* synthetic */ ILogCacheCallback access$100() {
        return sILogCacheCallback;
    }

    static /* synthetic */ void access$200(String r0, String r1) {
        removeLegacyFiles(r0, r1);
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
    }

    public static boolean init(ALogConfig r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        sConfig = r7;
        Alog.init(new LibLoader());     // Catch: Throwable -> L60
        prio = r7.getLevel();
        Alog.Builder r1 = new Alog.Builder(r7.getContext()).setInstanceName("default").setLevel(level2AlogCoreLevel(r7.getLevel())).setSyslog(sDebug).setLogFileDir(r7.getLogDirPath()).setLogFileSizeEach(r7.getPerSize()).setLogFileSizeTotal(r7.getMaxDirSize()).setLogFileExpDays(r7.getLogFileExpDays()).setCacheFileDir(r7.getBufferDirPath()).setCacheFileSizeEach(65536).setCacheFileSizeTotal(196608).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r7.isCompress() == false) goto L10;
        Alog.Compress r2 = Alog.Compress.ZSTD;
    L11:
        Alog.Builder r3 = r1.setCompress(r2);
        if (r7.isEncrypt() == false) goto L14;
        Alog.SymCrypt r4 = Alog.SymCrypt.TEA_16;
    L15:
        Alog.Builder r5 = r3.setSymCrypt(r4);
        if (r7.isEncrypt() == false) goto L18;
        Alog.AsymCrypt r6 = Alog.AsymCrypt.EC_SECP256K1;
    L19:
        Log.setInstance(r5.setAsymCrypt(r6).setServerPublicKey(r7.getPubKey()).build());
        if (r7.isMainThreadSpeedUp() == true) goto L22;
    L36:
        final String r8 = r7.getBufferDirPath();
        final String r9 = r7.getLogDirPath();
        final Queue<LogItem> r10 = null;
        if (sILogCacheCallback == null) goto L45;
        Queue<LogItem> r11 = sILogCacheCallback.getCachedLog();
        if (r11 != null) goto L41;
    L43:
        r10 = r11;
        goto L45
    L41:
        if (r11.size() != 0) goto L43;
    L45:
        if (r10 == null) goto L47;
    L48:
        Runnable r12 = new AnonymousClass1(r10, r8, r9);
        ScheduledExecutorService r13 = sOuterExecutorService;
        if (r13 != null) goto L51;
        new Thread(r12, "_ALOG_OPT_").start();
    L52:
        r0 = true;
    L53:
        if (r0 == true) goto L58;
        ScheduledExecutorService r14 = sOuterExecutorService;
        if (r14 != null) goto L57;
        new Timer("_ALOG_OPT_").schedule(new AnonymousClass2(r8, r9), 15000);
        goto L58
    L57:
        r14.schedule(new AnonymousClass3(r8, r9), 15, TimeUnit.SECONDS);
    L58:
        sInitSuccess = true;
        return true;
    L51:
        r13.execute(r12);
        goto L52
    L47:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L53;
    L22:
        if (Util.isMainProcess(r7.getContext()) == false) goto L36;
        Alog.Builder r15 = new Alog.Builder(r7.getContext()).setInstanceName("main").setLevel(level2AlogCoreLevel(r7.getLevel())).setSyslog(sDebug).setLogFileDir(r7.getLogDirPath()).setLogFileSizeEach(r7.getPerSize() / 2).setLogFileSizeTotal(r7.getMaxDirSize() / 2).setLogFileExpDays(r7.getLogFileExpDays()).setCacheFileDir(r7.getBufferDirPath()).setCacheFileSizeEach(32768).setCacheFileSizeTotal(98304).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r7.isCompress() == false) goto L26;
        Alog.Compress r16 = Alog.Compress.ZSTD;
    L27:
        Alog.Builder r17 = r15.setCompress(r16);
        if (r7.isEncrypt() == false) goto L30;
        Alog.SymCrypt r18 = Alog.SymCrypt.TEA_16;
    L31:
        Alog.Builder r19 = r17.setSymCrypt(r18);
        if (r7.isEncrypt() == false) goto L34;
        Alog.AsymCrypt r20 = Alog.AsymCrypt.EC_SECP256K1;
    L35:
        mainThreadRef = r19.setAsymCrypt(r20).setServerPublicKey(r7.getPubKey()).build();
        goto L36
    L34:
        r20 = Alog.AsymCrypt.NONE;
        goto L35
    L30:
        r18 = Alog.SymCrypt.NONE;
        goto L31
    L26:
        r16 = Alog.Compress.NONE;
        goto L27
    L18:
        r6 = Alog.AsymCrypt.NONE;
        goto L19
    L14:
        r4 = Alog.SymCrypt.NONE;
        goto L15
    L10:
        r2 = Alog.Compress.NONE;
    L60:
        return false;
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

    public static void setDebug(boolean r1) {
        sDebug = r1;
        Log.setSyslog(sDebug);
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L6;
        r2.setSyslog(sDebug);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void setBlockTagSet(Set<String> r0) {
        mBlockTagSet = Collections.unmodifiableSet(r0);
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static void setILogCacheCallback(ILogCacheCallback r0) {
        sILogCacheCallback = r0;
    }

    public static void addNativeFuncAddrCallback(INativeFuncAddrCallback r1) {
        sINativeFuncAddrCallbackList.add(r1);
    }

    public static List<INativeFuncAddrCallback> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
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

    public static void w(String r1, String r2, Throwable r3) {
        if (checkPrioAndTag(5, r1) == false) goto L11;
        String r4 = r2 + IOUtils.LINE_SEPARATOR_UNIX + StackTraceUtils.getStackTraceString(r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.w(r1, r4);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.w(r1, r4);
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

    public static void e(String r1, String r2, Throwable r3) {
        if (checkPrioAndTag(6, r1) == false) goto L11;
        String r4 = r2 + IOUtils.LINE_SEPARATOR_UNIX + StackTraceUtils.getStackTraceString(r3);
        if (mainThreadRef != null) goto L7;
    L9:
        Log.e(r1, r4);
        return;
    L7:
        if (Util.isMainThread() == false) goto L9;
        mainThreadRef.e(r1, r4);
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

    public static void asyncFlush() {
        Log.asyncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
    }

    public static void syncFlush() {
        Log.syncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.syncFlush();
        return;
    }

    public static void timedSyncFlush(int r1) {
        Log.timedSyncFlush(r1);
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.timedSyncFlush(r1);
        return;
    }

    public static void setOuterExecutorService(ScheduledExecutorService r0) {
        sOuterExecutorService = r0;
    }

    public static void changeLevel(int r1) {
        prio = r1;
        Log.setLevel(level2AlogCoreLevel(r1));
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.setLevel(level2AlogCoreLevel(r1));
        return;
    }

    public static List<String> getALogFiles(long r7, long r9) {
        ArrayList r0 = new ArrayList();
        File[] r8 = Log.getLogs(null, null, r7 * 1000, r9 * 1000);     // Catch: Exception -> L8
        int r10 = r8.length;     // Catch: Exception -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L7;
        r0.add(r8[r11].getAbsolutePath());     // Catch: Exception -> L8
        r11 = r11 + 1;
    L7:
        return r0;
    }

    public static String getStatus() {
        return Log.getStatus();
    L4:
        return "getStatus exception";
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

    public static void destroy() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public static void release() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Deprecated
    public static void flush() {
        Log.asyncFlush();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.asyncFlush();
        return;
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
}
