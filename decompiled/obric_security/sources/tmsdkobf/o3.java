package tmsdkobf;

import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public interface o3 {
    int a(String r1, String r2, String[] r3);

    long a(String r1, ContentValues r2);

    Cursor a(String r1, String[] r2, String r3, String[] r4, String r5);

    void a(String r1);

    ContentProviderResult[] a(ArrayList r1);

    Uri b(String r1);

    Uri c(String r1);

    void close();

    Uri d(String r1);

    Cursor e(String r1);
}
