package com.bytedance.common.wschannel.channel.impl.ok.policy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class RetryIntervalPolicy implements RetryPolicy {
    private static final long INIT_RETRY_INTERVAL = 5000;
    private static final long MAX_RETRY_INTERVAL = 120000;
    private final Context mContext;
    private int mReconnectTimes;

    public RetryIntervalPolicy(Context r2) {
        this.mReconnectTimes = 0;
        this.mContext = r2;
    }

    private static boolean isNetworkAvailable(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public long getNextRetryInterval() {
        if (isNetworkAvailable(this.mContext) == true) goto L6;
        return -1;
    L6:
        int r0 = this.mReconnectTimes + 1;
        this.mReconnectTimes = r0;
        return (long) (((Math.random() * 10.0d) * 1000.0d) + Math.min(((long) (1 << r0)) * 5000, 120000));
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRandomInterval() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRetryIntervalWithResponse(Response r9) {
        long r1 = getNextRetryInterval();
        if (r1 != (-1)) goto L5;
        return -1;
    L5:
        if (r9 != null) goto L31;
    L29:
        return r1;
    L31:
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L7:
        if (r9.isSuccessful() == true) goto L29;
        int r8 = r9.code();     // Catch: Exception -> L25
        if (r8 != 414) goto L11;
    L14:
        String r10 = r9.header("Handshake-Options");     // Catch: Exception -> L25
        if (r10 == null) goto L29;
        String[] r11 = r10.split(";");     // Catch: Exception -> L25
        int r12 = r11.length;     // Catch: Exception -> L25
        int r4 = 0;
    L17:
        if (r4 >= r12) goto L29;
        String r5 = r11[r4];     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r5) == true) goto L27;
        String[] r6 = r5.split("=");     // Catch: Exception -> L25
        if ("reconnect-interval".equals(r6[0]) == false) goto L27;
        String r7 = r6[1];     // Catch: Exception -> L25
        Logger.d(OkChannelImpl.TAG, "override retry interval");     // Catch: Exception -> L25
        r1 = Long.parseLong(r7) * 1000;     // Catch: Exception -> L25 NumberFormatException -> L30
        Logger.d(OkChannelImpl.TAG, "read response hand shake option : reconnect-interval:" + r1 + " ms");     // Catch: Exception -> L25 NumberFormatException -> L30
    L27:
        r4 = r4 + 1;
        goto L17
    L11:
        if (r8 == 511) goto L14;
        if (r8 != 512) goto L29;
        goto L14
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        this.mReconnectTimes = 0;
    }
}
