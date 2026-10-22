package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class ChunkedAesCmacImpl implements ChunkedMac {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private final AesCmacKey key;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public ChunkedAesCmacImpl(AesCmacKey key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        this.key = key;
        return;
    L7:
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacComputation createComputation() throws GeneralSecurityException {
        return new ChunkedAesCmacComputation(this.key);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacVerification createVerification(final byte[] tag) throws GeneralSecurityException {
        if (tag.length < this.key.getOutputPrefix().size()) goto L11;
        if (this.key.getOutputPrefix().equals(Bytes.copyFrom(tag, 0, this.key.getOutputPrefix().size())) == false) goto L9;
        return new ChunkedAesCmacVerification(this.key, tag);
    L9:
        throw new GeneralSecurityException("Wrong tag prefix");
    L11:
        throw new GeneralSecurityException("Tag too short");
    }
}
