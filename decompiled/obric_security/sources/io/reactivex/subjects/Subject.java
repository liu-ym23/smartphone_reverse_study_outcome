package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    public Subject() {
    }

    public final Subject<T> toSerialized() {
        if ((this instanceof SerializedSubject) == false) goto L6;
        return this;
    L6:
        return new SerializedSubject(this);
    }
}
