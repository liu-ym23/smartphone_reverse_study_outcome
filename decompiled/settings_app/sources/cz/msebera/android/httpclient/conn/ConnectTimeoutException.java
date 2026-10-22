package cz.msebera.android.httpclient.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class ConnectTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -4816682903149535989L;
    private final HttpHost host;

    public ConnectTimeoutException() {
        this.host = null;
    }

    public ConnectTimeoutException(String r1) {
        super(r1);
        this.host = null;
    }

    public ConnectTimeoutException(IOException r4, HttpHost r5, InetAddress... r6) {
        StringBuilder r0 = new StringBuilder("Connect to ");
        if (r5 == null) goto L5;
        String r1 = r5.toHostString();
    L6:
        StringBuilder r2 = r0.append(r1);
        if (r6 != null) goto L9;
    L11:
        String r7 = "";
    L12:
        StringBuilder r8 = r2.append(r7);
        if (r4 != null) goto L15;
    L17:
        String r3 = " timed out";
    L18:
        super(r8.append(r3).toString());
        this.host = r5;
        initCause(r4);
        return;
    L15:
        if (r4.getMessage() == null) goto L17;
        r3 = " failed: " + r4.getMessage();
        goto L18
    L9:
        if (r6.length <= 0) goto L11;
        r7 = HanziToPinyin.Token.SEPARATOR + Arrays.asList(r6);
        goto L12
    L5:
        r1 = "remote host";
        goto L6
    }

    public HttpHost getHost() {
        return this.host;
    }
}
