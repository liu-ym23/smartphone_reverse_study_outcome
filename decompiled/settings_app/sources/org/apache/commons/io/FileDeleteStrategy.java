package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class FileDeleteStrategy {
    public static final FileDeleteStrategy FORCE = null;
    public static final FileDeleteStrategy NORMAL = null;
    private final String name;

    static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        ForceFileDeleteStrategy() {
            super("Force");
        }

        @Override // org.apache.commons.io.FileDeleteStrategy
        protected boolean doDelete(File r1) throws IOException {
            FileUtils.forceDelete(r1);
            return true;
        }
    }

    static {
        NORMAL = new FileDeleteStrategy("Normal");
        FORCE = new ForceFileDeleteStrategy();
    }

    protected FileDeleteStrategy(String r1) {
        this.name = r1;
    }

    public boolean deleteQuietly(File r2) {
        if (r2 != null) goto L4;
        return true;
    L4:
        if (r2.exists() == false) goto L14;
        return doDelete(r2);
    L8:
        return false;
    L14:
        return true;
    }

    public void delete(File r3) throws IOException {
        if (r3.exists() == true) goto L5;
        return;
    L5:
        if (doDelete(r3) == false) goto L8;
        return;
    L8:
        throw new IOException(new StringBuffer("Deletion failed: ").append(r3).toString());
    }

    protected boolean doDelete(File r1) throws IOException {
        return r1.delete();
    }

    public String toString() {
        return new StringBuffer("FileDeleteStrategy[").append(this.name).append("]").toString();
    }
}
