package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class OnePartyCommonNetworkResponse extends Message<OnePartyCommonNetworkResponse, Builder> {
    public static final ProtoAdapter<OnePartyCommonNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extraMap;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<OnePartyCommonNetworkResponse, Builder> {
        public String body;
        public Map<String, String> extraMap;
        public Boolean isSucceed;
        public String serverLogId;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.isSucceed = false;
            this.body = "";
            this.serverLogId = "";
            this.extraMap = Internal.newMutableMap();
        }

        public Builder isSucceed(Boolean r1) {
            this.isSucceed = r1;
            return this;
        }

        public Builder body(String r1) {
            this.body = r1;
            return this;
        }

        public Builder serverLogId(String r1) {
            this.serverLogId = r1;
            return this;
        }

        public Builder extraMap(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraMap = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public OnePartyCommonNetworkResponse build() {
            return new OnePartyCommonNetworkResponse(this.isSucceed, this.body, this.serverLogId, this.extraMap, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_OnePartyCommonNetworkResponse extends ProtoAdapter<OnePartyCommonNetworkResponse> {
        private final ProtoAdapter<Map<String, String>> extraMap;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, OnePartyCommonNetworkResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse redact(OnePartyCommonNetworkResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_OnePartyCommonNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkResponse.class);
            this.extraMap = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OnePartyCommonNetworkResponse r5) {
            return (((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isSucceed) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.serverLogId)) + this.extraMap.encodedSizeWithTag(4, r5.extraMap)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, OnePartyCommonNetworkResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isSucceed);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.serverLogId);
            this.extraMap.encodeWithTag(r4, 4, r5.extraMap);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnePartyCommonNetworkResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.isSucceed(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.body(ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.serverLogId(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.extraMap.putAll(this.extraMap.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public OnePartyCommonNetworkResponse redact2(OnePartyCommonNetworkResponse r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkResponse();
        DEFAULT_ISSUCCEED = false;
    }

    public OnePartyCommonNetworkResponse(Boolean r7, String r8, String r9, Map<String, String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public OnePartyCommonNetworkResponse(Boolean r2, String r3, String r4, Map<String, String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.isSucceed = r2;
        this.body = r3;
        this.serverLogId = r4;
        this.extraMap = Internal.immutableCopyOf("extraMap", r5);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isSucceed = this.isSucceed;
        r0.body = this.body;
        r0.serverLogId = this.serverLogId;
        r0.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OnePartyCommonNetworkResponse) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkResponse r6 = (OnePartyCommonNetworkResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.isSucceed, r6.isSucceed) == false) goto L20;
        if (Internal.equals(this.body, r6.body) == false) goto L20;
        if (Internal.equals(this.serverLogId, r6.serverLogId) == false) goto L20;
        if (this.extraMap.equals(r6.extraMap) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isSucceed;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.body;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.serverLogId;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.extraMap.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.isSucceed == null) goto L6;
        r0.append(", isSucceed=").append(this.isSucceed);
    L6:
        if (this.body == null) goto L9;
        r0.append(", body=").append(this.body);
    L9:
        if (this.serverLogId == null) goto L11;
        r0.append(", serverLogId=").append(this.serverLogId);
    L11:
        Map<String, String> r1 = this.extraMap;
        if (r1 == null) goto L17;
        if (r1.isEmpty() == true) goto L17;
        r0.append(", extraMap=").append(this.extraMap);
    L17:
        return r0.replace(0, 2, "OnePartyCommonNetworkResponse{").append('}').toString();
    }
}
