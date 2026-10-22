package cz.msebera.android.httpclient.client.methods;

import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public class HttpPost extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return "POST";
    }

    public HttpPost() {
    }

    public HttpPost(URI r1) {
        setURI(r1);
    }

    public HttpPost(String r1) {
        setURI(URI.create(r1));
    }
}
