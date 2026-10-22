package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard;", "Landroid/os/Parcelable;", "isIndependent", "", "cardProviders", "", "Lcom/obric/capabilitykit/common/CardProvider;", "(Ljava/lang/Boolean;[Lcom/obric/capabilitykit/common/CardProvider;)V", "getCardProviders", "()[Lcom/obric/capabilitykit/common/CardProvider;", "setCardProviders", "([Lcom/obric/capabilitykit/common/CardProvider;)V", "[Lcom/obric/capabilitykit/common/CardProvider;", "()Ljava/lang/Boolean;", "setIndependent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RemoteCard implements Parcelable {
    public static final a CREATOR = null;
    private CardProvider[] cardProviders;
    private Boolean isIndependent;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/RemoteCard;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/capabilitykit/common/RemoteCard;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<RemoteCard> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public RemoteCard a(Parcel r7) {
            int r6 = r7.readInt();
            Intrinsics.checkNotNullParameter(r7, "parcel");
            Object r0 = r7.readValue(CardProvider.class.getClassLoader());
            if ((r0 instanceof Boolean) == false) goto L5;
            Boolean r1 = (Boolean) r0;
        L6:
            int r2 = r7.readInt();
            CardProvider[] r3 = new CardProvider[r2];
            int r4 = 0;
        L7:
            if (r4 >= r2) goto L9;
            r3[r4] = (CardProvider) r7.readParcelable(CardProvider.class.getClassLoader());
            r4 = r4 + 1;
            goto L7
        L9:
            RemoteCard r5 = new RemoteCard(r1, r3);
            int r8 = Math.min(r6, 0);
            ClassLoader r9 = a.class.getClassLoader();
            int r10 = 1;
        L10:
            if (r10 > r8) goto L12;
            r10 = r10 + 1;
        L12:
            if (r10 > r6) goto L14;
            ParcelUtils.skipValueSafely(r7, r9);
            r10 = r10 + 1;
            goto L12
        L14:
            return r5;
        L5:
            r1 = null;
            goto L6
        }

        public RemoteCard[] a(int r1) {
            return new RemoteCard[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteCard createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RemoteCard[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCard() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public RemoteCard(Boolean r1, CardProvider[] r2) {
        this.isIndependent = r1;
        this.cardProviders = r2;
    }

    public /* synthetic */ RemoteCard(Boolean r1, CardProvider[] r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CardProvider[] getCardProviders() {
        return this.cardProviders;
    }

    public final Boolean isIndependent() {
        return this.isIndependent;
    }

    public final void setCardProviders(CardProvider[] r1) {
        this.cardProviders = r1;
    }

    public final void setIndependent(Boolean r1) {
        this.isIndependent = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("RemoteCard(isIndependent=").append(this.isIndependent).append(", cardProviders=");
        String r2 = Arrays.toString(this.cardProviders);
        Intrinsics.checkNotNullExpressionValue(r2, "java.util.Arrays.toString(this)");
        return r0.append(r2).append(')').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeValue(this.isIndependent);
        CardProvider[] r1 = this.cardProviders;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L6:
        r4.writeInt(r2);
        CardProvider[] r3 = this.cardProviders;
        if (r3 == null) goto L11;
        int r6 = r3.length;
    L9:
        if (r0 >= r6) goto L13;
        r4.writeParcelable(r3[r0], r5);
        r0 = r0 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
