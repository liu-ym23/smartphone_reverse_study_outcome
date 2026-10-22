package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";

    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* JADX INFO: renamed from: androidx.core.app.NotificationCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;

        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;

        @Nullable
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public Builder(@Nullable IconCompat r11, @Nullable CharSequence r12, @Nullable PendingIntent r13) {
                this(r11, r12, r13, new Bundle(), null, true, 0, true, false);
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L6;
                return;
            L6:
                if (this.mIntent == null) goto L9;
                return;
            L9:
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            public Builder addExtras(Bundle r2) {
                if (r2 == null) goto L4;
                this.mExtras.putAll(r2);
            L4:
                return this;
            }

            public Builder addRemoteInput(RemoteInput r2) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                this.mRemoteInputs.add(r2);
                return this;
            }

            public Action build() {
                checkContextualActionNullFields();
                ArrayList r0 = new ArrayList();
                ArrayList r1 = new ArrayList();
                ArrayList<RemoteInput> r2 = this.mRemoteInputs;
                if (r2 == null) goto L11;
                Iterator<RemoteInput> r3 = r2.iterator();
            L6:
                if (r3.hasNext() == false) goto L11;
                RemoteInput r4 = r3.next();
                if (r4.isDataOnly() == true) goto L9;
                r1.add(r4);
                goto L6
            L9:
                r0.add(r4);
            L11:
                RemoteInput[] r5 = null;
                if (r0.isEmpty() == false) goto L14;
                RemoteInput[] r10 = null;
            L16:
                if (r1.isEmpty() == true) goto L20;
                r5 = (RemoteInput[]) r1.toArray(new RemoteInput[r1.size()]);
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r5, r10, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
            L14:
                r10 = (RemoteInput[]) r0.toArray(new RemoteInput[r0.size()]);
                goto L16
            }

            public Builder extend(Extender r1) {
                r1.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean r1) {
                this.mAllowGeneratedReplies = r1;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean r1) {
                this.mIsContextual = r1;
                return this;
            }

            public Builder setSemanticAction(int r1) {
                this.mSemanticAction = r1;
                return this;
            }

            public Builder setShowsUserInterface(boolean r1) {
                this.mShowsUserInterface = r1;
                return this;
            }

            public Builder(int r12, CharSequence r13, PendingIntent r14) {
                IconCompat r0 = null;
                if (r12 != 0) goto L5;
            L4:
                IconCompat r2 = r0;
                this(r2, r13, r14, new Bundle(), null, true, 0, true, false);
                return;
            L5:
                r0 = IconCompat.createWithResource(null, "", r12);
                goto L4
            }

            public Builder(Action r11) {
                this(r11.getIconCompat(), r11.title, r11.actionIntent, new Bundle(r11.mExtras), r11.getRemoteInputs(), r11.getAllowGeneratedReplies(), r11.getSemanticAction(), r11.mShowsUserInterface, r11.isContextual());
            }

            private Builder(@Nullable IconCompat r2, CharSequence r3, PendingIntent r4, Bundle r5, RemoteInput[] r6, boolean r7, int r8, boolean r9, boolean r10) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r2;
                this.mTitle = Builder.limitCharSequenceLength(r3);
                this.mIntent = r4;
                this.mExtras = r5;
                if (r6 != null) goto L5;
                ArrayList<RemoteInput> r11 = null;
            L6:
                this.mRemoteInputs = r11;
                this.mAllowGeneratedReplies = r7;
                this.mSemanticAction = r8;
                this.mShowsUserInterface = r9;
                this.mIsContextual = r10;
                return;
            L5:
                r11 = new ArrayList(Arrays.asList(r6));
                goto L6
            }
        }

        public interface Extender {
            Builder extend(Builder r1);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            private void setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                this.mFlags = r1 | this.mFlags;
                return;
            L4:
                int r3 = this.mFlags;
                this.mFlags = (~r1) & r3;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m5clone() {
                return clone();
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder r4) {
                Bundle r0 = new Bundle();
                int r1 = this.mFlags;
                if (r1 == 1) goto L5;
                r0.putInt(KEY_FLAGS, r1);
            L5:
                CharSequence r2 = this.mInProgressLabel;
                if (r2 == null) goto L8;
                r0.putCharSequence(KEY_IN_PROGRESS_LABEL, r2);
            L8:
                CharSequence r3 = this.mConfirmLabel;
                if (r3 == null) goto L11;
                r0.putCharSequence(KEY_CONFIRM_LABEL, r3);
            L11:
                CharSequence r5 = this.mCancelLabel;
                if (r5 == null) goto L14;
                r0.putCharSequence(KEY_CANCEL_LABEL, r5);
            L14:
                r4.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r0);
                return r4;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                if ((this.mFlags & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean getHintLaunchesActivity() {
                if ((this.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                if ((this.mFlags & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            public WearableExtender setAvailableOffline(boolean r2) {
                setFlag(1, r2);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence r1) {
                this.mCancelLabel = r1;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence r1) {
                this.mConfirmLabel = r1;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean r2) {
                setFlag(4, r2);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean r2) {
                setFlag(2, r2);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence r1) {
                this.mInProgressLabel = r1;
                return this;
            }

            public WearableExtender clone() {
                WearableExtender r0 = new WearableExtender();
                r0.mFlags = this.mFlags;
                r0.mInProgressLabel = this.mInProgressLabel;
                r0.mConfirmLabel = this.mConfirmLabel;
                r0.mCancelLabel = this.mCancelLabel;
                return r0;
            }

            public WearableExtender(Action r3) {
                this.mFlags = 1;
                Bundle r4 = r3.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r4 == null) goto L6;
                this.mFlags = r4.getInt(KEY_FLAGS, 1);
                this.mInProgressLabel = r4.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r4.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r4.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }
        }

        public Action(int r3, CharSequence r4, PendingIntent r5) {
            IconCompat r0 = null;
            if (r3 == 0) goto L6;
            r0 = IconCompat.createWithResource(null, "", r3);
        L6:
            this(r0, r4, r5);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            if (this.mIcon != null) goto L8;
            int r0 = this.icon;
            if (r0 == 0) goto L8;
            this.mIcon = IconCompat.createWithResource(null, "", r0);
        L8:
            return this.mIcon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public Action(@Nullable IconCompat r12, @Nullable CharSequence r13, @Nullable PendingIntent r14) {
            this(r12, r13, r14, new Bundle(), null, null, true, 0, true, false);
        }

        public Action(int r14, CharSequence r15, PendingIntent r16, Bundle r17, RemoteInput[] r18, RemoteInput[] r19, boolean r20, int r21, boolean r22, boolean r23) {
            IconCompat r1 = null;
            if (r14 == 0) goto L6;
            r1 = IconCompat.createWithResource(null, "", r14);
        L6:
            this(r1, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        }

        public Action(@Nullable IconCompat r3, CharSequence r4, PendingIntent r5, Bundle r6, RemoteInput[] r7, RemoteInput[] r8, boolean r9, int r10, boolean r11, boolean r12) {
            this.mShowsUserInterface = true;
            this.mIcon = r3;
            if (r3 != null) goto L5;
        L7:
            this.title = Builder.limitCharSequenceLength(r4);
            this.actionIntent = r5;
            if (r6 != null) goto L11;
            r6 = new Bundle();
        L11:
            this.mExtras = r6;
            this.mRemoteInputs = r7;
            this.mDataOnlyRemoteInputs = r8;
            this.mAllowGeneratedReplies = r9;
            this.mSemanticAction = r10;
            this.mShowsUserInterface = r11;
            this.mIsContextual = r12;
            return;
        L5:
            if (r3.getType() != 2) goto L7;
            this.icon = r3.getResId();
            goto L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private Bitmap mPicture;

        public BigPictureStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            Notification.BigPictureStyle r3 = new Notification.BigPictureStyle(r2.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
            if (this.mBigLargeIconSet == false) goto L6;
            r3.bigLargeIcon(this.mBigLargeIcon);
        L6:
            if (this.mSummaryTextSet == false) goto L9;
            r3.setSummaryText(this.mSummaryText);
            return;
        }

        public BigPictureStyle bigLargeIcon(Bitmap r1) {
            this.mBigLargeIcon = r1;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap r1) {
            this.mPicture = r1;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle(Builder r1) {
            setBuilder(r1);
        }
    }

    public static class BigTextStyle extends Style {
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            Notification.BigTextStyle r3 = new Notification.BigTextStyle(r2.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet == false) goto L6;
            r3.setSummaryText(this.mSummaryText);
            return;
        }

        public BigTextStyle bigText(CharSequence r1) {
            this.mBigText = Builder.limitCharSequenceLength(r1);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle(Builder r1) {
            setBuilder(r1);
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;

        @DimenRes
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;

            @DimenRes
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;

            public Builder() {
            }

            private Builder setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                this.mFlags = r1 | this.mFlags;
            L5:
                return this;
            L4:
                int r3 = this.mFlags;
                this.mFlags = (~r1) & r3;
                goto L5
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                PendingIntent r1 = this.mPendingIntent;
                if (r1 == null) goto L11;
                IconCompat r3 = this.mIcon;
                if (r3 == null) goto L9;
                return new BubbleMetadata(r1, this.mDeleteIntent, r3, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, null);
            L9:
                throw new IllegalStateException("Must supply an icon for the bubble");
            L11:
                throw new IllegalStateException("Must supply pending intent to bubble");
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean r2) {
                setFlag(1, r2);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent r1) {
                this.mDeleteIntent = r1;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int r2) {
                this.mDesiredHeight = Math.max(r2, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int r1) {
                this.mDesiredHeightResId = r1;
                this.mDesiredHeight = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat r3) {
                if (r3 == null) goto L10;
                if (r3.getType() == 1) goto L8;
                this.mIcon = r3;
                return this;
            L8:
                throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
            L10:
                throw new IllegalArgumentException("Bubbles require non-null icon");
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent r1) {
                if (r1 == null) goto L6;
                this.mPendingIntent = r1;
                return this;
            L6:
                throw new IllegalArgumentException("Bubble requires non-null pending intent");
            }

            @NonNull
            public Builder setSuppressNotification(boolean r2) {
                setFlag(2, r2);
                return this;
            }
        }

        public /* synthetic */ BubbleMetadata(PendingIntent r1, PendingIntent r2, IconCompat r3, int r4, int r5, int r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        @Nullable
        @RequiresApi(29)
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            Builder r0 = new Builder().setAutoExpandBubble(r2.getAutoExpandBubble()).setDeleteIntent(r2.getDeleteIntent()).setIcon(IconCompat.createFromIcon(r2.getIcon())).setIntent(r2.getIntent()).setSuppressNotification(r2.isNotificationSuppressed());
            if (r2.getDesiredHeight() == 0) goto L9;
            r0.setDesiredHeight(r2.getDesiredHeight());
        L9:
            if (r2.getDesiredHeightResId() == 0) goto L12;
            r0.setDesiredHeightResId(r2.getDesiredHeightResId());
        L12:
            return r0.build();
        }

        @Nullable
        @RequiresApi(29)
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(r2.getAutoExpandBubble()).setDeleteIntent(r2.getDeleteIntent()).setIcon(r2.getIcon().toIcon()).setIntent(r2.getIntent()).setSuppressNotification(r2.isNotificationSuppressed());
            if (r2.getDesiredHeight() == 0) goto L9;
            r0.setDesiredHeight(r2.getDesiredHeight());
        L9:
            if (r2.getDesiredHeightResId() == 0) goto L12;
            r0.setDesiredHeightResId(r2.getDesiredHeightResId());
        L12:
            return r0.build();
        }

        public boolean getAutoExpandBubble() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        @NonNull
        public IconCompat getIcon() {
            return this.mIcon;
        }

        @NonNull
        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private BubbleMetadata(PendingIntent r1, PendingIntent r2, IconCompat r3, int r4, @DimenRes int r5, int r6) {
            this.mPendingIntent = r1;
            this.mIcon = r3;
            this.mDesiredHeight = r4;
            this.mDesiredHeightResId = r5;
            this.mDeleteIntent = r2;
            this.mFlags = r6;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        Bitmap mLargeIcon;
        boolean mLocalOnly;
        Notification mNotification;
        int mNumber;

        @Deprecated
        public ArrayList<String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        public Builder(@NonNull Context r4, @NonNull String r5) {
            this.mActions = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            Notification r2 = new Notification();
            this.mNotification = r2;
            this.mContext = r4;
            this.mChannelId = r5;
            r2.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        public static CharSequence limitCharSequenceLength(CharSequence r2) {
            if (r2 != null) goto L5;
            return r2;
        L5:
            if (r2.length() > MAX_CHARSEQUENCE_LENGTH) goto L7;
            return r2;
        L7:
            return r2.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
        }

        private Bitmap reduceLargeIconSize(Bitmap r1) {
            return r1;
        }

        private void setFlag(int r1, boolean r2) {
            if (r2 == false) goto L4;
            Notification r0 = this.mNotification;
            r0.flags = r1 | r0.flags;
            return;
        L4:
            Notification r3 = this.mNotification;
            int r4 = r3.flags;
            r3.flags = (~r1) & r4;
        }

        public Builder addAction(int r3, CharSequence r4, PendingIntent r5) {
            this.mActions.add(new Action(r3, r4, r5));
            return this;
        }

        public Builder addExtras(Bundle r2) {
            if (r2 == null) goto L7;
            Bundle r0 = this.mExtras;
            if (r0 != null) goto L6;
            this.mExtras = new Bundle(r2);
            goto L7
        L6:
            r0.putAll(r2);
        L7:
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(int r2, CharSequence r3, PendingIntent r4) {
            return addInvisibleAction(new Action(r2, r3, r4));
        }

        public Builder addPerson(String r2) {
            this.mPeople.add(r2);
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder extend(Extender r1) {
            r1.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras != null) goto L6;
            this.mExtras = new Bundle();
        L6:
            return this.mExtras;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.mShowWhen == true) goto L7;
            return 0;
        L7:
            return this.mNotification.when;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean r1) {
            this.mAllowSystemGeneratedContextualActions = r1;
            return this;
        }

        public Builder setAutoCancel(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        public Builder setBadgeIconType(int r1) {
            this.mBadgeIcon = r1;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata r1) {
            this.mBubbleMetadata = r1;
            return this;
        }

        public Builder setCategory(String r1) {
            this.mCategory = r1;
            return this;
        }

        public Builder setChannelId(@NonNull String r1) {
            this.mChannelId = r1;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean r3) {
            this.mChronometerCountDown = r3;
            this.mExtras.putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r3);
            return this;
        }

        public Builder setColor(@ColorInt int r1) {
            this.mColor = r1;
            return this;
        }

        public Builder setColorized(boolean r1) {
            this.mColorized = r1;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews r2) {
            this.mNotification.contentView = r2;
            return this;
        }

        public Builder setContentInfo(CharSequence r1) {
            this.mContentInfo = limitCharSequenceLength(r1);
            return this;
        }

        public Builder setContentIntent(PendingIntent r1) {
            this.mContentIntent = r1;
            return this;
        }

        public Builder setContentText(CharSequence r1) {
            this.mContentText = limitCharSequenceLength(r1);
            return this;
        }

        public Builder setContentTitle(CharSequence r1) {
            this.mContentTitle = limitCharSequenceLength(r1);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews r1) {
            this.mBigContentView = r1;
            return this;
        }

        public Builder setCustomContentView(RemoteViews r1) {
            this.mContentView = r1;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews r1) {
            this.mHeadsUpContentView = r1;
            return this;
        }

        public Builder setDefaults(int r2) {
            Notification r0 = this.mNotification;
            r0.defaults = r2;
            if ((r2 & 4) == 0) goto L5;
            r0.flags |= 1;
        L5:
            return this;
        }

        public Builder setDeleteIntent(PendingIntent r2) {
            this.mNotification.deleteIntent = r2;
            return this;
        }

        public Builder setExtras(Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent r1, boolean r2) {
            this.mFullScreenIntent = r1;
            setFlag(128, r2);
            return this;
        }

        public Builder setGroup(String r1) {
            this.mGroupKey = r1;
            return this;
        }

        public Builder setGroupAlertBehavior(int r1) {
            this.mGroupAlertBehavior = r1;
            return this;
        }

        public Builder setGroupSummary(boolean r1) {
            this.mGroupSummary = r1;
            return this;
        }

        public Builder setLargeIcon(Bitmap r1) {
            this.mLargeIcon = reduceLargeIconSize(r1);
            return this;
        }

        public Builder setLights(@ColorInt int r2, int r3, int r4) {
            Notification r0 = this.mNotification;
            r0.ledARGB = r2;
            r0.ledOnMS = r3;
            r0.ledOffMS = r4;
            if (r3 == 0) goto L6;
            if (r4 == 0) goto L6;
            int r5 = 1;
        L7:
            r0.flags = r5 | (r0.flags & (-2));
            return this;
        L6:
            r5 = 0;
            goto L7
        }

        public Builder setLocalOnly(boolean r1) {
            this.mLocalOnly = r1;
            return this;
        }

        @NonNull
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public Builder setNumber(int r1) {
            this.mNumber = r1;
            return this;
        }

        public Builder setOngoing(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean r2) {
            setFlag(8, r2);
            return this;
        }

        public Builder setPriority(int r1) {
            this.mPriority = r1;
            return this;
        }

        public Builder setProgress(int r1, int r2, boolean r3) {
            this.mProgressMax = r1;
            this.mProgress = r2;
            this.mProgressIndeterminate = r3;
            return this;
        }

        public Builder setPublicVersion(Notification r1) {
            this.mPublicVersion = r1;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] r1) {
            this.mRemoteInputHistory = r1;
            return this;
        }

        public Builder setShortcutId(String r1) {
            this.mShortcutId = r1;
            return this;
        }

        public Builder setShowWhen(boolean r1) {
            this.mShowWhen = r1;
            return this;
        }

        public Builder setSmallIcon(int r2) {
            this.mNotification.icon = r2;
            return this;
        }

        public Builder setSortKey(String r1) {
            this.mSortKey = r1;
            return this;
        }

        public Builder setSound(Uri r3) {
            Notification r0 = this.mNotification;
            r0.sound = r3;
            r0.audioStreamType = -1;
            r0.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        public Builder setStyle(Style r2) {
            if (this.mStyle == r2) goto L7;
            this.mStyle = r2;
            if (r2 == null) goto L7;
            r2.setBuilder(this);
        L7:
            return this;
        }

        public Builder setSubText(CharSequence r1) {
            this.mSubText = limitCharSequenceLength(r1);
            return this;
        }

        public Builder setTicker(CharSequence r2) {
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r2);
            return this;
        }

        public Builder setTimeoutAfter(long r1) {
            this.mTimeout = r1;
            return this;
        }

        public Builder setUsesChronometer(boolean r1) {
            this.mUseChronometer = r1;
            return this;
        }

        public Builder setVibrate(long[] r2) {
            this.mNotification.vibrate = r2;
            return this;
        }

        public Builder setVisibility(int r1) {
            this.mVisibility = r1;
            return this;
        }

        public Builder setWhen(long r2) {
            this.mNotification.when = r2;
            return this;
        }

        public Builder addAction(Action r2) {
            this.mActions.add(r2);
            return this;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(Action r2) {
            this.mInvisibleActions.add(r2);
            return this;
        }

        public Builder setSmallIcon(int r2, int r3) {
            Notification r0 = this.mNotification;
            r0.icon = r2;
            r0.iconLevel = r3;
            return this;
        }

        public Builder setTicker(CharSequence r2, RemoteViews r3) {
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r2);
            this.mTickerView = r3;
            return this;
        }

        public Builder setSound(Uri r3, int r4) {
            Notification r0 = this.mNotification;
            r0.sound = r3;
            r0.audioStreamType = r4;
            r0.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(r4).build();
            return this;
        }

        @Deprecated
        public Builder(Context r2) {
            this(r2, null);
        }
    }

    public static final class CarExtender implements Extender {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        @Deprecated
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String r2) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r2;
                }

                public Builder addMessage(String r2) {
                    this.mMessages.add(r2);
                    return this;
                }

                public UnreadConversation build() {
                    List<String> r0 = this.mMessages;
                    String[] r2 = (String[]) r0.toArray(new String[r0.size()]);
                    String[] r6 = {this.mParticipant};
                    return new UnreadConversation(r2, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, r6, this.mLatestTimestamp);
                }

                public Builder setLatestTimestamp(long r1) {
                    this.mLatestTimestamp = r1;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent r1) {
                    this.mReadPendingIntent = r1;
                    return this;
                }

                public Builder setReplyAction(PendingIntent r1, RemoteInput r2) {
                    this.mRemoteInput = r2;
                    this.mReplyPendingIntent = r1;
                    return this;
                }
            }

            public UnreadConversation(String[] r1, RemoteInput r2, PendingIntent r3, PendingIntent r4, String[] r5, long r6) {
                this.mMessages = r1;
                this.mRemoteInput = r2;
                this.mReadPendingIntent = r4;
                this.mReplyPendingIntent = r3;
                this.mParticipants = r5;
                this.mLatestTimestamp = r6;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String[] r1 = this.mParticipants;
                if (r1.length > 0) goto L7;
                return null;
            L7:
                return r1[0];
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        @RequiresApi(21)
        private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation r8) {
            Bundle r0 = new Bundle();
            int r2 = 0;
            if (r8.getParticipants() != null) goto L5;
        L7:
            String r1 = null;
        L8:
            int r3 = r8.getMessages().length;
            Parcelable[] r4 = new Parcelable[r3];
        L9:
            if (r2 >= r3) goto L11;
            Bundle r5 = new Bundle();
            r5.putString(KEY_TEXT, r8.getMessages()[r2]);
            r5.putString(KEY_AUTHOR, r1);
            r4[r2] = r5;
            r2 = r2 + 1;
            goto L9
        L11:
            r0.putParcelableArray(KEY_MESSAGES, r4);
            RemoteInput r6 = r8.getRemoteInput();
            if (r6 == null) goto L14;
            r0.putParcelable(KEY_REMOTE_INPUT, new android.app.RemoteInput.Builder(r6.getResultKey()).setLabel(r6.getLabel()).setChoices(r6.getChoices()).setAllowFreeFormInput(r6.getAllowFreeFormInput()).addExtras(r6.getExtras()).build());
        L14:
            r0.putParcelable(KEY_ON_REPLY, r8.getReplyPendingIntent());
            r0.putParcelable(KEY_ON_READ, r8.getReadPendingIntent());
            r0.putStringArray(KEY_PARTICIPANTS, r8.getParticipants());
            r0.putLong("timestamp", r8.getLatestTimestamp());
            return r0;
        L5:
            if (r8.getParticipants().length <= 1) goto L7;
            r1 = r8.getParticipants()[0];
            goto L8
        }

        @RequiresApi(21)
        private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle r20) {
            RemoteInput r1 = null;
            if (r20 != null) goto L5;
            return null;
        L5:
            Parcelable[] r2 = r20.getParcelableArray(KEY_MESSAGES);
            if (r2 == null) goto L17;
            int r3 = r2.length;
            String[] r4 = new String[r3];
            int r5 = 0;
        L8:
            if (r5 >= r3) goto L16;
            Parcelable r6 = r2[r5];
            if ((r6 instanceof Bundle) == false) goto L14;
            String r7 = ((Bundle) r6).getString(KEY_TEXT);
            r4[r5] = r7;
            if (r7 == null) goto L14;
            r5 = r5 + 1;
        L14:
            return null;
        L16:
            String[] r8 = r4;
        L18:
            PendingIntent r10 = (PendingIntent) r20.getParcelable(KEY_ON_READ);
            PendingIntent r9 = (PendingIntent) r20.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput r11 = (android.app.RemoteInput) r20.getParcelable(KEY_REMOTE_INPUT);
            String[] r12 = r20.getStringArray(KEY_PARTICIPANTS);
            if (r12 != null) goto L21;
            return null;
        L21:
            if (r12.length != 1) goto L31;
            if (r11 == null) goto L26;
            r1 = new RemoteInput(r11.getResultKey(), r11.getLabel(), r11.getChoices(), r11.getAllowFreeFormInput(), r11.getEditChoicesBeforeSending(), r11.getExtras(), null);
        L26:
            return new UnreadConversation(r8, r1, r9, r10, r12, r20.getLong("timestamp"));
        L31:
            return null;
        L17:
            r8 = null;
            goto L18
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r4) {
            Bundle r0 = new Bundle();
            Bitmap r1 = this.mLargeIcon;
            if (r1 == null) goto L5;
            r0.putParcelable(EXTRA_LARGE_ICON, r1);
        L5:
            int r2 = this.mColor;
            if (r2 == 0) goto L8;
            r0.putInt(EXTRA_COLOR, r2);
        L8:
            UnreadConversation r3 = this.mUnreadConversation;
            if (r3 == null) goto L11;
            r0.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r3));
        L11:
            r4.getExtras().putBundle(EXTRA_CAR_EXTENDER, r0);
            return r4;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(@ColorInt int r1) {
            this.mColor = r1;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap r1) {
            this.mLargeIcon = r1;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation r1) {
            this.mUnreadConversation = r1;
            return this;
        }

        public CarExtender(Notification r3) {
            this.mColor = 0;
            if (NotificationCompat.getExtras(r3) != null) goto L5;
            Bundle r4 = null;
        L6:
            if (r4 == null) goto L9;
            this.mLargeIcon = (Bitmap) r4.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = r4.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r4.getBundle(EXTRA_CONVERSATION));
            return;
        L9:
            return;
        L5:
            r4 = NotificationCompat.getExtras(r3).getBundle(EXTRA_CAR_EXTENDER);
            goto L6
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews createRemoteViews(RemoteViews r7, boolean r8) {
            int r2 = 0;
            RemoteViews r0 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            r0.removeAllViews(R.id.actions);
            List<Action> r1 = getNonContextualActions(this.mBuilder.mActions);
            if (r8 == false) goto L10;
            if (r1 == null) goto L10;
            int r9 = Math.min(r1.size(), 3);
            if (r9 <= 0) goto L10;
            int r3 = 0;
        L8:
            if (r3 >= r9) goto L11;
            r0.addView(R.id.actions, generateActionButton(r1.get(r3)));
            r3 = r3 + 1;
        L11:
            r0.setViewVisibility(R.id.actions, r2);
            r0.setViewVisibility(R.id.action_divider, r2);
            buildIntoRemoteViews(r0, r7);
            return r0;
        L10:
            r2 = 8;
            goto L11
        }

        private RemoteViews generateActionButton(Action r7) {
            if (r7.actionIntent != null) goto L5;
            boolean r0 = true;
        L6:
            String r2 = this.mBuilder.mContext.getPackageName();
            if (r0 == false) goto L9;
            int r3 = R.layout.notification_action_tombstone;
        L10:
            RemoteViews r1 = new RemoteViews(r2, r3);
            r1.setImageViewBitmap(R.id.action_image, createColoredBitmap(r7.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
            r1.setTextViewText(R.id.action_text, r7.title);
            if (r0 == true) goto L13;
            r1.setOnClickPendingIntent(R.id.action_container, r7.actionIntent);
        L13:
            r1.setContentDescription(R.id.action_container, r7.title);
            return r1;
        L9:
            r3 = R.layout.notification_action;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private static List<Action> getNonContextualActions(List<Action> r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<Action> r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            Action r1 = r4.next();
            if (r1.isContextual() == true) goto L7;
            r0.add(r1);
            goto L7
        L11:
            return r0;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r1) {
            r1.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }
    }

    public interface Extender {
        Builder extend(Builder r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle addLine(CharSequence r2) {
            this.mTexts.add(Builder.limitCharSequenceLength(r2));
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            Notification.InboxStyle r3 = new Notification.InboxStyle(r2.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L5;
            r3.setSummaryText(this.mSummaryText);
        L5:
            Iterator<CharSequence> r1 = this.mTexts.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            r3.addLine(r1.next());
            goto L7
        }

        public InboxStyle setBigContentTitle(CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle(Builder r2) {
            this.mTexts = new ArrayList();
            setBuilder(r2);
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;

        @Nullable
        private CharSequence mConversationTitle;

        @Nullable
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages;
        private Person mUser;

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";

            @Nullable
            private String mDataMimeType;

            @Nullable
            private Uri mDataUri;
            private Bundle mExtras;

            @Nullable
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence r2, long r3, @Nullable Person r5) {
                this.mExtras = new Bundle();
                this.mText = r2;
                this.mTimestamp = r3;
                this.mPerson = r5;
            }

            @NonNull
            public static Bundle[] getBundleArrayForMessages(List<Message> r4) {
                Bundle[] r0 = new Bundle[r4.size()];
                int r1 = r4.size();
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L5;
                r0[r2] = r4.get(r2).toBundle();
                r2 = r2 + 1;
                goto L3
            L5:
                return r0;
            }

            @Nullable
            public static Message getMessageFromBundle(Bundle r10) {
                if (r10.containsKey(KEY_TEXT) == false) goto L27;
                if (r10.containsKey("time") == false) goto L27;
                if (r10.containsKey(KEY_PERSON) == false) goto L12;
                Person r3 = Person.fromBundle(r10.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L28
            L18:
                Message r4 = new Message(r10.getCharSequence(KEY_TEXT), r10.getLong("time"), r3);     // Catch: ClassCastException -> L28
                if (r10.containsKey("type") == false) goto L24;
                if (r10.containsKey(KEY_DATA_URI) == false) goto L24;
                r4.setData(r10.getString("type"), (Uri) r10.getParcelable(KEY_DATA_URI));     // Catch: ClassCastException -> L28
            L24:
                if (r10.containsKey(KEY_EXTRAS_BUNDLE) == false) goto L26;
                r4.getExtras().putAll(r10.getBundle(KEY_EXTRAS_BUNDLE));     // Catch: ClassCastException -> L28
            L26:
                return r4;
            L12:
                if (r10.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L15;
                r3 = Person.fromAndroidPerson((android.app.Person) r10.getParcelable(KEY_NOTIFICATION_PERSON));     // Catch: ClassCastException -> L28
                goto L18
            L15:
                if (r10.containsKey(KEY_SENDER) == false) goto L17;
                r3 = new Person.Builder().setName(r10.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L28
                goto L18
            L17:
                r3 = null;
            L27:
                return null;
            }

            @NonNull
            public static List<Message> getMessagesFromBundleArray(Parcelable[] r4) {
                ArrayList r0 = new ArrayList(r4.length);
                int r1 = 0;
            L4:
                if (r1 >= r4.length) goto L11;
                Parcelable r2 = r4[r1];
                if ((r2 instanceof Bundle) == false) goto L10;
                Message r3 = getMessageFromBundle((Bundle) r2);
                if (r3 == null) goto L10;
                r0.add(r3);
            L10:
                r1 = r1 + 1;
                goto L4
            L11:
                return r0;
            }

            private Bundle toBundle() {
                Bundle r0 = new Bundle();
                CharSequence r1 = this.mText;
                if (r1 == null) goto L5;
                r0.putCharSequence(KEY_TEXT, r1);
            L5:
                r0.putLong("time", this.mTimestamp);
                Person r2 = this.mPerson;
                if (r2 == null) goto L8;
                r0.putCharSequence(KEY_SENDER, r2.getName());
                r0.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
            L8:
                String r3 = this.mDataMimeType;
                if (r3 == null) goto L11;
                r0.putString("type", r3);
            L11:
                Uri r4 = this.mDataUri;
                if (r4 == null) goto L14;
                r0.putParcelable(KEY_DATA_URI, r4);
            L14:
                Bundle r5 = this.mExtras;
                if (r5 == null) goto L17;
                r0.putBundle(KEY_EXTRAS_BUNDLE, r5);
            L17:
                return r0;
            }

            @Nullable
            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            @Nullable
            public Uri getDataUri() {
                return this.mDataUri;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @Nullable
            public Person getPerson() {
                return this.mPerson;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                Person r0 = this.mPerson;
                if (r0 != null) goto L6;
                return null;
            L6:
                return r0.getName();
            }

            @NonNull
            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String r1, Uri r2) {
                this.mDataMimeType = r1;
                this.mDataUri = r2;
                return this;
            }

            @Deprecated
            public Message(CharSequence r2, long r3, CharSequence r5) {
                this(r2, r3, new Person.Builder().setName(r5).build());
            }
        }

        private MessagingStyle() {
            this.mMessages = new ArrayList();
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(Notification r2) {
            Bundle r3 = NotificationCompat.getExtras(r2);
            if (r3 != null) goto L5;
        L12:
            MessagingStyle r1 = new MessagingStyle();     // Catch: ClassCastException -> L11
            r1.restoreFromCompatExtras(r3);     // Catch: ClassCastException -> L11
            return r1;
        L11:
            return null;
        L5:
            if (r3.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L12;
            if (r3.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L12;
            return null;
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            int r0 = this.mMessages.size() - 1;
        L3:
            if (r0 < 0) goto L11;
            Message r1 = this.mMessages.get(r0);
            if (r1.getPerson() == null) goto L9;
            if (TextUtils.isEmpty(r1.getPerson().getName()) == true) goto L9;
            return r1;
        L9:
            r0 = r0 - 1;
            goto L3
        L11:
            if (this.mMessages.isEmpty() == true) goto L14;
            List<Message> r3 = this.mMessages;
            return r3.get(r3.size() - 1);
        L14:
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            int r0 = this.mMessages.size() - 1;
        L3:
            if (r0 < 0) goto L10;
            Message r2 = this.mMessages.get(r0);
            if (r2.getPerson() == null) goto L9;
            if (r2.getPerson().getName() != null) goto L9;
            return true;
        L9:
            r0 = r0 - 1;
            goto L3
        L10:
            return false;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int r7) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(r7), null);
        }

        private CharSequence makeMessageLine(Message r7) {
            BidiFormatter r0 = BidiFormatter.getInstance();
            SpannableStringBuilder r1 = new SpannableStringBuilder();
            CharSequence r3 = "";
            if (r7.getPerson() != null) goto L5;
            CharSequence r2 = "";
        L6:
            boolean r4 = TextUtils.isEmpty(r2);
            int r5 = ViewCompat.MEASURED_STATE_MASK;
            if (r4 == false) goto L11;
            r2 = this.mUser.getName();
            if (this.mBuilder.getColor() == 0) goto L11;
            r5 = this.mBuilder.getColor();
        L11:
            CharSequence r6 = r0.unicodeWrap(r2);
            r1.append(r6);
            r1.setSpan(makeFontColorSpan(r5), r1.length() - r6.length(), r1.length(), 33);
            if (r7.getText() == null) goto L15;
            r3 = r7.getText();
        L15:
            r1.append("  ").append(r0.unicodeWrap(r3));
            return r1;
        L5:
            r2 = r7.getPerson().getName();
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle r3) {
            super.addCompatExtras(r3);
            r3.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r3.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r3.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r3.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L10;
            r3.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L10:
            Boolean r2 = this.mIsGroupConversation;
            if (r2 == null) goto L14;
            r3.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r2.booleanValue());
            return;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence r4, long r5, CharSequence r7) {
            this.mMessages.add(new Message(r4, r5, new Person.Builder().setName(r7).build()));
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r8) {
            setGroupConversation(isGroupConversation());
            Notification.MessagingStyle r0 = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
            this.mIsGroupConversation.booleanValue();
            r0.setConversationTitle(this.mConversationTitle);
            r0.setGroupConversation(this.mIsGroupConversation.booleanValue());
            Iterator<Message> r7 = this.mMessages.iterator();
        L4:
            if (r7.hasNext() == false) goto L13;
            Message r1 = r7.next();
            Person r2 = r1.getPerson();
            CharSequence r4 = r1.getText();
            long r5 = r1.getTimestamp();
            if (r2 != null) goto L8;
            android.app.Person r3 = null;
        L9:
            Notification.MessagingStyle.Message r6 = new Notification.MessagingStyle.Message(r4, r5, r3);
            if (r1.getDataMimeType() == null) goto L12;
            r6.setData(r1.getDataMimeType(), r1.getDataUri());
        L12:
            r0.addMessage(r6);
            goto L4
        L8:
            r3 = r2.toAndroidPerson();
            goto L9
        L13:
            r0.setBuilder(r8.getBuilder());
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder r0 = this.mBuilder;
            if (r0 != null) goto L5;
        L12:
            Boolean r3 = this.mIsGroupConversation;
            if (r3 != null) goto L15;
            return false;
        L15:
            return r3.booleanValue();
        L5:
            if (r0.mContext.getApplicationInfo().targetSdkVersion >= 28) goto L12;
            if (this.mIsGroupConversation != null) goto L12;
            if (this.mConversationTitle == null) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(Bundle r3) {
            this.mMessages.clear();
            if (r3.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            this.mUser = Person.fromBundle(r3.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            CharSequence r0 = r3.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r0;
            if (r0 != null) goto L9;
            this.mConversationTitle = r3.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r1 = r3.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r1 == null) goto L13;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r1));
        L13:
            if (r3.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L16;
            this.mIsGroupConversation = Boolean.valueOf(r3.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L16:
            return;
        L5:
            this.mUser = new Person.Builder().setName(r3.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        public MessagingStyle setConversationTitle(@Nullable CharSequence r1) {
            this.mConversationTitle = r1;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean r1) {
            this.mIsGroupConversation = Boolean.valueOf(r1);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence r2) {
            this.mMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r2).build();
        }

        public MessagingStyle(@NonNull Person r2) {
            this.mMessages = new ArrayList();
            if (TextUtils.isEmpty(r2.getName()) == true) goto L7;
            this.mUser = r2;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public MessagingStyle addMessage(CharSequence r2, long r3, Person r5) {
            addMessage(new Message(r2, r3, r5));
            return this;
        }

        public MessagingStyle addMessage(Message r2) {
            this.mMessages.add(r2);
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        public Style() {
            this.mSummaryTextSet = false;
        }

        private int calculateTopPadding() {
            Resources r4 = this.mBuilder.mContext.getResources();
            int r0 = r4.getDimensionPixelSize(R.dimen.notification_top_pad);
            int r1 = r4.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float r5 = (constrain(r4.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round((r5 * r1) + ((1.0f - r5) * r0));
        }

        private static float constrain(float r1, float r2, float r3) {
            if (r1 >= r2) goto L6;
            return r2;
        L6:
            if (r1 > r3) goto L8;
            return r1;
        L8:
            return r3;
        }

        private Bitmap createIconWithBackground(int r2, int r3, int r4, int r5) {
            int r0 = R.drawable.notification_icon_background;
            if (r5 != 0) goto L5;
            r5 = 0;
        L5:
            Bitmap r6 = createColoredBitmap(r0, r5, r3);
            Canvas r1 = new Canvas(r6);
            Drawable r7 = this.mBuilder.mContext.getResources().getDrawable(r2).mutate();
            r7.setFilterBitmap(true);
            int r8 = (r3 - r4) / 2;
            int r9 = r4 + r8;
            r7.setBounds(r8, r8, r9, r9);
            r7.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            r7.draw(r1);
            return r6;
        }

        private void hideNormalContent(RemoteViews r2) {
            r2.setViewVisibility(R.id.title, 8);
            r2.setViewVisibility(R.id.text2, 8);
            r2.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle r1) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r1) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews applyStandardTemplate(boolean r12, int r13, boolean r14) {
            Resources r0 = this.mBuilder.mContext.getResources();
            RemoteViews r7 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r13);
            this.mBuilder.getPriority();
            Builder r15 = this.mBuilder;
            int r8 = 0;
            if (r15.mLargeIcon == null) goto L9;
            r7.setViewVisibility(R.id.icon, 0);
            r7.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
            if (r12 == true) goto L7;
        L13:
            CharSequence r16 = this.mBuilder.mContentTitle;
            if (r16 == null) goto L16;
            r7.setTextViewText(R.id.title, r16);
        L16:
            CharSequence r17 = this.mBuilder.mContentText;
            boolean r18 = true;
            if (r17 == null) goto L19;
            r7.setTextViewText(R.id.text, r17);
            boolean r19 = true;
        L20:
            Builder r1 = this.mBuilder;
            CharSequence r2 = r1.mContentInfo;
            if (r2 == null) goto L25;
            r7.setTextViewText(R.id.info, r2);
            r7.setViewVisibility(R.id.info, 0);
        L23:
            r19 = true;
            boolean r10 = true;
        L32:
            CharSequence r3 = this.mBuilder.mSubText;
            if (r3 == null) goto L42;
            r7.setTextViewText(R.id.text, r3);
            CharSequence r4 = this.mBuilder.mContentText;
            if (r4 == null) goto L40;
            r7.setTextViewText(R.id.text2, r4);
            r7.setViewVisibility(R.id.text2, 0);
            if (r14 == false) goto L39;
            r7.setTextViewTextSize(R.id.text, 0, r0.getDimensionPixelSize(R.dimen.notification_subtext_size));
        L39:
            r7.setViewPadding(R.id.line1, 0, 0, 0, 0);
            goto L42
        L40:
            r7.setViewVisibility(R.id.text2, 8);
        L42:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L44;
            r18 = r10;
        L50:
            int r11 = R.id.right_side;
            if (r18 == false) goto L53;
            int r110 = 0;
        L54:
            r7.setViewVisibility(r11, r110);
            int r111 = R.id.line3;
            if (r19 == true) goto L58;
            r8 = 8;
        L58:
            r7.setViewVisibility(r111, r8);
            return r7;
        L53:
            r110 = 8;
            goto L54
        L44:
            if (this.mBuilder.mUseChronometer == false) goto L48;
            r7.setViewVisibility(R.id.chronometer, 0);
            r7.setLong(R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + this.mBuilder.getWhenIfShowing());
            r7.setBoolean(R.id.chronometer, "setStarted", true);
            boolean r112 = this.mBuilder.mChronometerCountDown;
            if (r112 == false) goto L50;
            r7.setChronometerCountDown(R.id.chronometer, r112);
            goto L50
        L48:
            r7.setViewVisibility(R.id.time, 0);
            r7.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
            goto L50
        L25:
            if (r1.mNumber > 0) goto L27;
            r7.setViewVisibility(R.id.info, 8);
            r10 = false;
            goto L32
        L27:
            if (this.mBuilder.mNumber <= r0.getInteger(R.integer.status_bar_notification_info_maxnum)) goto L29;
            r7.setTextViewText(R.id.info, r0.getString(R.string.status_bar_notification_info_overflow));
        L30:
            r7.setViewVisibility(R.id.info, 0);
            goto L23
        L29:
            r7.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L30
        L19:
            r19 = false;
            goto L20
        L7:
            if (this.mBuilder.mNotification.icon == 0) goto L13;
            int r113 = r0.getDimensionPixelSize(R.dimen.notification_right_icon_size);
            int r114 = r113 - (r0.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
            Builder r5 = this.mBuilder;
            r7.setImageViewBitmap(R.id.right_icon, createIconWithBackground(r5.mNotification.icon, r113, r114, r5.getColor()));
            r7.setViewVisibility(R.id.right_icon, 0);
            goto L13
        L9:
            if (r12 == false) goto L13;
            if (r15.mNotification.icon == 0) goto L13;
            r7.setViewVisibility(R.id.icon, 0);
            int r115 = r0.getDimensionPixelSize(R.dimen.notification_large_icon_width) - r0.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int r116 = r0.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Builder r6 = this.mBuilder;
            r7.setImageViewBitmap(R.id.icon, createIconWithBackground(r6.mNotification.icon, r115, r116, r6.getColor()));
            goto L13
        }

        public Notification build() {
            Builder r0 = this.mBuilder;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews r8, RemoteViews r9) {
            hideNormalContent(r8);
            r8.removeAllViews(R.id.notification_main_column);
            r8.addView(R.id.notification_main_column, r9.clone());
            r8.setViewVisibility(R.id.notification_main_column, 0);
            r8.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(Bundle r1) {
        }

        public void setBuilder(Builder r2) {
            if (this.mBuilder == r2) goto L8;
            this.mBuilder = r2;
            if (r2 == null) goto L9;
            r2.setStyle(this);
            return;
        L9:
            return;
        }

        public Bitmap createColoredBitmap(IconCompat r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        private Bitmap createColoredBitmap(int r2, int r3, int r4) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r2), r3, r4);
        }

        private Bitmap createColoredBitmap(IconCompat r3, int r4, int r5) {
            Drawable r2 = r3.loadDrawable(this.mBuilder.mContext);
            if (r5 != 0) goto L5;
            int r6 = r2.getIntrinsicWidth();
        L6:
            if (r5 != 0) goto L8;
            r5 = r2.getIntrinsicHeight();
        L8:
            Bitmap r0 = Bitmap.createBitmap(r6, r5, Bitmap.Config.ARGB_8888);
            r2.setBounds(0, 0, r6, r5);
            if (r4 == 0) goto L11;
            r2.mutate().setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN));
        L11:
            r2.draw(new Canvas(r0));
            return r0;
        L5:
            r6 = r5;
            goto L6
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";

        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;

        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;

        @Deprecated
        public static final int SIZE_DEFAULT = 0;

        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;

        @Deprecated
        public static final int SIZE_LARGE = 4;

        @Deprecated
        public static final int SIZE_MEDIUM = 3;

        @Deprecated
        public static final int SIZE_SMALL = 2;

        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action r4) {
            IconCompat r0 = r4.getIconCompat();
            if (r0 != null) goto L5;
            Icon r1 = null;
        L6:
            Notification.Action.Builder r2 = new Notification.Action.Builder(r1, r4.getTitle(), r4.getActionIntent());
            if (r4.getExtras() == null) goto L9;
            Bundle r3 = new Bundle(r4.getExtras());
        L10:
            r3.putBoolean("android.support.allowGeneratedReplies", r4.getAllowGeneratedReplies());
            r2.setAllowGeneratedReplies(r4.getAllowGeneratedReplies());
            r2.addExtras(r3);
            RemoteInput[] r5 = r4.getRemoteInputs();
            if (r5 == null) goto L16;
            android.app.RemoteInput[] r6 = RemoteInput.fromCompat(r5);
            int r7 = r6.length;
            int r8 = 0;
        L13:
            if (r8 >= r7) goto L16;
            r2.addRemoteInput(r6[r8]);
            r8 = r8 + 1;
        L16:
            return r2.build();
        L9:
            r3 = new Bundle();
            goto L10
        L5:
            r1 = r0.toIcon();
            goto L6
        }

        private void setFlag(int r1, boolean r2) {
            if (r2 == false) goto L4;
            this.mFlags = r1 | this.mFlags;
            return;
        L4:
            int r3 = this.mFlags;
            this.mFlags = (~r1) & r3;
        }

        public WearableExtender addAction(Action r2) {
            this.mActions.add(r2);
            return this;
        }

        public WearableExtender addActions(List<Action> r2) {
            this.mActions.addAll(r2);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification r2) {
            this.mPages.add(r2);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> r2) {
            this.mPages.addAll(r2);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m6clone() {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder r5) {
            Bundle r0 = new Bundle();
            if (this.mActions.isEmpty() == true) goto L9;
            ArrayList<? extends Parcelable> r1 = new ArrayList(this.mActions.size());
            Iterator<Action> r2 = this.mActions.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            r1.add(getActionFromActionCompat(r2.next()));
            goto L6
        L8:
            r0.putParcelableArrayList(KEY_ACTIONS, r1);
        L9:
            int r3 = this.mFlags;
            if (r3 == 1) goto L12;
            r0.putInt(KEY_FLAGS, r3);
        L12:
            PendingIntent r4 = this.mDisplayIntent;
            if (r4 == null) goto L16;
            r0.putParcelable(KEY_DISPLAY_INTENT, r4);
        L16:
            if (this.mPages.isEmpty() == true) goto L18;
            ArrayList<Notification> r6 = this.mPages;
            r0.putParcelableArray(KEY_PAGES, (Parcelable[]) r6.toArray(new Notification[r6.size()]));
        L18:
            Bitmap r7 = this.mBackground;
            if (r7 == null) goto L21;
            r0.putParcelable(KEY_BACKGROUND, r7);
        L21:
            int r8 = this.mContentIcon;
            if (r8 == 0) goto L24;
            r0.putInt(KEY_CONTENT_ICON, r8);
        L24:
            int r9 = this.mContentIconGravity;
            if (r9 == 8388613) goto L27;
            r0.putInt(KEY_CONTENT_ICON_GRAVITY, r9);
        L27:
            int r10 = this.mContentActionIndex;
            if (r10 == (-1)) goto L30;
            r0.putInt(KEY_CONTENT_ACTION_INDEX, r10);
        L30:
            int r11 = this.mCustomSizePreset;
            if (r11 == 0) goto L33;
            r0.putInt(KEY_CUSTOM_SIZE_PRESET, r11);
        L33:
            int r12 = this.mCustomContentHeight;
            if (r12 == 0) goto L36;
            r0.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r12);
        L36:
            int r13 = this.mGravity;
            if (r13 == 80) goto L39;
            r0.putInt(KEY_GRAVITY, r13);
        L39:
            int r14 = this.mHintScreenTimeout;
            if (r14 == 0) goto L42;
            r0.putInt(KEY_HINT_SCREEN_TIMEOUT, r14);
        L42:
            String r15 = this.mDismissalId;
            if (r15 == null) goto L45;
            r0.putString(KEY_DISMISSAL_ID, r15);
        L45:
            String r16 = this.mBridgeTag;
            if (r16 == null) goto L48;
            r0.putString(KEY_BRIDGE_TAG, r16);
        L48:
            r5.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r0);
            return r5;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if ((this.mFlags & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap r1) {
            this.mBackground = r1;
            return this;
        }

        public WearableExtender setBridgeTag(String r1) {
            this.mBridgeTag = r1;
            return this;
        }

        public WearableExtender setContentAction(int r1) {
            this.mContentActionIndex = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int r1) {
            this.mContentIcon = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int r1) {
            this.mContentIconGravity = r1;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean r2) {
            setFlag(1, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int r1) {
            this.mCustomContentHeight = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int r1) {
            this.mCustomSizePreset = r1;
            return this;
        }

        public WearableExtender setDismissalId(String r1) {
            this.mDismissalId = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent r1) {
            this.mDisplayIntent = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int r1) {
            this.mGravity = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean r2) {
            setFlag(32, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean r2) {
            setFlag(64, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int r1) {
            this.mHintScreenTimeout = r1;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean r2) {
            setFlag(4, r2);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean r2) {
            setFlag(8, r2);
            return this;
        }

        public WearableExtender clone() {
            WearableExtender r0 = new WearableExtender();
            r0.mActions = new ArrayList(this.mActions);
            r0.mFlags = this.mFlags;
            r0.mDisplayIntent = this.mDisplayIntent;
            r0.mPages = new ArrayList(this.mPages);
            r0.mBackground = this.mBackground;
            r0.mContentIcon = this.mContentIcon;
            r0.mContentIconGravity = this.mContentIconGravity;
            r0.mContentActionIndex = this.mContentActionIndex;
            r0.mCustomSizePreset = this.mCustomSizePreset;
            r0.mCustomContentHeight = this.mCustomContentHeight;
            r0.mGravity = this.mGravity;
            r0.mHintScreenTimeout = this.mHintScreenTimeout;
            r0.mDismissalId = this.mDismissalId;
            r0.mBridgeTag = this.mBridgeTag;
            return r0;
        }

        public WearableExtender(Notification r11) {
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r12 = NotificationCompat.getExtras(r11);
            if (r12 == null) goto L5;
            Bundle r13 = r12.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r13 == null) goto L19;
            ArrayList r5 = r13.getParcelableArrayList(KEY_ACTIONS);
            if (r5 == null) goto L13;
            int r6 = r5.size();
            Action[] r7 = new Action[r6];
            int r8 = 0;
        L10:
            if (r8 >= r6) goto L12;
            r7[r8] = NotificationCompat.getActionCompatFromAction((Notification.Action) r5.get(r8));
            r8 = r8 + 1;
            goto L10
        L12:
            Collections.addAll(this.mActions, r7);
        L13:
            this.mFlags = r13.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) r13.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] r0 = NotificationCompat.getNotificationArrayFromBundle(r13, KEY_PAGES);
            if (r0 == null) goto L16;
            Collections.addAll(this.mPages, r0);
        L16:
            this.mBackground = (Bitmap) r13.getParcelable(KEY_BACKGROUND);
            this.mContentIcon = r13.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r13.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r13.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r13.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r13.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r13.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = r13.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r13.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r13.getString(KEY_BRIDGE_TAG);
            return;
        L19:
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    public static Action getAction(Notification r0, int r1) {
        return getActionCompatFromAction(r0.actions[r1]);
    }

    @RequiresApi(20)
    public static Action getActionCompatFromAction(Notification.Action r17) {
        android.app.RemoteInput[] r1 = r17.getRemoteInputs();
        IconCompat r3 = null;
        if (r1 != null) goto L5;
        RemoteInput[] r11 = null;
    L11:
        if (r17.getExtras().getBoolean("android.support.allowGeneratedReplies") == false) goto L13;
    L16:
        boolean r13 = true;
    L17:
        boolean r15 = r17.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int r14 = r17.getSemanticAction();
        boolean r16 = r17.isContextual();
        if (r17.getIcon() != null) goto L24;
        int r7 = r17.icon;
        if (r7 == 0) goto L24;
        return new Action(r7, r17.title, r17.actionIntent, r17.getExtras(), r11, null, r13, r14, r15, r16);
    L24:
        if (r17.getIcon() == null) goto L28;
        r3 = IconCompat.createFromIconOrNullIfZeroResId(r17.getIcon());
    L28:
        return new Action(r3, r17.title, r17.actionIntent, r17.getExtras(), r11, null, r13, r14, r15, r16);
    L13:
        if (r17.getAllowGeneratedReplies() == true) goto L16;
        r13 = false;
        goto L17
    L5:
        RemoteInput[] r4 = new RemoteInput[r1.length];
        int r5 = 0;
    L7:
        if (r5 >= r1.length) goto L9;
        android.app.RemoteInput r6 = r1[r5];
        r4[r5] = new RemoteInput(r6.getResultKey(), r6.getLabel(), r6.getChoices(), r6.getAllowFreeFormInput(), r6.getEditChoicesBeforeSending(), r6.getExtras(), null);
        r5 = r5 + 1;
        goto L7
    L9:
        r11 = r4;
        goto L11
    }

    public static int getActionCount(Notification r0) {
        Notification.Action[] r1 = r0.actions;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.length;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification r0) {
        return r0.getAllowSystemGeneratedContextualActions();
    }

    public static int getBadgeIconType(Notification r0) {
        return r0.getBadgeIconType();
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification r0) {
        return BubbleMetadata.fromPlatform(r0.getBubbleMetadata());
    }

    public static String getCategory(Notification r0) {
        return r0.category;
    }

    public static String getChannelId(Notification r0) {
        return r0.getChannelId();
    }

    @RequiresApi(19)
    public static CharSequence getContentTitle(Notification r1) {
        return r1.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(Notification r0) {
        return r0.extras;
    }

    public static String getGroup(Notification r0) {
        return r0.getGroup();
    }

    public static int getGroupAlertBehavior(Notification r0) {
        return r0.getGroupAlertBehavior();
    }

    @RequiresApi(21)
    public static List<Action> getInvisibleActions(Notification r3) {
        ArrayList r0 = new ArrayList();
        Bundle r4 = r3.extras.getBundle("android.car.EXTENSIONS");
        if (r4 != null) goto L5;
        return r0;
    L5:
        Bundle r5 = r4.getBundle("invisible_actions");
        if (r5 == null) goto L11;
        int r1 = 0;
    L9:
        if (r1 >= r5.size()) goto L11;
        r0.add(NotificationCompatJellybean.getActionFromBundle(r5.getBundle(Integer.toString(r1))));
        r1 = r1 + 1;
    L11:
        return r0;
    }

    public static boolean getLocalOnly(Notification r0) {
        if ((r0.flags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Notification[] getNotificationArrayFromBundle(Bundle r4, String r5) {
        Parcelable[] r0 = r4.getParcelableArray(r5);
        if ((r0 instanceof Notification[]) == true) goto L13;
        if (r0 == null) goto L13;
        Notification[] r1 = new Notification[r0.length];
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r1[r2] = (Notification) r0[r2];
        r2 = r2 + 1;
        goto L8
    L10:
        r4.putParcelableArray(r5, r1);
        return r1;
    L13:
        return (Notification[]) r0;
    }

    public static String getShortcutId(Notification r0) {
        return r0.getShortcutId();
    }

    public static String getSortKey(Notification r0) {
        return r0.getSortKey();
    }

    public static long getTimeoutAfter(Notification r2) {
        return r2.getTimeoutAfter();
    }

    public static boolean isGroupSummary(Notification r0) {
        if ((r0.flags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
