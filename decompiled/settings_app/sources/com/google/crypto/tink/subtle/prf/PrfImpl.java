package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public class PrfImpl implements Prf {
    private final StreamingPrf prfStreamer;

    private PrfImpl(StreamingPrf prfStreamer) {
        this.prfStreamer = prfStreamer;
    }

    public static PrfImpl wrap(StreamingPrf prfStreamer) {
        return new PrfImpl(prfStreamer);
    }

    private static byte[] readBytesFromStream(InputStream stream, int outputLength) throws GeneralSecurityException {
        byte[] r0 = new byte[outputLength];     // Catch: IOException -> L10
        int r1 = 0;
    L3:
        if (r1 >= outputLength) goto L9;
        int r2 = stream.read(r0, r1, outputLength - r1);     // Catch: IOException -> L10
        if (r2 <= 0) goto L8;
        r1 = r1 + r2;     // Catch: IOException -> L10
        goto L3
    L8:
        throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");     // Catch: IOException -> L10
    L9:
        return r0;
    L10:
        e = move-exception;
        throw new GeneralSecurityException(e);
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] input, int outputLength) throws GeneralSecurityException {
        if (input == null) goto L9;
        if (outputLength <= 0) goto L7;
        return readBytesFromStream(this.prfStreamer.computePrf(input), outputLength);
    L7:
        throw new GeneralSecurityException("Invalid outputLength specified.");
    L9:
        throw new GeneralSecurityException("Invalid input provided.");
    }
}
