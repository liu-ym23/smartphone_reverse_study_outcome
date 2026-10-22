package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String r1, @NonNull Throwable r2) {
        if (r2 != null) goto L5;
        r2 = new NullPointerException();
    L5:
        super(r1, r2);
    }

    public OnErrorNotImplementedException(@NonNull Throwable r3) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + r3, r3);
    }
}
