package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    public Subject() {
    }

    @Nullable
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    @NonNull
    public final Subject<T> toSerialized() {
        if ((this instanceof SerializedSubject) == false) goto L6;
        return this;
    L6:
        return new SerializedSubject(this);
    }
}
