package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f10902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f10903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<a> f10904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10905e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f10906a;
    }

    i() {
        this.f10902b = null;
        this.f10903c = null;
        this.f10904d = new LinkedList();
        this.f10905e = false;
        this.f10901a = false;
    }

    void a(i r3) {
        Drawable r0 = this.f10903c;
        if (r0 == null) goto L5;
        r3.i(r0);
    L5:
        Drawable r1 = this.f10902b;
        if (r1 == null) goto L8;
        r3.h(r1);
    L8:
        r3.f10904d.addAll(this.f10904d);
        r3.f10901a |= this.f10901a;
        r3.f10905e = this.f10905e;
    }

    public boolean b() {
        return this.f10905e;
    }

    Drawable c() {
        return this.f10902b;
    }

    Drawable d() {
        return this.f10903c;
    }

    List<a> e() {
        return Collections.unmodifiableList(this.f10904d);
    }

    boolean f() {
        return this.f10901a;
    }

    void g() {
        this.f10902b = null;
        this.f10903c = null;
        this.f10904d.clear();
        this.f10901a = false;
        this.f10905e = false;
    }

    public void h(@NonNull Drawable r1) {
        if (r1 == null) goto L6;
        this.f10902b = r1;
        this.f10901a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void i(@NonNull Drawable r1) {
        if (r1 == null) goto L6;
        this.f10903c = r1;
        this.f10901a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }
}
