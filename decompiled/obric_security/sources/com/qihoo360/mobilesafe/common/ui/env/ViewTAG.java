package com.qihoo360.mobilesafe.common.ui.env;

import android.content.Context;
import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class ViewTAG {
    private static GRID_ROW_TAG GRID_ROW_Instance;
    private static ROW_BTN_TAG ROW_BTN_Instance;
    private static ROW_TAG ROW_Instance;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.env.ViewTAG$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class DIALOG_TAG {
        public String DIALOG_TAG_CENTER_TEXT;
        public String DIALOG_TAG_CLOSE;
        public String DIALOG_TAG_IMAGE;
        public String DIALOG_TAG_LEFT_BTN;
        public String DIALOG_TAG_RIGHT_BTN;
        public String DIALOG_TAG_ROOT;
        public String DIALOG_TAG_SINGLE_BTN;
        public String DIALOG_TAG_SUGGEST;
        public String DIALOG_TAG_TITLE;
        public String DIALOG_TAG_TITLE_LAYOUT;
        public String DIALOG_TAG_WARNING_TEXT;

        public DIALOG_TAG(Context r2) {
            this.DIALOG_TAG_ROOT = "";
            this.DIALOG_TAG_LEFT_BTN = "";
            this.DIALOG_TAG_RIGHT_BTN = "";
            this.DIALOG_TAG_SINGLE_BTN = "";
            this.DIALOG_TAG_TITLE = "";
            this.DIALOG_TAG_CLOSE = "";
            this.DIALOG_TAG_IMAGE = "";
            this.DIALOG_TAG_CENTER_TEXT = "";
            this.DIALOG_TAG_SUGGEST = "";
            this.DIALOG_TAG_TITLE_LAYOUT = "";
            this.DIALOG_TAG_WARNING_TEXT = "";
            this.DIALOG_TAG_ROOT = r2.getString(R.string.inner_dialog_root);
            this.DIALOG_TAG_LEFT_BTN = r2.getString(R.string.inner_dialog_btn_left_btn);
            this.DIALOG_TAG_RIGHT_BTN = r2.getString(R.string.inner_dialog_btn_right_btn);
            this.DIALOG_TAG_TITLE = r2.getString(R.string.inner_dialog_title);
            this.DIALOG_TAG_CLOSE = r2.getString(R.string.inner_dialog_close);
            this.DIALOG_TAG_IMAGE = r2.getString(R.string.inner_dialog_image);
            this.DIALOG_TAG_CENTER_TEXT = r2.getString(R.string.inner_dialog_center_text);
            this.DIALOG_TAG_SUGGEST = r2.getString(R.string.inner_dialog_suggest_text);
            this.DIALOG_TAG_SINGLE_BTN = r2.getString(R.string.inner_dialog_btn_single_btn);
            this.DIALOG_TAG_TITLE_LAYOUT = r2.getString(R.string.inner_dialog_title_layout);
            this.DIALOG_TAG_WARNING_TEXT = r2.getString(R.string.inner_dialog_warning_text);
        }
    }

    public static class GRID_ROW_TAG {
        public String ROW_TAG_CENTER_IMAGE;
        public String ROW_TAG_FIRST_LINE_TEXT;
        public String ROW_TAG_ROOT;
        public String ROW_TAG_SECOND_LINE_TEXT;

        /* synthetic */ GRID_ROW_TAG(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private GRID_ROW_TAG(Context r2) {
            this.ROW_TAG_ROOT = "";
            this.ROW_TAG_FIRST_LINE_TEXT = "";
            this.ROW_TAG_SECOND_LINE_TEXT = "";
            this.ROW_TAG_CENTER_IMAGE = "";
            this.ROW_TAG_ROOT = r2.getString(R.string.inner_grid_row_root);
            this.ROW_TAG_FIRST_LINE_TEXT = r2.getString(R.string.inner_grid_row_first_text);
            this.ROW_TAG_SECOND_LINE_TEXT = r2.getString(R.string.inner_grid_row_second_text);
            this.ROW_TAG_CENTER_IMAGE = r2.getString(R.string.inner_grid_row_center_image);
        }
    }

    public static class ROW_BTN_TAG {
        public String ROW_BTN_TAG_LEFT_BTN;
        public int ROW_BTN_TAG_LEFT_BTN_ID;
        public String ROW_BTN_TAG_RIGHT_BTN;
        public String ROW_BTN_TAG_SELECT_VIEW;

        public ROW_BTN_TAG(Context r2) {
            this.ROW_BTN_TAG_LEFT_BTN = "";
            this.ROW_BTN_TAG_RIGHT_BTN = "";
            this.ROW_BTN_TAG_SELECT_VIEW = "";
            this.ROW_BTN_TAG_LEFT_BTN = r2.getString(R.string.inner_row_btn_left_btn);
            this.ROW_BTN_TAG_RIGHT_BTN = r2.getString(R.string.inner_row_btn_right_btn);
            this.ROW_BTN_TAG_SELECT_VIEW = r2.getString(R.string.inner_row_btn_select_view);
            this.ROW_BTN_TAG_LEFT_BTN_ID = R.id.inner_common_row_btn_tag_left_btn_id;
        }
    }

    public static class ROW_TAG {
        public String ROW_TAG_ARROW_VIEW;
        public String ROW_TAG_FIRST_LINE_TEXT;
        public String ROW_TAG_LEFT_FLAG_IMAGE;
        public String ROW_TAG_LEFT_ICON_IMAGE;
        public String ROW_TAG_LOADING_VIEW;
        public String ROW_TAG_MARK_TEXT;
        public String ROW_TAG_PROGRESS_VIEW;
        public String ROW_TAG_RIGHT_BADGE;
        public String ROW_TAG_RIGHT_BTN;
        public int ROW_TAG_RIGHT_SELECT_ID;
        public String ROW_TAG_RIGHT_TEXT;
        public String ROW_TAG_ROOT;
        public String ROW_TAG_SECOND_LINE_TEXT;
        public String ROW_TAG_SELECT_VIEW;
        public String ROW_TAG_THIRD_LINE_TEXT;

        /* synthetic */ ROW_TAG(Context r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ROW_TAG(Context r2) {
            this.ROW_TAG_ROOT = "";
            this.ROW_TAG_LEFT_ICON_IMAGE = "";
            this.ROW_TAG_LEFT_FLAG_IMAGE = "";
            this.ROW_TAG_MARK_TEXT = "";
            this.ROW_TAG_FIRST_LINE_TEXT = "";
            this.ROW_TAG_SECOND_LINE_TEXT = "";
            this.ROW_TAG_THIRD_LINE_TEXT = "";
            this.ROW_TAG_PROGRESS_VIEW = "";
            this.ROW_TAG_RIGHT_TEXT = "";
            this.ROW_TAG_RIGHT_BADGE = "";
            this.ROW_TAG_RIGHT_BTN = "";
            this.ROW_TAG_SELECT_VIEW = "";
            this.ROW_TAG_LOADING_VIEW = "";
            this.ROW_TAG_ARROW_VIEW = "";
            this.ROW_TAG_ROOT = r2.getString(R.string.inner_row_root);
            this.ROW_TAG_LEFT_ICON_IMAGE = r2.getString(R.string.inner_row_left_image);
            this.ROW_TAG_LEFT_FLAG_IMAGE = r2.getString(R.string.inner_row_left_flag);
            this.ROW_TAG_MARK_TEXT = r2.getString(R.string.inner_row_mark_text);
            this.ROW_TAG_FIRST_LINE_TEXT = r2.getString(R.string.inner_row_first_text);
            this.ROW_TAG_SECOND_LINE_TEXT = r2.getString(R.string.inner_row_second_text);
            this.ROW_TAG_THIRD_LINE_TEXT = r2.getString(R.string.inner_row_third_text);
            this.ROW_TAG_PROGRESS_VIEW = r2.getString(R.string.inner_row_progress_view);
            this.ROW_TAG_RIGHT_TEXT = r2.getString(R.string.inner_row_right_text);
            this.ROW_TAG_RIGHT_BADGE = r2.getString(R.string.inner_row_right_badge);
            this.ROW_TAG_RIGHT_BTN = r2.getString(R.string.inner_row_right_btn);
            this.ROW_TAG_SELECT_VIEW = r2.getString(R.string.inner_row_select_view);
            this.ROW_TAG_LOADING_VIEW = r2.getString(R.string.inner_row_loading_view);
            this.ROW_TAG_ARROW_VIEW = r2.getString(R.string.inner_row_arrow_view);
            this.ROW_TAG_RIGHT_SELECT_ID = R.id.inner_common_row_tag_right_select_id;
        }
    }

    public ViewTAG() {
    }

    public static ROW_TAG getRowTag(Context r2) {
        if (ROW_Instance != null) goto L6;
        ROW_Instance = new ROW_TAG(r2, null);
    L6:
        return ROW_Instance;
    }

    public static GRID_ROW_TAG getGridTag(Context r2) {
        if (GRID_ROW_Instance != null) goto L6;
        GRID_ROW_Instance = new GRID_ROW_TAG(r2, null);
    L6:
        return GRID_ROW_Instance;
    }

    public static ROW_BTN_TAG getRowBtnTag(Context r1) {
        if (ROW_BTN_Instance != null) goto L6;
        ROW_BTN_Instance = new ROW_BTN_TAG(r1);
    L6:
        return ROW_BTN_Instance;
    }
}
