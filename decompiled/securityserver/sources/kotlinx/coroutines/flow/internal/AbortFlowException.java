package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AbortFlowException extends CancellationException {
    public final FlowCollector b;

    public AbortFlowException(FlowCollector r2) {
        super("Flow was aborted, no more elements needed");
        this.b = r2;
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
