package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public void onMapSharedElements(List<String> r1, Map<String, View> r2) {
    }

    public void onRejectSharedElements(List<View> r1) {
    }

    public void onSharedElementEnd(List<String> r1, List<View> r2, List<View> r3) {
    }

    public void onSharedElementStart(List<String> r1, List<View> r2, List<View> r3) {
    }

    public SharedElementCallback() {
    }

    public Parcelable onCaptureSharedElementSnapshot(View r5, Matrix r6, RectF r7) {
        if ((r5 instanceof ImageView) == false) goto L13;
        ImageView r0 = (ImageView) r5;
        Drawable r1 = r0.getDrawable();
        Drawable r2 = r0.getBackground();
        if (r1 == null) goto L13;
        if (r2 != null) goto L13;
        Bitmap r3 = createDrawableBitmap(r1);
        if (r3 == null) goto L13;
        Bundle r4 = new Bundle();
        r4.putParcelable(BUNDLE_SNAPSHOT_BITMAP, r3);
        r4.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, r0.getScaleType().toString());
        if (r0.getScaleType() != ImageView.ScaleType.MATRIX) goto L12;
        float[] r8 = new float[9];
        r0.getImageMatrix().getValues(r8);
        r4.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, r8);
    L12:
        return r4;
    L13:
        int r9 = Math.round(r7.width());
        int r10 = Math.round(r7.height());
        if (r9 <= 0) goto L20;
        if (r10 <= 0) goto L20;
        float r11 = Math.min(1.0f, 1048576.0f / (r9 * r10));
        int r12 = (int) (r9 * r11);
        int r13 = (int) (r10 * r11);
        if (this.mTempMatrix != null) goto L19;
        this.mTempMatrix = new Matrix();
    L19:
        this.mTempMatrix.set(r6);
        this.mTempMatrix.postTranslate(-r7.left, -r7.top);
        this.mTempMatrix.postScale(r11, r11);
        Bitmap r14 = Bitmap.createBitmap(r12, r13, Bitmap.Config.ARGB_8888);
        Canvas r15 = new Canvas(r14);
        r15.concat(this.mTempMatrix);
        r5.draw(r15);
        return r14;
    L20:
        return null;
    }

    private static Bitmap createDrawableBitmap(Drawable r9) {
        int r0 = r9.getIntrinsicWidth();
        int r1 = r9.getIntrinsicHeight();
        if (r0 <= 0) goto L14;
        if (r1 <= 0) goto L16;
        float r3 = Math.min(1.0f, 1048576.0f / (r0 * r1));
        if ((r9 instanceof BitmapDrawable) == true) goto L9;
    L12:
        int r2 = (int) (r0 * r3);
        int r4 = (int) (r1 * r3);
        Bitmap r5 = Bitmap.createBitmap(r2, r4, Bitmap.Config.ARGB_8888);
        Canvas r6 = new Canvas(r5);
        Rect r7 = r9.getBounds();
        int r8 = r7.left;
        int r10 = r7.top;
        int r11 = r7.right;
        int r12 = r7.bottom;
        r9.setBounds(0, 0, r2, r4);
        r9.draw(r6);
        r9.setBounds(r8, r10, r11, r12);
        return r5;
    L9:
        if (r3 != 1.0f) goto L12;
        return ((BitmapDrawable) r9).getBitmap();
    L16:
        return null;
    L14:
        return null;
    }

    public View onCreateSnapshotView(Context r2, Parcelable r3) {
        if ((r3 instanceof Bundle) == false) goto L11;
        Bundle r4 = (Bundle) r3;
        Bitmap r1 = (Bitmap) r4.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
        if (r1 != null) goto L7;
        return null;
    L7:
        ImageView r0 = new ImageView(r2);
        r0.setImageBitmap(r1);
        r0.setScaleType(ImageView.ScaleType.valueOf(r4.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
        if (r0.getScaleType() != ImageView.ScaleType.MATRIX) goto L14;
        float[] r5 = r4.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
        Matrix r6 = new Matrix();
        r6.setValues(r5);
        r0.setImageMatrix(r6);
        return r0;
    L14:
        return r0;
    L11:
        if ((r3 instanceof Bitmap) == false) goto L16;
        ImageView r7 = new ImageView(r2);
        r7.setImageBitmap((Bitmap) r3);
        return r7;
    L16:
        return null;
    }

    public void onSharedElementsArrived(List<String> r1, List<View> r2, OnSharedElementsReadyListener r3) {
        r3.onSharedElementsReady();
    }
}
