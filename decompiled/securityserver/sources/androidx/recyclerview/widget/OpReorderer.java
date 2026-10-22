package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r1, int r2, int r3, Object r4);

        void recycleUpdateOp(AdapterHelper.UpdateOp r1);
    }

    public OpReorderer(Callback r1) {
        this.mCallback = r1;
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

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r4, int r5, AdapterHelper.UpdateOp r6, int r7, AdapterHelper.UpdateOp r8) {
        int r3 = r6.itemCount;
        int r0 = r8.positionStart;
        if (r3 >= r0) goto L5;
        int r1 = -1;
    L6:
        int r2 = r6.positionStart;
        if (r2 >= r0) goto L9;
        r1 = r1 + 1;
    L9:
        if (r0 > r2) goto L11;
        r6.positionStart = r2 + r8.itemCount;
    L11:
        int r9 = r8.positionStart;
        if (r9 > r3) goto L14;
        r6.itemCount = r3 + r8.itemCount;
    L14:
        r8.positionStart = r9 + r1;
        r4.set(r5, r8);
        r4.set(r7, r6);
        return;
    L5:
        r1 = 0;
        goto L6
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

    public void reorderOps(List<AdapterHelper.UpdateOp> r3) {
    L2:
        int r0 = getLastMoveOutOfOrder(r3);
        if (r0 == (-1)) goto L5;
        swapMoveOp(r3, r0, r0 + 1);
        goto L2
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> r10, int r11, AdapterHelper.UpdateOp r12, int r13, AdapterHelper.UpdateOp r14) {
        int r0 = r12.positionStart;
        int r1 = r12.itemCount;
        boolean r3 = false;
        if (r0 >= r1) goto L11;
        if (r14.positionStart == r0) goto L7;
    L9:
        boolean r2 = false;
    L16:
        int r4 = r14.positionStart;
        if (r1 >= r4) goto L19;
        r14.positionStart = r4 - 1;
    L25:
        int r5 = r12.positionStart;
        int r6 = r14.positionStart;
        AdapterHelper.UpdateOp r7 = null;
        if (r5 > r6) goto L28;
        r14.positionStart = r6 + 1;
    L31:
        if (r3 == false) goto L34;
        r10.set(r11, r14);
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r12);
        return;
    L34:
        if (r2 == false) goto L48;
        if (r7 == null) goto L42;
        int r9 = r12.positionStart;
        if (r9 <= r7.positionStart) goto L39;
        r12.positionStart = r9 - r7.itemCount;
    L39:
        int r15 = r12.itemCount;
        if (r15 <= r7.positionStart) goto L42;
        r12.itemCount = r15 - r7.itemCount;
    L42:
        int r16 = r12.positionStart;
        if (r16 <= r14.positionStart) goto L45;
        r12.positionStart = r16 - r14.itemCount;
    L45:
        int r17 = r12.itemCount;
        if (r17 <= r14.positionStart) goto L61;
        r12.itemCount = r17 - r14.itemCount;
    L61:
        r10.set(r11, r14);
        if (r12.positionStart == r12.itemCount) goto L64;
        r10.set(r13, r12);
    L65:
        if (r7 == null) goto L69;
        r10.add(r11, r7);
        return;
    L69:
        return;
    L64:
        r10.remove(r13);
        goto L65
    L48:
        if (r7 == null) goto L55;
        int r18 = r12.positionStart;
        if (r18 < r7.positionStart) goto L52;
        r12.positionStart = r18 - r7.itemCount;
    L52:
        int r19 = r12.itemCount;
        if (r19 < r7.positionStart) goto L55;
        r12.itemCount = r19 - r7.itemCount;
    L55:
        int r20 = r12.positionStart;
        if (r20 < r14.positionStart) goto L58;
        r12.positionStart = r20 - r14.itemCount;
    L58:
        int r21 = r12.itemCount;
        if (r21 < r14.positionStart) goto L61;
        r12.itemCount = r21 - r14.itemCount;
        goto L61
    L28:
        int r8 = r14.itemCount;
        if (r5 >= (r6 + r8)) goto L31;
        r7 = this.mCallback.obtainUpdateOp(2, r5 + 1, (r6 + r8) - r5, null);
        r14.itemCount = r12.positionStart - r14.positionStart;
        goto L31
    L19:
        int r22 = r14.itemCount;
        if (r1 >= (r4 + r22)) goto L25;
        r14.itemCount = r22 - 1;
        r12.cmd = 2;
        r12.itemCount = 1;
        if (r14.itemCount != 0) goto L68;
        r10.remove(r13);
        this.mCallback.recycleUpdateOp(r14);
        return;
    L68:
        return;
    L7:
        if (r14.itemCount != (r1 - r0)) goto L9;
        r2 = false;
        r3 = true;
        goto L16
    L11:
        if (r14.positionStart == (r1 + 1)) goto L13;
    L15:
        r2 = true;
        goto L16
    L13:
        if (r14.itemCount != (r0 - r1)) goto L15;
        r2 = true;
        r3 = true;
        goto L16
    }

    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> r9, int r10, AdapterHelper.UpdateOp r11, int r12, AdapterHelper.UpdateOp r13) {
        int r0 = r11.itemCount;
        int r1 = r13.positionStart;
        AdapterHelper.UpdateOp r4 = null;
        if (r0 >= r1) goto L5;
        r13.positionStart = r1 - 1;
    L8:
        AdapterHelper.UpdateOp r2 = null;
    L9:
        int r3 = r11.positionStart;
        int r5 = r13.positionStart;
        if (r3 > r5) goto L12;
        r13.positionStart = r5 + 1;
    L15:
        r9.set(r12, r11);
        if (r13.itemCount <= 0) goto L18;
        r9.set(r10, r13);
    L19:
        if (r2 == null) goto L21;
        r9.add(r10, r2);
    L21:
        if (r4 == null) goto L24;
        r9.add(r10, r4);
        return;
    L24:
        return;
    L18:
        r9.remove(r10);
        this.mCallback.recycleUpdateOp(r13);
        goto L19
    L12:
        int r6 = r13.itemCount;
        if (r3 >= (r5 + r6)) goto L15;
        int r7 = (r5 + r6) - r3;
        r4 = this.mCallback.obtainUpdateOp(4, r3 + 1, r7, r13.payload);
        r13.itemCount -= r7;
        goto L15
    L5:
        int r8 = r13.itemCount;
        if (r0 >= (r1 + r8)) goto L8;
        r13.itemCount = r8 - 1;
        r2 = this.mCallback.obtainUpdateOp(4, r11.positionStart, 1, r13.payload);
        goto L9
    }
}
