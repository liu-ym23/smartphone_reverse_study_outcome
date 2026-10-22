package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.bytedance.lego.init.IdleTaskConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    private static Handler sAsyncHandler = null;
    private static HandlerThread sAsyncLogThread = null;
    public static com.ss.android.agilelogger.a sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile com.ss.android.agilelogger.b sILogCacheCallback = null;
    private static volatile List<com.ss.android.agilelogger.c> sINativeFuncAddrCallbackList = null;
    private static Object sInitLock = null;
    private static volatile boolean sInitSuccess = false;
    private static boolean sInitialized;
    private static long sMainThreadId;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;

    static class a extends Handler {
        a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            int r1 = r2.what;
            if (r1 != 1) goto L5;
            Object r3 = r2.obj;
            if (r3 != null) goto L11;
            return;
        L11:
            if ((r3 instanceof h) == false) goto L16;
            ALog.access$000((h) r3);
            return;
        L16:
            return;
        L5:
            if (r1 != 2) goto L17;
            com.bytedance.android.alog.c.a();
            return;
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Queue f11801f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11802g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f11803h;

        b(Queue r1, String r2, String r3) {
            this.f11801f = r1;
            this.f11802g = r2;
            this.f11803h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Queue r0 = this.f11801f;
            if (r0 == null) goto L5;
            ALog.access$100(r0);
            ALog.access$200().a();
        L5:
            Iterator<com.ss.android.agilelogger.c> r1 = ALog.getNativeFuncAddrCallbackList().iterator();
        L7:
            if (r1.hasNext() == false) goto L16;
            com.ss.android.agilelogger.c r2 = r1.next();
            if (r2 == null) goto L7;
            r2.a(com.bytedance.android.alog.c.h());
            goto L7
        L16:
            Thread.sleep(IdleTaskConfig.IDLE_START_TIME_OUT);     // Catch: Exception -> L15
        L13:
            ALog.access$300(this.f11802g, this.f11803h);
        }
    }

    static class c extends TimerTask {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11805g;

        c(String r1, String r2) {
            this.f11804f = r1;
            this.f11805g = r2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ALog.access$300(this.f11804f, this.f11805g);
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11806f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11807g;

        d(String r1, String r2) {
            this.f11806f = r1;
            this.f11807g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ALog.access$300(this.f11806f, this.f11807g);
        }
    }

    static class e implements FilenameFilter {
        e() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            return r2.startsWith(".logCache_");
        }
    }

    static class f implements FilenameFilter {
        f() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r1, String r2) {
            if (r2.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r2.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r2.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11808a = null;

        static {
            int[] r0 = new int[com.ss.android.agilelogger.h.b.a.values().length];
            f11808a = r0;
            r0[com.ss.android.agilelogger.h.b.a.f11853f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f11808a[com.ss.android.agilelogger.h.b.a.n.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f11808a[com.ss.android.agilelogger.h.b.a.f11858k.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f11808a[com.ss.android.agilelogger.h.b.a.f11854g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f11808a[com.ss.android.agilelogger.h.b.a.f11855h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f11808a[com.ss.android.agilelogger.h.b.a.f11856i.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f11808a[com.ss.android.agilelogger.h.b.a.f11857j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f11808a[com.ss.android.agilelogger.h.b.a.m.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f11808a[com.ss.android.agilelogger.h.b.a.f11859l.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    private static class h {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f11809j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static h f11810k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static int f11811l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f11815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.ss.android.agilelogger.h.b.a f11816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f11817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f11818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f11819h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public h f11820i;

        static {
            f11809j = new Object();
        }

        private h() {
            this.f11816e = null;
        }

        public static h a() {
            Object r0 = f11809j;
            monitor-enter(r0);
            h r1 = f11810k;     // Catch: Throwable -> L12
            if (r1 == null) goto L9;
            f11810k = r1.f11820i;     // Catch: Throwable -> L12
            r1.f11820i = null;     // Catch: Throwable -> L12
            f11811l--;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return new h();
        L12:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f11813b = null;
            this.f11814c = null;
            this.f11815d = null;
            this.f11816e = null;
            this.f11817f = null;
            this.f11818g = -1;
            this.f11819h = 0;
            this.f11820i = null;
            Object r0 = f11809j;
            monitor-enter(r0);
            int r1 = f11811l;     // Catch: Throwable -> L9
            if (r1 >= 50) goto L7;
            this.f11820i = f11810k;     // Catch: Throwable -> L9
            f11810k = this;     // Catch: Throwable -> L9
            f11811l = r1 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alog f11821a;

        i(Alog r1) {
            this.f11821a = r1;
        }

        public void a(String r2, String r3) {
            if (ALog.access$400(6, r2) == false) goto L6;
            this.f11821a.k(r2, r3);
            return;
        }

        public void b(String r2, String r3) {
            if (ALog.access$400(4, r2) == false) goto L6;
            this.f11821a.t(r2, r3);
            return;
        }
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
        sStandaloneInstances = new ArrayList();
        sMainThreadId = -1;
        sInitialized = false;
        sInitLock = new Object();
    }

    public ALog() {
    }

    static /* synthetic */ void access$000(h r0) {
        handleAsyncLog(r0);
    }

    static /* synthetic */ void access$100(Queue r0) {
        writeCachedItems(r0);
    }

    static /* synthetic */ com.ss.android.agilelogger.b access$200() {
        return sILogCacheCallback;
    }

    static /* synthetic */ void access$300(String r0, String r1) {
        removeLegacyFiles(r0, r1);
    }

    static /* synthetic */ boolean access$400(int r0, String r1) {
        return checkPrioAndTag(r0, r1);
    }

    public static void addNativeFuncAddrCallback(com.ss.android.agilelogger.c r1) {
        sINativeFuncAddrCallbackList.add(r1);
    }

    public static void asyncFlush() {
        Handler r0 = sAsyncHandler;
        if (r0 == null) goto L5;
        r0.sendEmptyMessage(2);
    L5:
        com.bytedance.android.alog.c.a();
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L8;
        r1.h();
    L8:
        Iterator<WeakReference<Alog>> r2 = sStandaloneInstances.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Alog r3 = r2.next().get();
        if (r3 == null) goto L10;
        r3.h();
        goto L10
    }

    public static void bundle(int r8, String r9, Bundle r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.b(com.ss.android.agilelogger.h.b.a.f11855h, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, null, null, com.ss.android.agilelogger.h.b.a.f11855h, r10);
        return;
    }

    public static void changeLevel(int r1) {
        prio = r1;
        com.bytedance.android.alog.c.n(level2AlogCoreLevel(r1));
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.v(level2AlogCoreLevel(r1));
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

    public static i createInstance(String r1, Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return createInstance(r1, new com.ss.android.agilelogger.a.b(r2).a());
    }

    public static i createInstance(String r3, com.ss.android.agilelogger.a r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L35;
    L10:
        Alog.c r1 = new Alog.c(r4.b());
        r1.g(r3);
        r1.h(level2AlogCoreLevel(r4.c()));
        r1.q(sDebug);
        com.ss.android.agilelogger.a r5 = sConfig;
        if (r5 == null) goto L13;
        String r6 = r5.d();
    L14:
        r1.i(r6);
        r1.k(r4.g());
        r1.l(r4.f());
        r1.j(r4.e());
        com.ss.android.agilelogger.a r7 = sConfig;
        if (r7 == null) goto L17;
        String r8 = r7.a();
    L18:
        r1.c(r8);
        r1.d(65536);
        r1.e(196608);
        r1.m(Alog.e.f592h);
        r1.r(Alog.h.f605g);
        r1.n(Alog.f.f596h);
        if (r4.i() == false) goto L21;
        Alog.d r9 = Alog.d.f588i;
    L22:
        r1.f(r9);
        if (r4.j() == false) goto L25;
        Alog.g r10 = Alog.g.f600h;
    L26:
        r1.p(r10);
        if (r4.j() == false) goto L29;
        Alog.b r11 = Alog.b.f570h;
    L30:
        r1.b(r11);
        r1.o(r4.h());
        Alog r12 = r1.a();
        if (r12 != null) goto L33;
        return null;
    L33:
        sStandaloneInstances.add(new WeakReference(r12));
        return new i(r12);
    L29:
        r11 = Alog.b.f569g;
        goto L30
    L25:
        r10 = Alog.g.f599g;
        goto L26
    L21:
        r9 = Alog.d.f586g;
        goto L22
    L17:
        r8 = r4.a();
        goto L18
    L13:
        r6 = r4.d();
        goto L14
    L35:
        Alog.u(new com.ss.android.agilelogger.d());     // Catch: Throwable -> L9
    L9:
        return null;
    }

    public static void d(String r3, String r4) {
        if (checkPrioAndTag(3, r3) == false) goto L16;
        boolean r1 = com.ss.android.agilelogger.f.c();
        if (r1 == true) goto L7;
    L10:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        r0.j(r3, r4);
        return;
    L14:
        com.bytedance.android.alog.c.c(r3, r4);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(3, r3, r4);
        return;
    }

    public static void destroy() {
        com.bytedance.android.alog.c.b();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.i();
    L6:
        if (sAsyncHandler == null) goto L9;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
        return;
    }

    public static void e(String r3, String r4) {
        if (checkPrioAndTag(6, r3) == false) goto L16;
        boolean r1 = com.ss.android.agilelogger.f.c();
        if (r1 == true) goto L7;
    L10:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        r0.k(r3, r4);
        return;
    L14:
        com.bytedance.android.alog.c.d(r3, r4);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(6, r3, r4);
        return;
    }

    public static void e(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(6, r8) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.h.d.a(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L14;
        if (r0 == false) goto L14;
        r12.k(r8, r11);
        return;
    L14:
        com.bytedance.android.alog.c.d(r8, r11);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(6, r8, r9, r10, null, null);
        return;
    }

    public static void e(String r8, Throwable r9) {
        if (checkPrioAndTag(6, r8) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        String r10 = com.ss.android.agilelogger.h.d.a(r9);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.k(r8, r10);
        return;
    L14:
        com.bytedance.android.alog.c.d(r8, r10);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(6, r8, null, r9, null, null);
        return;
    }

    @Deprecated
    public static void flush() {
        Handler r0 = sAsyncHandler;
        if (r0 == null) goto L5;
        r0.sendEmptyMessage(2);
    L5:
        com.bytedance.android.alog.c.a();
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L9;
        r1.h();
        return;
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    public static List<String> getALogFiles(long r7, long r9) {
        ArrayList r0 = new ArrayList();
        File[] r8 = com.bytedance.android.alog.c.i(null, null, r7 * 1000, r9 * 1000);     // Catch: Exception -> L8
        int r10 = r8.length;     // Catch: Exception -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L7;
        r0.add(r8[r11].getAbsolutePath());     // Catch: Exception -> L8
        r11 = r11 + 1;
    L7:
        return r0;
    }

    public static List<String> getALogFiles(String r9, String r10, long r11, long r13) {
        ArrayList r0 = new ArrayList();
        File[] r12 = com.bytedance.android.alog.c.i(r9, r10, r11 * 1000, r13 * 1000);     // Catch: Exception -> L8
        int r14 = r12.length;     // Catch: Exception -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L7;
        r0.add(r12[r15].getAbsolutePath());     // Catch: Exception -> L8
        r15 = r15 + 1;
    L7:
        return r0;
    }

    public static long getALogSimpleWriteFuncAddr() {
        return com.bytedance.android.alog.c.j();
    }

    public static long getALogWriteFuncAddr() {
        return com.bytedance.android.alog.c.h();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return com.bytedance.android.alog.c.f();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return com.bytedance.android.alog.c.g();
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return com.bytedance.android.alog.c.e();
    }

    public static List<com.ss.android.agilelogger.c> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static String getStatus() {
        return com.bytedance.android.alog.c.k();
    L4:
        return "getStatus exception";
    }

    private static void handleAsyncLog(h r8) {
        int r1 = level2AlogCoreLevel(r8.f11812a);
        com.ss.android.agilelogger.h.b.a r0 = r8.f11816e;
        String r2 = "";
        if (r0 == null) goto L5;
        com.ss.android.agilelogger.h.b.a r3 = com.ss.android.agilelogger.h.b.a.f11858k;
        if (r0 != r3) goto L16;
    L14:
        String r4 = com.ss.android.agilelogger.h.b.c(r3, r8.f11814c);
    L15:
        String r5 = r4;
    L35:
        com.bytedance.android.alog.c.u(r1, r8.f11813b, r5, r8.f11818g, r8.f11819h);
        r8.b();
        return;
    L16:
        r3 = com.ss.android.agilelogger.h.b.a.f11854g;
        if (r0 == r3) goto L14;
        com.ss.android.agilelogger.h.b.a r6 = com.ss.android.agilelogger.h.b.a.f11855h;
        if (r0 != r6) goto L22;
        r4 = com.ss.android.agilelogger.h.b.b(r6, (Bundle) r8.f11817f);
        goto L15
    L22:
        com.ss.android.agilelogger.h.b.a r7 = com.ss.android.agilelogger.h.b.a.f11856i;
        if (r0 != r7) goto L25;
        r4 = com.ss.android.agilelogger.h.b.a(r7, (Intent) r8.f11817f);
        goto L15
    L25:
        com.ss.android.agilelogger.h.b.a r9 = com.ss.android.agilelogger.h.b.a.f11857j;
        if (r0 != r9) goto L28;
        r4 = com.ss.android.agilelogger.h.b.e(r9, (Throwable) r8.f11817f);
        goto L15
    L28:
        com.ss.android.agilelogger.h.b.a r10 = com.ss.android.agilelogger.h.b.a.m;
        if (r0 != r10) goto L31;
        r4 = com.ss.android.agilelogger.h.b.d(r10, (Thread) r8.f11817f);
        goto L15
    L31:
        com.ss.android.agilelogger.h.b.a r11 = com.ss.android.agilelogger.h.b.a.f11859l;
        if (r0 != r11) goto L34;
        r4 = com.ss.android.agilelogger.h.b.f(r11, (StackTraceElement[]) r8.f11817f);
        goto L15
    L34:
        r5 = "";
        goto L35
    L5:
        if (r8.f11815d != null) goto L8;
        r4 = r8.f11814c;
        goto L15
    L8:
        if (r8.f11814c == null) goto L11;
        r2 = r8.f11814c + "\n";
    L11:
        r4 = r2 + com.ss.android.agilelogger.h.d.a(r8.f11815d);
        goto L15
    }

    private static void handleItemMsg(com.ss.android.agilelogger.e r2) {
        switch(g.f11808a[r2.f11849d.ordinal()]) {
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
        r2.f11848c = r0;
        return;
    L5:
        r0 = com.ss.android.agilelogger.h.b.f(r2.f11849d, (StackTraceElement[]) r2.f11850e);
        goto L16
    L6:
        r0 = com.ss.android.agilelogger.h.b.d(r2.f11849d, (Thread) r2.f11850e);
        goto L16
    L7:
        r0 = com.ss.android.agilelogger.h.b.e(r2.f11849d, (Throwable) r2.f11850e);
        goto L16
    L8:
        r0 = com.ss.android.agilelogger.h.b.a(r2.f11849d, (Intent) r2.f11850e);
        goto L16
    L9:
        r0 = com.ss.android.agilelogger.h.b.b(r2.f11849d, (Bundle) r2.f11850e);
        goto L16
    L10:
        r0 = com.ss.android.agilelogger.h.b.c(r2.f11849d, (String) r2.f11850e);
        goto L16
    L15:
        r0 = (String) r2.f11850e;
        goto L16
    L12:
        if (r2.f11851f != null) goto L14;
        r0 = com.ss.android.agilelogger.h.d.a((Throwable) r2.f11850e);
        goto L16
    L14:
        r0 = r2.f11851f + com.ss.android.agilelogger.h.d.a((Throwable) r2.f11850e);
        goto L16
    }

    public static void header(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.c(com.ss.android.agilelogger.h.b.a.f11858k, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, r10, null, com.ss.android.agilelogger.h.b.a.f11858k, null);
        return;
    }

    public static void i(String r3, String r4) {
        if (checkPrioAndTag(4, r3) == false) goto L16;
        boolean r1 = com.ss.android.agilelogger.f.c();
        if (r1 == true) goto L7;
    L10:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        r0.t(r3, r4);
        return;
    L14:
        com.bytedance.android.alog.c.l(r3, r4);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(4, r3, r4);
        return;
    }

    public static boolean init(com.ss.android.agilelogger.a r11) {
        boolean r0 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        sConfig = r11;
        Alog.u(new com.ss.android.agilelogger.d());     // Catch: Throwable -> L88
        Object r1 = sInitLock;
        monitor-enter(r1);
    L85:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L85
        return false;
    L13:
        sInitialized = true;     // Catch: Throwable -> L85
        monitor-exit(r1);     // Catch: Throwable -> L85
        prio = r11.c();
        boolean r2 = com.ss.android.agilelogger.f.b(r11.b());
        boolean r3 = r11.l();
        if (r3 == false) goto L18;
    L21:
        boolean r4 = false;
    L22:
        Alog.c r5 = new Alog.c(r11.b());
        r5.g("default");
        r5.h(level2AlogCoreLevel(r11.c()));
        r5.q(sDebug);
        r5.i(r11.d());
        r5.k(r11.g());
        int r6 = r11.f();
        if (r4 == false) goto L25;
        r6 = (r6 / 3) * 2;
    L25:
        r5.l(r6);
        r5.j(r11.e());
        r5.c(r11.a());
        int r7 = 65536;
        if (r2 == false) goto L28;
        int r8 = 65536;
    L29:
        r5.d(r8);
        if (r2 == false) goto L32;
        r7 = 196608;
    L32:
        r5.e(r7);
        Alog.e r9 = Alog.e.f592h;
        r5.m(r9);
        Alog.h r10 = Alog.h.f605g;
        r5.r(r10);
        Alog.f r12 = Alog.f.f596h;
        r5.n(r12);
        if (r11.i() == false) goto L35;
        Alog.d r13 = Alog.d.f588i;
    L36:
        r5.f(r13);
        if (r11.j() == false) goto L39;
        Alog.g r14 = Alog.g.f600h;
    L40:
        r5.p(r14);
        if (r11.j() == false) goto L43;
        Alog.b r15 = Alog.b.f570h;
    L44:
        r5.b(r15);
        r5.o(r11.h());
        com.bytedance.android.alog.c.m(r5.a());
        if (r3 == false) goto L48;
        if (r2 == false) goto L48;
        HandlerThread r16 = new HandlerThread("Alog_main_delegate");
        sAsyncLogThread = r16;
        r16.start();
        sAsyncHandler = new a(sAsyncLogThread.getLooper());
    L48:
        if (r4 == false) goto L62;
        Alog.c r17 = new Alog.c(r11.b());
        r17.g("main");
        r17.h(level2AlogCoreLevel(r11.c()));
        r17.q(sDebug);
        r17.i(r11.d());
        r17.k(r11.g() / 2);
        r17.l(r11.f() / 3);
        r17.j(r11.e());
        r17.c(r11.a());
        r17.d(32768);
        r17.e(98304);
        r17.m(r9);
        r17.r(r10);
        r17.n(r12);
        if (r11.i() == false) goto L52;
        Alog.d r18 = Alog.d.f588i;
    L53:
        r17.f(r18);
        if (r11.j() == false) goto L56;
        Alog.g r19 = Alog.g.f600h;
    L57:
        r17.p(r19);
        if (r11.j() == false) goto L60;
        Alog.b r20 = Alog.b.f570h;
    L61:
        r17.b(r20);
        r17.o(r11.h());
        mainThreadRef = r17.a();
        goto L62
    L60:
        r20 = Alog.b.f569g;
        goto L61
    L56:
        r19 = Alog.g.f599g;
        goto L57
    L52:
        r18 = Alog.d.f586g;
    L62:
        String r21 = r11.a();
        String r110 = r11.d();
        Queue<com.ss.android.agilelogger.e> r22 = null;
        if (sILogCacheCallback == null) goto L70;
        Queue<com.ss.android.agilelogger.e> r23 = sILogCacheCallback.b();
        if (r23 != null) goto L67;
    L69:
        r22 = r23;
        goto L70
    L67:
        if (r23.size() != 0) goto L69;
    L70:
        if (r22 == null) goto L72;
    L73:
        b r24 = new b(r22, r21, r110);
        ScheduledExecutorService r25 = sOuterExecutorService;
        if (r25 != null) goto L76;
        new Thread(r24, "_ALOG_OPT_").start();
    L77:
        r0 = true;
    L78:
        if (r0 == true) goto L83;
        ScheduledExecutorService r26 = sOuterExecutorService;
        if (r26 != null) goto L82;
        new Timer("_ALOG_OPT_").schedule(new c(r21, r110), IdleTaskConfig.IDLE_START_TIME_OUT);
        goto L83
    L82:
        r26.schedule(new d(r21, r110), 15, TimeUnit.SECONDS);
    L83:
        sInitSuccess = true;
        return true;
    L76:
        r25.execute(r24);
        goto L77
    L72:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L78;
    L43:
        r15 = Alog.b.f569g;
        goto L44
    L39:
        r14 = Alog.g.f599g;
        goto L40
    L35:
        r13 = Alog.d.f586g;
        goto L36
    L28:
        r8 = 32768;
        goto L29
    L18:
        if (r11.k() == false) goto L21;
        if (r2 == false) goto L21;
        r4 = true;
    L88:
        return false;
    }

    private static void initMainThreadIdIfNeeded() {
        if (sMainThreadId != (-1)) goto L6;
        sMainThreadId = Process.myTid();
        return;
    }

    public static void intent(int r8, String r9, Intent r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.a(com.ss.android.agilelogger.h.b.a.f11856i, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, null, null, com.ss.android.agilelogger.h.b.a.f11856i, r10);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void json(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.c(com.ss.android.agilelogger.h.b.a.f11854g, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, r10, null, com.ss.android.agilelogger.h.b.a.f11854g, null);
        return;
    }

    private static int level2AlogCoreLevel(int r0) {
        return r0 - 2;
    }

    private static void postAsyncLog(int r6, String r7, String r8) {
        postAsyncLog(r6, r7, r8, null, null, null);
    }

    private static void postAsyncLog(int r1, String r2, String r3, Throwable r4, com.ss.android.agilelogger.h.b.a r5, Object r6) {
        initMainThreadIdIfNeeded();
        h r0 = h.a();
        r0.f11812a = r1;
        r0.f11813b = r2;
        r0.f11814c = r3;
        r0.f11815d = r4;
        r0.f11816e = r5;
        r0.f11817f = r6;
        r0.f11818g = sMainThreadId;
        r0.f11819h = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r0;
        sAsyncHandler.sendMessage(r7);
    }

    public static void println(int r2, String r3, Object r4, com.ss.android.agilelogger.h.b.a r5) {
        if (checkPrioAndTag(r2, r3) == false) goto L29;
        int r0 = level2AlogCoreLevel(r2);
        switch(g.f11808a[r5.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
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
        boolean r7 = com.ss.android.agilelogger.f.c();
        if (r7 == true) goto L20;
    L23:
        Alog r8 = mainThreadRef;
        if (r8 == null) goto L27;
        if (r7 == false) goto L27;
        r8.B(r0, r3, r6);
        return;
    L27:
        com.bytedance.android.alog.c.t(r0, r3, r6);
        return;
    L20:
        if (sAsyncHandler == null) goto L23;
        postAsyncLog(r2, r3, r6);
        return;
    L7:
        r6 = com.ss.android.agilelogger.h.b.f(com.ss.android.agilelogger.h.b.a.f11859l, (StackTraceElement[]) r4);
        goto L17
    L8:
        r6 = com.ss.android.agilelogger.h.b.d(com.ss.android.agilelogger.h.b.a.m, (Thread) r4);
        goto L17
    L9:
        r6 = com.ss.android.agilelogger.h.b.e(com.ss.android.agilelogger.h.b.a.f11857j, (Throwable) r4);
        goto L17
    L10:
        r6 = com.ss.android.agilelogger.h.b.a(com.ss.android.agilelogger.h.b.a.f11856i, (Intent) r4);
        goto L17
    L11:
        r6 = com.ss.android.agilelogger.h.b.b(com.ss.android.agilelogger.h.b.a.f11855h, (Bundle) r4);
        goto L17
    L12:
        com.ss.android.agilelogger.h.b.a r9 = com.ss.android.agilelogger.h.b.a.f11854g;
    L14:
        r6 = com.ss.android.agilelogger.h.b.c(r9, (String) r4);
        goto L17
    L13:
        r9 = com.ss.android.agilelogger.h.b.a.f11858k;
        goto L14
    L15:
        r6 = com.ss.android.agilelogger.h.d.a((Throwable) r4);
        goto L17
    L16:
        r6 = (String) r4;
        goto L17
    }

    public static void release() {
        com.bytedance.android.alog.c.b();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.i();
    L6:
        if (sAsyncHandler == null) goto L9;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
        return;
    }

    private static void removeLegacyFiles(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new e());
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
        File[] r8 = r7.listFiles(new f());
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

    public static void removeObsoleteInstance(String r10, Context r11, boolean r12) {
        String r0 = com.ss.android.agilelogger.f.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.contains(":") == false) goto L8;
        return;
    L8:
        if (r12 == true) goto L11;
        r0 = r0 + '-';
    L11:
        com.ss.android.agilelogger.a r13 = sConfig;
        if (r13 == null) goto L14;
        String r14 = r13.d();
        String r15 = sConfig.a();
    L15:
        File r1 = new File(r14);
        if (r1.exists() == true) goto L18;
        return;
    L18:
        if (r1.isDirectory() == false) goto L57;
        String r16 = "__" + r10 + ".alog.hot";
        File[] r2 = r1.listFiles();
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L21:
        if (r5 >= r3) goto L30;
        File r6 = r2[r5];
        String r7 = r6.getName();
        if (r7 == null) goto L29;
        if (r7.endsWith(r16) == false) goto L29;
        if (r7.contains(r0) == false) goto L29;
        r6.delete();
    L29:
        r5 = r5 + 1;
        goto L21
    L30:
        File r17 = new File(r15);
        if (r17.exists() == true) goto L33;
        return;
    L33:
        if (r17.isDirectory() == false) goto L58;
        String r18 = "__" + r10;
        File[] r19 = r17.listFiles();
        int r110 = r19.length;
    L36:
        if (r4 >= r110) goto L59;
        File r8 = r19[r4];
        String r9 = r8.getName();
        if (r9 == null) goto L44;
        if (r9.contains(r18) == false) goto L44;
        if (r9.contains(r0) == false) goto L44;
        r8.delete();
    L44:
        r4 = r4 + 1;
        goto L36
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L14:
        String r111 = com.ss.android.agilelogger.h.a.b(r11).getAbsolutePath();
        r15 = com.ss.android.agilelogger.h.a.a(r11);
        r14 = r111;
        goto L15
    }

    public static void setBlockTagSet(Set<String> r0) {
        mBlockTagSet = Collections.unmodifiableSet(r0);
    }

    public static void setDebug(boolean r1) {
        sDebug = r1;
        com.bytedance.android.alog.c.o(sDebug);
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L6;
        r2.w(sDebug);
        return;
    }

    public static void setILogCacheCallback(com.ss.android.agilelogger.b r0) {
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

    public static void stacktrace(int r8, String r9, StackTraceElement[] r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.f(com.ss.android.agilelogger.h.b.a.f11859l, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, null, null, com.ss.android.agilelogger.h.b.a.f11859l, r10);
        return;
    }

    public static void statcktrace(int r0, String r1, StackTraceElement[] r2) {
        stacktrace(r0, r1, r2);
    }

    public static void syncFlush() {
        Handler r0 = sAsyncHandler;
        if (r0 == null) goto L5;
        r0.sendEmptyMessage(2);
    L5:
        com.bytedance.android.alog.c.p();
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L8;
        r1.x();
    L8:
        Iterator<WeakReference<Alog>> r2 = sStandaloneInstances.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Alog r3 = r2.next().get();
        if (r3 == null) goto L10;
        r3.x();
        goto L10
    }

    public static void thread(int r8, String r9, Thread r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.d(com.ss.android.agilelogger.h.b.a.m, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, null, null, com.ss.android.agilelogger.h.b.a.m, r10);
        return;
    }

    public static void throwable(int r8, String r9, Throwable r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = com.ss.android.agilelogger.h.b.e(com.ss.android.agilelogger.h.b.a.f11857j, r10);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.B(r11, r9, r12);
        return;
    L14:
        com.bytedance.android.alog.c.t(r11, r9, r12);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(r8, r9, null, null, com.ss.android.agilelogger.h.b.a.f11857j, r10);
        return;
    }

    public static void timedSyncFlush(int r2) {
        Handler r0 = sAsyncHandler;
        if (r0 == null) goto L5;
        r0.sendEmptyMessage(2);
    L5:
        com.bytedance.android.alog.c.q(r2);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L8;
        r1.y(r2);
    L8:
        Iterator<WeakReference<Alog>> r3 = sStandaloneInstances.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Alog r4 = r3.next().get();
        if (r4 == null) goto L10;
        r4.y(r2);
        goto L10
    }

    public static void v(String r3, String r4) {
        if (checkPrioAndTag(2, r3) == false) goto L16;
        boolean r1 = com.ss.android.agilelogger.f.c();
        if (r1 == true) goto L7;
    L10:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        r0.z(r3, r4);
        return;
    L14:
        com.bytedance.android.alog.c.r(r3, r4);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(2, r3, r4);
        return;
    }

    public static void w(String r3, String r4) {
        if (checkPrioAndTag(5, r3) == false) goto L16;
        boolean r1 = com.ss.android.agilelogger.f.c();
        if (r1 == true) goto L7;
    L10:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        r0.A(r3, r4);
        return;
    L14:
        com.bytedance.android.alog.c.s(r3, r4);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(5, r3, r4);
        return;
    }

    public static void w(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(5, r8) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.h.d.a(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L14;
        if (r0 == false) goto L14;
        r12.A(r8, r11);
        return;
    L14:
        com.bytedance.android.alog.c.s(r8, r11);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(5, r8, r9, r10, null, null);
        return;
    }

    public static void w(String r8, Throwable r9) {
        if (checkPrioAndTag(5, r8) == false) goto L16;
        boolean r0 = com.ss.android.agilelogger.f.c();
        if (r0 == true) goto L7;
    L10:
        String r10 = com.ss.android.agilelogger.h.d.a(r9);
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L14;
        if (r0 == false) goto L14;
        r1.A(r8, r10);
        return;
    L14:
        com.bytedance.android.alog.c.s(r8, r10);
        return;
    L7:
        if (sAsyncHandler == null) goto L10;
        postAsyncLog(5, r8, null, r9, null, null);
        return;
    }

    private static void writeCachedItems(Queue<com.ss.android.agilelogger.e> r3) {
        Iterator<com.ss.android.agilelogger.e> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        com.ss.android.agilelogger.e r0 = r4.next();
        if (checkPrioAndTag(r0.f11846a, r0.f11847b) == false) goto L4;
        handleItemMsg(r0);
        com.bytedance.android.alog.c.t(level2AlogCoreLevel(r0.f11846a), r0.f11847b, r0.f11848c);
        goto L4
    }
}
