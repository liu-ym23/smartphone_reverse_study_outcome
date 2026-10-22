package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyParser<SerializationT extends Serialization> {
    private final Bytes objectIdentifier;
    private final Class<SerializationT> serializationClass;

    public interface KeyParsingFunction<SerializationT extends Serialization> {
        Key parseKey(SerializationT serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException;
    }

    public abstract Key parseKey(SerializationT serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException;

    /* synthetic */ KeyParser(Bytes r1, Class r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private KeyParser(Bytes objectIdentifier, Class<SerializationT> serializationClass) {
        this.objectIdentifier = objectIdentifier;
        this.serializationClass = serializationClass;
    }

    public final Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public final Class<SerializationT> getSerializationClass() {
        return this.serializationClass;
    }

    public static <SerializationT extends Serialization> KeyParser<SerializationT> create(final KeyParsingFunction<SerializationT> r1, final Bytes r2, final Class<SerializationT> r3) {
        return (KeyParser<SerializationT>) new AnonymousClass1(r2, r3, r1);
    }
}
