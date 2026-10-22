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
public final class ResponseBody extends Message<ResponseBody, Builder> {
    public static final ProtoAdapter<ResponseBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleResponse")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    public final BizExampleResponse bizExampleResponse;

    @SerializedName("decodeLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    public final DecodeLocationResponse decodeLocationResponse;

    @SerializedName("genericNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    public final GenericNetworkResponse genericNetworkResponse;

    @SerializedName("getIntersectFencesResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    public final GetIntersectFencesResponse getIntersectFencesResponse;

    @SerializedName("getLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    public final GetLocationResponse getLocationResponse;

    @SerializedName("getTTNetParametersResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    public final GetTTNetParametersResponse getTTNetParametersResponse;

    @SerializedName("onePartyCommonNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;

    @SerializedName("refreshLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    public final RefreshLocationResponse refreshLocationResponse;

    @SerializedName("sendApplogEventResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    public final SendApplogEventResponse sendApplogEventResponse;

    @SerializedName("sendWsMessageResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    public final SendWsMessageResponse sendWsMessageResponse;

    @SerializedName("startPicoLinksResponse")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    public final StartPicoLinksResponse startPicoLinksResponse;

    @SerializedName("subscribeWsMsgByBroadCastResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;

    @SerializedName("subscribeWsMsgByCallBackResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;

    @SerializedName("subscribeWsMsgByProviderResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;

    @SerializedName("subscribeWsMsgResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    public final SubscribeWsMsgResponse subscribeWsMsgResponse;

    @SerializedName("subscribeWsStatusResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    public final SubscribeWsStatusResponse subscribeWsStatusResponse;

    public static final class Builder extends Message.Builder<ResponseBody, Builder> {
        public BizExampleResponse bizExampleResponse;
        public DecodeLocationResponse decodeLocationResponse;
        public GenericNetworkResponse genericNetworkResponse;
        public GetIntersectFencesResponse getIntersectFencesResponse;
        public GetLocationResponse getLocationResponse;
        public GetTTNetParametersResponse getTTNetParametersResponse;
        public OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;
        public RefreshLocationResponse refreshLocationResponse;
        public SendApplogEventResponse sendApplogEventResponse;
        public SendWsMessageResponse sendWsMessageResponse;
        public StartPicoLinksResponse startPicoLinksResponse;
        public SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;
        public SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;
        public SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;
        public SubscribeWsMsgResponse subscribeWsMsgResponse;
        public SubscribeWsStatusResponse subscribeWsStatusResponse;

        public Builder() {
        }

        public Builder bizExampleResponse(BizExampleResponse r1) {
            this.bizExampleResponse = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder decodeLocationResponse(DecodeLocationResponse r1) {
            this.decodeLocationResponse = r1;
            return this;
        }

        public Builder genericNetworkResponse(GenericNetworkResponse r1) {
            this.genericNetworkResponse = r1;
            return this;
        }

        public Builder getIntersectFencesResponse(GetIntersectFencesResponse r1) {
            this.getIntersectFencesResponse = r1;
            return this;
        }

        public Builder getLocationResponse(GetLocationResponse r1) {
            this.getLocationResponse = r1;
            return this;
        }

        public Builder getTTNetParametersResponse(GetTTNetParametersResponse r1) {
            this.getTTNetParametersResponse = r1;
            return this;
        }

        public Builder onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse r1) {
            this.onePartyCommonNetworkResponse = r1;
            return this;
        }

        public Builder refreshLocationResponse(RefreshLocationResponse r1) {
            this.refreshLocationResponse = r1;
            return this;
        }

        public Builder sendApplogEventResponse(SendApplogEventResponse r1) {
            this.sendApplogEventResponse = r1;
            return this;
        }

        public Builder sendWsMessageResponse(SendWsMessageResponse r1) {
            this.sendWsMessageResponse = r1;
            return this;
        }

        public Builder startPicoLinksResponse(StartPicoLinksResponse r1) {
            this.startPicoLinksResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse r1) {
            this.subscribeWsMsgByBroadCastResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse r1) {
            this.subscribeWsMsgByCallBackResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse r1) {
            this.subscribeWsMsgByProviderResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgResponse(SubscribeWsMsgResponse r1) {
            this.subscribeWsMsgResponse = r1;
            return this;
        }

        public Builder subscribeWsStatusResponse(SubscribeWsStatusResponse r1) {
            this.subscribeWsStatusResponse = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public ResponseBody build() {
            return new ResponseBody(this.bizExampleResponse, this.sendWsMessageResponse, this.subscribeWsMsgResponse, this.subscribeWsStatusResponse, this.subscribeWsMsgByProviderResponse, this.subscribeWsMsgByCallBackResponse, this.subscribeWsMsgByBroadCastResponse, this.getLocationResponse, this.refreshLocationResponse, this.decodeLocationResponse, this.getIntersectFencesResponse, this.startPicoLinksResponse, this.onePartyCommonNetworkResponse, this.sendApplogEventResponse, this.genericNetworkResponse, this.getTTNetParametersResponse, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseBody extends ProtoAdapter<ResponseBody> {
        public ProtoAdapter_ResponseBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, ResponseBody r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResponseBody r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody redact(ResponseBody r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResponseBody decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L8;
            r5.bizExampleResponse(BizExampleResponse.ADAPTER.decode(r6));
            goto L3
        L8:
            if (r2 != 111001) goto L9;
            r5.startPicoLinksResponse(StartPicoLinksResponse.ADAPTER.decode(r6));
            goto L3
        L9:
            switch(r2) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r5.subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r6));
            goto L3
        L22:
            r5.subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r6));
            goto L3
        L23:
            r5.subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse.ADAPTER.decode(r6));
            goto L3
        L24:
            r5.subscribeWsStatusResponse(SubscribeWsStatusResponse.ADAPTER.decode(r6));
            goto L3
        L25:
            r5.subscribeWsMsgResponse(SubscribeWsMsgResponse.ADAPTER.decode(r6));
            goto L3
        L26:
            r5.sendWsMessageResponse(SendWsMessageResponse.ADAPTER.decode(r6));
            goto L3
        L10:
            switch(r2) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r5.getIntersectFencesResponse(GetIntersectFencesResponse.ADAPTER.decode(r6));
            goto L3
        L18:
            r5.decodeLocationResponse(DecodeLocationResponse.ADAPTER.decode(r6));
            goto L3
        L19:
            r5.refreshLocationResponse(RefreshLocationResponse.ADAPTER.decode(r6));
            goto L3
        L20:
            r5.getLocationResponse(GetLocationResponse.ADAPTER.decode(r6));
            goto L3
        L11:
            switch(r2) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r5.getTTNetParametersResponse(GetTTNetParametersResponse.ADAPTER.decode(r6));
            goto L3
        L14:
            r5.genericNetworkResponse(GenericNetworkResponse.ADAPTER.decode(r6));
            goto L3
        L15:
            r5.sendApplogEventResponse(SendApplogEventResponse.ADAPTER.decode(r6));
            goto L3
        L16:
            r5.onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse.ADAPTER.decode(r6));
            goto L3
        L12:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, ResponseBody r4) {
            BizExampleResponse.ADAPTER.encodeWithTag(r3, 100000, r4.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r3, 101001, r4.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r3, 101002, r4.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r3, 101003, r4.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r3, 101004, r4.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r3, 101005, r4.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r3, 101006, r4.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r3, 102001, r4.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r3, 102002, r4.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r3, 102003, r4.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r3, 102004, r4.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r3, 111001, r4.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r3, 112001, r4.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r3, 112002, r4.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r3, 112003, r4.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r3, 112004, r4.getTTNetParametersResponse);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResponseBody r4) {
            int r3 = BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r4.bizExampleResponse);
            int r0 = SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r4.sendWsMessageResponse) + r3;
            int r5 = SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r4.subscribeWsMsgResponse) + r0;
            int r1 = SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r4.subscribeWsStatusResponse) + r5;
            int r6 = SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r4.subscribeWsMsgByProviderResponse) + r1;
            int r2 = SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r4.subscribeWsMsgByCallBackResponse) + r6;
            int r7 = SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r4.subscribeWsMsgByBroadCastResponse) + r2;
            int r8 = GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r4.getLocationResponse) + r7;
            int r9 = RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r4.refreshLocationResponse) + r8;
            int r10 = DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r4.decodeLocationResponse) + r9;
            int r11 = GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r4.getIntersectFencesResponse) + r10;
            int r12 = StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r4.startPicoLinksResponse) + r11;
            int r13 = OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r4.onePartyCommonNetworkResponse) + r12;
            int r14 = SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r4.sendApplogEventResponse) + r13;
            int r15 = GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r4.genericNetworkResponse) + r14;
            int r16 = GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r4.getTTNetParametersResponse) + r15;
            return r4.unknownFields().size() + r16;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public ResponseBody redact2(ResponseBody r2) {
            Builder r1 = r2.newBuilder();
            BizExampleResponse r3 = r1.bizExampleResponse;
            if (r3 == null) goto L5;
            r1.bizExampleResponse = BizExampleResponse.ADAPTER.redact(r3);
        L5:
            SendWsMessageResponse r4 = r1.sendWsMessageResponse;
            if (r4 == null) goto L8;
            r1.sendWsMessageResponse = SendWsMessageResponse.ADAPTER.redact(r4);
        L8:
            SubscribeWsMsgResponse r5 = r1.subscribeWsMsgResponse;
            if (r5 == null) goto L11;
            r1.subscribeWsMsgResponse = SubscribeWsMsgResponse.ADAPTER.redact(r5);
        L11:
            SubscribeWsStatusResponse r6 = r1.subscribeWsStatusResponse;
            if (r6 == null) goto L14;
            r1.subscribeWsStatusResponse = SubscribeWsStatusResponse.ADAPTER.redact(r6);
        L14:
            SubscribeWsMsgByProviderResponse r7 = r1.subscribeWsMsgByProviderResponse;
            if (r7 == null) goto L17;
            r1.subscribeWsMsgByProviderResponse = SubscribeWsMsgByProviderResponse.ADAPTER.redact(r7);
        L17:
            SubscribeWsMsgByCallBackResponse r8 = r1.subscribeWsMsgByCallBackResponse;
            if (r8 == null) goto L20;
            r1.subscribeWsMsgByCallBackResponse = SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r8);
        L20:
            SubscribeWsMsgByBroadCastResponse r9 = r1.subscribeWsMsgByBroadCastResponse;
            if (r9 == null) goto L23;
            r1.subscribeWsMsgByBroadCastResponse = SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r9);
        L23:
            GetLocationResponse r10 = r1.getLocationResponse;
            if (r10 == null) goto L26;
            r1.getLocationResponse = GetLocationResponse.ADAPTER.redact(r10);
        L26:
            RefreshLocationResponse r11 = r1.refreshLocationResponse;
            if (r11 == null) goto L29;
            r1.refreshLocationResponse = RefreshLocationResponse.ADAPTER.redact(r11);
        L29:
            DecodeLocationResponse r12 = r1.decodeLocationResponse;
            if (r12 == null) goto L32;
            r1.decodeLocationResponse = DecodeLocationResponse.ADAPTER.redact(r12);
        L32:
            GetIntersectFencesResponse r13 = r1.getIntersectFencesResponse;
            if (r13 == null) goto L35;
            r1.getIntersectFencesResponse = GetIntersectFencesResponse.ADAPTER.redact(r13);
        L35:
            StartPicoLinksResponse r14 = r1.startPicoLinksResponse;
            if (r14 == null) goto L38;
            r1.startPicoLinksResponse = StartPicoLinksResponse.ADAPTER.redact(r14);
        L38:
            OnePartyCommonNetworkResponse r15 = r1.onePartyCommonNetworkResponse;
            if (r15 == null) goto L41;
            r1.onePartyCommonNetworkResponse = OnePartyCommonNetworkResponse.ADAPTER.redact(r15);
        L41:
            SendApplogEventResponse r16 = r1.sendApplogEventResponse;
            if (r16 == null) goto L44;
            r1.sendApplogEventResponse = SendApplogEventResponse.ADAPTER.redact(r16);
        L44:
            GenericNetworkResponse r17 = r1.genericNetworkResponse;
            if (r17 == null) goto L47;
            r1.genericNetworkResponse = GenericNetworkResponse.ADAPTER.redact(r17);
        L47:
            GetTTNetParametersResponse r18 = r1.getTTNetParametersResponse;
            if (r18 == null) goto L50;
            r1.getTTNetParametersResponse = GetTTNetParametersResponse.ADAPTER.redact(r18);
        L50:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseBody();
    }

    public ResponseBody(BizExampleResponse r19, SendWsMessageResponse r20, SubscribeWsMsgResponse r21, SubscribeWsStatusResponse r22, SubscribeWsMsgByProviderResponse r23, SubscribeWsMsgByCallBackResponse r24, SubscribeWsMsgByBroadCastResponse r25, GetLocationResponse r26, RefreshLocationResponse r27, DecodeLocationResponse r28, GetIntersectFencesResponse r29, StartPicoLinksResponse r30, OnePartyCommonNetworkResponse r31, SendApplogEventResponse r32, GenericNetworkResponse r33, GetTTNetParametersResponse r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResponseBody) == true) goto L8;
        return false;
    L8:
        ResponseBody r6 = (ResponseBody) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L44;
        if (Internal.equals(this.bizExampleResponse, r6.bizExampleResponse) == false) goto L44;
        if (Internal.equals(this.sendWsMessageResponse, r6.sendWsMessageResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgResponse, r6.subscribeWsMsgResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsStatusResponse, r6.subscribeWsStatusResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r6.subscribeWsMsgByProviderResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r6.subscribeWsMsgByCallBackResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r6.subscribeWsMsgByBroadCastResponse) == false) goto L44;
        if (Internal.equals(this.getLocationResponse, r6.getLocationResponse) == false) goto L44;
        if (Internal.equals(this.refreshLocationResponse, r6.refreshLocationResponse) == false) goto L44;
        if (Internal.equals(this.decodeLocationResponse, r6.decodeLocationResponse) == false) goto L44;
        if (Internal.equals(this.getIntersectFencesResponse, r6.getIntersectFencesResponse) == false) goto L44;
        if (Internal.equals(this.startPicoLinksResponse, r6.startPicoLinksResponse) == false) goto L44;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r6.onePartyCommonNetworkResponse) == false) goto L44;
        if (Internal.equals(this.sendApplogEventResponse, r6.sendApplogEventResponse) == false) goto L44;
        if (Internal.equals(this.genericNetworkResponse, r6.genericNetworkResponse) == false) goto L44;
        if (Internal.equals(this.getTTNetParametersResponse, r6.getTTNetParametersResponse) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L69;
        int r1 = unknownFields().hashCode() * 37;
        BizExampleResponse r2 = this.bizExampleResponse;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        SendWsMessageResponse r6 = this.sendWsMessageResponse;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        SubscribeWsMsgResponse r9 = this.subscribeWsMsgResponse;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        SubscribeWsStatusResponse r12 = this.subscribeWsStatusResponse;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        SubscribeWsMsgByProviderResponse r15 = this.subscribeWsMsgByProviderResponse;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgByCallBackResponse r18 = this.subscribeWsMsgByCallBackResponse;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        SubscribeWsMsgByBroadCastResponse r21 = this.subscribeWsMsgByBroadCastResponse;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        GetLocationResponse r24 = this.getLocationResponse;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RefreshLocationResponse r27 = this.refreshLocationResponse;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        DecodeLocationResponse r30 = this.decodeLocationResponse;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        GetIntersectFencesResponse r33 = this.getIntersectFencesResponse;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        StartPicoLinksResponse r36 = this.startPicoLinksResponse;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        OnePartyCommonNetworkResponse r39 = this.onePartyCommonNetworkResponse;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        SendApplogEventResponse r42 = this.sendApplogEventResponse;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        GenericNetworkResponse r45 = this.genericNetworkResponse;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        GetTTNetParametersResponse r48 = this.getTTNetParametersResponse;
        if (r48 == null) goto L67;
        r3 = r48.hashCode();
    L67:
        int r49 = r47 + r3;
        this.hashCode = r49;
        return r49;
    L63:
        r46 = 0;
        goto L64
    L59:
        r43 = 0;
        goto L60
    L55:
        r40 = 0;
        goto L56
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L69:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r0.append(", bizExampleResponse=");
        r0.append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r0.append(", sendWsMessageResponse=");
        r0.append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r0.append(", subscribeWsMsgResponse=");
        r0.append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r0.append(", subscribeWsStatusResponse=");
        r0.append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r0.append(", subscribeWsMsgByProviderResponse=");
        r0.append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackResponse=");
        r0.append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastResponse=");
        r0.append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r0.append(", getLocationResponse=");
        r0.append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r0.append(", refreshLocationResponse=");
        r0.append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r0.append(", decodeLocationResponse=");
        r0.append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r0.append(", getIntersectFencesResponse=");
        r0.append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r0.append(", startPicoLinksResponse=");
        r0.append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r0.append(", onePartyCommonNetworkResponse=");
        r0.append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r0.append(", sendApplogEventResponse=");
        r0.append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r0.append(", genericNetworkResponse=");
        r0.append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L51;
        r0.append(", getTTNetParametersResponse=");
        r0.append(this.getTTNetParametersResponse);
    L51:
        return a.m(r0, 0, 2, "ResponseBody{", '}');
    }

    public ResponseBody(BizExampleResponse r4, SendWsMessageResponse r5, SubscribeWsMsgResponse r6, SubscribeWsStatusResponse r7, SubscribeWsMsgByProviderResponse r8, SubscribeWsMsgByCallBackResponse r9, SubscribeWsMsgByBroadCastResponse r10, GetLocationResponse r11, RefreshLocationResponse r12, DecodeLocationResponse r13, GetIntersectFencesResponse r14, StartPicoLinksResponse r15, OnePartyCommonNetworkResponse r16, SendApplogEventResponse r17, GenericNetworkResponse r18, GetTTNetParametersResponse r19, ByteString r20) {
        super(ADAPTER, r20);
        this.bizExampleResponse = r4;
        this.sendWsMessageResponse = r5;
        this.subscribeWsMsgResponse = r6;
        this.subscribeWsStatusResponse = r7;
        this.subscribeWsMsgByProviderResponse = r8;
        this.subscribeWsMsgByCallBackResponse = r9;
        this.subscribeWsMsgByBroadCastResponse = r10;
        this.getLocationResponse = r11;
        this.refreshLocationResponse = r12;
        this.decodeLocationResponse = r13;
        this.getIntersectFencesResponse = r14;
        this.startPicoLinksResponse = r15;
        this.onePartyCommonNetworkResponse = r16;
        this.sendApplogEventResponse = r17;
        this.genericNetworkResponse = r18;
        this.getTTNetParametersResponse = r19;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.bizExampleResponse = this.bizExampleResponse;
        r0.sendWsMessageResponse = this.sendWsMessageResponse;
        r0.subscribeWsMsgResponse = this.subscribeWsMsgResponse;
        r0.subscribeWsStatusResponse = this.subscribeWsStatusResponse;
        r0.subscribeWsMsgByProviderResponse = this.subscribeWsMsgByProviderResponse;
        r0.subscribeWsMsgByCallBackResponse = this.subscribeWsMsgByCallBackResponse;
        r0.subscribeWsMsgByBroadCastResponse = this.subscribeWsMsgByBroadCastResponse;
        r0.getLocationResponse = this.getLocationResponse;
        r0.refreshLocationResponse = this.refreshLocationResponse;
        r0.decodeLocationResponse = this.decodeLocationResponse;
        r0.getIntersectFencesResponse = this.getIntersectFencesResponse;
        r0.startPicoLinksResponse = this.startPicoLinksResponse;
        r0.onePartyCommonNetworkResponse = this.onePartyCommonNetworkResponse;
        r0.sendApplogEventResponse = this.sendApplogEventResponse;
        r0.genericNetworkResponse = this.genericNetworkResponse;
        r0.getTTNetParametersResponse = this.getTTNetParametersResponse;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
