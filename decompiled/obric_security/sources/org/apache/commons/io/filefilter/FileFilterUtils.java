package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class FileFilterUtils {
    private static IOFileFilter cvsFilter;
    private static IOFileFilter svnFilter;

    public FileFilterUtils() {
    }

    public static IOFileFilter prefixFileFilter(String r1) {
        return new PrefixFileFilter(r1);
    }

    public static IOFileFilter suffixFileFilter(String r1) {
        return new SuffixFileFilter(r1);
    }

    public static IOFileFilter nameFileFilter(String r1) {
        return new NameFileFilter(r1);
    }

    public static IOFileFilter directoryFileFilter() {
        return DirectoryFileFilter.DIRECTORY;
    }

    public static IOFileFilter fileFileFilter() {
        return FileFileFilter.FILE;
    }

    public static IOFileFilter andFileFilter(IOFileFilter r1, IOFileFilter r2) {
        return new AndFileFilter(r1, r2);
    }

    public static IOFileFilter orFileFilter(IOFileFilter r1, IOFileFilter r2) {
        return new OrFileFilter(r1, r2);
    }

    public static IOFileFilter notFileFilter(IOFileFilter r1) {
        return new NotFileFilter(r1);
    }

    public static IOFileFilter trueFileFilter() {
        return TrueFileFilter.TRUE;
    }

    public static IOFileFilter falseFileFilter() {
        return FalseFileFilter.FALSE;
    }

    public static IOFileFilter asFileFilter(FileFilter r1) {
        return new DelegateFileFilter(r1);
    }

    public static IOFileFilter asFileFilter(FilenameFilter r1) {
        return new DelegateFileFilter(r1);
    }

    public static IOFileFilter ageFileFilter(long r1) {
        return new AgeFileFilter(r1);
    }

    public static IOFileFilter ageFileFilter(long r1, boolean r3) {
        return new AgeFileFilter(r1, r3);
    }

    public static IOFileFilter ageFileFilter(Date r1) {
        return new AgeFileFilter(r1);
    }

    public static IOFileFilter ageFileFilter(Date r1, boolean r2) {
        return new AgeFileFilter(r1, r2);
    }

    public static IOFileFilter ageFileFilter(File r1) {
        return new AgeFileFilter(r1);
    }

    public static IOFileFilter ageFileFilter(File r1, boolean r2) {
        return new AgeFileFilter(r1, r2);
    }

    public static IOFileFilter sizeFileFilter(long r1) {
        return new SizeFileFilter(r1);
    }

    public static IOFileFilter sizeFileFilter(long r1, boolean r3) {
        return new SizeFileFilter(r1, r3);
    }

    public static IOFileFilter sizeRangeFileFilter(long r3, long r5) {
        return new AndFileFilter(new SizeFileFilter(r3, true), new SizeFileFilter(r5 + 1, false));
    }

    public static IOFileFilter makeCVSAware(IOFileFilter r2) {
        if (cvsFilter != null) goto L5;
        cvsFilter = notFileFilter(andFileFilter(directoryFileFilter(), nameFileFilter("CVS")));
    L5:
        if (r2 != null) goto L9;
        return cvsFilter;
    L9:
        return andFileFilter(r2, cvsFilter);
    }

    public static IOFileFilter makeSVNAware(IOFileFilter r2) {
        if (svnFilter != null) goto L5;
        svnFilter = notFileFilter(andFileFilter(directoryFileFilter(), nameFileFilter(".svn")));
    L5:
        if (r2 != null) goto L9;
        return svnFilter;
    L9:
        return andFileFilter(r2, svnFilter);
    }

    public static IOFileFilter makeDirectoryOnly(IOFileFilter r2) {
        if (r2 != null) goto L6;
        return DirectoryFileFilter.DIRECTORY;
    L6:
        return new AndFileFilter(DirectoryFileFilter.DIRECTORY, r2);
    }

    public static IOFileFilter makeFileOnly(IOFileFilter r2) {
        if (r2 != null) goto L6;
        return FileFileFilter.FILE;
    L6:
        return new AndFileFilter(FileFileFilter.FILE, r2);
    }
}
