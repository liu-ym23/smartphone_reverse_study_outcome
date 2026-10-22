package com.obric.safecheck.util.serviceutil;

import com.obric.safecheck.AntiFraudWhiteListSettings;
import com.obric.safecheck.WhitePackageItem;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.security.safecheckapi.ApkInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0006"}, d2 = {"checkApkInBlacklist", "Lcom/obric/safecheck/database/entity/PkgSignItem;", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "pkgSignItems", "", "safecheck_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class MatchResultKt {
    public static final PkgSignItem checkApkInBlacklist(ApkInfo r10, List<PkgSignItem> r11) {
        Intrinsics.checkNotNullParameter(r11, "pkgSignItems");
        Object r1 = null;
        if (r11.isEmpty() == true) goto L136;
        if (r10 == null) goto L137;
        String r0 = r10.getPackageName();
        String r2 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        String r3 = r10.getSignatureMd5();
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        String r4 = r10.getSignatureSha1();
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        String r12 = r10.getSignatureSha256();
        if (r12 == null) goto L19;
        r2 = r12;
    L19:
        List<WhitePackageItem> r13 = AntiFraudWhiteListSettings.getValue();
        if (r13 != null) goto L22;
        r13 = CollectionsKt.emptyList();
    L22:
        List<WhitePackageItem> r14 = r13;
        if ((r14 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L26;
        WhitePackageItem r5 = (WhitePackageItem) r15.next();
        if (StringsKt.equals(r5.getPkgName(), r0, true) == false) goto L45;
        String r8 = r5.getMd5();
        if (r8 != null) goto L35;
    L36:
        String r9 = r5.getSha1();
        if (r9 != null) goto L39;
    L40:
        String r6 = r5.getSha256();
        if (r6 == null) goto L45;
        if (StringsKt.equals(r6, r2, true) != true) goto L45;
    L44:
        boolean r7 = true;
    L46:
        if (r7 == false) goto L29;
        boolean r16 = true;
    L48:
        if (r16 == false) goto L50;
        return null;
    L50:
        List<PkgSignItem> r17 = r11;
        if ((r17 instanceof Collection) == true) goto L53;
    L55:
        Iterator<T> r18 = r17.iterator();
    L57:
        if (r18.hasNext() == false) goto L54;
        PkgSignItem r19 = (PkgSignItem) r18.next();
        if (r19.isBlacklist() == false) goto L61;
    L73:
        boolean r20 = false;
    L74:
        if (r20 == false) goto L57;
        boolean r110 = true;
    L76:
        if (r110 == false) goto L78;
        return null;
    L78:
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r17.iterator();
    L80:
        if (r112.hasNext() == false) goto L99;
        Object r21 = r112.next();
        PkgSignItem r22 = (PkgSignItem) r21;
        if (r22.isBlacklist() == true) goto L84;
    L96:
        boolean r23 = false;
    L97:
        if (r23 == false) goto L80;
        r111.add(r21);
        goto L80
    L84:
        if (StringsKt.equals(r22.getPkg(), r0, true) == false) goto L88;
        if (StringsKt.equals(r22.getTmd5(), r3, true) == false) goto L88;
    L95:
        r23 = true;
    L88:
        if (StringsKt.equals(r22.getPkg(), r0, true) == false) goto L92;
        if (StringsKt.equals(r22.getTsha1(), r4, true) == true) goto L95;
    L92:
        if (StringsKt.equals(r22.getPkg(), r0, true) == false) goto L96;
        if (StringsKt.equals(r22.getTsha256(), r2, true) == false) goto L96;
    L99:
        Iterator r113 = r111.iterator();
        if (r113.hasNext() == false) goto L118;
        r1 = r113.next();
        if (r113.hasNext() == false) goto L118;
        String r114 = ((PkgSignItem) r1).getTimestamp();
        if (r114 != null) goto L108;
        r114 = "0000:00:00";
    L108:
        String r115 = r114;
    L109:
        Object r24 = r113.next();
        String r25 = ((PkgSignItem) r24).getTimestamp();
        if (r25 != null) goto L112;
        r25 = "0000:00:00";
    L112:
        String r26 = r25;
        if (r115.compareTo(r26) >= 0) goto L116;
        r1 = r24;
        r115 = r26;
    L116:
        if (r113.hasNext() == true) goto L109;
    L118:
        return (PkgSignItem) r1;
    L61:
        if (StringsKt.equals(r19.getPkg(), r0, true) == false) goto L65;
        if (StringsKt.equals(r19.getTmd5(), r3, true) == false) goto L65;
    L72:
        r20 = true;
    L65:
        if (StringsKt.equals(r19.getPkg(), r0, true) == false) goto L69;
        if (StringsKt.equals(r19.getTsha1(), r4, true) == true) goto L72;
    L69:
        if (StringsKt.equals(r19.getPkg(), r0, true) == false) goto L73;
        if (StringsKt.equals(r19.getTsha256(), r2, true) == false) goto L73;
    L54:
        r110 = false;
        goto L76
    L53:
        if (r17.isEmpty() == false) goto L55;
    L39:
        if (StringsKt.equals(r9, r4, true) == true) goto L44;
    L35:
        if (StringsKt.equals(r8, r3, true) == true) goto L44;
    L45:
        r7 = false;
    L26:
        r16 = false;
        goto L48
    L25:
        if (r14.isEmpty() == false) goto L27;
    L137:
        return null;
    L136:
        return null;
    }
}
