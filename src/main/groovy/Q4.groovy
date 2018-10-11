
// Ques 4 GString... override the toString() of the Person class to return something like... "Sachin is a man aged 24 who lives at Delhi.
// He works for Intelligrape with employee id 12 and draws $$$$$$$ lots of money !!!!."
import groovy.transform.ToString
import org.graalvm.compiler.core.common.type.ArithmeticOpTable

@ToString
class Person2
{
    String name
    int age
    String address
    List<ArithmeticOpTable.BinaryOp.Add> fields
}

@ToString
class Add2 extends Person2
{
    int empId
    String company
    int salary
}
Person2 add2 = new Add2()
add2.setName("Sumit")
add2.setAge(22)
add2.setAddress("Mayur vihar phase-1, Delhi-91")
add2.setEmpId(3051)
add2.setCompany("To The New")
add2.setSalary(17000)

println "${add2.name} is a man aged ${add2.age} who lives at ${add2.address}. He works for ${add2.company} with employee id ${add2.empId} and draws ${add2.salary} lots of money !!!!."