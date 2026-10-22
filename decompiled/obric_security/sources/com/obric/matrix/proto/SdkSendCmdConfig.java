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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkSendCmdConfig extends Message<SdkSendCmdConfig, Builder> {
    public static final ProtoAdapter<SdkSendCmdConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_MINSUPPORTINTENTSERVICEVERSION = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("extraConfigs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> extraConfigs;

    @SerializedName("forceUseOldBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 7)
    public final List<Integer> forceUseOldBindCmd;

    @SerializedName("isAllUseBind")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isAllUseBind;

    @SerializedName("minSupportIntentServiceVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer minSupportIntentServiceVersion;

    @SerializedName("pollingInterval")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer pollingInterval;

    @SerializedName("sendCmdTimeout")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer sendCmdTimeout;

    @SerializedName("useBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
    public final List<Integer> useBindCmd;

    public static final class Builder extends Message.Builder<SdkSendCmdConfig, Builder> {
        public Map<String, String> extraConfigs;
        public List<Integer> forceUseOldBindCmd;
        public Boolean isAllUseBind;
        public Integer minSupportIntentServiceVersion;
        public Integer pollingInterval;
        public Integer sendCmdTimeout;
        public List<Integer> useBindCmd;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.isAllUseBind = false;
            this.minSupportIntentServiceVersion = 0;
            this.sendCmdTimeout = 0;
            this.pollingInterval = 0;
            this.useBindCmd = Internal.newMutableList();
            this.extraConfigs = Internal.newMutableMap();
            this.forceUseOldBindCmd = Internal.newMutableList();
        }

        public Builder isAllUseBind(Boolean r1) {
            this.isAllUseBind = r1;
            return this;
        }

        public Builder minSupportIntentServiceVersion(Integer r1) {
            this.minSupportIntentServiceVersion = r1;
            return this;
        }

        public Builder useBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.useBindCmd = r1;
            return this;
        }

        public Builder sendCmdTimeout(Integer r1) {
            this.sendCmdTimeout = r1;
            return this;
        }

        public Builder pollingInterval(Integer r1) {
            this.pollingInterval = r1;
            return this;
        }

        public Builder extraConfigs(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraConfigs = r1;
            return this;
        }

        public Builder forceUseOldBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.forceUseOldBindCmd = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkSendCmdConfig build() {
            return new SdkSendCmdConfig(this.isAllUseBind, this.minSupportIntentServiceVersion, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SdkSendCmdConfig extends ProtoAdapter<SdkSendCmdConfig> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SdkSendCmdConfig r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkSendCmdConfig r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig redact(SdkSendCmdConfig r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SdkSendCmdConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkSendCmdConfig.class);
            this.extraConfigs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkSendCmdConfig r5) {
            return ((((((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isAllUseBind) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.minSupportIntentServiceVersion)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r5.useBindCmd)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.sendCmdTimeout)) + ProtoAdapter.INT32.encodedSizeWithTag(5, r5.pollingInterval)) + this.extraConfigs.encodedSizeWithTag(6, r5.extraConfigs)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(7, r5.forceUseOldBindCmd)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, SdkSendCmdConfig r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isAllUseBind);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.minSupportIntentServiceVersion);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 3, r5.useBindCmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.sendCmdTimeout);
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r5.pollingInterval);
            this.extraConfigs.encodeWithTag(r4, 6, r5.extraConfigs);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 7, r5.forceUseOldBindCmd);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkSendCmdConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.forceUseOldBindCmd.add(ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.extraConfigs.putAll(this.extraConfigs.decode(r7));
            goto L3
        L9:
            r0.pollingInterval(ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.sendCmdTimeout(ProtoAdapter.INT32.decode(r7));
            goto L3
        L11:
            r0.useBindCmd.add(ProtoAdapter.INT32.decode(r7));
            goto L3
        L12:
            r0.minSupportIntentServiceVersion(ProtoAdapter.INT32.decode(r7));
            goto L3
        L13:
            r0.isAllUseBind(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkSendCmdConfig redact2(SdkSendCmdConfig r1) {
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
        ADAPTER = new ProtoAdapter_SdkSendCmdConfig();
        DEFAULT_ISALLUSEBIND = false;
        DEFAULT_MINSUPPORTINTENTSERVICEVERSION = 0;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkSendCmdConfig(Boolean r10, Integer r11, List<Integer> r12, Integer r13, Integer r14, Map<String, String> r15, List<Integer> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public SdkSendCmdConfig(Boolean r2, Integer r3, List<Integer> r4, Integer r5, Integer r6, Map<String, String> r7, List<Integer> r8, ByteString r9) {
        super(ADAPTER, r9);
        this.isAllUseBind = r2;
        this.minSupportIntentServiceVersion = r3;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r4);
        this.sendCmdTimeout = r5;
        this.pollingInterval = r6;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r7);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r8);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isAllUseBind = this.isAllUseBind;
        r0.minSupportIntentServiceVersion = this.minSupportIntentServiceVersion;
        r0.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r0.sendCmdTimeout = this.sendCmdTimeout;
        r0.pollingInterval = this.pollingInterval;
        r0.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r0.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkSendCmdConfig) == true) goto L8;
        return false;
    L8:
        SdkSendCmdConfig r6 = (SdkSendCmdConfig) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.isAllUseBind, r6.isAllUseBind) == false) goto L26;
        if (Internal.equals(this.minSupportIntentServiceVersion, r6.minSupportIntentServiceVersion) == false) goto L26;
        if (this.useBindCmd.equals(r6.useBindCmd) == false) goto L26;
        if (Internal.equals(this.sendCmdTimeout, r6.sendCmdTimeout) == false) goto L26;
        if (Internal.equals(this.pollingInterval, r6.pollingInterval) == false) goto L26;
        if (this.extraConfigs.equals(r6.extraConfigs) == false) goto L26;
        if (this.forceUseOldBindCmd.equals(r6.forceUseOldBindCmd) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isAllUseBind;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.minSupportIntentServiceVersion;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((r5 + r7) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r9 = this.sendCmdTimeout;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.pollingInterval;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((((r11 + r3) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.isAllUseBind == null) goto L6;
        r0.append(", isAllUseBind=").append(this.isAllUseBind);
    L6:
        if (this.minSupportIntentServiceVersion == null) goto L8;
        r0.append(", minSupportIntentServiceVersion=").append(this.minSupportIntentServiceVersion);
    L8:
        List<Integer> r1 = this.useBindCmd;
        if (r1 == null) goto L14;
        if (r1.isEmpty() == true) goto L14;
        r0.append(", useBindCmd=").append(this.useBindCmd);
    L14:
        if (this.sendCmdTimeout == null) goto L17;
        r0.append(", sendCmdTimeout=").append(this.sendCmdTimeout);
    L17:
        if (this.pollingInterval == null) goto L19;
        r0.append(", pollingInterval=").append(this.pollingInterval);
    L19:
        Map<String, String> r2 = this.extraConfigs;
        if (r2 != null) goto L22;
    L24:
        List<Integer> r3 = this.forceUseOldBindCmd;
        if (r3 == null) goto L30;
        if (r3.isEmpty() == true) goto L30;
        r0.append(", forceUseOldBindCmd=").append(this.forceUseOldBindCmd);
    L30:
        return r0.replace(0, 2, "SdkSendCmdConfig{").append('}').toString();
    L22:
        if (r2.isEmpty() == true) goto L24;
        r0.append(", extraConfigs=").append(this.extraConfigs);
        goto L24
    }
}
