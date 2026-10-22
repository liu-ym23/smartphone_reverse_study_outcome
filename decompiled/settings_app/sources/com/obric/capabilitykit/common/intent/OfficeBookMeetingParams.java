package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfficeBookMeetingParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#Jn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\fHÖ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\fHÖ\u0001J\u0012\u00106\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u000104H\u0016J\t\u00108\u001a\u00020\u0004HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\fHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeBookMeetingParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "startTime", "", "endTime", "room", "participants", "", "agenda", "participantsId", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)V", "getAgenda", "()Ljava/lang/String;", "setAgenda", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getParticipants", "()[Ljava/lang/String;", "setParticipants", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getParticipantsId$annotations", "()V", "getParticipantsId", "setParticipantsId", "getRoom", "setRoom", "getStartTime", "setStartTime", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeBookMeetingParams;", "describeContents", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeBookMeetingParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeBookMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    Integer version;

    /* JADX INFO: compiled from: OfficeBookMeetingParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeBookMeetingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeBookMeetingParams createFromParcel(Parcel r13) {
            int r0 = r13.readInt();
            Intrinsics.checkNotNullParameter(r13, "parcel");
            OfficeBookMeetingParams r1 = new OfficeBookMeetingParams(r13.readString(), r13.readString(), r13.readString(), r13.createStringArray(), r13.readString(), null, null, 96, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r12 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L13;
            if (r5 != 1) goto L8;
            Object r6 = ParcelUtils.readValueSafely(r13, r12);
            if (r6 == null) goto L12;
            r1.participantsId = (String[]) r6;
        L12:
            r5 = r5 + 1;
            goto L3
        L8:
            if (r5 != 2) goto L12;
            Object r7 = ParcelUtils.readValueSafely(r13, r12);
            if (r7 == null) goto L12;
            r1.version = (Integer) r7;
        L13:
            if (r5 > r0) goto L15;
            ParcelUtils.skipValueSafely(r13, r12);
            r5 = r5 + 1;
            goto L13
        L15:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeBookMeetingParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeBookMeetingParams[] newArray(int r1) {
            return new OfficeBookMeetingParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeBookMeetingParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public OfficeBookMeetingParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ OfficeBookMeetingParams copy$default(OfficeBookMeetingParams r5, String r6, String r7, String r8, String[] r9, String r10, String[] r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.startTime;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.endTime;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.room;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.participants;
    L14:
        String[] r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.agenda;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.participantsId;
    L20:
        String[] r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.version;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public static /* synthetic */ void getParticipantsId$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.startTime;
    }

    public final String component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.room;
    }

    public final String[] component4() {
        return this.participants;
    }

    public final String component5() {
        return this.agenda;
    }

    public final String[] component6() {
        return this.participantsId;
    }

    public final Integer component7() {
        return this.version;
    }

    public final OfficeBookMeetingParams copy(String r9, String r10, String r11, String[] r12, String r13, String[] r14, Integer r15) {
        return new OfficeBookMeetingParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeBookMeetingParams) == true) goto L8;
        return false;
    L8:
        OfficeBookMeetingParams r6 = (OfficeBookMeetingParams) r5;
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.room, r6.room) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r6.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.agenda, r6.agenda) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.participantsId, r6.participantsId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.startTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.endTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.room;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String[] r10 = this.participants;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.agenda;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String[] r16 = this.participantsId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.version;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = Arrays.hashCode(r16);
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = Arrays.hashCode(r10);
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeBookMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        r1.writeString(this.room);
        r1.writeStringArray(this.participants);
        r1.writeString(this.agenda);
        r1.writeValue(this.participantsId);
        r1.writeValue(this.version);
    }

    public OfficeBookMeetingParams(String r1, String r2, String r3, String[] r4, String r5, String[] r6, Integer r7) {
        this.startTime = r1;
        this.endTime = r2;
        this.room = r3;
        this.participants = r4;
        this.agenda = r5;
        this.participantsId = r6;
        this.version = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ OfficeBookMeetingParams(String r2, String r3, String r4, String[] r5, String r6, String[] r7, Integer r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String r1) {
        this.startTime = r1;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final String getRoom() {
        return this.room;
    }

    public final void setRoom(String r1) {
        this.room = r1;
    }

    public final String[] getParticipants() {
        return this.participants;
    }

    public final void setParticipants(String[] r1) {
        this.participants = r1;
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final void setAgenda(String r1) {
        this.agenda = r1;
    }

    public final String[] getParticipantsId() {
        return this.participantsId;
    }

    public final void setParticipantsId(String[] r1) {
        this.participantsId = r1;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final void setVersion(Integer r1) {
        this.version = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if ((r10 instanceof OfficeBookMeetingParams) == false) goto L5;
        String r0 = this.startTime;
        if (r0 != null) goto L9;
        r0 = ((OfficeBookMeetingParams) r10).startTime;
    L9:
        String r2 = r0;
        String r1 = this.endTime;
        if (r1 != null) goto L12;
        r1 = ((OfficeBookMeetingParams) r10).endTime;
    L12:
        String r3 = r1;
        String r4 = this.room;
        if (r4 != null) goto L15;
        r4 = ((OfficeBookMeetingParams) r10).room;
    L15:
        String r5 = r4;
        String[] r6 = this.participants;
        if (r6 != null) goto L18;
        r6 = ((OfficeBookMeetingParams) r10).participants;
    L18:
        String[] r7 = r6;
        String r8 = this.agenda;
        if (r8 != null) goto L21;
        r8 = ((OfficeBookMeetingParams) r10).agenda;
    L21:
        String r9 = r8;
        String[] r11 = this.participantsId;
        if (r11 != null) goto L24;
        r11 = ((OfficeBookMeetingParams) r10).participantsId;
    L24:
        String[] r12 = r11;
        Integer r13 = this.version;
        if (r13 != null) goto L28;
        r13 = ((OfficeBookMeetingParams) r10).version;
    L28:
        return new OfficeBookMeetingParams(r2, r3, r5, r7, r9, r12, r13);
    L5:
        return this;
    }
}
