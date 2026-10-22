package com.obric.safecheck.service.checker;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.PhoneDao;
import com.obric.safecheck.database.entity.PhoneItem;
import com.obric.safecheck.service.UniversalPhoneNumberFormatter;
import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;
import com.obric.security.safecheckapi.CheckResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AntiFraudPhoneChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/safecheck/service/checker/AntiFraudPhoneChecker;", "Lcom/obric/safecheck/service/checker/PhoneAntiFraudChecker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "check", "", "Lcom/obric/security/safecheckapi/CheckResult;", "phoneNumbers", "", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AntiFraudPhoneChecker implements PhoneAntiFraudChecker {
    private final Context context;

    public AntiFraudPhoneChecker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.obric.safecheck.service.checker.PhoneAntiFraudChecker
    public List<CheckResult> check(List<String> r14) {
        OLog.d("AntiFraudPhoneChecker", "check");
        AntiFraudDatabase r13 = AntiFraudDatabase.getDatabase(this.context);
        Intrinsics.checkNotNullExpressionValue(r13, "AntiFraudDatabase.getDatabase(context)");
        PhoneDao r15 = r13.phoneDao();
        Intrinsics.checkNotNullExpressionValue(r15, "db.phoneDao()");
        ArrayList r0 = new ArrayList();
        if (r14 != null) goto L5;
        r14 = CollectionsKt.emptyList();
    L5:
        Iterator<String> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L12;
        String r1 = r16.next();
        String r2 = UniversalPhoneNumberFormatter.getPureCoreDigitNumber(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "pureNumber");
        PhoneItem r3 = r15.getPhoneItemByNumber(EncryptPhoneToMd5Kt.calculateMD5(r2));
        CheckResult r12 = new CheckResult(null, false, null, null, null, null, 63, null);
        r12.setCheckType(CheckResult.TYPE_PHONE);
        r12.setSource(r1);
        if (r3 == null) goto L11;
        r12.setBlacklisted(r3.isBlacklist());
        r12.setThreatType(CheckResult.THREAT_FRAUD);
    L11:
        r0.add(r12);
        goto L7
    L12:
        return r0;
    }
}
