package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemInAppSearchParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u001b\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemInAppSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "searchIntent", "", IndexDatabaseHelper.SavedQueriesColums.QUERY, "quResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuResult", "()Ljava/lang/String;", "setQuResult", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getSearchIntent", "setSearchIntent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemInAppSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemInAppSearchParams> CREATOR = null;
    private String quResult;
    private String query;
    private String searchIntent;

    /* JADX INFO: compiled from: SystemInAppSearchParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemInAppSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemInAppSearchParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            SystemInAppSearchParams r1 = new SystemInAppSearchParams(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemInAppSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemInAppSearchParams[] newArray(int r1) {
            return new SystemInAppSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemInAppSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemInAppSearchParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemInAppSearchParams copy$default(SystemInAppSearchParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.searchIntent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.query;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.quResult;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.searchIntent;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.quResult;
    }

    public final SystemInAppSearchParams copy(String r1, String r2, String r3) {
        return new SystemInAppSearchParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemInAppSearchParams) == true) goto L8;
        return false;
    L8:
        SystemInAppSearchParams r6 = (SystemInAppSearchParams) r5;
        if (Intrinsics.areEqual(this.searchIntent, r6.searchIntent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.quResult, r6.quResult) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.searchIntent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.query;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.quResult;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemInAppSearchParams(searchIntent=" + this.searchIntent + ", query=" + this.query + ", quResult=" + this.quResult + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.searchIntent);
        r1.writeString(this.query);
        r1.writeString(this.quResult);
    }

    public SystemInAppSearchParams(String r1, String r2, String r3) {
        this.searchIntent = r1;
        this.query = r2;
        this.quResult = r3;
    }

    public /* synthetic */ SystemInAppSearchParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getSearchIntent() {
        return this.searchIntent;
    }

    public final void setSearchIntent(String r1) {
        this.searchIntent = r1;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.searchIntent != null) goto L5;
    L9:
        return false;
    L5:
        if (this.query == null) goto L9;
        if (this.quResult == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof SystemInAppSearchParams) == false) goto L5;
        String r0 = this.searchIntent;
        if (r0 != null) goto L9;
        r0 = ((SystemInAppSearchParams) r3).searchIntent;
    L9:
        String r1 = this.query;
        if (r1 != null) goto L12;
        r1 = ((SystemInAppSearchParams) r3).query;
    L12:
        String r2 = this.quResult;
        if (r2 != null) goto L16;
        r2 = ((SystemInAppSearchParams) r3).quResult;
    L16:
        return new SystemInAppSearchParams(r0, r1, r2);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.searchIntent;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
