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
public final class FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 implements FlowCollector<Object> {

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        @Metadata
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {134, 135}, m = "emit")
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
        public final Object d(Object r9, Continuation r10) {
            if ((r10 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r11 = (AnonymousClass1) r10;
            int r0 = r11.i;
            if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
            r11.i = r0 - Integer.MIN_VALUE;
        L8:
            Object r8 = r11.f;
            CoroutineSingletons r12 = CoroutineSingletons.b;
            int r1 = r11.i;
            if (r1 != 0) goto L11;
            ResultKt.b(r8);
            throw null;
        L11:
            if (r1 == 1) goto L16;
            if (r1 != 2) goto L15;
            ResultKt.b(r8);
        L20:
            return Unit.f330a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            FlowCollector r2 = r11.q;
            Object r3 = r11.p;
            Continuation r4 = r11.o;
            Object r5 = r11.n;
            AnonymousClass1 r6 = r11.m;
            Object r7 = r11.l;
            AnonymousClass2 r13 = r11.k;
            ResultKt.b(r8);
            r11.k = r13;
            r11.l = r7;
            r11.m = r6;
            r11.n = r5;
            r11.o = r4;
            r11.p = r3;
            r11.q = r2;
            r11.i = 2;
            if (r2.d(r3, r11) != r12) goto L20;
            return r12;
        L7:
            r11 = new AnonymousClass1(this, r10);
            goto L8
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }
}
