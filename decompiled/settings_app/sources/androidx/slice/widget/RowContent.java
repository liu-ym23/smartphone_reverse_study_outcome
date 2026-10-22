package androidx.slice.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RowContent {
    private static final String TAG = "RowContent";
    private SliceItem mContentDescr;
    private ArrayList<SliceItem> mEndItems;
    private boolean mEndItemsContainAction;
    private boolean mIsHeader;
    private SliceItem mLayoutDirItem;
    private int mLineCount;
    private int mMaxHeight;
    private int mMinHeight;
    private SliceItem mPrimaryAction;
    private SliceItem mRange;
    private int mRangeHeight;
    private SliceItem mRowSlice;
    private int mSingleTextWithRangeHeight;
    private SliceItem mStartItem;
    private SliceItem mSubtitleItem;
    private SliceItem mSummaryItem;
    private int mTextWithRangeHeight;
    private SliceItem mTitleItem;
    private ArrayList<SliceAction> mToggleItems;

    public RowContent(Context r2, SliceItem r3, boolean r4) {
        this.mEndItems = new ArrayList();
        this.mToggleItems = new ArrayList();
        this.mLineCount = 0;
        populate(r3, r4);
        if (r2 == null) goto L6;
        this.mMaxHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_max_height);
        this.mTextWithRangeHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_range_multi_text_height);
        this.mSingleTextWithRangeHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_range_single_text_height);
        this.mMinHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_min_height);
        this.mRangeHeight = r2.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_range_height);
        return;
    }

    private boolean populate(SliceItem r10, boolean r11) {
        this.mIsHeader = r11;
        this.mRowSlice = r10;
        if (isValidRow(r10) == true) goto L6;
        Log.w(TAG, "Provided SliceItem is invalid for RowContent");
        return false;
    L6:
        determineStartAndPrimaryAction(r10);
        this.mContentDescr = SliceQuery.findSubtype(r10, "text", "content_description");
        ArrayList<SliceItem> r12 = filterInvalidItems(r10);
        if (r12.size() == 1) goto L9;
    L17:
        SliceItem r8 = null;
        SliceItem r2 = SliceQuery.findTopLevelItem(r10.getSlice(), "int", "layout_direction", null, null);
        this.mLayoutDirItem = r2;
        if (r2 == null) goto L24;
        if (SliceViewUtil.resolveLayoutDirection(r2.getInt()) == (-1)) goto L22;
        r8 = this.mLayoutDirItem;
    L22:
        this.mLayoutDirItem = r8;
    L24:
        if ("range".equals(r10.getSubType()) == false) goto L27;
        this.mRange = r10;
    L27:
        if (r12.size() <= 0) goto L86;
        SliceItem r13 = this.mStartItem;
        if (r13 == null) goto L31;
        r12.remove(r13);
    L31:
        SliceItem r14 = this.mPrimaryAction;
        if (r14 == null) goto L34;
        r12.remove(r14);
    L34:
        ArrayList r15 = new ArrayList();
        int r3 = 0;
    L36:
        if (r3 >= r12.size()) goto L61;
        SliceItem r6 = r12.get(r3);
        if ("text".equals(r6.getFormat()) == false) goto L58;
        SliceItem r7 = this.mTitleItem;
        if (r7 == null) goto L44;
        if (r7.hasHint("title") == false) goto L44;
    L49:
        if (this.mSubtitleItem != null) goto L54;
        if (r6.hasHint("summary") == true) goto L54;
        this.mSubtitleItem = r6;
    L59:
        r3 = r3 + 1;
    L54:
        if (this.mSummaryItem != null) goto L59;
        if (r6.hasHint("summary") == false) goto L59;
        this.mSummaryItem = r6;
    L44:
        if (r6.hasHint("title") == false) goto L49;
        if (r6.hasHint("summary") == true) goto L49;
        this.mTitleItem = r6;
        goto L59
    L58:
        r15.add(r6);
        goto L59
    L61:
        if (hasText(this.mTitleItem) == false) goto L64;
        this.mLineCount++;
    L64:
        if (hasText(this.mSubtitleItem) == false) goto L66;
        this.mLineCount++;
    L66:
        SliceItem r16 = this.mStartItem;
        if (r16 != null) goto L69;
    L71:
        boolean r17 = false;
    L72:
        int r4 = 0;
    L74:
        if (r4 >= r15.size()) goto L86;
        SliceItem r5 = (SliceItem) r15.get(r4);
        if (SliceQuery.find(r5, "action") == null) goto L78;
        boolean r9 = true;
    L80:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r5.getFormat()) == false) goto L83;
        if (r17 == true) goto L84;
        this.mEndItems.add(r5);
        r17 = true;
    L84:
        r4 = r4 + 1;
        goto L74
    L83:
        processContent(r5, r9);
        goto L84
    L78:
        r9 = false;
        goto L80
    L69:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r16.getFormat()) == false) goto L71;
        r17 = true;
    L86:
        return isValid();
    L9:
        if ("action".equals(r12.get(0).getFormat()) == true) goto L13;
        if ("slice".equals(r12.get(0).getFormat()) == false) goto L17;
    L13:
        if (r12.get(0).hasAnyHints(new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"}) == true) goto L17;
        if (isValidRow(r12.get(0)) == false) goto L17;
        r10 = r12.get(0);
        r12 = filterInvalidItems(r10);
        goto L17
    }

    private void processContent(SliceItem r3, boolean r4) {
        if (r4 == false) goto L6;
        SliceActionImpl r0 = new SliceActionImpl(r3);
        if (r0.isToggle() == false) goto L6;
        this.mToggleItems.add(r0);
    L6:
        this.mEndItems.add(r3);
        this.mEndItemsContainAction |= r4;
    }

    private void determineStartAndPrimaryAction(SliceItem r10) {
        List<SliceItem> r2 = SliceQuery.findAll(r10, null, "title", null);
        if (r2.size() <= 0) goto L15;
        String r3 = r2.get(0).getFormat();
        if ("action".equals(r3) == false) goto L9;
        if (SliceQuery.find(r2.get(0), SlardarSettingsConsts.SETTING_IMAGE) == null) goto L9;
    L14:
        this.mStartItem = r2.get(0);
    L9:
        if ("slice".equals(r3) == true) goto L14;
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r3) == true) goto L14;
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r3) == true) goto L14;
    L15:
        String[] r1 = {UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"};
        List<SliceItem> r4 = SliceQuery.findAll(r10, "slice", r1, null);
        r4.addAll(SliceQuery.findAll(r10, "action", r1, null));
        if (r4.isEmpty() == false) goto L23;
        if ("action".equals(r10.getFormat()) == false) goto L23;
        if (r10.getSlice().getItems().size() != 1) goto L23;
        this.mPrimaryAction = r10;
        return;
    L23:
        if (this.mStartItem == null) goto L30;
        if (r4.size() <= 1) goto L30;
        if (r4.get(0) != this.mStartItem) goto L30;
        this.mPrimaryAction = r4.get(1);
        return;
    L30:
        if (r4.size() <= 0) goto L35;
        this.mPrimaryAction = r4.get(0);
        return;
    }

    public SliceItem getSlice() {
        return this.mRowSlice;
    }

    public SliceItem getLayoutDirItem() {
        return this.mLayoutDirItem;
    }

    public SliceItem getRange() {
        return this.mRange;
    }

    public SliceItem getInputRangeThumb() {
        SliceItem r3 = this.mRange;
        if (r3 == null) goto L12;
        List<SliceItem> r4 = r3.getSlice().getItems();
        int r0 = 0;
    L6:
        if (r0 >= r4.size()) goto L16;
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r4.get(r0).getFormat()) == true) goto L10;
        r0 = r0 + 1;
        goto L6
    L10:
        return r4.get(r0);
    L16:
        return null;
    L12:
        return null;
    }

    public SliceItem getPrimaryAction() {
        return this.mPrimaryAction;
    }

    public SliceItem getStartItem() {
        if (this.mIsHeader == false) goto L6;
        return null;
    L6:
        return this.mStartItem;
    }

    public SliceItem getTitleItem() {
        return this.mTitleItem;
    }

    public SliceItem getSubtitleItem() {
        return this.mSubtitleItem;
    }

    public SliceItem getSummaryItem() {
        SliceItem r0 = this.mSummaryItem;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.mSubtitleItem;
    }

    public ArrayList<SliceItem> getEndItems() {
        return this.mEndItems;
    }

    public ArrayList<SliceAction> getToggleItems() {
        return this.mToggleItems;
    }

    public CharSequence getContentDescription() {
        SliceItem r0 = this.mContentDescr;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    public boolean endItemsContainAction() {
        return this.mEndItemsContainAction;
    }

    public int getLineCount() {
        return this.mLineCount;
    }

    public int getSmallHeight(int r2) {
        if (r2 > 0) goto L6;
        r2 = this.mMaxHeight;
    L6:
        if (getRange() != null) goto L8;
        return r2;
    L8:
        return getActualHeight(r2);
    }

    public int getActualHeight(int r3) {
        if (isValid() == true) goto L6;
        return 0;
    L6:
        if (r3 > 0) goto L10;
        r3 = this.mMaxHeight;
    L10:
        if (getRange() == null) goto L18;
        if (getLineCount() <= 1) goto L14;
        int r4 = this.mTextWithRangeHeight;
    L16:
        return r4 + this.mRangeHeight;
    L14:
        r4 = this.mSingleTextWithRangeHeight;
        goto L16
    L18:
        if (getLineCount() <= 1) goto L20;
        return r3;
    L20:
        if (this.mIsHeader == false) goto L23;
        return r3;
    L23:
        return this.mMinHeight;
    }

    private static boolean hasText(SliceItem r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.hasHint("partial") == false) goto L6;
    L7:
        return true;
    L6:
        if (TextUtils.isEmpty(r1.getText()) == true) goto L8;
        goto L7
    }

    public boolean isDefaultSeeMore() {
        if ("action".equals(this.mRowSlice.getFormat()) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mRowSlice.getSlice().hasHint("see_more") == false) goto L9;
        if (this.mRowSlice.getSlice().getItems().isEmpty() == false) goto L9;
        return true;
    }

    public boolean isValid() {
        if (this.mStartItem == null) goto L5;
    L18:
        return true;
    L5:
        if (this.mPrimaryAction != null) goto L18;
        if (this.mTitleItem != null) goto L18;
        if (this.mSubtitleItem != null) goto L18;
        if (this.mEndItems.size() > 0) goto L18;
        if (this.mRange != null) goto L18;
        if (isDefaultSeeMore() == true) goto L18;
        return false;
    }

    private static boolean isValidRow(SliceItem r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ("slice".equals(r5.getFormat()) == false) goto L8;
    L9:
        List<SliceItem> r1 = r5.getSlice().getItems();
        if (r5.hasHint("see_more") == true) goto L12;
    L14:
        int r2 = 0;
    L16:
        if (r2 >= r1.size()) goto L21;
        if (isValidRowContent(r5, r1.get(r2)) == true) goto L19;
        r2 = r2 + 1;
        goto L16
    L19:
        return true;
    L21:
        return false;
    L12:
        if (r1.isEmpty() == false) goto L14;
        return true;
    L8:
        if ("action".equals(r5.getFormat()) == false) goto L21;
        goto L9
    }

    private static ArrayList<SliceItem> filterInvalidItems(SliceItem r4) {
        ArrayList<SliceItem> r0 = new ArrayList();
        Iterator<SliceItem> r1 = r4.getSlice().getItems().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        SliceItem r2 = r1.next();
        if (isValidRowContent(r4, r2) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    private static boolean isValidRowContent(SliceItem r4, SliceItem r5) {
        if (r5.hasAnyHints(new String[]{"keywords", "ttl", "last_updated", "horizontal"}) == false) goto L5;
        return false;
    L5:
        if ("content_description".equals(r5.getSubType()) == true) goto L28;
        String r6 = r5.getFormat();
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r6) == false) goto L10;
    L23:
        return true;
    L10:
        if ("text".equals(r6) == true) goto L23;
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r6) == true) goto L23;
        if ("action".equals(r6) == true) goto L23;
        if ("input".equals(r6) == true) goto L23;
        if ("slice".equals(r6) == true) goto L23;
        if ("int".equals(r6) == true) goto L22;
        return false;
    L22:
        if ("range".equals(r4.getSubType()) == true) goto L23;
        return false;
    L28:
        return false;
    }
}
