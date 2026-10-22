package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public final enum ProtoSyntax extends java.lang.Enum<ProtoSyntax> {
    private static final /* synthetic */ ProtoSyntax[] $VALUES = null;
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    public static ProtoSyntax valueOf(String name) {
        return (ProtoSyntax) java.lang.Enum.valueOf(ProtoSyntax.class, name);
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) $VALUES.clone();
    }

    private ProtoSyntax(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    static {
        ProtoSyntax r0 = new ProtoSyntax("PROTO2", 0);
        PROTO2 = r0;
        ProtoSyntax r1 = new ProtoSyntax("PROTO3", 1);
        PROTO3 = r1;
        $VALUES = new ProtoSyntax[]{r0, r1};
    }
}
