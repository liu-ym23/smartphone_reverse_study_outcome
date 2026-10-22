package d.b.h.a.a.h.s;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static URI a(String r2) {
        if (com.bytedance.common.utility.k.c(r2) == false) goto L14;
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

    public static URI b(String r2) {
        if (com.bytedance.common.utility.k.c(r2) == false) goto L12;
        return null;
    L12:
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return a(r2);
    }
}
