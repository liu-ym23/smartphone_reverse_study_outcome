package com.google.crypto.tink;

import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda15 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public /* synthetic */ ConfigurationV0$$ExternalSyntheticLambda15() {
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key r1) {
        return EciesAeadHkdfHybridEncrypt.create((EciesPublicKey) r1);
    }
}
