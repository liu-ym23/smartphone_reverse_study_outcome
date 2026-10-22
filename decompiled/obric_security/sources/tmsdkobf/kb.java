package tmsdkobf;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
final class kb implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f304a;
    private ContentProvider b;
    private String c;
    private String d;

    public kb(long r1, ContentProvider r3, String r4) {
        this.f304a = r1;
        this.c = r4;
        this.d = "content://" + r4;
        this.b = r3;
    }

    @Override // tmsdkobf.o3
    public ContentProviderResult[] a(ArrayList r4) {
        r8.c("RawDBService", "applyBatch|caller=" + this.f304a + "|authority=" + this.c);
        return this.b.applyBatch(r4);
    L5:
        e = move-exception;
        a(e, 7);
        return null;
    }

    @Override // tmsdkobf.o3
    public Uri b(String r3) {
        return Uri.parse("content://" + this.c + "/update?" + r3);
    }

    @Override // tmsdkobf.o3
    public Uri c(String r3) {
        return Uri.parse("content://" + this.c + "/insert?" + r3);
    }

    @Override // tmsdkobf.o3
    public void close() {
    }

    @Override // tmsdkobf.o3
    public Uri d(String r3) {
        return Uri.parse("content://" + this.c + "/delete?" + r3);
    }

    @Override // tmsdkobf.o3
    public Cursor e(String r7) {
        r8.a("RawDBService", "query|caller=" + this.f304a + "|authority=" + this.c + "|sql=" + r7);
        Cursor r6 = this.b.query(Uri.parse(this.d + "/rawquery_1-?" + Uri.encode(r7)), null, null, null, null);     // Catch: Exception -> L5
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        return new xc(r6);
    L5:
        e = move-exception;
        a(e, 1);
        r6 = null;
        goto L7
    }

    @Override // tmsdkobf.o3
    public int a(String r4, String r5, String[] r6) {
        r8.a("RawDBService", "delete|caller=" + this.f304a + "|authority=" + this.c + "|table=" + r4);
        return this.b.delete(Uri.parse(this.d + "/delete?" + r4), r5, r6);
    L5:
        e = move-exception;
        a(e, 3);
        return 0;
    }

    @Override // tmsdkobf.o3
    public void a(String r4) {
        r8.a("RawDBService", "execSQL|caller=" + this.f304a + "|authority=" + this.c + "|sql=" + r4);
        this.b.delete(Uri.parse(this.d + "/execSQL?" + Uri.encode(r4)), null, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a(e, 6);
    }

    private void a(Exception r1, int r2) {
        r8.b("RawDBService", r1.getMessage());
    }

    @Override // tmsdkobf.o3
    public long a(String r4, ContentValues r5) {
        r8.a("RawDBService", "insert|caller=" + this.f304a + "|authority=" + this.c + "|table=" + r4);
        Uri r6 = this.b.insert(Uri.parse(this.d + "/insert?" + r4), r5);     // Catch: Exception -> L7
        if (r6 == null) goto L9;
        return Long.parseLong(r6.getQuery());
    L9:
        return -1;
    L7:
        e = move-exception;
        a(e, 2);
        goto L9
    }

    @Override // tmsdkobf.o3
    public Cursor a(String r7, String[] r8, String r9, String[] r10, String r11) {
        r8.a("RawDBService", "query|caller=" + this.f304a + "|authority=" + this.c + "|table=" + r7);
        Cursor r6 = this.b.query(Uri.parse(this.d + "/query_1-?" + r7), r8, r9, r10, r11);     // Catch: Exception -> L5
    L7:
        if (r6 != null) goto L9;
        return null;
    L9:
        return new xc(r6);
    L5:
        e = move-exception;
        a(e, 1);
        r6 = null;
        goto L7
    }
}
