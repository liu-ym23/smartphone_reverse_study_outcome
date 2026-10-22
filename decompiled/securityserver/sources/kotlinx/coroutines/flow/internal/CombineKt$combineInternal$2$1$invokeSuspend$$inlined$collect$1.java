package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.YieldContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {
    public final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1 b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1", f = "Combine.kt", l = {133, 134}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 j;
        public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 k;
        public Object l;
        public Continuation m;
        public Object n;

        public AnonymousClass1(CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 r1, Continuation r2) {
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

    public CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(CombineKt$combineInternal$2.AnonymousClass1 r1) {
        this.b = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r8, Continuation r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        Unit r4 = Unit.f330a;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.b(r10);
    L63:
        return r4;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Object r11 = r0.n;
        Continuation r7 = r0.m;
        Object r5 = r0.l;
        CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 r6 = r0.k;
        ResultKt.b(r10);
        Object r12 = r11;
        Continuation r13 = r7;
        CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 this = r6;
    L20:
        r0.k = this;
        r0.l = r5;
        r0.m = r13;
        r0.n = r12;
        r0.i = 2;
        CoroutineContext r14 = r0.c;
        Intrinsics.c(r14);
        Job r15 = (Job) r14.f(Job.g);
        if (r15 != null) goto L23;
    L27:
        Continuation r16 = IntrinsicsKt.b(r0);
        if ((r16 instanceof DispatchedContinuation) == true) goto L30;
        r16 = null;
    L30:
        DispatchedContinuation r17 = (DispatchedContinuation) r16;
        if (r17 == null) goto L57;
        CoroutineDispatcher r18 = r17.k;
        if (r18.l() == false) goto L35;
        r17.f = r4;
        r17.e = 1;
        r18.k(r14, r17);
    L45:
        Object r19 = r2;
    L58:
        if (r19 == r2) goto L61;
        r19 = r4;
    L61:
        if (r19 != r2) goto L63;
        return r2;
    L35:
        YieldContext r20 = new YieldContext(YieldContext.e);
        CoroutineContext r21 = r14.i(r20);
        r17.f = r4;
        r17.e = 1;
        r18.k(r21, r17);
        if (r20.c == false) goto L45;
        boolean r22 = DebugKt.f370a;
        EventLoop r23 = ThreadLocalEventLoop.a();
        ArrayQueue r24 = r23.i;
        if (r24 == null) goto L57;
        if (r24.b == r24.c) goto L57;
        if (r23.u() == false) goto L46;
        r17.f = r4;
        r17.e = 1;
        r23.n(r17);
        goto L45
    L46:
        r23.s(true);
        r17.run();     // Catch: Throwable -> L51
    L48:
        if (r23.w() == true) goto L48;
    L50:
        r23.m();
    L51:
        th = move-exception;
        r17.h(th, null);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r23.m();
        throw th;
    L57:
        r19 = r4;
        goto L58
    L23:
        if (r15.isActive() == true) goto L27;
        throw r15.q();
    L16:
        ResultKt.b(r10);
        CombineKt$combineInternal$2.AnonymousClass1 r25 = this.b;
        Channel r26 = r25.o;
        IndexedValue r27 = new IndexedValue(r25.n, r8);
        r0.k = this;
        r0.l = r8;
        r0.m = r0;
        r0.n = r8;
        r0.i = 1;
        if (r26.I(r27, r0) != r2) goto L19;
        return r2;
    L19:
        r12 = r8;
        r5 = r12;
        r13 = r0;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }
}
