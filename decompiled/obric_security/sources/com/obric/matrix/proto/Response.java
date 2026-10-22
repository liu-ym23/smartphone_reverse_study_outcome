package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.securitycenter.nodisturb.ProviderConstants;
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

/* JADX INFO: loaded from: classes3.dex */
public final class Response extends Message<Response, Builder> {
    public static final ProtoAdapter<Response> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_ERRORMSG = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_SEQUENCEID = "";
    public static final Integer DEFAULT_STATUSCODE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String accessToken;

    @SerializedName(ProviderConstants.Sms.BODY)
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    public final ResponseBody body;

    @SerializedName(EventConstants.EVENT_KEY_CMD)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName(AccountConst.KEY_ERROR_MSG)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String errorMsg;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final Map<String, String> extraParams;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String logId;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    public final MonitorInfo monitorInfo;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String sequenceId;

    @SerializedName("statusCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer statusCode;

    public static final class Builder extends Message.Builder<Response, Builder> {
        public String accessToken;
        public ResponseBody body;
        public Integer cmd;
        public String errorMsg;
        public Map<String, String> extraParams;
        public String logId;
        public MonitorInfo monitorInfo;
        public String sequenceId;
        public Integer statusCode;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.cmd = 0;
            this.statusCode = 0;
            this.errorMsg = "";
            this.logId = "";
            this.sequenceId = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        public Builder cmd(Integer r1) {
            this.cmd = r1;
            return this;
        }

        public Builder statusCode(Integer r1) {
            this.statusCode = r1;
            return this;
        }

        public Builder errorMsg(String r1) {
            this.errorMsg = r1;
            return this;
        }

        public Builder logId(String r1) {
            this.logId = r1;
            return this;
        }

        public Builder sequenceId(String r1) {
            this.sequenceId = r1;
            return this;
        }

        public Builder body(ResponseBody r1) {
            this.body = r1;
            return this;
        }

        public Builder accessToken(String r1) {
            this.accessToken = r1;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r1) {
            this.monitorInfo = r1;
            return this;
        }

        public Builder extraParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraParams = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Response build() {
            return new Response(this.cmd, this.statusCode, this.errorMsg, this.logId, this.sequenceId, this.body, this.accessToken, this.monitorInfo, this.extraParams, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Response extends ProtoAdapter<Response> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Response r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Response r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response redact(Response r1) {
            return redact2(r1);
        }

        public ProtoAdapter_Response() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            this.extraParams = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Response r5) {
            return ((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.cmd) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.statusCode)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.errorMsg)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.logId)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.sequenceId)) + ResponseBody.ADAPTER.encodedSizeWithTag(7, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r5.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(9, r5.monitorInfo)) + this.extraParams.encodedSizeWithTag(10, r5.extraParams)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, Response r5) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.cmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.statusCode);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.errorMsg);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.logId);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r4, 7, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r5.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r4, 9, r5.monitorInfo);
            this.extraParams.encodeWithTag(r4, 10, r5.extraParams);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Response decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.extraParams.putAll(this.extraParams.decode(r7));
            goto L3
        L8:
            r0.monitorInfo(MonitorInfo.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.accessToken(ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.body(ResponseBody.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.sequenceId(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.logId(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.errorMsg(ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.statusCode(ProtoAdapter.INT32.decode(r7));
            goto L3
        L15:
            r0.cmd(ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Response redact2(Response r2) {
            Builder r1 = r2.newBuilder();
            if (r1.body == null) goto L6;
            r1.body = ResponseBody.ADAPTER.redact(r1.body);
        L6:
            if (r1.monitorInfo == null) goto L8;
            r1.monitorInfo = MonitorInfo.ADAPTER.redact(r1.monitorInfo);
        L8:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_Response();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public Response(Integer r12, Integer r13, String r14, String r15, String r16, ResponseBody r17, String r18, MonitorInfo r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public Response(Integer r2, Integer r3, String r4, String r5, String r6, ResponseBody r7, String r8, MonitorInfo r9, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.cmd = r2;
        this.statusCode = r3;
        this.errorMsg = r4;
        this.logId = r5;
        this.sequenceId = r6;
        this.body = r7;
        this.accessToken = r8;
        this.monitorInfo = r9;
        this.extraParams = Internal.immutableCopyOf("extraParams", r10);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.cmd = this.cmd;
        r0.statusCode = this.statusCode;
        r0.errorMsg = this.errorMsg;
        r0.logId = this.logId;
        r0.sequenceId = this.sequenceId;
        r0.body = this.body;
        r0.accessToken = this.accessToken;
        r0.monitorInfo = this.monitorInfo;
        r0.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r6 = (Response) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L30;
        if (Internal.equals(this.statusCode, r6.statusCode) == false) goto L30;
        if (Internal.equals(this.errorMsg, r6.errorMsg) == false) goto L30;
        if (Internal.equals(this.logId, r6.logId) == false) goto L30;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L30;
        if (Internal.equals(this.body, r6.body) == false) goto L30;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L30;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L30;
        if (this.extraParams.equals(r6.extraParams) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L37;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.statusCode;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.errorMsg;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.logId;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.sequenceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ResponseBody r18 = this.body;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.accessToken;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        MonitorInfo r24 = this.monitorInfo;
        if (r24 == null) goto L35;
        r3 = r24.hashCode();
    L35:
        int r25 = ((r23 + r3) * 37) + this.extraParams.hashCode();
        this.hashCode = r25;
        return r25;
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
    L37:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r0.append(", cmd=").append(this.cmd);
    L6:
        if (this.statusCode == null) goto L9;
        r0.append(", statusCode=").append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r0.append(", errorMsg=").append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r0.append(", logId=").append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r0.append(", sequenceId=").append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r0.append(", body=").append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r0.append(", accessToken=").append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r0.append(", monitorInfo=").append(this.monitorInfo);
    L26:
        Map<String, String> r1 = this.extraParams;
        if (r1 == null) goto L32;
        if (r1.isEmpty() == true) goto L32;
        r0.append(", extraParams=").append(this.extraParams);
    L32:
        return r0.replace(0, 2, "Response{").append('}').toString();
    }
}
