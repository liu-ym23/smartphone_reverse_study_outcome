package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecorderDeleteParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0019HÖ\u0001J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "deleteAll", "", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)V", "getDeleteAll", "()Ljava/lang/Boolean;", "setDeleteAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;)V", "[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "describeContents", "", "equals", PluralRules.KEYWORD_OTHER, "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecorderDeleteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<RecorderDeleteParams> CREATOR = null;
    private Boolean deleteAll;
    private RecordingEntity[] targets;

    /* JADX INFO: compiled from: RecorderDeleteParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecorderDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Boolean r2 = null;
            if (r8.readInt() != 0) goto L5;
            RecordingEntity[] r4 = null;
        L8:
            int r5 = 1;
            if (r8.readInt() != 0) goto L12;
        L16:
            RecorderDeleteParams r1 = new RecorderDeleteParams(r4, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
        L17:
            if (r5 > r3) goto L19;
            r5 = r5 + 1;
        L19:
            if (r5 > r0) goto L21;
            ParcelUtils.skipValueSafely(r8, r7);
            r5 = r5 + 1;
            goto L19
        L21:
            return r1;
        L12:
            if (r8.readInt() == 0) goto L14;
            boolean r6 = true;
        L15:
            r2 = Boolean.valueOf(r6);
            goto L16
        L14:
            r6 = false;
            goto L15
        L5:
            int r9 = r8.readInt();
            r4 = new RecordingEntity[r9];
            int r10 = 0;
        L6:
            if (r10 == r9) goto L8;
            r4[r10] = (RecordingEntity) r8.readParcelable(RecorderDeleteParams.class.getClassLoader());
            r10 = r10 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams[] newArray(int r1) {
            return new RecorderDeleteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecorderDeleteParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecorderDeleteParams copy$default(RecorderDeleteParams r0, RecordingEntity[] r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deleteAll;
    L9:
        return r0.copy(r1, r2);
    }

    public final RecordingEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.deleteAll;
    }

    public final RecorderDeleteParams copy(RecordingEntity[] r1, Boolean r2) {
        return new RecorderDeleteParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecorderDeleteParams) == true) goto L8;
        return false;
    L8:
        RecorderDeleteParams r6 = (RecorderDeleteParams) r5;
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deleteAll, r6.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        RecordingEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.deleteAll;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "RecorderDeleteParams(targets=" + Arrays.toString(this.targets) + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        r7.writeInt(0);
        Intrinsics.checkNotNullParameter(r7, "out");
        RecordingEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L8:
        Boolean r6 = this.deleteAll;
        if (r6 != null) goto L11;
        r7.writeInt(0);
        return;
    L11:
        r7.writeInt(1);
        r7.writeInt(r6.booleanValue() ? 1 : 0);
        return;
    L5:
        r7.writeInt(1);
        int r3 = r1.length;
        r7.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r7.writeParcelable(r1[r4], r8);
        r4 = r4 + 1;
        goto L6
    }

    public RecorderDeleteParams(RecordingEntity[] r1, Boolean r2) {
        this.targets = r1;
        this.deleteAll = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ RecorderDeleteParams(RecordingEntity[] r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final RecordingEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(RecordingEntity[] r1) {
        this.targets = r1;
    }

    public final Boolean getDeleteAll() {
        return this.deleteAll;
    }

    public final void setDeleteAll(Boolean r1) {
        this.deleteAll = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof RecorderDeleteParams) == false) goto L5;
        RecordingEntity[] r0 = this.targets;
        if (r0 != null) goto L9;
        r0 = ((RecorderDeleteParams) r2).targets;
    L9:
        Boolean r1 = this.deleteAll;
        if (r1 != null) goto L13;
        r1 = ((RecorderDeleteParams) r2).deleteAll;
    L13:
        return new RecorderDeleteParams(r0, r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }
}
