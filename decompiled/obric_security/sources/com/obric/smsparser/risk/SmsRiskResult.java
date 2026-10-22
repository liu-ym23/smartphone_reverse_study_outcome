package com.obric.smsparser.risk;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsRiskResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/smsparser/risk/SmsRiskResult;", "Landroid/os/Parcelable;", SlardarConfigConsts.CONFIG_ID, "", "riskLevel", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getRiskLevel", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "smsrisk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsRiskResult implements Parcelable {
    public static final Parcelable.Creator<SmsRiskResult> CREATOR = null;
    private final String id;
    private final int riskLevel;

    /* JADX INFO: compiled from: SmsRiskResult.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SmsRiskResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsRiskResult createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SmsRiskResult(r2.readString(), r2.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsRiskResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsRiskResult[] newArray(int r1) {
            return new SmsRiskResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsRiskResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SmsRiskResult copy$default(SmsRiskResult r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.riskLevel;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.riskLevel;
    }

    public final SmsRiskResult copy(String r1, int r2) {
        return new SmsRiskResult(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SmsRiskResult) == true) goto L8;
        return false;
    L8:
        SmsRiskResult r6 = (SmsRiskResult) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (this.riskLevel == r6.riskLevel) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.riskLevel);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "SmsRiskResult(id=" + this.id + ", riskLevel=" + this.riskLevel + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.id);
        r1.writeInt(this.riskLevel);
    }

    public SmsRiskResult(String r1, int r2) {
        this.id = r1;
        this.riskLevel = r2;
    }

    public /* synthetic */ SmsRiskResult(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }

    public final String getId() {
        return this.id;
    }

    public final int getRiskLevel() {
        return this.riskLevel;
    }
}
