package android.provider.saf;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile r1) {
        this.mParent = r1;
    }

    public static DocumentFile fromFile(File r2) {
        return new RawDocumentFile(null, r2);
    }

    public static DocumentFile fromSingleUri(Context r2, Uri r3) {
        return new SingleDocumentFile(null, r2, r3);
    }

    public static DocumentFile fromTreeUri(Context r2, Uri r3) {
        return new TreeDocumentFile(null, r2, DocumentsContract.buildDocumentUriUsingTree(r3, DocumentsContract.getTreeDocumentId(r3)));
    }

    public static boolean isDocumentUri(Context r0, Uri r1) {
        return DocumentsContractApi19.isDocumentUri(r0, r1);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String r1);

    public abstract DocumentFile createFile(String r1, String r2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String r5) {
        DocumentFile[] r4 = listFiles();
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        DocumentFile r2 = r4[r1];
        if (r5.equals(r2.getName()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String r1);
}
