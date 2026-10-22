package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class URIUtils {
    public static URI createURI(String r1, String r2, int r3, String r4, String r5, String r6) throws URISyntaxException {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        if (r4 != null) goto L11;
    L12:
        r0.append(IOUtils.DIR_SEPARATOR_UNIX);
    L13:
        if (r4 == null) goto L15;
        r0.append(r4);
    L15:
        if (r5 == null) goto L17;
        r0.append('?');
        r0.append(r5);
    L17:
        if (r6 == null) goto L20;
        r0.append('#');
        r0.append(r6);
    L20:
        return new URI(r0.toString());
    L11:
        if (r4.startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L13;
        goto L12
    }

    public static URI rewriteURI(URI r7, HttpHost r8, boolean r9) throws URISyntaxException {
        if (r7 == null) goto L18;
        String r0 = null;
        if (r8 == null) goto L11;
        String r1 = r8.getSchemeName();
        String r2 = r8.getHostName();
        int r3 = r8.getPort();
        String r4 = r7.getRawPath();
        String r5 = r7.getRawQuery();
        if (r9 == true) goto L10;
        r0 = r7.getRawFragment();
    L10:
        return createURI(r1, r2, r3, r4, r5, r0);
    L11:
        String r6 = r7.getRawPath();
        String r10 = r7.getRawQuery();
        if (r9 == true) goto L16;
        r0 = r7.getRawFragment();
    L16:
        return createURI(null, null, -1, r6, r10, r0);
    L18:
        throw new IllegalArgumentException("URI may nor be null");
    }

    public static URI rewriteURI(URI r1, HttpHost r2) throws URISyntaxException {
        return rewriteURI(r1, r2, false);
    }

    public static URI resolve(URI r0, String r1) {
        return resolve(r0, URI.create(r1));
    }

    public static URI resolve(URI r2, URI r3) {
        if (r2 == null) goto L17;
        if (r3 == null) goto L15;
        if (r3.toString().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r3 = URI.create("#");
    L10:
        URI r4 = r2.resolve(r3);
        if (r0 == false) goto L18;
        String r5 = r4.toString();
        return URI.create(r5.substring(0, r5.indexOf(35)));
    L18:
        return r4;
    L7:
        r0 = false;
        goto L8
    L15:
        throw new IllegalArgumentException("Reference URI may nor be null");
    L17:
        throw new IllegalArgumentException("Base URI may nor be null");
    }

    private URIUtils() {
    }

    public static URI safeCreateUri(String r2) throws RuntimeException {
        if (StringUtils.isEmpty(r2) == false) goto L12;
        return null;
    L12:
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r2);
    }

    public static URI createUriWithOutQuery(String r2) throws RuntimeException {
        if (StringUtils.isEmpty(r2) == false) goto L14;
        return null;
    L14:
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
