package com.bytedance.frameworks.baselib.network.http.impl;

import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CookieStoreImpl implements CookieStore {
    private final Map<URI, List<HttpCookie>> map;

    public CookieStoreImpl() {
        this.map = new HashMap();
    }

    private URI cookiesUri(URI r4) {
        if (r4 != null) goto L8;
        return null;
    L8:
        return new URI(HttpHost.DEFAULT_SCHEME_NAME, r4.getHost(), null, null);
    L7:
        return r4;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI r3, HttpCookie r4) {
        monitor-enter(this);
        if (r4 == null) goto L14;
        URI r5 = cookiesUri(r3);     // Catch: Throwable -> L7
        List<HttpCookie> r0 = this.map.get(r5);     // Catch: Throwable -> L7
        if (r0 != null) goto L9;
        r0 = new ArrayList();     // Catch: Throwable -> L7
        this.map.put(r5, r0);     // Catch: Throwable -> L7
    L10:
        r0.add(r4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        r0.remove(r4);     // Catch: Throwable -> L7
        goto L10
    L14:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> get(URI r7) {
        monitor-enter(this);
        if (r7 == null) goto L37;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L12
        List<HttpCookie> r1 = this.map.get(r7);     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        Iterator<HttpCookie> r2 = r1.iterator();     // Catch: Throwable -> L12
    L8:
        if (r2.hasNext() == false) goto L15;
        HttpCookie r3 = r2.next();     // Catch: Throwable -> L12
        if (r3.hasExpired() == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L12
        goto L8
    L11:
        r2.remove();     // Catch: Throwable -> L12
    L15:
        Iterator<Map.Entry<URI, List<HttpCookie>>> r4 = this.map.entrySet().iterator();     // Catch: Throwable -> L12
    L17:
        if (r4.hasNext() == false) goto L33;
        Map.Entry<URI, List<HttpCookie>> r5 = r4.next();     // Catch: Throwable -> L12
        if (r7.equals(r5.getKey()) == true) goto L17;
        Iterator<HttpCookie> r6 = r5.getValue().iterator();     // Catch: Throwable -> L12
    L23:
        if (r6.hasNext() == false) goto L17;
        HttpCookie r8 = r6.next();     // Catch: Throwable -> L12
        if (HttpCookie.domainMatches(r8.getDomain(), r7.getHost()) == false) goto L23;
        if (r8.hasExpired() == true) goto L29;
        if (r0.contains(r8) == true) goto L23;
        r0.add(r8);     // Catch: Throwable -> L12
        goto L23
    L29:
        r6.remove();     // Catch: Throwable -> L12
        goto L23
    L33:
        List<HttpCookie> r9 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r9;
    L37:
        throw new NullPointerException("uri == null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> getCookies() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<List<HttpCookie>> r1 = this.map.values().iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L17;
        Iterator<HttpCookie> r2 = r1.next().iterator();     // Catch: Throwable -> L12
    L8:
        if (r2.hasNext() == false) goto L5;
        HttpCookie r3 = r2.next();     // Catch: Throwable -> L12
        if (r3.hasExpired() == true) goto L11;
        if (r0.contains(r3) == true) goto L8;
        r0.add(r3);     // Catch: Throwable -> L12
        goto L8
    L11:
        r2.remove();     // Catch: Throwable -> L12
        goto L8
    L17:
        List<HttpCookie> r4 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r4;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<URI> getURIs() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.map.keySet());     // Catch: Throwable -> L6
        r0.remove(null);     // Catch: Throwable -> L6
        List<URI> r1 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI r2, HttpCookie r3) {
        monitor-enter(this);
        if (r3 == null) goto L15;
        List<HttpCookie> r4 = this.map.get(cookiesUri(r2));     // Catch: Throwable -> L9
        if (r4 == null) goto L11;
        boolean r5 = r4.remove(r3);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r5;
    L11:
        monitor-exit(this);
        return false;
    L15:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        monitor-enter(this);
        boolean r0 = !this.map.isEmpty();     // Catch: Throwable -> L6
        this.map.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
