package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {157}, m = "awaitClose")
final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ProducerScope j;
    public Function0 k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlin.jvm.functions.Function0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        this.f = r5;
        this.i |= Integer.MIN_VALUE;
        ?? r6 = 0;
        r6 = 0;
        if ((this instanceof ProduceKt$awaitClose$1) == false) goto L7;
        int r0 = this.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        this.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r1 = this.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = this.i;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Function0 r7 = this.k;
        ResultKt.b(r1);     // Catch: Throwable -> L14
        r6 = r7;
    L23:
        r6.invoke();
        return Unit.f330a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.b(r1);
        CoroutineContext r4 = this.c;
        Intrinsics.c(r4);
        if (((Job) r4.f(Job.g)) != null) goto L28;
        this.k = null;     // Catch: Throwable -> L14
        this.i = 1;     // Catch: Throwable -> L14
        final CancellableContinuationImpl r8 = new CancellableContinuationImpl(1, IntrinsicsKt.b(this));     // Catch: Throwable -> L14
        r8.D();     // Catch: Throwable -> L14
        r6.E(new ProduceKt$awaitClose$4$1(r8));     // Catch: Throwable -> L14
        if (r8.s() != r2) goto L23;
        return r2;
    L28:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L14:
        th = move-exception;
        r6.invoke();
        throw th;
    L7:
        ProduceKt$awaitClose$1 this = new ProduceKt$awaitClose$1(this);
        goto L8
    }
}
