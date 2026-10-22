package cz.msebera.android.httpclient.auth;

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
public final class AuthSchemeRegistry implements Lookup<AuthSchemeProvider> {
    private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes;

    @Override // cz.msebera.android.httpclient.config.Lookup
    public /* bridge */ /* synthetic */ AuthSchemeProvider lookup(String r1) {
        return lookup(r1);
    }

    public AuthSchemeRegistry() {
        this.registeredSchemes = new ConcurrentHashMap();
    }

    public void register(String r2, AuthSchemeFactory r3) {
        Args.notNull(r2, "Name");
        Args.notNull(r3, "Authentication scheme factory");
        this.registeredSchemes.put(r2.toLowerCase(Locale.ENGLISH), r3);
    }

    public void unregister(String r2) {
        Args.notNull(r2, "Name");
        this.registeredSchemes.remove(r2.toLowerCase(Locale.ENGLISH));
    }

    public AuthScheme getAuthScheme(String r2, HttpParams r3) throws IllegalStateException {
        Args.notNull(r2, "Name");
        AuthSchemeFactory r1 = this.registeredSchemes.get(r2.toLowerCase(Locale.ENGLISH));
        if (r1 == null) goto L7;
        return r1.newInstance(r3);
    L7:
        throw new IllegalStateException("Unsupported authentication scheme: " + r2);
    }

    public List<String> getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, AuthSchemeFactory> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.registeredSchemes.clear();
        this.registeredSchemes.putAll(r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cz.msebera.android.httpclient.config.Lookup
    public AuthSchemeProvider lookup(final String r2) {
        return new AnonymousClass1(this, r2);
    }
}
