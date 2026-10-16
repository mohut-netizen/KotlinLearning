package Basics

/**
 * COLLECTIONS
 * - immutable by default
 * - for loop = for (i in a..b) inclusive
 * - varargs, named args, and default args give flexibility with parameter passing
 * - can use lambdas to interate through each index using forEach(action()) where action() can be replaced by {parameters -> do stuff}
 */
fun main() {
    val numbers = intArrayOf(1, 2, 3, 4) //cant do {...} bc type is uncertain, instead just do arrayOf(...) to create array

    //FOR LOOPS
    for (i in 0..<4){     //exclusive [akin to java for(i = 0; i < 4; i++) ]
        println("i is $i ")
    }
    for (i in 0..4){     //inclusive
        println("i is $i ")
    }

    //MAP LOOPING (multiple loop parameters)
    fun showPrices(prices: Map<String, Double>){
        //simply pass chosen names to your (key/value) pair into the for loop for ez processing!
        for ((fruit, price) in prices){
            println("$fruit cost $price")
        }
    }
    //COLLECTIONS
    val myList = listOf("one", "two", "three") //IMMUTABLE; read only. use mutableList if needed
    val prices = mapOf("apple" to 1.25, "orange" to 1.50, "banana" to 0.75) //IMMUTABLE; use mutableMap if needed

    showPrices(prices)


    //VARARG "numbers" passed in will auto be placed into new array called numbers. Enables any num of arguments to be passed in
    //note: If you want to pass an EXISTING collection (eg array) and not "1, 2, 3, 4"... you must use spread (*) operator like *arrayToPass
    fun getSum(vararg numbers: Int): Int {
        var sum = 0
        //numbers.forEach({number -> sum += number})

        for (num in numbers) {
            sum += num
        }
        return sum
    }
    println(getSum(1, 2, 3))
    println(getSum(*numbers)) //spread (*) operator to allow sending premade collection into vararg parameter


    //DEFAULT ARGS; in case user doesn't pass args in
    fun postSale(item: String = "TBD", price: Double = 0.00) {
        println("Selling $item for $$price!")
    }
    //NAMED ARGS; allows flexible ordering and better readability
    postSale(item = "Lambo", price = 666.00)
    postSale(price = 999.00, item = "Lambo") //flexible ordering bc named arg
    postSale(item = "TEXT FOR PRICE?") //default value used for price since not given



    //LAMBDAS & alternative .forEach(action())
    numbers.forEach({number -> println(number)})
    /*iterate over every number in numbers[], and performs action() by passing in a concise lambda function
    where forEach item {number -> do smth}
    NOTE: name "number ->" can be omitted, and default "it" can be used to represent each item in the array
    NOTE2: () are optional when you pass only one lambda inside the method*/

    //forEach but preserves indexing
    numbers.forEachIndexed { index, number ->   //same as above but passes in index to the lambda.
        println("$number is at index $index") }     //also bc {}, can split into several lines for readability

}


