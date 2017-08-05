# ImageFinder
This "library" can find images within an image. There are 3 functions that make this possible that either return a boolean, a position or an arraylist of positions.


The first function is called **findImage** which returns a boolean. It will return true if the image has been found within the other image. This can be used if you just want to check if the image can be found within the other image and dont care about the position of the image.

`findImage(BufferedImage image, BufferedImage imagetofind)`

The second function is called **findImagePos** which returns a position. If there are multiple images within the other image it will only return the position of the first found image.

`findImagePos(BufferedImage image, BufferedImage imagetofind)`

The third function is called **findAllImagePos** and it returns the positions of all found images. This is useful if there might be more images. The difference between this function and the other function is that the other function will return once it has found an image. This function will keep on going until the whole image has been *bruteforced*. 

`findAllImagePos(BufferedImage image, BufferedImage imagetofind)`

There are 2 functions that return a Position. A position is just a simple class that stores an x and a y value. It can be reached by using the `getX()` or `getY()` function.

An example of how to use the functions:
`List<Position> pos = findAllImagePos(ImageIO.read(new File("ScreenshotOfWebsite.png")),ImageIO.read(new File("Logo.png")));
int X = pos.getX();
int Y = pos.getY();
`

Please do keep in mind that im just an amateur who made this for a bot that im working on. Any tips or help regarding optimization or making the code more clean is welcome.
