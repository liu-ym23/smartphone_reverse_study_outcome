package androidx.slice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Pair;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceHints;
import androidx.slice.core.SliceQuery;
import androidx.slice.widget.GridContent;
import androidx.slice.widget.ListContent;
import androidx.slice.widget.RowContent;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SliceMetadata {
    public static final int LOADED_ALL = 2;
    public static final int LOADED_NONE = 0;
    public static final int LOADED_PARTIAL = 1;
    private Context mContext;
    private long mExpiry;
    private SliceItem mHeaderItem;
    private long mLastUpdated;
    private ListContent mListContent;
    private SliceActionImpl mPrimaryAction;
    private Slice mSlice;
    private List<SliceAction> mSliceActions;
    private int mTemplateType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceLoadingState {
    }

    public static SliceMetadata from(Context r1, Slice r2) {
        return new SliceMetadata(r1, r2);
    }

    private SliceMetadata(Context r9, Slice r10) {
        this.mSlice = r10;
        this.mContext = r9;
        SliceItem r1 = SliceQuery.find(r10, WsChannelMultiProcessSharedProvider.LONG_TYPE, "ttl", null);
        if (r1 == null) goto L5;
        this.mExpiry = r1.getLong();
    L5:
        SliceItem r0 = SliceQuery.find(r10, WsChannelMultiProcessSharedProvider.LONG_TYPE, "last_updated", null);
        if (r0 == null) goto L8;
        this.mLastUpdated = r0.getLong();
    L8:
        ListContent r2 = new ListContent(r9, r10, null, 0, 0);
        this.mListContent = r2;
        this.mHeaderItem = r2.getHeaderItem();
        this.mTemplateType = this.mListContent.getHeaderTemplateType();
        SliceItem r11 = this.mListContent.getPrimaryAction();
        if (r11 == null) goto L11;
        this.mPrimaryAction = new SliceActionImpl(r11);
    L11:
        List<SliceAction> r12 = this.mListContent.getSliceActions();
        this.mSliceActions = r12;
        if (r12 != null) goto L33;
        SliceItem r13 = this.mHeaderItem;
        if (r13 != null) goto L16;
        return;
    L16:
        if (SliceQuery.hasHints(r13, new String[]{"list_item"}) == true) goto L18;
        return;
    L18:
        if (SliceQuery.hasHints(this.mHeaderItem, new String[]{"horizontal"}) == true) goto L36;
        int r3 = 0;
        ArrayList<SliceItem> r14 = new RowContent(this.mContext, this.mHeaderItem, false).getEndItems();
        ArrayList r15 = new ArrayList();
    L21:
        if (r3 >= r14.size()) goto L27;
        if (SliceQuery.find(r14.get(r3), "action") == null) goto L25;
        r15.add(new SliceActionImpl(r14.get(r3)));
    L25:
        r3 = r3 + 1;
        goto L21
    L27:
        if (r15.size() <= 0) goto L37;
        this.mSliceActions = r15;
        return;
    L37:
        return;
    L36:
        return;
    }

    public CharSequence getTitle() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
    L10:
        CharSequence r1 = null;
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        SliceActionImpl r4 = this.mPrimaryAction;
        if (r4 == null) goto L17;
        return r4.getTitle();
    L17:
        return r1;
    L5:
        if (r0.hasHint("horizontal") == false) goto L7;
        r1 = new GridContent(this.mContext, this.mHeaderItem).getTitle();
        goto L12
    L7:
        RowContent r2 = new RowContent(this.mContext, this.mHeaderItem, true);
        if (r2.getTitleItem() == null) goto L10;
        r1 = r2.getTitleItem().getText();
        goto L12
    }

    public CharSequence getSubtitle() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.hasHint("horizontal") == true) goto L12;
        RowContent r1 = new RowContent(this.mContext, this.mHeaderItem, true);
        if (r1.getSubtitleItem() != null) goto L9;
        return null;
    L9:
        return r1.getSubtitleItem().getText();
    L12:
        return null;
    }

    public CharSequence getSummary() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.hasHint("horizontal") == true) goto L12;
        RowContent r1 = new RowContent(this.mContext, this.mHeaderItem, true);
        if (r1.getSummaryItem() != null) goto L9;
        return null;
    L9:
        return r1.getSummaryItem().getText();
    L12:
        return null;
    }

    public List<SliceAction> getSliceActions() {
        return this.mSliceActions;
    }

    public SliceAction getPrimaryAction() {
        return this.mPrimaryAction;
    }

    public int getHeaderType() {
        return this.mTemplateType;
    }

    public boolean hasLargeMode() {
        SliceItem r0 = this.mHeaderItem;
        if (r0 != null) goto L5;
    L11:
        boolean r1 = false;
    L13:
        if (this.mListContent.getRowItems().size() > 1) goto L18;
        if (r1 == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return true;
    L5:
        if (r0.hasHint("horizontal") == false) goto L11;
        GridContent r2 = new GridContent(this.mContext, this.mHeaderItem);
        if (r2.hasImage() == false) goto L11;
        if (r2.getMaxCellLineCount() <= 1) goto L11;
        r1 = true;
        goto L13
    }

    public List<SliceAction> getToggles() {
        ArrayList r0 = new ArrayList();
        SliceActionImpl r1 = this.mPrimaryAction;
        if (r1 != null) goto L5;
    L7:
        List<SliceAction> r2 = this.mSliceActions;
        if (r2 == null) goto L19;
        if (r2.size() <= 0) goto L19;
        int r3 = 0;
    L13:
        if (r3 >= this.mSliceActions.size()) goto L24;
        SliceAction r4 = this.mSliceActions.get(r3);
        if (r4.isToggle() == false) goto L17;
        r0.add(r4);
    L17:
        r3 = r3 + 1;
        goto L13
    L24:
        return r0;
    L19:
        return new RowContent(this.mContext, this.mHeaderItem, true).getToggleItems();
    L5:
        if (r1.isToggle() == false) goto L7;
        r0.add(this.mPrimaryAction);
        return r0;
    }

    public boolean sendToggleAction(SliceAction r9, boolean r10) throws PendingIntent.CanceledException {
        if (r9 == null) goto L5;
        Intent r5 = new Intent().addFlags(268435456).putExtra("android.app.slice.extra.TOGGLE_STATE", r10);
        r9.getAction().send(this.mContext, 0, r5, null, null);
        return true;
    L5:
        return false;
    }

    public PendingIntent getInputRangeAction() {
        if (this.mTemplateType != 4) goto L8;
        SliceItem r3 = new RowContent(this.mContext, this.mHeaderItem, true).getRange();
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getAction();
    L8:
        return null;
    }

    public boolean sendInputRangeAction(int r5) throws PendingIntent.CanceledException {
        if (this.mTemplateType != 4) goto L8;
        SliceItem r0 = new RowContent(this.mContext, this.mHeaderItem, true).getRange();
        if (r0 == null) goto L10;
        Pair<Integer, Integer> r1 = getRange();
        int r6 = MathUtils.clamp(r5, r1.first.intValue(), r1.second.intValue());
        Intent r7 = new Intent().addFlags(268435456).putExtra("android.app.slice.extra.RANGE_VALUE", r6);
        r0.fireAction(this.mContext, r7);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public Pair<Integer, Integer> getRange() {
        int r0 = this.mTemplateType;
        if (r0 != 4) goto L5;
    L9:
        SliceItem r3 = new RowContent(this.mContext, this.mHeaderItem, true).getRange();
        SliceItem r1 = SliceQuery.findSubtype(r3, "int", "max");
        SliceItem r4 = SliceQuery.findSubtype(r3, "int", SliceHints.SUBTYPE_MIN);
        if (r1 == null) goto L12;
        int r2 = r1.getInt();
    L13:
        if (r4 == null) goto L15;
        int r5 = r4.getInt();
    L17:
        return new Pair(Integer.valueOf(r5), Integer.valueOf(r2));
    L15:
        r5 = 0;
        goto L17
    L12:
        r2 = 100;
        goto L13
    L5:
        if (r0 == 5) goto L9;
        return null;
    }

    public int getRangeValue() {
        int r0 = this.mTemplateType;
        if (r0 != 4) goto L5;
    L8:
        SliceItem r4 = SliceQuery.findSubtype(new RowContent(this.mContext, this.mHeaderItem, true).getRange(), "int", "value");
        if (r4 != null) goto L11;
        return -1;
    L11:
        return r4.getInt();
    L5:
        if (r0 == 5) goto L8;
        return -1;
    }

    public List<String> getSliceKeywords() {
        SliceItem r4 = SliceQuery.find(this.mSlice, "slice", "keywords", null);
        if (r4 == null) goto L14;
        List<SliceItem> r5 = SliceQuery.findAll(r4, "text");
        if (r5 == null) goto L14;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r5.size()) goto L13;
        String r2 = (String) r5.get(r1).getText();
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r0.add(r2);
    L12:
        r1 = r1 + 1;
        goto L8
    L13:
        return r0;
    L14:
        return null;
    }

    public int getLoadingState() {
        if (SliceQuery.find(this.mSlice, null, "partial", null) == null) goto L5;
        boolean r0 = true;
    L7:
        if (this.mListContent.isValid() == true) goto L9;
        return 0;
    L9:
        if (r0 == false) goto L11;
        return 1;
    L11:
        return 2;
    L5:
        r0 = false;
        goto L7
    }

    public long getExpiry() {
        return this.mExpiry;
    }

    public long getLastUpdatedTime() {
        return this.mLastUpdated;
    }

    public boolean isPermissionSlice() {
        return this.mSlice.hasHint("permission_request");
    }

    public boolean isErrorSlice() {
        return this.mSlice.hasHint("error");
    }

    public static List<SliceAction> getSliceActions(Slice r4) {
        SliceItem r5 = SliceQuery.find(r4, "slice", "actions", null);
        String[] r1 = {"actions", UserDictionaryAddWordContents.EXTRA_SHORTCUT};
        if (r5 == null) goto L5;
        List<SliceItem> r6 = SliceQuery.findAll(r5, "slice", r1, null);
    L6:
        if (r6 == null) goto L12;
        ArrayList r0 = new ArrayList(r6.size());
        int r2 = 0;
    L9:
        if (r2 >= r6.size()) goto L11;
        r0.add(new SliceActionImpl(r6.get(r2)));
        r2 = r2 + 1;
        goto L9
    L11:
        return r0;
    L12:
        return null;
    L5:
        r6 = null;
        goto L6
    }
}
