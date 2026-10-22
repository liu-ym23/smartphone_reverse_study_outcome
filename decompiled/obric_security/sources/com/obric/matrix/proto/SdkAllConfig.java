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

/* JADX INFO: loaded from: classes3.dex */
public final class SdkAllConfig extends Message<SdkAllConfig, Builder> {
    public static final ProtoAdapter<SdkAllConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("otherConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, SdkCommonConfig> otherConfig;

    @SerializedName("sdkSendCmdConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    public final SdkSendCmdConfig sdkSendCmdConfig;

    public static final class Builder extends Message.Builder<SdkAllConfig, Builder> {
        public Map<String, SdkCommonConfig> otherConfig;
        public SdkSendCmdConfig sdkSendCmdConfig;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.otherConfig = Internal.newMutableMap();
        }

        public Builder sdkSendCmdConfig(SdkSendCmdConfig r1) {
            this.sdkSendCmdConfig = r1;
            return this;
        }

        public Builder otherConfig(Map<String, SdkCommonConfig> r1) {
            Internal.checkElementsNotNull(r1);
            this.otherConfig = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkAllConfig build() {
            return new SdkAllConfig(this.sdkSendCmdConfig, this.otherConfig, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SdkAllConfig extends ProtoAdapter<SdkAllConfig> {
        private final ProtoAdapter<Map<String, SdkCommonConfig>> otherConfig;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SdkAllConfig r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkAllConfig r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig redact(SdkAllConfig r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SdkAllConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.otherConfig = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkAllConfig r4) {
            return (SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r4.sdkSendCmdConfig) + this.otherConfig.encodedSizeWithTag(2, r4.otherConfig)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, SdkAllConfig r5) throws IOException {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r4, 1, r5.sdkSendCmdConfig);
            this.otherConfig.encodeWithTag(r4, 2, r5.otherConfig);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkAllConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.sdkSendCmdConfig(SdkSendCmdConfig.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.otherConfig.putAll(this.otherConfig.decode(r7));
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
        public SdkAllConfig redact2(SdkAllConfig r2) {
            Builder r1 = r2.newBuilder();
            if (r1.sdkSendCmdConfig == null) goto L5;
            r1.sdkSendCmdConfig = SdkSendCmdConfig.ADAPTER.redact(r1.sdkSendCmdConfig);
        L5:
            Internal.redactElements(r1.otherConfig, SdkCommonConfig.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_SdkAllConfig();
    }

    public SdkAllConfig(SdkSendCmdConfig r2, Map<String, SdkCommonConfig> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SdkAllConfig(SdkSendCmdConfig r2, Map<String, SdkCommonConfig> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.sdkSendCmdConfig = r2;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r3);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.sdkSendCmdConfig = this.sdkSendCmdConfig;
        r0.otherConfig = Internal.copyOf("otherConfig", this.otherConfig);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkAllConfig) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r6 = (SdkAllConfig) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.sdkSendCmdConfig, r6.sdkSendCmdConfig) == false) goto L16;
        if (this.otherConfig.equals(r6.otherConfig) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r2 = this.sdkSendCmdConfig;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.otherConfig.hashCode();
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
        if (this.sdkSendCmdConfig == null) goto L5;
        r0.append(", sdkSendCmdConfig=").append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r1 = this.otherConfig;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", otherConfig=").append(this.otherConfig);
    L11:
        return r0.replace(0, 2, "SdkAllConfig{").append('}').toString();
    }
}
