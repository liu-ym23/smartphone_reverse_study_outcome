package com.bytedance.librarian;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {
    private static final ArrayList<LibrarianUnsatisfiedLinkError> sErrors = null;

    static {
        sErrors = new ArrayList();
    }

    LibrarianUnsatisfiedLinkError(String r1) {
        super(r1);
        ArrayList<LibrarianUnsatisfiedLinkError> r2 = sErrors;
        monitor-enter(r2);
        r2.add(this);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    LibrarianUnsatisfiedLinkError(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
        ArrayList<LibrarianUnsatisfiedLinkError> r3 = sErrors;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] getErrors() {
        ArrayList<LibrarianUnsatisfiedLinkError> r0 = sErrors;
        monitor-enter(r0);
        UnsatisfiedLinkError[] r1 = (UnsatisfiedLinkError[]) r0.toArray(new UnsatisfiedLinkError[0]);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }
}
