package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String reasonPhrase;
    private final int statusCode;

    public HttpResponseException(int r5, String r6) {
        if (TextUtils.isBlank(r6) == false) goto L5;
        String r0 = "";
    L6:
        super(String.format("status code: %d".concat(r0), new Object[]{Integer.valueOf(r5), r6}));
        this.statusCode = r5;
        this.reasonPhrase = r6;
        return;
    L5:
        r0 = ", reason phrase: %s";
        goto L6
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
