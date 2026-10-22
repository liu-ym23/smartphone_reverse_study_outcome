package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChildCancelledException extends CancellationException {
    public ChildCancelledException() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        if (DebugKt.f370a == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return this;
    L5:
        return super.fillInStackTrace();
    }
}
