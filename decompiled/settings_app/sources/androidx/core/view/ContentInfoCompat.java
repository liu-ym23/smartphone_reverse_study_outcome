package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final Compat mCompat;

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static Pair<ContentInfo, ContentInfo> partition(ContentInfo r4, final Predicate<ClipData.Item> r5) {
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
            Pair<ClipData, ClipData> r7 = ContentInfoCompat.partition(r0, new ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0(r5));
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
        private final BuilderCompat mBuilderCompat;

        public Builder(ContentInfoCompat r2) {
            this.mBuilderCompat = new BuilderCompat31Impl(r2);
        }

        public Builder(ClipData r2, int r3) {
            this.mBuilderCompat = new BuilderCompat31Impl(r2, r3);
        }

        public Builder setClip(ClipData r2) {
            this.mBuilderCompat.setClip(r2);
            return this;
        }

        public Builder setSource(int r2) {
            this.mBuilderCompat.setSource(r2);
            return this;
        }

        public Builder setFlags(int r2) {
            this.mBuilderCompat.setFlags(r2);
            return this;
        }

        public Builder setLinkUri(Uri r2) {
            this.mBuilderCompat.setLinkUri(r2);
            return this;
        }

        public Builder setExtras(Bundle r2) {
            this.mBuilderCompat.setExtras(r2);
            return this;
        }

        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }
    }

    private interface BuilderCompat {
        ContentInfoCompat build();

        void setClip(ClipData r1);

        void setExtras(Bundle r1);

        void setFlags(int r1);

        void setLinkUri(Uri r1);

        void setSource(int r1);
    }

    private static final class BuilderCompat31Impl implements BuilderCompat {
        private final ContentInfo.Builder mPlatformBuilder;

        BuilderCompat31Impl(ClipData r2, int r3) {
            this.mPlatformBuilder = new ContentInfo.Builder(r2, r3);
        }

        BuilderCompat31Impl(ContentInfoCompat r2) {
            this.mPlatformBuilder = new ContentInfo.Builder(r2.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r1) {
            this.mPlatformBuilder.setClip(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r1) {
            this.mPlatformBuilder.setSource(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r1) {
            this.mPlatformBuilder.setFlags(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r1) {
            this.mPlatformBuilder.setLinkUri(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r1) {
            this.mPlatformBuilder.setExtras(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {
        ClipData mClip;
        Bundle mExtras;
        int mFlags;
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(ClipData r1, int r2) {
            this.mClip = r1;
            this.mSource = r2;
        }

        BuilderCompatImpl(ContentInfoCompat r2) {
            this.mClip = r2.getClip();
            this.mSource = r2.getSource();
            this.mFlags = r2.getFlags();
            this.mLinkUri = r2.getLinkUri();
            this.mExtras = r2.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setClip(ClipData r1) {
            this.mClip = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setSource(int r1) {
            this.mSource = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int r1) {
            this.mFlags = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri r1) {
            this.mLinkUri = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle r1) {
            this.mExtras = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }
    }

    private interface Compat {
        ClipData getClip();

        Bundle getExtras();

        int getFlags();

        Uri getLinkUri();

        int getSource();

        ContentInfo getWrapped();
    }

    private static final class Compat31Impl implements Compat {
        private final ContentInfo mWrapped;

        Compat31Impl(ContentInfo r1) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(r1);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mWrapped.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + VectorFormat.DEFAULT_SUFFIX;
        }
    }

    private static final class CompatImpl implements Compat {
        private final ClipData mClip;
        private final Bundle mExtras;
        private final int mFlags;
        private final Uri mLinkUri;
        private final int mSource;

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        CompatImpl(BuilderCompatImpl r5) {
            this.mClip = (ClipData) Preconditions.checkNotNull(r5.mClip);
            this.mSource = Preconditions.checkArgumentInRange(r5.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(r5.mFlags, 1);
            this.mLinkUri = r5.mLinkUri;
            this.mExtras = r5.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public Bundle getExtras() {
            return this.mExtras;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("ContentInfoCompat{clip=").append(this.mClip.getDescription()).append(", source=").append(ContentInfoCompat.sourceToString(this.mSource)).append(", flags=").append(ContentInfoCompat.flagsToString(this.mFlags));
            String r2 = "";
            if (this.mLinkUri != null) goto L5;
            String r1 = "";
        L6:
            StringBuilder r3 = r0.append(r1);
            if (this.mExtras == null) goto L11;
            r2 = ", hasExtras";
        L11:
            return r3.append(r2).append(VectorFormat.DEFAULT_SUFFIX).toString();
        L5:
            r1 = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

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

    static String flagsToString(int r1) {
        if ((r1 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r1);
    }

    ContentInfoCompat(Compat r1) {
        this.mCompat = r1;
    }

    public static ContentInfoCompat toContentInfoCompat(ContentInfo r2) {
        return new ContentInfoCompat(new Compat31Impl(r2));
    }

    public ContentInfo toContentInfo() {
        return (ContentInfo) Objects.requireNonNull(this.mCompat.getWrapped());
    }

    public String toString() {
        return this.mCompat.toString();
    }

    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public Pair<ContentInfoCompat, ContentInfoCompat> partition(androidx.core.util.Predicate<ClipData.Item> r5) {
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

    static Pair<ClipData, ClipData> partition(ClipData r6, androidx.core.util.Predicate<ClipData.Item> r7) {
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

    static ClipData buildClipData(ClipDescription r2, List<ClipData.Item> r3) {
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

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo r0, Predicate<ClipData.Item> r1) {
        return Api31Impl.partition(r0, r1);
    }
}
