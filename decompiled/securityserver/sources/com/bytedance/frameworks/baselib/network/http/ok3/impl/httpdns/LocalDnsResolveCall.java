package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.obric.matrix.push.common.CommonConstants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocalDnsResolveCall implements Callable<Void> {
    public static final int MSG_LOCALDNS_COMPLETED = 1;
    public static final String MSG_LOCALDNS_COMPLETED_HOST_KEY = "localdns_completed_host";
    private final String TAG;
    private final String mHost;
    private final HostResolveManager mHostResolveManager;
    private final WeakHandler mHttpDnsHanlder;

    public LocalDnsResolveCall(String r2, HostResolveManager r3, WeakHandler r4) {
        this.TAG = "LocalDnsResolveCall";
        this.mHost = r2;
        this.mHostResolveManager = r3;
        this.mHttpDnsHanlder = r4;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        long r0 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        InetAddress[] r2 = InetAddress.getAllByName(this.mHost);     // Catch: UnknownHostException -> L8
        int r3 = r2.length;     // Catch: UnknownHostException -> L8
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L18;
        InetAddress r5 = r2[r4];     // Catch: UnknownHostException -> L8
        if ((r5 instanceof Inet4Address) == false) goto L11;
        r9.add(r5.getHostAddress());     // Catch: UnknownHostException -> L8
    L16:
        r4 = r4 + 1;     // Catch: UnknownHostException -> L8
        goto L4
    L11:
        if ((r5 instanceof Inet6Address) == false) goto L14;
        r10.add(r5.getHostAddress());     // Catch: UnknownHostException -> L8
        goto L16
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(this.TAG, "local dns server returned a invalid address: " + r5.getHostAddress());     // Catch: UnknownHostException -> L8
        goto L16
    L18:
        if (Logger.debug() == false) goto L21;
        Logger.d(this.TAG, "local dns resolved success for host: " + this.mHost);     // Catch: UnknownHostException -> L8
    L21:
        if (r9.size() <= 0) goto L23;
    L24:
        this.mHostResolveManager.addLocalDnsCache(this.mHost, new DnsRecord(this.mHost, System.currentTimeMillis(), r9, r10, HttpDns.getService().getLocalDnsCacheTTL().get()));     // Catch: UnknownHostException -> L8
    L28:
        if (HttpDns.getService().isHttpDnsPrefer().get() == true) goto L47;
        Message r6 = Message.obtain();
        r6.obj = this;
        r6.what = 1;
        Bundle r7 = new Bundle();
        r7.putString(MSG_LOCALDNS_COMPLETED_HOST_KEY, this.mHost);
        r6.setData(r7);
        this.mHttpDnsHanlder.sendMessage(r6);
        if (Logger.debug() == false) goto L32;
        Logger.d(this.TAG, "send message to collect result handler for host : " + this.mHost);
    L32:
        long r8 = System.currentTimeMillis() - r0;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L39
        r1.put("host", this.mHost);     // Catch: JSONException -> L39
        if (r9.size() == 0) goto L37;
    L41:
        r1.put("status", "succeed");     // Catch: JSONException -> L39
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L39
        r11.addAll(r10);     // Catch: JSONException -> L39
        r11.addAll(r9);     // Catch: JSONException -> L39
        r1.put("result", r11);     // Catch: JSONException -> L39
    L42:
        r1.put("rtt", r8);     // Catch: JSONException -> L39
        if (Logger.debug() == false) goto L47;
        Logger.d(this.TAG, r1.toString());     // Catch: JSONException -> L39
        goto L47
    L37:
        if (r10.size() != 0) goto L41;
        r1.put("status", CommonConstants.MSG_FAILED);     // Catch: JSONException -> L39
        r1.put("result", "");     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L47:
        this.mHostResolveManager.removeLocalDnsResolvingFuture(this.mHost);
        return null;
    L23:
        if (r10.size() <= 0) goto L28;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }
}
