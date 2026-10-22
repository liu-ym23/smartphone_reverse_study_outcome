package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static RemoteAction createRemoteAction(Icon r1, CharSequence r2, CharSequence r3, PendingIntent r4) {
            return new RemoteAction(r1, r2, r3, r4);
        }

        @DoNotInline
        static PendingIntent getActionIntent(RemoteAction r0) {
            return r0.getActionIntent();
        }

        @DoNotInline
        static CharSequence getContentDescription(RemoteAction r0) {
            return r0.getContentDescription();
        }

        @DoNotInline
        static Icon getIcon(RemoteAction r0) {
            return r0.getIcon();
        }

        @DoNotInline
        static CharSequence getTitle(RemoteAction r0) {
            return r0.getTitle();
        }

        @DoNotInline
        static boolean isEnabled(RemoteAction r0) {
            return r0.isEnabled();
        }

        @DoNotInline
        static void setEnabled(RemoteAction r0, boolean r1) {
            r0.setEnabled(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void setShouldShowIcon(RemoteAction r0, boolean r1) {
            r0.setShouldShowIcon(r1);
        }

        @DoNotInline
        static boolean shouldShowIcon(RemoteAction r0) {
            return r0.shouldShowIcon();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat r2) {
        Preconditions.checkNotNull(r2);
        this.mIcon = r2.mIcon;
        this.mTitle = r2.mTitle;
        this.mContentDescription = r2.mContentDescription;
        this.mActionIntent = r2.mActionIntent;
        this.mEnabled = r2.mEnabled;
        this.mShouldShowIcon = r2.mShouldShowIcon;
    }

    public RemoteActionCompat(@NonNull IconCompat r1, @NonNull CharSequence r2, @NonNull CharSequence r3, @NonNull PendingIntent r4) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r1);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r2);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r3);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r4);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction r5) {
        Preconditions.checkNotNull(r5);
        RemoteActionCompat r0 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(r5)), Api26Impl.getTitle(r5), Api26Impl.getContentDescription(r5), Api26Impl.getActionIntent(r5));
        r0.setEnabled(Api26Impl.isEnabled(r5));
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r0.setShouldShowIcon(Api28Impl.shouldShowIcon(r5));
    L5:
        return r0;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @NonNull
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @NonNull
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean r1) {
        this.mEnabled = r1;
    }

    public void setShouldShowIcon(boolean r1) {
        this.mShouldShowIcon = r1;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        RemoteAction r0 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(r0, isEnabled());
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Api28Impl.setShouldShowIcon(r0, shouldShowIcon());
    L5:
        return r0;
    }
}
