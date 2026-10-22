package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    public DefaultRetryPolicy(int r1, int r2, float r3) {
        this.mCurrentTimeoutMs = r1;
        this.mMaxNumRetries = r2;
        this.mBackoffMultiplier = r3;
    }

    @Override // com.android.volley.RetryPolicy
    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    @Override // com.android.volley.RetryPolicy
    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    @Override // com.android.volley.RetryPolicy
    public void retry(VolleyError r4) throws VolleyError {
        this.mCurrentRetryCount++;
        int r0 = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = r0 + ((int) (r0 * this.mBackoffMultiplier));
        if (hasAttemptRemaining() == false) goto L5;
        return;
    L5:
        throw r4;
    }

    protected boolean hasAttemptRemaining() {
        if (this.mCurrentRetryCount > this.mMaxNumRetries) goto L5;
        return true;
    L5:
        return false;
    }
}
