# Covariant in Kotlin Generics

    Even though CatRetailer is a type of Retailer, and Cat is a type of Pet, our
    current code won’t let us assign a Retailer<Cat> object to a Retailer<Pet>
    variable. A Retailer<Pet> variable will only accept a Retailer<Pet> object.
    
    Not a Retailer<Cat>, nor a Retailer<Dog>, but only a Retailer<Pet>.
    
    This behavior appears to violate the whole point of polymorphism. The great
    news, however, is that we can adjust the generic type in the Retailer
    interface to control which types of objects a Retailer<Pet> variable can
    accept
> Use `out` to make a generic type *covariant*

In general, a class or interface generic type may be prefixed with out if the class
has functions that use it as a return type, or if the class has val properties of that
type. You can’t, however, use out if the class has function parameters or var
properties of that generic type.

> Another way of thinking about this is that a generic type that’s prefixed with out can only be used in an
“out” position, such as a function return type. It can’t, however, be used in an “in” position, so a function
can’t receive a covariant type as a parameter value.


# Contravariant in Kotlin Generics

> Use `in` to make a generic type contravariant

If a generic type is contravariant, it means that you can use a supertype in
place of a subtype. This is the opposite of covariance.

In general, a class or interface generic type may be prefixed with in if the class
has functions that use it as a parameter type. You can’t, however, use in if any
of the class functions use it as a return type, or if that type is used by any
properties, irrespective of whether they’re defined using val or var.

> In other words, a generic type that’s prefixed with “in” can only be used in an “in” position, such as a
function parameter value. It can’t be used in “out” positions.

## A generic type can be locally contravarian

As you’ve seen, prefixing a generic type with in as part of the class or interface
declaration makes the generic type globally contravariant. You can, however,
restrict this behavior to specific properties or functions.
Suppose, for example, that we want to be able to use a Vet<Pet> reference in
place of a Vet<Cat>, but only where it’s being passed to a Contest<Cat> in its constructor. We can achieve this by removing the in prefix from the generic
type in the Vet class, and adding it to the vet property in the Contest
constructor instead.

`class Vet< -in- T: Pet>{
fun treat(t: T){
println("Treat Pet ${t.name}")
}
}`

`class Contest<T: Pet>(var vet: Vet<*in* T>) {`

> Q: Couldn’t I have just made Contest’s vet property a Vet\<Pet>? 

> A: No. This would mean that the vet property could only accept a
Vet\<Pet>. And while you could make the vet property locally covariant
using:
var vet: Vet\<out Pet>
it would mean that you could assign a Vet\<Fish> to a Contest\<Cat>, which
is unlikely to end well.

# Invariant in Kotlin Generics

> When a generic type has no in or out prefix, we say that the type is invariant.
An invariant type can only accept references of that specific type.