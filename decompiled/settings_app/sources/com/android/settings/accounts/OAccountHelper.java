package com.android.settings.accounts;

import android.content.Context;
import android.content.Intent;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.platform.sdk.ones.account.AccountException;
import com.obric.matrix.platform.sdk.ones.account.AccountInfo;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.olog.OLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAccountHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J]\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u0004*\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/settings/accounts/OAccountHelper;", "", "()V", "TAG", "", AccountConst.METHOD_GET_ACCOUNT_INFO, "Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "isLogin", "", "logout", "", "onSuccessAction", "Lkotlin/Function0;", "onFailedAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "prepareAccountLaunchIntent", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registerAccountListener", "masked", "maskedChar", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OAccountHelper {
    public static final OAccountHelper INSTANCE = null;
    private static final String TAG = "OAccountHelper";

    static {
        INSTANCE = new OAccountHelper();
    }

    private OAccountHelper() {
    }

    @JvmStatic
    public static final boolean isLogin() {
        return OAccount.INSTANCE.isLogin(true);
    L4:
        e = move-exception;
        OLog.e(TAG, "isLogin error", e);
        return false;
    }

    @JvmStatic
    public static final AccountInfo getAccountInfo() {
        return OAccount.INSTANCE.accountInfo(true);
    L4:
        e = move-exception;
        OLog.e(TAG, "get account info error", e);
        return null;
    }

    public static /* synthetic */ Unit logout$default(Function0 r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return logout(r1, r2);
    }

    @JvmStatic
    public static final Unit logout(Function0<Unit> r3, Function2<? super Integer, ? super String, Unit> r4) {
        OAccount.INSTANCE.logout(r3, r4);     // Catch: AccountException -> L4
        return Unit.INSTANCE;
    L4:
        e = move-exception;
        OLog.e(TAG, "logout error", e);
        if (r4 == null) goto L11;
        String r5 = e.getMessage();
        if (r5 != null) goto L10;
        r5 = "logout failed";
    L10:
        r4.invoke(-1, r5);
        return Unit.INSTANCE;
    L11:
        return null;
    }

    @JvmStatic
    public static final Object prepareAccountLaunchIntent(Context r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        OAccount.INSTANCE.accountLaunchIntent(r3, r4);     // Catch: AccountException -> L8
        OLog.i(TAG, "prepareAccountLaunchIntent, isLogin=" + OAccount.INSTANCE.isLogin(true));     // Catch: AccountException -> L8
        if (OAccount.INSTANCE.isLogin(true) == false) goto L6;
        r4.removeFlags(268435456);     // Catch: AccountException -> L8
        Object r5 = Unit.INSTANCE;     // Catch: AccountException -> L8
    L11:
        return r5;
    L6:
        r5 = r4.addFlags(268435456);     // Catch: AccountException -> L8
        Intrinsics.checkNotNull(r5);     // Catch: AccountException -> L8
    L8:
        e = move-exception;
        OLog.e(TAG, "prepareAccountLaunchIntent error", e);
        return Unit.INSTANCE;
    }

    public final void registerAccountListener(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OAccount.INSTANCE.addAccountStatusListener(new AnonymousClass1());     // Catch: AccountException -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "registerAccountListener error", e);
    }

    public static /* synthetic */ String masked$default(OAccountHelper r0, String r1, char r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = '*';
    L6:
        return r0.masked(r1, r2);
    }

    public final String masked(String r11, char r12) {
        if (r11 == null) goto L24;
        String r13 = r11;
        ArrayList r0 = new ArrayList(r13.length());
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r13.length()) goto L16;
        char r4 = r13.charAt(r2);
        int r5 = r3 + 1;
        if (3 <= r3) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L15;
        r4 = r12;
    L15:
        r0.add(Character.valueOf(r4));
        r2 = r2 + 1;
        r3 = r5;
        goto L6
    L10:
        if (r3 >= 9) goto L12;
        r6 = true;
        goto L13
    L16:
        String r14 = CollectionsKt.joinToString$default(r0, "", null, null, 0, null, null, 62, null);
        if (r14 != null) goto L20;
        return "";
    L20:
        return r14;
    L24:
        return "";
    }
}
