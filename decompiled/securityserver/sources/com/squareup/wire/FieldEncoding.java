package com.squareup.wire;

import a.a;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    final int value;

    /* JADX INFO: renamed from: com.squareup.wire.FieldEncoding$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$FieldEncoding = null;

        static {
            int[] r0 = new int[FieldEncoding.values().length];
            $SwitchMap$com$squareup$wire$FieldEncoding = r0;
            r0[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$squareup$wire$FieldEncoding[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        FieldEncoding r0 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r0;
        FieldEncoding r1 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r1;
        FieldEncoding r2 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r2;
        FieldEncoding r3 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r3;
        $VALUES = new FieldEncoding[]{r0, r1, r2, r3};
    }

    private FieldEncoding(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static FieldEncoding get(int r2) {
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L14;
        if (r2 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException(a.e(r2, "Unexpected FieldEncoding: "));
    L14:
        return LENGTH_DELIMITED;
    L16:
        return FIXED64;
    L18:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r1) {
        return (FieldEncoding) Enum.valueOf(FieldEncoding.class, r1);
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int r1 = AnonymousClass1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 != 4) goto L13;
        return ProtoAdapter.BYTES;
    L13:
        throw new AssertionError();
    L15:
        return ProtoAdapter.FIXED64;
    L17:
        return ProtoAdapter.FIXED32;
    L19:
        return ProtoAdapter.UINT64;
    }
}
