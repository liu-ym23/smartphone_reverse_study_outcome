package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class PrintHelper {

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;

    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions;
    final Object mLock;
    int mOrientation;
    int mScaleMode;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @RequiresApi(19)
    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;
        final /* synthetic */ PrintHelper this$0;

        PrintBitmapAdapter(PrintHelper r1, String r2, int r3, Bitmap r4, OnPrintFinishCallback r5) {
            this.this$0 = r1;
            this.mJobName = r2;
            this.mFittingMode = r3;
            this.mBitmap = r4;
            this.mCallback = r5;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback r0 = this.mCallback;
            if (r0 == null) goto L6;
            r0.onFinish();
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes r1, PrintAttributes r2, CancellationSignal r3, PrintDocumentAdapter.LayoutResultCallback r4, Bundle r5) {
            this.mAttributes = r2;
            r4.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r2.equals(r1));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r8, ParcelFileDescriptor r9, CancellationSignal r10, PrintDocumentAdapter.WriteResultCallback r11) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r9, r10, r11);
        }
    }

    @RequiresApi(19)
    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ PrintHelper this$0;

        PrintUriAdapter(PrintHelper r1, String r2, Uri r3, OnPrintFinishCallback r4, int r5) {
            this.this$0 = r1;
            this.mJobName = r2;
            this.mImageFile = r3;
            this.mCallback = r4;
            this.mFittingMode = r5;
            this.mBitmap = null;
        }

        void cancelLoad() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            BitmapFactory.Options r1 = this.this$0.mDecodeOptions;     // Catch: Throwable -> L12
            if (r1 != null) goto L7;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L7:
            if (Build.VERSION.SDK_INT >= 24) goto L9;
            r1.requestCancelDecode();     // Catch: Throwable -> L12
        L9:
            this.this$0.mDecodeOptions = null;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> r0 = this.mLoadBitmap;
            if (r0 == null) goto L5;
            r0.cancel(true);
        L5:
            OnPrintFinishCallback r1 = this.mCallback;
            if (r1 == null) goto L8;
            r1.onFinish();
        L8:
            Bitmap r2 = this.mBitmap;
            if (r2 == null) goto L12;
            r2.recycle();
            this.mBitmap = null;
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes r7, final PrintAttributes r8, final CancellationSignal r9, final PrintDocumentAdapter.LayoutResultCallback r10, Bundle r11) {
            monitor-enter(this);
            this.mAttributes = r8;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r9.isCanceled() == false) goto L10;
            r10.onLayoutCancelled();
            return;
        L10:
            if (this.mBitmap == null) goto L13;
            r10.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r8.equals(r7));
            return;
        L13:
            this.mLoadBitmap = new AnonymousClass1(this, r9, r8, r7, r10).execute(new Uri[0]);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r8, ParcelFileDescriptor r9, CancellationSignal r10, PrintDocumentAdapter.WriteResultCallback r11) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r9, r10, r11);
        }
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r0 < 20) goto L7;
        if (r0 > 23) goto L7;
        boolean r4 = false;
    L8:
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = r4;
        if (r0 == 23) goto L11;
        r1 = true;
    L11:
        IS_MIN_MARGINS_HANDLING_CORRECT = r1;
        return;
    L7:
        r4 = true;
        goto L8
    }

    public PrintHelper(@NonNull Context r2) {
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = r2;
    }

    static Bitmap convertBitmapForColorMode(Bitmap r5, int r6) {
        if (r6 == 1) goto L5;
        return r5;
    L5:
        Bitmap r7 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r7);
        Paint r1 = new Paint();
        ColorMatrix r2 = new ColorMatrix();
        r2.setSaturation(0.0f);
        r1.setColorFilter(new ColorMatrixColorFilter(r2));
        r0.drawBitmap(r5, 0.0f, 0.0f, r1);
        r0.setBitmap(null);
        return r7;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes r3) {
        PrintAttributes.Builder r0 = new PrintAttributes.Builder().setMediaSize(r3.getMediaSize()).setResolution(r3.getResolution()).setMinMargins(r3.getMinMargins());
        if (r3.getColorMode() == 0) goto L6;
        r0.setColorMode(r3.getColorMode());
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L10:
        return r0;
    L8:
        if (r3.getDuplexMode() == 0) goto L10;
        r0.setDuplexMode(r3.getDuplexMode());
        goto L10
    }

    static Matrix getMatrix(int r3, int r4, RectF r5, int r6) {
        Matrix r0 = new Matrix();
        float r7 = r3;
        float r1 = r5.width() / r7;
        if (r6 != 2) goto L5;
        float r8 = Math.max(r1, r5.height() / r4);
    L6:
        r0.postScale(r8, r8);
        r0.postTranslate((r5.width() - (r7 * r8)) / 2.0f, (r5.height() - (r4 * r8)) / 2.0f);
        return r0;
    L5:
        r8 = Math.min(r1, r5.height() / r4);
        goto L6
    }

    static boolean isPortrait(Bitmap r1) {
        if (r1.getWidth() > r1.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    private Bitmap loadBitmap(Uri r4, BitmapFactory.Options r5) {
        if (r4 == null) goto L25;
        Context r3 = this.mContext;
        if (r3 == null) goto L25;
        InputStream r2 = null;
        InputStream r6 = r3.getContentResolver().openInputStream(r4);     // Catch: Throwable -> L17
        Bitmap r7 = BitmapFactory.decodeStream(r6, null, r5);     // Catch: Throwable -> L15
        if (r6 != null) goto L30;
    L14:
        return r7;
    L30:
        r6.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L15:
        th = th;
        r2 = r6;
    L18:
        if (r2 != null) goto L32;
    L23:
        throw th;
    L32:
        r2.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        Log.w(LOG_TAG, "close fail ", e);
    L17:
        th = th;
    L25:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    public static boolean systemSupportsPrint() {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        return true;
    L5:
        return false;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if (this.mOrientation != 0) goto L9;
        return 1;
    L9:
        return this.mOrientation;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    Bitmap loadConstrainedBitmap(Uri r8) {
        if (r8 == null) goto L44;
        if (this.mContext == null) goto L44;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        loadBitmap(r8, r0);
        int r2 = r0.outWidth;
        int r1 = r0.outHeight;
        if (r2 <= 0) goto L42;
        if (r1 <= 0) goto L42;
        int r4 = Math.max(r2, r1);
        int r5 = 1;
    L11:
        if (r4 <= MAX_PRINT_SIZE) goto L13;
        r4 = r4 >>> 1;
        r5 = r5 << 1;
        goto L11
    L13:
        if (r5 <= 0) goto L42;
        if ((Math.min(r2, r1) / r5) <= 0) goto L42;
        Object r3 = this.mLock;
        monitor-enter(r3);
        BitmapFactory.Options r6 = new BitmapFactory.Options();     // Catch: Throwable -> L39
        this.mDecodeOptions = r6;     // Catch: Throwable -> L39
        r6.inMutable = true;     // Catch: Throwable -> L39
        r6.inSampleSize = r5;     // Catch: Throwable -> L39
        monitor-exit(r3);     // Catch: Throwable -> L39
        Bitmap r9 = loadBitmap(r8, r6);     // Catch: Throwable -> L30
        Object r7 = this.mLock;
        monitor-enter(r7);
        this.mDecodeOptions = null;     // Catch: Throwable -> L27
        monitor-exit(r7);     // Catch: Throwable -> L27
        return r9;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mDecodeOptions = null;     // Catch: Throwable -> L36
        throw th;
    L36:
        th = move-exception;
        throw th;
    L39:
        th = move-exception;
        throw th;
    L42:
        return null;
    L44:
        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    public void printBitmap(@NonNull String r2, @NonNull Bitmap r3) {
        printBitmap(r2, r3, null);
    }

    public void printBitmap(@NonNull String r10, @NonNull Bitmap r11, @Nullable OnPrintFinishCallback r12) {
        if (Build.VERSION.SDK_INT < 19) goto L12;
        if (r11 == null) goto L13;
        PrintManager r0 = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(r11) == false) goto L9;
        PrintAttributes.MediaSize r1 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L10:
        PrintAttributes r2 = new PrintAttributes.Builder().setMediaSize(r1).setColorMode(this.mColorMode).build();
        r0.print(r10, new PrintBitmapAdapter(this, r10, this.mScaleMode, r11, r12), r2);
        return;
    L9:
        r1 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L10
    L13:
        return;
    }

    public void printBitmap(@NonNull String r2, @NonNull Uri r3) {
        printBitmap(r2, r3, null);
    }

    public void printBitmap(@NonNull String r9, @NonNull Uri r10, @Nullable OnPrintFinishCallback r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        PrintUriAdapter r0 = new PrintUriAdapter(this, r9, r10, r11, this.mScaleMode);
        PrintManager r12 = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder r13 = new PrintAttributes.Builder();
        r13.setColorMode(this.mColorMode);
        int r8 = this.mOrientation;
        if (r8 == 1) goto L12;
        if (r8 == 0) goto L12;
        if (r8 != 2) goto L14;
        PrintAttributes.MediaSize r14 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L13:
        r13.setMediaSize(r14);
    L14:
        r12.print(r9, r0, r13.build());
        return;
    L12:
        r14 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L13
    }

    public void setColorMode(int r1) {
        this.mColorMode = r1;
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    public void setScaleMode(int r1) {
        this.mScaleMode = r1;
    }

    @RequiresApi(19)
    void writeBitmap(final PrintAttributes r12, final int r13, final Bitmap r14, final ParcelFileDescriptor r15, final CancellationSignal r16, final PrintDocumentAdapter.WriteResultCallback r17) {
        if (IS_MIN_MARGINS_HANDLING_CORRECT == false) goto L5;
        final PrintAttributes r5 = r12;
    L6:
        new AnonymousClass1(this, r16, r5, r14, r12, r13, r15, r17).execute(new Void[0]);
        return;
    L5:
        r5 = copyAttributes(r12).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        goto L6
    }
}
