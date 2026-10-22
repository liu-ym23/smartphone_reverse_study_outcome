package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
interface ModelTypes<T> {
    T load(Bitmap r1);

    T load(Drawable r1);

    T load(Uri r1);

    T load(File r1);

    T load(Integer r1);

    T load(Object r1);

    T load(String r1);

    @Deprecated
    T load(URL r1);

    T load(byte[] r1);
}
