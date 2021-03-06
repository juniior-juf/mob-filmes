package com.example.mobfilmes.view.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mobfilmes.BR

class BaseViewHolder(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }

    fun bind(position:Int, obj: Any, handler: HandlerAdapter?) {
        binding.setVariable(BR.obj, obj)
        binding.setVariable(BR.handler, handler)
        binding.setVariable(BR.position, position)
        binding.executePendingBindings()
    }
}