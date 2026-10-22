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
public final class RequestBody extends Message<RequestBody, Builder> {
    public static final ProtoAdapter<RequestBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleRequest")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    public final BizExampleRequest bizExampleRequest;

    @SerializedName("decodeLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    public final DecodeLocationRequest decodeLocationRequest;

    @SerializedName("genericNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    public final GenericNetworkRequest genericNetworkRequest;

    @SerializedName("getIntersectFencesRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    public final GetIntersectFencesRequest getIntersectFencesRequest;

    @SerializedName("getLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    public final GetLocationRequest getLocationRequest;

    @SerializedName("getTTNetParametersRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    public final GetTTNetParametersRequest getTTNetParametersRequest;

    @SerializedName("onePartyCommonNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;

    @SerializedName("picoLinksCallback")
    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    public final PicoLinksCallback picoLinksCallback;

    @SerializedName("refreshLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    public final RefreshLocationRequest refreshLocationRequest;

    @SerializedName("sendApplogEventRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    public final SendApplogEventRequest sendApplogEventRequest;

    @SerializedName("sendWsMessageRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    public final SendWsMessageRequest sendWsMessageRequest;

    @SerializedName("startPicoLinksRequest")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    public final StartPicoLinksRequest startPicoLinksRequest;

    @SerializedName("subscribeWsMsgByBroadCastRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;

    @SerializedName("subscribeWsMsgByCallBackRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;

    @SerializedName("subscribeWsMsgByProviderRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;

    @SerializedName("subscribeWsMsgRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    public final SubscribeWsMsgRequest subscribeWsMsgRequest;

    @SerializedName("subscribeWsStatusRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    public final SubscribeWsStatusRequest subscribeWsStatusRequest;

    public static final class Builder extends Message.Builder<RequestBody, Builder> {
        public BizExampleRequest bizExampleRequest;
        public DecodeLocationRequest decodeLocationRequest;
        public GenericNetworkRequest genericNetworkRequest;
        public GetIntersectFencesRequest getIntersectFencesRequest;
        public GetLocationRequest getLocationRequest;
        public GetTTNetParametersRequest getTTNetParametersRequest;
        public OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;
        public PicoLinksCallback picoLinksCallback;
        public RefreshLocationRequest refreshLocationRequest;
        public SendApplogEventRequest sendApplogEventRequest;
        public SendWsMessageRequest sendWsMessageRequest;
        public StartPicoLinksRequest startPicoLinksRequest;
        public SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;
        public SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;
        public SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;
        public SubscribeWsMsgRequest subscribeWsMsgRequest;
        public SubscribeWsStatusRequest subscribeWsStatusRequest;

        public Builder() {
        }

        public Builder bizExampleRequest(BizExampleRequest r1) {
            this.bizExampleRequest = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder decodeLocationRequest(DecodeLocationRequest r1) {
            this.decodeLocationRequest = r1;
            return this;
        }

        public Builder genericNetworkRequest(GenericNetworkRequest r1) {
            this.genericNetworkRequest = r1;
            return this;
        }

        public Builder getIntersectFencesRequest(GetIntersectFencesRequest r1) {
            this.getIntersectFencesRequest = r1;
            return this;
        }

        public Builder getLocationRequest(GetLocationRequest r1) {
            this.getLocationRequest = r1;
            return this;
        }

        public Builder getTTNetParametersRequest(GetTTNetParametersRequest r1) {
            this.getTTNetParametersRequest = r1;
            return this;
        }

        public Builder onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest r1) {
            this.onePartyCommonNetworkRequest = r1;
            return this;
        }

        public Builder picoLinksCallback(PicoLinksCallback r1) {
            this.picoLinksCallback = r1;
            return this;
        }

        public Builder refreshLocationRequest(RefreshLocationRequest r1) {
            this.refreshLocationRequest = r1;
            return this;
        }

        public Builder sendApplogEventRequest(SendApplogEventRequest r1) {
            this.sendApplogEventRequest = r1;
            return this;
        }

        public Builder sendWsMessageRequest(SendWsMessageRequest r1) {
            this.sendWsMessageRequest = r1;
            return this;
        }

        public Builder startPicoLinksRequest(StartPicoLinksRequest r1) {
            this.startPicoLinksRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest r1) {
            this.subscribeWsMsgByBroadCastRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest r1) {
            this.subscribeWsMsgByCallBackRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest r1) {
            this.subscribeWsMsgByProviderRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgRequest(SubscribeWsMsgRequest r1) {
            this.subscribeWsMsgRequest = r1;
            return this;
        }

        public Builder subscribeWsStatusRequest(SubscribeWsStatusRequest r1) {
            this.subscribeWsStatusRequest = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RequestBody build() {
            return new RequestBody(this.bizExampleRequest, this.sendWsMessageRequest, this.subscribeWsMsgRequest, this.subscribeWsStatusRequest, this.subscribeWsMsgByProviderRequest, this.subscribeWsMsgByCallBackRequest, this.subscribeWsMsgByBroadCastRequest, this.getLocationRequest, this.refreshLocationRequest, this.decodeLocationRequest, this.getIntersectFencesRequest, this.startPicoLinksRequest, this.picoLinksCallback, this.onePartyCommonNetworkRequest, this.sendApplogEventRequest, this.genericNetworkRequest, this.getTTNetParametersRequest, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_RequestBody extends ProtoAdapter<RequestBody> {
        public ProtoAdapter_RequestBody() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, RequestBody r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RequestBody r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody redact(RequestBody r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RequestBody decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L7;
            r5.bizExampleRequest(BizExampleRequest.ADAPTER.decode(r6));
            goto L3
        L7:
            switch(r2) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r5.subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r6));
            goto L3
        L23:
            r5.subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r6));
            goto L3
        L24:
            r5.subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest.ADAPTER.decode(r6));
            goto L3
        L25:
            r5.subscribeWsStatusRequest(SubscribeWsStatusRequest.ADAPTER.decode(r6));
            goto L3
        L26:
            r5.subscribeWsMsgRequest(SubscribeWsMsgRequest.ADAPTER.decode(r6));
            goto L3
        L27:
            r5.sendWsMessageRequest(SendWsMessageRequest.ADAPTER.decode(r6));
            goto L3
        L8:
            switch(r2) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r5.getIntersectFencesRequest(GetIntersectFencesRequest.ADAPTER.decode(r6));
            goto L3
        L19:
            r5.decodeLocationRequest(DecodeLocationRequest.ADAPTER.decode(r6));
            goto L3
        L20:
            r5.refreshLocationRequest(RefreshLocationRequest.ADAPTER.decode(r6));
            goto L3
        L21:
            r5.getLocationRequest(GetLocationRequest.ADAPTER.decode(r6));
            goto L3
        L9:
            switch(r2) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r5.picoLinksCallback(PicoLinksCallback.ADAPTER.decode(r6));
            goto L3
        L17:
            r5.startPicoLinksRequest(StartPicoLinksRequest.ADAPTER.decode(r6));
            goto L3
        L10:
            switch(r2) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r5.getTTNetParametersRequest(GetTTNetParametersRequest.ADAPTER.decode(r6));
            goto L3
        L13:
            r5.genericNetworkRequest(GenericNetworkRequest.ADAPTER.decode(r6));
            goto L3
        L14:
            r5.sendApplogEventRequest(SendApplogEventRequest.ADAPTER.decode(r6));
            goto L3
        L15:
            r5.onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest.ADAPTER.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, RequestBody r4) {
            BizExampleRequest.ADAPTER.encodeWithTag(r3, 100000, r4.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r3, 101001, r4.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r3, 101002, r4.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r3, 101003, r4.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r3, 101004, r4.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r3, 101005, r4.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r3, 101006, r4.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r3, 102001, r4.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r3, 102002, r4.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r3, 102003, r4.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r3, 102004, r4.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r3, 111001, r4.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r3, 111002, r4.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r3, 112001, r4.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r3, 112002, r4.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r3, 112003, r4.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r3, 112004, r4.getTTNetParametersRequest);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RequestBody r4) {
            int r3 = BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r4.bizExampleRequest);
            int r0 = SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r4.sendWsMessageRequest) + r3;
            int r5 = SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r4.subscribeWsMsgRequest) + r0;
            int r1 = SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r4.subscribeWsStatusRequest) + r5;
            int r6 = SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r4.subscribeWsMsgByProviderRequest) + r1;
            int r2 = SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r4.subscribeWsMsgByCallBackRequest) + r6;
            int r7 = SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r4.subscribeWsMsgByBroadCastRequest) + r2;
            int r8 = GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r4.getLocationRequest) + r7;
            int r9 = RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r4.refreshLocationRequest) + r8;
            int r10 = DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r4.decodeLocationRequest) + r9;
            int r11 = GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r4.getIntersectFencesRequest) + r10;
            int r12 = StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r4.startPicoLinksRequest) + r11;
            int r13 = PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r4.picoLinksCallback) + r12;
            int r14 = OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r4.onePartyCommonNetworkRequest) + r13;
            int r15 = SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r4.sendApplogEventRequest) + r14;
            int r16 = GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r4.genericNetworkRequest) + r15;
            int r17 = GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r4.getTTNetParametersRequest) + r16;
            return r4.unknownFields().size() + r17;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RequestBody redact2(RequestBody r2) {
            Builder r1 = r2.newBuilder();
            BizExampleRequest r3 = r1.bizExampleRequest;
            if (r3 == null) goto L5;
            r1.bizExampleRequest = BizExampleRequest.ADAPTER.redact(r3);
        L5:
            SendWsMessageRequest r4 = r1.sendWsMessageRequest;
            if (r4 == null) goto L8;
            r1.sendWsMessageRequest = SendWsMessageRequest.ADAPTER.redact(r4);
        L8:
            SubscribeWsMsgRequest r5 = r1.subscribeWsMsgRequest;
            if (r5 == null) goto L11;
            r1.subscribeWsMsgRequest = SubscribeWsMsgRequest.ADAPTER.redact(r5);
        L11:
            SubscribeWsStatusRequest r6 = r1.subscribeWsStatusRequest;
            if (r6 == null) goto L14;
            r1.subscribeWsStatusRequest = SubscribeWsStatusRequest.ADAPTER.redact(r6);
        L14:
            SubscribeWsMsgByProviderRequest r7 = r1.subscribeWsMsgByProviderRequest;
            if (r7 == null) goto L17;
            r1.subscribeWsMsgByProviderRequest = SubscribeWsMsgByProviderRequest.ADAPTER.redact(r7);
        L17:
            SubscribeWsMsgByCallBackRequest r8 = r1.subscribeWsMsgByCallBackRequest;
            if (r8 == null) goto L20;
            r1.subscribeWsMsgByCallBackRequest = SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r8);
        L20:
            SubscribeWsMsgByBroadCastRequest r9 = r1.subscribeWsMsgByBroadCastRequest;
            if (r9 == null) goto L23;
            r1.subscribeWsMsgByBroadCastRequest = SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r9);
        L23:
            GetLocationRequest r10 = r1.getLocationRequest;
            if (r10 == null) goto L26;
            r1.getLocationRequest = GetLocationRequest.ADAPTER.redact(r10);
        L26:
            RefreshLocationRequest r11 = r1.refreshLocationRequest;
            if (r11 == null) goto L29;
            r1.refreshLocationRequest = RefreshLocationRequest.ADAPTER.redact(r11);
        L29:
            DecodeLocationRequest r12 = r1.decodeLocationRequest;
            if (r12 == null) goto L32;
            r1.decodeLocationRequest = DecodeLocationRequest.ADAPTER.redact(r12);
        L32:
            GetIntersectFencesRequest r13 = r1.getIntersectFencesRequest;
            if (r13 == null) goto L35;
            r1.getIntersectFencesRequest = GetIntersectFencesRequest.ADAPTER.redact(r13);
        L35:
            StartPicoLinksRequest r14 = r1.startPicoLinksRequest;
            if (r14 == null) goto L38;
            r1.startPicoLinksRequest = StartPicoLinksRequest.ADAPTER.redact(r14);
        L38:
            PicoLinksCallback r15 = r1.picoLinksCallback;
            if (r15 == null) goto L41;
            r1.picoLinksCallback = PicoLinksCallback.ADAPTER.redact(r15);
        L41:
            OnePartyCommonNetworkRequest r16 = r1.onePartyCommonNetworkRequest;
            if (r16 == null) goto L44;
            r1.onePartyCommonNetworkRequest = OnePartyCommonNetworkRequest.ADAPTER.redact(r16);
        L44:
            SendApplogEventRequest r17 = r1.sendApplogEventRequest;
            if (r17 == null) goto L47;
            r1.sendApplogEventRequest = SendApplogEventRequest.ADAPTER.redact(r17);
        L47:
            GenericNetworkRequest r18 = r1.genericNetworkRequest;
            if (r18 == null) goto L50;
            r1.genericNetworkRequest = GenericNetworkRequest.ADAPTER.redact(r18);
        L50:
            GetTTNetParametersRequest r19 = r1.getTTNetParametersRequest;
            if (r19 == null) goto L53;
            r1.getTTNetParametersRequest = GetTTNetParametersRequest.ADAPTER.redact(r19);
        L53:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RequestBody();
    }

    public RequestBody(BizExampleRequest r20, SendWsMessageRequest r21, SubscribeWsMsgRequest r22, SubscribeWsStatusRequest r23, SubscribeWsMsgByProviderRequest r24, SubscribeWsMsgByCallBackRequest r25, SubscribeWsMsgByBroadCastRequest r26, GetLocationRequest r27, RefreshLocationRequest r28, DecodeLocationRequest r29, GetIntersectFencesRequest r30, StartPicoLinksRequest r31, PicoLinksCallback r32, OnePartyCommonNetworkRequest r33, SendApplogEventRequest r34, GenericNetworkRequest r35, GetTTNetParametersRequest r36) {
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RequestBody) == true) goto L8;
        return false;
    L8:
        RequestBody r6 = (RequestBody) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L46;
        if (Internal.equals(this.bizExampleRequest, r6.bizExampleRequest) == false) goto L46;
        if (Internal.equals(this.sendWsMessageRequest, r6.sendWsMessageRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgRequest, r6.subscribeWsMsgRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsStatusRequest, r6.subscribeWsStatusRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r6.subscribeWsMsgByProviderRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r6.subscribeWsMsgByCallBackRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r6.subscribeWsMsgByBroadCastRequest) == false) goto L46;
        if (Internal.equals(this.getLocationRequest, r6.getLocationRequest) == false) goto L46;
        if (Internal.equals(this.refreshLocationRequest, r6.refreshLocationRequest) == false) goto L46;
        if (Internal.equals(this.decodeLocationRequest, r6.decodeLocationRequest) == false) goto L46;
        if (Internal.equals(this.getIntersectFencesRequest, r6.getIntersectFencesRequest) == false) goto L46;
        if (Internal.equals(this.startPicoLinksRequest, r6.startPicoLinksRequest) == false) goto L46;
        if (Internal.equals(this.picoLinksCallback, r6.picoLinksCallback) == false) goto L46;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r6.onePartyCommonNetworkRequest) == false) goto L46;
        if (Internal.equals(this.sendApplogEventRequest, r6.sendApplogEventRequest) == false) goto L46;
        if (Internal.equals(this.genericNetworkRequest, r6.genericNetworkRequest) == false) goto L46;
        if (Internal.equals(this.getTTNetParametersRequest, r6.getTTNetParametersRequest) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L73;
        int r1 = unknownFields().hashCode() * 37;
        BizExampleRequest r2 = this.bizExampleRequest;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        SendWsMessageRequest r6 = this.sendWsMessageRequest;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        SubscribeWsMsgRequest r9 = this.subscribeWsMsgRequest;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        SubscribeWsStatusRequest r12 = this.subscribeWsStatusRequest;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        SubscribeWsMsgByProviderRequest r15 = this.subscribeWsMsgByProviderRequest;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgByCallBackRequest r18 = this.subscribeWsMsgByCallBackRequest;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        SubscribeWsMsgByBroadCastRequest r21 = this.subscribeWsMsgByBroadCastRequest;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        GetLocationRequest r24 = this.getLocationRequest;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RefreshLocationRequest r27 = this.refreshLocationRequest;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        DecodeLocationRequest r30 = this.decodeLocationRequest;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        GetIntersectFencesRequest r33 = this.getIntersectFencesRequest;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        StartPicoLinksRequest r36 = this.startPicoLinksRequest;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        PicoLinksCallback r39 = this.picoLinksCallback;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        OnePartyCommonNetworkRequest r42 = this.onePartyCommonNetworkRequest;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        SendApplogEventRequest r45 = this.sendApplogEventRequest;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        GenericNetworkRequest r48 = this.genericNetworkRequest;
        if (r48 == null) goto L67;
        int r49 = r48.hashCode();
    L68:
        int r50 = (r47 + r49) * 37;
        GetTTNetParametersRequest r51 = this.getTTNetParametersRequest;
        if (r51 == null) goto L71;
        r3 = r51.hashCode();
    L71:
        int r52 = r50 + r3;
        this.hashCode = r52;
        return r52;
    L67:
        r49 = 0;
        goto L68
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
    L73:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.bizExampleRequest == null) goto L6;
        r0.append(", bizExampleRequest=");
        r0.append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r0.append(", sendWsMessageRequest=");
        r0.append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r0.append(", subscribeWsMsgRequest=");
        r0.append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r0.append(", subscribeWsStatusRequest=");
        r0.append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r0.append(", subscribeWsMsgByProviderRequest=");
        r0.append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackRequest=");
        r0.append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastRequest=");
        r0.append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r0.append(", getLocationRequest=");
        r0.append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r0.append(", refreshLocationRequest=");
        r0.append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r0.append(", decodeLocationRequest=");
        r0.append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r0.append(", getIntersectFencesRequest=");
        r0.append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r0.append(", startPicoLinksRequest=");
        r0.append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r0.append(", picoLinksCallback=");
        r0.append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r0.append(", onePartyCommonNetworkRequest=");
        r0.append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r0.append(", sendApplogEventRequest=");
        r0.append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r0.append(", genericNetworkRequest=");
        r0.append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L54;
        r0.append(", getTTNetParametersRequest=");
        r0.append(this.getTTNetParametersRequest);
    L54:
        return a.m(r0, 0, 2, "RequestBody{", '}');
    }

    public RequestBody(BizExampleRequest r4, SendWsMessageRequest r5, SubscribeWsMsgRequest r6, SubscribeWsStatusRequest r7, SubscribeWsMsgByProviderRequest r8, SubscribeWsMsgByCallBackRequest r9, SubscribeWsMsgByBroadCastRequest r10, GetLocationRequest r11, RefreshLocationRequest r12, DecodeLocationRequest r13, GetIntersectFencesRequest r14, StartPicoLinksRequest r15, PicoLinksCallback r16, OnePartyCommonNetworkRequest r17, SendApplogEventRequest r18, GenericNetworkRequest r19, GetTTNetParametersRequest r20, ByteString r21) {
        super(ADAPTER, r21);
        this.bizExampleRequest = r4;
        this.sendWsMessageRequest = r5;
        this.subscribeWsMsgRequest = r6;
        this.subscribeWsStatusRequest = r7;
        this.subscribeWsMsgByProviderRequest = r8;
        this.subscribeWsMsgByCallBackRequest = r9;
        this.subscribeWsMsgByBroadCastRequest = r10;
        this.getLocationRequest = r11;
        this.refreshLocationRequest = r12;
        this.decodeLocationRequest = r13;
        this.getIntersectFencesRequest = r14;
        this.startPicoLinksRequest = r15;
        this.picoLinksCallback = r16;
        this.onePartyCommonNetworkRequest = r17;
        this.sendApplogEventRequest = r18;
        this.genericNetworkRequest = r19;
        this.getTTNetParametersRequest = r20;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.bizExampleRequest = this.bizExampleRequest;
        r0.sendWsMessageRequest = this.sendWsMessageRequest;
        r0.subscribeWsMsgRequest = this.subscribeWsMsgRequest;
        r0.subscribeWsStatusRequest = this.subscribeWsStatusRequest;
        r0.subscribeWsMsgByProviderRequest = this.subscribeWsMsgByProviderRequest;
        r0.subscribeWsMsgByCallBackRequest = this.subscribeWsMsgByCallBackRequest;
        r0.subscribeWsMsgByBroadCastRequest = this.subscribeWsMsgByBroadCastRequest;
        r0.getLocationRequest = this.getLocationRequest;
        r0.refreshLocationRequest = this.refreshLocationRequest;
        r0.decodeLocationRequest = this.decodeLocationRequest;
        r0.getIntersectFencesRequest = this.getIntersectFencesRequest;
        r0.startPicoLinksRequest = this.startPicoLinksRequest;
        r0.picoLinksCallback = this.picoLinksCallback;
        r0.onePartyCommonNetworkRequest = this.onePartyCommonNetworkRequest;
        r0.sendApplogEventRequest = this.sendApplogEventRequest;
        r0.genericNetworkRequest = this.genericNetworkRequest;
        r0.getTTNetParametersRequest = this.getTTNetParametersRequest;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
