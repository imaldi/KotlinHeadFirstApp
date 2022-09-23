/* Use out to make a generic type covariant */

interface Retailer<T> {
    fun sell(): T
}

class CatRetailer: Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer: Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Cat")
        return Dog("")
    }
}

class FishRetailer: Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Cat")
        return Fish("")
    }
}
