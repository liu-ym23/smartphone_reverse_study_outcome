package com.ss.ttuploader.net;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface DNSCompletionListener {
    void onCancelled();

    void onCompletion(JSONObject r1, Error r2);

    void onRetry(Error r1);
}
