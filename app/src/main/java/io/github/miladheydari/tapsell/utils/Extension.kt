package io.github.miladheydari.tapsell.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import io.github.miladheydari.tapsell.repository.api.model.NoteModel
import io.github.miladheydari.tapsell.repository.db.entities.Note
import java.math.BigDecimal
import java.text.DecimalFormat

private val farsiChars = arrayOf(
    "\u06F0",
    "\u06F1",
    "\u06F2",
    "\u06F3",
    "\u06F4",
    "\u06F5",
    "\u06F6",
    "\u06F7",
    "\u06F8",
    "\u06F9",
    "\u066C",
    "\u066B"
)

fun String.toEnglish(): String {
    var number = this
    number = number.replace(farsiChars[0].toRegex(), "0")
    number = number.replace(farsiChars[1].toRegex(), "1")
    number = number.replace(farsiChars[2].toRegex(), "2")
    number = number.replace(farsiChars[3].toRegex(), "3")
    number = number.replace(farsiChars[4].toRegex(), "4")
    number = number.replace(farsiChars[5].toRegex(), "5")
    number = number.replace(farsiChars[6].toRegex(), "6")
    number = number.replace(farsiChars[7].toRegex(), "7")
    number = number.replace(farsiChars[8].toRegex(), "8")
    number = number.replace(farsiChars[9].toRegex(), "9")

    return number

}

fun String.toFarsi(): String {//1232452
    var number = this

    number = number.replace("0".toRegex(), farsiChars[0])
    number = number.replace("1".toRegex(), farsiChars[1])
    number = number.replace("2".toRegex(), farsiChars[2])
    number = number.replace("3".toRegex(), farsiChars[3])
    number = number.replace("4".toRegex(), farsiChars[4])
    number = number.replace("5".toRegex(), farsiChars[5])
    number = number.replace("6".toRegex(), farsiChars[6])
    number = number.replace("7".toRegex(), farsiChars[7])
    number = number.replace("8".toRegex(), farsiChars[8])
    number = number.replace("9".toRegex(), farsiChars[9])
    number = number.replace(",".toRegex(), farsiChars[10])
    number = number.replace(".", farsiChars[11])

    return number

}

fun BigDecimal.formatCurrency(): String {
    val formatter = DecimalFormat("###,###,###")
    return formatter.format(this)
}

fun Int.formatTime(): String {

    return String.format("%02d", this)


}

fun Context.toast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_LONG).show()

}

fun Fragment.toast(s: String) {
    this.activity?.toast(s)
}


fun Note.toModel(): NoteModel {

    return NoteModel(this.note)
}



fun NoteModel.toEntity(): Note {

    return Note(this.note)
}