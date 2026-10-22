package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputFilter implements InputFilter {
    private EmojiCompat.InitCallback mInitCallback;
    private final TextView mTextView;

    @RequiresApi(19)
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EmojiInputFilter> mEmojiInputFilterReference;
        private final Reference<TextView> mViewRef;

        InitCallbackImpl(TextView r2, EmojiInputFilter r3) {
            this.mViewRef = new WeakReference(r2);
            this.mEmojiInputFilterReference = new WeakReference(r3);
        }

        private boolean isInputFilterCurrentlyRegisteredOnTextView(@Nullable TextView r3, @Nullable InputFilter r4) {
            if (r4 == null) goto L17;
            if (r3 == null) goto L17;
            InputFilter[] r5 = r3.getFilters();
            if (r5 != null) goto L9;
            return false;
        L9:
            int r0 = 0;
        L11:
            if (r0 >= r5.length) goto L17;
            if (r5[r0] == r4) goto L14;
            r0 = r0 + 1;
            goto L11
        L14:
            return true;
        L17:
            return false;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView r0 = this.mViewRef.get();
            if (isInputFilterCurrentlyRegisteredOnTextView(r0, this.mEmojiInputFilterReference.get()) == true) goto L6;
            return;
        L6:
            if (r0.isAttachedToWindow() == false) goto L14;
            CharSequence r3 = r0.getText();
            CharSequence r1 = EmojiCompat.get().process(r3);
            if (r3 != r1) goto L10;
            return;
        L10:
            int r4 = Selection.getSelectionStart(r1);
            int r2 = Selection.getSelectionEnd(r1);
            r0.setText(r1);
            if ((r1 instanceof Spannable) == false) goto L15;
            EmojiInputFilter.updateSelection((Spannable) r1, r4, r2);
            return;
        L15:
            return;
        }
    }

    EmojiInputFilter(@NonNull TextView r1) {
        this.mTextView = r1;
    }

    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback != null) goto L6;
        this.mInitCallback = new InitCallbackImpl(this.mTextView, this);
    L6:
        return this.mInitCallback;
    }

    static void updateSelection(Spannable r0, int r1, int r2) {
        if (r1 < 0) goto L5;
        if (r2 < 0) goto L5;
        Selection.setSelection(r0, r1, r2);
        return;
    L5:
        if (r1 < 0) goto L7;
        Selection.setSelection(r0, r1);
        return;
    L7:
        if (r2 < 0) goto L12;
        Selection.setSelection(r0, r2);
        return;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        if (this.mTextView.isInEditMode() == false) goto L5;
        return r3;
    L5:
        int r0 = EmojiCompat.get().getLoadState();
        if (r0 == 0) goto L30;
        boolean r1 = true;
        if (r0 == 1) goto L13;
        if (r0 == 3) goto L30;
        return r3;
    L13:
        if (r8 != 0) goto L20;
        if (r7 != 0) goto L20;
        if (r6.length() != 0) goto L20;
        if (r3 != this.mTextView.getText()) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L29;
        if (r3 == null) goto L29;
        if (r4 == 0) goto L24;
    L26:
        r3 = r3.subSequence(r4, r5);
    L28:
        return EmojiCompat.get().process(r3, 0, r3.length());
    L24:
        if (r5 != r3.length()) goto L26;
    L29:
        return r3;
    L30:
        EmojiCompat.get().registerInitCallback(getInitCallback());
        return r3;
    }
}
