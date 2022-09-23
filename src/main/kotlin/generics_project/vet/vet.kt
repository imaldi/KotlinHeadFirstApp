class Vet<in T: Pet>{
    fun treat(t: T){
        println("Treat Pet ${t.name}")
    }
}