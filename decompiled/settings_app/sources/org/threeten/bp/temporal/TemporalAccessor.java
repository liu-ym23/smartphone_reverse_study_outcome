package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes6.dex */
public interface TemporalAccessor {
    int get(TemporalField r1);

    long getLong(TemporalField r1);

    boolean isSupported(TemporalField r1);

    <R> R query(TemporalQuery<R> r1);

    ValueRange range(TemporalField r1);
}
