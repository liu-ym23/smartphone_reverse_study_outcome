package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.keyderivation.KeysetDeriver;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class KeysetDeriverWrapper implements PrimitiveWrapper<KeyDeriver, KeysetDeriver> {
    private static final KeysetDeriverWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.keyderivation.internal.KeysetDeriverWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    private static class WrappedKeysetDeriver implements KeysetDeriver {
        private final PrimitiveSet<KeyDeriver> primitiveSet;

        /* synthetic */ WrappedKeysetDeriver(PrimitiveSet r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedKeysetDeriver(PrimitiveSet<KeyDeriver> primitiveSet) {
            this.primitiveSet = primitiveSet;
        }

        private static KeysetHandle.Builder.Entry deriveAndGetEntry(byte[] salt, PrimitiveSet.Entry<KeyDeriver> entry, int primaryKeyId) throws GeneralSecurityException {
            KeyDeriver r0 = entry.getFullPrimitive();
            if (r0 == null) goto L9;
            KeysetHandle.Builder.Entry r1 = KeysetHandle.importKey(r0.deriveKey(salt));
            r1.withFixedId(entry.getKeyId());
            if (entry.getKeyId() != primaryKeyId) goto L7;
            r1.makePrimary();
        L7:
            return r1;
        L9:
            throw new GeneralSecurityException("Primitive set has non-full primitives -- this is probably a bug");
        }

        @Override // com.google.crypto.tink.keyderivation.KeysetDeriver
        public KeysetHandle deriveKeyset(byte[] salt) throws GeneralSecurityException {
            KeysetHandle.Builder r0 = KeysetHandle.newBuilder();
            Iterator<PrimitiveSet.Entry<KeyDeriver>> r1 = this.primitiveSet.getAllInKeysetOrder().iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            r0.addEntry(deriveAndGetEntry(salt, r1.next(), this.primitiveSet.getPrimary().getKeyId()));
            goto L4
        L7:
            return r0.build();
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ KeysetDeriver wrap(final PrimitiveSet<KeyDeriver> primitiveSet) throws GeneralSecurityException {
        return wrap(primitiveSet);
    }

    static {
        WRAPPER = new KeysetDeriverWrapper();
    }

    private static void validate(PrimitiveSet<KeyDeriver> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() == null) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("Primitive set has no primary.");
    }

    KeysetDeriverWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public KeysetDeriver wrap(final PrimitiveSet<KeyDeriver> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedKeysetDeriver(primitiveSet, null);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<KeysetDeriver> getPrimitiveClass() {
        return KeysetDeriver.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<KeyDeriver> getInputPrimitiveClass() {
        return KeyDeriver.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }
}
