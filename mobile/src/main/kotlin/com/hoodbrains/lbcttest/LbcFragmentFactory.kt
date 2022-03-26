package com.hoodbrains.lbcttest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.hoodbrains.lbcttest.features.itemlist.ItemListFragment

class LbcFragmentFactory(private val viewModelFactory: ViewModelProvider.Factory) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =
        when (classLoader.loadClass(className)) {
            ItemListFragment::class.java -> ItemListFragment(viewModelFactory)
            else -> super.instantiate(classLoader, className)
        }
}