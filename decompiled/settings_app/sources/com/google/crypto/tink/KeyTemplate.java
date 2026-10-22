package com.google.crypto.tink;

import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class KeyTemplate {

    @Nullable
    private final com.google.crypto.tink.proto.KeyTemplate kt;

    @Nullable
    private final Parameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.KeyTemplate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = r0;
            r0[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L24:
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L38:
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r4 = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r4;
            r4[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L26:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L28:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L34:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static final enum OutputPrefixType extends Enum<OutputPrefixType> {
        private static final /* synthetic */ OutputPrefixType[] $VALUES = null;
        public static final OutputPrefixType CRUNCHY = null;
        public static final OutputPrefixType LEGACY = null;
        public static final OutputPrefixType RAW = null;
        public static final OutputPrefixType TINK = null;

        private OutputPrefixType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static OutputPrefixType valueOf(String name) {
            return (OutputPrefixType) Enum.valueOf(OutputPrefixType.class, name);
        }

        public static OutputPrefixType[] values() {
            return (OutputPrefixType[]) $VALUES.clone();
        }

        static {
            OutputPrefixType r0 = new OutputPrefixType("TINK", 0);
            TINK = r0;
            OutputPrefixType r1 = new OutputPrefixType("LEGACY", 1);
            LEGACY = r1;
            OutputPrefixType r3 = new OutputPrefixType("RAW", 2);
            RAW = r3;
            OutputPrefixType r5 = new OutputPrefixType("CRUNCHY", 3);
            CRUNCHY = r5;
            $VALUES = new OutputPrefixType[]{r0, r1, r3, r5};
        }
    }

    static OutputPrefixType fromProto(com.google.crypto.tink.proto.OutputPrefixType outputPrefixType) {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 != 4) goto L13;
        return OutputPrefixType.CRUNCHY;
    L13:
        throw new IllegalArgumentException("Unknown output prefix type");
    L15:
        return OutputPrefixType.RAW;
    L17:
        return OutputPrefixType.LEGACY;
    L19:
        return OutputPrefixType.TINK;
    }

    static com.google.crypto.tink.proto.OutputPrefixType toProto(OutputPrefixType outputPrefixType) {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 != 4) goto L13;
        return com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
    L13:
        throw new IllegalArgumentException("Unknown output prefix type");
    L15:
        return com.google.crypto.tink.proto.OutputPrefixType.RAW;
    L17:
        return com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
    L19:
        return com.google.crypto.tink.proto.OutputPrefixType.TINK;
    }

    @Deprecated
    public static KeyTemplate create(String typeUrl, byte[] value, OutputPrefixType outputPrefixType) {
        return new KeyTemplate((com.google.crypto.tink.proto.KeyTemplate) com.google.crypto.tink.proto.KeyTemplate.newBuilder().setTypeUrl(typeUrl).setValue(ByteString.copyFrom(value)).setOutputPrefixType(toProto(outputPrefixType)).build());
    }

    public static KeyTemplate createFrom(Parameters p) throws GeneralSecurityException {
        return new KeyTemplate(p);
    }

    private KeyTemplate(com.google.crypto.tink.proto.KeyTemplate kt) {
        this.kt = kt;
        this.parameters = null;
    }

    private KeyTemplate(Parameters parameters) {
        this.kt = null;
        this.parameters = parameters;
    }

    com.google.crypto.tink.proto.KeyTemplate getProto() {
        return getProtoMaybeThrow();
    L4:
        e = move-exception;
        throw new TinkBugException("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + this.parameters, e);
    }

    com.google.crypto.tink.proto.KeyTemplate getProtoMaybeThrow() throws GeneralSecurityException {
        com.google.crypto.tink.proto.KeyTemplate r0 = this.kt;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Parameters r1 = this.parameters;
        if ((r1 instanceof LegacyProtoParameters) == false) goto L10;
        return ((LegacyProtoParameters) r1).getSerialization().getKeyTemplate();
    L10:
        return ((ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(this.parameters, ProtoParametersSerialization.class)).getKeyTemplate();
    }

    @Deprecated
    public String getTypeUrl() {
        return getProto().getTypeUrl();
    }

    @Deprecated
    public byte[] getValue() {
        return getProto().getValue().toByteArray();
    }

    @Deprecated
    public OutputPrefixType getOutputPrefixType() {
        return fromProto(getProto().getOutputPrefixType());
    }

    public Parameters toParameters() throws GeneralSecurityException {
        Parameters r0 = this.parameters;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return TinkProtoParametersFormat.parse(getProto().toByteArray());
    }
}
