package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    public NotificationCompatBuilder(NotificationCompat.Builder r11) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r11;
        Notification.Builder r0 = new Notification.Builder(r11.mContext, r11.mChannelId);
        this.mBuilder = r0;
        Notification r1 = r11.mNotification;
        Notification.Builder r2 = r0.setWhen(r1.when).setSmallIcon(r1.icon, r1.iconLevel).setContent(r1.contentView).setTicker(r1.tickerText, r11.mTickerView).setVibrate(r1.vibrate).setLights(r1.ledARGB, r1.ledOnMS, r1.ledOffMS);
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
        Notification.Builder r8 = r6.setAutoCancel(r7).setDefaults(r1.defaults).setContentTitle(r11.mContentTitle).setContentText(r11.mContentText).setContentInfo(r11.mContentInfo).setContentIntent(r11.mContentIntent).setDeleteIntent(r1.deleteIntent);
        PendingIntent r9 = r11.mFullScreenIntent;
        if ((r1.flags & 128) == 0) goto L17;
        boolean r10 = true;
    L18:
        r8.setFullScreenIntent(r9, r10).setLargeIcon(r11.mLargeIcon).setNumber(r11.mNumber).setProgress(r11.mProgressMax, r11.mProgress, r11.mProgressIndeterminate);
        r0.setSubText(r11.mSubText).setUsesChronometer(r11.mUseChronometer).setPriority(r11.mPriority);
        Iterator<NotificationCompat.Action> r12 = r11.mActions.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        addAction(r12.next());
        goto L20
    L22:
        Bundle r13 = r11.mExtras;
        if (r13 == null) goto L25;
        this.mExtras.putAll(r13);
    L25:
        this.mContentView = r11.mContentView;
        this.mBigContentView = r11.mBigContentView;
        this.mBuilder.setShowWhen(r11.mShowWhen);
        this.mBuilder.setLocalOnly(r11.mLocalOnly).setGroup(r11.mGroupKey).setGroupSummary(r11.mGroupSummary).setSortKey(r11.mSortKey);
        this.mGroupAlertBehavior = r11.mGroupAlertBehavior;
        this.mBuilder.setCategory(r11.mCategory).setColor(r11.mColor).setVisibility(r11.mVisibility).setPublicVersion(r11.mPublicVersion).setSound(r1.sound, r1.audioAttributes);
        Iterator<String> r14 = r11.mPeople.iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        this.mBuilder.addPerson(r14.next());
        goto L27
    L29:
        this.mHeadsUpContentView = r11.mHeadsUpContentView;
        if (r11.mInvisibleActions.size() <= 0) goto L39;
        Bundle r15 = r11.getExtras().getBundle("android.car.EXTENSIONS");
        if (r15 != null) goto L34;
        r15 = new Bundle();
    L34:
        Bundle r16 = new Bundle();
        int r17 = 0;
    L36:
        if (r17 >= r11.mInvisibleActions.size()) goto L38;
        r16.putBundle(Integer.toString(r17), NotificationCompatJellybean.getBundleForAction(r11.mInvisibleActions.get(r17)));
        r17 = r17 + 1;
        goto L36
    L38:
        r15.putBundle("invisible_actions", r16);
        r11.getExtras().putBundle("android.car.EXTENSIONS", r15);
        this.mExtras.putBundle("android.car.EXTENSIONS", r15);
    L39:
        this.mBuilder.setExtras(r11.mExtras).setRemoteInputHistory(r11.mRemoteInputHistory);
        RemoteViews r18 = r11.mContentView;
        if (r18 == null) goto L42;
        this.mBuilder.setCustomContentView(r18);
    L42:
        RemoteViews r19 = r11.mBigContentView;
        if (r19 == null) goto L45;
        this.mBuilder.setCustomBigContentView(r19);
    L45:
        RemoteViews r20 = r11.mHeadsUpContentView;
        if (r20 == null) goto L48;
        this.mBuilder.setCustomHeadsUpContentView(r20);
    L48:
        this.mBuilder.setBadgeIconType(r11.mBadgeIcon).setShortcutId(r11.mShortcutId).setTimeoutAfter(r11.mTimeout).setGroupAlertBehavior(r11.mGroupAlertBehavior);
        if (r11.mColorizedSet == false) goto L52;
        this.mBuilder.setColorized(r11.mColorized);
    L52:
        if (TextUtils.isEmpty(r11.mChannelId) == true) goto L54;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L54:
        this.mBuilder.setAllowSystemGeneratedContextualActions(r11.mAllowSystemGeneratedContextualActions);
        this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(r11.mBubbleMetadata));
        if (r11.mSilent == true) goto L57;
        return;
    L57:
        if (this.mBuilderCompat.mGroupSummary == false) goto L59;
        this.mGroupAlertBehavior = 2;
    L60:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        int r110 = r1.defaults & (-4);
        r1.defaults = r110;
        this.mBuilder.setDefaults(r110);
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L63;
        this.mBuilder.setGroup(NotificationCompat.GROUP_KEY_SILENT);
    L63:
        this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
        return;
    L59:
        this.mGroupAlertBehavior = 1;
        goto L60
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

    private void removeSoundAndVibration(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        r1.defaults &= -4;
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
        if (r1 == null) goto L11;
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
    L11:
        RemoteViews r6 = this.mBuilderCompat.mContentView;
        if (r6 == null) goto L14;
        r2.contentView = r6;
        goto L14
    L7:
        r1 = null;
        goto L8
    }

    public Notification buildInternal() {
        return this.mBuilder.build();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }
}
