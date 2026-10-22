package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CookieStoreImpl implements CookieStore {
    private final Map<URI, List<HttpCookie>> map;

    public CookieStoreImpl() {
        this.map = new HashMap();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI r3, HttpCookie r4) {
        monitor-enter(this);
        if (r4 == null) goto L14;
        URI r5 = cookiesUri(r3);     // Catch: Throwable -> L11
        List<HttpCookie> r0 = this.map.get(r5);     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        r0 = new ArrayList();     // Catch: Throwable -> L11
        this.map.put(r5, r0);     // Catch: Throwable -> L11
    L8:
        r0.add(r4);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r0.remove(r4);     // Catch: Throwable -> L11
        goto L8
    L14:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private URI cookiesUri(URI r4) {
        if (r4 != null) goto L8;
        return null;
    L8:
        return new URI("http", r4.getHost(), null, null);
    L7:
        return r4;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> get(URI r7) {
        monitor-enter(this);
        if (r7 == null) goto L37;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L34
        List<HttpCookie> r1 = this.map.get(r7);     // Catch: Throwable -> L34
        if (r1 == null) goto L13;
        Iterator<HttpCookie> r2 = r1.iterator();     // Catch: Throwable -> L34
    L8:
        if (r2.hasNext() == false) goto L13;
        HttpCookie r3 = r2.next();     // Catch: Throwable -> L34
        if (r3.hasExpired() == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L34
        goto L8
    L11:
        r2.remove();     // Catch: Throwable -> L34
    L13:
        Iterator<Map.Entry<URI, List<HttpCookie>>> r4 = this.map.entrySet().iterator();     // Catch: Throwable -> L34
    L15:
        if (r4.hasNext() == false) goto L31;
        Map.Entry<URI, List<HttpCookie>> r5 = r4.next();     // Catch: Throwable -> L34
        if (r7.equals(r5.getKey()) == true) goto L15;
        Iterator<HttpCookie> r6 = r5.getValue().iterator();     // Catch: Throwable -> L34
    L21:
        if (r6.hasNext() == false) goto L15;
        HttpCookie r8 = r6.next();     // Catch: Throwable -> L34
        if (HttpCookie.domainMatches(r8.getDomain(), r7.getHost()) == false) goto L21;
        if (r8.hasExpired() == true) goto L27;
        if (r0.contains(r8) == true) goto L21;
        r0.add(r8);     // Catch: Throwable -> L34
        goto L21
    L27:
        r6.remove();     // Catch: Throwable -> L34
        goto L21
    L31:
        List<HttpCookie> r9 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r9;
    L37:
        throw new NullPointerException("uri == null");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> getCookies() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<List<HttpCookie>> r1 = this.map.values().iterator();     // Catch: Throwable -> L18
    L5:
        if (r1.hasNext() == false) goto L15;
        Iterator<HttpCookie> r2 = r1.next().iterator();     // Catch: Throwable -> L18
    L8:
        if (r2.hasNext() == false) goto L5;
        HttpCookie r3 = r2.next();     // Catch: Throwable -> L18
        if (r3.hasExpired() == true) goto L11;
        if (r0.contains(r3) == true) goto L8;
        r0.add(r3);     // Catch: Throwable -> L18
        goto L8
    L11:
        r2.remove();     // Catch: Throwable -> L18
        goto L8
    L15:
        List<HttpCookie> r4 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r4;
    L18:
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
        List<HttpCookie> r4 = this.map.get(cookiesUri(r2));     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        boolean r5 = r4.remove(r3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r5;
    L9:
        monitor-exit(this);
        return false;
    L15:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.map.isEmpty() == true) goto L6;
        boolean r0 = true;
    L7:
        this.map.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
        goto L7
    }
}
