package com.android.calendar.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.privacy.IGrantListener;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.matrix.platform.sdk.ones.region.RegionUtil;
import com.obric.olog.OLog;
import com.obric.oui.privacy.PrivacyItem;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import com.obric.security.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: GrantUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000eJ,\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0004J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/calendar/privacy/GrantUtil;", "", "()V", "URL_PERMISSION_NOTE", "", "URL_PRIVACY_POLICY", "URL_PRIVACY_POLICY_HK", "URL_THIRD_PARTY_SDK_DIR", "URL_USER_PROTOCOL", "securitymanager", "getAppUid", "", "packageName", "isAllowed", "", "context", "Landroid/content/Context;", "from", "forceShow", "isAllowedInternal", "localIsAllowed", "isAppAvailable", "requestGrant", "", "activity", "Landroid/app/Activity;", "grantListener", "Lcom/bytedanceos/privacy/IGrantListener;", "setResult", "result", "setSecurityManagerResult", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GrantUtil {
    public static final GrantUtil INSTANCE = null;
    public static final String URL_PERMISSION_NOTE = "https://os.obriccloud.com/agreement/security_permissions";
    public static final String URL_PRIVACY_POLICY = "https://os.obriccloud.com/agreement/securityservice_privacy";
    public static final String URL_PRIVACY_POLICY_HK = "https://os.obriccloud.com/agreement/securityservice_privacy_en";
    public static final String URL_THIRD_PARTY_SDK_DIR = "https://os.obriccloud.com/agreement/security_sdklist";
    public static final String URL_USER_PROTOCOL = "https://os.oceancloudapi.com/agreement/security_user_agreement";
    public static final String securitymanager = "com.obric.securitymanager";

    /* JADX INFO: renamed from: com.android.calendar.privacy.GrantUtil$requestGrant$1, reason: invalid class name */
    /* JADX INFO: compiled from: GrantUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"restoreOnce", "", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Ref.BooleanRef $restored;

        AnonymousClass1(Ref.BooleanRef r1) {
            this.$restored = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$restored.element == false) goto L5;
            return;
        L5:
            this.$restored.element = true;
        }
    }

    static {
        INSTANCE = new GrantUtil();
    }

    private GrantUtil() {
    }

    public static final /* synthetic */ void access$setResult(GrantUtil r0, Context r1, boolean r2) {
        r0.setResult(r1, r2);
    }

    public static /* synthetic */ void requestGrant$default(GrantUtil r0, Activity r1, IGrantListener r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        r0.requestGrant(r1, r2, r3, r4);
    }

    public final void requestGrant(final Activity r10, final IGrantListener r11, final String r12, final boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "grantListener");
        Intrinsics.checkNotNullParameter(r12, "from");
        Activity r0 = r10;
        if (isAppAvailable(r0, securitymanager) == false) goto L5;
        String r9 = r10.getString(R.string.security_manager);
        Intrinsics.checkNotNullExpressionValue(r9, "activity.getString(R.string.security_manager)");
    L6:
        PreferenceMgr r1 = PreferenceMgr.getInstance(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "PreferenceMgr.getInstance(activity)");
        final boolean r5 = r1.isAllowed();
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = false;
        final AnonymousClass1 r8 = new AnonymousClass1(r2);
        String r3 = r10.getString(R.string.first_launch_dialog_msgtitle);
        Intrinsics.checkNotNullExpressionValue(r3, "activity.getString(R.str…t_launch_dialog_msgtitle)");
        List<? extends PrivacyItem> r4 = CollectionsKt.listOf(new PrivacyItem.PermissionItem(r3, CollectionsKt.listOf(new String[]{r10.getString(R.string.first_launch_dialog_permission_1), r10.getString(R.string.first_launch_dialog_permission_2), r10.getString(R.string.first_launch_dialog_permission_3), r10.getString(R.string.first_launch_dialog_permission_4), r10.getString(R.string.first_launch_dialog_permission_5)})));
        PrivacyStatementActivity.Companion.Builder r14 = new PrivacyStatementActivity.Companion.Builder(r10).setTitle(r9).setIconResId(R.mipmap.app_secure);     // Catch: Throwable -> L14
        if (RegionUtil.INSTANCE.isCN() == false) goto L11;
        String r6 = URL_PRIVACY_POLICY;
    L12:
        PrivacyStatementActivity.Companion.Builder r15 = r14.setPrivacyUrls(new String[]{r6});     // Catch: Throwable -> L14
        String r7 = r10.getString(R.string.first_launch_dialog_subtitle);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r7, "activity.getString(R.str…t_launch_dialog_subtitle)");     // Catch: Throwable -> L14
        PrivacyStatementActivity.Companion.Builder r16 = r15.setDescription(r7);     // Catch: Throwable -> L14
        String r17 = r10.getString(R.string.first_launch_dialog_privacytext);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r17, "activity.getString(R.str…aunch_dialog_privacytext)");     // Catch: Throwable -> L14
        PrivacyStatementActivity.Companion.Builder r18 = r16.setPrivacyText(r17);     // Catch: Throwable -> L14
        String r19 = r10.getString(R.string.first_launch_dialog_PolicyLinkTexts);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r19, "activity.getString(R.str…h_dialog_PolicyLinkTexts)");     // Catch: Throwable -> L14
        r18.setPrivacyPolicyLinkTexts(CollectionsKt.arrayListOf(new String[]{r19})).setConsentCallback(new AnonymousClass2(r8, r12, r10, r11)).setItems(r4).show(new AnonymousClass3(r12, r13, r5, r8, r11));     // Catch: Throwable -> L14
        return;
    L11:
        r6 = URL_PRIVACY_POLICY_HK;
    L14:
        th = move-exception;
        r8.invoke2();
        throw th;
    L5:
        r9 = r10.getString(R.string.security_center);
        Intrinsics.checkNotNullExpressionValue(r9, "activity.getString(R.string.security_center)");
        goto L6
    }

    public final boolean isAppAvailable(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        PackageManager r0 = r1.getPackageManager();
        Intrinsics.checkNotNull(r2);
        if (r0.getLaunchIntentForPackage(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setResult(Context r2, boolean r3) {
        PreferenceMgr r1 = PreferenceMgr.getInstance(r2);
        OLog.e("GrantUtil", "setResultpermission_has_allowed");
        r1.putBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PERMISSION_ALLOWED, r3);
    }

    public final void setSecurityManagerResult(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        PreferenceMgr.getInstance(r3).putBoolean(securitymanager + getAppUid(securitymanager), r4);
    }

    public final int getAppUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        return SecurityCenterApplication.getApplication().getPackageManager().getApplicationInfo(r2, 0).uid;
    L5:
        return -1;
    }

    public static /* synthetic */ boolean isAllowedInternal$default(GrantUtil r1, Context r2, String r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = false;
    L12:
        return r1.isAllowedInternal(r2, r3, r4, r5);
    }

    public final boolean isAllowedInternal(Context r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        PreferenceMgr r0 = PreferenceMgr.getInstance(r3);
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.isAllowed();
    L6:
        if (r6 == true) goto L17;
        if (r2 != true) goto L17;
        if (r5 == false) goto L11;
    L14:
        setSecurityManagerResult(r3, true);
    L15:
        return true;
    L11:
        if (r4.length() <= 0) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L15;
    L17:
        return isAllowed(r3, r4, r5);
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ boolean isAllowed$default(GrantUtil r0, Context r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.isAllowed(r1, r2, r3);
    }

    public final boolean isAllowed(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        if (r4 == false) goto L6;
        setSecurityManagerResult(r2, false);
        return false;
    L6:
        PreferenceMgr r1 = PreferenceMgr.getInstance(r2);
        if (Intrinsics.areEqual(r3, securitymanager) == true) goto L9;
        if (r1 != null) goto L12;
        return false;
    L12:
        return r1.getBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PERMISSION_ALLOWED, false);
    L9:
        return r1.getIsAllowedFromUid(r3);
    }
}
