package biubiubiu.me.fftest;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Toast工具类，封装了系统自带Toast，以及自定义Toast
 * 
 * @author Shaojie
 * @Date 2013-9-26 下午7:08:47
 */
public class ToastUtils {

	/**
	 * Show the given message in a {@link android.widget.Toast}
	 * <p/>
	 * This method may be called from any thread
	 *
	 * @param activity
	 * @param message
	 */
	public static void show(final Activity activity, final String message) {
		Toaster.showShort(activity, message);
	}

	/**
	 * Show the message with the given resource id in a {@link android.widget.Toast}
	 * <p/>
	 * This method may be called from any thread
	 * 
	 * @param activity
	 * @param resId
	 */
	public static void show(final Activity activity, final int resId) {
		if (activity == null) {
			return;
		}
		show(activity, activity.getString(resId));
	}

	public static void showInCenter(Context context, final String message) {
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	public static void showPicToast(Context context, int resIconId) {
		Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		// LinearLayout toastView = (LinearLayout) toast.getView();
		// toastView.setOrientation(orientation);
		// toastView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL
		// );
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(resIconId);
		toast.setView(imageView);
		// toastView.addView(imageView, 0);
		toast.show();
	}

}
