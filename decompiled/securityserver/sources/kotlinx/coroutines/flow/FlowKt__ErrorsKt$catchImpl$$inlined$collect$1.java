package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1", f = "Errors.kt", l = {134}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 j;
        public FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 k;
        public Object l;
        public Object m;

        public AnonymousClass1(FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.j.d(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r5, Continuation r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        int r2 = r0.i;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r4 = r0.k;
        ResultKt.b(r7);     // Catch: Throwable -> L20
        return Unit.f330a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.b(r7);
        r0.k = this;     // Catch: Throwable -> L20
        r0.l = r5;     // Catch: Throwable -> L20
        r0.getClass();     // Catch: Throwable -> L20
        r0.m = r5;     // Catch: Throwable -> L20
        r0.i = 1;     // Catch: Throwable -> L20
        throw null;     // Catch: Throwable -> L20
    L20:
        getClass();
        throw null;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
