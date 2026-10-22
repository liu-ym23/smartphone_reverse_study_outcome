package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {
    public final Job b;

    public JobCancellationException(String r1, Throwable r2, Job r3) {
        super(r1);
        this.b = r3;
        if (r2 == null) goto L6;
        initCause(r2);
        return;
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final Throwable a() {
        if (DebugKt.f370a == false) goto L5;
        String r1 = getMessage();
        Intrinsics.c(r1);
        return new JobCancellationException(r1, this, this.b);
    L5:
        return null;
    }

    public final boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r3 instanceof JobCancellationException) == false) goto L12;
        JobCancellationException r4 = (JobCancellationException) r3;
        if (Intrinsics.a(r4.getMessage(), getMessage()) == false) goto L12;
        if (Intrinsics.a(r4.b, this.b) == false) goto L12;
        if (Intrinsics.a(r4.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        if (DebugKt.f370a == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return this;
    L5:
        return super.fillInStackTrace();
    }

    public final int hashCode() {
        String r0 = getMessage();
        Intrinsics.c(r0);
        int r1 = r0.hashCode() * 31;
        int r2 = (this.b.hashCode() + r1) * 31;
        Throwable r3 = getCause();
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L7:
        return r2 + r4;
    L5:
        r4 = 0;
        goto L7
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.b;
    }
}
