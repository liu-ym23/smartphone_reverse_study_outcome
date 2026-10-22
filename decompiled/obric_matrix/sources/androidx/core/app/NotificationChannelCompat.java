package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;

    @NonNull
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String r2, int r3) {
            this.mChannel = new NotificationChannelCompat(r2, r3);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String r3, @NonNull String r4) {
            if (Build.VERSION.SDK_INT < 30) goto L5;
            NotificationChannelCompat r0 = this.mChannel;
            r0.mParentId = r3;
            r0.mConversationId = r4;
        L5:
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String r2) {
            this.mChannel.mDescription = r2;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String r2) {
            this.mChannel.mGroupId = r2;
            return this;
        }

        @NonNull
        public Builder setImportance(int r2) {
            this.mChannel.mImportance = r2;
            return this;
        }

        @NonNull
        public Builder setLightColor(int r2) {
            this.mChannel.mLightColor = r2;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean r2) {
            this.mChannel.mLights = r2;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r2) {
            this.mChannel.mName = r2;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean r2) {
            this.mChannel.mShowBadge = r2;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri r2, @Nullable AudioAttributes r3) {
            NotificationChannelCompat r0 = this.mChannel;
            r0.mSound = r2;
            r0.mAudioAttributes = r3;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean r2) {
            this.mChannel.mVibrationEnabled = r2;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] r3) {
            NotificationChannelCompat r0 = this.mChannel;
            if (r3 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.mVibrationEnabled = r1;
            r0.mVibrationPattern = r3;
            return this;
        L5:
            if (r3.length <= 0) goto L7;
            r1 = true;
            goto L8
        }
    }

    @RequiresApi(26)
    NotificationChannelCompat(@NonNull NotificationChannel r4) {
        this(r4.getId(), r4.getImportance());
        this.mName = r4.getName();
        this.mDescription = r4.getDescription();
        this.mGroupId = r4.getGroup();
        this.mShowBadge = r4.canShowBadge();
        this.mSound = r4.getSound();
        this.mAudioAttributes = r4.getAudioAttributes();
        this.mLights = r4.shouldShowLights();
        this.mLightColor = r4.getLightColor();
        this.mVibrationEnabled = r4.shouldVibrate();
        this.mVibrationPattern = r4.getVibrationPattern();
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L5;
        this.mParentId = r4.getParentChannelId();
        this.mConversationId = r4.getConversationId();
    L5:
        this.mBypassDnd = r4.canBypassDnd();
        this.mLockscreenVisibility = r4.getLockscreenVisibility();
        if (r0 < 29) goto L8;
        this.mCanBubble = r4.canBubble();
    L8:
        if (r0 < 30) goto L11;
        this.mImportantConversation = r4.isImportantConversation();
        return;
    }

    NotificationChannelCompat(@NonNull String r2, int r3) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r2);
        this.mImportance = r3;
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        return;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Nullable
    public String getConversationId() {
        return this.mConversationId;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getGroup() {
        return this.mGroupId;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26) goto L6;
        return null;
    L6:
        NotificationChannel r1 = new NotificationChannel(this.mId, this.mName, this.mImportance);
        r1.setDescription(this.mDescription);
        r1.setGroup(this.mGroupId);
        r1.setShowBadge(this.mShowBadge);
        r1.setSound(this.mSound, this.mAudioAttributes);
        r1.enableLights(this.mLights);
        r1.setLightColor(this.mLightColor);
        r1.setVibrationPattern(this.mVibrationPattern);
        r1.enableVibration(this.mVibrationEnabled);
        if (r0 < 30) goto L13;
        String r2 = this.mParentId;
        if (r2 == null) goto L13;
        String r5 = this.mConversationId;
        if (r5 == null) goto L13;
        r1.setConversationId(r2, r5);
    L13:
        return r1;
    }

    @Nullable
    public String getParentChannelId() {
        return this.mParentId;
    }

    @Nullable
    public Uri getSound() {
        return this.mSound;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}
