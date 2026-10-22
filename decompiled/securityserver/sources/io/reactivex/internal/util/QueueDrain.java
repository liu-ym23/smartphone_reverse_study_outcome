package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> r1, T r2);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int r1);

    long produced(long r1);

    long requested();
}
