package com.obric.pushservice;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;

/* JADX INFO: compiled from: PushTokenCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/pushservice/PushTokenCallback;", "", "onFailed", "", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "onSuccess", "deviceToken", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface PushTokenCallback {
    void onFailed(String r1, String r2);

    void onSuccess(String r1);
}
