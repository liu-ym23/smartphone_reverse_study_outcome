package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;
import com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity;

/* JADX INFO: loaded from: classes.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object r1, Transition r2) {
        onResourceReady((Bitmap) r1, r2);
    }

    public NotificationTarget(Context r8, int r9, RemoteViews r10, Notification r11, int r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public NotificationTarget(Context r10, int r11, RemoteViews r12, Notification r13, int r14, String r15) {
        this(r10, Integer.MIN_VALUE, Integer.MIN_VALUE, r11, r12, r13, r14, r15);
    }

    public NotificationTarget(Context r1, int r2, int r3, int r4, RemoteViews r5, Notification r6, int r7, String r8) {
        super(r2, r3);
        this.context = (Context) Preconditions.checkNotNull(r1, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(r6, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(r5, "RemoteViews object can not be null!");
        this.viewId = r4;
        this.notificationId = r7;
        this.notificationTag = r8;
    }

    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService(ClearPowerHighAppsActivity.COME_FROM_NOTIFICATION))).notify(this.notificationTag, this.notificationId, this.notification);
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
