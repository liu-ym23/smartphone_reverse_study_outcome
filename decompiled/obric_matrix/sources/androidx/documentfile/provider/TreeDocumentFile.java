package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(@Nullable DocumentFile r1, Context r2, Uri r3) {
        super(r1);
        this.mContext = r2;
        this.mUri = r3;
    }

    private static void closeQuietly(@Nullable AutoCloseable r0) {
        if (r0 != null) goto L9;
        return;
    L9:
        r0.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    @Nullable
    private static Uri createFile(Context r0, Uri r1, String r2, String r3) {
        return DocumentsContract.createDocument(r0.getContentResolver(), r1, r2, r3);
    L4:
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createDirectory(String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String r3, String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, r3, r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
    L4:
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ContentResolver r1 = this.mContext.getContentResolver();
        Uri r0 = this.mUri;
        Uri r2 = DocumentsContract.buildChildDocumentsUriUsingTree(r0, DocumentsContract.getDocumentId(r0));
        ArrayList r3 = new ArrayList();
        int r7 = 0;
        Cursor r8 = null;
        r8 = r1.query(r2, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r8.moveToNext() == false) goto L8;
        r3.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, r8.getString(0)));     // Catch: Throwable -> L9 Exception -> L11
    L8:
        closeQuietly(r8);
        Uri[] r4 = (Uri[]) r3.toArray(new Uri[r3.size()]);
        DocumentFile[] r5 = new DocumentFile[r4.length];
    L16:
        if (r7 >= r4.length) goto L18;
        r5[r7] = new TreeDocumentFile(this, this.mContext, r4[r7]);
        r7 = r7 + 1;
        goto L16
    L18:
        return r5;
    L11:
        e = move-exception;
        Log.w("DocumentFile", "Failed query: " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        closeQuietly(r8);
        throw th;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r4) {
        Uri r5 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r4);     // Catch: Exception -> L9
        if (r5 == null) goto L8;
        this.mUri = r5;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }
}
