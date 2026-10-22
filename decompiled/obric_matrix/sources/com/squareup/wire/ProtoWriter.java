package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import k.f;
import k.h;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/squareup/wire/ProtoWriter;", "", "Lk/h;", "value", "Lkotlin/f0;", "writeBytes", "(Lk/h;)V", "", "writeString", "(Ljava/lang/String;)V", "", "fieldNumber", "Lcom/squareup/wire/FieldEncoding;", "fieldEncoding", "writeTag", "(ILcom/squareup/wire/FieldEncoding;)V", "writeSignedVarint32$wire_runtime", "(I)V", "writeSignedVarint32", "writeVarint32", "", "writeVarint64", "(J)V", "writeFixed32", "writeFixed64", "Lk/f;", "sink", "Lk/f;", "<init>", "(Lk/f;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class ProtoWriter {
    public static final Companion Companion = null;
    private final f sink;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/squareup/wire/ProtoWriter$Companion;", "", "", "fieldNumber", "Lcom/squareup/wire/FieldEncoding;", "fieldEncoding", "makeTag", "(ILcom/squareup/wire/FieldEncoding;)I", LocationMonitorConst.TAG, "tagSize$wire_runtime", "(I)I", "tagSize", "value", "int32Size$wire_runtime", "int32Size", "varint32Size$wire_runtime", "varint32Size", "", "varint64Size$wire_runtime", "(J)I", "varint64Size", "n", "encodeZigZag32$wire_runtime", "encodeZigZag32", "decodeZigZag32$wire_runtime", "decodeZigZag32", "encodeZigZag64$wire_runtime", "(J)J", "encodeZigZag64", "decodeZigZag64$wire_runtime", "decodeZigZag64", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static final /* synthetic */ int access$makeTag(Companion r0, int r1, FieldEncoding r2) {
            return r0.makeTag(r1, r2);
        }

        private final int makeTag(int r1, FieldEncoding r2) {
            return (r1 << 3) | r2.getValue$wire_runtime();
        }

        public final int decodeZigZag32$wire_runtime(int r1) {
            return (r1 >>> 1) ^ (-(r1 & 1));
        }

        public final long decodeZigZag64$wire_runtime(long r5) {
            long r4 = -(r5 & 1);
            return r4 ^ (r5 >>> 1);
        }

        public final int encodeZigZag32$wire_runtime(int r1) {
            return (r1 << 1) ^ (r1 >> 31);
        }

        public final long encodeZigZag64$wire_runtime(long r3) {
            long r2 = r3 >> 63;
            return r2 ^ (r3 << 1);
        }

        public final int int32Size$wire_runtime(int r1) {
            if (r1 >= 0) goto L6;
            return 10;
        L6:
            return varint32Size$wire_runtime(r1);
        }

        public final int tagSize$wire_runtime(int r2) {
            return varint32Size$wire_runtime(makeTag(r2, FieldEncoding.VARINT));
        }

        public final int varint32Size$wire_runtime(int r1) {
            if ((r1 & (-128)) != 0) goto L7;
            return 1;
        L7:
            if ((r1 & (-16384)) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r1) != 0) goto L15;
            return 3;
        L15:
            if (((-268435456) & r1) != 0) goto L17;
            return 4;
        L17:
            return 5;
        }

        public final int varint64Size$wire_runtime(long r5) {
            if (((-128) & r5) != 0) goto L7;
            return 1;
        L7:
            if (((-16384) & r5) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r5) != 0) goto L15;
            return 3;
        L15:
            if (((-268435456) & r5) != 0) goto L19;
            return 4;
        L19:
            if (((-34359738368L) & r5) != 0) goto L23;
            return 5;
        L23:
            if (((-4398046511104L) & r5) != 0) goto L27;
            return 6;
        L27:
            if (((-562949953421312L) & r5) != 0) goto L31;
            return 7;
        L31:
            if (((-72057594037927936L) & r5) != 0) goto L35;
            return 8;
        L35:
            if ((r5 & Long.MIN_VALUE) != 0) goto L37;
            return 9;
        L37:
            return 10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ProtoWriter(f r2) {
        o.g(r2, "sink");
        this.sink = r2;
    }

    public final void writeBytes(h r2) {
        o.g(r2, "value");
        this.sink.W(r2);
    }

    public final void writeFixed32(int r1) {
        this.sink.u(r1);
    }

    public final void writeFixed64(long r1) {
        this.sink.r(r1);
    }

    public final void writeSignedVarint32$wire_runtime(int r3) {
        if (r3 < 0) goto L4;
        writeVarint32(r3);
        return;
    L4:
        writeVarint64(r3);
    }

    public final void writeString(String r2) {
        o.g(r2, "value");
        this.sink.D(r2);
    }

    public final void writeTag(int r2, FieldEncoding r3) {
        o.g(r3, "fieldEncoding");
        writeVarint32(Companion.access$makeTag(Companion, r2, r3));
    }

    public final void writeVarint32(int r3) {
    L3:
        if ((r3 & (-128)) == 0) goto L5;
        this.sink.w((r3 & 127) | 128);
        r3 = r3 >>> 7;
        goto L3
    L5:
        this.sink.w(r3);
    }

    public final void writeVarint64(long r5) {
    L3:
        if (((-128) & r5) == 0) goto L5;
        this.sink.w((((int) r5) & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L5:
        this.sink.w((int) r5);
    }
}
