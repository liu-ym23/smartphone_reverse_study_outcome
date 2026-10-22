package cz.msebera.android.httpclient.pool;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPoolControl<T> {
    int getDefaultMaxPerRoute();

    int getMaxPerRoute(T r1);

    int getMaxTotal();

    PoolStats getStats(T r1);

    PoolStats getTotalStats();

    void setDefaultMaxPerRoute(int r1);

    void setMaxPerRoute(T r1, int r2);

    void setMaxTotal(int r1);
}
