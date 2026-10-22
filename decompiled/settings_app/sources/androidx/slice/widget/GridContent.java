package androidx.slice.widget;

import android.content.Context;
import android.content.res.Resources;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GridContent {
    private boolean mAllImages;
    private int mAllImagesHeight;
    private int mBigPicMaxHeight;
    private int mBigPicMinHeight;
    private SliceItem mColorItem;
    private SliceItem mContentDescr;
    private ArrayList<CellContent> mGridContent;
    private boolean mHasImage;
    private int mImageTextHeight;
    private int mLargestImageMode;
    private SliceItem mLayoutDirItem;
    private int mMaxCellLineCount;
    private int mMaxHeight;
    private int mMinHeight;
    private SliceItem mPrimaryAction;
    private SliceItem mSeeMoreItem;
    private SliceItem mTitleItem;

    public static class CellContent {
        private ArrayList<SliceItem> mCellItems;
        private SliceItem mContentDescr;
        private SliceItem mContentIntent;
        private boolean mHasImage;
        private int mImageMode;
        private int mTextCount;
        private SliceItem mTitleItem;

        public CellContent(SliceItem r2) {
            this.mCellItems = new ArrayList();
            this.mImageMode = -1;
            populate(r2);
        }

        public boolean populate(SliceItem r9) {
            String r0 = r9.getFormat();
            if (r9.hasHint(UserDictionaryAddWordContents.EXTRA_SHORTCUT) == true) goto L51;
            if ("slice".equals(r0) == false) goto L7;
        L8:
            List<SliceItem> r2 = r9.getSlice().getItems();
            if (r2.size() != 1) goto L16;
            if ("action".equals(r2.get(0).getFormat()) == false) goto L13;
        L14:
            this.mContentIntent = r2.get(0);
            r2 = r2.get(0).getSlice().getItems();
            goto L16
        L13:
            if ("slice".equals(r2.get(0).getFormat()) == true) goto L14;
        L16:
            if ("action".equals(r0) == false) goto L18;
            this.mContentIntent = r9;
        L18:
            this.mTextCount = 0;
            int r10 = 0;
            int r1 = 0;
        L20:
            if (r10 >= r2.size()) goto L54;
            SliceItem r3 = r2.get(r10);
            String r4 = r3.getFormat();
            if ("content_description".equals(r3.getSubType()) == false) goto L24;
            this.mContentDescr = r3;
        L49:
            r10 = r10 + 1;
            goto L20
        L24:
            int r7 = 2;
            if (this.mTextCount < 2) goto L27;
        L37:
            if (r1 >= 1) goto L49;
            if (SlardarSettingsConsts.SETTING_IMAGE.equals(r3.getFormat()) == false) goto L49;
            if (r3.hasHint("no_tint") == true) goto L43;
            this.mImageMode = 0;
        L48:
            r1 = r1 + 1;
            this.mHasImage = true;
            this.mCellItems.add(r3);
            goto L49
        L43:
            if (r3.hasHint("large") == true) goto L46;
            r7 = 1;
        L46:
            this.mImageMode = r7;
            goto L48
        L27:
            if ("text".equals(r4) == false) goto L29;
        L30:
            this.mTextCount++;
            this.mCellItems.add(r3);
            SliceItem r5 = this.mTitleItem;
            if (r5 != null) goto L33;
        L36:
            this.mTitleItem = r3;
            goto L49
        L33:
            if (r5.hasHint("title") == true) goto L49;
            if (r3.hasHint("title") == false) goto L49;
        L29:
            if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r4) == false) goto L37;
        L54:
            return isValid();
        L7:
            if ("action".equals(r0) == true) goto L8;
        L51:
            if (isValidCellContent(r9) == false) goto L54;
            this.mCellItems.add(r9);
            goto L54
        }

        public SliceItem getTitleItem() {
            return this.mTitleItem;
        }

        public SliceItem getContentIntent() {
            return this.mContentIntent;
        }

        public ArrayList<SliceItem> getCellItems() {
            return this.mCellItems;
        }

        private boolean isValidCellContent(SliceItem r6) {
            String r5 = r6.getFormat();
            if ("content_description".equals(r6.getSubType()) == false) goto L5;
        L8:
            boolean r7 = true;
        L9:
            if (r7 == false) goto L11;
            return false;
        L11:
            if ("text".equals(r5) == true) goto L17;
            if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r5) == true) goto L17;
            if (SlardarSettingsConsts.SETTING_IMAGE.equals(r5) == true) goto L17;
            return false;
        L17:
            return true;
        L5:
            if (r6.hasAnyHints(new String[]{"keywords", "ttl", "last_updated"}) == true) goto L8;
            r7 = false;
            goto L9
        }

        public boolean isValid() {
            if (this.mCellItems.size() > 0) goto L5;
        L7:
            return false;
        L5:
            if (this.mCellItems.size() > 3) goto L7;
            return true;
        }

        public boolean isImageOnly() {
            if (this.mCellItems.size() == 1) goto L5;
            return false;
        L5:
            if (SlardarSettingsConsts.SETTING_IMAGE.equals(this.mCellItems.get(0).getFormat()) == true) goto L7;
            return false;
        L7:
            return true;
        }

        public int getTextCount() {
            return this.mTextCount;
        }

        public boolean hasImage() {
            return this.mHasImage;
        }

        public int getImageMode() {
            return this.mImageMode;
        }

        public CharSequence getContentDescription() {
            SliceItem r0 = this.mContentDescr;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getText();
        }
    }

    public GridContent(Context r2, SliceItem r3) {
        this.mGridContent = new ArrayList();
        this.mLargestImageMode = 3;
        populate(r3);
        if (r2 == null) goto L6;
        Resources r4 = r2.getResources();
        this.mBigPicMinHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_big_pic_min_height);
        this.mBigPicMaxHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_big_pic_max_height);
        this.mAllImagesHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_grid_image_only_height);
        this.mImageTextHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_grid_image_text_height);
        this.mMinHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_grid_min_height);
        this.mMaxHeight = r4.getDimensionPixelSize(R.dimen.abc_slice_grid_max_height);
        return;
    }

    private boolean populate(SliceItem r6) {
        this.mColorItem = SliceQuery.findSubtype(r6, "int", "color");
        if ("slice".equals(r6.getFormat()) == false) goto L5;
    L6:
        SliceItem r0 = SliceQuery.findTopLevelItem(r6.getSlice(), "int", "layout_direction", null, null);
        this.mLayoutDirItem = r0;
        if (r0 != null) goto L9;
    L13:
        SliceItem r1 = SliceQuery.find(r6, null, "see_more", null);
        this.mSeeMoreItem = r1;
        int r2 = 0;
        if (r1 != null) goto L16;
    L22:
        this.mPrimaryAction = SliceQuery.find(r6, "slice", new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"}, new String[]{"actions"});
        this.mAllImages = true;
        if ("slice".equals(r6.getFormat()) == false) goto L32;
        List<SliceItem> r7 = filterAndProcessItems(r6.getSlice().getItems());
    L26:
        if (r2 >= r7.size()) goto L34;
        SliceItem r3 = r7.get(r2);
        if ("content_description".equals(r3.getSubType()) == false) goto L30;
        this.mContentDescr = r3;
    L31:
        r2 = r2 + 1;
        goto L26
    L30:
        processContent(new CellContent(r3));
    L34:
        return isValid();
    L32:
        processContent(new CellContent(r6));
        goto L34
    L16:
        if ("slice".equals(r1.getFormat()) == false) goto L22;
        List<SliceItem> r4 = this.mSeeMoreItem.getSlice().getItems();
        if (r4 == null) goto L22;
        if (r4.size() <= 0) goto L22;
        this.mSeeMoreItem = r4.get(0);
        goto L22
    L9:
        if (SliceViewUtil.resolveLayoutDirection(r0.getInt()) == (-1)) goto L11;
        SliceItem r5 = this.mLayoutDirItem;
    L12:
        this.mLayoutDirItem = r5;
        goto L13
    L11:
        r5 = null;
        goto L12
    L5:
        if ("action".equals(r6.getFormat()) == false) goto L13;
        goto L6
    }

    private void processContent(CellContent r3) {
        if (r3.isValid() == true) goto L5;
        return;
    L5:
        if (this.mTitleItem == null) goto L7;
    L9:
        this.mGridContent.add(r3);
        if (r3.isImageOnly() == true) goto L12;
        this.mAllImages = false;
    L12:
        this.mMaxCellLineCount = Math.max(this.mMaxCellLineCount, r3.getTextCount());
        this.mHasImage |= r3.hasImage();
        int r0 = this.mLargestImageMode;
        if (r0 != 3) goto L15;
        int r4 = r3.getImageMode();
    L16:
        this.mLargestImageMode = r4;
        return;
    L15:
        r4 = Math.max(r0, r3.getImageMode());
        goto L16
    L7:
        if (r3.getTitleItem() == null) goto L9;
        this.mTitleItem = r3.getTitleItem();
        goto L9
    }

    public CharSequence getTitle() {
        SliceItem r0 = this.mTitleItem;
        if (r0 == null) goto L7;
        return r0.getText();
    L7:
        if (this.mPrimaryAction != null) goto L9;
        return null;
    L9:
        return new SliceActionImpl(this.mPrimaryAction).getTitle();
    }

    public ArrayList<CellContent> getGridContent() {
        return this.mGridContent;
    }

    public SliceItem getLayoutDirItem() {
        return this.mLayoutDirItem;
    }

    public SliceItem getColorItem() {
        return this.mColorItem;
    }

    public SliceItem getContentIntent() {
        return this.mPrimaryAction;
    }

    public SliceItem getSeeMoreItem() {
        return this.mSeeMoreItem;
    }

    public CharSequence getContentDescription() {
        SliceItem r0 = this.mContentDescr;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    public boolean isValid() {
        if (this.mGridContent.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAllImages() {
        return this.mAllImages;
    }

    public int getLargestImageMode() {
        return this.mLargestImageMode;
    }

    private List<SliceItem> filterAndProcessItems(List<SliceItem> r11) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= r11.size()) goto L20;
        SliceItem r3 = r11.get(r2);
        boolean r6 = true;
        if (SliceQuery.find(r3, null, "see_more", null) == null) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L15;
        if (r3.hasAnyHints(new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT, "see_more", "keywords", "ttl", "last_updated"}) == true) goto L15;
        r6 = false;
    L15:
        if ("content_description".equals(r3.getSubType()) == false) goto L17;
        this.mContentDescr = r3;
    L19:
        r2 = r2 + 1;
        goto L4
    L17:
        if (r6 == true) goto L19;
        r0.add(r3);
        goto L19
    L8:
        r4 = false;
        goto L9
    L20:
        return r0;
    }

    public int getMaxCellLineCount() {
        return this.mMaxCellLineCount;
    }

    public boolean hasImage() {
        return this.mHasImage;
    }

    public int getSmallHeight() {
        return getHeight(true);
    }

    public int getActualHeight() {
        return getHeight(false);
    }

    private int getHeight(boolean r7) {
        boolean r1 = false;
        if (isValid() == true) goto L6;
        return 0;
    L6:
        if (this.mAllImages == false) goto L18;
        if (this.mGridContent.size() != 1) goto L13;
        if (r7 == false) goto L35;
        return this.mBigPicMinHeight;
    L35:
        return this.mBigPicMaxHeight;
    L13:
        if (this.mLargestImageMode != 0) goto L16;
        return this.mMinHeight;
    L16:
        return this.mAllImagesHeight;
    L18:
        if (getMaxCellLineCount() <= 1) goto L20;
        boolean r0 = true;
    L21:
        boolean r3 = hasImage();
        int r4 = this.mLargestImageMode;
        if (r4 != 0) goto L24;
    L25:
        r1 = true;
    L26:
        if (r0 == false) goto L30;
        if (r7 == true) goto L30;
        if (r3 == false) goto L38;
        return this.mMaxHeight;
    L38:
        return this.mMinHeight;
    L30:
        if (r1 == true) goto L38;
        return this.mImageTextHeight;
    L24:
        if (r4 != 3) goto L26;
    L20:
        r0 = false;
        goto L21
    }
}
