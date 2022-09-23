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