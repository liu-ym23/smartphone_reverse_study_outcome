package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", l = {308}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends Lambda implements Function0<Object[]> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", l = {308}, m = "invokeSuspend")
    public final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
        public FlowCollector i;
        public Object[] j;
        public final /* synthetic */ FlowKt__ZipKt$combineTransform$7 k;

        public AnonymousClass2(FlowKt__ZipKt$combineTransform$7 r1, Continuation r2) {
            this.k = r1;
            super(3, r2);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object b(Object r2, Object r3, Object r4) {
            FlowKt__ZipKt$combineTransform$7 r1 = this.k;
            AnonymousClass2 r0 = new AnonymousClass2(r1, (Continuation) r4);
            r0.i = (FlowCollector) r2;
            r0.j = (Object[]) r3;
            return r0.i(Unit.f330a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r1) {
            ResultKt.b(r1);
            throw null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r1) {
        ResultKt.b(r1);
        Intrinsics.l();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        FlowKt__ZipKt$combineTransform$7 r0 = (FlowKt__ZipKt$combineTransform$7) f(r1, (Continuation) r2);
        Unit r3 = Unit.f330a;
        r0.i(r3);
        return r3;
    }
}
