package com.obric.safecheck.service.checker;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.UrlDomainDao;
import com.obric.safecheck.database.entity.UrlDomainItem;
import com.obric.safecheck.util.serviceutil.UrlDomainParser;
import com.obric.safecheck.util.serviceutil.UrlMatch;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.TrackUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AntiFraudUrlChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/safecheck/service/checker/AntiFraudUrlChecker;", "Lcom/obric/safecheck/service/checker/UrlAntiFraudChecker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addDomainAndWwwVariant", "", "candidates", "", "", "domain", "buildDomainQueryCandidates", "", "parsedDomain", "check", "Lcom/obric/security/safecheckapi/CheckResult;", "urls", "", "getByDomainWithFallback", "Lcom/obric/safecheck/database/entity/UrlDomainItem;", "urlDomainDao", "Lcom/obric/safecheck/database/dao/UrlDomainDao;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AntiFraudUrlChecker implements UrlAntiFraudChecker {
    private final Context context;

    public AntiFraudUrlChecker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.obric.safecheck.service.checker.UrlAntiFraudChecker
    public List<CheckResult> check(List<String> r21) {
        OLog.d("AntiFraudUrlChecker", "check");
        List<String> r1 = UrlMatch.mathUrl(r21);
        AntiFraudDatabase r3 = AntiFraudDatabase.getDatabase(this.context);
        Intrinsics.checkNotNullExpressionValue(r3, "AntiFraudDatabase.getDatabase(context)");
        UrlDomainDao r4 = r3.urlDomainDao();
        Intrinsics.checkNotNullExpressionValue(r4, "db.urlDomainDao()");
        ArrayList r5 = new ArrayList();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L20;
        String r6 = r2.next();
        String r7 = UrlDomainParser.parseDomainFromUrl$default(UrlDomainParser.INSTANCE, r6, false, 2, null);
        UrlDomainItem r8 = getByDomainWithFallback(r4, r7);
        CheckResult r15 = new CheckResult(null, false, null, null, null, null, 63, null);
        r15.setCheckType(CheckResult.TYPE_URL);
        Intrinsics.checkNotNullExpressionValue(r6, "url");
        r15.setSource(r6);
        if (r8 == null) goto L13;
        r15.setBlacklisted(r8.isBlacklist());
        if (r8.isBlacklist() == false) goto L13;
        r15.setThreatType(CheckResult.THREAT_FRAUD);
    L13:
        OLog.d("AntiFraudUrlChecker", "check url=" + r6 + ", domain=" + r7 + ", isBlacklisted=" + r15.isBlacklisted());
        TrackUtils r11 = TrackUtils.INSTANCE;
        Pair[] r9 = new Pair[2];
        if (r8 != null) goto L16;
    L18:
        String r10 = "none";
    L19:
        r9[0] = TuplesKt.to("risk_level", r10);
        r9[1] = TuplesKt.to("url", r6);
        TrackUtils.trackEvent$default(r11, "anti_fraud_url_check", MapsKt.mapOf(r9), false, 4, null);
        r5.add(r15);
        goto L7
    L16:
        if (r8.isBlacklist() != true) goto L18;
        r10 = "high";
        goto L19
    L20:
        return r5;
    }

    private final UrlDomainItem getByDomainWithFallback(UrlDomainDao r1, String r2) {
        Iterator<String> r0 = buildDomainQueryCandidates(r2).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UrlDomainItem r3 = r1.getByDomain(r0.next());
        if (r3 == null) goto L4;
        return r3;
    L8:
        return null;
    }

    private final List<String> buildDomainQueryCandidates(String r3) {
        if (StringsKt.isBlank(r3) == true) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        addDomainAndWwwVariant(r0, r3);
        ArrayList r2 = new ArrayList();
        Iterator r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Object r1 = r4.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L8;
        r2.add(r1);
        goto L8
    L13:
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    private final void addDomainAndWwwVariant(Set<String> r6, String r7) {
        String r5 = r7;
        if (StringsKt.isBlank(r5) == false) goto L5;
        return;
    L5:
        r6.add(r7);
        if (StringsKt.startsWith$default(r7, "www.", false, 2, null) == false) goto L9;
        r6.add(StringsKt.removePrefix(r7, "www."));
        return;
    L9:
        if (StringsKt.contains$default(r5, '.', false, 2, null) == false) goto L13;
        r6.add("www." + r7);
        return;
    }
}
