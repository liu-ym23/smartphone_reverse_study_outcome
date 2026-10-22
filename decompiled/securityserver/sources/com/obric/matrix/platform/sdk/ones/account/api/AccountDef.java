package com.obric.matrix.platform.sdk.ones.account.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface AccountDef {

    @Metadata
    public interface LogoutScene {
        public static final int CANCEL_ACCOUNT_LOGOUT = 2;

        @NotNull
        public static final Companion Companion = null;
        public static final int FRONTIER_LOGOUT = 4;
        public static final int OTHER_LOGOUT = 3;
        public static final int SESSION_LOGOUT = 1;
        public static final int USER_LOGOUT = 0;

        @Metadata
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
