package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';

    @NonNull
    @GuardedBy("sLock")
    private static Executor sExecutor;
    private static final Object sLock = null;

    @NonNull
    private final int[] mParagraphEnds;

    @NonNull
    private final Params mParams;

    @NonNull
    private final Spannable mText;

    @Nullable
    private final PrecomputedText mWrapped;

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;

        @NonNull
        private final TextPaint mPaint;

        @Nullable
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;

            @NonNull
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(@NonNull TextPaint r1) {
                this.mPaint = r1;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int r1) {
                this.mBreakStrategy = r1;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int r1) {
                this.mHyphenationFrequency = r1;
                return this;
            }

            @RequiresApi(18)
            public Builder setTextDirection(@NonNull TextDirectionHeuristic r1) {
                this.mTextDir = r1;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        public Params(@NonNull TextPaint r2, @NonNull TextDirectionHeuristic r3, int r4, int r5) {
            this.mWrapped = new PrecomputedText.Params.Builder(r2).setBreakStrategy(r4).setHyphenationFrequency(r5).setTextDirection(r3).build();
            this.mPaint = r2;
            this.mTextDir = r3;
            this.mBreakStrategy = r4;
            this.mHyphenationFrequency = r5;
        }

        public boolean equals(@Nullable Object r4) {
            if (r4 != this) goto L6;
            return true;
        L6:
            if ((r4 instanceof Params) == true) goto L8;
            return false;
        L8:
            Params r5 = (Params) r4;
            if (equalsWithoutTextDirection(r5) == true) goto L12;
            return false;
        L12:
            if (this.mTextDir == r5.getTextDirection()) goto L14;
            return false;
        L14:
            return true;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params r4) {
            if (this.mBreakStrategy == r4.getBreakStrategy()) goto L6;
            return false;
        L6:
            if (this.mHyphenationFrequency == r4.getHyphenationFrequency()) goto L9;
            return false;
        L9:
            if (this.mPaint.getTextSize() == r4.getTextPaint().getTextSize()) goto L12;
            return false;
        L12:
            if (this.mPaint.getTextScaleX() == r4.getTextPaint().getTextScaleX()) goto L15;
            return false;
        L15:
            if (this.mPaint.getTextSkewX() == r4.getTextPaint().getTextSkewX()) goto L18;
            return false;
        L18:
            if (this.mPaint.getLetterSpacing() == r4.getTextPaint().getLetterSpacing()) goto L21;
            return false;
        L21:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r4.getTextPaint().getFontFeatureSettings()) == true) goto L24;
            return false;
        L24:
            if (this.mPaint.getFlags() == r4.getTextPaint().getFlags()) goto L27;
            return false;
        L27:
            if (this.mPaint.getTextLocales().equals(r4.getTextPaint().getTextLocales()) == true) goto L30;
            return false;
        L30:
            if (this.mPaint.getTypeface() != null) goto L35;
            if (r4.getTextPaint().getTypeface() == null) goto L37;
            return false;
        L37:
            return true;
        L35:
            if (this.mPaint.getTypeface().equals(r4.getTextPaint().getTypeface()) == true) goto L39;
            return false;
        L39:
            return true;
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        @Nullable
        @RequiresApi(18)
        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("{");
            r0.append("textSize=" + this.mPaint.getTextSize());
            r0.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r0.append(", textSkewX=" + this.mPaint.getTextSkewX());
            r0.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r0.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            r0.append(", textLocale=" + this.mPaint.getTextLocales());
            r0.append(", typeface=" + this.mPaint.getTypeface());
            r0.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            r0.append(", textDir=" + this.mTextDir);
            r0.append(", breakStrategy=" + this.mBreakStrategy);
            r0.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r0.append("}");
            return r0.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params r2) {
            this.mPaint = r2.getTextPaint();
            this.mTextDir = r2.getTextDirection();
            this.mBreakStrategy = r2.getBreakStrategy();
            this.mHyphenationFrequency = r2.getHyphenationFrequency();
            this.mWrapped = r2;
        }
    }

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            public PrecomputedTextCallback(@NonNull Params r1, @NonNull CharSequence r2) {
                this.mParams = r1;
                this.mText = r2;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() {
                return call();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }

        public PrecomputedTextFutureTask(@NonNull Params r2, @NonNull CharSequence r3) {
            super(new PrecomputedTextCallback(r2, r3));
        }
    }

    static {
        sLock = new Object();
    }

    private PrecomputedTextCompat(@NonNull CharSequence r2, @NonNull Params r3, @NonNull int[] r4) {
        this.mText = new SpannableString(r2);
        this.mParams = r3;
        this.mParagraphEnds = r4;
        this.mWrapped = null;
    }

    @SuppressLint({"NewApi"})
    public static PrecomputedTextCompat create(@NonNull CharSequence r5, @NonNull Params r6) {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        TraceCompat.beginSection("PrecomputedText");     // Catch: Throwable -> L8
        PrecomputedText.Params r0 = r6.mWrapped;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        PrecomputedTextCompat r1 = new PrecomputedTextCompat(PrecomputedText.create(r5, r0), r6);     // Catch: Throwable -> L8
        TraceCompat.endSection();
        return r1;
    L10:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L8
        int r3 = r5.length();     // Catch: Throwable -> L8
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L17;
        int r7 = TextUtils.indexOf(r5, LINE_FEED, r4, r3);     // Catch: Throwable -> L8
        if (r7 >= 0) goto L15;
        r4 = r3;
    L16:
        r2.add(Integer.valueOf(r4));     // Catch: Throwable -> L8
        goto L11
    L15:
        r4 = r7 + 1;     // Catch: Throwable -> L8
        goto L16
    L17:
        int[] r8 = new int[r2.size()];     // Catch: Throwable -> L8
        int r9 = 0;
    L19:
        if (r9 >= r2.size()) goto L21;
        r8[r9] = ((Integer) r2.get(r9)).intValue();     // Catch: Throwable -> L8
        r9 = r9 + 1;     // Catch: Throwable -> L8
        goto L19
    L21:
        StaticLayout.Builder.obtain(r5, 0, r5.length(), r6.getTextPaint(), ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).setBreakStrategy(r6.getBreakStrategy()).setHyphenationFrequency(r6.getHyphenationFrequency()).setTextDirection(r6.getTextDirection()).build();     // Catch: Throwable -> L8
        PrecomputedTextCompat r10 = new PrecomputedTextCompat(r5, r6, r8);     // Catch: Throwable -> L8
        TraceCompat.endSection();
        return r10;
    L8:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence r1, @NonNull Params r2, @Nullable Executor r3) {
        PrecomputedTextFutureTask r0 = new PrecomputedTextFutureTask(r2, r1);
        if (r3 != null) goto L16;
        Object r4 = sLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L11;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L9
    L11:
        r3 = sExecutor;     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
    L16:
        r3.execute(r0);
        return r0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mText.charAt(r1);
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphCount() {
        return this.mWrapped.getParagraphCount();
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphEnd(@IntRange(from = 0) int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphEnd(r4);
    }

    @IntRange(from = 0)
    @SuppressLint({"NewApi"})
    public int getParagraphStart(@IntRange(from = 0) int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphStart(r4);
    }

    @NonNull
    public Params getParams() {
        return this.mParams;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable r1 = this.mText;
        if ((r1 instanceof PrecomputedText) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) r1;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mText.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mText.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mText.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int r1, int r2, Class<T> r3) {
        return (T[]) this.mWrapped.getSpans(r1, r2, r3);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mText.nextSpanTransition(r1, r2, r3);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object r2) {
        if ((r2 instanceof MetricAffectingSpan) == true) goto L7;
        this.mWrapped.removeSpan(r2);
        return;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object r2, int r3, int r4, int r5) {
        if ((r2 instanceof MetricAffectingSpan) == true) goto L7;
        this.mWrapped.setSpan(r2, r3, r4, r5);
        return;
    L7:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mText.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.mText.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText r1, @NonNull Params r2) {
        this.mText = r1;
        this.mParams = r2;
        this.mParagraphEnds = null;
        this.mWrapped = r1;
    }
}
