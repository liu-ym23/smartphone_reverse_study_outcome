package com.bytedance.apm.core;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDynamicParams implements IDynamicParams {
    public DefaultDynamicParams() {
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public Map<String, String> getCommonParams() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public long getUid() {
        return 0;
    }
}
