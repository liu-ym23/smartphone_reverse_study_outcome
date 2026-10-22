package com.bytedanceos.securitycenter;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.platform.sdk.ones.account.IAccountService;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountSdkInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedanceos/securitycenter/AccountSdkInitializer;", "", "()V", "TAG", "", "init", "", "application", "Landroid/app/Application;", "AccountBridge", "AccountLogger", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AccountSdkInitializer {
    public static final AccountSdkInitializer INSTANCE = null;
    private static final String TAG = "AccountSdkInitializer";

    /* JADX INFO: compiled from: AccountSdkInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedanceos/securitycenter/AccountSdkInitializer$AccountBridge;", "Lcom/obric/matrix/platform/sdk/ones/account/api/IAccountBridge;", "()V", "addTokenHost", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onBind", "", "binder", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "onDisconnect", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class AccountBridge implements IAccountBridge {
        public static final AccountBridge INSTANCE = null;

        static {
            INSTANCE = new AccountBridge();
        }

        private AccountBridge() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
        public void onBind(IAccountService r1) {
            Intrinsics.checkNotNullParameter(r1, "binder");
            OLog.i(AccountSdkInitializer.TAG, "account service bound");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
        public void onDisconnect() {
            OLog.w(AccountSdkInitializer.TAG, "account service disconnected");
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.IAccountBridge
        public ArrayList<String> addTokenHost() {
            return new ArrayList();
        }
    }

    /* JADX INFO: compiled from: AccountSdkInitializer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedanceos/securitycenter/AccountSdkInitializer$AccountLogger;", "Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;", "()V", DayFormatter.DEFAULT_FORMAT, "", PushLog.KEY_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", BaseSwitches.V, "w", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class AccountLogger implements ILogger {
        public static final AccountLogger INSTANCE = null;

        static {
            INSTANCE = new AccountLogger();
        }

        private AccountLogger() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void v(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            OLog.v(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void d(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            OLog.d(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void i(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            OLog.i(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            OLog.w(r1, r2, r3);
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
        public void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            OLog.e(r1, r2, r3);
        }
    }

    static {
        INSTANCE = new AccountSdkInitializer();
    }

    private AccountSdkInitializer() {
    }

    public final void init(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AccountSdkInitializer r2 = this;     // Catch: Throwable -> L5
        OAccount.INSTANCE.init(r3, AccountLogger.INSTANCE, AccountBridge.INSTANCE);     // Catch: Throwable -> L5
        Object r4 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        OLog.e(TAG, "init account sdk failed", r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
