package com.example.mobfilmes.view.adapter

import android.view.View

interface HandlerAdapter {

    fun onClickItem(view: View, position: Int,  obj: Any)

}