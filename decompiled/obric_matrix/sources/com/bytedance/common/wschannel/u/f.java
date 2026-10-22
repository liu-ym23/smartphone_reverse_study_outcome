package com.bytedance.common.wschannel.u;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f3821g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3822f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f3823f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f3824g;

        a(f r1, Runnable r2) {
            this.f3824g = r1;
            this.f3823f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f3823f.run();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.e(f.a(), "WsThreadFactory error when running in thread " + f.b(this.f3824g), th);
        }
    }

    static {
        f3821g = f.class.getSimpleName();
    }

    public f(String r3) {
        this.f3822f = "WsChannel-" + r3;
    }

    static /* synthetic */ String a() {
        return f3821g;
    }

    static /* synthetic */ String b(f r0) {
        return r0.f3822f;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f3821g, "creating newThread " + this.f3822f);
    L6:
        return new Thread(new a(this, r4), this.f3822f);
    }
}
