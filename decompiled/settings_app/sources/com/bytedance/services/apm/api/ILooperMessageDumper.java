package com.bytedance.services.apm.api;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ILooperMessageDumper {
    JSONObject dumpDispatchingMessage();

    JSONArray dumpHistoryMessages();

    JSONObject dumpMessages();

    JSONArray dumpPendingMessages();
}
