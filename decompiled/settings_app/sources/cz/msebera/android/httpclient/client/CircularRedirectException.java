package cz.msebera.android.httpclient.client;

/* JADX INFO: loaded from: classes5.dex */
public class CircularRedirectException extends RedirectException {
    private static final long serialVersionUID = 6830063487001091803L;

    public CircularRedirectException() {
    }

    public CircularRedirectException(String r1) {
        super(r1);
    }

    public CircularRedirectException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
