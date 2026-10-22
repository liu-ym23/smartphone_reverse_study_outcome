package obric.tablet.widget;

/* JADX INFO: loaded from: classes5.dex */
public interface BytedancePopupWindowInterface {
    public static final int BUTTON_NEGATIVE = -2;
    public static final int BUTTON_NEUTRAL = -3;
    public static final int BUTTON_POSITIVE = -1;

    public interface CallbackListener {
        void onCancel();

        void onConfirm();

        void onNeural();
    }

    public interface OnShowListener {
        void onShow();
    }
}
