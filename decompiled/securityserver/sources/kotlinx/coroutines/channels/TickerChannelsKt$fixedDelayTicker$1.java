package kotlinx.coroutines.channels;

import com.ss.android.common.ApiConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", l = {ApiConstants.OP_ERROR_NAME_EXISTED, 108, 109}, m = "fixedDelayTicker")
final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public long j;
    public long k;
    public SendChannel l;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0082 -> B:22:0x0065). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r12) {
        this.f = r12;
        this.i |= Integer.MIN_VALUE;
        SendChannel r13 = null;
        if ((this instanceof TickerChannelsKt$fixedDelayTicker$1) == false) goto L7;
        int r0 = this.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        this.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r1 = this.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = this.i;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r13 = this.l;
        long r5 = this.k;
        long r7 = this.j;
        ResultKt.b(r1);
    L25:
        this.j = r7;
        this.k = r5;
        this.l = r13;
        this.i = 3;
        if (DelayKt.a(r7, this) == r2) goto L28;
    L22:
        Unit r4 = Unit.f330a;
        this.j = r7;
        this.k = r5;
        this.l = r13;
        this.i = 2;
        if (r13.I(r4, this) != r2) goto L25;
    L28:
        return CoroutineSingletons.b;
    L17:
        r13 = this.l;
        r5 = this.k;
        r7 = this.j;
        ResultKt.b(r1);
        goto L22
    L18:
        ResultKt.b(r1);
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.i = 1;
        if (DelayKt.a(0, this) == r2) goto L28;
        r7 = 0;
        r5 = 0;
    L7:
        TickerChannelsKt$fixedDelayTicker$1 this = new TickerChannelsKt$fixedDelayTicker$1(this);
        goto L8
    }
}
