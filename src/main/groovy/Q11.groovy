//Q11. Make copy of an image type file byte by byte


def file = new File("/home/sumit/Desktop/toCopy/IMAGE.jpg").readBytes()

new File("/home/sumit/Desktop/toCopy/copyImage").append(file)
