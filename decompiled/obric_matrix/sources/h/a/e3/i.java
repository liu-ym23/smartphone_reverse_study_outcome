package h.a.e3;

import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class i {

    @kotlin.k0.j.a.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<T> extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f17292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f17293g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f17294h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f17295i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f17296j;

        a(kotlin.k0.d<? super a> r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17295i = r2;
            this.f17296j |= Integer.MIN_VALUE;
            return i.a(null, null, false, this);
        }
    }

    public static final /* synthetic */ Object a(f r0, h.a.d3.v r1, boolean r2, kotlin.k0.d r3) {
        return c(r0, r1, r2, r3);
    }

    public static final <T> Object b(f<? super T> r1, h.a.d3.v<? extends T> r2, kotlin.k0.d<? super f0> r3) {
        Object r4 = c(r1, r2, true, r3);
        if (r4 != kotlin.k0.i.b.c()) goto L6;
        return r4;
    L6:
        return f0.f18324a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [h.a.e3.f, h.a.e3.f<? super T>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v3, types: [h.a.e3.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0094 -> B:14:0x0035). Please report as a decompilation issue!!! */
    private static final <T> Object c(f<? super T> r7, h.a.d3.v<? extends T> r8, boolean r9, kotlin.k0.d<? super f0> r10) {
        if ((r10 instanceof a) == false) goto L7;
        a r0 = (a) r10;
        int r1 = r0.f17296j;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17296j = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f17295i;
        Object r2 = kotlin.k0.i.b.c();
        int r3 = r0.f17296j;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        boolean r12 = (f<? super T>) r0.f17294h;
        r8 = (h.a.d3.v) r0.f17293g;
        f r13 = (f) r0.f17292f;
        kotlin.w.b(r11);     // Catch: Throwable -> L20
        ?? r14 = r12;
        ?? r15 = r13;
    L14:
        ?? r6 = r15;
        ?? r16 = r14;
        ?? r17 = (f<? super T>) r6;
    L49:
        r0.f17292f = r17;     // Catch: Throwable -> L40
        r0.f17293g = r8;     // Catch: Throwable -> L40
        r0.f17294h = r16;     // Catch: Throwable -> L40
        r0.f17296j = 1;     // Catch: Throwable -> L40
        Object r18 = r8.d(r0);     // Catch: Throwable -> L40
        if (r18 != r2) goto L26;
        return r2;
    L26:
        ?? r19 = r16;
        ?? r20 = r17;
        r7 = (f<? super T>) (r19 == true ? 1 : 0 ? 1 : 0);
    L29:
        if (h.a.d3.j.h(r18) == false) goto L37;
        Throwable r21 = h.a.d3.j.e(r18);     // Catch: Throwable -> L20
        if (r21 != null) goto L36;
        if (r7 == 0) goto L35;
        h.a.d3.k.a(r8, null);
    L35:
        return f0.f18324a;
    L36:
        throw r21;     // Catch: Throwable -> L20
    L37:
        h.a.d3.j.f(r18);     // Catch: Throwable -> L20
        r0.f17292f = r20;     // Catch: Throwable -> L20
        r0.f17293g = r8;     // Catch: Throwable -> L20
        r0.f17294h = (boolean) r7;     // Catch: Throwable -> L20
        r0.f17296j = 2;     // Catch: Throwable -> L20
        Object r110 = r20.emit(r18, r0);     // Catch: Throwable -> L20
        r14 = r7;
        r15 = r20;
        if (r110 != r2) goto L14;
        return r2;
    L40:
        th = move-exception;
        ?? r22 = r16;
        th = th;
        r7 = r22 == true ? 1 : 0;
    L51:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r7 == 0) goto L46;
        h.a.d3.k.a(r8, th);
    L46:
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r23 = (f<? super T>) r0.f17294h;
        r8 = (h.a.d3.v) r0.f17293g;
        f r24 = (f) r0.f17292f;
        kotlin.w.b(r11);     // Catch: Throwable -> L20
        r18 = ((h.a.d3.j) r11).k();     // Catch: Throwable -> L20
        r7 = r23;
        r20 = r24;
        goto L29
    L22:
        kotlin.w.b(r11);
        g.f(r7);
        r17 = r7;
        r16 = r9;
    L20:
        th = th;
    L7:
        r0 = new a(r10);
        goto L8
    }
}
