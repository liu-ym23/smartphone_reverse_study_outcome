package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes.dex */
public interface LocationUploadCallback {
    void onError(String r1);

    void onSuccess(LocationResp r1);
}
