package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction r5) {
        Preconditions.checkNotNull(r5);
        RemoteActionCompat r0 = new RemoteActionCompat(IconCompat.createFromIcon(r5.getIcon()), r5.getTitle(), r5.getContentDescription(), r5.getActionIntent());
        r0.setEnabled(r5.isEnabled());
        r0.setShouldShowIcon(r5.shouldShowIcon());
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

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        RemoteAction r0 = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        r0.setEnabled(isEnabled());
        r0.setShouldShowIcon(shouldShowIcon());
        return r0;
    }

    public RemoteActionCompat(@NonNull IconCompat r1, @NonNull CharSequence r2, @NonNull CharSequence r3, @NonNull PendingIntent r4) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(r1);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(r2);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(r3);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(r4);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
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
}
