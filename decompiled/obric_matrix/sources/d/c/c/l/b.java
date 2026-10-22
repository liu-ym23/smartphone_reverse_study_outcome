package d.c.c.l;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public interface a {
        void a(String r1, String r2);
    }

    void a(d.c.c.l.a r1);

    Bitmap b(InputStream r1, Rect r2, BitmapFactory.Options r3);

    void c(a r1);

    Bitmap d(FileDescriptor r1, Rect r2, BitmapFactory.Options r3);
}
