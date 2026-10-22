package com.bytedance.frameworks.baselib.network.http.storeregion;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface StoreRegionBridge {
    void onStoreIdcChanged(String r1, String r2, String r3, String r4, String r5, String r6);

    void sendFeedbackLog(String r1, String r2);

    boolean updateTncConfig(JSONObject r1, String r2, String r3, boolean r4);
}
