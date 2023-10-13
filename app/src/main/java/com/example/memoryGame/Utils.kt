package com.example.memoryGame

import android.text.InputFilter
import android.text.Spanned
import android.util.Log
import com.example.memoryGame.model.ColorsModel

class MinMaxFilter() : InputFilter {
    private var intMin: Int = 0
    private var intMax: Int = 0

    constructor(minValue: Int, maxValue: Int) : this() {
        this.intMin = minValue
        this.intMax = maxValue
    }
    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dStart: Int, dEnd: Int): CharSequence? {
        try {
            val input = Integer.parseInt(dest.toString() + source.toString())
            Log.e(javaClass.simpleName, "filter: $input")
            if (isInRange(intMin, intMax, input)) {
                return null
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}

fun numberList(): ArrayList<ColorsModel> {
    val list: ArrayList<ColorsModel> = arrayListOf()
    list.add(ColorsModel(id = "1", name = "1001"))
    list.add(ColorsModel(id = "2", name = "1011"))
    list.add(ColorsModel(id = "3", name = "2024"))
    list.add(ColorsModel(id = "4", name = "3065"))
    list.add(ColorsModel(id = "5", name = "7543"))
    list.add(ColorsModel(id = "43", name = "4323"))
    list.add(ColorsModel(id = "44", name = "7195"))
    list.add(ColorsModel(id = "7", name = "1054"))
    list.add(ColorsModel(id = "9", name = "6054"))
    list.add(ColorsModel(id = "11", name = "7897"))
    list.add(ColorsModel(id = "13", name = "1801"))
    list.add(ColorsModel(id = "10", name = "8021"))
    list.add(ColorsModel(id = "17", name = "1956"))
    list.add(ColorsModel(id = "15", name = "2865"))
    list.add(ColorsModel(id = "6", name = "6756"))
    list.add(ColorsModel(id = "12", name = "9999"))
    list.add(ColorsModel(id = "19", name = "9299"))
    list.add(ColorsModel(id = "48", name = "1341"))
    list.add(ColorsModel(id = "8", name = "4788"))
    list.add(ColorsModel(id = "45", name = "9877"))
    list.add(ColorsModel(id = "46", name = "3056"))
    list.add(ColorsModel(id = "14", name = "5555"))
    list.add(ColorsModel(id = "42", name = "7687"))
    list.add(ColorsModel(id = "47", name = "3499"))
    list.add(ColorsModel(id = "16", name = "1651"))
    list.add(ColorsModel(id = "50", name = "2023"))
    list.add(ColorsModel(id = "18", name = "9925"))
    list.add(ColorsModel(id = "21", name = "3906"))
    list.add(ColorsModel(id = "26", name = "4721"))
    list.add(ColorsModel(id = "20", name = "8734"))
    list.add(ColorsModel(id = "30", name = "9090"))
    list.add(ColorsModel(id = "32", name = "5425"))
    list.add(ColorsModel(id = "23", name = "8974"))
    list.add(ColorsModel(id = "33", name = "1278"))
    list.add(ColorsModel(id = "25", name = "1898"))
    list.add(ColorsModel(id = "28", name = "8911"))
    list.add(ColorsModel(id = "35", name = "1689"))
    list.add(ColorsModel(id = "22", name = "1798"))
    list.add(ColorsModel(id = "31", name = "3769"))
    list.add(ColorsModel(id = "34", name = "7786"))
    list.add(ColorsModel(id = "36", name = "5764"))
    list.add(ColorsModel(id = "24", name = "9786"))
    list.add(ColorsModel(id = "27", name = "2543"))
    list.add(ColorsModel(id = "37", name = "4654"))
    list.add(ColorsModel(id = "39", name = "6545"))
    list.add(ColorsModel(id = "49", name = "5646"))
    list.add(ColorsModel(id = "38", name = "3544"))
    list.add(ColorsModel(id = "41", name = "7565"))
    return list
}
