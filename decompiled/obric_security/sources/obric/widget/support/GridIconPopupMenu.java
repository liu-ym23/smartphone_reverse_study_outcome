package obric.widget.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;
import obric.app.IndicatorView;
import obric.view.PagerAdapter;
import obric.view.ViewPager;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class GridIconPopupMenu extends PopupMenu {
    private static final int MAX_ROW_NUM = 3;
    private int mColumnNum;
    private ArrayList<Drawable> mDrawables;
    private int mIconSize;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private IndicatorView mPageIndicator;
    private ArrayList<View> mPageViews;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    class MenuPageAdapter extends PagerAdapter {
        final /* synthetic */ GridIconPopupMenu this$0;

        @Override // obric.view.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            if (view != object) goto L4;
            return true;
        L4:
            return false;
        }

        MenuPageAdapter(final GridIconPopupMenu this$0) {
            this.this$0 = this$0;
        }

        @Override // obric.view.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) GridIconPopupMenu.access$400(this.this$0).get(position));
        }

        @Override // obric.view.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            View r0 = (View) GridIconPopupMenu.access$400(this.this$0).get(position);
            container.addView(r0);
            return r0;
        }

        @Override // obric.view.PagerAdapter
        public int getCount() {
            return GridIconPopupMenu.access$500(this.this$0);
        }
    }

    public interface OnMenuItemClickListener {
        void onMenuItemClick(int index);
    }

    static /* synthetic */ PagerAdapter access$000(GridIconPopupMenu r0) {
        return r0.mPagerAdapter;
    }

    static /* synthetic */ IndicatorView access$100(GridIconPopupMenu r0) {
        return r0.mPageIndicator;
    }

    static /* synthetic */ OnMenuItemClickListener access$200(GridIconPopupMenu r0) {
        return r0.mOnMenuItemClickListener;
    }

    static /* synthetic */ ViewPager access$300(GridIconPopupMenu r0) {
        return r0.mPager;
    }

    static /* synthetic */ ArrayList access$400(GridIconPopupMenu r0) {
        return r0.mPageViews;
    }

    static /* synthetic */ int access$500(GridIconPopupMenu r0) {
        return r0.getPageCount();
    }

    public GridIconPopupMenu(Context context, int numColumn) {
        super(context);
        this.mIconSize = 0;
        if (numColumn <= 0) goto L7;
        this.mColumnNum = numColumn;
        this.mContentAreaWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.popup_grid_menu_default_width);
        initMenuPanel();
        return;
    L7:
        throw new IllegalArgumentException("invalid args, the numColumn should be positive integer");
    }

    private void initMenuPanel() {
        this.mMenuPanelView = LayoutInflater.from(this.mContext).inflate(R.layout.grid_menu_layout, null);
        this.mPager = (ViewPager) this.mMenuPanelView.findViewById(R.id.viewpager);
        MenuPageAdapter r0 = new MenuPageAdapter(this);
        this.mPagerAdapter = r0;
        this.mPager.setAdapter(r0);
        this.mPageIndicator = (IndicatorView) this.mMenuPanelView.findViewById(R.id.indicator);
        this.mPager.setOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // obric.widget.support.PopupMenu
    protected void prepareShow() {
        createPageViews();
    }

    @Override // obric.widget.support.PopupMenu
    public void dismiss() {
        super.dismiss();
        this.mPageViews.clear();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        this.mOnMenuItemClickListener = menuItemClickListener;
    }

    private void createPageViews() {
        if (this.mPageViews != null) goto L5;
        this.mPageViews = new ArrayList(getPageCount());
    L5:
        this.mPageViews.clear();
        final int r0 = this.mColumnNum * 3;
        int r1 = 0;
    L7:
        if (r1 >= getPageCount()) goto L12;
        int r2 = r1 * r0;
        int r3 = r2 + r0;
        if (r1 != (getPageCount() - 1)) goto L11;
        r3 = this.mIconSize;
    L11:
        GridView r4 = (GridView) LayoutInflater.from(this.mContext).inflate(R.layout.icons_gridview_layout, null);
        r4.setNumColumns(this.mColumnNum);
        r4.setOnItemClickListener(new AnonymousClass2(this, r0));
        r4.setAdapter(new IconGridAdapter(this.mContext, this.mDrawables.subList(r2, r3)));
        this.mPageViews.add(r4);
        this.mPagerAdapter.notifyDataSetChanged();
        r1 = r1 + 1;
        goto L7
    L12:
        this.mPageIndicator.setState(this.mPagerAdapter.getCount(), this.mPager.getCurrentItem());
    }

    private int getPageCount() {
        return (int) Math.ceil((this.mIconSize * 1.0f) / (this.mColumnNum * 3));
    }

    public void setIcons(ArrayList<Drawable> icons) {
        this.mIconSize = icons.size();
        this.mDrawables = icons;
    }

    public void setIcons(int[] iconRes) {
        this.mIconSize = iconRes.length;
        if (this.mDrawables != null) goto L5;
        this.mDrawables = new ArrayList(iconRes.length);
    L5:
        this.mDrawables.clear();
        int r0 = 0;
    L7:
        if (r0 >= iconRes.length) goto L9;
        this.mDrawables.add(this.mContext.getDrawable(iconRes[r0]));
        r0 = r0 + 1;
        goto L7
    }
}
