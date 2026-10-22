package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DispatchTypedAction extends URLDispatchAction {
    private static final String TAG = "DispatchTypedAction";
    private DispatchStrategy mDispatchStrategy;

    static {
    }

    public DispatchTypedAction() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest r6, String r7, List<String> r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "dispatch action " + this.mDispatchStrategy.getDispatchStrategyType());
    L5:
        BaseDispatchAction.DispatchResultEnum r0 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri r1 = Uri.parse(r7);
        if (r1.getHost() != null) goto L8;
    L19:
        return r0;
    L8:
        if (isMatchRules(r1) == false) goto L19;
        if (this.mDispatchStrategy == null) goto L19;
        r0 = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        if (this.mDispatchStrategy.getDispatchStrategyType() != DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY) goto L15;
        this.mDispatchStrategy.dispatchRequestHeaders(r6);
        r8.set(0, r7);
        return r0;
    L15:
        String r5 = this.mDispatchStrategy.getTargetUrl(r1);
        if (r7.equals(r5) == true) goto L18;
        r8.set(0, r5);
        goto L19
    L18:
        r8.set(0, r7);
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected void onRequestCompleted(String r1, boolean r2, int r3) {
        this.mDispatchStrategy.notifyRequestResult(r1, r2, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return this.mDispatchStrategy.getDispatchStrategyType().ordinal();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected boolean loadActionParam(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        loadMatchRules(r10);
        String r0 = r10.optString("service_name");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.mServiceName = r0;
    L5:
        int r1 = r10.optInt("dispatch_strategy", 0);
        JSONObject r4 = r10.optJSONObject("strategy_info");
        if (r1 >= 0) goto L8;
    L12:
        this.mDispatchStrategy = null;
        return false;
    L8:
        if (r1 > 6) goto L12;
        DispatchStrategy r14 = DispatchStrategy.factory(DispatchStrategy.DispatchStrategyType.values()[r1], r4, r12, r13, getPriority());
        this.mDispatchStrategy = r14;
        r11.set(0, Boolean.valueOf(r14.needRequestResultFeedback()));
        return true;
    }
}
