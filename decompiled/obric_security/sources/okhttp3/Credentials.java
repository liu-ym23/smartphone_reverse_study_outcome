package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String r1, String r2) {
        return basic(r1, r2, Util.ISO_8859_1);
    }

    public static String basic(String r1, String r2, Charset r3) {
        return "Basic " + ByteString.encodeString(r1 + ":" + r2, r3).base64();
    }
}
