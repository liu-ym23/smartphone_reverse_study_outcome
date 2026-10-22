package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r1, int r2, int r3, Object r4);

        void recycleUpdateOp(AdapterHelper.UpdateOp r1);
    }

    OpReorderer(Callback r1) {
        this.mCallback = r1;
    }

    void reorderOps(List<AdapterHelper.UpdateOp> r3) {
    L2:
        int r0 = getLastMoveOutOfOrder(r3);
        if (r0 == (-1)) goto L5;
        swapMoveOp(r3, r0, r0 + 1);
        goto L2
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> r8, int r9, int r10) {
        AdapterHelper.UpdateOp r4 = r8.get(r9);
        AdapterHelper.UpdateOp r6 = r8.get(r10);
        int r0 = r6.cmd;
        if (r0 != 1) goto L5;
        swapMoveAdd(r8, r9, r4, r10, r6);
        return;
    L5:
        if (r0 != 2) goto L7;
        swapMoveRemove(r8, r9, r4, r10, r6);
        return;
    L7:
        if (r0 != 4) goto L15;
        swapMoveUpdate(r8, r9, r4, r10, r6);
        return;
    }

    void swapMoveRemove(List<AdapterHelper.UpdateOp> r9, int r10, AdapterHelper.UpdateOp r11, int r12, AdapterHelper.UpdateOp r13) {
        boolean r3 = false;
        if (r11.positionStart >= r11.itemCount) goto L11;
        if (r13.positionStart == r11.positionStart) goto L7;
    L9:
        boolean r0 = false;
    L17:
        if (r11.itemCount >= r13.positionStart) goto L20;
        r13.positionStart--;
    L25:
        AdapterHelper.UpdateOp r6 = null;
        if (r11.positionStart > r13.positionStart) goto L29;
        r13.positionStart++;
    L31:
        if (r3 == false) goto L34;
        r9.set(r10, r13);
        r9.remove(r12);
        this.mCallback.recycleUpdateOp(r11);
        return;
    L34:
        if (r0 == false) goto L48;
        if (r6 == null) goto L43;
        if (r11.positionStart <= r6.positionStart) goto L40;
        r11.positionStart -= r6.itemCount;
    L40:
        if (r11.itemCount <= r6.positionStart) goto L43;
        r11.itemCount -= r6.itemCount;
    L43:
        if (r11.positionStart <= r13.positionStart) goto L46;
        r11.positionStart -= r13.itemCount;
    L46:
        if (r11.itemCount <= r13.positionStart) goto L61;
        r11.itemCount -= r13.itemCount;
    L61:
        r9.set(r10, r13);
        if (r11.positionStart == r11.itemCount) goto L64;
        r9.set(r12, r11);
    L65:
        if (r6 == null) goto L69;
        r9.add(r10, r6);
        return;
    L69:
        return;
    L64:
        r9.remove(r12);
        goto L65
    L48:
        if (r6 == null) goto L56;
        if (r11.positionStart < r6.positionStart) goto L53;
        r11.positionStart -= r6.itemCount;
    L53:
        if (r11.itemCount < r6.positionStart) goto L56;
        r11.itemCount -= r6.itemCount;
    L56:
        if (r11.positionStart < r13.positionStart) goto L59;
        r11.positionStart -= r13.itemCount;
    L59:
        if (r11.itemCount < r13.positionStart) goto L61;
        r11.itemCount -= r13.itemCount;
        goto L61
    L29:
        if (r11.positionStart >= (r13.positionStart + r13.itemCount)) goto L31;
        r6 = this.mCallback.obtainUpdateOp(2, r11.positionStart + 1, (r13.positionStart + r13.itemCount) - r11.positionStart, null);
        r13.itemCount = r11.positionStart - r13.positionStart;
        goto L31
    L20:
        if (r11.itemCount >= (r13.positionStart + r13.itemCount)) goto L25;
        r13.itemCount--;
        r11.cmd = 2;
        r11.itemCount = 1;
        if (r13.itemCount != 0) goto L68;
        r9.remove(r12);
        this.mCallback.recycleUpdateOp(r13);
        return;
    L68:
        return;
    L7:
        if (r13.itemCount != (r11.itemCount - r11.positionStart)) goto L9;
        r0 = false;
        r3 = true;
        goto L17
    L11:
        if (r13.positionStart == (r11.itemCount + 1)) goto L13;
    L15:
        r0 = true;
        goto L17
    L13:
        if (r13.itemCount != (r11.positionStart - r11.itemCount)) goto L15;
        r0 = true;
        r3 = true;
        goto L17
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r3, int r4, AdapterHelper.UpdateOp r5, int r6, AdapterHelper.UpdateOp r7) {
        if (r5.itemCount >= r7.positionStart) goto L5;
        int r2 = -1;
    L7:
        if (r5.positionStart >= r7.positionStart) goto L10;
        r2 = r2 + 1;
    L10:
        if (r7.positionStart > r5.positionStart) goto L13;
        r5.positionStart += r7.itemCount;
    L13:
        if (r7.positionStart > r5.itemCount) goto L15;
        r5.itemCount += r7.itemCount;
    L15:
        r7.positionStart += r2;
        r3.set(r4, r7);
        r3.set(r6, r5);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    void swapMoveUpdate(List<AdapterHelper.UpdateOp> r8, int r9, AdapterHelper.UpdateOp r10, int r11, AdapterHelper.UpdateOp r12) {
        AdapterHelper.UpdateOp r4 = null;
        if (r10.itemCount >= r12.positionStart) goto L6;
        r12.positionStart--;
    L8:
        AdapterHelper.UpdateOp r0 = null;
    L10:
        if (r10.positionStart > r12.positionStart) goto L13;
        r12.positionStart++;
    L15:
        r8.set(r11, r10);
        if (r12.itemCount <= 0) goto L18;
        r8.set(r9, r12);
    L19:
        if (r0 == null) goto L21;
        r8.add(r9, r0);
    L21:
        if (r4 == null) goto L24;
        r8.add(r9, r4);
        return;
    L24:
        return;
    L18:
        r8.remove(r9);
        this.mCallback.recycleUpdateOp(r12);
        goto L19
    L13:
        if (r10.positionStart >= (r12.positionStart + r12.itemCount)) goto L15;
        int r1 = (r12.positionStart + r12.itemCount) - r10.positionStart;
        r4 = this.mCallback.obtainUpdateOp(4, r10.positionStart + 1, r1, r12.payload);
        r12.itemCount -= r1;
        goto L15
    L6:
        if (r10.itemCount >= (r12.positionStart + r12.itemCount)) goto L8;
        r12.itemCount--;
        r0 = this.mCallback.obtainUpdateOp(4, r10.positionStart, 1, r12.payload);
        goto L10
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> r5) {
        int r4 = r5.size() - 1;
        boolean r1 = false;
    L3:
        if (r4 < 0) goto L10;
        if (r5.get(r4).cmd != 8) goto L8;
        if (r1 == false) goto L9;
        return r4;
    L9:
        r4 = r4 - 1;
        goto L3
    L8:
        r1 = true;
        goto L9
    L10:
        return -1;
    }
}
