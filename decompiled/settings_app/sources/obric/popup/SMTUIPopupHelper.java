package obric.popup;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import obric.widget.R;
import obric.widget.WrapContentListView;

/* JADX INFO: loaded from: classes5.dex */
public class SMTUIPopupHelper {
    public SMTUIPopupHelper() {
    }

    public static CustomizedPopupWindow popup(Context context) {
        return new CustomizedPopupWindow(context, -2, -2);
    }

    public static CustomizedPopupWindow popup(Context context, int width) {
        return new CustomizedPopupWindow(context, width, -2);
    }

    public static CustomizedPopupWindow popup(Context context, int width, int height) {
        return new CustomizedPopupWindow(context, width, height);
    }

    public static CustomizedPopupWindow listPopup(final Context context, int width, int maxHeight, BaseAdapter adapter, AdapterView.OnItemClickListener onItemClickListener) {
        return listPopup(context, width, maxHeight, adapter, true, onItemClickListener);
    }

    public static CustomizedPopupWindow listPopup(final Context context, int width, int maxHeight, BaseAdapter adapter, boolean showDivider, AdapterView.OnItemClickListener onItemClickListener) {
        ListView r2 = generatePopupListView(context, maxHeight, showDivider);
        r2.setAdapter(adapter);
        r2.setOnItemClickListener(onItemClickListener);
        CustomizedPopupWindow r0 = popup(context, width).view(r2).wrapContentView(new AnonymousClass1(context));
        r0.setOutsideTouchable(true);
        r0.setElevation(50.0f);
        return r0;
    }

    private static ListView generatePopupListView(Context context, int maxHeight, boolean showDivider) {
        WrapContentListView r0 = new WrapContentListView(context, maxHeight);
        r0.setVerticalScrollBarEnabled(false);
        r0.setOutlineProvider(new AnonymousClass2());
        r0.setClipToOutline(true);
        if (showDivider == false) goto L5;
        r0.setDivider(context.getDrawable(R.drawable.list_divider_drawable));
    L6:
        r0.setSelector(R.drawable.obric_popup_menu_list_selector);
        return r0;
    L5:
        r0.setDivider(null);
        goto L6
    }
}
