package com.obric.matrix.proto;

import com.bytedance.apm6.consumer.slardar.Constants;
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
public final class SdkCommonConfig extends Message<SdkCommonConfig, Builder> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName(Constants.KEY_CONFIG)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> configs;

    public static final class Builder extends Message.Builder<SdkCommonConfig, Builder> {
        public Map<String, String> configs;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.configs = Internal.newMutableMap();
        }

        public Builder configs(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.configs = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkCommonConfig build() {
            return new SdkCommonConfig(this.configs, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SdkCommonConfig extends ProtoAdapter<SdkCommonConfig> {
        private final ProtoAdapter<Map<String, String>> configs;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SdkCommonConfig r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkCommonConfig r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig redact(SdkCommonConfig r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SdkCommonConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            this.configs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkCommonConfig r3) {
            return this.configs.encodedSizeWithTag(1, r3.configs) + r3.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, SdkCommonConfig r4) throws IOException {
            this.configs.encodeWithTag(r3, 1, r4.configs);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkCommonConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.configs.putAll(this.configs.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkCommonConfig redact2(SdkCommonConfig r1) {
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
        ADAPTER = new ProtoAdapter_SdkCommonConfig();
    }

    public SdkCommonConfig(Map<String, String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public SdkCommonConfig(Map<String, String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.configs = Internal.immutableCopyOf(Constants.KEY_CONFIG, r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.configs = Internal.copyOf(Constants.KEY_CONFIG, this.configs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkCommonConfig) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r6 = (SdkCommonConfig) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.configs.equals(r6.configs) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, String> r1 = this.configs;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", configs=").append(this.configs);
    L8:
        return r0.replace(0, 2, "SdkCommonConfig{").append('}').toString();
    }
}
