package com.obric.safecheck.util.serviceutil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class UrlMatch {
    public static final Pattern WEB_URL = null;
    private static final String WEB_URL_PATTERN = null;

    private static String buildWebUrlPattern() {
        return "((?:(rtsp|https|http):\\/\\/(?:(?:(?:(?:\\%[a-fA-F0-9]{2})|[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=])){1,64}(?:\\:(?:(?:(?:\\d%[a-fA-F0-9]{2})|[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=])){1,25})?\\@)?)?)?((?:(?:(?:(?:[1-9]|[1-9][0-9]|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:0|[1-9]|[1-9][0-9]|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:0|[1-9]|[1-9][0-9]|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])\\.(?:[0-9]|[1-9][0-9]|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5])))|(?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}\\.)+(?:museum|travel|mobi|blue|club|tech|aero|asia|arpa|info|coop|name|org|net|tel|top|biz|cat|com|edu|gov|int|jobs|love|mil|pro|ren|om|qa|z[amw]|y[etu]|w[fs]|v[aceginu]|u[agkmsyz]|t[cdfghjklmnoprtvwz]|s[abcdeghijklmnortuvyz]|r[eouw]|p[aefghklmnrstwy]|n[acefgilopruz]|m[acdeghklmnopqrstuvwxyz]|l[abcikrstuvy]|k[eghimnrwyz]|j[emop]|i[delmnoqrst]|h[kmnrtu]|g[abdefghilmnpqrstuwy]|f[ijkmor]|e[cegrstu]|d[ejkmoz]|c[acdfghiklmnoruvxyz]|b[abdefghijmnorstvwyz]|a[cdefgilmnoqrstuwxz])))(?:\\:\\d{1,5})?)(\\/(?:(?:(?:\\%[a-fA-F0-9]{2}))|(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_]))*)?(?:(?:($|\\b|(?=([\\u0800-\\u9fa5]+?)))))";
    }

    public UrlMatch() {
    }

    static {
        String r0 = buildWebUrlPattern();
        WEB_URL_PATTERN = r0;
        WEB_URL = Pattern.compile(r0, 2);
    }

    public static List<String> mathUrl(List<String> candidates) {
        final ArrayList r0 = new ArrayList();
        candidates.forEach(new UrlMatch$$ExternalSyntheticLambda0(r0));
        return r0;
    }

    static /* synthetic */ void lambda$mathUrl$0(ArrayList r4, String r5) {
        Matcher r0 = WEB_URL.matcher(r5);
        boolean r2 = false;
    L4:
        if (r0.find() == false) goto L6;
        r4.add(r0.group());
        r2 = true;
        goto L4
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        if (r5.startsWith("http://") == false) goto L10;
    L11:
        String r1 = UrlDomainParser.INSTANCE.parseDomainFromUrl(r5, false);
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.isEmpty() == true) goto L21;
        r4.add(r5);
        return;
    L21:
        return;
    L10:
        if (r5.startsWith("https://") == true) goto L11;
    }
}
