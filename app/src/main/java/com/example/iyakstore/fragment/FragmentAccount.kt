package com.example.iyakstore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.iyakstore.R
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentAccount: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_account, container, false)
        return view

    }

}