package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.config.ConnectionConfig;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnSupport {
    public ConnSupport() {
    }

    public static CharsetDecoder createDecoder(ConnectionConfig r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Charset r1 = r3.getCharset();
        CodingErrorAction r2 = r3.getMalformedInputAction();
        CodingErrorAction r4 = r3.getUnmappableInputAction();
        if (r1 == null) goto L17;
        CharsetDecoder r0 = r1.newDecoder();
        if (r2 != null) goto L11;
        r2 = CodingErrorAction.REPORT;
    L11:
        CharsetDecoder r5 = r0.onMalformedInput(r2);
        if (r4 != null) goto L16;
        r4 = CodingErrorAction.REPORT;
    L16:
        return r5.onUnmappableCharacter(r4);
    L17:
        return null;
    }

    public static CharsetEncoder createEncoder(ConnectionConfig r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Charset r1 = r2.getCharset();
        if (r1 == null) goto L17;
        CodingErrorAction r0 = r2.getMalformedInputAction();
        CodingErrorAction r3 = r2.getUnmappableInputAction();
        CharsetEncoder r4 = r1.newEncoder();
        if (r0 != null) goto L11;
        r0 = CodingErrorAction.REPORT;
    L11:
        CharsetEncoder r5 = r4.onMalformedInput(r0);
        if (r3 != null) goto L16;
        r3 = CodingErrorAction.REPORT;
    L16:
        return r5.onUnmappableCharacter(r3);
    L17:
        return null;
    }
}
