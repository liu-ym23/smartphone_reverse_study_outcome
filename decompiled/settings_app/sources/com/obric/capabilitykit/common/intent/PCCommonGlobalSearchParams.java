package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PCCommonGlobalSearchParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\b\u0010!\u001a\u00020\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCCommonGlobalSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "originQuery", "", "searchParams", "interactionType", "memoryScene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getMemoryScene$annotations", "()V", "getMemoryScene", "setMemoryScene", "getOriginQuery", "setOriginQuery", "getSearchParams", "setSearchParams", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCCommonGlobalSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCCommonGlobalSearchParams> CREATOR = null;
    private String interactionType;
    String memoryScene;
    private String originQuery;
    private String searchParams;

    /* JADX INFO: compiled from: PCCommonGlobalSearchParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCCommonGlobalSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCCommonGlobalSearchParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            PCCommonGlobalSearchParams r1 = new PCCommonGlobalSearchParams(r10.readString(), r10.readString(), r10.readString(), null, 8, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r9 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = ParcelUtils.readValueSafely(r10, r9);
            if (r5 == null) goto L8;
            r1.memoryScene = (String) r5;
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            ParcelUtils.skipValueSafely(r10, r9);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCCommonGlobalSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCCommonGlobalSearchParams[] newArray(int r1) {
            return new PCCommonGlobalSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCCommonGlobalSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCCommonGlobalSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PCCommonGlobalSearchParams copy$default(PCCommonGlobalSearchParams r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.originQuery;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.searchParams;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.interactionType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.memoryScene;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public static /* synthetic */ void getMemoryScene$annotations() {
    }

    public final String component1() {
        return this.originQuery;
    }

    public final String component2() {
        return this.searchParams;
    }

    public final String component3() {
        return this.interactionType;
    }

    public final String component4() {
        return this.memoryScene;
    }

    public final PCCommonGlobalSearchParams copy(String r1, String r2, String r3, String r4) {
        return new PCCommonGlobalSearchParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PCCommonGlobalSearchParams) == true) goto L8;
        return false;
    L8:
        PCCommonGlobalSearchParams r6 = (PCCommonGlobalSearchParams) r5;
        if (Intrinsics.areEqual(this.originQuery, r6.originQuery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchParams, r6.searchParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactionType, r6.interactionType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.memoryScene, r6.memoryScene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.originQuery;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.searchParams;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.interactionType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.memoryScene;
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
        return "PCCommonGlobalSearchParams(originQuery=" + this.originQuery + ", searchParams=" + this.searchParams + ", interactionType=" + this.interactionType + ", memoryScene=" + this.memoryScene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.originQuery);
        r1.writeString(this.searchParams);
        r1.writeString(this.interactionType);
        r1.writeValue(this.memoryScene);
    }

    public PCCommonGlobalSearchParams(String r1, String r2, String r3, String r4) {
        this.originQuery = r1;
        this.searchParams = r2;
        this.interactionType = r3;
        this.memoryScene = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ PCCommonGlobalSearchParams(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
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

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final void setOriginQuery(String r1) {
        this.originQuery = r1;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final void setSearchParams(String r1) {
        this.searchParams = r1;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final String getMemoryScene() {
        return this.memoryScene;
    }

    public final void setMemoryScene(String r1) {
        this.memoryScene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.originQuery != null) goto L5;
    L7:
        return false;
    L5:
        if (this.searchParams == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof PCCommonGlobalSearchParams) == false) goto L5;
        String r0 = this.originQuery;
        if (r0 != null) goto L9;
        r0 = ((PCCommonGlobalSearchParams) r4).originQuery;
    L9:
        String r1 = this.searchParams;
        if (r1 != null) goto L12;
        r1 = ((PCCommonGlobalSearchParams) r4).searchParams;
    L12:
        String r2 = this.interactionType;
        if (r2 != null) goto L15;
        r2 = ((PCCommonGlobalSearchParams) r4).interactionType;
    L15:
        String r3 = this.memoryScene;
        if (r3 != null) goto L19;
        r3 = ((PCCommonGlobalSearchParams) r4).memoryScene;
    L19:
        return new PCCommonGlobalSearchParams(r0, r1, r2, r3);
    L5:
        return this;
    }
}
