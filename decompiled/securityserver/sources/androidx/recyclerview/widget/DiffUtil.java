package androidx.recyclerview.widget;

import a.a;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = null;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(int r1, int r2);

        public abstract boolean areItemsTheSame(int r1, int r2);

        @Nullable
        public Object getChangePayload(int r1, int r2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        public DiffResult(Callback r1, List<Snake> r2, int[] r3, int[] r4, boolean r5) {
            this.mSnakes = r2;
            this.mOldItemStatuses = r3;
            this.mNewItemStatuses = r4;
            Arrays.fill(r3, 0);
            Arrays.fill(r4, 0);
            this.mCallback = r1;
            this.mOldListSize = r1.getOldListSize();
            this.mNewListSize = r1.getNewListSize();
            this.mDetectMoves = r5;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            if (this.mSnakes.isEmpty() == false) goto L5;
            Snake r0 = null;
        L6:
            if (r0 != null) goto L8;
        L11:
            Snake r1 = new Snake();
            r1.x = 0;
            r1.y = 0;
            r1.removal = false;
            r1.size = 0;
            r1.reverse = false;
            this.mSnakes.add(0, r1);
            return;
        L8:
            if (r0.x != 0) goto L11;
            if (r0.y != 0) goto L11;
            return;
        L5:
            r0 = this.mSnakes.get(0);
            goto L6
        }

        private void dispatchAdditions(List<PostponedUpdate> r7, ListUpdateCallback r8, int r9, int r10, int r11) {
            if (this.mDetectMoves == true) goto L6;
            r8.onInserted(r9, r10);
            return;
        L6:
            int r12 = r10 - 1;
        L7:
            if (r12 < 0) goto L27;
            int r2 = r11 + r12;
            int r1 = this.mNewItemStatuses[r2];
            int r3 = r1 & 31;
            if (r3 != 0) goto L11;
            r8.onInserted(r9, 1);
            Iterator<PostponedUpdate> r4 = r7.iterator();
        L24:
            if (r4.hasNext() == false) goto L26;
            r4.next().currentPos++;
        L26:
            r12 = r12 - 1;
            goto L7
        L11:
            if (r3 != 4) goto L13;
        L19:
            int r5 = r1 >> 5;
            r8.onMoved(removePostponedUpdate(r7, r5, true).currentPos, r9);
            if (r3 != 4) goto L26;
            r8.onChanged(r9, 1, this.mCallback.getChangePayload(r5, r2));
            goto L26
        L13:
            if (r3 == 8) goto L19;
            if (r3 != 16) goto L17;
            r7.add(new PostponedUpdate(r2, r9, false));
            goto L26
        L17:
            StringBuilder r13 = a.p(r2, "unknown flag for pos ", " ");
            r13.append(Long.toBinaryString(r3));
            throw new IllegalStateException(r13.toString());
        }

        private void dispatchRemovals(List<PostponedUpdate> r9, ListUpdateCallback r10, int r11, int r12, int r13) {
            if (this.mDetectMoves == true) goto L6;
            r10.onRemoved(r11, r12);
            return;
        L6:
            int r14 = r12 - 1;
        L7:
            if (r14 < 0) goto L27;
            int r2 = r13 + r14;
            int r1 = this.mOldItemStatuses[r2];
            int r3 = r1 & 31;
            if (r3 != 0) goto L11;
            r10.onRemoved(r11 + r14, 1);
            Iterator<PostponedUpdate> r4 = r9.iterator();
        L24:
            if (r4.hasNext() == false) goto L26;
            r4.next().currentPos--;
        L26:
            r14 = r14 - 1;
            goto L7
        L11:
            if (r3 != 4) goto L13;
        L19:
            int r5 = r1 >> 5;
            PostponedUpdate r6 = removePostponedUpdate(r9, r5, false);
            r10.onMoved(r11 + r14, r6.currentPos - 1);
            if (r3 != 4) goto L26;
            r10.onChanged(r6.currentPos - 1, 1, this.mCallback.getChangePayload(r2, r5));
            goto L26
        L13:
            if (r3 == 8) goto L19;
            if (r3 != 16) goto L17;
            r9.add(new PostponedUpdate(r2, r11 + r14, true));
            goto L26
        L17:
            StringBuilder r15 = a.p(r2, "unknown flag for pos ", " ");
            r15.append(Long.toBinaryString(r3));
            throw new IllegalStateException(r15.toString());
        }

        private void findAddition(int r3, int r4, int r5) {
            if (this.mOldItemStatuses[r3 - 1] == 0) goto L5;
            return;
        L5:
            findMatchingItem(r3, r4, r5, false);
        }

        private boolean findMatchingItem(int r9, int r10, int r11, boolean r12) {
            if (r12 == false) goto L4;
            r10 = r10 - 1;
            int r1 = r9;
            int r0 = r10;
        L5:
            if (r11 < 0) goto L29;
            Snake r2 = this.mSnakes.get(r11);
            int r3 = r2.x;
            int r4 = r2.size;
            int r5 = r3 + r4;
            int r6 = r2.y + r4;
            int r7 = 4;
            if (r12 == false) goto L18;
            int r8 = r1 - 1;
        L9:
            if (r8 < r5) goto L28;
            if (this.mCallback.areItemsTheSame(r8, r0) == true) goto L13;
            r8 = r8 - 1;
            goto L9
        L13:
            if (this.mCallback.areContentsTheSame(r8, r0) == false) goto L15;
            r7 = 8;
        L15:
            this.mNewItemStatuses[r0] = (r8 << 5) | 16;
            this.mOldItemStatuses[r8] = (r0 << 5) | r7;
            return true;
        L28:
            r1 = r2.x;
            r10 = r2.y;
            r11 = r11 - 1;
            goto L5
        L18:
            int r13 = r10 - 1;
        L19:
            if (r13 < r6) goto L28;
            if (this.mCallback.areItemsTheSame(r0, r13) == true) goto L23;
            r13 = r13 - 1;
            goto L19
        L23:
            if (this.mCallback.areContentsTheSame(r0, r13) == false) goto L25;
            r7 = 8;
        L25:
            int r14 = r9 - 1;
            this.mOldItemStatuses[r14] = (r13 << 5) | 16;
            this.mNewItemStatuses[r13] = (r14 << 5) | r7;
            return true;
        L29:
            return false;
        L4:
            r0 = r9 - 1;
            r1 = r0;
            goto L5
        }

        private void findMatchingItems() {
            int r0 = this.mOldListSize;
            int r1 = this.mNewListSize;
            int r2 = this.mSnakes.size() - 1;
        L3:
            if (r2 < 0) goto L19;
            Snake r4 = this.mSnakes.get(r2);
            int r5 = r4.x;
            int r6 = r4.size;
            int r7 = r5 + r6;
            int r8 = r4.y + r6;
            if (this.mDetectMoves == false) goto L10;
        L6:
            if (r0 <= r7) goto L8;
            findAddition(r0, r1, r2);
            r0 = r0 - 1;
        L8:
            if (r1 <= r8) goto L10;
            findRemoval(r0, r1, r2);
            r1 = r1 - 1;
        L10:
            int r3 = 0;
        L12:
            if (r3 >= r4.size) goto L18;
            int r9 = r4.x + r3;
            int r10 = r4.y + r3;
            if (this.mCallback.areContentsTheSame(r9, r10) == false) goto L16;
            int r11 = 1;
        L17:
            this.mOldItemStatuses[r9] = (r10 << 5) | r11;
            this.mNewItemStatuses[r10] = (r9 << 5) | r11;
            r3 = r3 + 1;
            goto L12
        L16:
            r11 = 2;
            goto L17
        L18:
            r0 = r4.x;
            r1 = r4.y;
            r2 = r2 - 1;
            goto L3
        }

        private void findRemoval(int r3, int r4, int r5) {
            if (this.mNewItemStatuses[r4 - 1] == 0) goto L5;
            return;
        L5:
            findMatchingItem(r3, r4, r5, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> r5, int r6, boolean r7) {
            int r0 = r5.size() - 1;
        L3:
            if (r0 < 0) goto L18;
            PostponedUpdate r2 = r5.get(r0);
            if (r2.posInOwnerList != r6) goto L17;
            if (r2.removal != r7) goto L17;
            r5.remove(r0);
        L10:
            if (r0 >= r5.size()) goto L16;
            PostponedUpdate r8 = r5.get(r0);
            int r3 = r8.currentPos;
            if (r7 == false) goto L14;
            int r4 = 1;
        L15:
            r8.currentPos = r3 + r4;
            r0 = r0 + 1;
            goto L10
        L14:
            r4 = -1;
            goto L15
        L16:
            return r2;
        L17:
            r0 = r0 - 1;
            goto L3
        L18:
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int r4) {
            if (r4 >= 0) goto L4;
        L11:
            StringBuilder r5 = a.p(r4, "Index out of bounds - passed position = ", ", new list size = ");
            r5.append(this.mNewListSize);
            throw new IndexOutOfBoundsException(r5.toString());
        L4:
            if (r4 >= this.mNewListSize) goto L11;
            int r3 = this.mNewItemStatuses[r4];
            if ((r3 & 31) != 0) goto L10;
            return -1;
        L10:
            return r3 >> 5;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int r4) {
            if (r4 >= 0) goto L4;
        L11:
            StringBuilder r5 = a.p(r4, "Index out of bounds - passed position = ", ", old list size = ");
            r5.append(this.mOldListSize);
            throw new IndexOutOfBoundsException(r5.toString());
        L4:
            if (r4 >= this.mOldListSize) goto L11;
            int r3 = this.mOldItemStatuses[r4];
            if ((r3 & 31) != 0) goto L10;
            return -1;
        L10:
            return r3 >> 5;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter r2) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(r2));
        }

        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback r15) {
            if ((r15 instanceof BatchingListUpdateCallback) == false) goto L5;
            BatchingListUpdateCallback r16 = (BatchingListUpdateCallback) r15;
        L6:
            List<PostponedUpdate> r0 = new ArrayList();
            int r1 = this.mOldListSize;
            int r8 = this.mNewListSize;
            int r9 = this.mSnakes.size() - 1;
        L7:
            if (r9 < 0) goto L20;
            Snake r10 = this.mSnakes.get(r9);
            int r11 = r10.size;
            int r12 = r10.x + r11;
            int r13 = r10.y + r11;
            if (r12 >= r1) goto L11;
            dispatchRemovals(r0, r16, r12, r1 - r12, r12);
        L11:
            if (r13 >= r8) goto L13;
            dispatchAdditions(r0, r16, r12, r8 - r13, r13);
        L13:
            int r14 = r11 - 1;
        L14:
            if (r14 < 0) goto L19;
            int[] r2 = this.mOldItemStatuses;
            int r3 = r10.x;
            if ((r2[r3 + r14] & 31) != 2) goto L18;
            r16.onChanged(r3 + r14, 1, this.mCallback.getChangePayload(r3 + r14, r10.y + r14));
        L18:
            r14 = r14 - 1;
            goto L14
        L19:
            r1 = r10.x;
            r8 = r10.y;
            r9 = r9 - 1;
            goto L7
        L20:
            r16.dispatchLastEvent();
            return;
        L5:
            r16 = new BatchingListUpdateCallback(r15);
            goto L6
        }
    }

    public static abstract class ItemCallback<T> {
        public ItemCallback() {
        }

        public abstract boolean areContentsTheSame(@NonNull T r1, @NonNull T r2);

        public abstract boolean areItemsTheSame(@NonNull T r1, @NonNull T r2);

        @Nullable
        public Object getChangePayload(@NonNull T r1, @NonNull T r2) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int r1, int r2, boolean r3) {
            this.posInOwnerList = r1;
            this.currentPos = r2;
            this.removal = r3;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int r1, int r2, int r3, int r4) {
            this.oldListStart = r1;
            this.oldListEnd = r2;
            this.newListStart = r3;
            this.newListEnd = r4;
        }
    }

    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        public Snake() {
        }
    }

    static {
        SNAKE_COMPARATOR = new AnonymousClass1();
    }

    private DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r1) {
        return calculateDiff(r1, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Snake diffPartial(Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        int r3 = r21 - r20;
        int r4 = r23 - r22;
        int r5 = 1;
        if (r3 < 1) goto L70;
        if (r4 < 1) goto L91;
        int r6 = r3 - r4;
        int r7 = ((r3 + r4) + 1) / 2;
        int r8 = (r26 - r7) - 1;
        int r9 = (r26 + r7) + 1;
        boolean r10 = false;
        Arrays.fill(r24, r8, r9, 0);
        Arrays.fill(r25, r8 + r6, r9 + r6, r3);
        if ((r6 % 2) == 0) goto L9;
        boolean r11 = true;
    L10:
        int r12 = 0;
    L11:
        if (r12 > r7) goto L69;
        int r13 = -r12;
        int r14 = r13;
    L13:
        if (r14 > r12) goto L38;
        if (r14 == r13) goto L20;
        if (r14 == r12) goto L19;
        int r15 = r26 + r14;
        if (r24[r15 - 1] < r24[r15 + r5]) goto L20;
    L19:
        int r16 = r24[(r26 + r14) - r5] + r5;
        boolean r17 = r5;
    L21:
        int r18 = r16 - r14;
    L22:
        if (r16 >= r3) goto L27;
        if (r18 >= r4) goto L27;
        if (r19.areItemsTheSame(r20 + r16, r22 + r18) == false) goto L27;
        r16 = r16 + 1;
        r18 = r18 + 1;
    L27:
        int r27 = r26 + r14;
        r24[r27] = r16;
        if (r11 == false) goto L37;
        if (r14 < ((r6 - r12) + 1)) goto L37;
        if (r14 > ((r6 + r12) - 1)) goto L37;
        if (r16 < r25[r27]) goto L37;
        Snake r0 = new Snake();
        int r2 = r25[r27];
        r0.x = r2;
        r0.y = r2 - r14;
        r0.size = r24[r27] - r2;
        r0.removal = r17;
        r0.reverse = false;
        return r0;
    L37:
        r14 = r14 + 2;
        r10 = false;
        r5 = 1;
    L20:
        r16 = r24[(r26 + r14) + r5];
        r17 = r10;
        goto L21
    L38:
        boolean r110 = r10;
        int r28 = r13;
    L39:
        if (r28 > r12) goto L67;
        int r111 = r28 + r6;
        if (r111 != (r12 + r6)) goto L43;
        int r112 = 1;
    L50:
        int r113 = r25[(r26 + r111) - r112];
        boolean r114 = r110;
    L51:
        int r115 = r113 - r111;
    L52:
        if (r113 <= 0) goto L57;
        if (r115 <= 0) goto L57;
        int r116 = r3;
        if (r19.areItemsTheSame((r20 + r113) - 1, (r22 + r115) - 1) == false) goto L58;
        r113 = r113 - 1;
        r115 = r115 - 1;
        r3 = r116;
    L58:
        int r29 = r26 + r111;
        r25[r29] = r113;
        if (r11 == true) goto L66;
        if (r111 < r13) goto L66;
        if (r111 > r12) goto L66;
        if (r24[r29] < r113) goto L66;
        Snake r1 = new Snake();
        int r30 = r25[r29];
        r1.x = r30;
        r1.y = r30 - r111;
        r1.size = r24[r29] - r30;
        r1.removal = r114;
        r1.reverse = true;
        return r1;
    L66:
        r28 = r28 + 2;
        r3 = r116;
        r110 = false;
    L57:
        r116 = r3;
        goto L58
    L43:
        if (r111 == (r13 + r6)) goto L47;
        int r117 = r26 + r111;
        r112 = 1;
        if (r25[r117 - 1] < r25[r117 + 1]) goto L50;
    L48:
        r113 = r25[(r26 + r111) + r112] - r112;
        r114 = r112;
        goto L51
    L47:
        r112 = 1;
        goto L48
    L67:
        r12 = r12 + 1;
        r5 = 1;
        r3 = r3;
        r10 = false;
        goto L11
    L69:
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    L9:
        r11 = false;
        goto L10
    L91:
        return null;
    L70:
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback r15, boolean r16) {
        int r0 = r15.getOldListSize();
        int r1 = r15.getNewListSize();
        ArrayList r4 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r2.add(new Range(0, r0, 0, r1));
        int r3 = Math.abs(r0 - r1) + (r0 + r1);
        int r5 = r3 * 2;
        int[] r13 = new int[r5];
        int[] r6 = new int[r5];
        ArrayList r7 = new ArrayList();
    L4:
        if (r2.isEmpty() == true) goto L30;
        Range r14 = (Range) r2.remove(r2.size() - 1);
        Snake r8 = diffPartial(r15, r14.oldListStart, r14.oldListEnd, r14.newListStart, r14.newListEnd, r13, r6, r3);
        if (r8 != null) goto L8;
        r7.add(r14);
        goto L4
    L8:
        if (r8.size <= 0) goto L10;
        r4.add(r8);
    L10:
        r8.x += r14.oldListStart;
        r8.y += r14.newListStart;
        if (r7.isEmpty() == false) goto L13;
        Range r9 = new Range();
    L14:
        r9.oldListStart = r14.oldListStart;
        r9.newListStart = r14.newListStart;
        if (r8.reverse == false) goto L18;
        r9.oldListEnd = r8.x;
        r9.newListEnd = r8.y;
    L21:
        r2.add(r9);
        if (r8.reverse == true) goto L24;
        int r10 = r8.x;
        int r11 = r8.size;
        r14.oldListStart = r10 + r11;
        r14.newListStart = r8.y + r11;
    L28:
        r2.add(r14);
        goto L4
    L24:
        if (r8.removal == false) goto L26;
        int r12 = r8.x;
        int r17 = r8.size;
        r14.oldListStart = (r12 + r17) + 1;
        r14.newListStart = r8.y + r17;
        goto L28
    L26:
        int r18 = r8.x;
        int r19 = r8.size;
        r14.oldListStart = r18 + r19;
        r14.newListStart = (r8.y + r19) + 1;
        goto L28
    L18:
        if (r8.removal == false) goto L20;
        r9.oldListEnd = r8.x - 1;
        r9.newListEnd = r8.y;
        goto L21
    L20:
        r9.oldListEnd = r8.x;
        r9.newListEnd = r8.y - 1;
        goto L21
    L13:
        r9 = (Range) r7.remove(r7.size() - 1);
        goto L14
    L30:
        Collections.sort(r4, SNAKE_COMPARATOR);
        return new DiffResult(r15, r4, r13, r6, r16);
    }
}
