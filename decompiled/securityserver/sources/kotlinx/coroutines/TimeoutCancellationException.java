package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {
    public final Job b;

    public TimeoutCancellationException(String r1, Job r2) {
        super(r1);
        this.b = r2;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        String r1 = getMessage();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        TimeoutCancellationException r0 = new TimeoutCancellationException(r1, this.b);
        r0.initCause(this);
        return r0;
    }
}
