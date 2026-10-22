package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final ContentResolver contentResolver;

        ImageThumbnailQuery(ContentResolver r1) {
            this.contentResolver = r1;
        }

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r7) {
            String r8 = r7.getLastPathSegment();
            return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r8}, null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final ContentResolver contentResolver;

        VideoThumbnailQuery(ContentResolver r1) {
            this.contentResolver = r1;
        }

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r7) {
            String r8 = r7.getLastPathSegment();
            return this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r8}, null);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public static ThumbFetcher buildImageFetcher(Context r2, Uri r3) {
        return build(r2, r3, new ImageThumbnailQuery(r2.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context r2, Uri r3) {
        return build(r2, r3, new VideoThumbnailQuery(r2.getContentResolver()));
    }

    private static ThumbFetcher build(Context r3, Uri r4, ThumbnailQuery r5) {
        ArrayPool r0 = Glide.get(r3).getArrayPool();
        return new ThumbFetcher(r4, new ThumbnailStreamOpener(Glide.get(r3).getRegistry().getImageHeaderParsers(), r5, r0, r3.getContentResolver()));
    }

    ThumbFetcher(Uri r1, ThumbnailStreamOpener r2) {
        this.mediaStoreImageUri = r1;
        this.opener = r2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r2, DataFetcher.DataCallback<? super InputStream> r3) {
        InputStream r4 = openThumbInputStream();     // Catch: FileNotFoundException -> L4
        this.inputStream = r4;     // Catch: FileNotFoundException -> L4
        r3.onDataReady(r4);     // Catch: FileNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Failed to find thumbnail file", e);
    L8:
        r3.onLoadFailed(e);
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream r0 = this.opener.open(this.mediaStoreImageUri);
        if (r0 == null) goto L5;
        int r3 = this.opener.getOrientation(this.mediaStoreImageUri);
    L6:
        if (r3 != (-1)) goto L8;
        return r0;
    L8:
        return new ExifOrientationStream(r0, r3);
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r0 = this.inputStream;
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
