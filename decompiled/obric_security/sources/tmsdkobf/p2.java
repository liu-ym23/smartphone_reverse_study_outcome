package tmsdkobf;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f405a;

    public p2() {
        this.f405a = ((me) qd.a(9)).a("QQSecureProvider");
        a();
    }

    private void a() {
        q8.a("CompressPhotoDBCreator", "createTable,sql=CREATE TABLE IF NOT EXISTS compress_photo_db (image_path TEXT UNIQUE )");
        this.f405a.a("CREATE TABLE IF NOT EXISTS compress_photo_db (image_path TEXT UNIQUE )");
    }

    public void b() {
        this.f405a.a("compress_photo_db", null, null);
        this.f405a.close();
    }

    public HashSet c() {
        HashSet r0 = new HashSet();
        Cursor r1 = this.f405a.e("SELECT *  FROM compress_photo_db");
        if (r1 != null) goto L23;
    L17:
        if (r1 != null) goto L25;
    L19:
        this.f405a.close();
        return r0;
    L25:
        r1.close();     // Catch: Exception -> L21
        goto L19
    L23:
        int r2 = r1.getColumnIndex("image_path");     // Catch: Throwable -> L9
    L6:
        if (r1.moveToNext() == false) goto L17;
        r0.add(r1.getString(r2));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        q8.b("compressList", "exception occurs! ", th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r1.close();     // Catch: Exception -> L22
    L15:
        this.f405a.close();
        throw th;
    }

    public int d() {
        Cursor r0 = this.f405a.e("SELECT COUNT(*) FROM compress_photo_db");
        int r1 = 0;
        if (r0 != null) goto L25;
    L14:
        if (r0 != null) goto L23;
    L16:
        this.f405a.close();
        return r1;
    L23:
        r0.close();     // Catch: Exception -> L18
        goto L16
    L25:
    L8:
        th = move-exception;
        r0.close();     // Catch: Exception -> L19
    L10:
        this.f405a.close();
        throw th;
    L5:
        if (r0.moveToNext() == false) goto L14;
        r1 = r0.getInt(0);     // Catch: Throwable -> L8 Exception -> L20
        goto L23
    }

    public void a(Set r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.size() == 0) goto L19;
        int r0 = d();
        Iterator r1 = r7.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        q8.a("CompressPhotoProcessor", "save compress path=" + ((String) r1.next()));
        goto L8
    L10:
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        String r3 = (String) r8.next();
        ContentValues r4 = new ContentValues();
        r4.put("image_path", r3);
        r2.add(ContentProviderOperation.newInsert(this.f405a.c("compress_photo_db")).withValues(r4).build());
        goto L12
    L14:
        this.f405a.a(r2);
        this.f405a.close();
        q8.a("CompressPhotoProcessor", "save compress list, add = " + (d() - r0));
        return;
    }
}
