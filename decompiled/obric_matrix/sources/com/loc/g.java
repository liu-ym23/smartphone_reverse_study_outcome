package com.loc;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7302a = "9aj&#k81";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7303b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7304c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static byte[] f7305d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f7306e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f7307f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f7308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer f7309h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f7310i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Integer f7311j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Integer f7312k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Integer f7313l = null;

    static {
        f7308g = new ConcurrentHashMap(8);
        f7309h = 1;
        f7310i = 2;
        f7311j = 3;
        f7312k = 4;
        f7313l = 5;
    }

    public static String a(String r3) {
        String r0 = "";
        ConcurrentHashMap<String, String> r1 = f7308g;     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (f7308g != null) goto L8;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (f7308g.containsKey(r3) == false) goto L10;
        r0 = f7308g.get(r3);     // Catch: Throwable -> L12
    L15:
        return r0;
    }

    public static void b(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        ConcurrentHashMap<String, String> r0 = f7308g;     // Catch: Throwable -> L21
        monitor-enter(r0);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (f7308g != null) goto L13;
        f7308g = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (f7308g.containsKey(r3) == true) goto L15;
        f7308g.put(r3, r4);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }

    public static byte[] c() {
        if (f7305d != null) goto L5;
        f7305d = m5.g(f7304c);
    L5:
        byte[] r1 = new byte[4];
        System.arraycopy(f7305d, 40, r1, 0, 4);
        int r0 = ((r1[0] & 255) * 256) + (r1[1] & 255);
        int r2 = ((r1[2] & 255) * 256) + (r1[3] & 255);
        byte[] r3 = new byte[r2];
        System.arraycopy(f7305d, r0, r3, 0, r2);
        return r3;
    }
}
