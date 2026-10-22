package cz.msebera.android.httpclient.impl.client;

/* JADX INFO: loaded from: classes5.dex */
public class LaxRedirectStrategy extends DefaultRedirectStrategy {
    public static final LaxRedirectStrategy INSTANCE = null;
    private static final String[] REDIRECT_METHODS = null;

    public LaxRedirectStrategy() {
    }

    static {
        INSTANCE = new LaxRedirectStrategy();
        REDIRECT_METHODS = new String[]{"GET", "POST", "HEAD", "DELETE"};
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultRedirectStrategy
    protected boolean isRedirectable(String r5) {
        String[] r4 = REDIRECT_METHODS;
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
}
