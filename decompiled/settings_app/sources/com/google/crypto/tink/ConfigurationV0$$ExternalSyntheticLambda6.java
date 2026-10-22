package com.google.crypto.tink;

import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ConfigurationV0$$ExternalSyntheticLambda6 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public /* synthetic */ ConfigurationV0$$ExternalSyntheticLambda6() {
    }

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key r1) {
        return RsaSsaPssVerifyJce.create((RsaSsaPssPublicKey) r1);
    }
}
