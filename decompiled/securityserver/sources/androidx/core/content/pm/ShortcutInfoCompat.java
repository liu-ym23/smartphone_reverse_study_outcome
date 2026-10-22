package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsLongLived;
    CharSequence mLabel;
    CharSequence mLongLabel;
    Person[] mPersons;
    int mRank;

    public static class Builder {
        private final ShortcutInfoCompat mInfo;

        public Builder(@NonNull Context r2, @NonNull String r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L12;
            ShortcutInfoCompat r1 = this.mInfo;
            Intent[] r0 = r1.mIntents;
            if (r0 == null) goto L10;
            if (r0.length == 0) goto L10;
            return r1;
        L10:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L12:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName r2) {
            this.mInfo.mActivity = r2;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> r2) {
            this.mInfo.mCategories = r2;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence r2) {
            this.mInfo.mDisabledMessage = r2;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat r2) {
            this.mInfo.mIcon = r2;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent r1) {
            return setIntents(new Intent[]{r1});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] r2) {
            this.mInfo.mIntents = r2;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence r2) {
            this.mInfo.mLongLabel = r2;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person r1) {
            return setPersons(new Person[]{r1});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] r2) {
            this.mInfo.mPersons = r2;
            return this;
        }

        @NonNull
        public Builder setRank(int r2) {
            this.mInfo.mRank = r2;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence r2) {
            this.mInfo.mLabel = r2;
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean r2) {
            this.mInfo.mIsLongLived = r2;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r3.mContext;
            r0.mId = r3.mId;
            Intent[] r2 = r3.mIntents;
            r0.mIntents = (Intent[]) Arrays.copyOf(r2, r2.length);
            r0.mActivity = r3.mActivity;
            r0.mLabel = r3.mLabel;
            r0.mLongLabel = r3.mLongLabel;
            r0.mDisabledMessage = r3.mDisabledMessage;
            r0.mIcon = r3.mIcon;
            r0.mIsAlwaysBadged = r3.mIsAlwaysBadged;
            r0.mIsLongLived = r3.mIsLongLived;
            r0.mRank = r3.mRank;
            Person[] r4 = r3.mPersons;
            if (r4 == null) goto L6;
            r0.mPersons = (Person[]) Arrays.copyOf(r4, r4.length);
        L6:
            if (r3.mCategories == null) goto L9;
            r0.mCategories = new HashSet(r3.mCategories);
            return;
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context r2, @NonNull ShortcutInfo r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3.getId();
            Intent[] r1 = r3.getIntents();
            r0.mIntents = (Intent[]) Arrays.copyOf(r1, r1.length);
            r0.mActivity = r3.getActivity();
            r0.mLabel = r3.getShortLabel();
            r0.mLongLabel = r3.getLongLabel();
            r0.mDisabledMessage = r3.getDisabledMessage();
            r0.mCategories = r3.getCategories();
            r0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r3.getExtras());
            r0.mRank = r3.getRank();
        }
    }

    public ShortcutInfoCompat() {
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        PersistableBundle r0 = new PersistableBundle();
        Person[] r1 = this.mPersons;
        if (r1 != null) goto L5;
    L10:
        r0.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return r0;
    L5:
        if (r1.length <= 0) goto L10;
        r0.putInt(EXTRA_PERSON_COUNT, r1.length);
        int r2 = 0;
    L8:
        if (r2 >= this.mPersons.length) goto L10;
        StringBuilder r3 = new StringBuilder(EXTRA_PERSON_);
        int r4 = r2 + 1;
        r3.append(r4);
        r0.putPersistableBundle(r3.toString(), this.mPersons[r2].toPersistableBundle());
        r2 = r4;
        goto L8
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static boolean getLongLivedFromExtra(@NonNull PersistableBundle r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r2.getBoolean(EXTRA_LONG_LIVED);
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person[] getPersonsFromExtra(@NonNull PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r0 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r1 = new Person[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        StringBuilder r3 = new StringBuilder(EXTRA_PERSON_);
        int r4 = r2 + 1;
        r3.append(r4);
        r1[r2] = Person.fromPersistableBundle(r5.getPersistableBundle(r3.toString()));
        r2 = r4;
        goto L7
    L9:
        return r1;
    L13:
        return null;
    }

    public Intent addToIntent(Intent r4) {
        Intent[] r0 = this.mIntents;
        r4.putExtra("android.intent.extra.shortcut.INTENT", r0[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L12;
        Drawable r1 = null;
        if (this.mIsAlwaysBadged == false) goto L11;
        PackageManager r2 = this.mContext.getPackageManager();
        ComponentName r3 = this.mActivity;
        if (r3 != null) goto L14;
    L9:
        if (r1 != null) goto L11;
        r1 = this.mContext.getApplicationInfo().loadIcon(r2);
        goto L11
    L14:
        r1 = r2.getActivityIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L13
    L11:
        this.mIcon.addToShortcutIntent(r4, r1, this.mContext);
    L12:
        return r4;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.mCategories;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public Intent getIntent() {
        Intent[] r1 = this.mIntents;
        return r1[r1.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] r1 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r1, r1.length);
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public int getRank() {
        return this.mRank;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder r0 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r1 = this.mIcon;
        if (r1 == null) goto L6;
        r0.setIcon(r1.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r0.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r0.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r2 = this.mActivity;
        if (r2 == null) goto L14;
        r0.setActivity(r2);
    L14:
        Set<String> r3 = this.mCategories;
        if (r3 == null) goto L17;
        r0.setCategories(r3);
    L17:
        r0.setRank(this.mRank);
        Person[] r4 = this.mPersons;
        if (r4 != null) goto L20;
    L25:
        r0.setLongLived(this.mIsLongLived);
        return r0.build();
    L20:
        if (r4.length <= 0) goto L25;
        int r5 = r4.length;
        android.app.Person[] r6 = new android.app.Person[r5];
        int r7 = 0;
    L22:
        if (r7 >= r5) goto L24;
        r6[r7] = this.mPersons[r7].toAndroidPerson();
        r7 = r7 + 1;
        goto L22
    L24:
        r0.setPersons(r6);
        goto L25
    }
}
