package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
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

        public Builder(String r2, int r3) {
            this.mChannel = new NotificationChannelCompat(r2, r3);
        }

        public Builder setName(CharSequence r2) {
            this.mChannel.mName = r2;
            return this;
        }

        public Builder setImportance(int r2) {
            this.mChannel.mImportance = r2;
            return this;
        }

        public Builder setDescription(String r2) {
            this.mChannel.mDescription = r2;
            return this;
        }

        public Builder setGroup(String r2) {
            this.mChannel.mGroupId = r2;
            return this;
        }

        public Builder setShowBadge(boolean r2) {
            this.mChannel.mShowBadge = r2;
            return this;
        }

        public Builder setSound(Uri r2, AudioAttributes r3) {
            this.mChannel.mSound = r2;
            this.mChannel.mAudioAttributes = r3;
            return this;
        }

        public Builder setLightsEnabled(boolean r2) {
            this.mChannel.mLights = r2;
            return this;
        }

        public Builder setLightColor(int r2) {
            this.mChannel.mLightColor = r2;
            return this;
        }

        public Builder setVibrationEnabled(boolean r2) {
            this.mChannel.mVibrationEnabled = r2;
            return this;
        }

        public Builder setVibrationPattern(long[] r3) {
            NotificationChannelCompat r0 = this.mChannel;
            if (r3 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.mVibrationEnabled = r1;
            this.mChannel.mVibrationPattern = r3;
            return this;
        L5:
            if (r3.length <= 0) goto L7;
            r1 = true;
            goto L8
        }

        public Builder setConversationId(String r2, String r3) {
            this.mChannel.mParentId = r2;
            this.mChannel.mConversationId = r3;
            return this;
        }

        public NotificationChannelCompat build() {
            return this.mChannel;
        }
    }

    NotificationChannelCompat(String r2, int r3) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(r2);
        this.mImportance = r3;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    NotificationChannelCompat(NotificationChannel r3) {
        this(r3.getId(), r3.getImportance());
        this.mName = r3.getName();
        this.mDescription = r3.getDescription();
        this.mGroupId = r3.getGroup();
        this.mShowBadge = r3.canShowBadge();
        this.mSound = r3.getSound();
        this.mAudioAttributes = r3.getAudioAttributes();
        this.mLights = r3.shouldShowLights();
        this.mLightColor = r3.getLightColor();
        this.mVibrationEnabled = r3.shouldVibrate();
        this.mVibrationPattern = r3.getVibrationPattern();
        this.mParentId = r3.getParentChannelId();
        this.mConversationId = r3.getConversationId();
        this.mBypassDnd = r3.canBypassDnd();
        this.mLockscreenVisibility = r3.getLockscreenVisibility();
        this.mCanBubble = r3.canBubble();
        this.mImportantConversation = r3.isImportantConversation();
    }

    NotificationChannel getNotificationChannel() {
        NotificationChannel r0 = new NotificationChannel(this.mId, this.mName, this.mImportance);
        r0.setDescription(this.mDescription);
        r0.setGroup(this.mGroupId);
        r0.setShowBadge(this.mShowBadge);
        r0.setSound(this.mSound, this.mAudioAttributes);
        r0.enableLights(this.mLights);
        r0.setLightColor(this.mLightColor);
        r0.setVibrationPattern(this.mVibrationPattern);
        r0.enableVibration(this.mVibrationEnabled);
        String r1 = this.mParentId;
        if (r1 == null) goto L7;
        String r4 = this.mConversationId;
        if (r4 == null) goto L7;
        r0.setConversationId(r1, r4);
    L7:
        return r0;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }
}
