package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
final class ChunkedAesCmacVerification implements ChunkedMacVerification {
    private final ChunkedAesCmacComputation aesCmacComputation;
    private final Bytes tag;

    ChunkedAesCmacVerification(AesCmacKey key, byte[] tag) throws GeneralSecurityException {
        this.aesCmacComputation = new ChunkedAesCmacComputation(key);
        this.tag = Bytes.copyFrom(tag);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void update(ByteBuffer data) throws GeneralSecurityException {
        this.aesCmacComputation.update(data);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void verifyMac() throws GeneralSecurityException {
        byte[] r0 = this.aesCmacComputation.computeMac();
        if (this.tag.equals(Bytes.copyFrom(r0)) == false) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("invalid MAC");
    }
}
