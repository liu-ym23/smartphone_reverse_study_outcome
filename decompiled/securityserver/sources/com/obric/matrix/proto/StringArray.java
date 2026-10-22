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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class StringArray extends Message<StringArray, Builder> {
    public static final ProtoAdapter<StringArray> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> _value;

    public static final class Builder extends Message.Builder<StringArray, Builder> {
        public List<String> _value;

        public Builder() {
            this._value = Internal.newMutableList();
        }

        public Builder _value(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this._value = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.squareup.wire.Message.Builder
        public StringArray build() {
            return new StringArray(this._value, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_StringArray extends ProtoAdapter<StringArray> {
        public ProtoAdapter_StringArray() {
            super(FieldEncoding.LENGTH_DELIMITED, StringArray.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, StringArray r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StringArray r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray redact(StringArray r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StringArray decode(ProtoReader r6) {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5._value.add(ProtoAdapter.STRING.decode(r6));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, StringArray r4) {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r3, 1, r4._value);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StringArray r3) {
            int r2 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r3._value);
            return r3.unknownFields().size() + r2;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public StringArray redact2(StringArray r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StringArray();
    }

    public StringArray(List<String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StringArray) == true) goto L8;
        return false;
    L8:
        StringArray r6 = (StringArray) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this._value.equals(r6._value) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = this._value;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=");
        r0.append(this._value);
    L8:
        return a.m(r0, 0, 2, "StringArray{", '}');
    }

    public StringArray(List<String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this._value = Internal.immutableCopyOf("_value", r2);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0._value = Internal.copyOf("_value", this._value);
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
