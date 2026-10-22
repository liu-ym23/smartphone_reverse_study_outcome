package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AccountInfo {

    @NotNull
    private String avatarUrl;
    private int countryCode;
    private boolean hasPassword;

    @NotNull
    private String innerSSOToken;
    private boolean isNewUser;

    @NotNull
    private String loginPhoneNumber;
    private boolean loginState;
    private long loginUtcTime;
    private int logoutScene;
    private int odinUserType;

    @NotNull
    private String screenName;

    @NotNull
    private String secUserId;

    @NotNull
    private String userEmail;
    private int userGender;

    @NotNull
    private String userId;

    @NotNull
    private String userMobile;

    @NotNull
    private String userName;

    @NotNull
    private String userSession;

    @NotNull
    private String xTTToken;

    public AccountInfo() {
        boolean r1 = false;
        int r2 = 0;
        String r3 = null;
        String r4 = null;
        int r5 = 0;
        String r6 = null;
        String r7 = null;
        String r8 = null;
        int r9 = 0;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        boolean r14 = false;
        int r15 = 0;
        boolean r16 = false;
        String r17 = null;
        long r18 = 0;
        String r20 = null;
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r20, 524287, null);
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo r17, boolean r18, int r19, String r20, String r21, int r22, String r23, String r24, String r25, int r26, String r27, String r28, String r29, String r30, boolean r31, int r32, boolean r33, String r34, long r35, String r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        boolean r2 = r17.loginState;
    L7:
        if ((r38 & 2) == 0) goto L9;
        int r3 = r17.logoutScene;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = r17.secUserId;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = r17.userId;
    L19:
        if ((r38 & 16) == 0) goto L21;
        int r6 = r17.odinUserType;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = r17.xTTToken;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = r17.innerSSOToken;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r9 = r17.avatarUrl;
    L35:
        if ((r38 & 256) == 0) goto L37;
        int r10 = r17.countryCode;
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r11 = r17.userName;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = r17.screenName;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r13 = r17.userEmail;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r14 = r17.userMobile;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        boolean r15 = r17.hasPassword;
    L58:
        boolean r36 = r15;
        if ((r38 & 16384) == 0) goto L61;
        int r16 = r17.userGender;
    L62:
        int r310 = r16;
        if ((r38 & 32768) == 0) goto L65;
        boolean r110 = r17.isNewUser;
    L66:
        boolean r311 = r110;
        if ((r38 & 65536) == 0) goto L69;
        String r111 = r17.userSession;
    L70:
        String r312 = r14;
        String r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        long r112 = r17.loginUtcTime;
    L75:
        if ((r38 & 262144) == 0) goto L77;
        String r1 = r17.loginPhoneNumber;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r312, r36, r310, r311, r313, r112, r1);
    L77:
        r1 = r37;
        goto L79
    L73:
        r112 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final boolean component1() {
        return this.loginState;
    }

    @NotNull
    public final String component10() {
        return this.userName;
    }

    @NotNull
    public final String component11() {
        return this.screenName;
    }

    @NotNull
    public final String component12() {
        return this.userEmail;
    }

    @NotNull
    public final String component13() {
        return this.userMobile;
    }

    public final boolean component14() {
        return this.hasPassword;
    }

    public final int component15() {
        return this.userGender;
    }

    public final boolean component16() {
        return this.isNewUser;
    }

    @NotNull
    public final String component17() {
        return this.userSession;
    }

    public final long component18() {
        return this.loginUtcTime;
    }

    @NotNull
    public final String component19() {
        return this.loginPhoneNumber;
    }

    public final int component2() {
        return this.logoutScene;
    }

    @NotNull
    public final String component3() {
        return this.secUserId;
    }

    @NotNull
    public final String component4() {
        return this.userId;
    }

    public final int component5() {
        return this.odinUserType;
    }

    @NotNull
    public final String component6() {
        return this.xTTToken;
    }

    @NotNull
    public final String component7() {
        return this.innerSSOToken;
    }

    @NotNull
    public final String component8() {
        return this.avatarUrl;
    }

    public final int component9() {
        return this.countryCode;
    }

    @NotNull
    public final AccountInfo copy(boolean r23, int r24, @NotNull String r25, @NotNull String r26, int r27, @NotNull String r28, @NotNull String r29, @NotNull String r30, int r31, @NotNull String r32, @NotNull String r33, @NotNull String r34, @NotNull String r35, boolean r36, int r37, boolean r38, @NotNull String r39, long r40, @NotNull String r42) {
        Intrinsics.f(r25, AccountInfoBundleKey.SEC_USER_ID);
        Intrinsics.f(r26, AccountInfoBundleKey.USER_ID);
        Intrinsics.f(r28, "xTTToken");
        Intrinsics.f(r29, "innerSSOToken");
        Intrinsics.f(r30, AccountInfoBundleKey.AVATAR_URL);
        Intrinsics.f(r32, AccountInfoBundleKey.USER_NAME);
        Intrinsics.f(r33, AccountInfoBundleKey.SCREEN_NAME);
        Intrinsics.f(r34, AccountInfoBundleKey.USER_EMAIL);
        Intrinsics.f(r35, AccountInfoBundleKey.USER_MOBILE);
        Intrinsics.f(r39, AccountInfoBundleKey.USER_SESSION);
        Intrinsics.f(r42, AccountInfoBundleKey.LOGIN_PHONE_NUMBER);
        return new AccountInfo(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42);
    }

    public boolean equals(@Nullable Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AccountInfo) == true) goto L8;
        return false;
    L8:
        AccountInfo r9 = (AccountInfo) r8;
        if (this.loginState == r9.loginState) goto L12;
        return false;
    L12:
        if (this.logoutScene == r9.logoutScene) goto L15;
        return false;
    L15:
        if (Intrinsics.a(this.secUserId, r9.secUserId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.a(this.userId, r9.userId) == true) goto L21;
        return false;
    L21:
        if (this.odinUserType == r9.odinUserType) goto L24;
        return false;
    L24:
        if (Intrinsics.a(this.xTTToken, r9.xTTToken) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.a(this.innerSSOToken, r9.innerSSOToken) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.a(this.avatarUrl, r9.avatarUrl) == true) goto L33;
        return false;
    L33:
        if (this.countryCode == r9.countryCode) goto L36;
        return false;
    L36:
        if (Intrinsics.a(this.userName, r9.userName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.a(this.screenName, r9.screenName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.a(this.userEmail, r9.userEmail) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.a(this.userMobile, r9.userMobile) == true) goto L48;
        return false;
    L48:
        if (this.hasPassword == r9.hasPassword) goto L51;
        return false;
    L51:
        if (this.userGender == r9.userGender) goto L54;
        return false;
    L54:
        if (this.isNewUser == r9.isNewUser) goto L57;
        return false;
    L57:
        if (Intrinsics.a(this.userSession, r9.userSession) == true) goto L60;
        return false;
    L60:
        if (this.loginUtcTime == r9.loginUtcTime) goto L63;
        return false;
    L63:
        if (Intrinsics.a(this.loginPhoneNumber, r9.loginPhoneNumber) == true) goto L65;
        return false;
    L65:
        return true;
    }

    @NotNull
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    @NotNull
    public final String getInnerSSOToken() {
        return this.innerSSOToken;
    }

    @NotNull
    public final String getLoginPhoneNumber() {
        return this.loginPhoneNumber;
    }

    public final boolean getLoginState() {
        return this.loginState;
    }

    public final long getLoginUtcTime() {
        return this.loginUtcTime;
    }

    public final int getLogoutScene() {
        return this.logoutScene;
    }

    public final int getOdinUserType() {
        return this.odinUserType;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getSecUserId() {
        return this.secUserId;
    }

    @NotNull
    public final String getUserEmail() {
        return this.userEmail;
    }

    public final int getUserGender() {
        return this.userGender;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserMobile() {
        return this.userMobile;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    public final String getUserSession() {
        return this.userSession;
    }

    @NotNull
    public final String getXTTToken() {
        return this.xTTToken;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    public int hashCode() {
        boolean r0 = this.loginState;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (this.userMobile.hashCode() + ((this.userEmail.hashCode() + ((this.screenName.hashCode() + ((this.userName.hashCode() + a.a.c(this.countryCode, (this.avatarUrl.hashCode() + ((this.innerSSOToken.hashCode() + ((this.xTTToken.hashCode() + a.a.c(this.odinUserType, (this.userId.hashCode() + ((this.secUserId.hashCode() + a.a.c(this.logoutScene, r2 * 31, 31)) * 31)) * 31, 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31)) * 31)) * 31;
        boolean r4 = this.hasPassword;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = a.a.c(this.userGender, (r3 + r5) * 31, 31);
        boolean r7 = this.isNewUser;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return this.loginPhoneNumber.hashCode() + ((Long.hashCode(this.loginUtcTime) + ((this.userSession.hashCode() + ((r6 + r1) * 31)) * 31)) * 31);
    }

    public final boolean isNewUser() {
        return this.isNewUser;
    }

    public final void setAvatarUrl(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.avatarUrl = r2;
    }

    public final void setCountryCode(int r1) {
        this.countryCode = r1;
    }

    public final void setHasPassword(boolean r1) {
        this.hasPassword = r1;
    }

    public final void setInnerSSOToken(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.innerSSOToken = r2;
    }

    public final void setLoginPhoneNumber(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.loginPhoneNumber = r2;
    }

    public final void setLoginState(boolean r1) {
        this.loginState = r1;
    }

    public final void setLoginUtcTime(long r1) {
        this.loginUtcTime = r1;
    }

    public final void setLogoutScene(int r1) {
        this.logoutScene = r1;
    }

    public final void setNewUser(boolean r1) {
        this.isNewUser = r1;
    }

    public final void setOdinUserType(int r1) {
        this.odinUserType = r1;
    }

    public final void setScreenName(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.screenName = r2;
    }

    public final void setSecUserId(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.secUserId = r2;
    }

    public final void setUserEmail(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.userEmail = r2;
    }

    public final void setUserGender(int r1) {
        this.userGender = r1;
    }

    public final void setUserId(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.userId = r2;
    }

    public final void setUserMobile(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.userMobile = r2;
    }

    public final void setUserName(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.userName = r2;
    }

    public final void setUserSession(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.userSession = r2;
    }

    public final void setXTTToken(@NotNull String r2) {
        Intrinsics.f(r2, "<set-?>");
        this.xTTToken = r2;
    }

    @NotNull
    public String toString() {
        return "AccountInfo(loginState=" + this.loginState + ", logoutScene=" + this.logoutScene + ", secUserId=" + this.secUserId + ", userId=" + this.userId + ", odinUserType=" + this.odinUserType + ", xTTToken=" + this.xTTToken + ", innerSSOToken=" + this.innerSSOToken + ", avatarUrl=" + this.avatarUrl + ", countryCode=" + this.countryCode + ", userName=" + this.userName + ", screenName=" + this.screenName + ", userEmail=" + this.userEmail + ", userMobile=" + this.userMobile + ", hasPassword=" + this.hasPassword + ", userGender=" + this.userGender + ", isNewUser=" + this.isNewUser + ", userSession=" + this.userSession + ", loginUtcTime=" + this.loginUtcTime + ", loginPhoneNumber=" + this.loginPhoneNumber + ')';
    }

    public AccountInfo(boolean r14, int r15, @NotNull String r16, @NotNull String r17, int r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, int r22, @NotNull String r23, @NotNull String r24, @NotNull String r25, @NotNull String r26, boolean r27, int r28, boolean r29, @NotNull String r30, long r31, @NotNull String r33) {
        Intrinsics.f(r16, AccountInfoBundleKey.SEC_USER_ID);
        Intrinsics.f(r17, AccountInfoBundleKey.USER_ID);
        Intrinsics.f(r19, "xTTToken");
        Intrinsics.f(r20, "innerSSOToken");
        Intrinsics.f(r21, AccountInfoBundleKey.AVATAR_URL);
        Intrinsics.f(r23, AccountInfoBundleKey.USER_NAME);
        Intrinsics.f(r24, AccountInfoBundleKey.SCREEN_NAME);
        Intrinsics.f(r25, AccountInfoBundleKey.USER_EMAIL);
        Intrinsics.f(r26, AccountInfoBundleKey.USER_MOBILE);
        Intrinsics.f(r30, AccountInfoBundleKey.USER_SESSION);
        Intrinsics.f(r33, AccountInfoBundleKey.LOGIN_PHONE_NUMBER);
        this.loginState = r14;
        this.logoutScene = r15;
        this.secUserId = r16;
        this.userId = r17;
        this.odinUserType = r18;
        this.xTTToken = r19;
        this.innerSSOToken = r20;
        this.avatarUrl = r21;
        this.countryCode = r22;
        this.userName = r23;
        this.screenName = r24;
        this.userEmail = r25;
        this.userMobile = r26;
        this.hasPassword = r27;
        this.userGender = r28;
        this.isNewUser = r29;
        this.userSession = r30;
        this.loginUtcTime = r31;
        this.loginPhoneNumber = r33;
    }

    public /* synthetic */ AccountInfo(boolean r22, int r23, String r24, String r25, int r26, String r27, String r28, String r29, int r30, String r31, String r32, String r33, String r34, boolean r35, int r36, boolean r37, String r38, long r39, String r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r42 & 256) == 0) goto L37;
        int r11 = 86;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r42 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        int r5 = 0;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r17 = "";
    L71:
        if ((r42 & 131072) == 0) goto L73;
        long r18 = 0;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r0 = "";
    L78:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r17, r18, r0);
        return;
    L77:
        r0 = r41;
        goto L78
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r5 = r36;
        goto L63
    L57:
        r2 = r35;
        goto L59
    L53:
        r15 = r34;
        goto L55
    L49:
        r14 = r33;
        goto L51
    L45:
        r13 = r32;
        goto L47
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }
}
