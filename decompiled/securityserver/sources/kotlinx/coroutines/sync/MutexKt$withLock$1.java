package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", l = {114}, m = "withLock")
public final class MutexKt$withLock$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Mutex j;
    public Object k;
    public Function0 l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        Function0 r1 = this.l;
        Object r2 = this.k;
        Mutex r4 = this.j;
        ResultKt.b(r3);
        Object r5 = r1.invoke();     // Catch: Throwable -> L9
        r4.a(r2);
        return r5;
    L9:
        th = move-exception;
        r4.a(r2);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r3);
        this.j = null;
        this.k = null;
        this.l = null;
        this.i = 1;
        throw null;
    }
}
