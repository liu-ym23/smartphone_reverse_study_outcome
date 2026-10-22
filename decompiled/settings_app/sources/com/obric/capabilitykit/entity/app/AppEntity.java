package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.Constants;
import com.bytedance.apm.constant.PerfConsts;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.a0;
import com.obric.capabilitykit.common.l;
import com.obric.capabilitykit.common.v;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.obric.oui.material.MaterialConfigBuilder;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b'\u0018\u0000 V2\u00020\u0001:\u0001VB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u00105\u001a\u0002062\u0006\u0010\u001a\u001a\u00020$J\u0006\u00107\u001a\u000206J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u0004\u0018\u00010\u0006J\b\u0010<\u001a\u0004\u0018\u00010\u0006J\u0010\u0010=\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\u0006J\u0006\u0010?\u001a\u00020\u0006J\b\u0010@\u001a\u00020\u000bH\u0016J\"\u0010A\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u000bH&J\u0015\u0010E\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bFJ%\u0010G\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010\u0006J\u0010\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010\u0006J\b\u0010O\u001a\u00020\u0006H\u0016J\u0015\u0010P\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bSJ\u0018\u0010T\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u000bH\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011¨\u0006W"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "(Ljava/lang/String;JJI)V", "_packageName", "get_packageName", "()Ljava/lang/String;", "set_packageName", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "ecaId", "ecaRawContent", "value", "", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "extraData", "getExtraData", "setExtraData", "extras", "", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "getExtras", "()Ljava/util/List;", "setExtras", "(Ljava/util/List;)V", "<set-?>", "hashCodeValue", "getHashCodeValue", "()I", "getId", "setId", "getLastModifiedTime", "setLastModifiedTime", "getType", "uuid", "getUuid", "setUuid", "addExtraEntity", "", "countHashCode", "describeContents", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getEcaId", "getEcaRawContent", "getExtraEntity", "key", "getPackageName", "hashCode", "onReadSubClassExtensionField", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$capabilitykitcommon_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "theirVersion", "readSubClassExtensionFieldFromParcel$capabilitykitcommon_release", "setEcaId", "uniqueId", "setEcaRawContent", "rawContent", "toString", "writeBaseFieldToParcel", "writeBaseFieldToParcel$capabilitykitcommon_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AppEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 0;
    private String _packageName;
    private long createTime;
    private String ecaId;
    private String ecaRawContent;
    private transient Object extra;
    private String extraData;
    private List<ExtraEntity> extras;
    private int hashCodeValue;
    private String id;
    private long lastModifiedTime;
    private final int type;
    private String uuid;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "", "fromJsonKeepTimeStamp", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            int r2 = r3.readInt();
            EntityClassData<? extends AppEntity> r0 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r2));
            if (r0 == null) goto L9;
            Function1<Parcel, T> r1 = r0.getParcelConstructor();
            if (r1 == 0) goto L9;
            return (AppEntity) r1.invoke(r3);
        L9:
            throw new UnsupportedOperationException("failed to construct AppEntity for type " + r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final AppEntity fromJson(String r2) {
            Intrinsics.checkNotNullParameter(r2, MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON);
            Object r1 = EntityExtKt.getEntityGson().fromJson(r2, AppEntity.class);
            Intrinsics.checkNotNullExpressionValue(r1, "entityGson.fromJson(json, AppEntity::class.java)");
            return (AppEntity) r1;
        }

        public final AppEntity fromJsonKeepTimeStamp(String r3) {
            Intrinsics.checkNotNullParameter(r3, MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON);
            int r2 = new JsonParser().parse(r3).getAsJsonObject().get("type").getAsInt();
            EntityClassData<? extends AppEntity> r0 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r2));
            if (r0 == null) goto L9;
            GenericDeclaration r1 = r0.getClazz();
            if (r1 == null) goto L9;
            Object r4 = EntityExtKt.getEntityKeepTimeStampGson().fromJson(r3, r1);
            Intrinsics.checkNotNullExpressionValue(r4, "entityKeepTimeStampGson.…omJson(json, targetClass)");
            return (AppEntity) r4;
        L9:
            throw new IllegalArgumentException("Unknown entity type: " + r2);
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity[] newArray(int r1) {
            return new AppEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppEntity(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(EntityExtKt.readStringOrEmpty(r9), r9.readLong(), r9.readLong(), r9.readInt());
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public AppEntity(String r2, long r3, long r5, int r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
        this.createTime = r3;
        this.lastModifiedTime = r5;
        this.type = r7;
        this._packageName = "";
        String r4 = EntityContextHolder.INSTANCE.getPackageName();
        if (PackageUtils.INSTANCE.isMemoryPackageName(r4) == false) goto L13;
        if ((this instanceof ContactEntity) == false) goto L7;
    L16:
        r4 = "com.android.contacts";
    L17:
        this._packageName = r4;
        return;
    L7:
        if ((this instanceof CallHistoryEntity) == true) goto L16;
        if ((this instanceof MessageEntity) == false) goto L17;
        this._packageName = Constants.PKG_MMS;
        return;
    L13:
        if (Intrinsics.areEqual(Constants.PKG_MMS, r4) == false) goto L17;
        if ((this instanceof ContactEntity) == false) goto L17;
        goto L16
    }

    public final void addExtraEntity(ExtraEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        if (this.extras != null) goto L5;
        this.extras = new ArrayList();
    L5:
        List<ExtraEntity> r1 = this.extras;
        Intrinsics.checkNotNull(r1);
        r1.add(r2);
    }

    public final void countHashCode() {
        this.hashCodeValue = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public DisplayRepresentation getDisplayRepresentation() {
        throw new UnsupportedOperationException("entity not implementation getDisplayRepresentation method");
    }

    public final String getEcaId() {
        return this.ecaId;
    }

    public final String getEcaRawContent() {
        return this.ecaRawContent;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final ExtraEntity getExtraEntity(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        List<ExtraEntity> r3 = this.extras;
        Object r0 = null;
        if (r3 == null) goto L15;
        Iterator<T> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        Object r1 = r5.next();
        if (Intrinsics.areEqual(((ExtraEntity) r1).getKey(), r4) == false) goto L6;
        r0 = r1;
    L11:
        return (ExtraEntity) r0;
    L15:
        return null;
    }

    public final List<ExtraEntity> getExtras() {
        return this.extras;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getPackageName() {
        return this._packageName;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String get_packageName() {
        return this._packageName;
    }

    public int hashCode() {
        a0 r0 = v.a.a().get(getClass().getName());
        if (r0 == null) goto L7;
        return (r0.a(this) * 31) + l.a.a(this);
    L7:
        throw new IllegalStateException("not found entity generatorHashCode function, entityName: " + getClass().getName());
    }

    public abstract void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3);

    public final void readExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        int r0 = r8.readInt();
        this._packageName = EntityExtKt.readStringOrEmpty(r8);
        this.extras = r8.createTypedArrayList(ExtraEntity.CREATOR);
        int r1 = 6;
        if (r0 > 6) goto L6;
        r1 = r0;
    L6:
        ClassLoader r2 = AppEntity.class.getClassLoader();
        int r3 = 1;
    L7:
        if (r3 > r1) goto L30;
        String r4 = null;
        switch(r3) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L23;
            case 4: goto L19;
            case 5: goto L15;
            case 6: goto L11;
            default: goto L29;
        };
    L11:
        Object r5 = ParcelUtils.INSTANCE.readValueSafely(r8, r2);
        if ((r5 instanceof String) == false) goto L14;
        r4 = (String) r5;
    L14:
        this.uuid = r4;
        goto L29
    L15:
        Object r6 = ParcelUtils.INSTANCE.readValueSafely(r8, r2);
        if ((r6 instanceof String) == false) goto L18;
        r4 = (String) r6;
    L18:
        this.ecaRawContent = r4;
        goto L29
    L19:
        Object r7 = ParcelUtils.INSTANCE.readValueSafely(r8, r2);
        if ((r7 instanceof String) == false) goto L22;
        r4 = (String) r7;
    L22:
        this.ecaId = r4;
        goto L29
    L23:
        Object r9 = ParcelUtils.INSTANCE.readValueSafely(r8, r2);
        if ((r9 instanceof String) == false) goto L26;
        r4 = (String) r9;
    L26:
        this.extraData = r4;
        goto L29
    L27:
        Object r10 = r8.readValue(r2);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");
        this.hashCodeValue = ((Integer) r10).intValue();
        goto L29
    L28:
        setExtra(ParcelUtils.INSTANCE.readValueSafely(r8, r2));
    L29:
        r3 = r3 + 1;
    L30:
        if (r3 > r0) goto L32;
        ParcelUtils.INSTANCE.skipValueSafely(r8, r2);
        r3 = r3 + 1;
        goto L30
    }

    public final void readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        if (r5 > r4) goto L6;
        r4 = r5;
    L6:
        ClassLoader r0 = AppEntity.class.getClassLoader();
        int r1 = 1;
    L7:
        if (r1 > r4) goto L9;
        onReadSubClassExtensionField(r3, r0, r1);
        r1 = r1 + 1;
    L9:
        if (r1 > r5) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L9
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setEcaId(String r1) {
        this.ecaId = r1;
    }

    public final void setEcaRawContent(String r1) {
        this.ecaRawContent = r1;
    }

    public final void setExtra(Object r3) {
        if (EntityExtKt.isValidEntityPropertyType(r3) == false) goto L6;
        this.extra = r3;
        return;
    L6:
        StringBuilder r0 = new StringBuilder("extra value type ");
        Intrinsics.checkNotNull(r3);
        throw new IllegalArgumentException(r0.append(r3.getClass().getName()).append(" is not supported").toString());
    }

    public final void setExtraData(String r1) {
        this.extraData = r1;
    }

    public final void setExtras(List<ExtraEntity> r1) {
        this.extras = r1;
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setLastModifiedTime(long r1) {
        this.lastModifiedTime = r1;
    }

    public final void setUuid(String r1) {
        this.uuid = r1;
    }

    public final void set_packageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._packageName = r2;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    public final void writeBaseFieldToParcel$capabilitykitcommon_release(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.type);
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.lastModifiedTime);
    }

    public final void writeExtensionFieldToParcel$capabilitykitcommon_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(6);
        r2.writeString(this._packageName);
        r2.writeTypedList(this.extras);
        r2.writeValue(this.extra);
        r2.writeValue(Integer.valueOf(this.hashCodeValue));
        r2.writeValue(this.extraData);
        r2.writeValue(this.ecaId);
        r2.writeValue(this.ecaRawContent);
        r2.writeValue(this.uuid);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }
}
