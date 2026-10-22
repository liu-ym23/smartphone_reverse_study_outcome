package tmsdk.fg.module.spacemanager.impl.duplicatefile;

/* JADX INFO: loaded from: classes5.dex */
public class DuplicateFileInfo {
    public String checksum;
    public int depth;
    public long fileSize;
    public String fullPath;
    public boolean isOriginal;

    public DuplicateFileInfo() {
    }

    public DuplicateFileInfo(String r1, long r2, int r4, boolean r5, String r6) {
        this.fullPath = r1;
        this.fileSize = r2;
        this.depth = r4;
        this.isOriginal = r5;
        this.checksum = r6;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public int getDepth() {
        return this.depth;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public void setChecksum(String r1) {
        this.checksum = r1;
    }

    public void setDepth(int r1) {
        this.depth = r1;
    }

    public void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public void setFullPath(String r1) {
        this.fullPath = r1;
    }

    public void setOriginal(boolean r1) {
        this.isOriginal = r1;
    }

    public String toString() {
        return "DuplicateFileInfo{fullPath='" + this.fullPath + "', fileSize=" + this.fileSize + ", depth=" + this.depth + ", isOriginal=" + this.isOriginal + ", checksum='" + this.checksum + "'}";
    }
}
