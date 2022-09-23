package generics_project

import Cat
import CatRetailer
import Contest
import Dog
import DogRetailer
import Fish
import Pet
import Retailer

@Suppress("JoinDeclarationAndAssignment")
fun main(args: Array<String>) {
    /// normal
    var catContest = Contest<Cat>()

    catContest.addScore(Cat("Fuzz Lightyear"), 50)
    catContest.addScore(Cat("Katsu"), 45)
    /*    ini error karena type nya ga cocok*/
//    catContest.addScore(Dog("Katsu"), 45)

    val topCat = catContest.getWinners().first()
    println("top cat is ${topCat.name}")

    /// Contest<Pet>
    val petContest = Contest<Pet>()
    petContest.addScore(Cat("Oyen"), 50)
    petContest.addScore(Dog("Dogo"), 56)

    val topPet = petContest.getWinners().first()
    println("top pet is ${topPet.name} (a ${topPet.javaClass.toString().removePrefix("class ")})")

    var dogContest: Contest<Dog>
    dogContest = Contest()

    val fishContest = Contest(Fish("Fishhhh"))

    /// Retailers Code
    val catRetailer1 = CatRetailer()
    val catRetailer2 : CatRetailer = CatRetailer()

    /// Disini dia mulai menarik hehehehe
    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catRetailer: Retailer<Cat> = CatRetailer()

//    Even though CatRetailer is a type of Retailer, and Cat is a type of Pet, our
//    current code won’t let us assign a Retailer<Cat> object to a Retailer<Pet>
//    variable. A Retailer<Pet> variable will only accept a Retailer<Pet> object.
//
//    Not a Retailer<Cat>, nor a Retailer<Dog>, but only a Retailer<Pet>.
//
//    This behavior appears to violate the whole point of polymorphism. The great
//    news, however, is that we can adjust the generic type in the Retailer
//    interface to control which types of objects a Retailer<Pet> variable can
//    accept

    /* Use out to make a generic type covariant */
//    val petRetailer: Retailer<Pet> = CatRetailer()
}