package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object r1, Transition r2) {
        onResourceReady((Bitmap) r1, r2);
    }

    public AppWidgetTarget(Context r1, int r2, int r3, int r4, RemoteViews r5, int... r6) {
        super(r2, r3);
        if (r6.length == 0) goto L7;
        this.context = (Context) Preconditions.checkNotNull(r1, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r5, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) Preconditions.checkNotNull(r6, "WidgetIds can not be null!");
        this.viewId = r4;
        this.componentName = null;
        return;
    L7:
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    public AppWidgetTarget(Context r8, int r9, RemoteViews r10, int... r11) {
        this(r8, Integer.MIN_VALUE, Integer.MIN_VALUE, r9, r10, r11);
    }

    public AppWidgetTarget(Context r1, int r2, int r3, int r4, RemoteViews r5, ComponentName r6) {
        super(r2, r3);
        this.context = (Context) Preconditions.checkNotNull(r1, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r5, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(r6, "ComponentName can not be null!");
        this.viewId = r4;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context r8, int r9, RemoteViews r10, ComponentName r11) {
        this(r8, Integer.MIN_VALUE, Integer.MIN_VALUE, r9, r10, r11);
    }

    private void update() {
        AppWidgetManager r0 = AppWidgetManager.getInstance(this.context);
        ComponentName r1 = this.componentName;
        if (r1 == null) goto L5;
        r0.updateAppWidget(r1, this.remoteViews);
        return;
    L5:
        r0.updateAppWidget(this.widgetIds, this.remoteViews);
    }

    public void onResourceReady(Bitmap r1, Transition<? super Bitmap> r2) {
        setBitmap(r1);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r1) {
        setBitmap(null);
    }

    private void setBitmap(Bitmap r3) {
        this.remoteViews.setImageViewBitmap(this.viewId, r3);
        update();
    }
}
