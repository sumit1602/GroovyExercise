
class AddCompanyDetails extends Person {

    int empId;
    String company;
    int salary

}
Person personDetails = new AddCompanyDetails();
personDetails.setName("Sumit chaudhary")
personDetails.setAge(23)
personDetails.setGender("Male")
personDetails.setAddress("mayur vihar phase-1")
personDetails.setEmpId(3051)
personDetails.setCompany("To The New")
personDetails.setSalary(17000)
println "Name: " + personDetails.name + ", Age: "+ personDetails.age + ", Gender: " + personDetails.gender + ", Address: "+ personDetails.address + ", Salary : " + personDetails.salary +
        ", Employee Id: " + personDetails.empId + ", Company : "+ personDetails.company


println  personDetails.getName()
println  personDetails.getGender()
println  personDetails.getAge()
println  personDetails.getCompany()
println  personDetails.getEmpId()
println  personDetails.getSalary()

//println  personDetails.@name
//println  personDetails.@gender
//println  personDetails.@age
println  personDetails.@company
println  personDetails.@empId
println personDetails.@salary