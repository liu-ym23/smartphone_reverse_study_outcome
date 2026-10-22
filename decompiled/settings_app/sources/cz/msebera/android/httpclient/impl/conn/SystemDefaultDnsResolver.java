package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.DnsResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes5.dex */
public class SystemDefaultDnsResolver implements DnsResolver {
    public static final SystemDefaultDnsResolver INSTANCE = null;

    public SystemDefaultDnsResolver() {
    }

    static {
        INSTANCE = new SystemDefaultDnsResolver();
    }

    @Override // cz.msebera.android.httpclient.conn.DnsResolver
    public InetAddress[] resolve(String r1) throws UnknownHostException {
        return InetAddress.getAllByName(r1);
    }
}
