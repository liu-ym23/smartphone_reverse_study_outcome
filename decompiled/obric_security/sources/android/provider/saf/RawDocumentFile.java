package android.provider.saf;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes.dex */
class RawDocumentFile extends DocumentFile {
    private File mFile;

    RawDocumentFile(DocumentFile r1, File r2) {
        super(r1);
        this.mFile = r2;
    }

    private static boolean deleteContents(File r6) {
        File[] r7 = r6.listFiles();
        boolean r0 = true;
        if (r7 == null) goto L13;
        int r1 = r7.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L13;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L10;
        r0 = r0 & deleteContents(r4);
    L10:
        if (r4.delete() == true) goto L12;
        q8.e("DocumentFile", "Failed to delete " + r4);
        r0 = false;
    L12:
        r3 = r3 + 1;
    L13:
        return r0;
    }

    private static String getTypeForName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 < 0) goto L7;
        String r2 = r1.substring(r0 + 1).toLowerCase();
        String r3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.provider.saf.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // android.provider.saf.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile createDirectory(String r3) {
        File r0 = new File(this.mFile, r3);
        if (r0.isDirectory() == true) goto L10;
        if (r0.mkdir() == true) goto L10;
        return null;
    L10:
        return new RawDocumentFile(this, r0);
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile createFile(String r2, String r3) {
        String r4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r2);
        if (r4 == null) goto L5;
        r3 = r3 + LibrarianImpl.Constants.DOT + r4;
    L5:
        File r5 = new File(this.mFile, r3);
        r5.createNewFile();     // Catch: IOException -> L8
        return new RawDocumentFile(this, r5);
    L8:
        e = move-exception;
        q8.e("DocumentFile", "Failed to createFile: " + e);
        return null;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // android.provider.saf.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // android.provider.saf.DocumentFile
    public String getName() {
        return this.mFile.getName();
    }

    @Override // android.provider.saf.DocumentFile
    public String getType() {
        if (this.mFile.isDirectory() == false) goto L7;
        return null;
    L7:
        return getTypeForName(this.mFile.getName());
    }

    @Override // android.provider.saf.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // android.provider.saf.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // android.provider.saf.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList r0 = new ArrayList();
        File[] r1 = this.mFile.listFiles();
        if (r1 == null) goto L8;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L8;
        r0.add(new RawDocumentFile(this, r1[r3]));
        r3 = r3 + 1;
    L8:
        return (DocumentFile[]) r0.toArray(new DocumentFile[r0.size()]);
    }

    @Override // android.provider.saf.DocumentFile
    public boolean renameTo(String r3) {
        File r0 = new File(this.mFile.getParentFile(), r3);
        if (this.mFile.renameTo(r0) == false) goto L6;
        this.mFile = r0;
        return true;
    L6:
        return false;
    }
}
