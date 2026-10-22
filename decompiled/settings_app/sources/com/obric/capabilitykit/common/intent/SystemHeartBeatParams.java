package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemHeartBeatParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\b\u0010$\u001a\u00020 H\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "expiryTimestamp", "", "timeUntilNextHeartbeat", "ext", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getExpiryTimestamp", "()Ljava/lang/Long;", "setExpiryTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getQuestionId", "setQuestionId", "getTimeUntilNextHeartbeat", "setTimeUntilNextHeartbeat", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemHeartBeatParams;", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemHeartBeatParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemHeartBeatParams> CREATOR = null;
    private Long expiryTimestamp;
    private String ext;
    private String questionId;
    private Long timeUntilNextHeartbeat;

    /* JADX INFO: compiled from: SystemHeartBeatParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemHeartBeatParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            Long r4 = null;
            if (r8.readInt() != 0) goto L5;
            Long r3 = null;
        L7:
            if (r8.readInt() == 0) goto L10;
            r4 = Long.valueOf(r8.readLong());
        L10:
            SystemHeartBeatParams r1 = new SystemHeartBeatParams(r2, r3, r4, r8.readString());
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r6 = 1;
        L11:
            if (r6 > r5) goto L13;
            r6 = r6 + 1;
        L13:
            if (r6 > r0) goto L15;
            ParcelUtils.skipValueSafely(r8, r7);
            r6 = r6 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r3 = Long.valueOf(r8.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemHeartBeatParams[] newArray(int r1) {
            return new SystemHeartBeatParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemHeartBeatParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemHeartBeatParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemHeartBeatParams copy$default(SystemHeartBeatParams r0, String r1, Long r2, Long r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.questionId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.expiryTimestamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timeUntilNextHeartbeat;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.ext;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.expiryTimestamp;
    }

    public final Long component3() {
        return this.timeUntilNextHeartbeat;
    }

    public final String component4() {
        return this.ext;
    }

    public final SystemHeartBeatParams copy(String r1, Long r2, Long r3, String r4) {
        return new SystemHeartBeatParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemHeartBeatParams) == true) goto L8;
        return false;
    L8:
        SystemHeartBeatParams r6 = (SystemHeartBeatParams) r5;
        if (Intrinsics.areEqual(this.questionId, r6.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiryTimestamp, r6.expiryTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeUntilNextHeartbeat, r6.timeUntilNextHeartbeat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.questionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.expiryTimestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.timeUntilNextHeartbeat;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.ext;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "SystemHeartBeatParams(questionId=" + this.questionId + ", expiryTimestamp=" + this.expiryTimestamp + ", timeUntilNextHeartbeat=" + this.timeUntilNextHeartbeat + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.questionId);
        Long r0 = this.expiryTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.timeUntilNextHeartbeat;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.ext);
        return;
    L9:
        r5.writeInt(1);
        r5.writeLong(r1.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r0.longValue());
        goto L6
    }

    public SystemHeartBeatParams(String r1, Long r2, Long r3, String r4) {
        this.questionId = r1;
        this.expiryTimestamp = r2;
        this.timeUntilNextHeartbeat = r3;
        this.ext = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ SystemHeartBeatParams(String r2, Long r3, Long r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final void setQuestionId(String r1) {
        this.questionId = r1;
    }

    public final Long getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public final void setExpiryTimestamp(Long r1) {
        this.expiryTimestamp = r1;
    }

    public final Long getTimeUntilNextHeartbeat() {
        return this.timeUntilNextHeartbeat;
    }

    public final void setTimeUntilNextHeartbeat(Long r1) {
        this.timeUntilNextHeartbeat = r1;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String r1) {
        this.ext = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.expiryTimestamp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.timeUntilNextHeartbeat == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof SystemHeartBeatParams) == false) goto L5;
        String r0 = this.questionId;
        if (r0 != null) goto L9;
        r0 = ((SystemHeartBeatParams) r4).questionId;
    L9:
        Long r1 = this.expiryTimestamp;
        if (r1 != null) goto L12;
        r1 = ((SystemHeartBeatParams) r4).expiryTimestamp;
    L12:
        Long r2 = this.timeUntilNextHeartbeat;
        if (r2 != null) goto L15;
        r2 = ((SystemHeartBeatParams) r4).timeUntilNextHeartbeat;
    L15:
        String r3 = this.ext;
        if (r3 != null) goto L19;
        r3 = ((SystemHeartBeatParams) r4).ext;
    L19:
        return new SystemHeartBeatParams(r0, r1, r2, r3);
    L5:
        return this;
    }
}
