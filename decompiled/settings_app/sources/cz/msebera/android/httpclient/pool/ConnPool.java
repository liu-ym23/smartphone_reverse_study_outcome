package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.concurrent.FutureCallback;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T r1, Object r2, FutureCallback<E> r3);

    void release(E r1, boolean r2);
}
