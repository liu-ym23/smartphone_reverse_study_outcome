package cz.msebera.android.httpclient.pool;

/* JADX INFO: loaded from: classes5.dex */
public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> r1);
}
