package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
final class NistCurvesHpkeKem implements HpkeKem {
    private final EllipticCurves.CurveType curve;
    private final HkdfHpkeKdf hkdf;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.NistCurvesHpkeKem$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = null;

        static {
            int[] r0 = new int[EllipticCurves.CurveType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = r0;
            r0[EllipticCurves.CurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[EllipticCurves.CurveType.NIST_P384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[EllipticCurves.CurveType.NIST_P521.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static NistCurvesHpkeKem fromCurve(EllipticCurves.CurveType curve) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curve.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha512"), EllipticCurves.CurveType.NIST_P521);
    L11:
        throw new GeneralSecurityException("invalid curve type: " + curve);
    L13:
        return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha384"), EllipticCurves.CurveType.NIST_P384);
    L15:
        return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha256"), EllipticCurves.CurveType.NIST_P256);
    }

    private NistCurvesHpkeKem(HkdfHpkeKdf hkdf, EllipticCurves.CurveType curve) {
        this.hkdf = hkdf;
        this.curve = curve;
    }

    private byte[] deriveKemSharedSecret(byte[] dhSharedSecret, byte[] senderEphemeralPublicKey, byte[] recipientPublicKey) throws GeneralSecurityException {
        return extractAndExpand(dhSharedSecret, Bytes.concat(new byte[][]{senderEphemeralPublicKey, recipientPublicKey}));
    }

    private byte[] deriveKemSharedSecret(byte[] dhSharedSecret, byte[] senderEphemeralPublicKey, byte[] recipientPublicKey, byte[] senderPublicKey) throws GeneralSecurityException {
        return extractAndExpand(dhSharedSecret, Bytes.concat(new byte[][]{senderEphemeralPublicKey, recipientPublicKey, senderPublicKey}));
    }

    private byte[] extractAndExpand(byte[] dhSharedSecret, byte[] kemContext) throws GeneralSecurityException {
        byte[] r7 = HpkeUtil.kemSuiteId(getKemId());
        HkdfHpkeKdf r1 = this.hkdf;
        return r1.extractAndExpand(null, dhSharedSecret, "eae_prk", kemContext, "shared_secret", r7, r1.getMacLength());
    }

    HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey, KeyPair senderEphemeralKeyPair) throws GeneralSecurityException {
        ECPublicKey r0 = EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, recipientPublicKey);
        byte[] r1 = EllipticCurves.computeSharedSecret((ECPrivateKey) senderEphemeralKeyPair.getPrivate(), r0);
        byte[] r5 = EllipticCurves.pointEncode(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, ((ECPublicKey) senderEphemeralKeyPair.getPublic()).getW());
        return new HpkeKemEncapOutput(deriveKemSharedSecret(r1, r5, recipientPublicKey), r5);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey) throws GeneralSecurityException {
        return encapsulate(recipientPublicKey, EllipticCurves.generateKeyPair(this.curve));
    }

    HpkeKemEncapOutput authEncapsulate(byte[] recipientPublicKey, KeyPair senderEphemeralKeyPair, HpkeKemPrivateKey senderPrivateKey) throws GeneralSecurityException {
        ECPublicKey r0 = EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, recipientPublicKey);
        byte[] r1 = Bytes.concat(new byte[][]{EllipticCurves.computeSharedSecret((ECPrivateKey) senderEphemeralKeyPair.getPrivate(), r0), EllipticCurves.computeSharedSecret(EllipticCurves.getEcPrivateKey(this.curve, senderPrivateKey.getSerializedPrivate().toByteArray()), r0)});
        byte[] r7 = EllipticCurves.pointEncode(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, ((ECPublicKey) senderEphemeralKeyPair.getPublic()).getW());
        return new HpkeKemEncapOutput(deriveKemSharedSecret(r1, r7, recipientPublicKey, senderPrivateKey.getSerializedPublic().toByteArray()), r7);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput authEncapsulate(byte[] recipientPublicKey, HpkeKemPrivateKey senderPrivateKey) throws GeneralSecurityException {
        return authEncapsulate(recipientPublicKey, EllipticCurves.generateKeyPair(this.curve), senderPrivateKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey) throws GeneralSecurityException {
        return deriveKemSharedSecret(EllipticCurves.computeSharedSecret(EllipticCurves.getEcPrivateKey(this.curve, recipientPrivateKey.getSerializedPrivate().toByteArray()), EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, encapsulatedKey)), encapsulatedKey, recipientPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] authDecapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey, byte[] senderPublicKey) throws GeneralSecurityException {
        ECPrivateKey r0 = EllipticCurves.getEcPrivateKey(this.curve, recipientPrivateKey.getSerializedPrivate().toByteArray());
        return deriveKemSharedSecret(Bytes.concat(new byte[][]{EllipticCurves.computeSharedSecret(r0, EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, encapsulatedKey)), EllipticCurves.computeSharedSecret(r0, EllipticCurves.getEcPublicKey(this.curve, EllipticCurves.PointFormatType.UNCOMPRESSED, senderPublicKey))}), encapsulatedKey, recipientPrivateKey.getSerializedPublic().toByteArray(), senderPublicKey);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[this.curve.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return HpkeUtil.P521_HKDF_SHA512_KEM_ID;
    L11:
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    L13:
        return HpkeUtil.P384_HKDF_SHA384_KEM_ID;
    L15:
        return HpkeUtil.P256_HKDF_SHA256_KEM_ID;
    }
}
