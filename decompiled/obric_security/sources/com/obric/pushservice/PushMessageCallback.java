package com.obric.pushservice;

import kotlin.Metadata;

/* JADX INFO: compiled from: PushMessageCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/pushservice/PushMessageCallback;", "", "onReceiveMessage", "", "data", "", "messageId", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface PushMessageCallback {
    void onReceiveMessage(String r1, String r2);
}
