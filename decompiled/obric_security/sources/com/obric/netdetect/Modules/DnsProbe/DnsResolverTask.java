package com.obric.netdetect.Modules.DnsProbe;

import android.net.Network;
import android.os.AsyncTask;
import com.obric.netdetect.API.Callback.DnsResolverCallback;
import com.obric.netdetect.API.NetDetectConfig;
import com.obric.netdetect.Utils.NetDetectLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DnsResolverTask extends AsyncTask<String, Void, Void> implements DnsResolverService.DnsResolverListener {
    private static final String TAG = "DnsResolverTask";
    private final DnsResolverCallback mCallback;
    private DnsResolverService mDnsResolverService;
    private final int mDnsType;
    private final int mNetworkType;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
        return doInBackground2(r1);
    }

    public DnsResolverTask(int r1, Network r2, NetDetectConfig r3, DnsResolverCallback r4) {
        this.mNetworkType = r1;
        this.mDnsType = r3.dnsType;
        this.mCallback = r4;
        this.mDnsResolverService = new DnsResolverService(this, r2, r3.dnsResolveTimeout);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(String... r3) {
        this.mDnsResolverService.executeDnsResolve(r3[0], this.mDnsType);
        return null;
    }

    @Override // com.obric.netdetect.Modules.DnsProbe.DnsResolverService.DnsResolverListener
    public void onDnsResolveSuccess(String r5, List<InetAddress> r6) {
        NetDetectLog.d(TAG, "dns resolve result success. hostname: " + r5 + ", addresses: " + r6);
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<InetAddress> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        InetAddress r2 = r7.next();
        if ((r2 instanceof Inet4Address) == true) goto L7;
        if ((r2 instanceof Inet6Address) == false) goto L4;
        r1.add(r2.getHostAddress());
        goto L4
    L7:
        r0.add(r2.getHostAddress());
        goto L4
    L11:
        DnsResolverCallback r8 = this.mCallback;
        if (r8 == null) goto L23;
        r8.onDnsResolverResult(DnsResolverResult.success(this.mNetworkType, r5, (String[]) r0.toArray(new String[0]), (String[]) r1.toArray(new String[0])));
        return;
    }

    @Override // com.obric.netdetect.Modules.DnsProbe.DnsResolverService.DnsResolverListener
    public void onDnsResolveFailed(String r3, int r4) {
        NetDetectLog.d(TAG, "dns resolve result failed. hostname: " + r3 + ", errorCode: " + r4);
        DnsResolverCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onDnsResolverResult(DnsResolverResult.failed(this.mNetworkType, r3, r4));
        return;
    }
}
