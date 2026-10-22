package com.bytedance.feedbackerlib.matisse.internal.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.feedbackerlib.e;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.g;
import com.bytedance.feedbackerlib.k.f.a.d;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import d.b.k.a.q;
import d.b.k.a.t;
import d.b.k.a.u;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/* JADX INFO: loaded from: classes.dex */
public class PreviewItemFragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.feedbackerlib.k.g.b f4402f;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Item f4403f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ PreviewItemFragment f4404g;

        a(PreviewItemFragment r1, Item r2) {
            this.f4404g = r1;
            this.f4403f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            Intent r4 = new Intent("android.intent.action.VIEW");
            r4.setDataAndType(this.f4403f.f4335h, "video/*");
            this.f4404g.startActivity(r4);     // Catch: Throwable -> L5
            return;
        L5:
            Toast.makeText(this.f4404g.getContext(), g.f4037b, 0).show();
        }
    }

    class b implements ImageViewTouch.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreviewItemFragment f4405a;

        b(PreviewItemFragment r1) {
            this.f4405a = r1;
        }

        @Override // it.sephiroth.android.library.imagezoom.ImageViewTouch.c
        public void a() {
            if (PreviewItemFragment.b(this.f4405a) == null) goto L6;
            PreviewItemFragment.b(this.f4405a).a();
            return;
        }
    }

    public PreviewItemFragment() {
    }

    static /* synthetic */ com.bytedance.feedbackerlib.k.g.b b(PreviewItemFragment r0) {
        return r0.f4402f;
    }

    public static PreviewItemFragment c(Item r3) {
        PreviewItemFragment r0 = new PreviewItemFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable("args_item", r3);
        r0.setArguments(r1);
        return r0;
    }

    public void d() {
        if (getView() == null) goto L6;
        ((ImageViewTouch) getView().findViewById(e.s)).w();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        super.onAttach(r2);
        if ((r2 instanceof com.bytedance.feedbackerlib.k.g.b) == false) goto L7;
        this.f4402f = (com.bytedance.feedbackerlib.k.g.b) r2;
        return;
    L7:
        throw new RuntimeException(r2.toString() + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return r1.inflate(f.o, r2, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f4402f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r8, @Nullable Bundle r9) {
        super.onViewCreated(r8, r9);
        Item r10 = (Item) getArguments().getParcelable("args_item");
        if (r10 != null) goto L5;
        return;
    L5:
        View r0 = r8.findViewById(e.l1);
        if (r10.g() == false) goto L8;
        r0.setVisibility(0);
        r0.setOnClickListener(new a(this, r10));
    L9:
        ImageViewTouch r11 = (ImageViewTouch) r8.findViewById(e.s);
        r11.setDisplayType(it.sephiroth.android.library.imagezoom.a.d.f17632g);
        r11.setSingleTapListener(new b(this));
        Point r1 = d.b(r10.b(), getActivity());
        if (r10.e() == false) goto L12;
        c.b().p.a(getContext(), r1.x, r1.y, r11, r10.b());
        t r7 = q.f(r10.f4335h);
        r7.b(true);
    L13:
        r7.a(u.f14079l);
        r7.d("FeedbackActivity");
        r7.S(r11);
        r7.g();
        return;
    L12:
        r7 = q.f(r10.f4335h);
        goto L13
    L8:
        r0.setVisibility(8);
        goto L9
    }
}
