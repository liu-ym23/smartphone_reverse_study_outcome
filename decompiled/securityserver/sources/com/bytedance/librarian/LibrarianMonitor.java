package com.bytedance.librarian;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LibrarianMonitor {
    public LibrarianMonitor() {
    }

    public void logDebug(String r1) {
        Log.d(LibrarianImpl.Constants.TAG, r1);
    }

    public void logError(String r1) {
        Log.e(LibrarianImpl.Constants.TAG, r1);
    }

    public void logWarning(String r1) {
        Log.w(LibrarianImpl.Constants.TAG, r1);
    }

    public void systemLoad(String r1) {
        System.load(r1);
    }

    public void systemLoadLibrary(String r1) {
        System.loadLibrary(r1);
    }

    public void logError(String r1, Throwable r2) {
        Log.e(LibrarianImpl.Constants.TAG, r1, r2);
    }

    public void logWarning(String r1, Throwable r2) {
        Log.w(LibrarianImpl.Constants.TAG, r1, r2);
    }
}
