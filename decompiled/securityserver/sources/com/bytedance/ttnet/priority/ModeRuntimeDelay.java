package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ModeRuntimeDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private final Set<String> mBlackListForRuntime;
    private final AtomicLong mLastP0StartTime;
    private int mP0CheckCountdownMs;
    private final Set<String> mP0List;
    private int mP1MaxWaitMs;
    private final RequestDropController mRequestDropController;
    private final Set<Request> mRuntimePOSet;
    private final Set<String> mWhiteListForRuntime;

    public ModeRuntimeDelay() {
        this.mRequestDropController = new RequestDropController();
        this.mP0List = new CopyOnWriteArraySet();
        this.mBlackListForRuntime = new CopyOnWriteArraySet();
        this.mWhiteListForRuntime = new CopyOnWriteArraySet();
        this.mP0CheckCountdownMs = 5000;
        this.mP1MaxWaitMs = 5000;
        this.mLastP0StartTime = new AtomicLong(0);
        this.mRuntimePOSet = new CopyOnWriteArraySet();
    }

    public static /* synthetic */ Set access$000(ModeRuntimeDelay r0) {
        return r0.mRuntimePOSet;
    }

    private boolean checkRequestForRuntime(Request r7) {
        this.mRequestDropController.raiseExceptionIfDrop(r7);
        boolean r1 = false;
        if (TTHttpCallPriorityControl.isMatch(this.mP0List, r7.getPath()) == false) goto L7;
        this.mLastP0StartTime.set(System.currentTimeMillis());
        this.mRuntimePOSet.add(r7);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.mLastP0StartTime.get()) <= this.mP0CheckCountdownMs) goto L9;
    L19:
        return r1;
    L9:
        if (this.mRuntimePOSet.isEmpty() == true) goto L19;
        if (this.mBlackListForRuntime.isEmpty() == false) goto L14;
        r1 = true;
        if (this.mWhiteListForRuntime.isEmpty() == true) goto L19;
        return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForRuntime, r7.getPath());
    L14:
        return TTHttpCallPriorityControl.isMatch(this.mBlackListForRuntime, r7.getPath());
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r6) {
        super.initWithTncConfig(r6);
        this.mRequestDropController.initWithTncConfig(r6);
        this.mRequestDelayController.initWithTncConfig(r6, this.mStateName);
        JSONArray r0 = r6.optJSONArray("p0");
        int r1 = 0;
        if (r0 == null) goto L12;
        int r2 = 0;
    L6:
        if (r2 >= r0.length()) goto L12;
        String r3 = r0.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        this.mP0List.add(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (this.mRequestDropController.isValid() == false) goto L14;
    L16:
        JSONArray r4 = r6.optJSONArray("bl_for_runtime");
        if (r4 == null) goto L25;
        int r5 = 0;
    L20:
        if (r5 >= r4.length()) goto L25;
        String r7 = r4.optString(r5);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        this.mBlackListForRuntime.add(r7);
    L24:
        r5 = r5 + 1;
    L25:
        JSONArray r8 = r6.optJSONArray("wl_for_runtime");
        if (r8 != null) goto L28;
    L33:
        this.mP0CheckCountdownMs = r6.optInt("p0_check_max_ms", 5000);
        this.mP1MaxWaitMs = r6.optInt("p1_wait_max_ms", 5000);
        return true;
    L28:
        if (r1 >= r8.length()) goto L33;
        String r9 = r8.optString(r1);
        if (TextUtils.isEmpty(r9) == true) goto L32;
        this.mWhiteListForRuntime.add(r9);
    L32:
        r1 = r1 + 1;
        goto L28
    L14:
        if (this.mP0List.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        if (checkRequestForRuntime(r10) == true) goto L5;
        return false;
    L5:
        return this.mRequestDelayController.requestAsyncDelay(r10, false, this.mP1MaxWaitMs, r13, r12, r11);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r9, RetrofitMetrics r10) {
        if (checkRequestForRuntime(r9) == false) goto L6;
        this.mRequestDelayController.requestBlockingDelay(r9, false, true, this.mP1MaxWaitMs, r10);
        return;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.RUNTIME_DELAY;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl, com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r3) {
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass1(this, r3));
    }
}
