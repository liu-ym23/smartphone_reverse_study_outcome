package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import android.os.Handler;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCushionThreadExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionThreadExecutor;", "", "()V", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getIoExecutor", "()Ljava/util/concurrent/ExecutorService;", "ioExecutor$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "executeOnIO", "", "task", "Ljava/lang/Runnable;", "runOnMain", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeCushionThreadExecutor {
    public static final SafeCushionThreadExecutor INSTANCE = null;
    private static final Lazy ioExecutor$delegate = null;
    private static final Lazy mainHandler$delegate = null;

    private SafeCushionThreadExecutor() {
    }

    static {
        INSTANCE = new SafeCushionThreadExecutor();
        mainHandler$delegate = LazyKt.lazy(SafeCushionThreadExecutor$mainHandler$2.INSTANCE);
        ioExecutor$delegate = LazyKt.lazy(SafeCushionThreadExecutor$ioExecutor$2.INSTANCE);
    }

    private final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }

    private final ExecutorService getIoExecutor() {
        return (ExecutorService) ioExecutor$delegate.getValue();
    }

    public final void executeOnIO(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        getIoExecutor().execute(r2);
    }

    public final void runOnMain(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        getMainHandler().post(r2);
    }
}
