package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "OPTIONS";
    }

    public HttpOptions() {
    }

    public HttpOptions(URI r1) {
        setURI(r1);
    }

    public HttpOptions(String r1) {
        setURI(URI.create(r1));
    }

    public Set<String> getAllowedMethods(HttpResponse r5) {
        Args.notNull(r5, "HTTP response");
        HeaderIterator r4 = r5.headerIterator("Allow");
        HashSet r6 = new HashSet();
    L4:
        if (r4.hasNext() == false) goto L8;
        HeaderElement[] r0 = r4.nextHeader().getElements();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L4;
        r6.add(r0[r2].getName());
        r2 = r2 + 1;
        goto L6
    L8:
        return r6;
    }
}
