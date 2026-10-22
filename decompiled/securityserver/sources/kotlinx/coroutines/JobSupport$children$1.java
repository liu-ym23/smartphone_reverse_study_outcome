package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {949, 951}, m = "invokeSuspend")
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    public SequenceScope c;
    public Object e;
    public NodeList f;
    public LockFreeLinkedListHead i;
    public LockFreeLinkedListNode j;
    public int k;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        if (r1 != 0) goto L5;
        ResultKt.b(r9);
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ResultKt.b(r9);
    L19:
        return Unit.f330a;
    L7:
        if (r1 != 2) goto L16;
        LockFreeLinkedListNode r2 = this.j;
        LockFreeLinkedListHead r4 = this.i;
        NodeList r5 = this.f;
        Object r6 = this.e;
        SequenceScope r7 = this.c;
        ResultKt.b(r9);
    L9:
        r2 = r2.A();
        if ((!r2.equals(r4)) == false) goto L19;
        if ((r2 instanceof ChildHandleNode) == false) goto L9;
        this.c = r7;
        this.e = r6;
        this.f = r5;
        this.i = r4;
        this.j = r2;
        this.k = 2;
        r7.a(((ChildHandleNode) r2).i, this);
        return r0;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((JobSupport$children$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
