package com.bytedance.ttnet.priority;

import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModePriorityManagement extends TTHttpCallPriorityControl.BaseModeControl {
    private final Set<String> mBlackListForPriority;
    private final RequestDropController mDropController;
    private int mMaxDelayTimeMs;
    private final RequestPriorityController mPriorityController;
    private final RequestSpeedController mRequestSpeedThrottleController;
    private final Set<String> mWhiteListForPriority;

    public ModePriorityManagement() {
        this.mDropController = new RequestDropController();
        this.mPriorityController = new RequestPriorityController();
        this.mRequestSpeedThrottleController = new RequestSpeedController();
        this.mBlackListForPriority = new CopyOnWriteArraySet();
        this.mWhiteListForPriority = new CopyOnWriteArraySet();
        this.mMaxDelayTimeMs = 60000;
    }

    private boolean checkIfDelayOrDropWithPriority(Request r2) throws DroppedByThrottleControlException {
        this.mDropController.raiseExceptionIfDrop(r2);
        if (this.mBlackListForPriority.isEmpty() == true) goto L7;
        return TTHttpCallPriorityControl.isMatch(this.mBlackListForPriority, r2.getPath());
    L7:
        if (this.mWhiteListForPriority.isEmpty() == false) goto L9;
        return false;
    L9:
        return !TTHttpCallPriorityControl.isMatch(this.mWhiteListForPriority, r2.getPath());
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r9, RetrofitMetrics r10) throws Exception {
        if (checkIfDelayOrDropWithPriority(r9) == false) goto L6;
        this.mRequestDelayController.requestBlockingDelay(r9, false, true, this.mMaxDelayTimeMs, r10);
        return;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, RetrofitMetrics r11, Executor r12, Runnable r13) throws Exception {
        if (checkIfDelayOrDropWithPriority(r10) == true) goto L5;
        return false;
    L5:
        return this.mRequestDelayController.requestAsyncDelay(r10, false, this.mMaxDelayTimeMs, r13, r12, r11);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r2) {
        Request r3 = this.mPriorityController.setPriorityToRequest(r2);
        return this.mRequestSpeedThrottleController.setThrottleSpeedToRequest(r3);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r3) {
        super.initWithTncConfig(r3);
        this.mDropController.initWithTncConfig(r3);
        this.mRequestDelayController.initWithTncConfig(r3, this.mStateName);
        JSONObject r0 = r3.optJSONObject("priority");
        if (this.mDropController.isValid() == true) goto L7;
        if (r0 != null) goto L7;
        return false;
    L7:
        this.mPriorityController.initWithTncConfig(r0);
        this.mRequestSpeedThrottleController.initWithTncConfig(r3);
        JSONObject r4 = r3.optJSONObject("delay");
        if (r4 == null) goto L12;
        this.mBlackListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(r4, "bl_with_priority"));
        this.mWhiteListForPriority.addAll(TTHttpCallPriorityControl.getSetFromJSONArray(r4, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    public void initRequestDropController(Set<String> r1) {
        this.mDropController.initWithLocal(r1);
    }

    public void initRequestDelayController(Set<String> r2, Set<String> r3, int r4, int r5, int r6, int r7) {
        this.mRequestDelayController.initWithLocal(r5, r6, r7);
        this.mBlackListForPriority.clear();
        this.mWhiteListForPriority.clear();
        this.mBlackListForPriority.addAll(r2);
        this.mWhiteListForPriority.addAll(r3);
        this.mMaxDelayTimeMs = r4;
    }

    public void initRequestPriorityController(Set<String> r1, Set<String> r2, Set<String> r3) {
        this.mPriorityController.initWithLocal(r1, r2, r3);
    }

    public void initRequestSpeedController(Map<String, Integer> r15, Set<String> r16, Set<String> r17, Set<String> r18, Set<String> r19, long r20, long r22, long r24, long r26) {
        this.mRequestSpeedThrottleController.initWithLocal(r15, r17, r17, r18, r19, r20, r22, r24, r26);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStart() {
        super.modeStart();
        this.mRequestSpeedThrottleController.connectionThrottleStart();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestSpeedThrottleController.connectionThrottleStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.PRIORITY;
    }
}
