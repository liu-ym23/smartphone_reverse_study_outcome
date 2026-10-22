package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class Validators {
    private static final Pattern GCP_KMS_CRYPTO_KEY_PATTERN = null;
    private static final Pattern GCP_KMS_CRYPTO_KEY_VERSION_PATTERN = null;
    private static final int MIN_RSA_MODULUS_SIZE = 2048;
    private static final String TYPE_URL_PREFIX = "type.googleapis.com/";
    private static final String URI_UNRESERVED_CHARS = "([0-9a-zA-Z\\-\\.\\_~])+";

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.Validators$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = null;

        static {
            int[] r0 = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0;
            r0[Enums.HashType.SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private Validators() {
    }

    public static void validateTypeUrl(String typeUrl) throws GeneralSecurityException {
        if (typeUrl.startsWith(TYPE_URL_PREFIX) == false) goto L10;
        if (typeUrl.length() == 20) goto L8;
        return;
    L8:
        throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it has no message name.\n", new Object[]{typeUrl}));
    L10:
        throw new GeneralSecurityException(String.format("Error: type URL %s is invalid; it must start with %s.\n", new Object[]{typeUrl, TYPE_URL_PREFIX}));
    }

    public static void validateAesKeySize(int sizeInBytes) throws InvalidAlgorithmParameterException {
        if (sizeInBytes != 16) goto L5;
        return;
    L5:
        if (sizeInBytes != 32) goto L8;
        return;
    L8:
        throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(sizeInBytes * 8)}));
    }

    public static void validateVersion(int candidate, int maxExpected) throws GeneralSecurityException {
        if (candidate < 0) goto L6;
        if (candidate > maxExpected) goto L6;
        return;
    L6:
        throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(candidate), Integer.valueOf(maxExpected)}));
    }

    public static void validateSignatureHash(Enums.HashType hash) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (r0 != 1) goto L5;
        return;
    L5:
        if (r0 != 2) goto L7;
        return;
    L7:
        if (r0 != 3) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Unsupported hash: " + hash.name());
    }

    public static void validateRsaModulusSize(int modulusSize) throws GeneralSecurityException {
        if (modulusSize < 2048) goto L14;
        if (TinkFipsUtil.useOnlyFips() == false) goto L12;
        if (modulusSize != 2048) goto L8;
        return;
    L8:
        if (modulusSize != 3072) goto L11;
        return;
    L11:
        throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size of 2048- or 3072-bit is supported in FIPS mode.", new Object[]{Integer.valueOf(modulusSize)}));
    L12:
        return;
    L14:
        throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size >= 2048-bit is supported", new Object[]{Integer.valueOf(modulusSize)}));
    }

    public static void validateRsaPublicExponent(BigInteger publicExponent) throws GeneralSecurityException {
        if (publicExponent.testBit(0) == false) goto L10;
        if (publicExponent.compareTo(BigInteger.valueOf(65536)) <= 0) goto L8;
        return;
    L8:
        throw new GeneralSecurityException("Public exponent must be greater than 65536.");
    L10:
        throw new GeneralSecurityException("Public exponent must be odd.");
    }

    public static void validateNotExists(File f) throws IOException {
        if (f.exists() == true) goto L6;
        return;
    L6:
        throw new IOException(String.format("%s exists, please choose another file\n", new Object[]{f}));
    }

    public static void validateExists(File f) throws IOException {
        if (f.exists() == false) goto L6;
        return;
    L6:
        throw new IOException(String.format("Error: %s doesn't exist, please choose another file\n", new Object[]{f}));
    }

    public static String validateKmsKeyUriAndRemovePrefix(String expectedPrefix, String kmsKeyUri) {
        if (kmsKeyUri.toLowerCase(Locale.US).startsWith(expectedPrefix) == false) goto L7;
        return kmsKeyUri.substring(expectedPrefix.length());
    L7:
        throw new IllegalArgumentException(String.format("key URI must start with %s", new Object[]{expectedPrefix}));
    }

    static {
        GCP_KMS_CRYPTO_KEY_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[]{URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS}), 2);
        GCP_KMS_CRYPTO_KEY_VERSION_PATTERN = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[]{URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS, URI_UNRESERVED_CHARS}), 2);
    }

    public static void validateCryptoKeyUri(String kmsKeyUri) throws GeneralSecurityException {
        if (GCP_KMS_CRYPTO_KEY_PATTERN.matcher(kmsKeyUri).matches() == false) goto L5;
        return;
    L5:
        if (GCP_KMS_CRYPTO_KEY_VERSION_PATTERN.matcher(kmsKeyUri).matches() == false) goto L9;
        throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey, not a CryptoKeyVersion");
    L9:
        throw new GeneralSecurityException("Invalid Google Cloud KMS Key URI. The URI must point to a CryptoKey in the format projects/*/locations/*/keyRings/*/cryptoKeys/*. See https://cloud.google.com/kms/docs/reference/rest/v1/projects.locations.keyRings.cryptoKeys#CryptoKey");
    }
}
