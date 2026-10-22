package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;
import com.bytedance.feedbackerlib.k.f.a.e;
import com.bytedance.feedbackerlib.m.w;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CursorAdapter f4448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f4449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListPopupWindow f4450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f4451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f4452e;

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.matisse.internal.ui.widget.a$a, reason: collision with other inner class name */
    class C0131a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4453f;

        C0131a(a r1) {
            this.f4453f = r1;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r7, View r8, int r9, long r10) {
            a.a(this.f4453f, r7.getContext(), r9);
            if (a.b(this.f4453f) == null) goto L6;
            a.b(this.f4453f).onItemSelected(r7, r8, r9, r10);
            return;
        }
    }

    class b implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4454f;

        b(a r1) {
            this.f4454f = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Context r0 = a.c(this.f4454f).getContext();
            if (r0 == null) goto L6;
            a.c(this.f4454f).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, ContextCompat.getDrawable(r0, com.bytedance.feedbackerlib.d.f4007i), null);
        L6:
            if (a.d(this.f4454f) == null) goto L9;
            a.d(this.f4454f).a();
            return;
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4455f;

        c(a r1) {
            this.f4455f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r4) {
            int r5 = r4.getResources().getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3987a);
            ListPopupWindow r0 = a.f(this.f4455f);
            if (a.e(this.f4455f).getCount() <= 6) goto L5;
            int r6 = r5 * 6;
        L6:
            r0.setHeight(r6);
            a.f(this.f4455f).show();
            if (a.d(this.f4455f) == null) goto L9;
            a.d(this.f4455f).b();
        L9:
            Context r7 = a.c(this.f4455f).getContext();
            if (r7 == null) goto L13;
            a.c(this.f4455f).setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, ContextCompat.getDrawable(r7, com.bytedance.feedbackerlib.d.n), null);
            return;
        L13:
            return;
        L5:
            r6 = r5 * a.e(this.f4455f).getCount();
            goto L6
        }
    }

    public interface d {
        void a();

        void b();
    }

    public a(@NonNull Context r4, d r5) {
        ListPopupWindow r0 = new ListPopupWindow(r4, null, com.bytedance.feedbackerlib.a.f3837f);
        this.f4450c = r0;
        r0.setModal(true);
        this.f4450c.setContentWidth(w.a(r4));
        this.f4450c.setHorizontalOffset(0);
        this.f4450c.setVerticalOffset(0);
        this.f4450c.setBackgroundDrawable(ContextCompat.getDrawable(r4, com.bytedance.feedbackerlib.d.r));
        this.f4450c.setOnItemClickListener(new C0131a(this));
        this.f4450c.setOnDismissListener(new b(this));
        this.f4452e = r5;
    }

    static /* synthetic */ void a(a r0, Context r1, int r2) {
        r0.g(r1, r2);
    }

    static /* synthetic */ AdapterView.OnItemSelectedListener b(a r0) {
        return r0.f4451d;
    }

    static /* synthetic */ TextView c(a r0) {
        return r0.f4449b;
    }

    static /* synthetic */ d d(a r0) {
        return r0.f4452e;
    }

    static /* synthetic */ CursorAdapter e(a r0) {
        return r0.f4448a;
    }

    static /* synthetic */ ListPopupWindow f(a r0) {
        return r0.f4450c;
    }

    private void g(Context r4, int r5) {
        this.f4450c.dismiss();
        Cursor r0 = this.f4448a.getCursor();
        r0.moveToPosition(r5);
        String r6 = Album.j(r0).f(r4);
        if (this.f4449b.getVisibility() != 0) goto L6;
    L4:
        this.f4449b.setText(r6);
        return;
    L6:
        if (e.a() == false) goto L8;
        this.f4449b.setAlpha(0.0f);
        this.f4449b.setVisibility(0);
        this.f4449b.setText(r6);
        this.f4449b.animate().alpha(1.0f).setDuration(r4.getResources().getInteger(R.integer.config_longAnimTime)).start();
        return;
    L8:
        this.f4449b.setVisibility(0);
        goto L4
    }

    public void h(CursorAdapter r2) {
        this.f4450c.setAdapter(r2);
        this.f4448a = r2;
    }

    public void i(AdapterView.OnItemSelectedListener r1) {
        this.f4451d = r1;
    }

    public void j(View r1) {
        this.f4450c.setAnchorView(r1);
    }

    public void k(TextView r2) {
        this.f4449b = r2;
        r2.setVisibility(8);
        this.f4449b.setOnClickListener(new c(this));
        TextView r3 = this.f4449b;
        r3.setOnTouchListener(this.f4450c.createDragToOpenListener(r3));
    }

    public void l(Context r2, int r3) {
        this.f4450c.setSelection(r3);
        g(r2, r3);
    }
}
