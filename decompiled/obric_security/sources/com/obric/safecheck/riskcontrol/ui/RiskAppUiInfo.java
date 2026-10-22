package com.obric.safecheck.riskcontrol.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RiskAppUiInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "", ApkVirusCheckProvider.KEY_PKG, "", "appName", "icon", "Landroid/graphics/drawable/Drawable;", "versionName", "installSource", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getInstallSource", "getPkg", "getVersionName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppUiInfo {
    public static final Companion Companion = null;
    private final String appName;
    private final Drawable icon;
    private final String installSource;
    private final String pkg;
    private final String versionName;

    /* JADX INFO: compiled from: RiskAppUiInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo$Companion;", "", "()V", "resolve", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "context", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "resolveArchive", "apkPath", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final RiskAppUiInfo resolve(Context r13, String r14, int r15) {
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r14, ApkVirusCheckProvider.KEY_PKG);
            PackageManager r16 = r13.getPackageManager();
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Companion r2 = this;     // Catch: Throwable -> L5
            Object r3 = Result.m774constructorimpl(r16.getApplicationInfo(r14, 0));     // Catch: Throwable -> L5
        L7:
            String r4 = null;
            if (Result.m780isFailureimpl(r3) == false) goto L10;
            r3 = null;
        L10:
            ApplicationInfo r5 = (ApplicationInfo) r3;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
            Companion r7 = this;     // Catch: Throwable -> L13
            Object r8 = Result.m774constructorimpl(r16.getPackageInfo(r14, 0));     // Catch: Throwable -> L13
        L16:
            if (Result.m780isFailureimpl(r8) == false) goto L18;
            r8 = null;
        L18:
            PackageInfo r9 = (PackageInfo) r8;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
            Companion r11 = this;     // Catch: Throwable -> L21
            Object r12 = Result.m774constructorimpl(r16.getInstallerPackageName(r14));     // Catch: Throwable -> L21
        L24:
            if (Result.m780isFailureimpl(r12) == false) goto L26;
            r12 = null;
        L26:
            String r17 = (String) r12;
            if (r17 == null) goto L37;
            Companion r18 = RiskAppUiInfo.Companion;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L31
            ApplicationInfo r0 = r16.getApplicationInfo(r17, 0);     // Catch: Throwable -> L31
            Intrinsics.checkNotNullExpressionValue(r0, "pm.getApplicationInfo(installer, 0)");     // Catch: Throwable -> L31
            Object r20 = Result.m774constructorimpl(r16.getApplicationLabel(r0).toString());     // Catch: Throwable -> L31
        L34:
            if (Result.m780isFailureimpl(r20) == false) goto L36;
            r20 = null;
        L36:
            String r21 = (String) r20;
        L38:
            if (r5 == null) goto L43;
            String r22 = r16.getApplicationLabel(r5).toString();
            if (r22 == null) goto L43;
            String r23 = r22;
        L44:
            if (r5 == null) goto L75;
            Companion r24 = RiskAppUiInfo.Companion;
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L48
            Object r26 = Result.m774constructorimpl(r16.getApplicationIcon(r5));     // Catch: Throwable -> L48
        L51:
            if (Result.m780isFailureimpl(r26) == false) goto L53;
            r26 = null;
        L53:
            Drawable r27 = (Drawable) r26;
            if (r27 == null) goto L75;
            Drawable r28 = r27;
        L65:
            if (r9 == null) goto L67;
            r4 = r9.versionName;
        L67:
            String r110 = r4;
            if (r21 != null) goto L70;
            String r111 = r17;
        L72:
            return new RiskAppUiInfo(r14, r23, r28, r110, r111);
        L70:
            r111 = r21;
        L48:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r26 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L75:
            Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L59
            Companion r112 = this;     // Catch: Throwable -> L59
            Object r113 = Result.m774constructorimpl(r13.getApplicationInfo().loadIcon(r16));     // Catch: Throwable -> L59
        L62:
            if (Result.m780isFailureimpl(r113) == false) goto L64;
            r113 = null;
        L64:
            r28 = (Drawable) r113;
        L59:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            r113 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L43:
            r23 = r14;
        L31:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            r20 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L34
        L37:
            r21 = null;
        L21:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            r12 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L13:
            th = move-exception;
            Result.Companion r33 = Result.Companion;
            r8 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L5:
            th = move-exception;
            Result.Companion r34 = Result.Companion;
            r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final RiskAppUiInfo resolveArchive(Context r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "apkPath");
            PackageManager r3 = r11.getPackageManager();
            String r0 = new File(r12).getName();
            if (StringsKt.isBlank(r0) == false) goto L5;
            r0 = r12;
        L5:
            String r4 = r0;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
            Companion r2 = this;     // Catch: Throwable -> L8
            Object r5 = Result.m774constructorimpl(r3.getPackageArchiveInfo(r12, 0));     // Catch: Throwable -> L8
        L11:
            if (Result.m780isFailureimpl(r5) == false) goto L13;
            r5 = null;
        L13:
            PackageInfo r6 = (PackageInfo) r5;
            if (r6 == null) goto L18;
            ApplicationInfo r7 = r6.applicationInfo;
            if (r7 == null) goto L18;
            r7.sourceDir = r12;
            r7.publicSourceDir = r12;
            ApplicationInfo r8 = r7;
        L19:
            if (r8 == null) goto L32;
            Companion r9 = RiskAppUiInfo.Companion;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
            Object r13 = Result.m774constructorimpl(r3.getApplicationLabel(r8).toString());     // Catch: Throwable -> L23
        L26:
            if (Result.m780isFailureimpl(r13) == false) goto L28;
            r13 = null;
        L28:
            String r14 = (String) r13;
            if (r14 == null) goto L32;
            r4 = r14;
        L23:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r13 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L32:
            if (r8 == null) goto L59;
            Companion r16 = RiskAppUiInfo.Companion;
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L36
            Object r18 = Result.m774constructorimpl(r8.loadIcon(r3));     // Catch: Throwable -> L36
        L39:
            if (Result.m780isFailureimpl(r18) == false) goto L41;
            r18 = null;
        L41:
            Drawable r19 = (Drawable) r18;
            if (r19 == null) goto L59;
        L51:
            Intrinsics.checkNotNullExpressionValue(r4, "appName");
            if (r6 == null) goto L54;
            String r20 = r6.versionName;
        L56:
            return new RiskAppUiInfo(r12, r4, r19, r20, null, 16, null);
        L54:
            r20 = null;
        L36:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r18 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L59:
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L45
            Companion r23 = this;     // Catch: Throwable -> L45
            Object r24 = Result.m774constructorimpl(r11.getApplicationInfo().loadIcon(r3));     // Catch: Throwable -> L45
        L48:
            if (Result.m780isFailureimpl(r24) == false) goto L50;
            r24 = null;
        L50:
            r19 = (Drawable) r24;
        L45:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r24 = Result.m774constructorimpl(ResultKt.createFailure(th));
        L18:
            r8 = null;
        L8:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L11
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ RiskAppUiInfo copy$default(RiskAppUiInfo r3, String r4, String r5, Drawable r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.pkg;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.appName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.icon;
    L11:
        Drawable r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.versionName;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.installSource;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.pkg;
    }

    public final String component2() {
        return this.appName;
    }

    public final Drawable component3() {
        return this.icon;
    }

    public final String component4() {
        return this.versionName;
    }

    public final String component5() {
        return this.installSource;
    }

    public final RiskAppUiInfo copy(String r7, String r8, Drawable r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r8, "appName");
        return new RiskAppUiInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RiskAppUiInfo) == false) goto L16;
        RiskAppUiInfo r4 = (RiskAppUiInfo) r3;
        if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appName, r4.appName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionName, r4.versionName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.installSource, r4.installSource) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.pkg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.appName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Drawable r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.versionName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.installSource;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RiskAppUiInfo(pkg=" + this.pkg + ", appName=" + this.appName + ", icon=" + this.icon + ", versionName=" + this.versionName + ", installSource=" + this.installSource + ")";
    }

    public RiskAppUiInfo(String r2, String r3, Drawable r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r3, "appName");
        this.pkg = r2;
        this.appName = r3;
        this.icon = r4;
        this.versionName = r5;
        this.installSource = r6;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getAppName() {
        return this.appName;
    }

    public /* synthetic */ RiskAppUiInfo(String r8, String r9, Drawable r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        Drawable r15 = (Drawable) null;
        Drawable r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r16 = (String) null;
        String r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r17 = (String) null;
        String r6 = null;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getInstallSource() {
        return this.installSource;
    }
}
