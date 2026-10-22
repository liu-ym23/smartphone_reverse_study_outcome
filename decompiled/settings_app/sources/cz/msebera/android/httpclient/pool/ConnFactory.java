package cz.msebera.android.httpclient.pool;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnFactory<T, C> {
    C create(T r1) throws IOException;
}
