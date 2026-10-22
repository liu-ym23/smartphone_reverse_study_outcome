package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseDate implements HttpResponseInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = null;

    static {
        DATE_GENERATOR = new HttpDateGenerator();
    }

    public ResponseDate() {
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r1, HttpContext r2) throws HttpException, IOException {
        Args.notNull(r1, "HTTP response");
        if (r1.getStatusLine().getStatusCode() >= 200) goto L5;
        return;
    L5:
        if (r1.containsHeader("Date") == true) goto L9;
        r1.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        return;
    }
}
