package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
final class HkdfHpkeKdf implements HpkeKdf {
    private final String macAlgorithm;

    HkdfHpkeKdf(String macAlgorithm) {
        this.macAlgorithm = macAlgorithm;
    }

    private byte[] extract(final byte[] ikm, final byte[] salt) throws GeneralSecurityException {
        Mac r0 = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (salt != null) goto L5;
    L8:
        r0.init(new SecretKeySpec(new byte[r0.getMacLength()], this.macAlgorithm));
    L10:
        return r0.doFinal(ikm);
    L5:
        if (salt.length == 0) goto L8;
        r0.init(new SecretKeySpec(salt, this.macAlgorithm));
        goto L10
    }

    private byte[] expand(final byte[] prk, final byte[] info, int length) throws GeneralSecurityException {
        Mac r0 = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (length > (r0.getMacLength() * 255)) goto L11;
        byte[] r1 = new byte[length];
        r0.init(new SecretKeySpec(prk, this.macAlgorithm));
        byte[] r6 = new byte[0];
        int r2 = 1;
        int r3 = 0;
    L5:
        r0.update(r6);
        r0.update(info);
        r0.update((byte) r2);
        r6 = r0.doFinal();
        if ((r6.length + r3) >= length) goto L8;
        System.arraycopy(r6, 0, r1, r3, r6.length);
        r3 = r3 + r6.length;
        r2 = r2 + 1;
        goto L5
    L8:
        System.arraycopy(r6, 0, r1, r3, length - r3);
        return r1;
    L11:
        throw new GeneralSecurityException("size too large");
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExtract(byte[] salt, byte[] ikm, String ikmLabel, byte[] suiteId) throws GeneralSecurityException {
        return extract(HpkeUtil.labelIkm(ikmLabel, ikm, suiteId), salt);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExpand(byte[] prk, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException {
        return expand(prk, HpkeUtil.labelInfo(infoLabel, info, suiteId, length), length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] extractAndExpand(byte[] salt, byte[] ikm, String ikmLabel, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException {
        return expand(extract(HpkeUtil.labelIkm(ikmLabel, ikm, suiteId), salt), HpkeUtil.labelInfo(infoLabel, info, suiteId, length), length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] getKdfId() throws GeneralSecurityException {
        String r2 = this.macAlgorithm;
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case 984523022: goto L14;
            case 984524074: goto L10;
            case 984525777: goto L6;
            default: goto L17;
        };
    L17:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        throw new GeneralSecurityException("Could not determine HPKE KDF ID");
    L21:
        return HpkeUtil.HKDF_SHA512_KDF_ID;
    L23:
        return HpkeUtil.HKDF_SHA384_KDF_ID;
    L25:
        return HpkeUtil.HKDF_SHA256_KDF_ID;
    L6:
        if (r2.equals("HmacSha512") == false) goto L17;
        r1 = 2;
        goto L17
    L10:
        if (r2.equals("HmacSha384") == false) goto L17;
        r1 = 1;
        goto L17
    L14:
        if (r2.equals("HmacSha256") == false) goto L17;
        r1 = 0;
        goto L17
    }

    int getMacLength() throws GeneralSecurityException {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }
}
