package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class StartPicoLinksResponse extends Message<StartPicoLinksResponse, Builder> {
    public static final ProtoAdapter<StartPicoLinksResponse> ADAPTER = null;
    public static final Phase DEFAULT_PHASE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("phase")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse$Phase#ADAPTER", tag = 1)
    public final Phase phase;

    @SerializedName("phaseData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> phaseData;

    public static final class Builder extends Message.Builder<StartPicoLinksResponse, Builder> {
        public Phase phase;
        public Map<String, String> phaseData;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.phase = Phase.SYNC_INVOKE;
            this.phaseData = Internal.newMutableMap();
        }

        public Builder phase(Phase r1) {
            this.phase = r1;
            return this;
        }

        public Builder phaseData(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.phaseData = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public StartPicoLinksResponse build() {
            return new StartPicoLinksResponse(this.phase, this.phaseData, super.buildUnknownFields());
        }
    }

    public static final enum Phase extends Enum<Phase> implements WireEnum {
        private static final /* synthetic */ Phase[] $VALUES = null;
        public static final ProtoAdapter<Phase> ADAPTER = null;
        public static final Phase ASYNC_CALLBACK = null;
        public static final Phase SYNC_INVOKE = null;
        public static final Phase URL_REDIRECT = null;
        private final int value;

        private static final class ProtoAdapter_Phase extends EnumAdapter<Phase> {
            @Override // com.squareup.wire.EnumAdapter
            protected /* bridge */ /* synthetic */ WireEnum fromValue(int r1) {
                return fromValue(r1);
            }

            ProtoAdapter_Phase() {
                super(Phase.class);
            }

            @Override // com.squareup.wire.EnumAdapter
            protected Phase fromValue(int r1) {
                return Phase.fromValue(r1);
            }
        }

        public static Phase valueOf(String r1) {
            return (Phase) Enum.valueOf(Phase.class, r1);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }

        static {
            Phase r0 = new Phase("SYNC_INVOKE", 0, 0);
            SYNC_INVOKE = r0;
            Phase r1 = new Phase("ASYNC_CALLBACK", 1, 1);
            ASYNC_CALLBACK = r1;
            Phase r3 = new Phase("URL_REDIRECT", 2, 2);
            URL_REDIRECT = r3;
            $VALUES = new Phase[]{r0, r1, r3};
            ADAPTER = new ProtoAdapter_Phase();
        }

        private Phase(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static Phase fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return URL_REDIRECT;
        L12:
            return ASYNC_CALLBACK;
        L14:
            return SYNC_INVOKE;
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    private static final class ProtoAdapter_StartPicoLinksResponse extends ProtoAdapter<StartPicoLinksResponse> {
        private final ProtoAdapter<Map<String, String>> phaseData;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, StartPicoLinksResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StartPicoLinksResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StartPicoLinksResponse redact(StartPicoLinksResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_StartPicoLinksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, StartPicoLinksResponse.class);
            this.phaseData = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StartPicoLinksResponse r4) {
            return (Phase.ADAPTER.encodedSizeWithTag(1, r4.phase) + this.phaseData.encodedSizeWithTag(2, r4.phaseData)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, StartPicoLinksResponse r5) throws IOException {
            Phase.ADAPTER.encodeWithTag(r4, 1, r5.phase);
            this.phaseData.encodeWithTag(r4, 2, r5.phaseData);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StartPicoLinksResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.phase(Phase.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.phaseData.putAll(this.phaseData.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StartPicoLinksResponse redact2(StartPicoLinksResponse r1) {
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
        ADAPTER = new ProtoAdapter_StartPicoLinksResponse();
        DEFAULT_PHASE = Phase.SYNC_INVOKE;
    }

    public StartPicoLinksResponse(Phase r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public StartPicoLinksResponse(Phase r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.phase = r2;
        this.phaseData = Internal.immutableCopyOf("phaseData", r3);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.phase = this.phase;
        r0.phaseData = Internal.copyOf("phaseData", this.phaseData);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StartPicoLinksResponse) == true) goto L8;
        return false;
    L8:
        StartPicoLinksResponse r6 = (StartPicoLinksResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.phase, r6.phase) == false) goto L16;
        if (this.phaseData.equals(r6.phaseData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Phase r2 = this.phase;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.phaseData.hashCode();
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
        if (this.phase == null) goto L5;
        r0.append(", phase=").append(this.phase);
    L5:
        Map<String, String> r1 = this.phaseData;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", phaseData=").append(this.phaseData);
    L11:
        return r0.replace(0, 2, "StartPicoLinksResponse{").append('}').toString();
    }
}
