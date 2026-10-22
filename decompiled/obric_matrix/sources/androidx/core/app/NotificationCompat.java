package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
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
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
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
import java.util.Objects;

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
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";

    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";

    @SuppressLint({"ActionValue"})
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
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";

    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
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
    static /* synthetic */ class AnonymousClass1 {
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
        private boolean mAuthenticationRequired;
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
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public Builder(int r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
                IconCompat r0 = null;
                if (r13 == 0) goto L6;
                r0 = IconCompat.createWithResource(null, "", r13);
            L6:
                this(r0, r14, r15, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder(@NonNull Action r12) {
                this(r12.getIconCompat(), r12.title, r12.actionIntent, new Bundle(r12.mExtras), r12.getRemoteInputs(), r12.getAllowGeneratedReplies(), r12.getSemanticAction(), r12.mShowsUserInterface, r12.isContextual(), r12.isAuthenticationRequired());
            }

            public Builder(@Nullable IconCompat r12, @Nullable CharSequence r13, @Nullable PendingIntent r14) {
                this(r12, r13, r14, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(@Nullable IconCompat r2, @Nullable CharSequence r3, @Nullable PendingIntent r4, @NonNull Bundle r5, @Nullable RemoteInput[] r6, boolean r7, int r8, boolean r9, boolean r10, boolean r11) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = r2;
                this.mTitle = Builder.limitCharSequenceLength(r3);
                this.mIntent = r4;
                this.mExtras = r5;
                if (r6 != null) goto L5;
                ArrayList<RemoteInput> r12 = null;
            L6:
                this.mRemoteInputs = r12;
                this.mAllowGeneratedReplies = r7;
                this.mSemanticAction = r8;
                this.mShowsUserInterface = r9;
                this.mIsContextual = r10;
                this.mAuthenticationRequired = r11;
                return;
            L5:
                r12 = new ArrayList(Arrays.asList(r6));
                goto L6
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual == true) goto L5;
                return;
            L5:
                Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
            }

            @NonNull
            @RequiresApi(19)
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action r6) {
                int r0 = Build.VERSION.SDK_INT;
                if (r0 >= 23) goto L5;
            L7:
                Builder r2 = new Builder(r6.icon, r6.title, r6.actionIntent);
            L9:
                if (r0 < 20) goto L18;
                android.app.RemoteInput[] r1 = r6.getRemoteInputs();
                if (r1 == null) goto L18;
                if (r1.length == 0) goto L18;
                int r3 = r1.length;
                int r4 = 0;
            L15:
                if (r4 >= r3) goto L18;
                r2.addRemoteInput(RemoteInput.fromPlatform(r1[r4]));
                r4 = r4 + 1;
            L18:
                if (r0 < 24) goto L21;
                r2.mAllowGeneratedReplies = r6.getAllowGeneratedReplies();
            L21:
                if (r0 < 28) goto L24;
                r2.setSemanticAction(r6.getSemanticAction());
            L24:
                if (r0 < 29) goto L27;
                r2.setContextual(r6.isContextual());
            L27:
                if (r0 < 31) goto L29;
                r2.setAuthenticationRequired(r6.isAuthenticationRequired());
            L29:
                return r2;
            L5:
                if (r6.getIcon() == null) goto L7;
                r2 = new Builder(IconCompat.createFromIcon(r6.getIcon()), r6.title, r6.actionIntent);
                goto L9
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle r2) {
                if (r2 == null) goto L4;
                this.mExtras.putAll(r2);
            L4:
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput r2) {
                if (this.mRemoteInputs != null) goto L5;
                this.mRemoteInputs = new ArrayList();
            L5:
                if (r2 == null) goto L7;
                this.mRemoteInputs.add(r2);
            L7:
                return this;
            }

            @NonNull
            public Action build() {
                checkContextualActionNullFields();
                ArrayList r1 = new ArrayList();
                ArrayList r2 = new ArrayList();
                ArrayList<RemoteInput> r3 = this.mRemoteInputs;
                if (r3 == null) goto L11;
                Iterator<RemoteInput> r4 = r3.iterator();
            L6:
                if (r4.hasNext() == false) goto L11;
                RemoteInput r5 = r4.next();
                if (r5.isDataOnly() == true) goto L9;
                r2.add(r5);
                goto L6
            L9:
                r1.add(r5);
            L11:
                RemoteInput[] r6 = null;
                if (r1.isEmpty() == false) goto L14;
                RemoteInput[] r11 = null;
            L16:
                if (r2.isEmpty() == true) goto L20;
                r6 = (RemoteInput[]) r2.toArray(new RemoteInput[r2.size()]);
            L20:
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, r6, r11, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
            L14:
                r11 = (RemoteInput[]) r1.toArray(new RemoteInput[r1.size()]);
                goto L16
            }

            @NonNull
            public Builder extend(@NonNull Extender r1) {
                r1.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean r1) {
                this.mAllowGeneratedReplies = r1;
                return this;
            }

            @NonNull
            public Builder setAuthenticationRequired(boolean r1) {
                this.mAuthenticationRequired = r1;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean r1) {
                this.mIsContextual = r1;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int r1) {
                this.mSemanticAction = r1;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean r1) {
                this.mShowsUserInterface = r1;
                return this;
            }
        }

        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder r1);
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

            public WearableExtender(@NonNull Action r3) {
                this.mFlags = 1;
                Bundle r4 = r3.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (r4 == null) goto L6;
                this.mFlags = r4.getInt(KEY_FLAGS, 1);
                this.mInProgressLabel = r4.getCharSequence(KEY_IN_PROGRESS_LABEL);
                this.mConfirmLabel = r4.getCharSequence(KEY_CONFIRM_LABEL);
                this.mCancelLabel = r4.getCharSequence(KEY_CANCEL_LABEL);
                return;
            }

            private void setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                int r3 = r1 | this.mFlags;
            L5:
                this.mFlags = r3;
                return;
            L4:
                int r4 = this.mFlags;
                r3 = (~r1) & r4;
                goto L5
            }

            @NonNull
            public WearableExtender clone() {
                WearableExtender r0 = new WearableExtender();
                r0.mFlags = this.mFlags;
                r0.mInProgressLabel = this.mInProgressLabel;
                r0.mConfirmLabel = this.mConfirmLabel;
                r0.mCancelLabel = this.mCancelLabel;
                return r0;
            }

            @NonNull
            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m10clone() {
                return clone();
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            @NonNull
            public Builder extend(@NonNull Builder r4) {
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

            @Nullable
            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Nullable
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

            @Nullable
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

            @NonNull
            public WearableExtender setAvailableOffline(boolean r2) {
                setFlag(1, r2);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence r1) {
                this.mCancelLabel = r1;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence r1) {
                this.mConfirmLabel = r1;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean r2) {
                setFlag(4, r2);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean r2) {
                setFlag(2, r2);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence r1) {
                this.mInProgressLabel = r1;
                return this;
            }
        }

        public Action(int r3, @Nullable CharSequence r4, @Nullable PendingIntent r5) {
            IconCompat r0 = null;
            if (r3 == 0) goto L6;
            r0 = IconCompat.createWithResource(null, "", r3);
        L6:
            this(r0, r4, r5);
        }

        Action(int r15, @Nullable CharSequence r16, @Nullable PendingIntent r17, @Nullable Bundle r18, @Nullable RemoteInput[] r19, @Nullable RemoteInput[] r20, boolean r21, int r22, boolean r23, boolean r24, boolean r25) {
            IconCompat r1 = null;
            if (r15 == 0) goto L6;
            r1 = IconCompat.createWithResource(null, "", r15);
        L6:
            this(r1, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        }

        public Action(@Nullable IconCompat r13, @Nullable CharSequence r14, @Nullable PendingIntent r15) {
            this(r13, r14, r15, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(@Nullable IconCompat r3, @Nullable CharSequence r4, @Nullable PendingIntent r5, @Nullable Bundle r6, @Nullable RemoteInput[] r7, @Nullable RemoteInput[] r8, boolean r9, int r10, boolean r11, boolean r12, boolean r13) {
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
            this.mAuthenticationRequired = r13;
            return;
        L5:
            if (r3.getType() != 2) goto L7;
            this.icon = r3.getResId();
            goto L7
        }

        @Nullable
        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        @Nullable
        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        @NonNull
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

        @Nullable
        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        @RequiresApi(16)
        private static class Api16Impl {
            private Api16Impl() {
            }

            @RequiresApi(16)
            static void setBigLargeIcon(Notification.BigPictureStyle r0, Bitmap r1) {
                r0.bigLargeIcon(r1);
            }

            @RequiresApi(16)
            static void setSummaryText(Notification.BigPictureStyle r0, CharSequence r1) {
                r0.setSummaryText(r1);
            }
        }

        @RequiresApi(23)
        private static class Api23Impl {
            private Api23Impl() {
            }

            @RequiresApi(23)
            static void setBigLargeIcon(Notification.BigPictureStyle r0, Icon r1) {
                r0.bigLargeIcon(r1);
            }
        }

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @RequiresApi(31)
            static void setBigPicture(Notification.BigPictureStyle r0, Icon r1) {
                r0.bigPicture(r1);
            }

            @RequiresApi(31)
            static void setContentDescription(Notification.BigPictureStyle r0, CharSequence r1) {
                r0.setContentDescription(r1);
            }

            @RequiresApi(31)
            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle r0, boolean r1) {
                r0.showBigPictureWhenCollapsed(r1);
            }
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(@Nullable Builder r1) {
            setBuilder(r1);
        }

        @Nullable
        private static IconCompat asIconCompat(@Nullable Parcelable r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            if ((r2 instanceof Icon) == false) goto L10;
            return IconCompat.createFromIcon((Icon) r2);
        L10:
            if ((r2 instanceof Bitmap) == true) goto L12;
            return null;
        L12:
            return IconCompat.createWithBitmap((Bitmap) r2);
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat getPictureIcon(@Nullable Bundle r1) {
            if (r1 != null) goto L5;
            return null;
        L5:
            Parcelable r0 = r1.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (r0 == null) goto L10;
            return asIconCompat(r0);
        L10:
            return asIconCompat(r1.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r8) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 16) goto L35;
            Notification.BigPictureStyle r1 = new Notification.BigPictureStyle(r8.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            IconCompat r2 = this.mPictureIcon;
            Context r5 = null;
            if (r2 == null) goto L16;
            if (r0 < 31) goto L13;
            if ((r8 instanceof NotificationCompatBuilder) == false) goto L10;
            Context r3 = ((NotificationCompatBuilder) r8).getContext();
        L11:
            Api31Impl.setBigPicture(r1, this.mPictureIcon.toIcon(r3));
            goto L16
        L10:
            r3 = null;
            goto L11
        L13:
            if (r2.getType() != 1) goto L16;
            r1 = r1.bigPicture(this.mPictureIcon.getBitmap());
        L16:
            if (this.mBigLargeIconSet == false) goto L30;
            IconCompat r4 = this.mBigLargeIcon;
            if (r4 != null) goto L21;
        L19:
            Api16Impl.setBigLargeIcon(r1, null);
            goto L30
        L21:
            if (r0 < 23) goto L27;
            if ((r8 instanceof NotificationCompatBuilder) == false) goto L25;
            r5 = ((NotificationCompatBuilder) r8).getContext();
        L25:
            Api23Impl.setBigLargeIcon(r1, this.mBigLargeIcon.toIcon(r5));
            goto L30
        L27:
            if (r4.getType() != 1) goto L19;
            Api16Impl.setBigLargeIcon(r1, this.mBigLargeIcon.getBitmap());
        L30:
            if (this.mSummaryTextSet == false) goto L32;
            Api16Impl.setSummaryText(r1, this.mSummaryText);
        L32:
            if (r0 < 31) goto L36;
            Api31Impl.showBigPictureWhenCollapsed(r1, this.mShowBigPictureWhenCollapsed);
            Api31Impl.setContentDescription(r1, this.mPictureContentDescription);
            return;
        L36:
            return;
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mBigLargeIcon = r2;
            this.mBigLargeIconSet = true;
            return this;
        L4:
            r2 = IconCompat.createWithBitmap(r1);
            goto L5
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap r1) {
            if (r1 != null) goto L4;
            IconCompat r2 = null;
        L5:
            this.mPictureIcon = r2;
            return this;
        L4:
            r2 = IconCompat.createWithBitmap(r1);
            goto L5
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle bigPicture(@Nullable Icon r1) {
            this.mPictureIcon = IconCompat.createFromIcon(r1);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            r1.remove(NotificationCompat.EXTRA_PICTURE);
            r1.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            r1.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r3) {
            super.restoreFromCompatExtras(r3);
            if (r3.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG) == false) goto L5;
            this.mBigLargeIcon = asIconCompat(r3.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
            this.mBigLargeIconSet = true;
        L5:
            this.mPictureIcon = getPictureIcon(r3);
            this.mShowBigPictureWhenCollapsed = r3.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle setContentDescription(@Nullable CharSequence r1) {
            this.mPictureContentDescription = r1;
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
        }

        @NonNull
        @RequiresApi(31)
        public BigPictureStyle showBigPictureWhenCollapsed(boolean r1) {
            this.mShowBigPictureWhenCollapsed = r1;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(@Nullable Builder r1) {
            setBuilder(r1);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r3) {
            super.addCompatExtras(r3);
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            r3.putCharSequence(NotificationCompat.EXTRA_BIG_TEXT, this.mBigText);
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 16) goto L8;
            Notification.BigTextStyle r4 = new Notification.BigTextStyle(r3.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet == false) goto L9;
            r4.setSummaryText(this.mSummaryText);
            return;
        L9:
            return;
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence r1) {
            this.mBigText = Builder.limitCharSequenceLength(r1);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r2) {
            super.restoreFromCompatExtras(r2);
            this.mBigText = r2.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
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
        private String mShortcutId;

        @RequiresApi(29)
        private static class Api29Impl {
            private Api29Impl() {
            }

            @Nullable
            @RequiresApi(29)
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getIntent() != null) goto L8;
                return null;
            L8:
                Builder r0 = new Builder(r3.getIntent(), IconCompat.createFromIcon(r3.getIcon())).setAutoExpandBubble(r3.getAutoExpandBubble()).setDeleteIntent(r3.getDeleteIntent()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L12;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L12:
                if (r3.getDesiredHeightResId() == 0) goto L15;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L15:
                return r0.build();
            }

            @Nullable
            @RequiresApi(29)
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r2) {
                if (r2 != null) goto L6;
                return null;
            L6:
                if (r2.getIntent() != null) goto L8;
                return null;
            L8:
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder().setIcon(r2.getIcon().toIcon()).setIntent(r2.getIntent()).setDeleteIntent(r2.getDeleteIntent()).setAutoExpandBubble(r2.getAutoExpandBubble()).setSuppressNotification(r2.isNotificationSuppressed());
                if (r2.getDesiredHeight() == 0) goto L12;
                r0.setDesiredHeight(r2.getDesiredHeight());
            L12:
                if (r2.getDesiredHeightResId() == 0) goto L15;
                r0.setDesiredHeightResId(r2.getDesiredHeightResId());
            L15:
                return r0.build();
            }
        }

        @RequiresApi(30)
        private static class Api30Impl {
            private Api30Impl() {
            }

            @Nullable
            @RequiresApi(30)
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getShortcutId() == null) goto L8;
                Builder r0 = new Builder(r3.getShortcutId());
            L9:
                r0.setAutoExpandBubble(r3.getAutoExpandBubble()).setDeleteIntent(r3.getDeleteIntent()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L13;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L13:
                if (r3.getDesiredHeightResId() == 0) goto L16;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L16:
                return r0.build();
            L8:
                r0 = new Builder(r3.getIntent(), IconCompat.createFromIcon(r3.getIcon()));
                goto L9
            }

            @Nullable
            @RequiresApi(30)
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r3) {
                if (r3 != null) goto L6;
                return null;
            L6:
                if (r3.getShortcutId() == null) goto L8;
                Notification.BubbleMetadata.Builder r0 = new Notification.BubbleMetadata.Builder(r3.getShortcutId());
            L9:
                r0.setDeleteIntent(r3.getDeleteIntent()).setAutoExpandBubble(r3.getAutoExpandBubble()).setSuppressNotification(r3.isNotificationSuppressed());
                if (r3.getDesiredHeight() == 0) goto L13;
                r0.setDesiredHeight(r3.getDesiredHeight());
            L13:
                if (r3.getDesiredHeightResId() == 0) goto L16;
                r0.setDesiredHeightResId(r3.getDesiredHeightResId());
            L16:
                return r0.build();
            L8:
                r0 = new Notification.BubbleMetadata.Builder(r3.getIntent(), r3.getIcon().toIcon());
                goto L9
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;

            @DimenRes
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            public Builder(@NonNull PendingIntent r2, @NonNull IconCompat r3) {
                Objects.requireNonNull(r2, "Bubble requires non-null pending intent");
                Objects.requireNonNull(r3, "Bubbles require non-null icon");
                this.mPendingIntent = r2;
                this.mIcon = r3;
            }

            @RequiresApi(30)
            public Builder(@NonNull String r2) {
                if (TextUtils.isEmpty(r2) == true) goto L7;
                this.mShortcutId = r2;
                return;
            L7:
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            @NonNull
            private Builder setFlag(int r1, boolean r2) {
                if (r2 == false) goto L4;
                int r3 = r1 | this.mFlags;
            L5:
                this.mFlags = r3;
                return this;
            L4:
                int r4 = this.mFlags;
                r3 = (~r1) & r4;
                goto L5
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                String r7 = this.mShortcutId;
                if (r7 != null) goto L5;
                Objects.requireNonNull(this.mPendingIntent, "Must supply pending intent or shortcut to bubble");
            L5:
                if (r7 != null) goto L7;
                Objects.requireNonNull(this.mIcon, "Must supply an icon or shortcut for the bubble");
            L7:
                BubbleMetadata r9 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, r7, null);
                r9.setFlags(this.mFlags);
                return r9;
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
            public Builder setIcon(@NonNull IconCompat r2) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r2, "Bubbles require non-null icon");
                this.mIcon = r2;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent r2) {
                if (this.mShortcutId != null) goto L7;
                Objects.requireNonNull(r2, "Bubble requires non-null pending intent");
                this.mPendingIntent = r2;
                return this;
            L7:
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            @NonNull
            public Builder setSuppressNotification(boolean r2) {
                setFlag(2, r2);
                return this;
            }
        }

        private BubbleMetadata(@Nullable PendingIntent r1, @Nullable PendingIntent r2, @Nullable IconCompat r3, int r4, @DimenRes int r5, int r6, @Nullable String r7) {
            this.mPendingIntent = r1;
            this.mIcon = r3;
            this.mDesiredHeight = r4;
            this.mDesiredHeightResId = r5;
            this.mDeleteIntent = r2;
            this.mFlags = r6;
            this.mShortcutId = r7;
        }

        /* synthetic */ BubbleMetadata(PendingIntent r1, PendingIntent r2, IconCompat r3, int r4, int r5, int r6, String r7, AnonymousClass1 r8) {
            this(r1, r2, r3, r4, r5, r6, r7);
        }

        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 30) goto L10;
            return Api30Impl.fromPlatform(r3);
        L10:
            if (r1 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.fromPlatform(r3);
        }

        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 30) goto L10;
            return Api30Impl.toPlatform(r3);
        L10:
            if (r1 == 29) goto L12;
            return null;
        L12:
            return Api29Impl.toPlatform(r3);
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

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat getIcon() {
            return this.mIcon;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        @Nullable
        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setFlags(int r1) {
            this.mFlags = r1;
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
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        Bitmap mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;

        @Deprecated
        public ArrayList<String> mPeople;

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Icon mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        @Deprecated
        public Builder(@NonNull Context r2) {
            this(r2, null);
        }

        @RequiresApi(19)
        public Builder(@NonNull Context r7, @NonNull Notification r8) {
            int r0 = Build.VERSION.SDK_INT;
            this(r7, NotificationCompat.getChannelId(r8));
            Bundle r9 = r8.extras;
            Style r1 = Style.extractStyleFromNotification(r8);
            setContentTitle(NotificationCompat.getContentTitle(r8)).setContentText(NotificationCompat.getContentText(r8)).setContentInfo(NotificationCompat.getContentInfo(r8)).setSubText(NotificationCompat.getSubText(r8)).setSettingsText(NotificationCompat.getSettingsText(r8)).setStyle(r1).setContentIntent(r8.contentIntent).setGroup(NotificationCompat.getGroup(r8)).setGroupSummary(NotificationCompat.isGroupSummary(r8)).setLocusId(NotificationCompat.getLocusId(r8)).setWhen(r8.when).setShowWhen(NotificationCompat.getShowWhen(r8)).setUsesChronometer(NotificationCompat.getUsesChronometer(r8)).setAutoCancel(NotificationCompat.getAutoCancel(r8)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(r8)).setOngoing(NotificationCompat.getOngoing(r8)).setLocalOnly(NotificationCompat.getLocalOnly(r8)).setLargeIcon(r8.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(r8)).setCategory(NotificationCompat.getCategory(r8)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(r8)).setNumber(r8.number).setTicker(r8.tickerText).setContentIntent(r8.contentIntent).setDeleteIntent(r8.deleteIntent).setFullScreenIntent(r8.fullScreenIntent, NotificationCompat.getHighPriority(r8)).setSound(r8.sound, r8.audioStreamType).setVibrate(r8.vibrate).setLights(r8.ledARGB, r8.ledOnMS, r8.ledOffMS).setDefaults(r8.defaults).setPriority(r8.priority).setColor(NotificationCompat.getColor(r8)).setVisibility(NotificationCompat.getVisibility(r8)).setPublicVersion(NotificationCompat.getPublicVersion(r8)).setSortKey(NotificationCompat.getSortKey(r8)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(r8)).setShortcutId(NotificationCompat.getShortcutId(r8)).setProgress(r9.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), r9.getInt(NotificationCompat.EXTRA_PROGRESS), r9.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(r8)).setSmallIcon(r8.icon, r8.iconLevel).addExtras(getExtrasWithoutDuplicateData(r8, r1));
            if (r0 < 23) goto L5;
            this.mSmallIcon = r8.getSmallIcon();
        L5:
            Notification.Action[] r2 = r8.actions;
            int r3 = 0;
            if (r2 == null) goto L13;
            if (r2.length == 0) goto L13;
            int r4 = r2.length;
            int r5 = 0;
        L10:
            if (r5 >= r4) goto L13;
            addAction(Action.Builder.fromAndroidAction(r2[r5]).build());
            r5 = r5 + 1;
        L13:
            if (r0 < 21) goto L20;
            List<Action> r6 = NotificationCompat.getInvisibleActions(r8);
            if (r6.isEmpty() == true) goto L20;
            Iterator<Action> r10 = r6.iterator();
        L18:
            if (r10.hasNext() == false) goto L20;
            addInvisibleAction(r10.next());
        L20:
            String[] r11 = r8.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (r11 == null) goto L28;
            if (r11.length == 0) goto L28;
            int r12 = r11.length;
        L25:
            if (r3 >= r12) goto L28;
            addPerson(r11[r3]);
            r3 = r3 + 1;
        L28:
            if (r0 < 28) goto L38;
            ArrayList r13 = r8.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
            if (r13 == null) goto L38;
            if (r13.isEmpty() == true) goto L38;
            Iterator r14 = r13.iterator();
        L35:
            if (r14.hasNext() == false) goto L38;
            addPerson(Person.fromAndroidPerson((android.app.Person) r14.next()));
        L38:
            if (r0 < 24) goto L43;
            if (r9.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN) == false) goto L43;
            setChronometerCountDown(r9.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
        L43:
            if (r0 >= 26) goto L45;
            return;
        L45:
            if (r9.containsKey(NotificationCompat.EXTRA_COLORIZED) == false) goto L53;
            setColorized(r9.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            return;
        }

        public Builder(@NonNull Context r4, @NonNull String r5) {
            this.mActions = new ArrayList();
            this.mPersonList = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
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

        @Nullable
        @RequiresApi(19)
        private static Bundle getExtrasWithoutDuplicateData(@NonNull Notification r3, @Nullable Style r4) {
            if (r3.extras != null) goto L6;
            return null;
        L6:
            Bundle r0 = new Bundle(r3.extras);
            r0.remove(NotificationCompat.EXTRA_TITLE);
            r0.remove(NotificationCompat.EXTRA_TEXT);
            r0.remove(NotificationCompat.EXTRA_INFO_TEXT);
            r0.remove(NotificationCompat.EXTRA_SUB_TEXT);
            r0.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            r0.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            r0.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            r0.remove(NotificationCompat.EXTRA_PROGRESS);
            r0.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            r0.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            r0.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            r0.remove(NotificationCompat.EXTRA_COLORIZED);
            r0.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            r0.remove(NotificationCompat.EXTRA_PEOPLE);
            r0.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            r0.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            r0.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            r0.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            r0.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle r1 = r0.getBundle("android.car.EXTENSIONS");
            if (r1 == null) goto L9;
            Bundle r2 = new Bundle(r1);
            r2.remove("invisible_actions");
            r0.putBundle("android.car.EXTENSIONS", r2);
        L9:
            if (r4 == null) goto L11;
            r4.clearCompatExtraKeys(r0);
        L11:
            return r0;
        }

        @Nullable
        protected static CharSequence limitCharSequenceLength(@Nullable CharSequence r2) {
            if (r2 != null) goto L5;
            return r2;
        L5:
            if (r2.length() > MAX_CHARSEQUENCE_LENGTH) goto L7;
            return r2;
        L7:
            return r2.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
        }

        @Nullable
        private Bitmap reduceLargeIconSize(@Nullable Bitmap r9) {
            if (r9 != null) goto L4;
        L13:
            return r9;
        L4:
            if (Build.VERSION.SDK_INT >= 27) goto L13;
            Resources r8 = this.mContext.getResources();
            int r0 = r8.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int r10 = r8.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (r9.getWidth() <= r0) goto L9;
        L11:
            double r1 = Math.min(((double) r0) / ((double) Math.max(1, r9.getWidth())), ((double) r10) / ((double) Math.max(1, r9.getHeight())));
            return Bitmap.createScaledBitmap(r9, (int) Math.ceil(((double) r9.getWidth()) * r1), (int) Math.ceil(((double) r9.getHeight()) * r1), true);
        L9:
            if (r9.getHeight() > r10) goto L11;
            return r9;
        }

        private void setFlag(int r1, boolean r2) {
            Notification r0 = this.mNotification;
            if (r2 == false) goto L5;
            int r3 = r1 | r0.flags;
        L6:
            r0.flags = r3;
            return;
        L5:
            int r4 = r0.flags;
            r3 = (~r1) & r4;
            goto L6
        }

        private boolean useExistingRemoteView() {
            Style r0 = this.mStyle;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.displayCustomViewInline() == false) goto L8;
            return false;
        }

        @NonNull
        public Builder addAction(int r3, @Nullable CharSequence r4, @Nullable PendingIntent r5) {
            this.mActions.add(new Action(r3, r4, r5));
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action r2) {
            if (r2 == null) goto L4;
            this.mActions.add(r2);
        L4:
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle r2) {
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

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(int r3, @Nullable CharSequence r4, @Nullable PendingIntent r5) {
            this.mInvisibleActions.add(new Action(r3, r4, r5));
            return this;
        }

        @NonNull
        @RequiresApi(21)
        public Builder addInvisibleAction(@Nullable Action r2) {
            if (r2 == null) goto L4;
            this.mInvisibleActions.add(r2);
        L4:
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person r2) {
            if (r2 == null) goto L4;
            this.mPersonList.add(r2);
        L4:
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String r2) {
            if (r2 != null) goto L4;
        L6:
            return this;
        L4:
            if (r2.isEmpty() == true) goto L6;
            this.mPeople.add(r2);
            goto L6
        }

        @NonNull
        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        @NonNull
        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle r0 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (r0 == null) goto L5;
            Bundle r2 = new Bundle(r0);
            r2.remove("invisible_actions");
            this.mExtras.putBundle("android.car.EXTENSIONS", r2);
        L5:
            return this;
        }

        @NonNull
        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createBigContentView() {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 >= 16) goto L7;
            return null;
        L7:
            if (this.mBigContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r1 = new NotificationCompatBuilder(this);
            Style r2 = this.mStyle;
            if (r2 == null) goto L17;
            RemoteViews r3 = r2.makeBigContentView(r1);
            if (r3 == null) goto L17;
            return r3;
        L17:
            Notification r4 = r1.build();
            if (r0 < 24) goto L22;
            return Notification.Builder.recoverBuilder(this.mContext, r4).createBigContentView();
        L22:
            return r4.bigContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mBigContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createContentView() {
            if (this.mContentView != null) goto L5;
        L8:
            NotificationCompatBuilder r0 = new NotificationCompatBuilder(this);
            Style r1 = this.mStyle;
            if (r1 == null) goto L13;
            RemoteViews r2 = r1.makeContentView(r0);
            if (r2 == null) goto L13;
            return r2;
        L13:
            Notification r3 = r0.build();
            if (Build.VERSION.SDK_INT < 24) goto L18;
            return Notification.Builder.recoverBuilder(this.mContext, r3).createContentView();
        L18:
            return r3.contentView;
        L5:
            if (useExistingRemoteView() == false) goto L8;
            return this.mContentView;
        }

        @Nullable
        @SuppressLint({"BuilderSetStyle"})
        public RemoteViews createHeadsUpContentView() {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 >= 21) goto L7;
            return null;
        L7:
            if (this.mHeadsUpContentView != null) goto L9;
        L12:
            NotificationCompatBuilder r1 = new NotificationCompatBuilder(this);
            Style r2 = this.mStyle;
            if (r2 == null) goto L17;
            RemoteViews r3 = r2.makeHeadsUpContentView(r1);
            if (r3 == null) goto L17;
            return r3;
        L17:
            Notification r4 = r1.build();
            if (r0 < 24) goto L22;
            return Notification.Builder.recoverBuilder(this.mContext, r4).createHeadsUpContentView();
        L22:
            return r4.headsUpContentView;
        L9:
            if (useExistingRemoteView() == false) goto L12;
            return this.mHeadsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender r1) {
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

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        @NonNull
        public Bundle getExtras() {
            if (this.mExtras != null) goto L6;
            this.mExtras = new Bundle();
        L6:
            return this.mExtras;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @NonNull
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

        @NonNull
        public Builder setAutoCancel(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int r1) {
            this.mBadgeIcon = r1;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata r1) {
            this.mBubbleMetadata = r1;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String r1) {
            this.mCategory = r1;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String r1) {
            this.mChannelId = r1;
            return this;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean r3) {
            this.mChronometerCountDown = r3;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, r3);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int r1) {
            this.mColor = r1;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean r1) {
            this.mColorized = r1;
            this.mColorizedSet = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews r2) {
            this.mNotification.contentView = r2;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence r1) {
            this.mContentInfo = limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent r1) {
            this.mContentIntent = r1;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence r1) {
            this.mContentText = limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence r1) {
            this.mContentTitle = limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews r1) {
            this.mBigContentView = r1;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews r1) {
            this.mContentView = r1;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews r1) {
            this.mHeadsUpContentView = r1;
            return this;
        }

        @NonNull
        public Builder setDefaults(int r2) {
            Notification r0 = this.mNotification;
            r0.defaults = r2;
            if ((r2 & 4) == 0) goto L5;
            r0.flags |= 1;
        L5:
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent r2) {
            this.mNotification.deleteIntent = r2;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        @NonNull
        public Builder setForegroundServiceBehavior(int r1) {
            this.mFgsDeferBehavior = r1;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent r1, boolean r2) {
            this.mFullScreenIntent = r1;
            setFlag(128, r2);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r1) {
            this.mGroupKey = r1;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int r1) {
            this.mGroupAlertBehavior = r1;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean r1) {
            this.mGroupSummary = r1;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap r1) {
            this.mLargeIcon = reduceLargeIconSize(r1);
            return this;
        }

        @NonNull
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

        @NonNull
        public Builder setLocalOnly(boolean r1) {
            this.mLocalOnly = r1;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r1) {
            this.mLocusId = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int r1) {
            this.mNumber = r1;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean r2) {
            setFlag(8, r2);
            return this;
        }

        @NonNull
        public Builder setPriority(int r1) {
            this.mPriority = r1;
            return this;
        }

        @NonNull
        public Builder setProgress(int r1, int r2, boolean r3) {
            this.mProgressMax = r1;
            this.mProgress = r2;
            this.mProgressIndeterminate = r3;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification r1) {
            this.mPublicVersion = r1;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] r1) {
            this.mRemoteInputHistory = r1;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence r1) {
            this.mSettingsText = limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String r1) {
            this.mShortcutId = r1;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat r3) {
            if (r3 != null) goto L4;
            return this;
        L4:
            this.mShortcutId = r3.getId();
            if (this.mLocusId != null) goto L14;
            if (r3.getLocusId() == null) goto L11;
            LocusIdCompat r0 = r3.getLocusId();
        L9:
            this.mLocusId = r0;
            goto L14
        L11:
            if (r3.getId() == null) goto L14;
            r0 = new LocusIdCompat(r3.getId());
        L14:
            if (this.mContentTitle != null) goto L16;
            setContentTitle(r3.getShortLabel());
        L16:
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean r1) {
            this.mShowWhen = r1;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean r1) {
            this.mSilent = r1;
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r2) {
            this.mNotification.icon = r2;
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int r2, int r3) {
            Notification r0 = this.mNotification;
            r0.icon = r2;
            r0.iconLevel = r3;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setSmallIcon(@NonNull IconCompat r2) {
            this.mSmallIcon = r2.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String r1) {
            this.mSortKey = r1;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r3) {
            Notification r0 = this.mNotification;
            r0.sound = r3;
            r0.audioStreamType = -1;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r0.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        L5:
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r3, int r4) {
            Notification r0 = this.mNotification;
            r0.sound = r3;
            r0.audioStreamType = r4;
            if (Build.VERSION.SDK_INT < 21) goto L5;
            r0.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(r4).build();
        L5:
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style r2) {
            if (this.mStyle == r2) goto L7;
            this.mStyle = r2;
            if (r2 == null) goto L7;
            r2.setBuilder(this);
        L7:
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence r1) {
            this.mSubText = limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence r2) {
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r2);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence r2, @Nullable RemoteViews r3) {
            Notification r0 = this.mNotification;
            r0.tickerText = limitCharSequenceLength(r2);
            this.mTickerView = r3;
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long r1) {
            this.mTimeout = r1;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean r1) {
            this.mUseChronometer = r1;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] r2) {
            this.mNotification.vibrate = r2;
            return this;
        }

        @NonNull
        public Builder setVisibility(int r1) {
            this.mVisibility = r1;
            return this;
        }

        @NonNull
        public Builder setWhen(long r2) {
            this.mNotification.when = r2;
            return this;
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

                public Builder(@NonNull String r2) {
                    this.mMessages = new ArrayList();
                    this.mParticipant = r2;
                }

                @NonNull
                public Builder addMessage(@Nullable String r2) {
                    if (r2 == null) goto L4;
                    this.mMessages.add(r2);
                L4:
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    List<String> r0 = this.mMessages;
                    return new UnreadConversation((String[]) r0.toArray(new String[r0.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                @NonNull
                public Builder setLatestTimestamp(long r1) {
                    this.mLatestTimestamp = r1;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent r1) {
                    this.mReadPendingIntent = r1;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent r1, @Nullable RemoteInput r2) {
                    this.mRemoteInput = r2;
                    this.mReplyPendingIntent = r1;
                    return this;
                }
            }

            UnreadConversation(@Nullable String[] r1, @Nullable RemoteInput r2, @Nullable PendingIntent r3, @Nullable PendingIntent r4, @Nullable String[] r5, long r6) {
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

            @Nullable
            public String[] getMessages() {
                return this.mMessages;
            }

            @Nullable
            public String getParticipant() {
                String[] r1 = this.mParticipants;
                if (r1.length > 0) goto L7;
                return null;
            L7:
                return r1[0];
            }

            @Nullable
            public String[] getParticipants() {
                return this.mParticipants;
            }

            @Nullable
            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            @Nullable
            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            @Nullable
            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
            this.mColor = 0;
        }

        public CarExtender(@NonNull Notification r4) {
            this.mColor = 0;
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            return;
        L6:
            if (NotificationCompat.getExtras(r4) != null) goto L8;
            Bundle r5 = null;
        L9:
            if (r5 == null) goto L12;
            this.mLargeIcon = (Bitmap) r5.getParcelable(EXTRA_LARGE_ICON);
            this.mColor = r5.getInt(EXTRA_COLOR, 0);
            this.mUnreadConversation = getUnreadConversationFromBundle(r5.getBundle(EXTRA_CONVERSATION));
            return;
        L12:
            return;
        L8:
            r5 = NotificationCompat.getExtras(r4).getBundle(EXTRA_CAR_EXTENDER);
            goto L9
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
        private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle r21) {
            RemoteInput r1 = null;
            if (r21 != null) goto L5;
            return null;
        L5:
            Parcelable[] r2 = r21.getParcelableArray(KEY_MESSAGES);
            int r4 = 0;
            if (r2 == null) goto L20;
            int r5 = r2.length;
            String[] r6 = new String[r5];
            int r7 = 0;
        L8:
            if (r7 >= r5) goto L16;
            if ((r2[r7] instanceof Bundle) == false) goto L11;
            r6[r7] = ((Bundle) r2[r7]).getString(KEY_TEXT);
            if (r6[r7] == null) goto L11;
            r7 = r7 + 1;
        L11:
            boolean r3 = false;
        L17:
            if (r3 == false) goto L19;
            String[] r8 = r6;
        L21:
            PendingIntent r11 = (PendingIntent) r21.getParcelable(KEY_ON_READ);
            PendingIntent r10 = (PendingIntent) r21.getParcelable(KEY_ON_REPLY);
            android.app.RemoteInput r9 = (android.app.RemoteInput) r21.getParcelable(KEY_REMOTE_INPUT);
            String[] r12 = r21.getStringArray(KEY_PARTICIPANTS);
            if (r12 != null) goto L24;
            return null;
        L24:
            if (r12.length != 1) goto L37;
            if (r9 == null) goto L32;
            String r14 = r9.getResultKey();
            CharSequence r15 = r9.getLabel();
            CharSequence[] r16 = r9.getChoices();
            boolean r17 = r9.getAllowFreeFormInput();
            if (Build.VERSION.SDK_INT < 29) goto L30;
            r4 = r9.getEditChoicesBeforeSending();
        L30:
            r1 = new RemoteInput(r14, r15, r16, r17, r4, r9.getExtras(), null);
        L32:
            return new UnreadConversation(r8, r1, r10, r11, r12, r21.getLong("timestamp"));
        L37:
            return null;
        L19:
            return null;
        L16:
            r3 = true;
            goto L17
        L20:
            r8 = null;
            goto L21
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r4) {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return r4;
        L5:
            Bundle r0 = new Bundle();
            Bitmap r1 = this.mLargeIcon;
            if (r1 == null) goto L8;
            r0.putParcelable(EXTRA_LARGE_ICON, r1);
        L8:
            int r2 = this.mColor;
            if (r2 == 0) goto L11;
            r0.putInt(EXTRA_COLOR, r2);
        L11:
            UnreadConversation r3 = this.mUnreadConversation;
            if (r3 == null) goto L14;
            r0.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(r3));
        L14:
            r4.getExtras().putBundle(EXTRA_CAR_EXTENDER, r0);
            return r4;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        @Nullable
        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Nullable
        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @NonNull
        public CarExtender setColor(@ColorInt int r1) {
            this.mColor = r1;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap r1) {
            this.mLargeIcon = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation r1) {
            this.mUnreadConversation = r1;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        public DecoratedCustomViewStyle() {
        }

        private RemoteViews createRemoteViews(RemoteViews r8, boolean r9) {
            boolean r1 = true;
            int r2 = 0;
            RemoteViews r0 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            r0.removeAllViews(R.id.actions);
            List<Action> r3 = getNonContextualActions(this.mBuilder.mActions);
            if (r9 == false) goto L10;
            if (r3 == null) goto L10;
            int r10 = Math.min(r3.size(), 3);
            if (r10 <= 0) goto L10;
            int r4 = 0;
        L8:
            if (r4 >= r10) goto L11;
            r0.addView(R.id.actions, generateActionButton(r3.get(r4)));
            r4 = r4 + 1;
        L11:
            if (r1 == true) goto L14;
            r2 = 8;
        L14:
            r0.setViewVisibility(R.id.actions, r2);
            r0.setViewVisibility(R.id.action_divider, r2);
            buildIntoRemoteViews(r0, r8);
            return r0;
        L10:
            r1 = false;
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
            IconCompat r4 = r7.getIconCompat();
            if (r4 == null) goto L13;
            r1.setImageViewBitmap(R.id.action_image, createColoredBitmap(r4, this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
        L13:
            r1.setTextViewText(R.id.action_text, r7.title);
            if (r0 == true) goto L17;
            r1.setOnClickPendingIntent(R.id.action_container, r7.actionIntent);
        L17:
            if (Build.VERSION.SDK_INT < 15) goto L19;
            r1.setContentDescription(R.id.action_container, r7.title);
        L19:
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
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            r2.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r4 = this.mBuilder.getBigContentView();
            if (r4 != null) goto L9;
            r4 = this.mBuilder.getContentView();
        L9:
            if (r4 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r4, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getContentView() != null) goto L9;
            return null;
        L9:
            return createRemoteViews(this.mBuilder.getContentView(), false);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            RemoteViews r4 = this.mBuilder.getHeadsUpContentView();
            if (r4 == null) goto L8;
            RemoteViews r1 = r4;
        L9:
            if (r4 != null) goto L12;
            return null;
        L12:
            return createRemoteViews(r1, true);
        L8:
            r1 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GroupAlertBehavior {
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            this.mTexts = new ArrayList();
        }

        public InboxStyle(@Nullable Builder r2) {
            this.mTexts = new ArrayList();
            setBuilder(r2);
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence r2) {
            if (r2 == null) goto L4;
            this.mTexts.add(Builder.limitCharSequenceLength(r2));
        L4:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r3) {
            if (Build.VERSION.SDK_INT < 16) goto L11;
            Notification.InboxStyle r4 = new Notification.InboxStyle(r3.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet == false) goto L7;
            r4.setSummaryText(this.mSummaryText);
        L7:
            Iterator<CharSequence> r2 = this.mTexts.iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            r4.addLine(r2.next());
            goto L9
        L13:
            return;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void restoreFromCompatExtras(@NonNull Bundle r3) {
            super.restoreFromCompatExtras(r3);
            this.mTexts.clear();
            if (r3.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L6;
            Collections.addAll(this.mTexts, r3.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            return;
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence r1) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(r1);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence r1) {
            this.mSummaryText = Builder.limitCharSequenceLength(r1);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";

        @Nullable
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages;

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

            public Message(@Nullable CharSequence r2, long r3, @Nullable Person r5) {
                this.mExtras = new Bundle();
                this.mText = r2;
                this.mTimestamp = r3;
                this.mPerson = r5;
            }

            @Deprecated
            public Message(@Nullable CharSequence r2, long r3, @Nullable CharSequence r5) {
                this(r2, r3, new Person.Builder().setName(r5).build());
            }

            @NonNull
            static Bundle[] getBundleArrayForMessages(@NonNull List<Message> r4) {
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
            static Message getMessageFromBundle(@NonNull Bundle r10) {
                if (r10.containsKey(KEY_TEXT) == false) goto L29;
                if (r10.containsKey(KEY_TIMESTAMP) == false) goto L29;
                if (r10.containsKey(KEY_PERSON) == false) goto L12;
                Person r3 = Person.fromBundle(r10.getBundle(KEY_PERSON));     // Catch: ClassCastException -> L30
            L20:
                Message r4 = new Message(r10.getCharSequence(KEY_TEXT), r10.getLong(KEY_TIMESTAMP), r3);     // Catch: ClassCastException -> L30
                if (r10.containsKey("type") == false) goto L26;
                if (r10.containsKey(KEY_DATA_URI) == false) goto L26;
                r4.setData(r10.getString("type"), (Uri) r10.getParcelable(KEY_DATA_URI));     // Catch: ClassCastException -> L30
            L26:
                if (r10.containsKey(KEY_EXTRAS_BUNDLE) == false) goto L28;
                r4.getExtras().putAll(r10.getBundle(KEY_EXTRAS_BUNDLE));     // Catch: ClassCastException -> L30
            L28:
                return r4;
            L12:
                if (r10.containsKey(KEY_NOTIFICATION_PERSON) == false) goto L17;
                if (Build.VERSION.SDK_INT < 28) goto L17;
                r3 = Person.fromAndroidPerson((android.app.Person) r10.getParcelable(KEY_NOTIFICATION_PERSON));     // Catch: ClassCastException -> L30
            L17:
                if (r10.containsKey(KEY_SENDER) == false) goto L19;
                r3 = new Person.Builder().setName(r10.getCharSequence(KEY_SENDER)).build();     // Catch: ClassCastException -> L30
                goto L20
            L19:
                r3 = null;
            L29:
                return null;
            }

            @NonNull
            static List<Message> getMessagesFromBundleArray(@NonNull Parcelable[] r3) {
                ArrayList r0 = new ArrayList(r3.length);
                int r1 = 0;
            L4:
                if (r1 >= r3.length) goto L11;
                if ((r3[r1] instanceof Bundle) == false) goto L10;
                Message r2 = getMessageFromBundle((Bundle) r3[r1]);
                if (r2 == null) goto L10;
                r0.add(r2);
            L10:
                r1 = r1 + 1;
                goto L4
            L11:
                return r0;
            }

            @NonNull
            private Bundle toBundle() {
                Bundle r0 = new Bundle();
                CharSequence r1 = this.mText;
                if (r1 == null) goto L5;
                r0.putCharSequence(KEY_TEXT, r1);
            L5:
                r0.putLong(KEY_TIMESTAMP, this.mTimestamp);
                Person r2 = this.mPerson;
                if (r2 == null) goto L11;
                r0.putCharSequence(KEY_SENDER, r2.getName());
                if (Build.VERSION.SDK_INT < 28) goto L10;
                r0.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
                goto L11
            L10:
                r0.putBundle(KEY_PERSON, this.mPerson.toBundle());
            L11:
                String r3 = this.mDataMimeType;
                if (r3 == null) goto L14;
                r0.putString("type", r3);
            L14:
                Uri r4 = this.mDataUri;
                if (r4 == null) goto L17;
                r0.putParcelable(KEY_DATA_URI, r4);
            L17:
                Bundle r5 = this.mExtras;
                if (r5 == null) goto L20;
                r0.putBundle(KEY_EXTRAS_BUNDLE, r5);
            L20:
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

            @Nullable
            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            @NonNull
            public Message setData(@Nullable String r1, @Nullable Uri r2) {
                this.mDataMimeType = r1;
                this.mDataUri = r2;
                return this;
            }

            @NonNull
            @RequiresApi(24)
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            Notification.MessagingStyle.Message toAndroidMessage() {
                Person r0 = getPerson();
                CharSequence r2 = null;
                android.app.Person r3 = null;
                if (Build.VERSION.SDK_INT < 28) goto L9;
                CharSequence r4 = getText();
                long r5 = getTimestamp();
                if (r0 == null) goto L8;
                r3 = r0.toAndroidPerson();
            L8:
                Notification.MessagingStyle.Message r1 = new Notification.MessagingStyle.Message(r4, r5, r3);
            L15:
                if (getDataMimeType() == null) goto L17;
                r1.setData(getDataMimeType(), getDataUri());
            L17:
                return r1;
            L9:
                CharSequence r6 = getText();
                long r7 = getTimestamp();
                if (r0 == null) goto L13;
                r2 = r0.getName();
            L13:
                r1 = new Notification.MessagingStyle.Message(r6, r7, r2);
                goto L15
            }
        }

        MessagingStyle() {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        public MessagingStyle(@NonNull Person r2) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if (TextUtils.isEmpty(r2.getName()) == true) goto L7;
            this.mUser = r2;
            return;
        L7:
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence r2) {
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(r2).build();
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification r1) {
            Style r2 = Style.extractStyleFromNotification(r1);
            if ((r2 instanceof MessagingStyle) == true) goto L5;
            return null;
        L5:
            return (MessagingStyle) r2;
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

        private CharSequence makeMessageLine(@NonNull Message r8) {
            BidiFormatter r0 = BidiFormatter.getInstance();
            SpannableStringBuilder r1 = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT < 21) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            int r3 = ViewCompat.MEASURED_STATE_MASK;
        L9:
            CharSequence r5 = "";
            if (r8.getPerson() != null) goto L12;
            CharSequence r4 = "";
        L14:
            if (TextUtils.isEmpty(r4) == false) goto L20;
            r4 = this.mUser.getName();
            if (r2 == false) goto L20;
            if (this.mBuilder.getColor() == 0) goto L20;
            r3 = this.mBuilder.getColor();
        L20:
            CharSequence r6 = r0.unicodeWrap(r4);
            r1.append(r6);
            r1.setSpan(makeFontColorSpan(r3), r1.length() - r6.length(), r1.length(), 33);
            if (r8.getText() == null) goto L24;
            r5 = r8.getText();
        L24:
            r1.append("  ").append(r0.unicodeWrap(r5));
            return r1;
        L12:
            r4 = r8.getPerson().getName();
            goto L14
        L8:
            r3 = -1;
            goto L9
        L5:
            r2 = false;
            goto L6
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(@NonNull Bundle r3) {
            super.addCompatExtras(r3);
            r3.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            r3.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            r3.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle == null) goto L8;
            if (this.mIsGroupConversation.booleanValue() == false) goto L8;
            r3.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
        L8:
            if (this.mMessages.isEmpty() == true) goto L11;
            r3.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
        L11:
            if (this.mHistoricMessages.isEmpty() == true) goto L13;
            r3.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
        L13:
            Boolean r2 = this.mIsGroupConversation;
            if (r2 == null) goto L17;
            r3.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, r2.booleanValue());
            return;
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message r2) {
            if (r2 == null) goto L6;
            this.mHistoricMessages.add(r2);
            if (this.mHistoricMessages.size() <= 25) goto L6;
            this.mHistoricMessages.remove(0);
        L6:
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message r2) {
            if (r2 == null) goto L6;
            this.mMessages.add(r2);
            if (this.mMessages.size() <= 25) goto L6;
            this.mMessages.remove(0);
        L6:
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence r2, long r3, @Nullable Person r5) {
            addMessage(new Message(r2, r3, r5));
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence r4, long r5, @Nullable CharSequence r7) {
            this.mMessages.add(new Message(r4, r5, new Person.Builder().setName(r7).build()));
            if (this.mMessages.size() <= 25) goto L5;
            this.mMessages.remove(0);
        L5:
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r8) {
            int r0 = Build.VERSION.SDK_INT;
            setGroupConversation(isGroupConversation());
            if (r0 < 24) goto L25;
            Person r3 = this.mUser;
            if (r0 < 28) goto L7;
            Notification.MessagingStyle r2 = new Notification.MessagingStyle(r3.toAndroidPerson());
        L8:
            Iterator<Message> r4 = this.mMessages.iterator();
        L10:
            if (r4.hasNext() == false) goto L13;
            r2.addMessage(r4.next().toAndroidMessage());
            goto L10
        L13:
            if (r0 < 26) goto L19;
            Iterator<Message> r5 = this.mHistoricMessages.iterator();
        L16:
            if (r5.hasNext() == false) goto L19;
            r2.addHistoricMessage(r5.next().toAndroidMessage());
        L19:
            if (this.mIsGroupConversation.booleanValue() == true) goto L21;
            if (r0 >= 28) goto L21;
        L22:
            if (r0 < 28) goto L24;
            r2.setGroupConversation(this.mIsGroupConversation.booleanValue());
        L24:
            r2.setBuilder(r8.getBuilder());
            return;
        L21:
            r2.setConversationTitle(this.mConversationTitle);
            goto L22
        L7:
            r2 = new Notification.MessagingStyle(r3.getName());
            goto L8
        L25:
            Message r1 = findLatestIncomingMessage();
            if (this.mConversationTitle != null) goto L28;
        L31:
            if (r1 == null) goto L35;
            r8.getBuilder().setContentTitle("");
            if (r1.getPerson() == null) goto L35;
            Notification.Builder r6 = r8.getBuilder();
            CharSequence r7 = r1.getPerson().getName();
        L30:
            r6.setContentTitle(r7);
        L35:
            if (r1 == null) goto L42;
            Notification.Builder r9 = r8.getBuilder();
            if (this.mConversationTitle == null) goto L39;
            CharSequence r10 = makeMessageLine(r1);
        L40:
            r9.setContentText(r10);
            goto L42
        L39:
            r10 = r1.getText();
        L42:
            if (r0 < 16) goto L68;
            SpannableStringBuilder r11 = new SpannableStringBuilder();
            if (this.mConversationTitle == null) goto L46;
        L49:
            boolean r12 = true;
        L50:
            int r13 = this.mMessages.size() - 1;
        L51:
            if (r13 < 0) goto L60;
            Message r14 = this.mMessages.get(r13);
            if (r12 == false) goto L55;
            CharSequence r15 = makeMessageLine(r14);
        L57:
            if (r13 == (this.mMessages.size() - 1)) goto L59;
            r11.insert(0, "\n");
        L59:
            r11.insert(0, r15);
            r13 = r13 - 1;
            goto L51
        L55:
            r15 = r14.getText();
            goto L57
        L60:
            new Notification.BigTextStyle(r8.getBuilder()).setBigContentTitle(null).bigText(r11);
            return;
        L46:
            if (hasMessagesWithoutSender() == true) goto L49;
            r12 = false;
            goto L50
        L68:
            return;
        L28:
            if (this.mIsGroupConversation.booleanValue() == false) goto L31;
            r6 = r8.getBuilder();
            r7 = this.mConversationTitle;
            goto L30
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r1) {
            super.clearCompatExtraKeys(r1);
            r1.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            r1.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            r1.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            r1.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            r1.remove(NotificationCompat.EXTRA_MESSAGES);
            r1.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            r1.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        @NonNull
        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        @NonNull
        public List<Message> getMessages() {
            return this.mMessages;
        }

        @NonNull
        public Person getUser() {
            return this.mUser;
        }

        @Nullable
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
        protected void restoreFromCompatExtras(@NonNull Bundle r3) {
            super.restoreFromCompatExtras(r3);
            this.mMessages.clear();
            if (r3.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == false) goto L5;
            Person r0 = Person.fromBundle(r3.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
        L6:
            this.mUser = r0;
            CharSequence r1 = r3.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = r1;
            if (r1 != null) goto L9;
            this.mConversationTitle = r3.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
        L9:
            Parcelable[] r2 = r3.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (r2 == null) goto L12;
            this.mMessages.addAll(Message.getMessagesFromBundleArray(r2));
        L12:
            Parcelable[] r4 = r3.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (r4 == null) goto L16;
            this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(r4));
        L16:
            if (r3.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION) == false) goto L19;
            this.mIsGroupConversation = Boolean.valueOf(r3.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            return;
        L19:
            return;
        L5:
            r0 = new Person.Builder().setName(r3.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            goto L6
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence r1) {
            this.mConversationTitle = r1;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean r1) {
            this.mIsGroupConversation = Boolean.valueOf(r1);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ServiceNotificationBehavior {
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
            return Math.round(((1.0f - r5) * r0) + (r5 * r1));
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

        @Nullable
        static Style constructCompatStyleByName(@Nullable String r2) {
            if (r2 == null) goto L38;
            r2.hashCode();
            byte r0 = -1;
            switch(r2.hashCode()) {
                case -716705180: goto L23;
                case -171946061: goto L19;
                case 912942987: goto L15;
                case 919595044: goto L11;
                case 2090799565: goto L7;
                default: goto L26;
            };
        L26:
            switch(r0) {
                case 0: goto L37;
                case 1: goto L35;
                case 2: goto L33;
                case 3: goto L31;
                case 4: goto L29;
                default: goto L40;
            };
        L40:
            return null;
        L29:
            return new MessagingStyle();
        L31:
            return new BigTextStyle();
        L33:
            return new InboxStyle();
        L35:
            return new BigPictureStyle();
        L37:
            return new DecoratedCustomViewStyle();
        L7:
            if (r2.equals("androidx.core.app.NotificationCompat$MessagingStyle") == false) goto L26;
            r0 = 4;
            goto L26
        L11:
            if (r2.equals("androidx.core.app.NotificationCompat$BigTextStyle") == false) goto L26;
            r0 = 3;
            goto L26
        L15:
            if (r2.equals("androidx.core.app.NotificationCompat$InboxStyle") == false) goto L26;
            r0 = 2;
            goto L26
        L19:
            if (r2.equals("androidx.core.app.NotificationCompat$BigPictureStyle") == false) goto L26;
            r0 = 1;
            goto L26
        L23:
            if (r2.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle") == false) goto L26;
            r0 = 0;
            goto L26
        L38:
            return null;
        }

        @Nullable
        private static Style constructCompatStyleByPlatformName(@Nullable String r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            int r1 = Build.VERSION.SDK_INT;
            if (r1 >= 16) goto L8;
        L29:
            return null;
        L8:
            if (r3.equals(Notification.BigPictureStyle.class.getName()) == false) goto L12;
            return new BigPictureStyle();
        L12:
            if (r3.equals(Notification.BigTextStyle.class.getName()) == false) goto L16;
            return new BigTextStyle();
        L16:
            if (r3.equals(Notification.InboxStyle.class.getName()) == false) goto L20;
            return new InboxStyle();
        L20:
            if (r1 < 24) goto L29;
            if (r3.equals(Notification.MessagingStyle.class.getName()) == false) goto L26;
            return new MessagingStyle();
        L26:
            if (r3.equals(Notification.DecoratedCustomViewStyle.class.getName()) == false) goto L29;
            return new DecoratedCustomViewStyle();
        }

        @Nullable
        static Style constructCompatStyleForBundle(@NonNull Bundle r1) {
            Style r0 = constructCompatStyleByName(r1.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (r0 == null) goto L6;
            return r0;
        L6:
            if (r1.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) == true) goto L28;
            if (r1.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER) == true) goto L28;
            if (r1.containsKey(NotificationCompat.EXTRA_PICTURE) == true) goto L26;
            if (r1.containsKey(NotificationCompat.EXTRA_PICTURE_ICON) == true) goto L26;
            if (r1.containsKey(NotificationCompat.EXTRA_BIG_TEXT) == false) goto L20;
            return new BigTextStyle();
        L20:
            if (r1.containsKey(NotificationCompat.EXTRA_TEXT_LINES) == false) goto L24;
            return new InboxStyle();
        L24:
            return constructCompatStyleByPlatformName(r1.getString(NotificationCompat.EXTRA_TEMPLATE));
        L26:
            return new BigPictureStyle();
        L28:
            return new MessagingStyle();
        }

        @Nullable
        static Style constructStyleForExtras(@NonNull Bundle r2) {
            Style r0 = constructCompatStyleForBundle(r2);
            if (r0 != null) goto L8;
            return null;
        L8:
            r0.restoreFromCompatExtras(r2);     // Catch: ClassCastException -> L7
            return r0;
        L7:
            return null;
        }

        private Bitmap createColoredBitmap(int r2, int r3, int r4) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, r2), r3, r4);
        }

        private Bitmap createColoredBitmap(@NonNull IconCompat r3, int r4, int r5) {
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

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style extractStyleFromNotification(@NonNull Notification r0) {
            Bundle r1 = NotificationCompat.getExtras(r0);
            if (r1 != null) goto L7;
            return null;
        L7:
            return constructStyleForExtras(r1);
        }

        private void hideNormalContent(RemoteViews r2) {
            r2.setViewVisibility(R.id.title, 8);
            r2.setViewVisibility(R.id.text2, 8);
            r2.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle r3) {
            if (this.mSummaryTextSet == false) goto L5;
            r3.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
        L5:
            CharSequence r0 = this.mBigContentTitle;
            if (r0 == null) goto L8;
            r3.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, r0);
        L8:
            String r2 = getClassName();
            if (r2 == null) goto L12;
            r3.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, r2);
            return;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor r1) {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews applyStandardTemplate(boolean r17, int r18, boolean r19) {
            Resources r1 = this.mBuilder.mContext.getResources();
            RemoteViews r8 = new RemoteViews(this.mBuilder.mContext.getPackageName(), r18);
            boolean r9 = true;
            int r10 = 0;
            if (this.mBuilder.getPriority() >= (-1)) goto L5;
            boolean r2 = true;
        L6:
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 16) goto L14;
            if (r11 >= 21) goto L14;
            if (r2 == false) goto L12;
            r8.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
            int r3 = R.id.icon;
            int r6 = R.drawable.notification_template_icon_low_bg;
        L13:
            r8.setInt(r3, "setBackgroundResource", r6);
            goto L14
        L12:
            r8.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
            r3 = R.id.icon;
            r6 = R.drawable.notification_template_icon_bg;
        L14:
            Builder r4 = this.mBuilder;
            if (r4.mLargeIcon == null) goto L28;
            int r5 = R.id.icon;
            if (r11 < 16) goto L19;
            r8.setViewVisibility(r5, 0);
            r8.setImageViewBitmap(r5, this.mBuilder.mLargeIcon);
        L20:
            if (r17 == true) goto L22;
        L36:
            CharSequence r7 = this.mBuilder.mContentTitle;
            if (r7 == null) goto L39;
            r8.setTextViewText(R.id.title, r7);
        L39:
            CharSequence r12 = this.mBuilder.mContentText;
            if (r12 == null) goto L42;
            r8.setTextViewText(R.id.text, r12);
            boolean r13 = true;
        L43:
            if (r11 < 21) goto L45;
        L47:
            boolean r14 = false;
        L48:
            Builder r15 = this.mBuilder;
            CharSequence r16 = r15.mContentInfo;
            if (r16 == null) goto L53;
            int r20 = R.id.info;
            r8.setTextViewText(r20, r16);
        L51:
            r8.setViewVisibility(r20, 0);
            boolean r110 = true;
            boolean r111 = true;
        L60:
            CharSequence r21 = this.mBuilder.mSubText;
            if (r21 == null) goto L67;
            if (r11 < 16) goto L67;
            r8.setTextViewText(R.id.text, r21);
            CharSequence r22 = this.mBuilder.mContentText;
            if (r22 == null) goto L66;
            int r23 = R.id.text2;
            r8.setTextViewText(r23, r22);
            r8.setViewVisibility(r23, 0);
            boolean r24 = true;
        L68:
            if (r24 == false) goto L74;
            if (r11 < 16) goto L74;
            if (r19 == false) goto L72;
            r8.setTextViewTextSize(R.id.text, 0, r1.getDimensionPixelSize(R.dimen.notification_subtext_size));
        L72:
            r8.setViewPadding(R.id.line1, 0, 0, 0, 0);
        L74:
            if (this.mBuilder.getWhenIfShowing() != 0) goto L76;
            r9 = r111;
        L85:
            int r0 = R.id.right_side;
            if (r9 == false) goto L88;
            int r25 = 0;
        L89:
            r8.setViewVisibility(r0, r25);
            int r26 = R.id.line3;
            if (r110 == true) goto L93;
            r10 = 8;
        L93:
            r8.setViewVisibility(r26, r10);
            return r8;
        L88:
            r25 = 8;
            goto L89
        L76:
            if (this.mBuilder.mUseChronometer == false) goto L83;
            if (r11 < 16) goto L83;
            int r27 = R.id.chronometer;
            r8.setViewVisibility(r27, 0);
            r8.setLong(r27, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            r8.setBoolean(r27, "setStarted", true);
            boolean r28 = this.mBuilder.mChronometerCountDown;
            if (r28 == false) goto L85;
            if (r11 < 24) goto L85;
            r8.setChronometerCountDown(r27, r28);
        L83:
            int r29 = R.id.time;
            r8.setViewVisibility(r29, 0);
            r8.setLong(r29, "setTime", this.mBuilder.getWhenIfShowing());
            goto L85
        L66:
            r8.setViewVisibility(R.id.text2, 8);
        L67:
            r24 = false;
            goto L68
        L53:
            if (r15.mNumber > 0) goto L55;
            r8.setViewVisibility(R.id.info, 8);
            r110 = r13;
            r111 = r14;
            goto L60
        L55:
            if (this.mBuilder.mNumber <= r1.getInteger(R.integer.status_bar_notification_info_maxnum)) goto L57;
            r8.setTextViewText(R.id.info, r1.getString(R.string.status_bar_notification_info_overflow));
        L58:
            r20 = R.id.info;
            goto L51
        L57:
            r8.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
            goto L58
        L45:
            if (this.mBuilder.mLargeIcon == null) goto L47;
            r14 = true;
            goto L48
        L42:
            r13 = false;
            goto L43
        L22:
            if (this.mBuilder.mNotification.icon == 0) goto L36;
            int r30 = r1.getDimensionPixelSize(R.dimen.notification_right_icon_size);
            int r31 = r30 - (r1.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
            if (r11 < 21) goto L26;
            Builder r32 = this.mBuilder;
            r8.setImageViewBitmap(R.id.right_icon, createIconWithBackground(r32.mNotification.icon, r30, r31, r32.getColor()));
        L27:
            r8.setViewVisibility(R.id.right_icon, 0);
            goto L36
        L26:
            r8.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
            goto L27
        L19:
            r8.setViewVisibility(r5, 8);
            goto L20
        L28:
            if (r17 == false) goto L36;
            if (r4.mNotification.icon == 0) goto L36;
            int r33 = R.id.icon;
            r8.setViewVisibility(r33, 0);
            if (r11 < 21) goto L34;
            int r34 = r1.getDimensionPixelSize(R.dimen.notification_large_icon_width) - r1.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int r35 = r1.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Builder r36 = this.mBuilder;
            Bitmap r37 = createIconWithBackground(r36.mNotification.icon, r34, r35, r36.getColor());
        L35:
            r8.setImageViewBitmap(r33, r37);
            goto L36
        L34:
            r37 = createColoredBitmap(this.mBuilder.mNotification.icon, -1);
            goto L35
        L5:
            r2 = false;
            goto L6
        }

        @Nullable
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
            int r0 = R.id.notification_main_column;
            r8.removeAllViews(r0);
            r8.addView(r0, r9.clone());
            r8.setViewVisibility(r0, 0);
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r8.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
            return;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected void clearCompatExtraKeys(@NonNull Bundle r1) {
            r1.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            r1.remove(NotificationCompat.EXTRA_TITLE_BIG);
            r1.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        Bitmap createColoredBitmap(@NonNull IconCompat r2, int r3) {
            return createColoredBitmap(r2, r3, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected String getClassName() {
            return null;
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
        protected void restoreFromCompatExtras(@NonNull Bundle r3) {
            if (r3.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT) == false) goto L5;
            this.mSummaryText = r3.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            this.mSummaryTextSet = true;
        L5:
            this.mBigContentTitle = r3.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder r2) {
            if (this.mBuilder == r2) goto L8;
            this.mBuilder = r2;
            if (r2 == null) goto L9;
            r2.setStyle(this);
            return;
        L9:
            return;
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

        public WearableExtender(@NonNull Notification r13) {
            int r0 = Build.VERSION.SDK_INT;
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle r14 = NotificationCompat.getExtras(r13);
            if (r14 == null) goto L5;
            Bundle r15 = r14.getBundle(EXTRA_WEARABLE_EXTENSIONS);
        L6:
            if (r15 == null) goto L28;
            ArrayList r6 = r15.getParcelableArrayList(KEY_ACTIONS);
            if (r0 < 16) goto L19;
            if (r6 == null) goto L19;
            int r8 = r6.size();
            Action[] r9 = new Action[r8];
            int r10 = 0;
        L11:
            if (r10 >= r8) goto L18;
            if (r0 < 20) goto L15;
            r9[r10] = NotificationCompat.getActionCompatFromAction((Notification.Action) r6.get(r10));
        L17:
            r10 = r10 + 1;
            goto L11
        L15:
            if (r0 < 16) goto L17;
            r9[r10] = NotificationCompatJellybean.getActionFromBundle((Bundle) r6.get(r10));
            goto L17
        L18:
            Collections.addAll(this.mActions, r9);
        L19:
            this.mFlags = r15.getInt(KEY_FLAGS, 1);
            this.mDisplayIntent = (PendingIntent) r15.getParcelable(KEY_DISPLAY_INTENT);
            Notification[] r1 = NotificationCompat.getNotificationArrayFromBundle(r15, KEY_PAGES);
            if (r1 == null) goto L22;
            Collections.addAll(this.mPages, r1);
        L22:
            this.mBackground = (Bitmap) r15.getParcelable("background");
            this.mContentIcon = r15.getInt(KEY_CONTENT_ICON);
            this.mContentIconGravity = r15.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
            this.mContentActionIndex = r15.getInt(KEY_CONTENT_ACTION_INDEX, -1);
            this.mCustomSizePreset = r15.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
            this.mCustomContentHeight = r15.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
            this.mGravity = r15.getInt(KEY_GRAVITY, 80);
            this.mHintScreenTimeout = r15.getInt(KEY_HINT_SCREEN_TIMEOUT);
            this.mDismissalId = r15.getString(KEY_DISMISSAL_ID);
            this.mBridgeTag = r15.getString(KEY_BRIDGE_TAG);
            return;
        L28:
            return;
        L5:
            r15 = null;
            goto L6
        }

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action r6) {
            int r0 = Build.VERSION.SDK_INT;
            int r1 = 0;
            if (r0 < 23) goto L9;
            IconCompat r2 = r6.getIconCompat();
            if (r2 != null) goto L7;
            Icon r3 = null;
        L8:
            Notification.Action.Builder r4 = new Notification.Action.Builder(r3, r6.getTitle(), r6.getActionIntent());
        L17:
            if (r6.getExtras() == null) goto L19;
            Bundle r5 = new Bundle(r6.getExtras());
        L20:
            r5.putBoolean("android.support.allowGeneratedReplies", r6.getAllowGeneratedReplies());
            if (r0 < 24) goto L24;
            r4.setAllowGeneratedReplies(r6.getAllowGeneratedReplies());
        L24:
            if (r0 < 31) goto L26;
            r4.setAuthenticationRequired(r6.isAuthenticationRequired());
        L26:
            r4.addExtras(r5);
            RemoteInput[] r7 = r6.getRemoteInputs();
            if (r7 == null) goto L32;
            android.app.RemoteInput[] r8 = RemoteInput.fromCompat(r7);
            int r9 = r8.length;
        L29:
            if (r1 >= r9) goto L32;
            r4.addRemoteInput(r8[r1]);
            r1 = r1 + 1;
        L32:
            return r4.build();
        L19:
            r5 = new Bundle();
            goto L20
        L7:
            r3 = r2.toIcon();
            goto L8
        L9:
            IconCompat r10 = r6.getIconCompat();
            if (r10 != null) goto L12;
        L14:
            int r11 = 0;
        L15:
            r4 = new Notification.Action.Builder(r11, r6.getTitle(), r6.getActionIntent());
            goto L17
        L12:
            if (r10.getType() != 2) goto L14;
            r11 = r10.getResId();
            goto L15
        }

        private void setFlag(int r1, boolean r2) {
            if (r2 == false) goto L4;
            int r3 = r1 | this.mFlags;
        L5:
            this.mFlags = r3;
            return;
        L4:
            int r4 = this.mFlags;
            r3 = (~r1) & r4;
            goto L5
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action r2) {
            this.mActions.add(r2);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> r2) {
            this.mActions.addAll(r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification r2) {
            this.mPages.add(r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> r2) {
            this.mPages.addAll(r2);
            return this;
        }

        @NonNull
        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @NonNull
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

        @NonNull
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m11clone() {
            return clone();
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        @NonNull
        public Builder extend(@NonNull Builder r9) {
            int r0 = Build.VERSION.SDK_INT;
            Bundle r1 = new Bundle();
            if (this.mActions.isEmpty() == false) goto L5;
        L17:
            int r2 = this.mFlags;
            if (r2 == 1) goto L20;
            r1.putInt(KEY_FLAGS, r2);
        L20:
            PendingIntent r3 = this.mDisplayIntent;
            if (r3 == null) goto L24;
            r1.putParcelable(KEY_DISPLAY_INTENT, r3);
        L24:
            if (this.mPages.isEmpty() == true) goto L26;
            ArrayList<Notification> r4 = this.mPages;
            r1.putParcelableArray(KEY_PAGES, (Parcelable[]) r4.toArray(new Notification[r4.size()]));
        L26:
            Bitmap r5 = this.mBackground;
            if (r5 == null) goto L29;
            r1.putParcelable("background", r5);
        L29:
            int r6 = this.mContentIcon;
            if (r6 == 0) goto L32;
            r1.putInt(KEY_CONTENT_ICON, r6);
        L32:
            int r7 = this.mContentIconGravity;
            if (r7 == 8388613) goto L35;
            r1.putInt(KEY_CONTENT_ICON_GRAVITY, r7);
        L35:
            int r8 = this.mContentActionIndex;
            if (r8 == (-1)) goto L38;
            r1.putInt(KEY_CONTENT_ACTION_INDEX, r8);
        L38:
            int r10 = this.mCustomSizePreset;
            if (r10 == 0) goto L41;
            r1.putInt(KEY_CUSTOM_SIZE_PRESET, r10);
        L41:
            int r11 = this.mCustomContentHeight;
            if (r11 == 0) goto L44;
            r1.putInt(KEY_CUSTOM_CONTENT_HEIGHT, r11);
        L44:
            int r12 = this.mGravity;
            if (r12 == 80) goto L47;
            r1.putInt(KEY_GRAVITY, r12);
        L47:
            int r13 = this.mHintScreenTimeout;
            if (r13 == 0) goto L50;
            r1.putInt(KEY_HINT_SCREEN_TIMEOUT, r13);
        L50:
            String r14 = this.mDismissalId;
            if (r14 == null) goto L53;
            r1.putString(KEY_DISMISSAL_ID, r14);
        L53:
            String r15 = this.mBridgeTag;
            if (r15 == null) goto L56;
            r1.putString(KEY_BRIDGE_TAG, r15);
        L56:
            r9.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, r1);
            return r9;
        L5:
            if (r0 < 16) goto L16;
            ArrayList<? extends Parcelable> r16 = new ArrayList(this.mActions.size());
            Iterator<Action> r17 = this.mActions.iterator();
        L8:
            if (r17.hasNext() == false) goto L15;
            Action r18 = r17.next();
            if (r0 >= 20) goto L11;
            if (r0 < 16) goto L8;
            Parcelable r19 = NotificationCompatJellybean.getBundleForAction(r18);
        L12:
            r16.add(r19);
            goto L8
        L11:
            r19 = getActionFromActionCompat(r18);
            goto L12
        L15:
            r1.putParcelableArrayList(KEY_ACTIONS, r16);
            goto L17
        L16:
            r1.putParcelableArrayList(KEY_ACTIONS, null);
            goto L17
        }

        @NonNull
        public List<Action> getActions() {
            return this.mActions;
        }

        @Nullable
        @Deprecated
        public Bitmap getBackground() {
            return this.mBackground;
        }

        @Nullable
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

        @Nullable
        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Nullable
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

        @NonNull
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

        @NonNull
        @Deprecated
        public WearableExtender setBackground(@Nullable Bitmap r1) {
            this.mBackground = r1;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String r1) {
            this.mBridgeTag = r1;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int r1) {
            this.mContentActionIndex = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int r1) {
            this.mContentIcon = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int r1) {
            this.mContentIconGravity = r1;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean r2) {
            setFlag(1, r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int r1) {
            this.mCustomContentHeight = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int r1) {
            this.mCustomSizePreset = r1;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String r1) {
            this.mDismissalId = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent r1) {
            this.mDisplayIntent = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int r1) {
            this.mGravity = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean r2) {
            setFlag(32, r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean r2) {
            setFlag(16, r2);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean r2) {
            setFlag(64, r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean r2) {
            setFlag(2, r2);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int r1) {
            this.mHintScreenTimeout = r1;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean r2) {
            setFlag(4, r2);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean r2) {
            setFlag(8, r2);
            return this;
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    @Nullable
    public static Action getAction(@NonNull Notification r3, int r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 20) goto L5;
        Bundle r2 = null;
        if (r0 < 19) goto L14;
        Notification.Action r1 = r3.actions[r4];
        SparseArray r5 = r3.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        if (r5 == null) goto L12;
        r2 = (Bundle) r5.get(r4);
    L12:
        return NotificationCompatJellybean.readAction(r1.icon, r1.title, r1.actionIntent, r2);
    L14:
        if (r0 >= 16) goto L16;
        return null;
    L16:
        return NotificationCompatJellybean.getAction(r3, r4);
    L5:
        return getActionCompatFromAction(r3.actions[r4]);
    }

    @NonNull
    @RequiresApi(20)
    static Action getActionCompatFromAction(@NonNull Notification.Action r20) {
        int r1 = Build.VERSION.SDK_INT;
        android.app.RemoteInput[] r2 = r20.getRemoteInputs();
        IconCompat r4 = null;
        boolean r5 = false;
        if (r2 != null) goto L5;
        RemoteInput[] r13 = null;
    L15:
        if (r1 >= 24) goto L17;
        boolean r3 = r20.getExtras().getBoolean("android.support.allowGeneratedReplies");
    L24:
        boolean r15 = r3;
        boolean r17 = r20.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        if (r1 < 28) goto L27;
        int r6 = r20.getSemanticAction();
    L28:
        int r16 = r6;
        if (r1 < 29) goto L31;
        boolean r18 = r20.isContextual();
    L33:
        if (r1 < 31) goto L35;
        r5 = r20.isAuthenticationRequired();
    L35:
        boolean r19 = r5;
        if (r1 < 23) goto L50;
        if (r20.getIcon() != null) goto L44;
        int r9 = r20.icon;
        if (r9 == 0) goto L44;
        return new Action(r9, r20.title, r20.actionIntent, r20.getExtras(), r13, null, r15, r16, r17, r18, r19);
    L44:
        if (r20.getIcon() == null) goto L48;
        r4 = IconCompat.createFromIconOrNullIfZeroResId(r20.getIcon());
    L48:
        return new Action(r4, r20.title, r20.actionIntent, r20.getExtras(), r13, null, r15, r16, r17, r18, r19);
    L50:
        return new Action(r20.icon, r20.title, r20.actionIntent, r20.getExtras(), r13, null, r15, r16, r17, r18, r19);
    L31:
        r18 = false;
        goto L33
    L27:
        r6 = r20.getExtras().getInt("android.support.action.semanticAction", 0);
        goto L28
    L17:
        if (r20.getExtras().getBoolean("android.support.allowGeneratedReplies") == false) goto L19;
    L22:
        r3 = true;
        goto L24
    L19:
        if (r20.getAllowGeneratedReplies() == true) goto L22;
        r3 = false;
        goto L24
    L5:
        RemoteInput[] r7 = new RemoteInput[r2.length];
        int r8 = 0;
    L7:
        if (r8 >= r2.length) goto L13;
        android.app.RemoteInput r10 = r2[r8];
        String r11 = r10.getResultKey();
        CharSequence r12 = r10.getLabel();
        CharSequence[] r14 = r10.getChoices();
        boolean r110 = r10.getAllowFreeFormInput();
        if (r1 < 29) goto L11;
        int r111 = r10.getEditChoicesBeforeSending();
    L12:
        r7[r8] = new RemoteInput(r11, r12, r14, r110, r111, r10.getExtras(), null);
        r8 = r8 + 1;
        goto L7
    L11:
        r111 = 0;
        goto L12
    L13:
        r13 = r7;
        goto L15
    }

    public static int getActionCount(@NonNull Notification r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 19) goto L9;
        Notification.Action[] r4 = r3.actions;
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.length;
    L9:
        if (r0 >= 16) goto L11;
        return 0;
    L11:
        return NotificationCompatJellybean.getActionCount(r3);
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return r2.getAllowSystemGeneratedContextualActions();
    }

    public static boolean getAutoCancel(@NonNull Notification r0) {
        if ((r0.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return r2.getBadgeIconType();
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return BubbleMetadata.fromPlatform(r2.getBubbleMetadata());
    }

    @Nullable
    public static String getCategory(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r2.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return r2.getChannelId();
    }

    public static int getColor(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r2.color;
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentInfo(@NonNull Notification r1) {
        return r1.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentText(@NonNull Notification r1) {
        return r1.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getContentTitle(@NonNull Notification r1) {
        return r1.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 19) goto L7;
        return r2.extras;
    L7:
        if (r0 >= 16) goto L9;
        return null;
    L9:
        return NotificationCompatJellybean.getExtras(r2);
    }

    @Nullable
    public static String getGroup(@NonNull Notification r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L7;
        return r3.getGroup();
    L7:
        if (r0 < 19) goto L12;
        Bundle r4 = r3.extras;
    L10:
        return r4.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    L12:
        if (r0 < 16) goto L14;
        r4 = NotificationCompatJellybean.getExtras(r3);
        goto L10
    L14:
        return null;
    }

    public static int getGroupAlertBehavior(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return r2.getGroupAlertBehavior();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static boolean getHighPriority(@NonNull Notification r0) {
        if ((r0.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    @RequiresApi(21)
    public static List<Action> getInvisibleActions(@NonNull Notification r3) {
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 19) goto L13;
        Bundle r4 = r3.extras.getBundle("android.car.EXTENSIONS");
        if (r4 != null) goto L7;
        return r0;
    L7:
        Bundle r5 = r4.getBundle("invisible_actions");
        if (r5 == null) goto L13;
        int r1 = 0;
    L11:
        if (r1 >= r5.size()) goto L13;
        r0.add(NotificationCompatJellybean.getActionFromBundle(r5.getBundle(Integer.toString(r1))));
        r1 = r1 + 1;
    L13:
        return r0;
    }

    public static boolean getLocalOnly(@NonNull Notification r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L9;
        if ((r4.flags & 256) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0 < 19) goto L14;
        Bundle r5 = r4.extras;
    L12:
        return r5.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    L14:
        if (r0 < 16) goto L16;
        r5 = NotificationCompatJellybean.getExtras(r4);
        goto L12
    L16:
        return false;
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification r3) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        LocusId r4 = r3.getLocusId();
        if (r4 != null) goto L8;
        return null;
    L8:
        return LocusIdCompat.toLocusIdCompat(r4);
    L9:
        return null;
    }

    @NonNull
    static Notification[] getNotificationArrayFromBundle(@NonNull Bundle r4, @NonNull String r5) {
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

    public static boolean getOngoing(@NonNull Notification r0) {
        if ((r0.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification r0) {
        if ((r0.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification r5) {
        ArrayList r0 = new ArrayList();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 28) goto L13;
        ArrayList r6 = r5.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
        if (r6 != null) goto L7;
    L21:
        return r0;
    L7:
        if (r6.isEmpty() == true) goto L21;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L21;
        r0.add(Person.fromAndroidPerson((android.app.Person) r7.next()));
        goto L10
    L13:
        if (r1 < 19) goto L21;
        String[] r8 = r5.extras.getStringArray(EXTRA_PEOPLE);
        if (r8 == null) goto L21;
        if (r8.length == 0) goto L21;
        int r2 = r8.length;
        int r3 = 0;
    L19:
        if (r3 >= r2) goto L21;
        String r4 = r8[r3];
        r0.add(new Person.Builder().setUri(r4).build());
        r3 = r3 + 1;
        goto L19
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return r2.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return r2.getSettingsText();
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return r2.getShortcutId();
    }

    @RequiresApi(19)
    public static boolean getShowWhen(@NonNull Notification r1) {
        return r1.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L7;
        return r3.getSortKey();
    L7:
        if (r0 < 19) goto L12;
        Bundle r4 = r3.extras;
    L10:
        return r4.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    L12:
        if (r0 < 16) goto L14;
        r4 = NotificationCompatJellybean.getExtras(r3);
        goto L10
    L14:
        return null;
    }

    @Nullable
    @RequiresApi(19)
    public static CharSequence getSubText(@NonNull Notification r1) {
        return r1.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return r2.getTimeoutAfter();
    }

    @RequiresApi(19)
    public static boolean getUsesChronometer(@NonNull Notification r1) {
        return r1.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return r2.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L9;
        if ((r4.flags & 512) == 0) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0 < 19) goto L14;
        Bundle r5 = r4.extras;
    L12:
        return r5.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    L14:
        if (r0 < 16) goto L16;
        r5 = NotificationCompatJellybean.getExtras(r4);
        goto L12
    L16:
        return false;
    }
}
