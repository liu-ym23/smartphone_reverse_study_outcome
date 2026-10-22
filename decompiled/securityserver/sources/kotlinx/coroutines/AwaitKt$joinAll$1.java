package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {55}, m = "joinAll")
final class AwaitKt$joinAll$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Object[] j;
    public Object[] k;
    public Object[] l;
    public Job m;
    public Job n;
    public int o;
    public int p;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r8) {
        this.f = r8;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r8);
        throw null;
    L5:
        if (r0 != 1) goto L15;
        int r2 = this.p;
        int r3 = this.o;
        Job[] r4 = (Job[]) this.l;
        Job[] r5 = (Job[]) this.k;
        Job[] r6 = (Job[]) this.j;
        ResultKt.b(r8);
    L7:
        r2 = r2 + 1;
        if (r2 >= r3) goto L13;
        Job r9 = r4[r2];
        this.j = r6;
        this.k = r5;
        this.l = r4;
        this.o = r3;
        this.p = r2;
        this.m = r9;
        this.n = r9;
        this.i = 1;
        if (r9.o(this) != r1) goto L7;
        return r1;
    L13:
        return Unit.f330a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
