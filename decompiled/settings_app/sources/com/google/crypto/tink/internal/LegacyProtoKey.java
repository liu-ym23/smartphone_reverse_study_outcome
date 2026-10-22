package com.google.crypto.tink.internal;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class LegacyProtoKey extends Key {
    private final ProtoKeySerialization serialization;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.LegacyProtoKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[KeyData.KeyMaterialType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType = r0;
            r0[KeyData.KeyMaterialType.SYMMETRIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType[KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r2 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r2;
            r2[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L28:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L20:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Immutable
    private static class LegacyProtoParametersNotForCreation extends Parameters {
        private final OutputPrefixType outputPrefixType;
        private final String typeUrl;

        /* synthetic */ LegacyProtoParametersNotForCreation(String r1, OutputPrefixType r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.crypto.tink.Parameters
        public boolean hasIdRequirement() {
            if (this.outputPrefixType == OutputPrefixType.RAW) goto L5;
            return true;
        L5:
            return false;
        }

        private static String outputPrefixToString(OutputPrefixType outputPrefixType) {
            int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
            if (r1 != 1) goto L5;
            return "TINK";
        L5:
            if (r1 != 2) goto L7;
            return "LEGACY";
        L7:
            if (r1 != 3) goto L9;
            return "RAW";
        L9:
            if (r1 == 4) goto L12;
            return NetworkStackConstant.UNKNOWN_TYPE;
        L12:
            return "CRUNCHY";
        }

        public String toString() {
            return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{this.typeUrl, outputPrefixToString(this.outputPrefixType)});
        }

        private LegacyProtoParametersNotForCreation(String typeUrl, OutputPrefixType outputPrefixType) {
            this.typeUrl = typeUrl;
            this.outputPrefixType = outputPrefixType;
        }
    }

    private static void throwIfMissingAccess(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType[protoKeySerialization.getKeyMaterialType().ordinal()];
        if (r1 != 1) goto L5;
    L7:
        SecretKeyAccess.requireAccess(access);
        return;
    L5:
        if (r1 == 2) goto L7;
    }

    public LegacyProtoKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        throwIfMissingAccess(serialization, access);
        this.serialization = serialization;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if ((key instanceof LegacyProtoKey) == true) goto L5;
        return false;
    L5:
        ProtoKeySerialization r4 = ((LegacyProtoKey) key).serialization;
        if (r4.getOutputPrefixType().equals(this.serialization.getOutputPrefixType()) == true) goto L9;
        return false;
    L9:
        if (r4.getKeyMaterialType().equals(this.serialization.getKeyMaterialType()) == true) goto L12;
        return false;
    L12:
        if (r4.getTypeUrl().equals(this.serialization.getTypeUrl()) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(r4.getIdRequirementOrNull(), this.serialization.getIdRequirementOrNull()) == true) goto L18;
        return false;
    L18:
        return Bytes.equal(this.serialization.getValue().toByteArray(), r4.getValue().toByteArray());
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.serialization.getIdRequirementOrNull();
    }

    public ProtoKeySerialization getSerialization(@Nullable SecretKeyAccess access) throws GeneralSecurityException {
        throwIfMissingAccess(this.serialization, access);
        return this.serialization;
    }

    @Override // com.google.crypto.tink.Key
    public Parameters getParameters() {
        return new LegacyProtoParametersNotForCreation(this.serialization.getTypeUrl(), this.serialization.getOutputPrefixType(), null);
    }
}
