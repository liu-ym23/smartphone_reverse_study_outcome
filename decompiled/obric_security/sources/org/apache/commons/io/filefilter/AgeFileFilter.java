package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes5.dex */
public class AgeFileFilter extends AbstractFileFilter {
    private boolean acceptOlder;
    private long cutoff;

    public AgeFileFilter(long r2) {
        this(r2, true);
    }

    public AgeFileFilter(long r1, boolean r3) {
        this.acceptOlder = r3;
        this.cutoff = r1;
    }

    public AgeFileFilter(Date r2) {
        this(r2, true);
    }

    public AgeFileFilter(Date r3, boolean r4) {
        this(r3.getTime(), r4);
    }

    public AgeFileFilter(File r2) {
        this(r2, true);
    }

    public AgeFileFilter(File r3, boolean r4) {
        this(r3.lastModified(), r4);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r3) {
        boolean r4 = FileUtils.isFileNewer(r3, this.cutoff);
        if (this.acceptOlder == false) goto L8;
        if (r4 == true) goto L6;
        return true;
    L6:
        return false;
    L8:
        return r4;
    }
}
