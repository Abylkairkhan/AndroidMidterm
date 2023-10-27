package com.example.avia.util

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.StyleRes
import com.example.avia.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.R as MaterialR

open class RoundedBottomSheetDialogFragment(
    @StyleRes private val themeRes: Int = R.style.BottomSheetDialogTheme,
    peekHeight: Double = 0.8
) : BottomSheetDialogFragment() {

    open val dialogHeight: Int by lazy {
        (requireActivity().resources.displayMetrics.heightPixels * peekHeight).toInt()
    }

    override fun getTheme(): Int = themeRes

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(
        requireContext(),
        theme
    ).apply {
        setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val bottomSheetInternal =
                bottomSheetDialog.findViewById<View>(MaterialR.id.design_bottom_sheet) as FrameLayout
            val layoutParams = bottomSheetInternal.layoutParams
            if (bottomSheetInternal.height > dialogHeight) {
                layoutParams.height = dialogHeight
            }
            bottomSheetInternal.layoutParams = layoutParams
            val behavior = BottomSheetBehavior.from(bottomSheetInternal)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.skipCollapsed = true
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        dismissAllowingStateLoss()
    }
}
