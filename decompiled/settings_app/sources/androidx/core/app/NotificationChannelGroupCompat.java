package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
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

        public Builder(String r2) {
            this.mGroup = new NotificationChannelGroupCompat(r2);
        }

        public Builder setName(CharSequence r2) {
            this.mGroup.mName = r2;
            return this;
        }

        public Builder setDescription(String r2) {
            this.mGroup.mDescription = r2;
            return this;
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }
    }

    NotificationChannelGroupCompat(String r2) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r2);
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r2) {
        this(r2, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r1, List<NotificationChannel> r2) {
        this(r1.getId());
        this.mName = r1.getName();
        this.mDescription = r1.getDescription();
        this.mBlocked = r1.isBlocked();
        this.mChannels = getChannelsCompat(r1.getChannels());
    }

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

    NotificationChannelGroup getNotificationChannelGroup() {
        NotificationChannelGroup r0 = new NotificationChannelGroup(this.mId, this.mName);
        r0.setDescription(this.mDescription);
        return r0;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
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

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }
}
