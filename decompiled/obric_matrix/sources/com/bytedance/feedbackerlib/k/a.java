package com.bytedance.feedbackerlib.k;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f4233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Fragment> f4234b;

    private a(Activity r2) {
        this(r2, null);
    }

    private a(Activity r2, Fragment r3) {
        this.f4233a = new WeakReference(r2);
        this.f4234b = new WeakReference(r3);
    }

    public static a b(Activity r1) {
        return new a(r1);
    }

    public static ArrayList<Item> e(Intent r1) {
        return r1.getParcelableArrayListExtra("extra_result_item");
    }

    public static boolean f(Intent r2) {
        return r2.getBooleanExtra("extra_result_original_enable", false);
    }

    public c a(Set<b> r2, boolean r3) {
        return new c(this, r2, r3);
    }

    @Nullable
    Activity c() {
        return this.f4233a.get();
    }

    @Nullable
    Fragment d() {
        WeakReference<Fragment> r0 = this.f4234b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }
}
