---
marp: true
theme: gaia
---

## Walkthrough/ Explanation of the Ball Bounce Program

---

## Ball Bounce Class

```java
public class BallBounce extends JPanel
```

- Used to create the main window of the object
- The `JPanel` is an instance of the window. We extend it to get certain properties of the JPanel class
- In the constructor (used to initialize the object), we go through the animation
- `ActionEvent`: just a way to cehck if something is happening
- in `actionPerformed()`, we are just moving the balls velocity and if it reaches the windows dimensions.
- `repaint()` updates the animation

___

### paintComponent Class

- takes in a certain graphic (can be any built in graphic, not necessarily a circle)
- we can add certain properties to it, like the color and the size

___

## Explanation of the main method

- `SwingUtilities.invokelater` a way to actually compile everything. the invoke later just means that it will constantly refresh
- JFrame is the main window
- we can specify properties to the window (base size, if you can open and close it, etc)

- BallBounce is overlayed onto the frame object.