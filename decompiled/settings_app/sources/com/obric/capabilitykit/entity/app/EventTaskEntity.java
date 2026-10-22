package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0002\u0010\u0011J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020&H\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "conditionString", "taskQuery", "periodString", "isDeleted", "", "conditionList", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getConditionList", "()Ljava/util/List;", "setConditionList", "(Ljava/util/List;)V", "getConditionString", "()Ljava/lang/String;", "setConditionString", "(Ljava/lang/String;)V", "()Z", "setDeleted", "(Z)V", "getPeriodString", "setPeriodString", "getTaskQuery", "setTaskQuery", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<String> conditionList;
    private String conditionString;
    private boolean isDeleted;
    private String periodString;
    private String taskQuery;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EventTaskEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.EventTaskEntity");
            return (EventTaskEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTaskEntity[] newArray(int r1) {
            return new EventTaskEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTaskEntity(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r13);
        long r3 = r13.readLong();
        long r5 = r13.readLong();
        String r7 = EntityExtKt.readStringOrEmpty(r13);
        String r8 = EntityExtKt.readStringOrEmpty(r13);
        String r9 = EntityExtKt.readStringOrEmpty(r13);
        boolean r10 = EntityExtKt.readBool(r13);
        ArrayList<String> r0 = r13.createStringArrayList();
        if (r0 == null) goto L6;
        List r1 = CollectionsKt.toList(r0);
        if (r1 == null) goto L6;
    L7:
        this(r2, r3, r5, r7, r8, r9, r10, r1);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r13.readInt());
        return;
    L6:
        r1 = new ArrayList();
        goto L7
    }

    public EventTaskEntity(String r13, long r14, long r16, String r18, String r19, String r20, boolean r21, List<String> r22) {
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(r18, "conditionString");
        Intrinsics.checkNotNullParameter(r19, "taskQuery");
        Intrinsics.checkNotNullParameter(r20, "periodString");
        Intrinsics.checkNotNullParameter(r22, "conditionList");
        super(r13, r14, r16, EntityType.EVENT_TASK);
        this.conditionString = r18;
        this.taskQuery = r19;
        this.periodString = r20;
        this.isDeleted = r21;
        this.conditionList = r22;
    }

    public final List<String> getConditionList() {
        return this.conditionList;
    }

    public final String getConditionString() {
        return this.conditionString;
    }

    public final String getPeriodString() {
        return this.periodString;
    }

    public final String getTaskQuery() {
        return this.taskQuery;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setConditionList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.conditionList = r2;
    }

    public final void setConditionString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.conditionString = r2;
    }

    public final void setDeleted(boolean r1) {
        this.isDeleted = r1;
    }

    public final void setPeriodString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.periodString = r2;
    }

    public final void setTaskQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.taskQuery = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.conditionString);
        r1.writeString(this.taskQuery);
        r1.writeString(this.periodString);
        EntityExtKt.writeBool(r1, this.isDeleted);
        r1.writeStringList(this.conditionList);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
