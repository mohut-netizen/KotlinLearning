enum class QuantityOfMeasurement{
    TEMPERATURE, LENGTH, MASS
}
enum class UnitOfMeasurement(val quantity: QuantityOfMeasurement){ //create primary constructor that accepts "quantity" arg & stores it inside the Unit
    //assign unit/quantity relationship
    FAHRENHEIT(QuantityOfMeasurement.TEMPERATURE), //new UnitOfMeasurement NEEDS a quantity arg passed in when constructing
    CELSIUS(QuantityOfMeasurement.TEMPERATURE),
    KELVIN(QuantityOfMeasurement.TEMPERATURE),
    FEET(QuantityOfMeasurement.LENGTH),
    INCH(QuantityOfMeasurement.LENGTH),

}

/**
 * what unit is being measured? (Can only be typed from values defined in enum UnitOfMeasurement)
 * how large is the unit? (12ft, 50.0kg)
 */
class Measurement(var unit: UnitOfMeasurement, var magnitude: Double){

    /**
     * Converts a given temperature to Fahrenheit
     * Unit given must be of type Temperature
     */
    fun getFahrenheit(): Double {
        //make sure the value of unit entered is TEMPERATURE before converting
        if (unit.quantity != QuantityOfMeasurement.TEMPERATURE) {
            println("Can't convert a non-temperature to F!")
            throw Exception("Can't convert a non-temperature to F!")
        }

        //return converted temperature
        return when(unit) {
            UnitOfMeasurement.FAHRENHEIT -> magnitude //no need to convert
            UnitOfMeasurement.CELSIUS  -> (magnitude* 1.8 + 32)
            UnitOfMeasurement.KELVIN ->  ((magnitude-273.15)* 1.8 + 32)
            else -> throw Exception("Unknown unit")
        }
    }

    fun getFeet(): Double{
        //return converted temperature
        return when(unit) {
            UnitOfMeasurement.INCH -> (magnitude/12)
            else -> throw Exception("Unknown unit")
        }
    }
}

fun main(){
    var myWeather = Measurement( UnitOfMeasurement.CELSIUS, 25.0) //Celsius
    var height = Measurement(UnitOfMeasurement.INCH, 69.0)
    
    println("Weather is ${myWeather.magnitude} ${myWeather.unit} ${myWeather.getFahrenheit()} F")
    println("Height is ${height.magnitude} ${height.unit} or ${height.getFeet()} ft")
}

