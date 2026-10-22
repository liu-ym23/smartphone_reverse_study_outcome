package com.ss.android.token;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f12306d = "token";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f12307e = "ts_sign";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f12308f = "attest_ts_sign";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f12309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f12310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final String f12311c;

    static {
    }

    public t() {
        this("", "", "");
    }

    public t(@NonNull String r1, @NonNull String r2, @NonNull String r3) {
        this.f12309a = r1;
        this.f12310b = r2;
        this.f12311c = r3;
    }

    public static t c(Cursor r3) {
        if (r3 == null) goto L15;
        if (r3.moveToFirst() == false) goto L15;
        String r0 = r3.getString(r3.getColumnIndexOrThrow(f12306d));
        String r1 = r3.getString(r3.getColumnIndexOrThrow(f12307e));
        String r4 = r3.getString(r3.getColumnIndexOrThrow(f12308f));
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        return new t(r0, r1, r4);
    L15:
        return new t();
    }

    public static t d(Uri r3) {
        if (r3 == null) goto L13;
        String r0 = r3.getQueryParameter(f12306d);
        String r1 = r3.getQueryParameter(f12307e);
        String r4 = r3.getQueryParameter(f12308f);
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        return new t(r0, r1, r4);
    L13:
        return new t();
    }

    public Cursor a() {
        MatrixCursor r0 = new MatrixCursor(new String[]{f12306d, f12307e, f12308f});
        r0.newRow().add(this.f12309a).add(this.f12310b).add(this.f12311c);
        return r0;
    }

    public String b() {
        return "TokenObject{token='" + p.O(this.f12309a) + "', tsSign='" + p.O(this.f12310b) + "', attestTsSign='" + p.O(this.f12311c) + "'}";
    }

    public Map<String, String> e() {
        HashMap r0 = new HashMap();
        r0.put(f12306d, this.f12309a);
        r0.put(f12307e, this.f12310b);
        r0.put(f12308f, this.f12311c);
        return r0;
    }

    public String toString() {
        return "TokenObject{token='" + this.f12309a + "', tsSign='" + this.f12310b + "', attestTsSign='" + this.f12311c + "'}";
    }
}
