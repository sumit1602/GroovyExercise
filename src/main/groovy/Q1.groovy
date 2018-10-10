

println "Q1. Create a class in Java along with follwing fields. classname: Person fields: name, age, gender, address Access the fields in all known ways: like through getter , by dot operator"

class Person {
    String name;
    int age;
    String gender;
    String address;
}
Person person = new Person();
person.setName("Sumit")
println person.getName()

person.setAge(23)
println person.getAge()

person.setGender("Male")
println person.getGender()

person.setAddress("Mayur vihar phase-1, Delhi-110091")
println person.getAddress()

println "Name: " + person.name + ", Age: "+ person.age + ", Gender: " + person.gender + ", Address: "+ person.address