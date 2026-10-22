package com.monitor.cloudmessage.callback;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IAlogConsumer extends IConsumerResultCallback {
    List<String> handleAlogData(long r1, long r3, JSONObject r5);
}
