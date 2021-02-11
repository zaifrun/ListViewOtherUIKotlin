package org.pondar.listviewotheruikotlin

open class Person(var name:String, var age:Int)  {


    fun isOld(): Boolean {
        if (age>50)
            return true
        else
            return false
    }
    override fun toString(): String {
        if (isOld())
            //return name+", "+age+" is old"
            return "$name, $age is old"
        else
            return "$name, $age is young"
    }
}