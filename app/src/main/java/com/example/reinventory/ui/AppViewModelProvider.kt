package com.example.reinventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.reinventory.InventoryApplication
import com.example.reinventory.ui.home.HomeViewModel
import com.example.reinventory.ui.item.ItemDetailsViewModel
import com.example.reinventory.ui.item.ItemEditViewModel
import com.example.reinventory.ui.item.ItemEntryViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }


        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }


        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }


        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}


fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)