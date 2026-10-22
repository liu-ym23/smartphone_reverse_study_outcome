package kotlinx.coroutines;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {26}, m = "awaitAll")
final class AwaitKt$awaitAll$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        int r4 = this.i | Integer.MIN_VALUE;
        this.i = r4;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L5;
        this.i = r4 - Integer.MIN_VALUE;
    L6:
        Object r5 = this.f;
        int r2 = this.i;
        if (r2 != 0) goto L9;
        ResultKt.b(r5);
        throw null;
    L9:
        if (r2 != 1) goto L13;
        ResultKt.b(r5);
        return (List) r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        AwaitKt$awaitAll$1 this = new AwaitKt$awaitAll$1(this);
        goto L6
    }
}
