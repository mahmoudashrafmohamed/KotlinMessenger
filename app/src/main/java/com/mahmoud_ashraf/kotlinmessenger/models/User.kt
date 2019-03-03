package com.mahmoud_ashraf.kotlinmessenger.models

class User(val uid: String, val username: String, val profileImageUrl: String) {
 // we added this secondary constructor because we need to use
 // constructor that take no args when fetch data from firebase
  constructor() : this("", "", "")
}