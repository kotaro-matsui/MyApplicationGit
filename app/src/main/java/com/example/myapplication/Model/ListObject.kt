package com.example.myapplication.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class ListObject: RealmObject() {
    @PrimaryKey
    var id : Int? = null

    @Required
    var booth = ""

    @Required
    var teacher = ""

    @Required
    var student = ""

    @Required
    var subject = ""
}