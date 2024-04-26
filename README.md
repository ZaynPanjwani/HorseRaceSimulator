# Horse Race Simulator

## What is Horse Race Simulator?

Horse race simulator is a program that simulates horse races and allows users to place bets on their horses.

## Running the Simulator

Pre requisites:
- This application requires Java 8 or newer.
- This application has been tested to run on MacOS. It should work on other systems but support is not guaranteed.

To run the program. You need to run the following command:

- For the textual version of the game, run:
`cd Part\ 1 && javac main.java && java main`
- For the GUI version of the game, run: `cd Part\ 2 && javac *.java && java Main`

## Customising the race

### Part 1

In order to run this code, you need to create objects of type horse and pass in their confidence levels to the constructor.
You must then create an object of type Race and pass over the length of the race in seconds as an argument to the constructor.
After that, you need to add each horse into the race object using the .addHorse function and pass over the Horse objects name and what lane to position each horse into. 

### Part 2

You can customize the horses, the fences as well as the track color in the GUI by using the buttons in the customization panel under the horse lanes.

