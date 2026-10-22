package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AccountInfoBundleKey {

    @NotNull
    public static final String AVATAR_URL = "avatarUrl";

    @NotNull
    public static final String COUNTRY_CODE = "countryCode";

    @NotNull
    public static final String HAS_PASSWORD = "hasPassword";

    @NotNull
    public static final String INNER_SSO_TOKEN = "innerSsoToken";

    @NotNull
    public static final AccountInfoBundleKey INSTANCE = null;

    @NotNull
    public static final String IS_NEW_USER = "isNewUser";

    @NotNull
    public static final String LOGIN_PHONE_NUMBER = "loginPhoneNumber";

    @NotNull
    public static final String LOGIN_STATE = "loginState";

    @NotNull
    public static final String LOGIN_UTC_TIME = "loginUtcTime";

    @NotNull
    public static final String LOGOUT_SCENE = "logoutScene";

    @NotNull
    public static final String ODIN_USER_TYPE = "odinUserType";

    @NotNull
    public static final String SCREEN_NAME = "screenName";

    @NotNull
    public static final String SEC_USER_ID = "secUserId";

    @NotNull
    public static final String TOKEN = "token";

    @NotNull
    public static final String USER_EMAIL = "userEmail";

    @NotNull
    public static final String USER_GENDER = "userGender";

    @NotNull
    public static final String USER_ID = "userId";

    @NotNull
    public static final String USER_MOBILE = "userMobile";

    @NotNull
    public static final String USER_NAME = "userName";

    @NotNull
    public static final String USER_SESSION = "userSession";

    static {
        INSTANCE = new AccountInfoBundleKey();
    }

    private AccountInfoBundleKey() {
    }
}
