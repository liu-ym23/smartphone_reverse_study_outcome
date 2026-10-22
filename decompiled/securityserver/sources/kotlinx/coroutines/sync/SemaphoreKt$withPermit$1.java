package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", l = {85}, m = "withPermit")
public final class SemaphoreKt$withPermit$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Semaphore j;
    public Function0 k;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        this.f = r4;
        int r0 = this.i | Integer.MIN_VALUE;
        this.i = r0;
        int r2 = SemaphoreKt.f448a;
        int r1 = r0 - Integer.MIN_VALUE;
        this.i = r1;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        Function0 r3 = this.k;
        Semaphore r5 = this.j;
        ResultKt.b(r4);
        Object r6 = r3.invoke();     // Catch: Throwable -> L9
        r5.release();
        return r6;
    L9:
        th = move-exception;
        r5.release();
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r4);
        this.j = null;
        this.k = null;
        this.i = 1;
        throw null;
    }
}
