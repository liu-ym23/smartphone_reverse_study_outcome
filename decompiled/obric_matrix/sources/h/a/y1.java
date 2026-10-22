package h.a;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class y1 extends CancellationException implements e0<y1> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x1 f17590f;

    public y1(String r1, Throwable r2, x1 r3) {
        super(r1);
        this.f17590f = r3;
        if (r2 == null) goto L6;
        initCause(r2);
        return;
    }

    @Override // h.a.e0
    public /* bridge */ /* synthetic */ Throwable a() {
        return b();
    }

    public y1 b() {
        if (q0.c() == false) goto L6;
        String r1 = getMessage();
        kotlin.n0.d.o.c(r1);
        return new y1(r1, this, this.f17590f);
    L6:
        return null;
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L4;
    L13:
        return true;
    L4:
        if ((r3 instanceof y1) == false) goto L12;
        y1 r4 = (y1) r3;
        if (kotlin.n0.d.o.a(r4.getMessage(), getMessage()) == false) goto L12;
        if (kotlin.n0.d.o.a(r4.f17590f, this.f17590f) == false) goto L12;
        if (kotlin.n0.d.o.a(r4.getCause(), getCause()) == true) goto L13;
    L12:
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (q0.c() == true) goto L5;
        setStackTrace(new StackTraceElement[0]);
        return this;
    L5:
        return super.fillInStackTrace();
    }

    public int hashCode() {
        String r0 = getMessage();
        kotlin.n0.d.o.c(r0);
        int r1 = ((r0.hashCode() * 31) + this.f17590f.hashCode()) * 31;
        Throwable r2 = getCause();
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f17590f;
    }
}
