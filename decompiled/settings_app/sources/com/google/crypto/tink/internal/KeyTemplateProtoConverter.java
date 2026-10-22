package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyTemplateProtoConverter {

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.KeyTemplateProtoConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static KeyTemplate.OutputPrefixType prefixFromProto(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 != 4) goto L13;
        return KeyTemplate.OutputPrefixType.CRUNCHY;
    L13:
        throw new GeneralSecurityException("Unknown output prefix type");
    L15:
        return KeyTemplate.OutputPrefixType.RAW;
    L17:
        return KeyTemplate.OutputPrefixType.LEGACY;
    L19:
        return KeyTemplate.OutputPrefixType.TINK;
    }

    public static com.google.crypto.tink.proto.KeyTemplate toProto(KeyTemplate keyTemplate) throws GeneralSecurityException {
        Parameters r2 = keyTemplate.toParameters();
        if ((r2 instanceof LegacyProtoParameters) == false) goto L7;
        return ((LegacyProtoParameters) r2).getSerialization().getKeyTemplate();
    L7:
        return ((ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(r2, ProtoParametersSerialization.class)).getKeyTemplate();
    }

    public static byte[] toByteArray(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return toProto(keyTemplate).toByteArray();
    }

    public static KeyTemplate.OutputPrefixType getOutputPrefixType(KeyTemplate t) throws GeneralSecurityException {
        return prefixFromProto(toProto(t).getOutputPrefixType());
    }

    private KeyTemplateProtoConverter() {
    }
}
