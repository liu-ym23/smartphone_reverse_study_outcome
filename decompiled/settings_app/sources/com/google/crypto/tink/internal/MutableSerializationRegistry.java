package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableSerializationRegistry {
    private static final MutableSerializationRegistry GLOBAL_INSTANCE = null;
    private final AtomicReference<SerializationRegistry> registry;

    public static /* synthetic */ MutableSerializationRegistry $r8$lambda$tLo8Il1jtXsiaLw6yVe6deN4xr0() {
        return createGlobalInstance();
    }

    private static MutableSerializationRegistry createGlobalInstance() throws GeneralSecurityException {
        MutableSerializationRegistry r0 = new MutableSerializationRegistry();
        r0.registerKeySerializer(KeySerializer.create(new MutableSerializationRegistry$$ExternalSyntheticLambda1(), LegacyProtoKey.class, ProtoKeySerialization.class));
        return r0;
    }

    static {
        GLOBAL_INSTANCE = (MutableSerializationRegistry) TinkBugException.exceptionIsBug(new MutableSerializationRegistry$$ExternalSyntheticLambda0());
    }

    public static MutableSerializationRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public MutableSerializationRegistry() {
        this.registry = new AtomicReference(new SerializationRegistry.Builder().build());
    }

    public synchronized <KeyT extends Key, SerializationT extends Serialization> void registerKeySerializer(KeySerializer<KeyT, SerializationT> serializer) throws GeneralSecurityException {
        monitor-enter(this);
        SerializationRegistry r3 = new SerializationRegistry.Builder(this.registry.get()).registerKeySerializer(serializer).build();     // Catch: Throwable -> L6
        this.registry.set(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <SerializationT extends Serialization> void registerKeyParser(KeyParser<SerializationT> parser) throws GeneralSecurityException {
        monitor-enter(this);
        SerializationRegistry r3 = new SerializationRegistry.Builder(this.registry.get()).registerKeyParser(parser).build();     // Catch: Throwable -> L6
        this.registry.set(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <ParametersT extends Parameters, SerializationT extends Serialization> void registerParametersSerializer(ParametersSerializer<ParametersT, SerializationT> serializer) throws GeneralSecurityException {
        monitor-enter(this);
        SerializationRegistry r3 = new SerializationRegistry.Builder(this.registry.get()).registerParametersSerializer(serializer).build();     // Catch: Throwable -> L6
        this.registry.set(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized <SerializationT extends Serialization> void registerParametersParser(ParametersParser<SerializationT> parser) throws GeneralSecurityException {
        monitor-enter(this);
        SerializationRegistry r3 = new SerializationRegistry.Builder(this.registry.get()).registerParametersParser(parser).build();     // Catch: Throwable -> L6
        this.registry.set(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public <SerializationT extends Serialization> boolean hasParserForKey(SerializationT serializedKey) {
        return this.registry.get().hasParserForKey(serializedKey);
    }

    public <SerializationT extends Serialization> Key parseKey(SerializationT serializedKey, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return this.registry.get().parseKey(serializedKey, access);
    }

    public Key parseKeyWithLegacyFallback(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (hasParserForKey(protoKeySerialization) == true) goto L7;
        return new LegacyProtoKey(protoKeySerialization, access);
    L7:
        return parseKey(protoKeySerialization, access);
    }

    public <KeyT extends Key, SerializationT extends Serialization> boolean hasSerializerForKey(KeyT key, Class<SerializationT> serializationClass) {
        return this.registry.get().hasSerializerForKey(key, serializationClass);
    }

    public <KeyT extends Key, SerializationT extends Serialization> SerializationT serializeKey(KeyT r1, Class<SerializationT> r2, @Nullable SecretKeyAccess r3) throws GeneralSecurityException {
        return (SerializationT) this.registry.get().serializeKey(r1, r2, r3);
    }

    public <SerializationT extends Serialization> boolean hasParserForParameters(SerializationT serializedParameters) {
        return this.registry.get().hasParserForParameters(serializedParameters);
    }

    public <SerializationT extends Serialization> Parameters parseParameters(SerializationT serializedParameters) throws GeneralSecurityException {
        return this.registry.get().parseParameters(serializedParameters);
    }

    public Parameters parseParametersWithLegacyFallback(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (hasParserForParameters(protoParametersSerialization) == true) goto L7;
        return new LegacyProtoParameters(protoParametersSerialization);
    L7:
        return parseParameters(protoParametersSerialization);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> boolean hasSerializerForParameters(ParametersT parameters, Class<SerializationT> serializationClass) {
        return this.registry.get().hasSerializerForParameters(parameters, serializationClass);
    }

    public <ParametersT extends Parameters, SerializationT extends Serialization> SerializationT serializeParameters(ParametersT r1, Class<SerializationT> r2) throws GeneralSecurityException {
        return (SerializationT) this.registry.get().serializeParameters(r1, r2);
    }
}
