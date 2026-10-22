package com.bytedance.ttnet.config;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.SsRunnable;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTHttpCallThrottleControl implements SsHttpCall.IHttpCallThrottleControl {
    private static volatile TTHttpCallThrottleControl mInstance;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private volatile StateConfig mCurrentConfig;
    private final ReadWriteLock mCurrentConfigRWLock;
    private final Lock mCurrentConfigReadLock;
    private final Lock mCurrentConfigWriteLock;
    private final AtomicLong mLastP0StartTime;
    private final Set<Request> mP1AsyncSet;
    private final Set<Request> mP1SyncSet;
    private final ReadWriteLock mReleaseP1EnqueueLock;
    private final Lock mReleaseP1EnqueueWriteLock;
    private final Condition mReleaseP1ExecuteCondition;
    private final Lock mReleaseP1ExecuteLock;
    private final Set<Request> mRuntimePOSet;
    private final Map<String, StateConfig> mStateConfigMap;
    private final AtomicBoolean mTncStateDelayEnabled;

    public static final enum DelayMode extends Enum<DelayMode> {
        private static final /* synthetic */ DelayMode[] $VALUES = null;
        public static final DelayMode BLACK_LIST = null;
        public static final DelayMode NOT_REACHED = null;
        public static final DelayMode NO_DELAY = null;
        public static final DelayMode RUNTIME = null;
        public static final DelayMode WHITE_LIST = null;

        private DelayMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DelayMode valueOf(String r1) {
            return (DelayMode) Enum.valueOf(DelayMode.class, r1);
        }

        public static DelayMode[] values() {
            return (DelayMode[]) $VALUES.clone();
        }

        static {
            DelayMode r0 = new DelayMode("NO_DELAY", 0);
            NO_DELAY = r0;
            DelayMode r1 = new DelayMode("BLACK_LIST", 1);
            BLACK_LIST = r1;
            DelayMode r3 = new DelayMode("WHITE_LIST", 2);
            WHITE_LIST = r3;
            DelayMode r5 = new DelayMode("RUNTIME", 3);
            RUNTIME = r5;
            DelayMode r7 = new DelayMode("NOT_REACHED", 4);
            NOT_REACHED = r7;
            $VALUES = new DelayMode[]{r0, r1, r3, r5, r7};
        }
    }

    private static class StateConfig {
        int asyncReqDelayMaxCount;
        Map<String, Integer> blackList;
        Set<String> blackListForRuntime;
        int delayDisableTimeMs;
        DelayMode delayMode;
        Set<String> dropList;
        int p0CheckCountdownMs;
        Set<String> p0List;
        int p1MaxWaitMs;
        int randomSendLowerBoundMs;
        int randomSendUpperBoundMs;
        int state;
        String stateName;
        int syncReqDelayMaxCount;
        Set<String> whiteList;
        int whiteListDelayTimeMs;
        Set<String> whiteListForRuntime;

        private StateConfig() {
            this.delayMode = DelayMode.NO_DELAY;
            this.state = -1;
            this.stateName = "";
            this.delayDisableTimeMs = 1000;
            this.syncReqDelayMaxCount = 5;
            this.asyncReqDelayMaxCount = 5;
            this.dropList = new CopyOnWriteArraySet();
            this.blackList = new ConcurrentHashMap();
            this.whiteList = new CopyOnWriteArraySet();
            this.whiteListDelayTimeMs = 100;
            this.p0List = new CopyOnWriteArraySet();
            this.blackListForRuntime = new CopyOnWriteArraySet();
            this.whiteListForRuntime = new CopyOnWriteArraySet();
            this.p0CheckCountdownMs = 5000;
            this.p1MaxWaitMs = 5000;
            this.randomSendUpperBoundMs = 3000;
            this.randomSendLowerBoundMs = 500;
        }

        /* synthetic */ StateConfig(AnonymousClass1 r1) {
            this();
        }
    }

    public TTHttpCallThrottleControl() {
        this.mTncStateDelayEnabled = new AtomicBoolean(false);
        this.mStateConfigMap = new ConcurrentHashMap();
        this.mCurrentConfig = new StateConfig(null);
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.mCurrentConfigRWLock = r0;
        this.mCurrentConfigReadLock = r0.readLock();
        this.mCurrentConfigWriteLock = r0.writeLock();
        this.mP1AsyncSet = new CopyOnWriteArraySet();
        this.mP1SyncSet = new CopyOnWriteArraySet();
        this.mLastP0StartTime = new AtomicLong(0);
        this.mRuntimePOSet = new CopyOnWriteArraySet();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.mReleaseP1EnqueueLock = r1;
        this.mReleaseP1EnqueueWriteLock = r1.writeLock();
        ReentrantLock r2 = new ReentrantLock();
        this.mReleaseP1ExecuteLock = r2;
        this.mReleaseP1ExecuteCondition = r2.newCondition();
    }

    static /* synthetic */ Lock access$100(TTHttpCallThrottleControl r0) {
        return r0.mReleaseP1EnqueueWriteLock;
    }

    static /* synthetic */ Map access$200(TTHttpCallThrottleControl r0) {
        return r0.mAsyncReqExecutorMap;
    }

    static /* synthetic */ Set access$300(TTHttpCallThrottleControl r0) {
        return r0.mRuntimePOSet;
    }

    static /* synthetic */ Set access$400(TTHttpCallThrottleControl r0) {
        return r0.mP1AsyncSet;
    }

    static /* synthetic */ Set access$500(TTHttpCallThrottleControl r0) {
        return r0.mP1SyncSet;
    }

    static /* synthetic */ void access$600(TTHttpCallThrottleControl r0) {
        r0.releaseAllP1Request();
    }

    public static TTHttpCallThrottleControl getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTHttpCallThrottleControl();     // Catch: Throwable -> L11
        SsHttpCall.setThrottleControl(mInstance);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject r13) {
        JSONArray r0 = r13.optJSONArray("tt_req_delay_config");
        if (r13.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L79;
        if (r0 == null) goto L79;
        ConcurrentHashMap r2 = new ConcurrentHashMap();
        int r3 = 0;
    L11:
        if (r3 >= r0.length()) goto L77;
        StateConfig r4 = new StateConfig(null);
        JSONObject r5 = r0.optJSONObject(r3);
        if (r5 == null) goto L76;
        r4.stateName = r5.optString("state_name", "");
        if (r5.isNull("bl_with_delay_ms") == true) goto L24;
        r4.delayMode = DelayMode.BLACK_LIST;
        JSONObject r6 = r5.optJSONObject("bl_with_delay_ms");
        if (r6 == null) goto L56;
        Iterator<String> r7 = r6.keys();
    L21:
        if (r7.hasNext() == false) goto L56;
        String r9 = r7.next();
        r4.blackList.put(r9, Integer.valueOf(r6.optInt(r9)));
    L56:
        if (r4.blackList.size() > 0) goto L62;
        if (r4.whiteList.size() > 0) goto L62;
        if (r4.p0List.size() <= 0) goto L76;
    L62:
        if (TextUtils.isEmpty(r4.stateName) == true) goto L76;
        r4.delayDisableTimeMs = r5.optInt("delay_disable_time_ms", 1000);
        if (r4.delayDisableTimeMs > 0) goto L68;
        r4.delayDisableTimeMs = 1000;
    L68:
        if (r5.isNull("dl") == true) goto L75;
        JSONArray r8 = r5.optJSONArray("dl");
        if (r8 == null) goto L75;
        int r10 = 0;
    L73:
        if (r10 >= r8.length()) goto L75;
        r4.dropList.add((String) r8.opt(r10));
        r10 = r10 + 1;
    L75:
        r4.state = r5.optInt("state", -1);
        r4.syncReqDelayMaxCount = r5.optInt("sync_req_delay_max_count", 10);
        r4.asyncReqDelayMaxCount = r5.optInt("async_req_delay_max_count", 10);
        r2.put(r4.stateName, r4);
        goto L76
    L24:
        if (r5.isNull("wl") == true) goto L35;
        r4.delayMode = DelayMode.WHITE_LIST;
        JSONArray r11 = r5.optJSONArray("wl");
        if (r11 == null) goto L31;
        int r12 = 0;
    L29:
        if (r12 >= r11.length()) goto L31;
        r4.whiteList.add((String) r11.opt(r12));
        r12 = r12 + 1;
    L31:
        r4.whiteListDelayTimeMs = r5.optInt("delay_time_ms", 1000);
        if (r4.whiteListDelayTimeMs > 0) goto L56;
        r4.whiteListDelayTimeMs = 1000;
        goto L56
    L35:
        if (r5.isNull("p0") == true) goto L56;
        r4.delayMode = DelayMode.RUNTIME;
        JSONArray r15 = r5.optJSONArray("p0");
        if (r15 == null) goto L42;
        int r16 = 0;
    L40:
        if (r16 >= r15.length()) goto L42;
        r4.p0List.add((String) r15.opt(r16));
        r16 = r16 + 1;
    L42:
        JSONArray r17 = r5.optJSONArray("bl_for_runtime");
        if (r17 == null) goto L48;
        int r18 = 0;
    L46:
        if (r18 >= r17.length()) goto L48;
        r4.blackListForRuntime.add((String) r17.opt(r18));
        r18 = r18 + 1;
    L48:
        JSONArray r19 = r5.optJSONArray("wl_for_runtime");
        if (r19 == null) goto L54;
        int r20 = 0;
    L52:
        if (r20 >= r19.length()) goto L54;
        r4.whiteListForRuntime.add((String) r19.opt(r20));
        r20 = r20 + 1;
    L54:
        r4.p0CheckCountdownMs = r5.optInt("p0_check_max_ms", 5000);
        r4.p1MaxWaitMs = r5.optInt("p1_wait_max_ms", 5000);
        r4.randomSendUpperBoundMs = r5.optInt("random_send_ubound_ms", 3000);
        r4.randomSendLowerBoundMs = r5.optInt("random_send_lbound_ms", 500);
    L76:
        r3 = r3 + 1;
        goto L11
    L77:
        this.mStateConfigMap.clear();
        this.mStateConfigMap.putAll(r2);
        this.mTncStateDelayEnabled.set(r14);
        return;
    L79:
        this.mStateConfigMap.clear();
        this.mTncStateDelayEnabled.set(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public void setAppState(String r8) {
        releaseAllP1Request();
        StateConfig r1 = this.mStateConfigMap.get(r8);
        this.mCurrentConfigWriteLock.lock();
    L17:
        th = move-exception;
        this.mCurrentConfigWriteLock.unlock();
        throw th;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("delayrefine", "setAppState " + r8);     // Catch: Throwable -> L17
    L7:
        if (r1 != this.mCurrentConfig) goto L10;
        this.mCurrentConfigWriteLock.unlock();
        return;
    L10:
        if (r1 != null) goto L12;
        r1 = new StateConfig(null);     // Catch: Throwable -> L17
    L12:
        this.mCurrentConfig = r1;     // Catch: Throwable -> L17
        if (this.mCurrentConfig.delayMode == DelayMode.NO_DELAY) goto L15;
        NetworkAsyncTaskManager r9 = NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK);     // Catch: Throwable -> L17
        final long r2 = this.mCurrentConfig.delayDisableTimeMs;     // Catch: Throwable -> L17
        final long r4 = 0;
        r9.postTask(new AnonymousClass1(this, r2, r4));     // Catch: Throwable -> L17
    L15:
        this.mCurrentConfigWriteLock.unlock();
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r10, RetrofitMetrics r11) throws Exception {
        if (this.mTncStateDelayEnabled.get() == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.getPath() == null) goto L72;
        if (r11 == null) goto L73;
        this.mCurrentConfigReadLock.lock();
        int r3 = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(false, this.mCurrentConfig, r11, r10);     // Catch: Throwable -> L57 Exception -> L59
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r3 + " path is " + r10.getPath());     // Catch: Throwable -> L57 Exception -> L59
    L15:
        this.mCurrentConfigReadLock.unlock();
        if (r3 <= 0) goto L19;
        sleepForSpecificTimeMs(r3, r10, r11);
        return;
    L19:
        if (r3 != 0) goto L21;
        return;
    L21:
        this.mCurrentConfigReadLock.lock();
        int r2 = this.mCurrentConfig.randomSendLowerBoundMs;
        int r4 = this.mCurrentConfig.randomSendUpperBoundMs;
        int r5 = this.mCurrentConfig.p1MaxWaitMs;
    L51:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L51
    L23:
        if (this.mCurrentConfig.delayMode == DelayMode.RUNTIME) goto L27;
    L24:
        this.mCurrentConfigReadLock.unlock();
        return;
    L27:
        if (checkRequestForRuntime(this.mCurrentConfig, r10) == false) goto L24;
        if (p1CheckP0Done() == true) goto L24;
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1ExecuteLock.lock();
        r11.delayStartTimeStamp = SystemClock.uptimeMillis();     // Catch: Throwable -> L44 Exception -> L46
        this.mP1SyncSet.add(r10);     // Catch: Throwable -> L44 Exception -> L46
        if (Logger.debug() == false) goto L36;
        Logger.d("delayrefine", "execute p1 add request " + r10.getPath() + " after added me, sync size is " + this.mP1SyncSet.size());     // Catch: Throwable -> L44 Exception -> L46
    L36:
        this.mReleaseP1ExecuteCondition.await(r5, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L44 Exception -> L46
        int r1 = getP1RandomDelayTime(false, r2, r4);     // Catch: Throwable -> L44 Exception -> L46
        long r6 = r1;
        r11.randomSendTime = r6;     // Catch: Throwable -> L44 Exception -> L46
        if (r1 <= 0) goto L40;
        Thread.sleep(r6);     // Catch: Throwable -> L44 Exception -> L46
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.d("delayrefine", "execute p1 release now " + r10.getPath() + " random is " + r1);     // Catch: Throwable -> L44 Exception -> L46
    L42:
        r11.stateDelayTime = SystemClock.uptimeMillis() - r11.delayStartTimeStamp;     // Catch: Throwable -> L44 Exception -> L46
        r11.delayedWithState = true;     // Catch: Throwable -> L44 Exception -> L46
    L47:
        this.mReleaseP1ExecuteLock.unlock();
        return;
    L46:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.mReleaseP1ExecuteLock.unlock();
        throw th;
    L59:
        e = move-exception;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L73:
        return;
    }

    private void sleepForSpecificTimeMs(int r3, Request r4, RetrofitMetrics r5) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.mP1SyncSet.add(r4);
        r5.delayStartTimeStamp = System.currentTimeMillis();
        r5.delayedWithState = true;
        Thread.sleep(r3);     // Catch: Throwable -> L8 InterruptedException -> L10
        r5.stateDelayTime = System.currentTimeMillis() - r5.delayStartTimeStamp;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r5.stateDelayTime = System.currentTimeMillis() - r5.delayStartTimeStamp;
        throw th;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(final Request r16, final RetrofitMetrics r17, final Executor r18, final Runnable r19) throws IOException {
        if (this.mTncStateDelayEnabled.get() == true) goto L5;
        return false;
    L5:
        if (r16 != null) goto L7;
    L47:
        return false;
    L7:
        if (r16.getPath() == null) goto L47;
        if (r17 == null) goto L47;
        this.mCurrentConfigReadLock.lock();
        int r3 = this.mCurrentConfig.p1MaxWaitMs;
        int r5 = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(true, this.mCurrentConfig, r17, r16);     // Catch: Throwable -> L41 Exception -> L43
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r5 + " path is " + r16.getPath());     // Catch: Throwable -> L41 Exception -> L43
    L15:
        if (r5 <= 0) goto L19;
        statePostDelay(r5, r18, r19, r16, r17);     // Catch: Throwable -> L41 Exception -> L43
        this.mCurrentConfigReadLock.unlock();
        return true;
    L19:
        if (r5 != 0) goto L23;
    L20:
        this.mCurrentConfigReadLock.unlock();
        return false;
    L23:
        if (this.mCurrentConfig.delayMode != DelayMode.RUNTIME) goto L20;
        if (checkRequestForRuntime(this.mCurrentConfig, r16) == false) goto L20;
        if (p1CheckP0Done() == true) goto L20;
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1EnqueueWriteLock.lock();
        this.mP1AsyncSet.add(r16);     // Catch: Throwable -> L38
        if (Logger.debug() == false) goto L35;
        Logger.d("delayrefine", "enqueue p1 add request " + r16.getPath() + " after added me, async size is " + this.mP1AsyncSet.size());     // Catch: Throwable -> L38
    L35:
        r17.delayStartTimeStamp = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.mAsyncReqExecutorMap.put(r19, r18);     // Catch: Throwable -> L38
        r17.delayedWithState = true;     // Catch: Throwable -> L38
        final long r4 = r3;
        final long r6 = 0;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass2(this, r4, r6, r19, r16, r17, r18));     // Catch: Throwable -> L38
        this.mReleaseP1EnqueueWriteLock.unlock();
        return true;
    L38:
        th = move-exception;
        this.mReleaseP1EnqueueWriteLock.unlock();
        throw th;
    L43:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    }

    private void statePostDelay(final int r9, final Executor r10, final Runnable r11, final Request r12, final RetrofitMetrics r13) {
        if (r9 > 0) goto L4;
        return;
    L4:
        r13.delayStartTimeStamp = System.currentTimeMillis();
        r13.delayedWithState = true;
        SsRunnable r0 = new AnonymousClass3(this, r13, r10, r11, r12, r9);
        this.mP1AsyncSet.add(r12);
        r10.execute(r0);
    }

    private boolean p1CheckP0Done() {
        if ((System.currentTimeMillis() - this.mLastP0StartTime.get()) <= this.mCurrentConfig.p0CheckCountdownMs) goto L6;
        return true;
    L6:
        if (this.mRuntimePOSet.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r3) {
        if (this.mTncStateDelayEnabled.get() == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass4(this, r3));
        return;
    L5:
        if (this.mRuntimePOSet.size() > 0) goto L7;
    }

    private void releaseAllP1Request() {
        if (Logger.debug() == false) goto L5;
        Logger.d("delayrefine", "releaseAllP1Request, " + this.mP1SyncSet.size() + HanziToPinyin.Token.SEPARATOR + this.mP1AsyncSet.size());
    L5:
        this.mReleaseP1ExecuteLock.lock();
        this.mReleaseP1ExecuteCondition.signalAll();     // Catch: Throwable -> L23
        this.mReleaseP1ExecuteLock.unlock();
        this.mCurrentConfigReadLock.lock();
        int r0 = this.mCurrentConfig.randomSendLowerBoundMs;     // Catch: Throwable -> L20
        int r1 = this.mCurrentConfig.randomSendUpperBoundMs;     // Catch: Throwable -> L20
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1EnqueueWriteLock.lock();
        Iterator<Map.Entry<Runnable, Executor>> r2 = this.mAsyncReqExecutorMap.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<Runnable, Executor> r3 = r2.next();     // Catch: Throwable -> L17
        final Runnable r11 = r3.getKey();     // Catch: Throwable -> L17
        final Executor r13 = r3.getValue();     // Catch: Throwable -> L17
        final int r12 = getP1RandomDelayTime(true, r0, r1);     // Catch: Throwable -> L17
        final long r7 = r12;
        final long r9 = 0;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass5(this, r7, r9, r11, r12, r13));     // Catch: Throwable -> L17
        goto L12
    L15:
        this.mReleaseP1EnqueueWriteLock.unlock();
        this.mP1AsyncSet.clear();
        this.mP1SyncSet.clear();
        return;
    L17:
        th = move-exception;
        this.mReleaseP1EnqueueWriteLock.unlock();
        throw th;
    L20:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L23:
        th = move-exception;
        this.mReleaseP1ExecuteLock.unlock();
        throw th;
    }

    private int getP1RandomDelayTime(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L12;
        if (this.mP1SyncSet.size() > 5) goto L12;
        return 0;
    L12:
        return new Random().nextInt((r6 - r5) + 1) + r5;
    L5:
        if (this.mP1AsyncSet.size() > 5) goto L7;
        return 0;
    }

    private Integer getMapValueIfMatch(Map<String, Integer> r4, String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r4.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        if (r5.startsWith(r1) == false) goto L7;
        return r4.get(r1);
    L15:
        return null;
    }

    private boolean isMatch(Set<String> r2, String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        if (r3.startsWith(r4.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private int getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(boolean r3, StateConfig r4, RetrofitMetrics r5, Request r6) throws IOException {
        if (r6.getMetrics() != null) goto L5;
        r6.setMetrics(r5);
    L5:
        r5.delayState = r4.state;
        r5.syncDelayCount = this.mP1SyncSet.size();
        r5.asyncDelayCount = this.mP1AsyncSet.size();
        if (isMatch(r4.dropList, r6.getPath()) == true) goto L32;
        if (r3 == true) goto L10;
    L12:
        if (r3 == true) goto L17;
        if (this.mP1SyncSet.size() < r4.syncReqDelayMaxCount) goto L17;
        return 0;
    L17:
        if (r4.delayMode != DelayMode.BLACK_LIST) goto L23;
        Integer r2 = getMapValueIfMatch(r4.blackList, r6.getPath());
        if (r2 != null) goto L21;
        return 0;
    L21:
        return r2.intValue();
    L23:
        if (r4.delayMode == DelayMode.WHITE_LIST) goto L25;
        return -1;
    L25:
        if (isMatch(r4.whiteList, r6.getPath()) == false) goto L27;
        return 0;
    L27:
        return r4.whiteListDelayTimeMs;
    L10:
        if (this.mP1AsyncSet.size() < r4.asyncReqDelayMaxCount) goto L12;
        return 0;
    L32:
        throw new DroppedByThrottleControlException();
    }

    private boolean checkRequestForRuntime(StateConfig r3, Request r4) {
        if (isMatch(r3.p0List, r4.getPath()) == false) goto L10;
        this.mLastP0StartTime.set(System.currentTimeMillis());
        this.mRuntimePOSet.add(r4);
        if (Logger.debug() == false) goto L18;
        Logger.d("delayrefine", "p0 add request " + r4.getPath() + " size " + this.mRuntimePOSet.size());
        return false;
    L18:
        return false;
    L10:
        if (r3.blackListForRuntime.size() <= 0) goto L14;
        return isMatch(r3.blackListForRuntime, r4.getPath());
    L14:
        if (r3.whiteListForRuntime.size() > 0) goto L16;
        return true;
    L16:
        return !isMatch(r3.whiteListForRuntime, r4.getPath());
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public int getDispatchDelayTime(String r1, String r2) {
        return URLDispatcher.inst().getDelayResult(r1, r2);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean isDispatchDelayEnabled() {
        return URLDispatcher.inst().isDispatchDelayEnabled();
    }
}
