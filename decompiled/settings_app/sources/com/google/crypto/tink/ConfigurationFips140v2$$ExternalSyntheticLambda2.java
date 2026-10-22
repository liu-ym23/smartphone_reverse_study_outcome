package com.google.crypto.tink;

import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ConfigurationFips140v2$$ExternalSyntheticLambda2 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public /* synthetic */ ConfigurationFips140v2$$ExternalSyntheticLambda2() {
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key r1) {
        return EncryptThenAuthenticate.create((AesCtrHmacAeadKey) r1);
    }
}
