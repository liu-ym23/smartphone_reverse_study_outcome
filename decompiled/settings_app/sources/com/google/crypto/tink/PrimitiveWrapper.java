package com.google.crypto.tink;

import com.google.crypto.tink.internal.PrimitiveSet;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<B> primitiveSet) throws GeneralSecurityException;
}
