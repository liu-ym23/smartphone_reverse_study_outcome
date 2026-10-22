package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.Serialization;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ParametersSerializer<ParametersT extends Parameters, SerializationT extends Serialization> {
    private final Class<ParametersT> parametersClass;
    private final Class<SerializationT> serializationClass;

    public interface ParametersSerializationFunction<ParametersT extends Parameters, SerializationT extends Serialization> {
        SerializationT serializeParameters(ParametersT key) throws GeneralSecurityException;
    }

    public abstract SerializationT serializeParameters(ParametersT parameters) throws GeneralSecurityException;

    /* synthetic */ ParametersSerializer(Class r1, Class r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private ParametersSerializer(Class<ParametersT> parametersClass, Class<SerializationT> serializationClass) {
        this.parametersClass = parametersClass;
        this.serializationClass = serializationClass;
    }

    public Class<ParametersT> getParametersClass() {
        return this.parametersClass;
    }

    public Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public static <ParametersT extends Parameters, SerializationT extends Serialization> ParametersSerializer<ParametersT, SerializationT> create(final ParametersSerializationFunction<ParametersT, SerializationT> r1, final Class<ParametersT> r2, final Class<SerializationT> r3) {
        return (ParametersSerializer<ParametersT, SerializationT>) new AnonymousClass1(r2, r3, r1);
    }
}
