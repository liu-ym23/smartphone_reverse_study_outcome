package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemStopActionParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemStopActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "intentName", "actionId", "reason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getQuestionId", "setQuestionId", "getReason", "setReason", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemStopActionParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemStopActionParams> CREATOR = null;
    private String actionId;
    private String intentName;
    private String questionId;
    private String reason;

    /* JADX INFO: compiled from: SystemStopActionParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemStopActionParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemStopActionParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            Intrinsics.checkNotNullParameter(r7, "parcel");
            SystemStopActionParams r1 = new SystemStopActionParams(r7.readString(), r7.readString(), r7.readString(), r7.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r7, r6);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemStopActionParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemStopActionParams[] newArray(int r1) {
            return new SystemStopActionParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemStopActionParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemStopActionParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemStopActionParams copy$default(SystemStopActionParams r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.questionId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.intentName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.actionId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.reason;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.intentName;
    }

    public final String component3() {
        return this.actionId;
    }

    public final String component4() {
        return this.reason;
    }

    public final SystemStopActionParams copy(String r1, String r2, String r3, String r4) {
        return new SystemStopActionParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemStopActionParams) == true) goto L8;
        return false;
    L8:
        SystemStopActionParams r6 = (SystemStopActionParams) r5;
        if (Intrinsics.areEqual(this.questionId, r6.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intentName, r6.intentName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionId, r6.actionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reason, r6.reason) == true) goto L20;
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
        String r4 = this.intentName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.actionId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.reason;
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
        return "SystemStopActionParams(questionId=" + this.questionId + ", intentName=" + this.intentName + ", actionId=" + this.actionId + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.questionId);
        r1.writeString(this.intentName);
        r1.writeString(this.actionId);
        r1.writeString(this.reason);
    }

    public SystemStopActionParams(String r1, String r2, String r3, String r4) {
        this.questionId = r1;
        this.intentName = r2;
        this.actionId = r3;
        this.reason = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ SystemStopActionParams(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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

    public final String getIntentName() {
        return this.intentName;
    }

    public final void setIntentName(String r1) {
        this.intentName = r1;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final void setActionId(String r1) {
        this.actionId = r1;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(String r1) {
        this.reason = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.reason == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof SystemStopActionParams) == false) goto L5;
        String r0 = this.questionId;
        if (r0 != null) goto L9;
        r0 = ((SystemStopActionParams) r4).questionId;
    L9:
        String r1 = this.intentName;
        if (r1 != null) goto L12;
        r1 = ((SystemStopActionParams) r4).intentName;
    L12:
        String r2 = this.actionId;
        if (r2 != null) goto L15;
        r2 = ((SystemStopActionParams) r4).actionId;
    L15:
        String r3 = this.reason;
        if (r3 != null) goto L19;
        r3 = ((SystemStopActionParams) r4).reason;
    L19:
        return new SystemStopActionParams(r0, r1, r2, r3);
    L5:
        return this;
    }
}
