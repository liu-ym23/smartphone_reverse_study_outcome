package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import org.reactivestreams.Processor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    public FlowableProcessor() {
    }

    @CheckReturnValue
    public final FlowableProcessor<T> toSerialized() {
        if ((this instanceof SerializedProcessor) == false) goto L6;
        return this;
    L6:
        return new SerializedProcessor(this);
    }
}
