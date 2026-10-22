package com.android.settings.utils;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import bytedanceos.api.NotificationChannelSmt;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.notification.NotificationBackend;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHelper {
    private static final String CHANNELS = "channels";
    private static final String ID = "id";
    private static final String IMPORTANCE = "importance";
    private static final String NAME = "name";
    private static final String NOTIFICATION_PRIVATE_APP = "nofification_private_app";
    private static final String PACKAGENAME = "packageName";
    private static final String SOUND = "sound";
    private static final String TAG = "NotificationHelper";
    private static final String UID = "uid";
    private static final String VIBRATION_ENABLED = "vibrationEnabled";
    private static volatile NotificationHelper sInstance;
    private NotificationBackend mBackend;
    private Context mContext;
    private INotificationManager mNotificationManager;
    private PackageManager mPackageManager;

    public static class AppRow {
        public boolean banned;
        public boolean lockedImportance;
        public boolean systemApp;

        public AppRow() {
        }
    }

    public static boolean isRootOrSystemUid(int r1) {
        if (r1 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == 1000) goto L7;
        return false;
    }

    static /* synthetic */ Context access$000(NotificationHelper r0) {
        return r0.mContext;
    }

    private NotificationHelper() {
        this.mBackend = new NotificationBackend();
        this.mContext = SettingsApplication.getApplication().getApplicationContext();
        this.mNotificationManager = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        this.mPackageManager = this.mContext.getPackageManager();
    }

    public static NotificationHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(NotificationHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NotificationHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NotificationHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean isNotificationLedEnabled(String r3, int r4) {
        ApplicationInfo r1 = this.mPackageManager.getApplicationInfo(r3, 0);     // Catch: Exception -> L9
        if (r4 >= 0) goto L7;
        if (r1 == null) goto L7;
        r4 = r1.uid;     // Catch: Exception -> L9
    L7:
        return this.mNotificationManager.getISmtEx().isNotiicationLedEnabledForPackage(r3, r4);
    L9:
        e = move-exception;
        OLog.e(TAG, "isNotificationLedEnabled error:" + e);
        return false;
    }

    public void setNotificationLedEnabled(String r2, int r3, boolean r4) {
        if (r3 < 0) goto L9;
    L4:
        this.mNotificationManager.getISmtEx().setNotificationLightEnableForPackage(r2, r3, r4);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.e(TAG, "setNotificationLedEnabled error:" + e);
        return;
    L9:
        r3 = this.mPackageManager.getApplicationInfo(r2, 0).uid;     // Catch: Exception -> L6
        goto L4
    }

    public Uri getSoundRtUri() {
        String r0 = Settings.System.getString(this.mContext.getContentResolver(), "notification_sound");
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return getDefaultUri(getDefaultRingtoneTitle("notification_sound", "is_notification"));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        return Uri.parse(r0);
    }

    private String getDefaultRingtoneTitle(String r12, String r13) {
        String r0 = SystemProperties.get("ro.config.notification_sound");
        String r1 = "";
        boolean r3 = false;
        if ("".equals(r0) == true) goto L20;
        Cursor r2 = null;
        r2 = this.mContext.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"title"}, "_display_name = '" + r0 + "' AND " + r13 + " =1", null, null);     // Catch: Throwable -> L14 Exception -> L16
        if (r2 != null) goto L9;
    L12:
        if (r2 == null) goto L20;
    L13:
        r2.close();
        goto L20
    L9:
        if (r2.moveToFirst() == false) goto L12;
        r1 = r2.getString(0);     // Catch: Throwable -> L14 Exception -> L16
        r3 = true;
        goto L12
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r2 == null) goto L20;
    L14:
        th = move-exception;
        if (r2 == null) goto L25;
        r2.close();
    L25:
        throw th;
    L20:
        if (r3 == false) goto L22;
        return r1;
    L22:
        return this.mContext.getString(R.string.ringtone_notification_default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    private Uri getDefaultUri(String r9) {
        ?? r1 = 0;
        Cursor r8 = this.mContext.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, new String[]{"_id"}, "title = '" + r9 + "' AND is_notification = 1", null, null);     // Catch: Throwable -> L16 Exception -> L18
        if (r8 != null) goto L30;
    L13:
        if (r8 == null) goto L15;
        r8.close();
    L15:
        return null;
    L30:
    L11:
        e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r8 == null) goto L23;
        r8.close();
    L23:
        return null;
    L6:
        if (r8.moveToFirst() == false) goto L13;
        Uri r10 = ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r8.getInt(0));     // Catch: Exception -> L11 Throwable -> L24
        if (r8 == null) goto L10;
        r8.close();
    L10:
        return r10;
    L24:
        th = th;
        r1 = this;
    L26:
        if (r1 == 0) goto L28;
        r1.close();
    L28:
        throw th;
    L18:
        e = e;
        r8 = null;
    L16:
        th = th;
        goto L26
    }

    public int getNotificationsVisibilityForPackage(String r2, int r3) {
        int r1 = this.mNotificationManager.getISmtEx().getNotificationsVisibilityForPackage(r2, r3);     // Catch: RemoteException -> L5
    L8:
        if (r1 != (-1000)) goto L11;
        return 1;
    L11:
        return r1;
    L5:
        e = move-exception;
        OLog.e(TAG, "getNotificationsVisibilityForPackage e: " + e);
        r1 = 1;
        goto L8
    }

    public void setNotificationsVisibilityForPackage(String r7, int r8, int r9) {
        this.mNotificationManager.getISmtEx().setNotificationsVisibilityForPackage(r7, r8, r9);     // Catch: RemoteException -> L4
    L6:
        StringBuffer r0 = new StringBuffer();
        PreferenceMgr r6 = PreferenceMgr.getInstance(this.mContext);
        String r3 = r6.getString(NOTIFICATION_PRIVATE_APP, "");
        String r10 = r7 + ":" + r8;
        if (r9 != 0) goto L16;
        r0.append(r3);
        if (r3.contains(r10) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        r10 = ";" + r10;
    L14:
        r0.append(r10);
        r6.putString(NOTIFICATION_PRIVATE_APP, r0.toString());
        return;
    L16:
        if (r9 == 1) goto L18;
        return;
    L18:
        if (r3.contains(r10) == false) goto L39;
        String[] r11 = r3.replaceAll(r10 + ";", "").replaceAll(r10, "").split(";");
        int r2 = 0;
    L21:
        if (r2 >= r11.length) goto L26;
        if (TextUtils.isEmpty(r11[r2]) == true) goto L25;
        r0.append(r11[r2] + ";");
    L25:
        r2 = r2 + 1;
        goto L21
    L26:
        String r12 = r0.toString();
        if (r12.endsWith(";") == false) goto L29;
        r6.putString(NOTIFICATION_PRIVATE_APP, r12.substring(0, r12.length() - 1));
        return;
    L29:
        r6.putString(NOTIFICATION_PRIVATE_APP, r12);
        return;
    L39:
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "setNotificationsVisibilityForPackage error " + e);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.utils.NotificationHelper$1] */
    public void resetNotificationsVisibility() {
        new AnonymousClass1(this).execute(new Void[0]);
    }

    public void recordCanBeBlocked(PackageInfo r3, AppRow r4) {
        if (r3 != null) goto L16;
        return;
    L16:
        boolean r2 = this.mNotificationManager.isImportanceLocked(r3.packageName, r3.applicationInfo.uid);     // Catch: RemoteException -> L6
        r4.lockedImportance = r2;     // Catch: RemoteException -> L6
        r4.systemApp = r2;     // Catch: RemoteException -> L6
    L9:
        if (r3.applicationInfo.targetSdkVersion > 32) goto L11;
        return;
    L11:
        if (r3.requestedPermissions != null) goto L13;
    L14:
        r4.lockedImportance = true;
        return;
    L13:
        if (Arrays.stream(r3.requestedPermissions).noneMatch(new NotificationHelper$$ExternalSyntheticLambda0()) == true) goto L14;
        return;
    L6:
        e = move-exception;
        OLog.e(TAG, "Error calling NMS", e);
        goto L9
    }

    static /* synthetic */ boolean lambda$recordCanBeBlocked$0(String r1) {
        return r1.equals("android.permission.POST_NOTIFICATIONS");
    }

    public static boolean notificationPermissionFixed(Context r2, String r3, int r4) {
        int r5 = new PermissionManager(r2).getPermissionFlags(r3, "android.permission.POST_NOTIFICATIONS", UserHandle.getUserHandleForUid(r4));     // Catch: Exception -> L10
        if ((r5 & 16) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r5 & 4) != 0) goto L8;
        return false;
    L10:
        e = move-exception;
        OLog.e(TAG, "notificationPermissionFixed error: " + e);
        return false;
    }

    public boolean areNotificationsEnabledForPackage(String r1, int r2) {
        return this.mNotificationManager.areNotificationsEnabledForPackage(r1, r2);
    L4:
        e = move-exception;
        OLog.e(TAG, "areNotificationsEnabledForPackage error:" + e);
        return true;
    }

    public void setNotificationsEnabledForPackage(String r2, int r3, boolean r4) {
        this.mNotificationManager.setNotificationsEnabledForPackage(r2, r3, r4);     // Catch: Exception -> L4
        ApplicationsState.setFeedbackAppNotificationsEnabled(this.mContext, r2, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "setNotificationsEnabledForPackage error:" + e);
    }

    public String getChannelsByJson(String r11) {
        JSONArray r2 = new JSONArray(r11);     // Catch: JSONException -> L21
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L21
        int r3 = 0;
    L5:
        if (r3 >= r2.length()) goto L19;
        JSONObject r4 = r2.getJSONObject(r3);     // Catch: JSONException -> L21
        String r5 = r4.getString("packageName");     // Catch: JSONException -> L21
        int r6 = r4.getInt("uid");     // Catch: JSONException -> L21
        if ("com.android.contacts".equals(r5) == false) goto L9;
    L11:
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L21
        List r8 = this.mBackend.getChannelGroups(r5, r6).getList();     // Catch: JSONException -> L21
        ArrayList r9 = new ArrayList();     // Catch: JSONException -> L21
        Iterator r10 = r8.iterator();     // Catch: JSONException -> L21
    L13:
        if (r10.hasNext() == false) goto L16;
        r9.addAll(((NotificationChannelGroup) r10.next()).getChannels());     // Catch: JSONException -> L21
        goto L13
    L16:
        if (r9.size() <= 0) goto L18;
        r7.put("packageName", r5);     // Catch: JSONException -> L21
        r7.put("uid", r6);     // Catch: JSONException -> L21
        r7.put(CHANNELS, channelGroupToJson(r9));     // Catch: JSONException -> L21
        r12.put(r7);     // Catch: JSONException -> L21
    L18:
        r3 = r3 + 1;     // Catch: JSONException -> L21
        goto L5
    L9:
        if (this.mBackend.onlyHasDefaultChannel(r5, r6) == false) goto L11;
    L19:
        return r12.toString();
    L21:
        e = move-exception;
        OLog.d(TAG, "get channel json error " + e.getMessage());
        return null;
    }

    public JSONArray channelGroupToJson(List<NotificationChannel> r5) {
        JSONArray r4 = new JSONArray();
        Iterator<NotificationChannel> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L21;
        NotificationChannel r0 = r6.next();
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L12
        r1.put("id", r0.getId());     // Catch: JSONException -> L12
        r1.put("name", r0.getName());     // Catch: JSONException -> L12
        r1.put(IMPORTANCE, r0.getImportance());     // Catch: JSONException -> L12
        r1.put(VIBRATION_ENABLED, r0.shouldVibrate());     // Catch: JSONException -> L12
        if (NotificationChannelSmt.getInstance().getSoundEnabled(r0) == false) goto L9;
        int r2 = 1;
    L10:
        r1.put("sound", r2);     // Catch: JSONException -> L12
        r4.put(r1);     // Catch: JSONException -> L12
        goto L4
    L9:
        r2 = 0;
    L12:
        e = move-exception;
        e.printStackTrace();
        OLog.d(TAG, "channelGroupToJson catch JSONException " + e.getMessage());
        return null;
    L21:
        return r4;
    }

    public void setChannels(String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L38;
        return;
    L38:
        JSONArray r0 = new JSONArray(r12);     // Catch: JSONException -> L35
        int r1 = 0;
    L6:
        if (r1 >= r0.length()) goto L48;
        JSONObject r2 = r0.getJSONObject(r1);     // Catch: JSONException -> L35
        String r3 = r2.getString("packageName");     // Catch: JSONException -> L35
        int r4 = Integer.parseInt(r2.getString("uid"));     // Catch: JSONException -> L35
        if ("com.android.contacts".equals(r3) == false) goto L11;
    L13:
        JSONArray r5 = r2.getJSONArray(CHANNELS);     // Catch: JSONException -> L35
        List r6 = this.mBackend.getChannelGroups(r3, r4).getList();     // Catch: JSONException -> L35
        if (r6.size() <= 0) goto L34;
        HashMap r7 = new HashMap();     // Catch: JSONException -> L35
        Iterator r8 = r6.iterator();     // Catch: JSONException -> L35
    L18:
        if (r8.hasNext() == false) goto L23;
        Iterator<NotificationChannel> r9 = ((NotificationChannelGroup) r8.next()).getChannels().iterator();     // Catch: JSONException -> L35
    L21:
        if (r9.hasNext() == false) goto L18;
        NotificationChannel r10 = r9.next();     // Catch: JSONException -> L35
        r7.put(r10.getId(), r10);     // Catch: JSONException -> L35
        goto L21
    L23:
        int r11 = 0;
    L25:
        if (r11 >= r5.length()) goto L34;
        JSONObject r13 = r5.getJSONObject(r11);     // Catch: JSONException -> L35
        String r14 = r13.getString("id");     // Catch: JSONException -> L35
        if (r7.containsKey(r14) == false) goto L33;
        NotificationChannel r15 = (NotificationChannel) r7.get(r14);     // Catch: JSONException -> L35
        r15.setName(r13.getString("name"));     // Catch: JSONException -> L35
        r15.setImportance(r13.getInt(IMPORTANCE));     // Catch: JSONException -> L35
        r15.enableVibration(r13.getBoolean(VIBRATION_ENABLED));     // Catch: JSONException -> L35
        NotificationChannelSmt r16 = NotificationChannelSmt.getInstance();     // Catch: JSONException -> L35
        boolean r17 = true;
        if (r13.getInt("sound") == 1) goto L32;
        r17 = false;
    L32:
        r16.setSoundEnabled(r15, r17);     // Catch: JSONException -> L35
        this.mBackend.updateChannel(r3, r4, r15);     // Catch: JSONException -> L35
    L33:
        r11 = r11 + 1;
    L34:
        r1 = r1 + 1;
        goto L6
    L11:
        if (this.mBackend.onlyHasDefaultChannel(r3, r4) == false) goto L13;
    L48:
        return;
    L35:
        e = move-exception;
        OLog.d(TAG, "parse notification data exception :" + e.getMessage());
    }
}
