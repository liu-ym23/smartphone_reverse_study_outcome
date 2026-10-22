package com.bytedance.monitor.collector;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class LockMonitorManager {
    private static final int DEFAULT_SIZE = 100;
    private static final String DELIMITER = "&#&";
    private static final String KEY_IS_ALL_THREAD = "is_all_thread";
    private static final String KEY_IS_LOCK = "is_lock";
    private static final String KEY_RAW_DUMP_INFO = "raw_dump_info";
    private static final String LOCK_THREAD_NAME = "lock_handler_time";
    private static final String STACK_THREAD_NAME = "lock_stack_fetch";
    private static final String TAG = "LockMonitorManager";
    private static final int bufferSize = 100;
    private static boolean isAllThread = false;
    private static volatile boolean isLockMonitoring = false;
    private static volatile String lastJavaStack = null;
    private static volatile String lastOwnerJavaStack = null;
    private static i[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r1) {
            Thread r0 = new Thread(r1);
            r0.setName(LockMonitorManager.LOCK_THREAD_NAME);
            return r0;
        }
    }

    static class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r1) {
            Thread r0 = new Thread(r1);
            Process.setThreadPriority(-20);
            r0.setName(LockMonitorManager.STACK_THREAD_NAME);
            return r0;
        }
    }

    static class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f5089a;

        c(JSONObject r1) {
            this.f5089a = r1;
        }

        @Override // com.bytedance.monitor.collector.LockMonitorManager.j
        public void a(@Nullable List<i> r8) {
            if (r8 != null) goto L5;
            return;
        L5:
            if (com.bytedance.apm.d.C() == false) goto L7;
            Log.d(LockMonitorManager.TAG, "dumpLockInfo size -> " + r8.size());
        L7:
            Iterator<i> r9 = r8.iterator();
        L9:
            if (r9.hasNext() == false) goto L21;
            i r0 = r9.next();
            JSONObject r2 = LockMonitorManager.access$000(r0, this.f5089a);     // Catch: Throwable -> L19
            if (r2 == null) goto L9;
            if (com.bytedance.apm.d.C() == false) goto L17;
            Log.d(LockMonitorManager.TAG, "lock report LockInfo: " + r0);     // Catch: Throwable -> L19
        L17:
            com.bytedance.apm.t.d.d r3 = new com.bytedance.apm.t.d.d("block_monitor", r2, r0.f5096a);     // Catch: Throwable -> L19
            r3.g();     // Catch: Throwable -> L19
            com.bytedance.apm.t.c.a.p().e(r3);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Log.e(LockMonitorManager.TAG, "onData: parse lock info failed: " + th.getLocalizedMessage());
            goto L9
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f5090f;

        d(j r1) {
            this.f5090f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            j r1 = this.f5090f;     // Catch: Throwable -> L8
            if (r1 == null) goto L6;
            r1.a(LockMonitorManager.dumpLockInfo());     // Catch: Throwable -> L8
        L10:
            return;
        L6:
            r1.a(null);     // Catch: Throwable -> L8
        L8:
            this.f5090f.a(null);
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5091f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f5092f;

            a(e r1, i r2) {
                this.f5092f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                LockMonitorManager.access$800(this.f5092f);
            }
        }

        e(String r1) {
            this.f5091f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            i r0 = i.c(this.f5091f);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            com.bytedance.apm.f0.b.f().i(new a(this, r0));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Thread f5093f;

        f(Thread r1) {
            this.f5093f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r2 = o.c(this.f5093f.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r0 = LockMonitorManager.access$600();     // Catch: Throwable -> L14
            monitor-enter(r0);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$600().size() == 0) goto L7;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$600().put(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    static class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Thread f5094f;

        g(Thread r1) {
            this.f5094f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r2 = o.c(this.f5094f.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r0 = LockMonitorManager.access$400();     // Catch: Throwable -> L14
            monitor-enter(r0);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$400().size() == 0) goto L7;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$400().put(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    static class h implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f5095f;

        h(String r1) {
            this.f5095f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LockMonitorManager.access$900() == false) goto L5;
            LockMonitorManager.access$1000(this.f5095f);     // Catch: Throwable -> L17
            return;
        L5:
            String r2 = o.c(Looper.getMainLooper().getThread().getStackTrace());     // Catch: Throwable -> L17
            BlockingQueue r0 = LockMonitorManager.access$400();     // Catch: Throwable -> L17
            monitor-enter(r0);     // Catch: Throwable -> L17
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L8:
            if (LockMonitorManager.access$400().size() == 0) goto L10;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L13
        L10:
            LockMonitorManager.access$400().put(r2);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            goto L22
        L21:
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f5097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f5098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f5099d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f5100e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f5101f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f5102g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f5103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f5104i;

        private i(long r2, long r4, String r6, String r7) {
            this.f5099d = EnvironmentCompat.MEDIA_UNKNOWN;
            this.f5096a = r2;
            this.f5097b = r4;
            this.f5098c = r6;
            this.f5104i = r7;
            h(r6);
            d.b.b.n.g.a r3 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
            if (r3 == null) goto L8;
            String r5 = r3.c();
            if (TextUtils.isEmpty(r5) == true) goto L9;
            this.f5099d = r5;
            return;
        L9:
            return;
        }

        static /* synthetic */ String a(i r0) {
            return r0.f5101f;
        }

        static /* synthetic */ String b(i r0) {
            return r0.f5099d;
        }

        @Nullable
        @WorkerThread
        static i c(String r9) {
            String r0 = null;
            if (r9 != null) goto L5;
        L61:
            return null;
        L5:
            if (r9.isEmpty() == true) goto L61;
            Log.d("lockDetect", "" + r9);
            String[] r1 = r9.split(LockMonitorManager.DELIMITER);
            if (r1.length == 4) goto L11;
            Log.d("lockDetect", "spiltData != 4" + r9);
            return null;
        L11:
            long r3 = Long.parseLong(r1[0]);
            long r5 = Long.parseLong(r1[1]);
            String r10 = r1[2];
            i r2 = new i(r3, r5, r10, r1[3]);
            if (LockMonitorManager.access$300() == false) goto L53;
            BlockingQueue r4 = LockMonitorManager.access$400();
            monitor-enter(r4);
            String r6 = (String) LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20
        L22:
            if (r6 == null) goto L24;
        L26:
            LockMonitorManager.access$502(r6);     // Catch: Throwable -> L18
        L28:
            if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
        L30:
            monitor-exit(r4);     // Catch: Throwable -> L18
            BlockingQueue r7 = LockMonitorManager.access$600();
            monitor-enter(r7);
            r0 = (String) LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 InterruptedException -> L37
        L39:
            if (r0 == null) goto L41;
        L43:
            LockMonitorManager.access$702(r6);     // Catch: Throwable -> L35
        L45:
            if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
        L47:
            monitor-exit(r7);     // Catch: Throwable -> L35
            String r8 = r0;
            r0 = r6;
        L54:
            if (r0 != null) goto L56;
        L58:
            if (r8 == null) goto L60;
            r2.j(r8);
        L60:
            return r2;
        L56:
            if (r10.contains(o.a(r0)) == false) goto L58;
            r2.i(r0);
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r0 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r6 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L18:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r6 = null;
            goto L22
        L53:
            r8 = null;
            goto L54
        }

        private void h(String r9) {
            String r10 = r9.substring(r9.indexOf("monitor contention with owner"));
            this.f5103h = r10.substring(30, r10.indexOf("(") - 1);
            int r1 = r10.indexOf(" at ");
            if (r1 == (-1)) goto L5;
            String r2 = r10.substring(r1 + 5, r10.indexOf("waiters=", r1));
            String r3 = r2.substring(r2.indexOf(" "));
            this.f5102g = r3.substring(1, r3.indexOf("(")) + r3.substring(r3.indexOf(")") + 1, r3.lastIndexOf(")") + 1);
        L5:
            String r11 = r10.substring(r10.indexOf("blocking from") + 14);
            String r12 = r11.substring(r11.indexOf(" ") + 1);
            this.f5100e = r12.substring(0, r12.indexOf("(")) + r12.substring(r12.indexOf(")") + 1, r12.lastIndexOf(")") + 1);
        }

        public String d() {
            return this.f5100e;
        }

        public String e() {
            return this.f5104i;
        }

        public String f() {
            return this.f5102g;
        }

        public String g() {
            return this.f5103h;
        }

        public void i(String r1) {
            this.f5101f = r1;
        }

        public void j(String r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.isEmpty() == true) goto L8;
            this.f5102g = r2;
            return;
        }

        public String toString() {
            return "LockInfo{timestamp=" + this.f5096a + ", duration=" + this.f5097b + ", rawAtrace='" + this.f5098c + "', topActivityName='" + this.f5099d + "', blockStackInfo='" + this.f5100e + "', completeBlockStackInfo='" + this.f5101f + "', ownerStackInfo='" + this.f5102g + "', lockThreadName='" + this.f5104i + "', ownerThreadName='" + this.f5103h + "'}";
        }
    }

    public interface j {
        @WorkerThread
        void a(@Nullable List<i> r1);
    }

    static {
        lockInfoQueue = new i[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new a());
        sStackFetcher = Executors.newSingleThreadExecutor(new b());
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    static /* synthetic */ JSONObject access$000(i r0, JSONObject r1) {
        return packJsonData(r0, r1);
    }

    static /* synthetic */ void access$1000(String r0) {
        getThreadStack(r0);
    }

    static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    static /* synthetic */ String access$502(String r0) {
        lastJavaStack = r0;
        return r0;
    }

    static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    static /* synthetic */ String access$702(String r0) {
        lastOwnerJavaStack = r0;
        return r0;
    }

    static /* synthetic */ void access$800(i r0) {
        enqueue(r0);
    }

    static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static String dumpLockInfo(long r9, long r11) {
        i[] r1 = new i[100];
        int r3 = 0;
        System.arraycopy(lockInfoQueue, 0, r1, 0, 100);
        ArrayList r2 = new ArrayList();
    L3:
        if (r3 >= 100) goto L17;
        i r4 = r1[((position + r3) + 1) % 100];
        if (r4 == null) goto L15;
        long r5 = r4.f5096a;
        if (r5 >= r11) goto L10;
    L11:
        r2.add(r4);
    L13:
        if ((r4.f5096a + r4.f5097b) >= r9) goto L15;
    L10:
        if ((r5 + r4.f5097b) <= r9) goto L13;
    L15:
        r3 = r3 + 1;
    L17:
        return r2.toString();
    }

    @WorkerThread
    public static List<i> dumpLockInfo() {
        LinkedList r0 = new LinkedList();
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L9;
        int r3 = (((position + 100) - r1) - 1) % 100;
        i[] r2 = lockInfoQueue;
        i r4 = r2[r3];
        r2[r3] = null;
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public static void dumpLockInfo(j r2) {
        com.bytedance.apm.f0.b.f().i(new d(r2));
    }

    public static void endLockDetect(@NonNull JSONObject r2) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r2.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r2.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (com.bytedance.apm.d.H() == false) goto L16;
        reportLockInfo(r2);
        k.n().l();
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @WorkerThread
    private static void enqueue(i r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        i[] r0 = lockInfoQueue;
        int r1 = position;
        r0[r1] = r2;
        position = (r1 + 1) % 100;
    }

    private static void getOwnerStack(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L27;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r1 = r0.activeCount();
        int r2 = r1 + (r1 / 2);
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L28;
        Thread r5 = r3[r4];
        if (r5 == null) goto L29;
        if (r5 == Thread.currentThread()) goto L19;
        if (r5.getName().contains(r6) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new f(r5));
    L19:
        r4 = r4 + 1;
        goto L7
    L29:
        return;
    L28:
        return;
    }

    private static void getThreadStack(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L23;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r1 = r0.activeCount();
        int r2 = r1 + (r1 / 2);
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L24;
        Thread r5 = r3[r4];
        if (r5 == null) goto L25;
        if (r5.getName().contains(r6) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new g(r5));
    L16:
        r4 = r4 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativeGetJavaStack(String r2, String r3) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new h(r3));
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L30;
        int r4 = r2.indexOf("monitor contention with owner");
        if (r4 > 0) goto L12;
        return;
    L12:
        if (r4 >= r2.length()) goto L25;
        String r5 = r2.substring(r4);
        int r0 = r5.indexOf("(") - 1;
        if (r0 > 0) goto L16;
        return;
    L16:
        if (30 < r5.length()) goto L18;
        return;
    L18:
        if (r0 >= r5.length()) goto L28;
        if (30 >= r0) goto L29;
        getOwnerStack(r5.substring(30, r0));
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    L30:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativePut(String r2) {
        sLockHandler.execute(new e(r2));
    }

    private static JSONObject packJsonData(i r7, JSONObject r8) {
        JSONObject r1 = new JSONObject();
        r1.put("timestamp", r7.f5096a);     // Catch: JSONException -> L16
        r1.put("crash_time", r7.f5096a);     // Catch: JSONException -> L16
        r1.put("is_main_process", com.bytedance.apm.d.G());     // Catch: JSONException -> L16
        r1.put("process_name", com.bytedance.apm.d.i());     // Catch: JSONException -> L16
        r1.put("block_duration", r7.f5097b);     // Catch: JSONException -> L16
        r1.put(KEY_RAW_DUMP_INFO, r7.f5098c);     // Catch: JSONException -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(i.a(r7)) == true) goto L7;
        r2.append(i.a(r7).replace("\t", ""));     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
    L7:
        r2.append("-OwnerThread: ");     // Catch: JSONException -> L16
        r2.append(r7.g());     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
        r2.append("-OwnerStack: ");     // Catch: JSONException -> L16
        r2.append(r7.f());     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
        r2.append("-WaiterStack: ");     // Catch: JSONException -> L16
        r2.append(r7.d());     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
        r2.append("-RawAtrace: ");     // Catch: JSONException -> L16
        r2.append(r7.f5098c);     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
        r2.append("-LockThread: ");     // Catch: JSONException -> L16
        r2.append(r7.e());     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
        if (i.b(r7) == null) goto L10;
        r2.append("-Activity: ");     // Catch: JSONException -> L16
        r2.append(i.b(r7));     // Catch: JSONException -> L16
        r2.append("\n");     // Catch: JSONException -> L16
    L10:
        JSONObject r9 = d.b.b.m.a.c.a().b();     // Catch: JSONException -> L16
        r9.put("block_stack_type", "stack");     // Catch: JSONException -> L16
        Iterator<String> r3 = r8.keys();     // Catch: JSONException -> L16
    L12:
        if (r3.hasNext() == false) goto L14;
        String r4 = r3.next();     // Catch: JSONException -> L16
        r9.put(r4, r8.get(r4));     // Catch: JSONException -> L16
        goto L12
    L14:
        r1.put("filters", r9);     // Catch: JSONException -> L16
        r1.put("stack", r2.toString());     // Catch: JSONException -> L16
        r1.put("event_type", "lag");     // Catch: JSONException -> L16
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(JSONObject r1) {
        dumpLockInfo(new c(r1));
    }

    public static void setOpenFetchStack(boolean r0) {
        openFetchStack = r0;
        if (r0 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    public static void startLockDetect(long r2) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (com.bytedance.apm.d.H() == false) goto L9;
        k.n().A(r2, false);
        return;
    }

    public static void startLockDetect(long r1, boolean r3) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r3;
        if (com.bytedance.apm.d.H() == false) goto L9;
        k.n().A(r1, r3);
        return;
    }
}
