package com.bytedance.ttnet.priority;

import a.a;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ModeNormalDelay extends TTHttpCallPriorityControl.BaseModeControl {
    private static final String KEY_BL_WITH_DELAY_MS = "bl_with_delay_ms";
    private static final String KEY_DELAY_TIME_MS = "delay_time_ms";
    private static final String KEY_WL = "wl";
    private final Map<String, Integer> mBlackList;
    private final RequestDropController mDropController;
    private final Set<String> mWhiteList;
    private int mWhiteListDelayTimeMs;

    public ModeNormalDelay() {
        this.mDropController = new RequestDropController();
        this.mBlackList = new ConcurrentHashMap();
        this.mWhiteList = new CopyOnWriteArraySet();
        this.mWhiteListDelayTimeMs = 1000;
    }

    private int getDelayTimeOrRaiseDroppedByThrottleControlException(Request r3) {
        this.mDropController.raiseExceptionIfDrop(r3);
        if (this.mBlackList.isEmpty() == true) goto L9;
        Integer r2 = TTHttpCallPriorityControl.getMapValueIfMatch(this.mBlackList, r3.getPath());
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    L9:
        if (this.mWhiteList.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (TTHttpCallPriorityControl.isMatch(this.mWhiteList, r3.getPath()) == false) goto L13;
        return 0;
    L13:
        return this.mWhiteListDelayTimeMs;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public boolean initWithTncConfig(JSONObject r6) {
        super.initWithTncConfig(r6);
        if (r6.isNull(KEY_BL_WITH_DELAY_MS) == true) goto L5;
    L7:
        this.mDropController.initWithTncConfig(r6);
        this.mRequestDelayController.initWithTncConfig(r6, this.mStateName);
        JSONObject r0 = r6.optJSONObject(KEY_BL_WITH_DELAY_MS);
        if (r0 == null) goto L13;
        Iterator<String> r7 = r0.keys();
    L11:
        if (r7.hasNext() == false) goto L24;
        String r1 = r7.next();
        this.mBlackList.put(r1, Integer.valueOf(r0.optInt(r1)));
    L24:
        if (this.mDropController.isValid() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.mBlackList.isEmpty() == false) goto L29;
        if (this.mWhiteList.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r2 = r6.optJSONArray(KEY_WL);
        if (r2 == null) goto L22;
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L22;
        String r4 = r2.optString(r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.mWhiteList.add(r4);
    L21:
        r3 = r3 + 1;
    L22:
        this.mWhiteListDelayTimeMs = r6.optInt(KEY_DELAY_TIME_MS, 1000);
        goto L24
    L5:
        if (r6.isNull(KEY_WL) == false) goto L7;
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        long r4 = getDelayTimeOrRaiseDroppedByThrottleControlException(r10);
        if (Logger.debug() == false) goto L6;
        StringBuilder r0 = a.s("get normal delay time ", r4, " ");
        r0.append(r10.getPath());
        Logger.d("ModeNormalDelay", r0.toString());
    L6:
        return this.mRequestDelayController.requestAsyncDelay(r10, false, r4, r13, r12, r11);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r9, RetrofitMetrics r10) {
        long r5 = getDelayTimeOrRaiseDroppedByThrottleControlException(r9);
        if (Logger.debug() == false) goto L5;
        StringBuilder r0 = a.s("get normal delay time ", r5, " ");
        r0.append(r9.getPath());
        Logger.d("ModeNormalDelay", r0.toString());
    L5:
        this.mRequestDelayController.requestBlockingDelay(r9, false, true, r5, r10);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public void modeStop() {
        super.modeStop();
        this.mRequestDelayController.releaseAllDelayedRequests();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl
    public TTHttpCallPriorityControl.ModeType modeType() {
        return TTHttpCallPriorityControl.ModeType.NORMAL_DELAY;
    }
}
