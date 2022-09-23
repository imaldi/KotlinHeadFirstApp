# Covariant in kotlin generics

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