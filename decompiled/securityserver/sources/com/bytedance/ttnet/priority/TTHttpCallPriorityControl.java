package com.bytedance.ttnet.priority;

import a.a;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTHttpCallPriorityControl implements IHttpCallThrottleControl {
    private static String TAG = "TTHttpCallPriorityControl";
    private static volatile TTHttpCallPriorityControl mInstance;
    private BaseModeControl mCurrentModeControl;
    private final ReadWriteLock mCurrentModeRWLock;
    private final Map<String, BaseModeControl> mModeControlMap;
    private final AtomicBoolean mTncModeControlEnabled;

    public static abstract class BaseModeControl implements IHttpCallThrottleControl {
        private NetworkAsyncTask mClearSelfTask;
        private int mDelayDisableTimeMs;
        protected final RequestDelayController mRequestDelayController;
        private int mStateId;
        protected String mStateName;

        public BaseModeControl() {
            this.mRequestDelayController = new RequestDelayController();
            this.mStateName = "";
            this.mStateId = -1;
            this.mDelayDisableTimeMs = 1000;
            this.mClearSelfTask = null;
        }

        public boolean initWithTncConfig(JSONObject r3) {
            String r0 = r3.optString("state_name", "");
            this.mStateName = r0;
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return false;
        L6:
            this.mStateId = r3.optInt("state", -1);
            int r1 = 1000;
            int r4 = r3.optInt("delay_disable_time_ms", 1000);
            this.mDelayDisableTimeMs = r4;
            if (r4 <= 0) goto L10;
            r1 = r4;
        L10:
            this.mDelayDisableTimeMs = r1;
            return true;
        }

        public void modeStart() {
            final long r2 = this.mDelayDisableTimeMs;
            final long r4 = 0;
            this.mClearSelfTask = new AnonymousClass1(this, r2, r4);
            NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(this.mClearSelfTask);
        }

        public void modeStop() {
            if (this.mClearSelfTask == null) goto L6;
            NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).removeTask(this.mClearSelfTask);
            return;
        }

        public ModeType modeType() {
            return ModeType.NOT_REACHED;
        }

        @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
        public void notifyRequestCompleted(Request r1) {
            this.mRequestDelayController.notifyRequestCompleted(r1);
        }

        public void setDelayDisableTimeMs(int r1) {
            this.mDelayDisableTimeMs = r1;
        }

        public void setStateName(String r1) {
            this.mStateName = r1;
            this.mRequestDelayController.setOwnerStateName(r1);
        }
    }

    public static final enum ModeType extends Enum<ModeType> {
        private static final /* synthetic */ ModeType[] $VALUES = null;
        public static final ModeType DEFAULT = null;
        public static final ModeType NORMAL_DELAY = null;
        public static final ModeType NOT_REACHED = null;
        public static final ModeType PRIORITY = null;
        public static final ModeType RUNTIME_DELAY = null;
        private final int value;

        static {
            ModeType r0 = new ModeType("DEFAULT", 0, 0);
            DEFAULT = r0;
            ModeType r1 = new ModeType("NORMAL_DELAY", 1, 1);
            NORMAL_DELAY = r1;
            ModeType r2 = new ModeType("RUNTIME_DELAY", 2, 2);
            RUNTIME_DELAY = r2;
            ModeType r3 = new ModeType("PRIORITY", 3, 3);
            PRIORITY = r3;
            ModeType r4 = new ModeType("NOT_REACHED", 4, 4);
            NOT_REACHED = r4;
            $VALUES = new ModeType[]{r0, r1, r2, r3, r4};
        }

        private ModeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ModeType fromValue(int r5) {
            ModeType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            ModeType r3 = r0[r2];
            if (r3.getValue() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException(a.e(r5, "Invalid value: "));
        }

        public static ModeType valueOf(String r1) {
            return (ModeType) Enum.valueOf(ModeType.class, r1);
        }

        public static ModeType[] values() {
            return (ModeType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public TTHttpCallPriorityControl() {
        this.mTncModeControlEnabled = new AtomicBoolean(false);
        this.mModeControlMap = new ConcurrentHashMap();
        this.mCurrentModeControl = new ModeDefault();
        this.mCurrentModeRWLock = new ReentrantReadWriteLock();
    }

    private boolean checkRequestAndMetrics(Request r1, RetrofitMetrics r2) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r1.getPath()) == true) goto L15;
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r1.getMetrics() != null) goto L14;
        r1.setMetrics(r2);
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    public static TTHttpCallPriorityControl getInstance() {
        if (mInstance != null) goto L16;
        monitor-enter(TTHttpCallThrottleControl.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new TTHttpCallPriorityControl();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    public static Integer getMapValueIfMatch(Map<String, Integer> r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r4.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next();
        if (r5.startsWith(r2) == false) goto L7;
        return r4.get(r2);
    L12:
        return null;
    }

    public static Set<String> getSetFromJSONArray(JSONObject r3, String r4) {
        CopyOnWriteArraySet r0 = new CopyOnWriteArraySet();
        if (r3 != null) goto L5;
        return r0;
    L5:
        JSONArray r5 = r3.optJSONArray(r4);
        if (r5 != null) goto L8;
        return r0;
    L8:
        int r6 = 0;
    L10:
        if (r6 >= r5.length()) goto L15;
        String r1 = r5.optString(r6);
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0.add(r1);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        return r0;
    }

    public static boolean isMatch(Set<String> r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
        return false;
    L7:
        Iterator<String> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        if (r3.startsWith(r4.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private void startMode(BaseModeControl r3) {
        this.mCurrentModeRWLock.writeLock().lock();
        this.mCurrentModeControl.modeStop();     // Catch: Throwable -> L6
        if (r3 != null) goto L8;
        r3 = new ModeDefault();     // Catch: Throwable -> L6
    L8:
        this.mCurrentModeControl = r3;     // Catch: Throwable -> L6
        r3.modeStart();     // Catch: Throwable -> L6
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "set mode " + this.mCurrentModeControl.modeType());     // Catch: Throwable -> L6
    L11:
        this.mCurrentModeRWLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mCurrentModeRWLock.writeLock().unlock();
        throw th;
    }

    public ModeType getCurrentMode() {
        this.mCurrentModeRWLock.writeLock().lock();
        ModeType r0 = this.mCurrentModeControl.modeType();     // Catch: Throwable -> L6
        this.mCurrentModeRWLock.writeLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.mCurrentModeRWLock.writeLock().unlock();
        throw th;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r4, RetrofitMetrics r5, Executor r6, Runnable r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "current mode is " + getCurrentMode());
    L6:
        if (this.mTncModeControlEnabled.get() == true) goto L11;
        if (this.mCurrentModeControl.modeType() == ModeType.DEFAULT) goto L11;
        return false;
    L11:
        if (checkRequestAndMetrics(r4, r5) == true) goto L14;
        return false;
    L14:
        return this.mCurrentModeControl.maybeDropRequestOrAsyncDelay(r4, r5, r6, r7);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r4, RetrofitMetrics r5) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "current mode is " + getCurrentMode());
    L6:
        if (this.mTncModeControlEnabled.get() == true) goto L11;
        if (this.mCurrentModeControl.modeType() == ModeType.DEFAULT) goto L11;
        return;
    L11:
        if (checkRequestAndMetrics(r4, r5) == true) goto L13;
        return;
    L13:
        this.mCurrentModeControl.maybeDropRequestOrBlockingDelay(r4, r5);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(Request r2) {
        if (this.mTncModeControlEnabled.get() == false) goto L8;
        if (r2 == null) goto L9;
        this.mCurrentModeControl.notifyRequestCompleted(r2);
        return;
    L9:
        return;
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject r9) {
        int r1 = 0;
        this.mTncModeControlEnabled.set(false);
        this.mModeControlMap.clear();
        JSONArray r0 = r9.optJSONArray("tt_req_delay_config");
        if (r9.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r9.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r10 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r10 == false) goto L14;
        boolean r11 = true;
    L16:
        if (r2 == false) goto L49;
        if (r0 == null) goto L49;
        if (r11 == false) goto L49;
        ConcurrentHashMap r12 = new ConcurrentHashMap();
    L22:
        if (r1 >= r0.length()) goto L45;
        JSONObject r3 = r0.optJSONObject(r1);
        String r5 = r3.optString("state_name", "");
        if (TextUtils.isEmpty(r5) == true) goto L43;
        ModeType r6 = ModeType.fromValue(r3.optInt("type", ModeType.NOT_REACHED.getValue()));
        if (r6 != ModeType.NORMAL_DELAY) goto L30;
        BaseModeControl r7 = new ModeNormalDelay();
    L36:
        if (r7 == null) goto L43;
        if (r7.initWithTncConfig(r3) == false) goto L43;
        if (Logger.debug() == false) goto L42;
        a.y("mode name is ", r5, TAG);
    L42:
        r12.put(r5, r7);
        goto L43
    L30:
        if (r6 != ModeType.RUNTIME_DELAY) goto L33;
        r7 = new ModeRuntimeDelay();
        goto L36
    L33:
        if (r6 != ModeType.PRIORITY) goto L35;
        r7 = new ModePriorityManagement();
        goto L36
    L35:
        r7 = null;
    L43:
        r1 = r1 + 1;
        goto L22
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(TAG, "mode size is " + r12.size());
    L47:
        this.mModeControlMap.putAll(r12);
        this.mTncModeControlEnabled.set(true);
        return;
    L49:
        startAppStateFromTNC("");
        return;
    L14:
        r11 = false;
        goto L16
    L9:
        r10 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public void resetToDefaultState() {
        startMode(null);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r2) {
        if (this.mTncModeControlEnabled.get() == false) goto L8;
        if (r2 == null) goto L8;
        return this.mCurrentModeControl.setOriginalRequestProperties(r2);
    L8:
        return r2;
    }

    public void startAppStateFromCustom(ModePriorityManagement r1) {
        startMode(r1);
    }

    public void startAppStateFromTNC(String r2) {
        startMode(this.mModeControlMap.get(r2));
    }
}
