package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HostNameResolver {
    InetAddress resolve(String r1) throws IOException;
}
