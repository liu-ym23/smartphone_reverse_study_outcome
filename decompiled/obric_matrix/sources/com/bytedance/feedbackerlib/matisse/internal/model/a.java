package com.bytedance.feedbackerlib.matisse.internal.model;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.feedbackerlib.g;
import com.bytedance.feedbackerlib.k.f.a.d;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.b;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedHashSet<Item> f4376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaPlayer f4378d;

    public a(Context r2) {
        this.f4377c = 0;
        this.f4378d = new MediaPlayer();
        this.f4375a = r2;
    }

    private int g() {
        c r0 = c.b();
        int r1 = r0.f4351g;
        if (r1 <= 0) goto L5;
        return r1;
    L5:
        int r3 = this.f4377c;
        if (r3 != 1) goto L10;
        return r0.f4352h;
    L10:
        if (r3 == 2) goto L12;
        return r1;
    L12:
        return r0.f4353i;
    }

    private void o() {
        Iterator<Item> r0 = this.f4376b.iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L13;
        Item r3 = r0.next();
        if (r3.f() == false) goto L10;
        if (r1 == true) goto L10;
        r1 = true;
    L10:
        if (r3.g() == false) goto L4;
        if (r2 == true) goto L4;
        r2 = true;
        goto L4
    L13:
        if (r1 == false) goto L17;
        if (r2 == false) goto L17;
        int r4 = 3;
    L16:
        this.f4377c = r4;
        return;
    L17:
        if (r1 == false) goto L19;
        this.f4377c = 1;
        return;
    L19:
        if (r2 == false) goto L30;
        r4 = 2;
        goto L16
    }

    public boolean a(Item r6) {
        if (q(r6) == true) goto L25;
        boolean r0 = this.f4376b.add(r6);
        if (r0 == false) goto L23;
        int r1 = this.f4377c;
        if (r1 != 0) goto L15;
        if (r6.f() == false) goto L12;
        this.f4377c = 1;
        goto L23
    L12:
        if (r6.g() == false) goto L23;
        this.f4377c = 2;
        goto L23
    L15:
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L23;
        if (r6.f() == false) goto L23;
    L18:
        this.f4377c = 3;
        goto L23
    L17:
        if (r6.g() == true) goto L18;
    L23:
        return r0;
    L25:
        throw new IllegalArgumentException("Can't select images and videos at the same time.");
    }

    public ArrayList<Item> b() {
        return new ArrayList(this.f4376b);
    }

    public List<String> c() {
        ArrayList r0 = new ArrayList();
        Iterator<Item> r1 = this.f4376b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Item r2 = r1.next();
        r0.add(com.bytedance.feedbackerlib.k.f.a.c.b(this.f4375a, r2.b()));
        goto L4
    L6:
        return r0;
    }

    public List<Uri> d() {
        ArrayList r0 = new ArrayList();
        Iterator<Item> r2 = this.f4376b.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(r2.next().b());
        goto L4
    L6:
        return r0;
    }

    public int e(Item r2) {
        int r1 = new ArrayList(this.f4376b).indexOf(r2);
        if (r1 != (-1)) goto L6;
        return Integer.MIN_VALUE;
    L6:
        return r1 + 1;
    }

    public int f() {
        return this.f4376b.size();
    }

    public Bundle h() {
        Bundle r0 = new Bundle();
        r0.putParcelableArrayList("state_selection", new ArrayList(this.f4376b));
        r0.putInt("state_collection_type", this.f4377c);
        return r0;
    }

    public b i(Item r9) {
        if (k() == false) goto L7;
        String r8 = this.f4375a.getString(g.f4038c, new Object[]{Integer.valueOf(g())});
        return new b(1, r8, r8);
    L7:
        if (q(r9) == true) goto L9;
        c r0 = c.b();
        Iterator<Item> r3 = this.f4376b.iterator();
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L16;
        if (r3.next().g() == false) goto L12;
        r4 = r4 + 1;
        goto L12
    L16:
        String r1 = this.f4375a.getString(g.f4041f, new Object[]{Integer.valueOf(r0.f4353i)});
        if (r4 < r0.f4353i) goto L23;
        if (r9.g() == false) goto L23;
        return new b(1, r1, "");
    L23:
        if (r9.g() == false) goto L34;
        this.f4378d.reset();
        this.f4378d.setDataSource(this.f4375a, r9.b());     // Catch: IOException -> L27
        this.f4378d.prepare();     // Catch: IOException -> L27
    L30:
        if (this.f4378d.getDuration() < 31000) goto L34;
        return new b(1, "视频不可超过30秒", "");
    L27:
        e = move-exception;
        e.printStackTrace();
    L34:
        return d.e(this.f4375a, r9);
    L9:
        return new b(this.f4375a.getString(g.f4042g));
    }

    public boolean j(Item r1) {
        return this.f4376b.contains(r1);
    }

    public boolean k() {
        if (this.f4376b.size() != g()) goto L5;
        return true;
    L5:
        return false;
    }

    public void l(Bundle r3) {
        if (r3 != null) goto L4;
        this.f4376b = new LinkedHashSet();
        return;
    L4:
        this.f4376b = new LinkedHashSet(r3.getParcelableArrayList("state_selection"));
        this.f4377c = r3.getInt("state_collection_type", 0);
    }

    public void m(Bundle r3) {
        r3.putParcelableArrayList("state_selection", new ArrayList(this.f4376b));
        r3.putInt("state_collection_type", this.f4377c);
    }

    public void n(ArrayList<Item> r2, int r3) {
        if (r2.size() != 0) goto L5;
        r3 = 0;
    L5:
        this.f4377c = r3;
        this.f4376b.clear();
        this.f4376b.addAll(r2);
    }

    public boolean p(Item r3) {
        boolean r4 = this.f4376b.remove(r3);
        if (r4 == true) goto L5;
    L10:
        return r4;
    L5:
        if (this.f4376b.size() != 0) goto L8;
        this.f4377c = 0;
        goto L10
    L8:
        if (this.f4377c != 3) goto L10;
        o();
        goto L10
    }

    public boolean q(Item r5) {
        if (c.b().f4346b == true) goto L5;
    L15:
        return false;
    L5:
        if (r5.f() == false) goto L10;
        int r0 = this.f4377c;
        if (r0 == 2) goto L17;
        if (r0 != 3) goto L10;
        return true;
    L17:
        return true;
    L10:
        if (r5.g() == false) goto L15;
        int r4 = this.f4377c;
        if (r4 == 1) goto L19;
        if (r4 != 3) goto L15;
        return true;
    L19:
        return true;
    }
}
