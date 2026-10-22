package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes6.dex */
public interface Temporal extends TemporalAccessor {
    boolean isSupported(TemporalUnit r1);

    Temporal minus(long r1, TemporalUnit r3);

    Temporal minus(TemporalAmount r1);

    Temporal plus(long r1, TemporalUnit r3);

    Temporal plus(TemporalAmount r1);

    long until(Temporal r1, TemporalUnit r2);

    Temporal with(TemporalAdjuster r1);

    Temporal with(TemporalField r1, long r2);
}
