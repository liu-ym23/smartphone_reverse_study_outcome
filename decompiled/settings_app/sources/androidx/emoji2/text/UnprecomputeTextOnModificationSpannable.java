package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite;

    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream codePoints(CharSequence r0) {
            return r0.codePoints();
        }

        static IntStream chars(CharSequence r0) {
            return r0.chars();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean isPrecomputedText(CharSequence r1) {
            return r1 instanceof PrecomputedTextCompat;
        }
    }

    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean isPrecomputedText(CharSequence r1) {
            if ((r1 instanceof PrecomputedText) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r1 instanceof PrecomputedTextCompat) == true) goto L8;
            return false;
        }
    }

    UnprecomputeTextOnModificationSpannable(Spannable r2) {
        this.mSafeToWrite = false;
        this.mDelegate = r2;
    }

    UnprecomputeTextOnModificationSpannable(Spanned r2) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r2);
    }

    UnprecomputeTextOnModificationSpannable(CharSequence r2) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r2);
    }

    private void ensureSafeWrites() {
        Spannable r0 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().isPrecomputedText(r0) == false) goto L7;
        this.mDelegate = new SpannableString(r0);
        goto L7
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // android.text.Spannable
    public void setSpan(Object r1, int r2, int r3, int r4) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r1, r2, r3, r4);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r1) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r1);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r1, int r2, Class<T> r3) {
        return (T[]) this.mDelegate.getSpans(r1, r2, r3);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mDelegate.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mDelegate.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mDelegate.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mDelegate.nextSpanTransition(r1, r2, r3);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mDelegate.charAt(r1);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mDelegate.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        return new PrecomputedTextDetector_28();
    }
}
