package obric.tablet.dslv;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleFloatViewManager implements DragSortListView.FloatViewManager {
    private int mFloatBGColor;
    private Bitmap mFloatBitmap;
    private ImageView mImageView;
    private ListView mListView;
    private int mShadowPadding;
    private int paddingBottom;
    private int paddingTop;

    @Override // obric.tablet.dslv.DragSortListView.FloatViewManager
    public void onDragFloatView(View r1, Point r2, Point r3) {
    }

    public SimpleFloatViewManager(ListView r2) {
        this.mShadowPadding = 10;
        this.mFloatBGColor = -1;
        this.paddingTop = 0;
        this.paddingBottom = 0;
        this.mListView = r2;
    }

    public void setBackgroundColor(int r1) {
        this.mFloatBGColor = r1;
    }

    @Override // obric.tablet.dslv.DragSortListView.FloatViewManager
    public View onCreateFloatView(int r14) {
        ListView r0 = this.mListView;
        View r15 = r0.getChildAt((r14 + r0.getHeaderViewsCount()) - this.mListView.getFirstVisiblePosition());
        if (r15 != null) goto L5;
        return null;
    L5:
        int r1 = this.mShadowPadding;
        this.paddingBottom = r1;
        this.paddingTop = r1;
        r15.setPressed(false);
        r15.setDrawingCacheEnabled(true);
        Bitmap r3 = r15.getDrawingCache();
        int r4 = r3.getWidth();
        int r5 = (this.paddingTop + this.paddingBottom) + r3.getHeight();
        Bitmap r6 = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);
        this.mFloatBitmap = r6;
        r6.eraseColor(0);
        new Canvas(this.mFloatBitmap).drawBitmap(r3, new Rect(0, 0, r3.getWidth(), r3.getHeight()), new Rect(0, this.paddingTop, r3.getWidth(), r3.getHeight() + this.paddingTop), null);
        r15.setDrawingCacheEnabled(false);
        if (this.mImageView != null) goto L8;
        this.mImageView = new ImageView(this.mListView.getContext());
    L8:
        this.mImageView.setPadding(0, 0, 0, 0);
        this.mImageView.setImageBitmap(this.mFloatBitmap);
        this.mImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup r2 = (ViewGroup) this.mImageView.getParent();
        if (r2 == null) goto L11;
        r2.removeView(this.mImageView);
    L11:
        this.mImageView.setBackgroundColor(0);
        r15.setDrawingCacheEnabled(true);
        FrameLayout r16 = new FrameLayout(this.mListView.getContext());
        r16.setLayoutParams(new FrameLayout.LayoutParams(r4, r5));
        r16.addView(this.mImageView);
        return r16;
    }

    @Override // obric.tablet.dslv.DragSortListView.FloatViewManager
    public void onDestroyFloatView(View r2) {
        ImageView r3 = this.mImageView;
        if (r3 == null) goto L5;
        r3.setImageDrawable(null);
    L5:
        this.mFloatBitmap.recycle();
        this.mFloatBitmap = null;
    }

    @Override // obric.tablet.dslv.DragSortListView.FloatViewManager
    public int getPaddingTop() {
        return this.paddingTop;
    }

    @Override // obric.tablet.dslv.DragSortListView.FloatViewManager
    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setShadowPadding(int r1) {
        this.mShadowPadding = r1;
    }
}
