package com.bytedanceos.securitycenter.scan;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: RiskResultMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J$\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/RiskResultMapper;", "", "()V", "deriveFallbackName", "", "key", "deriveKey", "path", "packageName", "isInstallationPackage", "", "deriveVirusType", "Lkotlin/Pair;", "", "virusName", "externalStorageRoots", "", "isRiskResult", "scanResult", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskResultMapper {
    public static final RiskResultMapper INSTANCE = null;

    public final boolean isRiskResult(int r1) {
        if (r1 != 259) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 260) goto L12;
        if (r1 == 261) goto L12;
        if (r1 == 262) goto L12;
        return false;
    }

    static {
        INSTANCE = new RiskResultMapper();
    }

    private RiskResultMapper() {
    }

    public final boolean isInstallationPackage(String r4, String r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r6, "externalStorageRoots");
        if (StringsKt.endsWith(r4, ".apk", true) == true) goto L6;
        return false;
    L6:
        if (StringsKt.isBlank(r5) == false) goto L8;
        return true;
    L8:
        List<String> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r3 = r7.iterator();
    L15:
        if (r3.hasNext() == false) goto L26;
        String r8 = (String) r3.next();
        if (r8.length() <= 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L22;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L15;
        return true;
    L22:
        if (StringsKt.startsWith$default(r4, r8, false, 2, null) == false) goto L24;
        r10 = true;
        goto L25
    L19:
        r9 = false;
    L26:
        return false;
    L11:
        if (r7.isEmpty() == false) goto L13;
        goto L13
    }

    public final String deriveKey(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "path");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        if (r3 == false) goto L9;
        String r4 = r1;
        String r5 = r2;
        if (StringsKt.isBlank(r4) == true) goto L15;
        r5 = r4;
    L15:
        return r5;
    L9:
        String r6 = r2;
        String r7 = r1;
        if (StringsKt.isBlank(r6) == true) goto L14;
        r7 = r6;
    L14:
        return r7;
    }

    public final Pair<String, Integer> deriveVirusType(String r5) {
        String r4 = r5;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        Locale r7 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r7, "Locale.US");
        String r8 = r5.toLowerCase(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.contains$default(r8, "a.gray.sex", false, 2, null) == false) goto L15;
        String r9 = "sex";
        int r10 = 1;
    L17:
        return TuplesKt.to(r9, r10);
    L15:
        r9 = "other";
        r10 = 2;
        goto L17
    L11:
        return TuplesKt.to("none", 0);
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r6 = false;
        goto L9
    }

    public final String deriveFallbackName(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        String r2 = StringsKt.substringAfterLast$default(r3, IOUtils.DIR_SEPARATOR_UNIX, null, 2, null);
        if (StringsKt.isBlank(r2) == true) goto L7;
        r3 = r2;
    L7:
        return r3;
    }
}
