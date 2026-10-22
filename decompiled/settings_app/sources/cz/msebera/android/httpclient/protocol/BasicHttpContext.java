package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public BasicHttpContext(HttpContext r2) {
        this.map = new ConcurrentHashMap();
        this.parentContext = r2;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String r2) {
        Args.notNull(r2, "Id");
        Object r0 = this.map.get(r2);
        if (r0 != null) goto L8;
        HttpContext r1 = this.parentContext;
        if (r1 != null) goto L7;
        return r0;
    L7:
        return r1.getAttribute(r2);
    L8:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String r2, Object r3) {
        Args.notNull(r2, "Id");
        if (r3 == null) goto L5;
        this.map.put(r2, r3);
        return;
    L5:
        this.map.remove(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String r2) {
        Args.notNull(r2, "Id");
        return this.map.remove(r2);
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
