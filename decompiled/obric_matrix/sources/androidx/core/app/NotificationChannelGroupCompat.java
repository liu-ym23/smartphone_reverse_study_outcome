package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String r2) {
            this.mGroup = new NotificationChannelGroupCompat(r2);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String r2) {
            this.mGroup.mDescription = r2;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence r2) {
            this.mGroup.mName = r2;
            return this;
        }
    }

    @RequiresApi(28)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r2) {
        this(r2, Collections.emptyList());
    }

    @RequiresApi(26)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup r4, @NonNull List<NotificationChannel> r5) {
        this(r4.getId());
        this.mName = r4.getName();
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L5;
        this.mDescription = r4.getDescription();
    L5:
        if (r0 < 28) goto L7;
        this.mBlocked = r4.isBlocked();
        List<NotificationChannelCompat> r6 = getChannelsCompat(r4.getChannels());
    L8:
        this.mChannels = r6;
        return;
    L7:
        r6 = getChannelsCompat(r5);
        goto L8
    }

    NotificationChannelGroupCompat(@NonNull String r2) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r2);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<NotificationChannel> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        NotificationChannel r1 = r6.next();
        if (this.mId.equals(r1.getGroup()) == false) goto L4;
        r0.add(new NotificationChannelCompat(r1));
        goto L4
    L8:
        return r0;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26) goto L6;
        return null;
    L6:
        NotificationChannelGroup r1 = new NotificationChannelGroup(this.mId, this.mName);
        if (r0 < 28) goto L9;
        r1.setDescription(this.mDescription);
    L9:
        return r1;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}
