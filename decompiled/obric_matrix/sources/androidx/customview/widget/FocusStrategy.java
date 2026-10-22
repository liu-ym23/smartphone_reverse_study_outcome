package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T r1, Rect r2);
    }

    public interface CollectionAdapter<T, V> {
        V get(T r1, int r2);

        int size(T r1);
    }

    private static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        SequentialComparator(boolean r2, BoundsAdapter<T> r3) {
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = r2;
            this.mAdapter = r3;
        }

        @Override // java.util.Comparator
        public int compare(T r5, T r6) {
            Rect r0 = this.mTemp1;
            Rect r1 = this.mTemp2;
            this.mAdapter.obtainBounds(r5, r0);
            this.mAdapter.obtainBounds(r6, r1);
            int r7 = r0.top;
            int r8 = r1.top;
            if (r7 >= r8) goto L6;
            return -1;
        L6:
            if (r7 <= r8) goto L8;
            return 1;
        L8:
            int r9 = r0.left;
            int r10 = r1.left;
            if (r9 < r10) goto L11;
            if (r9 > r10) goto L16;
            int r11 = r0.bottom;
            int r12 = r1.bottom;
            if (r11 >= r12) goto L23;
            return -1;
        L23:
            if (r11 <= r12) goto L25;
            return 1;
        L25:
            int r13 = r0.right;
            int r14 = r1.right;
            if (r13 < r14) goto L28;
            if (r13 > r14) goto L33;
            return 0;
        L33:
            if (this.mIsLayoutRtl == false) goto L36;
            return -1;
        L36:
            return 1;
        L28:
            if (this.mIsLayoutRtl == true) goto L30;
            return -1;
        L30:
            return 1;
        L16:
            if (this.mIsLayoutRtl == false) goto L19;
            return -1;
        L19:
            return 1;
        L11:
            if (this.mIsLayoutRtl == true) goto L13;
            return -1;
        L13:
            return 1;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int r3, @NonNull Rect r4, @NonNull Rect r5, @NonNull Rect r6) {
        boolean r0 = beamsOverlap(r3, r4, r5);
        if (beamsOverlap(r3, r4, r6) == true) goto L19;
        if (r0 == false) goto L19;
        if (isToDirectionOf(r3, r4, r6) == true) goto L10;
        return true;
    L10:
        if (r3 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r3 == 66) goto L18;
        if (majorAxisDistance(r3, r4, r5) < majorAxisDistanceToFarEdge(r3, r4, r6)) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private static boolean beamsOverlap(int r3, @NonNull Rect r4, @NonNull Rect r5) {
        if (r3 == 17) goto L21;
        if (r3 == 33) goto L14;
        if (r3 == 66) goto L21;
        if (r3 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r5.right < r4.left) goto L19;
        if (r5.left > r4.right) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (r5.bottom < r4.top) goto L26;
        if (r5.top > r4.bottom) goto L26;
        return true;
    L26:
        return false;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L r7, @NonNull CollectionAdapter<L, T> r8, @NonNull BoundsAdapter<T> r9, @Nullable T r10, @NonNull Rect r11, int r12) {
        Rect r0 = new Rect(r11);
        int r2 = 0;
        if (r12 != 17) goto L5;
        int r1 = r11.width() + 1;
    L17:
        r0.offset(r1, 0);
    L18:
        T r3 = null;
        int r4 = r8.size(r7);
        Rect r5 = new Rect();
    L19:
        if (r2 >= r4) goto L27;
        T r6 = r8.get(r7, r2);
        if (r6 == r10) goto L26;
        r9.obtainBounds(r6, r5);
        if (isBetterCandidate(r12, r11, r5, r0) == false) goto L26;
        r0.set(r5);
        r3 = r6;
    L26:
        r2 = r2 + 1;
        goto L19
    L27:
        return r3;
    L5:
        if (r12 != 33) goto L7;
        int r13 = r11.height() + 1;
    L15:
        r0.offset(0, r13);
        goto L18
    L7:
        if (r12 != 66) goto L9;
        r1 = -(r11.width() + 1);
        goto L17
    L9:
        if (r12 != 130) goto L12;
        r13 = -(r11.height() + 1);
        goto L15
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L r4, @NonNull CollectionAdapter<L, T> r5, @NonNull BoundsAdapter<T> r6, @Nullable T r7, int r8, boolean r9, boolean r10) {
        int r0 = r5.size(r4);
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(r5.get(r4, r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Collections.sort(r1, new SequentialComparator(r9, r6));
        if (r8 == 1) goto L14;
        if (r8 != 2) goto L12;
        return (T) getNextFocusable(r7, r1, r10);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return (T) getPreviousFocusable(r7, r1, r10);
    }

    private static <T> T getNextFocusable(T r1, ArrayList<T> r2, boolean r3) {
        int r0 = r2.size();
        if (r1 != null) goto L5;
        int r4 = -1;
    L6:
        int r5 = r4 + 1;
        if (r5 < r0) goto L9;
        if (r3 == false) goto L14;
        if (r0 > 0) goto L13;
        return null;
    L13:
        return r2.get(0);
    L14:
        return null;
    L9:
        return r2.get(r5);
    L5:
        r4 = r2.lastIndexOf(r1);
        goto L6
    }

    private static <T> T getPreviousFocusable(T r1, ArrayList<T> r2, boolean r3) {
        int r0 = r2.size();
        if (r1 != null) goto L5;
        int r4 = r0;
    L6:
        int r5 = r4 - 1;
        if (r5 >= 0) goto L9;
        if (r3 == false) goto L14;
        if (r0 > 0) goto L13;
        return null;
    L13:
        return r2.get(r0 - 1);
    L14:
        return null;
    L9:
        return r2.get(r5);
    L5:
        r4 = r2.indexOf(r1);
        goto L6
    }

    private static int getWeightedDistanceFor(int r1, int r2) {
        return ((r1 * 13) * r1) + (r2 * r2);
    }

    private static boolean isBetterCandidate(int r3, @NonNull Rect r4, @NonNull Rect r5, @NonNull Rect r6) {
        if (isCandidate(r4, r5, r3) == true) goto L6;
        return false;
    L6:
        if (isCandidate(r4, r6, r3) == true) goto L9;
        return true;
    L9:
        if (beamBeats(r3, r4, r5, r6) == false) goto L12;
        return true;
    L12:
        if (beamBeats(r3, r4, r6, r5) == false) goto L15;
        return false;
    L15:
        if (getWeightedDistanceFor(majorAxisDistance(r3, r4, r5), minorAxisDistance(r3, r4, r5)) < getWeightedDistanceFor(majorAxisDistance(r3, r4, r6), minorAxisDistance(r3, r4, r6))) goto L17;
        return false;
    L17:
        return true;
    }

    private static boolean isCandidate(@NonNull Rect r3, @NonNull Rect r4, int r5) {
        if (r5 != 17) goto L5;
        int r6 = r3.right;
        int r0 = r4.right;
        if (r6 > r0) goto L44;
        if (r3.left >= r0) goto L44;
    L47:
        return false;
    L44:
        if (r3.left <= r4.left) goto L47;
        return true;
    L5:
        if (r5 != 33) goto L7;
        int r7 = r3.bottom;
        int r1 = r4.bottom;
        if (r7 > r1) goto L35;
        if (r3.top >= r1) goto L35;
    L38:
        return false;
    L35:
        if (r3.top <= r4.top) goto L38;
        return true;
    L7:
        if (r5 != 66) goto L9;
        int r8 = r3.left;
        int r2 = r4.left;
        if (r8 < r2) goto L26;
        if (r3.right <= r2) goto L26;
    L29:
        return false;
    L26:
        if (r3.right >= r4.right) goto L29;
        return true;
    L9:
        if (r5 != 130) goto L20;
        int r9 = r3.top;
        int r10 = r4.top;
        if (r9 < r10) goto L15;
        if (r3.bottom <= r10) goto L15;
    L18:
        return false;
    L15:
        if (r3.bottom >= r4.bottom) goto L18;
        return true;
    L20:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean isToDirectionOf(int r3, @NonNull Rect r4, @NonNull Rect r5) {
        if (r3 == 17) goto L28;
        if (r3 == 33) goto L23;
        if (r3 == 66) goto L18;
        if (r3 != 130) goto L16;
        if (r4.bottom > r5.top) goto L14;
        return true;
    L14:
        return false;
    L16:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L18:
        if (r4.right > r5.left) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (r4.top < r5.bottom) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (r4.left < r5.right) goto L31;
        return true;
    L31:
        return false;
    }

    private static int majorAxisDistance(int r0, @NonNull Rect r1, @NonNull Rect r2) {
        return Math.max(0, majorAxisDistanceRaw(r0, r1, r2));
    }

    private static int majorAxisDistanceRaw(int r1, @NonNull Rect r2, @NonNull Rect r3) {
        if (r1 != 17) goto L5;
        int r4 = r2.left;
        int r5 = r3.right;
    L12:
        return r4 - r5;
    L5:
        if (r1 != 33) goto L7;
        r4 = r2.top;
        r5 = r3.bottom;
        goto L12
    L7:
        if (r1 != 66) goto L9;
        r4 = r3.left;
        r5 = r2.right;
        goto L12
    L9:
        if (r1 != 130) goto L14;
        r4 = r3.top;
        r5 = r2.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistanceToFarEdge(int r0, @NonNull Rect r1, @NonNull Rect r2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(r0, r1, r2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int r1, @NonNull Rect r2, @NonNull Rect r3) {
        if (r1 != 17) goto L5;
        int r4 = r2.left;
        int r5 = r3.left;
    L12:
        return r4 - r5;
    L5:
        if (r1 != 33) goto L7;
        r4 = r2.top;
        r5 = r3.top;
        goto L12
    L7:
        if (r1 != 66) goto L9;
        r4 = r3.right;
        r5 = r2.right;
        goto L12
    L9:
        if (r1 != 130) goto L14;
        r4 = r3.bottom;
        r5 = r2.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int minorAxisDistance(int r1, @NonNull Rect r2, @NonNull Rect r3) {
        if (r1 != 17) goto L5;
    L16:
        int r4 = r2.top + (r2.height() / 2);
        int r5 = r3.top;
        int r6 = r3.height();
    L15:
        return Math.abs(r4 - (r5 + (r6 / 2)));
    L5:
        if (r1 != 33) goto L7;
    L13:
        r4 = r2.left + (r2.width() / 2);
        r5 = r3.left;
        r6 = r3.width();
        goto L15
    L7:
        if (r1 == 66) goto L16;
        if (r1 == 130) goto L13;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
}
