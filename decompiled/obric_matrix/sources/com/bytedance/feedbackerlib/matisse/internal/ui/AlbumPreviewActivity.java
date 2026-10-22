package com.bytedance.feedbackerlib.matisse.internal.ui;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection;
import com.bytedance.feedbackerlib.matisse.internal.ui.adapter.PreviewPagerAdapter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class AlbumPreviewActivity extends BasePreviewActivity implements AlbumMediaCollection.a {
    private boolean x;
    private AlbumMediaCollection y;

    public AlbumPreviewActivity() {
        this.y = new AlbumMediaCollection();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void L(AlbumPreviewActivity r2) {
        r2.K();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public void K() {
        super.onStop();
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection.a
    public void e() {
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumMediaCollection.a
    public void h(Cursor r3) {
        ArrayList r0 = new ArrayList();
    L4:
        if (r3.moveToNext() == false) goto L7;
        r0.add(Item.i(r3));
        goto L4
    L7:
        if (r0.isEmpty() == false) goto L9;
        return;
    L9:
        PreviewPagerAdapter r4 = (PreviewPagerAdapter) this.f4381h.getAdapter();
        r4.a(r0);
        r4.notifyDataSetChanged();
        if (this.x == true) goto L14;
        this.x = true;
        int r5 = r0.indexOf((Item) getIntent().getParcelableExtra("extra_item"));
        this.f4381h.setCurrentItem(r5, false);
        this.n = r5;
        return;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.BasePreviewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r3) {
        super.onCreate(r3);
        if (c.b().q == true) goto L6;
        setResult(0);
        finish();
        return;
    L6:
        this.y.c(this, this);
        Album r4 = (Album) getIntent().getParcelableExtra("extra_album");
        this.y.a(r4);
        Item r5 = (Item) getIntent().getParcelableExtra("extra_item");
        if (this.f4380g.f4350f == false) goto L9;
        this.f4383j.setCheckedNum(this.f4379f.e(r5));
    L10:
        J(r5);
        return;
    L9:
        this.f4383j.setChecked(this.f4379f.j(r5));
        goto L10
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.y.d();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        L(this);
    }
}
