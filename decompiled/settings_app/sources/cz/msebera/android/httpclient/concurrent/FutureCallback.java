package cz.msebera.android.httpclient.concurrent;

/* JADX INFO: loaded from: classes5.dex */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T r1);

    void failed(Exception r1);
}
