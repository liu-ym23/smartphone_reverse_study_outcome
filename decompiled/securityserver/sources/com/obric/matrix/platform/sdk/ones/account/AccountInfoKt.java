package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AccountInfoKt {
    @NotNull
    public static final AccountInfo fromBundle(@NotNull AccountInfo r5, @NotNull Bundle r6) {
        Intrinsics.f(r5, "<this>");
        Intrinsics.f(r6, "bundle");
        r5.setLoginState(r6.getBoolean(AccountInfoBundleKey.LOGIN_STATE, false));
        r5.setLogoutScene(r6.getInt(AccountInfoBundleKey.LOGOUT_SCENE, 0));
        String r0 = r6.getString(AccountInfoBundleKey.SEC_USER_ID, "");
        Intrinsics.e(r0, "bundle.getString(Account…undleKey.SEC_USER_ID, \"\")");
        r5.setSecUserId(r0);
        String r1 = r6.getString(AccountInfoBundleKey.USER_ID, "");
        Intrinsics.e(r1, "bundle.getString(AccountInfoBundleKey.USER_ID, \"\")");
        r5.setUserId(r1);
        r5.setOdinUserType(r6.getInt(AccountInfoBundleKey.ODIN_USER_TYPE, 0));
        String r2 = r6.getString(AccountInfoBundleKey.TOKEN, "");
        Intrinsics.e(r2, "bundle.getString(AccountInfoBundleKey.TOKEN, \"\")");
        r5.setXTTToken(r2);
        String r3 = r6.getString(AccountInfoBundleKey.INNER_SSO_TOKEN, "");
        Intrinsics.e(r3, "bundle.getString(Account…eKey.INNER_SSO_TOKEN, \"\")");
        r5.setInnerSSOToken(r3);
        String r4 = r6.getString(AccountInfoBundleKey.AVATAR_URL, "");
        Intrinsics.e(r4, "bundle.getString(Account…BundleKey.AVATAR_URL, \"\")");
        r5.setAvatarUrl(r4);
        r5.setCountryCode(r6.getInt(AccountInfoBundleKey.COUNTRY_CODE, 86));
        String r7 = r6.getString(AccountInfoBundleKey.USER_NAME, "");
        Intrinsics.e(r7, "bundle.getString(Account…oBundleKey.USER_NAME, \"\")");
        r5.setUserName(r7);
        String r8 = r6.getString(AccountInfoBundleKey.SCREEN_NAME, "");
        Intrinsics.e(r8, "bundle.getString(Account…undleKey.SCREEN_NAME, \"\")");
        r5.setScreenName(r8);
        String r9 = r6.getString(AccountInfoBundleKey.USER_EMAIL, "");
        Intrinsics.e(r9, "bundle.getString(Account…BundleKey.USER_EMAIL, \"\")");
        r5.setUserEmail(r9);
        String r10 = r6.getString(AccountInfoBundleKey.USER_MOBILE, "");
        Intrinsics.e(r10, "bundle.getString(Account…undleKey.USER_MOBILE, \"\")");
        r5.setUserMobile(r10);
        r5.setHasPassword(r6.getBoolean(AccountInfoBundleKey.HAS_PASSWORD, false));
        r5.setUserGender(r6.getInt(AccountInfoBundleKey.USER_GENDER, 0));
        r5.setNewUser(r6.getBoolean(AccountInfoBundleKey.IS_NEW_USER, false));
        String r11 = r6.getString(AccountInfoBundleKey.USER_SESSION, "");
        Intrinsics.e(r11, "bundle.getString(Account…ndleKey.USER_SESSION, \"\")");
        r5.setUserSession(r11);
        r5.setLoginUtcTime(r6.getLong(AccountInfoBundleKey.LOGIN_UTC_TIME, 0));
        String r12 = r6.getString(AccountInfoBundleKey.LOGIN_PHONE_NUMBER, "");
        Intrinsics.e(r12, "bundle.getString(Account…y.LOGIN_PHONE_NUMBER, \"\")");
        r5.setLoginPhoneNumber(r12);
        return r5;
    }

    @NotNull
    public static final Bundle toBundle(@NotNull AccountInfo r4) {
        Intrinsics.f(r4, "<this>");
        Bundle r0 = new Bundle();
        r0.putBoolean(AccountInfoBundleKey.LOGIN_STATE, r4.getLoginState());
        r0.putInt(AccountInfoBundleKey.LOGOUT_SCENE, r4.getLogoutScene());
        r0.putString(AccountInfoBundleKey.SEC_USER_ID, r4.getSecUserId());
        r0.putString(AccountInfoBundleKey.USER_ID, r4.getUserId());
        r0.putInt(AccountInfoBundleKey.ODIN_USER_TYPE, r4.getOdinUserType());
        r0.putString(AccountInfoBundleKey.TOKEN, r4.getXTTToken());
        r0.putString(AccountInfoBundleKey.INNER_SSO_TOKEN, r4.getInnerSSOToken());
        r0.putString(AccountInfoBundleKey.AVATAR_URL, r4.getAvatarUrl());
        r0.putInt(AccountInfoBundleKey.COUNTRY_CODE, r4.getCountryCode());
        r0.putString(AccountInfoBundleKey.USER_NAME, r4.getUserName());
        r0.putString(AccountInfoBundleKey.SCREEN_NAME, r4.getScreenName());
        r0.putString(AccountInfoBundleKey.USER_EMAIL, r4.getUserEmail());
        r0.putString(AccountInfoBundleKey.USER_MOBILE, r4.getUserMobile());
        r0.putBoolean(AccountInfoBundleKey.HAS_PASSWORD, r4.getHasPassword());
        r0.putInt(AccountInfoBundleKey.USER_GENDER, r4.getUserGender());
        r0.putBoolean(AccountInfoBundleKey.IS_NEW_USER, r4.isNewUser());
        r0.putString(AccountInfoBundleKey.USER_SESSION, r4.getUserSession());
        r0.putLong(AccountInfoBundleKey.LOGIN_UTC_TIME, r4.getLoginUtcTime());
        r0.putString(AccountInfoBundleKey.LOGIN_PHONE_NUMBER, r4.getLoginPhoneNumber());
        return r0;
    }
}
