package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUserAuthorizeParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eHÖ\u0001R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserAuthorizeParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "scene", "", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "getScene", "()Ljava/lang/String;", "setScene", "component1", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserAuthorizeParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserAuthorizeParams> CREATOR = null;
    String scene;

    /* JADX INFO: compiled from: SystemUserAuthorizeParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserAuthorizeParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemUserAuthorizeParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            Intrinsics.checkNotNullParameter(r7, "parcel");
            SystemUserAuthorizeParams r1 = new SystemUserAuthorizeParams(null, 1, 0 == true ? 1 : 0);
            int r2 = Math.min(r0, 1);
            ClassLoader r6 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = ParcelUtils.readValueSafely(r7, r6);
            if (r5 == null) goto L8;
            r1.scene = (String) r5;
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            ParcelUtils.skipValueSafely(r7, r6);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserAuthorizeParams[] newArray(int r1) {
            return new SystemUserAuthorizeParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserAuthorizeParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserAuthorizeParams copy$default(SystemUserAuthorizeParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.scene;
    L6:
        return r0.copy(r1);
    }

    public static /* synthetic */ void getScene$annotations() {
    }

    public final String component1() {
        return this.scene;
    }

    public final SystemUserAuthorizeParams copy(String r1) {
        return new SystemUserAuthorizeParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SystemUserAuthorizeParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.scene, ((SystemUserAuthorizeParams) r4).scene) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.scene;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SystemUserAuthorizeParams(scene=" + this.scene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeValue(this.scene);
    }

    public SystemUserAuthorizeParams(String r1) {
        this.scene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemUserAuthorizeParams(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemUserAuthorizeParams) == false) goto L5;
        String r1 = this.scene;
        if (r1 != null) goto L10;
        r1 = ((SystemUserAuthorizeParams) r2).scene;
    L10:
        return new SystemUserAuthorizeParams(r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.scene;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
