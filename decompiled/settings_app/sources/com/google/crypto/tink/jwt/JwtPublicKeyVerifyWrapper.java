package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class JwtPublicKeyVerifyWrapper implements PrimitiveWrapper<JwtPublicKeyVerify, JwtPublicKeyVerify> {
    private static final JwtPublicKeyVerifyWrapper WRAPPER = null;

    @Immutable
    private static class WrappedJwtPublicKeyVerify implements JwtPublicKeyVerify {
        private final PrimitiveSet<JwtPublicKeyVerify> primitives;

        public WrappedJwtPublicKeyVerify(PrimitiveSet<JwtPublicKeyVerify> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
        public VerifiedJwt verifyAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException {
            Iterator<List<PrimitiveSet.Entry<JwtPublicKeyVerify>>> r4 = this.primitives.getAll().iterator();
            GeneralSecurityException r0 = null;
        L4:
            if (r4.hasNext() == false) goto L15;
            Iterator<PrimitiveSet.Entry<JwtPublicKeyVerify>> r1 = r4.next().iterator();
        L7:
            if (r1.hasNext() == false) goto L4;
            return r1.next().getFullPrimitive().verifyAndDecode(compact, validator);
        L11:
            e = move-exception;
            if ((e instanceof JwtInvalidException) == false) goto L7;
            r0 = e;
            goto L7
        L15:
            if (r0 == null) goto L18;
            throw r0;
        L18:
            throw new GeneralSecurityException("invalid JWT");
        }
    }

    JwtPublicKeyVerifyWrapper() {
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ JwtPublicKeyVerify wrap(final PrimitiveSet<JwtPublicKeyVerify> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new JwtPublicKeyVerifyWrapper();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public JwtPublicKeyVerify wrap(final PrimitiveSet<JwtPublicKeyVerify> primitives) throws GeneralSecurityException {
        return new WrappedJwtPublicKeyVerify(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<JwtPublicKeyVerify> getPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<JwtPublicKeyVerify> getInputPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }
}
