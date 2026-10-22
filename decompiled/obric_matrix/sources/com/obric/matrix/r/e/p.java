package com.obric.matrix.r.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class p extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WeakReference<a> f9950a;

    public interface a {
        void handleMsg(Message r1);
    }

    public p(Looper r1, a r2) {
        super(r1);
        this.f9950a = new WeakReference(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r1) {
        a r0 = this.f9950a.get();
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.handleMsg(r1);
        return;
    L8:
        return;
    }
}
