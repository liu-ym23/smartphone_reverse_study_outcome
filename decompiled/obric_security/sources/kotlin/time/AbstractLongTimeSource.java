package kotlin.time;

import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/ComparableTimeMark;", ProviderConstants.Sms.READ, "", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    /* JADX INFO: compiled from: TimeSources.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "effectiveDuration", "effectiveDuration-UwyO8pc$kotlin_stdlib", "()J", "elapsedNow", "elapsedNow-UwyO8pc", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long r1, AbstractLongTimeSource r3, long r4, DefaultConstructorMarker r6) {
            this(r1, r3, r4);
        }

        private LongTimeMark(long r1, AbstractLongTimeSource r3, long r4) {
            this.startedAt = r1;
            this.timeSource = r3;
            this.offset = r4;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r1) {
            return compareTo2(r1);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r1) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo2090minusLRDsOJo(long r1) {
            return ComparableTimeMark.DefaultImpls.m2095minusLRDsOJo(this, r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo2090minusLRDsOJo(long r1) {
            return mo2090minusLRDsOJo(r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo2092plusLRDsOJo(long r1) {
            return mo2092plusLRDsOJo(r1);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo2089elapsedNowUwyO8pc() {
            if (Duration.m2132isInfiniteimpl(this.offset) == false) goto L6;
            return Duration.m2152unaryMinusUwyO8pc(this.offset);
        L6:
            return Duration.m2135minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo2092plusLRDsOJo(long r9) {
            return new LongTimeMark(this.startedAt, this.timeSource, Duration.m2136plusLRDsOJo(this.offset, r9), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo2091minusUwyO8pc(ComparableTimeMark r7) {
            Intrinsics.checkNotNullParameter(r7, "other");
            if ((r7 instanceof LongTimeMark) == false) goto L18;
            LongTimeMark r1 = (LongTimeMark) r7;
            if (Intrinsics.areEqual(this.timeSource, r1.timeSource) == false) goto L18;
            if (Duration.m2105equalsimpl0(this.offset, r1.offset) == true) goto L9;
        L12:
            long r2 = Duration.m2135minusLRDsOJo(this.offset, r1.offset);
            long r6 = DurationKt.toDuration(this.startedAt - r1.startedAt, this.timeSource.getUnit());
            if (Duration.m2105equalsimpl0(r6, Duration.m2152unaryMinusUwyO8pc(r2)) == false) goto L16;
            return Duration.Companion.m2202getZEROUwyO8pc();
        L16:
            return Duration.m2136plusLRDsOJo(r6, r2);
        L9:
            if (Duration.m2132isInfiniteimpl(this.offset) == false) goto L12;
            return Duration.Companion.m2202getZEROUwyO8pc();
        L18:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r7);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r3) {
            if ((r3 instanceof LongTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) r3).timeSource) == false) goto L9;
            if (Duration.m2105equalsimpl0(mo2091minusUwyO8pc((ComparableTimeMark) r3), Duration.Companion.m2202getZEROUwyO8pc()) == false) goto L9;
            return true;
        }

        /* JADX INFO: renamed from: effectiveDuration-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2093effectiveDurationUwyO8pc$kotlin_stdlib() {
            if (Duration.m2132isInfiniteimpl(this.offset) == true) goto L5;
            DurationUnit r0 = this.timeSource.getUnit();
            if (r0.compareTo(DurationUnit.MILLISECONDS) >= 0) goto L9;
            long r1 = DurationUnitKt.convertDurationUnit(1, DurationUnit.MILLISECONDS, r0);
            long r3 = this.startedAt;
            long r5 = r3 / r1;
            long r4 = r3 % r1;
            long r2 = this.offset;
            long r7 = Duration.m2121getInWholeSecondsimpl(r2);
            int r9 = Duration.m2123getNanosecondsComponentimpl(r2);
            int r6 = r9 / 1000000;
            long r8 = DurationKt.toDuration(r4, r0);
            Duration.Companion r10 = Duration.Companion;
            long r11 = Duration.m2136plusLRDsOJo(r8, DurationKt.toDuration(r9 % 1000000, DurationUnit.NANOSECONDS));
            Duration.Companion r12 = Duration.Companion;
            long r13 = Duration.m2136plusLRDsOJo(r11, DurationKt.toDuration(r5 + ((long) r6), DurationUnit.MILLISECONDS));
            Duration.Companion r14 = Duration.Companion;
            return Duration.m2136plusLRDsOJo(r13, DurationKt.toDuration(r7, DurationUnit.SECONDS));
        L9:
            return Duration.m2136plusLRDsOJo(DurationKt.toDuration(this.startedAt, r0), this.offset);
        L5:
            return this.offset;
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return Duration.m2128hashCodeimpl(m2093effectiveDurationUwyO8pc$kotlin_stdlib());
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m2149toStringimpl(this.offset) + " (=" + Duration.m2149toStringimpl(m2093effectiveDurationUwyO8pc$kotlin_stdlib()) + "), " + this.timeSource + ')';
        }
    }

    protected abstract long read();

    public AbstractLongTimeSource(DurationUnit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.unit = r2;
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(read(), this, Duration.Companion.m2202getZEROUwyO8pc(), null);
    }
}
