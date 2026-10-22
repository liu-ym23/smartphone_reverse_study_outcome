package com.android.settings.notification;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationHistory;
import android.app.usage.IUsageStatsManager;
import android.app.usage.UsageEvents;
import android.companion.AssociationInfo;
import android.companion.ICompanionDeviceManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.service.notification.ConversationChannelWrapper;
import android.service.notification.NotificationListenerFilter;
import android.util.IconDrawableFactory;
import androidx.core.app.NotificationChannelCompat;
import com.android.internal.util.CollectionUtils;
import com.android.settings.R;
import com.android.settingslib.bluetooth.CachedBluetoothDevice;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import com.android.settingslib.notification.ConversationIconFactory;
import com.android.settingslib.utils.StringUtil;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationBackend {
    private static final int DAYS_TO_CHECK = 7;
    private static final String TAG = "NotificationBackend";
    static INotificationManager sINM;
    static IUsageStatsManager sUsageStatsManager;

    public static class AppRow extends Row {
        public boolean banned;
        public int blockedChannelCount;
        public int bubblePreference;
        public int channelCount;
        public boolean first;
        public Drawable icon;
        public CharSequence label;
        public boolean lockedImportance;
        public boolean permissionStateLocked;
        public String pkg;
        public NotificationsSentState sentByApp;
        public Map<String, NotificationsSentState> sentByChannel;
        public Intent settingsIntent;
        public boolean showBadge;
        public boolean systemApp;
        public int uid;
        public int userId;

        public AppRow() {
            this.bubblePreference = 0;
        }
    }

    public static class NotificationsSentState {
        public int avgSentDaily;
        public int avgSentWeekly;
        public long lastSent;
        public int sentCount;

        public NotificationsSentState() {
            this.avgSentDaily = 0;
            this.avgSentWeekly = 0;
            this.lastSent = 0;
            this.sentCount = 0;
        }
    }

    static class Row {
        public String section;

        Row() {
        }
    }

    public NotificationBackend() {
    }

    static {
        sUsageStatsManager = IUsageStatsManager.Stub.asInterface(ServiceManager.getService("usagestats"));
        sINM = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
    }

    public AppRow loadAppRow(Context r4, PackageManager r5, ApplicationInfo r6) {
        AppRow r0 = new AppRow();
        r0.pkg = r6.packageName;
        r0.uid = r6.uid;
        r0.label = r6.loadLabel(r5);     // Catch: Throwable -> L5
    L7:
        r0.icon = IconDrawableFactory.newInstance(r4).getBadgedIcon(r6);
        r0.banned = getNotificationsBanned(r0.pkg, r0.uid);
        r0.showBadge = canShowBadge(r0.pkg, r0.uid);
        r0.bubblePreference = getBubblePreference(r0.pkg, r0.uid);
        r0.userId = UserHandle.getUserId(r0.uid);
        r0.blockedChannelCount = getBlockedChannelCount(r0.pkg, r0.uid);
        r0.channelCount = getChannelCount(r0.pkg, r0.uid);
        return r0;
    L5:
        th = move-exception;
        OLog.e(TAG, "Error loading application label for " + r0.pkg, th);
        r0.label = r0.pkg;
        goto L7
    }

    public AppRow loadAppRow(Context r2, PackageManager r3, PackageInfo r4) {
        AppRow r5 = loadAppRow(r2, r3, r4.applicationInfo);
        recordCanBeBlocked(r4, r5);
        return r5;
    }

    void recordCanBeBlocked(PackageInfo r3, AppRow r4) {
        boolean r2 = sINM.isImportanceLocked(r3.packageName, r3.applicationInfo.uid);     // Catch: RemoteException -> L4
        r4.lockedImportance = r2;     // Catch: RemoteException -> L4
        r4.systemApp = r2;     // Catch: RemoteException -> L4
    L7:
        if (r3.applicationInfo.targetSdkVersion > 32) goto L9;
        return;
    L9:
        if (r3.requestedPermissions != null) goto L11;
    L12:
        r4.lockedImportance = true;
        r4.permissionStateLocked = true;
        return;
    L11:
        if (Arrays.stream(r3.requestedPermissions).noneMatch(new NotificationBackend$$ExternalSyntheticLambda1()) == true) goto L12;
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NMS", e);
        goto L7
    }

    static /* synthetic */ boolean lambda$recordCanBeBlocked$0(String r1) {
        return r1.equals("android.permission.POST_NOTIFICATIONS");
    }

    public static CharSequence getDeviceList(ICompanionDeviceManager r4, LocalBluetoothManager r5, String r6, int r7) {
        if (r4 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        List r8 = CollectionUtils.mapNotNull(r4.getAssociations(r6, r7), new NotificationBackend$$ExternalSyntheticLambda0());     // Catch: RemoteException -> L21
        if (r8 == null) goto L24;
        Iterator r9 = r8.iterator();     // Catch: RemoteException -> L21
        boolean r10 = false;
    L9:
        if (r9.hasNext() == false) goto L24;
        String r11 = (String) r9.next();     // Catch: RemoteException -> L21
        Iterator<CachedBluetoothDevice> r1 = r5.getCachedDeviceManager().getCachedDevicesCopy().iterator();     // Catch: RemoteException -> L21
    L13:
        if (r1.hasNext() == false) goto L9;
        CachedBluetoothDevice r2 = r1.next();     // Catch: RemoteException -> L21
        if (Objects.equals(r11, r2.getAddress()) == false) goto L13;
        if (r10 == false) goto L18;
        r0.append(", ");     // Catch: RemoteException -> L21
    L19:
        r0.append(r2.getName());     // Catch: RemoteException -> L21
        goto L13
    L18:
        r10 = true;
    L24:
        return r0.toString();
    L21:
        e = move-exception;
        OLog.w(TAG, "Error calling CDM", e);
        goto L24
    }

    static /* synthetic */ String lambda$getDeviceList$1(AssociationInfo r1) {
        if (r1.isSelfManaged() == false) goto L6;
        return null;
    L6:
        return r1.getDeviceMacAddress().toString();
    }

    public boolean enableSwitch(Context r3, ApplicationInfo r4) {
        PackageInfo r5 = r3.getPackageManager().getPackageInfo(r4.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L17
        AppRow r6 = new AppRow();     // Catch: PackageManager.NameNotFoundException -> L17
        recordCanBeBlocked(r5, r6);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r6.systemApp == true) goto L6;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L22;
        if (r6.lockedImportance == false) goto L16;
        return false;
    L16:
        return true;
    L22:
        return false;
    L6:
        if (r6.systemApp == true) goto L8;
    L10:
        r2 = false;
        goto L12
    L8:
        if (r6.banned == false) goto L10;
    L17:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean getNotificationsBanned(String r1, int r2) {
        return !sINM.areNotificationsEnabledForPackage(r1, r2);
    L5:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public boolean setNotificationsEnabledForPackage(String r4, int r5, boolean r6) {
    L13:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    L4:
        if (onlyHasDefaultChannel(r4, r5) == false) goto L10;
        NotificationChannel r1 = getChannel(r4, r5, NotificationChannelCompat.DEFAULT_CHANNEL_ID, null);     // Catch: Exception -> L13
        if (r6 == false) goto L8;
        int r2 = -1000;
    L9:
        r1.setImportance(r2);     // Catch: Exception -> L13
        updateChannel(r4, r5, r1);     // Catch: Exception -> L13
        goto L10
    L8:
        r2 = 0;
    L10:
        sINM.setNotificationsEnabledForPackage(r4, r5, r6);     // Catch: Exception -> L13
        return true;
    }

    public boolean canShowBadge(String r1, int r2) {
        return sINM.canShowBadge(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public boolean setShowBadge(String r1, int r2, boolean r3) {
        sINM.setShowBadge(r1, r2, r3);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public int getBubblePreference(String r1, int r2) {
        return sINM.getBubblePreferenceForPackage(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return -1;
    }

    public boolean setAllowBubbles(String r1, int r2, int r3) {
        sINM.setBubblesAllowed(r1, r2, r3);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public NotificationChannel getChannel(String r2, int r3, String r4) {
        return getChannel(r2, r3, r4, null);
    }

    public NotificationChannel getChannel(String r7, int r8, String r9, String r10) {
        if (r9 != null) goto L10;
        return null;
    L10:
        return sINM.getNotificationChannelForPackage(r7, r8, r9, r10, true);
    L7:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return null;
    }

    public NotificationChannelGroup getGroup(String r2, int r3, String r4) {
        if (r4 != null) goto L10;
        return null;
    L10:
        return sINM.getNotificationChannelGroupForPackage(r4, r2, r3);
    L7:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return null;
    }

    public ParceledListSlice<NotificationChannelGroup> getChannelGroups(String r2, int r3) {
        return sINM.getNotificationChannelGroupsForPackage(r2, r3, false);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public ParceledListSlice<NotificationChannelGroup> getGroups(String r2, int r3) {
        return sINM.getNotificationChannelGroupsForPackage(r2, r3, false);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public ParceledListSlice<NotificationChannelGroup> getGroupsWithRecentBlockedFilter(String r1, int r2) {
        return sINM.getRecentBlockedNotificationChannelGroupsForPackage(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public ParceledListSlice<ConversationChannelWrapper> getConversations(String r1, int r2) {
        return sINM.getConversationsForPackage(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public ParceledListSlice<ConversationChannelWrapper> getConversations(boolean r2) {
        return sINM.getConversations(r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public boolean hasSentValidMsg(String r1, int r2) {
        return sINM.hasSentValidMsg(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public boolean isInInvalidMsgState(String r1, int r2) {
        return sINM.isInInvalidMsgState(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public boolean hasUserDemotedInvalidMsgApp(String r1, int r2) {
        return sINM.hasUserDemotedInvalidMsgApp(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public void setInvalidMsgAppDemoted(String r1, int r2, boolean r3) {
        sINM.setInvalidMsgAppDemoted(r1, r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public boolean hasSentValidBubble(String r1, int r2) {
        return sINM.hasSentValidBubble(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public ParceledListSlice<NotificationChannel> getNotificationChannelsBypassingDnd(String r1, int r2) {
        return sINM.getNotificationChannelsBypassingDnd(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return ParceledListSlice.emptyList();
    }

    public void updateChannel(String r1, int r2, NotificationChannel r3) {
        sINM.updateNotificationChannelForPackage(r1, r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public void updateChannelGroup(String r1, int r2, NotificationChannelGroup r3) {
        sINM.updateNotificationChannelGroupForPackage(r1, r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public int getDeletedChannelCount(String r1, int r2) {
        return sINM.getDeletedChannelCount(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return 0;
    }

    public int getBlockedChannelCount(String r1, int r2) {
        return sINM.getBlockedChannelCount(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return 0;
    }

    public boolean onlyHasDefaultChannel(String r1, int r2) {
        return sINM.onlyHasDefaultChannel(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public int getChannelCount(String r2, int r3) {
        return sINM.getNumNotificationChannelsForPackage(r2, r3, false);
    L5:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return 0;
    }

    public boolean shouldHideSilentStatusBarIcons(Context r2) {
        return sINM.shouldHideSilentStatusIcons(r2.getPackageName());
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public void setHideSilentStatusIcons(boolean r2) {
        sINM.setHideSilentStatusIcons(r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public List<String> getAssistantAdjustments(String r2) {
        return sINM.getAllowedAssistantAdjustments(r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return new ArrayList();
    }

    public boolean showSilentInStatusBar(String r2) {
        return !sINM.shouldHideSilentStatusIcons(r2);
    L5:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public NotificationHistory getNotificationHistory(String r1, String r2) {
        return sINM.getNotificationHistory(r1, r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return new NotificationHistory();
    }

    protected void recordAggregatedUsageEvents(Context r9, AppRow r10) {
        long r3 = System.currentTimeMillis();
        long r1 = r3 - 604800000;
        UsageEvents r11 = sUsageStatsManager.queryEventsForPackageForUser(r1, r3, r10.userId, r10.pkg, r9.getPackageName());     // Catch: RemoteException -> L5
    L7:
        recordAggregatedUsageEvents(r11, r10);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = null;
        goto L7
    }

    protected void recordAggregatedUsageEvents(UsageEvents r8, AppRow r9) {
        r9.sentByChannel = new HashMap();
        r9.sentByApp = new NotificationsSentState();
        if (r8 == null) goto L27;
        UsageEvents.Event r0 = new UsageEvents.Event();
    L6:
        if (r8.hasNextEvent() == false) goto L18;
        r8.getNextEvent(r0);
        if (r0.getEventType() != 12) goto L6;
        String r1 = r0.mNotificationChannelId;
        if (r1 == null) goto L6;
        NotificationsSentState r2 = r9.sentByChannel.get(r1);
        if (r2 != null) goto L15;
        r2 = new NotificationsSentState();
        r9.sentByChannel.put(r1, r2);
    L15:
        if (r0.getTimeStamp() <= r2.lastSent) goto L17;
        r2.lastSent = r0.getTimeStamp();
        r9.sentByApp.lastSent = r0.getTimeStamp();
    L17:
        r2.sentCount++;
        r9.sentByApp.sentCount++;
        calculateAvgSentCounts(r2);
        goto L6
    L18:
        calculateAvgSentCounts(r9.sentByApp);
        return;
    }

    public static CharSequence getSentSummary(Context r4, NotificationsSentState r5, boolean r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r6 == false) goto L13;
        if (r5.lastSent != 0) goto L11;
        return r4.getString(R.string.notifications_sent_never);
    L11:
        return StringUtil.formatRelativeTime(r4, System.currentTimeMillis() - r5.lastSent, true);
    L13:
        if (r5.avgSentDaily <= 0) goto L17;
        return StringUtil.getIcuPluralsString(r4, r5.avgSentDaily, R.string.notifications_sent_daily);
    L17:
        return StringUtil.getIcuPluralsString(r4, r5.avgSentWeekly, R.string.notifications_sent_weekly);
    }

    private void calculateAvgSentCounts(NotificationsSentState r2) {
        if (r2 == null) goto L7;
        r2.avgSentDaily = Math.round(r2.sentCount / 7.0f);
        if (r2.sentCount >= 7) goto L8;
        r2.avgSentWeekly = r2.sentCount;
        return;
    L8:
        return;
    }

    public ComponentName getAllowedNotificationAssistant() {
        return sINM.getAllowedNotificationAssistant();
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return null;
    }

    public ComponentName getDefaultNotificationAssistant() {
        return sINM.getDefaultNotificationAssistant();
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return null;
    }

    public void setNASMigrationDoneAndResetDefault(int r1, boolean r2) {
        sINM.setNASMigrationDoneAndResetDefault(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public boolean setNotificationAssistantGranted(ComponentName r3) {
        sINM.setNotificationAssistantAccessGranted(r3, true);     // Catch: Exception -> L11
        if (r3 != null) goto L10;
        if (sINM.getAllowedNotificationAssistant() == null) goto L8;
        return false;
    L8:
        return true;
    L10:
        return r3.equals(sINM.getAllowedNotificationAssistant());
    L11:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    public void createConversationNotificationChannel(String r1, int r2, NotificationChannel r3, String r4) {
        sINM.createConversationNotificationChannelForPackage(r1, r2, r3, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public ShortcutInfo getConversationInfo(Context r2, String r3, int r4, String r5) {
        List<ShortcutInfo> r1 = ((LauncherApps) r2.getSystemService(LauncherApps.class)).getShortcuts(new LauncherApps.ShortcutQuery().setPackage(r3).setQueryFlags(1041).setShortcutIds(Arrays.asList(new String[]{r5})), UserHandle.of(UserHandle.getUserId(r4)));
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return r1.get(0);
    }

    public Drawable getConversationDrawable(Context r7, ShortcutInfo r8, String r9, int r10, boolean r11) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new ConversationIconFactory(r7, (LauncherApps) r7.getSystemService(LauncherApps.class), r7.getPackageManager(), IconDrawableFactory.newInstance(r7, false), r7.getResources().getDimensionPixelSize(R.dimen.conversation_icon_size)).getConversationDrawable(r8, r9, r10, r11);
    }

    public void requestPinShortcut(Context r1, ShortcutInfo r2) {
        ((ShortcutManager) r1.getSystemService(ShortcutManager.class)).requestPinShortcut(r2, null);
    }

    public void resetNotificationImportance() {
        sINM.unlockAllNotificationChannels();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public NotificationListenerFilter getListenerFilter(ComponentName r1, int r2) {
        NotificationListenerFilter r0 = sINM.getListenerFilter(r1, r2);     // Catch: Exception -> L4
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return new NotificationListenerFilter();
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        r0 = null;
        goto L6
    }

    public void setListenerFilter(ComponentName r1, int r2, NotificationListenerFilter r3) {
        sINM.setListenerFilter(r1, r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
    }

    public boolean isNotificationListenerAccessGranted(ComponentName r2) {
        return sINM.isNotificationListenerAccessGranted(r2);
    L4:
        e = move-exception;
        OLog.w(TAG, "Error calling NoMan", e);
        return false;
    }

    void setNm(INotificationManager r1) {
        sINM = r1;
    }
}
