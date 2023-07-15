package tr.mfk.common

import android.app.Activity
import android.content.Intent
import java.text.NumberFormat
import java.util.*

fun Activity.startNewActivity(activity: Class<*>){
    this.startActivity(Intent(this,activity))
}

fun getCurrency(price: Double): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return format.format(price)

}