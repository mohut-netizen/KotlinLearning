package Basics

import java.util.Locale
import java.util.Locale.getDefault

//top level variables exist in Kotlin
val FINAL_VALUE: String = "A constant"

//top level functions (not in any class
fun getFullName(firstName:String, lastName:String): String {
    return "$firstName $lastName" //String template; more efficient than doing concatenation
}

fun sayHello(): Unit{ //unit = void (unnecessary, can just omit type if nothing is returned
    println("Hello");
}

fun sayBetterHello(){ //void, no need to state return type
    println("Hello!");
}

fun getBETTERHello(): String = "Hello"; //Single expression function; quicker than { return "Hello"} boilerplate
fun getBETTERBetterHello() = "Hello!" //since fun is always returning a string, type is inferred!!!


fun main() {
    var mutableValue = "Hi" //inferred type (only inferred when its obvious what type)
    var number: Int //if variable is declared but not assigned, MUST state type

    var nullableString: String? = null //": Type?" means the value can be null. By default all Kotlin variables are NON-NULLABLE

    //cant call methods on null variables
    if (nullableString != null) {
        println(nullableString.uppercase())
    }
    println(nullableString?.uppercase()) // "?" operator checks if not null before running code



    var seasonNumber = 1
    var season = when(seasonNumber){ //when = Kotlin's switch statement
        1 -> "Spring"
        4 -> "Winter"
        else -> "Unknown" //else = Kotlin's default switch case
    }


    var name: String? = "Bob"
    var username = if(name != null) name else "Mumei" //if expression is good for assigning value, instead of if statement with repeated assignments


    println(getFullName("Bro", "Code"))
}

