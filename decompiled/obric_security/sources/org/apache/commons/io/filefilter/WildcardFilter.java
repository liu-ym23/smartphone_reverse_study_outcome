package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes5.dex */
public class WildcardFilter extends AbstractFileFilter {
    private String[] wildcards;

    public WildcardFilter(String r3) {
        if (r3 == null) goto L7;
        this.wildcards = new String[]{r3};
        return;
    L7:
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public WildcardFilter(String[] r1) {
        if (r1 == null) goto L7;
        this.wildcards = r1;
        return;
    L7:
        throw new IllegalArgumentException("The wildcard array must not be null");
    }

    public WildcardFilter(List r2) {
        if (r2 == null) goto L7;
        this.wildcards = (String[]) r2.toArray(new String[r2.size()]);
        return;
    L7:
        throw new IllegalArgumentException("The wildcard list must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r4, String r5) {
        if (r4 != null) goto L5;
    L7:
        int r6 = 0;
    L8:
        String[] r1 = this.wildcards;
        if (r6 >= r1.length) goto L15;
        if (FilenameUtils.wildcardMatch(r5, r1[r6]) == true) goto L12;
        r6 = r6 + 1;
        goto L8
    L12:
        return true;
    L15:
        return false;
    L5:
        if (new File(r4, r5).isDirectory() == false) goto L7;
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (r5.isDirectory() == false) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.wildcards.length) goto L13;
        if (FilenameUtils.wildcardMatch(r5.getName(), this.wildcards[r0]) == true) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }
}
