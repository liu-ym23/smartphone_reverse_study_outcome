package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        Throwable r2 = (Throwable) r1;
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        ResultKt.a(th);
        return null;
    }
}
