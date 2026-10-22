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
public final class SendApplogEventRequest extends Message<SendApplogEventRequest, Builder> {
    public static final ProtoAdapter<SendApplogEventRequest> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String appid;

    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> eventMap;

    public static final class Builder extends Message.Builder<SendApplogEventRequest, Builder> {
        public String appid;
        public Map<String, String> eventMap;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.appid = "";
            this.eventMap = Internal.newMutableMap();
        }

        public Builder appid(String r1) {
            this.appid = r1;
            return this;
        }

        public Builder eventMap(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.eventMap = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SendApplogEventRequest build() {
            return new SendApplogEventRequest(this.appid, this.eventMap, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SendApplogEventRequest extends ProtoAdapter<SendApplogEventRequest> {
        private final ProtoAdapter<Map<String, String>> eventMap;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SendApplogEventRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendApplogEventRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest redact(SendApplogEventRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SendApplogEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            this.eventMap = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendApplogEventRequest r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.appid) + this.eventMap.encodedSizeWithTag(2, r4.eventMap)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, SendApplogEventRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.appid);
            this.eventMap.encodeWithTag(r4, 2, r5.eventMap);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendApplogEventRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.appid(ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.eventMap.putAll(this.eventMap.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SendApplogEventRequest redact2(SendApplogEventRequest r1) {
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
        ADAPTER = new ProtoAdapter_SendApplogEventRequest();
    }

    public SendApplogEventRequest(String r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SendApplogEventRequest(String r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.appid = r2;
        this.eventMap = Internal.immutableCopyOf("eventMap", r3);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.appid = this.appid;
        r0.eventMap = Internal.copyOf("eventMap", this.eventMap);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendApplogEventRequest) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r6 = (SendApplogEventRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.appid, r6.appid) == false) goto L16;
        if (this.eventMap.equals(r6.eventMap) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.appid;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.eventMap.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.appid == null) goto L5;
        r0.append(", appid=").append(this.appid);
    L5:
        Map<String, String> r1 = this.eventMap;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", eventMap=").append(this.eventMap);
    L11:
        return r0.replace(0, 2, "SendApplogEventRequest{").append('}').toString();
    }
}
