package com.android.settings.intent;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.utils.NotificationHelper;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchNotificationIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSwitchNotificationParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchNotificationIntent extends BaseSystemSwitchNotificationIntent {
    private static final String ALL_NOTIFICATION = "ALL";
    private static final String DOU_BAO_PACKAGE_NAME = "com.larus.nova";
    private static final String MMS_PACKAGE_NAME = "com.android.mms";
    private final String TAG;
    private ApplicationsState mApplicationsState;
    private IntentResult mResult;
    private ApplicationsState.Session mSession;

    public SwitchNotificationIntent() {
        this.TAG = "SwitchNotificationIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSwitchNotificationIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemSwitchNotificationParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSwitchNotificationIntent
    public Object doAction(SystemSwitchNotificationParams r10, DispatchContext r11, Continuation<? super IntentResult<Empty>> r12) {
        OLog.d("SwitchNotificationIntent", "enter SwitchNotificationIntent doAction");
        Context r13 = r11.getContext();
        this.mResult = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("SwitchNotificationIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r11);
        this.mResult.setRet(201);
        return this.mResult;
    L7:
        if (r10.getTargetAppName() != null) goto L9;
    L56:
        this.mResult.setRet(103);
        OLog.e("SwitchNotificationIntent", "params is null");
        return this.mResult;
    L9:
        if (r10.getEnable() == null) goto L56;
        boolean r14 = r10.getEnable().booleanValue();
        String r15 = r10.getTargetAppName();
        ArrayList<ApplicationInfo> r1 = getAllNotificationAppList(r13);
        if (r15.equals(ALL_NOTIFICATION) == false) goto L33;
        OLog.d("SwitchNotificationIntent", "all notification enable is " + r14);
        Iterator<ApplicationInfo> r16 = r1.iterator();
    L15:
        if (r16.hasNext() == false) goto L27;
        ApplicationInfo r2 = r16.next();
        PackageInfo r3 = findPackageInfo(r13, r2.packageName, r2.uid);
        if (r3 == null) goto L18;
        if (isAllowOperationNotification(r13, r3, r2) == false) goto L21;
        if (r2.packageName.equals("com.larus.nova") == false) goto L26;
        if (r14 == false) goto L15;
    L26:
        operateNotification(r13, r2, r14);
        goto L15
    L21:
        OLog.d("SwitchNotificationIntent", r2.packageName + " is not allow operation.");
        goto L15
    L18:
        OLog.d("SwitchNotificationIntent", r2.packageName + " pkgInfo is null");
        goto L15
    L27:
        this.mResult.setRet(0);
        IntentResult r17 = this.mResult;
        if (r14 == false) goto L30;
        int r18 = R.string.switch_mode_notification_all_open;
    L31:
        r17.setDetails(r13.getString(r18));
        OLog.d("SwitchNotificationIntent", "all notification intent finished");
        return this.mResult;
    L30:
        r18 = R.string.switch_mode_notification_all_close;
        goto L31
    L33:
        OLog.d("SwitchNotificationIntent", r15 + " notification enable is " + r14);
        ApplicationInfo r4 = getPackageNameByAppName(r13, r1, r15);
        if (r4 != null) goto L38;
        OLog.e("SwitchNotificationIntent", r15 + " is no install");
        this.mResult.setRet(102);
        this.mResult.setDetails(r13.getString(R.string.switch_mode_notification_no_install, new Object[]{r15}));
        return this.mResult;
    L38:
        if (r4.packageName.equals("com.larus.nova") == false) goto L42;
        if (r14 == true) goto L42;
        this.mResult.setRet(0);
        this.mResult.setDetails(r13.getString(R.string.switch_mode_notification_doubao_close_tips));
        return this.mResult;
    L42:
        PackageInfo r5 = findPackageInfo(r13, r4.packageName, r4.uid);
        if (r5 != null) goto L47;
        OLog.e("SwitchNotificationIntent", r15 + " pkgInfo is null");
        this.mResult.setRet(102);
        this.mResult.setDetails(r13.getString(R.string.switch_mode_notification_no_install, new Object[]{r15}));
        return this.mResult;
    L47:
        if (isAllowOperationNotification(r13, r5, r4) == true) goto L50;
        OLog.i("SwitchNotificationIntent", r4.packageName + " notification is not allow");
        this.mResult.setRet(102);
        this.mResult.setDetails(r13.getString(R.string.switch_mode_notification_no_allow));
        return this.mResult;
    L50:
        operateNotification(r13, r4, r14);
        this.mResult.setRet(0);
        IntentResult r6 = this.mResult;
        if (r14 == false) goto L53;
        int r19 = R.string.switch_mode_notification_open;
    L54:
        r6.setDetails(r13.getString(r19, new Object[]{r15}));
        OLog.d("SwitchNotificationIntent", r15 + " notification intent finished");
        return this.mResult;
    L53:
        r19 = R.string.switch_mode_notification_close;
        goto L54
    }

    private ApplicationInfo getPackageNameByAppName(Context r3, ArrayList<ApplicationInfo> r4, String r5) {
        if (r4 == null) goto L13;
        if (r5 == null) goto L13;
        PackageManager r6 = r3.getPackageManager();
        Iterator<ApplicationInfo> r7 = r4.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        ApplicationInfo r0 = r7.next();
        if (TextUtils.equals(r6.getApplicationLabel(r0).toString(), r5) == false) goto L8;
        return r0;
    L12:
        return null;
    L13:
        OLog.i("SwitchNotificationIntent", "applicationInfos is null or appName is null");
        return null;
    }

    private PackageInfo findPackageInfo(Context r8, String r9, int r10) {
        OLog.e("SwitchNotificationIntent", "findPackageInfo pkg=" + r9 + ", uid=" + r10);
        PackageInfo r7 = null;
        if (r9 == null) goto L18;
        if (r10 < 0) goto L18;
        PackageManager r11 = r8.getPackageManager();
        String[] r1 = r11.getPackagesForUid(r10);
        if (r1 == null) goto L18;
        if (r9 == null) goto L18;
        int r2 = r1.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L18;
        if (r9.equals(r1[r3]) == false) goto L17;
        return r11.getPackageInfoAsUser(r9, 4160, UserHandle.getUserId(r10));
    L15:
        e = move-exception;
        OLog.w("SwitchNotificationIntent", "Failed to load package " + r9, e);
    L17:
        r3 = r3 + 1;
    L18:
        return r7;
    }

    private boolean isAllowOperationNotification(Context r5, PackageInfo r6, ApplicationInfo r7) {
        NotificationHelper.AppRow r4 = new NotificationHelper.AppRow();
        NotificationHelper.getInstance().recordCanBeBlocked(r6, r4);
        r4.banned = !NotificationHelper.getInstance().areNotificationsEnabledForPackage(r7.packageName, r7.uid);
        if (r4.systemApp == true) goto L5;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        OLog.i("SwitchNotificationIntent", "AppRow systemApp :" + r4.systemApp + ", lockedImportance: " + r4.lockedImportance + ",  blockable: " + r9);
        boolean r10 = NotificationHelper.notificationPermissionFixed(r5, r7.packageName, r7.uid);
        OLog.i("SwitchNotificationIntent", "notification permission fixed: " + r10);
        if (r9 == false) goto L21;
        if (r10 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r4.lockedImportance == true) goto L15;
        r9 = true;
        goto L16
    L5:
        if (r4.systemApp == true) goto L7;
    L9:
        r8 = false;
        goto L11
    L7:
        if (r4.banned == false) goto L9;
        goto L9
    }

    private ArrayList<ApplicationInfo> getAllNotificationAppList(Context r8) {
        ApplicationsState r0 = ApplicationsState.getInstance(SettingsApplication.getApplication(), true);
        this.mApplicationsState = r0;
        ApplicationsState.Session r1 = r0.newSession(new AnonymousClass1(this));
        this.mSession = r1;
        r1.resume(true);
        ArrayList<ApplicationsState.AppEntry> r2 = this.mSession.rebuild(null, ApplicationsState.ALPHA_COMPARATOR);
        ArrayList<ApplicationInfo> r3 = new ArrayList();
        Iterator<ApplicationsState.AppEntry> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        ApplicationsState.AppEntry r5 = r4.next();
        boolean r6 = Utils.isNotificationWhiteApp(r8, this.mApplicationsState, r5.info);
        boolean r7 = Utils.isPackageLocked(r8.getPackageManager(), r5.info.packageName, r5.info.uid);
        boolean r9 = r5.info.packageName.equals(r5.label);
        if (r6 == true) goto L11;
        if (r7 == true) goto L11;
        if (r9 == true) goto L11;
        r3.add(r5.info);
    L11:
        OLog.d("SwitchNotificationIntent", r5.info.packageName + " is not allow operation.isNotificationWhiteApp:" + r6 + " isPackageLocked:" + r7 + " isPkgEqualsLabel:" + r9);
        goto L4
    L12:
        this.mSession.release();
        return r3;
    }

    void operateNotification(Context r1, ApplicationInfo r2, boolean r3) {
        NotificationHelper.getInstance().setNotificationsEnabledForPackage(r2.packageName, r2.uid, r3);
    }
}
