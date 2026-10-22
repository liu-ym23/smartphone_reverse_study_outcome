package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\fH\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u00062"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "checkInDate", "hotelName", "checkOutDate", "hotelAddress", "checkInTime", "checkOutTime", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckInDate", "()Ljava/lang/String;", "setCheckInDate", "(Ljava/lang/String;)V", "getCheckInTime", "setCheckInTime", "getCheckOutDate", "setCheckOutDate", "getCheckOutTime", "setCheckOutTime", "getCity", "setCity", "getHotelAddress", "setHotelAddress", "getHotelName", "setHotelName", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderHotelMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String checkInDate;
    private String checkInTime;
    private String checkOutDate;
    private String checkOutTime;
    private String city;
    private String hotelAddress;
    private String hotelName;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderHotelMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
            return (OrderHotelMemoryEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity[] newArray(int r1) {
            return new OrderHotelMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderHotelMemoryEntity(Parcel r19) {
        Intrinsics.checkNotNullParameter(r19, "parcel");
        this(EntityExtKt.readStringOrEmpty(r19), r19.readLong(), r19.readLong(), r19.readInt(), EntityExtKt.readStringOrEmpty(r19), EntityExtKt.readStringOrEmpty(r19), r19.readString(), r19.readString(), r19.readString(), r19.readString(), null, 1024, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 1, r19.readInt());
    }

    public OrderHotelMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r18, "checkInDate");
        Intrinsics.checkNotNullParameter(r19, "hotelName");
        super(r12, r13, r15, 10004, r17);
        this.checkInDate = r18;
        this.hotelName = r19;
        this.checkOutDate = r20;
        this.hotelAddress = r21;
        this.checkInTime = r22;
        this.checkOutTime = r23;
        this.city = r24;
    }

    public /* synthetic */ OrderHotelMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 64) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r31 & 128) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r31 & 256) == 0) goto L13;
        String r14 = null;
    L15:
        if ((r31 & 512) == 0) goto L17;
        String r15 = null;
    L19:
        if ((r31 & 1024) == 0) goto L21;
        String r16 = null;
    L22:
        this(r18, r19, r21, r23, r24, r25, r12, r13, r14, r15, r16);
        return;
    L21:
        r16 = r30;
        goto L22
    L17:
        r15 = r29;
        goto L19
    L13:
        r14 = r28;
        goto L15
    L9:
        r13 = r27;
        goto L11
    L5:
        r12 = r26;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("checkInDate", makeModelInputValue("入住日期", this.checkInDate));
        r0.put("hotelName", makeModelInputValue("酒店名称", this.hotelName));
        String r1 = this.checkOutDate;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("checkOutDate", makeModelInputValue("退房日期", r1));
    L5:
        String r2 = this.city;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("city", makeModelInputValue("城市", r2));
    L8:
        String r3 = this.hotelAddress;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("hotelAddress", makeModelInputValue("酒店地址", r3));
    L11:
        String r4 = this.checkInTime;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("checkInTime", makeModelInputValue("入住时间", r4));
    L14:
        String r5 = this.checkOutTime;
        if (r5 == null) goto L17;
        Intrinsics.checkNotNull(r5);
        r0.put("checkOutTime", makeModelInputValue("退房时间", r5));
    L17:
        return r0;
    }

    public final String getCheckInDate() {
        return this.checkInDate;
    }

    public final String getCheckInTime() {
        return this.checkInTime;
    }

    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    public final String getCheckOutTime() {
        return this.checkOutTime;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getHotelAddress() {
        return this.hotelAddress;
    }

    public final String getHotelName() {
        return this.hotelName;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.city = (String) r2.readValue(r3);
        return;
    }

    public final void setCheckInDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.checkInDate = r2;
    }

    public final void setCheckInTime(String r1) {
        this.checkInTime = r1;
    }

    public final void setCheckOutDate(String r1) {
        this.checkOutDate = r1;
    }

    public final void setCheckOutTime(String r1) {
        this.checkOutTime = r1;
    }

    public final void setCity(String r1) {
        this.city = r1;
    }

    public final void setHotelAddress(String r1) {
        this.hotelAddress = r1;
    }

    public final void setHotelName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hotelName = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.checkInDate);
        r2.writeString(this.hotelName);
        r2.writeString(this.checkOutDate);
        r2.writeString(this.hotelAddress);
        r2.writeString(this.checkInTime);
        r2.writeString(this.checkOutTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(1);
        r2.writeValue(this.city);
    }
}
