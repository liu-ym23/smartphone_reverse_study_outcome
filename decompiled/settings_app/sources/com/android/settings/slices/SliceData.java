package com.android.settings.slices;

import android.net.Uri;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class SliceData {
    private static final String TAG = "SliceData";
    private final String mFragmentClassName;
    private final int mHighlightMenuRes;
    private final int mIconResource;
    private final boolean mIsPublicSlice;
    private final String mKey;
    private final String mKeywords;
    private final String mPreferenceController;
    private final CharSequence mScreenTitle;
    private final int mSliceType;
    private final String mSummary;
    private final String mTitle;
    private final String mUnavailableSliceSubtitle;
    private final Uri mUri;
    private final String mUserRestriction;

    /* JADX INFO: renamed from: com.android.settings.slices.SliceData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class Builder {
        private String mFragmentClassName;
        private int mHighlightMenuRes;
        private int mIconResource;
        private boolean mIsPublicSlice;
        private String mKey;
        private String mKeywords;
        private String mPrefControllerClassName;
        private CharSequence mScreenTitle;
        private int mSliceType;
        private String mSummary;
        private String mTitle;
        private String mUnavailableSliceSubtitle;
        private Uri mUri;
        private String mUserRestriction;

        Builder() {
        }

        static /* synthetic */ String access$000(Builder r0) {
            return r0.mKey;
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.mTitle;
        }

        static /* synthetic */ String access$1000(Builder r0) {
            return r0.mUnavailableSliceSubtitle;
        }

        static /* synthetic */ boolean access$1100(Builder r0) {
            return r0.mIsPublicSlice;
        }

        static /* synthetic */ int access$1200(Builder r0) {
            return r0.mHighlightMenuRes;
        }

        static /* synthetic */ String access$1300(Builder r0) {
            return r0.mUserRestriction;
        }

        static /* synthetic */ String access$200(Builder r0) {
            return r0.mSummary;
        }

        static /* synthetic */ CharSequence access$300(Builder r0) {
            return r0.mScreenTitle;
        }

        static /* synthetic */ String access$400(Builder r0) {
            return r0.mKeywords;
        }

        static /* synthetic */ int access$500(Builder r0) {
            return r0.mIconResource;
        }

        static /* synthetic */ String access$600(Builder r0) {
            return r0.mFragmentClassName;
        }

        static /* synthetic */ Uri access$700(Builder r0) {
            return r0.mUri;
        }

        static /* synthetic */ String access$800(Builder r0) {
            return r0.mPrefControllerClassName;
        }

        static /* synthetic */ int access$900(Builder r0) {
            return r0.mSliceType;
        }

        public Builder setKey(String r1) {
            this.mKey = r1;
            return this;
        }

        public Builder setTitle(String r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder setSummary(String r1) {
            this.mSummary = r1;
            return this;
        }

        public Builder setScreenTitle(CharSequence r1) {
            this.mScreenTitle = r1;
            return this;
        }

        public Builder setKeywords(String r1) {
            this.mKeywords = r1;
            return this;
        }

        public Builder setIcon(int r1) {
            this.mIconResource = r1;
            return this;
        }

        public Builder setPreferenceControllerClassName(String r1) {
            this.mPrefControllerClassName = r1;
            return this;
        }

        public Builder setFragmentName(String r1) {
            this.mFragmentClassName = r1;
            return this;
        }

        public Builder setUri(Uri r1) {
            this.mUri = r1;
            return this;
        }

        public Builder setSliceType(int r1) {
            this.mSliceType = r1;
            return this;
        }

        public Builder setUnavailableSliceSubtitle(String r1) {
            this.mUnavailableSliceSubtitle = r1;
            return this;
        }

        public Builder setHighlightMenuRes(int r1) {
            this.mHighlightMenuRes = r1;
            return this;
        }

        public Builder setIsPublicSlice(boolean r1) {
            this.mIsPublicSlice = r1;
            return this;
        }

        public Builder setUserRestriction(String r1) {
            this.mUserRestriction = r1;
            return this;
        }

        public SliceData build() {
            if (TextUtils.isEmpty(this.mKey) == true) goto L22;
            if (TextUtils.isEmpty(this.mTitle) == true) goto L20;
            if (TextUtils.isEmpty(this.mFragmentClassName) == true) goto L18;
            if (TextUtils.isEmpty(this.mPrefControllerClassName) == true) goto L16;
            if (this.mHighlightMenuRes != 0) goto L14;
            OLog.w(SliceData.TAG, "Highlight menu key res is empty: " + this.mPrefControllerClassName);
        L14:
            return new SliceData(this, null);
        L16:
            throw new InvalidSliceDataException("Preference Controller cannot be empty");
        L18:
            throw new InvalidSliceDataException("Fragment Name cannot be empty");
        L20:
            throw new InvalidSliceDataException("Title cannot be empty");
        L22:
            throw new InvalidSliceDataException("Key cannot be empty");
        }

        public String getKey() {
            return this.mKey;
        }
    }

    public static class InvalidSliceDataException extends RuntimeException {
        public InvalidSliceDataException(String r1) {
            super(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceType {
        public static final int INTENT = 0;
        public static final int SLIDER = 2;
        public static final int SWITCH = 1;
    }

    /* synthetic */ SliceData(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public String getKey() {
        return this.mKey;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public CharSequence getScreenTitle() {
        return this.mScreenTitle;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public int getIconResource() {
        return this.mIconResource;
    }

    public String getFragmentClassName() {
        return this.mFragmentClassName;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getPreferenceController() {
        return this.mPreferenceController;
    }

    public int getSliceType() {
        return this.mSliceType;
    }

    public String getUnavailableSliceSubtitle() {
        return this.mUnavailableSliceSubtitle;
    }

    public int getHighlightMenuRes() {
        return this.mHighlightMenuRes;
    }

    public boolean isPublicSlice() {
        return this.mIsPublicSlice;
    }

    public String getUserRestriction() {
        return this.mUserRestriction;
    }

    private SliceData(Builder r2) {
        this.mKey = Builder.access$000(r2);
        this.mTitle = Builder.access$100(r2);
        this.mSummary = Builder.access$200(r2);
        this.mScreenTitle = Builder.access$300(r2);
        this.mKeywords = Builder.access$400(r2);
        this.mIconResource = Builder.access$500(r2);
        this.mFragmentClassName = Builder.access$600(r2);
        this.mUri = Builder.access$700(r2);
        this.mPreferenceController = Builder.access$800(r2);
        this.mSliceType = Builder.access$900(r2);
        this.mUnavailableSliceSubtitle = Builder.access$1000(r2);
        this.mIsPublicSlice = Builder.access$1100(r2);
        this.mHighlightMenuRes = Builder.access$1200(r2);
        this.mUserRestriction = Builder.access$1300(r2);
    }

    public int hashCode() {
        return this.mKey.hashCode();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof SliceData) == true) goto L7;
        return false;
    L7:
        return TextUtils.equals(this.mKey, ((SliceData) r2).mKey);
    }
}
