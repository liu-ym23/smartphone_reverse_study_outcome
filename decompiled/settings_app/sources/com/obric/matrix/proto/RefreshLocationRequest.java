package com.obric.matrix.proto;

import com.android.settings.NotificationDisplayDetailsActivity;
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
public final class RefreshLocationRequest extends Message<RefreshLocationRequest, Builder> {
    public static final ProtoAdapter<RefreshLocationRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IGNORECACHE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("ignoreCache")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean ignoreCache;

    @SerializedName(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<RefreshLocationRequest, Builder> {
        public Boolean ignoreCache;
        public String packageName;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.packageName = "";
            this.ignoreCache = false;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        public Builder ignoreCache(Boolean r1) {
            this.ignoreCache = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RefreshLocationRequest build() {
            return new RefreshLocationRequest(this.packageName, this.ignoreCache, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_RefreshLocationRequest extends ProtoAdapter<RefreshLocationRequest> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationRequest decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, RefreshLocationRequest r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationRequest redact(RefreshLocationRequest r1) {
            return redact2(r1);
        }

        public ProtoAdapter_RefreshLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationRequest.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RefreshLocationRequest r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.packageName) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r4.ignoreCache)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, RefreshLocationRequest r4) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.packageName);
            ProtoAdapter.BOOL.encodeWithTag(r3, 2, r4.ignoreCache);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RefreshLocationRequest decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.packageName(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.ignoreCache(ProtoAdapter.BOOL.decode(r6));
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
        public RefreshLocationRequest redact2(RefreshLocationRequest r1) {
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
        ADAPTER = new ProtoAdapter_RefreshLocationRequest();
        DEFAULT_IGNORECACHE = false;
    }

    public RefreshLocationRequest(String r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RefreshLocationRequest(String r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.packageName = r2;
        this.ignoreCache = r3;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.packageName = this.packageName;
        r0.ignoreCache = this.ignoreCache;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationRequest) == true) goto L8;
        return false;
    L8:
        RefreshLocationRequest r6 = (RefreshLocationRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L16;
        if (Internal.equals(this.ignoreCache, r6.ignoreCache) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.packageName;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.ignoreCache;
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
        if (this.packageName == null) goto L6;
        r0.append(", packageName=").append(this.packageName);
    L6:
        if (this.ignoreCache == null) goto L9;
        r0.append(", ignoreCache=").append(this.ignoreCache);
    L9:
        return r0.replace(0, 2, "RefreshLocationRequest{").append('}').toString();
    }
}
