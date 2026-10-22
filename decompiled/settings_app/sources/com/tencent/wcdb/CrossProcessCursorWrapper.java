package com.tencent.wcdb;

/* JADX INFO: loaded from: classes5.dex */
public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor r1) {
        super(r1);
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public void fillWindow(int r2, CursorWindow r3) {
        if ((this.mCursor instanceof CrossProcessCursor) == false) goto L6;
        ((CrossProcessCursor) this.mCursor).fillWindow(r2, r3);
        return;
    L6:
        DatabaseUtils.cursorFillWindow(this.mCursor, r2, r3);
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public CursorWindow getWindow() {
        if ((this.mCursor instanceof CrossProcessCursor) == true) goto L5;
        return null;
    L5:
        return ((CrossProcessCursor) this.mCursor).getWindow();
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int r2, int r3) {
        if ((this.mCursor instanceof CrossProcessCursor) == true) goto L5;
        return true;
    L5:
        return ((CrossProcessCursor) this.mCursor).onMove(r2, r3);
    }
}
