package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__MergeKt$flatMapMerge$$inlined$map$1 implements Flow<Flow<Object>> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 implements FlowCollector<Object> {

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
        @Metadata
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", l = {134, 134}, m = "emit")
        public final class AnonymousClass1 extends ContinuationImpl {
            public /* synthetic */ Object f;
            public int i;
            public AnonymousClass2 j;
            public Object k;
            public AnonymousClass1 l;
            public Object m;
            public AnonymousClass1 n;
            public Object o;
            public FlowCollector p;
            public final /* synthetic */ AnonymousClass2 q;

            public AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
                this.q = r1;
                super(r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object i(Object r2) {
                this.f = r2;
                this.i |= Integer.MIN_VALUE;
                return this.q.d(null, this);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object d(Object r8, Continuation r9) {
            if ((r9 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r10 = (AnonymousClass1) r9;
            int r0 = r10.i;
            if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
            r10.i = r0 - Integer.MIN_VALUE;
        L8:
            Object r7 = r10.f;
            int r11 = r10.i;
            if (r11 != 0) goto L11;
            ResultKt.b(r7);
            throw null;
        L11:
            if (r11 == 1) goto L17;
            if (r11 != 2) goto L16;
            ResultKt.b(r7);
            return Unit.f330a;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            r10.getClass();
            FlowCollector r12 = r10.p;
            Object r1 = r10.o;
            AnonymousClass1 r2 = r10.n;
            Object r3 = r10.m;
            AnonymousClass1 r4 = r10.l;
            Object r5 = r10.k;
            AnonymousClass2 r6 = r10.j;
            ResultKt.b(r7);
            r10.j = r6;
            r10.k = r5;
            r10.l = r4;
            r10.m = r3;
            r10.n = r2;
            r10.o = r1;
            r10.p = r12;
            r10.i = 2;
            throw null;
        L7:
            r10 = new AnonymousClass1(this, r9);
            goto L8
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }
}
