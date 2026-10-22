package com.tencent.wcdb;

/* JADX INFO: loaded from: classes5.dex */
public interface CrossProcessCursor extends Cursor {
    void fillWindow(int r1, CursorWindow r2);

    CursorWindow getWindow();

    boolean onMove(int r1, int r2);
}
