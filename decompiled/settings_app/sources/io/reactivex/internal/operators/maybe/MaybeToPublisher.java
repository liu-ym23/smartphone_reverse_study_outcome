package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes5.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements Function<MaybeSource<Object>, Publisher<Object>> {
    private static final /* synthetic */ MaybeToPublisher[] $VALUES = null;
    public static final MaybeToPublisher INSTANCE = null;

    private MaybeToPublisher(String r1, int r2) {
        super(r1, r2);
    }

    public static MaybeToPublisher valueOf(String r1) {
        return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, r1);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) $VALUES.clone();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Publisher<Object> apply(MaybeSource<Object> r1) throws Exception {
        return apply2(r1);
    }

    static {
        MaybeToPublisher r0 = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new MaybeToPublisher[]{r0};
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Publisher<Object> apply2(MaybeSource<Object> r1) throws Exception {
        return new MaybeToFlowable(r1);
    }
}
