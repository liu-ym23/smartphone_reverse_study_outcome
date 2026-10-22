package com.obric.safecheck.service;

import com.obric.olog.OLog;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.service.checker.ApkAntiFraudChecker;
import com.obric.safecheck.service.checker.ApkVirusChecker;
import com.obric.safecheck.service.checker.PhoneAntiFraudChecker;
import com.obric.safecheck.service.checker.UrlAntiFraudChecker;
import com.obric.safecheck.service.checker.UrlTmsSecurityChecker;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DefaultSecurityCheckHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/safecheck/service/DefaultSecurityCheckHelper;", "Lcom/obric/safecheck/service/SecurityCheckHelper;", "apkAntiFraudChecker", "Lcom/obric/safecheck/service/checker/ApkAntiFraudChecker;", "apkGxbAntiFraudChecker", "apkVirusChecker", "Lcom/obric/safecheck/service/checker/ApkVirusChecker;", "phoneAntiFraudChecker", "Lcom/obric/safecheck/service/checker/PhoneAntiFraudChecker;", "urlAntiFraudChecker", "Lcom/obric/safecheck/service/checker/UrlAntiFraudChecker;", "urlTmsSecurityChecker", "Lcom/obric/safecheck/service/checker/UrlTmsSecurityChecker;", "(Lcom/obric/safecheck/service/checker/ApkAntiFraudChecker;Lcom/obric/safecheck/service/checker/ApkAntiFraudChecker;Lcom/obric/safecheck/service/checker/ApkVirusChecker;Lcom/obric/safecheck/service/checker/PhoneAntiFraudChecker;Lcom/obric/safecheck/service/checker/UrlAntiFraudChecker;Lcom/obric/safecheck/service/checker/UrlTmsSecurityChecker;)V", ApkVirusCheckProvider.METHOD_CHECK_APK, "", "Lcom/obric/security/safecheckapi/CheckResult;", "apkPath", "", "checkApkWithInfo", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkPhone", "phoneNumbers", "", "checkUrl", "urls", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultSecurityCheckHelper implements SecurityCheckHelper {
    private static final Companion Companion = null;

    @Deprecated
    private static final String TAG = "DefaultSecurityCheckHelper";
    private final ApkAntiFraudChecker apkAntiFraudChecker;
    private final ApkAntiFraudChecker apkGxbAntiFraudChecker;
    private final ApkVirusChecker apkVirusChecker;
    private final PhoneAntiFraudChecker phoneAntiFraudChecker;
    private final UrlAntiFraudChecker urlAntiFraudChecker;
    private final UrlTmsSecurityChecker urlTmsSecurityChecker;

    /* JADX INFO: compiled from: DefaultSecurityCheckHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/service/DefaultSecurityCheckHelper$Companion;", "", "()V", "TAG", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DefaultSecurityCheckHelper() {
        this(null, null, null, null, null, null, 63, null);
    }

    public DefaultSecurityCheckHelper(ApkAntiFraudChecker r1, ApkAntiFraudChecker r2, ApkVirusChecker r3, PhoneAntiFraudChecker r4, UrlAntiFraudChecker r5, UrlTmsSecurityChecker r6) {
        this.apkAntiFraudChecker = r1;
        this.apkGxbAntiFraudChecker = r2;
        this.apkVirusChecker = r3;
        this.phoneAntiFraudChecker = r4;
        this.urlAntiFraudChecker = r5;
        this.urlTmsSecurityChecker = r6;
    }

    public /* synthetic */ DefaultSecurityCheckHelper(ApkAntiFraudChecker r5, ApkAntiFraudChecker r6, ApkVirusChecker r7, PhoneAntiFraudChecker r8, UrlAntiFraudChecker r9, UrlTmsSecurityChecker r10, int r11, DefaultConstructorMarker r12) {
        UrlTmsSecurityChecker r0 = null;
        if ((r11 & 1) == 0) goto L6;
        ApkAntiFraudChecker r13 = (ApkAntiFraudChecker) null;
        r5 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        ApkAntiFraudChecker r14 = (ApkAntiFraudChecker) null;
        ApkAntiFraudChecker r15 = null;
    L10:
        if ((r11 & 4) == 0) goto L12;
        ApkVirusChecker r16 = (ApkVirusChecker) null;
        ApkVirusChecker r1 = null;
    L14:
        if ((r11 & 8) == 0) goto L16;
        PhoneAntiFraudChecker r17 = (PhoneAntiFraudChecker) null;
        PhoneAntiFraudChecker r2 = null;
    L18:
        if ((r11 & 16) == 0) goto L20;
        UrlAntiFraudChecker r18 = (UrlAntiFraudChecker) null;
        UrlAntiFraudChecker r3 = null;
    L22:
        if ((r11 & 32) == 0) goto L24;
        UrlTmsSecurityChecker r19 = (UrlTmsSecurityChecker) null;
    L25:
        this(r5, r15, r1, r2, r3, r0);
        return;
    L24:
        r0 = r10;
        goto L25
    L20:
        r3 = r9;
        goto L22
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r15 = r6;
        goto L10
    }

    @Override // com.obric.safecheck.service.SecurityCheckHelper
    public List<CheckResult> checkApk(String r11) {
        OLog.d(TAG, ApkVirusCheckProvider.METHOD_CHECK_APK);
        ApkAntiFraudChecker r0 = this.apkAntiFraudChecker;
        if (r0 == null) goto L6;
        List<CheckResult> r1 = r0.checkByPath(r11);
        if (r1 == null) goto L6;
    L11:
        List<CheckResult> r2 = r1;
        boolean r4 = false;
        if ((r2 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L15;
        if (((CheckResult) r3.next()).isBlacklisted() == false) goto L18;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
        return r1;
    L24:
        ApkAntiFraudChecker r6 = this.apkGxbAntiFraudChecker;
        List<CheckResult> r7 = null;
        if (r6 == null) goto L27;
        List<CheckResult> r8 = r6.checkByPath(r11);
    L28:
        if (r8 != null) goto L30;
        r8 = CollectionsKt.emptyList();
    L30:
        List<CheckResult> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L33;
    L35:
        Iterator<T> r10 = r9.iterator();
    L37:
        if (r10.hasNext() == false) goto L41;
        if (((CheckResult) r10.next()).isBlacklisted() == false) goto L37;
        r4 = true;
    L41:
        if (r4 == false) goto L43;
        return r8;
    L43:
        ApkVirusChecker r12 = this.apkVirusChecker;
        if (r12 == null) goto L46;
        r7 = r12.checkByPath(r11);
    L46:
        if (r7 != null) goto L49;
        r7 = CollectionsKt.emptyList();
    L49:
        if ((!r7.isEmpty()) == false) goto L51;
        return r7;
    L51:
        return r1;
    L33:
        if (r9.isEmpty() == false) goto L35;
    L27:
        r8 = null;
    L15:
        r5 = false;
        goto L22
    L14:
        if (r2.isEmpty() == false) goto L16;
    L6:
        CheckResult r13 = new CheckResult(null, false, null, null, null, null, 63, null);
        r13.setCheckType(CheckResult.TYPE_APK);
        if (r11 != null) goto L9;
        String r14 = "";
    L10:
        r13.setSource(r14);
        r1 = CollectionsKt.listOf(r13);
        goto L11
    L9:
        r14 = r11;
        goto L10
    }

    @Override // com.obric.safecheck.service.SecurityCheckHelper
    public List<CheckResult> checkApkWithInfo(ApkInfo r14) {
        if (r14 == null) goto L5;
        String r0 = r14.getPackageName();
        if (r0 == null) goto L5;
    L6:
        List<CheckResult> r1 = null;
        if (r14 == null) goto L9;
        String r2 = r14.getSignatureSha256();
    L10:
        OLog.d(TAG, "checkApkWithInfo start, packageName is " + r0 + " sha256 is " + r2);
        ApkAntiFraudChecker r3 = this.apkAntiFraudChecker;
        if (r3 == null) goto L13;
        List<CheckResult> r4 = r3.checkByInfo(r14);
    L14:
        if (r4 != null) goto L16;
        r4 = CollectionsKt.emptyList();
    L16:
        boolean r5 = true;
        if (this.apkAntiFraudChecker == null) goto L19;
        boolean r6 = true;
    L20:
        int r7 = r4.size();
        List<CheckResult> r8 = r4;
        boolean r9 = r8 instanceof Collection;
        if (r9 == true) goto L23;
    L25:
        Iterator<T> r10 = r8.iterator();
    L27:
        if (r10.hasNext() == false) goto L24;
        if (((CheckResult) r10.next()).isBlacklisted() == false) goto L27;
        boolean r11 = true;
    L31:
        OLog.d(TAG, "checkApkWithInfo antiFraud done, packageName is " + r0 + ", hasChecker is " + r6 + ", results size is " + r7 + ", hit is " + r11);
        if (r9 == true) goto L34;
    L36:
        Iterator<T> r12 = r8.iterator();
    L38:
        if (r12.hasNext() == false) goto L35;
        if (((CheckResult) r12.next()).isBlacklisted() == false) goto L38;
        boolean r13 = true;
    L42:
        if (r13 == false) goto L45;
        OLog.d(TAG, "checkApkWithInfo hit by antiFraud, packageName is " + r0);
        return r4;
    L45:
        ApkAntiFraudChecker r15 = this.apkGxbAntiFraudChecker;
        if (r15 == null) goto L48;
        r1 = r15.checkByInfo(r14);
    L48:
        if (r1 != null) goto L51;
        r1 = CollectionsKt.emptyList();
    L51:
        if (this.apkGxbAntiFraudChecker == null) goto L53;
        boolean r16 = true;
    L54:
        int r17 = r1.size();
        List<CheckResult> r18 = r1;
        boolean r19 = r18 instanceof Collection;
        if (r19 == true) goto L57;
    L59:
        Iterator<T> r20 = r18.iterator();
    L61:
        if (r20.hasNext() == false) goto L58;
        if (((CheckResult) r20.next()).isBlacklisted() == false) goto L61;
        boolean r21 = true;
    L65:
        OLog.d(TAG, "checkApkWithInfo gxb done, packageName is " + r0 + ", hasChecker is " + r16 + ", results size is " + r17 + ", hit is " + r21);
        if (r19 == true) goto L68;
    L70:
        Iterator<T> r110 = r18.iterator();
    L72:
        if (r110.hasNext() == false) goto L69;
        if (((CheckResult) r110.next()).isBlacklisted() == false) goto L72;
    L75:
        if (r5 == false) goto L78;
        OLog.d(TAG, "checkApkWithInfo hit by gxb, packageName is " + r0);
        return r1;
    L78:
        OLog.d(TAG, "checkApkWithInfo miss, return default result, packageName is " + r0);
        CheckResult r111 = new CheckResult(null, false, null, null, null, null, 63, null);
        r111.setCheckType(CheckResult.TYPE_APK);
        r111.setSource(r0);
        return CollectionsKt.listOf(r111);
    L69:
        r5 = false;
        goto L75
    L68:
        if (r18.isEmpty() == false) goto L70;
    L58:
        r21 = false;
        goto L65
    L57:
        if (r18.isEmpty() == false) goto L59;
    L53:
        r16 = false;
    L35:
        r13 = false;
        goto L42
    L34:
        if (r8.isEmpty() == false) goto L36;
    L24:
        r11 = false;
        goto L31
    L23:
        if (r8.isEmpty() == false) goto L25;
    L19:
        r6 = false;
        goto L20
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = null;
    L5:
        r0 = "";
        goto L6
    }

    @Override // com.obric.safecheck.service.SecurityCheckHelper
    public List<CheckResult> checkUrl(List<String> r13) {
        OLog.d(TAG, "checkUrl");
        UrlAntiFraudChecker r0 = this.urlAntiFraudChecker;
        if (r0 == null) goto L6;
        ArrayList r1 = r0.check(r13);
        if (r1 == null) goto L6;
    L13:
        UrlTmsSecurityChecker r12 = this.urlTmsSecurityChecker;
        if (r12 != null) goto L16;
        return r1;
    L16:
        return r12.check(r1);
    L6:
        if (r13 != null) goto L8;
        r13 = CollectionsKt.emptyList();
    L8:
        List<String> r14 = r13;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        String r3 = (String) r15.next();
        CheckResult r11 = new CheckResult(null, false, null, null, null, null, 63, null);
        r11.setCheckType(CheckResult.TYPE_URL);
        r11.setSource(r3);
        r2.add(r11);
        goto L10
    L12:
        r1 = r2;
        goto L13
    }

    @Override // com.obric.safecheck.service.SecurityCheckHelper
    public List<CheckResult> checkPhone(List<String> r12) {
        PhoneAntiFraudChecker r11 = this.phoneAntiFraudChecker;
        if (r11 == null) goto L6;
        List<CheckResult> r13 = r11.check(r12);
        if (r13 == null) goto L6;
        return r13;
    L6:
        if (r12 != null) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        List<String> r14 = r12;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L13;
        String r0 = (String) r16.next();
        CheckResult r10 = new CheckResult(null, false, null, null, null, null, 63, null);
        r10.setCheckType(CheckResult.TYPE_PHONE);
        r10.setSource(r0);
        r15.add(r10);
        goto L10
    L13:
        return r15;
    }
}
