package tmsdkobf;

import android.database.Cursor;
import android.database.CursorWrapper;

/* JADX INFO: loaded from: classes5.dex */
public class xc extends CursorWrapper {
    public xc(Cursor r1) {
        super(r1);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
