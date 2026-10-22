package com.obric.matrix.proto;

import a.a;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class RefreshLocationResponse extends Message<RefreshLocationResponse, Builder> {
    public static final ProtoAdapter<RefreshLocationResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULTCODE = null;
    public static final Integer DEFAULT_RESULTMSG = null;
    private static final long serialVersionUID = 0;

    @SerializedName("resultCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer resultCode;

    @SerializedName("resultMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer resultMsg;

    public static final class Builder extends Message.Builder<RefreshLocationResponse, Builder> {
        public Integer resultCode;
        public Integer resultMsg;

        public Builder() {
            this.resultCode = 0;
            this.resultMsg = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resultCode(Integer r1) {
            this.resultCode = r1;
            return this;
        }

        public Builder resultMsg(Integer r1) {
            this.resultMsg = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RefreshLocationResponse build() {
            return new RefreshLocationResponse(this.resultCode, this.resultMsg, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_RefreshLocationResponse extends ProtoAdapter<RefreshLocationResponse> {
        public ProtoAdapter_RefreshLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, RefreshLocationResponse r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse redact(RefreshLocationResponse r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RefreshLocationResponse decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.resultCode(ProtoAdapter.INT32.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.resultMsg(ProtoAdapter.INT32.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, RefreshLocationResponse r4) {
            ProtoAdapter<Integer> r2 = ProtoAdapter.INT32;
            r2.encodeWithTag(r3, 1, r4.resultCode);
            r2.encodeWithTag(r3, 2, r4.resultMsg);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RefreshLocationResponse r4) {
            ProtoAdapter<Integer> r3 = ProtoAdapter.INT32;
            int r0 = r3.encodedSizeWithTag(1, r4.resultCode);
            int r5 = r3.encodedSizeWithTag(2, r4.resultMsg) + r0;
            return r4.unknownFields().size() + r5;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RefreshLocationResponse redact2(RefreshLocationResponse r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationResponse();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public RefreshLocationResponse(Integer r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationResponse) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r6 = (RefreshLocationResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.resultCode, r6.resultCode) == false) goto L16;
        if (Internal.equals(this.resultMsg, r6.resultMsg) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.resultCode;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.resultMsg;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.resultCode == null) goto L6;
        r0.append(", resultCode=");
        r0.append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L9;
        r0.append(", resultMsg=");
        r0.append(this.resultMsg);
    L9:
        return a.m(r0, 0, 2, "RefreshLocationResponse{", '}');
    }

    public RefreshLocationResponse(Integer r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.resultCode = r2;
        this.resultMsg = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.resultCode = this.resultCode;
        r0.resultMsg = this.resultMsg;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
