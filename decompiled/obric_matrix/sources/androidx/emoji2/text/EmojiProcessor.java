package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;

    @Nullable
    private final int[] mEmojiAsDefaultStyleExceptions;

    @NonNull
    private EmojiCompat.GlyphChecker mGlyphChecker;

    @NonNull
    private final MetadataRepo mMetadataRepo;

    @NonNull
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    @RequiresApi(19)
    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence r5, int r6, int r7) {
            int r0 = r5.length();
            if (r6 < 0) goto L30;
            if (r0 < r6) goto L30;
            if (r7 >= 0) goto L9;
            return -1;
        L9:
            boolean r2 = false;
        L10:
            if (r7 == 0) goto L11;
            r6 = r6 - 1;
            if (r6 < 0) goto L14;
            char r3 = r5.charAt(r6);
            if (r2 == true) goto L20;
            if (Character.isSurrogate(r3) == false) goto L25;
            if (Character.isHighSurrogate(r3) == true) goto L28;
            r2 = true;
            goto L10
        L28:
            return -1;
        L25:
            r7 = r7 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r3) == false) goto L21;
            r7 = r7 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r2 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r6;
        L30:
            return -1;
        }

        static int findIndexForward(CharSequence r6, int r7, int r8) {
            int r0 = r6.length();
            if (r7 < 0) goto L29;
            if (r0 < r7) goto L29;
            if (r8 >= 0) goto L9;
            return -1;
        L9:
            boolean r3 = false;
        L10:
            if (r8 == 0) goto L11;
            if (r7 >= r0) goto L13;
            char r4 = r6.charAt(r7);
            if (r3 == true) goto L19;
            if (Character.isSurrogate(r4) == false) goto L24;
            if (Character.isLowSurrogate(r4) == true) goto L27;
            r7 = r7 + 1;
            r3 = true;
            goto L10
        L27:
            return -1;
        L24:
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r4) == false) goto L20;
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r3 == false) goto L15;
            return -1;
        L15:
            return r0;
        L11:
            return r7;
        L29:
            return -1;
        }
    }

    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(MetadataRepo.Node r2, boolean r3, int[] r4) {
            this.mState = 1;
            this.mRootNode = r2;
            this.mCurrentNode = r2;
            this.mUseEmojiAsDefaultStyle = r3;
            this.mEmojiAsDefaultStyleExceptions = r4;
        }

        private static boolean isEmojiStyle(int r1) {
            if (r1 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTextStyle(int r1) {
            if (r1 != 65038) goto L5;
            return true;
        L5:
            return false;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() == false) goto L6;
            return true;
        L6:
            if (isEmojiStyle(this.mLastCodepoint) == false) goto L9;
            return true;
        L9:
            if (this.mUseEmojiAsDefaultStyle == true) goto L11;
        L16:
            return false;
        L11:
            if (this.mEmojiAsDefaultStyleExceptions != null) goto L13;
            return true;
        L13:
            int r0 = this.mCurrentNode.getData().getCodepointAt(0);
            if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, r0) >= 0) goto L16;
            return true;
        }

        int check(int r6) {
            MetadataRepo.Node r0 = this.mCurrentNode.get(r6);
            int r2 = 3;
            if (this.mState == 2) goto L8;
            if (r0 != null) goto L6;
        L5:
            r2 = reset();
        L23:
            this.mLastCodepoint = r6;
            return r2;
        L6:
            this.mState = 2;
            this.mCurrentNode = r0;
            this.mCurrentDepth = 1;
        L7:
            r2 = 2;
            goto L23
        L8:
            if (r0 == null) goto L11;
            this.mCurrentNode = r0;
            this.mCurrentDepth++;
            goto L7
        L11:
            if (isTextStyle(r6) == true) goto L5;
            if (isEmojiStyle(r6) == true) goto L7;
            if (this.mCurrentNode.getData() == null) goto L5;
            if (this.mCurrentDepth == 1) goto L21;
        L22:
            this.mFlushNode = this.mCurrentNode;
            reset();
            goto L23
        L21:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L5;
            goto L5
        }

        EmojiMetadata getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        EmojiMetadata getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            if (this.mState == 2) goto L5;
        L11:
            return false;
        L5:
            if (this.mCurrentNode.getData() == null) goto L11;
            if (this.mCurrentDepth <= 1) goto L9;
            return true;
        L9:
            if (shouldUseEmojiPresentationStyleForSingleCodepoint() == false) goto L11;
            return true;
        }
    }

    EmojiProcessor(@NonNull MetadataRepo r1, @NonNull EmojiCompat.SpanFactory r2, @NonNull EmojiCompat.GlyphChecker r3, boolean r4, @Nullable int[] r5) {
        this.mSpanFactory = r2;
        this.mMetadataRepo = r1;
        this.mGlyphChecker = r3;
        this.mUseEmojiAsDefaultStyle = r4;
        this.mEmojiAsDefaultStyleExceptions = r5;
    }

    private void addEmoji(@NonNull Spannable r1, EmojiMetadata r2, int r3, int r4) {
        r1.setSpan(this.mSpanFactory.createSpan(r2), r3, r4, 33);
    }

    private static boolean delete(@NonNull Editable r6, @NonNull KeyEvent r7, boolean r8) {
        if (hasModifiers(r7) == false) goto L5;
        return false;
    L5:
        int r9 = Selection.getSelectionStart(r6);
        int r1 = Selection.getSelectionEnd(r6);
        if (hasInvalidSelection(r9, r1) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r2 = (EmojiSpan[]) r6.getSpans(r9, r1, EmojiSpan.class);
        if (r2 != null) goto L11;
    L24:
        return false;
    L11:
        if (r2.length <= 0) goto L24;
        int r3 = r2.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L24;
        EmojiSpan r5 = r2[r4];
        int r10 = r6.getSpanStart(r5);
        int r11 = r6.getSpanEnd(r5);
        if (r8 == false) goto L17;
        if (r10 != r9) goto L17;
    L21:
        r6.delete(r10, r11);
        return true;
    L17:
        if (r8 == true) goto L19;
        if (r11 == r9) goto L21;
    L19:
        if (r9 <= r10) goto L23;
        if (r9 < r11) goto L21;
    L23:
        r4 = r4 + 1;
        goto L13
    }

    static boolean handleDeleteSurroundingText(@NonNull InputConnection r5, @NonNull Editable r6, @IntRange(from = 0) int r7, @IntRange(from = 0) int r8, boolean r9) {
        if (r6 == null) goto L27;
        if (r5 == null) goto L27;
        if (r7 < 0) goto L27;
        if (r8 < 0) goto L27;
        int r1 = Selection.getSelectionStart(r6);
        int r2 = Selection.getSelectionEnd(r6);
        if (hasInvalidSelection(r1, r2) == false) goto L12;
        return false;
    L12:
        if (r9 == false) goto L17;
        int r10 = CodepointIndexFinder.findIndexBackward(r6, r1, Math.max(r7, 0));
        int r11 = CodepointIndexFinder.findIndexForward(r6, r2, Math.max(r8, 0));
        if (r10 == (-1)) goto L16;
        if (r11 == (-1)) goto L16;
    L18:
        EmojiSpan[] r12 = (EmojiSpan[]) r6.getSpans(r10, r11, EmojiSpan.class);
        if (r12 == null) goto L27;
        if (r12.length <= 0) goto L27;
        int r3 = r12.length;
        int r4 = 0;
    L23:
        if (r4 >= r3) goto L25;
        EmojiSpan r13 = r12[r4];
        int r14 = r6.getSpanStart(r13);
        int r15 = r6.getSpanEnd(r13);
        r10 = Math.min(r14, r10);
        r11 = Math.max(r15, r11);
        r4 = r4 + 1;
        goto L23
    L25:
        int r16 = Math.max(r10, 0);
        int r17 = Math.min(r11, r6.length());
        r5.beginBatchEdit();
        r6.delete(r16, r17);
        r5.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r10 = Math.max(r1 - r7, 0);
        r11 = Math.min(r2 + r8, r6.length());
    L27:
        return false;
    }

    static boolean handleOnKeyDown(@NonNull Editable r3, int r4, @NonNull KeyEvent r5) {
        if (r4 != 67) goto L5;
        boolean r6 = delete(r3, r5, false);
    L9:
        if (r6 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r3);
        return true;
    L12:
        return false;
    L5:
        if (r4 == 112) goto L7;
        r6 = false;
        goto L9
    L7:
        r6 = delete(r3, r5, true);
        goto L9
    }

    private boolean hasGlyph(CharSequence r2, int r3, int r4, EmojiMetadata r5) {
        if (r5.getHasGlyph() != 0) goto L6;
        r5.setHasGlyph(this.mGlyphChecker.hasGlyph(r2, r3, r4, r5.getSdkAdded()));
    L6:
        if (r5.getHasGlyph() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean hasInvalidSelection(int r1, int r2) {
        if (r1 == (-1)) goto L8;
        if (r2 == (-1)) goto L8;
        if (r1 != r2) goto L8;
        return false;
    L8:
        return true;
    }

    private static boolean hasModifiers(@NonNull KeyEvent r0) {
        return !KeyEvent.metaStateHasNoModifiers(r0.getMetaState());
    }

    int getEmojiMatch(@NonNull CharSequence r2) {
        return getEmojiMatch(r2, this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiMatch(@NonNull CharSequence r11, int r12) {
        ProcessorSm r0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int r10 = r11.length();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2 >= r10) goto L20;
        int r7 = Character.codePointAt(r11, r2);
        int r8 = r0.check(r7);
        EmojiMetadata r9 = r0.getCurrentMetadata();
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L9;
        r2 = r2 + Character.charCount(r7);
    L16:
        if (r9 == null) goto L4;
        if (r9.getCompatAdded() > r12) goto L4;
        r4 = r4 + 1;
        goto L4
    L9:
        if (r8 != 3) goto L16;
        r9 = r0.getFlushMetadata();
        if (r9.getCompatAdded() > r12) goto L16;
        r3 = r3 + 1;
        goto L16
    L15:
        r2 = r2 + Character.charCount(r7);
        r4 = 0;
        goto L16
    L20:
        if (r3 == 0) goto L23;
        return 2;
    L23:
        if (r0.isInFlushableState() == true) goto L25;
    L27:
        if (r4 != 0) goto L29;
        return 0;
    L29:
        return 2;
    L25:
        if (r0.getCurrentMetadata().getCompatAdded() > r12) goto L27;
        return 1;
    }

    CharSequence process(@NonNull CharSequence r10, @IntRange(from = 0) int r11, @IntRange(from = 0) int r12, @IntRange(from = 0) int r13, boolean r14) {
        boolean r0 = r10 instanceof SpannableBuilder;
        if (r0 == false) goto L5;
        ((SpannableBuilder) r10).beginBatchEdit();
    L5:
        UnprecomputeTextOnModificationSpannable r1 = null;
        if (r0 == false) goto L84;
    L15:
        r1 = new UnprecomputeTextOnModificationSpannable((Spannable) r10);     // Catch: Throwable -> L80
    L17:
        if (r1 == null) goto L28;
        EmojiSpan[] r3 = (EmojiSpan[]) r1.getSpans(r11, r12, EmojiSpan.class);     // Catch: Throwable -> L80
        if (r3 == null) goto L28;
        if (r3.length <= 0) goto L28;
        int r4 = r3.length;     // Catch: Throwable -> L80
        int r5 = 0;
    L23:
        if (r5 >= r4) goto L28;
        EmojiSpan r6 = r3[r5];     // Catch: Throwable -> L80
        int r7 = r1.getSpanStart(r6);     // Catch: Throwable -> L80
        int r8 = r1.getSpanEnd(r6);     // Catch: Throwable -> L80
        if (r7 == r12) goto L27;
        r1.removeSpan(r6);     // Catch: Throwable -> L80
    L27:
        r11 = Math.min(r7, r11);     // Catch: Throwable -> L80
        r12 = Math.max(r8, r12);     // Catch: Throwable -> L80
        r5 = r5 + 1;     // Catch: Throwable -> L80
    L28:
        if (r11 != r12) goto L30;
    L77:
        if (r0 == false) goto L79;
        ((SpannableBuilder) r10).endBatchEdit();
    L79:
        return r10;
    L30:
        if (r11 >= r10.length()) goto L77;
        if (r13 == Integer.MAX_VALUE) goto L36;
        if (r1 == null) goto L36;
        r13 = r13 - ((EmojiSpan[]) r1.getSpans(0, r1.length(), EmojiSpan.class)).length;     // Catch: Throwable -> L80
    L36:
        ProcessorSm r9 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);     // Catch: Throwable -> L80
        int r15 = Character.codePointAt(r10, r11);     // Catch: Throwable -> L80
        int r16 = 0;
        UnprecomputeTextOnModificationSpannable r2 = r1;
    L37:
        int r17 = r11;
    L38:
        if (r11 >= r12) goto L61;
        if (r16 >= r13) goto L61;
        int r18 = r9.check(r15);     // Catch: Throwable -> L80
        if (r18 != 1) goto L43;
        r17 = r17 + Character.charCount(Character.codePointAt(r10, r17));     // Catch: Throwable -> L80
        if (r17 >= r12) goto L59;
        r15 = Character.codePointAt(r10, r17);     // Catch: Throwable -> L80
    L59:
        r11 = r17;
        goto L38
    L43:
        if (r18 != 2) goto L45;
        r11 = r11 + Character.charCount(r15);     // Catch: Throwable -> L80
        if (r11 >= r12) goto L38;
        r15 = Character.codePointAt(r10, r11);     // Catch: Throwable -> L80
        goto L38
    L45:
        if (r18 != 3) goto L38;
        if (r14 == true) goto L50;
        if (hasGlyph(r10, r17, r11, r9.getFlushMetadata()) == true) goto L37;
    L50:
        if (r2 != null) goto L52;
        r2 = new UnprecomputeTextOnModificationSpannable(new SpannableString(r10));     // Catch: Throwable -> L80
    L52:
        addEmoji(r2, r9.getFlushMetadata(), r17, r11);     // Catch: Throwable -> L80
        r16 = r16 + 1;     // Catch: Throwable -> L80
    L61:
        if (r9.isInFlushableState() == false) goto L69;
        if (r16 >= r13) goto L69;
        if (r14 == false) goto L65;
    L66:
        if (r2 != null) goto L68;
        r2 = new UnprecomputeTextOnModificationSpannable(r10);     // Catch: Throwable -> L80
    L68:
        addEmoji(r2, r9.getCurrentMetadata(), r17, r11);     // Catch: Throwable -> L80
        goto L69
    L65:
        if (hasGlyph(r10, r17, r11, r9.getCurrentMetadata()) == false) goto L66;
    L69:
        if (r2 == null) goto L74;
        Spannable r19 = r2.getUnwrappedSpannable();     // Catch: Throwable -> L80
        if (r0 == false) goto L73;
        ((SpannableBuilder) r10).endBatchEdit();
    L73:
        return r19;
    L80:
        th = move-exception;
        if (r0 == false) goto L83;
        ((SpannableBuilder) r10).endBatchEdit();
    L83:
        throw th;
    L74:
        if (r0 == false) goto L76;
        ((SpannableBuilder) r10).endBatchEdit();
    L76:
        return r10;
    L84:
        if ((r10 instanceof Spannable) == true) goto L15;
        if ((r10 instanceof Spanned) == false) goto L17;
        if (((Spanned) r10).nextSpanTransition(r11 - 1, r12 + 1, EmojiSpan.class) > r12) goto L17;
        r1 = new UnprecomputeTextOnModificationSpannable(r10);     // Catch: Throwable -> L80
        goto L17
    }
}
