package com.decagon.android.sq007

import android.content.Context

class ResourceComparer {
    fun appNameCheck(context: Context,rsId: Int, string: String):Boolean{
      return context.getString(rsId)==string
    }
}