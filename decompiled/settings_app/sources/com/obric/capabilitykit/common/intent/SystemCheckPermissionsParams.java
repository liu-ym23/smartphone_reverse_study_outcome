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

/* JADX INFO: compiled from: SystemCheckPermissionsParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ,\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appletId", "", "permissions", "", "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemCheckPermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemCheckPermissionsParams> CREATOR = null;
    private String appletId;
    private Permission[] permissions;

    /* JADX INFO: compiled from: SystemCheckPermissionsParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemCheckPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r1 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            Permission[] r2 = null;
        L9:
            SystemCheckPermissionsParams r4 = new SystemCheckPermissionsParams(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            ParcelUtils.skipValueSafely(r8, r7);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r8.readInt();
            Permission[] r9 = new Permission[r6];
            int r10 = 0;
        L6:
            if (r10 == r6) goto L8;
            r9[r10] = Permission.CREATOR.createFromParcel(r8);
            r10 = r10 + 1;
            goto L6
        L8:
            r2 = r9;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams[] newArray(int r1) {
            return new SystemCheckPermissionsParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemCheckPermissionsParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemCheckPermissionsParams copy$default(SystemCheckPermissionsParams r0, String r1, Permission[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appletId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.permissions;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.appletId;
    }

    public final Permission[] component2() {
        return this.permissions;
    }

    public final SystemCheckPermissionsParams copy(String r1, Permission[] r2) {
        return new SystemCheckPermissionsParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemCheckPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemCheckPermissionsParams r6 = (SystemCheckPermissionsParams) r5;
        if (Intrinsics.areEqual(this.appletId, r6.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permissions, r6.permissions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.appletId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Permission[] r4 = this.permissions;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemCheckPermissionsParams(appletId=" + this.appletId + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeString(this.appletId);
        Permission[] r3 = this.permissions;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        int r1 = r3.length;
        r4.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r3[r0].writeToParcel(r4, r5);
        r0 = r0 + 1;
        goto L6
    }

    public SystemCheckPermissionsParams(String r1, Permission[] r2) {
        this.appletId = r1;
        this.permissions = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemCheckPermissionsParams(String r2, Permission[] r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final void setAppletId(String r1) {
        this.appletId = r1;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemCheckPermissionsParams) == false) goto L5;
        String r0 = this.appletId;
        if (r0 != null) goto L9;
        r0 = ((SystemCheckPermissionsParams) r2).appletId;
    L9:
        Permission[] r1 = this.permissions;
        if (r1 != null) goto L13;
        r1 = ((SystemCheckPermissionsParams) r2).permissions;
    L13:
        return new SystemCheckPermissionsParams(r0, r1);
    L5:
        return this;
    }
}
