package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.OutputStream;
import java.io.Serializable;
import k.e;
import k.f;
import k.h;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 +*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0004:\u0002,+B\u001f\b\u0004\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0012\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0015J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0019\u0010!\u001a\u00020 8G@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\"\u0010$\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "Ljava/io/Serializable;", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "withoutUnknownFields", "()Lcom/squareup/wire/Message;", "", "toString", "()Ljava/lang/String;", "", "writeReplace", "()Ljava/lang/Object;", "Lk/f;", "sink", "Lkotlin/f0;", "encode", "(Lk/f;)V", "", "()[B", "Ljava/io/OutputStream;", "stream", "(Ljava/io/OutputStream;)V", "", "hashCode", "I", "Lcom/squareup/wire/ProtoAdapter;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "()Lcom/squareup/wire/ProtoAdapter;", "Lk/h;", "unknownFields", "Lk/h;", "()Lk/h;", "cachedSerializedSize", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "<init>", "(Lcom/squareup/wire/ProtoAdapter;Lk/h;)V", "Companion", "Builder", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient h unknownFields;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0014\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0001*\u0014\b\u0003\u0010\u0003*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u00020\u0004B\t\b\u0004¢\u0006\u0004\b,\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00028\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/Message;", "M", "B", "", "Lkotlin/f0;", "prepareForNewUnknownFields", "()V", "Lk/h;", "unknownFields", "addUnknownFields", "(Lk/h;)Lcom/squareup/wire/Message$Builder;", "", LocationMonitorConst.TAG, "Lcom/squareup/wire/FieldEncoding;", "fieldEncoding", "value", "addUnknownField", "(ILcom/squareup/wire/FieldEncoding;Ljava/lang/Object;)Lcom/squareup/wire/Message$Builder;", "clearUnknownFields", "()Lcom/squareup/wire/Message$Builder;", "buildUnknownFields", "()Lk/h;", "build", "()Lcom/squareup/wire/Message;", "Lcom/squareup/wire/ProtoWriter;", "unknownFieldsWriter", "Lcom/squareup/wire/ProtoWriter;", "getUnknownFieldsWriter$wire_runtime", "()Lcom/squareup/wire/ProtoWriter;", "setUnknownFieldsWriter$wire_runtime", "(Lcom/squareup/wire/ProtoWriter;)V", "Lk/e;", "unknownFieldsBuffer", "Lk/e;", "getUnknownFieldsBuffer$wire_runtime", "()Lk/e;", "setUnknownFieldsBuffer$wire_runtime", "(Lk/e;)V", "unknownFieldsByteString", "Lk/h;", "getUnknownFieldsByteString$wire_runtime", "setUnknownFieldsByteString$wire_runtime", "(Lk/h;)V", "<init>", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        private transient e unknownFieldsBuffer;
        private transient h unknownFieldsByteString;
        private transient ProtoWriter unknownFieldsWriter;

        protected Builder() {
            this.unknownFieldsByteString = h.f18266i;
        }

        private final void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L13;
            this.unknownFieldsBuffer = new e();
            e r1 = this.unknownFieldsBuffer;
            if (r1 == null) goto L11;
            ProtoWriter r0 = new ProtoWriter(r1);
            this.unknownFieldsWriter = r0;
            if (r0 == null) goto L9;
            r0.writeBytes(this.unknownFieldsByteString);
            this.unknownFieldsByteString = h.f18266i;
            return;
        L9:
            o.p();
            throw null;
        L11:
            o.p();
            throw null;
        }

        public final Builder<M, B> addUnknownField(int r2, FieldEncoding r3, Object r4) {
            o.g(r3, "fieldEncoding");
            prepareForNewUnknownFields();
            ProtoAdapter<?> r5 = r3.rawProtoAdapter();
            if (r5 == null) goto L11;
            ProtoWriter r0 = this.unknownFieldsWriter;
            if (r0 == null) goto L8;
            r5.encodeWithTag(r0, r2, r4);
            return this;
        L8:
            o.p();
            throw null;
        L11:
            throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
        }

        public final Builder<M, B> addUnknownFields(h r2) {
            o.g(r2, "unknownFields");
            if (r2.size() <= 0) goto L9;
            prepareForNewUnknownFields();
            ProtoWriter r0 = this.unknownFieldsWriter;
            if (r0 == null) goto L7;
            r0.writeBytes(r2);
            goto L9
        L7:
            o.p();
            throw null;
        L9:
            return this;
        }

        public abstract M build();

        public final h buildUnknownFields() {
            e r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L10;
            if (r0 == null) goto L7;
            this.unknownFieldsByteString = r0.d0();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
            goto L10
        L7:
            o.p();
            throw null;
        L10:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = h.f18266i;
            e r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L8;
            if (r0 == null) goto L6;
            r0.a();
            this.unknownFieldsBuffer = null;
            goto L8
        L6:
            o.p();
            throw null;
        L8:
            this.unknownFieldsWriter = null;
            return this;
        }

        public final e getUnknownFieldsBuffer$wire_runtime() {
            return this.unknownFieldsBuffer;
        }

        public final h getUnknownFieldsByteString$wire_runtime() {
            return this.unknownFieldsByteString;
        }

        public final ProtoWriter getUnknownFieldsWriter$wire_runtime() {
            return this.unknownFieldsWriter;
        }

        public final void setUnknownFieldsBuffer$wire_runtime(e r1) {
            this.unknownFieldsBuffer = r1;
        }

        public final void setUnknownFieldsByteString$wire_runtime(h r2) {
            o.g(r2, "<set-?>");
            this.unknownFieldsByteString = r2;
        }

        public final void setUnknownFieldsWriter$wire_runtime(ProtoWriter r1) {
            this.unknownFieldsWriter = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/squareup/wire/Message$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    protected Message(ProtoAdapter<M> r2, h r3) {
        o.g(r2, "adapter");
        o.g(r3, "unknownFields");
        this.adapter = r2;
        this.unknownFields = r3;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream r2) {
        o.g(r2, "stream");
        this.adapter.encode(r2, this);
    }

    public final void encode(f r2) {
        o.g(r2, "sink");
        this.adapter.encode(r2, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.cachedSerializedSize;
    }

    public abstract B newBuilder();

    public final void setCachedSerializedSize$wire_runtime(int r1) {
        this.cachedSerializedSize = r1;
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final h unknownFields() {
        h r0 = this.unknownFields;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return h.f18266i;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    protected final Object writeReplace() {
        byte[] r1 = encode();
        Class<?> r2 = getClass();
        if (r2 == null) goto L7;
        return new MessageSerializedForm(r1, r2);
    L7:
        throw new b0("null cannot be cast to non-null type java.lang.Class<M>");
    }
}
