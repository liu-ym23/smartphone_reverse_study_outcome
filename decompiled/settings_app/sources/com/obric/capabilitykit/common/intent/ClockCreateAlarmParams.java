package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClockCreateAlarmParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003JP\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010+\u001a\u00020\bHÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010)H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bHÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "describeContents", "equals", PluralRules.KEYWORD_OTHER, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockCreateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockCreateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    private String time;

    /* JADX INFO: compiled from: ClockCreateAlarmParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockCreateAlarmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams createFromParcel(Parcel r11) {
            int r0 = r11.readInt();
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r3 = r11.readString();
            String r4 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Integer[] r5 = null;
        L8:
            int r9 = 1;
            if (r11.readInt() != 0) goto L12;
            Boolean r6 = null;
        L16:
            ClockCreateAlarmParams r1 = new ClockCreateAlarmParams(r3, r4, r5, r6, r11.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r10 = getClass().getClassLoader();
        L17:
            if (r9 > r2) goto L19;
            r9 = r9 + 1;
        L19:
            if (r9 > r0) goto L21;
            ParcelUtils.skipValueSafely(r11, r10);
            r9 = r9 + 1;
            goto L19
        L21:
            return r1;
        L12:
            if (r11.readInt() == 0) goto L14;
            boolean r7 = true;
        L15:
            r6 = Boolean.valueOf(r7);
            goto L16
        L14:
            r7 = false;
            goto L15
        L5:
            int r8 = r11.readInt();
            r5 = new Integer[r8];
            int r12 = 0;
        L6:
            if (r12 == r8) goto L8;
            r5[r12] = Integer.valueOf(r11.readInt());
            r12 = r12 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams[] newArray(int r1) {
            return new ClockCreateAlarmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ClockCreateAlarmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ClockCreateAlarmParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ClockCreateAlarmParams copy$default(ClockCreateAlarmParams r3, String r4, String r5, Integer[] r6, Boolean r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.time;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.date;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.repeatDayOfWeek;
    L11:
        Integer[] r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.closeInHoliday;
    L14:
        Boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.name;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.date;
    }

    public final Integer[] component3() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component4() {
        return this.closeInHoliday;
    }

    public final String component5() {
        return this.name;
    }

    public final ClockCreateAlarmParams copy(String r7, String r8, Integer[] r9, Boolean r10, String r11) {
        return new ClockCreateAlarmParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClockCreateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockCreateAlarmParams r6 = (ClockCreateAlarmParams) r5;
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r6.repeatDayOfWeek) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.closeInHoliday, r6.closeInHoliday) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.time;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer[] r7 = this.repeatDayOfWeek;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.closeInHoliday;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.name;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClockCreateAlarmParams(time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        ?? r8 = 0;
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        r6.writeString(this.time);
        r6.writeString(this.date);
        Integer[] r0 = this.repeatDayOfWeek;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L8:
        Boolean r1 = this.closeInHoliday;
        if (r1 != null) goto L11;
    L10:
        r6.writeInt(r8);
        r6.writeString(this.name);
        return;
    L11:
        r6.writeInt(1);
        r8 = r1.booleanValue();
        goto L10
    L5:
        r6.writeInt(1);
        int r2 = r0.length;
        r6.writeInt(r2);
        int r3 = 0;
    L6:
        if (r3 == r2) goto L8;
        r6.writeInt(r0[r3].intValue());
        r3 = r3 + 1;
        goto L6
    }

    public ClockCreateAlarmParams(String r1, String r2, Integer[] r3, Boolean r4, String r5) {
        this.time = r1;
        this.date = r2;
        this.repeatDayOfWeek = r3;
        this.closeInHoliday = r4;
        this.name = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ ClockCreateAlarmParams(String r2, String r3, Integer[] r4, Boolean r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String r1) {
        this.time = r1;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final void setRepeatDayOfWeek(Integer[] r1) {
        this.repeatDayOfWeek = r1;
    }

    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final void setCloseInHoliday(Boolean r1) {
        this.closeInHoliday = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r8) {
        if ((r8 instanceof ClockCreateAlarmParams) == false) goto L5;
        String r0 = this.time;
        if (r0 != null) goto L9;
        r0 = ((ClockCreateAlarmParams) r8).time;
    L9:
        String r2 = r0;
        String r1 = this.date;
        if (r1 != null) goto L12;
        r1 = ((ClockCreateAlarmParams) r8).date;
    L12:
        String r3 = r1;
        Integer[] r4 = this.repeatDayOfWeek;
        if (r4 != null) goto L15;
        r4 = ((ClockCreateAlarmParams) r8).repeatDayOfWeek;
    L15:
        Integer[] r5 = r4;
        Boolean r6 = this.closeInHoliday;
        if (r6 != null) goto L18;
        r6 = ((ClockCreateAlarmParams) r8).closeInHoliday;
    L18:
        Boolean r7 = r6;
        String r9 = this.name;
        if (r9 != null) goto L22;
        r9 = ((ClockCreateAlarmParams) r8).name;
    L22:
        return new ClockCreateAlarmParams(r2, r3, r5, r7, r9);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.time;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        StringBuilder r4 = r0.append(r3).append('|');
        String r5 = this.date;
        if (r5 == null) goto L9;
        String r6 = r5.toString();
    L10:
        StringBuilder r7 = r4.append(r6).append('|');
        Integer[] r8 = this.repeatDayOfWeek;
        if (r8 == null) goto L14;
        r2 = ArraysKt.joinToString$default(r8, null, null, null, 0, null, null, 63, null);
    L14:
        return r7.append(r2).toString();
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
