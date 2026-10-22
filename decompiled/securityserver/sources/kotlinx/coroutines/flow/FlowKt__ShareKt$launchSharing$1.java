package kotlinx.coroutines.flow;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {HttpStatus.SC_PARTIAL_CONTENT, 210, 211, 217}, m = "invokeSuspend")
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        public int i;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation f(Object r2, Continuation r3) {
            AnonymousClass1 r1 = new AnonymousClass1(2, r3);
            Number r4 = (Number) r2;
            r4.intValue();
            r1.i = r4.intValue();
            return r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r1) {
            ResultKt.b(r1);
            if (this.i <= 0) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            return ((AnonymousClass1) f(r1, (Continuation) r2)).i(Unit.f330a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {219}, m = "invokeSuspend")
    final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        public SharingCommand i;
        public final /* synthetic */ FlowKt__ShareKt$launchSharing$1 j;

        public AnonymousClass2(FlowKt__ShareKt$launchSharing$1 r1, Continuation r2) {
            this.j = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation f(Object r2, Continuation r3) {
            AnonymousClass2 r0 = new AnonymousClass2(this.j, r3);
            r0.i = (SharingCommand) r2;
            return r0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            ResultKt.b(r2);
            int r1 = this.i.ordinal();
            if (r1 != 0) goto L5;
            throw null;
        L5:
            if (r1 != 2) goto L7;
            throw null;
        L7:
            return Unit.f330a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            return ((AnonymousClass2) f(r1, (Continuation) r2)).i(Unit.f330a);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r1) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((FlowKt__ShareKt$launchSharing$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
