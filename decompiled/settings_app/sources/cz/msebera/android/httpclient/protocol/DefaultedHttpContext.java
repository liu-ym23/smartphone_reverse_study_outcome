package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class DefaultedHttpContext implements HttpContext {
    private final HttpContext defaults;
    private final HttpContext local;

    public DefaultedHttpContext(HttpContext r2, HttpContext r3) {
        this.local = (HttpContext) Args.notNull(r2, "HTTP context");
        this.defaults = r3;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r2) {
        Object r0 = this.local.getAttribute(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.defaults.getAttribute(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r1) {
        return this.local.removeAttribute(r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r1, Object r2) {
        this.local.setAttribute(r1, r2);
    }

    public HttpContext getDefaults() {
        return this.defaults;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[local: ");
        r0.append(this.local);
        r0.append("defaults: ").append(this.defaults);
        r0.append("]");
        return r0.toString();
    }
}
