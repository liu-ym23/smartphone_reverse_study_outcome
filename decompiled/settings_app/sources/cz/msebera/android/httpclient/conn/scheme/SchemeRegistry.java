package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class SchemeRegistry {
    private final ConcurrentHashMap<String, Scheme> registeredSchemes;

    public SchemeRegistry() {
        this.registeredSchemes = new ConcurrentHashMap();
    }

    public final Scheme getScheme(String r3) {
        Scheme r2 = get(r3);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Scheme '" + r3 + "' not registered.");
    }

    public final Scheme getScheme(HttpHost r2) {
        Args.notNull(r2, "Host");
        return getScheme(r2.getSchemeName());
    }

    public final Scheme get(String r2) {
        Args.notNull(r2, "Scheme name");
        return this.registeredSchemes.get(r2);
    }

    public final Scheme register(Scheme r2) {
        Args.notNull(r2, "Scheme");
        return this.registeredSchemes.put(r2.getName(), r2);
    }

    public final Scheme unregister(String r2) {
        Args.notNull(r2, "Scheme name");
        return this.registeredSchemes.remove(r2);
    }

    public final List<String> getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, Scheme> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(r2);
    }
}
