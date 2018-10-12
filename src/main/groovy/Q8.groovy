//Q8. Combine content of all the files in a specific directory to another new file

//new File('/home/sumit/Desktop/fromCopy/file2').text = new File('/home/sumit/Desktop/toCopy/fileToCopy').text

//def src = new File('/home/sumit/Desktop/fromCopy').eachFile {line -> println "line: $line"}

def destination = new File('/home/sumit/Desktop/toCopy/file3')
new File('/home/sumit/Desktop/fromCopy').eachFileRecurse{file-> destination<<(file.getText())}


