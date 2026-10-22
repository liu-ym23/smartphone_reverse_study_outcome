package com.ttnet.org.chromium.net;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int r1, Object r2, Object r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ProxyChangeListener.a((ProxyChangeListener) this.c, (Intent) this.e);
        return;
    L6:
        NetworkChangeNotifierAutoDetect.a((NetworkChangeNotifierAutoDetect) this.c, (Runnable) this.e);
        return;
    L8:
        ProxyChangeListener.ProxyReceiver.a((ProxyChangeListener.ProxyReceiver) this.c, (Intent) this.e);
    }
}
