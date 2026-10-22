package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class CookieSpecRegistry implements Lookup<CookieSpecProvider> {
    private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs;

    @Override // cz.msebera.android.httpclient.config.Lookup
    public /* bridge */ /* synthetic */ CookieSpecProvider lookup(String r1) {
        return lookup(r1);
    }

    public CookieSpecRegistry() {
        this.registeredSpecs = new ConcurrentHashMap();
    }

    public void register(String r2, CookieSpecFactory r3) {
        Args.notNull(r2, "Name");
        Args.notNull(r3, "Cookie spec factory");
        this.registeredSpecs.put(r2.toLowerCase(Locale.ENGLISH), r3);
    }

    public void unregister(String r2) {
        Args.notNull(r2, "Id");
        this.registeredSpecs.remove(r2.toLowerCase(Locale.ENGLISH));
    }

    public CookieSpec getCookieSpec(String r2, HttpParams r3) throws IllegalStateException {
        Args.notNull(r2, "Name");
        CookieSpecFactory r1 = this.registeredSpecs.get(r2.toLowerCase(Locale.ENGLISH));
        if (r1 == null) goto L7;
        return r1.newInstance(r3);
    L7:
        throw new IllegalStateException("Unsupported cookie spec: " + r2);
    }

    public CookieSpec getCookieSpec(String r2) throws IllegalStateException {
        return getCookieSpec(r2, null);
    }

    public List<String> getSpecNames() {
        return new ArrayList(this.registeredSpecs.keySet());
    }

    public void setItems(Map<String, CookieSpecFactory> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.registeredSpecs.clear();
        this.registeredSpecs.putAll(r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cz.msebera.android.httpclient.config.Lookup
    public CookieSpecProvider lookup(final String r2) {
        return new AnonymousClass1(this, r2);
    }
}
