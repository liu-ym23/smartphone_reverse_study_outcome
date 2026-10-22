package com.obric.oui.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.GetChars;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ReplacementSpan;
import android.view.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OPasswordTransformationMethod extends PasswordTransformationMethod {
    private static final int CACHE_RETAIN_EXTRA_SIZE = 16;
    private static final int CACHE_SHRINK_THRESHOLD = 32;
    private static final char DEFAULT_MASK_CHAR = 8226;
    private final float mDotSizeRatio;
    private final float mDotSpacingRatio;
    private final int mErrorBackgroundColor;
    private PasswordMaskSpanned mPasswordMaskSpanned;
    private boolean mShowErrorBackground;

    private static class IndexedPasswordMaskSpan extends ReplacementSpan {
        private final float mDotSizeRatio;
        private final float mDotSpacingRatio;
        private final int mErrorBackgroundColor;
        private boolean mIsShowErrorBackground;
        private final int start;

        static /* synthetic */ int access$000(IndexedPasswordMaskSpan r0) {
            return r0.start;
        }

        IndexedPasswordMaskSpan(int r2, float r3, float r4, int r5) {
            this.mIsShowErrorBackground = false;
            this.start = r2;
            this.mDotSizeRatio = r3;
            this.mDotSpacingRatio = r4;
            this.mErrorBackgroundColor = r5;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            copyFontMetrics(r1, r5);
            if (isMaskChar(r2, r3) == false) goto L5;
            float r6 = r1.getTextSize();
            float r7 = (this.mDotSizeRatio * r6) + (r6 * this.mDotSpacingRatio);
        L7:
            return (int) Math.ceil(r7);
        L5:
            r7 = r1.measureText(r2, r3, r4);
            goto L7
        }

        public void setShowErrorBackground(boolean r1) {
            this.mIsShowErrorBackground = r1;
        }

        public boolean isShowErrorBackground() {
            return this.mIsShowErrorBackground;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
            if (isMaskChar(r13, r14) == true) goto L6;
            r12.drawText(r13, r14, r15, r16, r18, r20);
            return;
        L6:
            float r3 = r20.getTextSize();
            float r4 = this.mDotSizeRatio * r3;
            float r5 = (r3 * this.mDotSpacingRatio) + r4;
            float r6 = r4 / 2.0f;
            float r7 = r16 + r6;
            float r8 = (r17 + r19) / 2.0f;
            Paint.Style r9 = r20.getStyle();
            r20.setStyle(Paint.Style.FILL);
            if (this.mIsShowErrorBackground == false) goto L9;
            int r10 = r20.getColor();
            r20.setColor(this.mErrorBackgroundColor);
            r12.drawRect(Math.round(r16), r17, Math.round((r16 + r5) + 0.5f), r19, r20);
            r20.setColor(r10);
        L9:
            r12.drawCircle(r7, r8, r6, r20);
            r20.setStyle(r9);
        }

        private boolean isMaskChar(CharSequence r1, int r2) {
            if (r2 >= 0) goto L4;
        L8:
            return false;
        L4:
            if (r2 >= r1.length()) goto L8;
            if (r1.charAt(r2) != 8226) goto L8;
            return true;
        }

        private void copyFontMetrics(Paint r1, Paint.FontMetricsInt r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            Paint.FontMetricsInt r0 = r1.getFontMetricsInt();
            r2.ascent = r0.ascent;
            r2.descent = r0.descent;
            r2.top = r0.top;
            r2.bottom = r0.bottom;
        }
    }

    private static class PasswordMaskSpanned implements Spanned, GetChars {
        private final ArrayList<IndexedPasswordMaskSpan> cachedMaskSpans;
        private CharSequence delegate;
        private final float mDotSizeRatio;
        private final float mDotSpacingRatio;
        private final int mErrorBackgroundColor;
        private boolean mIsShowErrorBackground;

        PasswordMaskSpanned(CharSequence r2, float r3, float r4, int r5) {
            this.mIsShowErrorBackground = false;
            this.cachedMaskSpans = new ArrayList();
            this.delegate = r2;
            this.mDotSizeRatio = r3;
            this.mDotSpacingRatio = r4;
            this.mErrorBackgroundColor = r5;
        }

        void updateDelegate(CharSequence r2) {
            if (this.delegate != r2) goto L5;
            return;
        L5:
            this.delegate = r2;
        }

        private CharSequence requireDelegate() {
            CharSequence r0 = this.delegate;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return requireDelegate().length();
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            return requireDelegate().charAt(r1);
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            return requireDelegate().subSequence(r1, r2);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return requireDelegate().toString();
        }

        @Override // android.text.GetChars
        public void getChars(int r2, int r3, char[] r4, int r5) {
            CharSequence r1 = requireDelegate();
            if ((r1 instanceof GetChars) == false) goto L5;
            ((GetChars) r1).getChars(r2, r3, r4, r5);
            return;
        L5:
            TextUtils.getChars(r1, r2, r3, r4, r5);
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int r8, int r9, Class<T> r10) {
            CharSequence r0 = requireDelegate();
            ArrayList r1 = new ArrayList();
            if ((r0 instanceof Spanned) == false) goto L8;
            Object[] r2 = ((Spanned) r0).getSpans(r8, r9, r10);
            int r4 = r2.length;
            int r5 = 0;
        L5:
            if (r5 >= r4) goto L8;
            r1.add(r2[r5]);
            r5 = r5 + 1;
        L8:
            if (r10.isAssignableFrom(IndexedPasswordMaskSpan.class) == false) goto L10;
        L13:
            ensureMaskSpanCache(length());
            int r11 = Math.max(r8, 0);
            int r12 = Math.min(r9, length());
        L14:
            if (r11 >= r12) goto L20;
            if (r0.charAt(r11) != 8226) goto L18;
            r1.add(r10.cast(this.cachedMaskSpans.get(r11)));
        L18:
            r11 = r11 + 1;
        L20:
            return (T[]) toTypedArray(r1, r10);
        L10:
            if (r10.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r10.isAssignableFrom(Object.class) == false) goto L20;
            goto L13
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object r2) {
            if ((r2 instanceof IndexedPasswordMaskSpan) == true) goto L5;
            CharSequence r1 = requireDelegate();
            if ((r1 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r1).getSpanStart(r2);
        L5:
            return IndexedPasswordMaskSpan.access$000((IndexedPasswordMaskSpan) r2);
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object r2) {
            if ((r2 instanceof IndexedPasswordMaskSpan) == true) goto L5;
            CharSequence r1 = requireDelegate();
            if ((r1 instanceof Spanned) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) r1).getSpanEnd(r2);
        L5:
            return IndexedPasswordMaskSpan.access$000((IndexedPasswordMaskSpan) r2) + 1;
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object r2) {
            if ((r2 instanceof IndexedPasswordMaskSpan) == false) goto L6;
            return 33;
        L6:
            CharSequence r1 = requireDelegate();
            if ((r1 instanceof Spanned) == true) goto L9;
            return 0;
        L9:
            return ((Spanned) r1).getSpanFlags(r2);
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int r4, int r5, Class r6) {
            CharSequence r0 = requireDelegate();
            if ((r0 instanceof Spanned) == false) goto L5;
            int r1 = ((Spanned) r0).nextSpanTransition(r4, r5, r6);
        L6:
            if (r6 != null) goto L8;
        L13:
            ensureMaskSpanCache(length());
            int r7 = Math.max(r4, 0);
            int r3 = Math.min(r5, length());
        L14:
            if (r7 >= r3) goto L21;
            if (r0.charAt(r7) != 8226) goto L20;
            if (r7 <= r4) goto L19;
            r1 = Math.min(r1, r7);
        L19:
            r1 = Math.min(r1, r7 + 1);
        L20:
            r7 = r7 + 1;
        L21:
            return r1;
        L8:
            if (r6.isAssignableFrom(IndexedPasswordMaskSpan.class) == true) goto L13;
            if (r6.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r6.isAssignableFrom(Object.class) == false) goto L21;
        L5:
            r1 = r5;
            goto L6
        }

        public void setShowErrorBackground(boolean r3) {
            this.mIsShowErrorBackground = r3;
            int r0 = 0;
        L4:
            if (r0 >= this.cachedMaskSpans.size()) goto L6;
            this.cachedMaskSpans.get(r0).setShowErrorBackground(r3);
            r0 = r0 + 1;
            goto L4
        }

        public boolean isShowErrorBackground() {
            return this.mIsShowErrorBackground;
        }

        private void ensureMaskSpanCache(int r6) {
        L3:
            if (this.cachedMaskSpans.size() >= r6) goto L5;
            IndexedPasswordMaskSpan r1 = new IndexedPasswordMaskSpan(this.cachedMaskSpans.size(), this.mDotSizeRatio, this.mDotSpacingRatio, this.mErrorBackgroundColor);
            r1.setShowErrorBackground(this.mIsShowErrorBackground);
            this.cachedMaskSpans.add(r1);
            goto L3
        L5:
            shrinkMaskSpanCacheIfNeeded(r6);
        }

        private void shrinkMaskSpanCacheIfNeeded(int r3) {
            int r4 = r3 + 16;
            if (this.cachedMaskSpans.size() > (r4 + 32)) goto L5;
            return;
        L5:
            ArrayList<IndexedPasswordMaskSpan> r2 = this.cachedMaskSpans;
            r2.subList(r4, r2.size()).clear();
        }

        private static <T> T[] toTypedArray(List<T> r2, Class<T> r3) {
            T[] r4 = (T[]) ((Object[]) Array.newInstance(r3, r2.size()));
            int r0 = 0;
        L4:
            if (r0 >= r2.size()) goto L6;
            r4[r0] = r2.get(r0);
            r0 = r0 + 1;
            goto L4
        L6:
            return r4;
        }
    }

    public OPasswordTransformationMethod(float r2, float r3, int r4) {
        this.mShowErrorBackground = false;
        this.mDotSizeRatio = r2;
        this.mDotSpacingRatio = r3;
        this.mErrorBackgroundColor = r4;
    }

    public float getDotSizeRatio() {
        return this.mDotSizeRatio;
    }

    public float getDotSpacingRatio() {
        return this.mDotSpacingRatio;
    }

    public int getErrorBackgroundColor() {
        return this.mErrorBackgroundColor;
    }

    public void setShowErrorBackground(boolean r2) {
        if (this.mShowErrorBackground == r2) goto L8;
        this.mShowErrorBackground = r2;
        PasswordMaskSpanned r1 = this.mPasswordMaskSpanned;
        if (r1 == null) goto L9;
        r1.setShowErrorBackground(r2);
        return;
    L9:
        return;
    }

    public boolean isShowErrorBackground() {
        return this.mShowErrorBackground;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r4, View r5) {
        CharSequence r6 = super.getTransformation(r4, r5);
        PasswordMaskSpanned r7 = this.mPasswordMaskSpanned;
        if (r7 != null) goto L5;
        this.mPasswordMaskSpanned = new PasswordMaskSpanned(r6, this.mDotSizeRatio, this.mDotSpacingRatio, this.mErrorBackgroundColor);
    L6:
        this.mPasswordMaskSpanned.setShowErrorBackground(this.mShowErrorBackground);
        return this.mPasswordMaskSpanned;
    L5:
        r7.updateDelegate(r6);
        goto L6
    }
}
