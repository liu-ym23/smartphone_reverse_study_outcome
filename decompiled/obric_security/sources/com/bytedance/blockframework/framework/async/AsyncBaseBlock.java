package com.bytedance.blockframework.framework.async;

import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.monitor.BlockLoggerKt;
import com.bytedance.blockframework.framework.monitor.BlockMonitor;
import com.bytedance.blockframework.framework.monitor.BlockMonitorKt;
import com.bytedance.blockframework.framework.performance.ThreadProcessor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncBaseBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ5\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u001c\u0010\f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0004\u0012\u00020\n0\rj\u0002`\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0017\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/blockframework/framework/async/AsyncBaseBlock;", "DATA", "MODEL", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "Lcom/bytedance/blockframework/framework/base/BaseBlock;", "Lcom/bytedance/blockframework/framework/async/IAsyncBind;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "asyncBind", "", "model", "syncInvoke", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lcom/bytedance/blockframework/framework/async/SyncInvoke;", "(Lcom/bytedance/blockframework/framework/core/IBlockModel;Lkotlin/jvm/functions/Function1;)V", "bindModel", "(Lcom/bytedance/blockframework/framework/core/IBlockModel;)V", "recordPref", "type", "", "message", "cost", "", "syncBind", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AsyncBaseBlock<DATA, MODEL extends IBlockModel<DATA>> extends BaseBlock<DATA, MODEL> implements IAsyncBind<MODEL> {
    public static /* synthetic */ void $r8$lambda$1aWy48mGx2HT2koVvbKpZtu_rr8(AsyncBaseBlock r0, IBlockModel r1) {
        bindModel$lambda$4(r0, r1);
    }

    public void asyncBind(MODEL r1, Function1<? super Function0<Unit>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "syncInvoke");
    }

    public void syncBind(MODEL r1) {
    }

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public /* bridge */ /* synthetic */ void asyncBind(Object r1, Function1 r2) {
        asyncBind((IBlockModel) r1, r2);
    }

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public /* bridge */ /* synthetic */ void syncBind(Object r1) {
        syncBind((IBlockModel) r1);
    }

    public AsyncBaseBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void bindModel(final MODEL r13) {
        if (enableAsyncBind() == false) goto L13;
        long r3 = BlockLoggerKt.currentTime();
        recordPref$default(this, BlockMonitorKt.TYPE_BLOCK_BIND, "sync_bind_start", 0, 4, null);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        syncBind(r13);     // Catch: Throwable -> L7
        Object r1 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.m777exceptionOrNullimpl(r1);
        if (r2 == null) goto L12;
        BlockInit.INSTANCE.recordException(r2);
    L12:
        recordPref(BlockMonitorKt.TYPE_BLOCK_BIND, "sync_bind_end", BlockLoggerKt.currentTime() - r3);
        ThreadProcessor.INSTANCE.work().post(new AsyncBaseBlock$$ExternalSyntheticLambda0(this, r13));
        return;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L9
    L13:
        long r4 = BlockLoggerKt.currentTime();
        recordPref$default(this, BlockMonitorKt.TYPE_BLOCK_BIND, "sync_bind_start", 0, 4, null);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        syncBind(r13);     // Catch: Throwable -> L16
        asyncBind(r13, AsyncBaseBlock$bindModel$4$1.INSTANCE);     // Catch: Throwable -> L16
        Object r14 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r15 = Result.m777exceptionOrNullimpl(r14);
        if (r15 == null) goto L21;
        BlockInit.INSTANCE.recordException(r15);
    L21:
        recordPref(BlockMonitorKt.TYPE_BLOCK_BIND, "sync_bind_end", BlockLoggerKt.currentTime() - r4);
        return;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r14 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private static final void bindModel$lambda$4(AsyncBaseBlock r9, IBlockModel r10) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        long r0 = BlockLoggerKt.currentTime();
        recordPref$default(r9, BlockMonitorKt.TYPE_BLOCK_BIND, "async_bind_start", 0, 4, null);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r9.asyncBind(r10, AsyncBaseBlock$bindModel$3$1$1.INSTANCE);     // Catch: Throwable -> L5
        Object r11 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m777exceptionOrNullimpl(r11);
        if (r12 == null) goto L10;
        BlockInit.INSTANCE.recordException(r12);
    L10:
        r9.recordPref(BlockMonitorKt.TYPE_BLOCK_BIND, "async_bind_end", BlockLoggerKt.currentTime() - r0);
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    static /* synthetic */ void recordPref$default(AsyncBaseBlock r0, String r1, String r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        r0.recordPref(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordPref");
    }

    private final void recordPref(String r8, String r9, long r10) {
        BlockMonitor.INSTANCE.record(getBlockContext().getScene().getName(), getBlockKey(), r8, r9, r10);
    }
}
