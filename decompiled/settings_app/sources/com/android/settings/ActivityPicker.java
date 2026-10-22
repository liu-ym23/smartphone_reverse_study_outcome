package com.android.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.olog.OLog;
import com.obric.oui.banner.BannerData;
import com.obric.oui.banner.BannerViewHolder;
import com.obric.oui.banner.IBannerViewHolderFactory;
import com.obric.oui.banner.OBanner;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.simplified.ORoundedListItemText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPicker extends LifeHookActivity2 implements AdapterView.OnItemClickListener, View.OnClickListener {
    private static int mNumberPerPage = 8;
    private PickAdapter mAdapter;
    private Intent mBaseIntent;
    public OSheet mDialog;
    public View.OnClickListener mOnClickListener;

    class BannerPropData implements BannerData {
        int mPagerPosition;
        List<PickAdapter.Item> mitems;
        final /* synthetic */ ActivityPicker this$0;

        @Override // com.obric.oui.banner.BannerData
        public String getHolderKey() {
            return "_proportion_item";
        }

        BannerPropData(ActivityPicker r1, List<PickAdapter.Item> r2, int r3) {
            this.this$0 = r1;
            this.mitems = r2;
            this.mPagerPosition = r3;
        }
    }

    private static class BannerPropViewHolder extends BannerViewHolder {
        private Context mContext;
        private View.OnClickListener mOnClickListener;
        private View mViewPager;

        public static class Companion implements IBannerViewHolderFactory {
            private static final String KEY = "_proportion_item";
            private View.OnClickListener mOnClickListener;

            @Override // com.obric.oui.banner.IBannerViewHolderFactory
            public String getKey() {
                return KEY;
            }

            Companion(View.OnClickListener r1) {
                this.mOnClickListener = r1;
            }

            @Override // com.obric.oui.banner.IBannerViewHolderFactory
            public BannerViewHolder newInstance(ViewGroup r4) {
                return new BannerPropViewHolder(LayoutInflater.from(r4.getContext()).inflate(R.layout.item_viewpager, r4, false), r4.getContext(), this.mOnClickListener);
            }
        }

        public BannerPropViewHolder(View r1, Context r2, View.OnClickListener r3) {
            super(r1);
            this.mViewPager = r1;
            this.mContext = r2;
            this.mOnClickListener = r3;
        }

        public static Companion getCompanion(View.OnClickListener r1) {
            return new Companion(r1);
        }

        @Override // com.obric.oui.banner.BannerViewHolder
        public void onBind(BannerData r9) {
            BannerPropData r10 = (BannerPropData) r9;
            List<PickAdapter.Item> r0 = r10.mitems;
            int r11 = r10.mPagerPosition;
            LinearLayout r1 = (LinearLayout) this.mViewPager.findViewById(R.id.top_icon_container);
            r1.removeAllViews();
            LinearLayout r2 = (LinearLayout) this.mViewPager.findViewById(R.id.bottom_icon_container);
            r2.removeAllViews();
            if (r0.size() > (ActivityPicker.access$000() / 2)) goto L5;
            r2.setVisibility(8);
        L5:
            int r3 = ActivityPicker.access$000() * r11;
        L7:
            if (r3 >= r0.size()) goto L15;
            if (r3 >= ((r11 + 1) * ActivityPicker.access$000())) goto L20;
            View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.resolver_share_item, null, false);
            ImageView r5 = (ImageView) r4.findViewById(R.id.resolver_image_view);
            TextView r6 = (TextView) r4.findViewById(R.id.resolver_text_view);
            r5.setImageDrawable(r0.get(r3).icon);
            r6.setText(r0.get(r3).label);
            r4.setTag(Integer.valueOf(r3));
            r4.setOnClickListener(this.mOnClickListener);
            OLog.d("onBind", "onBind i:" + r3 + " label:" + r0.get(r3).label);
            if ((ActivityPicker.access$000() / 2) <= (r3 - (ActivityPicker.access$000() * r11))) goto L13;
            r1.addView(r4);
        L14:
            r3 = r3 + 1;
            goto L7
        L13:
            r2.addView(r4);
            goto L14
        L20:
            return;
        }
    }

    private static class EmptyDrawable extends Drawable {
        private final int mHeight;
        private final int mWidth;

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
        }

        EmptyDrawable(int r1, int r2) {
            this.mWidth = r1;
            this.mHeight = r2;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mHeight;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.mWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.mHeight;
        }
    }

    private static class IconResizer {
        private final Canvas mCanvas;
        private final int mIconHeight;
        private final int mIconWidth;
        private final DisplayMetrics mMetrics;
        private final Rect mOldBounds;

        public IconResizer(int r5, int r6, DisplayMetrics r7) {
            this.mOldBounds = new Rect();
            Canvas r0 = new Canvas();
            this.mCanvas = r0;
            r0.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
            this.mMetrics = r7;
            this.mIconWidth = r5;
            this.mIconHeight = r6;
        }

        public Drawable createIconThumbnail(Drawable r10) {
            int r0 = this.mIconWidth;
            int r1 = this.mIconHeight;
            if (r10 == null) goto L5;
            if ((r10 instanceof PaintDrawable) == false) goto L10;
            PaintDrawable r2 = (PaintDrawable) r10;     // Catch: Throwable -> L35
            r2.setIntrinsicWidth(r0);     // Catch: Throwable -> L35
            r2.setIntrinsicHeight(r1);     // Catch: Throwable -> L35
        L14:
            int r3 = r10.getIntrinsicWidth();     // Catch: Throwable -> L35
            int r4 = r10.getIntrinsicHeight();     // Catch: Throwable -> L35
            if (r3 <= 0) goto L38;
            if (r4 > 0) goto L18;
            return r10;
        L18:
            if (r0 < r3) goto L24;
            if (r1 < r4) goto L24;
            if (r3 >= r0) goto L40;
            if (r4 >= r1) goto L41;
            Bitmap r5 = Bitmap.createBitmap(this.mIconWidth, this.mIconHeight, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L35
            Canvas r6 = this.mCanvas;     // Catch: Throwable -> L35
            r6.setBitmap(r5);     // Catch: Throwable -> L35
            this.mOldBounds.set(r10.getBounds());     // Catch: Throwable -> L35
            int r7 = (r0 - r3) / 2;     // Catch: Throwable -> L35
            int r8 = (r1 - r4) / 2;     // Catch: Throwable -> L35
            r10.setBounds(r7, r8, r3 + r7, r4 + r8);     // Catch: Throwable -> L35
            r10.draw(r6);     // Catch: Throwable -> L35
            r10.setBounds(this.mOldBounds);     // Catch: Throwable -> L35
            BitmapDrawable r11 = new BitmapDrawable(r5);     // Catch: Throwable -> L35
            BitmapDrawable r9 = r11;     // Catch: Throwable -> L35
            r11.setTargetDensity(this.mMetrics);     // Catch: Throwable -> L35
            r6.setBitmap(null);     // Catch: Throwable -> L35
            return r11;
        L41:
            return r10;
        L40:
            return r10;
        L24:
            float r12 = r3 / r4;     // Catch: Throwable -> L35
            if (r3 <= r4) goto L27;
            r1 = (int) (r0 / r12);     // Catch: Throwable -> L35
        L30:
            if (r10.getOpacity() == (-1)) goto L32;
            Bitmap.Config r13 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L35
        L33:
            Bitmap r14 = Bitmap.createBitmap(this.mIconWidth, this.mIconHeight, r13);     // Catch: Throwable -> L35
            Canvas r15 = this.mCanvas;     // Catch: Throwable -> L35
            r15.setBitmap(r14);     // Catch: Throwable -> L35
            this.mOldBounds.set(r10.getBounds());     // Catch: Throwable -> L35
            int r16 = (this.mIconWidth - r0) / 2;     // Catch: Throwable -> L35
            int r17 = (this.mIconHeight - r1) / 2;     // Catch: Throwable -> L35
            r10.setBounds(r16, r17, r16 + r0, r17 + r1);     // Catch: Throwable -> L35
            r10.draw(r15);     // Catch: Throwable -> L35
            r10.setBounds(this.mOldBounds);     // Catch: Throwable -> L35
            BitmapDrawable r18 = new BitmapDrawable(r14);     // Catch: Throwable -> L35
            BitmapDrawable r19 = r18;     // Catch: Throwable -> L35
            r18.setTargetDensity(this.mMetrics);     // Catch: Throwable -> L35
            r15.setBitmap(null);     // Catch: Throwable -> L35
            return r18;
        L32:
            r13 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L35
            goto L33
        L27:
            if (r4 <= r3) goto L30;
            r0 = (int) (r1 * r12);     // Catch: Throwable -> L35
            goto L30
        L38:
            return r10;
        L10:
            if ((r10 instanceof BitmapDrawable) == false) goto L14;
            BitmapDrawable r20 = (BitmapDrawable) r10;     // Catch: Throwable -> L35
            if (r20.getBitmap().getDensity() != 0) goto L14;
            r20.setTargetDensity(this.mMetrics);     // Catch: Throwable -> L35
            goto L14
        L36:
            return new EmptyDrawable(r0, r1);
        L5:
            return new EmptyDrawable(r0, r1);
        }
    }

    protected static class PickAdapter extends BaseAdapter {
        private final LayoutInflater mInflater;
        private final List<Item> mItems;

        public static class Item implements AppWidgetLoader.LabelledItem {
            protected static IconResizer sResizer;
            String className;
            Bundle extras;
            Drawable icon;
            CharSequence label;
            String packageName;

            protected IconResizer getResizer(Context r2) {
                if (sResizer != null) goto L6;
                Resources r1 = r2.getResources();
                int r3 = (int) r1.getDimension(android.R.dimen.app_icon_size);
                sResizer = new IconResizer(r3, r3, r1.getDisplayMetrics());
            L6:
                return sResizer;
            }

            Item(Context r1, CharSequence r2, Drawable r3) {
                this.label = r2;
                this.icon = getResizer(r1).createIconThumbnail(r3);
            }

            Item(Context r2, PackageManager r3, ResolveInfo r4) {
                CharSequence r0 = r4.loadLabel(r3);
                this.label = r0;
                if (r0 == null) goto L5;
            L7:
                this.icon = getResizer(r2).createIconThumbnail(r4.loadIcon(r3));
                this.packageName = r4.activityInfo.applicationInfo.packageName;
                this.className = r4.activityInfo.name;
                return;
            L5:
                if (r4.activityInfo == null) goto L7;
                this.label = r4.activityInfo.name;
                goto L7
            }

            Intent getIntent(Intent r3) {
                Intent r0 = new Intent(r3);
                String r4 = this.packageName;
                if (r4 == null) goto L9;
                String r1 = this.className;
                if (r1 == null) goto L9;
                r0.setClassName(r4, r1);
                Bundle r2 = this.extras;
                if (r2 == null) goto L10;
                r0.putExtras(r2);
            L10:
                return r0;
            L9:
                r0.setAction("android.intent.action.CREATE_SHORTCUT");
                r0.putExtra("android.intent.extra.shortcut.NAME", this.label);
                goto L10
            }

            @Override // com.android.settings.AppWidgetLoader.LabelledItem
            public CharSequence getLabel() {
                return this.label;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public PickAdapter(Context r2, List<Item> r3) {
            this.mInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
            this.mItems = r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mItems.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = this.mInflater.inflate(R.layout.pick_item, r5, false);
        L4:
            ORoundedListItemText r6 = (ORoundedListItemText) r4.findViewById(R.id.item);
            Item r2 = (Item) getItem(r3);
            r6.setTitleString(r2.label);
            r6.setContentImage(r2.icon);
            return r4;
        }
    }

    static {
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_ActivityPicker_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ActivityPicker_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    public ActivityPicker() {
        this.mOnClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ int access$000() {
        return mNumberPerPage;
    }

    public void com_android_settings_ActivityPicker__onCreate$___twin___(Bundle r22) {
        super.onCreate(r22);
        Intent r1 = getIntent();
        Parcelable r2 = r1.getParcelableExtra("android.intent.extra.INTENT");     // Catch: Exception -> L33
        if ((r2 instanceof Intent) == false) goto L7;
        Intent r3 = (Intent) r2;
        this.mBaseIntent = r3;
        r3.setFlags(r3.getFlags() & NetError.ERR_TTNET_UNSUPPORTED_REDIRECT);
    L8:
        List<PickAdapter.Item> r4 = getItems();
        this.mAdapter = new PickAdapter(this, r4);
        int r5 = 0;
        this.mDialog = new OSheet(this, 0);
        new OFloatingTitleBar(this);
        if (r1.hasExtra("android.intent.extra.TITLE") == false) goto L11;
        String r6 = r1.getStringExtra("android.intent.extra.TITLE");
    L12:
        this.mDialog.setHeader(OSheet.Header.MODAL, null, null, r6, null, false, null, new AnonymousClass2(this), null, null, null, null, null, null);
        View r7 = LayoutInflater.from(this).inflate(R.layout.activity_picker_layout, null, false);
        OBanner r8 = (OBanner) r7.findViewById(R.id.o_banner);
        if (getResources().getConfiguration().orientation != 2) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L21;
        mNumberPerPage = 16;
        if (r4.size() > (mNumberPerPage / 2)) goto L20;
        r8.setProportion(6.0f);
    L25:
        r8.registerViewHolder(BannerPropViewHolder.getCompanion(this.mOnClickListener));
        r8.initViewPager2();
        ArrayList r10 = new ArrayList();
        int r11 = (r4.size() / mNumberPerPage) + 1;
        OLog.d("onCreate", "pageCount:" + r11 + " items.size():" + r4.size());
    L26:
        if (r5 >= r11) goto L28;
        r10.add(new BannerPropData(this, r4, r5));
        r5 = r5 + 1;
        goto L26
    L28:
        r8.setData(r10);
        ((OCarouselIndicator) r7.findViewById(R.id.o_carousel_indicator)).setViewPager2(r8.getViewPager2(), r11);
        this.mDialog.setBodyView(r7);
        this.mDialog.setOnCancelListener(new AnonymousClass3(this));
        if (this.mDialog.getWindow() == null) goto L31;
        this.mDialog.getWindow().setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);
    L31:
        this.mDialog.show();
        return;
    L20:
        r8.setProportion(3.0f);
        goto L25
    L21:
        mNumberPerPage = 8;
        if (r4.size() > (mNumberPerPage / 2)) goto L24;
        r8.setProportion(2.62f);
        goto L25
    L24:
        r8.setProportion(1.46f);
        goto L25
    L15:
        r9 = false;
        goto L16
    L11:
        r6 = getTitle().toString();
        goto L12
    L7:
        Intent r12 = new Intent("android.intent.action.MAIN", null);
        this.mBaseIntent = r12;
        r12.addCategory("android.intent.category.DEFAULT");
    L33:
        e = move-exception;
        e.printStackTrace();
    }

    private List<OSelectionPanelView.SelectionItemData> convertToSelectionItemDataList(List<PickAdapter.Item> r5) {
        ArrayList r4 = new ArrayList();
        Iterator<PickAdapter.Item> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        PickAdapter.Item r0 = r6.next();
        String r1 = r0.label.toString();
        r4.add(new OSelectionPanelView.SelectionItemData(r0.icon, r1, null));
        goto L4
    L6:
        return r4;
    }

    public void onClick(DialogInterface r1, int r2) {
        setResult(-1, getIntentForPosition(r2));
        finish();
    }

    public void onCancel(DialogInterface r1) {
        setResult(0);
        finish();
    }

    protected Intent getIntentForPosition(int r2) {
        return ((PickAdapter.Item) this.mAdapter.getItem(r2)).getIntent(this.mBaseIntent);
    }

    protected List<PickAdapter.Item> getItems() {
        PackageManager r0 = getPackageManager();
        ArrayList r1 = new ArrayList();
        Intent r2 = getIntent();
        ArrayList<String> r3 = r2.getStringArrayListExtra("android.intent.extra.shortcut.NAME");
        ArrayList r4 = r2.getParcelableArrayListExtra("android.intent.extra.shortcut.ICON_RESOURCE");
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        if (r3.size() != r4.size()) goto L13;
        int r5 = 0;
    L9:
        if (r5 >= r3.size()) goto L13;
        String r6 = r3.get(r5);
        Drawable r7 = null;
        Intent.ShortcutIconResource r8 = (Intent.ShortcutIconResource) r4.get(r5);     // Catch: PackageManager.NameNotFoundException -> L17
        Resources r9 = r0.getResourcesForApplication(r8.packageName);     // Catch: PackageManager.NameNotFoundException -> L17
        r7 = r9.getDrawable(r9.getIdentifier(r8.resourceName, null, null), null);     // Catch: PackageManager.NameNotFoundException -> L17
    L12:
        r1.add(new PickAdapter.Item(this, r6, r7));
        r5 = r5 + 1;
    L13:
        Intent r10 = this.mBaseIntent;
        if (r10 == null) goto L16;
        putIntentItems(r10, r1);
    L16:
        return r1;
    }

    protected void putIntentItems(Intent r6, List<PickAdapter.Item> r7) {
        PackageManager r0 = getPackageManager();
        int r1 = 0;
        List<ResolveInfo> r8 = r0.queryIntentActivities(r6, 0);
        Collections.sort(r8, new ResolveInfo.DisplayNameComparator(r0));
        int r2 = r8.size();
    L3:
        if (r1 >= r2) goto L5;
        r7.add(new PickAdapter.Item(this, r0, r8.get(r1)));
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        setResult(-1, getIntentForPosition(r3));
        finish();
    }

    public void com_android_settings_ActivityPicker__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Insert("onCreate")
    public static void com_android_settings_ActivityPicker_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(ActivityPicker r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActivityPicker r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ActivityPicker__onCreate$___twin___(r4);
    }

    @Insert("finish")
    public static void com_android_settings_ActivityPicker_com_obric_hook_lancet_PrivacyHookActivity2_finish(ActivityPicker r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActivityPicker r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ActivityPicker__finish$___twin___();
    }
}
