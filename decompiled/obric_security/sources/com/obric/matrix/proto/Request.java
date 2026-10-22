package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
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
public final class Request extends Message<Request, Builder> {
    public static final ProtoAdapter<Request> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_APPPKG = "";
    public static final String DEFAULT_APPVERSIONCODE = "";
    public static final String DEFAULT_CHANNEL = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_DEVICEID = "";
    public static final String DEFAULT_SDKVERSION = "";
    public static final String DEFAULT_SEQUENCEID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String accessToken;

    @SerializedName("appKey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String appKey;

    @SerializedName("appPkg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String appPkg;

    @SerializedName("appVersionCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String appVersionCode;

    @SerializedName(ProviderConstants.Sms.BODY)
    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    public final RequestBody body;

    @SerializedName("channel")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String channel;

    @SerializedName(EventConstants.EVENT_KEY_CMD)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("deviceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String deviceId;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraParams;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    public final MonitorInfo monitorInfo;

    @SerializedName("sdkVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String sdkVersion;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String sequenceId;

    public static final class Builder extends Message.Builder<Request, Builder> {
        public String accessToken;
        public String appKey;
        public String appPkg;
        public String appVersionCode;
        public RequestBody body;
        public String channel;
        public Integer cmd;
        public String deviceId;
        public Map<String, String> extraParams;
        public MonitorInfo monitorInfo;
        public String sdkVersion;
        public String sequenceId;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.cmd = 0;
            this.sequenceId = "";
            this.sdkVersion = "";
            this.appKey = "";
            this.deviceId = "";
            this.channel = "";
            this.appVersionCode = "";
            this.appPkg = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        public Builder cmd(Integer r1) {
            this.cmd = r1;
            return this;
        }

        public Builder sequenceId(String r1) {
            this.sequenceId = r1;
            return this;
        }

        public Builder sdkVersion(String r1) {
            this.sdkVersion = r1;
            return this;
        }

        public Builder appKey(String r1) {
            this.appKey = r1;
            return this;
        }

        public Builder deviceId(String r1) {
            this.deviceId = r1;
            return this;
        }

        public Builder channel(String r1) {
            this.channel = r1;
            return this;
        }

        public Builder appVersionCode(String r1) {
            this.appVersionCode = r1;
            return this;
        }

        public Builder extraParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraParams = r1;
            return this;
        }

        public Builder appPkg(String r1) {
            this.appPkg = r1;
            return this;
        }

        public Builder body(RequestBody r1) {
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

        @Override // com.squareup.wire.Message.Builder
        public Request build() {
            return new Request(this.cmd, this.sequenceId, this.sdkVersion, this.appKey, this.deviceId, this.channel, this.appVersionCode, this.extraParams, this.appPkg, this.body, this.accessToken, this.monitorInfo, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Request extends ProtoAdapter<Request> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Request r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Request r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request redact(Request r1) {
            return redact2(r1);
        }

        public ProtoAdapter_Request() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            this.extraParams = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Request r5) {
            return (((((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.cmd) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.sequenceId)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.sdkVersion)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.appKey)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r5.deviceId)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.channel)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.appVersionCode)) + this.extraParams.encodedSizeWithTag(9, r5.extraParams)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r5.appPkg)) + RequestBody.ADAPTER.encodedSizeWithTag(11, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r5.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(13, r5.monitorInfo)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, Request r5) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.cmd);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.sequenceId);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.sdkVersion);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.appKey);
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r5.deviceId);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.channel);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.appVersionCode);
            this.extraParams.encodeWithTag(r4, 9, r5.extraParams);
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r5.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r4, 11, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r5.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r4, 13, r5.monitorInfo);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Request decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r0.monitorInfo(MonitorInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.accessToken(ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.body(RequestBody.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.appPkg(ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.extraParams.putAll(this.extraParams.decode(r7));
            goto L3
        L12:
            r0.appVersionCode(ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.channel(ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.deviceId(ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.appKey(ProtoAdapter.STRING.decode(r7));
            goto L3
        L16:
            r0.sdkVersion(ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.sequenceId(ProtoAdapter.STRING.decode(r7));
            goto L3
        L18:
            r0.cmd(ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L19:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Request redact2(Request r2) {
            Builder r1 = r2.newBuilder();
            if (r1.body == null) goto L6;
            r1.body = RequestBody.ADAPTER.redact(r1.body);
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
        ADAPTER = new ProtoAdapter_Request();
        DEFAULT_CMD = 0;
    }

    public Request(Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, Map<String, String> r22, String r23, RequestBody r24, String r25, MonitorInfo r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public Request(Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9, String r10, RequestBody r11, String r12, MonitorInfo r13, ByteString r14) {
        super(ADAPTER, r14);
        this.cmd = r2;
        this.sequenceId = r3;
        this.sdkVersion = r4;
        this.appKey = r5;
        this.deviceId = r6;
        this.channel = r7;
        this.appVersionCode = r8;
        this.extraParams = Internal.immutableCopyOf("extraParams", r9);
        this.appPkg = r10;
        this.body = r11;
        this.accessToken = r12;
        this.monitorInfo = r13;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.cmd = this.cmd;
        r0.sequenceId = this.sequenceId;
        r0.sdkVersion = this.sdkVersion;
        r0.appKey = this.appKey;
        r0.deviceId = this.deviceId;
        r0.channel = this.channel;
        r0.appVersionCode = this.appVersionCode;
        r0.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r0.appPkg = this.appPkg;
        r0.body = this.body;
        r0.accessToken = this.accessToken;
        r0.monitorInfo = this.monitorInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Request) == true) goto L8;
        return false;
    L8:
        Request r6 = (Request) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L36;
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L36;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L36;
        if (Internal.equals(this.sdkVersion, r6.sdkVersion) == false) goto L36;
        if (Internal.equals(this.appKey, r6.appKey) == false) goto L36;
        if (Internal.equals(this.deviceId, r6.deviceId) == false) goto L36;
        if (Internal.equals(this.channel, r6.channel) == false) goto L36;
        if (Internal.equals(this.appVersionCode, r6.appVersionCode) == false) goto L36;
        if (this.extraParams.equals(r6.extraParams) == false) goto L36;
        if (Internal.equals(this.appPkg, r6.appPkg) == false) goto L36;
        if (Internal.equals(this.body, r6.body) == false) goto L36;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L36;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.sequenceId;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.sdkVersion;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.appKey;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.deviceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.channel;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.appVersionCode;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (((r20 + r22) * 37) + this.extraParams.hashCode()) * 37;
        String r24 = this.appPkg;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RequestBody r27 = this.body;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.accessToken;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        MonitorInfo r33 = this.monitorInfo;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        this.hashCode = r34;
        return r34;
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
    L49:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r0.append(", cmd=").append(this.cmd);
    L6:
        if (this.sequenceId == null) goto L9;
        r0.append(", sequenceId=").append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r0.append(", sdkVersion=").append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r0.append(", appKey=").append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r0.append(", deviceId=").append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r0.append(", channel=").append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r0.append(", appVersionCode=").append(this.appVersionCode);
    L23:
        Map<String, String> r1 = this.extraParams;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", extraParams=").append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r0.append(", appPkg=").append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r0.append(", body=").append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r0.append(", accessToken=").append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L41;
        r0.append(", monitorInfo=").append(this.monitorInfo);
    L41:
        return r0.replace(0, 2, "Request{").append('}').toString();
    }
}
