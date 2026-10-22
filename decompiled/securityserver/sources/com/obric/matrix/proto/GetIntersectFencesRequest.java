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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class GetIntersectFencesRequest extends Message<GetIntersectFencesRequest, Builder> {
    public static final ProtoAdapter<GetIntersectFencesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FILTER_ADJACENCY = null;
    public static final Boolean DEFAULT_WITH_BORDER_INFO = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_FROM = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_TARGET = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fence_to_cal")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    public final Fence fence_to_cal;

    @SerializedName("filter_adjacency")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean filter_adjacency;

    @SerializedName("from_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    public final TargetDataset from_dataset;

    @SerializedName("from_fence_id_list")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> from_fence_id_list;

    @SerializedName("properties_filter")
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, StringArray> properties_filter;

    @SerializedName("target_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    public final TargetDataset target_dataset;

    @SerializedName("with_border_info")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean with_border_info;

    @SerializedName("with_overlap_from")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean with_overlap_from;

    @SerializedName("with_overlap_target")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean with_overlap_target;

    public static final class Builder extends Message.Builder<GetIntersectFencesRequest, Builder> {
        public Fence fence_to_cal;
        public Boolean filter_adjacency;
        public TargetDataset from_dataset;
        public List<String> from_fence_id_list;
        public Map<String, StringArray> properties_filter;
        public TargetDataset target_dataset;
        public Boolean with_border_info;
        public Boolean with_overlap_from;
        public Boolean with_overlap_target;

        public Builder() {
            Boolean r0 = Boolean.FALSE;
            this.with_border_info = r0;
            this.filter_adjacency = r0;
            this.with_overlap_from = r0;
            this.with_overlap_target = r0;
            this.properties_filter = Internal.newMutableMap();
            this.from_fence_id_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fence_to_cal(Fence r1) {
            this.fence_to_cal = r1;
            return this;
        }

        public Builder filter_adjacency(Boolean r1) {
            this.filter_adjacency = r1;
            return this;
        }

        public Builder from_dataset(TargetDataset r1) {
            this.from_dataset = r1;
            return this;
        }

        public Builder from_fence_id_list(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.from_fence_id_list = r1;
            return this;
        }

        public Builder properties_filter(Map<String, StringArray> r1) {
            Internal.checkElementsNotNull(r1);
            this.properties_filter = r1;
            return this;
        }

        public Builder target_dataset(TargetDataset r1) {
            this.target_dataset = r1;
            return this;
        }

        public Builder with_border_info(Boolean r1) {
            this.with_border_info = r1;
            return this;
        }

        public Builder with_overlap_from(Boolean r1) {
            this.with_overlap_from = r1;
            return this;
        }

        public Builder with_overlap_target(Boolean r1) {
            this.with_overlap_target = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesRequest build() {
            return new GetIntersectFencesRequest(this.target_dataset, this.properties_filter, this.fence_to_cal, this.from_dataset, this.from_fence_id_list, this.with_border_info, this.filter_adjacency, this.with_overlap_from, this.with_overlap_target, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_GetIntersectFencesRequest extends ProtoAdapter<GetIntersectFencesRequest> {
        private final ProtoAdapter<Map<String, StringArray>> properties_filter;

        public ProtoAdapter_GetIntersectFencesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesRequest.class);
            this.properties_filter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, StringArray.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GetIntersectFencesRequest r2) {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesRequest r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesRequest redact(GetIntersectFencesRequest r1) {
            return redact2(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesRequest decode(ProtoReader r7) {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r0.with_overlap_target(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            r0.with_overlap_from(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L9:
            r0.filter_adjacency(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L10:
            r0.with_border_info(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L11:
            r0.from_fence_id_list.add(ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.from_dataset(TargetDataset.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.fence_to_cal(Fence.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.properties_filter.putAll(this.properties_filter.decode(r7));
            goto L3
        L15:
            r0.target_dataset(TargetDataset.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, GetIntersectFencesRequest r5) {
            ProtoAdapter<TargetDataset> r0 = TargetDataset.ADAPTER;
            r0.encodeWithTag(r4, 1, r5.target_dataset);
            this.properties_filter.encodeWithTag(r4, 2, r5.properties_filter);
            Fence.ADAPTER.encodeWithTag(r4, 3, r5.fence_to_cal);
            r0.encodeWithTag(r4, 4, r5.from_dataset);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 5, r5.from_fence_id_list);
            ProtoAdapter<Boolean> r3 = ProtoAdapter.BOOL;
            r3.encodeWithTag(r4, 6, r5.with_border_info);
            r3.encodeWithTag(r4, 7, r5.filter_adjacency);
            r3.encodeWithTag(r4, 8, r5.with_overlap_from);
            r3.encodeWithTag(r4, 9, r5.with_overlap_target);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetIntersectFencesRequest r5) {
            ProtoAdapter<TargetDataset> r0 = TargetDataset.ADAPTER;
            int r1 = r0.encodedSizeWithTag(1, r5.target_dataset);
            int r4 = this.properties_filter.encodedSizeWithTag(2, r5.properties_filter) + r1;
            int r2 = Fence.ADAPTER.encodedSizeWithTag(3, r5.fence_to_cal) + r4;
            int r6 = r0.encodedSizeWithTag(4, r5.from_dataset) + r2;
            int r3 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r5.from_fence_id_list) + r6;
            ProtoAdapter<Boolean> r7 = ProtoAdapter.BOOL;
            int r8 = r7.encodedSizeWithTag(6, r5.with_border_info) + r3;
            int r9 = r7.encodedSizeWithTag(7, r5.filter_adjacency) + r8;
            int r10 = r7.encodedSizeWithTag(8, r5.with_overlap_from) + r9;
            int r11 = r7.encodedSizeWithTag(9, r5.with_overlap_target) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesRequest redact2(GetIntersectFencesRequest r2) {
            Builder r1 = r2.newBuilder();
            TargetDataset r3 = r1.target_dataset;
            if (r3 == null) goto L5;
            r1.target_dataset = TargetDataset.ADAPTER.redact(r3);
        L5:
            Internal.redactElements(r1.properties_filter, StringArray.ADAPTER);
            Fence r4 = r1.fence_to_cal;
            if (r4 == null) goto L8;
            r1.fence_to_cal = Fence.ADAPTER.redact(r4);
        L8:
            TargetDataset r5 = r1.from_dataset;
            if (r5 == null) goto L11;
            r1.from_dataset = TargetDataset.ADAPTER.redact(r5);
        L11:
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesRequest();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_WITH_BORDER_INFO = r0;
        DEFAULT_FILTER_ADJACENCY = r0;
        DEFAULT_WITH_OVERLAP_FROM = r0;
        DEFAULT_WITH_OVERLAP_TARGET = r0;
    }

    public GetIntersectFencesRequest(TargetDataset r12, Map<String, StringArray> r13, Fence r14, TargetDataset r15, List<String> r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetIntersectFencesRequest) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesRequest r6 = (GetIntersectFencesRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.target_dataset, r6.target_dataset) == false) goto L30;
        if (this.properties_filter.equals(r6.properties_filter) == false) goto L30;
        if (Internal.equals(this.fence_to_cal, r6.fence_to_cal) == false) goto L30;
        if (Internal.equals(this.from_dataset, r6.from_dataset) == false) goto L30;
        if (this.from_fence_id_list.equals(r6.from_fence_id_list) == false) goto L30;
        if (Internal.equals(this.with_border_info, r6.with_border_info) == false) goto L30;
        if (Internal.equals(this.filter_adjacency, r6.filter_adjacency) == false) goto L30;
        if (Internal.equals(this.with_overlap_from, r6.with_overlap_from) == false) goto L30;
        if (Internal.equals(this.with_overlap_target, r6.with_overlap_target) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        TargetDataset r2 = this.target_dataset;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (this.properties_filter.hashCode() + ((r1 + r4) * 37)) * 37;
        Fence r6 = this.fence_to_cal;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        TargetDataset r9 = this.from_dataset;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (this.from_fence_id_list.hashCode() + ((r8 + r10) * 37)) * 37;
        Boolean r12 = this.with_border_info;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Boolean r15 = this.filter_adjacency;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Boolean r18 = this.with_overlap_from;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.with_overlap_target;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        int r22 = r20 + r3;
        this.hashCode = r22;
        return r22;
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
    L33:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.target_dataset == null) goto L5;
        r0.append(", target_dataset=");
        r0.append(this.target_dataset);
    L5:
        Map<String, StringArray> r1 = this.properties_filter;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", properties_filter=");
        r0.append(this.properties_filter);
    L11:
        if (this.fence_to_cal == null) goto L14;
        r0.append(", fence_to_cal=");
        r0.append(this.fence_to_cal);
    L14:
        if (this.from_dataset == null) goto L16;
        r0.append(", from_dataset=");
        r0.append(this.from_dataset);
    L16:
        List<String> r2 = this.from_fence_id_list;
        if (r2 == null) goto L22;
        if (r2.isEmpty() == true) goto L22;
        r0.append(", from_fence_id_list=");
        r0.append(this.from_fence_id_list);
    L22:
        if (this.with_border_info == null) goto L25;
        r0.append(", with_border_info=");
        r0.append(this.with_border_info);
    L25:
        if (this.filter_adjacency == null) goto L28;
        r0.append(", filter_adjacency=");
        r0.append(this.filter_adjacency);
    L28:
        if (this.with_overlap_from == null) goto L31;
        r0.append(", with_overlap_from=");
        r0.append(this.with_overlap_from);
    L31:
        if (this.with_overlap_target == null) goto L34;
        r0.append(", with_overlap_target=");
        r0.append(this.with_overlap_target);
    L34:
        return a.m(r0, 0, 2, "GetIntersectFencesRequest{", '}');
    }

    public GetIntersectFencesRequest(TargetDataset r2, Map<String, StringArray> r3, Fence r4, TargetDataset r5, List<String> r6, Boolean r7, Boolean r8, Boolean r9, Boolean r10, ByteString r11) {
        super(ADAPTER, r11);
        this.target_dataset = r2;
        this.properties_filter = Internal.immutableCopyOf("properties_filter", r3);
        this.fence_to_cal = r4;
        this.from_dataset = r5;
        this.from_fence_id_list = Internal.immutableCopyOf("from_fence_id_list", r6);
        this.with_border_info = r7;
        this.filter_adjacency = r8;
        this.with_overlap_from = r9;
        this.with_overlap_target = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.target_dataset = this.target_dataset;
        r0.properties_filter = Internal.copyOf("properties_filter", this.properties_filter);
        r0.fence_to_cal = this.fence_to_cal;
        r0.from_dataset = this.from_dataset;
        r0.from_fence_id_list = Internal.copyOf("from_fence_id_list", this.from_fence_id_list);
        r0.with_border_info = this.with_border_info;
        r0.filter_adjacency = this.filter_adjacency;
        r0.with_overlap_from = this.with_overlap_from;
        r0.with_overlap_target = this.with_overlap_target;
        r0.addUnknownFields(unknownFields());
        return r0;
    }
}
