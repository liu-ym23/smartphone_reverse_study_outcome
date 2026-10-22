package com.monitor.cloudmessage.callback;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ITemplateConsumer extends IConsumerResultCallback {
    String handleTemplateMessage(JSONObject r1);
}
