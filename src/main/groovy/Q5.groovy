
//Groovy Truth: if('test') { printlnn "test evaluated to true inside if" } try replacing test with various objects and observe its behaviour.
//
//"Test"
//'null'
//null
//100
//0
//empty list
//list with all vaues as null List list = new ArrayList()
//Write a class HourMinute where the class stores hours and minutes as separate fields. Overload + and - operator operator for this class


if('test')
{ println " 'test' evaluated to true inside if " }
if("test")
{ println " \"test\" evaluated to true inside if " }
if(null)
{ println " null evaluated to true inside if" }
if('null')
{ println " 'null' evaluated to true inside if" }
if(100)
{ println "100 evaluated to true inside if" }
if(0)
{ println "0 evaluated to true inside if" }
//if()
//{ println "0 evaluated to true inside if" }`
List family = []
if(family)
{ println "family evaluated to true inside if" }

List family1 = [null,null,null]
if(family1)
{ println "family1 evaluated to true inside if" }

List list = new ArrayList(3)
list.add{null}
list.add{null}
list.add{null}

if(list)
{ println "list evaluated to true inside if" }

class HourMinute {
    int hours
    int minute

    HourMinute(int hours, int minute) {
        this.hours = hours
        this.minute = minute
    }

    HourMinute plus(HourMinute time) {
        return new HourMinute(this.hours+time.hours,this.minute+time.minute)
    }
    HourMinute minus(HourMinute time) {
        return new HourMinute(this.hours-time.hours,this.minute-time.minute)
    }
}
def h1 = new HourMinute(3, 5)
def h2 = new HourMinute(6, 9)

assert (h1 + h2).hours == 9 && (h1 + h2).minute == 14
assert (h2 - h1).hours == 3 && (h2 - h1).minute == 4
println('HourMinutes')