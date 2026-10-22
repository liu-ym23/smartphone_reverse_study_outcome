package android.provider.saf;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.util.ArrayList;
import java.util.HashMap;
import tmsdk.common.tcc.QFile;
import tmsdkobf.dc;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes.dex */
public class TreeDocumentFile extends DocumentFile {
    static long mTime1;
    static long mTime2;
    private Context mContext;
    public String mDocId;
    private String mMimeType;
    protected long mModifyTime;
    protected String mName;
    protected long mSize;
    protected int mType;
    private Uri mUri;

    static {
    }

    public TreeDocumentFile(DocumentFile r3, Context r4, Uri r5) {
        super(r3);
        this.mType = 0;
        this.mSize = -1;
        this.mModifyTime = -1;
        this.mContext = r4;
        this.mUri = r5;
    }

    private static void closeQuietly(AutoCloseable r0) {
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

    private static Uri createFile(Context r0, Uri r1, String r2, String r3) {
        return DocumentsContract.createDocument(r0.getContentResolver(), r1, r2, r3);
    L4:
        return null;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile createDirectory(String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }

    @Override // android.provider.saf.DocumentFile
    public boolean delete() {
        return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
    L4:
        return false;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public String getName() {
        if (this.mName != null) goto L6;
        this.mName = DocumentsContractApi19.getName(this.mContext, this.mUri);
    L6:
        return this.mName;
    }

    @Override // android.provider.saf.DocumentFile
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isDirectory() {
        if (this.mType != 0) goto L9;
        if ("vnd.android.document/directory".equals(this.mMimeType) == false) goto L7;
        this.mType = 4;
        goto L9
    L7:
        this.mType = 1;
    L9:
        if (this.mType == 4) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // android.provider.saf.DocumentFile
    public long lastModified() {
        if (this.mModifyTime != (-1)) goto L8;
        QFile r0 = dc.a(this.mDocId);
        if (r0 == null) goto L8;
        r0.fillExtraInfo();
        this.mSize = r0.size;
        this.mModifyTime = r0.modifyTime;
        this.mType = r0.type;
    L8:
        if (this.mModifyTime != (-1)) goto L11;
        this.mModifyTime = DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    L11:
        return this.mModifyTime;
    }

    @Override // android.provider.saf.DocumentFile
    public long length() {
        q8.c("DocumentFile", "length:" + this.mDocId + "," + this.mUri.toString());
        if (this.mType != 4) goto L7;
        return 4096;
    L7:
        if (this.mSize != (-1)) goto L12;
        QFile r0 = dc.a(this.mDocId);
        if (r0 == null) goto L12;
        r0.fillExtraInfo();
        this.mSize = r0.size;
        this.mModifyTime = r0.modifyTime;
        this.mType = r0.type;
    L12:
        if (this.mSize != (-1)) goto L15;
        this.mSize = DocumentsContractApi19.length(this.mContext, this.mUri);
    L15:
        return this.mSize;
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile[] listFiles() {
        long r0 = System.currentTimeMillis();
        ContentResolver r3 = this.mContext.getContentResolver();
        Uri r2 = this.mUri;
        Uri r4 = DocumentsContract.buildChildDocumentsUriUsingTree(r2, DocumentsContract.getDocumentId(r2));
        ArrayList r5 = new ArrayList();
        HashMap r9 = new HashMap();
        HashMap r10 = new HashMap();
        HashMap r11 = new HashMap();
        int r12 = 0;
        Cursor r13 = null;
        r13 = r3.query(r4, new String[]{"document_id", "mime_type", "_display_name"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        mTime1 += System.currentTimeMillis() - r0;     // Catch: Throwable -> L8 Exception -> L10
    L5:
        if (r13.moveToNext() == false) goto L12;
        String r6 = r13.getString(0);     // Catch: Throwable -> L8 Exception -> L10
        Uri r7 = DocumentsContract.buildDocumentUriUsingTree(this.mUri, r6);     // Catch: Throwable -> L8 Exception -> L10
        r5.add(r7);     // Catch: Throwable -> L8 Exception -> L10
        r9.put(r7, r13.getString(1));     // Catch: Throwable -> L8 Exception -> L10
        r11.put(r7, r13.getString(2));     // Catch: Throwable -> L8 Exception -> L10
        r10.put(r7, r6);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        closeQuietly(r13);
        Uri[] r8 = (Uri[]) r5.toArray(new Uri[r5.size()]);
        DocumentFile[] r14 = new DocumentFile[r8.length];
    L14:
        if (r12 >= r8.length) goto L16;
        Context r15 = this.mContext;
        Uri r16 = r8[r12];
        TreeDocumentFile r17 = new TreeDocumentFile(this, r15, r16, (String) r9.get(r16));
        r14[r12] = r17;
        r17.mDocId = (String) r10.get(r8[r12]);
        ((TreeDocumentFile) r14[r12]).mName = (String) r11.get(r8[r12]);
        r12 = r12 + 1;
        goto L14
    L16:
        mTime2 += System.currentTimeMillis() - r0;
        return r14;
    L10:
        e = move-exception;
        q8.e("DocumentFile", "Failed query: " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        closeQuietly(r13);
        throw th;
    }

    @Override // android.provider.saf.DocumentFile
    public boolean renameTo(String r4) {
        Uri r5 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r4);     // Catch: Exception -> L9
        if (r5 == null) goto L8;
        this.mUri = r5;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }

    public TreeDocumentFile(DocumentFile r3, Context r4, Uri r5, String r6) {
        super(r3);
        this.mType = 0;
        this.mSize = -1;
        this.mModifyTime = -1;
        this.mContext = r4;
        this.mUri = r5;
        this.mMimeType = r6;
    }

    @Override // android.provider.saf.DocumentFile
    public DocumentFile createFile(String r3, String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, r3, r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }
}
