package com.bytedance.apm6.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface Monitorable {
    String getLogType();

    boolean isValid();

    JSONObject toJsonObject();
}
