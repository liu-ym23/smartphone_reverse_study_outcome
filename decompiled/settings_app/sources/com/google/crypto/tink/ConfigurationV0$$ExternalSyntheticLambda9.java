package com.google.crypto.tink;

import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.subtle.AesEaxJce;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda9 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public /* synthetic */ ConfigurationV0$$ExternalSyntheticLambda9() {
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key r1) {
        return AesEaxJce.create((AesEaxKey) r1);
    }
}
