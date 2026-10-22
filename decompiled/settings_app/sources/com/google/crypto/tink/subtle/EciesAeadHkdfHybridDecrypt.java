package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.Util;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_AAD = null;
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final byte[] outputPrefix;
    private final EciesHkdfRecipientKem recipientKem;
    private final ECPrivateKey recipientPrivateKey;

    static {
        EMPTY_AAD = new byte[0];
    }

    private EciesAeadHkdfHybridDecrypt(final ECPrivateKey recipientPrivateKey, final byte[] hkdfSalt, String hkdfHmacAlgo, EllipticCurves.PointFormatType ecPointFormat, EciesAeadHkdfDemHelper demHelper, byte[] outputPrefix) throws GeneralSecurityException {
        this.recipientPrivateKey = recipientPrivateKey;
        this.recipientKem = new EciesHkdfRecipientKem(recipientPrivateKey);
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.ecPointFormat = ecPointFormat;
        this.demHelper = demHelper;
        this.outputPrefix = outputPrefix;
    }

    public static HybridDecrypt create(EciesPrivateKey key) throws GeneralSecurityException {
        ECPrivateKey r3 = EllipticCurves.getEcPrivateKey((EllipticCurves.CurveType) EciesAeadHkdfHybridEncrypt.CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType()), BigIntegerEncoding.toBigEndianBytes(key.getNistPrivateKeyValue().getBigInteger(InsecureSecretKeyAccess.get())));
        byte[] r0 = new byte[0];
        if (key.getParameters().getSalt() == null) goto L6;
        r0 = key.getParameters().getSalt().toByteArray();
    L6:
        return new EciesAeadHkdfHybridDecrypt(r3, r0, EciesAeadHkdfHybridEncrypt.toHmacAlgo(key.getParameters().getHashType()), (EllipticCurves.PointFormatType) EciesAeadHkdfHybridEncrypt.POINT_FORMAT_TYPE_CONVERTER.toProtoEnum(key.getParameters().getNistCurvePointFormat()), EciesAeadHkdfHybridEncrypt.createHelper(key.getParameters().getDemParameters()), key.getOutputPrefix().toByteArray());
    }

    private byte[] decryptNoPrefix(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        int r0 = EllipticCurves.encodingSizeInBytes(this.recipientPrivateKey.getParams().getCurve(), this.ecPointFormat);
        if (ciphertext.length < r0) goto L7;
        byte[] r3 = Arrays.copyOfRange(ciphertext, 0, r0);
        byte[] r11 = this.recipientKem.generateKey(r3, this.hkdfHmacAlgo, this.hkdfSalt, contextInfo, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        return this.demHelper.getAeadOrDaead(r11).decrypt(Arrays.copyOfRange(ciphertext, r0, ciphertext.length), EMPTY_AAD);
    L7:
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L7;
        return decryptNoPrefix(ciphertext, contextInfo);
    L7:
        if (Util.isPrefix(r0, ciphertext) == false) goto L11;
        return decryptNoPrefix(Arrays.copyOfRange(ciphertext, this.outputPrefix.length, ciphertext.length), contextInfo);
    L11:
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
