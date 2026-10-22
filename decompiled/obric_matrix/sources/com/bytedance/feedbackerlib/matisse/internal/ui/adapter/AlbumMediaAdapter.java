package com.bytedance.feedbackerlib.matisse.internal.ui.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.CheckView;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.MediaGrid;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlbumMediaAdapter extends RecyclerViewCursorAdapter<RecyclerView.ViewHolder> implements MediaGrid.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.matisse.internal.model.a f4406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f4407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.feedbackerlib.matisse.internal.entity.c f4408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f4409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f4410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RecyclerView f4411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4412i;

    class a implements View.OnClickListener {
        a(AlbumMediaAdapter r1) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            if ((r1.getContext() instanceof f) == false) goto L6;
            ((f) r1.getContext()).g();
            return;
        }
    }

    private static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f4413a;

        b(View r2) {
            super(r2);
            this.f4413a = (TextView) r2.findViewById(com.bytedance.feedbackerlib.e.r);
        }

        static /* synthetic */ TextView a(b r0) {
            return r0.f4413a;
        }
    }

    public interface c {
        void onUpdate();
    }

    private static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediaGrid f4414a;

        d(View r1) {
            super(r1);
            this.f4414a = (MediaGrid) r1;
        }

        static /* synthetic */ MediaGrid a(d r0) {
            return r0.f4414a;
        }
    }

    public interface e {
        void f(Album r1, Item r2, int r3);
    }

    public interface f {
        void g();
    }

    public AlbumMediaAdapter(Context r3, com.bytedance.feedbackerlib.matisse.internal.model.a r4, RecyclerView r5) {
        super(null);
        com.bytedance.feedbackerlib.matisse.internal.entity.c r0 = com.bytedance.feedbackerlib.matisse.internal.entity.c.b();
        this.f4408e = r0;
        this.f4406c = r4;
        List<Item> r6 = r0.y;
        if (r6 == null) goto L8;
        Iterator<Item> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        this.f4406c.a(r7.next());
    L8:
        TypedArray r8 = r3.getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3836e});
        this.f4407d = r8.getDrawable(0);
        r8.recycle();
        this.f4411h = r5;
    }

    private boolean g(Context r1, Item r2) {
        com.bytedance.feedbackerlib.matisse.internal.entity.b r0 = this.f4406c.i(r2);
        com.bytedance.feedbackerlib.matisse.internal.entity.b.a(r1, r0);
        if (r0 != null) goto L5;
        return true;
    L5:
        return false;
    }

    private int h(Context r4) {
        if (this.f4412i != 0) goto L6;
        int r0 = ((GridLayoutManager) this.f4411h.getLayoutManager()).getSpanCount();
        int r1 = (r4.getResources().getDisplayMetrics().widthPixels - (r4.getResources().getDimensionPixelSize(com.bytedance.feedbackerlib.c.n) * (r0 - 1))) / r0;
        this.f4412i = r1;
        this.f4412i = (int) (r1 * this.f4408e.o);
    L6:
        return this.f4412i;
    }

    private void i() {
        notifyDataSetChanged();
        c r0 = this.f4409f;
        if (r0 == null) goto L6;
        r0.onUpdate();
        return;
    }

    private void l(Item r4, MediaGrid r5) {
        if (this.f4408e.f4350f == false) goto L12;
        int r6 = this.f4406c.e(r4);
        if (r6 <= 0) goto L7;
        r5.setCheckEnabled(true);
        r5.setCheckedNum(r6);
        r5.i();
        return;
    L7:
        r5.b();
        if (this.f4406c.k() == false) goto L10;
        r5.setCheckEnabled(false);
        r5.setCheckedNum(Integer.MIN_VALUE);
        return;
    L10:
        r5.setCheckEnabled(true);
        r5.setCheckedNum(r6);
        return;
    L12:
        if (this.f4406c.j(r4) == false) goto L15;
        r5.setCheckEnabled(true);
        r5.setChecked(true);
        return;
    L15:
        if (this.f4406c.k() == false) goto L17;
        r5.setCheckEnabled(false);
    L18:
        r5.setChecked(false);
        return;
    L17:
        r5.setCheckEnabled(true);
        goto L18
    }

    private void m(Item r3, RecyclerView.ViewHolder r4) {
        if (this.f4408e.f4350f == false) goto L10;
        if (this.f4406c.e(r3) == Integer.MIN_VALUE) goto L7;
    L11:
        this.f4406c.p(r3);
    L12:
        i();
        return;
    L7:
        if (g(r4.itemView.getContext(), r3) == true) goto L15;
        return;
    L15:
        this.f4406c.a(r3);
        goto L12
    L10:
        if (this.f4406c.j(r3) == true) goto L11;
        if (g(r4.itemView.getContext(), r3) == true) goto L15;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.widget.MediaGrid.a
    public void a(CheckView r1, Item r2, RecyclerView.ViewHolder r3) {
        m(r2, r3);
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.widget.MediaGrid.a
    public void b(ImageView r1, Item r2, RecyclerView.ViewHolder r3) {
        if (this.f4408e.x == false) goto L7;
        e r0 = this.f4410g;
        if (r0 == null) goto L9;
        r0.f(null, r2, r3.getAdapterPosition());
        return;
    L9:
        return;
    L7:
        m(r2, r3);
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.RecyclerViewCursorAdapter
    public int c(int r1, Cursor r2) {
        if (Item.i(r2).d() == false) goto L5;
        return 1;
    L5:
        return 2;
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.adapter.RecyclerViewCursorAdapter
    protected void e(RecyclerView.ViewHolder r7, Cursor r8) {
        if ((r7 instanceof b) == false) goto L16;
        b r6 = (b) r7;
        Drawable[] r9 = b.a(r6).getCompoundDrawables();
        TypedArray r10 = r7.itemView.getContext().getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3833b});
        int r1 = r10.getColor(0, 0);
        r10.recycle();
        int r11 = 0;
    L6:
        if (r11 >= r9.length) goto L14;
        Drawable r2 = r9[r11];
        if (r2 == null) goto L13;
        Drawable.ConstantState r4 = r2.getConstantState();
        if (r4 == null) goto L13;
        Drawable r5 = r4.newDrawable().mutate();
        r5.setColorFilter(r1, PorterDuff.Mode.SRC_IN);
        r5.setBounds(r2.getBounds());
        r9[r11] = r5;
    L13:
        r11 = r11 + 1;
        goto L6
    L14:
        b.a(r6).setCompoundDrawables(r9[0], r9[1], r9[2], r9[3]);
        return;
    L16:
        if ((r7 instanceof d) == false) goto L24;
        d r0 = (d) r7;
        Item r12 = Item.i(r8);
        d.a(r0).e(new MediaGrid.b(h(d.a(r0).getContext()), this.f4407d, this.f4408e.f4350f, r7));
        d.a(r0).a(r12);
        d.a(r0).setOnMediaGridClickListener(this);
        l(r12, d.a(r0));
        return;
    }

    public void j(c r1) {
        this.f4409f = r1;
    }

    public void k(e r1) {
        this.f4410g = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 1) goto L7;
        b r5 = new b(LayoutInflater.from(r3.getContext()).inflate(com.bytedance.feedbackerlib.f.r, r3, false));
        r5.itemView.setOnClickListener(new a(this));
        return r5;
    L7:
        if (r4 == 2) goto L9;
        return null;
    L9:
        return new d(LayoutInflater.from(r3.getContext()).inflate(com.bytedance.feedbackerlib.f.q, r3, false));
    }
}
