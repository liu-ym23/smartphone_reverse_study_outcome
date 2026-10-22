package com.squareup.wire;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import k.e;
import k.g;
import k.h;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\bJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\rJ\r\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010\bJ\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\rJ$\u0010(\u001a\u00020\u00102\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010$H\u0087\b¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010\u0006J'\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00105R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010/R\u0018\u0010:\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00105R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010/¨\u0006A"}, d2 = {"Lcom/squareup/wire/ProtoReader;", "", "", "expectedEndTag", "Lkotlin/f0;", "skipGroup", "(I)V", "internalReadVarint32", "()I", "fieldEncoding", "afterPackableScalar", "", "beforeLengthDelimitedScalar", "()J", "beginMessage", "token", "Lk/h;", "endMessageAndGetUnknownFields", "(J)Lk/h;", "endMessage", "(J)V", "nextTag", "Lcom/squareup/wire/FieldEncoding;", "peekFieldEncoding", "()Lcom/squareup/wire/FieldEncoding;", "skip", "()V", "readBytes", "()Lk/h;", "", "readString", "()Ljava/lang/String;", "readVarint32", "readVarint64", "readFixed32", "readFixed64", "Lkotlin/Function1;", "tagHandler", "-forEachTag", "(Lkotlin/n0/c/l;)Lk/h;", "forEachTag", LocationMonitorConst.TAG, "readUnknownField", "value", "addUnknownField", "(ILcom/squareup/wire/FieldEncoding;Ljava/lang/Object;)V", "pushedLimit", "J", "", "Lk/e;", "bufferStack", "Ljava/util/List;", WsConstants.KEY_CONNECTION_STATE, "I", "Lk/g;", "source", "Lk/g;", "limit", "nextFieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "recursionDepth", "pos", "<init>", "(Lk/g;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class ProtoReader {
    public static final Companion Companion = null;
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private final List<e> bufferStack;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final g source;
    private int state;
    private int tag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/squareup/wire/ProtoReader$Companion;", "", "", "FIELD_ENCODING_MASK", "I", "RECURSION_LIMIT", "STATE_END_GROUP", "STATE_FIXED32", "STATE_FIXED64", "STATE_LENGTH_DELIMITED", "STATE_PACKED_TAG", "STATE_START_GROUP", "STATE_TAG", "STATE_VARINT", "TAG_FIELD_ENCODING_BITS", "<init>", "()V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ProtoReader(g r3) {
        o.g(r3, "source");
        this.source = r3;
        this.limit = LocationRequestCompat.PASSIVE_INTERVAL;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.bufferStack = new ArrayList();
    }

    private final void afterPackableScalar(int r7) {
        if (this.state != r7) goto L5;
    L4:
        this.state = 6;
        return;
    L5:
        long r2 = this.pos;
        long r4 = this.limit;
        if (r2 > r4) goto L13;
        if (r2 != r4) goto L10;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        goto L4
    L10:
        this.state = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    }

    private final long beforeLengthDelimitedScalar() {
        if (this.state != 2) goto L7;
        long r0 = this.limit - this.pos;
        this.source.b0(r0);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r0;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private final int internalReadVarint32() {
        this.source.b0(1);
        this.pos++;
        byte r0 = this.source.readByte();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        this.source.b0(1);
        this.pos++;
        byte r3 = this.source.readByte();
        if (r3 < 0) goto L9;
        int r7 = r3 << 7;
    L29:
        return r7 | r1;
    L9:
        r1 = r1 | ((r3 & 127) << 7);
        this.source.b0(1);
        this.pos++;
        byte r4 = this.source.readByte();
        if (r4 < 0) goto L12;
        r7 = r4 << 14;
        goto L29
    L12:
        r1 = r1 | ((r4 & 127) << 14);
        this.source.b0(1);
        this.pos++;
        byte r5 = this.source.readByte();
        if (r5 < 0) goto L15;
        r7 = r5 << 21;
        goto L29
    L15:
        int r2 = r1 | ((r5 & 127) << 21);
        this.source.b0(1);
        this.pos++;
        byte r6 = this.source.readByte();
        int r8 = r2 | (r6 << 28);
        if (r6 >= 0) goto L26;
        int r9 = 0;
    L18:
        if (r9 > 4) goto L24;
        this.source.b0(1);
        this.pos++;
        if (this.source.readByte() >= 0) goto L21;
        r9 = r9 + 1;
        goto L18
    L21:
        return r8;
    L24:
        throw new ProtocolException("Malformed VARINT");
    L26:
        return r8;
    }

    private final void skipGroup(int r6) {
    L3:
        if (this.pos >= this.limit) goto L33;
        if (this.source.v() == true) goto L33;
        int r0 = internalReadVarint32();
        if (r0 == 0) goto L31;
        int r1 = r0 >> 3;
        int r2 = r0 & 7;
        if (r2 == 3) goto L10;
        if (r2 == 4) goto L13;
        if (r2 == 2) goto L19;
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L24;
        if (r2 != 5) goto L29;
        this.state = 5;
        readFixed32();
        goto L3
    L29:
        throw new ProtocolException("Unexpected field encoding: " + r2);
    L24:
        this.state = 1;
        readFixed64();
        goto L3
    L21:
        this.state = 0;
        readVarint64();
        goto L3
    L19:
        long r3 = internalReadVarint32();
        this.pos += r3;
        this.source.skip(r3);
        goto L3
    L13:
        if (r1 != r6) goto L16;
        return;
    L16:
        throw new ProtocolException("Unexpected end group");
    L10:
        skipGroup(r1);
        goto L3
    L31:
        throw new ProtocolException("Unexpected tag 0");
    L33:
        throw new EOFException();
    }

    /* JADX INFO: renamed from: -forEachTag, reason: not valid java name */
    public final h m67forEachTag(l<? super Integer, ? extends Object> r5) {
        o.g(r5, "tagHandler");
        long r0 = beginMessage();
    L3:
        int r2 = nextTag();
        if (r2 == (-1)) goto L6;
        r5.invoke(Integer.valueOf(r2));
        goto L3
    L6:
        return endMessageAndGetUnknownFields(r0);
    }

    public final void addUnknownField(int r3, FieldEncoding r4, Object r5) {
        o.g(r4, "fieldEncoding");
        ProtoWriter r0 = new ProtoWriter(this.bufferStack.get(this.recursionDepth - 1));
        ProtoAdapter<?> r2 = r4.rawProtoAdapter();
        if (r2 == null) goto L7;
        r2.encodeWithTag(r0, r3, r5);
        return;
    L7:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }

    public final long beginMessage() {
        if (this.state != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        int r1 = this.recursionDepth + 1;
        this.recursionDepth = r1;
        if (r1 > 65) goto L15;
        if (r1 <= this.bufferStack.size()) goto L12;
        this.bufferStack.add(new e());
    L12:
        long r2 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r2;
    L15:
        throw new IOException("Wire recursion limit exceeded");
    L17:
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final void endMessage(long r1) {
        endMessageAndGetUnknownFields(r1);
    }

    public final h endMessageAndGetUnknownFields(long r8) {
        boolean r1 = true;
        if (this.state != 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L28;
        int r2 = this.recursionDepth - 1;
        this.recursionDepth = r2;
        if (r2 >= 0) goto L10;
    L12:
        r1 = false;
    L13:
        if (r1 == false) goto L26;
        if (this.pos == this.limit) goto L20;
        if (r2 == 0) goto L20;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L20:
        this.limit = r8;
        e r7 = this.bufferStack.get(r2);
        if (r7.k0() <= 0) goto L24;
        return r7.d0();
    L24:
        return h.f18266i;
    L26:
        throw new IllegalStateException("No corresponding call to beginMessage()".toString());
    L10:
        if (this.pushedLimit != (-1)) goto L12;
    L28:
        throw new IllegalStateException("Unexpected call to endMessage()".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final int nextTag() {
        int r0 = this.state;
        if (r0 != 7) goto L7;
        this.state = 2;
        return this.tag;
    L7:
        if (r0 != 6) goto L54;
    L9:
        if (this.pos >= this.limit) goto L51;
        if (this.source.v() == true) goto L59;
        int r1 = internalReadVarint32();
        if (r1 == 0) goto L50;
        int r2 = r1 >> 3;
        this.tag = r2;
        int r3 = r1 & 7;
        if (r3 != 3) goto L18;
        skipGroup(r2);
        goto L9
    L18:
        if (r3 == 4) goto L48;
        if (r3 != 2) goto L34;
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r4 = internalReadVarint32();
        if (r4 < 0) goto L33;
        if (this.pushedLimit != (-1)) goto L31;
        long r5 = this.limit;
        this.pushedLimit = r5;
        long r6 = this.pos + ((long) r4);
        this.limit = r6;
        if (r6 > r5) goto L29;
        return this.tag;
    L29:
        throw new EOFException();
    L31:
        throw new IllegalStateException();
    L33:
        throw new ProtocolException("Negative length: " + r4);
    L34:
        if (r3 != 0) goto L38;
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        return r2;
    L38:
        if (r3 != 1) goto L42;
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        return r2;
    L42:
        if (r3 != 5) goto L46;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        return r2;
    L46:
        throw new ProtocolException("Unexpected field encoding: " + r3);
    L48:
        throw new ProtocolException("Unexpected end group");
    L50:
        throw new ProtocolException("Unexpected tag 0");
    L59:
        return -1;
    L51:
        return -1;
    L54:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public final h readBytes() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.b0(r0);
        return this.source.n(r0);
    }

    public final int readFixed32() {
        int r0 = this.state;
        if (r0 != 5) goto L5;
    L9:
        this.source.b0(4);
        this.pos += (long) 4;
        int r1 = this.source.R();
        afterPackableScalar(5);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public final long readFixed64() {
        int r0 = this.state;
        if (r0 != 1) goto L5;
    L9:
        this.source.b0(8);
        this.pos += (long) 8;
        long r2 = this.source.a0();
        afterPackableScalar(1);
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    public final String readString() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.b0(r0);
        return this.source.m(r0);
    }

    public final void readUnknownField(int r3) {
        FieldEncoding r0 = peekFieldEncoding();
        if (r0 == null) goto L6;
        addUnknownField(r3, r0, r0.rawProtoAdapter().decode(this));
        return;
    L6:
        o.p();
        throw null;
    }

    public final int readVarint32() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        int r1 = internalReadVarint32();
        afterPackableScalar(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public final long readVarint64() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        this.source.b0(1);
        this.pos++;
        byte r4 = this.source.readByte();
        r1 = r1 | (((long) (r4 & 127)) << r3);
        if ((r4 & 128) == 0) goto L14;
        r3 = r3 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r1;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public final void skip() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r0 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r0 != 2) goto L9;
        long r1 = beforeLengthDelimitedScalar();
        this.source.skip(r1);
        return;
    L9:
        if (r0 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }
}
