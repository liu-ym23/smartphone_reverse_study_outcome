package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiTextViewHelper {
    private final HelperInternal mHelper;

    static class HelperInternal {
        HelperInternal() {
        }

        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r1) {
            return r1;
        }

        public boolean isEnabled() {
            return false;
        }

        void setAllCaps(boolean r1) {
        }

        void setEnabled(boolean r1) {
        }

        void updateTransformationMethod() {
        }

        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r1) {
            return r1;
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter mEmojiInputFilter;
        private boolean mEnabled;
        private final TextView mTextView;

        HelperInternal19(TextView r2) {
            this.mTextView = r2;
            this.mEnabled = true;
            this.mEmojiInputFilter = new EmojiInputFilter(r2);
        }

        @NonNull
        private InputFilter[] addEmojiInputFilterIfMissing(@NonNull InputFilter[] r6) {
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            if (r6[r2] == this.mEmojiInputFilter) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r6;
        L8:
            InputFilter[] r3 = new InputFilter[r6.length + 1];
            System.arraycopy(r6, 0, r3, 0, r0);
            r3[r0] = this.mEmojiInputFilter;
            return r3;
        }

        private SparseArray<InputFilter> getEmojiInputFilterPositionArray(@NonNull InputFilter[] r3) {
            SparseArray<InputFilter> r2 = new SparseArray(1);
            int r0 = 0;
        L4:
            if (r0 >= r3.length) goto L9;
            if ((r3[r0] instanceof EmojiInputFilter) == false) goto L8;
            r2.put(r0, r3[r0]);
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            return r2;
        }

        @NonNull
        private InputFilter[] removeEmojiInputFilterIfPresent(@NonNull InputFilter[] r6) {
            SparseArray<InputFilter> r5 = getEmojiInputFilterPositionArray(r6);
            if (r5.size() != 0) goto L5;
            return r6;
        L5:
            int r0 = r6.length;
            InputFilter[] r1 = new InputFilter[r6.length - r5.size()];
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r0) goto L11;
            if (r5.indexOfKey(r2) >= 0) goto L10;
            r1[r3] = r6[r2];
            r3 = r3 + 1;
        L10:
            r2 = r2 + 1;
            goto L6
        L11:
            return r1;
        }

        @Nullable
        private TransformationMethod unwrapForDisabled(@Nullable TransformationMethod r1) {
            if ((r1 instanceof EmojiTransformationMethod) == true) goto L5;
            return r1;
        L5:
            return ((EmojiTransformationMethod) r1).getOriginalTransformationMethod();
        }

        private void updateFilters() {
            InputFilter[] r0 = this.mTextView.getFilters();
            this.mTextView.setFilters(getFilters(r0));
        }

        @NonNull
        private TransformationMethod wrapForEnabled(@Nullable TransformationMethod r1) {
            if ((r1 instanceof EmojiTransformationMethod) == false) goto L6;
            return r1;
        L6:
            if ((r1 instanceof PasswordTransformationMethod) == false) goto L9;
            return r1;
        L9:
            return new EmojiTransformationMethod(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r2) {
            if (this.mEnabled == true) goto L7;
            return removeEmojiInputFilterIfPresent(r2);
        L7:
            return addEmojiInputFilterIfMissing(r2);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mEnabled;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean r1) {
            if (r1 == false) goto L5;
            updateTransformationMethod();
            return;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean r1) {
            this.mEnabled = r1;
            updateTransformationMethod();
            updateFilters();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        void setEnabledUnsafe(boolean r1) {
            this.mEnabled = r1;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            TransformationMethod r0 = wrapTransformationMethod(this.mTextView.getTransformationMethod());
            this.mTextView.setTransformationMethod(r0);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r2) {
            if (this.mEnabled == false) goto L7;
            return wrapForEnabled(r2);
        L7:
            return unwrapForDisabled(r2);
        }
    }

    @RequiresApi(19)
    private static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 mHelperDelegate;

        SkippingHelper19(TextView r2) {
            this.mHelperDelegate = new HelperInternal19(r2);
        }

        private boolean skipBecauseEmojiCompatNotInitialized() {
            return !EmojiCompat.isConfigured();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @NonNull
        InputFilter[] getFilters(@NonNull InputFilter[] r2) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r2;
        L6:
            return this.mHelperDelegate.getFilters(r2);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean isEnabled() {
            return this.mHelperDelegate.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setAllCaps(boolean r2) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.setAllCaps(r2);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void setEnabled(boolean r2) {
            boolean r0 = skipBecauseEmojiCompatNotInitialized();
            HelperInternal19 r1 = this.mHelperDelegate;
            if (r0 == false) goto L5;
            r1.setEnabledUnsafe(r2);
            return;
        L5:
            r1.setEnabled(r2);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void updateTransformationMethod() {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L5;
            return;
        L5:
            this.mHelperDelegate.updateTransformationMethod();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        @Nullable
        TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r2) {
            if (skipBecauseEmojiCompatNotInitialized() == false) goto L6;
            return r2;
        L6:
            return this.mHelperDelegate.wrapTransformationMethod(r2);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView r2) {
        this(r2, true);
    }

    public EmojiTextViewHelper(@NonNull TextView r3, boolean r4) {
        Preconditions.checkNotNull(r3, "textView cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.mHelper = new HelperInternal();
        return;
    L5:
        if (r4 == true) goto L7;
        HelperInternal r5 = new SkippingHelper19(r3);
    L8:
        this.mHelper = r5;
        return;
    L7:
        r5 = new HelperInternal19(r3);
        goto L8
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] r1) {
        return this.mHelper.getFilters(r1);
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setAllCaps(boolean r1) {
        this.mHelper.setAllCaps(r1);
    }

    public void setEnabled(boolean r1) {
        this.mHelper.setEnabled(r1);
    }

    public void updateTransformationMethod() {
        this.mHelper.updateTransformationMethod();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod r1) {
        return this.mHelper.wrapTransformationMethod(r1);
    }
}
