package d.b.s.a;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface i {
    @Nullable
    default List<String> a() {
        return null;
    }

    com.ss.android.h b(int r1, String r2, List<com.ss.android.f> r3, int r4);

    @Nullable
    default List<String> c() {
        return null;
    }

    com.ss.android.h d(int r1, String r2, Map<String, String> r3, String r4, String r5, List<com.ss.android.f> r6);

    com.ss.android.h e(int r1, String r2, Map<String, String> r3, List<com.ss.android.f> r4, int r5);

    int f(Context r1, Throwable r2);
}
