package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";

    @Nullable
    private final DocumentFile mParent;

    DocumentFile(@Nullable DocumentFile r1) {
        this.mParent = r1;
    }

    @NonNull
    public static DocumentFile fromFile(@NonNull File r2) {
        return new RawDocumentFile(null, r2);
    }

    @Nullable
    public static DocumentFile fromSingleUri(@NonNull Context r3, @NonNull Uri r4) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return new SingleDocumentFile(null, r3, r4);
    }

    @Nullable
    public static DocumentFile fromTreeUri(@NonNull Context r3, @NonNull Uri r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return new TreeDocumentFile(null, r3, DocumentsContract.buildDocumentUriUsingTree(r4, DocumentsContract.getTreeDocumentId(r4)));
    }

    public static boolean isDocumentUri(@NonNull Context r2, @Nullable Uri r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContract.isDocumentUri(r2, r3);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @Nullable
    public abstract DocumentFile createDirectory(@NonNull String r1);

    @Nullable
    public abstract DocumentFile createFile(@NonNull String r1, @NonNull String r2);

    public abstract boolean delete();

    public abstract boolean exists();

    @Nullable
    public DocumentFile findFile(@NonNull String r5) {
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

    @Nullable
    public abstract String getName();

    @Nullable
    public DocumentFile getParentFile() {
        return this.mParent;
    }

    @Nullable
    public abstract String getType();

    @NonNull
    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    @NonNull
    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(@NonNull String r1);
}
