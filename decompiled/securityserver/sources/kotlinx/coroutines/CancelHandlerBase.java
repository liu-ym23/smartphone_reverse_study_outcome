package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CancelHandlerBase implements Function1<Throwable, Unit> {
    public abstract void c(Throwable r1);
}
