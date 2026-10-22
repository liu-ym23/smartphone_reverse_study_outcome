package com.google.crypto.tink;

import com.google.crypto.tink.hybrid.HpkePrivateKey;
import com.google.crypto.tink.hybrid.internal.HpkeDecrypt;
import com.google.crypto.tink.internal.PrimitiveConstructor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda18 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public /* synthetic */ ConfigurationV0$$ExternalSyntheticLambda18() {
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key r1) {
        return HpkeDecrypt.create((HpkePrivateKey) r1);
    }
}
