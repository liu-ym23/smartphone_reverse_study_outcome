package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead> {
    private static final PrimitiveConstructor<LegacyProtoKey, StreamingAead> LEGACY_FULL_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = null;
    private static final StreamingAeadWrapper WRAPPER = null;

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public /* bridge */ /* synthetic */ StreamingAead wrap(final PrimitiveSet<StreamingAead> primitives) throws GeneralSecurityException {
        return wrap(primitives);
    }

    static {
        WRAPPER = new StreamingAeadWrapper();
        LEGACY_FULL_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new StreamingAeadWrapper$$ExternalSyntheticLambda0(), LegacyProtoKey.class, StreamingAead.class);
    }

    StreamingAeadWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public StreamingAead wrap(final PrimitiveSet<StreamingAead> primitives) throws GeneralSecurityException {
        ArrayList r4 = new ArrayList();
        Iterator<List<PrimitiveSet.Entry<StreamingAead>>> r0 = primitives.getAll().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Iterator<PrimitiveSet.Entry<StreamingAead>> r1 = r0.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        PrimitiveSet.Entry<StreamingAead> r2 = r1.next();
        if (r2.getFullPrimitive() == null) goto L12;
        r4.add(r2.getFullPrimitive());
        goto L7
    L12:
        throw new GeneralSecurityException("No full primitive set for key id " + r2.getKeyId());
    L13:
        PrimitiveSet.Entry<StreamingAead> r5 = primitives.getPrimary();
        if (r5 == null) goto L20;
        if (r5.getFullPrimitive() == null) goto L20;
        return new StreamingAeadHelper(r4, r5.getFullPrimitive());
    L20:
        throw new GeneralSecurityException("No primary set");
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<StreamingAead> getPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<StreamingAead> getInputPrimitiveClass() {
        return StreamingAead.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(LEGACY_FULL_STREAMING_AEAD_PRIMITIVE_CONSTRUCTOR);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder primitiveRegistryBuilder) throws GeneralSecurityException {
        primitiveRegistryBuilder.registerPrimitiveWrapper(WRAPPER);
    }
}
