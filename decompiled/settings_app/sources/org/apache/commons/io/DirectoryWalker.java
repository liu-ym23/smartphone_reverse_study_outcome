package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DirectoryWalker {
    private final int depthLimit;
    private final FileFilter filter;

    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private int depth;
        private File file;

        public CancelException(File r2, int r3) {
            this("Operation Cancelled", r2, r3);
        }

        public CancelException(String r1, File r2, int r3) {
            super(r1);
            this.file = r2;
            this.depth = r3;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
    }

    protected boolean handleDirectory(File r1, int r2, Collection r3) throws IOException {
        return true;
    }

    protected void handleDirectoryEnd(File r1, int r2, Collection r3) throws IOException {
    }

    protected void handleDirectoryStart(File r1, int r2, Collection r3) throws IOException {
    }

    protected void handleEnd(Collection r1) throws IOException {
    }

    protected void handleFile(File r1, int r2, Collection r3) throws IOException {
    }

    protected boolean handleIsCancelled(File r1, int r2, Collection r3) throws IOException {
        return false;
    }

    protected void handleRestricted(File r1, int r2, Collection r3) throws IOException {
    }

    protected void handleStart(File r1, Collection r2) throws IOException {
    }

    protected DirectoryWalker() {
        this(null, -1);
    }

    protected DirectoryWalker(FileFilter r1, int r2) {
        this.filter = r1;
        this.depthLimit = r2;
    }

    protected DirectoryWalker(IOFileFilter r1, IOFileFilter r2, int r3) {
        if (r1 != null) goto L6;
        if (r2 != null) goto L6;
        this.filter = null;
    L13:
        this.depthLimit = r3;
        return;
    L6:
        if (r1 != null) goto L9;
        r1 = TrueFileFilter.TRUE;
    L9:
        if (r2 != null) goto L12;
        r2 = TrueFileFilter.TRUE;
    L12:
        this.filter = FileFilterUtils.orFileFilter(FileFilterUtils.makeDirectoryOnly(r1), FileFilterUtils.makeFileOnly(r2));
        goto L13
    }

    protected final void walk(File r2, Collection r3) throws IOException {
        if (r2 == null) goto L9;
        handleStart(r2, r3);     // Catch: CancelException -> L5
        walk(r2, 0, r3);     // Catch: CancelException -> L5
        handleEnd(r3);     // Catch: CancelException -> L5
        return;
    L5:
        e = move-exception;
        handleCancelled(r2, r3, e);
        return;
    L9:
        throw new NullPointerException("Start Directory is null");
    }

    private void walk(File r6, int r7, Collection r8) throws IOException {
        checkIfCancelled(r6, r7, r8);
        if (handleDirectory(r6, r7, r8) == false) goto L22;
        handleDirectoryStart(r6, r7, r8);
        int r0 = r7 + 1;
        int r1 = this.depthLimit;
        if (r1 < 0) goto L7;
        if (r0 <= r1) goto L7;
    L21:
        handleDirectoryEnd(r6, r7, r8);
    L7:
        checkIfCancelled(r6, r7, r8);
        FileFilter r2 = this.filter;
        if (r2 != null) goto L10;
        File[] r3 = r6.listFiles();
    L11:
        if (r3 != null) goto L13;
        handleRestricted(r6, r0, r8);
        goto L21
    L13:
        int r4 = 0;
    L15:
        if (r4 >= r3.length) goto L21;
        File r5 = r3[r4];
        if (r5.isDirectory() == false) goto L19;
        walk(r5, r0, r8);
    L20:
        r4 = r4 + 1;
        goto L15
    L19:
        checkIfCancelled(r5, r0, r8);
        handleFile(r5, r0, r8);
        checkIfCancelled(r5, r0, r8);
        goto L20
    L10:
        r3 = r6.listFiles(r2);
    L22:
        checkIfCancelled(r6, r7, r8);
    }

    protected final void checkIfCancelled(File r1, int r2, Collection r3) throws IOException {
        if (handleIsCancelled(r1, r2, r3) == true) goto L6;
        return;
    L6:
        throw new CancelException(r1, r2);
    }

    protected void handleCancelled(File r1, Collection r2, CancelException r3) throws IOException {
        throw r3;
    }
}
