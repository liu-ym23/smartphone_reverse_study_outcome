package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class InMemoryDnsResolver implements DnsResolver {
    private final Map<String, InetAddress[]> dnsMap;
    public HttpClientAndroidLog log;

    public InMemoryDnsResolver() {
        this.log = new HttpClientAndroidLog(InMemoryDnsResolver.class);
        this.dnsMap = new ConcurrentHashMap();
    }

    public void add(String r2, InetAddress... r3) {
        Args.notNull(r2, "Host name");
        Args.notNull(r3, "Array of IP addresses");
        this.dnsMap.put(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.conn.DnsResolver
    public InetAddress[] resolve(String r4) throws UnknownHostException {
        InetAddress[] r0 = this.dnsMap.get(r4);
        if (this.log.isInfoEnabled() == false) goto L5;
        this.log.info("Resolving " + r4 + " to " + Arrays.deepToString(r0));
    L5:
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new UnknownHostException(r4 + " cannot be resolved");
    }
}
