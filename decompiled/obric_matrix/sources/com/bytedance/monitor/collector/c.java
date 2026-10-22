package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public c(int r2) {
        super(r2, "atrace_event");
    }

    private String g() {
        if (k.p == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtrace();
    }

    private String h(long r1, long r3) {
        if (k.p == true) goto L7;
        return null;
    L7:
        return MonitorJni.doDumpAtraceRange(r1, r3);
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> a() {
    L8:
        return null;
    L4:
        if (k.p == true) goto L6;
        return null;
    L6:
        return new Pair(this.f5108a, g());
    }

    @Override // com.bytedance.monitor.collector.b
    Pair<String, ?> b(long r4, long r6) {
    L8:
        return null;
    L4:
        if (k.p == true) goto L6;
        return null;
    L6:
        return new Pair(this.f5108a, h(r4, r6));
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r1) {
    }

    public void i(long r2) {
        if (k.p == true) goto L5;
        return;
    L5:
        MonitorJni.doEnableAtrace(this.f5110c, r2);     // Catch: Throwable -> L7
        return;
    }
}
