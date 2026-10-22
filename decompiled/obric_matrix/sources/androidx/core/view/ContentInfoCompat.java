package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;

    @NonNull
    private final Compat mCompat;

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @NonNull
        @DoNotInline
        public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r4, @NonNull final Predicate<ClipData.Item> r5) {
            ClipData r0 = r4.getClip();
            if (r0.getItemCount() != 1) goto L12;
            boolean r6 = r5.test(r0.getItemAt(0));
            if (r6 == false) goto L7;
            ContentInfo r1 = r4;
        L8:
            if (r6 == false) goto L11;
            r4 = null;
        L11:
            return Pair.create(r1, r4);
        L7:
            r1 = null;
            goto L8
        L12:
            Objects.requireNonNull(r5);
            Pair<ClipData, ClipData> r7 = ContentInfoCompat.partition(r0, new k(r5));
            if (r7.first != null) goto L17;
            return Pair.create(null, r4);
        L17:
            if (r7.second != null) goto L21;
            return Pair.create(r4, null);
        L21:
            return Pair.create(new ContentInfo.Builder(r4).setClip((ClipData) r7.first).build(), new ContentInfo.Builder(r4).setClip((ClipData) r7.second).build());
        }
    }

    public static final class Builder {

        @NonNull
        private final BuilderCompat mBuilderCompat;

        public Builder(@NonNull ClipData r3, int r4) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            BuilderCompat r0 = new BuilderCompat31Impl(r3, r4);
        L6:
            this.mBuilderCompat = r0;
            return;
        L5:
            r0 = new BuilderCompatImpl(r3, r4);
            goto L6
        }

        public Builder(@NonNull ContentInfoCompat r3) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            BuilderCompat r0 = new BuilderCompat31Impl(r3);
        L6:
            this.mBuilderCompat = r0;
            return;
        L5:
            r0 = new BuilderCompatImpl(r3);
            goto L6
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData r2) {
            this.mBuilderCompat.setClip(r2);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle r2) {
            this.mBuilderCompat.setExtras(r2);
            return this;
        }

        @NonNull
        public Builder setFlags(int r2) {
            this.mBuilderCompat.setFlags(r2);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri r2) {
            this.mBuilderCompat.setLinkUri(r2);
            return this;
        }

        @NonNull
        public Builder setSource(int r2) {
            this.mBuilderCompat.setSource(r2);
            return this;
        }
    }

    private interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData r1);

        void setExtras(@Nullable Bundle r1);

        void setFlags(int r1);

        void setLinkUri(@Nullable Uri r1);

        void setSource(int r1);
    }

    @RequiresApi(31)
    private static final class BuilderCompat31Impl implements BuilderCompat {

        @NonNull
        private final ContentInfo.Builder mPlatformBuilder;

        BuilderCompat31Impl(@NonNull ClipData r2, int r3) {
            this.mPlatformBuilder = new ContentInfo.Builder(r2, r3);
        }

        BuilderCompat31Impl(@NonNull ContentInfoCompat r2) {
            this.mPlatformBuilder = new ContentInfo.Builder(r2.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r1) {
            this.mPlatformBuilder.setClip(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r1) {
            this.mPlatformBuilder.setExtras(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r1) {
            this.mPlatformBuilder.setFlags(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r1) {
            this.mPlatformBuilder.setLinkUri(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r1) {
            this.mPlatformBuilder.setSource(r1);
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {

        @NonNull
        ClipData mClip;

        @Nullable
        Bundle mExtras;
        int mFlags;

        @Nullable
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(@NonNull ClipData r1, int r2) {
            this.mClip = r1;
            this.mSource = r2;
        }

        BuilderCompatImpl(@NonNull ContentInfoCompat r2) {
            this.mClip = r2.getClip();
            this.mSource = r2.getSource();
            this.mFlags = r2.getFlags();
            this.mLinkUri = r2.getLinkUri();
            this.mExtras = r2.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(@NonNull ClipData r1) {
            this.mClip = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(@Nullable Bundle r1) {
            this.mExtras = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r1) {
            this.mFlags = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(@Nullable Uri r1) {
            this.mLinkUri = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r1) {
            this.mSource = r1;
        }
    }

    private interface Compat {
        @NonNull
        ClipData getClip();

        @Nullable
        Bundle getExtras();

        int getFlags();

        @Nullable
        Uri getLinkUri();

        int getSource();

        @Nullable
        ContentInfo getWrapped();
    }

    @RequiresApi(31)
    private static final class Compat31Impl implements Compat {

        @NonNull
        private final ContentInfo mWrapped;

        Compat31Impl(@NonNull ContentInfo r1) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mWrapped.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    private static final class CompatImpl implements Compat {

        @NonNull
        private final ClipData mClip;

        @Nullable
        private final Bundle mExtras;
        private final int mFlags;

        @Nullable
        private final Uri mLinkUri;
        private final int mSource;

        CompatImpl(BuilderCompatImpl r5) {
            this.mClip = (ClipData) Preconditions.checkNotNull(r5.mClip);
            this.mSource = Preconditions.checkArgumentInRange(r5.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(r5.mFlags, 1);
            this.mLinkUri = r5.mLinkUri;
            this.mExtras = r5.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @NonNull
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        @Nullable
        public ContentInfo getWrapped() {
            return null;
        }

        @NonNull
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ContentInfoCompat{clip=");
            r0.append(this.mClip.getDescription());
            r0.append(", source=");
            r0.append(ContentInfoCompat.sourceToString(this.mSource));
            r0.append(", flags=");
            r0.append(ContentInfoCompat.flagsToString(this.mFlags));
            String r2 = "";
            if (this.mLinkUri != null) goto L5;
            String r1 = "";
        L6:
            r0.append(r1);
            if (this.mExtras == null) goto L10;
            r2 = ", hasExtras";
        L10:
            r0.append(r2);
            r0.append("}");
            return r0.toString();
        L5:
            r1 = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    ContentInfoCompat(@NonNull Compat r1) {
        this.mCompat = r1;
    }

    @NonNull
    static ClipData buildClipData(@NonNull ClipDescription r2, @NonNull List<ClipData.Item> r3) {
        ClipData r0 = new ClipData(new ClipDescription(r2), r3.get(0));
        int r4 = 1;
    L4:
        if (r4 >= r3.size()) goto L6;
        r0.addItem(r3.get(r4));
        r4 = r4 + 1;
        goto L4
    L6:
        return r0;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String flagsToString(int r1) {
        if ((r1 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r1);
    }

    @NonNull
    static Pair<ClipData, ClipData> partition(@NonNull ClipData r6, @NonNull androidx.core.util.Predicate<ClipData.Item> r7) {
        int r1 = 0;
        ArrayList r2 = null;
        ArrayList r3 = null;
    L4:
        if (r1 >= r6.getItemCount()) goto L14;
        ClipData.Item r4 = r6.getItemAt(r1);
        if (r7.test(r4) == false) goto L10;
        if (r2 != null) goto L9;
        r2 = new ArrayList();
    L9:
        r2.add(r4);
    L13:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r3 != null) goto L12;
        r3 = new ArrayList();
    L12:
        r3.add(r4);
        goto L13
    L14:
        if (r2 == null) goto L16;
        if (r3 != null) goto L21;
        return Pair.create(r6, null);
    L21:
        return Pair.create(buildClipData(r6.getDescription(), r2), buildClipData(r6.getDescription(), r3));
    L16:
        return Pair.create(null, r6);
    }

    @NonNull
    @RequiresApi(31)
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo r0, @NonNull Predicate<ClipData.Item> r1) {
        return Api31Impl.partition(r0, r1);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String sourceToString(int r1) {
        if (r1 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r1 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r1 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r1 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r1 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r1 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r1);
    }

    @NonNull
    @RequiresApi(31)
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo r2) {
        return new ContentInfoCompat(new Compat31Impl(r2));
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.Predicate<ClipData.Item> r5) {
        ClipData r0 = this.mCompat.getClip();
        if (r0.getItemCount() != 1) goto L12;
        boolean r6 = r5.test(r0.getItemAt(0));
        if (r6 == false) goto L7;
        ContentInfoCompat r1 = this;
    L8:
        if (r6 == false) goto L11;
        ContentInfoCompat this = null;
    L11:
        return Pair.create(r1, this);
    L7:
        r1 = null;
        goto L8
    L12:
        Pair<ClipData, ClipData> r7 = partition(r0, r5);
        if (r7.first != null) goto L17;
        return Pair.create(null, this);
    L17:
        if (r7.second != null) goto L21;
        return Pair.create(this, null);
    L21:
        return Pair.create(new Builder(this).setClip((ClipData) r7.first).build(), new Builder(this).setClip((ClipData) r7.second).build());
    }

    @NonNull
    @RequiresApi(31)
    public ContentInfo toContentInfo() {
        ContentInfo r0 = this.mCompat.getWrapped();
        Objects.requireNonNull(r0);
        return r0;
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }
}
