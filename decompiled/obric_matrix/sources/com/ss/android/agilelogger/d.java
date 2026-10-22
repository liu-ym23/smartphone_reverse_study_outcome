package com.ss.android.agilelogger;

/* JADX INFO: loaded from: classes2.dex */
class d implements com.bytedance.android.alog.b {
    d() {
    }

    @Override // com.bytedance.android.alog.b
    public void loadLibrary(String r1) {
        d.b.j.a.b("alog", ALog.sConfig.b());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("alog");
    }
}
