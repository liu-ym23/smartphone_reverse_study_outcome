package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public DecoratedMediaCustomViewStyle() {
        }

        private void setBackgroundColor(RemoteViews r3) {
            int r0 = this.mBuilder.getColor();
            androidx.core.app.NotificationCompat.Builder r2 = this.mBuilder;
            if (r0 == 0) goto L5;
            int r4 = r2.getColor();
        L6:
            r3.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", r4);
            return;
        L5:
            r4 = r2.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            goto L6
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r3.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            return;
        L5:
            super.apply(r3);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int r1) {
            if (r1 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow_custom;
        L6:
            return R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return R.layout.notification_template_media_custom;
        L6:
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r3) {
            int r4 = Build.VERSION.SDK_INT;
            if (r4 < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getBigContentView() == null) goto L8;
            RemoteViews r1 = this.mBuilder.getBigContentView();
        L9:
            if (r1 != null) goto L11;
            return null;
        L11:
            RemoteViews r0 = generateBigContentView();
            buildIntoRemoteViews(r0, r1);
            if (r4 < 21) goto L14;
            setBackgroundColor(r0);
        L14:
            return r0;
        L8:
            r1 = this.mBuilder.getContentView();
            goto L9
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r6) {
            int r7 = Build.VERSION.SDK_INT;
            if (r7 < 24) goto L5;
            return null;
        L5:
            boolean r2 = true;
            if (this.mBuilder.getContentView() == null) goto L8;
            boolean r1 = true;
        L10:
            if (r7 < 21) goto L22;
            if (r1 == false) goto L13;
        L16:
            if (r2 == false) goto L26;
            RemoteViews r8 = generateContentView();
            if (r1 == false) goto L20;
            buildIntoRemoteViews(r8, this.mBuilder.getContentView());
        L20:
            setBackgroundColor(r8);
            return r8;
        L26:
            return null;
        L13:
            if (this.mBuilder.getBigContentView() != null) goto L16;
            r2 = false;
            goto L16
        L22:
            RemoteViews r9 = generateContentView();
            if (r1 == false) goto L26;
            buildIntoRemoteViews(r9, this.mBuilder.getContentView());
            return r9;
        L8:
            r1 = false;
            goto L10
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r3) {
            int r4 = Build.VERSION.SDK_INT;
            if (r4 < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getHeadsUpContentView() == null) goto L8;
            RemoteViews r1 = this.mBuilder.getHeadsUpContentView();
        L9:
            if (r1 != null) goto L11;
            return null;
        L11:
            RemoteViews r0 = generateBigContentView();
            buildIntoRemoteViews(r0, r1);
            if (r4 < 21) goto L14;
            setBackgroundColor(r0);
        L14:
            return r0;
        L8:
            r1 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r2) {
            this.mActionsToShowInCompact = null;
            setBuilder(r2);
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r4) {
            if (r4.getActionIntent() != null) goto L5;
            boolean r0 = true;
        L6:
            RemoteViews r1 = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            int r3 = R.id.action0;
            r1.setImageViewResource(r3, r4.getIcon());
            if (r0 == true) goto L10;
            r1.setOnClickPendingIntent(r3, r4.getActionIntent());
        L10:
            if (Build.VERSION.SDK_INT < 15) goto L12;
            r1.setContentDescription(r3, r4.getTitle());
        L12:
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        public static MediaSessionCompat.Token getMediaSession(Notification r3) {
            Bundle r4 = androidx.core.app.NotificationCompat.getExtras(r3);
            if (r4 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Parcelable r5 = r4.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r5 != null) goto L9;
            return null;
        L9:
            return MediaSessionCompat.Token.b(r5);
        L10:
            IBinder r6 = BundleCompat.getBinder(r4, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r6 == null) goto L17;
            Parcel r0 = Parcel.obtain();
            r0.writeStrongBinder(r6);
            r0.setDataPosition(0);
            MediaSessionCompat.Token r7 = MediaSessionCompat.Token.CREATOR.createFromParcel(r0);
            r0.recycle();
            return r7;
        L17:
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r3.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
            return;
        L6:
            if (this.mShowCancelButton == false) goto L10;
            r3.getBuilder().setOngoing(true);
            return;
        }

        @RequiresApi(21)
        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r2) {
            int[] r0 = this.mActionsToShowInCompact;
            if (r0 == null) goto L5;
            r2.setShowActionsInCompactView(r0);
        L5:
            MediaSessionCompat.Token r1 = this.mToken;
            if (r1 == null) goto L8;
            r2.setMediaSession((MediaSession.Token) r1.f());
        L8:
            return r2;
        }

        RemoteViews generateBigContentView() {
            int r0 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r1 = applyStandardTemplate(false, getBigContentViewLayoutResource(r0), false);
            r1.removeAllViews(R.id.media_actions);
            if (r0 <= 0) goto L8;
            int r3 = 0;
        L5:
            if (r3 >= r0) goto L8;
            r1.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(r3)));
            r3 = r3 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            int r2 = R.id.cancel_action;
            r1.setViewVisibility(r2, 0);
            r1.setInt(r2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            r1.setOnClickPendingIntent(r2, this.mCancelButtonIntent);
        L11:
            return r1;
        L10:
            r1.setViewVisibility(R.id.cancel_action, 8);
            goto L11
        }

        RemoteViews generateContentView() {
            RemoteViews r0 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r3 = this.mBuilder.mActions.size();
            int[] r4 = this.mActionsToShowInCompact;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            r0.removeAllViews(R.id.media_actions);
            if (r5 <= 0) goto L15;
            int r6 = 0;
        L9:
            if (r6 >= r5) goto L15;
            if (r6 >= r3) goto L13;
            r0.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[r6])));
            r6 = r6 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r6), Integer.valueOf(r3 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r0.setViewVisibility(R.id.end_padder, 8);
            int r2 = R.id.cancel_action;
            r0.setViewVisibility(r2, 0);
            r0.setOnClickPendingIntent(r2, this.mCancelButtonIntent);
            r0.setInt(r2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        L18:
            return r0;
        L17:
            r0.setViewVisibility(R.id.end_padder, 0);
            r0.setViewVisibility(R.id.cancel_action, 8);
            goto L18
        L5:
            r5 = Math.min(r4.length, 3);
            goto L6
        }

        int getBigContentViewLayoutResource(int r1) {
            if (r1 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow;
        L6:
            return R.layout.notification_template_big_media;
        }

        int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r2) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateBigContentView();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r2) {
            if (Build.VERSION.SDK_INT < 21) goto L7;
            return null;
        L7:
            return generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r1) {
            this.mCancelButtonIntent = r1;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token r1) {
            this.mToken = r1;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... r1) {
            this.mActionsToShowInCompact = r1;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean r3) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            this.mShowCancelButton = r3;
        L5:
            return this;
        }
    }

    private NotificationCompat() {
    }
}
