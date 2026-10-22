package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CommonPool$shutdown$2 implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r1) {
        throw new RejectedExecutionException("CommonPool was shutdown");
    }
}
