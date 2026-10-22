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
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Pair extends Message<Pair, Builder> {
    public static final ProtoAdapter<Pair> ADAPTER = null;
    public static final String DEFAULT__KEY = "";
    public static final String DEFAULT__VAL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("_key")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String _key;

    @SerializedName("_val")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String _val;

    public static final class Builder extends Message.Builder<Pair, Builder> {
        public String _key;
        public String _val;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this._key = "";
            this._val = "";
        }

        public Builder _key(String r1) {
            this._key = r1;
            return this;
        }

        public Builder _val(String r1) {
            this._val = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Pair build() {
            return new Pair(this._key, this._val, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Pair r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Pair r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair redact(Pair r1) {
            return redact2(r1);
        }

        public ProtoAdapter_Pair() {
            super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Pair r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4._key) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4._val)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, Pair r4) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4._key);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4._val);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Pair decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5._key(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5._val(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Pair redact2(Pair r1) {
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
        ADAPTER = new ProtoAdapter_Pair();
    }

    public Pair(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Pair(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this._key = r2;
        this._val = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0._key = this._key;
        r0._val = this._val;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r6 = (Pair) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this._key, r6._key) == false) goto L16;
        if (Internal.equals(this._val, r6._val) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this._key;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this._val;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this._key == null) goto L6;
        r0.append(", _key=").append(this._key);
    L6:
        if (this._val == null) goto L9;
        r0.append(", _val=").append(this._val);
    L9:
        return r0.replace(0, 2, "Pair{").append('}').toString();
    }
}
