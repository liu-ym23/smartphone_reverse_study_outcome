package com.bytedance.blockframework.framework.performance;

import android.os.Handler;
import com.bytedanceos.cloud.SecurityPackageWhiteListService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HandlerProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/blockframework/framework/performance/HandlerProcessor;", "", "handler", "Landroid/os/Handler;", SecurityPackageWhiteListService.ACTION_SYNC, "", "(Landroid/os/Handler;Z)V", "post", "", "runnable", "Lkotlin/Function0;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HandlerProcessor {
    private final Handler handler;
    private final boolean sync;

    /* JADX INFO: renamed from: $r8$lambda$ShZe2_nTuL3apOkj6v8uj6Rfx-0, reason: not valid java name */
    public static /* synthetic */ void m69$r8$lambda$ShZe2_nTuL3apOkj6v8uj6Rfx0(Function0 r0) {
        post$lambda$0(r0);
    }

    public HandlerProcessor(Handler r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.handler = r2;
        this.sync = r3;
    }

    public final void post(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (this.sync == false) goto L5;
        r2.invoke();
        return;
    L5:
        this.handler.post(new HandlerProcessor$$ExternalSyntheticLambda0(r2));
    }

    private static final void post$lambda$0(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke();
    }
}
