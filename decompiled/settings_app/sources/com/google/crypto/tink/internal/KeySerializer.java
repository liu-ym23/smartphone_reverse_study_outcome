package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.Serialization;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeySerializer<KeyT extends Key, SerializationT extends Serialization> {
    private final Class<KeyT> keyClass;
    private final Class<SerializationT> serializationClass;

    public interface KeySerializationFunction<KeyT extends Key, SerializationT extends Serialization> {
        SerializationT serializeKey(KeyT key, @Nullable SecretKeyAccess access) throws GeneralSecurityException;
    }

    public abstract SerializationT serializeKey(KeyT key, @Nullable SecretKeyAccess access) throws GeneralSecurityException;

    /* synthetic */ KeySerializer(Class r1, Class r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private KeySerializer(Class<KeyT> keyClass, Class<SerializationT> serializationClass) {
        this.keyClass = keyClass;
        this.serializationClass = serializationClass;
    }

    public Class<KeyT> getKeyClass() {
        return this.keyClass;
    }

    public Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public static <KeyT extends Key, SerializationT extends Serialization> KeySerializer<KeyT, SerializationT> create(final KeySerializationFunction<KeyT, SerializationT> r1, final Class<KeyT> r2, final Class<SerializationT> r3) {
        return (KeySerializer<KeyT, SerializationT>) new AnonymousClass1(r2, r3, r1);
    }
}
