package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SerializationRegistry {
    private final Map<ParserIndex, KeyParser<?>> keyParserMap;
    private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
    private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
    private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.SerializationRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final Map<ParserIndex, KeyParser<?>> keyParserMap;
        private final Map<SerializerIndex, KeySerializer<?, ?>> keySerializerMap;
        private final Map<ParserIndex, ParametersParser<?>> parametersParserMap;
        private final Map<SerializerIndex, ParametersSerializer<?, ?>> parametersSerializerMap;

        static /* synthetic */ Map access$1000(Builder r0) {
            return r0.parametersParserMap;
        }

        static /* synthetic */ Map access$700(Builder r0) {
            return r0.keySerializerMap;
        }

        static /* synthetic */ Map access$800(Builder r0) {
            return r0.keyParserMap;
        }

        static /* synthetic */ Map access$900(Builder r0) {
            return r0.parametersSerializerMap;
        }

        public Builder() {
            this.keySerializerMap = new HashMap();
            this.keyParserMap = new HashMap();
            this.parametersSerializerMap = new HashMap();
            this.parametersParserMap = new HashMap();
        }

        public Builder(SerializationRegistry registry) {
            this.keySerializerMap = new HashMap(SerializationRegistry.access$000(registry));
            this.keyParserMap = new HashMap(SerializationRegistry.access$100(registry));
            this.parametersSerializerMap = new HashMap(SerializationRegistry.access$200(registry));
            this.parametersParserMap = new HashMap(SerializationRegistry.access$300(registry));
        }

        public <KeyT extends Key, SerializationT extends Serialization> Builder registerKeySerializer(KeySerializer<KeyT, SerializationT> serializer) throws GeneralSecurityException {
            SerializerIndex r0 = new SerializerIndex(serializer.getKeyClass(), serializer.getSerializationClass(), null);
            if (this.keySerializerMap.containsKey(r0) == false) goto L11;
            KeySerializer<?, ?> r1 = this.keySerializerMap.get(r0);
            if (r1.equals(serializer) == false) goto L10;
            if (serializer.equals(r1) == false) goto L10;
        L12:
            return this;
        L10:
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + r0);
        L11:
            this.keySerializerMap.put(r0, serializer);
            goto L12
        }

        public <SerializationT extends Serialization> Builder registerKeyParser(KeyParser<SerializationT> parser) throws GeneralSecurityException {
            ParserIndex r0 = new ParserIndex(parser.getSerializationClass(), parser.getObjectIdentifier(), null);
            if (this.keyParserMap.containsKey(r0) == false) goto L11;
            KeyParser<?> r1 = this.keyParserMap.get(r0);
            if (r1.equals(parser) == false) goto L10;
            if (parser.equals(r1) == false) goto L10;
        L12:
            return this;
        L10:
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + r0);
        L11:
            this.keyParserMap.put(r0, parser);
            goto L12
        }

        public <ParametersT extends Parameters, SerializationT extends Serialization> Builder registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> serializer) throws GeneralSecurityException {
            SerializerIndex r0 = new SerializerIndex(serializer.getParametersClass(), serializer.getSerializationClass(), null);
            if (this.parametersSerializerMap.containsKey(r0) == false) goto L11;
            ParametersSerializer<?, ?> r1 = this.parametersSerializerMap.get(r0);
            if (r1.equals(serializer) == false) goto L10;
            if (serializer.equals(r1) == false) goto L10;
        L12:
            return this;
        L10:
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + r0);
        L11:
            this.parametersSerializerMap.put(r0, serializer);
            goto L12
        }

        public <SerializationT extends Serialization> Builder registerParametersParser(ParametersParser<SerializationT> parser) throws GeneralSecurityException {
            ParserIndex r0 = new ParserIndex(parser.getSerializationClass(), parser.getObjectIdentifier(), null);
            if (this.parametersParserMap.containsKey(r0) == false) goto L11;
            ParametersParser<?> r1 = this.parametersParserMap.get(r0);
            if (r1.equals(parser) == false) goto L10;
            if (parser.equals(r1) == false) goto L10;
        L12:
            return this;
        L10:
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + r0);
        L11:
            this.parametersParserMap.put(r0, parser);
            goto L12
        }

        public SerializationRegistry build() {
            return new SerializationRegistry(this, null);
        }
    }

    private static class ParserIndex {
        private final Class<? extends Serialization> keySerializationClass;
        private final Bytes serializationIdentifier;

        /* synthetic */ ParserIndex(Class r1, Bytes r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ParserIndex(Class<? extends Serialization> keySerializationClass, Bytes serializationIdentifier) {
            this.keySerializationClass = keySerializationClass;
            this.serializationIdentifier = serializationIdentifier;
        }

        public boolean equals(Object o) {
            if ((o instanceof ParserIndex) == true) goto L5;
            return false;
        L5:
            ParserIndex r4 = (ParserIndex) o;
            if (r4.keySerializationClass.equals(this.keySerializationClass) == true) goto L8;
            return false;
        L8:
            if (r4.serializationIdentifier.equals(this.serializationIdentifier) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.keySerializationClass, this.serializationIdentifier});
        }

        public String toString() {
            return this.keySerializationClass.getSimpleName() + ", object identifier: " + this.serializationIdentifier;
        }
    }

    private static class SerializerIndex {
        private final Class<?> keyClass;
        private final Class<? extends Serialization> keySerializationClass;

        /* synthetic */ SerializerIndex(Class r1, Class r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private SerializerIndex(Class<?> keyClass, Class<? extends Serialization> keySerializationClass) {
            this.keyClass = keyClass;
            this.keySerializationClass = keySerializationClass;
        }

        public boolean equals(Object o) {
            if ((o instanceof SerializerIndex) == true) goto L5;
            return false;
        L5:
            SerializerIndex r4 = (SerializerIndex) o;
            if (r4.keyClass.equals(this.keyClass) == true) goto L8;
            return false;
        L8:
            if (r4.keySerializationClass.equals(this.keySerializationClass) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.keyClass, this.keySerializationClass});
        }

        public String toString() {
            return this.keyClass.getSimpleName() + " with serialization type: " + this.keySerializationClass.getSimpleName();
        }
    }

    /* synthetic */ SerializationRegistry(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Map access$000(SerializationRegistry r0) {
        return r0.keySerializerMap;
    }

    static /* synthetic */ Map access$100(SerializationRegistry r0) {
        return r0.keyParserMap;
    }

    static /* synthetic */ Map access$200(SerializationRegistry r0) {
        return r0.parametersSerializerMap;
    }

    static /* synthetic */ Map access$300(SerializationRegistry r0) {
        return r0.parametersParserMap;
    }

    private SerializationRegistry(Builder builder) {
        this.keySerializerMap = new HashMap(Builder.access$700(builder));
        this.keyParserMap = new HashMap(Builder.access$800(builder));
        this.parametersSerializerMap = new HashMap(Builder.access$900(builder));
        this.parametersParserMap = new HashMap(Builder.access$1000(builder));
    }

    public <SerializationT extends Serialization> boolean hasParserForKey(SerializationT serializedKey) {
        ParserIndex r0 = new ParserIndex(serializedKey.getClass(), serializedKey.getObjectIdentifier(), null);
        return this.keyParserMap.containsKey(r0);
    }

    public <SerializationT extends Serialization> Key parseKey(SerializationT serializedKey, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        ParserIndex r0 = new ParserIndex(serializedKey.getClass(), serializedKey.getObjectIdentifier(), null);
        if (this.keyParserMap.containsKey(r0) == false) goto L7;
        return this.keyParserMap.get(r0).parseKey(serializedKey, access);
    L7:
        throw new GeneralSecurityException("No Key Parser for requested key type " + r0 + " available");
    }

    public <KeyT extends Key, SerializationT extends Serialization> boolean hasSerializerForKey(KeyT key, Class<SerializationT> serializationClass) {
        SerializerIndex r0 = new SerializerIndex(key.getClass(), serializationClass, null);
        return this.keySerializerMap.containsKey(r0);
    }

    public <KeyT extends Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT r4, Class<SerializationT> r5, @Nullable SecretKeyAccess r6) throws GeneralSecurityException {
        SerializerIndex r0 = new SerializerIndex(r4.getClass(), r5, null);
        if (this.keySerializerMap.containsKey(r0) == false) goto L7;
        return (SerializationT) this.keySerializerMap.get(r0).serializeKey(r4, r6);
    L7:
        throw new GeneralSecurityException("No Key serializer for " + r0 + " available");
    }

    public <SerializationT extends Serialization> boolean hasParserForParameters(SerializationT serializedParameters) {
        ParserIndex r0 = new ParserIndex(serializedParameters.getClass(), serializedParameters.getObjectIdentifier(), null);
        return this.parametersParserMap.containsKey(r0);
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializedParameters) throws GeneralSecurityException {
        ParserIndex r0 = new ParserIndex(serializedParameters.getClass(), serializedParameters.getObjectIdentifier(), null);
        if (this.parametersParserMap.containsKey(r0) == false) goto L7;
        return this.parametersParserMap.get(r0).parseParameters(serializedParameters);
    L7:
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + r0 + " available");
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> boolean hasSerializerForParameters(ParametersT parameters, Class<SerializationT> serializationClass) {
        SerializerIndex r0 = new SerializerIndex(parameters.getClass(), serializationClass, null);
        return this.parametersSerializerMap.containsKey(r0);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT r4, Class<SerializationT> r5) throws GeneralSecurityException {
        SerializerIndex r0 = new SerializerIndex(r4.getClass(), r5, null);
        if (this.parametersSerializerMap.containsKey(r0) == false) goto L7;
        return (SerializationT) this.parametersSerializerMap.get(r0).serializeParameters(r4);
    L7:
        throw new GeneralSecurityException("No Key Format serializer for " + r0 + " available");
    }
}
