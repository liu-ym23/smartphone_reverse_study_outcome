package com.bytedance.feedbackerlib.matisse.internal.ui.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.feedbackerlib.e;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.matisse.internal.entity.Album;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends CursorAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Drawable f4419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.matisse.internal.model.a f4420g;

    public a(Context r2, Cursor r3, boolean r4, com.bytedance.feedbackerlib.matisse.internal.model.a r5) {
        super(r2, r3, r4);
        TypedArray r6 = r2.getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3832a});
        this.f4419f = r6.getDrawable(0);
        r6.recycle();
        this.f4420g = r5;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View r9, Context r10, Cursor r11) {
        Album r12 = Album.j(r11);
        ((TextView) r9.findViewById(e.f4014c)).setText(r12.f(r10));
        ((TextView) r9.findViewById(e.f4013b)).setText(String.valueOf(r12.d()));
        TextView r0 = (TextView) r9.findViewById(e.v0);
        r0.setVisibility(8);
        c.b().p.b(r10, r10.getResources().getDimensionPixelSize(com.bytedance.feedbackerlib.c.m), this.f4419f, (ImageView) r9.findViewById(e.f4012a), r12.e());
        com.bytedance.feedbackerlib.matisse.internal.model.a r13 = this.f4420g;
        if (r13 != null) goto L5;
        return;
    L5:
        ArrayList<Item> r14 = r13.b();
        if (r14 != null) goto L8;
        return;
    L8:
        if (r12.h() == false) goto L13;
        int r8 = this.f4420g.f();
        if (r8 <= 0) goto L36;
        r0.setVisibility(0);
        r0.setText("" + r8);
        return;
    L36:
        return;
    L13:
        Iterator<Item> r15 = r14.iterator();
        int r16 = 0;
    L15:
        if (r15.hasNext() == false) goto L24;
        Item r17 = r15.next();
        if (r17 == null) goto L15;
        r17.h();
        String r18 = r17.f4338k;
        if (r18 == null) goto L15;
        if (r18.equals(r12.g()) == false) goto L15;
        r16 = r16 + 1;
        goto L15
    L24:
        if (r16 <= 0) goto L38;
        r0.setVisibility(0);
        r0.setText("" + r16);
        return;
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context r1, Cursor r2, ViewGroup r3) {
        return LayoutInflater.from(r1).inflate(f.f4035l, r3, false);
    }
}
