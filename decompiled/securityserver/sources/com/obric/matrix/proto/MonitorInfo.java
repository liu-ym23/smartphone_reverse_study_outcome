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
public final class MonitorInfo extends Message<MonitorInfo, Builder> {
    public static final ProtoAdapter<MonitorInfo> ADAPTER = null;
    public static final Long DEFAULT_MATRIXBINDPROCESSENDTIME = null;
    public static final Long DEFAULT_MATRIXBINDREVTIME = null;
    public static final Long DEFAULT_THIRDJAVAJNICALLTIME = null;
    public static final Long DEFAULT_THIRDJAVAREVRESRESULT = null;
    public static final Long DEFAULT_THIRDSTARTTIME = null;
    private static final long serialVersionUID = 0;

    @SerializedName("matrixBindProcessEndTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long matrixBindProcessEndTime;

    @SerializedName("matrixBindRevTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long matrixBindRevTime;

    @SerializedName("thirdJavaJniCallTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long thirdJavaJniCallTime;

    @SerializedName("thirdJavaRevResResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long thirdJavaRevResResult;

    @SerializedName("thirdStartTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long thirdStartTime;

    public static final class Builder extends Message.Builder<MonitorInfo, Builder> {
        public Long matrixBindProcessEndTime;
        public Long matrixBindRevTime;
        public Long thirdJavaJniCallTime;
        public Long thirdJavaRevResResult;
        public Long thirdStartTime;

        public Builder() {
            this.thirdStartTime = 0L;
            this.thirdJavaJniCallTime = 0L;
            this.matrixBindRevTime = 0L;
            this.matrixBindProcessEndTime = 0L;
            this.thirdJavaRevResResult = 0L;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder matrixBindProcessEndTime(Long r1) {
            this.matrixBindProcessEndTime = r1;
            return this;
        }

        public Builder matrixBindRevTime(Long r1) {
            this.matrixBindRevTime = r1;
            return this;
        }

        public Builder thirdJavaJniCallTime(Long r1) {
            this.thirdJavaJniCallTime = r1;
            return this;
        }

        public Builder thirdJavaRevResResult(Long r1) {
            this.thirdJavaRevResResult = r1;
            return this;
        }

        public Builder thirdStartTime(Long r1) {
            this.thirdStartTime = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public MonitorInfo build() {
            return new MonitorInfo(this.thirdStartTime, this.thirdJavaJniCallTime, this.matrixBindRevTime, this.matrixBindProcessEndTime, this.thirdJavaRevResResult, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MonitorInfo extends ProtoAdapter<MonitorInfo> {
        public ProtoAdapter_MonitorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, MonitorInfo r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MonitorInfo r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo redact(MonitorInfo r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MonitorInfo decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            r5.thirdStartTime(ProtoAdapter.INT64.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.thirdJavaJniCallTime(ProtoAdapter.INT64.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.matrixBindRevTime(ProtoAdapter.INT64.decode(r6));
            goto L3
        L12:
            if (r2 != 4) goto L14;
            r5.matrixBindProcessEndTime(ProtoAdapter.INT64.decode(r6));
            goto L3
        L14:
            if (r2 != 5) goto L15;
            r5.thirdJavaRevResResult(ProtoAdapter.INT64.decode(r6));
            goto L3
        L15:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L21:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, MonitorInfo r4) {
            ProtoAdapter<Long> r2 = ProtoAdapter.INT64;
            r2.encodeWithTag(r3, 1, r4.thirdStartTime);
            r2.encodeWithTag(r3, 2, r4.thirdJavaJniCallTime);
            r2.encodeWithTag(r3, 3, r4.matrixBindRevTime);
            r2.encodeWithTag(r3, 4, r4.matrixBindProcessEndTime);
            r2.encodeWithTag(r3, 5, r4.thirdJavaRevResResult);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MonitorInfo r4) {
            ProtoAdapter<Long> r3 = ProtoAdapter.INT64;
            int r0 = r3.encodedSizeWithTag(1, r4.thirdStartTime);
            int r1 = r3.encodedSizeWithTag(2, r4.thirdJavaJniCallTime) + r0;
            int r2 = r3.encodedSizeWithTag(3, r4.matrixBindRevTime) + r1;
            int r5 = r3.encodedSizeWithTag(4, r4.matrixBindProcessEndTime) + r2;
            int r6 = r3.encodedSizeWithTag(5, r4.thirdJavaRevResResult) + r5;
            return r4.unknownFields().size() + r6;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public MonitorInfo redact2(MonitorInfo r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MonitorInfo();
        DEFAULT_THIRDSTARTTIME = 0L;
        DEFAULT_THIRDJAVAJNICALLTIME = 0L;
        DEFAULT_MATRIXBINDREVTIME = 0L;
        DEFAULT_MATRIXBINDPROCESSENDTIME = 0L;
        DEFAULT_THIRDJAVAREVRESRESULT = 0L;
    }

    public MonitorInfo(Long r8, Long r9, Long r10, Long r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MonitorInfo) == true) goto L8;
        return false;
    L8:
        MonitorInfo r6 = (MonitorInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L22;
        if (Internal.equals(this.thirdStartTime, r6.thirdStartTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaJniCallTime, r6.thirdJavaJniCallTime) == false) goto L22;
        if (Internal.equals(this.matrixBindRevTime, r6.matrixBindRevTime) == false) goto L22;
        if (Internal.equals(this.matrixBindProcessEndTime, r6.matrixBindProcessEndTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaRevResResult, r6.thirdJavaRevResResult) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.thirdStartTime;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.thirdJavaJniCallTime;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.matrixBindRevTime;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.matrixBindProcessEndTime;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.thirdJavaRevResResult;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        this.hashCode = r16;
        return r16;
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
    L25:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.thirdStartTime == null) goto L6;
        r0.append(", thirdStartTime=");
        r0.append(this.thirdStartTime);
    L6:
        if (this.thirdJavaJniCallTime == null) goto L9;
        r0.append(", thirdJavaJniCallTime=");
        r0.append(this.thirdJavaJniCallTime);
    L9:
        if (this.matrixBindRevTime == null) goto L12;
        r0.append(", matrixBindRevTime=");
        r0.append(this.matrixBindRevTime);
    L12:
        if (this.matrixBindProcessEndTime == null) goto L15;
        r0.append(", matrixBindProcessEndTime=");
        r0.append(this.matrixBindProcessEndTime);
    L15:
        if (this.thirdJavaRevResResult == null) goto L18;
        r0.append(", thirdJavaRevResResult=");
        r0.append(this.thirdJavaRevResResult);
    L18:
        return a.m(r0, 0, 2, "MonitorInfo{", '}');
    }

    public MonitorInfo(Long r2, Long r3, Long r4, Long r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.thirdStartTime = r2;
        this.thirdJavaJniCallTime = r3;
        this.matrixBindRevTime = r4;
        this.matrixBindProcessEndTime = r5;
        this.thirdJavaRevResResult = r6;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.thirdStartTime = this.thirdStartTime;
        r0.thirdJavaJniCallTime = this.thirdJavaJniCallTime;
        r0.matrixBindRevTime = this.matrixBindRevTime;
        r0.matrixBindProcessEndTime = this.matrixBindProcessEndTime;
        r0.thirdJavaRevResResult = this.thirdJavaRevResResult;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
