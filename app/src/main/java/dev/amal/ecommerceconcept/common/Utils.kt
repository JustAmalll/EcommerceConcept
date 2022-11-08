package dev.amal.ecommerceconcept.common

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayout

fun TabLayout.changeSelectedTabItemFontFamily(
    tabPosition: Int, @FontRes fontFamilyRes: Int
) {
    val linearLayout = (this.getChildAt(0) as ViewGroup).getChildAt(tabPosition) as LinearLayout
    val tabTextView = linearLayout.getChildAt(1) as TextView
    val typeface = context?.let { ResourcesCompat.getFont(it, fontFamilyRes) }
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