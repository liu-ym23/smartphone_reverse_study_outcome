package com.google.crypto.tink;

import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class TinkProtoParametersFormat {
    public static byte[] serialize(Parameters parameters) throws GeneralSecurityException {
        if ((parameters instanceof LegacyProtoParameters) == false) goto L7;
        return ((LegacyProtoParameters) parameters).getSerialization().getKeyTemplate().toByteArray();
    L7:
        return ((ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(parameters, ProtoParametersSerialization.class)).getKeyTemplate().toByteArray();
    }

    public static Parameters parse(byte[] serializedParameters) throws GeneralSecurityException {
        com.google.crypto.tink.proto.KeyTemplate r2 = com.google.crypto.tink.proto.KeyTemplate.parseFrom(serializedParameters, ExtensionRegistryLite.getEmptyRegistry());     // Catch: IOException -> L5
        return MutableSerializationRegistry.globalInstance().parseParametersWithLegacyFallback(ProtoParametersSerialization.checkedCreate(r2));
    L5:
        e = move-exception;
        throw new GeneralSecurityException("Failed to parse proto", e);
    }

    private TinkProtoParametersFormat() {
    }
}
