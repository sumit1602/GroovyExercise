
 //Q6. Print multiple of 3 upto 10 terms in at least three different ways using groovy special methods
//Groovy extends the Integer class with the step(), upto() and times() methods. These methods take a closure as a parameter.
// In the closure we define the piece of code we want to be executed several times.

 //method 1
//
// int count=1;
// while(count<11) {
//     println count * 3
//     count++;
// }
//
//
////method 2
// for (int i = 1; i < 11; i++) {
//     a=i*3;
//     println a;
// }


//def a={
//    println  it * 3
//}
//
// 1.upto(10,a)


// 1.upto(10, {print it * 3 + " "})
// 3.step(31,3,{print it + " "})


 1.upto(10){print it*3  + " "}
 println "\n "

 11.times {print it*3  + " "}
 println "\n "

 3.step(31,3){print it +" "}
