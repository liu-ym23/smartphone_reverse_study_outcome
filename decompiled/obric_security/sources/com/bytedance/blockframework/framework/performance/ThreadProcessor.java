package com.bytedance.blockframework.framework.performance;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/blockframework/framework/performance/ThreadProcessor;", "", "()V", "BLOCK_WORK_THREAD_LABEL", "", "mainHandler", "Landroid/os/Handler;", "workHandler", "main", "post", "", "runnable", "Lkotlin/Function0;", "setWork", "handler", "work", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreadProcessor {
    public static final String BLOCK_WORK_THREAD_LABEL = "Block_WorkThread";
    public static final ThreadProcessor INSTANCE = null;
    private static final Handler mainHandler = null;
    private static volatile Handler workHandler;

    public static /* synthetic */ void $r8$lambda$NRpzcqvTzqhVHWoSf6YLM2orrZY(Function0 r0) {
        post$lambda$1(r0);
    }

    private ThreadProcessor() {
    }

    static {
        INSTANCE = new ThreadProcessor();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public final Handler work() {
        if (workHandler != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (workHandler != null) goto L8;
        HandlerThread r0 = new HandlerThread(BLOCK_WORK_THREAD_LABEL);     // Catch: Throwable -> L11
        r0.start();     // Catch: Throwable -> L11
        workHandler = new Handler(r0.getLooper());     // Catch: Throwable -> L11
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        Handler r2 = workHandler;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("workHandler");
        return null;
    L20:
        return r2;
    }

    public final Handler main() {
        return mainHandler;
    }

    public final void setWork(Handler r1) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        workHandler = r1;
    }

    private static final void post$lambda$1(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }

    public final void post(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        work().post(new ThreadProcessor$$ExternalSyntheticLambda0(r2));
    }
}
