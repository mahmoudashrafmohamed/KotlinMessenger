package com.mahmoud_ashraf.kotlinmessenger.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * we add Parcelable to can send object of user in putExtra between intents
 */
@Parcelize
class User(val uid: String, val name: String, val profileImageUrl: String?) : Parcelable {
 // we added this secondary constructor because we need to use
 // constructor that take no args when fetch data from firebase and assign the values that will assign
 // to the primary constructor
  constructor() : this("", "", "")
}