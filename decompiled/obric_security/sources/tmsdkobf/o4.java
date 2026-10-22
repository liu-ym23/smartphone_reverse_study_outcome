package tmsdkobf;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f385a;
    private final ContentResolver b;
    private final Uri c;

    public o4(ContentResolver r1, File r2) {
        this.f385a = r2;
        this.b = r1;
        this.c = MediaStore.Files.getContentUri("external");
    }

    public boolean a() {
        if (this.f385a.exists() == true) goto L5;
    L15:
        return true;
    L5:
        if (this.f385a.isDirectory() == true) goto L15;
        if (this.b != null) goto L17;
        return false;
    L17:
        this.b.delete(this.c, "_data=?", new String[]{this.f385a.getAbsolutePath()});     // Catch: Throwable -> L16
        if (this.f385a.exists() == false) goto L14;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L16
        r0.put("_data", this.f385a.getAbsolutePath());     // Catch: Throwable -> L16
        Uri r1 = this.b.insert(this.c, r0);     // Catch: Throwable -> L16
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L16
        r2.put("media_type", 4);     // Catch: Throwable -> L16
        this.b.update(r1, r2, null, null);     // Catch: Throwable -> L16
        this.b.delete(r1, null, null);     // Catch: Throwable -> L16
    L14:
        return !this.f385a.exists();
    }
}
