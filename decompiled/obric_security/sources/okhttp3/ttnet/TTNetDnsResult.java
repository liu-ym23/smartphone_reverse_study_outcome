package okhttp3.ttnet;

import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TTNetDnsResult {
    private final String mDnsInfoJson;
    private final List<InetAddress> mInetAddressList;

    public TTNetDnsResult(List<InetAddress> r1, String r2) {
        this.mInetAddressList = r1;
        this.mDnsInfoJson = r2;
    }

    public List<InetAddress> getInetAddressList() {
        return this.mInetAddressList;
    }

    public String getDnsInfoJson() {
        return this.mDnsInfoJson;
    }
}
