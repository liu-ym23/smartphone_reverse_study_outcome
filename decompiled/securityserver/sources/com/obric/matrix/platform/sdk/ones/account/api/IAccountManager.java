package com.obric.matrix.platform.sdk.ones.account.api;

import com.obric.matrix.platform.sdk.ones.account.AccountInfo;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IAccountManager {

    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ void updateAccountInfoAsync$default(IAccountManager r0, IUpdateAccountInfoCallback r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.updateAccountInfoAsync(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAccountInfoAsync");
        }

        public static /* synthetic */ void updateXttTokenMapAsync$default(IAccountManager r0, IUpdateTokenMapCallback r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            r0.updateXttTokenMapAsync(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateXttTokenMapAsync");
        }
    }

    @NotNull
    AccountInfo accountInfo();

    void addAccountStatusListener(@NotNull IAccountStatusListener r1);

    void init(boolean r1);

    @NotNull
    String innerToken();

    boolean isLogin();

    int logoutScene();

    void removeAccountStatusListener(@NotNull IAccountStatusListener r1);

    void setLoginPhoneNumber(@NotNull String r1);

    void updateAccountInfo();

    void updateAccountInfoAsync(@Nullable IUpdateAccountInfoCallback r1);

    void updateXttTokenMap();

    void updateXttTokenMapAsync(@Nullable IUpdateTokenMapCallback r1);

    @NotNull
    Map<String, String> xttTokenMap();
}
