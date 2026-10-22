package com.squareup.wire;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.m;
import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/squareup/wire/FieldEncoding;", "", "Lcom/squareup/wire/ProtoAdapter;", "rawProtoAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "", "value", "I", "getValue$wire_runtime", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final enum FieldEncoding extends Enum<FieldEncoding> {
    private static final /* synthetic */ FieldEncoding[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0081\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/squareup/wire/FieldEncoding$Companion;", "", "", "value", "Lcom/squareup/wire/FieldEncoding;", "get$wire_runtime", "(I)Lcom/squareup/wire/FieldEncoding;", "get", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final FieldEncoding get$wire_runtime(int r3) {
            if (r3 == 0) goto L15;
            if (r3 == 1) goto L18;
            if (r3 == 2) goto L17;
            if (r3 != 5) goto L11;
            return FieldEncoding.FIXED32;
        L11:
            throw new ProtocolException("Unexpected FieldEncoding: " + r3);
        L17:
            return FieldEncoding.LENGTH_DELIMITED;
        L18:
            return FieldEncoding.FIXED64;
        L15:
            return FieldEncoding.VARINT;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FieldEncoding.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[FieldEncoding.VARINT.ordinal()] = 1;
            r0[FieldEncoding.FIXED32.ordinal()] = 2;
            r0[FieldEncoding.FIXED64.ordinal()] = 3;
            r0[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
        }
    }

    static {
        FieldEncoding r1 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r1;
        FieldEncoding r2 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r2;
        FieldEncoding r3 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r3;
        FieldEncoding r4 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r4;
        $VALUES = new FieldEncoding[]{r1, r2, r3, r4};
        Companion = new Companion(null);
    }

    private FieldEncoding(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static final FieldEncoding get$wire_runtime(int r1) {
        return Companion.get$wire_runtime(r1);
    }

    public static FieldEncoding valueOf(String r1) {
        return (FieldEncoding) Enum.valueOf(FieldEncoding.class, r1);
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) $VALUES.clone();
    }

    public final int getValue$wire_runtime() {
        return this.value;
    }

    public final ProtoAdapter<?> rawProtoAdapter() {
        int r1 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L12;
        return ProtoAdapter.BYTES;
    L12:
        throw new m();
    L18:
        return ProtoAdapter.FIXED64;
    L19:
        return ProtoAdapter.FIXED32;
    L16:
        return ProtoAdapter.UINT64;
    }
}
