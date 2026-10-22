package com.obric.matrix.platform.sdk.ones.account.api;

import kotlin.Metadata;

/* JADX INFO: compiled from: AccountDef.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/AccountDef;", "", "LogoutScene", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AccountDef {

    /* JADX INFO: compiled from: AccountDef.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/AccountDef$LogoutScene;", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LogoutScene {
        public static final int CANCEL_ACCOUNT_LOGOUT = 2;
        public static final Companion Companion = null;
        public static final int FRONTIER_LOGOUT = 4;
        public static final int OTHER_LOGOUT = 3;
        public static final int SESSION_LOGOUT = 1;
        public static final int USER_LOGOUT = 0;

        /* JADX INFO: compiled from: AccountDef.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/AccountDef$LogoutScene$Companion;", "", "()V", "CANCEL_ACCOUNT_LOGOUT", "", "FRONTIER_LOGOUT", "OTHER_LOGOUT", "SESSION_LOGOUT", "USER_LOGOUT", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int CANCEL_ACCOUNT_LOGOUT = 2;
            public static final int FRONTIER_LOGOUT = 4;
            public static final int OTHER_LOGOUT = 3;
            public static final int SESSION_LOGOUT = 1;
            public static final int USER_LOGOUT = 0;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }
}
