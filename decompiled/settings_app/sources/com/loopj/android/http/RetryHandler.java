package com.loopj.android.http;

import android.os.SystemClock;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes4.dex */
class RetryHandler implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> exceptionBlacklist = null;
    private static final HashSet<Class<?>> exceptionWhitelist = null;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    static {
        HashSet<Class<?>> r0 = new HashSet();
        exceptionWhitelist = r0;
        HashSet<Class<?>> r1 = new HashSet();
        exceptionBlacklist = r1;
        r0.add(NoHttpResponseException.class);
        r0.add(UnknownHostException.class);
        r0.add(SocketException.class);
        r1.add(InterruptedIOException.class);
        r1.add(SSLException.class);
    }

    public RetryHandler(int r1, int r2) {
        this.maxRetries = r1;
        this.retrySleepTimeMS = r2;
    }

    static void addClassToWhitelist(Class<?> r1) {
        exceptionWhitelist.add(r1);
    }

    static void addClassToBlacklist(Class<?> r1) {
        exceptionBlacklist.add(r1);
    }

    @Override // cz.msebera.android.httpclient.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException r3, int r4, HttpContext r5) {
        Boolean r0 = (Boolean) r5.getAttribute("http.request_sent");
        if (r0 == null) goto L6;
        r0.booleanValue();
    L6:
        if (r4 <= this.maxRetries) goto L8;
    L7:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L16;
    L18:
        if (r1 == false) goto L20;
        SystemClock.sleep(this.retrySleepTimeMS);
    L21:
        return r1;
    L20:
        r3.printStackTrace();
        goto L21
    L16:
        if (((HttpUriRequest) r5.getAttribute("http.request")) != null) goto L18;
        return false;
    L8:
        r1 = true;
        if (isInList(exceptionWhitelist, r3) == true) goto L14;
        if (isInList(exceptionBlacklist, r3) == false) goto L14;
        goto L14
    }

    protected boolean isInList(HashSet<Class<?>> r1, Throwable r2) {
        Iterator<Class<?>> r0 = r1.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().isInstance(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
