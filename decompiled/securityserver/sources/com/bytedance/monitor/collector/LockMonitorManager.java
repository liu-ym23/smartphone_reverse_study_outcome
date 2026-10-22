package com.bytedance.monitor.collector;

import a.a;
import android.annotation.SuppressLint;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
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
    private static LockInfo[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    public static class LockInfo {
        private static final String INFO_BEGIN = "monitor contention with owner";
        private String blockStackInfo;
        private String completeBlockStackInfo;
        public final long duration;
        private String lockThreadName;
        private String ownerStackInfo;
        private String ownerThreadName;
        public final String rawAtrace;
        public final long timestamp;
        private String topActivityName;

        private LockInfo(long r2, long r4, String r6, String r7) {
            this.topActivityName = EnvironmentCompat.MEDIA_UNKNOWN;
            this.timestamp = r2;
            this.duration = r4;
            this.rawAtrace = r6;
            this.lockThreadName = r7;
            parseAtrace(r6);
            ActivityLifecycleService r3 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            if (r3 == null) goto L8;
            String r5 = r3.getTopActivityClassName();
            if (TextUtils.isEmpty(r5) == true) goto L9;
            this.topActivityName = r5;
            return;
        L9:
            return;
        }

        public static /* synthetic */ String access$100(LockInfo r0) {
            return r0.completeBlockStackInfo;
        }

        public static /* synthetic */ String access$200(LockInfo r0) {
            return r0.topActivityName;
        }

        @Nullable
        @WorkerThread
        public static LockInfo createLockInfo(String r9) {
            String r0 = null;
            if (r9 != null) goto L5;
        L61:
            return null;
        L5:
            if (r9.isEmpty() == true) goto L61;
            Log.d("lockDetect", r9);
            String[] r1 = r9.split(LockMonitorManager.DELIMITER);
            if (r1.length == 4) goto L11;
            Log.d("lockDetect", "spiltData != 4".concat(r9));
            return null;
        L11:
            long r3 = Long.parseLong(r1[0]);
            long r5 = Long.parseLong(r1[1]);
            String r10 = r1[2];
            LockInfo r2 = new LockInfo(r3, r5, r10, r1[3]);
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
            r2.setOwnerJavaStack(r8);
        L60:
            return r2;
        L56:
            if (r10.contains(Util.getTopMethodName(r0)) == false) goto L58;
            r2.setJavaStack(r0);
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r0 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L35:
            th = move-exception;
            throw th;
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
            goto L39
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r6 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r6 = null;
        L18:
            th = move-exception;
            throw th;
        L53:
            r8 = null;
            goto L54
        }

        private void parseAtrace(String r9) {
            String r10 = r9.substring(r9.indexOf(INFO_BEGIN));
            this.ownerThreadName = r10.substring(30, r10.indexOf("(") - 1);
            int r1 = r10.indexOf(" at ");
            if (r1 == (-1)) goto L5;
            String r2 = r10.substring(r1 + 5, r10.indexOf("waiters=", r1));
            String r3 = r2.substring(r2.indexOf(" "));
            this.ownerStackInfo = r3.substring(1, r3.indexOf("(")) + r3.substring(r3.indexOf(")") + 1, r3.lastIndexOf(")") + 1);
        L5:
            String r11 = r10.substring(r10.indexOf("blocking from") + 14);
            String r12 = r11.substring(r11.indexOf(" ") + 1);
            this.blockStackInfo = r12.substring(0, r12.indexOf("(")) + r12.substring(r12.indexOf(")") + 1, r12.lastIndexOf(")") + 1);
        }

        public String getBlockStackInfo() {
            return this.blockStackInfo;
        }

        public String getLockThreadName() {
            return this.lockThreadName;
        }

        public String getOwnerStackInfo() {
            return this.ownerStackInfo;
        }

        public String getOwnerThreadName() {
            return this.ownerThreadName;
        }

        public void setJavaStack(String r1) {
            this.completeBlockStackInfo = r1;
        }

        public void setOwnerJavaStack(String r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            if (r2.isEmpty() == true) goto L8;
            this.ownerStackInfo = r2;
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("LockInfo{timestamp=");
            r0.append(this.timestamp);
            r0.append(", duration=");
            r0.append(this.duration);
            r0.append(", rawAtrace='");
            r0.append(this.rawAtrace);
            r0.append("', topActivityName='");
            r0.append(this.topActivityName);
            r0.append("', blockStackInfo='");
            r0.append(this.blockStackInfo);
            r0.append("', completeBlockStackInfo='");
            r0.append(this.completeBlockStackInfo);
            r0.append("', ownerStackInfo='");
            r0.append(this.ownerStackInfo);
            r0.append("', lockThreadName='");
            r0.append(this.lockThreadName);
            r0.append("', ownerThreadName='");
            return a.o(r0, this.ownerThreadName, "'}");
        }
    }

    public interface LockInfoFetchListener {
        @WorkerThread
        void onData(@Nullable List<LockInfo> r1);
    }

    static {
        lockInfoQueue = new LockInfo[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new AnonymousClass1());
        sStackFetcher = Executors.newSingleThreadExecutor(new AnonymousClass2());
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    public static /* synthetic */ JSONObject access$000(LockInfo r0, JSONObject r1) {
        return packJsonData(r0, r1);
    }

    public static /* synthetic */ void access$1000(String r0) {
        getThreadStack(r0);
    }

    public static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    public static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    public static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    public static /* synthetic */ String access$502(String r0) {
        lastJavaStack = r0;
        return r0;
    }

    public static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    public static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    public static /* synthetic */ String access$702(String r0) {
        lastOwnerJavaStack = r0;
        return r0;
    }

    public static /* synthetic */ void access$800(LockInfo r0) {
        enqueue(r0);
    }

    public static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static void dumpLockInfo(final LockInfoFetchListener r2) {
        AsyncEventManager.getInstance().post(new AnonymousClass4(r2));
    }

    public static void endLockDetect(@NonNull JSONObject r2) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r2.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r2.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (ApmContext.isMainProcessSimple() == false) goto L16;
        reportLockInfo(r2);
        PerfMonitorManager.getInstance().endLockDetect();
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @WorkerThread
    private static void enqueue(LockInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        LockInfo[] r0 = lockInfoQueue;
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
        int r2 = (r1 / 2) + r1;
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L28;
        final Thread r5 = r3[r4];
        if (r5 == null) goto L29;
        if (r5 == Thread.currentThread()) goto L19;
        if (r5.getName().contains(r6) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new AnonymousClass6(r5));
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
        int r2 = (r1 / 2) + r1;
        Thread[] r3 = new Thread[r2];
        r0.enumerate(r3);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L24;
        final Thread r5 = r3[r4];
        if (r5 == null) goto L25;
        if (r5.getName().contains(r6) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new AnonymousClass7(r5));
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
    private static void nativeGetJavaStack(String r2, final String r3) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new AnonymousClass8(r3));
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
        int r6 = r5.indexOf("(") - 1;
        if (r6 > 0) goto L16;
        return;
    L16:
        if (30 < r5.length()) goto L18;
        return;
    L18:
        if (r6 >= r5.length()) goto L28;
        if (30 >= r6) goto L29;
        getOwnerStack(r5.substring(30, r6));
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
    private static void nativePut(final String r2) {
        sLockHandler.execute(new AnonymousClass5(r2));
    }

    private static JSONObject packJsonData(LockInfo r7, JSONObject r8) {
        JSONObject r1 = new JSONObject();
        r1.put("timestamp", r7.timestamp);     // Catch: JSONException -> L7
        r1.put(CommonKey.KEY_CRASH_TIME, r7.timestamp);     // Catch: JSONException -> L7
        r1.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L7
        r1.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L7
        r1.put("block_duration", r7.duration);     // Catch: JSONException -> L7
        r1.put(KEY_RAW_DUMP_INFO, r7.rawAtrace);     // Catch: JSONException -> L7
        StringBuilder r2 = new StringBuilder();     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(LockInfo.access$100(r7)) == true) goto L9;
        r2.append(LockInfo.access$100(r7).replace("\t", ""));     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
    L9:
        r2.append("-OwnerThread: ");     // Catch: JSONException -> L7
        r2.append(r7.getOwnerThreadName());     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
        r2.append("-OwnerStack: ");     // Catch: JSONException -> L7
        r2.append(r7.getOwnerStackInfo());     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
        r2.append("-WaiterStack: ");     // Catch: JSONException -> L7
        r2.append(r7.getBlockStackInfo());     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
        r2.append("-RawAtrace: ");     // Catch: JSONException -> L7
        r2.append(r7.rawAtrace);     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
        r2.append("-LockThread: ");     // Catch: JSONException -> L7
        r2.append(r7.getLockThreadName());     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
        if (LockInfo.access$200(r7) == null) goto L12;
        r2.append("-Activity: ");     // Catch: JSONException -> L7
        r2.append(LockInfo.access$200(r7));     // Catch: JSONException -> L7
        r2.append("\n");     // Catch: JSONException -> L7
    L12:
        JSONObject r9 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L7
        r9.put("block_stack_type", "stack");     // Catch: JSONException -> L7
        Iterator<String> r3 = r8.keys();     // Catch: JSONException -> L7
    L14:
        if (r3.hasNext() == false) goto L16;
        String r4 = r3.next();     // Catch: JSONException -> L7
        r9.put(r4, r8.get(r4));     // Catch: JSONException -> L7
        goto L14
    L16:
        r1.put("filters", r9);     // Catch: JSONException -> L7
        r1.put("stack", r2.toString());     // Catch: JSONException -> L7
        r1.put("event_type", "lag");     // Catch: JSONException -> L7
        return r1;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(final JSONObject r1) {
        dumpLockInfo(new AnonymousClass3(r1));
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

    @WorkerThread
    public static List<LockInfo> dumpLockInfo() {
        LinkedList r0 = new LinkedList();
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L9;
        int r3 = (((position + 100) - r1) - 1) % 100;
        LockInfo[] r2 = lockInfoQueue;
        LockInfo r4 = r2[r3];
        r2[r3] = null;
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    public static void startLockDetect(long r2) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (ApmContext.isMainProcessSimple() == false) goto L9;
        PerfMonitorManager.getInstance().startLockDetect(r2, false);
        return;
    }

    public static void startLockDetect(long r1, boolean r3) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r3;
        if (ApmContext.isMainProcessSimple() == false) goto L9;
        PerfMonitorManager.getInstance().startLockDetect(r1, r3);
        return;
    }

    public static String dumpLockInfo(long r9, long r11) {
        LockInfo[] r1 = new LockInfo[100];
        int r3 = 0;
        System.arraycopy(lockInfoQueue, 0, r1, 0, 100);
        ArrayList r2 = new ArrayList();
    L3:
        if (r3 >= 100) goto L17;
        LockInfo r4 = r1[((position + r3) + 1) % 100];
        if (r4 == null) goto L15;
        long r5 = r4.timestamp;
        if (r5 >= r11) goto L10;
    L11:
        r2.add(r4);
    L13:
        if ((r4.timestamp + r4.duration) >= r9) goto L15;
    L10:
        if ((r5 + r4.duration) <= r9) goto L13;
    L15:
        r3 = r3 + 1;
    L17:
        return r2.toString();
    }
}
