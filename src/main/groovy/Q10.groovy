//Q10. Write a method which removes all the white spaces in a file and writes the output to another file.
// Suppose white space characters are Space, Tab and Enter

def s=new File("/home/sumit/Desktop/fromCopy/file1").eachLine{line ->line.replaceAll("\\s","")}
new File('/home/sumit/Desktop/toCopy/file6').append(s)

//(file.getText())
//String s = "hello ji jjjj ddd ------ "
//println s.replaceAll("\\W","")/home/sumit/Desktop/fromCopy/home/sumit/Desktop/fromCopy
//println s