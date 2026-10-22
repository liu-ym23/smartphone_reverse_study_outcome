package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$2 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r1) {
            this.f = r1;
            throw null;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 implements FlowCollector<Object> {

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2$1, reason: invalid class name */
        @Metadata
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$2$2", f = "Transform.kt", l = {134, 134}, m = "emit")
        public final class AnonymousClass1 extends ContinuationImpl {
            public /* synthetic */ Object f;
            public int i;
            public final /* synthetic */ AnonymousClass2 j;
            public AnonymousClass2 k;
            public Object l;
            public AnonymousClass1 m;
            public Object n;
            public Continuation o;
            public Object p;
            public FlowCollector q;

            public AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
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
        public final Object d(Object r10, Continuation r11) {
            Unit r12 = Unit.f330a;
            if ((r11 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) r11;
            int r1 = r0.i;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.i = r1 - Integer.MIN_VALUE;
        L8:
            Object r9 = r0.f;
            CoroutineSingletons r13 = CoroutineSingletons.b;
            int r2 = r0.i;
            if (r2 != 0) goto L11;
            ResultKt.b(r9);
            throw null;
        L11:
            if (r2 == 1) goto L16;
            if (r2 != 2) goto L15;
            ResultKt.b(r9);
        L21:
            return r12;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            FlowCollector r3 = r0.q;
            Object r4 = r0.p;
            Continuation r5 = r0.o;
            Object r6 = r0.n;
            AnonymousClass1 r7 = r0.m;
            Object r8 = r0.l;
            AnonymousClass2 r14 = r0.k;
            ResultKt.b(r9);
            if (((Boolean) r9).booleanValue() == false) goto L21;
            r0.k = r14;
            r0.l = r8;
            r0.m = r7;
            r0.n = r6;
            r0.o = r5;
            r0.p = r4;
            r0.q = r3;
            r0.i = 2;
            if (r3.d(r4, r0) != r13) goto L21;
            return r13;
        L7:
            r0 = new AnonymousClass1(this, r11);
            goto L8
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }
}
