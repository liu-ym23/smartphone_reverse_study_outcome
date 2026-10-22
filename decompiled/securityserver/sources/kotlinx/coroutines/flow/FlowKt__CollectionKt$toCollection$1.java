package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", l = {32}, m = "toCollection")
final class FlowKt__CollectionKt$toCollection$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Collection k;
    public Flow l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        Collection r2 = this.k;
        ResultKt.b(r3);
        return r2;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.b(r3);
        this.k = null;
        this.i = 1;
        throw null;
    }
}
