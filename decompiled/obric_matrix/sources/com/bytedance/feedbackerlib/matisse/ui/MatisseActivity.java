package com.bytedance.feedbackerlib.matisse.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.g;
import com.bytedance.feedbackerlib.k.f.a.f;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.model.AlbumCollection;
import com.bytedance.feedbackerlib.matisse.internal.ui.AlbumPreviewActivity;
import com.bytedance.feedbackerlib.matisse.internal.ui.MediaSelectionFragment;
import com.bytedance.feedbackerlib.matisse.internal.ui.SelectedPreviewActivity;
import com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.CheckRadioView;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.IncapableDialog;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class MatisseActivity extends AppCompatActivity implements View.OnClickListener, AlbumCollection.a, AdapterView.OnItemSelectedListener, MediaSelectionFragment.a, AlbumMediaAdapter.c, AlbumMediaAdapter.e, AlbumMediaAdapter.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AlbumCollection f4456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.matisse.internal.model.a f4457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.feedbackerlib.k.f.a.b f4458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bytedance.feedbackerlib.matisse.internal.entity.c f4459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bytedance.feedbackerlib.matisse.internal.ui.widget.a f4460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.bytedance.feedbackerlib.matisse.internal.ui.adapter.a f4461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f4462l;
    private TextView m;
    private TextView n;
    private View o;
    private View p;
    private View q;
    private LinearLayout r;
    private CheckRadioView s;
    private boolean t;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MatisseActivity f4463f;

        a(MatisseActivity r1) {
            this.f4463f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f4463f.onBackPressed();
        }
    }

    class b implements com.bytedance.feedbackerlib.matisse.internal.ui.widget.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MatisseActivity f4464a;

        b(MatisseActivity r1) {
            this.f4464a = r1;
        }

        @Override // com.bytedance.feedbackerlib.matisse.internal.ui.widget.a.d
        public void a() {
            MatisseActivity.x(this.f4464a).setVisibility(8);
        }

        @Override // com.bytedance.feedbackerlib.matisse.internal.ui.widget.a.d
        public void b() {
            MatisseActivity.x(this.f4464a).setVisibility(0);
        }
    }

    class c implements com.bytedance.feedbackerlib.j.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.feedbackerlib.j.e f4465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MatisseActivity f4466b;

        c(MatisseActivity r1, com.bytedance.feedbackerlib.j.e r2) {
            this.f4466b = r1;
            this.f4465a = r2;
        }

        @Override // com.bytedance.feedbackerlib.j.e.b
        public void a() {
            MatisseActivity.y(this.f4466b).setText(this.f4465a.g("preview"));
            MatisseActivity.z(this.f4466b).setText(this.f4465a.g("fll_image"));
            MatisseActivity.A(this.f4466b).setText(this.f4465a.g("complete"));
        }
    }

    class d implements f.a {
        d(MatisseActivity r1) {
        }

        @Override // com.bytedance.feedbackerlib.k.f.a.f.a
        public void a() {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Cursor f4467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MatisseActivity f4468g;

        e(MatisseActivity r1, Cursor r2) {
            this.f4468g = r1;
            this.f4467f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4467f.moveToPosition(MatisseActivity.B(this.f4468g).a());
            com.bytedance.feedbackerlib.matisse.internal.ui.widget.a r0 = MatisseActivity.C(this.f4468g);
            MatisseActivity r1 = this.f4468g;
            r0.l(r1, MatisseActivity.B(r1).a());
            Album r2 = Album.j(this.f4467f);
            if (r2.h() == true) goto L5;
        L7:
            MatisseActivity.D(this.f4468g, r2);
            return;
        L5:
            if (com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4355k == false) goto L7;
            r2.b();
            goto L7
        }
    }

    public MatisseActivity() {
        this.f4456f = new AlbumCollection();
        this.f4457g = new com.bytedance.feedbackerlib.matisse.internal.model.a(this);
    }

    static /* synthetic */ TextView A(MatisseActivity r0) {
        return r0.m;
    }

    static /* synthetic */ AlbumCollection B(MatisseActivity r0) {
        return r0.f4456f;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.matisse.internal.ui.widget.a C(MatisseActivity r0) {
        return r0.f4460j;
    }

    static /* synthetic */ void D(MatisseActivity r0, Album r1) {
        r0.G(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void E(MatisseActivity r2) {
        r2.w();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private int F() {
        int r0 = this.f4457g.f();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Item r3 = this.f4457g.b().get(r1);
        if (r3.f() == false) goto L9;
        if (com.bytedance.feedbackerlib.k.f.a.d.d(r3.f4336i) <= this.f4459i.v) goto L9;
        r2 = r2 + 1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r2;
    }

    private void G(Album r4) {
        if (r4.h() == true) goto L5;
    L7:
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        MediaSelectionFragment r5 = MediaSelectionFragment.b(r4);
        getSupportFragmentManager().beginTransaction().replace(com.bytedance.feedbackerlib.e.f4020i, r5, MediaSelectionFragment.class.getSimpleName()).commitAllowingStateLoss();
        return;
    L5:
        if (r4.i() == false) goto L7;
        this.o.setVisibility(8);
        this.p.setVisibility(0);
    }

    private void H() {
        int r0 = this.f4457g.f();
        com.bytedance.feedbackerlib.j.e r1 = com.bytedance.feedbackerlib.j.e.e();
        if (r0 != 0) goto L6;
        this.m.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        this.f4462l.setEnabled(false);
        this.m.setEnabled(false);
        this.m.setText(r1.g("complete"));
    L12:
        if (this.f4459i.s == false) goto L14;
        this.r.setVisibility(0);
        J();
        return;
    L14:
        this.r.setVisibility(4);
        return;
    L6:
        if (r0 == 1) goto L8;
    L10:
        this.m.setBackgroundResource(com.bytedance.feedbackerlib.d.f4003e);
        this.f4462l.setEnabled(true);
        this.m.setEnabled(true);
        this.m.setText(r1.g("complete") + " (" + r0 + ")");
        goto L12
    L8:
        if (this.f4459i.h() == false) goto L10;
        this.m.setBackgroundResource(com.bytedance.feedbackerlib.d.f4003e);
        this.f4462l.setEnabled(true);
        this.m.setText(r1.g("complete"));
        this.m.setEnabled(true);
        goto L12
    }

    private void I() {
        com.bytedance.feedbackerlib.j.e r0 = com.bytedance.feedbackerlib.j.e.e();
        if (this.t == true) goto L6;
        this.n.setText(r0.g("fll_image"));
        return;
    L6:
        ArrayList<Item> r1 = this.f4457g.b();
        if (r1 == null) goto L12;
        Iterator<Item> r2 = r1.iterator();
        long r5 = 0;
    L10:
        if (r2.hasNext() == false) goto L14;
        r5 = r5 + r2.next().f4336i;
    L14:
        if (r5 <= 0) goto L16;
        float r3 = com.bytedance.feedbackerlib.k.f.a.d.d(r5);
        TextView r9 = this.n;
        String r4 = r0.g("fll_image") + "(" + r3 + "M)";
    L17:
        r9.setText(r4);
        return;
    L16:
        r9 = this.n;
        r4 = r0.g("fll_image");
        goto L17
    L12:
        r5 = 0;
        goto L14
    }

    private void J() {
        this.s.setChecked(this.t);
        I();
        if (F() > 0) goto L5;
        return;
    L5:
        if (this.t == false) goto L9;
        IncapableDialog.b("", getString(g.f4040e, new Object[]{Integer.valueOf(this.f4459i.v)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
        this.s.setChecked(false);
        this.t = false;
        return;
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle u(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context v(MatisseActivity r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ View x(MatisseActivity r0) {
        return r0.q;
    }

    static /* synthetic */ TextView y(MatisseActivity r0) {
        return r0.f4462l;
    }

    static /* synthetic */ TextView z(MatisseActivity r0) {
        return r0.n;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumCollection.a
    public void b() {
        this.f4461k.swapCursor(null);
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.MediaSelectionFragment.a
    public com.bytedance.feedbackerlib.matisse.internal.model.a c() {
        return this.f4457g;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.model.AlbumCollection.a
    public void d(Cursor r3) {
        this.f4461k.swapCursor(r3);
        new Handler(Looper.getMainLooper()).post(new e(this, r3));
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter.e
    public void f(Album r2, Item r3, int r4) {
        Intent r5 = new Intent(this, AlbumPreviewActivity.class);
        r5.putExtra("extra_album", r2);
        r5.putExtra("extra_item", r3);
        r5.putExtra("extra_default_bundle", this.f4457g.h());
        r5.putExtra("extra_result_original_enable", this.t);
        startActivityForResult(r5, 23);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter.f
    public void g() {
        com.bytedance.feedbackerlib.k.f.a.b r0 = this.f4458h;
        if (r0 == null) goto L6;
        r0.b(this, 24);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r9, int r10, Intent r11) {
        super.onActivityResult(r9, r10, r11);
        if (r10 == (-1)) goto L6;
        return;
    L6:
        if (r9 != 23) goto L23;
        Bundle r12 = u(r11, "extra_result_bundle");
        ArrayList<Item> r13 = r12.getParcelableArrayList("state_selection");
        this.t = r11.getBooleanExtra("extra_result_original_enable", false);
        int r14 = r12.getInt("state_collection_type", 0);
        if (r11.getBooleanExtra("extra_result_apply", false) == false) goto L18;
        Intent r15 = new Intent();
        ArrayList<? extends Parcelable> r16 = new ArrayList();
        ArrayList<String> r4 = new ArrayList();
        if (r13 == null) goto L15;
        Iterator<Item> r5 = r13.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        Item r6 = r5.next();
        r16.add(r6.b());
        r4.add(com.bytedance.feedbackerlib.k.f.a.c.b(this, r6.b()));
    L15:
        if (r13 == null) goto L17;
        r15.putParcelableArrayListExtra("extra_result_item", r13);
    L17:
        r15.putParcelableArrayListExtra("extra_result_selection", r16);
        r15.putStringArrayListExtra("extra_result_selection_path", r4);
        r15.putExtra("extra_result_original_enable", this.t);
        setResult(-1, r15);
    L28:
        finish();
        return;
    L18:
        this.f4457g.n(r13, r14);
        Fragment r17 = getSupportFragmentManager().findFragmentByTag(MediaSelectionFragment.class.getSimpleName());
        if ((r17 instanceof MediaSelectionFragment) == false) goto L21;
        ((MediaSelectionFragment) r17).c();
    L21:
        H();
        return;
    L23:
        if (r9 != 24) goto L32;
        Uri r18 = this.f4458h.d();
        String r19 = this.f4458h.c();
        ArrayList<? extends Parcelable> r110 = new ArrayList();
        r110.add(r18);
        ArrayList<String> r3 = new ArrayList();
        r3.add(r19);
        Intent r7 = new Intent();
        r7.putParcelableArrayListExtra("extra_result_selection", r110);
        r7.putStringArrayListExtra("extra_result_selection_path", r3);
        setResult(-1, r7);
        if (Build.VERSION.SDK_INT >= 21) goto L27;
        revokeUriPermission(r18, 3);
    L27:
        new f(v(this), r19, new d(this));
        goto L28
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5.getId() != com.bytedance.feedbackerlib.e.f4018g) goto L8;
        Intent r6 = new Intent(this, SelectedPreviewActivity.class);
        r6.putExtra("extra_default_bundle", this.f4457g.h());
        r6.putExtra("extra_result_original_enable", this.t);
        startActivityForResult(r6, 23);     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L8:
        if (r5.getId() != com.bytedance.feedbackerlib.e.f4016e) goto L11;
        Intent r7 = new Intent();
        r7.putParcelableArrayListExtra("extra_result_selection", (ArrayList) this.f4457g.d());
        r7.putStringArrayListExtra("extra_result_selection_path", (ArrayList) this.f4457g.c());
        r7.putExtra("extra_result_original_enable", this.t);
        r7.putParcelableArrayListExtra("extra_result_item", this.f4457g.b());
        setResult(-1, r7);
        finish();
        return;
    L11:
        if (r5.getId() != com.bytedance.feedbackerlib.e.S) goto L25;
        int r8 = F();
        if (r8 <= 0) goto L16;
        IncapableDialog.b("", getString(g.f4039d, new Object[]{Integer.valueOf(r8), Integer.valueOf(this.f4459i.v)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
        return;
    L16:
        boolean r9 = !this.t;
        this.t = r9;
        this.s.setChecked(r9);
        com.bytedance.feedbackerlib.k.g.a r10 = this.f4459i.w;
        if (r10 == null) goto L19;
        r10.a(this.t);
    L19:
        I();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r6) {
        com.bytedance.feedbackerlib.matisse.internal.entity.c r0 = com.bytedance.feedbackerlib.matisse.internal.entity.c.b();
        this.f4459i = r0;
        setTheme(r0.f4348d);
        super.onCreate(r6);
        if (this.f4459i.q == true) goto L6;
        setResult(0);
        finish();
        return;
    L6:
        setContentView(com.bytedance.feedbackerlib.f.f4033j);
        com.bytedance.feedbackerlib.matisse.internal.entity.c r1 = this.f4459i;
        this.t = r1.t;
        if (r1.c() == false) goto L10;
        setRequestedOrientation(this.f4459i.f4349e);
    L10:
        if (this.f4459i.f4355k == false) goto L16;
        com.bytedance.feedbackerlib.k.f.a.b r2 = new com.bytedance.feedbackerlib.k.f.a.b(this);
        this.f4458h = r2;
        com.bytedance.feedbackerlib.matisse.internal.entity.a r3 = this.f4459i.f4356l;
        if (r3 == null) goto L15;
        r2.f(r3);
        goto L16
    L15:
        throw new RuntimeException("Don't forget to set CaptureStrategy.");
    L16:
        int r4 = com.bytedance.feedbackerlib.e.m0;
        setSupportActionBar((Toolbar) findViewById(r4));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((ImageView) findViewById(com.bytedance.feedbackerlib.e.t)).setOnClickListener(new a(this));
        TextView r5 = (TextView) findViewById(com.bytedance.feedbackerlib.e.f4018g);
        this.f4462l = r5;
        r5.setOnClickListener(this);
        TextView r7 = (TextView) findViewById(com.bytedance.feedbackerlib.e.f4016e);
        this.m = r7;
        r7.setOnClickListener(this);
        this.n = (TextView) findViewById(com.bytedance.feedbackerlib.e.O0);
        this.q = findViewById(com.bytedance.feedbackerlib.e.m);
        this.o = findViewById(com.bytedance.feedbackerlib.e.f4020i);
        this.p = findViewById(com.bytedance.feedbackerlib.e.f4021j);
        this.r = (LinearLayout) findViewById(com.bytedance.feedbackerlib.e.S);
        this.s = (CheckRadioView) findViewById(com.bytedance.feedbackerlib.e.R);
        this.r.setOnClickListener(this);
        this.f4457g.l(r6);
        if (r6 == null) goto L19;
        this.t = r6.getBoolean("checkState");
    L19:
        H();
        this.f4461k = new com.bytedance.feedbackerlib.matisse.internal.ui.adapter.a(this, null, false, this.f4457g);
        com.bytedance.feedbackerlib.matisse.internal.ui.widget.a r8 = new com.bytedance.feedbackerlib.matisse.internal.ui.widget.a(this, new b(this));
        this.f4460j = r8;
        r8.i(this);
        this.f4460j.k((TextView) findViewById(com.bytedance.feedbackerlib.e.h0));
        this.f4460j.j(findViewById(r4));
        this.f4460j.h(this.f4461k);
        this.f4456f.c(this, this);
        this.f4456f.f(r6);
        this.f4456f.b();
        com.bytedance.feedbackerlib.j.e r9 = com.bytedance.feedbackerlib.j.e.e();
        this.f4462l.setText(r9.g("preview"));
        this.n.setText(r9.g("fll_image"));
        this.m.setText(r9.g("complete"));
        r9.k(new c(this, r9));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4456f.d();
        com.bytedance.feedbackerlib.matisse.internal.entity.c r1 = this.f4459i;
        r1.w = null;
        r1.r = null;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        this.f4456f.h(r3);
        this.f4461k.getCursor().moveToPosition(r3);
        Album r5 = Album.j(this.f4461k.getCursor());
        if (r5.h() == true) goto L5;
    L7:
        G(r5);
        return;
    L5:
        if (com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4355k == false) goto L7;
        r5.b();
        goto L7
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        this.f4457g.m(r2);
        this.f4456f.g(r2);
        r2.putBoolean("checkState", this.t);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        E(this);
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.AlbumMediaAdapter.c
    public void onUpdate() {
        H();
        com.bytedance.feedbackerlib.k.g.c r0 = this.f4459i.r;
        if (r0 == null) goto L6;
        r0.a(this.f4457g.d(), this.f4457g.c());
        return;
    }

    public void w() {
        super.onStop();
    }
}
