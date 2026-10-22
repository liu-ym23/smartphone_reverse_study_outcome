package com.obric.matrix.account.provider;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\t"}, d2 = {"Lcom/obric/matrix/account/provider/CommandReceiver;", "", "()V", "onLogin", "Landroid/os/Bundle;", "args", "onLogout", "sendCode", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0225a f8611a = null;

    /* JADX INFO: renamed from: com.obric.matrix.account.provider.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/account/provider/CommandReceiver$Companion;", "", "()V", "CODE", "", "CODE_PARAMS_ERROR", "", "CODE_TIME_OUT", "COMMAND_EXCEPTION", "COMMAND_FAILED", "COMMAND_UNSUPPORTED", "KEY_CODE", "KEY_MESSAGE", "MESSAGE_ALREADY_LOGIN", "MESSAGE_Exception", "MESSAGE_NO_NEED_LOGOUT", "MESSAGE_TIME_OUT", "MESSAGE_UNSUPPORTED_METHOD", "PHONE", "SUCCESS_CODE", "SUCCESS_MSG", "TIME_OUT", "", "commandFailed", "Landroid/os/Bundle;", "code", "onFailed", NotificationCompat.CATEGORY_MESSAGE, "paramsEmpty", "unsupportedCommandFailed", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0225a {
        private C0225a() {
        }

        public /* synthetic */ C0225a(g r1) {
            this();
        }

        private final Bundle b(int r2, String r3) {
            Bundle r1 = new Bundle();
            r1.putInt("code", r2);
            r1.putString("errorMsg", r3);
            return r1;
        }

        public final Bundle a(int r2) {
            return b(r2, "command failed");
        }

        public final Bundle c() {
            return b(-2, "unsupported method");
        }
    }

    static {
        f8611a = new C0225a(null);
    }
}
