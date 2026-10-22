package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    static class Api26Impl {
        private Api26Impl() {
        }

        static CharSequence getContentDescription(RemoteAction r0) {
            return r0.getContentDescription();
        }

        static PendingIntent getActionIntent(RemoteAction r0) {
            return r0.getActionIntent();
        }

        static CharSequence getTitle(RemoteAction r0) {
            return r0.getTitle();
        }

        static Icon getIcon(RemoteAction r0) {
            return r0.getIcon();
        }

        static boolean isEnabled(RemoteAction r0) {
            return r0.isEnabled();
        }

        static RemoteAction createRemoteAction(Icon r1, CharSequence r2, CharSequence r3, PendingIntent r4) {
            return new RemoteAction(r1, r2, r3, r4);
        }

        static void setEnabled(RemoteAction r0, boolean r1) {
            r0.setEnabled(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static boolean shouldShowIcon(RemoteAction r0) {
            return r0.shouldShowIcon();
        }

        static void setShouldShowIcon(RemoteAction r0, boolean r1) {
            r0.setShouldShowIcon(r1);
        }
    }

    public RemoteActionCompat(IconCompat r1, CharSequence r2, CharSequence r3, PendingIntent r4) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r1);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r2);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r3);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r4);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    public RemoteActionCompat() {
    }

    public RemoteActionCompat(RemoteActionCompat r2) {
        Preconditions.checkNotNull(r2);
        this.mIcon = r2.mIcon;
        this.mTitle = r2.mTitle;
        this.mContentDescription = r2.mContentDescription;
        this.mActionIntent = r2.mActionIntent;
        this.mEnabled = r2.mEnabled;
        this.mShouldShowIcon = r2.mShouldShowIcon;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction r5) {
        Preconditions.checkNotNull(r5);
        RemoteActionCompat r0 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r5)), Api26Impl.getTitle(r5), Api26Impl.getContentDescription(r5), Api26Impl.getActionIntent(r5));
        r0.setEnabled(Api26Impl.isEnabled(r5));
        r0.setShouldShowIcon(Api28Impl.shouldShowIcon(r5));
        return r0;
    }

    public void setEnabled(boolean r1) {
        this.mEnabled = r1;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setShouldShowIcon(boolean r1) {
        this.mShouldShowIcon = r1;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public RemoteAction toRemoteAction() {
        RemoteAction r0 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r0, isEnabled());
        Api28Impl.setShouldShowIcon(r0, shouldShowIcon());
        return r0;
    }
}
