package cz.msebera.android.httpclient.protocol;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String r1);

    Object removeAttribute(String r1);

    void setAttribute(String r1, Object r2);
}
