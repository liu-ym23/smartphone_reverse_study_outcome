package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u000f"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, PerfConsts.KEY_CURRENT_CAPACITY, "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ContextKt {
    public static /* synthetic */ Flow buffer$default(Flow r0, int r1, BufferOverflow r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = -2;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = BufferOverflow.SUSPEND;
    L9:
        return FlowKt.buffer(r0, r1, r2);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> r9, int r10, BufferOverflow r11) {
        boolean r0 = true;
        if (r10 < 0) goto L5;
    L9:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L28;
        if (r10 == (-1)) goto L13;
    L16:
        if (r0 == false) goto L26;
        if (r10 != (-1)) goto L19;
        BufferOverflow r6 = BufferOverflow.DROP_OLDEST;
        int r5 = 0;
    L21:
        if ((r9 instanceof FusibleFlow) == false) goto L24;
        return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) r9, null, r5, r6, 1, null);
    L24:
        return new ChannelFlowOperatorImpl(r9, null, r5, r6, 2, null);
    L19:
        r5 = r10;
        r6 = r11;
        goto L21
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L13:
        if (r11 == BufferOverflow.SUSPEND) goto L16;
        r0 = false;
        goto L16
    L28:
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r10).toString());
    L5:
        if (r10 == (-2)) goto L9;
        if (r10 == (-1)) goto L9;
        r3 = false;
        goto L10
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Flow buffer(Flow r2, int r3) {
        return FlowKt.buffer$default(r2, r3, null, 2, null);
    }

    public static /* synthetic */ Flow buffer$default(Flow r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = -2;
    L6:
        return FlowKt.buffer(r0, r1);
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> r3) {
        return FlowKt.buffer$default(r3, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> flowOn(Flow<? extends T> r8, CoroutineContext r9) {
        checkFlowContext$FlowKt__ContextKt(r9);
        if (Intrinsics.areEqual(r9, EmptyCoroutineContext.INSTANCE) == false) goto L6;
        return r8;
    L6:
        if ((r8 instanceof FusibleFlow) == false) goto L9;
        return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) r8, r9, 0, null, 6, null);
    L9:
        return new ChannelFlowOperatorImpl(r8, r9, 0, null, 12, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> cancellable(Flow<? extends T> r1) {
        if ((r1 instanceof CancellableFlow) == false) goto L6;
        return r1;
    L6:
        return new CancellableFlowImpl(r1);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext r2) {
        if (r2.get(Job.Key) != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r2).toString());
    L5:
        r0 = false;
        goto L6
    }
}
