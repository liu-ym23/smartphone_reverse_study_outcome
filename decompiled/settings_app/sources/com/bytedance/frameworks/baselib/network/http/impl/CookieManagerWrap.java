package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class CookieManagerWrap extends CookieManager {
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private CookiePolicy policy;
    private CookieStore store;

    public CookieManagerWrap() {
        this(null, null);
    }

    public CookieManagerWrap(CookieStore r1, CookiePolicy r2) {
        if (r1 != null) goto L5;
        r1 = new CookieStoreImpl();
    L5:
        this.store = r1;
        if (r2 != null) goto L8;
        r2 = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
    L8:
        this.policy = r2;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r3, Map<String, List<String>> r4) throws IOException {
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        ArrayList r5 = new ArrayList();
        Iterator<HttpCookie> r2 = this.store.get(r3).iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        HttpCookie r0 = r2.next();
        if (HttpCookie.pathMatches(r0, r3) == false) goto L6;
        if (HttpCookie.secureMatches(r0, r3) == false) goto L6;
        if (HttpCookie.portMatches(r0, r3) == false) goto L6;
        r5.add(r0);
        goto L6
    L15:
        return cookiesToHeaders(r5);
    L17:
        throw new IllegalArgumentException();
    }

    private static Map<String, List<String>> cookiesToHeaders(List<HttpCookie> r5) {
        if (r5.isEmpty() == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        Iterator<HttpCookie> r1 = r5.iterator();
        int r2 = 1;
        int r3 = 1;
    L8:
        if (r1.hasNext() == false) goto L10;
        r3 = Math.min(r3, r1.next().getVersion());
        goto L8
    L10:
        if (r3 != 1) goto L12;
        r0.append("$Version=\"1\"; ");
    L12:
        r0.append(r5.get(0).toString());
    L14:
        if (r2 >= r5.size()) goto L17;
        r0.append(VectorFormat.DEFAULT_SEPARATOR).append(r5.get(r2).toString());
        r2 = r2 + 1;
        goto L14
    L17:
        return Collections.singletonMap("Cookie", Collections.singletonList(r0.toString()));
    L5:
        return Collections.emptyMap();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r1, Map<String, List<String>> r2) throws IOException {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        putInternal(r1, parseCookie(r2));
        return;
    L7:
        throw new IllegalArgumentException();
    }

    public void put(URI r4, List<String> r5) throws IOException {
        if (r4 == null) goto L15;
        if (r5 == null) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator<String> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        String r1 = r6.next();
        if (StringUtils.isEmpty(r1) == true) goto L6;
        r0.addAll(HttpCookie.parse(r1));     // Catch: IllegalArgumentException -> L16
        goto L6
    L12:
        putInternal(r4, r0);
        return;
    L15:
        throw new IllegalArgumentException();
    }

    private void putInternal(URI r4, List<HttpCookie> r5) {
        if (Lists.isEmpty(r5) == false) goto L5;
        return;
    L5:
        Iterator<HttpCookie> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L25;
        HttpCookie r0 = r6.next();
        if (TextUtils.isEmpty(r0.getDomain()) == false) goto L12;
        r0.setDomain(r4.getHost());
    L12:
        if (TextUtils.isEmpty(r0.getPath()) == false) goto L15;
        r0.setPath(pathToCookiePath(r4.getPath()));
    L15:
        if ("".equals(r0.getPortlist()) == true) goto L16;
        if (r0.getPortlist() == null) goto L23;
        if (HttpCookie.portMatches(r0, r4) == false) goto L7;
    L23:
        if (this.policy.shouldAccept(r4, r0) == false) goto L7;
        this.store.add(r4, r0);
        goto L7
    L16:
        r0.setPortlist(Integer.toString(SerializableHttpCookie.getEffectivePort(r4.getScheme(), r4.getPort())));
        goto L23
    }

    public void setCookie(URI r2, String r3) throws IOException {
        if (r2 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r3) == true) goto L14;
        List<HttpCookie> r4 = HttpCookie.parse(r3);     // Catch: IllegalArgumentException -> L8
    L9:
        putInternal(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public static String pathToCookiePath(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return LibrarianImpl.Constants.SEPARATOR;
    L7:
        return r2.substring(0, r2.lastIndexOf(47) + 1);
    }

    private static List<HttpCookie> parseCookie(Map<String, List<String>> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        Map.Entry<String, List<String>> r1 = r5.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L4;
        if (r2.equalsIgnoreCase(VERSION_ZERO_HEADER) == true) goto L11;
        if (r2.equalsIgnoreCase(VERSION_ONE_HEADER) == false) goto L4;
    L11:
        Iterator<String> r3 = r1.getValue().iterator();
    L13:
        if (r3.hasNext() == false) goto L4;
        Iterator<HttpCookie> r6 = HttpCookie.parse(r3.next()).iterator();     // Catch: IllegalArgumentException -> L21
    L17:
        if (r6.hasNext() == false) goto L13;
        r0.add(r6.next());     // Catch: IllegalArgumentException -> L21
    L20:
        return r0;
    }

    public void setCookiePolicy(CookiePolicy r1) {
        if (r1 == null) goto L5;
        this.policy = r1;
        return;
    }
}
