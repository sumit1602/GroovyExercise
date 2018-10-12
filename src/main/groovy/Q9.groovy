// Q9. Create a file which contains all the odd numbered lines of a given file.
// Each line should be numbered at the beginning of line viz : 1, 3, 5.....

def file=new File("/home/sumit/Desktop/toCopy/FILE7")
println "The file ${file.absolutePath} has ${file.length()} bytes"

def lineNo = 1

file.withReader { reader ->
    while ((line = reader.readLine())!=null) {
        println "${lineNo}. ${line}"
        lineNo=lineNo+2
    }
}