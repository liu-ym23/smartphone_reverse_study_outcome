package com.android.settings.notification;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.INotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.AdaptNotificationManager;
import com.android.settings.CopyablePreference;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationStation extends SettingsPreferenceFragment {
    private static final boolean DEBUG = false;
    private static final boolean DUMP_EXTRAS = true;
    private static final boolean DUMP_PARCEL = true;
    private static final String TAG = "NotificationStation";
    private Context mContext;
    private Handler mHandler;
    private final NotificationListenerService mListener;
    private INotificationManager mNoMan;
    private final Comparator<HistoricalNotificationInfo> mNotificationSorter;
    private PackageManager mPm;
    private NotificationListenerService.RankingMap mRanking;
    private Runnable mRefreshListRunnable;

    private static class HistoricalNotificationInfo {
        public boolean active;
        public CharSequence extra;
        public Drawable icon;
        public String pkg;
        public Drawable pkgicon;
        public CharSequence pkgname;
        public int priority;
        public long timestamp;
        public CharSequence title;
        public int user;

        private HistoricalNotificationInfo() {
        }

        /* synthetic */ HistoricalNotificationInfo(AnonymousClass1 r1) {
            this();
        }
    }

    private static class HistoricalNotificationPreference extends CopyablePreference {
        private final HistoricalNotificationInfo mInfo;

        @Override // androidx.preference.Preference
        public void performClick() {
        }

        public HistoricalNotificationPreference(Context r1, HistoricalNotificationInfo r2) {
            super(r1);
            setLayoutResource(R.layout.notification_log_row);
            this.mInfo = r2;
        }

        @Override // com.android.settings.CopyablePreference, androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r4) {
            super.onBindViewHolder(r4);
            if (this.mInfo.icon == null) goto L6;
            ((ImageView) r4.findViewById(R.id.icon)).setImageDrawable(this.mInfo.icon);
        L6:
            if (this.mInfo.pkgicon == null) goto L8;
            ((ImageView) r4.findViewById(R.id.pkgicon)).setImageDrawable(this.mInfo.pkgicon);
        L8:
            r4.findViewById(R.id.timestamp).setTime(this.mInfo.timestamp);
            ((TextView) r4.findViewById(R.id.title)).setText(this.mInfo.title);
            ((TextView) r4.findViewById(R.id.pkgname)).setText(this.mInfo.pkgname);
            final TextView r0 = (TextView) r4.findViewById(R.id.extra);
            r0.setText(this.mInfo.extra);
            r0.setVisibility(8);
            r4.itemView.setOnClickListener(new AnonymousClass1(this, r0));
            View r5 = r4.itemView;
            if (this.mInfo.active == false) goto L11;
            float r3 = 1.0f;
        L12:
            r5.setAlpha(r3);
            return;
        L11:
            r3 = 0.5f;
            goto L12
        }

        @Override // com.android.settings.CopyablePreference
        public CharSequence getCopyableText() {
            return new SpannableStringBuilder(this.mInfo.title).append(" [").append(new Date(this.mInfo.timestamp).toString()).append("]\n").append(this.mInfo.pkgname).append("\n").append(this.mInfo.extra);
        }
    }

    static {
    }

    private static void logd(String r0, Object... r1) {
    }

    public void com_android_settings_notification_NotificationStation__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationStation() {
        this.mRefreshListRunnable = new AnonymousClass1(this);
        this.mListener = new AnonymousClass2(this);
        this.mNotificationSorter = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(NotificationStation r0) {
        r0.refreshList();
    }

    static /* synthetic */ void access$100(String r0, Object[] r1) {
        logd(r0, r1);
    }

    static /* synthetic */ NotificationListenerService.RankingMap access$200(NotificationStation r0) {
        return r0.mRanking;
    }

    static /* synthetic */ NotificationListenerService.RankingMap access$202(NotificationStation r0, NotificationListenerService.RankingMap r1) {
        r0.mRanking = r1;
        return r1;
    }

    static /* synthetic */ void access$300(NotificationStation r0) {
        r0.scheduleRefreshList();
    }

    private void scheduleRefreshList() {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.mRefreshListRunnable);
        this.mHandler.postDelayed(this.mRefreshListRunnable, 100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r4) {
        logd("onAttach(%s)", new Object[]{r4.getClass().getSimpleName()});
        super.onAttach(r4);
        this.mHandler = new Handler(r4.getMainLooper());
        this.mContext = r4;
        this.mPm = r4.getPackageManager();
        this.mNoMan = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        logd("onDetach()", new Object[0]);
        this.mHandler.removeCallbacks(this.mRefreshListRunnable);
        this.mHandler = null;
        super.onDetach();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mListener.unregisterAsSystemService();     // Catch: RemoteException -> L4
    L6:
        super.onPause();
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "Cannot unregister listener", e);
        goto L6
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        logd("onActivityCreated(%s)", new Object[]{r3});
        super.onActivityCreated(r3);
    }

    public void com_android_settings_notification_NotificationStation__onResume$___twin___() {
        logd("onResume()", new Object[0]);
        super.onResume();
        this.mListener.registerAsSystemService(this.mContext, new ComponentName(this.mContext.getPackageName(), getClass().getCanonicalName()), ActivityManager.getCurrentUser());     // Catch: RemoteException -> L5
    L7:
        refreshList();
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "Cannot register listener", e);
        goto L7
    }

    private void refreshList() {
        List<HistoricalNotificationInfo> r0 = loadNotifications();
        if (r0 == null) goto L10;
        int r1 = r0.size();
        int r4 = 0;
        logd("adding %d infos", new Object[]{Integer.valueOf(r1)});
        Collections.sort(r0, this.mNotificationSorter);
        if (getPreferenceScreen() != null) goto L7;
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getContext()));
    L7:
        getPreferenceScreen().removeAll();
    L8:
        if (r4 >= r1) goto L12;
        getPreferenceScreen().addPreference(new HistoricalNotificationPreference(getPrefContext(), r0.get(r4)));
        r4 = r4 + 1;
        goto L8
    L12:
        return;
    }

    private static CharSequence bold(CharSequence r3) {
        if (r3.length() != 0) goto L5;
        return r3;
    L5:
        SpannableString r0 = new SpannableString(r3);
        r0.setSpan(new StyleSpan(1), 0, r3.length(), 0);
        return r0;
    }

    private static String getTitleString(Notification r2) {
        if (r2.extras == null) goto L7;
        CharSequence r0 = r2.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = r2.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
    L9:
        if (TextUtils.isEmpty(r0) == false) goto L14;
        if (TextUtils.isEmpty(r2.tickerText) == true) goto L14;
        r0 = r2.tickerText;
    L14:
        return String.valueOf(r0);
    L7:
        r0 = null;
        goto L9
    }

    private static String formatPendingIntent(PendingIntent r2) {
        StringBuilder r0 = new StringBuilder("Intent(pkg=");
        IntentSender r3 = r2.getIntentSender();
        r0.append(r3.getCreatorPackage());
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        r0.append(")");
        return r0.toString();
    L4:
        if (ActivityManagerNative.getDefault().isIntentSenderAnActivity(r3.getTarget()) == false) goto L9;
        r0.append(" (activity)");     // Catch: RemoteException -> L7
        goto L9
    }

    private List<HistoricalNotificationInfo> loadNotifications() {
        int r2 = ActivityManager.getCurrentUser();
        AnonymousClass1 r3 = null;
        StatusBarNotification[] r4 = this.mNoMan.getActiveNotifications(this.mContext.getPackageName());     // Catch: RemoteException -> L110
        StatusBarNotification[] r5 = AdaptNotificationManager.getHistoricalNotifications(this.mNoMan, this.mContext.getPackageName(), 50);     // Catch: RemoteException -> L110
        ArrayList r6 = new ArrayList(r4.length + r5.length);     // Catch: RemoteException -> L110
        NotificationListenerService.Ranking r7 = new NotificationListenerService.Ranking();     // Catch: RemoteException -> L110
        int r8 = 2;
        int r10 = 0;
        boolean r11 = true;
        StatusBarNotification[][] r9 = {r4, r5};     // Catch: RemoteException -> L110
        int r12 = 0;
    L4:
        if (r12 >= r8) goto L109;
        StatusBarNotification[] r13 = r9[r12];     // Catch: RemoteException -> L110
        int r14 = r13.length;     // Catch: RemoteException -> L110
        int r15 = r10;
    L6:
        if (r15 >= r14) goto L108;
        StatusBarNotification r16 = r13[r15];     // Catch: RemoteException -> L110
        if (r16.getUserId() == (-1)) goto L10;
        boolean r17 = r11;
    L12:
        if (r16.getUserId() == r2) goto L14;
        boolean r18 = r11;
    L16:
        if ((r17 & r18) == false) goto L18;
        StatusBarNotification[] r20 = r4;
        NotificationListenerService.Ranking r21 = r7;
        boolean r19 = r11;
        StatusBarNotification[] r22 = r13;
        int r23 = 0;
        int r24 = 2;
    L107:
        r15 = r15 + 1;
        r10 = r23;
        r11 = r19;
        r8 = r24;
        r2 = r2;
        r9 = r9;
        r4 = r20;
        r7 = r21;
        r13 = r22;
        r3 = null;
        goto L6
    L18:
        Notification r25 = r16.getNotification();     // Catch: RemoteException -> L110
        HistoricalNotificationInfo r110 = new HistoricalNotificationInfo(r3);     // Catch: RemoteException -> L110
        r110.pkg = r16.getPackageName();     // Catch: RemoteException -> L110
        r110.user = r16.getUserId();     // Catch: RemoteException -> L110
        r110.icon = loadIconDrawable(r110.pkg, r110.user, r25.icon);     // Catch: RemoteException -> L110
        r110.pkgicon = loadPackageIconDrawable(r110.pkg, r110.user);     // Catch: RemoteException -> L110
        r110.pkgname = loadPackageName(r110.pkg);     // Catch: RemoteException -> L110
        r110.title = getTitleString(r25);     // Catch: RemoteException -> L110
        if (TextUtils.isEmpty(r110.title) == false) goto L21;
        r110.title = getString(R.string.notification_log_no_title);     // Catch: RemoteException -> L110
    L21:
        r110.timestamp = r16.getPostTime();     // Catch: RemoteException -> L110
        r110.priority = r25.priority;     // Catch: RemoteException -> L110
        if (r13 != r4) goto L24;
        boolean r26 = true;
    L25:
        r110.active = r26;     // Catch: RemoteException -> L110
        SpannableStringBuilder r27 = new SpannableStringBuilder();     // Catch: RemoteException -> L110
        String r28 = getString(R.string.notification_log_details_delimiter);     // Catch: RemoteException -> L110
        r27.append(bold(getString(R.string.notification_log_details_package))).append(r28).append(r110.pkg).append("\n").append(bold(getString(R.string.notification_log_details_key))).append(r28).append(r16.getKey());     // Catch: RemoteException -> L110
        r27.append("\n").append(bold(getString(R.string.notification_log_details_icon))).append(r28).append(r25.getSmallIcon().toString());     // Catch: RemoteException -> L110
        if (r16.isGroup() == false) goto L30;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_group))).append(r28).append(r16.getGroupKey());     // Catch: RemoteException -> L110
        if (r25.isGroupSummary() == false) goto L30;
        r27.append(bold(getString(R.string.notification_log_details_group_summary)));     // Catch: RemoteException -> L110
    L30:
        r27.append("\n").append(bold(getString(R.string.notification_log_details_sound))).append(r28);     // Catch: RemoteException -> L110
        if ((r25.defaults & 1) == 0) goto L34;
        r27.append(getString(R.string.notification_log_details_default));     // Catch: RemoteException -> L110
    L37:
        r27.append("\n").append(bold(getString(R.string.notification_log_details_vibrate))).append(r28);     // Catch: RemoteException -> L110
        if ((r25.defaults & 2) == 0) goto L41;
        r27.append(getString(R.string.notification_log_details_default));     // Catch: RemoteException -> L110
    L49:
        r27.append("\n").append(bold(getString(R.string.notification_log_details_visibility))).append(r28).append(Notification.visibilityToString(r25.visibility));     // Catch: RemoteException -> L110
        if (r25.publicVersion == null) goto L52;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_public_version))).append(r28).append(getTitleString(r25.publicVersion));     // Catch: RemoteException -> L110
    L52:
        r27.append("\n").append(bold(getString(R.string.notification_log_details_priority))).append(r28).append(Notification.priorityToString(r25.priority));     // Catch: RemoteException -> L110
        if (r13 != r4) goto L66;
        NotificationListenerService.RankingMap r29 = this.mRanking;     // Catch: RemoteException -> L110
        if (r29 == null) goto L62;
        if (r29.getRanking(r16.getKey(), r7) == false) goto L62;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_importance))).append(r28).append(NotificationListenerService.Ranking.importanceToString(r7.getImportance()));     // Catch: RemoteException -> L110
        if (r7.getImportanceExplanation() == null) goto L66;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_explanation))).append(r28).append(r7.getImportanceExplanation());     // Catch: RemoteException -> L110
    L62:
        if (this.mRanking != null) goto L64;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_ranking_null)));     // Catch: RemoteException -> L110
        goto L66
    L64:
        r27.append("\n").append(bold(getString(R.string.notification_log_details_ranking_none)));     // Catch: RemoteException -> L110
    L66:
        if (r25.contentIntent == null) goto L69;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_content_intent))).append(r28).append(formatPendingIntent(r25.contentIntent));     // Catch: RemoteException -> L110
    L69:
        if (r25.deleteIntent == null) goto L72;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_delete_intent))).append(r28).append(formatPendingIntent(r25.deleteIntent));     // Catch: RemoteException -> L110
    L72:
        if (r25.fullScreenIntent == null) goto L76;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_full_screen_intent))).append(r28).append(formatPendingIntent(r25.fullScreenIntent));     // Catch: RemoteException -> L110
    L76:
        if (r25.actions != null) goto L78;
    L91:
        r20 = r4;
        r21 = r7;
        r22 = r13;
        if (r25.contentView == null) goto L95;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_content_view))).append(r28).append(r25.contentView.toString());     // Catch: RemoteException -> L110
    L95:
        if (r25.extras != null) goto L97;
    L106:
        Parcel r30 = Parcel.obtain();     // Catch: RemoteException -> L110
        r25.writeToParcel(r30, 0);     // Catch: RemoteException -> L110
        r27.append("\n").append(bold(getString(R.string.notification_log_details_parcel))).append(r28).append(String.valueOf(r30.dataPosition())).append(TokenParser.SP).append(bold(getString(R.string.notification_log_details_ashmem))).append(r28).append("\n");     // Catch: RemoteException -> L110
        r30.recycle();     // Catch: RemoteException -> L110
        r110.extra = r27;     // Catch: RemoteException -> L110
        r23 = 0;
        r19 = true;
        r24 = 2;
        logd("   [%d] %s: %s", new Object[]{Long.valueOf(r110.timestamp), r110.pkg, r110.title});     // Catch: RemoteException -> L110
        r6.add(r110);     // Catch: RemoteException -> L110
        goto L107
    L97:
        if (r25.extras.size() <= 0) goto L106;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_extras)));     // Catch: RemoteException -> L110
        Iterator<String> r31 = r25.extras.keySet().iterator();     // Catch: RemoteException -> L110
    L100:
        if (r31.hasNext() == false) goto L106;
        String r32 = r31.next();     // Catch: RemoteException -> L110
        String r33 = String.valueOf(r25.extras.get(r32));     // Catch: RemoteException -> L110
        if (r33.length() <= 100) goto L105;
        r33 = r33.substring(0, 100) + "...";     // Catch: RemoteException -> L110
    L105:
        r27.append("\n  ").append(r32).append(r28).append(r33);     // Catch: RemoteException -> L110
        r31 = r31;
        goto L100
    L78:
        if (r25.actions.length <= 0) goto L91;
        r27.append("\n").append(bold(getString(R.string.notification_log_details_actions)));     // Catch: RemoteException -> L110
        int r34 = 0;
    L81:
        if (r34 >= r25.actions.length) goto L91;
        Notification.Action r111 = r25.actions[r34];     // Catch: RemoteException -> L110
        StatusBarNotification[] r210 = r4;
        NotificationListenerService.Ranking r211 = r7;
        r27.append("\n  ").append(String.valueOf(r34)).append(TokenParser.SP).append(bold(getString(R.string.notification_log_details_title))).append(r28).append(r111.title);     // Catch: RemoteException -> L110
        if (r111.actionIntent == null) goto L88;
        r27.append("\n    ").append(bold(getString(R.string.notification_log_details_content_intent))).append(r28).append(formatPendingIntent(r111.actionIntent));     // Catch: RemoteException -> L110
    L88:
        if (r111.getRemoteInputs() == null) goto L90;
        r27.append("\n    ").append(bold(getString(R.string.notification_log_details_remoteinput))).append(r28).append(String.valueOf(r111.getRemoteInputs().length));     // Catch: RemoteException -> L110
    L90:
        r34 = r34 + 1;     // Catch: RemoteException -> L110
        r4 = r210;
        r7 = r211;
        r13 = r13;
        goto L81
    L41:
        if (r25.vibrate == null) goto L48;
        int r35 = 0;
    L44:
        if (r35 >= r25.vibrate.length) goto L49;
        if (r35 <= 0) goto L47;
        r27.append(',');     // Catch: RemoteException -> L110
    L47:
        r27.append(String.valueOf(r25.vibrate[r35]));     // Catch: RemoteException -> L110
        r35 = r35 + 1;     // Catch: RemoteException -> L110
        goto L44
    L48:
        r27.append(getString(R.string.notification_log_details_none));     // Catch: RemoteException -> L110
        goto L49
    L34:
        if (r25.sound == null) goto L36;
        r27.append(r25.sound.toString());     // Catch: RemoteException -> L110
        goto L37
    L36:
        r27.append(getString(R.string.notification_log_details_none));     // Catch: RemoteException -> L110
        goto L37
    L24:
        r26 = false;
        goto L25
    L14:
        r18 = false;
        goto L16
    L10:
        r17 = false;
        goto L12
    L108:
        r12 = r12 + 1;
        r8 = r8;
        r9 = r9;
        r7 = r7;
        r3 = null;
        goto L4
    L109:
        return r6;
    L110:
        e = move-exception;
        OLog.e(TAG, "Cannot load Notifications: ", e);
        return null;
    }

    private Resources getResourcesForUserPackage(String r3, int r4) {
        if (r3 == null) goto L12;
        if (r4 != (-1)) goto L13;
        r4 = 0;
    L13:
        return this.mPm.getResourcesForApplicationAsUser(r3, r4);
    L8:
        e = move-exception;
        OLog.e(TAG, "Icon package not found: " + r3, e);
        return null;
    L12:
        return this.mContext.getResources();
    }

    private Drawable loadPackageIconDrawable(String r1, int r2) {
        return this.mPm.getApplicationIcon(r1);
    L4:
        e = move-exception;
        OLog.e(TAG, "Cannot get application icon", e);
        return null;
    }

    private CharSequence loadPackageName(String r3) {
        ApplicationInfo r0 = this.mPm.getApplicationInfo(r3, 8192);     // Catch: PackageManager.NameNotFoundException -> L6
        if (r0 == null) goto L8;
        return this.mPm.getApplicationLabel(r0);
    L8:
        return r3;
    L6:
        e = move-exception;
        OLog.e(TAG, "Cannot load package name", e);
        goto L8
    }

    private Drawable loadIconDrawable(String r4, int r5, int r6) {
        Resources r3 = (Resources) NullSafe.nonNull(getResourcesForUserPackage(r4, r5));
        if (r6 != 0) goto L14;
        return null;
    L14:
        return r3.getDrawable(r6, null);
    L7:
        e = move-exception;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder("Icon not found in ");
        if (r4 == null) goto L11;
        Object r7 = Integer.valueOf(r6);
    L12:
        OLog.w(r0, r1.append(r7).append(": ").append(Integer.toHexString(r6)).toString(), e);
        return null;
    L11:
        r7 = "<system>";
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationStation r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_NotificationStation__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationStation r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationStation_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationStation r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_NotificationStation__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
