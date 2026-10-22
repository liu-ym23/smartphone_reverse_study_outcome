package com.android.settings.applications;

import android.app.usage.IUsageStatsManager;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.widget.CompoundButton;
import com.android.settings.Utils;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.search.Index;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateNotificationBridge extends AppStateBaseBridge {
    private static final int DAYS_TO_CHECK = 7;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_NOTIFICATION_BLOCKED = null;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_NOTIFICATION_FREQUENCY = null;
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_NOTIFICATION_RECENCY = null;
    public static final Comparator<com.android.settingslib.applications.ApplicationsState.AppEntry> FREQUENCY_NOTIFICATION_COMPARATOR = null;
    public static final Comparator<com.android.settingslib.applications.ApplicationsState.AppEntry> RECENT_NOTIFICATION_COMPARATOR = null;
    private final boolean DEBUG;
    private final String TAG;
    private NotificationBackend mBackend;
    private final Context mContext;
    private IUsageStatsManager mUsageStatsManager;
    protected List<Integer> mUserIds;

    public static class NotificationsSentState {
        public int avgSentDaily;
        public int avgSentWeekly;
        public boolean blockable;
        public boolean blocked;
        public long lastSent;
        public int sentCount;

        public NotificationsSentState() {
            this.avgSentDaily = 0;
            this.avgSentWeekly = 0;
            this.lastSent = 0;
            this.sentCount = 0;
        }
    }

    public static CharSequence getSummary(Context r0, NotificationsSentState r1, int r2) {
        return "";
    }

    static /* synthetic */ NotificationsSentState access$000(com.android.settingslib.applications.ApplicationsState.AppEntry r0) {
        return getNotificationsSentState(r0);
    }

    public AppStateNotificationBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3, IUsageStatsManager r4, UserManager r5, NotificationBackend r6) {
        super(r2, r3);
        this.TAG = "AppStateNotificationBridge";
        this.DEBUG = false;
        this.mContext = r1;
        this.mUsageStatsManager = r4;
        this.mBackend = r6;
        ArrayList r7 = new ArrayList();
        this.mUserIds = r7;
        r7.add(Integer.valueOf(r1.getUserId()));
        int r8 = Utils.getManagedProfileId(r5, r1.getUserId());
        if (r8 == (-10000)) goto L6;
        this.mUserIds.add(Integer.valueOf(r8));
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        if (r0 != null) goto L5;
        return;
    L5:
        Map<String, NotificationsSentState> r1 = getAggregatedUsageEvents();
        Iterator<com.android.settingslib.applications.ApplicationsState.AppEntry> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r2.next();
        NotificationsSentState r4 = r1.get(getKey(UserHandle.getUserId(r3.info.uid), r3.info.packageName));
        if (r4 != null) goto L11;
        r4 = new NotificationsSentState();
    L11:
        calculateAvgSentCounts(r4);
        addBlockStatus(r3, r4);
        r3.extraInfo = r4;
        goto L7
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        NotificationsSentState r4 = getAggregatedUsageEvents(UserHandle.getUserId(r1.info.uid), r1.info.packageName);
        calculateAvgSentCounts(r4);
        addBlockStatus(r1, r4);
        r1.extraInfo = r4;
    }

    private void addBlockStatus(com.android.settingslib.applications.ApplicationsState.AppEntry r2, NotificationsSentState r3) {
        if (r3 == null) goto L5;
        r3.blocked = this.mBackend.getNotificationsBanned(r2.info.packageName, r2.info.uid);
        return;
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

    protected Map<String, NotificationsSentState> getAggregatedUsageEvents() {
        ArrayMap r0 = new ArrayMap();
        long r8 = System.currentTimeMillis();
        long r10 = r8 - 604800000;
        Iterator<Integer> r12 = this.mUserIds.iterator();
    L4:
        if (r12.hasNext() == false) goto L23;
        int r13 = r12.next().intValue();
        UsageEvents r1 = this.mUsageStatsManager.queryEventsForUser(r10, r8, r13, this.mContext.getPackageName());     // Catch: RemoteException -> L8
    L10:
        if (r1 == null) goto L4;
        UsageEvents.Event r2 = new UsageEvents.Event();
    L13:
        if (r1.hasNextEvent() == false) goto L4;
        r1.getNextEvent(r2);
        NotificationsSentState r3 = (NotificationsSentState) r0.get(getKey(r13, r2.getPackageName()));
        if (r3 != null) goto L18;
        r3 = new NotificationsSentState();
        r0.put(getKey(r13, r2.getPackageName()), r3);
    L18:
        if (r2.getEventType() != 12) goto L13;
        if (r2.getTimeStamp() <= r3.lastSent) goto L22;
        r3.lastSent = r2.getTimeStamp();
    L22:
        r3.sentCount++;
    L8:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L10
    L23:
        return r0;
    }

    protected NotificationsSentState getAggregatedUsageEvents(int r10, String r11) {
        long r3 = System.currentTimeMillis();
        NotificationsSentState r8 = null;
        UsageEvents r9 = this.mUsageStatsManager.queryEventsForPackageForUser(r3 - 604800000, r3, r10, r11, this.mContext.getPackageName());     // Catch: RemoteException -> L5
    L7:
        if (r9 == null) goto L19;
        UsageEvents.Event r12 = new UsageEvents.Event();
    L10:
        if (r9.hasNextEvent() == false) goto L19;
        r9.getNextEvent(r12);
        if (r12.getEventType() != 12) goto L10;
        if (r8 != null) goto L16;
        r8 = new NotificationsSentState();
    L16:
        if (r12.getTimeStamp() <= r8.lastSent) goto L18;
        r8.lastSent = r12.getTimeStamp();
    L18:
        r8.sentCount++;
    L19:
        return r8;
    L5:
        e = move-exception;
        e.printStackTrace();
        r9 = null;
        goto L7
    }

    private static NotificationsSentState getNotificationsSentState(com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L5;
    L11:
        return null;
    L5:
        if (r2.extraInfo == null) goto L11;
        if ((r2.extraInfo instanceof NotificationsSentState) == false) goto L11;
        return (NotificationsSentState) r2.extraInfo;
    }

    protected static String getKey(int r1, String r2) {
        return r1 + Index.ENTRIES_SEPARATOR + r2;
    }

    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateNotificationBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateNotificationBridge, reason: not valid java name */
    /* synthetic */ void m280x75b0b0d7(com.android.settingslib.applications.ApplicationsState.AppEntry r5, CompoundButton r6, boolean r7) {
        if (RiskPermissionControlGuard.intercept(this.mContext, r5.info.packageName, UserHandle.getUserId(r5.info.uid), 64) == false) goto L6;
        r6.setOnCheckedChangeListener(null);
        r6.setChecked(!r7);
        r6.setOnCheckedChangeListener(getSwitchOnCheckedListener(r5));
        return;
    L6:
        NotificationsSentState r8 = getNotificationsSentState(r5);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.blocked != r7) goto L13;
        this.mBackend.setNotificationsEnabledForPackage(r5.info.packageName, r5.info.uid, r7);
        r8.blocked = !r7;
        return;
    }

    static {
        FILTER_APP_NOTIFICATION_RECENCY = new AnonymousClass1();
        FILTER_APP_NOTIFICATION_FREQUENCY = new AnonymousClass2();
        FILTER_APP_NOTIFICATION_BLOCKED = new AnonymousClass3();
        RECENT_NOTIFICATION_COMPARATOR = new AnonymousClass4();
        FREQUENCY_NOTIFICATION_COMPARATOR = new AnonymousClass5();
    }

    public static final boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r0) {
        NotificationsSentState r1 = getNotificationsSentState(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.blockable;
    }

    public static final boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r0) {
        NotificationsSentState r1 = getNotificationsSentState(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return !r1.blocked;
    }
}
