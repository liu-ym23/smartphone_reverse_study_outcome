package com.google.crypto.tink.internal;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class LegacyProtoParameters extends Parameters {
    private final ProtoParametersSerialization serialization;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.LegacyProtoParameters$1, reason: invalid class name */
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

    public LegacyProtoParameters(ProtoParametersSerialization serialization) {
        this.serialization = serialization;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.serialization.getKeyTemplate().getOutputPrefixType() == OutputPrefixType.RAW) goto L5;
        return true;
    L5:
        return false;
    }

    public ProtoParametersSerialization getSerialization() {
        return this.serialization;
    }

    public boolean equals(Object o) {
        if ((o instanceof LegacyProtoParameters) == true) goto L5;
        return false;
    L5:
        ProtoParametersSerialization r4 = ((LegacyProtoParameters) o).serialization;
        if (this.serialization.getKeyTemplate().getOutputPrefixType().equals(r4.getKeyTemplate().getOutputPrefixType()) == true) goto L8;
        return false;
    L8:
        if (this.serialization.getKeyTemplate().getTypeUrl().equals(r4.getKeyTemplate().getTypeUrl()) == true) goto L10;
        return false;
    L10:
        if (this.serialization.getKeyTemplate().getValue().equals(r4.getKeyTemplate().getValue()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.serialization.getKeyTemplate(), this.serialization.getObjectIdentifier()});
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
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{this.serialization.getKeyTemplate().getTypeUrl(), outputPrefixToString(this.serialization.getKeyTemplate().getOutputPrefixType())});
    }
}
