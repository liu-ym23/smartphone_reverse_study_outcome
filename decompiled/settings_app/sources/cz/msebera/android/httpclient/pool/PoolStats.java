package cz.msebera.android.httpclient.pool;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class PoolStats implements Serializable {
    private static final long serialVersionUID = -2807686144795228544L;
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int r1, int r2, int r3, int r4) {
        this.leased = r1;
        this.pending = r2;
        this.available = r3;
        this.max = r4;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getPending() {
        return this.pending;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getMax() {
        return this.max;
    }

    public String toString() {
        return "[leased: " + this.leased + "; pending: " + this.pending + "; available: " + this.available + "; max: " + this.max + "]";
    }
}
