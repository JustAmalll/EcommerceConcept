package dev.amal.core.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout
import dev.amal.core.R

fun TabLayout.changeSelectedTabItemFontFamily(
    tabPosition: Int, isSelected: Boolean
) {
    val linearLayout = (this.getChildAt(0) as ViewGroup).getChildAt(tabPosition) as LinearLayout
    val tabTextView = linearLayout.getChildAt(1) as TextView
    val typeface = context?.let { context ->
        ResourcesCompat.getFont(
            context, if (isSelected) R.font.mark_pro_bold else R.font.mark_pro_normal
        )
    }
    tabTextView.textSize = 20f
    tabTextView.typeface = typeface
}

fun TextView.setTextColor(context: Context, color: Int) {
    this.setTextColor(ContextCompat.getColor(context, color))
}

fun CardView.setCardBgColor(context: Context, color: Int) {
    this.setCardBackgroundColor(ContextCompat.getColor(context, color))
}

fun ProgressBar.showProgressBarWhenLoading(isLoading: Boolean) {
    if (isLoading) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}

fun ImageView.setImageDrawable(context: Context, color: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(context, color))
}

fun Window.setLightSystemBars(context: Context) {
    this.navigationBarColor = ContextCompat.getColor(context, R.color.surface)
    this.statusBarColor = ContextCompat.getColor(context, R.color.surface)
}

fun TextView.toggleTextColor(
    context: Context,
    phoneTextView: TextView,
    computerTextView: TextView,
    healthTextView: TextView,
    booksTextView: TextView
) {
    if (this != booksTextView) booksTextView.setTextColor(context, R.color.black)
    if (this != phoneTextView) phoneTextView.setTextColor(context, R.color.black)
    if (this != computerTextView) computerTextView.setTextColor(context, R.color.black)
    if (this != healthTextView) healthTextView.setTextColor(context, R.color.black)
    this.setTextColor(context, R.color.primary)
}