package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context r1) {
            this.context = r1;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory r1) {
            return new MediaStoreVideoThumbLoader(this.context);
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<InputStream> buildLoadData(Uri r1, int r2, int r3, Options r4) {
        return buildLoadData2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(Uri r1) {
        return handles2(r1);
    }

    public MediaStoreVideoThumbLoader(Context r1) {
        this.context = r1.getApplicationContext();
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<InputStream> buildLoadData2(Uri r1, int r2, int r3, Options r4) {
        if (MediaStoreUtil.isThumbnailSize(r2, r3) == true) goto L5;
        return null;
    L5:
        if (isRequestingDefaultFrame(r4) == true) goto L7;
        return null;
    L7:
        return new ModelLoader.LoadData(new ObjectKey(r1), ThumbFetcher.buildVideoFetcher(this.context, r1));
    }

    private boolean isRequestingDefaultFrame(Options r3) {
        Long r2 = (Long) r3.get(VideoDecoder.TARGET_FRAME);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.longValue() != (-1)) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r1) {
        return MediaStoreUtil.isMediaStoreVideoUri(r1);
    }
}
