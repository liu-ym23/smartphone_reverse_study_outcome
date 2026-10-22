package com.obric.securitycenter.nodisturb.checker;

import android.content.Context;
import android.text.TextUtils;
import com.obric.olog.OLog;
import com.obric.security.nodisturbapi.InterceptResult;
import com.obric.security.nodisturbapi.SmsData;
import com.obric.securitycenter.nodisturb.manager.BlackListManager;
import com.obric.securitycenter.nodisturb.manager.KeywordMatcher;
import com.obric.securitycenter.nodisturb.manager.SmsBodyCheckManager;
import com.obric.securitycenter.nodisturb.manager.WhiteListManager;
import com.obric.securitycenter.nodisturb.utils.EncryptToMd5Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CnSmsBlockChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/securitycenter/nodisturb/checker/CnSmsBlockChecker;", "Lcom/obric/securitycenter/nodisturb/checker/SmsBlockChecker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blackListManager", "Lcom/obric/securitycenter/nodisturb/manager/BlackListManager;", "keywordMatcher", "Lcom/obric/securitycenter/nodisturb/manager/KeywordMatcher;", "smsBodyCheckManager", "Lcom/obric/securitycenter/nodisturb/manager/SmsBodyCheckManager;", "whiteListManager", "Lcom/obric/securitycenter/nodisturb/manager/WhiteListManager;", "check", "Lcom/obric/security/nodisturbapi/InterceptResult;", "ruleMask", "", "smsData", "Lcom/obric/security/nodisturbapi/SmsData;", "onDestroy", "", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CnSmsBlockChecker implements SmsBlockChecker {
    public static final Companion Companion = null;
    private static final String TAG = "CnSmsBlockChecker";
    private final BlackListManager blackListManager;
    private final Context context;
    private final KeywordMatcher keywordMatcher;
    private final SmsBodyCheckManager smsBodyCheckManager;
    private final WhiteListManager whiteListManager;

    /* JADX INFO: compiled from: CnSmsBlockChecker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/checker/CnSmsBlockChecker$Companion;", "", "()V", "TAG", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CnSmsBlockChecker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.whiteListManager = new WhiteListManager();
        this.blackListManager = new BlackListManager();
        this.smsBodyCheckManager = new SmsBodyCheckManager();
        this.keywordMatcher = new KeywordMatcher();
    }

    @Override // com.obric.securitycenter.nodisturb.checker.SmsBlockChecker
    public InterceptResult check(int r11, SmsData r12) {
        Intrinsics.checkNotNullParameter(r12, "smsData");
        InterceptResult r0 = new InterceptResult();
        if (r11 != 0) goto L7;
        OLog.w(TAG, "checkSmsIntercept skip: ruleMask=0");
        return r0;
    L7:
        if ((r11 & 1) == 0) goto L13;
        WhiteListManager r2 = this.whiteListManager;
        String r4 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r4, "smsData.address");
        boolean r3 = r2.isInWhiteList(r4);
        r0.setHitWhiteList(r3);
        if (r3 == false) goto L13;
        String r10 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r10, "smsData.address");
        OLog.d(TAG, "checkSmsIntercept hit white list, addressMd5=" + EncryptToMd5Kt.calculateMD5(r10));
        r0.setNeedIntercept(false);
        return r0;
    L13:
        if ((r11 & 2) == 0) goto L19;
        BlackListManager r5 = this.blackListManager;
        String r6 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r6, "smsData.address");
        long r7 = r5.isInBlackList(r6);
        if (r7 < 0) goto L19;
        String r13 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r13, "smsData.address");
        OLog.d(TAG, "checkSmsIntercept hit black list, blackListId=" + r7 + ", addressMd5=" + EncryptToMd5Kt.calculateMD5(r13));
        r0.setHitBlackList(true);
        r0.setBlackListId(r7);
        r0.setNeedIntercept(true);
        return r0;
    L19:
        if ((r11 & 16) == 0) goto L25;
        KeywordMatcher r8 = this.keywordMatcher;
        String r9 = r12.body;
        Intrinsics.checkNotNullExpressionValue(r9, "smsData.body");
        String r14 = r8.matchFirst(r9);
        String r15 = r14;
        OLog.d(TAG, "checkSmsIntercept isContainKeyWord = " + (!TextUtils.isEmpty(r15)));
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r0.addHitSmsKeyword(r14);
        r0.setNeedIntercept(true);
        return r0;
    L25:
        if ((r11 & 8) == 0) goto L29;
        SmsBodyCheckManager r16 = this.smsBodyCheckManager;
        Context r17 = this.context;
        String r18 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r18, "smsData.address");
        int r19 = r16.checkMessageRisk(r17, r18, r12.body);
        if (r19 <= 0) goto L29;
        String r110 = r12.address;
        Intrinsics.checkNotNullExpressionValue(r110, "smsData.address");
        OLog.d(TAG, "checkSmsIntercept hit risk level, riskLevel=" + r19 + ", addressMd5=" + EncryptToMd5Kt.calculateMD5(r110));
        r0.setNeedIntercept(true);
        r0.setSmsRiskLevel(r19);
    L29:
        return r0;
    }

    @Override // com.obric.securitycenter.nodisturb.checker.SmsBlockChecker
    public void onDestroy() {
        this.smsBodyCheckManager.onDestroy();
    }
}
