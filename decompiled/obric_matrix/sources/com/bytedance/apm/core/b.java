package com.bytedance.apm.core;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    Map<String, String> getCommonParams();

    String getSessionId();

    long getUid();
}
