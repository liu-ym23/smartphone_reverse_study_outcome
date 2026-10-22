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

/* JADX INFO: compiled from: SystemUserRemindParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\u0012\u0010(\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010&H\u0016J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\"HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u00060"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", "content", "", "title", "candidate", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "([Lcom/obric/capabilitykit/common/intent/Options;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserRemindParams;", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserRemindParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserRemindParams> CREATOR = null;
    private String[] candidate;
    private String content;
    private Options[] options;
    private String title;

    /* JADX INFO: compiled from: SystemUserRemindParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserRemindParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            if (r8.readInt() != 0) goto L5;
            Options[] r1 = null;
        L9:
            SystemUserRemindParams r6 = new SystemUserRemindParams(r1, r8.readString(), r8.readString(), r8.createStringArray());
            int r2 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r3 = 1;
        L10:
            if (r3 > r2) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 > r0) goto L14;
            ParcelUtils.skipValueSafely(r8, r7);
            r3 = r3 + 1;
            goto L12
        L14:
            return r6;
        L5:
            int r4 = r8.readInt();
            Options[] r5 = new Options[r4];
            int r9 = 0;
        L6:
            if (r9 == r4) goto L8;
            r5[r9] = Options.CREATOR.createFromParcel(r8);
            r9 = r9 + 1;
            goto L6
        L8:
            r1 = r5;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams[] newArray(int r1) {
            return new SystemUserRemindParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemUserRemindParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemUserRemindParams copy$default(SystemUserRemindParams r0, Options[] r1, String r2, String r3, String[] r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.options;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.title;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.candidate;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Options[] component1() {
        return this.options;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.title;
    }

    public final String[] component4() {
        return this.candidate;
    }

    public final SystemUserRemindParams copy(Options[] r1, String r2, String r3, String[] r4) {
        return new SystemUserRemindParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemUserRemindParams) == true) goto L8;
        return false;
    L8:
        SystemUserRemindParams r6 = (SystemUserRemindParams) r5;
        if (Intrinsics.areEqual(this.options, r6.options) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.candidate, r6.candidate) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Options[] r0 = this.options;
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
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String[] r10 = this.candidate;
        if (r10 == null) goto L19;
        r1 = Arrays.hashCode(r10);
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "SystemUserRemindParams(options=" + Arrays.toString(this.options) + ", content=" + this.content + ", title=" + this.title + ", candidate=" + Arrays.toString(this.candidate) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        Options[] r1 = this.options;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L8:
        r5.writeString(this.content);
        r5.writeString(this.title);
        r5.writeStringArray(this.candidate);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L8;
        r1[r0].writeToParcel(r5, r6);
        r0 = r0 + 1;
        goto L6
    }

    public SystemUserRemindParams(Options[] r1, String r2, String r3, String[] r4) {
        this.options = r1;
        this.content = r2;
        this.title = r3;
        this.candidate = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemUserRemindParams(Options[] r2, String r3, String r4, String[] r5, int r6, DefaultConstructorMarker r7) {
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

    public final Options[] getOptions() {
        return this.options;
    }

    public final void setOptions(Options[] r1) {
        this.options = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final void setCandidate(String[] r1) {
        this.candidate = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof SystemUserRemindParams) == false) goto L5;
        Options[] r0 = this.options;
        if (r0 != null) goto L9;
        r0 = ((SystemUserRemindParams) r4).options;
    L9:
        String r1 = this.content;
        if (r1 != null) goto L12;
        r1 = ((SystemUserRemindParams) r4).content;
    L12:
        String r2 = this.title;
        if (r2 != null) goto L15;
        r2 = ((SystemUserRemindParams) r4).title;
    L15:
        String[] r3 = this.candidate;
        if (r3 != null) goto L19;
        r3 = ((SystemUserRemindParams) r4).candidate;
    L19:
        return new SystemUserRemindParams(r0, r1, r2, r3);
    L5:
        return this;
    }
}
