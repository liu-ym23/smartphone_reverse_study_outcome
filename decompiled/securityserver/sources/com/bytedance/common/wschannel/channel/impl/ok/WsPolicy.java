package com.bytedance.common.wschannel.channel.impl.ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
class WsPolicy {
    private int mIndex;
    private RetryPolicy mRetryPolicy;
    private String mTargetUrl;
    private final List<String> mUrls;

    public WsPolicy(List<String> r3, RetryPolicy r4) {
        this.mIndex = 0;
        ArrayList r0 = new ArrayList();
        this.mUrls = r0;
        if (r3 == null) goto L5;
        r0.addAll(r3);
    L5:
        Logger.d(OkChannelImpl.TAG, "urls : " + r0);
        this.mRetryPolicy = r4;
        reset();
    }

    public synchronized String getNextUrl() {
        monitor-enter(this);
        int r0 = this.mIndex + 1;     // Catch: Throwable -> L8
        this.mIndex = r0;     // Catch: Throwable -> L8
        if (this.mUrls.size() <= r0) goto L11;
        String r1 = this.mUrls.get(r0);     // Catch: Throwable -> L8
        this.mTargetUrl = r1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L11:
        monitor-exit(this);
        return "";
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized Pair<String, Long> getRetryUrlAndInterval(Response r6) {
        monitor-enter(this);
        String r0 = getUrl();     // Catch: Throwable -> L8
        long r1 = this.mRetryPolicy.getRetryIntervalWithResponse(r6);     // Catch: Throwable -> L8
        if (r1 != (-1)) goto L10;
        this.mRetryPolicy.reset();     // Catch: Throwable -> L8
        r0 = getNextUrl();     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r0) == true) goto L10;
        r1 = this.mRetryPolicy.getRandomInterval();     // Catch: Throwable -> L8
    L10:
        Pair<String, Long> r7 = new Pair(r0, Long.valueOf(r1));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r7;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized String getUrl() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (StringUtils.isEmpty(this.mTargetUrl) == false) goto L10;
        int r0 = this.mUrls.size();     // Catch: Throwable -> L8
        int r1 = this.mIndex;     // Catch: Throwable -> L8
        if (r0 <= r1) goto L10;
        this.mTargetUrl = this.mUrls.get(r1);     // Catch: Throwable -> L8
    L10:
        String r2 = this.mTargetUrl;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r2;
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.mRetryPolicy.reset();     // Catch: Throwable -> L6
        this.mTargetUrl = null;     // Catch: Throwable -> L6
        this.mIndex = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
