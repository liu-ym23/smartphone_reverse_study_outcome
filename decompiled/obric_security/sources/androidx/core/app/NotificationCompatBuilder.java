package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(NotificationCompat.Builder r12) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r12;
        this.mContext = r12.mContext;
        Notification.Builder r0 = new Notification.Builder(r12.mContext, r12.mChannelId);
        this.mBuilder = r0;
        Notification r1 = r12.mNotification;
        Notification.Builder r2 = r0.setWhen(r1.when).setSmallIcon(r1.icon, r1.iconLevel).setContent(r1.contentView).setTicker(r1.tickerText, r12.mTickerView).setVibrate(r1.vibrate).setLights(r1.ledARGB, r1.ledOnMS, r1.ledOffMS);
        if ((r1.flags & 2) == 0) goto L5;
        boolean r3 = true;
    L6:
        Notification.Builder r4 = r2.setOngoing(r3);
        if ((r1.flags & 8) == 0) goto L9;
        boolean r5 = true;
    L10:
        Notification.Builder r6 = r4.setOnlyAlertOnce(r5);
        if ((r1.flags & 16) == 0) goto L13;
        boolean r7 = true;
    L14:
        Notification.Builder r8 = r6.setAutoCancel(r7).setDefaults(r1.defaults).setContentTitle(r12.mContentTitle).setContentText(r12.mContentText).setContentInfo(r12.mContentInfo).setContentIntent(r12.mContentIntent).setDeleteIntent(r1.deleteIntent);
        PendingIntent r9 = r12.mFullScreenIntent;
        if ((r1.flags & 128) == 0) goto L17;
        boolean r10 = true;
    L18:
        r8.setFullScreenIntent(r9, r10).setLargeIcon(r12.mLargeIcon).setNumber(r12.mNumber).setProgress(r12.mProgressMax, r12.mProgress, r12.mProgressIndeterminate);
        r0.setSubText(r12.mSubText).setUsesChronometer(r12.mUseChronometer).setPriority(r12.mPriority);
        Iterator<NotificationCompat.Action> r11 = r12.mActions.iterator();
    L20:
        if (r11.hasNext() == false) goto L23;
        addAction(r11.next());
        goto L20
    L23:
        if (r12.mExtras == null) goto L25;
        this.mExtras.putAll(r12.mExtras);
    L25:
        this.mContentView = r12.mContentView;
        this.mBigContentView = r12.mBigContentView;
        this.mBuilder.setShowWhen(r12.mShowWhen);
        this.mBuilder.setLocalOnly(r12.mLocalOnly).setGroup(r12.mGroupKey).setGroupSummary(r12.mGroupSummary).setSortKey(r12.mSortKey);
        this.mGroupAlertBehavior = r12.mGroupAlertBehavior;
        this.mBuilder.setCategory(r12.mCategory).setColor(r12.mColor).setVisibility(r12.mVisibility).setPublicVersion(r12.mPublicVersion).setSound(r1.sound, r1.audioAttributes);
        ArrayList<String> r13 = r12.mPeople;
        if (r13 != null) goto L28;
    L33:
        this.mHeadsUpContentView = r12.mHeadsUpContentView;
        if (r12.mInvisibleActions.size() <= 0) goto L44;
        Bundle r14 = r12.getExtras().getBundle("android.car.EXTENSIONS");
        if (r14 != null) goto L38;
        r14 = new Bundle();
    L38:
        Bundle r15 = new Bundle(r14);
        Bundle r16 = new Bundle();
        int r17 = 0;
    L40:
        if (r17 >= r12.mInvisibleActions.size()) goto L42;
        r16.putBundle(Integer.toString(r17), NotificationCompatJellybean.getBundleForAction(r12.mInvisibleActions.get(r17)));
        r17 = r17 + 1;
        goto L40
    L42:
        r14.putBundle("invisible_actions", r16);
        r15.putBundle("invisible_actions", r16);
        r12.getExtras().putBundle("android.car.EXTENSIONS", r14);
        this.mExtras.putBundle("android.car.EXTENSIONS", r15);
    L44:
        if (r12.mSmallIcon == null) goto L46;
        this.mBuilder.setSmallIcon(r12.mSmallIcon);
    L46:
        this.mBuilder.setExtras(r12.mExtras).setRemoteInputHistory(r12.mRemoteInputHistory);
        if (r12.mContentView == null) goto L50;
        this.mBuilder.setCustomContentView(r12.mContentView);
    L50:
        if (r12.mBigContentView == null) goto L53;
        this.mBuilder.setCustomBigContentView(r12.mBigContentView);
    L53:
        if (r12.mHeadsUpContentView == null) goto L55;
        this.mBuilder.setCustomHeadsUpContentView(r12.mHeadsUpContentView);
    L55:
        this.mBuilder.setBadgeIconType(r12.mBadgeIcon).setSettingsText(r12.mSettingsText).setShortcutId(r12.mShortcutId).setTimeoutAfter(r12.mTimeout).setGroupAlertBehavior(r12.mGroupAlertBehavior);
        if (r12.mColorizedSet == false) goto L59;
        this.mBuilder.setColorized(r12.mColorized);
    L59:
        if (TextUtils.isEmpty(r12.mChannelId) == true) goto L61;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L61:
        Iterator<Person> r18 = r12.mPersonList.iterator();
    L63:
        if (r18.hasNext() == false) goto L65;
        this.mBuilder.addPerson(r18.next().toAndroidPerson());
        goto L63
    L65:
        this.mBuilder.setAllowSystemGeneratedContextualActions(r12.mAllowSystemGeneratedContextualActions);
        this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(r12.mBubbleMetadata));
        if (r12.mLocusId == null) goto L69;
        this.mBuilder.setLocusId(r12.mLocusId.toLocusId());
    L69:
        if (Build.VERSION.SDK_INT < 31) goto L74;
        if (r12.mFgsDeferBehavior == 0) goto L74;
        this.mBuilder.setForegroundServiceBehavior(r12.mFgsDeferBehavior);
    L74:
        if (r12.mSilent == true) goto L76;
        return;
    L76:
        if (this.mBuilderCompat.mGroupSummary == false) goto L78;
        this.mGroupAlertBehavior = 2;
    L79:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        r1.defaults &= -2;
        r1.defaults &= -3;
        this.mBuilder.setDefaults(r1.defaults);
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L82;
        this.mBuilder.setGroup(NotificationCompat.GROUP_KEY_SILENT);
    L82:
        this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
        return;
    L78:
        this.mGroupAlertBehavior = 1;
        goto L79
    L28:
        if (r13.isEmpty() == true) goto L33;
        Iterator<String> r19 = r13.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        this.mBuilder.addPerson(r19.next());
        goto L31
    L17:
        r10 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private static List<String> combineLists(List<String> r3, List<String> r4) {
        if (r3 != null) goto L4;
        return r4;
    L4:
        if (r4 != null) goto L6;
        return r3;
    L6:
        ArraySet r0 = new ArraySet(r3.size() + r4.size());
        r0.addAll(r3);
        r0.addAll(r4);
        return new ArrayList(r0);
    }

    private static List<String> getPeople(List<Person> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<Person> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next().resolveToLegacyUri());
        goto L7
    L9:
        return r0;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }

    public Notification build() {
        NotificationCompat.Style r0 = this.mBuilderCompat.mStyle;
        if (r0 == null) goto L5;
        r0.apply(this);
    L5:
        if (r0 == null) goto L7;
        RemoteViews r1 = r0.makeContentView(this);
    L8:
        Notification r2 = buildInternal();
        if (r1 == null) goto L12;
        r2.contentView = r1;
    L14:
        if (r0 == null) goto L18;
        RemoteViews r3 = r0.makeBigContentView(this);
        if (r3 == null) goto L18;
        r2.bigContentView = r3;
    L18:
        if (r0 == null) goto L22;
        RemoteViews r4 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r4 == null) goto L22;
        r2.headsUpContentView = r4;
    L22:
        if (r0 == null) goto L26;
        Bundle r5 = NotificationCompat.getExtras(r2);
        if (r5 == null) goto L26;
        r0.addCompatExtras(r5);
    L26:
        return r2;
    L12:
        if (this.mBuilderCompat.mContentView == null) goto L14;
        r2.contentView = this.mBuilderCompat.mContentView;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    private void addAction(NotificationCompat.Action r6) {
        IconCompat r0 = r6.getIconCompat();
        if (r0 == null) goto L5;
        Icon r1 = r0.toIcon();
    L6:
        Notification.Action.Builder r2 = new Notification.Action.Builder(r1, r6.getTitle(), r6.getActionIntent());
        if (r6.getRemoteInputs() == null) goto L12;
        android.app.RemoteInput[] r3 = RemoteInput.fromCompat(r6.getRemoteInputs());
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L12;
        r2.addRemoteInput(r3[r5]);
        r5 = r5 + 1;
    L12:
        if (r6.getExtras() == null) goto L14;
        Bundle r7 = new Bundle(r6.getExtras());
    L15:
        r7.putBoolean("android.support.allowGeneratedReplies", r6.getAllowGeneratedReplies());
        r2.setAllowGeneratedReplies(r6.getAllowGeneratedReplies());
        r7.putInt("android.support.action.semanticAction", r6.getSemanticAction());
        r2.setSemanticAction(r6.getSemanticAction());
        r2.setContextual(r6.isContextual());
        if (Build.VERSION.SDK_INT < 31) goto L18;
        r2.setAuthenticationRequired(r6.isAuthenticationRequired());
    L18:
        r7.putBoolean("android.support.action.showsUserInterface", r6.getShowsUserInterface());
        r2.addExtras(r7);
        this.mBuilder.addAction(r2.build());
        return;
    L14:
        r7 = new Bundle();
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    protected Notification buildInternal() {
        return this.mBuilder.build();
    }

    private void removeSoundAndVibration(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        r1.defaults &= -2;
        r1.defaults &= -3;
    }
}
