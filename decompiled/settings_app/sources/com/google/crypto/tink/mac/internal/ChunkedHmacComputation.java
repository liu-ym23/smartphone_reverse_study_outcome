package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
final class ChunkedHmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = null;
    private boolean finalized;
    private final HmacKey key;
    private final Mac mac;

    static {
        FORMAT_VERSION = new byte[]{0};
    }

    ChunkedHmacComputation(HmacKey key) throws GeneralSecurityException {
        this.finalized = false;
        Mac r0 = EngineFactory.MAC.getInstance(composeAlgorithmName(key));
        this.mac = r0;
        r0.init(new SecretKeySpec(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC"));
        this.key = key;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public void update(ByteBuffer data) {
        if (this.finalized == true) goto L7;
        this.mac.update(data);
        return;
    L7:
        throw new IllegalStateException("Cannot update after computing the MAC tag. Please create a new object.");
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public byte[] computeMac() throws GeneralSecurityException {
        if (this.finalized == true) goto L10;
        if (this.key.getParameters().getVariant() != HmacParameters.Variant.LEGACY) goto L7;
        update(ByteBuffer.wrap(FORMAT_VERSION));
    L7:
        this.finalized = true;
        return Bytes.concat(new byte[][]{this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.mac.doFinal(), this.key.getParameters().getCryptographicTagSizeBytes())});
    L10:
        throw new IllegalStateException("Cannot compute after already computing the MAC tag. Please create a new object.");
    }

    private static String composeAlgorithmName(HmacKey key) {
        return "HMAC" + key.getParameters().getHashType();
    }
}
