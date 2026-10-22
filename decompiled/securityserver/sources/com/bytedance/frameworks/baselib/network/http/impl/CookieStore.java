package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CookieStore {
    void add(URI r1, HttpCookie r2);

    List<HttpCookie> get(URI r1);

    List<HttpCookie> getCookies();

    List<URI> getURIs();

    boolean remove(URI r1, HttpCookie r2);

    boolean removeAll();
}
