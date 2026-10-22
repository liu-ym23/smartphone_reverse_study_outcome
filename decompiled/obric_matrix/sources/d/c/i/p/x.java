package d.c.i.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class x extends a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f16468d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentResolver f16469c;

    static {
        f16468d = new String[]{"_id", "_data"};
    }

    public x(Executor r1, d.c.c.g.i r2, ContentResolver r3) {
        super(r1, r2);
        this.f16469c = r3;
    }

    private d.c.i.l.e g(Uri r7) {
        Cursor r8 = this.f16469c.query(r7, f16468d, null, null, null);
        if (r8 != null) goto L21;
        return null;
    L21:
    L19:
        r8.close();
        return null;
    L16:
        th = move-exception;
        r8.close();
        throw th;
    L6:
        if (r8.getCount() != 0) goto L9;
        r8.close();
        return null;
    L9:
        r8.moveToFirst();     // Catch: Throwable -> L16 FileNotFoundException -> L19
        String r1 = r8.getString(r8.getColumnIndex("_data"));     // Catch: Throwable -> L16 FileNotFoundException -> L19
        if (r1 == null) goto L14;
        d.c.i.l.e r6 = e(new FileInputStream(r1), h(r1));     // Catch: Throwable -> L16 FileNotFoundException -> L19
        r8.close();
        return r6;
    L14:
        r8.close();
        return null;
    }

    private static int h(String r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        return (int) new File(r2).length();
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r5) {
        Uri r6 = r5.v();
        if (d.c.c.k.f.g(r6) == false) goto L21;
        if (r6.toString().endsWith("/photo") == false) goto L8;
        InputStream r7 = this.f16469c.openInputStream(r6);
    L17:
        return e(r7, -1);
    L8:
        if (r6.toString().endsWith("/display_photo") == true) goto L27;
        InputStream r0 = ContactsContract.Contacts.openContactPhotoInputStream(this.f16469c, r6);
        if (r0 == null) goto L19;
        r7 = r0;
        goto L17
    L19:
        throw new IOException("Contact photo does not exist: " + r6);
    L27:
        r7 = this.f16469c.openAssetFileDescriptor(r6, "r").createInputStream();     // Catch: IOException -> L11
    L12:
        throw new IOException("Contact photo does not exist: " + r6);
    L21:
        if (d.c.c.k.f.f(r6) == false) goto L26;
        d.c.i.l.e r1 = g(r6);
        if (r1 == null) goto L26;
        return r1;
    L26:
        return e(this.f16469c.openInputStream(r6), -1);
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "LocalContentUriFetchProducer";
    }
}
