package com.android.settings.fuelgauge.appBatteryUseOptimization.apppoweruse;

import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import com.android.settings.fuelgauge.PowerUsageDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppPowerProfileData.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J[\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018¨\u00060"}, d2 = {"Lcom/android/settings/fuelgauge/appBatteryUseOptimization/apppoweruse/AppPowerProfileData;", "", "pkg", "", "appName", "appIcon", "Landroid/graphics/drawable/Drawable;", "powermAh", "", PowerUsageDetail.EXTRA_PERCENT, "", "fgDurationSec", "bgDurationSec", "durationDesc", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;IFIILjava/lang/String;)V", "getAppIcon", "()Landroid/graphics/drawable/Drawable;", "setAppIcon", "(Landroid/graphics/drawable/Drawable;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getBgDurationSec", "()I", "getDurationDesc", "setDurationDesc", "getFgDurationSec", "getPercent", "()F", "setPercent", "(F)V", "getPkg", "getPowermAh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppPowerProfileData {
    private Drawable appIcon;
    private String appName;
    private final int bgDurationSec;
    private String durationDesc;
    private final int fgDurationSec;
    private float percent;
    private final String pkg;
    private final int powermAh;

    public AppPowerProfileData() {
        this(null, null, null, 0, 0.0f, 0, 0, null, 255, null);
    }

    public static /* synthetic */ AppPowerProfileData copy$default(AppPowerProfileData r9, String r10, String r11, Drawable r12, int r13, float r14, int r15, int r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.pkg;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.appName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Drawable r4 = r9.appIcon;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.powermAh;
    L19:
        if ((r18 & 16) == 0) goto L21;
        float r6 = r9.percent;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.fgDurationSec;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.bgDurationSec;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.durationDesc;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.pkg;
    }

    public final String component2() {
        return this.appName;
    }

    public final Drawable component3() {
        return this.appIcon;
    }

    public final int component4() {
        return this.powermAh;
    }

    public final float component5() {
        return this.percent;
    }

    public final int component6() {
        return this.fgDurationSec;
    }

    public final int component7() {
        return this.bgDurationSec;
    }

    public final String component8() {
        return this.durationDesc;
    }

    public final AppPowerProfileData copy(String r11, String r12, Drawable r13, int r14, float r15, int r16, int r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "pkg");
        Intrinsics.checkNotNullParameter(r12, "appName");
        Intrinsics.checkNotNullParameter(r18, "durationDesc");
        return new AppPowerProfileData(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppPowerProfileData) == true) goto L8;
        return false;
    L8:
        AppPowerProfileData r6 = (AppPowerProfileData) r5;
        if (Intrinsics.areEqual(this.pkg, r6.pkg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appIcon, r6.appIcon) == true) goto L18;
        return false;
    L18:
        if (this.powermAh == r6.powermAh) goto L21;
        return false;
    L21:
        if (Float.compare(this.percent, r6.percent) == 0) goto L24;
        return false;
    L24:
        if (this.fgDurationSec == r6.fgDurationSec) goto L27;
        return false;
    L27:
        if (this.bgDurationSec == r6.bgDurationSec) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.durationDesc, r6.durationDesc) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.pkg.hashCode() * 31) + this.appName.hashCode()) * 31;
        Drawable r1 = this.appIcon;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + Integer.hashCode(this.powermAh)) * 31) + Float.hashCode(this.percent)) * 31) + Integer.hashCode(this.fgDurationSec)) * 31) + Integer.hashCode(this.bgDurationSec)) * 31) + this.durationDesc.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AppPowerProfileData(pkg=" + this.pkg + ", appName=" + this.appName + ", appIcon=" + this.appIcon + ", powermAh=" + this.powermAh + ", percent=" + this.percent + ", fgDurationSec=" + this.fgDurationSec + ", bgDurationSec=" + this.bgDurationSec + ", durationDesc=" + this.durationDesc + ')';
    }

    public AppPowerProfileData(String r2, String r3, Drawable r4, int r5, float r6, int r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "pkg");
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r9, "durationDesc");
        this.pkg = r2;
        this.appName = r3;
        this.appIcon = r4;
        this.powermAh = r5;
        this.percent = r6;
        this.fgDurationSec = r7;
        this.bgDurationSec = r8;
        this.durationDesc = r9;
    }

    public /* synthetic */ AppPowerProfileData(String r3, String r4, Drawable r5, int r6, float r7, int r8, int r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = 0;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = 0.0f;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = 0;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = 0;
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = "";
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appName = r2;
    }

    public final Drawable getAppIcon() {
        return this.appIcon;
    }

    public final void setAppIcon(Drawable r1) {
        this.appIcon = r1;
    }

    public final int getPowermAh() {
        return this.powermAh;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final void setPercent(float r1) {
        this.percent = r1;
    }

    public final int getFgDurationSec() {
        return this.fgDurationSec;
    }

    public final int getBgDurationSec() {
        return this.bgDurationSec;
    }

    public final String getDurationDesc() {
        return this.durationDesc;
    }

    public final void setDurationDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.durationDesc = r2;
    }
}
