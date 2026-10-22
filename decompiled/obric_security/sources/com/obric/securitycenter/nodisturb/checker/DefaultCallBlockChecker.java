package com.obric.securitycenter.nodisturb.checker;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.security.nodisturbapi.InterceptResult;
import com.obric.security.nodisturbapi.PhoneType;
import com.obric.securitycenter.nodisturb.manager.BlackListManager;
import com.obric.securitycenter.nodisturb.manager.NumberCheckManager;
import com.obric.securitycenter.nodisturb.manager.WhiteListManager;
import com.obric.securitycenter.nodisturb.utils.EncryptToMd5Kt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DefaultCallBlockChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/securitycenter/nodisturb/checker/DefaultCallBlockChecker;", "Lcom/obric/securitycenter/nodisturb/checker/CallBlockChecker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blackListManager", "Lcom/obric/securitycenter/nodisturb/manager/BlackListManager;", "numberCheckManager", "Lcom/obric/securitycenter/nodisturb/manager/NumberCheckManager;", "whiteListManager", "Lcom/obric/securitycenter/nodisturb/manager/WhiteListManager;", "check", "Lcom/obric/security/nodisturbapi/InterceptResult;", "ruleMask", "", "target", "", "onDestroy", "", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultCallBlockChecker implements CallBlockChecker {
    public static final Companion Companion = null;
    private static final String TAG = "DefaultCallBlockChecker";
    private final BlackListManager blackListManager;
    private final NumberCheckManager numberCheckManager;
    private final WhiteListManager whiteListManager;

    /* JADX INFO: compiled from: DefaultCallBlockChecker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/checker/DefaultCallBlockChecker$Companion;", "", "()V", "TAG", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public DefaultCallBlockChecker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.whiteListManager = new WhiteListManager();
        this.blackListManager = new BlackListManager();
        this.numberCheckManager = new NumberCheckManager(r2);
    }

    @Override // com.obric.securitycenter.nodisturb.checker.CallBlockChecker
    public InterceptResult check(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "target");
        InterceptResult r0 = new InterceptResult();
        if (r10 != 0) goto L5;
    L25:
        OLog.w(TAG, "checkCallIntercept skip: ruleMask=" + r10 + ", targetBlank=" + StringsKt.isBlank(r11));
        return r0;
    L5:
        if (StringsKt.isBlank(r11) == true) goto L25;
        if ((r10 & 1) == 0) goto L14;
        boolean r2 = this.whiteListManager.isInWhiteList(r11);
        r0.setHitWhiteList(r2);
        if (r2 == false) goto L14;
        OLog.d(TAG, "checkCallIntercept hit white list, targetMd5=" + EncryptToMd5Kt.calculateMD5(r11));
        r0.setNeedIntercept(false);
        return r0;
    L14:
        if ((r10 & 2) == 0) goto L20;
        long r5 = this.blackListManager.isInBlackList(r11);
        if (r5 < 0) goto L20;
        OLog.d(TAG, "checkCallIntercept hit black list, blackListId=" + r5 + ", targetMd5=" + EncryptToMd5Kt.calculateMD5(r11));
        r0.setHitBlackList(true);
        r0.setBlackListId(r5);
        r0.setNeedIntercept(true);
        return r0;
    L20:
        if ((r10 & 4) == 0) goto L24;
        int r9 = this.numberCheckManager.queryNumberMarkClassify(r11);
        OLog.d(TAG, "checkCallIntercept numberMarkClassify = " + r9);
        int r12 = PhoneType.getMatchedValidType(r9);
        if (r12 == (-1)) goto L24;
        OLog.d(TAG, "checkCallIntercept hit phone type, phoneType=" + r12 + ", targetMd5=" + EncryptToMd5Kt.calculateMD5(r11));
        r0.setNeedIntercept(true);
        r0.setPhoneType(r12);
    L24:
        return r0;
    }

    @Override // com.obric.securitycenter.nodisturb.checker.CallBlockChecker
    public void onDestroy() {
        this.numberCheckManager.onDestroy();
    }
}
