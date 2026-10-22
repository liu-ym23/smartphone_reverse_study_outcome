package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ZipKt$combine$$inlined$combine$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$1$3", f = "Zip.kt", l = {337, 337}, m = "invokeSuspend")
    public final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
        public FlowCollector i;
        public Object[] j;
        public FlowCollector k;
        public Object[] l;
        public FlowCollector m;
        public int n;
        public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$1 o;
        public Object[] p;

        public AnonymousClass3(Continuation r1, FlowKt__ZipKt$combine$$inlined$combine$1 r2) {
            this.o = r2;
            super(3, r1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object b(Object r2, Object r3, Object r4) {
            AnonymousClass3 r0 = new AnonymousClass3((Continuation) r4, this.o);
            r0.i = (FlowCollector) r2;
            r0.j = (Object[]) r3;
            return r0.i(Unit.f330a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r6) {
            CoroutineSingletons r0 = CoroutineSingletons.b;
            int r1 = this.n;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.b(r6);
        L13:
            return Unit.f330a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            FlowCollector r2 = this.m;
            Object[] r3 = this.l;
            FlowCollector r4 = this.k;
            ResultKt.b(r6);
            this.k = r4;
            this.l = r3;
            this.n = 2;
            if (r2.d(r6, this) != r0) goto L13;
            return r0;
        L14:
            ResultKt.b(r6);
            FlowCollector r7 = this.i;
            Object[] r5 = this.j;
            this.o.getClass();
            Object r8 = r5[0];
            Object r9 = r5[1];
            Object r10 = r5[2];
            Object r11 = r5[3];
            this.k = r7;
            this.l = r5;
            this.m = r7;
            this.p = r5;
            this.n = 1;
            throw null;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r4, Continuation r5) {
        Object r3 = CombineKt.a(r4, null, new AnonymousClass2(this), new AnonymousClass3(null, this), r5);
        if (r3 != CoroutineSingletons.b) goto L6;
        return r3;
    L6:
        return Unit.f330a;
    }
}
