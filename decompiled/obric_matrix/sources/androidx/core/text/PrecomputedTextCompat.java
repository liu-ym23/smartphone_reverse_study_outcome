package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Layout;
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

            public Builder(@NonNull TextPaint r2) {
                this.mPaint = r2;
                int r3 = Build.VERSION.SDK_INT;
                if (r3 < 23) goto L5;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
            L7:
                if (r3 < 18) goto L9;
                TextDirectionHeuristic r4 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            L10:
                this.mTextDir = r4;
                return;
            L9:
                r4 = null;
                goto L10
            L5:
                this.mHyphenationFrequency = 0;
                this.mBreakStrategy = 0;
                goto L7
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

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params r3) {
            this.mPaint = r3.getTextPaint();
            this.mTextDir = r3.getTextDirection();
            this.mBreakStrategy = r3.getBreakStrategy();
            this.mHyphenationFrequency = r3.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            r3 = null;
        L6:
            this.mWrapped = r3;
        }

        Params(@NonNull TextPaint r3, @NonNull TextDirectionHeuristic r4, int r5, int r6) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            PrecomputedText.Params r0 = new PrecomputedText.Params.Builder(r3).setBreakStrategy(r5).setHyphenationFrequency(r6).setTextDirection(r4).build();
        L6:
            this.mWrapped = r0;
            this.mPaint = r3;
            this.mTextDir = r4;
            this.mBreakStrategy = r5;
            this.mHyphenationFrequency = r6;
            return;
        L5:
            r0 = null;
            goto L6
        }

        public boolean equals(@Nullable Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof Params) == true) goto L8;
            return false;
        L8:
            Params r6 = (Params) r5;
            if (equalsWithoutTextDirection(r6) == true) goto L12;
            return false;
        L12:
            if (Build.VERSION.SDK_INT >= 18) goto L14;
        L16:
            return true;
        L14:
            if (this.mTextDir == r6.getTextDirection()) goto L16;
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params r5) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 23) goto L11;
            if (this.mBreakStrategy == r5.getBreakStrategy()) goto L8;
            return false;
        L8:
            if (this.mHyphenationFrequency == r5.getHyphenationFrequency()) goto L11;
            return false;
        L11:
            if (this.mPaint.getTextSize() == r5.getTextPaint().getTextSize()) goto L14;
            return false;
        L14:
            if (this.mPaint.getTextScaleX() == r5.getTextPaint().getTextScaleX()) goto L17;
            return false;
        L17:
            if (this.mPaint.getTextSkewX() == r5.getTextPaint().getTextSkewX()) goto L20;
            return false;
        L20:
            if (r0 < 21) goto L28;
            if (this.mPaint.getLetterSpacing() == r5.getTextPaint().getLetterSpacing()) goto L25;
            return false;
        L25:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r5.getTextPaint().getFontFeatureSettings()) == true) goto L28;
            return false;
        L28:
            if (this.mPaint.getFlags() == r5.getTextPaint().getFlags()) goto L31;
            return false;
        L31:
            if (r0 < 24) goto L36;
            if (this.mPaint.getTextLocales().equals(r5.getTextPaint().getTextLocales()) == true) goto L41;
            return false;
        L41:
            if (this.mPaint.getTypeface() != null) goto L46;
            if (r5.getTextPaint().getTypeface() == null) goto L48;
            return false;
        L48:
            return true;
        L46:
            if (this.mPaint.getTypeface().equals(r5.getTextPaint().getTypeface()) == true) goto L50;
            return false;
        L50:
            return true;
        L36:
            if (r0 < 17) goto L41;
            if (this.mPaint.getTextLocale().equals(r5.getTextPaint().getTextLocale()) == true) goto L41;
            return false;
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
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 24) goto L7;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L7:
            if (r0 < 21) goto L11;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L11:
            if (r0 < 18) goto L15;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L15:
            if (r0 < 17) goto L19;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L19:
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("{");
            r0.append("textSize=" + this.mPaint.getTextSize());
            r0.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r0.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 21) goto L6;
            r0.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r0.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
        L6:
            if (r1 < 24) goto L10;
            StringBuilder r2 = new StringBuilder();
            r2.append(", textLocale=");
            Object r3 = this.mPaint.getTextLocales();
        L8:
            r2.append(r3);
            r0.append(r2.toString());
        L12:
            r0.append(", typeface=" + this.mPaint.getTypeface());
            if (r1 < 26) goto L15;
            r0.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        L15:
            r0.append(", textDir=" + this.mTextDir);
            r0.append(", breakStrategy=" + this.mBreakStrategy);
            r0.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r0.append("}");
            return r0.toString();
        L10:
            if (r1 < 17) goto L12;
            r2 = new StringBuilder();
            r2.append(", textLocale=");
            r3 = this.mPaint.getTextLocale();
            goto L8
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(@NonNull Params r1, @NonNull CharSequence r2) {
                this.mParams = r1;
                this.mText = r2;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() {
                return call();
            }
        }

        PrecomputedTextFutureTask(@NonNull Params r2, @NonNull CharSequence r3) {
            super(new PrecomputedTextCallback(r2, r3));
        }
    }

    static {
        sLock = new Object();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText r3, @NonNull Params r4) {
        this.mText = r3;
        this.mParams = r4;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        r3 = null;
    L6:
        this.mWrapped = r3;
    }

    private PrecomputedTextCompat(@NonNull CharSequence r2, @NonNull Params r3, @NonNull int[] r4) {
        this.mText = new SpannableString(r2);
        this.mParams = r3;
        this.mParagraphEnds = r4;
        this.mWrapped = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence r11, @NonNull Params r12) {
        int r0 = Build.VERSION.SDK_INT;
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        TraceCompat.beginSection("PrecomputedText");     // Catch: Throwable -> L30
        if (r0 < 29) goto L10;
        PrecomputedText.Params r1 = r12.mWrapped;     // Catch: Throwable -> L30
        if (r1 == null) goto L10;
        PrecomputedTextCompat r2 = new PrecomputedTextCompat(PrecomputedText.create(r11, r1), r12);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r2;
    L10:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L30
        int r4 = r11.length();     // Catch: Throwable -> L30
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L17;
        int r6 = TextUtils.indexOf(r11, LINE_FEED, r5, r4);     // Catch: Throwable -> L30
        if (r6 >= 0) goto L15;
        r5 = r4;
    L16:
        r3.add(Integer.valueOf(r5));     // Catch: Throwable -> L30
        goto L11
    L15:
        r5 = r6 + 1;     // Catch: Throwable -> L30
        goto L16
    L17:
        int[] r7 = new int[r3.size()];     // Catch: Throwable -> L30
        int r8 = 0;
    L19:
        if (r8 >= r3.size()) goto L22;
        r7[r8] = ((Integer) r3.get(r8)).intValue();     // Catch: Throwable -> L30
        r8 = r8 + 1;     // Catch: Throwable -> L30
        goto L19
    L22:
        if (r0 < 23) goto L25;
        StaticLayout.Builder.obtain(r11, 0, r11.length(), r12.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(r12.getBreakStrategy()).setHyphenationFrequency(r12.getHyphenationFrequency()).setTextDirection(r12.getTextDirection()).build();     // Catch: Throwable -> L30
    L27:
        PrecomputedTextCompat r9 = new PrecomputedTextCompat(r11, r12, r7);     // Catch: Throwable -> L30
        TraceCompat.endSection();
        return r9;
    L25:
        if (r0 < 21) goto L27;
        new StaticLayout(r11, r12.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence r1, @NonNull Params r2, @Nullable Executor r3) {
        PrecomputedTextFutureTask r0 = new PrecomputedTextFutureTask(r2, r1);
        if (r3 != null) goto L15;
        Object r4 = sLock;
        monitor-enter(r4);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L12
    L9:
        r3 = sExecutor;     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
    L15:
        r3.execute(r0);
        return r0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mText.charAt(r1);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphCount();
    L7:
        return this.mParagraphEnds.length;
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphEnd(r4);
    L7:
        return this.mParagraphEnds[r4];
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int r4) {
        Preconditions.checkArgumentInRange(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r4 != 0) goto L9;
        return 0;
    L9:
        return this.mParagraphEnds[r4 - 1];
    L5:
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
    public <T> T[] getSpans(int r3, int r4, Class<T> r5) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return (T[]) this.mWrapped.getSpans(r3, r4, r5);
    L7:
        return (T[]) this.mText.getSpans(r3, r4, r5);
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
    public void removeSpan(Object r3) {
        if ((r3 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.removeSpan(r3);
        return;
    L7:
        this.mText.removeSpan(r3);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object r3, int r4, int r5, int r6) {
        if ((r3 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.setSpan(r3, r4, r5, r6);
        return;
    L7:
        this.mText.setSpan(r3, r4, r5, r6);
        return;
    L10:
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
}
