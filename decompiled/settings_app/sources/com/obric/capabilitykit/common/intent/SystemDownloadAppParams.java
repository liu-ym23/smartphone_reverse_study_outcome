package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemDownloadAppParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "isSystemApp", "", "proceed", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setSystemApp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getProceed$annotations", "()V", "getProceed", "setProceed", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "describeContents", "", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemDownloadAppParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemDownloadAppParams> CREATOR = null;
    private String appName;
    private Boolean isSystemApp;
    Boolean proceed;

    /* JADX INFO: compiled from: SystemDownloadAppParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemDownloadAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r3 = r10.readString();
            if (r10.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            SystemDownloadAppParams r1 = new SystemDownloadAppParams(r3, r2, null, 4, null);
            int r4 = Math.min(r0, 1);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L12:
            if (r5 > r4) goto L18;
            if (r5 != 1) goto L17;
            Object r6 = ParcelUtils.readValueSafely(r10, r9);
            if (r6 == null) goto L17;
            r1.proceed = (Boolean) r6;
        L17:
            r5 = r5 + 1;
        L18:
            if (r5 > r0) goto L20;
            ParcelUtils.skipValueSafely(r10, r9);
            r5 = r5 + 1;
            goto L18
        L20:
            return r1;
        L7:
            if (r10.readInt() == 0) goto L9;
            boolean r7 = true;
        L10:
            r2 = Boolean.valueOf(r7);
            goto L11
        L9:
            r7 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams[] newArray(int r1) {
            return new SystemDownloadAppParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemDownloadAppParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemDownloadAppParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemDownloadAppParams copy$default(SystemDownloadAppParams r0, String r1, Boolean r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.appName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isSystemApp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.proceed;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getProceed$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final Boolean component2() {
        return this.isSystemApp;
    }

    public final Boolean component3() {
        return this.proceed;
    }

    public final SystemDownloadAppParams copy(String r1, Boolean r2, Boolean r3) {
        return new SystemDownloadAppParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemDownloadAppParams) == true) goto L8;
        return false;
    L8:
        SystemDownloadAppParams r6 = (SystemDownloadAppParams) r5;
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSystemApp, r6.isSystemApp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.proceed, r6.proceed) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isSystemApp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.proceed;
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
        return "SystemDownloadAppParams(appName=" + this.appName + ", isSystemApp=" + this.isSystemApp + ", proceed=" + this.proceed + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(1);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.appName);
        Boolean r0 = this.isSystemApp;
        if (r0 != null) goto L6;
        ?? r4 = 0;
    L5:
        r2.writeInt(r4);
        r2.writeValue(this.proceed);
        return;
    L6:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L5
    }

    public SystemDownloadAppParams(String r1, Boolean r2, Boolean r3) {
        this.appName = r1;
        this.isSystemApp = r2;
        this.proceed = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemDownloadAppParams(String r2, Boolean r3, Boolean r4, int r5, DefaultConstructorMarker r6) {
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

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final Boolean isSystemApp() {
        return this.isSystemApp;
    }

    public final void setSystemApp(Boolean r1) {
        this.isSystemApp = r1;
    }

    public final Boolean getProceed() {
        return this.proceed;
    }

    public final void setProceed(Boolean r1) {
        this.proceed = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof SystemDownloadAppParams) == false) goto L5;
        String r0 = this.appName;
        if (r0 != null) goto L9;
        r0 = ((SystemDownloadAppParams) r3).appName;
    L9:
        Boolean r1 = this.isSystemApp;
        if (r1 != null) goto L12;
        r1 = ((SystemDownloadAppParams) r3).isSystemApp;
    L12:
        Boolean r2 = this.proceed;
        if (r2 != null) goto L16;
        r2 = ((SystemDownloadAppParams) r3).proceed;
    L16:
        return new SystemDownloadAppParams(r0, r1, r2);
    L5:
        return this;
    }
}
