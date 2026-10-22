package cz.msebera.android.httpclient.impl.client.cache;

/* JADX INFO: loaded from: classes5.dex */
public interface FailureCache {
    int getErrorCount(String r1);

    void increaseErrorCount(String r1);

    void resetErrorCount(String r1);
}
