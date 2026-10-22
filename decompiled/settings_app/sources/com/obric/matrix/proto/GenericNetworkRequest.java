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
public final class GenericNetworkRequest extends Message<GenericNetworkRequest, Builder> {
    public static final ProtoAdapter<GenericNetworkRequest> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final ByteString DEFAULT_BODY = null;
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final Boolean DEFAULT_NEEDACCESSTOKEN = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String accessToken;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString body;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> headerParams;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final NETWORK_METHOD method;

    @SerializedName("needAccessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean needAccessToken;

    @SerializedName("path")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String path;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> queryParams;

    public static final class Builder extends Message.Builder<GenericNetworkRequest, Builder> {
        public String accessToken;
        public ByteString body;
        public Map<String, String> headerParams;
        public NETWORK_METHOD method;
        public Boolean needAccessToken;
        public String path;
        public Map<String, String> queryParams;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.path = "";
            this.method = NETWORK_METHOD.METHOD_GET;
            this.body = ByteString.EMPTY;
            this.needAccessToken = false;
            this.accessToken = "";
            this.headerParams = Internal.newMutableMap();
            this.queryParams = Internal.newMutableMap();
        }

        public Builder path(String r1) {
            this.path = r1;
            return this;
        }

        public Builder method(NETWORK_METHOD r1) {
            this.method = r1;
            return this;
        }

        public Builder headerParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.headerParams = r1;
            return this;
        }

        public Builder queryParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.queryParams = r1;
            return this;
        }

        public Builder body(ByteString r1) {
            this.body = r1;
            return this;
        }

        public Builder needAccessToken(Boolean r1) {
            this.needAccessToken = r1;
            return this;
        }

        public Builder accessToken(String r1) {
            this.accessToken = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GenericNetworkRequest build() {
            String r0 = this.path;
            if (r0 == null) goto L9;
            if (this.method == null) goto L9;
            return new GenericNetworkRequest(this.path, this.method, this.headerParams, this.queryParams, this.body, this.needAccessToken, this.accessToken, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "path", this.method, "method"});
        }
    }

    private static final class ProtoAdapter_GenericNetworkRequest extends ProtoAdapter<GenericNetworkRequest> {
        private final ProtoAdapter<Map<String, String>> headerParams;
        private final ProtoAdapter<Map<String, String>> queryParams;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GenericNetworkRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkRequest redact(GenericNetworkRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_GenericNetworkRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkRequest.class);
            this.headerParams = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.queryParams = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GenericNetworkRequest r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.path) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(2, r5.method)) + this.headerParams.encodedSizeWithTag(3, r5.headerParams)) + this.queryParams.encodedSizeWithTag(4, r5.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r5.body)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r5.needAccessToken)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.accessToken)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, GenericNetworkRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.path);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r4, 2, r5.method);
            this.headerParams.encodeWithTag(r4, 3, r5.headerParams);
            this.queryParams.encodeWithTag(r4, 4, r5.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r5.body);
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r5.needAccessToken);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.accessToken);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.method(NETWORK_METHOD.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.accessToken(ProtoAdapter.STRING.decode(r9));
            goto L3
        L8:
            r0.needAccessToken(ProtoAdapter.BOOL.decode(r9));
            goto L3
        L9:
            r0.body(ProtoAdapter.BYTES.decode(r9));
            goto L3
        L10:
            r0.queryParams.putAll(this.queryParams.decode(r9));
            goto L3
        L11:
            r0.headerParams.putAll(this.headerParams.decode(r9));
            goto L3
        L16:
            r0.path(ProtoAdapter.STRING.decode(r9));
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkRequest redact2(GenericNetworkRequest r1) {
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
        ADAPTER = new ProtoAdapter_GenericNetworkRequest();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_NEEDACCESSTOKEN = false;
    }

    public GenericNetworkRequest(String r10, NETWORK_METHOD r11, Map<String, String> r12, Map<String, String> r13, ByteString r14, Boolean r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public GenericNetworkRequest(String r2, NETWORK_METHOD r3, Map<String, String> r4, Map<String, String> r5, ByteString r6, Boolean r7, String r8, ByteString r9) {
        super(ADAPTER, r9);
        this.path = r2;
        this.method = r3;
        this.headerParams = Internal.immutableCopyOf("headerParams", r4);
        this.queryParams = Internal.immutableCopyOf("queryParams", r5);
        this.body = r6;
        this.needAccessToken = r7;
        this.accessToken = r8;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.path = this.path;
        r0.method = this.method;
        r0.headerParams = Internal.copyOf("headerParams", this.headerParams);
        r0.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r0.body = this.body;
        r0.needAccessToken = this.needAccessToken;
        r0.accessToken = this.accessToken;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkRequest) == true) goto L8;
        return false;
    L8:
        GenericNetworkRequest r6 = (GenericNetworkRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (this.path.equals(r6.path) == false) goto L26;
        if (this.method.equals(r6.method) == false) goto L26;
        if (this.headerParams.equals(r6.headerParams) == false) goto L26;
        if (this.queryParams.equals(r6.queryParams) == false) goto L26;
        if (Internal.equals(this.body, r6.body) == false) goto L26;
        if (Internal.equals(this.needAccessToken, r6.needAccessToken) == false) goto L26;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((((((((unknownFields().hashCode() * 37) + this.path.hashCode()) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r2 = this.body;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.needAccessToken;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.accessToken;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
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
        r0.append(", path=").append(this.path);
        r0.append(", method=").append(this.method);
        Map<String, String> r1 = this.headerParams;
        if (r1 != null) goto L5;
    L7:
        Map<String, String> r2 = this.queryParams;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.append(", queryParams=").append(this.queryParams);
    L13:
        if (this.body == null) goto L16;
        r0.append(", body=").append(this.body);
    L16:
        if (this.needAccessToken == null) goto L19;
        r0.append(", needAccessToken=").append(this.needAccessToken);
    L19:
        if (this.accessToken == null) goto L22;
        r0.append(", accessToken=").append(this.accessToken);
    L22:
        return r0.replace(0, 2, "GenericNetworkRequest{").append('}').toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", headerParams=").append(this.headerParams);
        goto L7
    }
}
