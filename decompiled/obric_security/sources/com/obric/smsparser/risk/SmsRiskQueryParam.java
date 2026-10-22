package com.obric.smsparser.risk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsRiskQueryParam.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/smsparser/risk/SmsRiskQueryParam;", "Landroid/os/Parcelable;", SlardarConfigConsts.CONFIG_ID, "", AccountConst.KEY_PHONE_NUMBER, "smsContent", ProviderConstants.Sms.DATE, "", WsConstants.KEY_EXTRA, "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLandroid/os/Bundle;)V", "getDate", "()J", "getExtra", "()Landroid/os/Bundle;", "getId", "()Ljava/lang/String;", "getPhoneNumber", "getSmsContent", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "smsrisk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsRiskQueryParam implements Parcelable {
    public static final Parcelable.Creator<SmsRiskQueryParam> CREATOR = null;
    private final long date;
    private final Bundle extra;
    private final String id;
    private final String phoneNumber;
    private final String smsContent;

    /* JADX INFO: compiled from: SmsRiskQueryParam.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SmsRiskQueryParam> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsRiskQueryParam createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new SmsRiskQueryParam(r8.readString(), r8.readString(), r8.readString(), r8.readLong(), r8.readBundle(SmsRiskQueryParam.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsRiskQueryParam createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsRiskQueryParam[] newArray(int r1) {
            return new SmsRiskQueryParam[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsRiskQueryParam[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SmsRiskQueryParam copy$default(SmsRiskQueryParam r4, String r5, String r6, String r7, long r8, Bundle r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.phoneNumber;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.smsContent;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.date;
    L14:
        long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.extra;
    L17:
        String r9 = r5;
        return r4.copy(r9, r13, r0, r1, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.phoneNumber;
    }

    public final String component3() {
        return this.smsContent;
    }

    public final long component4() {
        return this.date;
    }

    public final Bundle component5() {
        return this.extra;
    }

    public final SmsRiskQueryParam copy(String r8, String r9, String r10, long r11, Bundle r13) {
        return new SmsRiskQueryParam(r8, r9, r10, r11, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SmsRiskQueryParam) == true) goto L8;
        return false;
    L8:
        SmsRiskQueryParam r9 = (SmsRiskQueryParam) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.smsContent, r9.smsContent) == true) goto L18;
        return false;
    L18:
        if (this.date == r9.date) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.phoneNumber;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.smsContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Long.hashCode(this.date)) * 31;
        Bundle r10 = this.extra;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SmsRiskQueryParam(id=" + this.id + ", phoneNumber=" + this.phoneNumber + ", smsContent=" + this.smsContent + ", date=" + this.date + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.id);
        r3.writeString(this.phoneNumber);
        r3.writeString(this.smsContent);
        r3.writeLong(this.date);
        r3.writeBundle(this.extra);
    }

    public SmsRiskQueryParam(String r1, String r2, String r3, long r4, Bundle r6) {
        this.id = r1;
        this.phoneNumber = r2;
        this.smsContent = r3;
        this.date = r4;
        this.extra = r6;
    }

    public /* synthetic */ SmsRiskQueryParam(String r8, String r9, String r10, long r11, Bundle r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = 0;
    L5:
        long r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r13 = null;
    L8:
        this(r8, r9, r10, r4, r13);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getSmsContent() {
        return this.smsContent;
    }

    public final long getDate() {
        return this.date;
    }

    public final Bundle getExtra() {
        return this.extra;
    }
}
