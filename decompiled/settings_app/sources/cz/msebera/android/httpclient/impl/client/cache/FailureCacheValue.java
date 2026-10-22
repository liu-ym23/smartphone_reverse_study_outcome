package cz.msebera.android.httpclient.impl.client.cache;

/* JADX INFO: loaded from: classes5.dex */
public class FailureCacheValue {
    private final long creationTimeInNanos;
    private final int errorCount;
    private final String key;

    public FailureCacheValue(String r3, int r4) {
        this.creationTimeInNanos = System.nanoTime();
        this.key = r3;
        this.errorCount = r4;
    }

    public long getCreationTimeInNanos() {
        return this.creationTimeInNanos;
    }

    public String getKey() {
        return this.key;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public String toString() {
        return "[entry creationTimeInNanos=" + this.creationTimeInNanos + "; key=" + this.key + "; errorCount=" + this.errorCount + ']';
    }
}
