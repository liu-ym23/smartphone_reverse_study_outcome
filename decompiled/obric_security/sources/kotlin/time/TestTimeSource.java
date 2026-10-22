package kotlin.time;

import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", ProviderConstants.Sms.READ, "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m2235plusAssignLRDsOJo(long r9) {
        long r0 = Duration.m2146toLongimpl(r9, getUnit());
        if (r0 != Long.MIN_VALUE) goto L5;
    L11:
        double r2 = this.reading + Duration.m2143toDoubleimpl(r9, getUnit());
        if (r2 <= 9.223372036854776E18d) goto L14;
    L15:
        m2234overflowLRDsOJo(r9);
    L16:
        long r4 = (long) r2;
    L17:
        this.reading = r4;
        return;
    L14:
        if (r2 >= (-9.223372036854776E18d)) goto L16;
    L5:
        if (r0 == Long.MAX_VALUE) goto L11;
        long r3 = this.reading;
        r4 = r3 + r0;
        if ((r0 ^ r3) < 0) goto L17;
        if ((r3 ^ r4) >= 0) goto L17;
        m2234overflowLRDsOJo(r9);
        goto L17
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m2234overflowLRDsOJo(long r5) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + Duration.m2149toStringimpl(r5) + '.');
    }
}
