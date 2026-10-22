package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f282a = "CryptorUtils";

    static {
    }

    public static String a(Context r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L16;
        return r4;
    L16:
        byte[] r5 = TccCryptor.decrypt(r3, z.a(r4, 0), null);     // Catch: Exception -> L10 UnsupportedEncodingException -> L12
        if (r5 == null) goto L15;
        return new String(r5, "gbk");
    L15:
        return null;
    L12:
        e = e;
        String r6 = f282a;
        StringBuilder r0 = new StringBuilder("getDecodeString, UnsupportedEncodingException: ");
    L14:
        q8.b(r6, r0.append(e).toString());
    L10:
        e = e;
        r6 = f282a;
        r0 = new StringBuilder("getDecodeString, Exception: ");
        goto L14
    }
}
