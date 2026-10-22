package tmsdk.fg.module.spacemanager.impl.duplicatefile;

/* JADX INFO: loaded from: classes5.dex */
public class DuplicateFileGroup {
    public long fileSize;
    public DuplicateFileInfo[] files;

    public DuplicateFileGroup() {
    }

    public DuplicateFileGroup(long r1, DuplicateFileInfo[] r3) {
        this.fileSize = r1;
        this.files = r3;
    }

    public int getFileCount() {
        DuplicateFileInfo[] r0 = this.files;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public DuplicateFileInfo[] getFiles() {
        return this.files;
    }

    public void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public void setFiles(DuplicateFileInfo[] r1) {
        this.files = r1;
    }

    public String toString() {
        return "DuplicateFileGroup{fileSize=" + this.fileSize + ", fileCount=" + getFileCount() + '}';
    }
}
