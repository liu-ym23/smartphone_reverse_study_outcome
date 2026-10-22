package h.a.e3.b0;

import h.a.f3.d0;
import h.a.x1;
import kotlin.Metadata;
import kotlin.n0.c.p;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0005\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class j {

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements p<Integer, kotlin.k0.g.b, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h<?> f17281f;

        a(h<?> r1) {
            this.f17281f = r1;
            super(2);
        }

        public final Integer a(int r3, kotlin.k0.g.b r4) {
            kotlin.k0.g.c<?> r0 = r4.getKey();
            kotlin.k0.g.b r2 = this.f17281f.f17274g.get(r0);
            if (r0 == x1.f17584d) goto L9;
            if (r4 == r2) goto L6;
            int r5 = Integer.MIN_VALUE;
        L8:
            return Integer.valueOf(r5);
        L6:
            r5 = r3 + 1;
            goto L8
        L9:
            x1 r6 = (x1) r2;
            x1 r7 = j.b((x1) r4, r6);
            if (r7 != r6) goto L17;
            if (r6 == null) goto L15;
            r3 = r3 + 1;
        L15:
            return Integer.valueOf(r3);
        L17:
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + r7 + ", expected child of " + r6 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer r1, kotlin.k0.g.b r2) {
            return a(r1.intValue(), r2);
        }
    }

    public static final void a(h<?> r3, kotlin.k0.g r4) {
        if (((Number) r4.fold(0, new a(r3))).intValue() != r3.f17275h) goto L6;
        return;
    L6:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + r3.f17274g + ",\n\t\tbut emission happened in " + r4 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final x1 b(x1 r1, x1 r2) {
    L2:
        if (r1 == null) goto L3;
        if (r1 == r2) goto L6;
        if ((r1 instanceof d0) == false) goto L9;
        r1 = ((d0) r1).P0();
        goto L2
    L9:
        return r1;
    L6:
        return r1;
    L3:
        return null;
    }
}
