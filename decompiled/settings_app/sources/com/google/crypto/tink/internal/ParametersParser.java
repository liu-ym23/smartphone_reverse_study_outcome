package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ParametersParser<SerializationT extends Serialization> {
    private final Bytes objectIdentifier;
    private final Class<SerializationT> serializationClass;

    public interface ParametersParsingFunction<SerializationT extends Serialization> {
        Parameters parseParameters(SerializationT serialization) throws GeneralSecurityException;
    }

    public abstract Parameters parseParameters(SerializationT serialization) throws GeneralSecurityException;

    /* synthetic */ ParametersParser(Bytes r1, Class r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private ParametersParser(Bytes objectIdentifier, Class<SerializationT> serializationClass) {
        this.objectIdentifier = objectIdentifier;
        this.serializationClass = serializationClass;
    }

    public final Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public final Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public static <SerializationT extends Serialization> ParametersParser<SerializationT> create(final ParametersParsingFunction<SerializationT> r1, final Bytes r2, final Class<SerializationT> r3) {
        return (ParametersParser<SerializationT>) new AnonymousClass1(r2, r3, r1);
    }
}
