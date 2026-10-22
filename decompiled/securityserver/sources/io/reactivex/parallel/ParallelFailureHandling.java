package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public final enum ParallelFailureHandling extends Enum<ParallelFailureHandling> implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    private static final /* synthetic */ ParallelFailureHandling[] $VALUES = null;
    public static final ParallelFailureHandling ERROR = null;
    public static final ParallelFailureHandling RETRY = null;
    public static final ParallelFailureHandling SKIP = null;
    public static final ParallelFailureHandling STOP = null;

    static {
        ParallelFailureHandling r0 = new ParallelFailureHandling("STOP", 0);
        STOP = r0;
        ParallelFailureHandling r1 = new ParallelFailureHandling("ERROR", 1);
        ERROR = r1;
        ParallelFailureHandling r2 = new ParallelFailureHandling("SKIP", 2);
        SKIP = r2;
        ParallelFailureHandling r3 = new ParallelFailureHandling("RETRY", 3);
        RETRY = r3;
        $VALUES = new ParallelFailureHandling[]{r0, r1, r2, r3};
    }

    private ParallelFailureHandling(String r1, int r2) {
        super(r1, r2);
    }

    public static ParallelFailureHandling valueOf(String r1) {
        return (ParallelFailureHandling) Enum.valueOf(ParallelFailureHandling.class, r1);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ParallelFailureHandling apply2(Long r1, Throwable r2) {
        return this;
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ ParallelFailureHandling apply(Long r1, Throwable r2) {
        return apply2(r1, r2);
    }
}
