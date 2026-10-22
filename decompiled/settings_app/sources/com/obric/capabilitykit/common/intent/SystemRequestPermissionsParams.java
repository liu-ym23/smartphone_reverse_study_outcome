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

/* JADX INFO: compiled from: SystemRequestPermissionsParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010'H\u0016J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "title", "", "content", "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", "permissions", "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemRequestPermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemRequestPermissionsParams> CREATOR = null;
    private String content;
    private Options[] options;
    private Permission[] permissions;
    private String title;

    /* JADX INFO: compiled from: SystemRequestPermissionsParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemRequestPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r1 = r10.readString();
            String r2 = r10.readString();
            Permission[] r4 = null;
            if (r10.readInt() != 0) goto L5;
            Options[] r6 = null;
        L9:
            if (r10.readInt() == 0) goto L14;
            int r3 = r10.readInt();
            r4 = new Permission[r3];
            int r7 = 0;
        L12:
            if (r7 == r3) goto L14;
            r4[r7] = Permission.CREATOR.createFromParcel(r10);
            r7 = r7 + 1;
        L14:
            SystemRequestPermissionsParams r5 = new SystemRequestPermissionsParams(r1, r2, r6, r4);
            int r8 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r11 = 1;
        L15:
            if (r11 > r8) goto L17;
            r11 = r11 + 1;
        L17:
            if (r11 > r0) goto L19;
            ParcelUtils.skipValueSafely(r10, r9);
            r11 = r11 + 1;
            goto L17
        L19:
            return r5;
        L5:
            int r12 = r10.readInt();
            r6 = new Options[r12];
            int r13 = 0;
        L6:
            if (r13 == r12) goto L9;
            r6[r13] = Options.CREATOR.createFromParcel(r10);
            r13 = r13 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams[] newArray(int r1) {
            return new SystemRequestPermissionsParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemRequestPermissionsParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemRequestPermissionsParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemRequestPermissionsParams copy$default(SystemRequestPermissionsParams r0, String r1, String r2, Options[] r3, Permission[] r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.options;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.permissions;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final Options[] component3() {
        return this.options;
    }

    public final Permission[] component4() {
        return this.permissions;
    }

    public final SystemRequestPermissionsParams copy(String r1, String r2, Options[] r3, Permission[] r4) {
        return new SystemRequestPermissionsParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemRequestPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemRequestPermissionsParams r6 = (SystemRequestPermissionsParams) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.options, r6.options) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.permissions, r6.permissions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Options[] r7 = this.options;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Permission[] r10 = this.permissions;
        if (r10 == null) goto L19;
        r1 = Arrays.hashCode(r10);
    L19:
        return r9 + r1;
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
        return "SystemRequestPermissionsParams(title=" + this.title + ", content=" + this.content + ", options=" + Arrays.toString(this.options) + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        int r0 = 0;
        r7.writeInt(0);
        Intrinsics.checkNotNullParameter(r7, "out");
        r7.writeString(this.title);
        r7.writeString(this.content);
        Options[] r1 = this.options;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L8:
        Permission[] r6 = this.permissions;
        if (r6 != null) goto L11;
        r7.writeInt(0);
        return;
    L11:
        r7.writeInt(1);
        int r2 = r6.length;
        r7.writeInt(r2);
    L12:
        if (r0 == r2) goto L17;
        r6[r0].writeToParcel(r7, r8);
        r0 = r0 + 1;
        goto L12
    L17:
        return;
    L5:
        r7.writeInt(1);
        int r3 = r1.length;
        r7.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r1[r4].writeToParcel(r7, r8);
        r4 = r4 + 1;
        goto L6
    }

    public SystemRequestPermissionsParams(String r1, String r2, Options[] r3, Permission[] r4) {
        this.title = r1;
        this.content = r2;
        this.options = r3;
        this.permissions = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemRequestPermissionsParams(String r2, String r3, Options[] r4, Permission[] r5, int r6, DefaultConstructorMarker r7) {
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

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Options[] getOptions() {
        return this.options;
    }

    public final void setOptions(Options[] r1) {
        this.options = r1;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(Permission[] r1) {
        this.permissions = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof SystemRequestPermissionsParams) == false) goto L5;
        String r0 = this.title;
        if (r0 != null) goto L9;
        r0 = ((SystemRequestPermissionsParams) r4).title;
    L9:
        String r1 = this.content;
        if (r1 != null) goto L12;
        r1 = ((SystemRequestPermissionsParams) r4).content;
    L12:
        Options[] r2 = this.options;
        if (r2 != null) goto L15;
        r2 = ((SystemRequestPermissionsParams) r4).options;
    L15:
        Permission[] r3 = this.permissions;
        if (r3 != null) goto L19;
        r3 = ((SystemRequestPermissionsParams) r4).permissions;
    L19:
        return new SystemRequestPermissionsParams(r0, r1, r2, r3);
    L5:
        return this;
    }
}
