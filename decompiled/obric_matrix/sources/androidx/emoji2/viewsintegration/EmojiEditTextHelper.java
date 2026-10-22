package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    static class HelperInternal {
        HelperInternal() {
        }

        @Nullable
        KeyListener getKeyListener(@Nullable KeyListener r1) {
            return r1;
        }

        boolean isEnabled() {
            return false;
        }

        InputConnection onCreateInputConnection(@NonNull InputConnection r1, @NonNull EditorInfo r2) {
            return r1;
        }

        void setEmojiReplaceStrategy(int r1) {
        }

        void setEnabled(boolean r1) {
        }

        void setMaxEmojiCount(int r1) {
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(@NonNull EditText r2, boolean r3) {
            this.mEditText = r2;
            EmojiTextWatcher r0 = new EmojiTextWatcher(r2, r3);
            this.mTextWatcher = r0;
            r2.addTextChangedListener(r0);
            r2.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(@Nullable KeyListener r1) {
            if ((r1 instanceof EmojiKeyListener) == false) goto L5;
            return r1;
        L5:
            if (r1 != null) goto L9;
            return null;
        L9:
            if ((r1 instanceof NumberKeyListener) == false) goto L12;
            return r1;
        L12:
            return new EmojiKeyListener(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(@NonNull InputConnection r2, @NonNull EditorInfo r3) {
            if ((r2 instanceof EmojiInputConnection) == false) goto L6;
            return r2;
        L6:
            return new EmojiInputConnection(this.mEditText, r2, r3);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int r1) {
            this.mTextWatcher.setEmojiReplaceStrategy(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean r1) {
            this.mTextWatcher.setEnabled(r1);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int r1) {
            this.mTextWatcher.setMaxEmojiCount(r1);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText r2) {
        this(r2, true);
    }

    public EmojiEditTextHelper(@NonNull EditText r3, boolean r4) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(r3, "editText cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.mHelper = new HelperInternal();
        return;
    L5:
        this.mHelper = new HelperInternal19(r3, r4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener r1) {
        return this.mHelper.getKeyListener(r1);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection r1, @NonNull EditorInfo r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return this.mHelper.onCreateInputConnection(r1, r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int r1) {
        this.mEmojiReplaceStrategy = r1;
        this.mHelper.setEmojiReplaceStrategy(r1);
    }

    public void setEnabled(boolean r1) {
        this.mHelper.setEnabled(r1);
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int r2) {
        Preconditions.checkArgumentNonnegative(r2, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = r2;
        this.mHelper.setMaxEmojiCount(r2);
    }
}
