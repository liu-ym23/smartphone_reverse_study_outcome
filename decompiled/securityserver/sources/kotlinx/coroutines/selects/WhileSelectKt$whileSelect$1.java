package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", l = {37}, m = "whileSelect")
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Function1 j;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0039 -> B:17:0x003c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        this.f = r5;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        Function1 r2 = this.j;
        ResultKt.b(r5);
    L18:
        if (((Boolean) r5).booleanValue() == false) goto L21;
    L9:
        this.j = r2;
        this.i = 1;
        SelectBuilderImpl r6 = new SelectBuilderImpl(this);
        r2.invoke(r6);     // Catch: Throwable -> L12
    L14:
        r5 = r6.L();
        if (r5 != r1) goto L18;
        return r1;
    L12:
        th = move-exception;
        r6.M(th);
        goto L14
    L21:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r5);
        r2 = null;
        goto L9
    }
}
