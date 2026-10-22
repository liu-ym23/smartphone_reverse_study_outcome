package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.MethodNotSupportedException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.message.BasicHttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE = null;
    private static final String[] RFC2616_COMMON_METHODS = null;
    private static final String[] RFC2616_ENTITY_ENC_METHODS = null;
    private static final String[] RFC2616_SPECIAL_METHODS = null;
    private static final String[] RFC5789_ENTITY_ENC_METHODS = null;

    static {
        INSTANCE = new DefaultHttpRequestFactory();
        RFC2616_COMMON_METHODS = new String[]{"GET"};
        RFC2616_ENTITY_ENC_METHODS = new String[]{"POST", "PUT"};
        RFC2616_SPECIAL_METHODS = new String[]{"HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"};
        RFC5789_ENTITY_ENC_METHODS = new String[]{"PATCH"};
    }

    public DefaultHttpRequestFactory() {
    }

    private static boolean isOneOf(String[] r4, String r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equalsIgnoreCase(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine r2) throws MethodNotSupportedException {
        Args.notNull(r2, "Request line");
        String r1 = r2.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, r1) == false) goto L7;
        return new BasicHttpRequest(r2);
    L7:
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, r1) == false) goto L11;
        return new BasicHttpEntityEnclosingRequest(r2);
    L11:
        if (isOneOf(RFC2616_SPECIAL_METHODS, r1) == false) goto L15;
        return new BasicHttpRequest(r2);
    L15:
        if (isOneOf(RFC5789_ENTITY_ENC_METHODS, r1) == false) goto L19;
        return new BasicHttpEntityEnclosingRequest(r2);
    L19:
        throw new MethodNotSupportedException(r1 + " method not supported");
    }

    @Override // cz.msebera.android.httpclient.HttpRequestFactory
    public HttpRequest newHttpRequest(String r1, String r2) throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, r1) == false) goto L7;
        return new BasicHttpRequest(r1, r2);
    L7:
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, r1) == false) goto L11;
        return new BasicHttpEntityEnclosingRequest(r1, r2);
    L11:
        if (isOneOf(RFC2616_SPECIAL_METHODS, r1) == false) goto L15;
        return new BasicHttpRequest(r1, r2);
    L15:
        if (isOneOf(RFC5789_ENTITY_ENC_METHODS, r1) == false) goto L19;
        return new BasicHttpEntityEnclosingRequest(r1, r2);
    L19:
        throw new MethodNotSupportedException(r1 + " method not supported");
    }
}
