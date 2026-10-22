package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;

    @Nullable
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context r4, @NonNull ShortcutInfo r5) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r4;
            r0.mId = r5.getId();
            r0.mPackageName = r5.getPackage();
            Intent[] r3 = r5.getIntents();
            r0.mIntents = (Intent[]) Arrays.copyOf(r3, r3.length);
            r0.mActivity = r5.getActivity();
            r0.mLabel = r5.getShortLabel();
            r0.mLongLabel = r5.getLongLabel();
            r0.mDisabledMessage = r5.getDisabledMessage();
            int r6 = Build.VERSION.SDK_INT;
            if (r6 < 28) goto L7;
            int r7 = r5.getDisabledReason();
        L5:
            r0.mDisabledReason = r7;
            r0.mCategories = r5.getCategories();
            r0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r5.getExtras());
            r0.mUser = r5.getUserHandle();
            r0.mLastChangedTimestamp = r5.getLastChangedTimestamp();
            if (r6 < 30) goto L13;
            r0.mIsCached = r5.isCached();
        L13:
            r0.mIsDynamic = r5.isDynamic();
            r0.mIsPinned = r5.isPinned();
            r0.mIsDeclaredInManifest = r5.isDeclaredInManifest();
            r0.mIsImmutable = r5.isImmutable();
            r0.mIsEnabled = r5.isEnabled();
            r0.mHasKeyFieldsOnly = r5.hasKeyFieldsOnly();
            r0.mLocusId = ShortcutInfoCompat.getLocusId(r5);
            r0.mRank = r5.getRank();
            r0.mExtras = r5.getExtras();
            return;
        L7:
            if (r5.isEnabled() == false) goto L9;
            r7 = 0;
            goto L5
        L9:
            r7 = 3;
            goto L5
        }

        public Builder(@NonNull Context r2, @NonNull String r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat r4) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r4.mContext;
            r0.mId = r4.mId;
            r0.mPackageName = r4.mPackageName;
            Intent[] r3 = r4.mIntents;
            r0.mIntents = (Intent[]) Arrays.copyOf(r3, r3.length);
            r0.mActivity = r4.mActivity;
            r0.mLabel = r4.mLabel;
            r0.mLongLabel = r4.mLongLabel;
            r0.mDisabledMessage = r4.mDisabledMessage;
            r0.mDisabledReason = r4.mDisabledReason;
            r0.mIcon = r4.mIcon;
            r0.mIsAlwaysBadged = r4.mIsAlwaysBadged;
            r0.mUser = r4.mUser;
            r0.mLastChangedTimestamp = r4.mLastChangedTimestamp;
            r0.mIsCached = r4.mIsCached;
            r0.mIsDynamic = r4.mIsDynamic;
            r0.mIsPinned = r4.mIsPinned;
            r0.mIsDeclaredInManifest = r4.mIsDeclaredInManifest;
            r0.mIsImmutable = r4.mIsImmutable;
            r0.mIsEnabled = r4.mIsEnabled;
            r0.mLocusId = r4.mLocusId;
            r0.mIsLongLived = r4.mIsLongLived;
            r0.mHasKeyFieldsOnly = r4.mHasKeyFieldsOnly;
            r0.mRank = r4.mRank;
            Person[] r5 = r4.mPersons;
            if (r5 == null) goto L6;
            r0.mPersons = (Person[]) Arrays.copyOf(r5, r5.length);
        L6:
            if (r4.mCategories == null) goto L8;
            r0.mCategories = new HashSet(r4.mCategories);
        L8:
            PersistableBundle r6 = r4.mExtras;
            if (r6 == null) goto L11;
            r0.mExtras = r6;
        L11:
            r0.mExcludedSurfaces = r4.mExcludedSurfaces;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r2) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String r3, @NonNull String r4, @NonNull List<String> r5) {
            addCapabilityBinding(r3);
            if (r5.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r3) != null) goto L10;
            this.mCapabilityBindingParams.put(r3, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r3).put(r4, r5);
            goto L11
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L49;
            ShortcutInfoCompat r0 = this.mInfo;
            Intent[] r1 = r0.mIntents;
            if (r1 == null) goto L47;
            if (r1.length == 0) goto L47;
            if (this.mIsConversation == false) goto L15;
            if (r0.mLocusId != null) goto L13;
            r0.mLocusId = new LocusIdCompat(r0.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            ShortcutInfoCompat r2 = this.mInfo;
            if (r2.mCategories != null) goto L19;
            r2.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (Build.VERSION.SDK_INT < 21) goto L45;
            if (this.mCapabilityBindingParams == null) goto L39;
            ShortcutInfoCompat r3 = this.mInfo;
            if (r3.mExtras != null) goto L27;
            r3.mExtras = new PersistableBundle();
        L27:
            Iterator<String> r4 = this.mCapabilityBindingParams.keySet().iterator();
        L29:
            if (r4.hasNext() == false) goto L39;
            String r5 = r4.next();
            Map<String, List<String>> r6 = this.mCapabilityBindingParams.get(r5);
            this.mInfo.mExtras.putStringArray(r5, (String[]) r6.keySet().toArray(new String[0]));
            Iterator<String> r7 = r6.keySet().iterator();
        L32:
            if (r7.hasNext() == false) goto L29;
            String r8 = r7.next();
            List<String> r9 = r6.get(r8);
            PersistableBundle r10 = this.mInfo.mExtras;
            String r11 = r5 + "/" + r8;
            if (r9 != null) goto L36;
            String[] r12 = new String[0];
        L37:
            r10.putStringArray(r11, r12);
            goto L32
        L36:
            r12 = (String[]) r9.toArray(new String[0]);
        L39:
            if (this.mSliceUri == null) goto L45;
            ShortcutInfoCompat r13 = this.mInfo;
            if (r13.mExtras != null) goto L43;
            r13.mExtras = new PersistableBundle();
        L43:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L45:
            return this.mInfo;
        L47:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L49:
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
        public Builder setExcludedFromSurfaces(int r2) {
            this.mInfo.mExcludedSurfaces = r2;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle r2) {
            this.mInfo.mExtras = r2;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat r2) {
            this.mInfo.mIcon = r2;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent r3) {
            return setIntents(new Intent[]{r3});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] r2) {
            this.mInfo.mIntents = r2;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat r2) {
            this.mInfo.mLocusId = r2;
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
        public Builder setLongLived(boolean r2) {
            this.mInfo.mIsLongLived = r2;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person r3) {
            return setPersons(new Person[]{r3});
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
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri r1) {
            this.mSliceUri = r1;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle r2) {
            ShortcutInfoCompat r0 = this.mInfo;
            r0.mTransientExtras = (Bundle) Preconditions.checkNotNull(r2);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Surface {
    }

    ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r0 = this.mPersons;
        if (r0 != null) goto L8;
    L13:
        LocusIdCompat r1 = this.mLocusId;
        if (r1 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r1.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r0.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r0.length);
        int r2 = 0;
    L11:
        if (r2 >= this.mPersons.length) goto L13;
        PersistableBundle r3 = this.mExtras;
        StringBuilder r4 = new StringBuilder();
        r4.append(EXTRA_PERSON_);
        int r5 = r2 + 1;
        r4.append(r5);
        r3.putPersistableBundle(r4.toString(), this.mPersons[r2].toPersistableBundle());
        r2 = r5;
        goto L11
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static List<ShortcutInfoCompat> fromShortcuts(@NonNull Context r3, @NonNull List<ShortcutInfo> r4) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<ShortcutInfo> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(new Builder(r3, r5.next()).build());
        goto L4
    L6:
        return r0;
    }

    @Nullable
    @RequiresApi(25)
    static LocusIdCompat getLocusId(@NonNull ShortcutInfo r2) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r2.getLocusId() != null) goto L9;
        return null;
    L9:
        return LocusIdCompat.toLocusIdCompat(r2.getLocusId());
    L11:
        return getLocusIdFromExtra(r2.getExtras());
    }

    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.getString(EXTRA_LOCUS_ID);
        if (r3 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r3);
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    static boolean getLongLivedFromExtra(@Nullable PersistableBundle r2) {
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
    static Person[] getPersonsFromExtra(@NonNull PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r0 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r1 = new Person[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        StringBuilder r3 = new StringBuilder();
        r3.append(EXTRA_PERSON_);
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

    Intent addToIntent(Intent r4) {
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

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.mExtras;
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

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    @NonNull
    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int r1) {
        if ((this.mExcludedSurfaces & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
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
        PersistableBundle r4 = this.mExtras;
        if (r4 == null) goto L21;
        r0.setExtras(r4);
    L21:
        if (Build.VERSION.SDK_INT < 29) goto L34;
        Person[] r5 = this.mPersons;
        if (r5 != null) goto L25;
    L30:
        LocusIdCompat r6 = this.mLocusId;
        if (r6 == null) goto L33;
        r0.setLocusId(r6.toLocusId());
    L33:
        r0.setLongLived(this.mIsLongLived);
    L36:
        return r0.build();
    L25:
        if (r5.length <= 0) goto L30;
        int r7 = r5.length;
        android.app.Person[] r8 = new android.app.Person[r7];
        int r9 = 0;
    L27:
        if (r9 >= r7) goto L29;
        r8[r9] = this.mPersons[r9].toAndroidPerson();
        r9 = r9 + 1;
        goto L27
    L29:
        r0.setPersons(r8);
        goto L30
    L34:
        r0.setExtras(buildLegacyExtrasBundle());
        goto L36
    }
}
