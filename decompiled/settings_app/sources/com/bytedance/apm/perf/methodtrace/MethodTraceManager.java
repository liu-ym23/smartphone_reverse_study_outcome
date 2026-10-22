package com.bytedance.apm.perf.methodtrace;

import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MethodTraceManager {
    private static final int BASE_CACHE_SIZE = 8192;
    private static final int BYTE_255 = 255;
    private static final int EVENT_METHOD_ENTER = 0;
    private static final int EVENT_METHOD_EXIT = 1;
    private static volatile MethodTraceManager sTraceManger;
    private IAsyncTaskManager mAsyncTaskManager;
    private List<Thread> mBusyThreads;
    private int mCacheIndex;
    private JSONObject mData;
    private volatile boolean mIsRunning;
    private HashMap<StackTraceElement, Integer> mMethodIdMap;
    private Set<Long> mOldThreadSet;
    private Map<Long, ThreadTraceItem> mThreadItemMap;
    private int mTimer;
    private byte[] mTraceCache;
    private long mTraceStartTime;
    private TaskRunnable mTraceTask;

    class ThreadTraceItem {
        StackTraceElement[] oldStack;
        long startTime;
        final /* synthetic */ MethodTraceManager this$0;
        String threadName;

        ThreadTraceItem(MethodTraceManager r1, String r2, long r3, StackTraceElement[] r5) {
            this.this$0 = r1;
            this.threadName = r2;
            this.startTime = r3;
            this.oldStack = r5;
        }
    }

    private static byte getByte(int r0, int r1) {
        return (byte) ((r0 >> r1) & 255);
    }

    private static byte getByte(long r2, int r4) {
        return (byte) ((r2 >> r4) & 255);
    }

    static /* synthetic */ boolean access$000(MethodTraceManager r0) {
        return r0.mIsRunning;
    }

    static /* synthetic */ int access$100(MethodTraceManager r0) {
        return r0.mTimer;
    }

    static /* synthetic */ int access$110(MethodTraceManager r2) {
        int r0 = r2.mTimer;
        r2.mTimer = r0 - 1;
        return r0;
    }

    static /* synthetic */ void access$200(MethodTraceManager r0) {
        r0.stop();
    }

    static /* synthetic */ void access$300(MethodTraceManager r0) {
        r0.trace();
    }

    static /* synthetic */ IAsyncTaskManager access$400(MethodTraceManager r0) {
        return r0.mAsyncTaskManager;
    }

    public MethodTraceManager() {
        this.mIsRunning = false;
        this.mTraceTask = new AnonymousClass1(this);
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    }

    public static MethodTraceManager getInstance() {
        if (sTraceManger != null) goto L15;
        monitor-enter(MethodTraceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sTraceManger != null) goto L9;
        sTraceManger = new MethodTraceManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MethodTraceManager.class);     // Catch: Throwable -> L11
    L15:
        return sTraceManger;
    }

    private void trace() {
        HashSet r7 = new HashSet();
        Iterator<Thread> r8 = this.mBusyThreads.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        Thread r6 = r8.next();
        if (r6 == null) goto L4;
        if (r6.isAlive() == false) goto L4;
        long r9 = r6.getId();
        ThreadTraceItem r0 = this.mThreadItemMap.get(Long.valueOf(r9));
        if (r0 != null) goto L14;
        ThreadTraceItem r13 = new ThreadTraceItem(this, r6.getName(), SystemClock.uptimeMillis() * 1000, null);
        this.mThreadItemMap.put(Long.valueOf(r6.getId()), r13);
        ThreadTraceItem r3 = r13;
    L15:
        compareStackTrace(r9, r3, r6.getStackTrace(), SystemClock.uptimeMillis() * 1000);
        this.mOldThreadSet.remove(Long.valueOf(r9));
        r7.add(Long.valueOf(r9));
        goto L4
    L14:
        r3 = r0;
        goto L15
    L16:
        Iterator<Long> r1 = this.mOldThreadSet.iterator();
    L18:
        if (r1.hasNext() == false) goto L20;
        handleOldStack(r1.next().longValue());
        goto L18
    L20:
        this.mOldThreadSet = r7;
    }

    public void start(List<Thread> r3, JSONObject r4) {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mBusyThreads = r3;
        this.mData = r4;
        this.mThreadItemMap = new HashMap();
        this.mTraceStartTime = SystemClock.uptimeMillis() * 1000;
        this.mMethodIdMap = new HashMap();
        this.mOldThreadSet = new HashSet();
        this.mIsRunning = true;
        initTraceCacheHeader();
        this.mTimer = 200;
        IAsyncTaskManager r5 = this.mAsyncTaskManager;
        if (r5 == null) goto L9;
        r5.post(this.mTraceTask);
        return;
    }

    public void stopTrace() {
        if (this.mIsRunning == false) goto L8;
        IAsyncTaskManager r0 = this.mAsyncTaskManager;
        if (r0 == null) goto L9;
        r0.post(AsyncTaskUtil.wrapTimeSensitiveTask("stop-trace", new AnonymousClass2(this)));
        return;
    L9:
        return;
    }

    private void initTraceCacheHeader() {
        this.mTraceCache = new byte[8192];
        this.mCacheIndex = 0;
        append4Bytes(1464814675);
        append2Bytes(3);
        append2Bytes(18);
        append8Bytes(this.mTraceStartTime);
        append2Bytes(14);
    }

    private void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        IAsyncTaskManager r0 = this.mAsyncTaskManager;
        if (r0 == null) goto L8;
        r0.removeTask(this.mTraceTask);
    L8:
        Iterator<Long> r1 = this.mOldThreadSet.iterator();
    L10:
        if (r1.hasNext() == false) goto L13;
        handleOldStack(r1.next().longValue());
        goto L10
    L13:
        if (this.mCacheIndex <= 18) goto L17;
        sendTrace(logTrace());
        return;
    }

    private void sendTrace(String r3) {
        this.mData.put("trace_data", r3);     // Catch: JSONException -> L4
        CommonDataPipeline.getInstance().handle(new ExceptionLogData("cpu_trace", this.mData));     // Catch: JSONException -> L4
        return;
    }

    private void compareStackTrace(long r16, ThreadTraceItem r18, StackTraceElement[] r19, long r20) {
        int r10 = (int) (r20 - this.mTraceStartTime);
        int r11 = (int) (r20 - r18.startTime);
        if (r18.oldStack != null) goto L5;
    L20:
        int r12 = r19.length - 1;
    L21:
        if (r12 < 0) goto L23;
        logMethodTraceEvent(r16, r11, r10, r19[r12], 0);
        r12 = r12 - 1;
        goto L21
    L23:
        r18.oldStack = r19;
        this.mThreadItemMap.put(Long.valueOf(r16), r18);
        return;
    L5:
        if (r18.oldStack.length == 0) goto L20;
        int r13 = r18.oldStack.length - 1;
        int r14 = r19.length - 1;
    L8:
        if (r13 < 0) goto L13;
        if (r14 < 0) goto L13;
        if (r18.oldStack[r13].equals(r19[r14]) == false) goto L13;
        r13 = r13 - 1;
        r14 = r14 - 1;
    L13:
        int r15 = 0;
    L14:
        if (r15 > r13) goto L16;
        logMethodTraceEvent(r16, r11, r10, r18.oldStack[r15], 1);
        r15 = r15 + 1;
    L16:
        if (r14 < 0) goto L18;
        logMethodTraceEvent(r16, r11, r10, r19[r14], 0);
        r14 = r14 - 1;
        goto L16
    L18:
        r18.oldStack = r19;
        this.mThreadItemMap.put(Long.valueOf(r16), r18);
    }

    private void handleOldStack(long r13) {
        ThreadTraceItem r0 = this.mThreadItemMap.get(Long.valueOf(r13));
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = SystemClock.uptimeMillis() * 1000;
        int r3 = (int) (r1 - this.mTraceStartTime);
        int r2 = (int) (r1 - r0.startTime);
        int r4 = 0;
    L7:
        if (r4 >= r0.oldStack.length) goto L9;
        logMethodTraceEvent(r13, r2, r3, r0.oldStack[r4], 1);
        r4 = r4 + 1;
        goto L7
    L9:
        r0.oldStack = null;
    }

    private void logMethodTraceEvent(long r5, int r7, int r8, StackTraceElement r9, int r10) {
        int r0 = this.mCacheIndex;
        int r1 = r0 + 14;
        byte[] r2 = this.mTraceCache;
        if (r1 < r2.length) goto L5;
        byte[] r3 = new byte[r2.length + 8192];
        System.arraycopy(r2, 0, r3, 0, r0);
        this.mTraceCache = r3;
    L5:
        append2Bytes((int) r5);
        append4Bytes((getTraceMethodId(r9) << 2) | r10);
        append4Bytes(r7);
        append4Bytes(r8);
    }

    private int getTraceMethodId(StackTraceElement r3) {
        Integer r0 = this.mMethodIdMap.get(r3);
        if (r0 != null) goto L6;
        r0 = Integer.valueOf(this.mMethodIdMap.size());
        HashMap<StackTraceElement, Integer> r2 = this.mMethodIdMap;
        r2.put(r3, Integer.valueOf(r2.size()));
    L6:
        return r0.intValue();
    }

    private void append2Bytes(int r4) {
        byte[] r0 = this.mTraceCache;
        int r1 = this.mCacheIndex;
        this.mCacheIndex = r1 + 1;
        r0[r1] = getByte(r4, 0);
        byte[] r2 = this.mTraceCache;
        int r3 = this.mCacheIndex;
        this.mCacheIndex = r3 + 1;
        r2[r3] = getByte(r4, 8);
    }

    private void append4Bytes(int r4) {
        append2Bytes(r4);
        byte[] r0 = this.mTraceCache;
        int r1 = this.mCacheIndex;
        this.mCacheIndex = r1 + 1;
        r0[r1] = getByte(r4, 16);
        byte[] r2 = this.mTraceCache;
        int r3 = this.mCacheIndex;
        this.mCacheIndex = r3 + 1;
        r2[r3] = getByte(r4, 24);
    }

    private void append8Bytes(long r4) {
        append4Bytes((int) r4);
        byte[] r0 = this.mTraceCache;
        int r1 = this.mCacheIndex;
        this.mCacheIndex = r1 + 1;
        r0[r1] = getByte(r4, 32);
        byte[] r2 = this.mTraceCache;
        int r3 = this.mCacheIndex;
        this.mCacheIndex = r3 + 1;
        r2[r3] = getByte(r4, 40);
        byte[] r5 = this.mTraceCache;
        int r6 = this.mCacheIndex;
        this.mCacheIndex = r6 + 1;
        r5[r6] = getByte(r4, 48);
        byte[] r7 = this.mTraceCache;
        int r8 = this.mCacheIndex;
        this.mCacheIndex = r8 + 1;
        r7[r8] = getByte(r4, 56);
    }

    private String logTrace() {
        StringBuilder r0 = new StringBuilder(400);
        r0.append("*version\n3\ndata-file-overflow=false\nclock=dual\nelapsed-time-usec=");
        r0.append((SystemClock.uptimeMillis() * 1000) - this.mTraceStartTime).append("\nnum-method-calls=");
        r0.append(this.mMethodIdMap.size()).append("\nclock-call-overhead-nsec=zzz\nvm=art\npid=");
        r0.append(Process.myPid()).append("\n*threads\n");
        Iterator<Map.Entry<Long, ThreadTraceItem>> r1 = this.mThreadItemMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Long, ThreadTraceItem> r2 = r1.next();
        r0.append(r2.getKey()).append("\t").append(r2.getValue().threadName).append("\n");
        goto L4
    L6:
        r0.append("*methods\n");
        StringBuilder r3 = new StringBuilder();
        StringBuilder r4 = new StringBuilder();
        Iterator<Map.Entry<StackTraceElement, Integer>> r5 = this.mMethodIdMap.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<StackTraceElement, Integer> r6 = r5.next();
        StackTraceElement r7 = r6.getKey();
        Integer r8 = r6.getValue();
        r3.append("\t0x").append(Integer.toHexString(r8.intValue() << 2));
        r4.append("\tat ").append(r7.getClassName()).append(".").append(r7.getMethodName()).append("(").append(r7.getFileName()).append(":").append(r7.getLineNumber()).append(")\n");
        goto L8
    L10:
        r0.append(r3).append("\n").append(r4);
        r0.append("*end\n");
        r0.append(Base64.encodeToString(this.mTraceCache, 0, this.mCacheIndex, 2));
        return r0.toString();
    }
}
