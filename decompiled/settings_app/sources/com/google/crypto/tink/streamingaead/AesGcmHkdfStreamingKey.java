package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmHkdfStreamingKey extends StreamingAeadKey {
    private final SecretBytes initialKeymaterial;
    private final AesGcmHkdfStreamingParameters parameters;

    @Override // com.google.crypto.tink.streamingaead.StreamingAeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.streamingaead.StreamingAeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ StreamingAeadParameters getParameters() {
        return getParameters();
    }

    private AesGcmHkdfStreamingKey(AesGcmHkdfStreamingParameters parameters, SecretBytes initialKeymaterial) {
        this.parameters = parameters;
        this.initialKeymaterial = initialKeymaterial;
    }

    public static AesGcmHkdfStreamingKey create(AesGcmHkdfStreamingParameters parameters, SecretBytes initialKeymaterial) throws GeneralSecurityException {
        if (parameters.getKeySizeBytes() != initialKeymaterial.size()) goto L7;
        return new AesGcmHkdfStreamingKey(parameters, initialKeymaterial);
    L7:
        throw new GeneralSecurityException("Key size mismatch");
    }

    public SecretBytes getInitialKeyMaterial() {
        return this.initialKeymaterial;
    }

    @Override // com.google.crypto.tink.streamingaead.StreamingAeadKey, com.google.crypto.tink.Key
    public AesGcmHkdfStreamingParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof AesGcmHkdfStreamingKey) == true) goto L5;
        return false;
    L5:
        AesGcmHkdfStreamingKey r4 = (AesGcmHkdfStreamingKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.initialKeymaterial.equalsSecretBytes(this.initialKeymaterial) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
