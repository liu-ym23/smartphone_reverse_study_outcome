package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$scan$$inlined$unsafeFlow$1", f = "Transform.kt", l = {114, 116}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 j;
        public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Ref.ObjectRef o;

        public AnonymousClass1(FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.j.a(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r7, Continuation r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L17;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ResultKt.b(r9);
        return Unit.f330a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r6 = r0.o;
        r7 = r0.n;
        Continuation r4 = r0.m;
        FlowCollector r5 = r0.l;
        FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 r10 = r0.k;
        ResultKt.b(r9);
        Ref.ObjectRef r11 = r6;
        FlowKt__TransformKt$scan$$inlined$unsafeFlow$1 this = r10;
    L21:
        this.getClass();
        r0.k = this;
        r0.l = r5;
        r0.m = r4;
        r0.n = r7;
        r0.o = r11;
        r0.i = 2;
        throw null;
    L17:
        ResultKt.b(r9);
        r11 = new Ref.ObjectRef();
        r11.b = null;
        r0.k = this;
        r0.l = r7;
        r0.m = r0;
        r0.n = r7;
        r0.o = r11;
        r0.i = 1;
        if (r7.d(null, r0) != r2) goto L20;
        return r2;
    L20:
        r5 = r7;
        r4 = r0;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
