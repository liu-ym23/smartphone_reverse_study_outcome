package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractCookieSpec implements CookieSpec {
    private final Map<String, CookieAttributeHandler> attribHandlerMap;

    public AbstractCookieSpec() {
        this.attribHandlerMap = new ConcurrentHashMap(10);
    }

    protected AbstractCookieSpec(HashMap<String, CookieAttributeHandler> r2) {
        Asserts.notNull(r2, "Attribute handler map");
        this.attribHandlerMap = new ConcurrentHashMap(r2);
    }

    protected AbstractCookieSpec(CommonCookieAttributeHandler... r6) {
        this.attribHandlerMap = new ConcurrentHashMap(r6.length);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        CommonCookieAttributeHandler r2 = r6[r1];
        this.attribHandlerMap.put(r2.getAttributeName(), r2);
        r1 = r1 + 1;
        goto L3
    }

    @Deprecated
    public void registerAttribHandler(String r2, CookieAttributeHandler r3) {
        Args.notNull(r2, "Attribute name");
        Args.notNull(r3, "Attribute handler");
        this.attribHandlerMap.put(r2, r3);
    }

    protected CookieAttributeHandler findAttribHandler(String r1) {
        return this.attribHandlerMap.get(r1);
    }

    protected CookieAttributeHandler getAttribHandler(String r4) {
        CookieAttributeHandler r3 = findAttribHandler(r4);
        if (r3 == null) goto L5;
        boolean r0 = true;
    L6:
        Asserts.check(r0, "Handler not registered for " + r4 + " attribute");
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    protected Collection<CookieAttributeHandler> getAttribHandlers() {
        return this.attribHandlerMap.values();
    }
}
