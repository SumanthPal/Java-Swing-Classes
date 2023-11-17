# Event Handling
So what is this so called event handling? If u really want to become a backend programming, this will come up **a lot**.


### Basic Definition

If you think of "events" as interactions people make with the computer, things become a lot simple. Think about how you use your keyboard to search stuff or your mouse to click buttons. All of these lead to events. 

Actually clicking the button is what we call events.

#### Diagram
![Diagram](Ch1/Pasted%20image%2020231116175157.png)


Take a look at the diagram. We see the event, actually observing the event, and handling it accordingly.
### So How Do We Make it Work?

In an event, usually the computer has a listener. This essentially serves as your checker, checking if an event happened. Think of it as checking if a button is clicked or not. It's a simple if statement right? What's crucial comes afterward.

Lets take a look at the implementation in Java.

```java

JButton myButton = new JButton("Click Me");


myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        System.out.println("Button Clicked!");
    }
});

```

> Lets break down the code a little bit.


1. Most JComponent classes have a Listener method allowing us to handle events. In this case, we are using an action listener, which checks for any that happened in the component. There are multiple types of listeners, too.


2. The actionPerformed takes an `ActionEvent e`, which essentially tells the button what do when it registers an event. (For more information on ActionEvent, check out the docs: [Action Events](https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionEvent.html).

3. It then outputs "Button Clicked" in our terminal.

Output:
![Button](Ch1/Screen%20Shot%202023-11-16%20at%206.10.53%20PM.png)

If you think about it, this makes debugging really easy. We can use events to know whats working and what isn't.

<br />
So what if we want to add some stuff to our GUI after handling an event? How do we do this?
<br />
As an example we'll make a button tracker that checks how many times you've clicked a button.


We've been manipulating objects, but this time I'll show you guys how to make these objects and assign attributes.

### Creating the Class

```java
public class ClickCounter extends JFrame() {
	
	private int clickCount = 0;
	
	private JLabel countLabel;
	private JPanel panel;
	private JButton clickButton;

```
Assign your class attributes.

We know we need a
- Label - for the displaying the click counts
- Button - to actually do the button clicks
- Counter - to know if a button is being clicked or not

<br />
Since I don't really care how tidy I want my object to be, I'm going to just put everything in my default constructor. You can tidy it up by making methods but it doesn't really matter.

```java
public ClickCounting() {  
  
    //basic window operations  
    setTitle("Click Counter");  
    setSize(300,200);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
    JPanel panel = new JPanel();  
    JButton clickButton = new JButton("Click");  
  
    countLabel = new JLabel("Click Count: 0");  

}
```
> Basically assigning basic values to our ClickCounting Window.

In the constructor, we are first assigning basic aspects to our main JPanel. We specify the title, size, and what it should do when being closed.

We also initialize the JComponents previously defined.

Now let's get into the more interesting part, actually making this work.

> So let's come up with a plan.
```
1. We want to add an action listener which registers when the button gets clicked
2. The clickCount variable should be incremented
3. Our text should update.
```

To sum it up...
```java
clickButton.addActionListener(new ActionListener() {  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        clickCount++;  
  
        countLabel.setText("Click Count: " + clickCount);  
    }  
});
```

And to tie everything together...

```java
panel.add(clickButton);  
panel.add(countLabel);  
  
add(panel);  
setVisible(true);
```

This is our output:
![[Screen Shot 2023-11-16 at 8.08.00 PM.png]]

Pretty interesting right?

<br/>

### Other Event Handling

There are three super important types of Event Handling that we can use. 

#### 1. MouseListeners
- Listens for mouse events (will output where mouse can be clicked if you would like)
#### 2. Key Listener
- Specifies a key press
#### 3. Item Listener
- Specific component event (checkboxes, special buttons, etc)



I would say right now, if you guys are interested, just play with the system. Its super interesting how it works and I've barely scratched the surface on what you can do. You can try to add some of your previous projects in this class to Java Swing to see how it works.

Next I'll talk about Graphics with Java Swing. This will also include ANIMATIONS too.

