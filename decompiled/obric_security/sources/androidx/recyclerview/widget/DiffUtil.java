package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = null;

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int r1, int r2);

        public abstract boolean areItemsTheSame(int r1, int r2);

        public Object getChangePayload(int r1, int r2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();

        public Callback() {
        }
    }

    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int r1) {
            int[] r2 = new int[r1];
            this.mData = r2;
            this.mMid = r2.length / 2;
        }

        int get(int r2) {
            return this.mData[r2 + this.mMid];
        }

        int[] backingData() {
            return this.mData;
        }

        void set(int r2, int r3) {
            this.mData[r2 + this.mMid] = r3;
        }

        public void fill(int r1) {
            Arrays.fill(this.mData, r1);
        }
    }

    static class Diagonal {
        public final int size;
        public final int x;
        public final int y;

        Diagonal(int r1, int r2, int r3) {
            this.x = r1;
            this.y = r2;
            this.size = r3;
        }

        int endX() {
            return this.x + this.size;
        }

        int endY() {
            return this.y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback r1, List<Diagonal> r2, int[] r3, int[] r4, boolean r5) {
            this.mDiagonals = r2;
            this.mOldItemStatuses = r3;
            this.mNewItemStatuses = r4;
            Arrays.fill(r3, 0);
            Arrays.fill(r4, 0);
            this.mCallback = r1;
            this.mOldListSize = r1.getOldListSize();
            this.mNewListSize = r1.getNewListSize();
            this.mDetectMoves = r5;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            if (this.mDiagonals.isEmpty() == false) goto L5;
            Diagonal r0 = null;
        L6:
            if (r0 != null) goto L8;
        L11:
            this.mDiagonals.add(0, new Diagonal(0, 0, 0));
        L12:
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
            return;
        L8:
            if (r0.x != 0) goto L11;
            if (r0.y == 0) goto L12;
        L5:
            r0 = this.mDiagonals.get(0);
            goto L6
        }

        private void findMatchingItems() {
            Iterator<Diagonal> r0 = this.mDiagonals.iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            Diagonal r1 = r0.next();
            int r2 = 0;
        L7:
            if (r2 >= r1.size) goto L4;
            int r3 = r1.x + r2;
            int r4 = r1.y + r2;
            if (this.mCallback.areContentsTheSame(r3, r4) == false) goto L11;
            int r5 = 1;
        L12:
            this.mOldItemStatuses[r3] = (r4 << 4) | r5;
            this.mNewItemStatuses[r4] = (r3 << 4) | r5;
            r2 = r2 + 1;
            goto L7
        L11:
            r5 = 2;
            goto L12
        L14:
            if (this.mDetectMoves == false) goto L21;
            findMoveMatches();
            return;
        }

        private void findMoveMatches() {
            Iterator<Diagonal> r0 = this.mDiagonals.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L13;
            Diagonal r2 = r0.next();
        L7:
            if (r1 >= r2.x) goto L12;
            if (this.mOldItemStatuses[r1] != 0) goto L11;
            findMatchingAddition(r1);
        L11:
            r1 = r1 + 1;
            goto L7
        L12:
            r1 = r2.endX();
            goto L4
        }

        private void findMatchingAddition(int r6) {
            int r0 = this.mDiagonals.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r1 >= r0) goto L19;
            Diagonal r3 = this.mDiagonals.get(r1);
        L6:
            if (r2 >= r3.y) goto L18;
            if (this.mNewItemStatuses[r2] != 0) goto L17;
            if (this.mCallback.areItemsTheSame(r6, r2) == false) goto L17;
            if (this.mCallback.areContentsTheSame(r6, r2) == false) goto L14;
            int r4 = 8;
        L15:
            this.mOldItemStatuses[r6] = (r2 << 4) | r4;
            this.mNewItemStatuses[r2] = (r6 << 4) | r4;
            return;
        L14:
            r4 = 4;
        L17:
            r2 = r2 + 1;
            goto L6
        L18:
            r2 = r3.endY();
            r1 = r1 + 1;
            goto L3
        }

        public int convertOldPositionToNew(int r4) {
            if (r4 < 0) goto L12;
            if (r4 >= this.mOldListSize) goto L12;
            int r3 = this.mOldItemStatuses[r4];
            if ((r3 & 15) != 0) goto L10;
            return -1;
        L10:
            return r3 >> 4;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r4 + ", old list size = " + this.mOldListSize);
        }

        public int convertNewPositionToOld(int r4) {
            if (r4 < 0) goto L12;
            if (r4 >= this.mNewListSize) goto L12;
            int r3 = this.mNewItemStatuses[r4];
            if ((r3 & 15) != 0) goto L10;
            return -1;
        L10:
            return r3 >> 4;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r4 + ", new list size = " + this.mNewListSize);
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter r2) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(r2));
        }

        public void dispatchUpdatesTo(ListUpdateCallback r13) {
            if ((r13 instanceof BatchingListUpdateCallback) == false) goto L5;
            BatchingListUpdateCallback r14 = (BatchingListUpdateCallback) r13;
        L6:
            int r0 = this.mOldListSize;
            ArrayDeque r1 = new ArrayDeque();
            int r2 = this.mOldListSize;
            int r3 = this.mNewListSize;
            int r4 = this.mDiagonals.size() - 1;
        L7:
            if (r4 < 0) goto L38;
            Diagonal r6 = this.mDiagonals.get(r4);
            int r7 = r6.endX();
            int r8 = r6.endY();
        L9:
            int r9 = 0;
            if (r2 <= r7) goto L20;
            r2 = r2 - 1;
            int r10 = this.mOldItemStatuses[r2];
            if ((r10 & 12) != 0) goto L13;
            r14.onRemoved(r2, 1);
            r0 = r0 - 1;
            goto L9
        L13:
            int r11 = r10 >> 4;
            PostponedUpdate r12 = getPostponedUpdate(r1, r11, false);
            if (r12 != null) goto L15;
            r1.add(new PostponedUpdate(r2, (r0 - r2) - 1, true));
            goto L9
        L15:
            int r15 = (r0 - r12.currentPos) - 1;
            r14.onMoved(r2, r15);
            if ((r10 & 4) == 0) goto L9;
            r14.onChanged(r15, 1, this.mCallback.getChangePayload(r2, r11));
        L20:
            if (r3 <= r8) goto L30;
            r3 = r3 - 1;
            int r16 = this.mNewItemStatuses[r3];
            if ((r16 & 12) != 0) goto L23;
            r14.onInserted(r2, 1);
            r0 = r0 + 1;
            goto L20
        L23:
            int r17 = r16 >> 4;
            PostponedUpdate r18 = getPostponedUpdate(r1, r17, true);
            if (r18 == null) goto L25;
            r14.onMoved((r0 - r18.currentPos) - 1, r2);
            if ((r16 & 4) == 0) goto L20;
            r14.onChanged(r2, 1, this.mCallback.getChangePayload(r17, r3));
            goto L20
        L25:
            r1.add(new PostponedUpdate(r3, r0 - r2, false));
            goto L20
        L30:
            int r5 = r6.x;
            int r19 = r6.y;
        L32:
            if (r9 >= r6.size) goto L37;
            if ((this.mOldItemStatuses[r5] & 15) != 2) goto L36;
            r14.onChanged(r5, 1, this.mCallback.getChangePayload(r5, r19));
        L36:
            r5 = r5 + 1;
            r19 = r19 + 1;
            r9 = r9 + 1;
            goto L32
        L37:
            r2 = r6.x;
            r3 = r6.y;
            r4 = r4 - 1;
            goto L7
        L38:
            r14.dispatchLastEvent();
            return;
        L5:
            r14 = new BatchingListUpdateCallback(r13);
            goto L6
        }

        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> r2, int r3, boolean r4) {
            Iterator<PostponedUpdate> r5 = r2.iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            PostponedUpdate r0 = r5.next();
            if (r0.posInOwnerList != r3) goto L4;
            if (r0.removal != r4) goto L4;
            r5.remove();
        L12:
            if (r5.hasNext() == false) goto L17;
            PostponedUpdate r6 = r5.next();
            if (r4 == true) goto L15;
            r6.currentPos++;
            goto L12
        L15:
            r6.currentPos--;
            goto L12
        L17:
            return r0;
        L10:
            r0 = null;
            goto L12
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T r1, T r2);

        public abstract boolean areItemsTheSame(T r1, T r2);

        public Object getChangePayload(T r1, T r2) {
            return null;
        }

        public ItemCallback() {
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int r1, int r2, boolean r3) {
            this.posInOwnerList = r1;
            this.currentPos = r2;
            this.removal = r3;
        }
    }

    static class Range {
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

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }
    }

    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        boolean hasAdditionOrRemoval() {
            if ((this.endY - this.startY) == (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAddition() {
            if ((this.endY - this.startY) <= (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        Diagonal toDiagonal() {
            if (hasAdditionOrRemoval() == true) goto L5;
            int r1 = this.startX;
            return new Diagonal(r1, this.startY, this.endX - r1);
        L5:
            if (this.reverse == false) goto L9;
            return new Diagonal(this.startX, this.startY, diagonalSize());
        L9:
            if (isAddition() == false) goto L13;
            return new Diagonal(this.startX, this.startY + 1, diagonalSize());
        L13:
            return new Diagonal(this.startX + 1, this.startY, diagonalSize());
        }
    }

    private DiffUtil() {
    }

    static {
        DIAGONAL_COMPARATOR = new AnonymousClass1();
    }

    public static DiffResult calculateDiff(Callback r1) {
        return calculateDiff(r1, true);
    }

    public static DiffResult calculateDiff(Callback r9, boolean r10) {
        int r0 = r9.getOldListSize();
        int r1 = r9.getNewListSize();
        ArrayList r4 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r2.add(new Range(0, r0, 0, r1));
        int r3 = ((((r0 + r1) + 1) / 2) * 2) + 1;
        CenteredArray r5 = new CenteredArray(r3);
        CenteredArray r6 = new CenteredArray(r3);
        ArrayList r7 = new ArrayList();
    L4:
        if (r2.isEmpty() == true) goto L16;
        Range r8 = (Range) r2.remove(r2.size() - 1);
        Snake r11 = midPoint(r8, r9, r5, r6);
        if (r11 != null) goto L8;
        r7.add(r8);
        goto L4
    L8:
        if (r11.diagonalSize() <= 0) goto L11;
        r4.add(r11.toDiagonal());
    L11:
        if (r7.isEmpty() == false) goto L13;
        Range r12 = new Range();
    L14:
        r12.oldListStart = r8.oldListStart;
        r12.newListStart = r8.newListStart;
        r12.oldListEnd = r11.startX;
        r12.newListEnd = r11.startY;
        r2.add(r12);
        r8.oldListEnd = r8.oldListEnd;
        r8.newListEnd = r8.newListEnd;
        r8.oldListStart = r11.endX;
        r8.newListStart = r11.endY;
        r2.add(r8);
        goto L4
    L13:
        r12 = (Range) r7.remove(r7.size() - 1);
        goto L14
    L16:
        Collections.sort(r4, DIAGONAL_COMPARATOR);
        return new DiffResult(r9, r4, r5.backingData(), r6.backingData(), r10);
    }

    private static Snake midPoint(Range r4, Callback r5, CenteredArray r6, CenteredArray r7) {
        if (r4.oldSize() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r4.newSize() < 1) goto L16;
        int r0 = ((r4.oldSize() + r4.newSize()) + 1) / 2;
        r6.set(1, r4.oldListStart);
        r7.set(1, r4.oldListEnd);
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L16;
        Snake r3 = forward(r4, r5, r6, r7, r2);
        if (r3 != null) goto L11;
        Snake r8 = backward(r4, r5, r6, r7, r2);
        if (r8 != null) goto L14;
        r2 = r2 + 1;
        goto L8
    L14:
        return r8;
    L11:
        return r3;
    }

    private static Snake forward(Range r11, Callback r12, CenteredArray r13, CenteredArray r14, int r15) {
        boolean r2 = true;
        if ((Math.abs(r11.oldSize() - r11.newSize()) % 2) == 1) goto L6;
        r2 = false;
    L6:
        int r0 = r11.oldSize() - r11.newSize();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L39;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r13.get(r4 - 1);
        int r6 = r5 + 1;
    L15:
        int r7 = (r11.newListStart + (r6 - r11.oldListStart)) - r4;
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 - 1;
    L22:
        if (r6 >= r11.oldListEnd) goto L28;
        if (r7 >= r11.newListEnd) goto L28;
        if (r12.areItemsTheSame(r6, r7) == false) goto L28;
        r6 = r6 + 1;
        r7 = r7 + 1;
    L28:
        r13.set(r4, r6);
        if (r2 == false) goto L38;
        int r9 = r0 - r4;
        if (r9 < (r3 + 1)) goto L38;
        if (r9 > (r15 - 1)) goto L38;
        if (r14.get(r9) > r6) goto L38;
        Snake r16 = new Snake();
        r16.startX = r5;
        r16.startY = r8;
        r16.endX = r6;
        r16.endY = r7;
        r16.reverse = false;
        return r16;
    L38:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r13.get(r4 + 1) <= r13.get(r4 - 1)) goto L13;
    L14:
        r5 = r13.get(r4 + 1);
        r6 = r5;
        goto L15
    L39:
        return null;
    }

    private static Snake backward(Range r11, Callback r12, CenteredArray r13, CenteredArray r14, int r15) {
        if (((r11.oldSize() - r11.newSize()) % 2) != 0) goto L5;
        boolean r0 = true;
    L6:
        int r2 = r11.oldSize() - r11.newSize();
        int r3 = -r15;
        int r4 = r3;
    L7:
        if (r4 > r15) goto L38;
        if (r4 == r3) goto L14;
        if (r4 != r15) goto L11;
    L13:
        int r5 = r14.get(r4 - 1);
        int r6 = r5 - 1;
    L15:
        int r7 = r11.newListEnd - ((r11.oldListEnd - r6) - r4);
        if (r15 == 0) goto L20;
        if (r6 != r5) goto L20;
        int r8 = r7 + 1;
    L22:
        if (r6 <= r11.oldListStart) goto L28;
        if (r7 <= r11.newListStart) goto L28;
        if (r12.areItemsTheSame(r6 - 1, r7 - 1) == false) goto L28;
        r6 = r6 - 1;
        r7 = r7 - 1;
    L28:
        r14.set(r4, r6);
        if (r0 == false) goto L37;
        int r9 = r2 - r4;
        if (r9 < r3) goto L37;
        if (r9 > r15) goto L37;
        if (r13.get(r9) < r6) goto L37;
        Snake r16 = new Snake();
        r16.startX = r6;
        r16.startY = r7;
        r16.endX = r5;
        r16.endY = r8;
        r16.reverse = true;
        return r16;
    L37:
        r4 = r4 + 2;
    L20:
        r8 = r7;
        goto L22
    L11:
        if (r14.get(r4 + 1) >= r14.get(r4 - 1)) goto L13;
    L14:
        r5 = r14.get(r4 + 1);
        r6 = r5;
        goto L15
    L38:
        return null;
    L5:
        r0 = false;
        goto L6
    }
}
