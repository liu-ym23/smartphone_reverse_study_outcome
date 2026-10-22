package com.bytedance.lighten.loader;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class FrescoImageLoaderDelegate implements d.b.k.a.o {
    private d.b.k.a.c mFrescoCache;
    private d.b.k.a.i mImpl;

    public FrescoImageLoaderDelegate() {
    }

    @Override // d.b.k.a.i
    public void display(d.b.k.a.s r1) {
        this.mImpl.display(r1);
    }

    @Override // d.b.k.a.i
    public void download(d.b.k.a.s r1) {
        this.mImpl.download(r1);
    }

    public d.b.k.a.c getCache() {
        return this.mFrescoCache;
    }

    @Override // d.b.k.a.o
    public void init(@NonNull d.b.k.a.r r3) {
        d.b.k.a.h.b(r3.c());
        if (r3.o() == false) goto L5;
        d.c.i.g.h r0 = s.m(r3);
        d.c.f.a.a.c.d(r3.c(), r0);
        r.a().b(r0);
        d.c.c.e.a.q(r3.e());
    L5:
        k r4 = new k();
        this.mFrescoCache = r4;
        this.mImpl = new o(r4);
    }

    @Override // d.b.k.a.o
    public d.b.k.a.t load(int r2) {
        return new d.b.k.a.t(Uri.parse("res://" + d.b.k.a.q.f14022d + "/" + r2));
    }

    @Override // d.b.k.a.o
    public d.b.k.a.t load(@NonNull Uri r1) {
        return new d.b.k.a.t(r1);
    }

    public d.b.k.a.t load(@NonNull d.b.k.a.w.a r1) {
        return new d.b.k.a.t(r1);
    }

    public d.b.k.a.t load(@NonNull File r1) {
        return new d.b.k.a.t(Uri.fromFile(r1));
    }

    public d.b.k.a.t load(@Nullable Object r1) {
        return new d.b.k.a.t(r1);
    }

    public d.b.k.a.t load(@NonNull String r1) {
        return new d.b.k.a.t(r1);
    }

    @Override // d.b.k.a.i
    public void loadBitmap(d.b.k.a.s r1) {
        this.mImpl.loadBitmap(r1);
    }

    @Override // d.b.k.a.i
    public void trimDisk(int r1) {
        this.mImpl.trimDisk(r1);
    }

    @Override // d.b.k.a.i
    public void trimMemory(int r1) {
        this.mImpl.trimMemory(r1);
    }
}
