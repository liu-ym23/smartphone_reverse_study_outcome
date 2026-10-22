package com.bytedance.apm.f0;

import android.os.Build;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f1518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f1519b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1520f;

        a(d r1) {
            this.f1520f = r1;
        }

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
        L6:
            ((Runnable) d.a(this.f1520f).take()).run();     // Catch: InterruptedException -> L4
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }
    }

    public d(String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        BlockingQueue<Runnable> r0 = new LinkedTransferQueue();
    L6:
        this.f1519b = r0;
        this.f1518a = new Thread(new a(this), r3);
        return;
    L5:
        r0 = new LinkedBlockingQueue();
        goto L6
    }

    static /* synthetic */ BlockingQueue a(d r0) {
        return r0.f1519b;
    }

    public final boolean b(Runnable r1) {
        return this.f1519b.offer(r1);
    }

    public void c() {
        this.f1518a.start();
    }
}
