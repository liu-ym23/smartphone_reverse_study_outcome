package com.obric.security.safecheckapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/security/safecheckapi/CheckResult;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "checkType", "", "isBlacklisted", "", DBHelper.BATTERY_COL_SOURCE, "threatType", "threatLevel", "description", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckType", "()Ljava/lang/String;", "setCheckType", "(Ljava/lang/String;)V", "getDescription", "setDescription", "()Z", "setBlacklisted", "(Z)V", "getSource", "setSource", "getThreatLevel", "setThreatLevel", "getThreatType", "setThreatType", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "safecheckapi_release"}, k = 1, mv = {1, 4, 3})
public final class CheckResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final String LEVEL_HIGH = "高";
    public static final String LEVEL_LOW = "低";
    public static final String LEVEL_MEDIUM = "中";
    public static final String THREAT_FRAUD = "反诈";
    public static final String THREAT_FRAUD_GXB = "工信部";
    public static final String THREAT_VIRUS = "病毒";
    public static final String TYPE_APK = "APK";
    public static final String TYPE_PHONE = "PHONE";
    public static final String TYPE_URL = "URL";
    private String checkType;
    private String description;
    private boolean isBlacklisted;
    private String source;
    private String threatLevel;
    private String threatType;

    /* JADX INFO: compiled from: CheckResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001d\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/security/safecheckapi/CheckResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/security/safecheckapi/CheckResult;", "()V", "LEVEL_HIGH", "", "LEVEL_LOW", "LEVEL_MEDIUM", "THREAT_FRAUD", "THREAT_FRAUD_GXB", "THREAT_VIRUS", "TYPE_APK", "TYPE_PHONE", "TYPE_URL", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/security/safecheckapi/CheckResult;", "safecheckapi_release"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<CheckResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CheckResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CheckResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckResult createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CheckResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CheckResult[] newArray(int r1) {
            return new CheckResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CheckResult() {
        this(null, false, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CheckResult(String r2, boolean r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "checkType");
        Intrinsics.checkNotNullParameter(r4, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "threatType");
        Intrinsics.checkNotNullParameter(r6, "threatLevel");
        Intrinsics.checkNotNullParameter(r7, "description");
        this.checkType = r2;
        this.isBlacklisted = r3;
        this.source = r4;
        this.threatType = r5;
        this.threatLevel = r6;
        this.description = r7;
    }

    public final String getCheckType() {
        return this.checkType;
    }

    public final void setCheckType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.checkType = r2;
    }

    public final boolean isBlacklisted() {
        return this.isBlacklisted;
    }

    public final void setBlacklisted(boolean r1) {
        this.isBlacklisted = r1;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public final String getThreatType() {
        return this.threatType;
    }

    public final void setThreatType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threatType = r2;
    }

    public final String getThreatLevel() {
        return this.threatLevel;
    }

    public final void setThreatLevel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threatLevel = r2;
    }

    public /* synthetic */ CheckResult(String r2, boolean r3, String r4, String r5, String r6, String r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = "";
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = "";
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.description = r2;
    }

    public CheckResult(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r0 = r10.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        Intrinsics.checkNotNullExpressionValue(r3, "parcel.readString() ?: \"\"");
        boolean r4 = false;
        if (r10.readByte() == ((byte) 0)) goto L9;
        r4 = true;
    L9:
        String r2 = r10.readString();
        if (r2 != null) goto L12;
        String r5 = "";
    L13:
        Intrinsics.checkNotNullExpressionValue(r5, "parcel.readString() ?: \"\"");
        this(r3, r4, r5, String.valueOf(r10.readString()), String.valueOf(r10.readString()), String.valueOf(r10.readString()));
        return;
    L12:
        r5 = r2;
        goto L13
    L5:
        r3 = r0;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.checkType);
        r1.writeByte(this.isBlacklisted ? 1 : 0);
        r1.writeString(this.source);
        r1.writeString(this.threatType);
        r1.writeString(this.threatLevel);
        r1.writeString(this.description);
    }
}
