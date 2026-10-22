package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m2970plusAssignLRDsOJo(long r12) {
        long r0 = Duration.m2880toLongimpl(r12, getUnit());
        boolean r5 = true;
        if (((r0 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L13;
        long r2 = this.reading;
        long r6 = r2 + r0;
        if ((r0 ^ r2) >= 0) goto L10;
    L12:
        this.reading = r6;
        return;
    L10:
        if ((r2 ^ r6) >= 0) goto L12;
        m2969overflowLRDsOJo(r12);
        goto L12
    L13:
        long r1 = Duration.m2837divUwyO8pc(r12, 2);
        if ((1 | (Duration.m2880toLongimpl(r1, getUnit()) - 1)) == Long.MAX_VALUE) goto L17;
        r5 = false;
    L17:
        if (r5 == true) goto L24;
        long r3 = this.reading;
        m2970plusAssignLRDsOJo(r1);     // Catch: IllegalStateException -> L21
        m2970plusAssignLRDsOJo(Duration.m2869minusLRDsOJo(r12, r1));     // Catch: IllegalStateException -> L21
        return;
    L21:
        e = move-exception;
        this.reading = r3;
        throw e;
    L24:
        m2969overflowLRDsOJo(r12);
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m2969overflowLRDsOJo(long r5) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + Duration.m2883toStringimpl(r5) + '.');
    }
}
