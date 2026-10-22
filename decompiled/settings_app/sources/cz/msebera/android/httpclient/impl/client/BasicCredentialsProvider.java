package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap<AuthScope, Credentials> credMap;

    public BasicCredentialsProvider() {
        this.credMap = new ConcurrentHashMap();
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void setCredentials(AuthScope r2, Credentials r3) {
        Args.notNull(r2, "Authentication scope");
        this.credMap.put(r2, r3);
    }

    private static Credentials matchCredentials(Map<AuthScope, Credentials> r6, AuthScope r7) {
        Credentials r0 = r6.get(r7);
        if (r0 != null) goto L18;
        Iterator<AuthScope> r1 = r6.keySet().iterator();
        int r2 = -1;
        AuthScope r3 = null;
    L6:
        if (r1.hasNext() == false) goto L10;
        AuthScope r4 = r1.next();
        int r5 = r7.match(r4);
        if (r5 <= r2) goto L6;
        r3 = r4;
        r2 = r5;
        goto L6
    L10:
        if (r3 != null) goto L12;
        return r0;
    L12:
        return r6.get(r3);
    L18:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public Credentials getCredentials(AuthScope r2) {
        Args.notNull(r2, "Authentication scope");
        return matchCredentials(this.credMap, r2);
    }

    @Override // cz.msebera.android.httpclient.client.CredentialsProvider
    public void clear() {
        this.credMap.clear();
    }

    public String toString() {
        return this.credMap.toString();
    }
}
