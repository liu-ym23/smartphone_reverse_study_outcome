package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StaticDispatchStrategy extends DispatchStrategy {
    private static final String TAG = "StaticDispatchStrategy";
    private Map<String, String> mHostMap;

    static {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String r1, boolean r2, int r3) {
    }

    public StaticDispatchStrategy(JSONObject r5) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.mHostMap = new HashMap();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mHostMap.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri r5) {
        String r0 = r5.getHost();
        String r6 = r5.toString();
        String r4 = this.mHostMap.get(r0);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r6;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "replace host " + r4 + " for " + r0);
    L8:
        return r6.replaceFirst(r0, r4);
    }
}
