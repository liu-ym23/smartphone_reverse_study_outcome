package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes5.dex */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r1, long r2);

    long between(Temporal r1, Temporal r2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal r1);

    boolean isTimeBased();

    String toString();
}
