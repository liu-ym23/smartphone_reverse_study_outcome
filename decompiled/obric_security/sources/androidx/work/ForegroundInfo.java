package androidx.work;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class ForegroundInfo {
    private final int mForegroundServiceType;
    private final Notification mNotification;
    private final int mNotificationId;

    public ForegroundInfo(int notificationId, Notification notification) {
        this(notificationId, notification, 0);
    }

    public ForegroundInfo(int notificationId, Notification notification, int foregroundServiceType) {
        this.mNotificationId = notificationId;
        this.mNotification = notification;
        this.mForegroundServiceType = foregroundServiceType;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public int getForegroundServiceType() {
        return this.mForegroundServiceType;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L18;
        ForegroundInfo r4 = (ForegroundInfo) o;
        if (this.mNotificationId == r4.mNotificationId) goto L14;
        return false;
    L14:
        if (this.mForegroundServiceType == r4.mForegroundServiceType) goto L17;
        return false;
    L17:
        return this.mNotification.equals(r4.mNotification);
    }

    public int hashCode() {
        return (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31) + this.mNotification.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ForegroundInfo{mNotificationId=");
        r0.append(this.mNotificationId);
        r0.append(", mForegroundServiceType=").append(this.mForegroundServiceType);
        r0.append(", mNotification=").append(this.mNotification);
        r0.append('}');
        return r0.toString();
    }
}
