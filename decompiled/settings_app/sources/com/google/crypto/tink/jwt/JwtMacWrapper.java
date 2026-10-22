package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class JwtMacWrapper implements PrimitiveWrapper<JwtMac, JwtMac> {
    private static final JwtMacWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtMacWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    private static class WrappedJwtMac implements JwtMac {
        private final PrimitiveSet<JwtMac> primitives;

        /* synthetic */ WrappedJwtMac(PrimitiveSet r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedJwtMac(PrimitiveSet<JwtMac> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public String computeMacAndEncode(RawJwt token) throws GeneralSecurityException {
            return this.primitives.getPrimary().getFullPrimitive().computeMacAndEncode(token);
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public VerifiedJwt verifyMacAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException {
            Iterator<List<PrimitiveSet.Entry<JwtMac>>> r4 = this.primitives.getAll().iterator();
            GeneralSecurityException r0 = null;
        L4:
            if (r4.hasNext() == false) goto L15;
            Iterator<PrimitiveSet.Entry<JwtMac>> r1 = r4.next().iterator();
        L7:
            if (r1.hasNext() == false) goto L4;
            return r1.next().getFullPrimitive().verifyMacAndDecode(compact, validator);
        L11:
            e = move-exception;
            if ((e instanceof JwtInvalidException) == false) goto L7;
            r0 = e;
            goto L7
        L15:
            if (r0 == null) goto L18;
            throw r0;
        L18:
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ JwtMac wrap(final PrimitiveSet<JwtMac> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new JwtMacWrapper();
    }

    private static void validate(PrimitiveSet<JwtMac> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() == null) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("Primitive set has no primary.");
    }

    JwtMacWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public JwtMac wrap(final PrimitiveSet<JwtMac> primitives) throws GeneralSecurityException {
        validate(primitives);
        return new WrappedJwtMac(primitives, null);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<JwtMac> getPrimitiveClass() {
        return JwtMac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<JwtMac> getInputPrimitiveClass() {
        return JwtMac.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }
}
