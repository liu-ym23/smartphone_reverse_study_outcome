package com.obric.matrix.proto;

import com.bytedance.bdinstall.Api;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class TargetDataset extends Message<TargetDataset, Builder> {
    public static final ProtoAdapter<TargetDataset> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String appid;

    @SerializedName(Api.KEY_APPKEY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appkey;

    @SerializedName("name")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String name;

    @SerializedName("properties")
    @WireField(adapter = "com.obric.matrix.proto.NullableMap#ADAPTER", tag = 4)
    public final NullableMap properties;

    public static final class Builder extends Message.Builder<TargetDataset, Builder> {
        public String appid;
        public String appkey;
        public String name;
        public NullableMap properties;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.name = "";
            this.appid = "";
            this.appkey = "";
        }

        public Builder name(String r1) {
            this.name = r1;
            return this;
        }

        public Builder appid(String r1) {
            this.appid = r1;
            return this;
        }

        public Builder appkey(String r1) {
            this.appkey = r1;
            return this;
        }

        public Builder properties(NullableMap r1) {
            this.properties = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public TargetDataset build() {
            return new TargetDataset(this.name, this.appid, this.appkey, this.properties, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_TargetDataset extends ProtoAdapter<TargetDataset> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, TargetDataset r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TargetDataset r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TargetDataset redact(TargetDataset r1) {
            return redact2(r1);
        }

        public ProtoAdapter_TargetDataset() {
            super(FieldEncoding.LENGTH_DELIMITED, TargetDataset.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TargetDataset r4) {
            return (((ProtoAdapter.STRING.encodedSizeWithTag(1, r4.name) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.appid)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.appkey)) + NullableMap.ADAPTER.encodedSizeWithTag(4, r4.properties)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, TargetDataset r4) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.name);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.appid);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.appkey);
            NullableMap.ADAPTER.encodeWithTag(r3, 4, r4.properties);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TargetDataset decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.name(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.appid(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.appkey(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.properties(NullableMap.ADAPTER.decode(r6));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TargetDataset redact2(TargetDataset r2) {
            Builder r1 = r2.newBuilder();
            if (r1.properties == null) goto L5;
            r1.properties = NullableMap.ADAPTER.redact(r1.properties);
        L5:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_TargetDataset();
    }

    public TargetDataset(String r7, String r8, String r9, NullableMap r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TargetDataset(String r2, String r3, String r4, NullableMap r5, ByteString r6) {
        super(ADAPTER, r6);
        this.name = r2;
        this.appid = r3;
        this.appkey = r4;
        this.properties = r5;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.name = this.name;
        r0.appid = this.appid;
        r0.appkey = this.appkey;
        r0.properties = this.properties;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TargetDataset) == true) goto L8;
        return false;
    L8:
        TargetDataset r6 = (TargetDataset) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.name, r6.name) == false) goto L20;
        if (Internal.equals(this.appid, r6.appid) == false) goto L20;
        if (Internal.equals(this.appkey, r6.appkey) == false) goto L20;
        if (Internal.equals(this.properties, r6.properties) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.name;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.appid;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.appkey;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        NullableMap r12 = this.properties;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
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
        if (this.name == null) goto L6;
        r0.append(", name=").append(this.name);
    L6:
        if (this.appid == null) goto L9;
        r0.append(", appid=").append(this.appid);
    L9:
        if (this.appkey == null) goto L12;
        r0.append(", appkey=").append(this.appkey);
    L12:
        if (this.properties == null) goto L15;
        r0.append(", properties=").append(this.properties);
    L15:
        return r0.replace(0, 2, "TargetDataset{").append('}').toString();
    }
}
