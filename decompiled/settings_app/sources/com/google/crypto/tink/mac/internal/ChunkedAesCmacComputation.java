package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
final class ChunkedAesCmacComputation implements ChunkedMacComputation {
    private static final byte[] FORMAT_VERSION = null;
    private final Cipher aes;
    private boolean finalized;
    private final AesCmacKey key;
    private final ByteBuffer localStash;
    private final byte[] subKey1;
    private final byte[] subKey2;
    private final ByteBuffer x;
    private final ByteBuffer y;

    static {
        FORMAT_VERSION = new byte[]{0};
    }

    ChunkedAesCmacComputation(AesCmacKey key) throws GeneralSecurityException {
        this.finalized = false;
        this.key = key;
        Cipher r0 = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        this.aes = r0;
        r0.init(1, new SecretKeySpec(key.getAesKey().toByteArray(InsecureSecretKeyAccess.get()), "AES"));
        byte[] r1 = AesUtil.dbl(r0.doFinal(new byte[16]));
        this.subKey1 = r1;
        this.subKey2 = AesUtil.dbl(r1);
        this.localStash = ByteBuffer.allocate(16);
        this.x = ByteBuffer.allocate(16);
        this.y = ByteBuffer.allocate(16);
    }

    private void munch(ByteBuffer data) throws GeneralSecurityException {
        this.y.rewind();
        this.x.rewind();
        Bytes.xor(this.y, this.x, data, 16);
        this.y.rewind();
        this.x.rewind();
        this.aes.doFinal(this.y, this.x);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public void update(ByteBuffer data) throws GeneralSecurityException {
        if (this.finalized == true) goto L20;
        if (this.localStash.remaining() == 16) goto L10;
        int r0 = Math.min(this.localStash.remaining(), data.remaining());
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L10;
        this.localStash.put(data.get());
        r2 = r2 + 1;
    L10:
        if (this.localStash.remaining() != 0) goto L15;
        if (data.remaining() <= 0) goto L15;
        this.localStash.rewind();
        munch(this.localStash);
        this.localStash.rewind();
    L15:
        if (data.remaining() <= 16) goto L17;
        munch(data);
        goto L15
    L17:
        this.localStash.put(data);
        return;
    L20:
        throw new IllegalStateException("Can not update after computing the MAC tag. Please create a new object.");
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacComputation
    public byte[] computeMac() throws GeneralSecurityException {
        if (this.finalized == true) goto L14;
        if (this.key.getParameters().getVariant() != AesCmacParameters.Variant.LEGACY) goto L7;
        update(ByteBuffer.wrap(FORMAT_VERSION));
    L7:
        this.finalized = true;
        if (this.localStash.remaining() <= 0) goto L10;
        byte[] r1 = Bytes.xor(AesUtil.cmacPad(Arrays.copyOf(this.localStash.array(), this.localStash.position())), this.subKey2);
    L12:
        return Bytes.concat(new byte[][]{this.key.getOutputPrefix().toByteArray(), Arrays.copyOf(this.aes.doFinal(Bytes.xor(r1, this.x.array())), this.key.getParameters().getCryptographicTagSizeBytes())});
    L10:
        r1 = Bytes.xor(this.localStash.array(), 0, this.subKey1, 0, 16);
        goto L12
    L14:
        throw new IllegalStateException("Can not compute after computing the MAC tag. Please create a new object.");
    }
}
