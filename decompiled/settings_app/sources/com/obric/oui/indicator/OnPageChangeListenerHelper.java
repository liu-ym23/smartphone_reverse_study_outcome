package com.obric.oui.indicator;

import android.icu.text.PluralRules;
import com.obric.oui.common.util.OUILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnPageChangeListenerHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ%\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH ¢\u0006\u0002\b\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X \u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "", "()V", "TAG", "", "pageCount", "", "getPageCount$OUI_standardRelease", "()I", "onPageScrolled", "", "position", "positionOffset", "", "selectedPosition", "nextPosition", "onPageScrolled$OUI_standardRelease", "resolveScrollState", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper$ScrollState;", "ScrollState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OnPageChangeListenerHelper {
    private final String TAG;

    /* JADX INFO: compiled from: OnPageChangeListenerHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/indicator/OnPageChangeListenerHelper$ScrollState;", "", "selectedPosition", "", "nextPosition", "positionOffset", "", "(IIF)V", "getNextPosition", "()I", "getPositionOffset", "()F", "getSelectedPosition", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ScrollState {
        private final int nextPosition;
        private final float positionOffset;
        private final int selectedPosition;

        public static /* synthetic */ ScrollState copy$default(ScrollState r0, int r1, int r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.selectedPosition;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.nextPosition;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.positionOffset;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.selectedPosition;
        }

        public final int component2() {
            return this.nextPosition;
        }

        public final float component3() {
            return this.positionOffset;
        }

        public final ScrollState copy(int r1, int r2, float r3) {
            return new ScrollState(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ScrollState) == true) goto L8;
            return false;
        L8:
            ScrollState r6 = (ScrollState) r5;
            if (this.selectedPosition == r6.selectedPosition) goto L12;
            return false;
        L12:
            if (this.nextPosition == r6.nextPosition) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.positionOffset), Float.valueOf(r6.positionOffset)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.selectedPosition) * 31) + Integer.hashCode(this.nextPosition)) * 31) + Float.hashCode(this.positionOffset);
        }

        public String toString() {
            return "ScrollState(selectedPosition=" + this.selectedPosition + ", nextPosition=" + this.nextPosition + ", positionOffset=" + this.positionOffset + ')';
        }

        public ScrollState(int r1, int r2, float r3) {
            this.selectedPosition = r1;
            this.nextPosition = r2;
            this.positionOffset = r3;
        }

        public final int getSelectedPosition() {
            return this.selectedPosition;
        }

        public final int getNextPosition() {
            return this.nextPosition;
        }

        public final float getPositionOffset() {
            return this.positionOffset;
        }
    }

    public abstract int getPageCount$OUI_standardRelease();

    public abstract void onPageScrolled$OUI_standardRelease(int r1, int r2, float r3);

    public OnPageChangeListenerHelper() {
        this.TAG = "OnPageChangeHelper";
    }

    public final void onPageScrolled(int r2, float r3) {
        ScrollState r4 = resolveScrollState(r2, r3);
        if (r4 != null) goto L13;
        return;
    L13:
        onPageScrolled$OUI_standardRelease(r4.getSelectedPosition(), r4.getNextPosition(), r4.getPositionOffset());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L11;
        OUILogger.INSTANCE.i(this.TAG, Intrinsics.stringPlus("OIndicator: ", e.getMessage()));
        return;
    L11:
        OUILogger.INSTANCE.e(this.TAG, "抓住了一个Exception并ignore", e);
    }

    private final ScrollState resolveScrollState(int r7, float r8) {
        int r0 = getPageCount$OUI_standardRelease();
        if (r0 > 0) goto L6;
        OUILogger.INSTANCE.i(this.TAG, Intrinsics.stringPlus("Ignore onPageScrolled because pageCount=", Integer.valueOf(r0)));
        return null;
    L6:
        boolean r3 = true;
        if (r0 == 1) goto L9;
        int r5 = r0 - 1;
        if (r7 < 0) goto L14;
        if (r7 > r5) goto L14;
    L15:
        if (r3 == true) goto L18;
        OUILogger.INSTANCE.i(this.TAG, "Ignore onPageScrolled because position=" + r7 + ", pageCount=" + r0);
        return null;
    L18:
        if (r7 == r5) goto L20;
    L22:
        if (r7 != r5) goto L25;
        return new ScrollState(r5, r5, 0.0f);
    L25:
        return new ScrollState(r7, r7 + 1, r8);
    L20:
        if (r8 <= 0.0f) goto L22;
        return new ScrollState(r5, 0, r8);
    L14:
        r3 = false;
        goto L15
    L9:
        return new ScrollState(0, 0, 0.0f);
    }
}
