package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.content.LocusIdCompat;
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
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(NotificationCompat.Builder r15) {
        int r0 = Build.VERSION.SDK_INT;
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = r15;
        this.mContext = r15.mContext;
        Context r3 = r15.mContext;
        if (r0 < 26) goto L5;
        Notification.Builder r2 = new Notification.Builder(r3, r15.mChannelId);
    L6:
        this.mBuilder = r2;
        Notification r4 = r15.mNotification;
        Notification.Builder r5 = this.mBuilder.setWhen(r4.when).setSmallIcon(r4.icon, r4.iconLevel).setContent(r4.contentView).setTicker(r4.tickerText, r15.mTickerView).setVibrate(r4.vibrate).setLights(r4.ledARGB, r4.ledOnMS, r4.ledOffMS);
        if ((r4.flags & 2) == 0) goto L9;
        boolean r6 = true;
    L10:
        Notification.Builder r7 = r5.setOngoing(r6);
        if ((r4.flags & 8) == 0) goto L13;
        boolean r8 = true;
    L14:
        Notification.Builder r9 = r7.setOnlyAlertOnce(r8);
        if ((r4.flags & 16) == 0) goto L17;
        boolean r10 = true;
    L18:
        Notification.Builder r11 = r9.setAutoCancel(r10).setDefaults(r4.defaults).setContentTitle(r15.mContentTitle).setContentText(r15.mContentText).setContentInfo(r15.mContentInfo).setContentIntent(r15.mContentIntent).setDeleteIntent(r4.deleteIntent);
        PendingIntent r12 = r15.mFullScreenIntent;
        if ((r4.flags & 128) == 0) goto L21;
        boolean r13 = true;
    L22:
        r11.setFullScreenIntent(r12, r13).setLargeIcon(r15.mLargeIcon).setNumber(r15.mNumber).setProgress(r15.mProgressMax, r15.mProgress, r15.mProgressIndeterminate);
        if (r0 >= 21) goto L26;
        this.mBuilder.setSound(r4.sound, r4.audioStreamType);
    L26:
        if (r0 < 16) goto L50;
        this.mBuilder.setSubText(r15.mSubText).setUsesChronometer(r15.mUseChronometer).setPriority(r15.mPriority);
        Iterator<NotificationCompat.Action> r14 = r15.mActions.iterator();
    L29:
        if (r14.hasNext() == false) goto L31;
        addAction(r14.next());
        goto L29
    L31:
        Bundle r16 = r15.mExtras;
        if (r16 == null) goto L34;
        this.mExtras.putAll(r16);
    L34:
        if (r0 < 20) goto L36;
    L48:
        this.mContentView = r15.mContentView;
        this.mBigContentView = r15.mBigContentView;
        goto L50
    L36:
        if (r15.mLocalOnly == false) goto L38;
        this.mExtras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
    L38:
        String r17 = r15.mGroupKey;
        if (r17 == null) goto L45;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, r17);
        if (r15.mGroupSummary == false) goto L43;
        Bundle r18 = this.mExtras;
        String r19 = NotificationCompatExtras.EXTRA_GROUP_SUMMARY;
    L44:
        r18.putBoolean(r19, true);
        goto L45
    L43:
        r18 = this.mExtras;
        r19 = NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL;
    L45:
        String r20 = r15.mSortKey;
        if (r20 == null) goto L48;
        this.mExtras.putString(NotificationCompatExtras.EXTRA_SORT_KEY, r20);
    L50:
        if (r0 < 17) goto L53;
        this.mBuilder.setShowWhen(r15.mShowWhen);
    L53:
        if (r0 < 19) goto L60;
        if (r0 >= 21) goto L60;
        List<String> r21 = combineLists(getPeople(r15.mPersonList), r15.mPeople);
        if (r21 == null) goto L60;
        if (r21.isEmpty() == true) goto L60;
        this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) r21.toArray(new String[r21.size()]));
    L60:
        if (r0 < 20) goto L63;
        this.mBuilder.setLocalOnly(r15.mLocalOnly).setGroup(r15.mGroupKey).setGroupSummary(r15.mGroupSummary).setSortKey(r15.mSortKey);
        this.mGroupAlertBehavior = r15.mGroupAlertBehavior;
    L63:
        if (r0 < 21) goto L86;
        this.mBuilder.setCategory(r15.mCategory).setColor(r15.mColor).setVisibility(r15.mVisibility).setPublicVersion(r15.mPublicVersion).setSound(r4.sound, r4.audioAttributes);
        if (r0 >= 28) goto L67;
        List r22 = combineLists(getPeople(r15.mPersonList), r15.mPeople);
    L68:
        if (r22 != null) goto L70;
    L75:
        this.mHeadsUpContentView = r15.mHeadsUpContentView;
        if (r15.mInvisibleActions.size() <= 0) goto L86;
        Bundle r23 = r15.getExtras().getBundle("android.car.EXTENSIONS");
        if (r23 != null) goto L80;
        r23 = new Bundle();
    L80:
        Bundle r24 = new Bundle(r23);
        Bundle r110 = new Bundle();
        int r111 = 0;
    L82:
        if (r111 >= r15.mInvisibleActions.size()) goto L84;
        r110.putBundle(Integer.toString(r111), NotificationCompatJellybean.getBundleForAction(r15.mInvisibleActions.get(r111)));
        r111 = r111 + 1;
        goto L82
    L84:
        r23.putBundle("invisible_actions", r110);
        r24.putBundle("invisible_actions", r110);
        r15.getExtras().putBundle("android.car.EXTENSIONS", r23);
        this.mExtras.putBundle("android.car.EXTENSIONS", r24);
        goto L86
    L70:
        if (r22.isEmpty() == true) goto L75;
        Iterator r25 = r22.iterator();
    L73:
        if (r25.hasNext() == false) goto L75;
        this.mBuilder.addPerson((String) r25.next());
        goto L73
    L67:
        r22 = r15.mPeople;
    L86:
        if (r0 < 23) goto L91;
        Icon r26 = r15.mSmallIcon;
        if (r26 == null) goto L91;
        this.mBuilder.setSmallIcon(r26);
    L91:
        if (r0 < 24) goto L102;
        this.mBuilder.setExtras(r15.mExtras).setRemoteInputHistory(r15.mRemoteInputHistory);
        RemoteViews r27 = r15.mContentView;
        if (r27 == null) goto L95;
        this.mBuilder.setCustomContentView(r27);
    L95:
        RemoteViews r28 = r15.mBigContentView;
        if (r28 == null) goto L98;
        this.mBuilder.setCustomBigContentView(r28);
    L98:
        RemoteViews r29 = r15.mHeadsUpContentView;
        if (r29 == null) goto L102;
        this.mBuilder.setCustomHeadsUpContentView(r29);
    L102:
        if (r0 < 26) goto L109;
        this.mBuilder.setBadgeIconType(r15.mBadgeIcon).setSettingsText(r15.mSettingsText).setShortcutId(r15.mShortcutId).setTimeoutAfter(r15.mTimeout).setGroupAlertBehavior(r15.mGroupAlertBehavior);
        if (r15.mColorizedSet == false) goto L107;
        this.mBuilder.setColorized(r15.mColorized);
    L107:
        if (TextUtils.isEmpty(r15.mChannelId) == true) goto L109;
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
    L109:
        if (r0 < 28) goto L115;
        Iterator<Person> r30 = r15.mPersonList.iterator();
    L112:
        if (r30.hasNext() == false) goto L115;
        this.mBuilder.addPerson(r30.next().toAndroidPerson());
    L115:
        if (r0 < 29) goto L120;
        this.mBuilder.setAllowSystemGeneratedContextualActions(r15.mAllowSystemGeneratedContextualActions);
        this.mBuilder.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(r15.mBubbleMetadata));
        LocusIdCompat r31 = r15.mLocusId;
        if (r31 == null) goto L120;
        this.mBuilder.setLocusId(r31.toLocusId());
    L120:
        if (r0 < 31) goto L125;
        int r32 = r15.mFgsDeferBehavior;
        if (r32 == 0) goto L125;
        this.mBuilder.setForegroundServiceBehavior(r32);
    L125:
        if (r15.mSilent == true) goto L127;
        return;
    L127:
        if (this.mBuilderCompat.mGroupSummary == false) goto L129;
        this.mGroupAlertBehavior = 2;
    L130:
        this.mBuilder.setVibrate(null);
        this.mBuilder.setSound(null);
        int r112 = r4.defaults & (-2);
        r4.defaults = r112;
        int r113 = r112 & (-3);
        r4.defaults = r113;
        this.mBuilder.setDefaults(r113);
        if (r0 >= 26) goto L133;
        return;
    L133:
        if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey) == false) goto L135;
        this.mBuilder.setGroup(NotificationCompat.GROUP_KEY_SILENT);
    L135:
        this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
        return;
    L129:
        this.mGroupAlertBehavior = 1;
        goto L130
    L21:
        r13 = false;
        goto L22
    L17:
        r10 = false;
        goto L18
    L13:
        r8 = false;
        goto L14
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = new Notification.Builder(r3);
        goto L6
    }

    private void addAction(NotificationCompat.Action r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L39;
        IconCompat r1 = r7.getIconCompat();
        int r3 = 0;
        if (r0 < 23) goto L12;
        if (r1 == null) goto L9;
        Icon r2 = r1.toIcon();
    L10:
        Notification.Action.Builder r4 = new Notification.Action.Builder(r2, r7.getTitle(), r7.getActionIntent());
    L17:
        if (r7.getRemoteInputs() == null) goto L22;
        android.app.RemoteInput[] r5 = RemoteInput.fromCompat(r7.getRemoteInputs());
        int r6 = r5.length;
    L19:
        if (r3 >= r6) goto L22;
        r4.addRemoteInput(r5[r3]);
        r3 = r3 + 1;
    L22:
        if (r7.getExtras() == null) goto L24;
        Bundle r8 = new Bundle(r7.getExtras());
    L25:
        r8.putBoolean("android.support.allowGeneratedReplies", r7.getAllowGeneratedReplies());
        if (r0 < 24) goto L28;
        r4.setAllowGeneratedReplies(r7.getAllowGeneratedReplies());
    L28:
        r8.putInt("android.support.action.semanticAction", r7.getSemanticAction());
        if (r0 < 28) goto L32;
        r4.setSemanticAction(r7.getSemanticAction());
    L32:
        if (r0 < 29) goto L35;
        r4.setContextual(r7.isContextual());
    L35:
        if (r0 < 31) goto L37;
        r4.setAuthenticationRequired(r7.isAuthenticationRequired());
    L37:
        r8.putBoolean("android.support.action.showsUserInterface", r7.getShowsUserInterface());
        r4.addExtras(r8);
        this.mBuilder.addAction(r4.build());
        return;
    L24:
        r8 = new Bundle();
        goto L25
    L9:
        r2 = null;
        goto L10
    L12:
        if (r1 == null) goto L14;
        int r9 = r1.getResId();
    L15:
        r4 = new Notification.Action.Builder(r9, r7.getTitle(), r7.getActionIntent());
        goto L17
    L14:
        r9 = 0;
        goto L15
    L39:
        if (r0 < 16) goto L44;
        this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, r7));
        return;
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> r3, @Nullable List<String> r4) {
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

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> r2) {
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

    private void removeSoundAndVibration(Notification r1) {
        r1.sound = null;
        r1.vibrate = null;
        int r0 = r1.defaults & (-2);
        r1.defaults = r0;
        r1.defaults = r0 & (-3);
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
    L10:
        r2.contentView = r1;
    L14:
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 16) goto L21;
        if (r0 == null) goto L21;
        RemoteViews r4 = r0.makeBigContentView(this);
        if (r4 == null) goto L21;
        r2.bigContentView = r4;
    L21:
        if (r3 < 21) goto L26;
        if (r0 == null) goto L26;
        RemoteViews r5 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (r5 == null) goto L26;
        r2.headsUpContentView = r5;
    L26:
        if (r3 < 16) goto L31;
        if (r0 == null) goto L31;
        Bundle r6 = NotificationCompat.getExtras(r2);
        if (r6 == null) goto L31;
        r0.addCompatExtras(r6);
    L31:
        return r2;
    L11:
        r1 = this.mBuilderCompat.mContentView;
        if (r1 == null) goto L14;
    L7:
        r1 = null;
        goto L8
    }

    protected Notification buildInternal() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        return this.mBuilder.build();
    L7:
        if (r0 < 24) goto L26;
        Notification r1 = this.mBuilder.build();
        if (this.mGroupAlertBehavior != 0) goto L11;
    L24:
        return r1;
    L11:
        if (r1.getGroup() == null) goto L18;
        if ((r1.flags & 512) == 0) goto L18;
        if (this.mGroupAlertBehavior != 2) goto L18;
        removeSoundAndVibration(r1);
    L18:
        if (r1.getGroup() == null) goto L24;
        if ((r1.flags & 512) != 0) goto L24;
        if (this.mGroupAlertBehavior != 1) goto L24;
        removeSoundAndVibration(r1);
        goto L24
    L26:
        if (r0 < 21) goto L54;
        this.mBuilder.setExtras(this.mExtras);
        Notification r2 = this.mBuilder.build();
        RemoteViews r3 = this.mContentView;
        if (r3 == null) goto L30;
        r2.contentView = r3;
    L30:
        RemoteViews r4 = this.mBigContentView;
        if (r4 == null) goto L33;
        r2.bigContentView = r4;
    L33:
        RemoteViews r5 = this.mHeadsUpContentView;
        if (r5 == null) goto L37;
        r2.headsUpContentView = r5;
    L37:
        if (this.mGroupAlertBehavior != 0) goto L39;
    L52:
        return r2;
    L39:
        if (r2.getGroup() == null) goto L46;
        if ((r2.flags & 512) == 0) goto L46;
        if (this.mGroupAlertBehavior != 2) goto L46;
        removeSoundAndVibration(r2);
    L46:
        if (r2.getGroup() == null) goto L52;
        if ((r2.flags & 512) != 0) goto L52;
        if (this.mGroupAlertBehavior != 1) goto L52;
        removeSoundAndVibration(r2);
        goto L52
    L54:
        if (r0 < 20) goto L79;
        this.mBuilder.setExtras(this.mExtras);
        Notification r6 = this.mBuilder.build();
        RemoteViews r7 = this.mContentView;
        if (r7 == null) goto L58;
        r6.contentView = r7;
    L58:
        RemoteViews r8 = this.mBigContentView;
        if (r8 == null) goto L62;
        r6.bigContentView = r8;
    L62:
        if (this.mGroupAlertBehavior != 0) goto L64;
    L77:
        return r6;
    L64:
        if (r6.getGroup() == null) goto L71;
        if ((r6.flags & 512) == 0) goto L71;
        if (this.mGroupAlertBehavior != 2) goto L71;
        removeSoundAndVibration(r6);
    L71:
        if (r6.getGroup() == null) goto L77;
        if ((r6.flags & 512) != 0) goto L77;
        if (this.mGroupAlertBehavior != 1) goto L77;
        removeSoundAndVibration(r6);
        goto L77
    L79:
        if (r0 < 19) goto L91;
        SparseArray<Bundle> r9 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r9 == null) goto L83;
        this.mExtras.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r9);
    L83:
        this.mBuilder.setExtras(this.mExtras);
        Notification r10 = this.mBuilder.build();
        RemoteViews r11 = this.mContentView;
        if (r11 == null) goto L86;
        r10.contentView = r11;
    L86:
        RemoteViews r12 = this.mBigContentView;
        if (r12 == null) goto L89;
        r10.bigContentView = r12;
    L89:
        return r10;
    L91:
        if (r0 < 16) goto L109;
        Notification r13 = this.mBuilder.build();
        Bundle r14 = NotificationCompat.getExtras(r13);
        Bundle r15 = new Bundle(this.mExtras);
        Iterator<String> r16 = this.mExtras.keySet().iterator();
    L94:
        if (r16.hasNext() == false) goto L98;
        String r17 = r16.next();
        if (r14.containsKey(r17) == false) goto L94;
        r15.remove(r17);
        goto L94
    L98:
        r14.putAll(r15);
        SparseArray<Bundle> r18 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (r18 == null) goto L101;
        NotificationCompat.getExtras(r13).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, r18);
    L101:
        RemoteViews r19 = this.mContentView;
        if (r19 == null) goto L104;
        r13.contentView = r19;
    L104:
        RemoteViews r20 = this.mBigContentView;
        if (r20 == null) goto L107;
        r13.bigContentView = r20;
    L107:
        return r13;
    L109:
        return this.mBuilder.getNotification();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }
}
