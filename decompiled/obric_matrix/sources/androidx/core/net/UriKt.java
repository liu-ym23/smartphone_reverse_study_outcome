package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UriKt {
    public static final File toFile(Uri r2) {
        o.f(r2, "<this>");
        if (o.a(r2.getScheme(), "file") == false) goto L11;
        String r0 = r2.getPath();
        if (r0 == null) goto L9;
        return new File(r0);
    L9:
        throw new IllegalArgumentException(("Uri path is null: " + r2).toString());
    L11:
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + r2).toString());
    }

    public static final Uri toUri(File r1) {
        o.f(r1, "<this>");
        Uri r2 = Uri.fromFile(r1);
        o.e(r2, "fromFile(this)");
        return r2;
    }

    public static final Uri toUri(String r1) {
        o.f(r1, "<this>");
        Uri r2 = Uri.parse(r1);
        o.e(r2, "parse(this)");
        return r2;
    }
}
