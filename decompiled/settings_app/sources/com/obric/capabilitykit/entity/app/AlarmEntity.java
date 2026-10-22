package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001a\u0010,\u001a\u0004\u0018\u00010\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\"\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020#H\u0016J\u0018\u00102\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020#H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R4\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "startTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "closeInHoliday", "", "getCloseInHoliday", "()Z", "setCloseInHoliday", "(Z)V", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "isEnabled", "setEnabled", "isRinging", "()Ljava/lang/Boolean;", "setRinging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", "value", "", "", "repeatDayOfWeek", "getRepeatDayOfWeek", "()Ljava/util/List;", "setRepeatDayOfWeek", "(Ljava/util/List;)V", "repeatDayOfWeekDesc", "getStartTime", "setStartTime", "generateRepeatDesc", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlarmEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
    private static final int RELATED_VERSION = 0;
    private boolean closeInHoliday;
    private String date;
    private boolean isEnabled;
    private Boolean isRinging;
    private String name;
    private List<Integer> repeatDayOfWeek;
    private String repeatDayOfWeekDesc;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AlarmEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
            return (AlarmEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity[] newArray(int r1) {
            return new AlarmEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Integer, CharSequence> {
        public final /* synthetic */ Map<Integer, String> a;

        public a(Map<Integer, String> r1) {
            this.a = r1;
            super(1);
        }

        public final CharSequence a(int r1) {
            String r0 = this.a.get(Integer.valueOf(r1));
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer r1) {
            return a(r1.intValue());
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlarmEntity(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(EntityExtKt.readStringOrEmpty(r10), r10.readLong(), r10.readLong(), EntityExtKt.readStringOrEmpty(r10), EntityExtKt.readStringOrEmpty(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r0 = r10.readInt();
        this.isEnabled = EntityExtKt.readBool(r10);
        ArrayList r1 = new ArrayList();
        r10.readList(r1, Integer.TYPE.getClassLoader());
        setRepeatDayOfWeek(r1);
        this.closeInHoliday = EntityExtKt.readBool(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 2, r0);
    }

    public AlarmEntity(String r9, long r10, long r12, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r15, "startTime");
        super(r9, r10, r12, 701);
        this.name = r14;
        this.startTime = r15;
    }

    public /* synthetic */ AlarmEntity(String r10, long r11, long r13, String r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        String r8 = "";
    L6:
        this(r10, r11, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final String generateRepeatDesc(List<Integer> r12) {
        if (r12 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "周一"), TuplesKt.to(2, "周二"), TuplesKt.to(3, "周三"), TuplesKt.to(4, "周四"), TuplesKt.to(5, "周五"), TuplesKt.to(6, "周六"), TuplesKt.to(7, "周日")});
        if (r12.containsAll(CollectionsKt.toList(new IntRange(1, 7))) == false) goto L16;
        return "每天";
    L16:
        return "每" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r12), "", null, null, 0, null, new a(r11), 30, null);
    L5:
        if (r12.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final Boolean isRinging() {
        return this.isRinging;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L5;
        this.date = (String) r2.readValue(r3);
        return;
    L5:
        if (r4 != 2) goto L11;
        this.isRinging = (Boolean) r2.readValue(r3);
        return;
    }

    public final void setCloseInHoliday(boolean r1) {
        this.closeInHoliday = r1;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final void setEnabled(boolean r1) {
        this.isEnabled = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setRepeatDayOfWeek(List<Integer> r2) {
        this.repeatDayOfWeekDesc = generateRepeatDesc(r2);
        this.repeatDayOfWeek = r2;
    }

    public final void setRinging(Boolean r1) {
        this.isRinging = r1;
    }

    public final void setStartTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        r1.writeString(this.startTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(2);
        EntityExtKt.writeBool(r1, this.isEnabled);
        r1.writeList(this.repeatDayOfWeek);
        EntityExtKt.writeBool(r1, this.closeInHoliday);
        r1.writeValue(this.date);
        r1.writeValue(this.isRinging);
    }
}
