package com.bytedance.apm.agent.instrumentation.okhttp3;

import okhttp3.Call;
import okhttp3.EventListener;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpEventFactory implements EventListener.Factory {
    public EventListener.Factory originFactory;

    public OkHttpEventFactory(EventListener.Factory r1) {
        this.originFactory = r1;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call r1) {
        EventListener.Factory r0 = this.originFactory;
        if (r0 == null) goto L5;
        EventListener r2 = r0.create(r1);
    L7:
        return new OkHttpEventListener(r2);
    L5:
        r2 = null;
        goto L7
    }
}
