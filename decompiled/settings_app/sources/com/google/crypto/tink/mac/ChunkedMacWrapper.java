package com.google.crypto.tink.mac;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChunkedMacWrapper implements PrimitiveWrapper<ChunkedMac, ChunkedMac> {
    private static final ChunkedMacWrapper WRAPPER = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.ChunkedMacWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    private static class WrappedChunkedMac implements ChunkedMac {
        private final PrimitiveSet<ChunkedMac> primitives;

        /* synthetic */ WrappedChunkedMac(PrimitiveSet r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedChunkedMac(PrimitiveSet<ChunkedMac> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacComputation createComputation() throws GeneralSecurityException {
            return getChunkedMac(this.primitives.getPrimary()).createComputation();
        }

        private ChunkedMac getChunkedMac(PrimitiveSet.Entry<ChunkedMac> entry) {
            return entry.getFullPrimitive();
        }

        @Override // com.google.crypto.tink.mac.ChunkedMac
        public ChunkedMacVerification createVerification(final byte[] tag) throws GeneralSecurityException {
            byte[] r0 = Arrays.copyOf(tag, 5);
            ArrayList r1 = new ArrayList();
            Iterator<PrimitiveSet.Entry<ChunkedMac>> r2 = this.primitives.getPrimitive(r0).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(getChunkedMac(r2.next()).createVerification(tag));
            goto L4
        L6:
            Iterator<PrimitiveSet.Entry<ChunkedMac>> r3 = this.primitives.getRawPrimitives().iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            r1.add(getChunkedMac(r3.next()).createVerification(tag));
            goto L8
        L11:
            return new WrappedChunkedMacVerification(r1, null);
        }
    }

    private static class WrappedChunkedMacVerification implements ChunkedMacVerification {
        private final List<ChunkedMacVerification> verifications;

        /* synthetic */ WrappedChunkedMacVerification(List r1, AnonymousClass1 r2) {
            this(r1);
        }

        private WrappedChunkedMacVerification(List<ChunkedMacVerification> verificationEntries) {
            this.verifications = verificationEntries;
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void update(ByteBuffer data) throws GeneralSecurityException {
            ByteBuffer r0 = data.duplicate();
            r0.mark();
            Iterator<ChunkedMacVerification> r2 = this.verifications.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            ChunkedMacVerification r1 = r2.next();
            r0.reset();
            r1.update(r0);
            goto L4
        L6:
            data.position(data.limit());
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacVerification
        public void verifyMac() throws GeneralSecurityException {
            GeneralSecurityException r0 = new GeneralSecurityException("MAC verification failed for all suitable keys in keyset");
            Iterator<ChunkedMacVerification> r2 = this.verifications.iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            r2.next().verifyMac();     // Catch: GeneralSecurityException -> L8
            return;
        L8:
            e = move-exception;
            r0.addSuppressed(e);
            goto L4
        L10:
            throw r0;
        }
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ ChunkedMac wrap(final PrimitiveSet<ChunkedMac> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new ChunkedMacWrapper();
    }

    private ChunkedMacWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public ChunkedMac wrap(final PrimitiveSet<ChunkedMac> primitives) throws GeneralSecurityException {
        if (primitives == null) goto L17;
        if (primitives.getPrimary() == null) goto L15;
        Iterator<List<PrimitiveSet.Entry<ChunkedMac>>> r2 = primitives.getAll().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        Iterator<PrimitiveSet.Entry<ChunkedMac>> r0 = r2.next().iterator();
    L10:
        if (r0.hasNext() == false) goto L7;
        ChunkedMac r1 = r0.next().getFullPrimitive();
        goto L10
    L13:
        return new WrappedChunkedMac(primitives, null);
    L15:
        throw new GeneralSecurityException("no primary in primitive set");
    L17:
        throw new GeneralSecurityException("primitive set must be non-null");
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<ChunkedMac> getPrimitiveClass() {
        return ChunkedMac.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<ChunkedMac> getInputPrimitiveClass() {
        return ChunkedMac.class;
    }

    static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
