//Q7. Write a closure which checks if a value is contained within a list where the closure accepts two parameters
List li =[1,2,3,4,5,6]

//li.each{println it}
li.eachWithIndex{a, i -> if(a==4) println a+" is present" }


