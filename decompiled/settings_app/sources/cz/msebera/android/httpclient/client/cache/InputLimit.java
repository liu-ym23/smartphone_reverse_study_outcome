package cz.msebera.android.httpclient.client.cache;

/* JADX INFO: loaded from: classes5.dex */
public class InputLimit {
    private boolean reached;
    private final long value;

    public InputLimit(long r1) {
        this.value = r1;
        this.reached = false;
    }

    public long getValue() {
        return this.value;
    }

    public void reached() {
        this.reached = true;
    }

    public boolean isReached() {
        return this.reached;
    }
}
