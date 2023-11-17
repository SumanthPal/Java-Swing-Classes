### Understanding Components
- If you are familiar with Google's Flutter, it operates quite similarly (Create through Components)

Take a look at the structure for how we can use Java Swing

*This is the Inheritance Map*
![Inheritance Map](Ch1/Screen%20Shot%202023-11-08%20at%2010.59.14%20AM.png)

**Component**: a type of class which controls the main user interface control of Java Swing. Represents an object with graphical representation

JComponent: Think of it as the base class for Swing UI's. Every Swing component will inherit attributes from the Component. Extending the Component will enable for viewing it in windows.


> *So how can we use Java Swing to create a window?*

**JFrame** is a type of container that creates a window on the screen. We can add properties to the window too.

Example:

```java
import javax.swing.*; //we be importing java swing

public static void main(String[] args) {

	JFrame frame = new JFrame("Title");//we can add an example title here
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing behavior
	frame.setSize(800, 800); //setting the side
	frame.setVisible(true);//displaying window
	
	
}
```

**Output**
![Window](Ch1/Screen%20Shot%202023-11-08%20at%2011.12.12%20AM.png)
This example code makes and displays a window.

> But what if we want to add some stuff to our example?

Java Swing comes with a load of different things you can use. For more information, check out the subclasses in the Java Swing Docs: 
[Java Swing Official Docs](https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/JComponent.html)

For now, we'll look at the JButton Class.

Like what we did in the JFrame, we'll make an object of the JButton.

```java
JButton button = new JButton("Click on Me");
frame.add(button);
```

**Output**
![Button](Ch1/Screen%20Shot%202023-11-08%20at%2011.15.08%20AM.png)

In the frame, we can see the entire thing is a button. This makes sense right, because we didn't specify any dimensions for the button to follow. What if we want to change certain attributes of the button?

Java Swing has this object called `Dimensions` which we can use. We can also use the built in Color file from Java. (This just has a bunch of RGB Stuff).

Keep in mind, if we want to change the size, we have to let the frame know we're adding components that don't fit to size. We can do this by setting the Layout:
`frame.setLayout(new FlowLayout());`

So now, let's set a size and color.

```java
frame.setLayout(new FlowLayout());

JButton button = new JButton("Click on Me");
button.setPreferredSize(new Dimension(150, 50)); //changes the size

button.setForeground(Color.RED); //changes the font color
```

**Output**
![Button](Ch1/Screen%20Shot%202023-11-08%20at%2011.25.09%20AM.png)

More stuff modifying the button.

The think about java swing is that what you have one one computer might not be the same for the other. Because I'm using a mac, I can't properly access the button.setBackground() function.

A way around this is to  "wrap" it with a function that can allow us to set a background.

For now, we will use the `JPanel()`. We will also set the button to be opaque.

```java
JButton button = new JButton("Click Me");  
JPanel panel = new JPanel();  
button.setOpaque(true);  
panel.setBackground(Color.BLUE);  
panel.add(button);

```

**Output**
![Button](Ch1/Screen%20Shot%202023-11-08%20at%2011.33.04%20AM.png)
Ok uh I guess it didn't work to be expected. But that's fine, since we know we can modify the button.

There's a bunch of different ways we can customize a button (making the button an image) to animating it, we get a lot of functionality from it.


In the next lesson, I'll talk about how to handle events with buttons. This will give greater functionality to your stuff.

We can be able to do things like this
![Button](Ch1/Screen%20Shot%202023-11-08%20at%2011.37.52%20AM.png)
(The button is changing size btw) This is done through Action Events.