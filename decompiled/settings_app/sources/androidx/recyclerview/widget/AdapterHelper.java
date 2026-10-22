package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    interface Callback {
        RecyclerView.ViewHolder findViewHolder(int r1);

        void markViewHoldersUpdated(int r1, int r2, Object r3);

        void offsetPositionsForAdd(int r1, int r2);

        void offsetPositionsForMove(int r1, int r2);

        void offsetPositionsForRemovingInvisible(int r1, int r2);

        void offsetPositionsForRemovingLaidOutOrNewView(int r1, int r2);

        void onDispatchFirstPass(UpdateOp r1);

        void onDispatchSecondPass(UpdateOp r1);
    }

    static final class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        UpdateOp(int r1, int r2, int r3, Object r4) {
            this.cmd = r1;
            this.positionStart = r2;
            this.itemCount = r3;
            this.payload = r4;
        }

        String cmdToString() {
            int r1 = this.cmd;
            if (r1 != 1) goto L5;
            return "add";
        L5:
            if (r1 != 2) goto L7;
            return "rm";
        L7:
            if (r1 != 4) goto L9;
            return "up";
        L9:
            if (r1 == 8) goto L12;
            return "??";
        L12:
            return "mv";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UpdateOp) == true) goto L8;
            return false;
        L8:
            UpdateOp r6 = (UpdateOp) r5;
            int r1 = this.cmd;
            if (r1 == r6.cmd) goto L12;
            return false;
        L12:
            if (r1 != 8) goto L21;
            if (Math.abs(this.itemCount - this.positionStart) != 1) goto L21;
            if (this.itemCount != r6.positionStart) goto L21;
            if (this.positionStart != r6.itemCount) goto L21;
            return true;
        L21:
            if (this.itemCount == r6.itemCount) goto L24;
            return false;
        L24:
            if (this.positionStart == r6.positionStart) goto L26;
            return false;
        L26:
            Object r4 = this.payload;
            if (r4 == null) goto L32;
            if (r4.equals(r6.payload) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r6.payload == null) goto L34;
            return false;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }
    }

    AdapterHelper(Callback r2) {
        this(r2, false);
    }

    AdapterHelper(Callback r3, boolean r4) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = r3;
        this.mDisableRecycler = r4;
        this.mOpReorderer = new OpReorderer(this);
    }

    AdapterHelper addUpdateOp(UpdateOp... r2) {
        Collections.addAll(this.mPendingUpdates, r2);
        return this;
    }

    void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int r0 = this.mPendingUpdates.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        UpdateOp r2 = this.mPendingUpdates.get(r1);
        int r3 = r2.cmd;
        if (r3 != 1) goto L7;
        applyAdd(r2);
    L17:
        Runnable r4 = this.mOnItemProcessedCallback;
        if (r4 == null) goto L20;
        r4.run();
    L20:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        applyRemove(r2);
        goto L17
    L9:
        if (r3 != 4) goto L11;
        applyUpdate(r2);
        goto L17
    L11:
        if (r3 != 8) goto L17;
        applyMove(r2);
        goto L17
    L21:
        this.mPendingUpdates.clear();
    }

    void consumePostponedUpdates() {
        int r0 = this.mPostponedList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.mCallback.onDispatchSecondPass(this.mPostponedList.get(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    private void applyMove(UpdateOp r1) {
        postponeAndUpdateViewHolders(r1);
    }

    private void applyRemove(UpdateOp r11) {
        int r0 = r11.positionStart;
        int r1 = r11.positionStart + r11.itemCount;
        int r2 = r11.positionStart;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L23;
        if (this.mCallback.findViewHolder(r2) == null) goto L8;
    L14:
        if (r4 != 0) goto L16;
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, r0, r5, null));
        boolean r6 = true;
    L17:
        byte r7 = 1;
    L18:
        if (r6 == false) goto L20;
        r2 = r2 - r5;
        r1 = r1 - r5;
        r5 = 1;
    L21:
        r2 = r2 + 1;
        r4 = r7;
        goto L4
    L20:
        r5 = r5 + 1;
        goto L21
    L16:
        r6 = false;
        goto L17
    L8:
        if (canFindInPreLayout(r2) == true) goto L14;
        if (r4 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(2, r0, r5, null));
        r6 = true;
    L13:
        r7 = 0;
        goto L18
    L12:
        r6 = false;
        goto L13
    L23:
        if (r5 == r11.itemCount) goto L25;
        recycleUpdateOp(r11);
        r11 = obtainUpdateOp(2, r0, r5, null);
    L25:
        if (r4 != 0) goto L27;
        dispatchAndUpdateViewHolders(r11);
        return;
    L27:
        postponeAndUpdateViewHolders(r11);
    }

    private void applyUpdate(UpdateOp r10) {
        int r0 = r10.positionStart;
        int r1 = r10.positionStart + r10.itemCount;
        int r2 = r10.positionStart;
        byte r4 = -1;
        int r5 = 0;
    L4:
        if (r2 >= r1) goto L18;
        if (this.mCallback.findViewHolder(r2) == null) goto L8;
    L13:
        if (r4 != 0) goto L15;
        dispatchAndUpdateViewHolders(obtainUpdateOp(4, r0, r5, r10.payload));
        r0 = r2;
        r5 = 0;
    L15:
        r4 = 1;
    L16:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L4
    L8:
        if (canFindInPreLayout(r2) == true) goto L13;
        if (r4 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(4, r0, r5, r10.payload));
        r0 = r2;
        r5 = 0;
    L12:
        r4 = 0;
        goto L16
    L18:
        if (r5 == r10.itemCount) goto L20;
        Object r3 = r10.payload;
        recycleUpdateOp(r10);
        r10 = obtainUpdateOp(4, r0, r5, r3);
    L20:
        if (r4 != 0) goto L22;
        dispatchAndUpdateViewHolders(r10);
        return;
    L22:
        postponeAndUpdateViewHolders(r10);
    }

    private void dispatchAndUpdateViewHolders(UpdateOp r13) {
        if (r13.cmd == 1) goto L37;
        if (r13.cmd == 8) goto L37;
        int r0 = updatePositionWithPostponed(r13.positionStart, r13.cmd);
        int r2 = r13.positionStart;
        int r3 = r13.cmd;
        if (r3 == 2) goto L12;
        if (r3 != 4) goto L11;
        int r4 = 1;
    L13:
        int r7 = 1;
        int r8 = 1;
    L15:
        if (r7 >= r13.itemCount) goto L32;
        int r9 = updatePositionWithPostponed(r13.positionStart + (r4 * r7), r13.cmd);
        int r10 = r13.cmd;
        if (r10 == 2) goto L23;
        if (r10 == 4) goto L21;
    L19:
        boolean r11 = false;
    L25:
        if (r11 == false) goto L27;
        r8 = r8 + 1;
    L31:
        r7 = r7 + 1;
        goto L15
    L27:
        UpdateOp r1 = obtainUpdateOp(r13.cmd, r0, r8, r13.payload);
        dispatchFirstPassAndUpdateViewHolders(r1, r2);
        recycleUpdateOp(r1);
        if (r13.cmd != 4) goto L30;
        r2 = r2 + r8;
    L30:
        r8 = 1;
        r0 = r9;
        goto L31
    L21:
        if (r9 != (r0 + 1)) goto L19;
    L22:
        r11 = true;
        goto L25
    L23:
        if (r9 != r0) goto L19;
    L32:
        Object r5 = r13.payload;
        recycleUpdateOp(r13);
        if (r8 <= 0) goto L41;
        UpdateOp r14 = obtainUpdateOp(r13.cmd, r0, r8, r5);
        dispatchFirstPassAndUpdateViewHolders(r14, r2);
        recycleUpdateOp(r14);
        return;
    L41:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r13);
    L12:
        r4 = 0;
    L37:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp r3, int r4) {
        this.mCallback.onDispatchFirstPass(r3);
        int r0 = r3.cmd;
        if (r0 != 2) goto L5;
        this.mCallback.offsetPositionsForRemovingInvisible(r4, r3.itemCount);
        return;
    L5:
        if (r0 != 4) goto L8;
        this.mCallback.markViewHoldersUpdated(r4, r3.itemCount, r3.payload);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    private int updatePositionWithPostponed(int r7, int r8) {
        int r0 = this.mPostponedList.size() - 1;
    L4:
        if (r0 < 0) goto L44;
        UpdateOp r3 = this.mPostponedList.get(r0);
        if (r3.cmd != 8) goto L32;
        if (r3.positionStart >= r3.itemCount) goto L10;
        int r2 = r3.positionStart;
        int r4 = r3.itemCount;
    L11:
        if (r7 < r2) goto L26;
        if (r7 > r4) goto L26;
        if (r2 != r3.positionStart) goto L20;
        if (r8 != 1) goto L17;
        r3.itemCount++;
    L19:
        r7 = r7 + 1;
    L43:
        r0 = r0 - 1;
        goto L4
    L17:
        if (r8 != 2) goto L19;
        r3.itemCount--;
        goto L19
    L20:
        if (r8 != 1) goto L22;
        r3.positionStart++;
    L24:
        r7 = r7 - 1;
        goto L43
    L22:
        if (r8 != 2) goto L24;
        r3.positionStart--;
    L26:
        if (r7 >= r3.positionStart) goto L43;
        if (r8 != 1) goto L29;
        r3.positionStart++;
        r3.itemCount++;
        goto L43
    L29:
        if (r8 != 2) goto L43;
        r3.positionStart--;
        r3.itemCount--;
        goto L43
    L10:
        r2 = r3.itemCount;
        r4 = r3.positionStart;
        goto L11
    L32:
        if (r3.positionStart <= r7) goto L34;
        if (r8 != 1) goto L41;
        r3.positionStart++;
        goto L43
    L41:
        if (r8 != 2) goto L43;
        r3.positionStart--;
        goto L43
    L34:
        if (r3.cmd != 1) goto L37;
        r7 = r7 - r3.itemCount;
        goto L43
    L37:
        if (r3.cmd != 2) goto L43;
        r7 = r7 + r3.itemCount;
        goto L43
    L44:
        int r9 = this.mPostponedList.size() - 1;
    L45:
        if (r9 < 0) goto L57;
        UpdateOp r1 = this.mPostponedList.get(r9);
        if (r1.cmd != 8) goto L54;
        if (r1.itemCount != r1.positionStart) goto L51;
    L52:
        this.mPostponedList.remove(r9);
        recycleUpdateOp(r1);
    L56:
        r9 = r9 - 1;
        goto L45
    L51:
        if (r1.itemCount >= 0) goto L56;
    L54:
        if (r1.itemCount > 0) goto L56;
        this.mPostponedList.remove(r9);
        recycleUpdateOp(r1);
        goto L56
    L57:
        return r7;
    }

    private boolean canFindInPreLayout(int r8) {
        int r0 = this.mPostponedList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        UpdateOp r3 = this.mPostponedList.get(r2);
        if (r3.cmd != 8) goto L10;
        if (findPositionOffset(r3.itemCount, r2 + 1) != r8) goto L17;
        return true;
    L17:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r3.cmd != 1) goto L17;
        int r4 = r3.positionStart + r3.itemCount;
        int r5 = r3.positionStart;
    L12:
        if (r5 >= r4) goto L17;
        if (findPositionOffset(r5, r2 + 1) == r8) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return true;
    L18:
        return false;
    }

    private void applyAdd(UpdateOp r1) {
        postponeAndUpdateViewHolders(r1);
    }

    private void postponeAndUpdateViewHolders(UpdateOp r3) {
        this.mPostponedList.add(r3);
        int r0 = r3.cmd;
        if (r0 != 1) goto L5;
        this.mCallback.offsetPositionsForAdd(r3.positionStart, r3.itemCount);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(r3.positionStart, r3.itemCount);
        return;
    L7:
        if (r0 != 4) goto L9;
        this.mCallback.markViewHoldersUpdated(r3.positionStart, r3.itemCount, r3.payload);
        return;
    L9:
        if (r0 != 8) goto L12;
        this.mCallback.offsetPositionsForMove(r3.positionStart, r3.itemCount);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r3);
    }

    boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasAnyUpdateTypes(int r1) {
        if ((this.mExistingUpdateTypes & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int findPositionOffset(int r2) {
        return findPositionOffset(r2, 0);
    }

    int findPositionOffset(int r5, int r6) {
        int r0 = this.mPostponedList.size();
    L3:
        if (r6 >= r0) goto L28;
        UpdateOp r1 = this.mPostponedList.get(r6);
        if (r1.cmd != 8) goto L16;
        if (r1.positionStart != r5) goto L10;
        r5 = r1.itemCount;
    L27:
        r6 = r6 + 1;
        goto L3
    L10:
        if (r1.positionStart >= r5) goto L13;
        r5 = r5 - 1;
    L13:
        if (r1.itemCount > r5) goto L27;
        r5 = r5 + 1;
        goto L27
    L16:
        if (r1.positionStart > r5) goto L27;
        if (r1.cmd != 2) goto L25;
        if (r5 < (r1.positionStart + r1.itemCount)) goto L21;
        r5 = r5 - r1.itemCount;
        goto L27
    L21:
        return -1;
    L25:
        if (r1.cmd != 1) goto L27;
        r5 = r5 + r1.itemCount;
        goto L27
    L28:
        return r5;
    }

    boolean onItemRangeChanged(int r5, int r6, Object r7) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(4, r5, r6, r7));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean onItemRangeInserted(int r5, int r6) {
        if (r6 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(1, r5, r6, null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean onItemRangeRemoved(int r6, int r7) {
        if (r7 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(2, r6, r7, null));
        this.mExistingUpdateTypes |= 2;
        if (this.mPendingUpdates.size() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    boolean onItemRangeMoved(int r5, int r6, int r7) {
        if (r5 != r6) goto L6;
        return false;
    L6:
        if (r7 != 1) goto L12;
        this.mPendingUpdates.add(obtainUpdateOp(8, r5, r6, null));
        this.mExistingUpdateTypes |= 8;
        if (this.mPendingUpdates.size() == 1) goto L10;
        return false;
    L10:
        return true;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int r0 = this.mPendingUpdates.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        UpdateOp r3 = this.mPendingUpdates.get(r2);
        int r4 = r3.cmd;
        if (r4 != 1) goto L7;
        this.mCallback.onDispatchSecondPass(r3);
        this.mCallback.offsetPositionsForAdd(r3.positionStart, r3.itemCount);
    L17:
        Runnable r5 = this.mOnItemProcessedCallback;
        if (r5 == null) goto L20;
        r5.run();
    L20:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.mCallback.onDispatchSecondPass(r3);
        this.mCallback.offsetPositionsForRemovingInvisible(r3.positionStart, r3.itemCount);
        goto L17
    L9:
        if (r4 != 4) goto L11;
        this.mCallback.onDispatchSecondPass(r3);
        this.mCallback.markViewHoldersUpdated(r3.positionStart, r3.itemCount, r3.payload);
        goto L17
    L11:
        if (r4 != 8) goto L17;
        this.mCallback.onDispatchSecondPass(r3);
        this.mCallback.offsetPositionsForMove(r3.positionStart, r3.itemCount);
        goto L17
    L21:
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public int applyPendingUpdatesToPosition(int r6) {
        int r0 = this.mPendingUpdates.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L31;
        UpdateOp r2 = this.mPendingUpdates.get(r1);
        int r3 = r2.cmd;
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L21;
        if (r3 != 8) goto L30;
        if (r2.positionStart != r6) goto L15;
        r6 = r2.itemCount;
        goto L30
    L15:
        if (r2.positionStart >= r6) goto L18;
        r6 = r6 - 1;
    L18:
        if (r2.itemCount > r6) goto L30;
        r6 = r6 + 1;
    L30:
        r1 = r1 + 1;
        goto L3
    L21:
        if (r2.positionStart > r6) goto L30;
        if ((r2.positionStart + r2.itemCount) > r6) goto L24;
        r6 = r6 - r2.itemCount;
        goto L30
    L24:
        return -1;
    L28:
        if (r2.positionStart > r6) goto L30;
        r6 = r6 + r2.itemCount;
        goto L30
    L31:
        return r6;
    }

    boolean hasUpdates() {
        if (this.mPostponedList.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingUpdates.isEmpty() == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int r1, int r2, int r3, Object r4) {
        UpdateOp r0 = this.mUpdateOpPool.acquire();
        if (r0 == null) goto L7;
        r0.cmd = r1;
        r0.positionStart = r2;
        r0.itemCount = r3;
        r0.payload = r4;
        return r0;
    L7:
        return new UpdateOp(r1, r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp r2) {
        if (this.mDisableRecycler == true) goto L6;
        r2.payload = null;
        this.mUpdateOpPool.release(r2);
        return;
    }

    void recycleUpdateOpsAndClearList(List<UpdateOp> r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        recycleUpdateOp(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        r4.clear();
    }
}
