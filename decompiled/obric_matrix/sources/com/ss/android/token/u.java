package com.ss.android.token;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f12313b;

    public u(Context r1) {
        this.f12312a = r1.getApplicationContext();
    }

    private Uri d(String r2) {
        return e(r2, null);
    }

    private Uri e(String r2, Map<String, String> r3) {
        i();
        Uri.Builder r1 = this.f12313b.buildUpon().appendPath(r2);
        if (r3 == null) goto L11;
        if (r3.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        Map.Entry<String, String> r5 = r4.next();
        r1.appendQueryParameter(r5.getKey(), r5.getValue());
    L11:
        return r1.build();
    }

    private Cursor f(Uri r7) {
        return this.f12312a.getContentResolver().query(r7, null, null, null, null);
    }

    private void i() {
        if (this.f12313b != null) goto L6;
        this.f12313b = Uri.parse("content://" + TokenObjectProvider.a(this.f12312a));
        return;
    }

    private void j(Uri r3) {
        this.f12312a.getContentResolver().update(r3, new ContentValues(), null, null);
    }

    public void a() {
        j(d("clear_last_token"));
    }

    public String b() {
        Cursor r1 = f(d("get_last_same_user_token"));
        if (r1 != null) goto L5;
        return "";
    L5:
        if (r1.moveToFirst() == true) goto L7;
        return "";
    L7:
        return r1.getString(r1.getColumnIndexOrThrow("last_token"));
    }

    public t c() {
        return t.c(f(d("get_token_object")));
    }

    public void g() {
        j(d("save_last_token"));
    }

    public void h(@NonNull t r2) {
        j(e("set_token_object", r2.e()));
    }
}
