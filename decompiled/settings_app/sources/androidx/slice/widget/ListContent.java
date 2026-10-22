package androidx.slice.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.SliceMetadata;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListContent {
    private SliceItem mColorItem;
    private Context mContext;
    private int mGridBottomPadding;
    private int mGridTopPadding;
    private SliceItem mHeaderItem;
    private int mLargeHeight;
    private SliceItem mLayoutDirItem;
    private int mMaxSmallHeight;
    private int mMinScrollHeight;
    private ArrayList<SliceItem> mRowItems;
    private SliceItem mSeeMoreItem;
    private Slice mSlice;
    private List<SliceAction> mSliceActions;

    public ListContent(Context r7, Slice r8) {
        this(r7, r8, null, 0, 0);
    }

    public ListContent(Context r2, Slice r3, SliceStyle r4) {
        this.mRowItems = new ArrayList();
        init(r2, r3, r4);
        populate(r3);
    }

    public ListContent(Context r2, Slice r3, AttributeSet r4, int r5, int r6) {
        this.mRowItems = new ArrayList();
        init(r2, r3, null);
        if (r2 == null) goto L12;
        Resources.Theme r7 = r2.getTheme();
        if (r7 == null) goto L12;
        TypedArray r8 = r7.obtainStyledAttributes(r4, R.styleable.SliceView, r5, r6);
        this.mGridTopPadding = (int) r8.getDimension(R.styleable.SliceView_gridTopPadding, 0.0f);     // Catch: Throwable -> L9
        this.mGridBottomPadding = (int) r8.getDimension(R.styleable.SliceView_gridTopPadding, 0.0f);     // Catch: Throwable -> L9
        r8.recycle();
    L9:
        th = move-exception;
        r8.recycle();
        throw th;
    L12:
        populate(r3);
    }

    private void init(Context r2, Slice r3, SliceStyle r4) {
        this.mSlice = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.mContext = r2;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r0 = r4.getGridTopPadding();
    L9:
        this.mGridTopPadding = r0;
        if (r4 == null) goto L12;
        r5 = r4.getGridBottomPadding();
    L12:
        this.mGridBottomPadding = r5;
        if (r2 == null) goto L16;
        this.mMinScrollHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_min_height);
        this.mLargeHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_large_height);
        return;
    L16:
        return;
    L8:
        r0 = 0;
        goto L9
    }

    public void setMaxSmallHeight(int r1) {
        this.mMaxSmallHeight = r1;
    }

    private boolean populate(Slice r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        SliceItem r3 = null;
        this.mColorItem = SliceQuery.findTopLevelItem(r10, "int", "color", null, null);
        SliceItem r1 = SliceQuery.findTopLevelItem(r10, "int", "layout_direction", null, null);
        this.mLayoutDirItem = r1;
        if (r1 != null) goto L8;
    L11:
        this.mSliceActions = SliceMetadata.getSliceActions(r10);
        SliceItem r2 = findHeaderItem(r10);
        this.mHeaderItem = r2;
        if (r2 == null) goto L14;
        this.mRowItems.add(r2);
    L14:
        this.mSeeMoreItem = getSeeMoreItem(r10);
        List<SliceItem> r11 = r10.getItems();
        int r4 = 0;
    L16:
        if (r4 >= r11.size()) goto L33;
        SliceItem r5 = r11.get(r4);
        String r6 = r5.getFormat();
        if (r5.hasAnyHints(new String[]{"actions", "see_more", "keywords", "ttl", "last_updated"}) == true) goto L31;
        if ("action".equals(r6) == true) goto L24;
        if ("slice".equals(r6) == false) goto L31;
    L24:
        if (this.mHeaderItem != null) goto L29;
        if (r5.hasHint("list_item") == true) goto L29;
        this.mHeaderItem = r5;
        this.mRowItems.add(0, r5);
    L29:
        if (r5.hasHint("list_item") == false) goto L31;
        this.mRowItems.add(r5);
    L31:
        r4 = r4 + 1;
        goto L16
    L33:
        if (this.mHeaderItem != null) goto L38;
        if (this.mRowItems.size() < 1) goto L38;
        this.mHeaderItem = this.mRowItems.get(0);
    L38:
        return isValid();
    L8:
        if (SliceViewUtil.resolveLayoutDirection(r1.getInt()) == (-1)) goto L10;
        r3 = this.mLayoutDirItem;
    L10:
        this.mLayoutDirItem = r3;
        goto L11
    }

    public int getSmallHeight() {
        return getHeight(this.mHeaderItem, true, 0, 1, 1);
    }

    public int getLargeHeight(int r5, boolean r6) {
        int r0 = getListHeight(this.mRowItems);
        if (r5 <= 0) goto L5;
        r5 = Math.max(getSmallHeight(), r5);
    L5:
        if (r5 <= 0) goto L7;
        int r1 = r5;
    L9:
        if ((r0 - r1) < this.mMinScrollHeight) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r0 = r1;
    L17:
        if (r6 == false) goto L19;
        return r0;
    L19:
        return getListHeight(getItemsForNonScrollingList(r0));
    L14:
        if (r5 <= 0) goto L17;
        r0 = Math.min(r1, r0);
        goto L17
    L11:
        r2 = false;
        goto L12
    L7:
        r1 = this.mLargeHeight;
        goto L9
    }

    public int getListHeight(List<SliceItem> r13) {
        if (r13 != null) goto L5;
    L27:
        return 0;
    L5:
        if (this.mContext == null) goto L27;
        if (r13.isEmpty() == true) goto L10;
        SliceItem r1 = r13.get(0);
        boolean r4 = !r1.hasAnyHints(new String[]{"list_item", "horizontal"});
    L11:
        SliceItem r5 = r1;
        if (r13.size() == 1) goto L14;
    L17:
        int r2 = r13.size();
        int r3 = 0;
        int r11 = 0;
    L19:
        if (r3 >= r13.size()) goto L26;
        SliceItem r6 = r13.get(r3);
        if (r3 != 0) goto L24;
        if (r4 == false) goto L24;
        boolean r7 = true;
    L25:
        r11 = r11 + getHeight(r6, r7, r3, r2, 2);
        r3 = r3 + 1;
    L24:
        r7 = false;
        goto L25
    L26:
        return r11;
    L14:
        if (r5.hasHint("horizontal") == true) goto L17;
        return getHeight(r5, true, 0, 1, 2);
    L10:
        r1 = null;
        r4 = false;
        goto L11
    }

    public ArrayList<SliceItem> getItemsForNonScrollingList(int r14) {
        ArrayList<SliceItem> r0 = new ArrayList();
        ArrayList<SliceItem> r1 = this.mRowItems;
        if (r1 != null) goto L5;
    L41:
        return r0;
    L5:
        if (r1.size() == 0) goto L41;
        if (hasHeader() == false) goto L10;
        int r2 = 2;
    L12:
        if (this.mSeeMoreItem == null) goto L14;
        int r3 = new RowContent(this.mContext, this.mSeeMoreItem, false).getActualHeight(this.mMaxSmallHeight) + 0;
    L15:
        int r5 = this.mRowItems.size();
        int r12 = 0;
    L16:
        if (r12 >= r5) goto L32;
        if (r12 != 0) goto L19;
        boolean r6 = !this.mRowItems.get(r12).hasAnyHints(new String[]{"list_item", "horizontal"});
    L20:
        SliceItem r7 = this.mRowItems.get(r12);
        if (r12 != 0) goto L24;
        if (r6 == false) goto L24;
        boolean r8 = true;
    L25:
        int r9 = getHeight(r7, r8, r12, r5, 2);
        if (r14 <= 0) goto L30;
        if ((r3 + r9) > r14) goto L32;
    L30:
        r3 = r3 + r9;
        r0.add(this.mRowItems.get(r12));
        r12 = r12 + 1;
    L24:
        r8 = false;
        goto L25
    L19:
        r6 = false;
    L32:
        if (this.mSeeMoreItem == null) goto L39;
        if (r0.size() < r2) goto L39;
        if (r0.size() == r5) goto L39;
        r0.add(this.mSeeMoreItem);
    L39:
        if (r0.size() != 0) goto L41;
        r0.add(this.mRowItems.get(0));
        goto L41
    L14:
        r3 = 0;
        goto L15
    L10:
        r2 = 1;
        goto L12
    }

    private int getHeight(SliceItem r4, boolean r5, int r6, int r7, int r8) {
        int r1 = 0;
        if (this.mContext == null) goto L28;
        if (r4 == null) goto L28;
        if (r4.hasHint("horizontal") == false) goto L23;
        GridContent r9 = new GridContent(this.mContext, r4);
        if (r9.isAllImages() == false) goto L12;
        if (r6 != 0) goto L12;
        int r10 = this.mGridTopPadding;
    L14:
        if (r9.isAllImages() == true) goto L16;
    L18:
        if (r8 != 1) goto L20;
        int r3 = r9.getSmallHeight();
    L22:
        return (r3 + r10) + r1;
    L20:
        r3 = r9.getActualHeight();
        goto L22
    L16:
        if (r6 != (r7 - 1)) goto L18;
        r1 = this.mGridBottomPadding;
    L12:
        r10 = 0;
        goto L14
    L23:
        RowContent r11 = new RowContent(this.mContext, r4, r5);
        int r12 = this.mMaxSmallHeight;
        if (r8 != 1) goto L27;
        return r11.getSmallHeight(r12);
    L27:
        return r11.getActualHeight(r12);
    L28:
        return 0;
    }

    public boolean isValid() {
        if (this.mSlice != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRowItems.size() <= 0) goto L7;
        return true;
    }

    public Slice getSlice() {
        return this.mSlice;
    }

    public SliceItem getLayoutDirItem() {
        return this.mLayoutDirItem;
    }

    public SliceItem getColorItem() {
        return this.mColorItem;
    }

    public SliceItem getHeaderItem() {
        return this.mHeaderItem;
    }

    public List<SliceAction> getSliceActions() {
        return this.mSliceActions;
    }

    public SliceItem getSeeMoreItem() {
        return this.mSeeMoreItem;
    }

    public ArrayList<SliceItem> getRowItems() {
        return this.mRowItems;
    }

    public boolean hasHeader() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (isValidHeader(r0) == false) goto L7;
        return true;
    }

    public int getHeaderTemplateType() {
        return getRowType(this.mContext, this.mHeaderItem, true, this.mSliceActions);
    }

    public static int getRowType(Context r2, SliceItem r3, boolean r4, List<SliceAction> r5) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        if (r3.hasHint("horizontal") == false) goto L8;
        return 1;
    L8:
        RowContent r1 = new RowContent(r2, r3, r4);
        SliceItem r6 = r1.getPrimaryAction();
        if (r6 == null) goto L11;
        SliceActionImpl r7 = new SliceActionImpl(r6);
    L13:
        if (r1.getRange() == null) goto L20;
        if ("action".equals(r1.getRange().getFormat()) == false) goto L17;
        return 4;
    L17:
        return 5;
    L20:
        if (r7 != null) goto L22;
    L24:
        if (r4 == false) goto L35;
        if (r5 == null) goto L35;
        int r8 = 0;
    L28:
        if (r8 >= r5.size()) goto L33;
        if (r5.get(r8).isToggle() == true) goto L31;
        r8 = r8 + 1;
        goto L28
    L31:
        return 3;
    L33:
        return 0;
    L35:
        if (r1.getToggleItems().size() > 0) goto L37;
        return 0;
    L37:
        return 3;
    L22:
        if (r7.isToggle() == false) goto L24;
        return 3;
    L11:
        r7 = null;
        goto L13
    }

    public SliceItem getPrimaryAction() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
        SliceItem r1 = null;
    L10:
        if (r1 != null) goto L12;
        r1 = SliceQuery.find(this.mSlice, "action", new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"}, null);
    L12:
        if (r1 != null) goto L15;
        String r2 = (String) null;
        return SliceQuery.find(this.mSlice, "action", null, null);
    L15:
        return r1;
    L5:
        if (r0.hasHint("horizontal") == false) goto L7;
        r1 = new GridContent(this.mContext, this.mHeaderItem).getContentIntent();
        goto L10
    L7:
        r1 = new RowContent(this.mContext, this.mHeaderItem, false).getPrimaryAction();
        goto L10
    }

    private static SliceItem findHeaderItem(Slice r7) {
        SliceItem r8 = SliceQuery.find(r7, "slice", null, new String[]{"list_item", UserDictionaryAddWordContents.EXTRA_SHORTCUT, "actions", "keywords", "ttl", "last_updated", "horizontal"});
        if (r8 != null) goto L5;
    L7:
        return null;
    L5:
        if (isValidHeader(r8) == false) goto L7;
        return r8;
    }

    private static SliceItem getSeeMoreItem(Slice r4) {
        SliceItem r5 = SliceQuery.findTopLevelItem(r4, null, null, new String[]{"see_more"}, null);
        if (r5 != null) goto L5;
    L12:
        return null;
    L5:
        if ("slice".equals(r5.getFormat()) == false) goto L12;
        List<SliceItem> r0 = r5.getSlice().getItems();
        if (r0.size() == 1) goto L9;
        return r5;
    L9:
        if ("action".equals(r0.get(0).getFormat()) == true) goto L11;
        return r5;
    L11:
        return r0.get(0);
    }

    public static boolean isValidHeader(SliceItem r5) {
        if ("slice".equals(r5.getFormat()) == true) goto L5;
        return false;
    L5:
        if (r5.hasAnyHints(new String[]{"list_item", "actions", "keywords", "see_more"}) == true) goto L11;
        String r2 = (String) null;
        if (SliceQuery.find(r5, "text", null, null) == null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}
