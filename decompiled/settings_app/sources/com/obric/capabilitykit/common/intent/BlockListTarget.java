package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "Landroid/os/Parcelable;", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "callHistory", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "telephone", "", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;Ljava/lang/String;)V", "getCallHistory", "()Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockListTarget implements Parcelable {
    public static final Parcelable.Creator<BlockListTarget> CREATOR = null;
    private final CallHistoryEntity callHistory;
    private final ContactEntity contact;
    private final String telephone;

    /* JADX INFO: compiled from: Params.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BlockListTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockListTarget createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            BlockListTarget r1 = new BlockListTarget((ContactEntity) r6.readParcelable(BlockListTarget.class.getClassLoader()), (CallHistoryEntity) r6.readParcelable(BlockListTarget.class.getClassLoader()), r6.readString());
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
        public /* bridge */ /* synthetic */ BlockListTarget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BlockListTarget[] newArray(int r1) {
            return new BlockListTarget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BlockListTarget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ BlockListTarget copy$default(BlockListTarget r0, ContactEntity r1, CallHistoryEntity r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.contact;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.callHistory;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.telephone;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ContactEntity component1() {
        return this.contact;
    }

    public final CallHistoryEntity component2() {
        return this.callHistory;
    }

    public final String component3() {
        return this.telephone;
    }

    public final BlockListTarget copy(ContactEntity r1, CallHistoryEntity r2, String r3) {
        return new BlockListTarget(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlockListTarget) == true) goto L8;
        return false;
    L8:
        BlockListTarget r6 = (BlockListTarget) r5;
        if (Intrinsics.areEqual(this.contact, r6.contact) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.callHistory, r6.callHistory) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephone, r6.telephone) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ContactEntity r0 = this.contact;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CallHistoryEntity r4 = this.callHistory;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.telephone;
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
        return "BlockListTarget(contact=" + this.contact + ", callHistory=" + this.callHistory + ", telephone=" + this.telephone + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeParcelable(this.contact, r3);
        r2.writeParcelable(this.callHistory, r3);
        r2.writeString(this.telephone);
    }

    public BlockListTarget(ContactEntity r1, CallHistoryEntity r2, String r3) {
        this.contact = r1;
        this.callHistory = r2;
        this.telephone = r3;
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    public final CallHistoryEntity getCallHistory() {
        return this.callHistory;
    }

    public final String getTelephone() {
        return this.telephone;
    }
}
