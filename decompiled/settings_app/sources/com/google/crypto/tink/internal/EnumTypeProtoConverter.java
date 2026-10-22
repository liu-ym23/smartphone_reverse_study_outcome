package com.google.crypto.tink.internal;

import com.google.errorprone.annotations.Immutable;
import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EnumTypeProtoConverter<E extends Enum<E>, O> {
    private final Map<E, O> fromProtoEnumMap;
    private final Map<O, E> toProtoEnumMap;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.EnumTypeProtoConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<E extends Enum<E>, O> {
        Map<E, O> fromProtoEnumMap;
        Map<O, E> toProtoEnumMap;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.fromProtoEnumMap = new HashMap();
            this.toProtoEnumMap = new HashMap();
        }

        public Builder<E, O> add(E protoEnum, O objectEnum) {
            this.fromProtoEnumMap.put(protoEnum, objectEnum);
            this.toProtoEnumMap.put(objectEnum, protoEnum);
            return this;
        }

        public EnumTypeProtoConverter<E, O> build() {
            return new EnumTypeProtoConverter(Collections.unmodifiableMap(this.fromProtoEnumMap), Collections.unmodifiableMap(this.toProtoEnumMap), null);
        }
    }

    /* synthetic */ EnumTypeProtoConverter(Map r1, Map r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private EnumTypeProtoConverter(Map<E, O> fromProtoEnumMap, Map<O, E> toProtoEnumMap) {
        this.fromProtoEnumMap = fromProtoEnumMap;
        this.toProtoEnumMap = toProtoEnumMap;
    }

    public static <E extends Enum<E>, O> Builder<E, O> builder() {
        return new Builder(null);
    }

    public E toProtoEnum(O objectEnum) throws GeneralSecurityException {
        E r2 = this.toProtoEnumMap.get(objectEnum);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new GeneralSecurityException("Unable to convert object enum: " + objectEnum);
    }

    public O fromProtoEnum(E protoEnum) throws GeneralSecurityException {
        O r2 = this.fromProtoEnumMap.get(protoEnum);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new GeneralSecurityException("Unable to convert proto enum: " + protoEnum);
    }
}
