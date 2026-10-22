package com.bytedance.memory.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4997b;

    private static class a implements b {
        a() {
        }

        @Override // com.bytedance.memory.b.c.b
        public void a(@Nullable Throwable r2, @NonNull String r3, @NonNull Object... r4) {
            b(String.format(r3, r4) + '\n' + Log.getStackTraceString(r2), new Object[0]);
        }

        @Override // com.bytedance.memory.b.c.b
        public void b(@NonNull String r3, @NonNull Object... r4) {
            if (e.f4999a == false) goto L5;
        L7:
            String r2 = String.format(r3, r4);
            if (r2.length() >= 4000) goto L10;
            Log.d("memory", r2);
            return;
        L10:
            String[] r5 = r2.split("\n", -1);
            int r6 = r5.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L15;
            Log.d("memory", r5[r7]);
            r7 = r7 + 1;
            goto L11
        L15:
            return;
        L5:
            if (c.a() == true) goto L7;
        }
    }

    public interface b {
        void a(@Nullable Throwable r1, @NonNull String r2, @NonNull Object... r3);

        void b(@NonNull String r1, @NonNull Object... r2);
    }

    static {
        f4996a = new a();
    }

    static /* synthetic */ boolean a() {
        return f4997b;
    }

    public static void b(@Nullable Throwable r1, @NonNull String r2, @NonNull Object... r3) {
        b r0 = f4996a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2, r3);
    }

    public static void c(@NonNull String r1, @NonNull Object... r2) {
        b r0 = f4996a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r1, r2);
    }
}
