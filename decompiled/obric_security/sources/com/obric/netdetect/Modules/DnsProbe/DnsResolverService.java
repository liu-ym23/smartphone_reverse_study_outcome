package com.obric.netdetect.Modules.DnsProbe;

import android.net.DnsResolver;
import android.net.Network;
import com.obric.netdetect.Utils.NetDetectLog;
import com.obric.netdetect.Utils.URLUtils;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DnsResolverService {
    private static final String TAG = "DnsResolverService";
    private final DnsResolver.Callback<List<InetAddress>> mCallback;
    private DnsResolver mDnsResolver;
    private DnsResolverListener mListener;
    private Network mNetwork;
    private final CompletableFuture<List<InetAddress>> mResultRef;
    private int mTimeout;

    public interface DnsResolverListener {
        void onDnsResolveFailed(String r1, int r2);

        void onDnsResolveSuccess(String r1, List<InetAddress> r2);
    }

    static /* synthetic */ CompletableFuture access$000(DnsResolverService r0) {
        return r0.mResultRef;
    }

    public DnsResolverService(DnsResolverListener r2, Network r3, int r4) {
        this.mResultRef = new CompletableFuture();
        this.mCallback = new AnonymousClass1(this);
        this.mListener = r2;
        this.mNetwork = r3;
        this.mTimeout = r4;
        this.mDnsResolver = DnsResolver.getInstance();
    }

    public void executeDnsResolve(String r4, int r5) {
        URL r0 = URLUtils.makeURL(r4);
        if (r0 != null) goto L6;
        NetDetectLog.e(TAG, "url is invalid: " + r4);
        this.mListener.onDnsResolveFailed(null, 2);
        return;
    L6:
        String r6 = r0.getHost();
        if (r6 != null) goto L10;
        NetDetectLog.e(TAG, "hostname is null");
        this.mListener.onDnsResolveFailed(null, 3);
        return;
    L10:
        sendDnsProbe(r6, r5);
    }

    private void sendDnsProbe(String r12, int r13) {
        if (r13 != 0) goto L5;
        this.mDnsResolver.query(this.mNetwork, r12, 4, new DnsResolverService$$ExternalSyntheticLambda0(), null, this.mCallback);
    L6:
        int r2 = 0;
        List<InetAddress> r0 = this.mResultRef.get(this.mTimeout, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L12 Throwable -> L14 ExecutionException -> L17
        if (r0 != null) goto L10;
    L20:
        this.mListener.onDnsResolveFailed(r12, r2);
        return;
    L10:
        if (r0.isEmpty() == true) goto L20;
        this.mListener.onDnsResolveSuccess(r12, r0);
        return;
    L12:
        th = move-exception;
        this.mListener.onDnsResolveFailed(r12, 0);
        throw th;
    L14:
        e = move-exception;
        NetDetectLog.e(TAG, "DNS resolve timeout: ", e);     // Catch: Throwable -> L12
        this.mListener.onDnsResolveFailed(r12, 5);
        return;
    L17:
        e = move-exception;
        r2 = 4;
        NetDetectLog.e(TAG, "DNS resolve error: ", e);     // Catch: Throwable -> L12
        goto L20
    L5:
        this.mDnsResolver.query(this.mNetwork, r12, r13, 4, new DnsResolverService$$ExternalSyntheticLambda0(), null, this.mCallback);
        goto L6
    }
}
