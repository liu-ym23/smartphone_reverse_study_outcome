package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer(String r1) {
        this.originServer = r1;
    }

    public ResponseServer() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r2, HttpContext r3) throws HttpException, IOException {
        Args.notNull(r2, "HTTP response");
        if (r2.containsHeader("Server") == true) goto L8;
        String r1 = this.originServer;
        if (r1 == null) goto L9;
        r2.addHeader("Server", r1);
        return;
    L9:
        return;
    }
}
