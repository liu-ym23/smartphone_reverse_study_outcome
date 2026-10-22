package cz.msebera.android.httpclient.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public class CharsetUtils {
    public CharsetUtils() {
    }

    public static Charset lookup(String r1) {
        if (r1 != null) goto L8;
        return null;
    L8:
        return Charset.forName(r1);
    L7:
        return null;
    }

    public static Charset get(String r1) throws UnsupportedEncodingException {
        if (r1 != null) goto L9;
        return null;
    L9:
        return Charset.forName(r1);
    L8:
        throw new UnsupportedEncodingException(r1);
    }
}
